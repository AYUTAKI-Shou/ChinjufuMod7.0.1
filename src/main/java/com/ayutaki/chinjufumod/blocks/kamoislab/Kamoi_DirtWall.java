package com.ayutaki.chinjufumod.blocks.kamoislab;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
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

public class Kamoi_DirtWall extends BaseStage4_Face {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger STAGE_1_4 = PropertyInteger.create("stage", 1, 4);

	public Kamoi_DirtWall(String name) {
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

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_spru) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 1));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_bir) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 2));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_jun) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 3));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_aca) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 4));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_doak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 5));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_saku) {
			stack.add(new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 0));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_kae) {
			stack.add(new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 1));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_ich) {
			stack.add(new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 2));
			stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_spru) {
			return new ItemStack(Items_WallPane.PILLARSLAB, 1, 1); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_bir) {
			return new ItemStack(Items_WallPane.PILLARSLAB, 1, 2); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_jun) {
			return new ItemStack(Items_WallPane.PILLARSLAB, 1, 3); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_aca) {
			return new ItemStack(Items_WallPane.PILLARSLAB, 1, 4); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_doak) {
			return new ItemStack(Items_WallPane.PILLARSLAB, 1, 5); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_saku) {
			return new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 0); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_kae) {
			return new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 1); }

		if (this == KamoiShikkui_Blocks.KAMOI_dirt_ich) {
			return new ItemStack(Items_Seasonal.PILLARSLAB_s, 1, 2); }

		return new ItemStack(Items_WallPane.PILLARSLAB, 1, 0);
	}
}
