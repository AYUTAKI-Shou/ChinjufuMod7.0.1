package com.ayutaki.chinjufumod.world.features;

import java.util.List;
import java.util.OptionalInt;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FeatureConfigured_CM {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIG_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ChinjufuMod.MOD_ID);

	/////* Surface...MiscOverworldFeatures */////
	public static final RegistryObject<ConfiguredFeature<?, ?>> AUTUMN_CONFIG = CONFIG_FEATURES.register("autumn", 
			()-> new ConfiguredFeature<>(Feature.DISK, new DiskConfiguration(Wood_Blocks.FALL_LEAF.get().defaultBlockState(), UniformInt.of(2, 3), 1, 
							List.of(Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState()))));

	/////* Forest...VegetationFeatures */////
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA_OAK = CONFIG_FEATURES.register("sakura_oak", 
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
					new WeightedPlacedFeature(FeaturePlaced_CM.SAKURA_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.sakuraTreeChance.get() / 10 / 30 * 29), 
					new WeightedPlacedFeature(FeaturePlaced_CM.SAKURA_FANCY_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.sakuraTreeChance.get() / 10 / 30),
					new WeightedPlacedFeature(FeaturePlaced_CM.SAKURA_BEES_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.sakuraTreeChance.get() / 10 / 300),
					new WeightedPlacedFeature(FeaturePlaced_CM.OAK_FANCY_PLACE.getHolder().orElseThrow(), (float) (10 - Config_CM.INSTANCE.sakuraTreeChance.get()) / 300)),
					FeaturePlaced_CM.OAK_PLACE.getHolder().orElseThrow())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA_OAK_HILLS = CONFIG_FEATURES.register("sakura_oak_hills", 
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
					new WeightedPlacedFeature(FeaturePlaced_CM.SAKURA_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.sakuraTreeChance.get() / 10 / 30 * 29), 
					new WeightedPlacedFeature(FeaturePlaced_CM.SAKURA_FANCY_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.sakuraTreeChance.get() / 10 / 30),
					new WeightedPlacedFeature(FeaturePlaced_CM.OAK_FANCY_PLACE.getHolder().orElseThrow(), (float) (10 - Config_CM.INSTANCE.sakuraTreeChance.get()) / 200)), 
					FeaturePlaced_CM.OAK_PLACE.getHolder().orElseThrow())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> KAEDE_AUTUMNOAK = CONFIG_FEATURES.register("kaede_autumnoak", 
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
					new WeightedPlacedFeature(FeaturePlaced_CM.KAEDE_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.kaedeTreeChance.get() / 10), 
					new WeightedPlacedFeature(FeaturePlaced_CM.OAKKARE_FANCY_PLACE.getHolder().orElseThrow(), (float) (10 - Config_CM.INSTANCE.kaedeTreeChance.get()) / 300)), 
					FeaturePlaced_CM.OAKKARE_PLACE.getHolder().orElseThrow())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> KAEDE_AUTUMNOAK_HILLS = CONFIG_FEATURES.register("kaede_autumnoak_hills", 
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
					new WeightedPlacedFeature(FeaturePlaced_CM.KAEDE_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.kaedeTreeChance.get() / 10 / 100 * 99), 
					new WeightedPlacedFeature(FeaturePlaced_CM.KAEDE_FANCY_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.kaedeTreeChance.get() / 10 / 100),
					new WeightedPlacedFeature(FeaturePlaced_CM.OAKKARE_FANCY_PLACE.getHolder().orElseThrow(), (float) (10 - Config_CM.INSTANCE.kaedeTreeChance.get()) / 200)), 
					FeaturePlaced_CM.OAKKARE_PLACE.getHolder().orElseThrow())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICHOH_AUTUMNOAK = CONFIG_FEATURES.register("ichoh_autumnoak", 
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
					new WeightedPlacedFeature(FeaturePlaced_CM.ICHOH_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.ichohTreeChance.get() / 10 / 30 * 29), 
					new WeightedPlacedFeature(FeaturePlaced_CM.ICHOH_FANCY_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.ichohTreeChance.get() / 10 / 30),
					new WeightedPlacedFeature(FeaturePlaced_CM.OAKKARE_FANCY_PLACE.getHolder().orElseThrow(), (float) (10 - Config_CM.INSTANCE.ichohTreeChance.get()) / 300)), 
					FeaturePlaced_CM.OAKKARE_PLACE.getHolder().orElseThrow())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICHOH_AUTUMNOAK_HILLS = CONFIG_FEATURES.register("ichoh_autumnoak_hills", 
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
					new WeightedPlacedFeature(FeaturePlaced_CM.ICHOH_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.ichohTreeChance.get() / 10 / 20 * 19), 
					new WeightedPlacedFeature(FeaturePlaced_CM.ICHOH_FANCY_PLACE.getHolder().orElseThrow(), (float) Config_CM.INSTANCE.ichohTreeChance.get() / 10 / 20),
					new WeightedPlacedFeature(FeaturePlaced_CM.OAKKARE_FANCY_PLACE.getHolder().orElseThrow(), (float) (10 - Config_CM.INSTANCE.ichohTreeChance.get()) / 200)), 
					FeaturePlaced_CM.OAKKARE_PLACE.getHolder().orElseThrow())));
	
	/////* Tree...TreeFeatures */////
	private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_CONFIG = CONFIG_FEATURES.register("normal_oak_cm", 
			()-> registryTree(createStraightTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_FANCY_CONFIG = CONFIG_FEATURES.register("fancy_oak_cm", 
			()-> registryTree(createFancyTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES).ignoreVines()));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA_CONFIG = CONFIG_FEATURES.register("normal_sakura", 
			()-> registryTree(createStraightTree(Wood_Blocks.SAKURA_log.get(), Wood_Blocks.SAKURA_flow.get(), 4, 2, 0, 2).ignoreVines()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA_FANCY_CONFIG = CONFIG_FEATURES.register("fancy_sakura", 
			()-> registryTree(createFancyTree(Wood_Blocks.SAKURA_log.get(), Wood_Blocks.SAKURA_flow.get()).ignoreVines()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA_BEES_CONFIG = CONFIG_FEATURES.register("sakura_bees_0002", 
			()-> registryTree(createStraightTree(Wood_Blocks.SAKURA_log.get(), Wood_Blocks.SAKURA_flow.get(), 4, 2, 0, 2).ignoreVines().decorators(List.of(BEEHIVE_0002))));
	
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> KAEDE_CONFIG = CONFIG_FEATURES.register("normal_kaede", 
			()-> registryTree(createStraightTree(Wood_Blocks.KAEDE_log.get(), Wood_Blocks.KAEDE_leaf.get(), 4, 2, 0, 2).ignoreVines()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> KAEDE_FANCY_CONFIG = CONFIG_FEATURES.register("fancy_kaede", 
			()-> registryTree(createFancyTree(Wood_Blocks.KAEDE_log.get(), Wood_Blocks.KAEDE_leaf.get()).ignoreVines()));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICHOH_CONFIG = CONFIG_FEATURES.register("normal_ichoh", 
			()-> registryTree(createStraightTree(Wood_Blocks.ICHOH_log.get(), Wood_Blocks.ICHOH_leaf.get(), 4, 2, 0, 2).ignoreVines()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICHOH_FANCY_CONFIG = CONFIG_FEATURES.register("fancy_ichoh", 
			()-> registryTree(createFancyTree(Wood_Blocks.ICHOH_log.get(), Wood_Blocks.ICHOH_leaf.get()).ignoreVines()));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> OAKKARE_CONFIG = CONFIG_FEATURES.register("normal_autumnoak", 
			()-> registryTree(createStraightTree(Wood_Blocks.OAKKARE_log.get(), Wood_Blocks.OAKKARE_leaf.get(), 4, 2, 0, 2).ignoreVines()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> OAKKARE_FANCY_CONFIG = CONFIG_FEATURES.register("fancy_autumnoak", 
			()-> registryTree(createFancyTree(Wood_Blocks.OAKKARE_log.get(), Wood_Blocks.OAKKARE_leaf.get()).ignoreVines()));
	
	private static TreeConfiguration.TreeConfigurationBuilder createStraightTree(Block log, Block leaves, int high, int width, int zero, int fix) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), 
					new StraightTrunkPlacer(high, width, zero), BlockStateProvider.simple(leaves), 
					new BlobFoliagePlacer(ConstantInt.of(fix), ConstantInt.of(0), 3), 
					new TwoLayersFeatureSize(1, 0, 1)); }

	private static TreeConfiguration.TreeConfigurationBuilder createFancyTree(Block log, Block leaves) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), 
					new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(leaves), 
					new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
					new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))); }
	
	private static ConfiguredFeature<?, ?> registryTree(TreeConfiguration.TreeConfigurationBuilder tree) {
		return new ConfiguredFeature<>(Feature.TREE, tree.build());
	}
	
	/** VegetationFeatures.PATCH_WATERLILLY **/
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAKENOKO_CONFIG = CONFIG_FEATURES.register("takenoko_config", 
			()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 1, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, 
					new SimpleBlockConfiguration(BlockStateProvider.simple(Wood_Blocks.TAKENOKO.get()))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAKENOKO_HILLS_CONFIG = CONFIG_FEATURES.register("takenoko_hills_config", 
			()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 0, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, 
					new SimpleBlockConfiguration(BlockStateProvider.simple(Wood_Blocks.TAKENOKO.get()))))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> KURIIGA_CONFIG = CONFIG_FEATURES.register("kuriiga_config", 
			()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(3, 1, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, 
					new SimpleBlockConfiguration(BlockStateProvider.simple(Wood_Blocks.KURIIGA_BUSH.get()))))));
	
	/////* Ore...OreFeatures */////
	public static final RegistryObject<ConfiguredFeature<?, ?>> BAUXITE_ORE_CONFIG = CONFIG_FEATURES.register("ore_bauxite_config", 
			()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ChinjufuMod_Blocks.BAUXITE_ORE.get().defaultBlockState()), 
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ChinjufuMod_Blocks.BAUXITE_ORE_DEEP.get().defaultBlockState())), 8)));
}
