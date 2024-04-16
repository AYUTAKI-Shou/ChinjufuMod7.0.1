package com.ayutaki.chinjufumod.blocks.season;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WoodButtonBlock;
import net.minecraftforge.common.ToolType;

public class WoodButton_CM extends WoodButtonBlock {

	public WoodButton_CM(Block.Properties properties) {
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
