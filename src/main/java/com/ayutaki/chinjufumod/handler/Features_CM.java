package com.ayutaki.chinjufumod.handler;

import java.util.OptionalInt;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodLeaf_Kuri;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/* net.minecraft.world.gen.feature.Features */
public class Features_CM {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, ChinjufuMod.MOD_ID);

	/* BlockState */
	private static final BlockState OAK_LOG = Blocks.OAK_LOG.defaultBlockState();
	private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.defaultBlockState();
	private static final BlockState OAKKARE_LEAVES = Wood_Blocks.OAKKARE_leaf.defaultBlockState()
			.setValue(WoodLeaf_Kuri.DISTANCE, Integer.valueOf(7))
			.setValue(WoodLeaf_Kuri.PERSISTENT, Boolean.valueOf(false))
			.setValue(WoodLeaf_Kuri.DROP, Boolean.valueOf(false));
	private static final BlockState OAKKARE_LOG = Wood_Blocks.OAKKARE_log.defaultBlockState();
	private static final BlockState SAKURA_LOG = Wood_Blocks.SAKURA_log.defaultBlockState();
	private static final BlockState SAKURA_FLOWER = Wood_Blocks.SAKURA_flow.defaultBlockState();
	private static final BlockState KAEDE_LOG = Wood_Blocks.KAEDE_log.defaultBlockState();
	private static final BlockState KAEDE_LEAVES = Wood_Blocks.KAEDE_leaf.defaultBlockState();
	private static final BlockState ICHOH_LOG = Wood_Blocks.ICHOH_log.defaultBlockState();
	private static final BlockState ICHOH_LEAVES = Wood_Blocks.ICHOH_leaf.defaultBlockState();
	private static final BlockState TAKENOKO = Wood_Blocks.TAKENOKO.defaultBlockState();
	private static final BlockState BAUXITE_ORE = ChinjufuMod_Blocks.BAUXITE_ORE.defaultBlockState();
	private static final BlockState KURIIGA_BUSH = Wood_Blocks.KURIIGA_BUSH.defaultBlockState();
	

	/* Tree */
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OAK_CONFIG = register("normal_oak_cm", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAK_LEAVES),
			new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
			new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OAK_FANCY_CONFIG = register("fancy_oak_cm", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAK_LEAVES),
			new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
			new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
			.ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAKURA_CONFIG = register("normal_sakura", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(SAKURA_LOG),
			new SimpleBlockStateProvider(SAKURA_FLOWER),
			new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
			new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAKURA_FANCY_CONFIG = register("fancy_sakura", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(SAKURA_LOG),
			new SimpleBlockStateProvider(SAKURA_FLOWER),
			new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
			new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
			.ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KAEDE_CONFIG = register("normal_kaede", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(KAEDE_LOG),
			new SimpleBlockStateProvider(KAEDE_LEAVES),
			new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
			new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KAEDE_FANCY_CONFIG = register("fancy_kaede", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(KAEDE_LOG),
			new SimpleBlockStateProvider(KAEDE_LEAVES),
			new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
			new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
			.ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ICHOH_CONFIG = register("normal_ichoh", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ICHOH_LOG),
			new SimpleBlockStateProvider(ICHOH_LEAVES),
			new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
			new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ICHOH_FANCY_CONFIG = register("fancy_ichoh", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ICHOH_LOG),
			new SimpleBlockStateProvider(ICHOH_LEAVES),
			new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
			new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
			.ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OAKKARE_CONFIG = register("normal_autumnoak", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAKKARE_LOG),
			new SimpleBlockStateProvider(OAKKARE_LEAVES),
			new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
			new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OAKKARE_FANCY_CONFIG = register("fancy_autumnoak", Feature.TREE.configured((
			new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAKKARE_LOG),
			new SimpleBlockStateProvider(OAKKARE_LEAVES),
			new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
			new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
			.ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	
	/* Forest*/
	public static final ConfiguredFeature<?, ?> SAKURA_OAK = register("sakura_oak", Feature.RANDOM_SELECTOR.configured(
			new MultipleRandomFeatureConfig(ImmutableList.of(
					SAKURA_CONFIG.weighted((float) Config_CM.getInstance().sakuraTreeChance() / 10 / 30 * 29),
					SAKURA_FANCY_CONFIG.weighted((float) Config_CM.getInstance().sakuraTreeChance() / 10 / 30),
					OAK_FANCY_CONFIG.weighted((float) (10 - Config_CM.getInstance().sakuraTreeChance()) / 300)),
					OAK_CONFIG))
			.decorated(Features.Placements.HEIGHTMAP_SQUARE)
			.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> SAKURA_OAK_HILLS = register("sakura_oak_hills", Feature.RANDOM_SELECTOR.configured(
			new MultipleRandomFeatureConfig(ImmutableList.of(
					SAKURA_CONFIG.weighted((float) Config_CM.getInstance().sakuraTreeChance() / 10 / 20 * 29),
					SAKURA_FANCY_CONFIG.weighted((float) Config_CM.getInstance().sakuraTreeChance() / 10 / 20),
					OAK_FANCY_CONFIG.weighted((float) (10 - Config_CM.getInstance().sakuraTreeChance()) / 200)),
					OAK_CONFIG))
			.decorated(Features.Placements.HEIGHTMAP_SQUARE)
			.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> KAEDE_AUTUMNOAK = register("kaede_autumnoak", Feature.RANDOM_SELECTOR.configured(
			new MultipleRandomFeatureConfig(ImmutableList.of(
					KAEDE_CONFIG.weighted((float) Config_CM.getInstance().kaedeTreeChance() / 10),
					OAKKARE_FANCY_CONFIG.weighted((float) (10 - Config_CM.getInstance().kaedeTreeChance()) / 300)),
					OAKKARE_CONFIG))
			.decorated(Features.Placements.HEIGHTMAP_SQUARE)
			.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> KAEDE_AUTUMNOAK_HILLS = register("kaede_autumnoak_hills", Feature.RANDOM_SELECTOR.configured(
			new MultipleRandomFeatureConfig(ImmutableList.of(
					KAEDE_CONFIG.weighted((float) Config_CM.getInstance().kaedeTreeChance() / 10 / 100 * 99),
					KAEDE_FANCY_CONFIG.weighted((float) Config_CM.getInstance().kaedeTreeChance() / 10 / 100),
					OAKKARE_FANCY_CONFIG.weighted((float) (10 - Config_CM.getInstance().kaedeTreeChance()) / 200)),
					OAKKARE_CONFIG))
			.decorated(Features.Placements.HEIGHTMAP_SQUARE)
			.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> ICHOH_AUTUMNOAK = register("ichoh_autumnoak", Feature.RANDOM_SELECTOR.configured(
			new MultipleRandomFeatureConfig(ImmutableList.of(
					ICHOH_CONFIG.weighted((float) Config_CM.getInstance().ichohTreeChance() / 10 / 30 * 29),
					ICHOH_FANCY_CONFIG.weighted((float) Config_CM.getInstance().ichohTreeChance() / 10 / 30),
					OAKKARE_FANCY_CONFIG.weighted((float) (10 - Config_CM.getInstance().ichohTreeChance()) / 300)),
					OAKKARE_CONFIG))
			.decorated(Features.Placements.HEIGHTMAP_SQUARE)
			.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> ICHOH_AUTUMNOAK_HILLS = register("ichoh_autumnoak_hills", Feature.RANDOM_SELECTOR.configured(
			new MultipleRandomFeatureConfig(ImmutableList.of(
					ICHOH_CONFIG.weighted((float) Config_CM.getInstance().ichohTreeChance() / 10 / 20 * 19),
					ICHOH_FANCY_CONFIG.weighted((float) Config_CM.getInstance().ichohTreeChance() / 10 / 20),
					OAKKARE_FANCY_CONFIG.weighted((float) (10 - Config_CM.getInstance().ichohTreeChance()) / 200)),
					OAKKARE_CONFIG))
			.decorated(Features.Placements.HEIGHTMAP_SQUARE)
			.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	/** Features.PATCH_WATERLILLY LILY_PAD **/
	public static final ConfiguredFeature<?, ?> TAKENOKO_CONFIG = register("takenoko_config", Feature.RANDOM_PATCH
			.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TAKENOKO), 
					SimpleBlockPlacer.INSTANCE)).tries(2).build()).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(1));
	public static final ConfiguredFeature<?, ?> TAKENOKO_HILLS = register("takenoko_hills", Feature.RANDOM_PATCH
			.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TAKENOKO), 
					SimpleBlockPlacer.INSTANCE)).tries(1).build()).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(1));
	
	public static final ConfiguredFeature<?, ?> KURIIGA_CONFIG = register("kuribush_config", Feature.RANDOM_PATCH
			.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(KURIIGA_BUSH), 
					SimpleBlockPlacer.INSTANCE)).tries(9).build()).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(2));
	
	/* Ore */
	public static final ConfiguredFeature<?, ?> BAUXITE_ORE_CONFIG = register("ore_bauxite_congig", Feature.ORE
			.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BAUXITE_ORE, 8))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(10, 10, 70)))
			.squared().count(Config_CM.getInstance().bauxiteChance()));

	///* Register *///
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
	}

}
/*
public static final ConfiguredFeature<?, ?> BIRCH_OTHER = register("birch_other", Feature.RANDOM_SELECTOR.configured(
new MultipleRandomFeatureConfig(ImmutableList.of(
BIRCH_BEES_0002.weighted(0.2F),
FANCY_OAK_BEES_0002.weighted(0.1F)),
OAK_BEES_0002)).decorated(Features.Placements.HEIGHTMAP_SQUARE)
.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));


1.15.2 net.minecraft.world.biome.DefaultBiomeFeatures.class
鉱石, 鉱脈サイズ))...(new CountRangeConfig(確率,最小の高さ,height base,最大の高さ))
COAL_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));

1.16.5 net.minecraft.world.gen.feature.Features.class
Features.States.COAL_ORE, 17)).range(128).squared().count(20));
Features.States.IRON_ORE, 9)).range(64).squared().count(20));
Features.States.REDSTONE_ORE, 8)).range(16).squared().count(8));
Features.States.DIAMOND_ORE, 8)).range(16).squared());
Features.States.GOLD_ORE, 9)).range(32).squared().count(2));
Features.States.GOLD_ORE, 9)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(32, 32, 80))).squared().count(20));
 */