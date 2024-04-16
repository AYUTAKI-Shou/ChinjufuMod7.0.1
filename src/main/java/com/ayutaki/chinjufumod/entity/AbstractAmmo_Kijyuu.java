package com.ayutaki.chinjufumod.entity;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractAmmo_Kijyuu extends AbstractArrowEntity {

	private static final DataParameter<Byte> ID_FLAGS = EntityDataManager.defineId(AbstractAmmo_Kijyuu.class, DataSerializers.BYTE);
	private static final DataParameter<Byte> PIERCE_LEVEL = EntityDataManager.defineId(AbstractAmmo_Kijyuu.class, DataSerializers.BYTE);
	@Nullable
	private BlockState lastState;
	protected boolean inGround;
	protected int inGroundTime;
	public AbstractAmmo_Kijyuu.PickupStatus pickup = AbstractAmmo_Kijyuu.PickupStatus.DISALLOWED;
	public int shakeTime;
	private int life;
	private double ammoDamage = 1.0D;
	private int knockback;
	private SoundEvent soundEvent = this.getDefaultHitGroundSoundEvent();
	private IntOpenHashSet piercingIgnoreEntityIds;
	private List<Entity> piercedAndKilledEntities;

	private boolean leftOwner; /**/
	
	protected AbstractAmmo_Kijyuu(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected AbstractAmmo_Kijyuu(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn) {
		this(type, worldIn);
		this.setPos(x, y, z);
	}

	protected AbstractAmmo_Kijyuu(EntityType<? extends AbstractArrowEntity> type, LivingEntity shooter, World worldIn) {
		this(type, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
		this.setOwner(shooter);
		if (shooter instanceof PlayerEntity) {
			this.pickup = AbstractAmmo_Kijyuu.PickupStatus.ALLOWED;
		}
	}

	@Override
	public void setSoundEvent(SoundEvent soundIn) {
		this.soundEvent = soundIn;
	}

	/*@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double distance) {
		double d0 = this.getBoundingBox().getSize() * 10.0D;
		if (Double.isNaN(d0)) {
			d0 = 1.0D;
		}

		d0 = d0 * 64.0D * getViewScale();
		return distance < d0 * d0;
	}*/

	@Override
	protected void defineSynchedData() {
		this.entityData.define(ID_FLAGS, (byte)0);
		this.entityData.define(PIERCE_LEVEL, (byte)0);
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity, inaccuracy);
		this.life = 0;
	}

	@OnlyIn(Dist.CLIENT)
	public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		this.setPos(x, y, z);
		this.setRot(yaw, pitch);
	}

	@OnlyIn(Dist.CLIENT)
	public void lerpMotion(double x, double y, double z) {
		super.lerpMotion(x, y, z);
		this.life = 0;
	}

	@SuppressWarnings("deprecation")
	public void tick() {
		//super.tick(); infernal-expansion-2.3.1 の意図は不明だが、書かずに済むように**を追加

		if (!this.level.isClientSide) { this.setSharedFlag(6, this.isGlowing()); } /**/
		if (!this.leftOwner) { this.leftOwner = this.checkLeftOwner(); } /**/

		boolean flag = this.isNoPhysics();
		Vector3d vector3d = this.getDeltaMovement();
		if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
			float f = MathHelper.sqrt(getHorizontalDistanceSqr(vector3d));
			this.yRot = (float)(MathHelper.atan2(vector3d.x, vector3d.z) * (double)(180F / (float)Math.PI));
			this.xRot = (float)(MathHelper.atan2(vector3d.y, (double)f) * (double)(180F / (float)Math.PI));
			this.yRotO = this.yRot;
			this.xRotO = this.xRot;
		}

		BlockPos pos = this.blockPosition();
		BlockState state = this.level.getBlockState(pos);
		if (!state.isAir(this.level, pos) && !flag) {
			VoxelShape voxelshape = state.getCollisionShape(this.level, pos);
			if (!voxelshape.isEmpty()) {
				Vector3d vector3d1 = this.position();

				for(AxisAlignedBB axisalignedbb : voxelshape.toAabbs()) {
					if (axisalignedbb.move(pos).contains(vector3d1)) {
						this.inGround = true;
						break;
					}
				}
			}
		}

		if (this.shakeTime > 0) {
			--this.shakeTime;
		}

		if (this.isInWaterOrRain()) {
			this.clearFire();
		}

		/** inGround remove **/
		if (this.inGround && !flag) {
			this.level.broadcastEntityEvent(this, (byte)3); /***/
			this.remove();
		}

		else {
			this.inGroundTime = 0;
			Vector3d vector3d2 = this.position();
			Vector3d vector3d3 = vector3d2.add(vector3d);
			RayTraceResult raytraceresult = this.level.clip(new RayTraceContext(vector3d2, vector3d3, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this));
			if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
				vector3d3 = raytraceresult.getLocation();
			}

			while(!this.removed) {
				EntityRayTraceResult entityraytraceresult = this.findHitEntity(vector3d2, vector3d3);
				if (entityraytraceresult != null) {
					raytraceresult = entityraytraceresult;
				}

				if (raytraceresult != null && raytraceresult.getType() == RayTraceResult.Type.ENTITY) {
					Entity entity = ((EntityRayTraceResult)raytraceresult).getEntity();
					Entity owner = this.getOwner();
					if (entity instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).canHarmPlayer((PlayerEntity)entity)) {
						raytraceresult = null;
						entityraytraceresult = null;
					}
				}

				if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !flag && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
					this.onHit(raytraceresult);
					this.hasImpulse = true;
				}

				if (entityraytraceresult == null || this.getPierceLevel() <= 0) {
					break;
				}

				raytraceresult = null;
			}

			vector3d = this.getDeltaMovement();
			double d3 = vector3d.x;
			double d4 = vector3d.y;
			double d0 = vector3d.z;
			/* addParticle */

			double d5 = this.getX() + d3;
			double d1 = this.getY() + d4;
			double d2 = this.getZ() + d0;
			float f1 = MathHelper.sqrt(getHorizontalDistanceSqr(vector3d));
			if (flag) {
				this.yRot = (float)(MathHelper.atan2(-d3, -d0) * (double)(180F / (float)Math.PI));
			} else {
				this.yRot = (float)(MathHelper.atan2(d3, d0) * (double)(180F / (float)Math.PI));
			}

			this.xRot = (float)(MathHelper.atan2(d4, (double)f1) * (double)(180F / (float)Math.PI));
			this.xRot = lerpRotation(this.xRotO, this.xRot);
			this.yRot = lerpRotation(this.yRotO, this.yRot);
			float f2 = 0.99F;
			
			if (this.isInWater()) {
				for(int j = 0; j < 4; ++j) {
					this.level.addParticle(ParticleTypes.BUBBLE, d5 - d3 * 0.25D, d1 - d4 * 0.25D, d2 - d0 * 0.25D, d3, d4, d0); }

				f2 = this.getWaterInertia();
			}

			this.setDeltaMovement(vector3d.scale((double)f2));
			if (!this.isNoGravity() && !flag) {
				Vector3d vector3d4 = this.getDeltaMovement();
				this.setDeltaMovement(vector3d4.x, vector3d4.y - (double)0.05F, vector3d4.z);
			}

			this.setPos(d5, d1, d2);
			this.checkInsideBlocks();
		}

		this.baseTick(); /**/
	}

	private boolean checkLeftOwner() {
		Entity entity = this.getOwner();
		if (entity != null) {
			for(Entity entity1 : this.level.getEntities(this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), (entity0) -> {
				return !entity0.isSpectator() && entity0.isPickable();
			})) {
				if (entity1.getRootVehicle() == entity.getRootVehicle()) {
					return false;
				}
			}
		}
		return true;
	} /**/
		
	private boolean shouldFall() {
		return this.inGround && this.level.noCollision((new AxisAlignedBB(this.position(), this.position())).inflate(0.06D));
	}

	private void startFalling() {
		this.inGround = false;
		Vector3d vector3d = this.getDeltaMovement();
		this.setDeltaMovement(vector3d.multiply((double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F)));
		this.life = 0;
	}

	@Override
	public void move(MoverType mover, Vector3d vector3d) {
		super.move(mover, vector3d);
		if (mover != MoverType.SELF && this.shouldFall()) {
			this.startFalling();
		}
	}

	@Override
	protected void tickDespawn() {
		++this.life;
		if (this.life >= 1000) {
			this.level.broadcastEntityEvent(this, (byte)3); /***/
			this.remove();
		}
	}

	private void resetPiercedEntities() {
		if (this.piercedAndKilledEntities != null) {
			this.piercedAndKilledEntities.clear();
		}

		if (this.piercingIgnoreEntityIds != null) {
			this.piercingIgnoreEntityIds.clear();
		}
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		// super.onHitEntity(result); Don't refer to arrow.
		Entity entity = result.getEntity();
		float f = (float)this.getDeltaMovement().length();
		int i = MathHelper.ceil(MathHelper.clamp((double)f * this.ammoDamage, 0.0D, 2.147483647E9D));
		if (this.getPierceLevel() > 0) {
			if (this.piercingIgnoreEntityIds == null) {
				this.piercingIgnoreEntityIds = new IntOpenHashSet(5);
			}

			if (this.piercedAndKilledEntities == null) {
				this.piercedAndKilledEntities = Lists.newArrayListWithCapacity(5);
			}

			if (this.piercingIgnoreEntityIds.size() >= this.getPierceLevel() + 1) {
				this.remove();
				return;
			}

			this.piercingIgnoreEntityIds.add(entity.getId());
		}

		Entity owner = this.getOwner();
		DamageSource damagesource;
		if (owner == null) {
			damagesource = DamageSource.thrown(this, this);
		} else {
			damagesource = DamageSource.thrown(this, owner);
			if (owner instanceof LivingEntity) {
				((LivingEntity)owner).setLastHurtMob(entity);
			}
		}

		boolean flag = entity.getType() == EntityType.ENDERMAN;
		int k = entity.getRemainingFireTicks();
		if (this.isOnFire() && !flag) {
			entity.setSecondsOnFire(5);
		}

		if (entity.hurt(damagesource, (float)i)) {
			if (flag) {
				return;
			}

			if (entity instanceof LivingEntity) {
				LivingEntity livingentity = (LivingEntity)entity;
				if (!this.level.isClientSide && this.getPierceLevel() <= 0) {
					livingentity.setArrowCount(livingentity.getArrowCount() + 1);
				}

				if (this.knockback > 0) {
					Vector3d vector3d = this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D).normalize().scale((double)this.knockback * 0.6D);
					if (vector3d.lengthSqr() > 0.0D) {
						livingentity.push(vector3d.x, 0.1D, vector3d.z);
					}
				}

				if (!this.level.isClientSide && owner instanceof LivingEntity) {
					EnchantmentHelper.doPostHurtEffects(livingentity, owner);
					EnchantmentHelper.doPostDamageEffects((LivingEntity)owner, livingentity);
				}

				this.doPostHurtEffects(livingentity);
				if (owner != null && livingentity != owner && livingentity instanceof PlayerEntity && owner instanceof ServerPlayerEntity && !this.isSilent()) {
					((ServerPlayerEntity)owner).connection.send(new SChangeGameStatePacket(SChangeGameStatePacket.ARROW_HIT_PLAYER, 0.0F));
				}

				if (!entity.isAlive() && this.piercedAndKilledEntities != null) {
					this.piercedAndKilledEntities.add(livingentity);
				}
			}

			this.playSound(this.soundEvent, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
			if (this.getPierceLevel() <= 0) {
				this.remove();
			}
		}

		else {
			entity.setRemainingFireTicks(k);
			this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
			this.yRot += 180.0F;
			this.yRotO += 180.0F;
			if (!this.level.isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
				if (this.pickup == AbstractAmmo_Kijyuu.PickupStatus.ALLOWED) {
					this.spawnAtLocation(this.getPickupItem(), 0.1F);
				}
				this.remove();
			}
		}
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		this.lastState = this.level.getBlockState(result.getBlockPos());
		super.onHitBlock(result);
		Vector3d vector3d = result.getLocation().subtract(this.getX(), this.getY(), this.getZ());
		this.setDeltaMovement(vector3d);
		Vector3d vector3d1 = vector3d.normalize().scale((double)0.05F);
		this.setPosRaw(this.getX() - vector3d1.x, this.getY() - vector3d1.y, this.getZ() - vector3d1.z);
		this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
		this.inGround = true;
		this.shakeTime = 7;
		this.setCritArrow(false);
		this.setPierceLevel((byte)0);
		this.setSoundEvent(SoundEvents_CM.AM_HIT);
		this.setShotFromCrossbow(false);
		this.resetPiercedEntities();
	}

	@Override
	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents_CM.AM_HIT;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) { }

	@Nullable
	protected EntityRayTraceResult findHitEntity(Vector3d vector3d_1, Vector3d vector3d_2) {
		return ProjectileHelper.getEntityHitResult(this.level, this, vector3d_1, vector3d_2, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), this::canHitEntity);
	}

	@Override
	protected boolean canHitEntity(Entity entity) {
		return super.canHitEntity(entity) && (this.piercingIgnoreEntityIds == null || !this.piercingIgnoreEntityIds.contains(entity.getId()));
	}

	@SuppressWarnings("deprecation")
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putShort("life", (short)this.life);
		if (this.lastState != null) {
			compound.put("inBlockState", NBTUtil.writeBlockState(this.lastState));
		}

		compound.putByte("shake", (byte)this.shakeTime);
		compound.putBoolean("inGround", this.inGround);
		compound.putByte("pickup", (byte)this.pickup.ordinal());
		compound.putDouble("damage", this.ammoDamage);
		compound.putBoolean("crit", this.isCritArrow());
		compound.putByte("PierceLevel", this.getPierceLevel());
		compound.putString("SoundEvent", Registry.SOUND_EVENT.getKey(this.soundEvent).toString());
		compound.putBoolean("ShotFromCrossbow", this.shotFromCrossbow());
	}

	@SuppressWarnings("deprecation")
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		this.life = compound.getShort("life");
		if (compound.contains("inBlockState", 10)) {
			this.lastState = NBTUtil.readBlockState(compound.getCompound("inBlockState"));
		}

		this.shakeTime = compound.getByte("shake") & 255;
		this.inGround = compound.getBoolean("inGround");
		if (compound.contains("damage", 99)) {
			this.ammoDamage = compound.getDouble("damage");
		}

		if (compound.contains("pickup", 99)) {
			this.pickup = AbstractAmmo_Kijyuu.PickupStatus.byOrdinal(compound.getByte("pickup"));
		} else if (compound.contains("player", 99)) {
			this.pickup = compound.getBoolean("player") ? AbstractAmmo_Kijyuu.PickupStatus.ALLOWED : AbstractAmmo_Kijyuu.PickupStatus.DISALLOWED;
		}

		this.setCritArrow(compound.getBoolean("crit"));
		this.setPierceLevel(compound.getByte("PierceLevel"));
		if (compound.contains("SoundEvent", 8)) {
			this.soundEvent = Registry.SOUND_EVENT.getOptional(new ResourceLocation(compound.getString("SoundEvent"))).orElse(this.getDefaultHitGroundSoundEvent());
		}

		this.setShotFromCrossbow(compound.getBoolean("ShotFromCrossbow"));
	}

	@Override
	public void setOwner(@Nullable Entity entity) {
		super.setOwner(entity);
		if (entity instanceof PlayerEntity) {
			this.pickup = ((PlayerEntity)entity).abilities.instabuild ? AbstractAmmo_Kijyuu.PickupStatus.CREATIVE_ONLY : AbstractAmmo_Kijyuu.PickupStatus.ALLOWED;
		}
	}

	@Override
	public void playerTouch(PlayerEntity entity) {
		if (!this.level.isClientSide && (this.inGround || this.isNoPhysics()) && this.shakeTime <= 0) {
			boolean flag = this.pickup == AbstractAmmo_Kijyuu.PickupStatus.ALLOWED || this.pickup == AbstractAmmo_Kijyuu.PickupStatus.CREATIVE_ONLY && entity.abilities.instabuild || this.isNoPhysics() && this.getOwner().getUUID() == entity.getUUID();
			if (this.pickup == AbstractAmmo_Kijyuu.PickupStatus.ALLOWED && !entity.inventory.add(this.getPickupItem())) {
				flag = false;
			}

			if (flag) {
				entity.take(this, 1);
				this.remove();
			}
		}
	}

	protected abstract ItemStack getPickupItem();

	@Override
	protected boolean isMovementNoisy() {
		return false;
	}

	@Override
	public void setBaseDamage(double damage) {
		this.ammoDamage = damage;
	}

	@Override
	public double getBaseDamage() {
		return this.ammoDamage;
	}

	@Override
	public void setKnockback(int knockback) {
		this.knockback = knockback;
	}

	@Override
	public boolean isAttackable() {
		return false;
	}

	@Override
	protected float getEyeHeight(Pose pos, EntitySize size) {
		return 0.13F;
	}

	@Override
	public void setCritArrow(boolean flag) {
		this.setFlag(1, flag);
	}

	@Override
	public void setPierceLevel(byte value) {
		this.entityData.set(PIERCE_LEVEL, value);
	}

	private void setFlag(int value, boolean flag) {
		byte b0 = this.entityData.get(ID_FLAGS);
		if (flag) { this.entityData.set(ID_FLAGS, (byte)(b0 | value)); }
		
		else { this.entityData.set(ID_FLAGS, (byte)(b0 & ~value)); }
	}

	@Override
	public boolean isCritArrow() {
		byte b0 = this.entityData.get(ID_FLAGS);
		return (b0 & 1) != 0;
	}

	@Override
	public boolean shotFromCrossbow() {
		byte b0 = this.entityData.get(ID_FLAGS);
		return (b0 & 4) != 0;
	}

	@Override
	public byte getPierceLevel() {
		return this.entityData.get(PIERCE_LEVEL);
	}

	@Override
	public void setEnchantmentEffectsFromEntity(LivingEntity entity, float value) {
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER_ARROWS, entity);
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH_ARROWS, entity);
		this.setBaseDamage((double)(value * 2.0F) + this.random.nextGaussian() * 0.25D + (double)((float)this.level.getDifficulty().getId() * 0.11F));
		if (i > 0) {
			this.setBaseDamage(this.getBaseDamage() + (double)i * 0.5D);
		}

		if (j > 0) {
			this.setKnockback(j);
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, entity) > 0) {
			this.setSecondsOnFire(100);
		}
	}

	@Override
	protected float getWaterInertia() {
		return 0.6F;
	}

	@Override
	public void setNoPhysics(boolean flag) {
		this.noPhysics = flag;
		this.setFlag(2, flag);
	}

	@Override
	public boolean isNoPhysics() {
		if (!this.level.isClientSide) {
			return this.noPhysics;
		} else {
			return (this.entityData.get(ID_FLAGS) & 2) != 0;
		}
	}

	@Override
	public void setShotFromCrossbow(boolean flag) {
		this.setFlag(4, flag);
	}

	/* Flying render, and addParticle */
	@Override
	public IPacket<?> getAddEntityPacket() {
		Entity owner = this.getOwner();
		return new SSpawnObjectPacket(this, owner == null ? 0 : owner.getId());
	}

	public static enum PickupStatus {
		DISALLOWED,
		ALLOWED,
		CREATIVE_ONLY;

		public static AbstractAmmo_Kijyuu.PickupStatus byOrdinal(int value) {
			if (value < 0 || value > values().length) {
				value = 0; }

			return values()[value];
		}
	}

	/* -> broadcastEntityEvent */
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 3) { 
			this.level.addParticle(ParticleTypes_CM.MARK_PT, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D); }
	}
}
