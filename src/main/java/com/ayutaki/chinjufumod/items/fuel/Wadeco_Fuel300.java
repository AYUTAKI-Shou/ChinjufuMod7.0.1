package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wadeco_Fuel300 extends BlockNamedItem {

	public Wadeco_Fuel300(Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.WADECO));
	}

	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack stack) {
		return 300;
	}

}
