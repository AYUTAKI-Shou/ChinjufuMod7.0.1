package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class Seasonal_noSlab extends BlockNamedItem {

	public Seasonal_noSlab(Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.SEASONAL));
	}
}
