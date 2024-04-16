package com.ayutaki.chinjufumod.world.biome;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class SurfaceRule_CM {

	private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());
	private static final SurfaceRules.RuleSource GRASS_BLOCK = SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState());
	private static final SurfaceRules.RuleSource FALL_LEAF = SurfaceRules.state(Wood_Blocks.FALL_LEAF.get().defaultBlockState());
	
	public static SurfaceRules.RuleSource makeRules() {
		SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
		SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
		SurfaceRules.RuleSource fallleafSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, FALL_LEAF), DIRT);
		
		return SurfaceRules.sequence(
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.KAEDE_FOREST_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.KAEDE_HILLS_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.ICHOH_FOREST_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.ICHOH_HILLS_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.KAEDE_FORESTB_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.KAEDE_HILLSB_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.ICHOH_FORESTB_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKey_CM.ICHOH_HILLSB_KEY), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fallleafSurface)),
			
			// Default to a grass and dirt surface
			SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
		);
	}
}
