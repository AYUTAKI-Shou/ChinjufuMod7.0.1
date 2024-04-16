package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.armor.Armor_Akatsuki;
import com.ayutaki.chinjufumod.items.armor.Armor_AkatsukiKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Battleship;
import com.ayutaki.chinjufumod.items.armor.Armor_BattleshipKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Carrier;
import com.ayutaki.chinjufumod.items.armor.Armor_CarrierKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Destroyer;
import com.ayutaki.chinjufumod.items.armor.Armor_DestroyerKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Kasumi;
import com.ayutaki.chinjufumod.items.armor.Armor_KasumiKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Mogami;
import com.ayutaki.chinjufumod.items.armor.Armor_MogamiKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Nagato;
import com.ayutaki.chinjufumod.items.armor.Armor_NagatoKai;
import com.ayutaki.chinjufumod.items.armor.Armor_RJ;
import com.ayutaki.chinjufumod.items.armor.Armor_RJKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Ro500;
import com.ayutaki.chinjufumod.items.armor.Armor_Sendai;
import com.ayutaki.chinjufumod.items.armor.Armor_SendaiKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Tone;
import com.ayutaki.chinjufumod.items.armor.Armor_ToneKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Yura;
import com.ayutaki.chinjufumod.items.armor.Armor_YuraKai;
import com.ayutaki.chinjufumod.items.armor.Armor_Zuihou;
import com.ayutaki.chinjufumod.items.armor.Armor_ZuihouKai;
import com.ayutaki.chinjufumod.items.armor.Armor_i13;
import com.ayutaki.chinjufumod.items.armor.Armor_i168;
import com.ayutaki.chinjufumod.items.armor.CMArmorMaterial;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Armor {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* Destroyer */
	public static Item FUBUKI_HELMET = register("item_fubuki_helmet", new Armor_Destroyer(CMArmorMaterial.FUBUKI, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item FUBUKI_CHESTPLATE = register("item_fubuki_chestplate", new Armor_Destroyer(CMArmorMaterial.FUBUKI, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item FUBUKI_LEGGINGS = register("item_fubuki_leggings", new Armor_Destroyer(CMArmorMaterial.FUBUKI, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item FUBUKI_BOOTS = register("item_fubuki_boots", new Armor_Destroyer(CMArmorMaterial.FUBUKI, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item FUBUKI_BOOTS_KAI = register("item_fubuki_bootskai", new Armor_DestroyerKai(CMArmorMaterial.FUBUKI, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item KASUMI_HELMET = register("item_kasumi_helmet", new Armor_Kasumi(CMArmorMaterial.KASUMI, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item KASUMI_CHESTPLATE = register("item_kasumi_chestplate", new Armor_Kasumi(CMArmorMaterial.KASUMI, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item KASUMI_LEGGINGS = register("item_kasumi_leggings", new Armor_Kasumi(CMArmorMaterial.KASUMI, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item KASUMI_BOOTS = register("item_kasumi_boots", new Armor_Kasumi(CMArmorMaterial.KASUMI, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item KASUMI_BOOTS_KAI = register("item_kasumi_bootskai", new Armor_KasumiKai(CMArmorMaterial.KASUMI, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item SHIRATSUYU_HELMET = register("item_shiratsuyu_helmet", new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item SHIRATSUYU_CHESTPLATE = register("item_shiratsuyu_chestplate", new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item SHIRATSUYU_LEGGINGS = register("item_shiratsuyu_leggings", new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item SHIRATSUYU_BOOTS = register("item_shiratsuyu_boots", new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item SHIRATSUYU_BOOTS_KAI = register("item_shiratsuyu_bootskai", new Armor_DestroyerKai(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item SHIGURE_HELMET = register("item_shigure_helmet", new Armor_Destroyer(CMArmorMaterial.SHIGURE, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item SHIGURE_CHESTPLATE = register("item_shigure_chestplate", new Armor_Destroyer(CMArmorMaterial.SHIGURE, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item SHIGURE_LEGGINGS = register("item_shigure_leggings", new Armor_Destroyer(CMArmorMaterial.SHIGURE, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item SHIGURE_BOOTS = register("item_shigure_boots", new Armor_Destroyer(CMArmorMaterial.SHIGURE, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item SHIGURE_BOOTS_KAI = register("item_shigure_bootskai", new Armor_DestroyerKai(CMArmorMaterial.SHIGURE, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item AKATSUKI_HELMET = register("item_akatsuki_helmet", new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item AKATSUKI_CHESTPLATE = register("item_akatsuki_chestplate", new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item AKATSUKI_LEGGINGS = register("item_akatsuki_leggings", new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item AKATSUKI_BOOTS = register("item_akatsuki_boots", new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item AKATSUKI_BOOTS_KAI = register("item_akatsuki_bootskai", new Armor_AkatsukiKai(CMArmorMaterial.AKATSUKI, EquipmentSlotType.FEET, new Item.Properties()));
	
	/* Cruiser */
	public static Item SENDAI_HELMET = register("item_sendai_helmet", new Armor_Sendai(CMArmorMaterial.SENDAI, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item SENDAI_CHESTPLATE = register("item_sendai_chestplate", new Armor_Sendai(CMArmorMaterial.SENDAI, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item SENDAI_LEGGINGS = register("item_sendai_leggings", new Armor_Sendai(CMArmorMaterial.SENDAI, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item SENDAI_BOOTS = register("item_sendai_boots", new Armor_Sendai(CMArmorMaterial.SENDAI, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item SENDAI_BOOTS_KAI = register("item_sendai_bootskai", new Armor_SendaiKai(CMArmorMaterial.SENDAI, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item YURA_HELMET = register("item_yura_helmet", new Armor_Yura(CMArmorMaterial.YURA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item YURA_CHESTPLATE = register("item_yura_chestplate", new Armor_Yura(CMArmorMaterial.YURA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item YURA_LEGGINGS = register("item_yura_leggings", new Armor_Yura(CMArmorMaterial.YURA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item YURA_BOOTS = register("item_yura_boots", new Armor_Yura(CMArmorMaterial.YURA, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item YURA_BOOTS_KAI = register("item_yura_bootskai", new Armor_YuraKai(CMArmorMaterial.YURA, EquipmentSlotType.FEET, new Item.Properties()));

	/* Heavy Cruiser */
	public static Item MOGAMI_HELMET = register("item_mogami_helmet", new Armor_Mogami(CMArmorMaterial.MOGAMI, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item MOGAMI_CHESTPLATE = register("item_mogami_chestplate", new Armor_Mogami(CMArmorMaterial.MOGAMI, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item MOGAMI_LEGGINGS = register("item_mogami_leggings", new Armor_Mogami(CMArmorMaterial.MOGAMI, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item MOGAMI_BOOTS = register("item_mogami_boots", new Armor_Mogami(CMArmorMaterial.MOGAMI, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item MOGAMI_BOOTS_KAI = register("item_mogami_bootskai", new Armor_MogamiKai(CMArmorMaterial.MOGAMI, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item TONE_HELMET = register("item_tone_helmet", new Armor_Tone(CMArmorMaterial.TONE, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item TONE_CHESTPLATE = register("item_tone_chestplate", new Armor_Tone(CMArmorMaterial.TONE, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item TONE_LEGGINGS = register("item_tone_leggings", new Armor_Tone(CMArmorMaterial.TONE, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item TONE_BOOTS = register("item_tone_boots", new Armor_Tone(CMArmorMaterial.TONE, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item TONE_BOOTS_KAI = register("item_tone_bootskai", new Armor_ToneKai(CMArmorMaterial.TONE, EquipmentSlotType.FEET, new Item.Properties()));

	/* Aircraft carrier */
	public static Item RJ_HELMET = register("item_ryujou_helmet", new Armor_RJ(CMArmorMaterial.RJ, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item RJ_CHESTPLATE = register("item_ryujou_chestplate", new Armor_RJ(CMArmorMaterial.RJ, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item RJ_LEGGINGS = register("item_ryujou_leggings", new Armor_RJ(CMArmorMaterial.RJ, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item RJ_BOOTS = register("item_ryujou_boots", new Armor_RJ(CMArmorMaterial.RJ, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item RJ_BOOTS_KAI = register("item_ryujou_bootskai", new Armor_RJKai(CMArmorMaterial.RJ, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item ZUIHOU_HELMET = register("item_zuihou_helmet", new Armor_Zuihou(CMArmorMaterial.ZUIHOU, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item ZUIHOU_CHESTPLATE = register("item_zuihou_chestplate", new Armor_Zuihou(CMArmorMaterial.ZUIHOU, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item ZUIHOU_LEGGINGS = register("item_zuihou_leggings", new Armor_Zuihou(CMArmorMaterial.ZUIHOU, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item ZUIHOU_BOOTS = register("item_zuihou_boots", new Armor_Zuihou(CMArmorMaterial.ZUIHOU, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item ZUIHOU_BOOTS_KAI = register("item_zuihou_bootskai", new Armor_ZuihouKai(CMArmorMaterial.ZUIHOU, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item AKAGI_HELMET = register("item_akagi_helmet", new Armor_Carrier(CMArmorMaterial.AKAGI, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item AKAGI_CHESTPLATE = register("item_akagi_chestplate", new Armor_Carrier(CMArmorMaterial.AKAGI, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item AKAGI_LEGGINGS = register("item_akagi_leggings", new Armor_Carrier(CMArmorMaterial.AKAGI, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item AKAGI_BOOTS = register("item_akagi_boots", new Armor_Carrier(CMArmorMaterial.AKAGI, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item AKAGI_BOOTS_KAI = register("item_akagi_bootskai", new Armor_CarrierKai(CMArmorMaterial.AKAGI, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item KAGA_HELMET = register("item_kaga_helmet", new Armor_Carrier(CMArmorMaterial.KAGA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item KAGA_CHESTPLATE = register("item_kaga_chestplate", new Armor_Carrier(CMArmorMaterial.KAGA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item KAGA_LEGGINGS = register("item_kaga_leggings", new Armor_Carrier(CMArmorMaterial.KAGA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item KAGA_BOOTS = register("item_kaga_boots", new Armor_Carrier(CMArmorMaterial.KAGA, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item KAGA_BOOTS_KAI = register("item_kaga_bootskai", new Armor_CarrierKai(CMArmorMaterial.KAGA, EquipmentSlotType.FEET, new Item.Properties()));

	/* Battleship */
	public static Item KONGOU_HELMET = register("item_kongou_helmet", new Armor_Battleship(CMArmorMaterial.KONGOU, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item KONGOU_CHESTPLATE = register("item_kongou_chestplate", new Armor_Battleship(CMArmorMaterial.KONGOU, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item KONGOU_LEGGINGS = register("item_kongou_leggings", new Armor_Battleship(CMArmorMaterial.KONGOU, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item KONGOU_BOOTS = register("item_kongou_boots", new Armor_Battleship(CMArmorMaterial.KONGOU, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item KONGOU_BOOTS_KAI = register("item_kongou_bootskai", new Armor_BattleshipKai(CMArmorMaterial.KONGOU, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item FUSOU_HELMET = register("item_fusou_helmet", new Armor_Battleship(CMArmorMaterial.FUSOU, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item FUSOU_CHESTPLATE = register("item_fusou_chestplate", new Armor_Battleship(CMArmorMaterial.FUSOU, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item FUSOU_LEGGINGS = register("item_fusou_leggings", new Armor_Battleship(CMArmorMaterial.FUSOU, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item FUSOU_BOOTS = register("item_fusou_boots", new Armor_Battleship(CMArmorMaterial.FUSOU, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item FUSOU_BOOTS_KAI = register("item_fusou_bootskai", new Armor_BattleshipKai(CMArmorMaterial.FUSOU, EquipmentSlotType.FEET, new Item.Properties()));
	
	public static Item NAGATO_HELMET = register("item_nagato_helmet", new Armor_Nagato(CMArmorMaterial.NAGATO, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item NAGATO_CHESTPLATE = register("item_nagato_chestplate", new Armor_Nagato(CMArmorMaterial.NAGATO, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item NAGATO_LEGGINGS = register("item_nagato_leggings", new Armor_Nagato(CMArmorMaterial.NAGATO, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item NAGATO_BOOTS = register("item_nagato_boots", new Armor_Nagato(CMArmorMaterial.NAGATO, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item NAGATO_BOOTS_KAI = register("item_nagato_bootskai", new Armor_NagatoKai(CMArmorMaterial.NAGATO, EquipmentSlotType.FEET, new Item.Properties()));

	/* Submarine */
	public static Item I168_HELMET = register("item_i168_helmet", new Armor_i168(CMArmorMaterial.I168, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item I168_CHESTPLATE = register("item_i168_chestplate", new Armor_i168(CMArmorMaterial.I168, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item I168_LEGGINGS = register("item_i168_leggings", new Armor_i168(CMArmorMaterial.I168, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item I168_BOOTS = register("item_i168_boots", new Armor_i168(CMArmorMaterial.I168, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item I13_HELMET = register("item_i13_helmet", new Armor_i13(CMArmorMaterial.I13, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item I13_CHESTPLATE = register("item_i13_chestplate", new Armor_i13(CMArmorMaterial.I13, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item I13_LEGGINGS = register("item_i13_leggings", new Armor_i13(CMArmorMaterial.I13, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item I13_BOOTS = register( "item_i13_boots", new Armor_i13(CMArmorMaterial.I13, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item RO500_HELMET = register("item_ro500_helmet", new Armor_Ro500(CMArmorMaterial.RO500, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item RO500_CHESTPLATE = register("item_ro500_chestplate", new Armor_Ro500(CMArmorMaterial.RO500, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item RO500_LEGGINGS = register("item_ro500_leggings", new Armor_Ro500(CMArmorMaterial.RO500, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item RO500_BOOTS = register( "item_ro500_boots", new Armor_Ro500(CMArmorMaterial.RO500, EquipmentSlotType.FEET, new Item.Properties()));

	
	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
