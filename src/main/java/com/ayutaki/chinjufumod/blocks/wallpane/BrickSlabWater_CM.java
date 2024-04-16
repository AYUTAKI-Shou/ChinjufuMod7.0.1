package com.ayutaki.chinjufumod.blocks.wallpane;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraftforge.common.ToolType;

public class BrickSlabWater_CM extends SlabBlock {

	public BrickSlabWater_CM(Block.Properties properties) {
		super(properties);
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
