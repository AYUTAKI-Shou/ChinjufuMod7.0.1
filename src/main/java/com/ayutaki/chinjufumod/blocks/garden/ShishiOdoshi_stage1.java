package com.ayutaki.chinjufumod.blocks.garden;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShishiOdoshi_stage1 extends BaseShishiOdoshi {

	public ShishiOdoshi_stage1(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);

		if (stack.isEmpty() && state.get(HALF) == DoubleBlockHalf.LOWER) {
			if (i == 1) {
				CMEvents.soundStoneButton_On(worldIn, pos);

				worldIn.setBlockState(pos, state.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2))); }

			if (i != 1) {
				CMEvents.soundStoneButton_Off(worldIn, pos);

				worldIn.setBlockState(pos, state.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1))); }
		}
		
		if (!stack.isEmpty()) {
			CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI, 150);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_1_4);
		DoubleBlockHalf half = state.get(HALF);
		
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		switch (half) {
		case LOWER:
		default:
			
			switch (i) {
			case 1:
			default:
				break;

			case 2:
			case 3:
				worldIn.setBlockState(pos, state.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				
				worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI, 150);
				break;
				
			case 4:
				worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHI2.getDefaultState()
						.with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.LOWER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI2.getDefaultState()
						.with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)));
				
				worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI, 150);
				break;
			} // switch
			break;

		case UPPER:
			break;
		} // switch LOWER-UPPER
	}

	/* Play Sound and Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.5D;
		double d2 = (double)pos.getZ() + 0.5D;
		int i = state.get(STAGE_1_4);

		if (i == 1) { }

		if (i != 1) {
			worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, rand.nextFloat() * 0.25F, rand.nextFloat() + 0.75F, false); }
	}

}
