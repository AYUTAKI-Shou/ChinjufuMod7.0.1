package com.ayutaki.chinjufumod.world.features;

import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;
import com.google.common.collect.ImmutableList;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

/* Can not use Config_CM!! */
public class FeaturePlaced_CM {

	/* Surface...MiscOverworldPlacements */
	public static final ResourceKey<PlacedFeature> AUTUMN_PLACE = createKey("autumn_place");

	/* Tree...TreePlacements */
	public static final ResourceKey<PlacedFeature> OAK_PLACE = createKey("oak_place");
	public static final ResourceKey<PlacedFeature> OAK_FANCY_PLACE = createKey("fancy_oak_place");
	public static final ResourceKey<PlacedFeature> SAKURA_PLACE = createKey("sakura_place");
	public static final ResourceKey<PlacedFeature> SAKURA_FANCY_PLACE = createKey("fancy_sakura_place");
	public static final ResourceKey<PlacedFeature> SAKURA_BEES_PLACE = createKey("sakura_bees_place");

	public static final ResourceKey<PlacedFeature> KAEDE_PLACE = createKey("kaede_place");
	public static final ResourceKey<PlacedFeature> KAEDE_FANCY_PLACE = createKey("kaede_oak_place");
	public static final ResourceKey<PlacedFeature> ICHOH_PLACE = createKey("ichoh_place");
	public static final ResourceKey<PlacedFeature> ICHOH_FANCY_PLACE = createKey("fancy_ichoh_place");
	public static final ResourceKey<PlacedFeature> OAKKARE_PLACE = createKey("autumnoak_place");
	public static final ResourceKey<PlacedFeature> OAKKARE_FANCY_PLACE = createKey("fancy_autumnoak_place");

	
	/* Forest...VegetationPlacements */
	public static final ResourceKey<PlacedFeature> SAKURA_OAK_PLACE = createKey("sakura_oak_place");
	public static final ResourceKey<PlacedFeature> SAKURA_OAK_HILLS_PLACE = createKey("sakura_oak_hills_place");
	public static final ResourceKey<PlacedFeature> KAEDE_AUTUMNOAK_PLACE = createKey("kaede_autumnoak_place");
	public static final ResourceKey<PlacedFeature> KAEDE_AUTUMNOAK_HILLS_PLACE = createKey("kaede_autumnoak_hills_place");
	public static final ResourceKey<PlacedFeature> ICHOH_AUTUMNOAK_PLACE = createKey("ichoh_autumnoak_place");
	public static final ResourceKey<PlacedFeature> ICHOH_AUTUMNOAK_HILLS_PLACE = createKey("ichoh_autumnoak_hills_place");
	/** VegetationPlacements.PATCH_WATERLILLY **/
	public static final ResourceKey<PlacedFeature> TAKENOKO_PLACE = createKey("takenoko_place");
	public static final ResourceKey<PlacedFeature> TAKENOKO_HILLS_PLACE = createKey("takenoko_hills_place");
	public static final ResourceKey<PlacedFeature> KURIIGA_PLACE = createKey("kuriiga_place");


	/* Ore...OrePlacements */
	public static final ResourceKey<PlacedFeature> BAUXITEORE_PLACE = createKey("ore_bauxite_place"); // low-high
	public static final ResourceKey<PlacedFeature> BAUXITEORE_DEEPPLACE = createKey("ore_bauxite_deepplace");

	private static ResourceKey<PlacedFeature> createKey(final String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ChinjufuMod.MOD_ID, name));
	}
	
	
	/////* Bootstap */////
	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configFeature = context.lookup(Registries.CONFIGURED_FEATURE);
		register(context, AUTUMN_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.AUTUMN_CONFIG), CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
		
		
		register(context, OAK_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.OAK_CONFIG), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		register(context, OAK_FANCY_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.OAK_FANCY_CONFIG), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		register(context, SAKURA_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.SAKURA_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.SAKURA_nae.get()));
		register(context, SAKURA_FANCY_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.SAKURA_FANCY_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.SAKURA_nae.get()));
		register(context, SAKURA_BEES_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.SAKURA_BEES_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.SAKURA_nae.get()));
		register(context, KAEDE_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.KAEDE_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.KAEDE_nae.get()));
		register(context, KAEDE_FANCY_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.KAEDE_FANCY_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.KAEDE_nae.get()));
		register(context, ICHOH_PLACE , configFeature.getOrThrow(FeatureConfigured_CM.ICHOH_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.ICHOH_nae.get()));
		register(context, ICHOH_FANCY_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.ICHOH_FANCY_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.ICHOH_nae.get()));
		register(context, OAKKARE_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.OAKKARE_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.OAKKARE_nae.get()));
		register(context, OAKKARE_FANCY_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.OAKKARE_FANCY_CONFIG), PlacementUtils.filteredByBlockSurvival(Wood_Blocks.OAKKARE_nae.get()));
		
		register(context, SAKURA_OAK_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.SAKURA_OAK), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		register(context, SAKURA_OAK_HILLS_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.SAKURA_OAK_HILLS), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		register(context, KAEDE_AUTUMNOAK_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.KAEDE_AUTUMNOAK), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		register(context, KAEDE_AUTUMNOAK_HILLS_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.KAEDE_AUTUMNOAK_HILLS), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		register(context, ICHOH_AUTUMNOAK_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.ICHOH_AUTUMNOAK), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		register(context, ICHOH_AUTUMNOAK_HILLS_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.ICHOH_AUTUMNOAK_HILLS), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		
		register(context, TAKENOKO_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.TAKENOKO_CONFIG), 
				List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		register(context, TAKENOKO_HILLS_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.TAKENOKO_HILLS_CONFIG), 
				List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		register(context, KURIIGA_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.KURIIGA_CONFIG), 
				List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		
		
		register(context, BAUXITEORE_PLACE, configFeature.getOrThrow(FeatureConfigured_CM.BAUXITE_ORE_CONFIG), 
				List.of(CountPlacement.of(8), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)))); // low-high
		register(context, BAUXITEORE_DEEPPLACE, configFeature.getOrThrow(FeatureConfigured_CM.BAUXITE_ORE_CONFIG), 
				List.of(CountPlacement.of(8), HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(0))));
	}
	
	/* Share variables */
	private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier modifier) {
		return ImmutableList.<PlacementModifier>builder().add(modifier).add(InSquarePlacement.spread())
				.add(SurfaceWaterDepthFilter.forMaxDepth(0)).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	public static List<PlacementModifier> treePlacement(PlacementModifier modifier) {
		return treePlacementBase(modifier).build();
	}
			
	private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configFeature, List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configFeature, List.copyOf(modifiers)));
	}

	private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configFeature, PlacementModifier... modifiers) {
		register(context, key, configFeature, List.of(modifiers));
	}
}
