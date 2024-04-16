package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ToamiEntity extends EntityThrowable {

	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(ToamiEntity.class, DataSerializers.VARINT);
	private ItemStack projectile = ItemStack.EMPTY;

	public ToamiEntity(World worldIn) {
		super(worldIn);
		setSize(3.0F, 3.0F);
	}

	public ToamiEntity(World worldIn, EntityLivingBase entity, ItemStack stack) {
		super(worldIn, entity);
		this.projectile = stack.copy();
	}

	public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
		float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
		float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
		float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
		this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
		this.motionX += entityThrower.motionX;
		this.motionZ += entityThrower.motionZ;

		if (!entityThrower.onGround) { this.motionY += entityThrower.motionY; }
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(RETURN_TO, -1);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		/** Server state control **/
		if (!world.isRemote) {
			Entity thrower = getThrower();
			
			if (isReturning()) {
				if (thrower == null && ticksExisted > 60) { dropAndKill(); }
				
				if (thrower != null) { returnAndKill(); }
			}
			
			
			if (!isReturning()) {
				
				if (thrower == null && ticksExisted > 60) { dropAndKill(); }
				
				if (thrower != null && ticksExisted >= 15) { setEntityToReturnTo(getEntityToReturnTo() + 1); } }
		}
	}

	private void returnAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getThrower();
		EntityPlayer playerIn = (EntityPlayer)thrower;
		if (thrower != null && !playerIn.capabilities.isCreativeMode) { stack.attemptDamageItem(1, rand, null); } 
		
		EntityItem item = new EntityItem(world, thrower.posX, thrower.posY, thrower.posZ, stack);
		world.spawnEntity(item);
		setDead();
	}
	
	private void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getThrower();
		EntityPlayer playerIn = (EntityPlayer)thrower;
		if (thrower != null && !playerIn.capabilities.isCreativeMode) { stack.attemptDamageItem(1, rand, null); } 
		
		EntityItem item = new EntityItem(world, posX, posY, posZ, stack);
		world.spawnEntity(item);
		setDead();
	}
	
	private ItemStack getItemStack() {
		return this.projectile.copy();
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {

		switch (result.typeOfHit) {
		case BLOCK: {
			BlockPos pos = result.getBlockPos();
			IBlockState state = world.getBlockState(pos);

			if (state.getMaterial().isReplaceable()) { return; }
			
			if (!state.getMaterial().isReplaceable()) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			break;
		}

		case ENTITY: {
			Entity thrower = getThrower();
			
			if (!world.isRemote && result.entityHit != null && result.entityHit instanceof EntityLivingBase && result.entityHit != getThrower()) {

				if (result.entityHit instanceof EntitySquid) {
					result.entityHit.playSound(SoundEvents.ITEM_BUCKET_FILL, 2.0F, 1.0F);
					result.entityHit.setDead();
					thrower.entityDropItem(new ItemStack(Items_Teatime.IKA, 1, 0), 1.0F);
					
					if (world.getBiome(this.getPosition()) == Biomes.RIVER || world.getBiome(this.getPosition()) == Biomes.FROZEN_OCEAN) {
						if (world.rand.nextInt(2) == 0) { thrower.entityDropItem(new ItemStack(Items.FISH, 1, 1), 1.0F); } }

					if (world.getBiome(this.getPosition()) == Biomes.OCEAN || world.getBiome(this.getPosition()) == Biomes.DEEP_OCEAN) {
						if (world.rand.nextInt(2) == 0) { thrower.entityDropItem(new ItemStack(Items.FISH, 1, 0), 1.0F); } }
					
					if (world.getBiome(this.getPosition()) != Biomes.RIVER && world.getBiome(this.getPosition()) != Biomes.FROZEN_OCEAN &&
							world.getBiome(this.getPosition()) != Biomes.OCEAN && world.getBiome(this.getPosition()) != Biomes.DEEP_OCEAN) { }
				}

				else {
					result.entityHit.playSound(SoundEvents.ENTITY_GENERIC_HURT, 2.0F, 1.0F);
					((EntityLiving) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
					setEntityToReturnTo(getEntityToReturnTo() + 1); 
				}
			}
			break;
		}

		default: break;
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0F;
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

	private int getEntityToReturnTo() {
		return dataManager.get(RETURN_TO);
	}

	private void setEntityToReturnTo(int entityID) {
		dataManager.set(RETURN_TO, entityID);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setTag("fly_stack", projectile.writeToNBT(new NBTTagCompound()));
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		projectile = new ItemStack(compound.getCompoundTag("fly_stack"));
	}
}
