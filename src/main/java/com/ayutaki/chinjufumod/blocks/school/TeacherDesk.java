package com.ayutaki.chinjufumod.blocks.school;

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

public class TeacherDesk extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Shapes.or(Block.box(-8.0D, 15.0D, 0.0D, 24.0D, 16.0D, 16.0D), 
			Block.box(-6.0D, 11.0D, 1.0D, 22.0D, 15.0D, 15.0D),
			Block.box(-7.0D, 0.0D, 1.0D, 23.0D, 15.0D, 3.0D),
			Block.box(-7.0D, 0.0D, 1.0D, -4.0D, 15.0D, 15.0D),
			Block.box(20.0D, 0.0D, 1.0D, 23.0D, 15.0D, 15.0D));
	
	protected static final VoxelShape AABB_WEST = Shapes.or(Block.box(0.0D, 15.0D, -8.0D, 16.0D, 16.0D, 24.0D), 
			Block.box(1.0D, 11.0D, -6.0D, 15.0D, 15.0D, 22.0D),
			Block.box(12.0D, 0.0D, -7.0D, 15.0D, 15.0D, 23.0D),
			Block.box(1.0D, 0.0D, -7.0D, 15.0D, 15.0D, -4.0D),
			Block.box(1.0D, 0.0D, 20.0D, 15.0D, 15.0D, 23.0D));
	
	protected static final VoxelShape AABB_NORTH = Shapes.or(Block.box(-8.0D, 15.0D, 0.0D, 24.0D, 16.0D, 16.0D), 
			Block.box(-6.0D, 11.0D, 1.0D, 22.0D, 15.0D, 15.0D),
			Block.box(-7.0D, 0.0D, 12.0D, 23.0D, 15.0D, 15.0D),
			Block.box(-7.0D, 0.0D, 1.0D, -4.0D, 15.0D, 15.0D),
			Block.box(20.0D, 0.0D, 1.0D, 23.0D, 15.0D, 15.0D));
	
	protected static final VoxelShape AABB_EAST = Shapes.or(Block.box(0.0D, 15.0D, -8.0D, 16.0D, 16.0D, 24.0D), 
			Block.box(1.0D, 11.0D, -6.0D, 15.0D, 15.0D, 22.0D),
			Block.box(1.0D, 0.0D, -7.0D, 3.0D, 15.0D, 23.0D),
			Block.box(1.0D, 0.0D, -7.0D, 15.0D, 15.0D, -4.0D),
			Block.box(1.0D, 0.0D, 20.0D, 15.0D, 15.0D, 23.0D));

	public TeacherDesk(BlockBehaviour.Properties properties) {
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
		} // switch
	}
}
