package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AdmiralStampBlock extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(11.0D, 0.0, 11.0D, 15.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(1.0D, 0.0, 11.0D, 5.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(1.0D, 0.0, 1.0D, 5.0D, 4.0D, 5.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(11.0D, 0.0, 1.0D, 15.0D, 4.0D, 5.0D);

	public AdmiralStampBlock(Block.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		switch(direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
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
	
	/* 上からの光透過 */
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
}
