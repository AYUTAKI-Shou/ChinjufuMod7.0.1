package com.ayutaki.chinjufumod.world.generate;

import java.util.Random;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CM_OreGen implements IWorldGenerator {

	private WorldGenerator bauxite_cm;

	public CM_OreGen() {
		bauxite_cm = new WorldGenMinable(Chinjufu_Blocks.BAUXITE_ORE.getDefaultState(), 8);
	}

	private void runGenerator(WorldGenerator gen, World worldIn, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {

		if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
			throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;

		for(int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			gen.generate(worldIn, rand, new BlockPos(x, y, z));
		}
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World worldIn, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		/*ifを追加*/
		if (Config_CM.isGeneratorEnabled && worldIn.provider instanceof WorldProviderSurface) {

			switch (worldIn.provider.getDimension()) {

			case 0: //オーバーワールド Coal=142,Iron=77,RedStone=25,Gold=8,Lapiz=3.4
				this.runGenerator(bauxite_cm, worldIn, rand, chunkX, chunkZ, Config_CM.isGeneratorChance, 10, 70);
				break;

			case -1: // ネザー
				break;

			case 1: // エンド
				break;
			}
		}
	}

}
