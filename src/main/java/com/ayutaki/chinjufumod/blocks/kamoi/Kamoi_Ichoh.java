package com.ayutaki.chinjufumod.blocks.kamoi;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_noSlab;
import com.ayutaki.chinjufumod.items.fuel.Shikkui_Slab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Kamoi_Ichoh extends Base_Kamoi {

	public Kamoi_Ichoh(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		boolean stone = (item instanceof Shikkui_Slab);
		boolean wood = ((item == Items.OAK_SLAB) || (item == Items.SPRUCE_SLAB) || (item == Items.BIRCH_SLAB) || 
				(item == Items.JUNGLE_SLAB) || (item == Items.ACACIA_SLAB) || (item == Items.DARK_OAK_SLAB) || item instanceof Seasonal_noSlab);
		
		if (!playerIn.isCrouching()) {
			
			if (stone) {
				if (item == Items_Wablock.DIRTWALL_SH) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_dirt_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; }

				if (item == Items_Wablock.SHIKKUI_SH_white) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_white_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //0

				if (item == Items_Wablock.SHIKKUI_SH_orange) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_orange_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //1

				if (item == Items_Wablock.SHIKKUI_SH_magenta) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //2

				if (item == Items_Wablock.SHIKKUI_SH_lightb) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_lightb_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //3

				if (item == Items_Wablock.SHIKKUI_SH_yellow) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_yellow_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //4

				if (item == Items_Wablock.SHIKKUI_SH_lime) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_lime_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //5

				if (item == Items_Wablock.SHIKKUI_SH_pink) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //6

				if (item == Items_Wablock.SHIKKUI_SH_gray) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_gray_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //7

				if (item == Items_Wablock.SHIKKUI_SH_lightg) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_lightg_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //8

				if (item == Items_Wablock.SHIKKUI_SH_cyan) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_cyan_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //9

				if (item == Items_Wablock.SHIKKUI_SH_purple) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_purple_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //10

				if (item == Items_Wablock.SHIKKUI_SH_blue) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_blue_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //11

				if (item == Items_Wablock.SHIKKUI_SH_brown) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_brown_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //12

				if (item == Items_Wablock.SHIKKUI_SH_green) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_green_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //13

				if (item == Items_Wablock.SHIKKUI_SH_red) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_red_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //14

				if (item == Items_Wablock.SHIKKUI_SH_black) {
					CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_black_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //15
			}
			
			
			if (wood) {
				if (item == Items.OAK_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_oak_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //Oak

				if (item == Items.SPRUCE_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_spru_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //Spruce

				if (item == Items.BIRCH_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_bir_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //Birch

				if (item == Items.JUNGLE_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_jun_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //Jungle

				if (item == Items.ACACIA_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_aca_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //Acacia

				if (item == Items.DARK_OAK_SLAB) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_doak_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //DarkOak

				if (item == Items_Seasonal.SAKURA_slabhalf) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_saku_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //SAKURA

				if (item == Items_Seasonal.KAEDE_slabhalf) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_kae_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //KAEDE

				if (item == Items_Seasonal.ICHOH_slabhalf) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);

					worldIn.setBlock(pos, KamoiPlanks_Blocks.KAMOI_ich_ichoh.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(STAGE_1_4, state.getValue(STAGE_1_4)), 3);
					return ActionResultType.SUCCESS; } //ICHOH
			}

			if (stack.isEmpty()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}

		/** Form changes. **/
		if (playerIn.isCrouching() && stack.isEmpty()) {
			CMEvents.soundWoodPlace(worldIn, pos);
			worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.PASS;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.PILLARSLAB_ich);
	}
}
