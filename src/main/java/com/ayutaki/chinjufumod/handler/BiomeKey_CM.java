package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeKey_CM {
	
	public static final ResourceKey<Biome> SAKURA_FOREST_KEY = register("biome_sakura");
	public static final ResourceKey<Biome> SAKURA_HILLS_KEY = register("biome_sakurahills");

	public static final ResourceKey<Biome> KAEDE_FOREST_KEY = register("biome_kaede");
	public static final ResourceKey<Biome> KAEDE_HILLS_KEY = register("biome_kaedehills");
	
	public static final ResourceKey<Biome> ICHOH_FOREST_KEY = register("biome_ichoh");
	public static final ResourceKey<Biome> ICHOH_HILLS_KEY = register("biome_ichohhills");
	
	///* Register *///
	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, name));
	}
}
