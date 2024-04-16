package com.ayutaki.chinjufumod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AmmoEntity_Kijyuu extends AbstractAmmo_Kijyuu implements IProjectile {

	public AmmoEntity_Kijyuu(World worldIn) {
		super(worldIn);
	}

	public AmmoEntity_Kijyuu(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public AmmoEntity_Kijyuu(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(Items.AIR);
	}

	public void onUpdate() {
		super.onUpdate();
	}

	@Override
	public void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn);
	}
}
