package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class AmmoBauxiteBox extends BaseFacingWater {

	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(0.01D, 0.0D, 0.01D, 15.99D, 15.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 15.99D, 16.0D, 1.0D),
			Block.box(0.01D, 0.0D, 15.0D, 15.99D, 16.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 1.0D, 16.0D, 15.99D),
			Block.box(15.0D, 0.0D, 0.01D, 15.99D, 16.0D, 15.99D));

	public AmmoBauxiteBox(AbstractBlock.Properties properties) {
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
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
