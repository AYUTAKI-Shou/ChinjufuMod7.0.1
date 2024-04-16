package com.ayutaki.chinjufumod.world.generate;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.world.features.FeaturePlaced_CM;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen_CM {
	
	// OreGen_CM generate works by @SubscribeEvent.
	public static void generate(final BiomeLoadingEvent event) {
		BiomeCategory category = event.getCategory();
		BiomeGenerationSettingsBuilder builder = event.getGeneration();

		if (Config_CM.INSTANCE.bauxiteGene.get() == true) {
			if (category != Biome.BiomeCategory.NETHER && category != Biome.BiomeCategory.THEEND) {
				builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlaced_CM.BAUXITEORE_PLACE.getHolder().orElseThrow());
				builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlaced_CM.BAUXITEORE_DEEPPLACE.getHolder().orElseThrow()); }
		}

		if (Config_CM.INSTANCE.bauxiteGene.get() != true) { }
	}
}
