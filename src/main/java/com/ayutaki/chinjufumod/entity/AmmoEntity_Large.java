package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AmmoEntity_Large extends AbstractAmmo_Entity {

	public AmmoEntity_Large(World worldIn) {
		super(worldIn);
	}

	public AmmoEntity_Large(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public AmmoEntity_Large(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(Items.AIR);
	}

	public void onUpdate() {
		super.onUpdate(); }

	@Override
	public void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn); }
	
	@Override
	public void hitProcess() {
		if (!this.world.isRemote) {
			Explosion_CM explosion = new Explosion_CM(this.world, this, this.posX, this.posY, this.posZ, 2.5F, false, Config_CM.blastBlockBreak);
			explosion.doExplosionA();
			explosion.doExplosionB(true); }
		
		this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
		this.world.setEntityState(this, (byte)3);
	}
}
