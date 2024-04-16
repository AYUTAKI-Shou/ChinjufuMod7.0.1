package com.ayutaki.chinjufumod.world.generate;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.BiomeKey_CM;
import com.ayutaki.chinjufumod.world.features.FeaturePlaced_CM;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class KuriBush_Gen {
	
	public static void generate(final BiomeLoadingEvent event) {
		BiomeCategory category = event.getCategory();
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
		
		if (Config_CM.INSTANCE.chestnutsFall.get() == true) { }
		
		if (Config_CM.INSTANCE.chestnutsFall.get() != true) {
			if (category == Biome.BiomeCategory.NETHER || category == Biome.BiomeCategory.THEEND) { }
			
			if (key == BiomeKey_CM.ICHOH_FOREST_KEY || key == BiomeKey_CM.ICHOH_HILLS_KEY ||
					key == BiomeKey_CM.KAEDE_FOREST_KEY || key == BiomeKey_CM.KAEDE_HILLS_KEY) {
				builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KURIIGA_PLACE.getHolder().orElseThrow());
			}
		}
	}
}
