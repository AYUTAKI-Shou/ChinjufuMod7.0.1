package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.items.armor.Base_BattleshipItem;
import com.ayutaki.chinjufumod.items.armor.Base_CarrierItem;
import com.ayutaki.chinjufumod.items.armor.Base_CruiserItem;
import com.ayutaki.chinjufumod.items.armor.Base_DestroyerItem;
import com.ayutaki.chinjufumod.items.armor.Base_Submarine;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class ShipTypes_CM {

	public static boolean typeDestroyer(PlayerEntity playerIn) {
		return (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof Base_DestroyerItem &&
						playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof Base_DestroyerItem); }
	
	public static boolean typeCruiser(PlayerEntity playerIn) {
		return (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof Base_CruiserItem &&
						playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof Base_CruiserItem); }
	
	public static boolean typeCarrier(PlayerEntity playerIn) {
		return (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof Base_CarrierItem &&
						playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof Base_CarrierItem); }
	
	public static boolean typeBattleship(PlayerEntity playerIn) {
		return (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof Base_BattleshipItem &&
						playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof Base_BattleshipItem); }

	public static boolean typeSubmarine(PlayerEntity playerIn) {
		return (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof Base_Submarine && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof Base_Submarine && 
						playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof Base_Submarine &&
						playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof Base_Submarine); }
}
