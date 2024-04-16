package com.ayutaki.chinjufumod.items.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Base_WearItem extends ArmorItem {

	public Base_WearItem(ArmorMaterial material, ArmorItem.Type slot, Item.Properties properties) {
		super(material, slot, properties);
	}

	/** net.minecraftforge.common.extensions.IForgeItem **/
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		ArmorItem armor = (ArmorItem) stack.getItem();
		String name = armor.getMaterial().getName();
		int index = name.indexOf(":");
		
		if (slot == EquipmentSlot.LEGS) {
			return "chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_2.png"; } 
		else {
			return "chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_1.png"; }
	}
}
