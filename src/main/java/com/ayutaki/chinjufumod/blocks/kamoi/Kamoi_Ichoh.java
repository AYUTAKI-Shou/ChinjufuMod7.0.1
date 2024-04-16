package com.ayutaki.chinjufumod.blocks.kamoi;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiShikkui_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kamoi_Ichoh extends Base_Kamoi {

	public Kamoi_Ichoh(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (!playerIn.isSneaking()) {
			if (item == Items_Wablock.DIRTWALL_SH) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_dirt_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; }

			if (item == Items_Wablock.SHIKKUI_SH_white) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_white_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //0

			if (item == Items_Wablock.SHIKKUI_SH_orange) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //1

			if (item == Items_Wablock.SHIKKUI_SH_magenta) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_magenta_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //2

			if (item == Items_Wablock.SHIKKUI_SH_lightb) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_lightb_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //3

			if (item == Items_Wablock.SHIKKUI_SH_yellow) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_yellow_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //4

			if (item == Items_Wablock.SHIKKUI_SH_lime) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_lime_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //5

			if (item == Items_Wablock.SHIKKUI_SH_pink) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_pink_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //6

			if (item == Items_Wablock.SHIKKUI_SH_gray) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_gray_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //7

			if (item == Items_Wablock.SHIKKUI_SH_lightg) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_lightg_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //8

			if (item == Items_Wablock.SHIKKUI_SH_cyan) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_cyan_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //9

			if (item == Items_Wablock.SHIKKUI_SH_purple) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_purple_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //10

			if (item == Items_Wablock.SHIKKUI_SH_blue) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_blue_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //11

			if (item == Items_Wablock.SHIKKUI_SH_brown) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_brown_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //12

			if (item == Items_Wablock.SHIKKUI_SH_green) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_green_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //13

			if (item == Items_Wablock.SHIKKUI_SH_red) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //14

			if (item == Items_Wablock.SHIKKUI_SH_black) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_black_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //15

			/** 木材 **/
			if (item == new ItemStack(Blocks.WOODEN_SLAB).getItem()) {
				int k;
				k = stack.getMetadata();

				if (k == 0) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_oak_ich.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
					return true; } //オーク

				if (k == 1) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_spru_ich.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
					return true; } //マツ

				if (k == 2) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_bir_ich.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
					return true; } //シラカバ

				if (k == 3) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_jun_ich.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
					return true; } //ジャングル

				if (k == 4) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_aca_ich.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
					return true; } //アカシア

				if (k == 5) {
					CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_doak_ich.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
					return true; } //ダークオーク
			}

			if (item == Items_Seasonal.SAKURA_slabhalf) {
				CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_saku_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //サクラ

			if (item == Items_Seasonal.KAEDE_slabhalf) {
				CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_kae_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //カエデ

			if (item == Items_Seasonal.ICHOH_slabhalf) {
				CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, KamoiPlanks_Blocks.KAMOI_ich_ich.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_4, state.getValue(STAGE_1_4)));
				return true; } //イチョウ
		}

		/** 形状変化 **/
		if (playerIn.isSneaking() && stack.isEmpty()) {
			CMEvents.soundWoodPlace(worldIn, pos);
			worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_4), 2);
			return true;
		}
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 2));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 2);
	}
}
