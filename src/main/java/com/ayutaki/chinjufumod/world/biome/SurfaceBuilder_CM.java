package com.ayutaki.chinjufumod.world.biome;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SurfaceBuilder_CM {

	/* SurfaceBuilderConfig(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial) */
	public static final SurfaceBuilderConfig AUTUMN_CONFIG =
			new SurfaceBuilderConfig(Wood_Blocks.FALL_LEAF.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

}
