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

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class KoukakuHou100 extends Base_RensouHou {

	public KoukakuHou100(Item.Properties properties) {
		super(properties);
	}
	
	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@SuppressWarnings("deprecation")
	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerIn = (Player)entityLiving;
			boolean mode = playerIn.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			ItemStack projectile = playerIn.getProjectile(stack);
			
			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);

			if (i < 0) return;

			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_S.get()); }
				
				float charge = getPowerForTime(i);
				if (!((double)charge < 0.1D)) {
					boolean mode1 = playerIn.getAbilities().instabuild || (projectile.getItem() instanceof Ammo_Small && ((Ammo_Small)projectile.getItem()).isInfinite(projectile, stack, playerIn));
					
					if (!worldIn.isClientSide) {
						Ammo_Small arrowitem = (Ammo_Small)(projectile.getItem() instanceof Ammo_Small ? projectile.getItem() : Items_Weapon.AMMUNITION_S.get());
						AbstractAmmo_Entity abstractarrowentity = arrowitem.createAmmo(worldIn, projectile, playerIn);
						abstractarrowentity = customAmmo(abstractarrowentity);

						/* Damage */
						abstractarrowentity.setCritArrow(true);
						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
						
						boolean destroyer = ShipTypes_CM.typeDestroyer(playerIn);
						double FIT = (destroyer)? 0.5D : 0.0D;
						double LEVEL = (playerIn.experienceLevel >= 25)? 1.5D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 1.0D : 
							((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 0.5D : 0.0D));
						
						abstractarrowentity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 3.0F, 1.0F);
						if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 0.5D + FIT + LEVEL); }
						if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 0.5D + (double)j * 0.5D + FIT + LEVEL); }
				
						/* Enchant */
						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
						if (k == 0) { abstractarrowentity.setKnockback(1); }
						if (k > 0) { abstractarrowentity.setKnockback(k + 1); }

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) { abstractarrowentity.setSecondsOnFire(100); }

						/* Break animation. */
						stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );

						if (mode1 || playerIn.getAbilities().instabuild) {
							 abstractarrowentity.pickup = AbstractAmmo_Entity.Pickup.CREATIVE_ONLY; }

						worldIn.addFreshEntity(abstractarrowentity);
						playerIn.getCooldowns().addCooldown(this, 10);
					} //!worldIn.isClientSide

					/* Firing sound effect. Small 0.5F, 1.4F, Medium 1.0F, 1.2F Large 1.2F, 1.0F */
					worldIn.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_FIRE.get(), 
							SoundSource.PLAYERS, 0.5F, 1.4F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
					
					Vec3 pos = playerIn.getEyePosition(1.0F).add(0.0D, -0.15D, 0.0D).subtract(playerIn.getLookAngle().multiply(-0.75D, -0.75D, -0.75D));
					worldIn.addParticle((ParticleOptions) ParticleTypes_CM.SHOOTM_PT.get(), pos.x, pos.y, pos.z, 0.0D, 0.0D, 0.0D);

					if (!mode1 && !playerIn.getAbilities().instabuild) {
						projectile.shrink(1);
						if (projectile.isEmpty()) { playerIn.getInventory().removeItem(projectile); }
						
						/* Drop the Cartridge. */
						if (!worldIn.isClientSide) {
							playerIn.drop(new ItemStack(Items_NoTab.CARTRIDGE_S.get()), false);
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_CARTRIDGE.get(), 
									SoundSource.BLOCKS, 0.5F, 1.4F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F); }
					}
					
					playerIn.awardStat(Stats.ITEM_USED.get(this));
				}//!((double)f < 0.1D)
			} //!projectile.isEmpty()	
		} //instanceof Player
	}

	
	/* Ammo to be used. */
	public static final Predicate<ItemStack> AMMOS = (projectile) -> {
		return projectile.getItem() == Items_Weapon.AMMUNITION_S.get();
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return AMMOS;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_rensouhou_small").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.item_koukakuhou100").withStyle(ChatFormatting.DARK_GREEN));
	}
}
