package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class ToamiEntity extends ThrowableEntity implements IRendersAsItem {

	private static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.defineId(ToamiEntity.class, DataSerializers.ITEM_STACK);
	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.defineId(ToamiEntity.class, DataSerializers.INT);
	private ItemStack projectile = new ItemStack(Items_Teatime.TOAMI);
	
	public ToamiEntity(EntityType<ToamiEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public ToamiEntity(LivingEntity entityIn, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.TOAMI, entityIn, worldIn);
		projectile = stack.copy();
	}

	@Override
	protected void defineSynchedData() {
		this.getEntityData().define(DATA_ITEM_STACK, ItemStack.EMPTY);
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

	@Override
	public void tick() {
		super.tick();

		if (!level.isClientSide) {
			Entity thrower = getOwner();
			
			if (isReturning()) { 
				if (thrower == null && tickCount > 60) { dropAndKill(); }
				
				if (thrower != null) { returnAndKill(); } }
			
			if (!isReturning()) {
				if (thrower == null && tickCount > 60) { dropAndKill(); }
				
				if (thrower != null && tickCount >= 15) { setEntityToReturnTo(getEntityToReturnTo() + 1); } }
		}
	}

	/* Drop item and Kill entity. */
	private void returnAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getOwner();
		PlayerEntity playerIn = (PlayerEntity)thrower;
		if (thrower != null && !playerIn.abilities.instabuild) { stack.hurt(1, random, null); }
		
		ItemEntity item = new ItemEntity(level, thrower.getX(), thrower.getY(), thrower.getZ(), stack);
		level.addFreshEntity(item);
		remove();
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getOwner();
		PlayerEntity playerIn = (PlayerEntity)thrower;
		if (thrower != null && !playerIn.abilities.instabuild) { stack.hurt(1, random, null); }
		
		ItemEntity item = new ItemEntity(level, getX(), getY(), getZ(), stack);
		level.addFreshEntity(item);
		remove();
	}
	
	/* Reflects durability value with "stack.copy()". */
	private ItemStack getItemStack() {
		return projectile.copy();
	}
	
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
	protected void onHitEntity(EntityRayTraceResult result) {
		Entity thrower = getOwner();
		
		if (isReturning()) { return; }

		if (!isReturning()) { 
			if (!level.isClientSide && result.getEntity() instanceof LivingEntity) {
				
				if (result.getEntity() instanceof CodEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.COD)); }
				
				if (result.getEntity() instanceof SalmonEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.SALMON)); }
				
				if (result.getEntity() instanceof TropicalFishEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.TROPICAL_FISH)); }
				
				if (result.getEntity() instanceof PufferfishEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.PUFFERFISH));
					((LivingEntity) thrower).addEffect(new EffectInstance(Effects.POISON, 60, 0)); }
				
				if (result.getEntity() instanceof SquidEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items_Teatime.IKA)); }
				
				if (!(result.getEntity() instanceof CodEntity) && !(result.getEntity() instanceof SalmonEntity) &&
						!(result.getEntity() instanceof TropicalFishEntity) && !(result.getEntity() instanceof PufferfishEntity) &&
						!(result.getEntity() instanceof SquidEntity)) {
					
					result.getEntity().playSound(SoundEvents.GENERIC_HURT, 2.0F, 1.0F);
					((LivingEntity) result.getEntity()).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 300, 1));
					setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	/** Collision to Block. **/
	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		BlockState state = level.getBlockState(result.getBlockPos());
		state.onProjectileHit(level, state, result, this);
		
		Block block = state.getBlock();
		if (state.getMaterial().isReplaceable() || block == Blocks.KELP ||
				block == Crop_Blocks.SHIKAKE_AMI || block == Crop_Blocks.YOUSHOKU_AMI) { 
			return; }
		
		if (!state.getMaterial().isReplaceable() && block != Blocks.KELP &&
				block != Crop_Blocks.SHIKAKE_AMI && block != Crop_Blocks.YOUSHOKU_AMI) { 
			//test sound... level.playSound(null, result.getBlockPos(), SoundEvents.STONE_BREAK, SoundCategory.BLOCKS, 3.0F, 0.8F);
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
	
	public boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	private int getEntityToReturnTo() {
		return entityData.get(RETURN_TO).intValue();
	}

	private void setEntityToReturnTo(int entityID) {
		entityData.set(RETURN_TO, Integer.valueOf(entityID));
	}

	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		if (stack.getItem() != this.getDefaultItem() || stack.hasTag()) {
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
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		ItemStack stack = ItemStack.of(compound.getCompound("Item"));
		this.setItem(stack);
	}
}
