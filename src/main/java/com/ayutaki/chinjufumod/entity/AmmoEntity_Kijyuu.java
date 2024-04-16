package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class AmmoEntity_Kijyuu extends AbstractAmmo_Kijyuu {

	public AmmoEntity_Kijyuu(EntityType<? extends AbstractAmmo_Kijyuu> type, Level worldIn) {
		super(type, worldIn);
	}
	
	public AmmoEntity_Kijyuu(Level worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_K.get(), x, y, z, worldIn);
	}

	public AmmoEntity_Kijyuu(Level worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_K.get(), shooter, worldIn);
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

	/* Flying render */
	@Nonnull
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
