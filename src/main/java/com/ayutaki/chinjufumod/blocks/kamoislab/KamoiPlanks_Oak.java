package com.ayutaki.chinjufumod.blocks.kamoislab;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_WallPane;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class KamoiPlanks_Oak extends BaseStage4_Face {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger STAGE_1_4 = PropertyInteger.create("stage", 1, 4);

	public KamoiPlanks_Oak(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_4), 2); }
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

		if (this == KamoiPlanks_Blocks.KAMOI_oak_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 0)); }

		if (this == KamoiPlanks_Blocks.KAMOI_spru_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 1)); }

		if (this == KamoiPlanks_Blocks.KAMOI_bir_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 2)); }

		if (this == KamoiPlanks_Blocks.KAMOI_jun_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 3)); }

		if (this == KamoiPlanks_Blocks.KAMOI_aca_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 4)); }

		if (this == KamoiPlanks_Blocks.KAMOI_doak_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 5)); }

		if (this == KamoiPlanks_Blocks.KAMOI_saku_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Items_Seasonal.SAKURA_slabhalf, 1, 0)); }

		if (this == KamoiPlanks_Blocks.KAMOI_kae_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Items_Seasonal.KAEDE_slabhalf, 1, 0)); }

		if (this == KamoiPlanks_Blocks.KAMOI_ich_oak) {
			stack.add(new ItemStack(Items_WallPane.PILLARSLAB, 1, 0));
			stack.add(new ItemStack(Items_Seasonal.ICHOH_slabhalf, 1, 0)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_WallPane.PILLARSLAB, 1, 0);
	}
}
