package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AmmoEntity_Small extends AbstractAmmo_Entity implements IProjectile {

	public AmmoEntity_Small(World worldIn) {
		super(worldIn);
	}

	public AmmoEntity_Small(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public AmmoEntity_Small(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	/* 不可欠なメソッドだが, AIRを呼び出して無効化 */
	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(Items.AIR);
	}

	public void onUpdate() {
		super.onUpdate(); }

	@Override
	public void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn); }
	
	/* Fire ball, Snow ball */
	/** Small=1.0-1.2, 0.5F, Medium=1.5-1.0, 1.25F, Large=2.0-0.8, 2.5F **/
	@Override
	public void hitProcess() {
		if (!this.world.isRemote) {
			Explosion_CM explosion = new Explosion_CM(this.world, this, this.posX, this.posY, this.posZ, 0.5F, false, false);
			explosion.doExplosionA();
			explosion.doExplosionB(true); }
		
		this.playSound(SoundEvents_CM.AM_IMPACT, 1.0F, 1.2F);
		this.world.setEntityState(this, (byte)3);
	}
}
