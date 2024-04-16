package com.ayutaki.chinjufumod.blocks.wood;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class WoodPillar_CM extends RotatedPillarBlock {

	public WoodPillar_CM(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		if (this == Wood_Blocks.SAKURA_log) { return new ItemStack(Items_Seasonal.SAKURA_log); }
		if (this == Wood_Blocks.KAEDE_log) { return new ItemStack(Items_Seasonal.KAEDE_log); }
		if (this == Wood_Blocks.ICHOH_log) { return new ItemStack(Items_Seasonal.ICHOH_log); }
		if (this == Wood_Blocks.PILLAR_saku) { return new ItemStack(Items_Seasonal.PILLAR_saku); }
		if (this == Wood_Blocks.PILLAR_kae) { return new ItemStack(Items_Seasonal.PILLAR_kae); }
		if (this == Wood_Blocks.PILLAR_ich) { return new ItemStack(Items_Seasonal.PILLAR_ich); }
		
		if (this == WallPanel_Blocks.PILLAR_oak) { return new ItemStack(Items_WallPanel.PILLAR_oak); }
		if (this == WallPanel_Blocks.PILLAR_spru) { return new ItemStack(Items_WallPanel.PILLAR_spru); }
		if (this == WallPanel_Blocks.PILLAR_bir) { return new ItemStack(Items_WallPanel.PILLAR_bir); }
		if (this == WallPanel_Blocks.PILLAR_jun) { return new ItemStack(Items_WallPanel.PILLAR_jun); }
		if (this == WallPanel_Blocks.PILLAR_aca) { return new ItemStack(Items_WallPanel.PILLAR_aca); }
		if (this == WallPanel_Blocks.PILLAR_doak) { return new ItemStack(Items_WallPanel.PILLAR_doak); }
		return new ItemStack(Items.OAK_LOG);
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }
	
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
