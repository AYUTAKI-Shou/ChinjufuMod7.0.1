package com.ayutaki.chinjufumod.blocks.gate;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class Gate_spruce extends BaseGate {

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
	
	public Gate_spruce(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

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
				return flagOpen? CLOSE_NORTH : VoxelShapes.empty();
			case SOUTH:
				return flagOpen? CLOSE_SOUTH : VoxelShapes.empty();
			case WEST:
				return flagOpen? CLOSE_WEST : VoxelShapes.empty();
			case EAST:
				return flagOpen? CLOSE_EAST : VoxelShapes.empty();
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
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

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
				return flagOpen? VoxelShapes.block() : VoxelShapes.empty();
			case SOUTH:
				return flagOpen? VoxelShapes.block() : VoxelShapes.empty();
			case WEST:
				return flagOpen? VoxelShapes.block() : VoxelShapes.empty();
			case EAST:
				return flagOpen? VoxelShapes.block() : VoxelShapes.empty();
			}
			
		case 2:
			switch (direction) {
			case NORTH:
			default:
				return flagOpen? VoxelShapes.block() : (flagRight? OR_NORTH : OL_NORTH);
			case SOUTH:
				return flagOpen? VoxelShapes.block() : (flagRight? OR_SOUTH : OL_SOUTH);
			case WEST:
				return flagOpen? VoxelShapes.block() : (flagRight? OR_WEST : OL_WEST);
			case EAST:
				return flagOpen? VoxelShapes.block() : (flagRight? OR_EAST : OL_EAST);
			}
		}
	}
		
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
