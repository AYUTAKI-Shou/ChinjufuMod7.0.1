package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class Base_WearItem extends ArmorItem {

	public Base_WearItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties.group(ItemGroups_CM.SEASONAL));
	}

	/* net.minecraftforge.common.extensions.IForgeItem */
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		ArmorItem armor = (ArmorItem) stack.getItem();
		String name = armor.getArmorMaterial().getName();
		int index = name.indexOf(":");
		
		if (slot == EquipmentSlotType.LEGS) {
			return "chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_2.png"; } 
		else {
			return "chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_1.png"; }
	}
}
