package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Irori_Sakana_E1 extends BaseIrori_Sakana {

	public Irori_Sakana_E1(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_15);
		boolean waterlogged = state.getValue(WATERLOGGED);

		boolean hitNorth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() < 0.3D);
		boolean hitSouth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.7D);
		boolean hitEast = (hit.getLocation().x - (double)pos.getX() > 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);
		boolean hitWest = (hit.getLocation().x - (double)pos.getX() < 0.3D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);

		switch (i) {
		case 0 : //00 EEER 北東南西
		default:
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (!hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(9)), 3); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(3)), 3); }
					
					if (hitWest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 1: //01 EEEC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (!hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(12)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(10)), 3); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hitWest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 2: //02 EERE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (!hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(3)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 3: //03 EERR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth || hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth || hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } } 
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(12)), 3); }
					
					if (hitSouth || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 4: //04 EERC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth || hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(2)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(13)), 3); }
					
					if (hitSouth || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 5: //05 EECE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (!hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(14)), 3); }
					
					if (hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }

					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(6)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 6: //06 EECR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth || hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(15)), 3); }
					
					if (hitSouth || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 7: //07 EECC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth || hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(1)), 3); }

				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(5)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }
					
					if (hitEast) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
								.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
					
					if (hitSouth || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 8: //08 EREE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (!hitEast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } } 
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
					
					if (hitEast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(9)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 9: //09 ERER 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth || hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast || hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hitEast || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(12)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 10: //10 EREC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth || hitSouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(8)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); }
					
					if (hitEast || hitWest) { CMEvents.soundTouchBlock(worldIn, pos); }

					if (hitSouth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(13)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 11: //11 ERRE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitEast || hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitNorth || hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); }
					
					if (hitEast || hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(12)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 12: //12 ERRR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (!hitNorth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 13: //13 ERRC 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitEast || hitSouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitWest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(11)), 3); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 14: //14 ERCE 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitEast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(8)), 3); }
				
				if (hitNorth || hitWest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9)), 3); }
					
					if (hitEast || hitSouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitWest) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(15)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 15: //15 ERCR 北東南西
			/** Take it. **/
			if (stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) {
				if (hitNorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitSouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(9)), 3); }
				
				if (hitEast || hitWest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!stack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA.get()) {
				
				if (!waterlogged) {
					if (hitNorth) {
						CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10)), 3); }
					
					if (!hitNorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!stack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
		} // switch
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_0_15);

		if (!inWater(state, worldIn, pos)) {
			if (isCooking(worldIn, pos, Direction.DOWN)) {
	
				if (i == 0) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(1)), 3); }//1 EEEC
	
				if (i == 2) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(5)), 3); }//5 EECE
	
				if (i == 3 || i == 4 || i == 6) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(7)), 3); }//7 EECC
	
				if (i == 8) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }//1 ECEE
	
				if (i == 9 || i == 10) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }//3 ECEC
	
				if (i == 11 || i == 14) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }//7 ECCE
	
				if (i == 12 || i == 13 || i == 15) {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9)), 3); }//9 ECCC
	
				else { }
			}
	
			if (!isCooking(worldIn, pos, Direction.DOWN)) { }
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			
			if (i == 12 || i == 13 ||i == 15) {
				this.dropRottenfood3(worldIn, pos);
				this.dropStick3(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 3 || i == 4 || i == 6 || i == 7 || i == 9 || i == 10 || i == 11 || i == 14) {
				this.dropRottenfood2(worldIn, pos);
				this.dropStick2(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 0 || i == 1 || i == 2 || i == 5 || i == 8) {
				this.dropRottenfood1(worldIn, pos);
				this.dropStick1(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
		}
	}
	
	protected void dropRottenfood1(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get(), 1);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropStick1(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.STICK, 1);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropRottenfood2(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get(), 2);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropStick2(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.STICK, 2);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropRottenfood3(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get(), 3);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropStick3(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.STICK, 3);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
}
