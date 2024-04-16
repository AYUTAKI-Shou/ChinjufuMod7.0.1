package com.ayutaki.chinjufumod.world.biome;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BiomeKey_CM {

	public static final ResourceKey<Biome> SAKURA_FOREST_KEY = createKey("biome_sakura");
	public static final ResourceKey<Biome> SAKURA_HILLS_KEY = createKey("biome_sakurahills");

	public static final ResourceKey<Biome> KAEDE_FOREST_KEY = createKey("biome_kaede");
	public static final ResourceKey<Biome> KAEDE_HILLS_KEY = createKey("biome_kaedehills");
	public static final ResourceKey<Biome> KAEDE_FORESTB_KEY = createKey("biome_kaede_b");
	public static final ResourceKey<Biome> KAEDE_HILLSB_KEY = createKey("biome_kaedehills_b");
	
	public static final ResourceKey<Biome> ICHOH_FOREST_KEY = createKey("biome_ichoh");
	public static final ResourceKey<Biome> ICHOH_HILLS_KEY = createKey("biome_ichohhills");
	public static final ResourceKey<Biome> ICHOH_FORESTB_KEY = createKey("biome_ichoh_b");
	public static final ResourceKey<Biome> ICHOH_HILLSB_KEY = createKey("biome_ichohhills_b");
	
	///* Register *///
	private static ResourceKey<Biome> createKey(String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(ChinjufuMod.MOD_ID, name));
	}
	
	public static void bootstrap(BootstapContext<Biome> context) {
		HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> worldCarver = context.lookup(Registries.CONFIGURED_CARVER);
		
		context.register(SAKURA_FOREST_KEY, BiomeMaker_CM.makeSakuraBiome(placedFeature, worldCarver));
		context.register(SAKURA_HILLS_KEY, BiomeMaker_CM.makeSakuraHills(placedFeature, worldCarver));
		/** True will put KuriBush. **/
		context.register(KAEDE_FOREST_KEY, BiomeMaker_CM.makeKaedeBiome(placedFeature, worldCarver, false));
		context.register(KAEDE_HILLS_KEY, BiomeMaker_CM.makeKaedeHills(placedFeature, worldCarver, false));
		context.register(KAEDE_FORESTB_KEY, BiomeMaker_CM.makeKaedeBiome(placedFeature, worldCarver, true));
		context.register(KAEDE_HILLSB_KEY, BiomeMaker_CM.makeKaedeHills(placedFeature, worldCarver, true));
		
		context.register(ICHOH_FOREST_KEY, BiomeMaker_CM.makeIchohBiome(placedFeature, worldCarver, false));
		context.register(ICHOH_HILLS_KEY, BiomeMaker_CM.makeIchohHills(placedFeature, worldCarver, false));
		context.register(ICHOH_FORESTB_KEY, BiomeMaker_CM.makeIchohBiome(placedFeature, worldCarver, true));
		context.register(ICHOH_HILLSB_KEY, BiomeMaker_CM.makeIchohHills(placedFeature, worldCarver, true));
	}
}
