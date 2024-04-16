package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AmmoEntity_Kijyuu extends AbstractAmmo_Kijyuu {

	@SuppressWarnings("unused")
	private SoundEvent hitSound = this.getHitEntitySound();

	public AmmoEntity_Kijyuu(EntityType<? extends AmmoEntity_Kijyuu> type, World worldIn) {
		super(type, worldIn);
	}

	public AmmoEntity_Kijyuu(World worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_K, x, y, z, worldIn);
	}

	public AmmoEntity_Kijyuu(World worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_K, shooter, worldIn);
	}

	/* PotionEffect null */
	public void setPotionEffect(ItemStack stack) { }

	public static int getCustomColor(ItemStack stack) { return -1; }

	/* Pickup AIR */
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(Items.AIR);
	}

	/* ↓↓Hit result↓↓ */
	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void arrowHit(LivingEntity living) {
		super.arrowHit(living);
	}

	@Override
	protected void onHit(RayTraceResult raytraceResult) {
		super.onHit(raytraceResult);
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult entityRay) {
		super.onEntityHit(entityRay);
	}

	/* Flying render */
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
