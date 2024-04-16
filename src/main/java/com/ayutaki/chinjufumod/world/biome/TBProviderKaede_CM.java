package com.ayutaki.chinjufumod.world.biome;

import java.util.function.Consumer;

import com.ayutaki.chinjufumod.Config_CM;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class TBProviderKaede_CM extends Region {

	public TBProviderKaede_CM(ResourceLocation name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}
	
	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
			if (Config_CM.INSTANCE.chestnutsFall.get() == true) { 
				builder.replaceBiome(Biomes.FOREST, BiomeKey_CM.KAEDE_FOREST_KEY);
				builder.replaceBiome(Biomes.TAIGA, BiomeKey_CM.KAEDE_HILLS_KEY); }
			
			if (Config_CM.INSTANCE.chestnutsFall.get() != true) { 
				builder.replaceBiome(Biomes.FOREST, BiomeKey_CM.KAEDE_FORESTB_KEY);
				builder.replaceBiome(Biomes.TAIGA, BiomeKey_CM.KAEDE_HILLSB_KEY); }
		});
	}
}
