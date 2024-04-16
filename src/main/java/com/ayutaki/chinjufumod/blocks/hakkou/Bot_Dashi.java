package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Bot_Dashi extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(1.75D, 0.0, 1.75D, 5.25D, 5.5D, 5.25D);
	protected static final VoxelShape AABB_WEST = Block.box(10.75D, 0.0, 1.75D, 14.25D, 5.5D, 5.25D);
	protected static final VoxelShape AABB_NORTH = Block.box(10.75D, 0.0, 10.75D, 14.25D, 5.5D, 14.25D);
	protected static final VoxelShape AABB_EAST = Block.box(1.75D, 0.0, 10.75D, 5.25D, 5.5D, 14.25D);

	public Bot_Dashi(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		
		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
	}

	/* 上からの光透過 */
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

}
