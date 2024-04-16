package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.entity.helper.Vector3;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.EndGatewayTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public abstract class AbstractKK_Entity extends ThrowableEntity implements IRendersAsItem {
	
	protected static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.defineId(AbstractKK_Entity.class, DataSerializers.ITEM_STACK);
	protected static final DataParameter<Byte> ID_FLAGS = EntityDataManager.defineId(AbstractKK_Entity.class, DataSerializers.BYTE);
	protected static final DataParameter<Integer> RETURN_TO = EntityDataManager.defineId(AbstractKK_Entity.class, DataSerializers.INT);
	
	protected AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, World worldIn) {
		super(type, worldIn);
	}

	protected AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, double posX, double posY, double posZ, World worldIn) {
		this(type, worldIn);
		this.setPos(posX, posY, posZ);
	}

	protected AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, LivingEntity shooter, World worldIn) {
		this(type, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
		this.setOwner(shooter);
		if (Config_CM.getInstance().lowSound()) { this.playSound(SoundEvents_CM.KK_PROPELLER_12, 1.5F, 1.0F); }
	}
	
	@Override
	protected void defineSynchedData() {
		this.getEntityData().define(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.entityData.define(ID_FLAGS, (byte)0);
		this.entityData.define(RETURN_TO, Integer.valueOf(-1));
	}
	
	/* Flying render */
	@Nonnull
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double dist) {
		double d0 = this.getBoundingBox().getSize() * 4.0D;
		
		if (Double.isNaN(d0)) { 
			d0 = 4.0D; }

		d0 = d0 * 64.0D;
		return dist < d0 * d0;
	}

	public void tick() {
		super.tick();
		
		/** PROPELLER Sound **/
		if (!Config_CM.getInstance().lowSound()) {
			if (this.tickCount % 3 == 0 ) { this.playSound(SoundEvents_CM.KK_PROPELLER, 1.5F, 1.0F); } }

		
		if (!level.isClientSide) {
			Entity thrower = getOwner();
			
			if (isReturning()) {
				if (thrower == null && tickCount > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					setDeltaMovement(motion.toVector3d());
					
					if (distanceToSqr(thrower) < 2) { dropAndKill(); } }
			}
			
			if (!isReturning()) {
				if (thrower == null && tickCount > 200) { dropAndKill(); }
				
				if (thrower != null && tickCount >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
		
		/** 水による未帰還も多いため削除
		if (isInWater()) {
			spawnAtLocation(getItemStack(), 0.5f);
			playSound(SoundEvents_CM.WATER_SPLASH, 2.0F, 1.0F);
			remove();
		} **/
		
		RayTraceResult raytraceresult = ProjectileHelper.getHitResult(this, this::canHitEntity);
		boolean flag = false;
		if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
			BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getBlockPos();
			BlockState blockstate = this.level.getBlockState(blockpos);
			
			if (blockstate.is(Blocks.NETHER_PORTAL)) {
				this.handleInsidePortal(blockpos);
				flag = true; } 
			
			else if (blockstate.is(Blocks.END_GATEWAY)) {
				TileEntity tileentity = this.level.getBlockEntity(blockpos);
				
				if (tileentity instanceof EndGatewayTileEntity && EndGatewayTileEntity.canEntityTeleport(this)) {
					((EndGatewayTileEntity)tileentity).teleportEntity(this); }
				flag = true; }
		}

		if (raytraceresult.getType() != RayTraceResult.Type.MISS && !flag && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
			this.onHit(raytraceresult);
		}

		this.checkInsideBlocks();
		Vector3d vector3d = this.getDeltaMovement();
		double d2 = this.getX() + vector3d.x;
		double d0 = this.getY() + vector3d.y;
		double d1 = this.getZ() + vector3d.z;
		this.updateRotation();
		float f;
		if (this.isInWater()) {
			for(int i = 0; i < 4; ++i) {
				this.level.addParticle(ParticleTypes.BUBBLE, d2 - vector3d.x * 0.25D, d0 - vector3d.y * 0.25D, d1 - vector3d.z * 0.25D, vector3d.x, vector3d.y, vector3d.z); }
			f = 0.8F;
		} 
		
		else { f = 0.99F; }

		this.setDeltaMovement(vector3d.scale((double)f));
		if (!this.isNoGravity()) {
			Vector3d vector3d1 = this.getDeltaMovement();
			this.setDeltaMovement(vector3d1.x, vector3d1.y - (double)this.getGravity(), vector3d1.z); }

		this.setPos(d2, d0, d1);
	}

	protected float getGravity() {
		return 0.0F;
	}
	
	/* Drop item and Kill entity. */
	protected void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getOwner();
		PlayerEntity playerIn = (PlayerEntity)thrower;
		if (thrower != null && !playerIn.abilities.instabuild) { stack.hurt(1, random, null); }
		
		ItemEntity item = new ItemEntity(level, getX(), getY(), getZ(), stack);
		level.addFreshEntity(item);
		remove();
	}

	protected abstract ItemStack getItemStack();
	
	/* Collision processing. */
	@Override
	protected void onHit(RayTraceResult result) {
		RayTraceResult.Type raytraceresult$type = result.getType();
		if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
			onHitEntity((EntityRayTraceResult)result); }

		else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
			onHitBlock((BlockRayTraceResult)result); }
	}

	/** Collision to Entity. **/
	@Override
	protected void onHitEntity(EntityRayTraceResult result) { }
	
	/** Collision to Block. **/
	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		BlockState state = level.getBlockState(result.getBlockPos());
		state.onProjectileHit(level, state, result, this);
		this.setCarrier(false);
		/** Go through the blocks. **/
		Block block = state.getBlock();
		if (block instanceof Block) { return; }
	}
	
	/* Effect of water on Entity Speed. */
	@Override
	public boolean isInWater() {
		return false;
	}
	
	/* RETURN_TO */
	public boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	protected int getEntityToReturnTo() {
		return entityData.get(RETURN_TO).intValue();
	}

	protected void setEntityToReturnTo(int entityID) {
		entityData.set(RETURN_TO, Integer.valueOf(entityID));
	}
	
	/* Carrier */
	public void setCarrier(boolean flag) {
		this.setFlag(1, flag);
	}
	
	protected void setFlag(int value, boolean flag) {
		byte b0 = this.entityData.get(ID_FLAGS);
		
		if (flag) { this.entityData.set(ID_FLAGS, (byte)(b0 | value)); } 
		else { this.entityData.set(ID_FLAGS, (byte)(b0 & ~value)); }
	}
	
	public boolean isCarrier() {
		byte b0 = this.entityData.get(ID_FLAGS);
		return (b0 & 1) != 0;
	}
	
	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		if (stack.getItem() != this.getDefaultItem() || stack.hasTag()) {
			this.getEntityData().set(DATA_ITEM_STACK, Util.make(stack.copy(), (consumer) -> {
				consumer.setCount(1);
			}));
		}
	}

	protected abstract Item getDefaultItem();

	protected ItemStack getItemRaw() {
		return this.getEntityData().get(DATA_ITEM_STACK);
	}

	/* Mandatory for "implements ItemSupplier" */
	@Override
	public ItemStack getItem() {
		ItemStack stack = this.getItemRaw();
		return stack.isEmpty() ? new ItemStack(this.getDefaultItem()) : stack;
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		ItemStack stack = this.getItemRaw();
		if (!stack.isEmpty()) {
			compound.put("Item", stack.save(new CompoundNBT())); }

		compound.putBoolean("carrier", this.isCarrier());
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		ItemStack stack = ItemStack.of(compound.getCompound("Item"));
		this.setItem(stack);

		this.setCarrier(compound.getBoolean("carrier"));
	}
}
