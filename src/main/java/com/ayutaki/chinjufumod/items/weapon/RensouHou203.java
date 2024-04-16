package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RensouHou203 extends Base_RensouHou {

	public RensouHou203(Item.Properties properties) {
		super(properties);
	}

	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@Override
	public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {

		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			ItemStack projectile = playerIn.getProjectile(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);

			if (i < 0) return;

			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_M); }

				float charge = getArrowVelocity(i);
				if (!((double)charge < 0.1D)) {
					boolean mode1 = playerIn.abilities.instabuild || (projectile.getItem() instanceof Ammo_Medium && ((Ammo_Medium)projectile.getItem()).isInfinite(projectile, stack, playerIn));

					if (!worldIn.isClientSide) {
						Ammo_Medium arrowitem = (Ammo_Medium)(projectile.getItem() instanceof Ammo_Medium ? projectile.getItem() : Items_Weapon.AMMUNITION_M);
						AbstractAmmo_Entity abstractarrowentity = arrowitem.createAmmo(worldIn, projectile, playerIn);
						abstractarrowentity = customAmmo(abstractarrowentity);

						/* Damage */
						abstractarrowentity.setCritArrow(true);
						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);

						boolean cruiser = ShipTypes_CM.typeCruiser(playerIn);
						double FIT = (cruiser)? 1.0D : 0.0D;
						double LEVEL = (playerIn.experienceLevel >= 25)? 1.5D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 1.0D : 
							((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 0.5D : 0.0D));

						abstractarrowentity.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 3.5F, 1.0F);
						if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 2.0D + FIT + LEVEL); }
						if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 2.0D + (double)j * 0.5D + FIT + LEVEL); }

						/* Enchant */
						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
						if (k == 0) { abstractarrowentity.setKnockback(1); }
						if (k > 0) { abstractarrowentity.setKnockback(k + 1); }

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) { abstractarrowentity.setSecondsOnFire(100); }

						/* Break animation. */
						stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );

						if (mode1 || playerIn.abilities.instabuild) {
							 abstractarrowentity.pickup = AbstractAmmo_Entity.PickupStatus.CREATIVE_ONLY; }
						
						worldIn.addFreshEntity(abstractarrowentity);
						playerIn.getCooldowns().addCooldown(this, 12);
					}
					
					/* Firing sound effect. Small 0.5F, 1.4F, Medium 1.0F, 1.2F Large 1.2F, 1.0F */
					worldIn.playSound((PlayerEntity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_FIRE, 
							SoundCategory.PLAYERS, 1.0F, 1.2F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
					
					Vector3d pos = playerIn.getEyePosition(1.0F).add(0.0D, -0.15D, 0.0D).subtract(playerIn.getLookAngle().multiply(-0.75D, -0.75D, -0.75D));
					worldIn.addParticle(ParticleTypes_CM.SHOOTM_PT, pos.x, pos.y, pos.z, 0.0D, 0.0D, 0.0D);
					
					if (!mode1 && !playerIn.abilities.instabuild) {
						projectile.shrink(1);
						if (projectile.isEmpty()) { playerIn.inventory.removeItem(projectile); }
						
						/* Drop the Cartridge. */
						if (!worldIn.isClientSide) {
							playerIn.drop(new ItemStack(Items_NoTab.CARTRIDGE_M), false);
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_CARTRIDGE, 
									SoundCategory.BLOCKS, 1.0F, 1.2F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F); }
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}

	/* Ammo to be used. */
	public static final Predicate<ItemStack> AMMOM = (projectile) -> {
		return projectile.getItem() == Items_Weapon.AMMUNITION_M;
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return AMMOM;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 17;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_rensouhou_medium").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_rensouhou203").withStyle(TextFormatting.DARK_GREEN));
	}
}
