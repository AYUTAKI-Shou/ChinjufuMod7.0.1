package com.ayutaki.chinjufumod.blocks.kamoi;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_noSlab;
import com.ayutaki.chinjufumod.items.fuel.Shikkui_Slab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Kamoi_DarkOak extends Base_Kamoi {

	public Kamoi_DarkOak(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		boolean stone = (item instanceof Shikkui_Slab);
		boolean wood = ((item == Items.OAK_SLAB) || (item == Items.SPRUCE_SLAB) || (item == Items.BIRCH_SLAB) || 
				(item == Items.JUNGLE_SLAB) || (item == Items.ACACIA_SLAB) || (item == Items.DARK_OAK_SLAB) || item instanceof Seasonal_noSlab);
		
		if (!playerIn.isCrouching()) {
			
			if (stone) {
				if (item == Items_Wablock.DIRTWALL_SH.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_dirt_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; }

				if (item == Items_Wablock.SHIKKUI_SH_white.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_white_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //0

				if (item == Items_Wablock.SHIKKUI_SH_orange.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_orange_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //1

				if (item == Items_Wablock.SHIKKUI_SH_magenta.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //2

				if (item == Items_Wablock.SHIKKUI_SH_lightb.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_lightb_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //3

				if (item == Items_Wablock.SHIKKUI_SH_yellow.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_yellow_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //4

				if (item == Items_Wablock.SHIKKUI_SH_lime.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_lime_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //5

				if (item == Items_Wablock.SHIKKUI_SH_pink.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //6

				if (item == Items_Wablock.SHIKKUI_SH_gray.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_gray_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //7

				if (item == Items_Wablock.SHIKKUI_SH_lightg.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_lightg_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //8

				if (item == Items_Wablock.SHIKKUI_SH_cyan.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_cyan_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //9

				if (item == Items_Wablock.SHIKKUI_SH_purple.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_purple_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //10

				if (item == Items_Wablock.SHIKKUI_SH_blue.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_blue_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //11

				if (item == Items_Wablock.SHIKKUI_SH_brown.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_brown_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //12

				if (item == Items_Wablock.SHIKKUI_SH_green.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_green_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //13

				if (item == Items_Wablock.SHIKKUI_SH_red.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_red_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //14

				if (item == Items_Wablock.SHIKKUI_SH_black.get()) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_black_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //15
			}
			
			
			if (wood) {
				if (item == Items.OAK_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_oak_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //Oak

				if (item == Items.SPRUCE_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_spru_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //Spruce

				if (item == Items.BIRCH_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_bir_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //Birch

				if (item == Items.JUNGLE_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_jun_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //Jungle

				if (item == Items.ACACIA_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_aca_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //Acacia

				if (item == Items.DARK_OAK_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_doak_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //DarkOak

				if (item == Items_Seasonal.SAKURA_slabhalf.get()) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_saku_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //SAKURA

				if (item == Items_Seasonal.KAEDE_slabhalf.get()) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_kae_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //KAEDE

				if (item == Items_Seasonal.ICHOH_slabhalf.get()) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_ich_doak.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return InteractionResult.SUCCESS; } //ICHOH
			}

			if (stack.isEmpty()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return InteractionResult.SUCCESS; }
		}

		/** Form changes. **/
		if (playerIn.isCrouching() && stack.isEmpty()) {
			CMEvents.soundWoodPlace(worldIn, pos);
			worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
			return InteractionResult.SUCCESS;
		}
		
		return InteractionResult.PASS;
	}


	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_WallPanel.PILLARSLAB_doak.get());
	}
}
