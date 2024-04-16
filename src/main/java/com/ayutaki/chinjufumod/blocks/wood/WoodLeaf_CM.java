package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WoodLeaf_CM extends LeavesBlock {

	public WoodLeaf_CM(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* Add Particle */
	@SuppressWarnings("deprecation")
	public static boolean isFree(BlockState state) {
		return state.isAir() || state.is(BlockTags.FIRE) || state.liquid() || state.canBeReplaced();
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level worldIn, BlockPos pos, RandomSource rand) {
		super.animateTick(state, worldIn, pos, rand);

		if (this == Wood_Blocks.SAKURA_flow.get()) {
			/** 1/200 **/
			if (rand.nextInt(200) == 0) {

				if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((ParticleOptions) ParticleTypes_CM.FALLSAKURA.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}

		if (this == Wood_Blocks.KAEDE_leaf.get()) {
			if (rand.nextInt(400) == 0) {

				if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((ParticleOptions) ParticleTypes_CM.FALLKAEDE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}

		if (this == Wood_Blocks.ICHOH_leaf.get()) {
			if (rand.nextInt(400) == 0) {

				if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((ParticleOptions) ParticleTypes_CM.FALLICHOH.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}
	}
	
	/* drak 0.0F -> 1.0F light */
	@Override
	public float getShadeBrightness(BlockState state, BlockGetter world, BlockPos pos) {
		return 0.8F;
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 30; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 60; }
	
}
