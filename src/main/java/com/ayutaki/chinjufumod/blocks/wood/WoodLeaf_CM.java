package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* data\minecraft\tags\blocks\leaves.json と logs.json で消失を予防 */
public class WoodLeaf_CM extends LeavesBlock {

	public WoodLeaf_CM(Block.Properties properties) {
		super(properties);
	}

	/* Add Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.animateTick(stateIn, worldIn, pos, rand);

		if (this == Wood_Blocks.SAKURA_flow) {
			/** 1/200 **/
			if (rand.nextInt(200) == 0) {

				if (worldIn.isAirBlock(pos.down())) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLSAKURA, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}

		if (this == Wood_Blocks.KAEDE_leaf) {
			if (rand.nextInt(400) == 0) {

				if (worldIn.isAirBlock(pos.down())) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLKAEDE, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}

		if (this == Wood_Blocks.ICHOH_leaf) {
			if (rand.nextInt(400) == 0) {

				if (worldIn.isAirBlock(pos.down())) {

					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());

					worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLICHOH, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		}
	}

	/* 周囲の光透過 影0.0F -> 1.0F透過*/
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0.5F;
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

}
