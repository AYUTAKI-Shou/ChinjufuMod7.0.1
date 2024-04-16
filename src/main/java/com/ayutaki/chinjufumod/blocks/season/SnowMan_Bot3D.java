package com.ayutaki.chinjufumod.blocks.season;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class SnowMan_Bot3D extends Base_SnowManBot {

	/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
	public SnowMan_Bot3D(String name) {
		super(name);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		
		/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 4)); }
		if (i == 2) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 5)); }
		if (i == 3) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 6)); }
		if (i == 4) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 7)); }
		return stack;
	}

}
