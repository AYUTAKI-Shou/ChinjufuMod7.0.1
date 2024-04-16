package com.ayutaki.chinjufumod.world.generate;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TakenokoGen extends WorldGenerator {

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		for (int i = 0; i < 64; ++i) {
			BlockPos pos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

			if (worldIn.isAirBlock(pos) && (!worldIn.provider.isNether() || pos.getY() < 255) && 
					Seasonal_Blocks.TAKENOKO.canBlockStay(worldIn, pos, Seasonal_Blocks.TAKENOKO.getDefaultState())) {
				worldIn.setBlockState(pos, Seasonal_Blocks.TAKENOKO.getDefaultState(), 2);
			}
		}
		return true;
	}
}
