package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.items.armor.Base_BattleshipItem;
import com.ayutaki.chinjufumod.items.armor.Base_CarrierItem;
import com.ayutaki.chinjufumod.items.armor.Base_CruiserItem;
import com.ayutaki.chinjufumod.items.armor.Base_DestroyerItem;
import com.ayutaki.chinjufumod.items.armor.Base_Submarine;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

public class ShipTypes_CM {

	public static boolean typeDestroyer(Player playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof Base_DestroyerItem && 
						playerIn.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof Base_DestroyerItem &&
						playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof Base_DestroyerItem); }
	
	public static boolean typeCruiser(Player playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof Base_CruiserItem && 
						playerIn.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof Base_CruiserItem &&
						playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof Base_CruiserItem); }
	
	public static boolean typeCarrier(Player playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof Base_CarrierItem && 
						playerIn.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof Base_CarrierItem &&
						playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof Base_CarrierItem); }
	
	public static boolean typeBattleship(Player playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof Base_BattleshipItem && 
						playerIn.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof Base_BattleshipItem &&
						playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof Base_BattleshipItem); }

	public static boolean typeSubmarine(Player playerIn) {
		return (playerIn.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof Base_Submarine && 
						playerIn.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof Base_Submarine && 
						playerIn.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof Base_Submarine &&
						playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof Base_Submarine); }
}
