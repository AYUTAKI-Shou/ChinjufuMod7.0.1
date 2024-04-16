package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class AmmoEntity_Small extends AbstractAmmo_Entity {

	public AmmoEntity_Small(EntityType<? extends AbstractAmmo_Entity> type, Level worldIn) {
		super(type, worldIn);
	}
	
	public AmmoEntity_Small(Level worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_S.get(), x, y, z, worldIn);
	}

	public AmmoEntity_Small(Level worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_S.get(), shooter, worldIn);
	}

	/* PotionEffect null */
	public void setEffectsFromItem(ItemStack stack) { }

	public static int getCustomColor(ItemStack stack) { return -1; }
	
	@SuppressWarnings("unused")
	private void updateColor() { }

	public void addEffect(MobEffectInstance instance) { }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
	}
	
	/* Pickup AIR */
	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(Items.AIR);
	}

	@Override
	public void handleEntityEvent(byte value) {
		super.handleEntityEvent(value);
	}

	/* Flying render 1.18->1.20 */
	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this);
	} // fix 20.2
	
	/** Small=1.0-1.2, 0.5F, Medium=1.5-1.0, 1.25F, Large=2.0-0.8, 2.5F **/
	@SuppressWarnings("resource")
	@Override
	public void hitProcess() {
		if (!this.level().isClientSide) {
			this.createExplosion(this, this.getX(), this.getY(), this.getZ(), 0.5F, false, Explosion.BlockInteraction.KEEP); }

		this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
		this.level().broadcastEntityEvent(this, (byte)3);
	}
}
