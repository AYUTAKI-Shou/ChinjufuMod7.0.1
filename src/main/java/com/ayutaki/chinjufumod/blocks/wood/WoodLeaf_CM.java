package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.particles.IParticleData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

/* data\minecraft\tags\blocks\leaves.json と logs.json で消失を予防 */
public class WoodLeaf_CM extends LeavesBlock {

	public WoodLeaf_CM(AbstractBlock.Properties properties) {
		super(properties);
	}

	@SuppressWarnings("deprecation")
	public static boolean isFree(BlockState state) {
		Material material = state.getMaterial();
		return state.isAir() || state.is(BlockTags.FIRE) || material.isLiquid() || material.isReplaceable();
	}

	/* Add Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.animateTick(stateIn, worldIn, pos, rand);

		if (this == Wood_Blocks.SAKURA_flow) {
			/** 1/200 **/
			if (rand.nextInt(200) == 0) {

				if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLSAKURA, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}

		if (this == Wood_Blocks.KAEDE_leaf) {
			if (rand.nextInt(400) == 0) {

				if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLKAEDE, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}

		if (this == Wood_Blocks.ICHOH_leaf) {
			if (rand.nextInt(400) == 0) {

				if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLICHOH, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}
	}

	/* 周囲の光透過 影0.0F -> 1.0F透過*/
	@OnlyIn(Dist.CLIENT)
	public float getShadeBrightness(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0.5F;
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 30; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 60; }
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.HOE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
