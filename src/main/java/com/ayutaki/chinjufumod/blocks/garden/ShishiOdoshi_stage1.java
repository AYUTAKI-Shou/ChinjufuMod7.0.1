package com.ayutaki.chinjufumod.blocks.garden;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShishiOdoshi_stage1 extends BaseShishiOdoshi {

	public ShishiOdoshi_stage1(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		if (stack.isEmpty() && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (i == 1) {
				CMEvents.soundStoneButton_On(worldIn, pos);

				worldIn.setBlock(pos, state.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)), 3); }

			if (i != 1) {
				CMEvents.soundStoneButton_Off(worldIn, pos);

				worldIn.setBlock(pos, state.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)), 3);
				worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)), 3); } }
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI.get(), 150);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);
		DoubleBlockHalf half = state.getValue(HALF);
		
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
				worldIn.setBlock(pos, state.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
							.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
							.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
							.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				
				worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI.get(), 150);
				break;
				
			case 4:
				worldIn.setBlock(pos, Garden_Blocks.SHISHIODOSHI2.get().defaultBlockState()
						.setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)), 3);
				worldIn.setBlock(pos.above(), Garden_Blocks.SHISHIODOSHI2.get().defaultBlockState()
						.setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)), 3);
				
				worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI.get(), 150);
				break;
			} // STAGE_1_4
			break;

		case UPPER:
			break;
		} // HALF
	}
	
	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level worldIn, BlockPos pos, RandomSource rand) {
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.5D;
		double d2 = (double)pos.getZ() + 0.5D;
		int i = state.getValue(STAGE_1_4);

		if (i == 1) { }

		if (i != 1) {
			worldIn.playLocalSound(d0, d1, d2, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, rand.nextFloat() * 0.25F, rand.nextFloat() + 0.75F, false); }
	}
}
