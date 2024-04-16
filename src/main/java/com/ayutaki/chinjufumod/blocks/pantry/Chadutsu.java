package com.ayutaki.chinjufumod.blocks.pantry;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Chadutsu extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(11.5D, 0.0, 11.5D, 15.0D, 5.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0, 11.5D, 4.5D, 5.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(1.0D, 0.0, 1.0D, 4.5D, 5.0D, 4.5D);
	protected static final VoxelShape AABB_EAST = Block.box(11.5D, 0.0, 1.0D, 15.0D, 5.0D, 4.5D);

	public Chadutsu(BlockBehaviour.Properties properties) {
		super(properties);
	}

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
}
