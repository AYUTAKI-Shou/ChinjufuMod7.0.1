package com.ayutaki.chinjufumod.world.generate;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.Features_CM;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class KuriBush_Gen {

	public static void generate(final BiomeLoadingEvent biomeevent) {
		Category category = biomeevent.getCategory();
		BiomeGenerationSettingsBuilder builder = biomeevent.getGeneration();
		
		if (Config_CM.getInstance().chestnutsFall() == true) { }
		
		if (Config_CM.getInstance().chestnutsFall() != true) {
			for (Biome biomeIn : ForgeRegistries.BIOMES) {
				if (category == Biome.Category.NETHER || category == Biome.Category.THEEND) { }
				
				if (biomeIn == Biomes_CM.ACER_FOREST.get() || biomeIn == Biomes_CM.ACER_FOREST.get() ||
						biomeIn == Biomes_CM.GINKGO_FOREST.get() || biomeIn == Biomes_CM.GINKGO_FOREST.get()) {
					builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.KURIIGA_CONFIG); }
			}
		}
	}

}
