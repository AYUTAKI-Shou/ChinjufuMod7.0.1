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

public class HodaGi_A_Top extends Base_HodaGi_Top {

	public HodaGi_A_Top(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		if (i != 1) {
			if (stack.isEmpty()) {
				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_B_TOP.defaultBlockState()
							.setValue(Base_HodaGi_Top.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Top.STAGE_1_4,Integer.valueOf(1))
							.setValue(Base_HodaGi_Top.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 3) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_B_TOP.defaultBlockState()
							.setValue(Base_HodaGi_Top.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(2))
							.setValue(Base_HodaGi_Top.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 4) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_B_TOP.defaultBlockState()
							.setValue(Base_HodaGi_Top.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(3))
							.setValue(Base_HodaGi_Top.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
