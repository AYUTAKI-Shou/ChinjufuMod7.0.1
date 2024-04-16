package com.ayutaki.chinjufumod.world.features;

import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FeaturePlaced_CM {

	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ChinjufuMod.MOD_ID);
	
	/////* Surface...MiscOverworldPlacements */////
	public static final RegistryObject<PlacedFeature> AUTUMN_PLACE = PLACED_FEATURES.register("autumn_place",
			() -> new PlacedFeature(FeatureConfigured_CM.AUTUMN_CONFIG.getHolder().orElseThrow(), 
					List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
	
	/////* Forest...VegetationPlacements */////
	public static final RegistryObject<PlacedFeature> SAKURA_OAK_PLACE = PLACED_FEATURES.register("sakura_oak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.SAKURA_OAK.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> SAKURA_OAK_HILLS_PLACE = PLACED_FEATURES.register("sakura_oak_hills_place",
			() -> new PlacedFeature(FeatureConfigured_CM.SAKURA_OAK_HILLS.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> KAEDE_AUTUMNOAK_PLACE = PLACED_FEATURES.register("kaede_autumnoak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.KAEDE_AUTUMNOAK.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> KAEDE_AUTUMNOAK_HILLS_PLACE = PLACED_FEATURES.register("kaede_autumnoak_hills_place",
			() -> new PlacedFeature(FeatureConfigured_CM.KAEDE_AUTUMNOAK_HILLS.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> ICHOH_AUTUMNOAK_PLACE = PLACED_FEATURES.register("ichoh_autumnoak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.ICHOH_AUTUMNOAK.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> ICHOH_AUTUMNOAK_HILLS_PLACE = PLACED_FEATURES.register("ichoh_autumnoak_hills_place",
			() -> new PlacedFeature(FeatureConfigured_CM.ICHOH_AUTUMNOAK_HILLS.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	
	private static Builder<PlacementModifier> treePlacementBase(PlacementModifier modifier) {
		return ImmutableList.<PlacementModifier>builder().add(modifier).add(InSquarePlacement.spread())
				.add(SurfaceWaterDepthFilter.forMaxDepth(0)).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome()); }

	public static List<PlacementModifier> treePlacement(PlacementModifier modifier) {
		return treePlacementBase(modifier).build(); }
	
	/////* Tree...TreePlacements */////
	public static final RegistryObject<PlacedFeature> OAK_PLACE = PLACED_FEATURES.register("oak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.OAK_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> OAK_FANCY_PLACE = PLACED_FEATURES.register("fancy_oak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.OAK_FANCY_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));

	public static final RegistryObject<PlacedFeature> SAKURA_PLACE = PLACED_FEATURES.register("sakura_place",
			() -> new PlacedFeature(FeatureConfigured_CM.SAKURA_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.SAKURA_nae.get()))));
	public static final RegistryObject<PlacedFeature> SAKURA_FANCY_PLACE = PLACED_FEATURES.register("fancy_sakura_place",
			() -> new PlacedFeature(FeatureConfigured_CM.SAKURA_FANCY_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.SAKURA_nae.get()))));
	public static final RegistryObject<PlacedFeature> SAKURA_BEES_PLACE = PLACED_FEATURES.register("sakura_bees_place",
			() -> new PlacedFeature(FeatureConfigured_CM.SAKURA_BEES_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.SAKURA_nae.get()))));

	public static final RegistryObject<PlacedFeature> KAEDE_PLACE = PLACED_FEATURES.register("kaede_place",
			() -> new PlacedFeature(FeatureConfigured_CM.KAEDE_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.KAEDE_nae.get()))));
	public static final RegistryObject<PlacedFeature> KAEDE_FANCY_PLACE = PLACED_FEATURES.register("kaede_oak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.KAEDE_FANCY_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.KAEDE_nae.get()))));

	public static final RegistryObject<PlacedFeature> ICHOH_PLACE = PLACED_FEATURES.register("ichoh_place",
			() -> new PlacedFeature(FeatureConfigured_CM.ICHOH_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.ICHOH_nae.get()))));
	public static final RegistryObject<PlacedFeature> ICHOH_FANCY_PLACE = PLACED_FEATURES.register("fancy_ichoh_place",
			() -> new PlacedFeature(FeatureConfigured_CM.ICHOH_FANCY_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.ICHOH_nae.get()))));
	
	public static final RegistryObject<PlacedFeature> OAKKARE_PLACE = PLACED_FEATURES.register("autumnoak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.OAKKARE_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.OAKKARE_nae.get()))));
	public static final RegistryObject<PlacedFeature> OAKKARE_FANCY_PLACE = PLACED_FEATURES.register("fancy_autumnoak_place",
			() -> new PlacedFeature(FeatureConfigured_CM.OAKKARE_FANCY_CONFIG.getHolder().orElseThrow(), 
					List.of(PlacementUtils.filteredByBlockSurvival(Wood_Blocks.OAKKARE_nae.get()))));
	
	/** VegetationPlacements.PATCH_WATERLILLY **/
	public static final RegistryObject<PlacedFeature> TAKENOKO_PLACE = PLACED_FEATURES.register("takenoko_place", 
			() -> new PlacedFeature(FeatureConfigured_CM.TAKENOKO_CONFIG.getHolder().orElseThrow(), 
					List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TAKENOKO_HILLS_PLACE = PLACED_FEATURES.register("takenoko_hills_place", 
			() -> new PlacedFeature(FeatureConfigured_CM.TAKENOKO_HILLS_CONFIG.getHolder().orElseThrow(), 
					List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> KURIIGA_PLACE = PLACED_FEATURES.register("kuriiga_place", 
			() -> new PlacedFeature(FeatureConfigured_CM.KURIIGA_CONFIG.getHolder().orElseThrow(), 
					List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	
	/////* Ore...OrePlacements */////
	public static final RegistryObject<PlacedFeature> BAUXITEORE_PLACE = PLACED_FEATURES.register("ore_bauxite_place",
			() -> new PlacedFeature(FeatureConfigured_CM.BAUXITE_ORE_CONFIG.getHolder().orElseThrow(), 
					List.of(CountPlacement.of(Config_CM.INSTANCE.bauxiteChance.get()), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))))); // low-high
	public static final RegistryObject<PlacedFeature> BAUXITEORE_DEEPPLACE = PLACED_FEATURES.register("ore_bauxite_deepplace",
			() -> new PlacedFeature(FeatureConfigured_CM.BAUXITE_ORE_CONFIG.getHolder().orElseThrow(), 
					List.of(CountPlacement.of(Config_CM.INSTANCE.bauxiteChance.get()), HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(0)))));
}
