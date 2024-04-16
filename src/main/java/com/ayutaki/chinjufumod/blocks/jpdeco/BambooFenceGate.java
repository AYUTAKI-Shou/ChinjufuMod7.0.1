package com.ayutaki.chinjufumod.blocks.jpdeco;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
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
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape AABB_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape AABB_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);

	protected static final VoxelShape AABBW_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 14.0D, 9.0D);
	protected static final VoxelShape AABBW_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 14.0D, 16.0D);
	protected static final VoxelShape AABBW_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 14.0D, 9.0D);
	protected static final VoxelShape AABBW_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 14.0D, 16.0D);

	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 24.0D, 9.0D);
	protected static final VoxelShape CLOSE_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 24.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 24.0D, 9.0D);
	protected static final VoxelShape CLOSE_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 24.0D, 16.0D);

	public BambooFenceGate(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(FACING);

		switch (direction) {
		case NORTH:
		default:
			return !state.getValue(IN_WALL)? AABB_NORTH : AABBW_NORTH;
		case SOUTH:
			return !state.getValue(IN_WALL)? AABB_SOUTH : AABBW_SOUTH;
		case WEST:
			return !state.getValue(IN_WALL)? AABB_WEST : AABBW_WEST;
		case EAST:
			return !state.getValue(IN_WALL)? AABB_EAST : AABBW_EAST;
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(FACING);

		switch (direction) {
		case NORTH:
		default:
			return !state.getValue(OPEN)? CLOSE_NORTH : VoxelShapes.empty();
		case SOUTH:
			return !state.getValue(OPEN)? CLOSE_SOUTH : VoxelShapes.empty();
		case WEST:
			return !state.getValue(OPEN)? CLOSE_WEST : VoxelShapes.empty();
		case EAST:
			return !state.getValue(OPEN)? CLOSE_EAST : VoxelShapes.empty();
		}
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }
	
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
