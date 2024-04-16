package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.world.features.FeatureConfigured_CM;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class Tree_Ichoh extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random rand, boolean t_f) {
		return (rand.nextInt(20) == 0)? FeatureConfigured_CM.ICHOH_FANCY_CONFIG.getHolder().orElseThrow() : FeatureConfigured_CM.ICHOH_CONFIG.getHolder().orElseThrow();
	}
}