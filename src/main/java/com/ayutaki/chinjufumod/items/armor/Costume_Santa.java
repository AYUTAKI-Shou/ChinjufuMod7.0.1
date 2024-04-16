package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Costume_Santa extends Base_WearItem {

	public Costume_Santa(ArmorMaterial material, ArmorItem.Type slot, Item.Properties properties) {
		super(material, slot, properties);
	}

	/* Item repair material. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		if (this == Items_Seasonal.AKASHISANTA_BOOTS.get() || this == Items_Seasonal.SUZUYASANTA_BOOTS.get() || this == Items_Seasonal
				.KUMANOSANTA_BOOTS.get() || this == Items_Seasonal.RYUJOUSANTA_BOOTS.get() || this == Items_Seasonal.TEITOKUSANTA_BOOTS.get()) {
			return material.getItem() == Items.BLACK_CARPET; }

		else { return material.getItem() == Items.RED_CARPET; }
	}
}
