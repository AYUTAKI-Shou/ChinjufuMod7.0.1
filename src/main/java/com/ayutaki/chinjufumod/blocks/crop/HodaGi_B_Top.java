package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class HodaGi_B_Top extends Base_HodaGi_Top {

	public HodaGi_B_Top(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);
		
		if (i != 1) {
			if (stack.isEmpty()) {
				
				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_C_TOP.get().defaultBlockState()
							.setValue(Base_HodaGi_Top.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Top.STAGE_1_4,Integer.valueOf(1))
							.setValue(Base_HodaGi_Top.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 3) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_C_TOP.get().defaultBlockState()
							.setValue(Base_HodaGi_Top.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(2))
							.setValue(Base_HodaGi_Top.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
				if (i == 4) {
					worldIn.setBlock(pos, Crop_Blocks.HODAGI_C_TOP.get().defaultBlockState()
							.setValue(Base_HodaGi_Top.H_FACING, state.getValue(H_FACING))
							.setValue(Base_HodaGi_Top.STAGE_1_4, Integer.valueOf(3))
							.setValue(Base_HodaGi_Top.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
}
