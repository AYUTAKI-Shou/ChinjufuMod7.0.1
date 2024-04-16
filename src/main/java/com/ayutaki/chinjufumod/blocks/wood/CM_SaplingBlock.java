package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/* The tree to be grown is decided in each Tree.java. */
public class CM_SaplingBlock extends SaplingBlock {

	@SuppressWarnings("unused")
	private final AbstractTreeGrower treeGrower;
	
	public CM_SaplingBlock(AbstractTreeGrower treeIn, BlockBehaviour.Properties properties) {
		super(treeIn, properties);
		treeGrower = treeIn;
	}
	
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return state.is(BlockTags.DIRT) || state.is(Blocks.FARMLAND) || block == Wood_Blocks.FALL_LEAF.get();
	}
}
