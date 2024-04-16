package com.ayutaki.chinjufumod.world.generate;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class CM_OreGen {

	public static void addOres() {
		if (Config_CM.getInstance().bauxiteGene() == true) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig
								.FillerBlockType.NATURAL_STONE, ChinjufuMod_Blocks.BAUXITE_ORE.getDefaultState(), 8))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(Config_CM.getInstance().bauxiteChance(), 10, 0, 70))));
			}
		}

		if (Config_CM.getInstance().bauxiteGene() != true) { }
	}
}
/* net.minecraft.world.biome.DefaultBiomeFeatures.class
鉱石, 鉱脈サイズ))...(new CountRangeConfig(確率,最小の高さ,height base,最大の高さ))
COAL_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));
*/