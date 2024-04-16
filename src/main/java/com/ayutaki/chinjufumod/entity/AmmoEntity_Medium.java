package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AmmoEntity_Medium extends AbstractAmmo_Entity {

	public AmmoEntity_Medium(World worldIn) {
		super(worldIn);
	}

	public AmmoEntity_Medium(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public AmmoEntity_Medium(World worldIn, EntityLivingBase shooter) {
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
			Explosion_CM explosion = new Explosion_CM(this.world, this, this.posX, this.posY, this.posZ, 1.25F, false, Config_CM.blastBlockBreak);
			explosion.doExplosionA();
			explosion.doExplosionB(true); }
		
		this.playSound(SoundEvents_CM.AM_IMPACT, 1.5F, 1.0F);
		this.world.setEntityState(this, (byte)3);
	}
}
