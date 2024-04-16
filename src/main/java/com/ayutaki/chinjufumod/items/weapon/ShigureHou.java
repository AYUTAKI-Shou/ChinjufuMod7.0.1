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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShigureHou extends Base_RensouHou {

	public ShigureHou(Item.Properties properties) {
		super(properties);
	}

	/* Called when the player stops using an Item (stops holding the right mouse button). */
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {

		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack projectile = playerIn.findAmmo(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);

			if (i < 0) return;

			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_S); }

				float charge = getArrowVelocity(i);
				if (!((double)charge < 0.1D)) {
					boolean mode1 = playerIn.abilities.isCreativeMode || (projectile.getItem() instanceof Ammo_Small && ((Ammo_Small)projectile.getItem()).isInfinite(projectile, stack, playerIn));

					if (!worldIn.isRemote) {
						Ammo_Small arrowitem = (Ammo_Small)(projectile.getItem() instanceof Ammo_Small ? projectile.getItem() : Items_Weapon.AMMUNITION_S);
						AbstractAmmo_Entity abstractarrowentity = arrowitem.createAmmo(worldIn, projectile, playerIn);
						abstractarrowentity = customAmmo(abstractarrowentity);

						/* Damage */
						abstractarrowentity.setIsCritical(true);
						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
						
						boolean destroyer = ShipTypes_CM.typeDestroyer(playerIn);
						double FIT = (destroyer)? 0.5D : 0.0D;
						double LEVEL = (playerIn.experienceLevel >= 25)? 1.5D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 1.0D : 
							((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 0.5D : 0.0D));
						
						abstractarrowentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.0F, 1.0F);
						if (j == 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + FIT + LEVEL); }
						if (j > 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + FIT + LEVEL); }

						/* Enchant */
						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						if (k == 0) { abstractarrowentity.setKnockbackStrength(1); }
						if (k > 0) { abstractarrowentity.setKnockbackStrength(k + 1); }

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) { abstractarrowentity.setFire(100); }

						/* Break animation. */
						stack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );

						if (mode1 || playerIn.abilities.isCreativeMode) {
							abstractarrowentity.pickupStatus = AbstractAmmo_Entity.PickupStatus.CREATIVE_ONLY; }
						
						worldIn.addEntity(abstractarrowentity);
						playerIn.getCooldownTracker().setCooldown(this, 10);
					}

					/* Firing sound effect. Small 0.5F, 1.4F, Medium 1.0F, 1.2F Large 1.2F, 1.0F */
					worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.AM_FIRE, 
							SoundCategory.PLAYERS, 0.5F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
					
					Vec3d pos = playerIn.getEyePosition(1.0F).add(0.0D, -0.15D, 0.0D).subtract(playerIn.getLookVec().mul(-0.75D, -0.75D, -0.75D));
					worldIn.addParticle(ParticleTypes_CM.SHOOTM_PT, pos.x, pos.y, pos.z, 0.0D, 0.0D, 0.0D);
					
					if (!mode1 && !playerIn.abilities.isCreativeMode) {
						projectile.shrink(1);
						if (projectile.isEmpty()) { playerIn.inventory.deleteStack(projectile); }
						
						/* Drop the Cartridge. */
						if (!worldIn.isRemote) {
							playerIn.dropItem(new ItemStack(Items_NoTab.CARTRIDGE_S), false);
							worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.AM_CARTRIDGE, 
									SoundCategory.BLOCKS, 0.5F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F); }
					}

					playerIn.addStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}


	/* Ammo to be used. */
	public static final Predicate<ItemStack> AMMOS = (projectile) -> {
		return projectile.getItem() == Items_Weapon.AMMUNITION_S;
	};

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return AMMOS;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_rensouhou_small").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_shigurehou").applyTextStyle(TextFormatting.DARK_GREEN));
	}
}
