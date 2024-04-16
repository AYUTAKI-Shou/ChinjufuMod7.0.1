package com.ayutaki.chinjufumod.entity;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Weak_Explosion extends Explosion {

	@SuppressWarnings("unused")
	private final boolean causesFire;
	@SuppressWarnings("unused")
	private final Explosion.Mode mode;
	@SuppressWarnings("unused")
	private final Random random = new Random();
	private final World world;
	private final double x;
	private final double y;
	private final double z;
	@Nullable
	private final Entity exploder;
	private final float size;
	private DamageSource damageSource;
	private final List<BlockPos> affectedBlockPositions = Lists.newArrayList();
	private final Map<PlayerEntity, Vec3d> playerKnockbackMap = Maps.newHashMap();
	private final Vec3d position;

	@OnlyIn(Dist.CLIENT)
	public Weak_Explosion(World worldIn, @Nullable Entity entityIn, double x, double y, double z, float size, List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, x, y, z, size, false, Explosion.Mode.DESTROY, affectedPositions);
	}

	@OnlyIn(Dist.CLIENT)
	public Weak_Explosion(World worldIn, @Nullable Entity exploderIn, double xIn, double yIn, double zIn, float sizeIn, boolean causesFireIn, Explosion.Mode modeIn, List<BlockPos> affectedBlockPositionsIn) {
		this(worldIn, exploderIn, xIn, yIn, zIn, sizeIn, causesFireIn, modeIn);
		this.affectedBlockPositions.addAll(affectedBlockPositionsIn);
	}

	public Weak_Explosion(World worldIn, @Nullable Entity exploderIn, double xIn, double yIn, double zIn, float sizeIn, boolean causesFireIn, Explosion.Mode modeIn) {
		super(worldIn, exploderIn, zIn, zIn, zIn, sizeIn, causesFireIn, modeIn);
		this.world = worldIn;
		this.exploder = exploderIn;
		this.size = sizeIn;
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
		this.causesFire = causesFireIn;
		this.mode = modeIn;
		this.damageSource = DamageSource.causeExplosionDamage(this);
		this.position = new Vec3d(this.x, this.y, this.z);
	}

	/* ブロックの破壊に関する設定
	 * Does the first part of the explosion (destroy blocks) */
	public void doExplosionA() {
		Set<BlockPos> set = Sets.newHashSet();
		int i = 16;

		for(int j = 0; j < i; ++j) {
			for(int k = 0; k < i; ++k) {
				for(int l = 0; l < i; ++l) {
					if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
						double d0 = (double)((float)j / 15.0F * 2.0F - 1.0F);
						double d1 = (double)((float)k / 15.0F * 2.0F - 1.0F);
						double d2 = (double)((float)l / 15.0F * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						float f = this.size * (0.7F + this.world.rand.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;

						for(float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos pos = new BlockPos(d4, d6, d8);
							BlockState state = this.world.getBlockState(pos);
							IFluidState ifluidstate = this.world.getFluidState(pos);
							if (!state.isAir(this.world, pos) || !ifluidstate.isEmpty()) {
								float f2 = Math.max(state.getExplosionResistance(this.world, pos, exploder, this), ifluidstate.getExplosionResistance(this.world, pos, exploder, this));
								if (this.exploder != null) {
									f2 = this.exploder.getExplosionResistance(this, this.world, pos, state, ifluidstate, f2);
								}

								f -= (f2 + f1) * f1;
							}

							if (f > 0.0F && (this.exploder == null || this.exploder.canExplosionDestroyBlock(this, this.world, pos, state, f))) {
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
		this.affectedBlockPositions.addAll(set);
		float f3 = this.size * 2.0F;
		int k1 = MathHelper.floor(this.x - (double)f3 - 1.0D);
		int l1 = MathHelper.floor(this.x + (double)f3 + 1.0D);
		int i2 = MathHelper.floor(this.y - (double)f3 - 1.0D);
		int i1 = MathHelper.floor(this.y + (double)f3 + 1.0D);
		int j2 = MathHelper.floor(this.z - (double)f3 - 1.0D);
		int j1 = MathHelper.floor(this.z + (double)f3 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.exploder, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.world, this, list, f3);
		Vec3d vec3d = new Vec3d(this.x, this.y, this.z);

		/* 爆破サイズに応じて、爆破範囲内のエンティティにダメージを与える */
		for(int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);

			/* 爆発への免疫、爆心からの距離に応じてダメージ判定 */
			if (!entity.isImmuneToExplosions()) {
				double d12 = (double)(MathHelper.sqrt(entity.getDistanceSq(vec3d)) / f3);

				/** 爆心に近いときはダメージ判定を行う **/
				if (d12 <= 1.0D) {
					double d5 = entity.getPosX() - this.x;
					double d7 = entity.getPosYEye() - this.y;
					double d9 = entity.getPosZ() - this.z;
					double d13 = (double)MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
					if (d13 != 0.0D) {
						d5 = d5 / d13;
						d7 = d7 / d13;
						d9 = d9 / d13;
						double d14 = (double)getBlockDensity(vec3d, entity);
						double d10 = (1.0D - d12) * d14;
						entity.attackEntityFrom(this.getDamageSource(), (float)1.0F);
						double d11 = d10;

						/* 爆破耐性のエンチャントに対する処理 */

						/* 爆風による吹き飛び 上への吹き飛びを0.1倍 */
						entity.setMotion(entity.getMotion().add(d5 * d11, d7 * d11 * 0.1, d9 * d11));

						if (entity instanceof PlayerEntity) {
							PlayerEntity playerIn = (PlayerEntity)entity;
							if (!playerIn.isSpectator() && (!playerIn.isCreative() || !playerIn.abilities.isFlying)) {
								this.playerKnockbackMap.put(playerIn, new Vec3d(d5 * d10, d7 * d10 * 0.1, d9 * d10));
							}
						} //PlayerEntity
					}
				}
			}
		}
	}

	/* 音やパーティクルの設定
	 * Does the second part of the explosion (sound, particles, drop spawn) */
	public void doExplosionB(boolean spawnParticles) { }

	public DamageSource getDamageSource() {
		return this.damageSource;
	}

	public void setDamageSource(DamageSource damageSourceIn) {
		this.damageSource = damageSourceIn;
	}

	/* 爆風による吹き飛び */
	public Map<PlayerEntity, Vec3d> getPlayerKnockbackMap() {
		return this.playerKnockbackMap;
	}

	/*爆発ブロックを配置したエンティティ、爆発の原因となったエンティティ、またはnullを返す
	 * Returns either the entity that placed the explosive block, the entity that caused the explosion or null. */
	@Nullable
	public LivingEntity getExplosivePlacedBy() {
		if (this.exploder == null) {
			return null;
		}
		else if (this.exploder instanceof TNTEntity) {
			return ((TNTEntity)this.exploder).getTntPlacedBy();
		}
		else if (this.exploder instanceof LivingEntity) {
			return (LivingEntity)this.exploder;
		}
		else {
			return this.exploder instanceof DamagingProjectileEntity ? ((DamagingProjectileEntity)this.exploder).shootingEntity : null;
		}
	}

	public void clearAffectedBlockPositions() {
		this.affectedBlockPositions.clear();
	}

	public List<BlockPos> getAffectedBlockPositions() {
		return this.affectedBlockPositions;
	}

	public Vec3d getPosition() {
		return this.position;
	}

}
