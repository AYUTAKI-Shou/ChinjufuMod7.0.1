package com.ayutaki.chinjufumod.blocks.wood;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/* 発生させる木は 各Tree.java で決める */
public class CM_SaplingBlock extends SaplingBlock {

	@SuppressWarnings("unused")
	private final Tree tree;

	public CM_SaplingBlock(Tree treeIn, AbstractBlock.Properties properties) {
		super(treeIn, properties);
		this.tree = treeIn;
	}

	/* Changed to instanceof or getMaterial(). */
	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getBlock() instanceof SpreadableSnowyDirtBlock || state.getMaterial() == Material.DIRT);
	}
}