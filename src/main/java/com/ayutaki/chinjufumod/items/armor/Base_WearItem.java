package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class Base_WearItem extends ItemArmor {

	public Base_WearItem(ArmorMaterial a_material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(a_material, renderIndexIn, equipmentSlotIn);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

	/* net.minecraft.item.Item.getArmorTexture */
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		ItemArmor armor = (ItemArmor) stack.getItem();
		String name = armor.getArmorMaterial().getName();
		int index = name.indexOf(":");
		
		if (slot == EntityEquipmentSlot.LEGS) {
			return "chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_2.png"; } 
		else {
			return "chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_1.png"; }
	}
}
