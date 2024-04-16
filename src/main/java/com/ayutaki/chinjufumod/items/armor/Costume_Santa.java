package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Costume_Santa extends Base_WearItem {

	public Costume_Santa(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		if (this == Items_Seasonal.AKASHISANTA_BOOTS || this == Items_Seasonal.SUZUYASANTA_BOOTS || this == Items_Seasonal
				.KUMANOSANTA_BOOTS || this == Items_Seasonal.RYUJOUSANTA_BOOTS || this == Items_Seasonal.TEITOKUSANTA_BOOTS) {
			return material.getItem() == Items.BLACK_CARPET; }

		else { return material.getItem() == Items.RED_CARPET; }
	}
}
