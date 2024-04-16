package com.ayutaki.chinjufumod.blocks.gate;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Gate_thick extends BaseGate {

	/* Collision */
	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, 0.0D, 3.8D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape CLOSE_WEST = Block.box(8.0D, 0.0D, 0.0D, 12.2D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 12.2D);
	protected static final VoxelShape CLOSE_EAST = Block.box(3.8D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape OL_SOUTH = Block.box(8.0D, 0.0D, 3.8D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OL_WEST = Block.box(0.0D, 0.0D, 8.0D, 12.2D, 16.0D, 16.0D);
	protected static final VoxelShape OL_NORTH = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 12.2D);
	protected static final VoxelShape OL_EAST = Block.box(3.8D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);

	protected static final VoxelShape OR_SOUTH = Block.box(0.0D, 0.0D, 3.8D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape OR_WEST = Block.box(0.0D, 0.0D, 0.0D, 12.2D, 16.0D, 8.0D);
	protected static final VoxelShape OR_NORTH = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.2D);
	protected static final VoxelShape OR_EAST = Block.box(3.8D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	
	public Gate_thick(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_2);
		boolean flagOpen = !state.getValue(OPEN);
		boolean flagRight = state.getValue(HINGE) == DoorHingeSide.RIGHT;

		switch (i) {
		case 1:
		default:
			switch (direction) {
			case NORTH:
			default:
				return flagOpen? CLOSE_NORTH : Shapes.empty();
			case SOUTH:
				return flagOpen? CLOSE_SOUTH : Shapes.empty();
			case WEST:
				return flagOpen? CLOSE_WEST : Shapes.empty();
			case EAST:
				return flagOpen? CLOSE_EAST : Shapes.empty();
			}
			
		case 2:
			switch (direction) {
			case NORTH:
			default:
				return flagOpen? CLOSE_NORTH : (flagRight? OR_NORTH : OL_NORTH);
			case SOUTH:
				return flagOpen? CLOSE_SOUTH : (flagRight? OR_SOUTH : OL_SOUTH);
			case WEST:
				return flagOpen? CLOSE_WEST : (flagRight? OR_WEST : OL_WEST);
			case EAST:
				return flagOpen? CLOSE_EAST : (flagRight? OR_EAST : OL_EAST);
			}
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_2);
		boolean flagOpen = !state.getValue(OPEN);
		boolean flagRight = state.getValue(HINGE) == DoorHingeSide.RIGHT;
		
		switch (i) {
		case 1:
		default:
			switch (direction) {
			case NORTH:
			default:
				return flagOpen? Shapes.block() : Shapes.empty();
			case SOUTH:
				return flagOpen? Shapes.block() : Shapes.empty();
			case WEST:
				return flagOpen? Shapes.block() : Shapes.empty();
			case EAST:
				return flagOpen? Shapes.block() : Shapes.empty();
			}
			
		case 2:
			switch (direction) {
			case NORTH:
			default:
				return flagOpen? Shapes.block() : (flagRight? OR_NORTH : OL_NORTH);
			case SOUTH:
				return flagOpen? Shapes.block() : (flagRight? OR_SOUTH : OL_SOUTH);
			case WEST:
				return flagOpen? Shapes.block() : (flagRight? OR_WEST : OL_WEST);
			case EAST:
				return flagOpen? Shapes.block() : (flagRight? OR_EAST : OL_EAST);
			}
		}
	}
}
