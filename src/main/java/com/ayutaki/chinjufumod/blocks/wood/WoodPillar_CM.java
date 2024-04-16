package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WoodPillar_CM extends RotatedPillarBlock {

	public WoodPillar_CM(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		if (this == Wood_Blocks.SAKURA_log.get()) { return new ItemStack(Items_Seasonal.SAKURA_log.get()); }
		if (this == Wood_Blocks.KAEDE_log.get()) { return new ItemStack(Items_Seasonal.KAEDE_log.get()); }
		if (this == Wood_Blocks.ICHOH_log.get()) { return new ItemStack(Items_Seasonal.ICHOH_log.get()); }
		if (this == Wood_Blocks.PILLAR_saku.get()) { return new ItemStack(Items_Seasonal.PILLAR_saku.get()); }
		if (this == Wood_Blocks.PILLAR_kae.get()) { return new ItemStack(Items_Seasonal.PILLAR_kae.get()); }
		if (this == Wood_Blocks.PILLAR_ich.get()) { return new ItemStack(Items_Seasonal.PILLAR_ich.get()); }
		
		if (this == WallPanel_Blocks.PILLAR_oak.get()) { return new ItemStack(Items_WallPanel.PILLAR_oak.get()); }
		if (this == WallPanel_Blocks.PILLAR_spru.get()) { return new ItemStack(Items_WallPanel.PILLAR_spru.get()); }
		if (this == WallPanel_Blocks.PILLAR_bir.get()) { return new ItemStack(Items_WallPanel.PILLAR_bir.get()); }
		if (this == WallPanel_Blocks.PILLAR_jun.get()) { return new ItemStack(Items_WallPanel.PILLAR_jun.get()); }
		if (this == WallPanel_Blocks.PILLAR_aca.get()) { return new ItemStack(Items_WallPanel.PILLAR_aca.get()); }
		if (this == WallPanel_Blocks.PILLAR_doak.get()) { return new ItemStack(Items_WallPanel.PILLAR_doak.get()); }
		return new ItemStack(Items.OAK_LOG);
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }
	
}
