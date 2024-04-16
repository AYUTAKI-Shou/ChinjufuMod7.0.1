package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wadeco_Fuel300 extends BlockNamedItem {

	public Wadeco_Fuel300(Block block, Item.Properties properties) {
		super(block, properties.group(ItemGroups_CM.WADECO));
	}

	/* Used in Furnace. */
	@Override
	public int getBurnTime(ItemStack stack) {
		return 300;
	}

}
