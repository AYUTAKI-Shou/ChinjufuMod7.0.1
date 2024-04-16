package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class Wall_noFuel extends ItemNameBlockItem {

	public Wall_noFuel(Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.WALLPANEL));
	}
}
