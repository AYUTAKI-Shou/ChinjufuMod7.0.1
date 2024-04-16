package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Gyorai61cmEntity extends ThrowableProjectile implements ItemSupplier {

	private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(Gyorai61cmEntity.class, EntityDataSerializers.ITEM_STACK);
	private static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(Gyorai61cmEntity.class, EntityDataSerializers.BYTE);
	private ItemStack projectile = new ItemStack(Items_Weapon.GYORAI_61cm.get());
	private double baseDamage = 10.0D;
	
	public Gyorai61cmEntity(EntityType<Gyorai61cmEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	public Gyorai61cmEntity(LivingEntity entityIn, Level world, ItemStack stack) {
		super(EntityTypes_CM.GYORAI61.get(), entityIn, world);
		this.projectile = stack.copy();
	}

	@Override
	protected void defineSynchedData() {
		this.getEntityData().define(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.entityData.define(ID_FLAGS, (byte)0);
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
		/** Add Particle **/
		this.level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!level().isClientSide && tickCount >= 60) { dropAndKill(); }
	}

	/* Drop item and Kill entity. */
	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
		ItemEntity item = new ItemEntity(level(), getX(), getY(), getZ(), stack);
		level().addFreshEntity(item);
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
	@Override
	protected void onHitEntity(@Nonnull EntityHitResult result) {
		super.onHitEntity(result);

		/** Attack Mobs. **/
		double atackDamage = this.baseDamage;
		float criticalA = (this.random.nextInt(3) == 0)? 1.2F : 1.0F;
		float criticalB = (this.random.nextInt(9) == 0)? 1.1F : 0.9F;
		float addGYORAI = this.isSuirai()? criticalA : criticalB;

		result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), (float)atackDamage * addGYORAI);
		
		this.hitProcess();
		this.discard();
	}
	
	/** Collision to Block. **/
	@Override
	protected void onHitBlock(@Nonnull BlockHitResult result) {
		super.onHitBlock(result);
		BlockState state = level().getBlockState(result.getBlockPos());
		Block block = state.getBlock();
		if (state.canBeReplaced() || block == Blocks.KELP) { 
			return; }
		
		if (!state.canBeReplaced() && block != Blocks.KELP) { 
			this.hitProcess();
			this.discard(); }
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
	
	private void setFlag(int value, boolean flag) {
		byte b0 = this.entityData.get(ID_FLAGS);
		if (flag) {
			this.entityData.set(ID_FLAGS, (byte)(b0 | value));
		} else {
			this.entityData.set(ID_FLAGS, (byte)(b0 & ~value));
		}
	}
	
	public boolean isSuirai() {
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
	
	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		ItemStack stack = this.getItemRaw();
		if (!stack.isEmpty()) {
			compound.put("Item", stack.save(new CompoundTag())); }

		compound.putDouble("damage", this.baseDamage);
		compound.putBoolean("suirai", this.isSuirai());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
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
	@SuppressWarnings("resource")
	public void hitProcess() {
		if (!this.level().isClientSide) {
			float addGYORAI = this.isSuirai()? 1.5F : 1.0F;
			this.createExplosion(this, this.getX(), this.getY(), this.getZ(), addGYORAI, false, Explosion.BlockInteraction.KEEP); }

		this.playSound(SoundEvents_CM.AM_IMPACT.get(), 2.0F, 0.8F / (this.random.nextFloat() * 0.2F + 0.9F));
		this.level().broadcastEntityEvent(this, (byte)3);
	}
	
	public Explosion_CM createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.BlockInteraction mode) {
		return this.explode(entityIn, (DamageSource)null, (ExplosionDamageCalculator)null, xIn, yIn, zIn, value, flag, mode);
	}

	public Explosion_CM explode(@Nullable Entity entityIn, @Nullable DamageSource damage, @Nullable ExplosionDamageCalculator context, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.BlockInteraction mode) {
		Explosion_CM explosion = new Explosion_CM(level(), this, damage, context, xIn, yIn, zIn, value, flag, mode);
		explosion.explode();
		explosion.finalizeExplosion(true);
		return explosion;
	}
	
	/** from Snow ball **/
	@OnlyIn(Dist.CLIENT)
	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			for (int re = 0; re < 4; re++) {
				this.level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D); }
		}
	}
}
