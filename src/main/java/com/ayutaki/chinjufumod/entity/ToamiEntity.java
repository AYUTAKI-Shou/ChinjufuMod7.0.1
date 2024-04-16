package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ToamiEntity extends ThrowableProjectile implements ItemSupplier {
	
	private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(ToamiEntity.class, EntityDataSerializers.ITEM_STACK);
	private static final EntityDataAccessor<Integer> RETURN_TO = SynchedEntityData.defineId(ToamiEntity.class, EntityDataSerializers.INT);
	private ItemStack projectile = new ItemStack(Items_Teatime.TOAMI.get());

	public ToamiEntity(EntityType<ToamiEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	public ToamiEntity(LivingEntity entityIn, Level world, ItemStack stack) {
		super(EntityTypes_CM.TOAMI.get(), entityIn, world);
		this.projectile = stack.copy();
	}

	@Override
	protected void defineSynchedData() {
		this.getEntityData().define(DATA_ITEM_STACK, ItemStack.EMPTY);
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

		if (!this.level().isClientSide) {
			Entity thrower = getOwner();
			
			if (isReturning()) { 
				if (thrower == null && tickCount > 60) { dropAndKill(); }
				
				if (thrower != null) { returnAndKill(); } }
			
			if (!isReturning()) {
				if (thrower == null && tickCount > 60) { dropAndKill(); }
				
				if (thrower != null && tickCount >= 15) { setEntityToReturnTo(getEntityToReturnTo() + 1); } }
		}
	}

	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		if (!stack.is(this.getDefaultItem()) || stack.hasTag()) {
			this.getEntityData().set(DATA_ITEM_STACK, Util.make(stack.copy(), (consumer) -> {
				consumer.setCount(1);
			}));
		}
	}

	protected Item getDefaultItem() {
		return this.projectile.getItem();
	}

	protected ItemStack getItemRaw() {
		return this.getEntityData().get(DATA_ITEM_STACK);
	}
	
	/* Mandatory for "implements ItemSupplier" */
	public ItemStack getItem() {
		ItemStack stack = this.getItemRaw();
		return stack.isEmpty() ? new ItemStack(this.getDefaultItem()) : stack;
	}
	
	/* Drop item and Kill entity. */
	private void returnAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getOwner();
		Player playerIn = (Player)thrower;
		if (thrower != null && !playerIn.getAbilities().instabuild) { stack.hurt(1, random, null); }
		
		ItemEntity item = new ItemEntity(this.level(), thrower.getX(), thrower.getY(), thrower.getZ(), stack);
		this.level().addFreshEntity(item);
		discard();
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getOwner();
		Player playerIn = (Player)thrower;
		if (thrower != null && !playerIn.getAbilities().instabuild) { stack.hurt(1, random, null); }
		
		ItemEntity item = new ItemEntity(this.level(), getX(), getY(), getZ(), stack);
		this.level().addFreshEntity(item);
		discard();
	}

	/* Reflects durability value with "stack.copy()". */
	private ItemStack getItemStack() {
		return projectile.copy();
	}
	
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
	@SuppressWarnings("resource")
	@Override
	protected void onHitEntity(@Nonnull EntityHitResult result) {
		super.onHitEntity(result);
		Entity thrower = getOwner();
		
		if (isReturning()) { return; }
		
		if (!isReturning()) { 
			if (!this.level().isClientSide && result.getEntity() instanceof LivingEntity) {
				if (result.getEntity() instanceof Cod) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().discard();
					thrower.spawnAtLocation(new ItemStack(Items.COD)); }
				
				if (result.getEntity() instanceof Salmon) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().discard();
					thrower.spawnAtLocation(new ItemStack(Items.SALMON)); }
				
				if (result.getEntity() instanceof TropicalFish) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().discard();
					thrower.spawnAtLocation(new ItemStack(Items.TROPICAL_FISH)); }
				
				if (result.getEntity() instanceof Pufferfish) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().discard();
					thrower.spawnAtLocation(new ItemStack(Items.PUFFERFISH));
					((LivingEntity) thrower).addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0)); }
				
				if (result.getEntity() instanceof Squid) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().discard();
					thrower.spawnAtLocation(new ItemStack(Items_Teatime.IKA.get())); }
				
				if (!(result.getEntity() instanceof Cod) && !(result.getEntity() instanceof Salmon) &&
						!(result.getEntity() instanceof TropicalFish) && !(result.getEntity() instanceof Pufferfish) &&
						!(result.getEntity() instanceof Squid)) {
					
					result.getEntity().playSound(SoundEvents.GENERIC_HURT, 2.0F, 1.0F);
					((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1));
					setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}
	
	/** Collision to Block. **/
	@Override
	protected void onHitBlock(@Nonnull BlockHitResult result) {
		super.onHitBlock(result);
		BlockState state = this.level().getBlockState(result.getBlockPos());
		Block block = state.getBlock();
		if (state.canBeReplaced() || block == Blocks.KELP ||
				block == Crop_Blocks.SHIKAKE_AMI.get() || block == Crop_Blocks.YOUSHOKU_AMI.get()) { 
			return; }

		if (!state.canBeReplaced() && block != Blocks.KELP &&
				block != Crop_Blocks.SHIKAKE_AMI.get() && block != Crop_Blocks.YOUSHOKU_AMI.get()) { 
			//test sound... level().playSound(null, result.getBlockPos(), SoundEvents.STONE_BREAK, SoundCategory.BLOCKS, 3.0F, 0.8F);
			setEntityToReturnTo(getEntityToReturnTo() + 1); }
	}

	@Override
	protected float getGravity() {
		return 0F;
	}
	
	/* Effect of water on Entity Speed. */
	@Override
	public boolean isInWater() {
		return false;
	}

	private boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	private int getEntityToReturnTo() {
		return entityData.get(RETURN_TO).intValue();
	}

	private void setEntityToReturnTo(int entityID) {
		entityData.set(RETURN_TO, Integer.valueOf(entityID));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		ItemStack stack = this.getItemRaw();
		if (!stack.isEmpty()) {
			compound.put("Item", stack.save(new CompoundTag())); }
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		ItemStack stack = ItemStack.of(compound.getCompound("Item"));
		this.setItem(stack);
	}
}
