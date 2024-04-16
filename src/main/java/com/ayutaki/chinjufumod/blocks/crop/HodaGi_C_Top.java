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

public class HodaGi_C_Top extends Base_HodaGi_Top {

	public HodaGi_C_Top(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);
		
		if (i != 1) {
			
			if (stack.isEmpty()) {

				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_A_TOP.getDefaultState()
							.with(Base_HodaGi_Top.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(1))
							.with(Base_HodaGi_Top.WATERLOGGED, state.get(WATERLOGGED))); }

				if (i == 3) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_A_TOP.getDefaultState()
							.with(Base_HodaGi_Top.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(2))
							.with(Base_HodaGi_Top.WATERLOGGED, state.get(WATERLOGGED))); }
		
				if (i == 4) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_A_TOP.getDefaultState()
							.with(Base_HodaGi_Top.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(3))
							.with(Base_HodaGi_Top.WATERLOGGED, state.get(WATERLOGGED))); }
			}
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
