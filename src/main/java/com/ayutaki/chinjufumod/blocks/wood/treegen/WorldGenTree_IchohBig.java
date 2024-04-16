package com.ayutaki.chinjufumod.blocks.wood.treegen;

import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/* WorldGenBigTreeを参照 */
public class WorldGenTree_IchohBig extends WorldGenAbstractTree {

	/* フィールドの設定 */
	private Random rand;
	private World world;
	private BlockPos basePos = BlockPos.ORIGIN;
	int heightLimit;
	int height;
	double heightAttenuation = 0.618D;
	double branchSlope = 0.381D;
	double scaleWidth = 1.0D;
	double leafDensity = 1.0D;

	/** 幹の太さ **/
	int trunkSize = 1;
	/** 高さの最大値 デフォルト12 -> 10 **/
	int heightLimitLimit = 10;
	/** 枝ともっとも遠い葉っぱまでの距離 **/
	int leafDistanceLimit = 4;
	List<WorldGenTree_IchohBig.FoliageCoordinates> foliageCoords;
	/* 葉っぱのフィールドを追加 */
	private IBlockState leave;

	public WorldGenTree_IchohBig(boolean notify) {
		super(notify);
		this.leave = Seasonal_Blocks.ICHOH_leaf.getDefaultState();
	}

	public WorldGenTree_IchohBig(boolean notify, IBlockState state) {
		super(notify);
	 this.leave = state;
	}

	/* 葉っぱ, 幹, 苗木の設定 ----------------------------------------------------------------- */
	public IBlockState getLeaveState() {
	 return this.leave;
	}

	public Block getLog() {
	 return Seasonal_Blocks.ICHOH_log;
	}

	public Block getSapling() {
	 return Seasonal_Blocks.ICHOH_nae;
	}

	/* 木の生成で以下のメソッドを走らせる */
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		this.world = worldIn;
		this.basePos = position;
		this.rand = new Random(rand.nextLong());

		if (this.heightLimit == 0) {
			this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
		}

		if (!this.validTreeLocation()) {
			this.world = null; //Fix vanilla Mem leak, holds latest world
			return false;
		}
		else {
			this.generateLeafNodeList();
			this.generateLeaves();
			this.generateTrunk();
			this.generateLeafNodeBases();
			this.world = null; //Fix vanilla Mem leak, holds latest world
			return true;
		}
	}

	/*枝の生成 */
	void generateLeafNodeList() {
		this.height = (int)((double)this.heightLimit * this.heightAttenuation);

		if (this.height >= this.heightLimit) {
			this.height = this.heightLimit - 1;
		}

		int i = (int)(1.382D + Math.pow(this.leafDensity * (double)this.heightLimit / 13.0D, 2.0D));

		if (i < 1) {
			i = 1;
		}

		int j = this.basePos.getY() + this.height;
		int k = this.heightLimit - this.leafDistanceLimit;
		this.foliageCoords = Lists.<WorldGenTree_IchohBig.FoliageCoordinates>newArrayList();
		this.foliageCoords.add(new WorldGenTree_IchohBig.FoliageCoordinates(this.basePos.up(k), j));

		for (; k >= 0; --k) {
			float f = this.layerSize(k);

			if (f >= 0.0F) {

				for (int l = 0; l < i; ++l) {
					double d0 = this.scaleWidth * (double)f * ((double)this.rand.nextFloat() + 0.328D);
					double d1 = (double)(this.rand.nextFloat() * 2.0F) * Math.PI;
					double d2 = d0 * Math.sin(d1) + 0.5D;
					double d3 = d0 * Math.cos(d1) + 0.5D;
					BlockPos pos = this.basePos.add(d2, (double)(k - 1), d3);
					BlockPos pos1 = pos.up(this.leafDistanceLimit);

					if (this.checkBlockLine(pos, pos1) == -1) {
						int i1 = this.basePos.getX() - pos.getX();
						int j1 = this.basePos.getZ() - pos.getZ();
						double d4 = (double)pos.getY() - Math.sqrt((double)(i1 * i1 + j1 * j1)) * this.branchSlope;
						int k1 = d4 > (double)j ? j : (int)d4;
						BlockPos pos2 = new BlockPos(this.basePos.getX(), k1, this.basePos.getZ());

						if (this.checkBlockLine(pos2, pos) == -1) {
							this.foliageCoords.add(new WorldGenTree_IchohBig.FoliageCoordinates(pos, pos2.getY()));
						}
					}
				}
			}
		}
	}

	void crosSection(BlockPos pos, float p_181631_2_, IBlockState p_181631_3_) {
		int i = (int)((double)p_181631_2_ + 0.618D);

		for (int j = -i; j <= i; ++j) {

			for (int k = -i; k <= i; ++k) {

				if (Math.pow((double)Math.abs(j) + 0.5D, 2.0D) + Math.pow((double)Math.abs(k) + 0.5D, 2.0D) <= (double)(p_181631_2_ * p_181631_2_)) {
					BlockPos pos1 = pos.add(j, 0, k);
					IBlockState state = this.world.getBlockState(pos1);

					if (state.getBlock().isAir(state, world, pos1) || state.getBlock().isLeaves(state, world, pos1)) {
						this.setBlockAndNotifyAdequately(this.world, pos1, p_181631_3_);
					}
				}
			}
		}
	}

	/* 木の大きさ */
	float layerSize(int y) {

		if ((float)y < (float)this.heightLimit * 0.3F) {
			return -1.0F;
		}

		else {
			float f = (float)this.heightLimit / 2.0F;
			float f1 = f - (float)y;
			float f2 = MathHelper.sqrt(f * f - f1 * f1);

			if (f1 == 0.0F) {
				f2 = f;
			}

			else if (Math.abs(f1) >= f) {
				return 0.0F;
			}

			return f2 * 0.5F;
		}
	}

	/* 葉っぱの大きさ */
	float leafSize(int y) {

		if (y >= 0 && y < this.leafDistanceLimit) {
			return y != 0 && y != this.leafDistanceLimit - 1 ? 3.0F : 2.0F;
		}

		else {
			return -1.0F;
		}
	}

	/* 個々の枝で生成する葉っぱ */
	void generateLeafNode(BlockPos pos) {

		for (int i = 0; i < this.leafDistanceLimit; ++i) {

			/** Blocks.LEAVES.getDefaultState()…を, getLeaveState()に書き換え **/
			this.crosSection(pos.up(i), this.leafSize(i), getLeaveState());
		}
	}

	/* 枝の大きさ */
	void limb(BlockPos p_175937_1_, BlockPos p_175937_2_, Block p_175937_3_) {

		BlockPos pos1 = p_175937_2_.add(-p_175937_1_.getX(), -p_175937_1_.getY(), -p_175937_1_.getZ());
		int i = this.getGreatestDistance(pos1);
		float f = (float)pos1.getX() / (float)i;
		float f1 = (float)pos1.getY() / (float)i;
		float f2 = (float)pos1.getZ() / (float)i;

		for (int j = 0; j <= i; ++j) {
			BlockPos pos2 = p_175937_1_.add((double)(0.5F + (float)j * f), (double)(0.5F + (float)j * f1), (double)(0.5F + (float)j * f2));
			BlockLog.EnumAxis blocklog$enumaxis = this.getLogAxis(p_175937_1_, pos2);
			this.setBlockAndNotifyAdequately(this.world, pos2, p_175937_3_.getDefaultState().withProperty(BlockLog.LOG_AXIS, blocklog$enumaxis));
		}
	}

	/* 枝の大きさ */
	private int getGreatestDistance(BlockPos posIn) {
		int i = MathHelper.abs(posIn.getX());
		int j = MathHelper.abs(posIn.getY());
		int k = MathHelper.abs(posIn.getZ());

		if (k > i && k > j) {
			return k;
		}
		else {
			return j > i ? j : i;
		}
	}

	private BlockLog.EnumAxis getLogAxis(BlockPos p_175938_1_, BlockPos p_175938_2_) {
		BlockLog.EnumAxis blocklog$enumaxis = BlockLog.EnumAxis.Y;
		int i = Math.abs(p_175938_2_.getX() - p_175938_1_.getX());
		int j = Math.abs(p_175938_2_.getZ() - p_175938_1_.getZ());
		int k = Math.max(i, j);

		if (k > 0) {

			if (i == k) {
				blocklog$enumaxis = BlockLog.EnumAxis.X;
			}
			else if (j == k) {
				blocklog$enumaxis = BlockLog.EnumAxis.Z;
			}
		}
		return blocklog$enumaxis;
	}

	/* 葉っぱの生成 */
	void generateLeaves() {

		for (WorldGenTree_IchohBig.FoliageCoordinates BlockBigTreeSakura$foliagecoordinates : this.foliageCoords) {
			this.generateLeafNode(BlockBigTreeSakura$foliagecoordinates);
		}
	}

	/* 整合性の処理 */
	boolean leafNodeNeedsBase(int p_76493_1_) {
		return (double)p_76493_1_ >= (double)this.heightLimit * 0.2D;
	}

	/* 幹の太さについて 値は１か２ */
	void generateTrunk() {
		BlockPos pos = this.basePos;
		BlockPos pos1 = this.basePos.up(this.height);
		/** Blocks.LOG; を getLog(); に書き換え **/
		Block block = getLog();
		this.limb(pos, pos1, block);

		if (this.trunkSize == 2) {
			this.limb(pos.east(), pos1.east(), block);
			this.limb(pos.east().south(), pos1.east().south(), block);
			this.limb(pos.south(), pos1.south(), block);
		}
	}

	/*必要な幹ブロックの追加*/
	void generateLeafNodeBases() {

		for (WorldGenTree_IchohBig.FoliageCoordinates BlockBigTreeSakura$foliagecoordinates : this.foliageCoords) {

			int i = BlockBigTreeSakura$foliagecoordinates.getBranchBase();
			BlockPos pos = new BlockPos(this.basePos.getX(), i, this.basePos.getZ());

			if (!pos.equals(BlockBigTreeSakura$foliagecoordinates) && this.leafNodeNeedsBase(i - this.basePos.getY())) {
				/** Blocks.LOG; を getLog(); に書き換え **/
				this.limb(pos, BlockBigTreeSakura$foliagecoordinates, getLog());
			}
		}
	}

	/**
	 * Checks a line of blocks in the world from the first coordinate to triplet to the second, returning the distance
	 * (in blocks) before a non-air, non-leaf block is encountered and/or the end is encountered.
	 */
	int checkBlockLine(BlockPos posOne, BlockPos posTwo) {
		BlockPos pos = posTwo.add(-posOne.getX(), -posOne.getY(), -posOne.getZ());
		int i = this.getGreatestDistance(pos);
		float f = (float)pos.getX() / (float)i;
		float f1 = (float)pos.getY() / (float)i;
		float f2 = (float)pos.getZ() / (float)i;

		if (i == 0) {
			return -1;
		}

		else {

			for (int j = 0; j <= i; ++j) {
				BlockPos pos1 = posOne.add((double)(0.5F + (float)j * f), (double)(0.5F + (float)j * f1), (double)(0.5F + (float)j * f2));

				if (!this.isReplaceable(world, pos1)) {
					return j;
				}
			}
			return -1;
		}
	}

	/* 枝ともっとも遠い葉っぱまでの距離のデフォルト */
	public void setDecorationDefaults() {
		this.leafDistanceLimit = 5;
	}

	/**
	 * Returns a boolean indicating whether or not the current location for the tree, spanning basePos to to the height
	 * limit, is valid.
	 */
	private boolean validTreeLocation() {

		BlockPos down = this.basePos.down();
		net.minecraft.block.state.IBlockState state = this.world.getBlockState(down);
		boolean isSoil = state.getBlock().canSustainPlant(state, this.world, down, net.minecraft.util.EnumFacing.UP, ((net.minecraft.block.BlockSapling)Blocks.SAPLING));

		if (!isSoil) {
			return false;
		}

		else {
			int i = this.checkBlockLine(this.basePos, this.basePos.up(this.heightLimit - 1));

			if (i == -1)
			{
				return true;
			}
			else if (i < 6)
			{
				return false;
			}
			else
			{
				this.heightLimit = i;
				return true;
			}
		}
	}

	/* ---------------------------------------------------------------------------------------------------------- */
	static class FoliageCoordinates extends BlockPos {

			private final int branchBase;

			public FoliageCoordinates(BlockPos pos, int p_i45635_2_) {
				super(pos.getX(), pos.getY(), pos.getZ());
				this.branchBase = p_i45635_2_;
			}

			public int getBranchBase() {
				return this.branchBase;
			}
		}


}
