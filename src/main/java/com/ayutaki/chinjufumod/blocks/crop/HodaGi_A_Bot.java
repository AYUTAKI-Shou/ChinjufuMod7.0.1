package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class HodaGi_A_Bot extends Base_HodaGi_Bot {

	public HodaGi_A_Bot(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);
		double hitY = hit.getLocation().y - (double)hit.getBlockPos().getY();
		
		if (i != 1) {
			if (stack.isEmpty() && hitY < 0.75D) {
				
				CMEvents.takeKinoko(worldIn, pos, playerIn);

				if (i == 2) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_B_BOT.get().defaultBlockState()
							.setValue(Base_HodaGi_Bot.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Bot.STAGE_1_4,Integer.valueOf(1))
							.setValue(Base_HodaGi_Bot.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 3) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_B_BOT.get().defaultBlockState()
							.setValue(Base_HodaGi_Bot.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(2))
							.setValue(Base_HodaGi_Bot.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 4) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_B_BOT.get().defaultBlockState()
							.setValue(Base_HodaGi_Bot.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(3))
							.setValue(Base_HodaGi_Bot.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }

		else { return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		worldIn.setBlock(pos.above(), Crop_Blocks.HODAGI_A_TOP.get().defaultBlockState()
				.setValue(BaseStage4_FaceWater.H_FACING, state.getValue(H_FACING))
				.setValue(BaseStage4_FaceWater.WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(BaseStage4_FaceWater.STAGE_1_4,Integer.valueOf(1)), 3);
	}
}
