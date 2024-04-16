package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wadeco_Fuel200 extends BlockNamedItem {

	public Wadeco_Fuel200(Block block, Item.Properties properties) {
		super(block, properties.group(ItemGroups_CM.WADECO));
	}

	/* Used in Furnace. */
	@Override
	public int getBurnTime(ItemStack stack) {
		return 200;
	}

}
