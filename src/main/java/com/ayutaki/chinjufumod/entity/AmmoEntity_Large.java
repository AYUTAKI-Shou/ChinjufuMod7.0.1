package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AmmoEntity_Large extends AbstractAmmo_Entity {

	@SuppressWarnings("unused")
	private SoundEvent hitSound = this.getHitEntitySound();

	public AmmoEntity_Large(EntityType<? extends AmmoEntity_Large> type, World worldIn) {
		super(type, worldIn);
	}

	public AmmoEntity_Large(World worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_L, x, y, z, worldIn);
	}

	public AmmoEntity_Large(World worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_L, shooter, worldIn);
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

	/** Small=1.0-1.2, 0.5F, Medium=1.5-1.0, 1.25F, Large=2.0-0.8, 2.5F **/
	@Override
	public void hitProcess() {
		if (!this.world.isRemote) {
			boolean blast = Config_CM.getInstance().blastBlockBreak();
			this.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2.5F, false, (blast == true)? Explosion.Mode.BREAK : Explosion.Mode.NONE); }
		
		this.playSound(this.getHitEntitySound(), 2.0F, 0.8F / (this.rand.nextFloat() * 0.2F + 0.9F));
		this.world.setEntityState(this, (byte)3);
	}
}
