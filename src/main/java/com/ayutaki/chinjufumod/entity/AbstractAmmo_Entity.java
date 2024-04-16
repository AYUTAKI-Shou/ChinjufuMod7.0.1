package com.ayutaki.chinjufumod.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractAmmo_Entity extends Entity implements IProjectile {

	private static final DataParameter<Byte> CRITICAL = EntityDataManager.createKey(AbstractAmmo_Entity.class, DataSerializers.BYTE);
	protected static final DataParameter<Optional<UUID>> field_212362_a = EntityDataManager.createKey(AbstractAmmo_Entity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	private static final DataParameter<Byte> PIERCE_LEVEL = EntityDataManager.createKey(AbstractAmmo_Entity.class, DataSerializers.BYTE);
	@Nullable
	private BlockState inBlockState;
	protected boolean inGround;
	protected int timeInGround;
	public AbstractAmmo_Entity.PickupStatus pickupStatus = AbstractAmmo_Entity.PickupStatus.DISALLOWED;
	public int arrowShake;
	public UUID shootingEntity;
	private int ticksInGround;
	private int ticksInAir;
	/** 工廠指示書を難しくした分の加算 + 1.0して 3.0D**/
	private double ammoDamage = 3.0D;
	private int knockbackStrength;
	private SoundEvent hitSound = this.getHitEntitySound();
	private IntOpenHashSet piercedEntities;
	private List<Entity> hitEntities;

	protected AbstractAmmo_Entity(EntityType<? extends AbstractAmmo_Entity> type, World worldIn) {
		super(type, worldIn);
	}

	protected AbstractAmmo_Entity(EntityType<? extends AbstractAmmo_Entity> type, double x, double y, double z, World worldIn) {
		this(type, worldIn);
		this.setPosition(x, y, z);
	}

	protected AbstractAmmo_Entity(EntityType<? extends AbstractAmmo_Entity> type, LivingEntity shooter, World worldIn) {
		this(type, shooter.getPosX(), shooter.getPosYEye() - (double)0.1F, shooter.getPosZ(), worldIn);
		this.setShooter(shooter);

		if (shooter instanceof PlayerEntity) {
			this.pickupStatus = AbstractAmmo_Entity.PickupStatus.ALLOWED;
		}
	}

	public void setHitSound(SoundEvent soundIn) {
		this.hitSound = soundIn;
	}

	/** Checks if the entity is in range to render. */
	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance) {
		double d0 = this.getBoundingBox().getAverageEdgeLength() * 10.0D;
		if (Double.isNaN(d0)) {
			d0 = 1.0D;
		}

		d0 = d0 * 64.0D * getRenderDistanceWeight();
		return distance < d0 * d0;
	}

	protected void registerData() {
		this.dataManager.register(CRITICAL, (byte)0);
		this.dataManager.register(field_212362_a, Optional.empty());
		this.dataManager.register(PIERCE_LEVEL, (byte)0);
	}

	public void shoot(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy) {
		float f = -MathHelper.sin(yaw * ((float)Math.PI / 180F)) * MathHelper.cos(pitch * ((float)Math.PI / 180F));
		float f1 = -MathHelper.sin(pitch * ((float)Math.PI / 180F));
		float f2 = MathHelper.cos(yaw * ((float)Math.PI / 180F)) * MathHelper.cos(pitch * ((float)Math.PI / 180F));
		this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
		this.setMotion(this.getMotion().add(shooter.getMotion().x, shooter.onGround ? 0.0D : shooter.getMotion().y, shooter.getMotion().z));
	}

	/** Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction. */
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		Vec3d vec3d = (new Vec3d(x, y, z)).normalize().add(this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy, this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy, this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy).scale((double)velocity);
		this.setMotion(vec3d);
		float f = MathHelper.sqrt(horizontalMag(vec3d));
		this.rotationYaw = (float)(MathHelper.atan2(vec3d.x, vec3d.z) * (double)(180F / (float)Math.PI));
		this.rotationPitch = (float)(MathHelper.atan2(vec3d.y, (double)f) * (double)(180F / (float)Math.PI));
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
		this.ticksInGround = 0;
	}

	/** Sets a target for the client to interpolate towards over the next few ticks */
	@OnlyIn(Dist.CLIENT)
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		this.setPosition(x, y, z);
		this.setRotation(yaw, pitch);
	}

	/** Updates the entity motion clientside, called by packets from the server */
	@OnlyIn(Dist.CLIENT)
	public void setVelocity(double x, double y, double z) {
		this.setMotion(x, y, z);

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt(x * x + z * z);
			this.rotationPitch = (float)(MathHelper.atan2(y, (double)f) * (double)(180F / (float)Math.PI));
			this.rotationYaw = (float)(MathHelper.atan2(x, z) * (double)(180F / (float)Math.PI));
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
			this.ticksInGround = 0;
		}
	}

	/** Called to update the entity's position/logic. */
	@SuppressWarnings("deprecation")
	public void tick() {
		super.tick();
		boolean flag = this.getNoClip();
		Vec3d vec3d = this.getMotion();
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt(horizontalMag(vec3d));
			this.rotationYaw = (float)(MathHelper.atan2(vec3d.x, vec3d.z) * (double)(180F / (float)Math.PI));
			this.rotationPitch = (float)(MathHelper.atan2(vec3d.y, (double)f) * (double)(180F / (float)Math.PI));
			this.prevRotationYaw = this.rotationYaw;
			this.prevRotationPitch = this.rotationPitch;
		}

		BlockPos pos = new BlockPos(this);
		BlockState state = this.world.getBlockState(pos);

		if (!state.isAir(this.world, pos) && !flag) {
			VoxelShape voxelshape = state.getCollisionShape(this.world, pos);

			if (!voxelshape.isEmpty()) {
				Vec3d vec3d1 = this.getPositionVec();

				for(AxisAlignedBB axisalignedbb : voxelshape.toBoundingBoxList()) {
					if (axisalignedbb.offset(pos).contains(vec3d1)) {
						this.inGround = true;
						break;
					}
				}
			}
		}

		if (this.arrowShake > 0) {
			--this.arrowShake;
		}

		if (this.isWet()) {
			this.extinguish();
		}

		if (this.inGround && !flag) {
			this.hitProcess();
			this.remove();
		}

		else {
			this.timeInGround = 0;
			++this.ticksInAir;
			Vec3d vec3d2 = this.getPositionVec();
			Vec3d vec3d3 = vec3d2.add(vec3d);
			RayTraceResult raytraceresult = this.world.rayTraceBlocks(new RayTraceContext(vec3d2, vec3d3, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this));

			if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
				vec3d3 = raytraceresult.getHitVec();
			}

			while(!this.removed) {
				EntityRayTraceResult entityraytraceresult = this.rayTraceEntities(vec3d2, vec3d3);

				if (entityraytraceresult != null) {
					raytraceresult = entityraytraceresult;
				}

				if (raytraceresult != null && raytraceresult.getType() == RayTraceResult.Type.ENTITY) {
					Entity entity = ((EntityRayTraceResult)raytraceresult).getEntity();
					Entity entity1 = this.getShooter();

					if (entity instanceof PlayerEntity && entity1 instanceof PlayerEntity && !((PlayerEntity)entity1).canAttackPlayer((PlayerEntity)entity)) {
						raytraceresult = null;
						entityraytraceresult = null;
					}
				}

				if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !flag && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
					this.onHit(raytraceresult);
					this.isAirBorne = true;
				}

				if (entityraytraceresult == null || this.getPierceLevel() <= 0) {
					break;
				}

				raytraceresult = null;
			}

			vec3d = this.getMotion();
			double d3 = vec3d.x;
			double d4 = vec3d.y;
			double d0 = vec3d.z;

			if (this.getIsCritical()) {
				for(int i = 0; i < 4; ++i) {
					this.world.addParticle(ParticleTypes_CM.AMMO_PT, this.getPosX() + d3 * (double)i / 4.0D, this.getPosY() + d4 * (double)i / 4.0D, this.getPosZ() + d0 * (double)i / 4.0D, -d3, -d4 + 0.2D, -d0);
				}
			}

			double d5 = this.getPosX() + d3;
			double d1 = this.getPosY() + d4;
			double d2 = this.getPosZ() + d0;
			float f1 = MathHelper.sqrt(horizontalMag(vec3d));

			if (flag) {
				this.rotationYaw = (float)(MathHelper.atan2(-d3, -d0) * (double)(180F / (float)Math.PI));
			}

			else {
				this.rotationYaw = (float)(MathHelper.atan2(d3, d0) * (double)(180F / (float)Math.PI));
			}

			for(this.rotationPitch = (float)(MathHelper.atan2(d4, (double)f1) * (double)(180F / (float)Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
				;
			}

			while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
				this.prevRotationPitch += 360.0F;
			}

			while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
				this.prevRotationYaw -= 360.0F;
			}

			while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
				this.prevRotationYaw += 360.0F;
			}

			this.rotationPitch = MathHelper.lerp(0.2F, this.prevRotationPitch, this.rotationPitch);
			this.rotationYaw = MathHelper.lerp(0.2F, this.prevRotationYaw, this.rotationYaw);
			float f2 = 0.99F;

			if (this.isInWater()) {
				for(int j = 0; j < 4; ++j) {
					this.world.addParticle(ParticleTypes.BUBBLE, d5 - d3 * 0.25D, d1 - d4 * 0.25D, d2 - d0 * 0.25D, d3, d4, d0);
				}
				f2 = this.getWaterDrag();
			}

			this.setMotion(vec3d.scale((double)f2));

			if (!this.hasNoGravity() && !flag) {
				Vec3d vec3d4 = this.getMotion();
				this.setMotion(vec3d4.x, vec3d4.y - (double)0.05F, vec3d4.z);
			}

			this.setPosition(d5, d1, d2);
			this.doBlockCollisions();
		}
	}

	protected void func_225516_i_() {
		++this.ticksInGround;
		if (this.ticksInGround >= 1200) {
			this.hitProcess();
			this.remove();
		}
	}

	/** Called when the arrow hits a block or an entity */
	protected void onHit(RayTraceResult result) {
		RayTraceResult.Type raytraceresult$type = result.getType();

		if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
			this.onEntityHit((EntityRayTraceResult)result); }

		else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)result;
			BlockState state = this.world.getBlockState(blockraytraceresult.getPos());
			this.inBlockState = state;
			Vec3d vec3d = blockraytraceresult.getHitVec().subtract(this.getPosX(), this.getPosY(), this.getPosZ());
			this.setMotion(vec3d);
			Vec3d vec3d1 = vec3d.normalize().scale((double)0.05F);
			this.setRawPosition(this.getPosX() - vec3d1.x, this.getPosY() - vec3d1.y, this.getPosZ() - vec3d1.z);
			this.playSound(this.getHitGroundSound(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
			this.inGround = true;
			this.arrowShake = 7;
			this.setIsCritical(false);
			this.setPierceLevel((byte)0);
			this.setHitSound(SoundEvents_CM.AM_IMPACT);
			this.setShotFromCrossbow(false);
			this.func_213870_w();
			state.onProjectileCollision(this.world, state, blockraytraceresult, this); }
	}

	private void func_213870_w() {
		if (this.hitEntities != null) {
			this.hitEntities.clear();
		}

		if (this.piercedEntities != null) {
			this.piercedEntities.clear();
		}
	}

	/** Called when the arrow hits an entity */
	protected void onEntityHit(EntityRayTraceResult result) {
		Entity entity = result.getEntity();
		float f = (float)this.getMotion().length();
		int i = MathHelper.ceil(Math.max((double)f * this.ammoDamage, 0.0D));

		if (this.getPierceLevel() > 0) {
			if (this.piercedEntities == null) {
				this.piercedEntities = new IntOpenHashSet(5);
			}

			if (this.hitEntities == null) {
				this.hitEntities = Lists.newArrayListWithCapacity(5);
			}

			if (this.piercedEntities.size() >= this.getPierceLevel() + 1) {
				this.hitProcess();
				this.remove();
				return;
			}

			this.piercedEntities.add(entity.getEntityId());
		}

		if (this.getIsCritical()) {
			i += this.rand.nextInt(i / 2 + 2);
		}

		Entity entity1 = this.getShooter();
		DamageSource damagesource;

		if (entity1 == null) {
			damagesource = DamageSource.causeThrownDamage(this, this);
		}

		else {
			damagesource = DamageSource.causeThrownDamage(this, entity1);

			if (entity1 instanceof LivingEntity) {
				((LivingEntity)entity1).setLastAttackedEntity(entity);
			}
		}

		boolean flag = entity.getType() == EntityType.ENDERMAN;
		int j = entity.getFireTimer();

		if (this.isBurning() && !flag) {
			entity.setFire(5);
		}

		if (entity.attackEntityFrom(damagesource, (float)i)) {
			if (flag) {
				return;
			}

			if (entity instanceof LivingEntity) {
				LivingEntity livingentity = (LivingEntity)entity;

				if (!this.world.isRemote && this.getPierceLevel() <= 0) {
					livingentity.setArrowCountInEntity(livingentity.getArrowCountInEntity() + 1);
				}

				if (this.knockbackStrength > 0) {
					Vec3d vec3d = this.getMotion().mul(1.0D, 0.0D, 1.0D).normalize().scale((double)this.knockbackStrength * 0.6D);
					if (vec3d.lengthSquared() > 0.0D) {
						livingentity.addVelocity(vec3d.x, 0.1D, vec3d.z);
					}
				}

				if (!this.world.isRemote && entity1 instanceof LivingEntity) {
					EnchantmentHelper.applyThornEnchantments(livingentity, entity1);
					EnchantmentHelper.applyArthropodEnchantments((LivingEntity)entity1, livingentity);
				}

				this.arrowHit(livingentity);
				if (entity1 != null && livingentity != entity1 && livingentity instanceof PlayerEntity && entity1 instanceof ServerPlayerEntity) {
					((ServerPlayerEntity)entity1).connection.sendPacket(new SChangeGameStatePacket(6, 0.0F));
				}

				if (!entity.isAlive() && this.hitEntities != null) {
					this.hitEntities.add(livingentity);
				}

				if (!this.world.isRemote && entity1 instanceof ServerPlayerEntity) {
					ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entity1;

					if (this.hitEntities != null && this.getShotFromCrossbow()) {
						CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayerentity, this.hitEntities, this.hitEntities.size());
					}

					else if (!entity.isAlive() && this.getShotFromCrossbow()) {
						CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayerentity, Arrays.asList(entity), 0);
					}
				}
			}

			this.playSound(this.hitSound, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

			if (this.getPierceLevel() <= 0) {
				this.hitProcess();
				this.remove();
			}
		}

		else {
			entity.setFireTimer(j);
			this.setMotion(this.getMotion().scale(-0.1D));
			this.rotationYaw += 180.0F;
			this.prevRotationYaw += 180.0F;
			this.ticksInAir = 0;

			if (!this.world.isRemote && this.getMotion().lengthSquared() < 1.0E-7D) {
				if (this.pickupStatus == AbstractAmmo_Entity.PickupStatus.ALLOWED) {
					this.entityDropItem(this.getArrowStack(), 0.1F); }
				
				this.hitProcess();
				this.remove();
			}
		}
	}

	/** The sound made when an entity is hit by this projectile */
	protected SoundEvent getHitEntitySound() {
		return SoundEvents_CM.AM_IMPACT;
	}

	protected final SoundEvent getHitGroundSound() {
		return this.hitSound;
	}

	protected void arrowHit(LivingEntity living) { }

	/** Gets the EntityRayTraceResult representing the entity hit */
	@Nullable
	protected EntityRayTraceResult rayTraceEntities(Vec3d startVec, Vec3d endVec) {
		return ProjectileHelper.rayTraceEntities(this.world, this, startVec, endVec, this.getBoundingBox().expand(this.getMotion()).grow(1.0D), (p_213871_1_) -> {
			return !p_213871_1_.isSpectator() && p_213871_1_.isAlive() && p_213871_1_.canBeCollidedWith() && (p_213871_1_ != this.getShooter() || this.ticksInAir >= 5) && (this.piercedEntities == null || !this.piercedEntities.contains(p_213871_1_.getEntityId()));
		});
	}

	@SuppressWarnings("deprecation")
	public void writeAdditional(CompoundNBT compound) {

		compound.putShort("life", (short)this.ticksInGround);
		if (this.inBlockState != null) {
			compound.put("inBlockState", NBTUtil.writeBlockState(this.inBlockState));
		}

		compound.putByte("shake", (byte)this.arrowShake);
		compound.putBoolean("inGround", this.inGround);
		compound.putByte("pickup", (byte)this.pickupStatus.ordinal());
		compound.putDouble("damage", this.ammoDamage);
		compound.putBoolean("crit", this.getIsCritical());
		compound.putByte("PierceLevel", this.getPierceLevel());

		if (this.shootingEntity != null) {
			compound.putUniqueId("OwnerUUID", this.shootingEntity);
		}

		compound.putString("SoundEvent", Registry.SOUND_EVENT.getKey(this.hitSound).toString());
		compound.putBoolean("ShotFromCrossbow", this.getShotFromCrossbow());
	}

	/** (abstract) Protected helper method to read subclass entity data from NBT. */
	@SuppressWarnings("deprecation")
	public void readAdditional(CompoundNBT compound) {
		this.ticksInGround = compound.getShort("life");
		if (compound.contains("inBlockState", 10)) {
			this.inBlockState = NBTUtil.readBlockState(compound.getCompound("inBlockState"));
		}

		this.arrowShake = compound.getByte("shake") & 255;
		this.inGround = compound.getBoolean("inGround");
		if (compound.contains("damage", 99)) {
			this.ammoDamage = compound.getDouble("damage");
		}

		if (compound.contains("pickup", 99)) {
			this.pickupStatus = AbstractAmmo_Entity.PickupStatus.getByOrdinal(compound.getByte("pickup"));
		}

		else if (compound.contains("player", 99)) {
			this.pickupStatus = compound.getBoolean("player") ? AbstractAmmo_Entity.PickupStatus.ALLOWED : AbstractAmmo_Entity.PickupStatus.DISALLOWED;
		}

		this.setIsCritical(compound.getBoolean("crit"));
		this.setPierceLevel(compound.getByte("PierceLevel"));
		if (compound.hasUniqueId("OwnerUUID")) {
			this.shootingEntity = compound.getUniqueId("OwnerUUID");
		}

		if (compound.contains("SoundEvent", 8)) {
			this.hitSound = Registry.SOUND_EVENT.getValue(new ResourceLocation(compound.getString("SoundEvent"))).orElse(this.getHitEntitySound());
		}

		this.setShotFromCrossbow(compound.getBoolean("ShotFromCrossbow"));
		}

	public void setShooter(@Nullable Entity entityIn) {
		this.shootingEntity = entityIn == null ? null : entityIn.getUniqueID();
		if (entityIn instanceof PlayerEntity) {
			this.pickupStatus = ((PlayerEntity)entityIn).abilities.isCreativeMode ? AbstractAmmo_Entity.PickupStatus.CREATIVE_ONLY : AbstractAmmo_Entity.PickupStatus.ALLOWED;
		}
	}

	@Nullable
	public Entity getShooter() {
		return this.shootingEntity != null && this.world instanceof ServerWorld ? ((ServerWorld)this.world).getEntityByUuid(this.shootingEntity) : null;
	}

	/** Called by a player entity when they collide with an entity */
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		if (!this.world.isRemote && (this.inGround || this.getNoClip()) && this.arrowShake <= 0) {
			boolean flag = this.pickupStatus == AbstractAmmo_Entity.PickupStatus.ALLOWED || this.pickupStatus == AbstractAmmo_Entity.PickupStatus.CREATIVE_ONLY && entityIn.abilities.isCreativeMode || this.getNoClip() && this.getShooter().getUniqueID() == entityIn.getUniqueID();
			if (this.pickupStatus == AbstractAmmo_Entity.PickupStatus.ALLOWED && !entityIn.inventory.addItemStackToInventory(this.getArrowStack())) {
				flag = false;
			}

			if (flag) {
				entityIn.onItemPickup(this, 1);
				this.remove();
			}
		}
	}

	protected abstract ItemStack getArrowStack();

	protected boolean canTriggerWalking() {
		return false;
	}

	public void setDamage(double damage) {
		this.ammoDamage = damage;
	}

	public double getDamage() {
		return this.ammoDamage;
	}

	/** Sets the amount of knockback the arrow applies when it hits a mob. */
	public void setKnockbackStrength(int knockbackStrengthIn) {
		this.knockbackStrength = knockbackStrengthIn;
	}

	/** Returns true if it's possible to attack this entity with an item. */
	public boolean canBeAttackedWithItem() {
		return false;
	}

	protected float getEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 0.0F;
	}

	/** Whether the arrow has a stream of critical hit particles flying behind it. */
	public void setIsCritical(boolean critical) {
		this.setArrowFlag(1, critical);
	}

	public void setPierceLevel(byte level) {
		this.dataManager.set(PIERCE_LEVEL, level);
	}

	private void setArrowFlag(int i, boolean flag) {
		byte b0 = this.dataManager.get(CRITICAL);
		if (flag) {
			this.dataManager.set(CRITICAL, (byte)(b0 | i));
		}
		else {
			this.dataManager.set(CRITICAL, (byte)(b0 & ~i));
		}
	}

	/** Whether the arrow has a stream of critical hit particles flying behind it. */
	public boolean getIsCritical() {
		byte b0 = this.dataManager.get(CRITICAL);
		return (b0 & 1) != 0;
	}

	/** Whether the arrow was shot from a crossbow. */
	public boolean getShotFromCrossbow() {
		byte b0 = this.dataManager.get(CRITICAL);
		return (b0 & 4) != 0;
	}

	public byte getPierceLevel() {
		return this.dataManager.get(PIERCE_LEVEL);
	}

	public void setEnchantmentEffectsFromEntity(LivingEntity entityIn, float f) {
		int i = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, entityIn);
		int j = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, entityIn);
		this.setDamage((double)(f * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.world.getDifficulty().getId() * 0.11F));
		if (i > 0) {
			this.setDamage(this.getDamage() + (double)i * 0.5D + 0.5D);
		}

		if (j > 0) {
			this.setKnockbackStrength(j);
		}

		if (EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FLAME, entityIn) > 0) {
			this.setFire(100);
		}
	}

	protected float getWaterDrag() {
		return 0.6F;
	}

	/** Sets if this arrow can noClip */
	public void setNoClip(boolean noClipIn) {
		this.noClip = noClipIn;
		this.setArrowFlag(2, noClipIn);
	}

	/** Whether the arrow can noClip */
	public boolean getNoClip() {
		if (!this.world.isRemote) {
			return this.noClip;
		}

		else {
			return (this.dataManager.get(CRITICAL) & 2) != 0;
		}
	}

	/** Sets data about if this arrow entity was shot from a crossbow */
	public void setShotFromCrossbow(boolean fromCrossbow) {
		this.setArrowFlag(4, fromCrossbow);
	}

	public IPacket<?> createSpawnPacket() {
		Entity entity = this.getShooter();
		return new SSpawnObjectPacket(this, entity == null ? 0 : entity.getEntityId());
	}

	public static enum PickupStatus {
		DISALLOWED,
		ALLOWED,
		CREATIVE_ONLY;

		public static AbstractAmmo_Entity.PickupStatus getByOrdinal(int ordinal) {

			if (ordinal < 0 || ordinal > values().length) {
				ordinal = 0;
			}
			return values()[ordinal];
		}
	}

	/* Overwrite in each case. -> */
	public void hitProcess() { }
	
	public Explosion_CM createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		return this.explode(entityIn, (DamageSource)null, xIn, yIn, zIn, value, flag, modeIn);
	}

	public Explosion_CM explode(@Nullable Entity entityIn, @Nullable DamageSource damage, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		Explosion_CM explosion = new Explosion_CM(world, this, xIn, yIn, zIn, value, flag, modeIn);
		explosion.doExplosionA();
		explosion.doExplosionB(true);
		return explosion;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for(int i = 0; i < 4; ++i) {
				this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D); }
		}
	}
}
