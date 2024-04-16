package com.ayutaki.chinjufumod.blocks.season;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class SnowMan_Bot1D extends Base_SnowManBot {

	/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
	public SnowMan_Bot1D(String name) {
		super(name);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		
		/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 1) { stack.add(new ItemStack(Items_Seasonal.SNOWMAN)); }
		if (i == 2) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT)); }
		if (i == 3) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Items_Teatime.FOOD_TOMATO)); }
		if (i == 4) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Items.BUCKET)); }
		return stack;
	}

}
