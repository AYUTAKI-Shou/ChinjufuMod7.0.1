package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HodaGi_B_Top extends Base_HodaGi_Top {

	public HodaGi_B_Top(String name) {
		super(name);
	}

	/* RightClick Action */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i != 1) {
			if (stack.isEmpty()) {
				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_C_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(HodaGi_C_Bot.STAGE_1_4, Integer.valueOf(1))); }

				if (i == 3) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_C_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(HodaGi_C_Bot.STAGE_1_4, Integer.valueOf(2))); }

				if (i == 4) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_C_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(HodaGi_C_Bot.STAGE_1_4, Integer.valueOf(3))); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }

		/** 'true' to not put anything on top. **/
		return true;
	}

}
