package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Bot_Shouyu extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(1.75D, 0.0, 1.75D, 5.25D, 6.5D, 5.25D);
	protected static final VoxelShape AABB_WEST = Block.box(10.75D, 0.0, 1.75D, 14.25D, 6.5D, 5.25D);
	protected static final VoxelShape AABB_NORTH = Block.box(10.75D, 0.0, 10.75D, 14.25D, 6.5D, 14.25D);
	protected static final VoxelShape AABB_EAST = Block.box(1.75D, 0.0, 10.75D, 5.25D, 6.5D, 14.25D);
	
	public Bot_Shouyu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		
		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return true;
	}
}
