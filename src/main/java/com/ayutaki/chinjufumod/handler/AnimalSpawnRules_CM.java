package com.ayutaki.chinjufumod.handler;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;

public class AnimalSpawnRules_CM {

	/*net.minecraft.entity.EntitySpawnPlacementRegistry*/
	public static void replaceAnimalSpawnRegistrys() {
		register(EntityType.CHICKEN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.SHEEP, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.COW, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.PIG, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.HORSE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		/* ロバ */
		register(EntityType.DONKEY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		/* ラバ */
		register(EntityType.MULE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		/*野生のラマ*/
		register(EntityType.LLAMA, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.WOLF, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.FOX, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.CAT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.PANDA, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		/*行商人のラマ*/
		register(EntityType.TRADER_LLAMA, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.SKELETON_HORSE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);
		register(EntityType.ZOMBIE_HORSE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalSpawnRules_CM::canAnimalSpawn);

	}

	public static <T extends MobEntity> void register(EntityType<T> entityTypeIn, EntitySpawnPlacementRegistry
			.PlacementType placementType, Heightmap.Type heightMapType, EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {

		try { EntitySpawnPlacementRegistry.register(entityTypeIn, placementType, heightMapType, predicate); }
		catch (IllegalStateException e) { }
	}
	public static boolean canAnimalSpawn(EntityType<?> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK|| worldIn.getBlockState(pos.down()).getBlock() == Wood_Blocks.FALL_LEAF) && worldIn.getLightSubtracted(pos, 0) > 8;
	}

}
