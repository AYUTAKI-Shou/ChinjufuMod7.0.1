package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.Weak_Explosion;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Shield_CM extends ShieldItem {

	public Shield_CM(Item.Properties properties) {
		super(properties.group(ItemGroups_CM.CMARMOR));
		/** 336×3 =1008, ×5=1680, ×7=2352, ×9=3024 **/
	}

	/* Called when the player stops using an Item (stops holding the right mouse button). */
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entity, int timeLeft) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity playerIn = ((PlayerEntity) entity);
			
			if (!worldIn.isRemote) {
				if (!playerIn.getCooldownTracker().hasCooldown(this)) {
					AxisAlignedBB AABB_CHECK = new AxisAlignedBB(playerIn.getPosX() - 0.8, playerIn.getPosY() - 0.5, playerIn.getPosZ() - 0.8, playerIn.getPosX() + 1.8, playerIn.getPosY() + 1.5, playerIn.getPosZ() + 1.8);
					List<LivingEntity> listEntity = worldIn.getEntitiesWithinAABB(LivingEntity.class, AABB_CHECK);
					
					if (listEntity.size() <= 1) { }
					
					if (listEntity.size() > 1) {
						if (!playerIn.areEyesInFluid(FluidTags.WATER, true)) {
							playerIn.getCooldownTracker().setCooldown(this, 10);
							worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.SWING, SoundCategory.PLAYERS, 1.0F, 1.0F);
							
							double d0 = (double)(-MathHelper.sin(playerIn.rotationYaw * ((float)Math.PI / 180F)));
							double d1 = (double)MathHelper.cos(playerIn.rotationYaw * ((float)Math.PI / 180F));
							((ServerWorld)worldIn).spawnParticle(ParticleTypes.SWEEP_ATTACK, playerIn.getPosX() + d0, playerIn.getPosYHeight(0.5D), playerIn.getPosZ() + d1, 0, d0, 0.0D, d1, 0.0D);

							this.createExplosion(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 1.0F, false, Explosion.Mode.NONE);
							stack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
						} // Player is not under the Water.
						
						if (playerIn.areEyesInFluid(FluidTags.WATER, true)) {
							worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_GENERIC_SWIM, SoundCategory.PLAYERS, 0.6F, 0.8F);
							playerIn.getCooldownTracker().setCooldown(this, 10); } // Player is under the Water.

					 } // listEntity.size() > 1

				} //!isOnCooldown
			} //!worldIn.isClientSide
		} //PlayerEntity
	}
	
	public Weak_Explosion createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		return this.explode(entityIn, (DamageSource)null, xIn, yIn, zIn, value, flag, modeIn);
	}

	public Weak_Explosion explode(@Nullable Entity entityIn, @Nullable DamageSource damage, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		Weak_Explosion explosion = new Weak_Explosion(entityIn.world, entityIn, xIn, yIn, zIn, value, flag, modeIn);
		explosion.doExplosionA();
		return explosion;
	}
	
	/* 盾として消耗処理 */
	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		return stack.getItem() instanceof ShieldItem;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_shield").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_shield2").applyTextStyle(TextFormatting.GRAY));
	}
}
