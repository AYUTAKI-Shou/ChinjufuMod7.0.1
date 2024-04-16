package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.entity.helper.Vector3;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractKK_Entity extends ThrowableProjectile implements ItemSupplier {

	protected static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(AbstractKK_Entity.class, EntityDataSerializers.ITEM_STACK);
	protected static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(AbstractKK_Entity.class, EntityDataSerializers.BYTE);
	protected static final EntityDataAccessor<Integer> RETURN_TO = SynchedEntityData.defineId(AbstractKK_Entity.class, EntityDataSerializers.INT);
	
	public AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, Level worldIn) {
		super(type, worldIn);
	}

	public AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, double posX, double posY, double posZ, Level worldIn) {
		super(type, posX, posY, posZ, worldIn);
	}

	protected AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, LivingEntity shooter, Level worldIn) {
		super(type, shooter, worldIn);
		this.setOwner(shooter);
		if (Config_CM.INSTANCE.lowSound.get()) { this.playSound(SoundEvents_CM.KK_PROPELLER12.get(), 1.5F, 1.0F); }
	}
	
	@Override
	protected void defineSynchedData() {
		this.getEntityData().define(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.entityData.define(ID_FLAGS, (byte)0);
		this.entityData.define(RETURN_TO, Integer.valueOf(-1));
	}

	/* Flying render 1.18->1.20 */
	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this);
	} // fix 20.2

	@Override
	public boolean ignoreExplosion() {
		return true;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void tick() {
		super.tick();
		
		/** PROPELLER Sound **/
		if (!Config_CM.INSTANCE.lowSound.get()) {
			if (this.tickCount % 3 == 0 ) { this.playSound(SoundEvents_CM.KK_PROPELLER.get(), 1.5F, 1.0F); } }
		
		if (!level().isClientSide) {
			Entity thrower = getOwner();
			
			/** Return move **/
			if (isReturning()) {
				if (thrower == null && tickCount > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vec3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					setDeltaMovement(motion);
					
					if (distanceToSqr(thrower) < 2) { dropAndKill(); } }
			}
			
			/** Flying move **/
			if (!isReturning()) {
				if (thrower == null && tickCount > 200) { dropAndKill(); }
				
				if (thrower != null && tickCount >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	/* Drop item and Kill entity. */
	protected void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getOwner();
		Player playerIn = (Player)thrower;
		if (thrower != null && !playerIn.getAbilities().instabuild) { stack.hurt(1, random, null); }
		
		ItemEntity item = new ItemEntity(level(), getX(), getY(), getZ(), stack);
		level().addFreshEntity(item);
		discard();
	}

	protected abstract ItemStack getItemStack();
	
	/* Collision processing. */
	@Override
	protected void onHit(HitResult result) {
		HitResult.Type hitresult$type = result.getType();
		if (hitresult$type == HitResult.Type.ENTITY) {
			this.onHitEntity((EntityHitResult)result); }
		
		else if (hitresult$type == HitResult.Type.BLOCK) {
			this.onHitBlock((BlockHitResult)result); }
	}
	
	/** Collision to Entity. **/
	@Override
	protected void onHitEntity(@Nonnull EntityHitResult result) { }

	/** Collision to Block. **/
	@Override
	protected void onHitBlock(@Nonnull BlockHitResult result) {
		super.onHitBlock(result);
		BlockState state = level().getBlockState(result.getBlockPos());
		Block block = state.getBlock();
		/** Go through the blocks. **/
		if (block instanceof Block) { return; }
	}

	@Override
	protected float getGravity() {
		return 0.0F;
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
	
	private void setFlag(int value, boolean flag) {
		byte b0 = this.entityData.get(ID_FLAGS);
		if (flag) {
			this.entityData.set(ID_FLAGS, (byte)(b0 | value));
		} else {
			this.entityData.set(ID_FLAGS, (byte)(b0 & ~value));
		}
	}
	
	public boolean isCarrier() {
		byte b0 = this.entityData.get(ID_FLAGS);
		return (b0 & 1) != 0;
	}
	
	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		if (!stack.is(this.getDefaultItem()) || stack.hasTag()) {
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
	public ItemStack getItem() {
		ItemStack stack = this.getItemRaw();
		return stack.isEmpty() ? new ItemStack(this.getDefaultItem()) : stack;
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		ItemStack stack = this.getItemRaw();
		if (!stack.isEmpty()) {
			compound.put("Item", stack.save(new CompoundTag())); }

		compound.putBoolean("carrier", this.isCarrier());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		ItemStack stack = ItemStack.of(compound.getCompound("Item"));
		this.setItem(stack);

		this.setCarrier(compound.getBoolean("carrier"));
	}
}
