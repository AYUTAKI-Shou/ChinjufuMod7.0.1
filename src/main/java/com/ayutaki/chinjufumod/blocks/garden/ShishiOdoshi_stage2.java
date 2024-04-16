package com.ayutaki.chinjufumod.blocks.garden;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShishiOdoshi_stage2 extends BaseShishiOdoshi {

	public ShishiOdoshi_stage2(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);

		if (stack.isEmpty() && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			
			CMEvents.soundStoneButton_Off(worldIn, pos);
			worldIn.setBlock(pos, Garden_Blocks.SHISHIODOSHI.get().defaultBlockState()
							.setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
							.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.LOWER)
							.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
							.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)), 3);

			worldIn.setBlock(pos.above(), Garden_Blocks.SHISHIODOSHI.get().defaultBlockState()
							.setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
							.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
							.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
							.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)), 3); }
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }

		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2.get(), 30);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		
		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());
		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }
		
		switch (half) {
		case LOWER:
		default:

			switch (i) {
			case 1:
			default:
				worldIn.setBlock(pos, state.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);

				worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2.get(), 30);
				break;

			case 2:
				worldIn.setBlock(pos, state.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				
				/* state.getValue(WHICH) == false 空=0,1,2,3=満,4=溢 */
				if (direction == Direction.NORTH && state.getValue(WHICH) == false) {
					if (eastBlock instanceof Chouzubachi && eastState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.east(), eastState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(eastState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				if (direction == Direction.SOUTH && state.getValue(WHICH) == false) {
					if (westBlock instanceof Chouzubachi && westState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.west(), westState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(westState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				if (direction == Direction.EAST && state.getValue(WHICH) == false) {
					if (southBlock instanceof Chouzubachi && southState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.south(), southState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(southState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				if (direction == Direction.WEST && state.getValue(WHICH) == false) {
					if (northBlock instanceof Chouzubachi && northState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.north(), northState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(northState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				/* state.getValue(WHICH) == true */
				if (direction == Direction.NORTH && state.getValue(WHICH) == true) {
					if (westBlock instanceof Chouzubachi && westState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.west(), westState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(westState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				if (direction == Direction.SOUTH && state.getValue(WHICH) == true) {
					if (eastBlock instanceof Chouzubachi && eastState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.east(), eastState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(eastState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				if (direction == Direction.EAST && state.getValue(WHICH) == true) {
					if (northBlock instanceof Chouzubachi && northState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.north(), northState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(northState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }

				if (direction == Direction.WEST && state.getValue(WHICH) == true) {
					if (southBlock instanceof Chouzubachi && southState.getValue(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlock(pos.south(), southState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(southState.getValue(Chouzubachi.STAGE_0_3) + 1)), 3); }
					else { } }
				
				worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2.get(), 30);
				break;

			case 3:
				worldIn.setBlock(pos, state.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)), 3);
				
				/* state.getValue(WHICH) == false */
				if (direction == Direction.NORTH && state.getValue(WHICH) == false) {
					if (eastBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.east(), eastState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				if (direction == Direction.SOUTH && state.getValue(WHICH) == false) {
					if (westBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.west(), westState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				if (direction == Direction.EAST && state.getValue(WHICH) == false) {
					if (southBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.south(), southState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				if (direction == Direction.WEST && state.getValue(WHICH) == false) {
					if (northBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.north(), northState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				/* state.getValue(WHICH) == true */
				if (direction == Direction.NORTH && state.getValue(WHICH) == true) {
					if (westBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.west(), westState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				if (direction == Direction.SOUTH && state.getValue(WHICH) == true) {
					if (eastBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.east(), eastState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				if (direction == Direction.EAST && state.getValue(WHICH) == true) {
					if (northBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.north(), northState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }

				if (direction == Direction.WEST && state.getValue(WHICH) == true) {
					if (southBlock instanceof Chouzubachi) {
						worldIn.setBlock(pos.south(), southState.setValue(Chouzubachi.STAGE_0_3, Integer.valueOf(3)), 3); }
					else { } }
				
				worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2.get(), 30);
				break;
				
			case 4:
				worldIn.playSound(null, pos, SoundEvents_CM.SHISHIODOSHI.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
				
				worldIn.setBlock(pos, Garden_Blocks.SHISHIODOSHI.get().defaultBlockState()
							.setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
							.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
							.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.LOWER)
							.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlock(pos.above(), Garden_Blocks.SHISHIODOSHI.get().defaultBlockState()
						.setValue(BaseShishiOdoshi.H_FACING, state.getValue(H_FACING))
						.setValue(BaseShishiOdoshi.WHICH, state.getValue(WHICH))
						.setValue(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)), 3);
				
				worldIn.scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2.get(), 30);
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

		worldIn.playLocalSound(d0, d1, d2, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, rand.nextFloat() * 0.25F, rand.nextFloat() + 0.75F, false);
	}
}
