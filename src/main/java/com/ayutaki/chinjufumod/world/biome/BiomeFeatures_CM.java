package com.ayutaki.chinjufumod.world.biome;

import com.ayutaki.chinjufumod.handler.Features_CM;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

/* net.minecraft.world.biome.DefaultBiomeFeatures */
public class BiomeFeatures_CM {

	public static void addIchohTree(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.ICHOH_AUTUMNOAK);
	}

	public static void addIchohHills(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.ICHOH_AUTUMNOAK_HILLS);
	}

	public static void addKaedeTree(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.KAEDE_AUTUMNOAK);
	}

	public static void addKaedeHills(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.KAEDE_AUTUMNOAK_HILLS);
	}

	public static void addSakuraTree(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.SAKURA_OAK);
	}

	public static void addSakuraHills(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.SAKURA_OAK_HILLS);
	}

	public static void addTakenoko(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.TAKENOKO_CONFIG);
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_DEFAULT);
	}
	
	public static void addTakenokoHills(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features_CM.TAKENOKO_HILLS);
		biomeSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_DEFAULT);
	}
}
