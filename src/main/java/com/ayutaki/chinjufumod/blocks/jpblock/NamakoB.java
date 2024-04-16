package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NamakoB extends Base_JpFull {

	public NamakoB(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (item instanceof Base_ItemHake) { return false; }
		
		else {
			if (stack.isEmpty()) {
				if (playerIn.isSneaking()) {
					CMEvents.soundStonePlace(worldIn, pos);

					if (i == 0) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(0))); }
					if (i == 1) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(1))); }
					if (i == 2) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(2))); }
					if (i == 3) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(3))); }
					if (i == 4) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(4))); }
					if (i == 5) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(5))); }
					if (i == 6) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(6))); }
					if (i == 7) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(7))); }
					if (i == 8) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(8))); }
					if (i == 9) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(9))); }
					if (i == 10) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(10))); }
					if (i == 11) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(11))); }
					if (i == 12) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(12))); }
					if (i == 13) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(13))); }
					if (i == 14) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(14))); }
					if (i == 15) { worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_CR.getDefaultState()
							.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(15))); } }
				return true;
			}
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
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}

	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 0) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 0); }
		if (i == 1) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 4); }
		if (i == 5) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 5); }
		if (i == 6) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 6); }
		if (i == 7) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 7); }
		if (i == 8) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 8); }
		if (i == 9) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 9); }
		if (i == 10) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 10); }
		if (i == 11) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 11); }
		if (i == 12) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 12); }
		if (i == 13) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 13); }
		if (i == 14) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 14); }
		if (i == 15) { return new ItemStack(Items_Wablock.NAMAKOB, 1, 15); }
		return null;
	}
}