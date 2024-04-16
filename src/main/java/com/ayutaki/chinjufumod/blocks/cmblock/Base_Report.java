package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Base_Report extends BaseStage4_Face {
	
	/* 1=E, 2=B, 3=R, 4=P | 5=N, 6=-1, 7=N, 8=-2 | 9=N, 10=-3, 11=N, 12=-4 | 13=N, 14=-5, 15=N | */
	public Base_Report(String name) {
		super(name);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
		
		setTickRandomly(true);
	}

	protected void dropOrder(IBlockState state, World worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_Chinjufu.WORK_ORDER, 5, 0);
		
		EnumFacing direction = state.getValue(H_FACING);
		double sn = (direction == EnumFacing.SOUTH)? 1.1D : ((direction == EnumFacing.NORTH)? - 1.1D : 0.0D); 
		double ew = (direction == EnumFacing.EAST)? 1.1D : ((direction == EnumFacing.WEST)? - 1.1D : 0.0D);
		
		InventoryHelper.spawnItemStack(worldIn, pos.getX() + ew, pos.getY() + 0.5D, pos.getZ() + sn, stack);
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn,
			BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0);
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
}
