package com.ayutaki.chinjufumod.world.features;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeModifiers_CM {

	public static final ResourceKey<BiomeModifier> ADD_BAUXITEORE = createKey("add_ore_bauxite");
	public static final ResourceKey<BiomeModifier> ADD_BAUXITEORE_DEEPPLACE = createKey("add_ore_bauxite_deepplace");
	
	private static ResourceKey<BiomeModifier> createKey(final String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ChinjufuMod.MOD_ID, name));
	}
	
	
	/////* Bootstap */////
	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		var biomes = context.lookup(Registries.BIOME);

		context.register(ADD_BAUXITEORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
						HolderSet.direct(placedFeatures.getOrThrow(FeaturePlaced_CM.BAUXITEORE_PLACE)),
						GenerationStep.Decoration.UNDERGROUND_ORES));

		context.register(ADD_BAUXITEORE_DEEPPLACE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
						HolderSet.direct(placedFeatures.getOrThrow(FeaturePlaced_CM.BAUXITEORE_DEEPPLACE)),
						GenerationStep.Decoration.UNDERGROUND_ORES));
	}
}
