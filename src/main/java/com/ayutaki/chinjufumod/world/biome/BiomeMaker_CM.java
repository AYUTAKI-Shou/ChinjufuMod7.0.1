package com.ayutaki.chinjufumod.world.biome;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.world.features.FeaturePlaced_CM;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BiomeMaker_CM {

	@Nullable
	private static final Music NORMAL_MUSIC = null;
	
	protected static int calculateSkyColor(float f) {
		float $$1 = f / 3.0F;
		$$1 = Mth.clamp($$1, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
	}
	
	/* Share variables */
	private static Biome biome(boolean flag, float temp, float downfall, MobSpawnSettings.Builder mobSpawn, BiomeGenerationSettings.Builder biomeGene, @Nullable Music bgm) {
		return biome(flag, temp, downfall, 4159204, 329011, (Integer)null, (Integer)null, mobSpawn, biomeGene, bgm);
	}
	
	 private static Biome biome(boolean flag, float temp, float downfall, int water, int fog, @Nullable Integer grass, @Nullable Integer foliage, MobSpawnSettings.Builder mobSpawn, BiomeGenerationSettings.Builder biomeGene, @Nullable Music bgm) {
		 BiomeSpecialEffects.Builder biomespecialeffects$builder = (new BiomeSpecialEffects.Builder()).waterColor(water).waterFogColor(fog).fogColor(12638463).skyColor(calculateSkyColor(temp))
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(bgm);
		if (grass != null) { biomespecialeffects$builder.grassColorOverride(grass); }
		if (foliage != null) { biomespecialeffects$builder.foliageColorOverride(foliage); }
		
		return (new Biome.BiomeBuilder()).hasPrecipitation(flag).temperature(temp).downfall(downfall)
				.specialEffects(biomespecialeffects$builder.build()).mobSpawnSettings(mobSpawn.build()).generationSettings(biomeGene.build()).build();
	}
		 
	private static void globalOverworldGeneration(BiomeGenerationSettings.Builder biomeSettings) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeSettings);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeSettings);
		BiomeDefaultFeatures.addDefaultSprings(biomeSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeSettings);
	}
	
	
	/* SAKURA */
	public static Biome makeSakuraBiome(HolderGetter<PlacedFeature> placedFeature, HolderGetter<ConfiguredWorldCarver<?>> worldCarver) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeature, worldCarver);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		/** Tree **/
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.SAKURA_OAK_PLACE);
		
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.TAKENOKO_PLACE); // add TAKENOKO
		BiomeDefaultFeatures.addForestFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		
		MobSpawnSettings.Builder mobSpawn = new MobSpawnSettings.Builder();
		/** Spring Animals. **/
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));

		/** SAKURA liked by the undead. **/
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
		
		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE);
		return biome(true, 0.7F, 0.6F, mobSpawn, biomeSettings, music);
	}
	
	public static Biome makeSakuraHills(HolderGetter<PlacedFeature> placedFeature, HolderGetter<ConfiguredWorldCarver<?>> worldCarver) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeature, worldCarver);
			
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		/** Tree **/
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.SAKURA_OAK_HILLS_PLACE);
		
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.TAKENOKO_HILLS_PLACE); // add TAKENOKO
		BiomeDefaultFeatures.addForestFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);

		MobSpawnSettings.Builder mobSpawn = new MobSpawnSettings.Builder();
		/** Less in high places. **/
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 6, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));

		/** Less in high places. x0.7 **/
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 3, 1, 1));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE);
		return biome(true, 0.7F, 0.6F, mobSpawn, biomeSettings, music);
	}
	
		
	/* KAEDE */
	public static Biome makeKaedeBiome(HolderGetter<PlacedFeature> placedFeature, HolderGetter<ConfiguredWorldCarver<?>> worldCarver, boolean bush) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeature, worldCarver);
			
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		/** Tree **/
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KAEDE_AUTUMNOAK_PLACE);
		/** KURI_BUSH **/
		if (bush) { biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KURIIGA_PLACE); }
		
		BiomeDefaultFeatures.addForestFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);

		MobSpawnSettings.Builder mobSpawn = new MobSpawnSettings.Builder();
		/** !SAKURA and !ICHOH Animals. **/
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));

		/** Creeper hate Cat. **/
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 50, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
		mobSpawn.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
		return biome(true, 0.7F, 0.6F, mobSpawn, biomeSettings, music);
	}
	
	public static Biome makeKaedeHills(HolderGetter<PlacedFeature> placedFeature, HolderGetter<ConfiguredWorldCarver<?>> worldCarver, boolean bush) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeature, worldCarver);
			
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		/** Tree **/
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KAEDE_AUTUMNOAK_HILLS_PLACE);
		/** KURI_BUSH **/
		if (bush) { biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KURIIGA_PLACE); }
		
		BiomeDefaultFeatures.addForestFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);

		MobSpawnSettings.Builder mobSpawn = new MobSpawnSettings.Builder();
		/** Less in high places. **/
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 5, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 2, 1, 2));

		/** Less in high places. x0.7 **/
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 3, 1, 1));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 35, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 7, 1, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 3, 1, 1));
		mobSpawn.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
		return biome(true, 0.7F, 0.6F, mobSpawn, biomeSettings, music);
	}
	
	
	/* ICHOH */
	public static Biome makeIchohBiome(HolderGetter<PlacedFeature> placedFeature, HolderGetter<ConfiguredWorldCarver<?>> worldCarver, boolean bush) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeature, worldCarver);
			
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		/** Tree **/
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.ICHOH_AUTUMNOAK_PLACE);
		/** KURI_BUSH **/
		if (bush) { biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KURIIGA_PLACE); }
		
		BiomeDefaultFeatures.addForestFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);

		MobSpawnSettings.Builder mobSpawn = new MobSpawnSettings.Builder();
		/** Small animals hate ICHOH. **/
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.MULE, 1, 1, 3));

		/** Spider hate ICHOH. **/
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 80, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 20, 1, 1));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 20, 1, 1));
		mobSpawn.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
		return biome(true, 0.7F, 0.6F, mobSpawn, biomeSettings, music);
	}
	
	public static Biome makeIchohHills(HolderGetter<PlacedFeature> placedFeature, HolderGetter<ConfiguredWorldCarver<?>> worldCarver, boolean bush) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeature, worldCarver);
			
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		/** Tree **/
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.ICHOH_AUTUMNOAK_HILLS_PLACE);
		/** KURI_BUSH **/
		if (bush) { biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeaturePlaced_CM.KURIIGA_PLACE); }
		
		BiomeDefaultFeatures.addForestFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);

		MobSpawnSettings.Builder mobSpawn = new MobSpawnSettings.Builder();
		/** Less in high places. **/
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 4, 4, 4));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 2, 2, 6));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
		mobSpawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.MULE, 1, 1, 3));

		/** Less in high places. x0.7 **/
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 56, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 14, 1, 1));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 70, 4, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 7, 1, 4));
		mobSpawn.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 14, 1, 1));
		mobSpawn.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
		return biome(true, 0.7F, 0.6F, mobSpawn, biomeSettings, music);
	}
}
