package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodLeaf_Kuri;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.IPlantable;

/* net.minecraft.world.biome.DefaultBiomeFeatures */
public class Features_CM {

	/* BlockState */
	private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
	private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	private static final BlockState OAKKARE_LEAVES = Wood_Blocks.OAKKARE_leaf.getDefaultState()
			.with(WoodLeaf_Kuri.DISTANCE, Integer.valueOf(7))
			.with(WoodLeaf_Kuri.PERSISTENT, Boolean.valueOf(false))
			.with(WoodLeaf_Kuri.DROP, Boolean.valueOf(false));
	private static final BlockState OAKKARE_LOG = Wood_Blocks.OAKKARE_log.getDefaultState();
	
	private static final BlockState SAKURA_LOG = Wood_Blocks.SAKURA_log.getDefaultState();
	private static final BlockState SAKURA_FLOWER = Wood_Blocks.SAKURA_flow.getDefaultState();
	private static final BlockState KAEDE_LOG = Wood_Blocks.KAEDE_log.getDefaultState();
	private static final BlockState KAEDE_LEAVES = Wood_Blocks.KAEDE_leaf.getDefaultState();
	private static final BlockState ICHOH_LOG = Wood_Blocks.ICHOH_log.getDefaultState();
	private static final BlockState ICHOH_LEAVES = Wood_Blocks.ICHOH_leaf.getDefaultState();
	private static final BlockState TAKENOKO = Wood_Blocks.TAKENOKO.getDefaultState();
	private static final BlockState KURIIGA_BUSH = Wood_Blocks.KURIIGA_BUSH.getDefaultState();
	
	/* Tree net.minecraft.world.biome.DefaultBiomeFeatures 原木, 葉, 基本の高さ.ランダム高さの幅A.葉の高さ.苗木 */
	public static final TreeFeatureConfig OAK_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAK_LEAVES),
			new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Blocks.OAK_SAPLING).build();
	public static final TreeFeatureConfig OAK_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAK_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Blocks.OAK_SAPLING).build();

	public static final TreeFeatureConfig SAKURA_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(SAKURA_LOG),
			new SimpleBlockStateProvider(SAKURA_FLOWER),
			new BlobFoliagePlacer(2, 0)).baseHeight(4).heightRandA(3).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.SAKURA_nae).build();
	public static final TreeFeatureConfig SAKURA_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(SAKURA_LOG),
			new SimpleBlockStateProvider(SAKURA_FLOWER),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.SAKURA_nae).build();

	public static final TreeFeatureConfig KAEDE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(KAEDE_LOG),
			new SimpleBlockStateProvider(KAEDE_LEAVES),
			new BlobFoliagePlacer(2, 0)).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.KAEDE_nae).build();
	public static final TreeFeatureConfig KAEDE_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(KAEDE_LOG),
			new SimpleBlockStateProvider(KAEDE_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.KAEDE_nae).build();

	public static final TreeFeatureConfig ICHOH_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ICHOH_LOG),
			new SimpleBlockStateProvider(ICHOH_LEAVES),
			new BlobFoliagePlacer(2, 0)).baseHeight(5).heightRandA(3).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.ICHOH_nae).build();
	public static final TreeFeatureConfig ICHOH_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ICHOH_LOG),
			new SimpleBlockStateProvider(ICHOH_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.ICHOH_nae).build();

	public static final TreeFeatureConfig OAKKARE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAKKARE_LOG),
			new SimpleBlockStateProvider(OAKKARE_LEAVES),
			new BlobFoliagePlacer(2, 0)).baseHeight(4).heightRandA(3).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.OAKKARE_nae).build();
	public static final TreeFeatureConfig OAKKARE_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAKKARE_LOG),
			new SimpleBlockStateProvider(OAKKARE_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.OAKKARE_nae).build();

	/** DefaultBiomeFeatures.LILAC_CONFIG 10 -> 2 **/
	public static final BlockClusterFeatureConfig TAKENOKO_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(TAKENOKO), new SimpleBlockPlacer())).tries(2).build();
	public static final BlockClusterFeatureConfig TAKENOKO_HILLS = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(TAKENOKO), new SimpleBlockPlacer())).tries(1).build();
	public static final BlockClusterFeatureConfig KURIIGA_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(KURIIGA_BUSH), new SimpleBlockPlacer())).tries(9).build();
	
	/* Forest*/
	public static void addSakuraandOak(Biome biomeIn) {
		float sakura = (float) Config_CM.getInstance().sakuraTreeChance() / 10;
		float fancyoak = (float) (10 - Config_CM.getInstance().sakuraTreeChance()) / 300;

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
				TreeFeature.NORMAL_TREE.withConfiguration(SAKURA_CONFIG).withChance(sakura / 30 * 29),
				TreeFeature.FANCY_TREE.withConfiguration(SAKURA_FANCY_CONFIG).withChance(sakura / 30),
				TreeFeature.FANCY_TREE.withConfiguration(OAK_FANCY_CONFIG).withChance(fancyoak)),
				TreeFeature.NORMAL_TREE.withConfiguration(OAK_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addSakuraandOakHills(Biome biomeIn) {
		float sakura = (float) Config_CM.getInstance().sakuraTreeChance() / 10;
		float fancyoak = (float) (10 - Config_CM.getInstance().sakuraTreeChance()) / 200;

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
				TreeFeature.NORMAL_TREE.withConfiguration(SAKURA_CONFIG).withChance(sakura / 20 * 19),
				TreeFeature.FANCY_TREE.withConfiguration(SAKURA_FANCY_CONFIG).withChance(sakura / 20),
				TreeFeature.FANCY_TREE.withConfiguration(OAK_FANCY_CONFIG).withChance(fancyoak)),
				TreeFeature.NORMAL_TREE.withConfiguration(OAK_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addKaedeandOak(Biome biomeIn) {
		float kaede = (float) Config_CM.getInstance().kaedeTreeChance() / 10;
		float fancyoak = (float) (10 - Config_CM.getInstance().kaedeTreeChance()) / 300;

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
				TreeFeature.NORMAL_TREE.withConfiguration(KAEDE_CONFIG).withChance(kaede),
				TreeFeature.FANCY_TREE.withConfiguration(OAKKARE_FANCY_CONFIG).withChance(fancyoak)),
				TreeFeature.NORMAL_TREE.withConfiguration(OAKKARE_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addKaedeandOakHills(Biome biomeIn) {
		float kaede = (float) Config_CM.getInstance().kaedeTreeChance() / 10;
		float fancyoak = (float) (10 - Config_CM.getInstance().kaedeTreeChance()) / 200;

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
				TreeFeature.NORMAL_TREE.withConfiguration(KAEDE_CONFIG).withChance(kaede / 100 * 99),
				TreeFeature.FANCY_TREE.withConfiguration(KAEDE_FANCY_CONFIG).withChance(kaede / 100),
				TreeFeature.FANCY_TREE.withConfiguration(OAKKARE_FANCY_CONFIG).withChance(fancyoak)),
				TreeFeature.NORMAL_TREE.withConfiguration(OAKKARE_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addIchohandOak(Biome biomeIn) {
		float ichoh = (float) Config_CM.getInstance().ichohTreeChance() / 10;
		float fancyoak = (float) (10 - Config_CM.getInstance().ichohTreeChance()) / 300;

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
				TreeFeature.NORMAL_TREE.withConfiguration(ICHOH_CONFIG).withChance(ichoh / 30 * 29),
				TreeFeature.FANCY_TREE.withConfiguration(ICHOH_FANCY_CONFIG).withChance(ichoh / 30),
				TreeFeature.FANCY_TREE.withConfiguration(OAKKARE_FANCY_CONFIG).withChance(fancyoak)),
				TreeFeature.NORMAL_TREE.withConfiguration(OAKKARE_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addIchohandOakHills(Biome biomeIn) {
		float ichoh = (float) Config_CM.getInstance().ichohTreeChance() / 10;
		float fancyoak = (float) (10 - Config_CM.getInstance().ichohTreeChance()) / 200;

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
				TreeFeature.NORMAL_TREE.withConfiguration(ICHOH_CONFIG).withChance(ichoh / 20 * 19),
				TreeFeature.FANCY_TREE.withConfiguration(ICHOH_FANCY_CONFIG).withChance(ichoh / 20),
				TreeFeature.FANCY_TREE.withConfiguration(OAKKARE_FANCY_CONFIG).withChance(fancyoak)),
				TreeFeature.NORMAL_TREE.withConfiguration(OAKKARE_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}
	
	public static void addTakenoko(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), 
				Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.PLAINS_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TAKENOKO_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}
	
	public static void addTakenokoHills(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), 
				Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.PLAINS_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TAKENOKO_HILLS).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}
	
/*public static void addForestTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
		Feature.NORMAL_TREE.withConfiguration(field_230129_h_).withChance(0.2F),
		Feature.FANCY_TREE.withConfiguration(field_230131_m_).withChance(0.1F)),
		Feature.NORMAL_TREE.withConfiguration(field_230132_o_)))
		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}*/
}
