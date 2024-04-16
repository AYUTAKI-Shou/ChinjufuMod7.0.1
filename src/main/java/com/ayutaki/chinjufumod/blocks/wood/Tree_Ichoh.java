package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.world.features.FeatureConfigured_CM;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class Tree_Ichoh extends AbstractTreeGrower {
	
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource rand, boolean t_f) {
		return (rand.nextInt(20) == 0)? FeatureConfigured_CM.ICHOH_FANCY_CONFIG : FeatureConfigured_CM.ICHOH_CONFIG;
	}
}
