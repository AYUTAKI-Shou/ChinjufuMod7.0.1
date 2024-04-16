package com.ayutaki.chinjufumod.blocks.jpdeco;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BambooFenceGate extends FenceGateBlock {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);

	protected static final VoxelShape AABBW_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 14.0D, 9.0D);
	protected static final VoxelShape AABBW_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 14.0D, 16.0D);
	protected static final VoxelShape AABBW_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 14.0D, 9.0D);
	protected static final VoxelShape AABBW_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 14.0D, 16.0D);

	protected static final VoxelShape CLOSE_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 24.0D, 9.0D);
	protected static final VoxelShape CLOSE_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 24.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 24.0D, 9.0D);
	protected static final VoxelShape CLOSE_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 24.0D, 16.0D);

	public BambooFenceGate(Block.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(HORIZONTAL_FACING);

		switch(direction) {
		case NORTH:
		default:
			return !state.get(IN_WALL)? AABB_NORTH : AABBW_NORTH;
		case SOUTH:
			return !state.get(IN_WALL)? AABB_SOUTH : AABBW_SOUTH;
		case WEST:
			return !state.get(IN_WALL)? AABB_WEST : AABBW_WEST;
		case EAST:
			return !state.get(IN_WALL)? AABB_EAST : AABBW_EAST;
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(HORIZONTAL_FACING);

		switch(direction) {
		case NORTH:
		default:
			return !state.get(OPEN)? CLOSE_NORTH : VoxelShapes.empty();
		case SOUTH:
			return !state.get(OPEN)? CLOSE_SOUTH : VoxelShapes.empty();
		case WEST:
			return !state.get(OPEN)? CLOSE_WEST : VoxelShapes.empty();
		case EAST:
			return !state.get(OPEN)? CLOSE_EAST : VoxelShapes.empty();
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
