package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Frypan_kara extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 2.0D, 12.0D);

	public Frypan_kara(Block.Properties properties) {
		super(properties);
	}

	/* Anti Shadow */
	public int getLightValue(BlockState state) {
		return 1;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

}
