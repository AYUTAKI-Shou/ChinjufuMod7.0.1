package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraftforge.common.ToolType;

public class Base_Stairs_JP extends StairsBlock {

	@SuppressWarnings("deprecation")
	public Base_Stairs_JP(BlockState state, Block.Properties properties) {
		super(state, properties);
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
