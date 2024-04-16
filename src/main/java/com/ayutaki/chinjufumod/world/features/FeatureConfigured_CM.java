package com.ayutaki.chinjufumod.world.features;

import java.util.List;
import java.util.OptionalInt;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

/* Can not use Config_CM!! */
public final class FeatureConfigured_CM {
	/* Surface...MiscOverworldFeatures */
	public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMN_CONFIG = createKey("autumn");
	/* Tree...TreeFeatures */
	public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_CONFIG = createKey("normal_oak_cm");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_FANCY_CONFIG = createKey("fancy_oak_cm");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_CONFIG = createKey("normal_sakura");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_FANCY_CONFIG = createKey("fancy_sakura");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BEES_CONFIG = createKey("sakura_bees_0002");	
	public static final ResourceKey<ConfiguredFeature<?, ?>> KAEDE_CONFIG = createKey("normal_kaede");
	public static final ResourceKey<ConfiguredFeature<?, ?>> KAEDE_FANCY_CONFIG = createKey("fancy_kaede");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICHOH_CONFIG = createKey("normal_ichoh");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICHOH_FANCY_CONFIG = createKey("fancy_ichoh");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> OAKKARE_CONFIG = createKey("normal_autumnoak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OAKKARE_FANCY_CONFIG = createKey("fancy_autumnoak");
	
	/* Forest...VegetationFeatures */
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_OAK = createKey("sakura_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_OAK_HILLS = createKey("sakura_oak_hills");
	public static final ResourceKey<ConfiguredFeature<?, ?>> KAEDE_AUTUMNOAK = createKey("kaede_autumnoak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> KAEDE_AUTUMNOAK_HILLS = createKey("kaede_autumnoak_hills");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICHOH_AUTUMNOAK = createKey("ichoh_autumnoak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICHOH_AUTUMNOAK_HILLS = createKey("ichoh_autumnoak_hills");
	
	/** VegetationFeatures.PATCH_WATERLILLY **/
	public static final ResourceKey<ConfiguredFeature<?, ?>>TAKENOKO_CONFIG = createKey("takenoko_config");
	public static final ResourceKey<ConfiguredFeature<?, ?>>TAKENOKO_HILLS_CONFIG = createKey("takenoko_hills_config");
	public static final ResourceKey<ConfiguredFeature<?, ?>>KURIIGA_CONFIG = createKey("kuriiga_config");
	
	/* Ore...OreFeatures */
	public static final ResourceKey<ConfiguredFeature<?, ?>> BAUXITE_ORE_CONFIG = createKey("ore_bauxite_config");
	
	private static ResourceKey<ConfiguredFeature<?, ?>> createKey(final String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ChinjufuMod.MOD_ID, name));
	}
	
	
	/////* Bootstap */////
	public static void bootstrap(final BootstapContext<ConfiguredFeature<?, ?>> context) {
		register(context, AUTUMN_CONFIG, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Wood_Blocks.FALL_LEAF.get()), 
				BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.CLAY)), UniformInt.of(2, 3), 1));
		
		
		BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
		register(context, OAK_CONFIG, Feature.TREE, createStraightTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).build());
		register(context, OAK_FANCY_CONFIG, Feature.TREE, createFancyTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES).build());
		register(context, SAKURA_CONFIG, Feature.TREE, createStraightTree(Wood_Blocks.SAKURA_log.get(), Wood_Blocks.SAKURA_flow.get(), 4, 2, 0, 2).build());
		register(context, SAKURA_FANCY_CONFIG, Feature.TREE, createFancyTree(Wood_Blocks.SAKURA_log.get(), Wood_Blocks.SAKURA_flow.get()).build());
		register(context, SAKURA_BEES_CONFIG, Feature.TREE, createStraightTree(Wood_Blocks.SAKURA_log.get(), Wood_Blocks.SAKURA_flow.get(), 4, 2, 0, 2).decorators(List.of(BEEHIVE_0002)).build());

		register(context, KAEDE_CONFIG, Feature.TREE, createStraightTree(Wood_Blocks.KAEDE_log.get(), Wood_Blocks.KAEDE_leaf.get(), 4, 2, 0, 2).ignoreVines().build());
		register(context, KAEDE_FANCY_CONFIG, Feature.TREE, createFancyTree(Wood_Blocks.KAEDE_log.get(), Wood_Blocks.KAEDE_leaf.get()).build());
		register(context, ICHOH_CONFIG, Feature.TREE, createStraightTree(Wood_Blocks.ICHOH_log.get(), Wood_Blocks.ICHOH_leaf.get(), 4, 2, 0, 2).ignoreVines().build());
		register(context, ICHOH_FANCY_CONFIG, Feature.TREE, createFancyTree(Wood_Blocks.ICHOH_log.get(), Wood_Blocks.ICHOH_leaf.get()).build());
		register(context, OAKKARE_CONFIG, Feature.TREE, createStraightTree(Wood_Blocks.OAKKARE_log.get(), Wood_Blocks.OAKKARE_leaf.get(), 4, 2, 0, 2).ignoreVines().build());
		register(context, OAKKARE_FANCY_CONFIG, Feature.TREE, createFancyTree(Wood_Blocks.OAKKARE_log.get(), Wood_Blocks.OAKKARE_leaf.get()).build());

		HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);
		Holder<PlacedFeature> OAK = placedFeature.getOrThrow(FeaturePlaced_CM.OAK_PLACE);
		Holder<PlacedFeature> OAK_F = placedFeature.getOrThrow(FeaturePlaced_CM.OAK_FANCY_PLACE);
		Holder<PlacedFeature> SAKURA = placedFeature.getOrThrow(FeaturePlaced_CM.SAKURA_PLACE);
		Holder<PlacedFeature> SAKURA_F = placedFeature.getOrThrow(FeaturePlaced_CM.SAKURA_FANCY_PLACE);
		Holder<PlacedFeature> SAKURA_B = placedFeature.getOrThrow(FeaturePlaced_CM.SAKURA_BEES_PLACE);
		register(context, SAKURA_OAK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
				new WeightedPlacedFeature(SAKURA, (float) 2 / 10 / 30 * 29), 
				new WeightedPlacedFeature(SAKURA_F, (float) 2 / 10 / 30),
				new WeightedPlacedFeature(SAKURA_B, (float) 2 / 10 / 300),
				new WeightedPlacedFeature(OAK_F, (float) (10 - 2) / 300)), OAK));

		register(context, SAKURA_OAK_HILLS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
				new WeightedPlacedFeature(SAKURA, (float) 2/ 10 / 30 * 29), 
				new WeightedPlacedFeature(SAKURA_F, (float) 2 / 10 / 30),
				new WeightedPlacedFeature(SAKURA_B, (float) (10 - 2) / 200)), OAK));

		Holder<PlacedFeature> KAEDE =placedFeature.getOrThrow(FeaturePlaced_CM.KAEDE_PLACE);
		Holder<PlacedFeature> KAEDE_F =placedFeature.getOrThrow(FeaturePlaced_CM.KAEDE_FANCY_PLACE);
		Holder<PlacedFeature> ICHOH =placedFeature.getOrThrow(FeaturePlaced_CM.ICHOH_PLACE);
		Holder<PlacedFeature> ICHOH_F =placedFeature.getOrThrow(FeaturePlaced_CM.ICHOH_FANCY_PLACE);
		Holder<PlacedFeature> OAKKARE =placedFeature.getOrThrow(FeaturePlaced_CM.OAKKARE_PLACE);
		Holder<PlacedFeature> OAKKARE_F =placedFeature.getOrThrow(FeaturePlaced_CM.OAKKARE_FANCY_PLACE);
		register(context, KAEDE_AUTUMNOAK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
				new WeightedPlacedFeature(KAEDE, (float) 2 / 10), 
				new WeightedPlacedFeature(OAKKARE_F, (float) (10 - 2) / 300)), OAKKARE));

		register(context, KAEDE_AUTUMNOAK_HILLS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
				new WeightedPlacedFeature(KAEDE, (float) 2 / 10 / 100 * 99), 
				new WeightedPlacedFeature(KAEDE_F, (float) 2 / 10 / 100),
				new WeightedPlacedFeature(OAKKARE_F, (float) (10 - 2) / 200)), OAKKARE));

		register(context, ICHOH_AUTUMNOAK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
				new WeightedPlacedFeature(ICHOH, (float) 2 / 10 / 30 * 29), 
				new WeightedPlacedFeature(ICHOH_F, (float) 2 / 10 / 30),
				new WeightedPlacedFeature(OAKKARE_F, (float) (10 - 2) / 300)), OAKKARE));

		register(context, ICHOH_AUTUMNOAK_HILLS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
				new WeightedPlacedFeature(ICHOH, (float) 2 / 10 / 20 * 19), 
				new WeightedPlacedFeature(ICHOH_F, (float) 2 / 10 / 20),
				new WeightedPlacedFeature(OAKKARE_F, (float) (10 - 2) / 200)), OAKKARE));
		

		register(context, TAKENOKO_CONFIG, Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 1, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, 
						new SimpleBlockConfiguration(BlockStateProvider.simple(Wood_Blocks.TAKENOKO.get())))));
		register(context, TAKENOKO_HILLS_CONFIG, Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 0, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, 
						new SimpleBlockConfiguration(BlockStateProvider.simple(Wood_Blocks.TAKENOKO.get())))));
		register(context, KURIIGA_CONFIG, Feature.RANDOM_PATCH, new RandomPatchConfiguration(3, 1, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, 
						new SimpleBlockConfiguration(BlockStateProvider.simple(Wood_Blocks.KURIIGA_BUSH.get())))));
		
		
		RuleTest RULE1 = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest RULE2 = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		register(context, BAUXITE_ORE_CONFIG, Feature.ORE, 
				new OreConfiguration(List.of(OreConfiguration.target(RULE1, ChinjufuMod_Blocks.BAUXITE_ORE.get().defaultBlockState()), 
				OreConfiguration.target(RULE2, ChinjufuMod_Blocks.BAUXITE_ORE_DEEP.get().defaultBlockState())), 8));
	}
	
	/* Share variables */
	private static TreeConfiguration.TreeConfigurationBuilder createStraightTree(Block log, Block leaves, int high, int width, int zero, int fix) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), 
				new StraightTrunkPlacer(high, width, zero), BlockStateProvider.simple(leaves), 
				new BlobFoliagePlacer(ConstantInt.of(fix), ConstantInt.of(0), 3), 
				new TwoLayersFeatureSize(1, 0, 1));
	}
	
	private static TreeConfiguration.TreeConfigurationBuilder createFancyTree(Block log, Block leaves) {
		return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), 
				new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(leaves), 
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), 
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))));
	}
	
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
		context.register(key, new ConfiguredFeature<>(feature, config));
	}
}
