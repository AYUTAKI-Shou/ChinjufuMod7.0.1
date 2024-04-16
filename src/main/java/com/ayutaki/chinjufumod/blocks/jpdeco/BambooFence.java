package com.ayutaki.chinjufumod.blocks.jpdeco;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BambooFence extends FenceBlock {

	private static final VoxelShape AABB_CENTER = Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	private static final VoxelShape AABB_NORTH = Block.makeCuboidShape(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 6.5D);
	private static final VoxelShape AABB_EAST = Block.makeCuboidShape(9.5D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	private static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(6.5D, 0.0D, 9.5D, 9.5D, 16.0D, 16.0D);
	private static final VoxelShape AABB_WEST = Block.makeCuboidShape(0.0D, 0.0D, 6.5D, 6.5D, 16.0D, 9.5D);

	public BambooFence(Block.Properties properties) {
		super(properties);
	}

	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.get(NORTH).booleanValue();
		boolean east = state.get(EAST).booleanValue();
		boolean south = state.get(SOUTH).booleanValue();
		boolean west = state.get(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) { shape = VoxelShapes.or(shape); }
		if (north) { shape = VoxelShapes.or(shape, AABB_NORTH); }
		if (south) { shape = VoxelShapes.or(shape, AABB_SOUTH); }
		if (east) { shape = VoxelShapes.or(shape, AABB_EAST); }
		if (west) { shape = VoxelShapes.or(shape, AABB_WEST); }

		return shape;
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
