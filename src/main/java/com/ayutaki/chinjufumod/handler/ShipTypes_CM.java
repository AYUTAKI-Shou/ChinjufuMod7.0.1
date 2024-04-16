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
		return (playerIn.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Base_DestroyerItem &&
						playerIn.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Base_DestroyerItem); }
	
	public static boolean typeCruiser(PlayerEntity playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Base_CruiserItem &&
						playerIn.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Base_CruiserItem); }
	
	public static boolean typeCarrier(PlayerEntity playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Base_CarrierItem &&
						playerIn.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Base_CarrierItem); }
	
	public static boolean typeBattleship(PlayerEntity playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Base_BattleshipItem &&
						playerIn.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Base_BattleshipItem); }
	
	public static boolean typeSubmarine(PlayerEntity playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Base_Submarine && 
						playerIn.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Base_Submarine && 
						playerIn.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Base_Submarine &&
						playerIn.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Base_Submarine); }
}
