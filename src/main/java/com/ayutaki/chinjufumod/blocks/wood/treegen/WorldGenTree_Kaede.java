package com.ayutaki.chinjufumod.blocks.wood.treegen;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public class WorldGenTree_Kaede extends WorldGenAbstractTree {

	private IBlockState blockStateWood = Seasonal_Blocks.KAEDE_log.getDefaultState();
	private IBlockState blockStateLeaves =
			Seasonal_Blocks.KAEDE_leaf.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

	/* 生成される木の高さの最小値 デフォルト4 */
	private final int minTreeHeight = 4;

	public WorldGenTree_Kaede(boolean parShouldNotify) {
		super(parShouldNotify);
	}

	@Override
	public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos) {

		int minHeight = parRandom.nextInt(3) + minTreeHeight;

		// Check if tree fits in world
		if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight()) {

			if (!isSuitableLocation(parWorld, parBlockPos, minHeight)) {
				return false;
			}

			else {
				IBlockState state = parWorld.getBlockState(parBlockPos.down());

				if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP,
						(IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1) {

					state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
					generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
					generateTrunk(parWorld, parBlockPos, minHeight);
					return true;
				}
				else{
					return false;
				}
			}
		}
		else{
			return false;
		}
	}

	/* 葉っぱの生成 */
	private void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom) {

		for (int foliageY = parBlockPos.getY() - 3 + height; foliageY <= parBlockPos.getY() + height; ++foliageY) {

			int foliageLayer = foliageY - (parBlockPos.getY() + height);
			int foliageLayerRadius = 1 - foliageLayer / 2;

			for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX() + foliageLayerRadius; ++foliageX) {
				int foliageRelativeX = foliageX - parBlockPos.getX();

				for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ() + foliageLayerRadius; ++foliageZ) {
					int foliageRelativeZ = foliageZ - parBlockPos.getZ();

					// Fill in layer with some randomness
					if (Math.abs(foliageRelativeX) != foliageLayerRadius || Math.abs(foliageRelativeZ) != foliageLayerRadius || parRandom.nextInt(2) != 0 && foliageLayer != 0) {

						BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
						IBlockState state = parWorld.getBlockState(blockPos);

						if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
							setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
						}
					}
				}
			}
		}
	}

	/* 幹の生成 */
	private void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight) {

		for (int height = 0; height < minHeight; ++height) {

			BlockPos upN = parBlockPos.up(height);
			IBlockState state = parWorld.getBlockState(upN);

			if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN)) {
				setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height), blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
			}
		}

	}

	private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight) {
		boolean isSuitableLocation = true;

		for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY) {

			// Handle increasing space towards top of tree
			int extraSpaceNeeded = 1;
			// Handle base location
			if (checkY == parBlockPos.getY()) {
				extraSpaceNeeded = 0;
			}
			// Handle top location
			if (checkY >= parBlockPos.getY() + 1 + minHeight - 2) {
				extraSpaceNeeded = 2;
			}

			BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

			for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX) {

				for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ) {
					isSuitableLocation = isReplaceable(parWorld,blockPos.setPos(checkX, checkY, checkZ));
				}
			}
		}
		return isSuitableLocation;
	}

	protected boolean canGrowInto(Block blockType) {
		Material material = blockType.getDefaultState().getMaterial();
		return material == Material.AIR || material == Material.LEAVES || blockType == Blocks.GRASS || blockType == Blocks
				.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks
				.VINE|| blockType == Seasonal_Blocks.FALL_LEAF;
	}
}
