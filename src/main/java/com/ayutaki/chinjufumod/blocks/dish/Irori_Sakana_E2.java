package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Irori_Sakana_E2 extends BaseIrori_Sakana {

	public Irori_Sakana_E2(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_0_15);
		boolean waterlogged = state.get(WATERLOGGED);

		boolean hitNorth = (hit.getHitVec().x - (double)pos.getX() > 0.3D) && (hit.getHitVec().x - (double)pos.getX() < 0.7D) && (hit.getHitVec().z - (double)pos.getZ() < 0.3D);
		boolean hitSouth = (hit.getHitVec().x - (double)pos.getX() > 0.3D) && (hit.getHitVec().x - (double)pos.getX() < 0.7D) && (hit.getHitVec().z - (double)pos.getZ() > 0.7D);
		boolean hitEast = (hit.getHitVec().x - (double)pos.getX() > 0.7D) && (hit.getHitVec().z - (double)pos.getZ() > 0.3D) && (hit.getHitVec().z - (double)pos.getZ() < 0.7D);
		boolean hitWest = (hit.getHitVec().x - (double)pos.getX() < 0.3D) && (hit.getHitVec().z - (double)pos.getZ() > 0.3D) && (hit.getHitVec().z - (double)pos.getZ() < 0.7D);

		switch (i) {
		case 0: //00 ERCC 北東南西
		default:
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10)), 3); }

				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 1: //01 ECEE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(12)), 3); }
					
					if (hitEast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(2)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 2: //02 ECER 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13)), 3); }
					
					if (hitEast || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(5)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 3: //03 ECEC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
				
				if (hitWest) {					
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(1)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); }
					
					if (hitEast || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(6)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 4: //04 ECRE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }
				
				if (hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15)), 3); }
					
					if (hitEast || hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(5)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 5: //05 ECRR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
				
				if (hitSouth || hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 6: //06 ECRC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {					
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
				
				if (hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest) {					
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(4)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 7: //07 ECCE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); }

				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(1)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }
					
					if (hitEast || hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(8)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 8: //08 ECCR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); }

				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(2)), 3); }
				
				if (hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 9: //09 ECCC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }

				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(3)), 3); }

				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(7)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 10: //10 REEE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (!hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(13)), 3); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(11)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 11: //11 REER 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitEast || hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(14)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 12: //12 REEC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitEast || hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(10)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(15)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 13: //13 RERE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitEast || hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitNorth || hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(14)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 14://14 RERR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hitEast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (!hitEast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 15: //15 RERC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitNorth || hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(13)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (!hitEast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
		} // switch
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_0_15);

		if (!inWater(state, worldIn, pos)) {
			if (isCooking(worldIn, pos, Direction.DOWN)) {
	
				if (i == 0 || i == 5 || i == 6 || i == 8) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(9))); } //9 ECCC
	
				if (i == 2) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(3))); } //3 ECEC
	
				if (i == 4) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(7))); } //7 ECCE
	
				if (i == 10) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5))); } //5 CEEE
	
				if (i == 11 || i == 12) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7))); } //7 CEEC
	
				if (i == 13) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(11))); } //11 CECE
	
				if (i == 14 || i == 15) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13))); } //13 CECC
	
				else { }
			}
	
			if (!isCooking(worldIn, pos, Direction.DOWN)) { }
		}
		
		if (inWater(state, worldIn, pos)) { 
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			
			if (i == 0 || i == 5 || i == 6 || i == 8 || i == 9 || i == 14 || i == 15) {
				this.dropRottenfood3(worldIn, pos);
				this.dropStick3(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 2 || i == 3 || i == 4 || i == 7 || i == 11 || i == 12 || i == 13) {
				this.dropRottenfood2(worldIn, pos);
				this.dropStick2(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 1 || i == 10) {
				this.dropRottenfood1(worldIn, pos);
				this.dropStick1(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
		}
	}
	
	protected void dropRottenfood1(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD, 1);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropStick1(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.STICK, 1);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropRottenfood2(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD, 2);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropStick2(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.STICK, 2);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropRottenfood3(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD, 3);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropStick3(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.STICK, 3);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
}
