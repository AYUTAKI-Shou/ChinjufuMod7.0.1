package com.ayutaki.chinjufumod.blocks.wood;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraftforge.common.ToolType;

public class WoodFenceGate_CM extends FenceGateBlock {

	public WoodFenceGate_CM(Block.Properties properties) {
		super(properties);
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
