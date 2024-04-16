package com.ayutaki.chinjufumod.blocks.school;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class SchoolDesk extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.makeCuboidShape(-3.0D, 15.0D, 0.0D, 19.0D, 16.0D, 16.0D), 
			Block.makeCuboidShape(-2.0D, 11.0D, 1.0D, 18.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(-2.0D, 3.0D, 1.0D, 18.0D, 5.0D, 2.0D),
			Block.makeCuboidShape(-2.0D, 0.0D, 1.0D, 0.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(16.0D, 0.0D, 1.0D, 18.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, -3.0D, 16.0D, 16.0D, 19.0D), 
			Block.makeCuboidShape(1.0D, 11.0D, -2.0D, 15.0D, 15.0D, 18.0D),
			Block.makeCuboidShape(14.0D, 3.0D, -2.0D, 15.0D, 5.0D, 18.0D),
			Block.makeCuboidShape(1.0D, 0.0D, -2.0D, 15.0D, 15.0D, 0.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 16.0D, 15.0D, 15.0D, 18.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.makeCuboidShape(-3.0D, 15.0D, 0.0D, 19.0D, 16.0D, 16.0D), 
			Block.makeCuboidShape(-2.0D, 11.0D, 1.0D, 18.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(-2.0D, 3.0D, 14.0D, 18.0D, 5.0D, 15.0D),
			Block.makeCuboidShape(-2.0D, 0.0D, 1.0D, 0.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(16.0D, 0.0D, 1.0D, 18.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, -3.0D, 16.0D, 16.0D, 19.0D), 
			Block.makeCuboidShape(1.0D, 11.0D, -2.0D, 15.0D, 15.0D, 18.0D),
			Block.makeCuboidShape(1.0D, 3.0D, -2.0D, 2.0D, 5.0D, 18.0D),
			Block.makeCuboidShape(1.0D, 0.0D, -2.0D, 15.0D, 15.0D, 0.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 16.0D, 15.0D, 15.0D, 18.0D));

	public SchoolDesk(Block.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
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
