package com.ayutaki.chinjufumod.blocks.harbor;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class Keiryu extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.box(3.0D, 6.0D, 0.0D, 13.0D, 11.0D, 12.0D),
			Block.box(3.0D, 0.0D, 0.0D, 13.0D, 6.0D, 7.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(Block.box(4.0D, 6.0D, 3.0D, 16.0D, 11.0D, 13.0D),
					Block.box(9.0D, 0.0D, 3.0D, 16.0D, 6.0D, 13.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.box(3.0D, 6.0D, 4.0D, 13.0D, 11.0D, 16.0D),
			Block.box(3.0D, 0.0D, 9.0D, 13.0D, 6.0D, 16.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(Block.box(0.0D, 6.0D, 3.0D, 12.0D, 11.0D, 13.0D),
			Block.box(0.0D, 0.0D, 3.0D, 7.0D, 6.0D, 13.0D));

	public Keiryu(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
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
