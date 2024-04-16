package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class Shikkui_Slab extends BlockNamedItem {

	public Shikkui_Slab(Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.WABLOCK));
	}
}
