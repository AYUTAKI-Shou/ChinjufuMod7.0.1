package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/* 発生させる木は 各Tree.java で決める */
public class CM_SaplingBlock extends SaplingBlock {

	@SuppressWarnings("unused")
	private final Tree tree;

	public CM_SaplingBlock(Tree treeIn, Properties properties) {
		super(treeIn, properties);
		this.tree = treeIn;
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || 
				block == Blocks.PODZOL || block == Blocks.FARMLAND || block == Wood_Blocks.FALL_LEAF;
	}
}
