package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WakeWater2 extends Base_WakeWater {

	public WakeWater2(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		worldIn.getBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.WAKE_WATER2, 10);
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.WAKE_WATER2, 10);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (worldIn.isAreaLoaded(pos, 1)) { worldIn.removeBlock(pos, false); }
		worldIn.setBlock(pos, ChinjufuMod_Blocks.WAKE_WATER3.defaultBlockState(), 3); //must '3'. 4 does not work.
		worldIn.getBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.WAKE_WATER2, 10);
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		if (rand.nextDouble() < 0.1D) {
			double d0 = (double)pos.getX() + (rand.nextDouble() - 0.15F) * 0.4D;
			double d1 = (double)pos.getY() + (rand.nextDouble() - 0.15F) * 0.4D;
			double d2 = (double)pos.getZ() + (rand.nextDouble() - 0.15F) * 0.4D;
			worldIn.playLocalSound(d0, d1, d2, SoundEvents_CM.WATER_WAKE, SoundCategory.BLOCKS, 0.5F, 0.7F, false); }

		if (true)
			for(int i = 0; i < 10; ++i) {
				double d0 = (double)pos.getX() + (rand.nextDouble() - 1.0F) * 0.3D;
				double d1 = (double)pos.getY() + (rand.nextDouble() - 1.0F) * 0.3D;
				double d2 = (double)pos.getZ() + (rand.nextDouble() - 1.0F) * 0.3D;

				worldIn.addParticle(ParticleTypes.CLOUD, d0 + 0.7D, d1 - 0.4, d2 + 0.7D, 0.0D, 0.0D, 0.0D);
		}
	}
}
