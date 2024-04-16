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

public class TBProviderIchoh_CM extends Region {

	public TBProviderIchoh_CM(ResourceLocation name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}
	
	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
			if (Config_CM.INSTANCE.chestnutsFall.get() == true) { 			
				builder.replaceBiome(Biomes.FOREST, BiomeKey_CM.ICHOH_FOREST_KEY);
				builder.replaceBiome(Biomes.TAIGA, BiomeKey_CM.ICHOH_HILLS_KEY); }
			
			if (Config_CM.INSTANCE.chestnutsFall.get() != true) { 			
				builder.replaceBiome(Biomes.FOREST, BiomeKey_CM.ICHOH_FORESTB_KEY);
				builder.replaceBiome(Biomes.TAIGA, BiomeKey_CM.ICHOH_HILLSB_KEY); }
		});
	}
}
