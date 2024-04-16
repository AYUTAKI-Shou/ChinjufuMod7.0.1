package com.ayutaki.chinjufumod.blocks.wood;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraftforge.common.ToolType;

public class WoodStairs_CM extends StairsBlock {

	@SuppressWarnings("deprecation")
	public WoodStairs_CM(BlockState state, Block.Properties properties) {
		super(state, properties);
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
