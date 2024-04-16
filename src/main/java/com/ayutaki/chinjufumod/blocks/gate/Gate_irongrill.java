package com.ayutaki.chinjufumod.blocks.gate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.state.TripleGate;

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

public class Gate_irongrill extends BaseGate {

	/* Collision */
	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape CLOSE_WEST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape CLOSE_EAST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
	
	protected static final VoxelShape OL_SOUTH = Block.box(8.0D, 0.0D, 7.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OL_WEST = Block.box(0.0D, 0.0D, 8.0D, 8.5D, 16.0D, 16.0D);
	protected static final VoxelShape OL_NORTH = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.5D);
	protected static final VoxelShape OL_EAST = Block.box(7.5D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);

	protected static final VoxelShape OR_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape OR_WEST = Block.box(0.0D, 0.0D, 0.0D, 8.5D, 16.0D, 8.0D);
	protected static final VoxelShape OR_NORTH = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape OR_EAST = Block.box(7.5D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape TOP2_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 11.0D, 8.5D);
	protected static final VoxelShape TOP2_WEST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 11.0D, 16.0D);
	protected static final VoxelShape TOP2_NORTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 11.0D, 8.5D);
	protected static final VoxelShape TOP2_EAST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 11.0D, 16.0D);
	
	protected static final VoxelShape T2OL_SOUTH = Block.box(8.0D, 0.0D, 7.5D, 16.0D, 11.0D, 16.0D);
	protected static final VoxelShape T2OL_WEST = Block.box(0.0D, 0.0D, 8.0D, 8.5D, 11.0D, 16.0D);
	protected static final VoxelShape T2OL_NORTH = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 11.0D, 8.5D);
	protected static final VoxelShape T2OL_EAST = Block.box(7.5D, 0.0D, 0.0D, 16.0D, 11.0D, 8.0D);

	protected static final VoxelShape T2OR_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 8.0D, 11.0D, 16.0D);
	protected static final VoxelShape T2OR_WEST = Block.box(0.0D, 0.0D, 0.0D, 8.5D, 11.0D, 8.0D);
	protected static final VoxelShape T2OR_NORTH = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 11.0D, 8.5D);
	protected static final VoxelShape T2OR_EAST = Block.box(7.5D, 0.0D, 8.0D, 16.0D, 11.0D, 16.0D);
	
	public Gate_irongrill(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.getValue(H_FACING);
		TripleGate triple = state.getValue(HALF);
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
			switch (triple) {
			case UPPER:
			default:
			case LOWER:
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
				
			case TOP:
				switch (direction) {
				case NORTH:
				default:
					return flagOpen? TOP2_NORTH : (flagRight? T2OR_NORTH : T2OL_NORTH);
				case SOUTH:
					return flagOpen? TOP2_SOUTH : (flagRight? T2OR_SOUTH : T2OL_SOUTH);
				case WEST:
					return flagOpen? TOP2_WEST : (flagRight? T2OR_WEST : T2OL_WEST);
				case EAST:
					return flagOpen? TOP2_EAST : (flagRight? T2OR_EAST : T2OL_EAST);
				}
			}

		}
	}
		
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
