package com.ayutaki.chinjufumod.entity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Weak_Explosion extends Explosion {
	
	private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new ExplosionDamageCalculator();
	@SuppressWarnings("unused")
	private static final int MAX_DROPS_PER_COMBINED_STACK = 16;
	private final boolean fire;
	private final Explosion.BlockInteraction blockInteraction;
	private final Random random = new Random();
	private final Level level;
	private final double x;
	private final double y;
	private final double z;
	@Nullable
	private final Entity source;
	private final float radius;
	private final DamageSource damageSource;
	private final ExplosionDamageCalculator damageCalculator;
	private final List<BlockPos> toBlow = Lists.newArrayList();
	private final Map<Player, Vec3> hitPlayers = Maps.newHashMap();
	private final Vec3 position;

	public Weak_Explosion(Level worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn) {
		this(worldIn, entityIn, xIn, yIn, zIn, sizeIn, false, Explosion.BlockInteraction.DESTROY);
	}

	public Weak_Explosion(Level worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn, List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, xIn, yIn, zIn, sizeIn, false, Explosion.BlockInteraction.DESTROY, affectedPositions);
	}

	public Weak_Explosion(Level worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn, boolean fireIn, Explosion.BlockInteraction mode, List<BlockPos> p_46049_) {
		this(worldIn, entityIn, xIn, yIn, zIn, sizeIn, fireIn, mode);
		this.toBlow.addAll(p_46049_);
	}

	public Weak_Explosion(Level worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn, boolean fireIn, Explosion.BlockInteraction mode) {
		this(worldIn, entityIn, (DamageSource)null, (ExplosionDamageCalculator)null, xIn, yIn, zIn, sizeIn, fireIn, mode);
	}

	public Weak_Explosion(Level worldIn, @Nullable Entity entityIn, @Nullable DamageSource source, @Nullable ExplosionDamageCalculator context, double xIn, double yIn, double zIn, float sizeIn, boolean fireIn, Explosion.BlockInteraction mode) {
		super(worldIn, entityIn, source, context, xIn, yIn,zIn, sizeIn, fireIn, mode); //must
		this.level = worldIn;
		this.source = entityIn;
		this.radius = sizeIn;
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
		this.fire = fireIn;
		this.blockInteraction = mode;
		this.damageSource = source == null ? DamageSource.explosion(this) : source;
		this.damageCalculator = context == null ? this.makeDamageCalculator(entityIn) : context;
		this.position = new Vec3(this.x, this.y, this.z);
 }

	private ExplosionDamageCalculator makeDamageCalculator(@Nullable Entity entityIn) {
		return (ExplosionDamageCalculator)(entityIn == null ? EXPLOSION_DAMAGE_CALCULATOR : new EntityBasedExplosionDamageCalculator(entityIn));
	}

	public static float getSeenPercent(Vec3 vec, Entity entityIn) {
		AABB aabb = entityIn.getBoundingBox();
		double d0 = 1.0D / ((aabb.maxX - aabb.minX) * 2.0D + 1.0D);
		double d1 = 1.0D / ((aabb.maxY - aabb.minY) * 2.0D + 1.0D);
		double d2 = 1.0D / ((aabb.maxZ - aabb.minZ) * 2.0D + 1.0D);
		double d3 = (1.0D - Math.floor(1.0D / d0) * d0) / 2.0D;
		double d4 = (1.0D - Math.floor(1.0D / d2) * d2) / 2.0D;
		if (!(d0 < 0.0D) && !(d1 < 0.0D) && !(d2 < 0.0D)) {
			int i = 0;
			int j = 0;

			for(float f = 0.0F; f <= 1.0F; f = (float)((double)f + d0)) {
				for(float f1 = 0.0F; f1 <= 1.0F; f1 = (float)((double)f1 + d1)) {
					for(float f2 = 0.0F; f2 <= 1.0F; f2 = (float)((double)f2 + d2)) {
						double d5 = Mth.lerp((double)f, aabb.minX, aabb.maxX);
						double d6 = Mth.lerp((double)f1, aabb.minY, aabb.maxY);
						double d7 = Mth.lerp((double)f2, aabb.minZ, aabb.maxZ);
						Vec3 vec3 = new Vec3(d5 + d3, d6, d7 + d4);
						if (entityIn.level.clip(new ClipContext(vec3, vec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entityIn)).getType() == HitResult.Type.MISS) {
							++i;
						}

						++j;
					}
				}
			}

			return (float)i / (float)j;
		} else {
			return 0.0F;
		}
	}

	/* ブロックの破壊に関する設定
	 * Does the first part of the explosion (destroy blocks) */
	@SuppressWarnings("unused")
	public void explode() {
		this.level.gameEvent(this.source, GameEvent.EXPLODE, new BlockPos(this.x, this.y, this.z));
		Set<BlockPos> set = Sets.newHashSet();
		//int i = 16;

		for(int j = 0; j < 16; ++j) {
			for(int k = 0; k < 16; ++k) {
				for(int l = 0; l < 16; ++l) {
					if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
						double d0 = (double)((float)j / 15.0F * 2.0F - 1.0F);
						double d1 = (double)((float)k / 15.0F * 2.0F - 1.0F);
						double d2 = (double)((float)l / 15.0F * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 /= d3;
						d1 /= d3;
						d2 /= d3;
						float f = this.radius * (0.7F + this.level.random.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;

						for(float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos pos = new BlockPos(d4, d6, d8);
							BlockState state = this.level.getBlockState(pos);
							FluidState fluidstate = this.level.getFluidState(pos);
							if (!this.level.isInWorldBounds(pos)) {
								break;
							}

							Optional<Float> optional = this.damageCalculator.getBlockExplosionResistance(this, this.level, pos, state, fluidstate);
							if (optional.isPresent()) {
								f -= (optional.get() + 0.3F) * 0.3F;
							}

							if (f > 0.0F && this.damageCalculator.shouldBlockExplode(this, this.level, pos, state, f)) {
								set.add(pos);
							}

							d4 += d0 * (double)0.3F;
							d6 += d1 * (double)0.3F;
							d8 += d2 * (double)0.3F;
						}
					}
				}
			}
		}

		/* 爆発の影響を受ける範囲 */
		this.toBlow.addAll(set);
		float f2 = this.radius * 2.0F;
		int k1 = Mth.floor(this.x - (double)f2 - 1.0D);
		int l1 = Mth.floor(this.x + (double)f2 + 1.0D);
		int i2 = Mth.floor(this.y - (double)f2 - 1.0D);
		int i1 = Mth.floor(this.y + (double)f2 + 1.0D);
		int j2 = Mth.floor(this.z - (double)f2 - 1.0D);
		int j1 = Mth.floor(this.z + (double)f2 + 1.0D);
		List<Entity> list = this.level.getEntities(this.source, new AABB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.level, this, list, f2);
		Vec3 vec3 = new Vec3(this.x, this.y, this.z);

		/* 爆破サイズに応じて、爆破範囲内のエンティティにダメージを与える */
		for(int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			
			/* 爆発への免疫、爆心からの距離に応じてダメージ判定 */
			if (!entity.ignoreExplosion()) {
				double d12 = Math.sqrt(entity.distanceToSqr(vec3)) / (double)f2;
				
				/** 爆心に近いときはダメージ判定を行う **/
				if (d12 <= 1.0D) {
					double d5 = entity.getX() - this.x;
					double d7 = (entity instanceof PrimedTnt ? entity.getY() : entity.getEyeY()) - this.y;
					double d9 = entity.getZ() - this.z;
					double d13 = Math.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
					if (d13 != 0.0D) {
						d5 /= d13;
						d7 /= d13;
						d9 /= d13;
						double d14 = (double)getSeenPercent(vec3, entity);
						double d10 = (1.0D - d12) * d14;
						entity.hurt(this.getDamageSource(), (float)1.0F);
						double d11 = d10;
						
						/* 爆破耐性のエンチャントに対する処理 */
						if (entity instanceof LivingEntity) {
							d11 = ProtectionEnchantment.getExplosionKnockbackAfterDampener((LivingEntity)entity, d10);
						}

						/* 爆風による吹き飛び 上への吹き飛びを0.1倍 */
						entity.setDeltaMovement(entity.getDeltaMovement().add(d5 * d11, d7 * d11 * 0.1, d9 * d11));
						
						if (entity instanceof Player) {
							Player player = (Player)entity;
							if (!player.isSpectator() && (!player.isCreative() || !player.getAbilities().flying)) {
								this.hitPlayers.put(player, new Vec3(d5 * d10, d7 * d10 * 0.1, d9 * d10));
							}
						} //PlayerEntity
					}
				}
			}
		}
	}

	/* 音やパーティクルの設定
	 * Does the second part of the explosion (sound, particles, drop spawn) */
	public void finalizeExplosion(boolean spawnParticles) {

		/** パーティクルの設定 -> 弾Entityへ **/
		
		/** ブロックの破壊 **/
		boolean flag = this.blockInteraction != Explosion.BlockInteraction.NONE;
		if (flag) {
			ObjectArrayList<Pair<ItemStack, BlockPos>> objectarraylist = new ObjectArrayList<>();
			Collections.shuffle(this.toBlow, this.level.random);

			for(BlockPos pos : this.toBlow) {
				BlockState state = this.level.getBlockState(pos);
				//Block block = state.getBlock();
				if (!state.isAir()) {
					BlockPos pos1 = pos.immutable();
					this.level.getProfiler().push("explosion_blocks");
					if (state.canDropFromExplosion(this.level, pos, this) && this.level instanceof ServerLevel) {
						BlockEntity blockentity = state.hasBlockEntity() ? this.level.getBlockEntity(pos) : null;
						LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerLevel)this.level)).withRandom(this.level.random).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, ItemStack.EMPTY).withOptionalParameter(LootContextParams.BLOCK_ENTITY, blockentity).withOptionalParameter(LootContextParams.THIS_ENTITY, this.source);
						if (this.blockInteraction == Explosion.BlockInteraction.DESTROY) {
							lootcontext$builder.withParameter(LootContextParams.EXPLOSION_RADIUS, this.radius);
						}

						state.getDrops(lootcontext$builder).forEach((p_46074_) -> {
							addBlockDrops(objectarraylist, p_46074_, pos1);
						});
					}

					state.onBlockExploded(this.level, pos, this);
					this.level.getProfiler().pop();
				}
			}

			for(Pair<ItemStack, BlockPos> pair : objectarraylist) {
				Block.popResource(this.level, pair.getSecond(), pair.getFirst());
			}
		}

		/** 炎上をともなう爆発 **/
		if (this.fire) {
			for(BlockPos pos2 : this.toBlow) {
				if (this.random.nextInt(3) == 0 && this.level.getBlockState(pos2).isAir() && this.level.getBlockState(pos2.below()).isSolidRender(this.level, pos2.below())) {
					this.level.setBlockAndUpdate(pos2, BaseFireBlock.getState(this.level, pos2));
				}
			}
		}

	}

	private static void addBlockDrops(ObjectArrayList<Pair<ItemStack, BlockPos>> object, ItemStack stack, BlockPos pos) {
		int i = object.size();

		for(int j = 0; j < i; ++j) {
			Pair<ItemStack, BlockPos> pair = object.get(j);
			ItemStack pairStack = pair.getFirst();
			if (ItemEntity.areMergable(pairStack, stack)) {
				ItemStack pairStack1 = ItemEntity.merge(pairStack, stack, 16);
				object.set(j, Pair.of(pairStack1, pair.getSecond()));
				if (stack.isEmpty()) {
					return;
				}
			}
		}

		object.add(Pair.of(stack, pos));
	}

	public DamageSource getDamageSource() {
		return this.damageSource;
	}

	public Map<Player, Vec3> getHitPlayers() {
		return this.hitPlayers;
	}

	/*爆発ブロックを配置したエンティティ、爆発の原因となったエンティティ、またはnullを返す
	 * Returns either the entity that placed the explosive block, the entity that caused the explosion or null. */
	@Nullable
	public LivingEntity getSourceMob() {
		if (this.source == null) {
			return null;
		} else if (this.source instanceof PrimedTnt) {
			return ((PrimedTnt)this.source).getOwner();
		} else if (this.source instanceof LivingEntity) {
			return (LivingEntity)this.source;
		} else {
			if (this.source instanceof Projectile) {
				Entity entity = ((Projectile)this.source).getOwner();
				if (entity instanceof LivingEntity) {
					return (LivingEntity)entity;
				}
			}

			return null;
		}
	}

	public void clearToBlow() {
		this.toBlow.clear();
	}

	public List<BlockPos> getToBlow() {
		return this.toBlow;
	}

	public Vec3 getPosition() {
		return this.position;
	}

	@Nullable
	public Entity getExploder() {
		return this.source;
	}

	public static enum BlockInteraction {
		NONE,
		BREAK,
		DESTROY;
	}
}
