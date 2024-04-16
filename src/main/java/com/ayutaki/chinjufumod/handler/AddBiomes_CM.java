package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddBiomes_CM {

	public static void addBiomes() {

		if (Config_CM.getInstance().sakuraBiomeGene() == true) {
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes_CM.SAKURA_FOREST.get(), Config_CM.getInstance().sakuraBiomeChance()));
			BiomeDictionary.addTypes(Biomes_CM.SAKURA_FOREST.get(), Type.FOREST, Type.OVERWORLD);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes_CM.SAKURA_HILLS.get(), Config_CM.getInstance().sakuraBiomeChance()));
			BiomeDictionary.addTypes(Biomes_CM.SAKURA_HILLS.get(), Type.HILLS, Type.OVERWORLD);
		}
		if (Config_CM.getInstance().sakuraBiomeGene() != true) { }

		if (Config_CM.getInstance().kaedeBiomeGene() == true) {
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes_CM.ACER_FOREST.get(), Config_CM.getInstance().kaedeBiomeChance()));
			BiomeDictionary.addTypes(Biomes_CM.ACER_FOREST.get(), Type.FOREST, Type.OVERWORLD);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(Biomes_CM.ACER_HILLS.get(), Config_CM.getInstance().kaedeBiomeChance()));
			BiomeDictionary.addTypes(Biomes_CM.ACER_HILLS.get(), Type.HILLS, Type.OVERWORLD);
		}
		if (Config_CM.getInstance().kaedeBiomeGene() != true) { }

		if (Config_CM.getInstance().ichohBiomeGene() == true) {
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes_CM.GINKGO_FOREST.get(), Config_CM.getInstance().ichohBiomeChance()));
			BiomeDictionary.addTypes(Biomes_CM.GINKGO_FOREST.get(), Type.FOREST, Type.OVERWORLD);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(Biomes_CM.GINKGO_HILLS.get(), Config_CM.getInstance().ichohBiomeChance()));
			BiomeDictionary.addTypes(Biomes_CM.GINKGO_HILLS.get(), Type.HILLS, Type.OVERWORLD);
		}
		if (Config_CM.getInstance().ichohBiomeGene() != true) { }
	}

}
