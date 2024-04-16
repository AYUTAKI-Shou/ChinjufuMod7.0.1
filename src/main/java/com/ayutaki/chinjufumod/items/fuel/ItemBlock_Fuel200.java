package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemBlock_Fuel200 extends ItemBlock {

	public ItemBlock_Fuel200(String name, Block putBlock) {
		super(putBlock);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 200;
	}
}
