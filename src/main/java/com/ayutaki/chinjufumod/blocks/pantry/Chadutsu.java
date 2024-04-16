package com.ayutaki.chinjufumod.blocks.pantry;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Chadutsu extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(11.5D, 0.0, 11.5D, 15.0D, 5.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0, 11.5D, 4.5D, 5.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(1.0D, 0.0, 1.0D, 4.5D, 5.0D, 4.5D);
	protected static final VoxelShape AABB_EAST = Block.box(11.5D, 0.0, 1.0D, 15.0D, 5.0D, 4.5D);

	public Chadutsu(AbstractBlock.Properties properties) {
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

}
