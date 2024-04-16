package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class HodaGi_C_Bot extends Base_HodaGi_Bot {

	public HodaGi_C_Bot(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);
		double hitY = hit.getLocation().y - (double)hit.getBlockPos().getY();
		
		if (i != 1) {
			if (stack.isEmpty() && hitY < 0.75D) {
				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_A_BOT.defaultBlockState()
							.setValue(Base_HodaGi_Bot.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Bot.STAGE_1_4,Integer.valueOf(1))
							.setValue(Base_HodaGi_Bot.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 3) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_A_BOT.defaultBlockState()
							.setValue(Base_HodaGi_Bot.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(2))
							.setValue(Base_HodaGi_Bot.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 4) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_A_BOT.defaultBlockState()
							.setValue(Base_HodaGi_Bot.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(3))
							.setValue(Base_HodaGi_Bot.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
