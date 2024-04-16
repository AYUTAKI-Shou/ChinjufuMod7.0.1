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
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Shield_CM extends ShieldItem {

	public Shield_CM(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.CMARMOR));
		/** 336×3 =1008, ×5=1680, ×7=2352, ×9=3024 **/
	}

	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@Override
	public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entity, int timeLeft) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity playerIn = ((PlayerEntity) entity);
			
			if (!worldIn.isClientSide) {
				if (!playerIn.getCooldowns().isOnCooldown(this)) {
					AxisAlignedBB AABB_CHECK = new AxisAlignedBB(playerIn.getX() - 0.8, playerIn.getY() - 0.5, playerIn.getZ() - 0.8, playerIn.getX() + 1.8, playerIn.getY() + 1.5, playerIn.getZ() + 1.8);
					List<LivingEntity> listEntity = worldIn.getEntitiesOfClass(LivingEntity.class, AABB_CHECK);
					
					if (listEntity.size() <= 1) { }
					
					if (listEntity.size() > 1) {
						if (!playerIn.isUnderWater()) {
							playerIn.getCooldowns().addCooldown(this, 10);
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.SWING, SoundCategory.PLAYERS, 1.0F, 1.0F);
							
							double d0 = (double)(-MathHelper.sin(playerIn.yRot * ((float)Math.PI / 180F)));
							double d1 = (double)MathHelper.cos(playerIn.yRot * ((float)Math.PI / 180F));
							((ServerWorld)worldIn).sendParticles(ParticleTypes.SWEEP_ATTACK, playerIn.getX() + d0, playerIn.getY(0.5D), playerIn.getZ() + d1, 0, d0, 0.0D, d1, 0.0D);

							this.createExplosion(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), 1.0F, false, Explosion.Mode.NONE);
							stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
						} // Player is not under the Water.
						
						if (playerIn.isUnderWater()) {
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.GENERIC_SWIM, SoundCategory.PLAYERS, 0.6F, 0.8F);
							playerIn.getCooldowns().addCooldown(this, 10); } // Player is under the Water.
						
					} // listEntity.size() > 1

				} //!isOnCooldown

			} //!worldIn.isClientSide
		} //PlayerEntity
	}

	public Weak_Explosion createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode mode) {
		return this.explode(entityIn, (DamageSource)null, (ExplosionContext)null, xIn, yIn, zIn, value, flag, mode);
	}

	public Weak_Explosion explode(@Nullable Entity entityIn, @Nullable DamageSource damage, @Nullable ExplosionContext context, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode mode) {
		Weak_Explosion explosion = new Weak_Explosion(entityIn.level, entityIn, damage, context, xIn, yIn, zIn, value, flag, mode);
		explosion.explode();
		return explosion;
	}
	
	/* 盾として消耗処理 */
	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		return stack.getItem() instanceof ShieldItem;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_shield").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_shield2").withStyle(TextFormatting.GRAY));
	}
}
