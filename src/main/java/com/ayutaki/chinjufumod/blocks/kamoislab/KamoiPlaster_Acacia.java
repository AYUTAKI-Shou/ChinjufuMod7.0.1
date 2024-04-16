package com.ayutaki.chinjufumod.blocks.kamoislab;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_WallPane;
import com.ayutaki.chinjufumod.registry.KamoiShikkui_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class KamoiPlaster_Acacia extends BaseStage4_Face {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger STAGE_1_4 = PropertyInteger.create("stage", 1, 4);

	public KamoiPlaster_Acacia(String name) {
		super(name);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(10.0F);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_4), 2); }
			return true;
		}
		return false;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == KamoiShikkui_Blocks.KAMOI_white_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_white, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_orange_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_orange, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_magenta_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_magenta, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_lightb_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lightb, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_yellow_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_yellow, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_lime_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lime, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_pink_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_pink, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_gray_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_gray, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_lightg_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lightg, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_cyan_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_cyan, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_purple_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_purple, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_blue_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_blue, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_brown_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_brown, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_green_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_green, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_red_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_red, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_black_a) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_black, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_WallPane.PILLARSLAB, 1, 4);
	}
}
