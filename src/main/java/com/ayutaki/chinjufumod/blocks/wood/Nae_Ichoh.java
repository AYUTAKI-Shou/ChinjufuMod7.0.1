package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_IchohBig;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class Nae_Ichoh extends BlockBush implements IGrowable {

	/* Property */
	public static final PropertyInteger STAGE_0_1 = PropertyInteger.create("stage", 0, 1);

	public Nae_Ichoh(String name) {
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.WOOD);
		setHardness(0.5F);
		setResistance(1.0F);
		setLightOpacity(1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);
	}

	/* RandomTick true/false. */
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	/* Contents of RandomTick. */
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		if (state.getValue(STAGE_0_1).intValue() == 0) {
			worldIn.setBlockState(pos, state.cycleProperty(STAGE_0_1), 4);
		}

		else {
			generateTree(worldIn, pos, state, rand);
		}
	}

	/* RandomTick */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				grow(worldIn, rand, pos, state);
			}
		}
	}

	/* 苗木から WorldGenTree を使って木を生成する */
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;

		/* 木の大きさを変えない場合
		 * WorldGenerator worldgenerator = new WorldGenTreeSakura(true);*/

		/* 確率で大木になる Intの数字が母数, ：の左が分子 */
		WorldGenerator worldgenerator =
				(WorldGenerator)(rand.nextInt(20) == 0 ? new WorldGenTree_IchohBig(true) : new WorldGenTree_Ichoh(true));

		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

		worldgenerator.generate(worldIn, rand, pos);
	}

	/* The result of using Bonemeal. */
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return worldIn.rand.nextFloat() < 0.45D;
	}

	/* デフォルトのメタData valueを呼び出し */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(STAGE_0_1, Integer.valueOf((meta & 8) >> 3));
	}

	/* メタData valueを拾う */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(STAGE_0_1).intValue() << 3;
		return i;
	}

	/* メタData valueとして STAGE_0_1 を設ける */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {STAGE_0_1});
	}

	/* 直下ブロックによる設置判定 */
	 @Override
	 protected boolean canSustainBush(IBlockState state) {
	 	return state.getBlock() instanceof BlockGrass || state.getBlock() instanceof BlockDirt || 
	 			state.getBlock() instanceof BlockFarmland || state.getBlock() instanceof FallLeaf;
	 }

	/* Render */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
