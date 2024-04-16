package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.items.armor.Base_Submarine;
import com.ayutaki.chinjufumod.items.armor.Base_BattleshipItem;
import com.ayutaki.chinjufumod.items.armor.Base_CarrierItem;
import com.ayutaki.chinjufumod.items.armor.Base_CruiserItem;
import com.ayutaki.chinjufumod.items.armor.Base_DestroyerItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ShipTypes_CM {

	public static boolean typeDestroyer(EntityPlayer playerIn) {
		return (playerIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof Base_DestroyerItem &&
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof Base_DestroyerItem); }
	
	public static boolean typeCruiser(EntityPlayer playerIn) {
		return (playerIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof Base_CruiserItem &&
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof Base_CruiserItem); }
	
	public static boolean typeCarrier(EntityPlayer playerIn) {
		return (playerIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof Base_CarrierItem &&
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof Base_CarrierItem); }
	
	public static boolean typeBattleship(EntityPlayer playerIn) {
		return (playerIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof Base_BattleshipItem &&
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof Base_BattleshipItem); }
	
	public static boolean typeSubmarine(EntityPlayer playerIn) {
		return (playerIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof Base_Submarine && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof Base_Submarine && 
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof Base_Submarine &&
						playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof Base_Submarine); }
}
