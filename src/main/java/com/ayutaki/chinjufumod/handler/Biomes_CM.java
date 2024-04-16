package com.ayutaki.chinjufumod.handler;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.world.biomegen.Biome_Ichoh;
import com.ayutaki.chinjufumod.world.biomegen.Biome_IchohHills;
import com.ayutaki.chinjufumod.world.biomegen.Biome_Kaede;
import com.ayutaki.chinjufumod.world.biomegen.Biome_KaedeHills;
import com.ayutaki.chinjufumod.world.biomegen.Biome_Sakura;
import com.ayutaki.chinjufumod.world.biomegen.Biome_SakuraHills;
import com.ayutaki.chinjufumod.world.biomegen.ModBiomeBase;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;

public class Biomes_CM {

	public static final List<ModBiomeEntry> biomeEntryList = new ArrayList<>();

	public static final Biome_Sakura BIOME_SAKURA = new Biome_Sakura();
	public static final Biome_SakuraHills BIOME_SAKURA_HILL = new Biome_SakuraHills();
	public static final Biome_Kaede BIOME_KAEDE = new Biome_Kaede();
	public static final Biome_KaedeHills BIOME_KAEDE_HILL = new Biome_KaedeHills();
	public static final Biome_Ichoh BIOME_ICHOH = new Biome_Ichoh();
	public static final Biome_IchohHills BIOME_ICHOH_HILL = new Biome_IchohHills();

	public static void registerBiomes(RegistryEvent.Register<Biome> event) {

		/* コンフィグで登録するか, しないかを決める*/
		if (Config_CM.sakuraBiomeRegister == true) {
			event.getRegistry().register(BIOME_SAKURA);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
					new BiomeManager.BiomeEntry(BIOME_SAKURA, Config_CM.sakuraBiomeChance / 2));
			BiomeManager.addSpawnBiome(BIOME_SAKURA);

			event.getRegistry().register(BIOME_SAKURA_HILL);
			BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
					new BiomeManager.BiomeEntry(BIOME_SAKURA_HILL, Config_CM.sakuraBiomeChance / 2));
			BiomeManager.addSpawnBiome(BIOME_SAKURA_HILL);

		}
		if (Config_CM.sakuraBiomeRegister != true) { }

		if (Config_CM.kaedeBiomeRegister == true) {
			event.getRegistry().register(BIOME_KAEDE);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
					new BiomeManager.BiomeEntry(BIOME_KAEDE, Config_CM.kaedeBiomeChance / 2));
			BiomeManager.addSpawnBiome(BIOME_KAEDE);

			event.getRegistry().register(BIOME_KAEDE_HILL);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
					new BiomeManager.BiomeEntry(BIOME_KAEDE_HILL, Config_CM.kaedeBiomeChance / 2));
			BiomeManager.addSpawnBiome(BIOME_KAEDE_HILL);

		}
		if (Config_CM.kaedeBiomeRegister != true) { }

		if (Config_CM.ichohBiomeRegister == true) {
			event.getRegistry().register(BIOME_ICHOH);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
					new BiomeManager.BiomeEntry(BIOME_ICHOH, Config_CM.ichohBiomeChance / 2));
			BiomeManager.addSpawnBiome(BIOME_ICHOH);

			event.getRegistry().register(BIOME_ICHOH_HILL);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
					new BiomeManager.BiomeEntry(BIOME_ICHOH_HILL, Config_CM.ichohBiomeChance / 2));
			BiomeManager.addSpawnBiome(BIOME_ICHOH_HILL);

		}
		if (Config_CM.ichohBiomeRegister != true) { }

	}

	@SuppressWarnings("unused")
	private static void registerBiome(RegistryEvent.Register<Biome> event,
			ModBiomeBase biome, BiomeType type, int weight, BiomeDictionary.Type... biomeDictTypes) {
		event.getRegistry().register(biome);

		// add all biomeDictTypes for said biome
		for (BiomeDictionary.Type biomeDictType : biomeDictTypes) {
			BiomeDictionary.addTypes(biome, biomeDictType);
		}

		// add biome to the biomeEntry list if weight is not 0
		biomeEntryList.add(new ModBiomeEntry(biome, type, weight));
	}

	public static class ModBiomeEntry {

		private final int weight;
		private final Biome biome;
		private final BiomeType type;
		private final BiomeManager.BiomeEntry entry;

		private ModBiomeEntry(ModBiomeBase biome, BiomeType type, int weight) {
			this.type = type;
			this.biome = biome;
			this.weight = weight;
			this.entry = new BiomeManager.BiomeEntry(biome, weight);
		}

		public ModBiomeBase getBiome() {
			return (ModBiomeBase) this.biome;
		}

		public BiomeManager.BiomeEntry getEntry() {
			return this.entry;
		}

		public BiomeType getType() {
			return this.type;
		}

		public int getWeight() {
			return this.weight;
		}
	}

}
