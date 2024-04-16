package com.ayutaki.chinjufumod.world.biomegen;

import java.util.Random;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_OakKareBig;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Biome_Kaede extends ModBiomeBase {

	public Biome_Kaede() {
		super(new BiomeProperties("Kaede")
				.setBaseHeight(0.25F).setTemperature(0.45F).setRainfall(0.3F));
		this.setRegistryName("biome_kaede");
		this.decorator.treesPerChunk = 10;
		this.decorator.grassPerChunk = 1;
		this.decorator.generateFalls = false;

		this.setSpawnables();
	}

	/* 土壌の変更 */
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.topBlock = Seasonal_Blocks.FALL_LEAF.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}

	/* 生やす木の設定 銀杏と枯れ木をまぜる */
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		int kaede = (int) 20 / Config_CM.kaedeTreeChance;

		return (WorldGenAbstractTree) (rand.nextInt(kaede) == 0 ? new WorldGenTree_Kaede(false) :
			(rand.nextInt(30) == 0 ? new WorldGenTree_OakKareBig(false) : new WorldGenTree_OakKare(false)));
	}

	/* 草花の設定 (ConfigCM_Core.chestnutsFall == true)*/
	@Override
	public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
		return super.pickRandomFlower(rand, pos);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return super.getRandomWorldGenForGrass(rand);
	}

	/* ソンビなどのスポーン */
	private void setSpawnables() {
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();

		/** 桜と銀杏から外れた動物を集める **/
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 10, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityOcelot.class, 2, 1, 1));

		/** ネコが出るため, クリーパーは少なめ 100 -> 50 **/
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySpider.class, 100, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 95, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 5, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCreeper.class, 50, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityWitch.class, 5, 1, 1));

		spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
		spawnableCaveCreatureList.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
	}

	public Class <? extends Biome > getBiomeClass() {
		return Biome_Kaede.class;
	}
}
