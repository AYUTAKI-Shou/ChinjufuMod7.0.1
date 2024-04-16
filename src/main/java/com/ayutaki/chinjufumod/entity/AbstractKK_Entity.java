package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.entity.helper.Vector3;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class AbstractKK_Entity extends EntityThrowable {

	public static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.createKey(AbstractKK_Entity.class, DataSerializers.ITEM_STACK);
	protected static final DataParameter<Byte> ID_FLAGS = EntityDataManager.<Byte>createKey(AbstractKK_Entity.class, DataSerializers.BYTE);
	protected static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(AbstractKK_Entity.class, DataSerializers.VARINT);
	
	public AbstractKK_Entity(World worldIn) {
		super(worldIn);
		setSize(2.0F, 2.0F);
	}

	public AbstractKK_Entity(World worldIn, EntityLivingBase entity, ItemStack stack) {
		super(worldIn, entity);
	}

	public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
		float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
		float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
		float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
		this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
		this.motionX += entityThrower.motionX;
		this.motionZ += entityThrower.motionZ;

		if (!entityThrower.onGround) { this.motionY += entityThrower.motionY; }
		if (Config_CM.lowSound) { this.playSound(SoundEvents_CM.KK_PROPELLER12, 1.5F, 1.0F); }
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.dataManager.register(ID_FLAGS, Byte.valueOf((byte)0));
		this.dataManager.register(RETURN_TO, -1);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		
		/** PROPELLER Sound **/
		if (!Config_CM.lowSound) {
			if (this.ticksExisted % 3 == 0) { this.playSound(SoundEvents_CM.KK_PROPELLER, 1.5F, 1.0F); } }
		
		/** Server state control **/
		if (!world.isRemote) {
			Entity thrower = getThrower();

			/** 水による未帰還も多いため削除
			if (isInWater()) {
				this.playSound(SoundEvents_CM.WATER_SPLASH, 2.0F, 1.0F);
				dropAndKill();
			} **/
			
			if (isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					motionX = motion.x;
					motionY = motion.y;
					motionZ = motion.z;
					
					if (getDistanceSq(thrower) < 2) { dropAndKill(); } }
			}
			
			
			if (!isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null && ticksExisted >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	protected void dropAndKill() {
		ItemStack kansaiki = getItemStack();
		
		Entity thrower = getThrower();
		EntityPlayer playerIn = (EntityPlayer)thrower;
		if (thrower != null && !playerIn.capabilities.isCreativeMode) { kansaiki.attemptDamageItem(1, rand, null); } 

		EntityItem item = new EntityItem(world, posX, posY, posZ, kansaiki);
		world.spawnEntity(item);
		setDead();
	}

	protected abstract ItemStack getItemStack();
	
	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {

		if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
			this.onHitEntity(result); }
		
		else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
			Block block = world.getBlockState(result.getBlockPos()).getBlock();
			/** Go through the blocks. **/
			if (block instanceof Block) { return; }
		}
	}

	protected void onHitEntity(RayTraceResult result) { }
	
	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}

	/* 水による速度への影響 */
	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	public boolean isPushedByWater() {
		return false;
	}

	/* Renderで参照する state */
	public boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	protected int getEntityToReturnTo() {
		return dataManager.get(RETURN_TO);
	}

	protected void setEntityToReturnTo(int entityID) {
		dataManager.set(RETURN_TO, entityID);
	}
	
	/* Carrier */
	public void setCarrier(boolean flag) {
		byte b0 = ((Byte)this.dataManager.get(ID_FLAGS)).byteValue();

		if (flag) { this.dataManager.set(ID_FLAGS, Byte.valueOf((byte)(b0 | 1))); }
		else { this.dataManager.set(ID_FLAGS, Byte.valueOf((byte)(b0 & -2))); }
	}

	public boolean isCarrier() {
		byte b0 = ((Byte)this.dataManager.get(ID_FLAGS)).byteValue();
		return (b0 & 1) != 0;
	}
	
	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		this.dataManager.set(DATA_ITEM_STACK, stack);
	}
	
	protected ItemStack getItemRaw() {
		return this.dataManager.get(DATA_ITEM_STACK);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setTag("item", this.getItemRaw().writeToNBT(new NBTTagCompound()));
		compound.setBoolean("carrier", this.isCarrier());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setItem(new ItemStack(compound.getCompoundTag("item")));
		this.setCarrier(compound.getBoolean("carrier"));
	}
}
