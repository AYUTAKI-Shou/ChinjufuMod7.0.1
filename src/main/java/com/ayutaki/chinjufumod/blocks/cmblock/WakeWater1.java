package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WakeWater1 extends Base_WakeWater {

	public WakeWater1(String name) {
		super(name);
	}

	/* TickRandomで消える */
	@Override
	public int tickRate(World worldIn) {
		return 10;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, Chinjufu_Blocks.WAKE_WATER1, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		worldIn.scheduleUpdate(pos, Chinjufu_Blocks.WAKE_WATER1, this.tickRate(worldIn));
		worldIn.setBlockState(pos, Chinjufu_Blocks.WAKE_WATER2.getDefaultState());
	}

	/* 航跡エフェクト */
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = worldIn;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = rand;
		if (true)
			/*la < 4 量*/
			for (int la = 0; la < 10; ++la) {
				/* 1.5F 消える速度？ 0.5D 範囲*/
				double d0 = (double) ((float) par2) + (double) (par5Random.nextFloat() - 1.5F) * 0.4D;
				double d1 = (double) ((float) par3) + (double) (par5Random.nextFloat() - 1.5F) * 0.4D;
				double d2 = (double) ((float) par4) + (double) (par5Random.nextFloat() - 1.5F) * 0.4D;

				par1World.spawnParticle(EnumParticleTypes.CLOUD, d0 + 0.9D, d1 + 0.00D, d2 + 0.9D, 0.0D, 0.0D, 0.0D);
		}
	}
}
