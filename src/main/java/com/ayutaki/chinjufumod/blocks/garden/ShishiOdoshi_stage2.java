package com.ayutaki.chinjufumod.blocks.garden;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShishiOdoshi_stage2 extends BaseShishiOdoshi {

	public ShishiOdoshi_stage2(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);

		if (stack.isEmpty() && state.get(HALF) == DoubleBlockHalf.LOWER) {
			
			CMEvents.soundStoneButton_Off(worldIn, pos);
			worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHI.getDefaultState()
							.with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
							.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.LOWER)
							.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
							.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1)));

			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI.getDefaultState()
							.with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
							.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
							.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
							.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(1))); }
		
		if (!stack.isEmpty()) {
			CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2, 30);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_1_4);
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		
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
				worldIn.setBlockState(pos, state.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				
				worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2, 30);
				break;

			case 2:
				worldIn.setBlockState(pos, state.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				
				/* state.get(WHICH) == false 空=0,1,2,3=満,4=溢 */
				if (direction == Direction.NORTH && state.get(WHICH) == false) {
					if (eastBlock instanceof Chouzubachi && eastState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.east(), eastState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(eastState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				if (direction == Direction.SOUTH && state.get(WHICH) == false) {
					if (westBlock instanceof Chouzubachi && westState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.west(), westState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(westState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				if (direction == Direction.EAST && state.get(WHICH) == false) {
					if (southBlock instanceof Chouzubachi && southState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.south(), southState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(southState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				if (direction == Direction.WEST && state.get(WHICH) == false) {
					if (northBlock instanceof Chouzubachi && northState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.north(), northState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(northState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				/* state.get(WHICH) == true */
				if (direction == Direction.NORTH && state.get(WHICH) == true) {
					if (westBlock instanceof Chouzubachi && westState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.west(), westState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(westState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				if (direction == Direction.SOUTH && state.get(WHICH) == true) {
					if (eastBlock instanceof Chouzubachi && eastState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.east(), eastState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(eastState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				if (direction == Direction.EAST && state.get(WHICH) == true) {
					if (northBlock instanceof Chouzubachi && northState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.north(), northState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(northState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }

				if (direction == Direction.WEST && state.get(WHICH) == true) {
					if (southBlock instanceof Chouzubachi && southState.get(Chouzubachi.STAGE_0_3) < 3) {
						worldIn.setBlockState(pos.south(), southState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(southState.get(Chouzubachi.STAGE_0_3) + 1))); }
					else { } }
				
				worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2, 30);
				break;

			case 3:
				worldIn.setBlockState(pos, state.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(i + 1)));
				
				/* state.get(WHICH) == false */
				if (direction == Direction.NORTH && state.get(WHICH) == false) {
					if (eastBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.east(), eastState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				if (direction == Direction.SOUTH && state.get(WHICH) == false) {
					if (westBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.west(), westState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				if (direction == Direction.EAST && state.get(WHICH) == false) {
					if (southBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.south(), southState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				if (direction == Direction.WEST && state.get(WHICH) == false) {
					if (northBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.north(), northState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				/* state.get(WHICH) == true */
				if (direction == Direction.NORTH && state.get(WHICH) == true) {
					if (westBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.west(), westState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				if (direction == Direction.SOUTH && state.get(WHICH) == true) {
					if (eastBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.east(), eastState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				if (direction == Direction.EAST && state.get(WHICH) == true) {
					if (northBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.north(), northState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }

				if (direction == Direction.WEST && state.get(WHICH) == true) {
					if (southBlock instanceof Chouzubachi) {
						worldIn.setBlockState(pos.south(), southState.with(Chouzubachi.STAGE_0_3, Integer.valueOf(3))); }
					else { } }
				
				worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2, 30);
				break;
				
			case 4:
				worldIn.playSound(null, pos, SoundEvents_CM.SHISHIODOSHI, SoundCategory.BLOCKS, 0.5F, 1.0F);
				
				worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHI.getDefaultState()
							.with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
							.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
							.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.LOWER)
							.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)));
				worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI.getDefaultState()
						.with(BaseShishiOdoshi.H_FACING, state.get(H_FACING))
						.with(BaseShishiOdoshi.WHICH, state.get(WHICH))
						.with(BaseShishiOdoshi.HALF, DoubleBlockHalf.UPPER)
						.with(BaseShishiOdoshi.STAGE_1_4, Integer.valueOf(2)));
				
				worldIn.getPendingBlockTicks().scheduleTick(pos, Garden_Blocks.SHISHIODOSHI2, 30);
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

		worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, rand.nextFloat() * 0.25F, rand.nextFloat() + 0.75F, false);
	}

}
