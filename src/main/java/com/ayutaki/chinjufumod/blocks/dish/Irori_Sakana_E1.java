package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Irori_Sakana_E1 extends BaseIrori_Sakana {

	public Irori_Sakana_E1(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		boolean hitNorth = (hitX > 0.3D) && (hitX < 0.7D) && (hitZ < 0.3D);
		boolean hitSouth = (hitX > 0.3D) && (hitX < 0.7D) && (hitZ > 0.7D);
		boolean hitEast = (hitX > 0.7D) && (hitZ > 0.3D) && (hitZ < 0.7D);
		boolean hitWest = (hitX < 0.3D) && (hitZ > 0.3D) && (hitZ < 0.7D);

		switch (i) {
		case 0 : //00 EEER 北東南西
		default:
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitWest != true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitWest == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(11)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(9)), 3); }
				
				if (hitSouth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(3)), 3); }
				
				if (hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 1 : //01 EEEC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitWest != true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitWest == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(12)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(10)), 3); }
				
				if (hitSouth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(4)), 3); }
				
				if (hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 2 : //02 EERE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitSouth != true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(11)), 3); }
				
				if (hitSouth == true) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (hitWest == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(3)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 3 : //03 EERR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true || hitEast == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true || hitWest == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(12)), 3); }
				
				if (hitSouth == true || hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 4 : //04 EERC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true || hitEast == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(2)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(13)), 3); }
				
				if (hitSouth == true || hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 5 : //05 EECE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitSouth != true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(14)), 3); }
				
				if (hitSouth == true) { CMEvents.soundTouchBlock(worldIn, pos); }

				if (hitWest == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(6)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 6 : //06 EECR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true || hitEast == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hitWest == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(15)), 3); }
				
				if (hitSouth == true || hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 7 : //07 EECC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true || hitEast == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(1)), 3); }

				if (hitWest == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(5)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }
				
				if (hitEast == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
							.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hitSouth == true || hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 8 : //08 EREE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitEast != true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
				
				if (hitEast == true) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (hitSouth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(11)), 3); }
				
				if (hitWest == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(9)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 9 : //09 ERER 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true || hitSouth == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast == true || hitWest == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
				
				if (hitEast == true || hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (hitSouth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(12)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 10 : //10 EREC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true || hitSouth == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(8)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); }
				
				if (hitEast == true || hitWest == true) { CMEvents.soundTouchBlock(worldIn, pos); }

				if (hitSouth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(13)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 11 : //11 ERRE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitEast == true || hitSouth == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitNorth == true || hitWest == true) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); }
				
				if (hitEast == true || hitSouth == true) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (hitWest == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(12)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 12 : //12 ERRR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitNorth != true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }
				
				if (hitNorth != true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 13 : //13 ERRC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast == true || hitSouth == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(11)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); }
				
				if (hitNorth != true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 14 : //14 ERCE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitEast == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitSouth == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(8)), 3); }
				
				if (hitNorth == true || hitWest == true) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9)), 3); }
				
				if (hitEast == true || hitSouth == true) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (hitWest == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(15)), 3); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
	
		case 15 : //15 ERCR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth == true) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(9)), 3); }
				
				if (hitEast == true || hitWest == true) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth == true) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10)), 3); }
				
				if (hitNorth != true) { CMEvents.soundTouchBlock(worldIn, pos); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
		} // switch
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* TickRandom */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (this.isCooking(worldIn, pos)) {

			if (i == 0) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(1))); }//1 EEEC

			if (i == 2) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(5))); }//5 EECE

			if (i == 3 || i == 4 || i == 6) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(7))); }//7 EECC

			if (i == 8) {
				worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1))); }//1 ECEE

			if (i == 9 || i == 10) {
				worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3))); }//3 ECEC

			if (i == 11 || i == 14) {
				worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7))); }//7 ECCE

			if (i == 12 || i == 13 || i == 15) {
				worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
						.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9))); }//9 ECCC

			else { }
		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}


	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 0) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0)); }

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 2) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0)); }

		if (i == 3) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 2, 0)); }

		if (i == 4) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 5) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 6) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 7) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 2, 0)); }

		if (i == 8) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0)); }

		if (i == 9) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 2, 0)); }

		if (i == 10) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 11) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 2, 0)); }

		if (i == 12) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 3, 0)); }

		if (i == 13) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 2, 0));
							stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 14) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		if (i == 15) { stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA, 2, 0));
							stack.add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1, 0)); }

		return stack;
	}

}
