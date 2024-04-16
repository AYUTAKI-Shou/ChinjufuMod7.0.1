package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.Weak_Explosion;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class Shield_CM extends ShieldItem {

	public Shield_CM(Item.Properties builder) {
		super(builder);
		/** 336×3 =1008, ×5=1680, ×7=2352, ×9=3024 **/
	}
	
	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entity, int timeLeft) {
		if (entity instanceof Player) {
			Player playerIn = ((Player) entity);
			
			if (!worldIn.isClientSide) {
				if (!playerIn.getCooldowns().isOnCooldown(this)) {
					AABB AABB_CHECK = new AABB(playerIn.getX() - 0.8, playerIn.getY() - 0.5, playerIn.getZ() - 0.8, playerIn.getX() + 1.8, playerIn.getY() + 1.5, playerIn.getZ() + 1.8);
					List<LivingEntity> listEntity = worldIn.getEntitiesOfClass(LivingEntity.class, AABB_CHECK);
					
					if (listEntity.size() <= 1) { }
					
					if (listEntity.size() > 1) {
						if (!playerIn.isUnderWater()) {
							playerIn.getCooldowns().addCooldown(this, 10);
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.SWING.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
							
							double d0 = (double)(-Mth.sin(playerIn.getYRot() * ((float)Math.PI / 180F)));
							double d1 = (double)Mth.cos(playerIn.getYRot() * ((float)Math.PI / 180F));
							((ServerLevel)worldIn).sendParticles(ParticleTypes.SWEEP_ATTACK, playerIn.getX() + d0, playerIn.getY(0.5D), playerIn.getZ() + d1, 0, d0, 0.0D, d1, 0.0D);

							this.createExplosion(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), 1.0F, false, Explosion.BlockInteraction.KEEP);
							stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
						} // Player is not under the Water.
						
						if (playerIn.isUnderWater()) {
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.GENERIC_SWIM, SoundSource.PLAYERS, 0.6F, 0.8F);
							playerIn.getCooldowns().addCooldown(this, 10); } // Player is under the Water.
						
					} // listEntity.size() > 1

				} //!isOnCooldown

			} //!worldIn.isClientSide
		} //PlayerEntity
	}
	
	public Weak_Explosion createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.BlockInteraction mode) {
		return this.explode(entityIn, (DamageSource)null, (ExplosionDamageCalculator)null, xIn, yIn, zIn, value, flag, mode);
	}

	public Weak_Explosion explode(@Nullable Entity entityIn, @Nullable DamageSource damage, @Nullable ExplosionDamageCalculator context, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.BlockInteraction mode) {
		Weak_Explosion explosion = new Weak_Explosion(entityIn.level(), entityIn, damage, context, xIn, yIn, zIn, value, flag, mode);
		explosion.explode();
		explosion.finalizeExplosion(true);
		return explosion;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_shield").withStyle(ChatFormatting.GRAY));
	}
}
