package com.ayutaki.chinjufumod.items.seasonal;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class SeasonalTab_Item extends Item {

	public SeasonalTab_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

}
