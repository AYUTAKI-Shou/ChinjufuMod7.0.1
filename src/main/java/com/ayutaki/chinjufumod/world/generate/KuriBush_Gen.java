package com.ayutaki.chinjufumod.world.generate;

import java.util.Random;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class KuriBush_Gen implements IWorldGenerator {
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World worldIn, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (Config_CM.chestnutsFall == true) { return; }
		
		if (Config_CM.chestnutsFall != true) {
			if (!worldIn.provider.isSurfaceWorld() || worldIn.provider.getDimension() != 0) { return; }
	
			if (rand.nextFloat() > 64) { return; }
	
			// offset the generation by +8 on x and z to prevent cascading chunk generation
			int poxX = (chunkX * 16 + 8) + rand.nextInt(16);//gets us the world position of where to spawn the gysahls
			int posZ = (chunkZ * 16 + 8) + rand.nextInt(16);
			BlockPos finalPosition = worldIn.getTopSolidOrLiquidBlock(new BlockPos(poxX, 0, posZ));//Gets the top block
	
			Biome biome = worldIn.getBiome(new BlockPos(poxX, 64, posZ));
			if (biome != Biomes_CM.BIOME_ICHOH && biome != Biomes_CM.BIOME_ICHOH_HILL && 
					biome != Biomes_CM.BIOME_KAEDE && biome != Biomes_CM.BIOME_KAEDE_HILL) { return; }
	
			IBlockState state = Seasonal_Blocks.KURIIGA_BUSH.getDefaultState();
	
			for (int i = 0; i < 24; ++i) {
				BlockPos pos = finalPosition.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
	
				if (worldIn.isAirBlock(pos) && (!worldIn.provider.isNether() || pos.getY() < 255) && 
						Seasonal_Blocks.KURIIGA_BUSH.canBlockStay(worldIn, pos, Seasonal_Blocks.KURIIGA_BUSH.getDefaultState())) {
					worldIn.setBlockState(pos, state, 2);
				}
			}
		}
	}

}
