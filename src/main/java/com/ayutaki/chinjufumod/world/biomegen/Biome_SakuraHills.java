package com.ayutaki.chinjufumod.world.biomegen;

import java.util.Random;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_Sakura;
import com.ayutaki.chinjufumod.blocks.wood.treegen.WorldGenTree_SakuraBig;
import com.ayutaki.chinjufumod.world.generate.TakenokoGen;

import net.minecraft.block.BlockFlower;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Biome_SakuraHills extends ModBiomeBase {

	public Biome_SakuraHills() {
		super(new BiomeProperties("Sakura_Hills")
				.setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.7F).setRainfall(0.6F));
		this.setRegistryName("biome_sakura_hills");
		this.decorator.treesPerChunk = 12;
		this.decorator.grassPerChunk = 2;
		this.decorator.generateFalls = false;

		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();

		this.setSpawnables();

	}

	/* 生やす木の設定 銀杏と枯れ木をまぜる */
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		int sakura = (int) 20 / Config_CM.sakuraTreeChance;

		return (WorldGenAbstractTree) (rand.nextInt(sakura) == 0 ? (rand.nextInt(20) == 0 ? new WorldGenTree_SakuraBig(false) : new WorldGenTree_Sakura(false)) :
			(rand.nextInt(20) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false)));
	}

	/* 草花の設定 */
	public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
		return super.pickRandomFlower(rand, pos);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return rand.nextInt(12) == 0 ? new TakenokoGen() : super.getRandomWorldGenForGrass(rand);
	}

	/* ソンビなどのスポーン */
	private void setSpawnables() {
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();

		/** 高所のため羊は半減 **/
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 10, 4, 4));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 6, 4, 4));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));

		/** 高所のため 3割減 **/
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySpider.class, 70, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 70, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 3, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 70, 4, 4));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCreeper.class, 70, 4, 4));

		spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
		spawnableCaveCreatureList.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
	}

	public Class <? extends Biome > getBiomeClass() {
		return Biome_SakuraHills.class;
	}
}
