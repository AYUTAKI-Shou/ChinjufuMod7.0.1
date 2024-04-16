package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.Features_CM;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class Tree_AutumnOak extends Tree {

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return randomIn.nextInt(20) == 0 ? TreeFeature.FANCY_TREE.withConfiguration(Features_CM.OAKKARE_FANCY_CONFIG) : TreeFeature.NORMAL_TREE.withConfiguration(Features_CM.OAKKARE_CONFIG);
	}

}
