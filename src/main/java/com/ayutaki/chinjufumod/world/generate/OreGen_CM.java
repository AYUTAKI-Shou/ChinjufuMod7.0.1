package com.ayutaki.chinjufumod.world.generate;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.Features_CM;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen_CM {

	public static void generate(final BiomeLoadingEvent biomeevent) {

		Category category = biomeevent.getCategory();
		BiomeGenerationSettingsBuilder builder = biomeevent.getGeneration();

		if (Config_CM.getInstance().bauxiteGene() == true) {
			if (category != Biome.Category.NETHER && category != Biome.Category.THEEND) {
				builder.addFeature(Decoration.UNDERGROUND_ORES, Features_CM.BAUXITE_ORE_CONFIG); } }

		if (Config_CM.getInstance().bauxiteGene() != true) { }
	}

}
