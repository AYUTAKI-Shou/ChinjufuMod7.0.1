package com.ayutaki.chinjufumod.world.biome;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilder_CM {

	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, ChinjufuMod.MOD_ID);

	/* SurfaceBuilderConfig(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial) */
	public static final SurfaceBuilderConfig AUTUMN_CONFIG =
			new SurfaceBuilderConfig(Wood_Blocks.FALL_LEAF.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState());


	/* net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders.class */
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> AUTUMN = register("autumn", SurfaceBuilder.DEFAULT.configured(AUTUMN_CONFIG));

	private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> config) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, name, config);
	}

}
