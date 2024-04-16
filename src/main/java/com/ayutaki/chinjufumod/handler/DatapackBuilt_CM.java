package com.ayutaki.chinjufumod.handler;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.world.biome.BiomeKey_CM;
import com.ayutaki.chinjufumod.world.features.BiomeModifiers_CM;
import com.ayutaki.chinjufumod.world.features.FeatureConfigured_CM;
import com.ayutaki.chinjufumod.world.features.FeaturePlaced_CM;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class DatapackBuilt_CM extends DatapackBuiltinEntriesProvider {
	
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, (bootstrap) -> FeatureConfigured_CM.bootstrap(bootstrap))
			.add(Registries.PLACED_FEATURE, (bootstrap) -> FeaturePlaced_CM.bootstrap(bootstrap))
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, (bootstrap) -> BiomeModifiers_CM.bootstrap(bootstrap))
			.add(Registries.BIOME, (bootstrap) -> BiomeKey_CM.bootstrap(bootstrap));
	
	public DatapackBuilt_CM(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(ChinjufuMod.MOD_ID));
	}
}
