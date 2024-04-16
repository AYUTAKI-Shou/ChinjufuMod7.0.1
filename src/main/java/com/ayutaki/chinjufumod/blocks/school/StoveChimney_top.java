package com.ayutaki.chinjufumod.blocks.school;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseWaterLogged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class StoveChimney_top extends BaseWaterLogged {

	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.makeCuboidShape(7.0D, 15.0D, 7.0D, 9.0D, 16.0D, 9.0D),
			Block.makeCuboidShape(5.5D, 14.0D, 5.5D, 10.5D, 15.0D, 10.5D),
			Block.makeCuboidShape(4.0D, 13.0D, 4.0D, 12.0D, 14.0D, 12.0D),
			Block.makeCuboidShape(5.9D, 0.0D, 5.9D, 10.1D, 13.0D, 10.1D));

	public StoveChimney_top(Block.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
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
