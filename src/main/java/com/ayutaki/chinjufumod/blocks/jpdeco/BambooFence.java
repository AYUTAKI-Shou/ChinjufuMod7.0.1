package com.ayutaki.chinjufumod.blocks.jpdeco;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BambooFence extends FenceBlock {

	private static final VoxelShape AABB_CENTER = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	private static final VoxelShape AABB_NORTH = Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 6.5D);
	private static final VoxelShape AABB_EAST = Block.box(9.5D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	private static final VoxelShape AABB_SOUTH = Block.box(6.5D, 0.0D, 9.5D, 9.5D, 16.0D, 16.0D);
	private static final VoxelShape AABB_WEST = Block.box(0.0D, 0.0D, 6.5D, 6.5D, 16.0D, 9.5D);

	public BambooFence(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) { shape = VoxelShapes.or(shape); }
		if (north) { shape = VoxelShapes.or(shape, AABB_NORTH); }
		if (south) { shape = VoxelShapes.or(shape, AABB_SOUTH); }
		if (east) { shape = VoxelShapes.or(shape, AABB_EAST); }
		if (west) { shape = VoxelShapes.or(shape, AABB_WEST); }

		return shape;
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
