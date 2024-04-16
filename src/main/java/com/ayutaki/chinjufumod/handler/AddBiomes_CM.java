package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddBiomes_CM {

	public static final RegistryKey<Biome> SAKURA_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, "biome_sakura"));
	public static final RegistryKey<Biome> SAKURA_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, "biome_sakurahills"));
	public static final RegistryKey<Biome> ACER_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, "biome_kaede"));
	public static final RegistryKey<Biome> ACER_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, "biome_kaedehills"));
	public static final RegistryKey<Biome> GINKGO_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, "biome_ichoh"));
	public static final RegistryKey<Biome> GINKGO_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ChinjufuMod.MOD_ID, "biome_ichohhills"));

	public static void addBiomes() {

		if (Config_CM.getInstance().sakuraBiomeGene() == true) {
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(SAKURA_FOREST_KEY, Config_CM.getInstance().sakuraBiomeChance()));
			BiomeDictionary.addTypes(SAKURA_FOREST_KEY, Type.FOREST, Type.OVERWORLD);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(SAKURA_HILLS_KEY, Config_CM.getInstance().sakuraBiomeChance()));
			BiomeDictionary.addTypes(SAKURA_HILLS_KEY, Type.HILLS, Type.OVERWORLD); }

		if (Config_CM.getInstance().sakuraBiomeGene() != true) { }


		if (Config_CM.getInstance().kaedeBiomeGene() == true) {
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ACER_FOREST_KEY, Config_CM.getInstance().kaedeBiomeChance()));
			BiomeDictionary.addTypes(ACER_FOREST_KEY, Type.FOREST, Type.OVERWORLD);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(ACER_HILLS_KEY, Config_CM.getInstance().kaedeBiomeChance()));
			BiomeDictionary.addTypes(ACER_HILLS_KEY, Type.HILLS, Type.OVERWORLD); }

		if (Config_CM.getInstance().kaedeBiomeGene() != true) { }


		if (Config_CM.getInstance().ichohBiomeGene() == true) {
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(GINKGO_FOREST_KEY, Config_CM.getInstance().ichohBiomeChance()));
			BiomeDictionary.addTypes(GINKGO_FOREST_KEY, Type.FOREST, Type.OVERWORLD);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(GINKGO_HILLS_KEY, Config_CM.getInstance().ichohBiomeChance()));
			BiomeDictionary.addTypes(GINKGO_HILLS_KEY, Type.HILLS, Type.OVERWORLD); }

		if (Config_CM.getInstance().ichohBiomeGene() != true) { }

	}

}
