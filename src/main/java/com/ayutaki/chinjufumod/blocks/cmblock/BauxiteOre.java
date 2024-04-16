package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class BauxiteOre extends OreBlock {

	public BauxiteOre(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Drop EXP */
	@Override
	protected int xpOnDrop(Random rand) {
		return MathHelper.nextInt(rand, 1, 3);
	}

	/* シルクタッチで壊した時はゼロ */
	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0? this.xpOnDrop(RANDOM) : 0;
	}

}
