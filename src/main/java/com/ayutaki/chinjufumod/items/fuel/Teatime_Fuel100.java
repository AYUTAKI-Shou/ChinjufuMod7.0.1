package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Teatime_Fuel100 extends BlockNamedItem {

	public Teatime_Fuel100(Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.TEATIME));
	}

	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack stack) {
		return 100;
	}

}
