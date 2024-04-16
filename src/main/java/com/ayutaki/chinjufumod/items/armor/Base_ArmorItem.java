package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.ConfigClient_CM;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Base_ArmorItem extends ArmorItem {

	public Base_ArmorItem(ArmorMaterial material, ArmorItem.Type slot, Item.Properties properties) {
		super(material, slot, properties);
	}

	/** net.minecraftforge.common.extensions.IForgeItem **/
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		ArmorItem armor = (ArmorItem) stack.getItem();
		String name = armor.getMaterial().getName();
		int index = name.indexOf(":");
		
		String layer1 = ("chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_1.png");
		String layer2 = ("chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_2.png");
		String layerA = ("chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_a.png");
		String layerB = ("chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_b.png");
		String layerC = ("chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_c.png");
		String layerD = ("chinjufumod:textures/models/armor/" + name.substring(index + 1) + "_layer_d.png");
		
		int HELM = ConfigClient_CM.INSTANCE.helmetTexture.get();
		int CHEST = ConfigClient_CM.INSTANCE.chestplateTexture.get();
		int BOOTS = ConfigClient_CM.INSTANCE.bootsTexture.get();
		int LEG = ConfigClient_CM.INSTANCE.leggingsTexture.get();
		
		if (slot == EquipmentSlot.HEAD) { return (HELM == 1)? layerA : ((HELM == 2)? layerC : layer1); }
		if (slot == EquipmentSlot.CHEST) { return (CHEST == 1)? layerA : ((CHEST == 2)? layerC : layer1); }
		if (slot == EquipmentSlot.FEET) { return (BOOTS == 1)? layerA : ((BOOTS == 2)? layerC : layer1); }
		if (slot == EquipmentSlot.LEGS) { return (LEG == 1)? layerB : ((LEG == 2)? layerD : layer2); }
		else { return (CHEST == 1)? layerA : ((CHEST == 2)? layerC : layer1); }
	}
}
