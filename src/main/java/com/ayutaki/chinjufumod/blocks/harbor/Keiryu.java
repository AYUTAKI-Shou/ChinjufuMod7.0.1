package com.ayutaki.chinjufumod.blocks.harbor;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Keiryu extends BaseFacingWater {
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Shapes.or(Block.box(3.0D, 6.0D, 0.0D, 13.0D, 11.0D, 12.0D),
			Block.box(3.0D, 0.0D, 0.0D, 13.0D, 6.0D, 7.0D));
	protected static final VoxelShape AABB_WEST = Shapes.or(Block.box(4.0D, 6.0D, 3.0D, 16.0D, 11.0D, 13.0D),
					Block.box(9.0D, 0.0D, 3.0D, 16.0D, 6.0D, 13.0D));
	protected static final VoxelShape AABB_NORTH = Shapes.or(Block.box(3.0D, 6.0D, 4.0D, 13.0D, 11.0D, 16.0D),
			Block.box(3.0D, 0.0D, 9.0D, 13.0D, 6.0D, 16.0D));
	protected static final VoxelShape AABB_EAST = Shapes.or(Block.box(0.0D, 6.0D, 3.0D, 12.0D, 11.0D, 13.0D),
			Block.box(0.0D, 0.0D, 3.0D, 7.0D, 6.0D, 13.0D));
	
	public Keiryu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* 周囲の光透過 影0.0F -> 1.0F透過*/
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}	
}
