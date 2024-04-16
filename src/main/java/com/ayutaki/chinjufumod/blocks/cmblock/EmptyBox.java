package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseWaterLogged;

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

public class EmptyBox extends BaseWaterLogged {

	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(0.01D, 0.0D, 0.01D, 15.99D, 1.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 15.99D, 16.0D, 1.0D),
			Block.box(0.01D, 0.0D, 15.0D, 15.99D, 16.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 1.0D, 16.0D, 15.99D),
			Block.box(15.0D, 0.0D, 0.01D, 15.99D, 16.0D, 15.99D));

	public EmptyBox(AbstractBlock.Properties properties) {
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
	
	/* Flammable Block */
	/** IForgeBlock.class Called when fire is updating, checks if a block face can catch fire. **/
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	/** Called when fire is updating on a neighbor block. **/
	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	/**Chance that fire will spread and consume this block. 300 being a 100% chance, 0, being a 0% chance **/
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }

}
