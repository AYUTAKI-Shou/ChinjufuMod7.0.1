package com.ayutaki.chinjufumod.world.generate;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.Features_CM;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class KuriBush_Gen {

	public static void addBush() {
		if (Config_CM.getInstance().chestnutsFall() == true) { }
		
		if (Config_CM.getInstance().chestnutsFall() != true) {
			for (Biome biomeIn : ForgeRegistries.BIOMES) {
				
				if (biomeIn.getCategory() == Biome.Category.NETHER || biomeIn.getCategory() == Biome.Category.THEEND) { }

				if (biomeIn == Biomes_CM.ACER_FOREST.get() || biomeIn == Biomes_CM.ACER_HILLS.get() ||
						biomeIn == Biomes_CM.GINKGO_FOREST.get() || biomeIn == Biomes_CM.GINKGO_HILLS.get()) {
					biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(Features_CM.KURIIGA_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2)))); }
			}
		}
	}
}
/* net.minecraft.world.biome.DefaultBiomeFeatures.class
鉱石, 鉱脈サイズ))...(new CountRangeConfig(確率,最小の高さ,height base,最大の高さ))
COAL_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));
*/