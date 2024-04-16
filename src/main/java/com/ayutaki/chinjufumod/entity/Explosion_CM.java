package com.ayutaki.chinjufumod.entity;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/* エンティティなどで呼び出せば使える */
public class Explosion_CM extends Explosion {

	private final Random rand;
	private final World world;
	private final double x;
	private final double y;
	private final double z;
	private final Entity exploder;
	private final float size;

	/*爆発の影響を受けるブロック
	 * A list of ChunkPositions of blocks affected by this explosion */
	private final List<BlockPos> affectedBlockPositions;

	/*爆発による吹き飛び
	 * Maps players to the knockback vector applied by the explosion, to send to the client */
	private final Map<EntityPlayer, Vec3d> playerKnockbackMap;
	private final Vec3d position;

	/* 炎上をともなう爆発かどうか
	 * whether or not the explosion sets fire to blocks around it */
	private final boolean causesFire;

	/* 煙のパーティクルを出すかどうか
	 * whether or not this explosion spawns smoke particles */
	private final boolean damagesTerrain;


	@SideOnly(Side.CLIENT)
	public Explosion_CM(World worldIn, Entity entityIn, double x, double y, double z, float size, List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, x, y, z, size, false, true, affectedPositions);
	}

	@SideOnly(Side.CLIENT)
	public Explosion_CM(World worldIn, Entity entityIn, double x, double y, double z, float size,
			boolean causesFire, boolean damagesTerrain, List<BlockPos> affectedPositions) {

		this(worldIn, entityIn, x, y, z, size, causesFire, damagesTerrain);
		this.affectedBlockPositions.addAll(affectedPositions);
	}

	public Explosion_CM(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming, boolean damagesTerrain) {
		super(worldIn, entityIn, x, y, z, size, damagesTerrain, damagesTerrain);
		this.rand = new Random();
		this.affectedBlockPositions = Lists.<BlockPos>newArrayList();
		this.playerKnockbackMap = Maps.<EntityPlayer, Vec3d>newHashMap();
		this.world = worldIn;
		this.exploder = entityIn;
		this.size = size;
		this.x = x;
		this.y = y;
		this.z = z;
		this.causesFire = flaming;
		this.damagesTerrain = damagesTerrain;
		this.position = new Vec3d(this.x, this.y, this.z);
	}

	/*ブロックの破壊に関する設定
	 * Does the first part of the explosion (destroy blocks) */
	public void doExplosionA() {

		Set<BlockPos> set = Sets.<BlockPos>newHashSet();
		@SuppressWarnings("unused")
		int i = 16;

		for (int j = 0; j < 16; ++j) {
			
			for (int k = 0; k < 16; ++k) {
				
				for (int l = 0; l < 16; ++l) {
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

						for (@SuppressWarnings("unused")
						float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							
							BlockPos pos = new BlockPos(d4, d6, d8);
							IBlockState state = this.world.getBlockState(pos);

							/* AIR以外のブロックだったとき, 爆破耐性の判定を行う */
							if (state.getMaterial() != Material.AIR) {

								float f2 = this.exploder != null ? this.exploder.getExplosionResistance(this, this.world, pos, state) : state.getBlock().getExplosionResistance(world, pos, (Entity)null, this);
								f -= (f2 + 0.3F) * 0.3F;
							}

							if (f > 0.0F && (this.exploder == null || this.exploder.canExplosionDestroyBlock(this, this.world, pos, state, f))) {

								set.add(pos);
							}

							d4 += d0 * 0.30000001192092896D;
							d6 += d1 * 0.30000001192092896D;
							d8 += d2 * 0.30000001192092896D;
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

		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.exploder,
				new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.world, this, list, f3);
		Vec3d vec3d = new Vec3d(this.x, this.y, this.z);

		/* 爆破サイズに応じて, 爆破範囲内のエンティティにダメージを与える */
		for (int k2 = 0; k2 < list.size(); ++k2) {

			Entity entity = list.get(k2);

			/* 爆発への免疫, 爆心からの距離に応じてダメージ判定 */
			if (!entity.isImmuneToExplosions()) {

				double d12 = entity.getDistance(this.x, this.y, this.z) / (double)f3;

				/** 爆心に近いときはダメージ判定を行う **/
				if (d12 <= 1.0D) {

					double d5 = entity.posX - this.x;
					double d7 = entity.posY + (double)entity.getEyeHeight() - this.y;
					double d9 = entity.posZ - this.z;

					double d13 = (double)MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);

					if (d13 != 0.0D) {

						d5 = d5 / d13;
						d7 = d7 / d13;
						d9 = d9 / d13;
						double d14 = (double)this.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
						double d10 = (1.0D - d12) * d14;

						entity.attackEntityFrom(DamageSource.causeExplosionDamage(this), (float)((int)((d10 * d10 + d10) / 2.0D * 7.0D * (double)f3 + 1.0D)));
						double d11 = d10;

						/* 爆破耐性のエンチャントに対する処理 */
						if (entity instanceof EntityLivingBase) {
							d11 = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase)entity, d10);
						}

						entity.motionX += d5 * d11;
						entity.motionY += d7 * d11;
						entity.motionZ += d9 * d11;

						if (entity instanceof EntityPlayer) {
							EntityPlayer playerIn = (EntityPlayer)entity;
							/* 爆風による吹き飛び 上への吹き飛びを0.8倍 */
							if (!playerIn.isSpectator() && (!playerIn.isCreative() || !playerIn.capabilities.isFlying)) {
								this.playerKnockbackMap.put(playerIn, new Vec3d(d5 * d10, d7 * d10 * 0.8, d9 * d10));
							}
						}
					}
				}
			}
		}
	}

	/* 音やパーティクルの設定
	 * Does the second part of the explosion (sound, particles, drop spawn) */
	public void doExplosionB(boolean spawnParticles) {

		/** パーティクル **/
		this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);

		/** ブロックの破壊 **/
		if (this.damagesTerrain) {

			for (BlockPos pos : this.affectedBlockPositions) {

				IBlockState state = this.world.getBlockState(pos);
				Block block = state.getBlock();

				/* AIR以外のブロックだった場合, アイテムドロップの処理を行う */
				if (state.getMaterial() != Material.AIR) {

					if (block.canDropFromExplosion(this)) {
						block.dropBlockAsItemWithChance(this.world, pos, this.world.getBlockState(pos), 1.0F / this.size, 0);
					}
					block.onBlockExploded(this.world, pos, this);
				}

			}
		}

		/** 炎上をともなう爆発 **/
		if (this.causesFire) {

			for (BlockPos pos1 : this.affectedBlockPositions) {

				if (this.world.getBlockState(pos1).getMaterial() == Material.AIR && this.world
						.getBlockState(pos1.down()).isFullBlock() && this.rand.nextInt(3) == 0) {
					this.world.setBlockState(pos1, Blocks.FIRE.getDefaultState());
				}
			}
		}

	}

	/* 爆風による吹き飛び */
	public Map<EntityPlayer, Vec3d> getPlayerKnockbackMap() {
		return this.playerKnockbackMap;
	}

	/*爆発ブロックを配置したエンティティ, 爆発の原因となったエンティティ, またはnullを返す
	 * Returns either the entity that placed the explosive block, the entity that caused the explosion or null. */
	@Nullable
	public EntityLivingBase getExplosivePlacedBy() {

		if (this.exploder == null) {
			return null;
		}

		else if (this.exploder instanceof EntityTNTPrimed) {
			return ((EntityTNTPrimed)this.exploder).getTntPlacedBy();
		}

		else {
			return this.exploder instanceof EntityLivingBase ? (EntityLivingBase)this.exploder : null;
		}
	}

	public void clearAffectedBlockPositions() {
		this.affectedBlockPositions.clear();
	}

	public List<BlockPos> getAffectedBlockPositions() {
		return this.affectedBlockPositions;
	}

	public Vec3d getPosition(){ return this.position; }
}
