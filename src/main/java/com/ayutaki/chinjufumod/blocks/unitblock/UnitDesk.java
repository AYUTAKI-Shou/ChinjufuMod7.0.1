package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class UnitDesk extends BaseUnitDesk {

	/** 0=オーク, 1=マツ, 2=シラカバ, 3=ジャングル, 4=アカシア, 5=ダークオーク, 
	 ** 6=サクラ, 7=カエデ, 8=イチョウ **/
	public UnitDesk(String name) {
		super(name);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_0_8)).intValue();

		if (stack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundWoodPlace(worldIn, pos);
	
				if (i == 0) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(0))); }
				if (i == 1) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(1))); }
				if (i == 2) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(2))); }
				if (i == 3) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(3))); }
				if (i == 4) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(4))); }
				if (i == 5) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(5))); }
				if (i == 6) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(6))); }
				if (i == 7) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(7))); }
				if (i == 8) { worldIn.setBlockState(pos, Unit_Blocks.UNITDESK_sub.getDefaultState()
						.withProperty(UnitDesk_sub.STAGE_0_8, Integer.valueOf(8))); } }
			
			if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
			
			return true;
		}
		return false;
	}

	/* Connect the blocks. */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		boolean back = worldIn.getBlockState(pos.south()).getBlock() == this;
		boolean forward = worldIn.getBlockState(pos.north()).getBlock() == this;
		boolean left = worldIn.getBlockState(pos.west()).getBlock() == this;
		boolean right = worldIn.getBlockState(pos.east()).getBlock() == this;
		return state.withProperty(BACK, back)
				.withProperty(FORWARD, forward)
				.withProperty(LEFT, left)
				.withProperty(RIGHT, right);
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_8)).intValue();

		if (i == 0) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 0); }
		if (i == 1) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 4); }
		if (i == 5) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 5); }
		if (i == 6) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 6); }
		if (i == 7) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 7); }
		if (i == 8) { return new ItemStack(Items_Chinjufu.UNITDESK_item, 1, 8); }
		return null;
	}
}
