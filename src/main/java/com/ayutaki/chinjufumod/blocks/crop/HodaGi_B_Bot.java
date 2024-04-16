package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class HodaGi_B_Bot extends Base_HodaGi_Bot {

	public HodaGi_B_Bot(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);
		double hitY = hit.getHitVec().y - (double)hit.getPos().getY();

		if (i != 1) {
			
			if (stack.isEmpty() && hitY < 0.75D) {
				
				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_C_BOT.getDefaultState()
							.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(1))
							.with(Base_HodaGi_Bot.WATERLOGGED, state.get(WATERLOGGED))); }
		
				if (i == 3) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_C_BOT.getDefaultState()
							.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(2))
							.with(Base_HodaGi_Bot.WATERLOGGED, state.get(WATERLOGGED))); }
		
				if (i == 4) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_C_BOT.getDefaultState()
							.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(3))
							.with(Base_HodaGi_Bot.WATERLOGGED, state.get(WATERLOGGED))); }
			}
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
