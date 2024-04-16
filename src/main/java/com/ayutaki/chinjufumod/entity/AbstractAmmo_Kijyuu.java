package com.ayutaki.chinjufumod.entity;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractAmmo_Kijyuu extends AbstractArrow {

	private static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(AbstractAmmo_Kijyuu.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Byte> PIERCE_LEVEL = SynchedEntityData.defineId(AbstractAmmo_Kijyuu.class, EntityDataSerializers.BYTE);

	@Nullable
	private BlockState lastState;
	protected boolean inGround;
	protected int inGroundTime;
	public AbstractAmmo_Kijyuu.Pickup pickup = AbstractAmmo_Kijyuu.Pickup.DISALLOWED;
	public int shakeTime;
	private int life;
	private double ammoDamage = 1.0D; /***/
	private int knockback;
	private SoundEvent soundEvent = this.getDefaultHitGroundSoundEvent();
	@Nullable
	private IntOpenHashSet piercingIgnoreEntityIds;
	@Nullable
	private List<Entity> piercedAndKilledEntities;
	
	@SuppressWarnings("unused")
	private Entity cachedOwner; /**/
	private boolean leftOwner; /**/
	private boolean hasBeenShot; /**/
	
	protected AbstractAmmo_Kijyuu(EntityType<? extends AbstractArrow> type, Level worldIn) {
		super(type, worldIn);
	}

	protected AbstractAmmo_Kijyuu(EntityType<? extends AbstractArrow> type, double x, double y, double z, Level worldIn) {
		this(type, worldIn);
		this.setPos(x, y, z);
	}

	protected AbstractAmmo_Kijyuu(EntityType<? extends AbstractArrow> type, LivingEntity shooter, Level worldIn) {
		this(type, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
		this.setOwner(shooter);
		if (shooter instanceof Player) {
			this.pickup = AbstractAmmo_Kijyuu.Pickup.ALLOWED;
		}
	}
	
	@Override
	public void setSoundEvent(SoundEvent soundIn) {
		this.soundEvent = soundIn;
	}
	
	/*@Override //@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double distance) {
		double d0 = this.getBoundingBox().getSize() * 10.0D;
		if (Double.isNaN(d0)) {
			d0 = 1.0D;
		}

		d0 = d0 * 64.0D * getViewScale();
		return distance < d0 * d0;
	} */
	
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
	
	public void tick() {
		// super.tick(); **
		if (!this.hasBeenShot) {
			this.gameEvent(GameEvent.PROJECTILE_SHOOT, this.getOwner()); // 1.18->1.20
			 this.hasBeenShot = true; } /**/
		if (!this.leftOwner) { this.leftOwner = this.checkLeftOwner(); } /**/
		
		boolean flag = this.isNoPhysics();
		Vec3 vec3 = this.getDeltaMovement();
		if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
			double d0 = vec3.horizontalDistance();
			this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * (double)(180F / (float)Math.PI)));
			this.setXRot((float)(Mth.atan2(vec3.y, d0) * (double)(180F / (float)Math.PI)));
			this.yRotO = this.getYRot();
			this.xRotO = this.getXRot();
		}

		BlockPos pos = this.blockPosition();
		BlockState state = this.level().getBlockState(pos);
		if (!state.isAir() && !flag) {
			VoxelShape voxelshape = state.getCollisionShape(this.level(), pos);
			if (!voxelshape.isEmpty()) {
				Vec3 vec31 = this.position();

				for(AABB aabb : voxelshape.toAabbs()) {
					if (aabb.move(pos).contains(vec31)) {
						this.inGround = true;
						break;
					}
				}
			}
		}

		if (this.shakeTime > 0) {
			--this.shakeTime;
		}

		if (this.isInWaterOrRain() || state.is(Blocks.POWDER_SNOW)) {
			this.clearFire();
		}

		/** inGround remove **/
		if (this.inGround && !flag) {
			this.level().broadcastEntityEvent(this, (byte)3); /***/
			this.discard();
		} 
		
		else {
			this.inGroundTime = 0;
			Vec3 vec32 = this.position();
			Vec3 vec33 = vec32.add(vec3);
			HitResult hitresult = this.level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
			if (hitresult.getType() != HitResult.Type.MISS) {
				vec33 = hitresult.getLocation();
			}

			while(!this.isRemoved()) {
				EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
				if (entityhitresult != null) {
					hitresult = entityhitresult;
				}

				if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
					Entity entity = ((EntityHitResult)hitresult).getEntity();
					Entity entity1 = this.getOwner();
					if (entity instanceof Player && entity1 instanceof Player && !((Player)entity1).canHarmPlayer((Player)entity)) {
						hitresult = null;
						entityhitresult = null;
					}
				}

				if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !flag && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
					this.onHit(hitresult);
					this.hasImpulse = true;
				}

				if (entityhitresult == null || this.getPierceLevel() <= 0) {
					break;
				}

				hitresult = null;
			}

			vec3 = this.getDeltaMovement();
			double d5 = vec3.x;
			double d6 = vec3.y;
			double d1 = vec3.z;
			/* addParticle */

			double d7 = this.getX() + d5;
			double d2 = this.getY() + d6;
			double d3 = this.getZ() + d1;
			double d4 = vec3.horizontalDistance();
			if (flag) {
				this.setYRot((float)(Mth.atan2(-d5, -d1) * (double)(180F / (float)Math.PI)));
			} else {
				this.setYRot((float)(Mth.atan2(d5, d1) * (double)(180F / (float)Math.PI)));
			}

			this.setXRot((float)(Mth.atan2(d6, d4) * (double)(180F / (float)Math.PI)));
			this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
			this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
			float f = 0.99F;
			
			if (this.isInWater()) {
				for(int j = 0; j < 4; ++j) {
					this.level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * 0.25D, d2 - d6 * 0.25D, d3 - d1 * 0.25D, d5, d6, d1);
				}
				f = this.getWaterInertia();
			}

			this.setDeltaMovement(vec3.scale((double)f));
			if (!this.isNoGravity() && !flag) {
				Vec3 vec34 = this.getDeltaMovement();
				this.setDeltaMovement(vec34.x, vec34.y - (double)0.05F, vec34.z);
			}

			this.setPos(d7, d2, d3);
			this.checkInsideBlocks();
		}
	}
	
	@SuppressWarnings("resource")
	private boolean checkLeftOwner() {
		Entity entity = this.getOwner();
		if (entity != null) {
			for(Entity entity1 : this.level().getEntities(this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), (entity0) -> {
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
		return this.inGround && this.level().noCollision((new AABB(this.position(), this.position())).inflate(0.06D));
	}

	private void startFalling() {
		this.inGround = false;
		Vec3 vec3 = this.getDeltaMovement();
		this.setDeltaMovement(vec3.multiply((double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F)));
		this.life = 0;
	}
		
	@Override
	public void move(MoverType mover, Vec3 vector3d) {
		super.move(mover, vector3d);
		if (mover != MoverType.SELF && this.shouldFall()) {
			this.startFalling();
		}
	}
	
	@Override
	protected void tickDespawn() {
		++this.life;
		if (this.life >= 1000) {
			this.level().broadcastEntityEvent(this, (byte)3); /***/
			this.discard();
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
	
	@SuppressWarnings("resource")
	@Override
	protected void onHitEntity(EntityHitResult result) {
		// super.onHitEntity(result); Don't refer to arrow.
		Entity entity = result.getEntity();
		float f = (float)this.getDeltaMovement().length();
		int i = Mth.ceil(Mth.clamp((double)f * this.ammoDamage, 0.0D, 2.147483647E9D));
		if (this.getPierceLevel() > 0) {
			if (this.piercingIgnoreEntityIds == null) {
				this.piercingIgnoreEntityIds = new IntOpenHashSet(5);
			}

			if (this.piercedAndKilledEntities == null) {
				this.piercedAndKilledEntities = Lists.newArrayListWithCapacity(5);
			}

			if (this.piercingIgnoreEntityIds.size() >= this.getPierceLevel() + 1) {
				this.discard();
				return;
			}

			this.piercingIgnoreEntityIds.add(entity.getId());
		}

		if (this.isCritArrow()) {
			long j = (long)this.random.nextInt(i / 2 + 2);
			i = (int)Math.min(j + (long)i, 2147483647L);
		}

		Entity owner = this.getOwner();
		DamageSource damagesource;
		if (owner == null) {
			damagesource = this.damageSources().thrown(this, this); // 1.18->1.20
		} else {
			damagesource = this.damageSources().thrown(this, owner); // 1.18->1.20
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
				if (!this.level().isClientSide && this.getPierceLevel() <= 0) {
					livingentity.setArrowCount(livingentity.getArrowCount() + 1);
				}

				if (this.knockback > 0) {
					Vec3 vec3 = this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D).normalize().scale((double)this.knockback* 0.6D);
					if (vec3.lengthSqr() > 0.0D) {
						livingentity.push(vec3.x, 0.1D, vec3.z);
					}
				}

				if (!this.level().isClientSide && owner instanceof LivingEntity) {
					EnchantmentHelper.doPostHurtEffects(livingentity, owner);
					EnchantmentHelper.doPostDamageEffects((LivingEntity)owner, livingentity);
				}

				this.doPostHurtEffects(livingentity);
				if (owner != null && livingentity != owner && livingentity instanceof Player && owner instanceof ServerPlayer && !this.isSilent()) {
					((ServerPlayer)owner).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
				}

				if (!entity.isAlive() && this.piercedAndKilledEntities != null) {
					this.piercedAndKilledEntities.add(livingentity);
				}
			}

			this.playSound(this.soundEvent, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
			if (this.getPierceLevel() <= 0) {
				this.discard();
			}
		}

		else {
			entity.setRemainingFireTicks(k);
			this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
			this.setYRot(this.getYRot() + 180.0F);
			this.yRotO += 180.0F;
			if (!this.level().isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
				if (this.pickup == AbstractAmmo_Kijyuu.Pickup.ALLOWED) {
					this.spawnAtLocation(this.getPickupItem(), 0.1F);
				}
				this.discard();
			}
		}
	}
	
	@Override
	protected void onHitBlock(BlockHitResult result) {
		this.lastState = this.level().getBlockState(result.getBlockPos());
		super.onHitBlock(result);
		Vec3 vec3 = result.getLocation().subtract(this.getX(), this.getY(), this.getZ());
		this.setDeltaMovement(vec3);
		Vec3 vec31 = vec3.normalize().scale((double)0.05F);
		this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
		this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
		this.inGround = true;
		this.shakeTime = 7;
		this.setCritArrow(false);
		this.setPierceLevel((byte)0);
		this.setSoundEvent(SoundEvents_CM.AM_HIT.get());
		this.setShotFromCrossbow(false);
		this.resetPiercedEntities();
	}
	
	@Override
	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents_CM.AM_HIT.get();
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) { }

	@Nullable
	protected EntityHitResult findHitEntity(Vec3 vec3_1, Vec3 vec3_2) {
		return ProjectileUtil.getEntityHitResult(this.level(), this, vec3_1, vec3_2, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), this::canHitEntity);
	}
	
	@Override
	protected boolean canHitEntity(Entity entity) {
		return super.canHitEntity(entity) && (this.piercingIgnoreEntityIds == null || !this.piercingIgnoreEntityIds.contains(entity.getId()));
	}
	
	@SuppressWarnings("deprecation")
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putShort("life", (short)this.life);
		if (this.lastState != null) {
			compound.put("inBlockState", NbtUtils.writeBlockState(this.lastState));
		}

		compound.putByte("shake", (byte)this.shakeTime);
		compound.putBoolean("inGround", this.inGround);
		compound.putByte("pickup", (byte)this.pickup.ordinal());
		compound.putDouble("damage", this.ammoDamage);
		compound.putBoolean("crit", this.isCritArrow());
		compound.putByte("PierceLevel", this.getPierceLevel());
		compound.putString("SoundEvent", BuiltInRegistries.SOUND_EVENT.getKey(this.soundEvent).toString()); // 1.18->1.20
		compound.putBoolean("ShotFromCrossbow", this.shotFromCrossbow());
	}
	
	@SuppressWarnings("deprecation")
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.life = compound.getShort("life");
		if (compound.contains("inBlockState", 10)) {
			this.lastState = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compound.getCompound("inBlockState")); // 1.18->1.20
		}

		this.shakeTime = compound.getByte("shake") & 255;
		this.inGround = compound.getBoolean("inGround");
		if (compound.contains("damage", 99)) {
			this.ammoDamage = compound.getDouble("damage");
		}

		this.pickup = AbstractAmmo_Kijyuu.Pickup.byOrdinal(compound.getByte("pickup"));
		this.setCritArrow(compound.getBoolean("crit"));
		this.setPierceLevel(compound.getByte("PierceLevel"));
		if (compound.contains("SoundEvent", 8)) {
			this.soundEvent = BuiltInRegistries.SOUND_EVENT.getOptional(new ResourceLocation(compound.getString("SoundEvent"))).orElse(this.getDefaultHitGroundSoundEvent());
		} // 1.18->1.20

		this.setShotFromCrossbow(compound.getBoolean("ShotFromCrossbow"));
	}
	
	@Override
	public void setOwner(@Nullable Entity entity) {
		super.setOwner(entity);
		if (entity instanceof Player) {
			this.pickup = ((Player)entity).getAbilities().instabuild ? AbstractAmmo_Kijyuu.Pickup.CREATIVE_ONLY : AbstractAmmo_Kijyuu.Pickup.ALLOWED;
		}
	}
	
	@SuppressWarnings("resource")
	public void playerTouch(Player entity) {
		if (!this.level().isClientSide && (this.inGround || this.isNoPhysics()) && this.shakeTime <= 0) {
			if (this.tryPickup(entity)) {
				entity.take(this, 1);
				this.discard();
			}
		}
	}
	
	protected abstract ItemStack getPickupItem();
	
	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
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
	protected float getEyeHeight(Pose pos, EntityDimensions size) {
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
		if (flag) {
			this.entityData.set(ID_FLAGS, (byte)(b0 | value));
		} else {
			this.entityData.set(ID_FLAGS, (byte)(b0 & ~value));
		}
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
		this.setBaseDamage((double)(value * 2.0F) + this.random.nextGaussian() * 0.25D + (double)((float)this.level().getDifficulty().getId() * 0.11F));
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
	public void setNoPhysics(boolean tf) {
		this.noPhysics = tf;
		this.setFlag(2, tf);
	}
	
	@Override
	public boolean isNoPhysics() {
		if (!this.level().isClientSide) {
			return this.noPhysics;
		} else {
			return (this.entityData.get(ID_FLAGS) & 2) != 0;
		}
	}

	@Override
	public void setShotFromCrossbow(boolean tf) {
		this.setFlag(4, tf);
	}
	
	/* Flying render 1.18->1.20 */
	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		Entity entity = this.getOwner();
		return new ClientboundAddEntityPacket(this, entity == null ? 0 : entity.getId());
	}
	
	public static enum Pickup {
		DISALLOWED,
		ALLOWED,
		CREATIVE_ONLY;

		public static AbstractAmmo_Kijyuu.Pickup byOrdinal(int value) {
			if (value < 0 || value > values().length) {
				value = 0; }

			return values()[value];
		}
	}
	
	/*** from Snow ball */
	@OnlyIn(Dist.CLIENT)
	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			this.level().addParticle((ParticleOptions) ParticleTypes_CM.MARK_PT.get(), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D); }
	}
}
