package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class Gyorai61cmEntity extends ThrowableEntity implements IRendersAsItem {

	private static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.defineId(Gyorai61cmEntity.class, DataSerializers.ITEM_STACK);
	private static final DataParameter<Byte> ID_FLAGS = EntityDataManager.defineId(Gyorai61cmEntity.class, DataSerializers.BYTE);
	private ItemStack projectile = new ItemStack(Items_Weapon.GYORAI_61cm);
	private double baseDamage = 10.0D;
	
	public Gyorai61cmEntity(EntityType<Gyorai61cmEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public Gyorai61cmEntity(LivingEntity entity, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.GYORAI61, entity, worldIn);
		this.projectile = stack.copy();
	}

	@Override
	protected void defineSynchedData() {
		this.getEntityData().define(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.entityData.define(ID_FLAGS, (byte)0);
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
		/** Particle **/
		this.level.addParticle(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!level.isClientSide && tickCount >= 60) { dropAndKill(); }
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
		ItemEntity item = new ItemEntity(level, getX(), getY(), getZ(), stack);
		level.addFreshEntity(item);
		remove();
	}

	/* Reflects durability value with "stack.copy()". */
	private ItemStack getItemStack() {
		return this.projectile.copy();
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

		/** Attack Mobs. **/
		double atackDamage = this.baseDamage;
		float criticalA = (this.random.nextInt(3) == 0)? 1.2F : 1.0F;
		float criticalB = (this.random.nextInt(9) == 0)? 1.1F : 0.9F;
		float addGYORAI = this.isSuirai()? criticalA : criticalB;

		result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), (float)atackDamage * addGYORAI);
		
		this.hitProcess();
		this.remove();
	}

	/** Collision to Block. **/
	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		BlockState state = this.level.getBlockState(result.getBlockPos());
		state.onProjectileHit(this.level, state, result, this);

		Block block = state.getBlock();
		if (state.getMaterial().isReplaceable() || block == Blocks.KELP) { return; }
		
		if (!state.getMaterial().isReplaceable() && block != Blocks.KELP) { 
			this.hitProcess();
			this.remove(); }
	}

	@Override
	protected float getGravity() {
		if (this.wasEyeInWater) { return 0F; }
		return 0.01F;
	}

	/* Effect of water on Entity Speed. */
	@Override
	public boolean isInWater() {
		return false;
	}

	public void setSuirai(boolean flag) {
		this.setFlag(1, flag);
	}
	
	protected void setFlag(int value, boolean flag) {
		byte b0 = this.entityData.get(ID_FLAGS);
		
		if (flag) { this.entityData.set(ID_FLAGS, (byte)(b0 | value)); } 
		else { this.entityData.set(ID_FLAGS, (byte)(b0 & ~value)); }
	}
	
	public boolean isSuirai() {
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
		
		compound.putDouble("damage", this.baseDamage);
		compound.putBoolean("suirai", this.isSuirai());
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		ItemStack stack = ItemStack.of(compound.getCompound("Item"));
		this.setItem(stack);
		
		if (compound.contains("damage", 99)) {
			this.baseDamage = compound.getDouble("damage"); }
		
		this.setSuirai(compound.getBoolean("suirai"));
	}

	public void setBaseDamage(double damage) {
		this.baseDamage = damage;
	}
	
	public double getBaseDamage() {
		return this.baseDamage;
	}
	
	/* Hit */
	public void hitProcess() {
		if (!this.level.isClientSide) {
			float addGYORAI = this.isSuirai()? 1.5F : 1.0F;
			this.createExplosion(this, this.getX(), this.getY(), this.getZ(), addGYORAI, false, Explosion.Mode.NONE); }
		
		this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F / (this.random.nextFloat() * 0.2F + 0.9F));
		this.level.broadcastEntityEvent(this, (byte)3);
	}
	
	public Explosion_CM createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode mode) {
		return this.explode(entityIn, (DamageSource)null, (ExplosionContext)null, xIn, yIn, zIn, value, flag, mode);
	}

	public Explosion_CM explode(@Nullable Entity entityIn, @Nullable DamageSource damage, @Nullable ExplosionContext context, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode mode) {
		Explosion_CM explosion = new Explosion_CM(level, this, damage, context, xIn, yIn, zIn, value, flag, mode);
		explosion.explode();
		explosion.finalizeExplosion(true);
		return explosion;
	}
	
	/* -> broadcastEntityEvent */
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			for(int i = 0; i < 4; ++i) {
				this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D); }
		}
	}
}
