package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class AdmiralStampItem2 extends Base_AdmiralStampItem {

	public AdmiralStampItem2(String name) {
		super(name);
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.ADMIRAL_STAMP_B, 1, 4)); }
		if (i == 2) { stack.add(new ItemStack(Items_Chinjufu.ADMIRAL_STAMP_B, 1, 5)); }
		if (i == 3) { stack.add(new ItemStack(Items_Chinjufu.ADMIRAL_STAMP_B, 1, 6)); }
		if (i == 4) { stack.add(new ItemStack(Items_Chinjufu.ADMIRAL_STAMP_B, 1, 7)); }
		return stack;

	}
}
