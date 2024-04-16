package com.ayutaki.chinjufumod.world.biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

/* net.minecraft.world.biom.BiomeMake */
public class BiomeMaker_CM {

	private static int calculateSkyColor(float f) {
		float level = f / 3.0F;
		level = MathHelper.clamp(level, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - level * 0.05F, 0.5F + level * 0.1F, 1.0F);
	}

	/* SAKURA */
	public static Biome makeSakuraBiome() {
		BiomeGenerationSettings.Builder biomeSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		/** Village **/
		biomeSettings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
		/** Structure **/
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeSettings);
		/** Tree **/
		BiomeFeatures_CM.addSakuraTree(biomeSettings);

		/** Lake, Ore **/
		DefaultBiomeFeatures.addDefaultCarvers(biomeSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeSettings);

		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeSettings);

		BiomeFeatures_CM.addTakenoko(biomeSettings); // add TAKENOKO
		DefaultBiomeFeatures.addDefaultGrass(biomeSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeSettings);

		/** Mob **/
		MobSpawnInfo.Builder mobSpawn = new MobSpawnInfo.Builder();
		/** 春のイメージの動物を集める **/
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));

		/** 櫻の樹の下には、に合わせてアンデッドを集める **/
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.FOREST)
				.depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.6F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.6F))
								.grassColorOverride(8564294)
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawn.build()).generationSettings(biomeSettings.build()).build();
	}

	public static Biome makeSakuraHills() {
		BiomeGenerationSettings.Builder biomeSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		/** Village **/
		/** Structure **/
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeSettings);
		/** Tree **/
		BiomeFeatures_CM.addSakuraHills(biomeSettings);

		/** Lake, Ore **/
		DefaultBiomeFeatures.addDefaultCarvers(biomeSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeSettings);

		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeSettings);

		BiomeFeatures_CM.addTakenokoHills(biomeSettings); // add TAKENOKO
		DefaultBiomeFeatures.addDefaultGrass(biomeSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeSettings);

		/** Mob **/
		MobSpawnInfo.Builder mobSpawn = new MobSpawnInfo.Builder();
		/** 高所のため羊は半減 **/
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 6, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));

		/** 高所のため 3割減 **/
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 3, 1, 1));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.FOREST)
				.depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.6F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.6F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawn.build()).generationSettings(biomeSettings.build()).build();
	}

	/* KAEDE */
	public static Biome makeKaedeBiome() {
		BiomeGenerationSettings.Builder biomeSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilder_CM.AUTUMN);
		/** Village **/
		biomeSettings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
		/** Structure **/
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeSettings);
		/** Tree **/
		BiomeFeatures_CM.addKaedeTree(biomeSettings);

		/** Lake, Ore **/
		DefaultBiomeFeatures.addDefaultCarvers(biomeSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeSettings);

		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeSettings);

		DefaultBiomeFeatures.addForestFlowers(biomeSettings);
		DefaultBiomeFeatures.addDefaultGrass(biomeSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeSettings);

		/** Mob **/
		MobSpawnInfo.Builder mobSpawn = new MobSpawnInfo.Builder();
		/** 桜と銀杏から外れた動物を集める **/
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 1));

		/** ネコが出るため、クリーパーは少なめ 100 -> 50 **/
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 50, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
		mobSpawn.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.FOREST)
				.depth(0.1F).scale(0.2F).temperature(0.5F).downfall(0.6F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.6F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawn.build()).generationSettings(biomeSettings.build()).build();
	}

	public static Biome makeKaedeHills() {
		BiomeGenerationSettings.Builder biomeSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(SurfaceBuilder_CM.AUTUMN);
		/** Village **/
		/** Structure **/
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeSettings);
		/** Tree **/
		BiomeFeatures_CM.addKaedeHills(biomeSettings);

		/** Lake, Ore **/
		DefaultBiomeFeatures.addDefaultCarvers(biomeSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeSettings);

		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeSettings);

		DefaultBiomeFeatures.addForestFlowers(biomeSettings);
		DefaultBiomeFeatures.addDefaultGrass(biomeSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeSettings);

		/** Mob **/
		MobSpawnInfo.Builder mobSpawn = new MobSpawnInfo.Builder();
		/** 高所のため豚は半減 **/
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 5, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 1));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 2, 1, 2));

		/** 高所のため 3割減 **/
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 3, 1, 1));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 35, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 7, 1, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 3, 1, 1));
		mobSpawn.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.FOREST)
				.depth(0.45F).scale(0.3F).temperature(0.3F).downfall(0.6F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.6F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawn.build()).generationSettings(biomeSettings.build()).build();
	}

	/* ICHOH */
	public static Biome makeIchohBiome() {
		BiomeGenerationSettings.Builder biomeSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(SurfaceBuilder_CM.AUTUMN);
		/** Village **/
		biomeSettings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
		/** Structure **/
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeSettings);
		/** Tree **/
		BiomeFeatures_CM.addIchohTree(biomeSettings);

		/** Lake, Ore **/
		DefaultBiomeFeatures.addDefaultCarvers(biomeSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeSettings);

		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeSettings);

		DefaultBiomeFeatures.addForestFlowers(biomeSettings);
		DefaultBiomeFeatures.addDefaultGrass(biomeSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeSettings);

		/** Mob **/
		MobSpawnInfo.Builder mobSpawn = new MobSpawnInfo.Builder();
		/** 銀杏中毒のため中小の動物は出ない **/
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.HORSE, 5, 2, 6));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.DONKEY, 1, 1, 3));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.MULE, 1, 1, 3));

		/** 防虫効果でクモは出ない、知性の象徴として村人ゾンビ・ウィッチを5 -> 20 **/
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 80, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 20, 1, 1));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 20, 1, 1));
		mobSpawn.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.FOREST)
				.depth(0.1F).scale(0.2F).temperature(0.5F).downfall(0.5F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.6F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawn.build()).generationSettings(biomeSettings.build()).build();
	}

	public static Biome makeIchohHills() {
		BiomeGenerationSettings.Builder biomeSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(SurfaceBuilder_CM.AUTUMN);
		/** Village **/
		/** Structure **/
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeSettings);
		/** Tree **/
		BiomeFeatures_CM.addIchohHills(biomeSettings);

		/** Lake, Ore **/
		DefaultBiomeFeatures.addDefaultCarvers(biomeSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeSettings);

		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeSettings);

		DefaultBiomeFeatures.addForestFlowers(biomeSettings);
		DefaultBiomeFeatures.addDefaultGrass(biomeSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeSettings);

		/** Mob **/
		MobSpawnInfo.Builder mobSpawn = new MobSpawnInfo.Builder();
		/** 高所のため 牛と馬を半減 **/
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 4, 4, 4));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.HORSE, 2, 2, 6));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.DONKEY, 1, 1, 3));
		mobSpawn.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.MULE, 1, 1, 3));

		/** 高所のため 3割減 **/
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 56, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 14, 1, 1));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 70, 4, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 7, 1, 4));
		mobSpawn.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 14, 1, 1));
		mobSpawn.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.FOREST)
				.depth(0.45F).scale(0.3F).temperature(0.3F).downfall(0.6F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.6F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawn.build()).generationSettings(biomeSettings.build()).build();
	}

}
