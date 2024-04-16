package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
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

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Armor {

	public static Item FUBUKI_HELMET, FUBUKI_CHESTPLATE, FUBUKI_LEGGINGS, FUBUKI_BOOTS, FUBUKI_BOOTS_KAI;
	public static Item KASUMI_HELMET, KASUMI_CHESTPLATE, KASUMI_LEGGINGS, KASUMI_BOOTS, KASUMI_BOOTS_KAI;
	public static Item SHIRATSUYU_HELMET, SHIRATSUYU_CHESTPLATE, SHIRATSUYU_LEGGINGS, SHIRATSUYU_BOOTS, SHIRATSUYU_BOOTS_KAI;
	public static Item SHIGURE_HELMET, SHIGURE_CHESTPLATE, SHIGURE_LEGGINGS, SHIGURE_BOOTS, SHIGURE_BOOTS_KAI;
	public static Item AKATSUKI_HELMET, AKATSUKI_CHESTPLATE, AKATSUKI_LEGGINGS, AKATSUKI_BOOTS, AKATSUKI_BOOTS_KAI;
	
	public static Item SENDAI_HELMET, SENDAI_CHESTPLATE, SENDAI_LEGGINGS, SENDAI_BOOTS, SENDAI_BOOTS_KAI;
	public static Item YURA_HELMET, YURA_CHESTPLATE, YURA_LEGGINGS, YURA_BOOTS, YURA_BOOTS_KAI;
	public static Item MOGAMI_HELMET, MOGAMI_CHESTPLATE, MOGAMI_LEGGINGS, MOGAMI_BOOTS, MOGAMI_BOOTS_KAI;
	public static Item TONE_HELMET, TONE_CHESTPLATE, TONE_LEGGINGS, TONE_BOOTS, TONE_BOOTS_KAI;

	public static Item RJ_HELMET, RJ_CHESTPLATE, RJ_LEGGINGS, RJ_BOOTS, RJ_BOOTS_KAI;
	public static Item ZUIHOU_HELMET, ZUIHOU_CHESTPLATE, ZUIHOU_LEGGINGS, ZUIHOU_BOOTS, ZUIHOU_BOOTS_KAI;

	public static Item AKAGI_HELMET, AKAGI_CHESTPLATE, AKAGI_LEGGINGS, AKAGI_BOOTS, AKAGI_BOOTS_KAI;
	public static Item KAGA_HELMET, KAGA_CHESTPLATE, KAGA_LEGGINGS, KAGA_BOOTS, KAGA_BOOTS_KAI;

	public static Item KONGOU_HELMET, KONGOU_CHESTPLATE, KONGOU_LEGGINGS, KONGOU_BOOTS, KONGOU_BOOTS_KAI;
	public static Item FUSOU_HELMET, FUSOU_CHESTPLATE, FUSOU_LEGGINGS, FUSOU_BOOTS, FUSOU_BOOTS_KAI;
	public static Item NAGATO_HELMET, NAGATO_CHESTPLATE, NAGATO_LEGGINGS, NAGATO_BOOTS, NAGATO_BOOTS_KAI;
	
	public static Item I168_HELMET, I168_CHESTPLATE, I168_LEGGINGS, I168_BOOTS;
	public static Item I13_HELMET, I13_CHESTPLATE, I13_LEGGINGS, I13_BOOTS;
	public static Item RO500_HELMET, RO500_CHESTPLATE, RO500_LEGGINGS, RO500_BOOTS;
	
	public static void init() {
		/* Destroyer */
		FUBUKI_HELMET = new Armor_Destroyer("item_fubuki_helmet", CMArmorMaterial.FUBUKI, 1, EntityEquipmentSlot.HEAD);
		FUBUKI_CHESTPLATE = new Armor_Destroyer("item_fubuki_chestplate", CMArmorMaterial.FUBUKI, 1,EntityEquipmentSlot.CHEST);
		FUBUKI_LEGGINGS = new Armor_Destroyer("item_fubuki_leggings", CMArmorMaterial.FUBUKI, 2, EntityEquipmentSlot.LEGS);
		FUBUKI_BOOTS = new Armor_Destroyer("item_fubuki_boots", CMArmorMaterial.FUBUKI, 1,EntityEquipmentSlot.FEET);
		FUBUKI_BOOTS_KAI = new Armor_DestroyerKai("item_fubuki_bootskai", CMArmorMaterial.FUBUKI, 1,EntityEquipmentSlot.FEET);

		KASUMI_HELMET = new Armor_Kasumi("item_kasumi_helmet", CMArmorMaterial.KASUMI, 1, EntityEquipmentSlot.HEAD);
		KASUMI_CHESTPLATE = new Armor_Kasumi("item_kasumi_chestplate", CMArmorMaterial.KASUMI, 1,EntityEquipmentSlot.CHEST);
		KASUMI_LEGGINGS = new Armor_Kasumi("item_kasumi_leggings", CMArmorMaterial.KASUMI, 2, EntityEquipmentSlot.LEGS);
		KASUMI_BOOTS = new Armor_Kasumi("item_kasumi_boots", CMArmorMaterial.KASUMI, 1,EntityEquipmentSlot.FEET);
		KASUMI_BOOTS_KAI = new Armor_KasumiKai("item_kasumi_bootskai", CMArmorMaterial.KASUMI, 1,EntityEquipmentSlot.FEET);

		SHIRATSUYU_HELMET = new Armor_Destroyer("item_shiratsuyu_helmet", CMArmorMaterial.SHIRATSUYU, 1, EntityEquipmentSlot.HEAD);
		SHIRATSUYU_CHESTPLATE = new Armor_Destroyer("item_shiratsuyu_chestplate", CMArmorMaterial.SHIRATSUYU, 1, EntityEquipmentSlot.CHEST);
		SHIRATSUYU_LEGGINGS = new Armor_Destroyer("item_shiratsuyu_leggings", CMArmorMaterial.SHIRATSUYU, 2, EntityEquipmentSlot.LEGS);
		SHIRATSUYU_BOOTS = new Armor_Destroyer("item_shiratsuyu_boots", CMArmorMaterial.SHIRATSUYU, 1, EntityEquipmentSlot.FEET);
		SHIRATSUYU_BOOTS_KAI = new Armor_DestroyerKai("item_shiratsuyu_bootskai", CMArmorMaterial.SHIRATSUYU, 1, EntityEquipmentSlot.FEET);

		SHIGURE_HELMET = new Armor_Destroyer("item_shigure_helmet", CMArmorMaterial.SHIGURE, 1, EntityEquipmentSlot.HEAD);
		SHIGURE_CHESTPLATE = new Armor_Destroyer("item_shigure_chestplate", CMArmorMaterial.SHIGURE, 1, EntityEquipmentSlot.CHEST);
		SHIGURE_LEGGINGS = new Armor_Destroyer("item_shigure_leggings", CMArmorMaterial.SHIGURE, 2, EntityEquipmentSlot.LEGS);
		SHIGURE_BOOTS = new Armor_Destroyer("item_shigure_boots", CMArmorMaterial.SHIGURE, 1, EntityEquipmentSlot.FEET);
		SHIGURE_BOOTS_KAI = new Armor_DestroyerKai("item_shigure_bootskai", CMArmorMaterial.SHIGURE, 1, EntityEquipmentSlot.FEET);

		AKATSUKI_HELMET = new Armor_Akatsuki("item_akatsuki_helmet", CMArmorMaterial.AKATSUKI, 1, EntityEquipmentSlot.HEAD);
		AKATSUKI_CHESTPLATE = new Armor_Akatsuki("item_akatsuki_chestplate", CMArmorMaterial.AKATSUKI, 1, EntityEquipmentSlot.CHEST);
		AKATSUKI_LEGGINGS = new Armor_Akatsuki("item_akatsuki_leggings", CMArmorMaterial.AKATSUKI, 2, EntityEquipmentSlot.LEGS);
		AKATSUKI_BOOTS = new Armor_Akatsuki("item_akatsuki_boots", CMArmorMaterial.AKATSUKI, 1, EntityEquipmentSlot.FEET);
		AKATSUKI_BOOTS_KAI = new Armor_AkatsukiKai("item_akatsuki_bootskai", CMArmorMaterial.AKATSUKI, 1, EntityEquipmentSlot.FEET);

		/* Cruiser */
		SENDAI_HELMET = new Armor_Sendai("item_sendai_helmet", CMArmorMaterial.SENDAI, 1, EntityEquipmentSlot.HEAD);
		SENDAI_CHESTPLATE = new Armor_Sendai("item_sendai_chestplate", CMArmorMaterial.SENDAI, 1, EntityEquipmentSlot.CHEST);
		SENDAI_LEGGINGS = new Armor_Sendai("item_sendai_leggings", CMArmorMaterial.SENDAI, 2, EntityEquipmentSlot.LEGS);
		SENDAI_BOOTS = new Armor_Sendai("item_sendai_boots", CMArmorMaterial.SENDAI, 1, EntityEquipmentSlot.FEET);
		SENDAI_BOOTS_KAI = new Armor_SendaiKai("item_sendai_bootskai", CMArmorMaterial.SENDAI, 1, EntityEquipmentSlot.FEET);

		YURA_HELMET = new Armor_Yura("item_yura_helmet", CMArmorMaterial.YURA, 1, EntityEquipmentSlot.HEAD);
		YURA_CHESTPLATE = new Armor_Yura("item_yura_chestplate", CMArmorMaterial.YURA, 1, EntityEquipmentSlot.CHEST);
		YURA_LEGGINGS = new Armor_Yura("item_yura_leggings", CMArmorMaterial.YURA, 2, EntityEquipmentSlot.LEGS);
		YURA_BOOTS = new Armor_Yura("item_yura_boots", CMArmorMaterial.YURA, 1, EntityEquipmentSlot.FEET);
		YURA_BOOTS_KAI = new Armor_YuraKai("item_yura_bootskai", CMArmorMaterial.YURA, 1, EntityEquipmentSlot.FEET);

		/* Heavy Cruiser */
		MOGAMI_HELMET = new Armor_Mogami("item_mogami_helmet", CMArmorMaterial.MOGAMI, 1, EntityEquipmentSlot.HEAD);
		MOGAMI_CHESTPLATE = new Armor_Mogami("item_mogami_chestplate", CMArmorMaterial.MOGAMI, 1, EntityEquipmentSlot.CHEST);
		MOGAMI_LEGGINGS = new Armor_Mogami("item_mogami_leggings", CMArmorMaterial.MOGAMI, 2, EntityEquipmentSlot.LEGS);
		MOGAMI_BOOTS = new Armor_Mogami("item_mogami_boots", CMArmorMaterial.MOGAMI, 1, EntityEquipmentSlot.FEET);
		MOGAMI_BOOTS_KAI = new Armor_MogamiKai("item_mogami_bootskai", CMArmorMaterial.MOGAMI, 1, EntityEquipmentSlot.FEET);

		TONE_HELMET = new Armor_Tone("item_tone_helmet", CMArmorMaterial.TONE, 1, EntityEquipmentSlot.HEAD);
		TONE_CHESTPLATE = new Armor_Tone("item_tone_chestplate", CMArmorMaterial.TONE, 1, EntityEquipmentSlot.CHEST);
		TONE_LEGGINGS = new Armor_Tone("item_tone_leggings", CMArmorMaterial.TONE, 2, EntityEquipmentSlot.LEGS);
		TONE_BOOTS = new Armor_Tone("item_tone_boots", CMArmorMaterial.TONE, 1, EntityEquipmentSlot.FEET);
		TONE_BOOTS_KAI = new Armor_ToneKai("item_tone_bootskai", CMArmorMaterial.TONE, 1, EntityEquipmentSlot.FEET);

		/* Aircraft carrier */
		RJ_HELMET = new Armor_RJ("item_ryujou_helmet", CMArmorMaterial.RJ, 1, EntityEquipmentSlot.HEAD);
		RJ_CHESTPLATE = new Armor_RJ("item_ryujou_chestplate", CMArmorMaterial.RJ, 1, EntityEquipmentSlot.CHEST);
		RJ_LEGGINGS = new Armor_RJ("item_ryujou_leggings", CMArmorMaterial.RJ, 2, EntityEquipmentSlot.LEGS);
		RJ_BOOTS = new Armor_RJ("item_ryujou_boots", CMArmorMaterial.RJ, 1, EntityEquipmentSlot.FEET);
		RJ_BOOTS_KAI = new Armor_RJKai("item_ryujou_bootskai", CMArmorMaterial.RJ, 1, EntityEquipmentSlot.FEET);

		ZUIHOU_HELMET = new Armor_Zuihou("item_zuihou_helmet", CMArmorMaterial.ZUIHOU, 1, EntityEquipmentSlot.HEAD);
		ZUIHOU_CHESTPLATE = new Armor_Zuihou("item_zuihou_chestplate", CMArmorMaterial.ZUIHOU, 1, EntityEquipmentSlot.CHEST);
		ZUIHOU_LEGGINGS = new Armor_Zuihou("item_zuihou_leggings", CMArmorMaterial.ZUIHOU, 2, EntityEquipmentSlot.LEGS);
		ZUIHOU_BOOTS = new Armor_Zuihou("item_zuihou_boots", CMArmorMaterial.ZUIHOU, 1, EntityEquipmentSlot.FEET);
		ZUIHOU_BOOTS_KAI = new Armor_ZuihouKai("item_zuihou_bootskai", CMArmorMaterial.ZUIHOU, 1, EntityEquipmentSlot.FEET);

		AKAGI_HELMET = new Armor_Carrier("item_akagi_helmet", CMArmorMaterial.AKAGI, 1, EntityEquipmentSlot.HEAD);
		AKAGI_CHESTPLATE = new Armor_Carrier("item_akagi_chestplate", CMArmorMaterial.AKAGI, 1,EntityEquipmentSlot.CHEST);
		AKAGI_LEGGINGS = new Armor_Carrier("item_akagi_leggings", CMArmorMaterial.AKAGI, 2, EntityEquipmentSlot.LEGS);
		AKAGI_BOOTS = new Armor_Carrier("item_akagi_boots", CMArmorMaterial.AKAGI, 1, EntityEquipmentSlot.FEET);
		AKAGI_BOOTS_KAI = new Armor_CarrierKai("item_akagi_bootskai", CMArmorMaterial.AKAGI, 1, EntityEquipmentSlot.FEET);

		KAGA_HELMET = new Armor_Carrier("item_kaga_helmet", CMArmorMaterial.KAGA, 1, EntityEquipmentSlot.HEAD);
		KAGA_CHESTPLATE = new Armor_Carrier("item_kaga_chestplate", CMArmorMaterial.KAGA, 1, EntityEquipmentSlot.CHEST);
		KAGA_LEGGINGS = new Armor_Carrier("item_kaga_leggings", CMArmorMaterial.KAGA, 2, EntityEquipmentSlot.LEGS);
		KAGA_BOOTS = new Armor_Carrier("item_kaga_boots", CMArmorMaterial.KAGA, 1, EntityEquipmentSlot.FEET);
		KAGA_BOOTS_KAI = new Armor_CarrierKai("item_kaga_bootskai", CMArmorMaterial.KAGA, 1, EntityEquipmentSlot.FEET);

		/* Battleship */
		KONGOU_HELMET = new Armor_Battleship("item_kongou_helmet", CMArmorMaterial.KONGOU, 1, EntityEquipmentSlot.HEAD);
		KONGOU_CHESTPLATE = new Armor_Battleship("item_kongou_chestplate", CMArmorMaterial.KONGOU, 1, EntityEquipmentSlot.CHEST);
		KONGOU_LEGGINGS = new Armor_Battleship("item_kongou_leggings", CMArmorMaterial.KONGOU, 2, EntityEquipmentSlot.LEGS);
		KONGOU_BOOTS = new Armor_Battleship("item_kongou_boots", CMArmorMaterial.KONGOU, 1, EntityEquipmentSlot.FEET);
		KONGOU_BOOTS_KAI = new Armor_BattleshipKai("item_kongou_bootskai", CMArmorMaterial.KONGOU, 1, EntityEquipmentSlot.FEET);

		FUSOU_HELMET = new Armor_Battleship("item_fusou_helmet", CMArmorMaterial.FUSOU, 1, EntityEquipmentSlot.HEAD);
		FUSOU_CHESTPLATE = new Armor_Battleship("item_fusou_chestplate", CMArmorMaterial.FUSOU, 1, EntityEquipmentSlot.CHEST);
		FUSOU_LEGGINGS = new Armor_Battleship("item_fusou_leggings", CMArmorMaterial.FUSOU, 2, EntityEquipmentSlot.LEGS);
		FUSOU_BOOTS = new Armor_Battleship("item_fusou_boots", CMArmorMaterial.FUSOU, 1, EntityEquipmentSlot.FEET);
		FUSOU_BOOTS_KAI = new Armor_BattleshipKai("item_fusou_bootskai", CMArmorMaterial.FUSOU, 1, EntityEquipmentSlot.FEET);

		NAGATO_HELMET = new Armor_Nagato("item_nagato_helmet", CMArmorMaterial.NAGATO, 1, EntityEquipmentSlot.HEAD);
		NAGATO_CHESTPLATE = new Armor_Nagato("item_nagato_chestplate", CMArmorMaterial.NAGATO, 1, EntityEquipmentSlot.CHEST);
		NAGATO_LEGGINGS = new Armor_Nagato("item_nagato_leggings", CMArmorMaterial.NAGATO, 2, EntityEquipmentSlot.LEGS);
		NAGATO_BOOTS = new Armor_Nagato("item_nagato_boots", CMArmorMaterial.NAGATO, 1, EntityEquipmentSlot.FEET);
		NAGATO_BOOTS_KAI = new Armor_NagatoKai("item_nagato_bootskai", CMArmorMaterial.NAGATO, 1, EntityEquipmentSlot.FEET);
		
		/* Submarine */
		I168_HELMET = new Armor_i168("item_i168_helmet", CMArmorMaterial.I168, 1, EntityEquipmentSlot.HEAD);
		I168_CHESTPLATE = new Armor_i168("item_i168_chestplate", CMArmorMaterial.I168, 1, EntityEquipmentSlot.CHEST);
		I168_LEGGINGS = new Armor_i168("item_i168_leggings", CMArmorMaterial.I168, 2, EntityEquipmentSlot.LEGS);
		I168_BOOTS = new Armor_i168("item_i168_boots", CMArmorMaterial.I168, 1, EntityEquipmentSlot.FEET);

		I13_HELMET = new Armor_i13("item_i13_helmet", CMArmorMaterial.I13, 1, EntityEquipmentSlot.HEAD);
		I13_CHESTPLATE = new Armor_i13("item_i13_chestplate", CMArmorMaterial.I13, 1, EntityEquipmentSlot.CHEST);
		I13_LEGGINGS = new Armor_i13("item_i13_leggings", CMArmorMaterial.I13, 2, EntityEquipmentSlot.LEGS);
		I13_BOOTS = new Armor_i13("item_i13_boots", CMArmorMaterial.I13, 1, EntityEquipmentSlot.FEET);

		RO500_HELMET = new Armor_Ro500("item_ro500_helmet", CMArmorMaterial.RO500, 1, EntityEquipmentSlot.HEAD);
		RO500_CHESTPLATE = new Armor_Ro500("item_ro500_chestplate", CMArmorMaterial.RO500, 1, EntityEquipmentSlot.CHEST);
		RO500_LEGGINGS = new Armor_Ro500("item_ro500_leggings", CMArmorMaterial.RO500, 2, EntityEquipmentSlot.LEGS);
		RO500_BOOTS = new Armor_Ro500("item_ro500_boots", CMArmorMaterial.RO500, 1, EntityEquipmentSlot.FEET);
	}

	public static void register() {

		registerItem(FUBUKI_HELMET);
		registerItem(FUBUKI_CHESTPLATE);
		registerItem(FUBUKI_LEGGINGS);
		registerItem(FUBUKI_BOOTS);
		registerItem(FUBUKI_BOOTS_KAI);
		registerItem(KASUMI_HELMET);
		registerItem(KASUMI_CHESTPLATE);
		registerItem(KASUMI_LEGGINGS);
		registerItem(KASUMI_BOOTS);
		registerItem(KASUMI_BOOTS_KAI);
		registerItem(SHIRATSUYU_HELMET);
		registerItem(SHIRATSUYU_CHESTPLATE);
		registerItem(SHIRATSUYU_LEGGINGS);
		registerItem(SHIRATSUYU_BOOTS);
		registerItem(SHIRATSUYU_BOOTS_KAI);
		registerItem(SHIGURE_HELMET);
		registerItem(SHIGURE_CHESTPLATE);
		registerItem(SHIGURE_LEGGINGS);
		registerItem(SHIGURE_BOOTS);
		registerItem(SHIGURE_BOOTS_KAI);
		registerItem(AKATSUKI_HELMET);
		registerItem(AKATSUKI_CHESTPLATE);
		registerItem(AKATSUKI_LEGGINGS);
		registerItem(AKATSUKI_BOOTS);
		registerItem(AKATSUKI_BOOTS_KAI);
		
		registerItem(SENDAI_HELMET);
		registerItem(SENDAI_CHESTPLATE);
		registerItem(SENDAI_LEGGINGS);
		registerItem(SENDAI_BOOTS);
		registerItem(SENDAI_BOOTS_KAI);
		registerItem(YURA_HELMET);
		registerItem(YURA_CHESTPLATE);
		registerItem(YURA_LEGGINGS);
		registerItem(YURA_BOOTS);
		registerItem(YURA_BOOTS_KAI);
		registerItem(MOGAMI_HELMET);
		registerItem(MOGAMI_CHESTPLATE);
		registerItem(MOGAMI_LEGGINGS);
		registerItem(MOGAMI_BOOTS);
		registerItem(MOGAMI_BOOTS_KAI);
		registerItem(TONE_HELMET);
		registerItem(TONE_CHESTPLATE);
		registerItem(TONE_LEGGINGS);
		registerItem(TONE_BOOTS);
		registerItem(TONE_BOOTS_KAI);

		registerItem(RJ_HELMET);
		registerItem(RJ_CHESTPLATE);
		registerItem(RJ_LEGGINGS);
		registerItem(RJ_BOOTS);
		registerItem(RJ_BOOTS_KAI);
		registerItem(ZUIHOU_HELMET);
		registerItem(ZUIHOU_CHESTPLATE);
		registerItem(ZUIHOU_LEGGINGS);
		registerItem(ZUIHOU_BOOTS );
		registerItem(ZUIHOU_BOOTS_KAI);

		registerItem(AKAGI_HELMET);
		registerItem(AKAGI_CHESTPLATE);
		registerItem(AKAGI_LEGGINGS);
		registerItem(AKAGI_BOOTS);
		registerItem(AKAGI_BOOTS_KAI);
		registerItem(KAGA_HELMET);
		registerItem(KAGA_CHESTPLATE);
		registerItem(KAGA_LEGGINGS);
		registerItem(KAGA_BOOTS);
		registerItem(KAGA_BOOTS_KAI);

		registerItem(KONGOU_HELMET);
		registerItem(KONGOU_CHESTPLATE);
		registerItem(KONGOU_LEGGINGS);
		registerItem(KONGOU_BOOTS);
		registerItem(KONGOU_BOOTS_KAI);
		registerItem(FUSOU_HELMET);
		registerItem(FUSOU_CHESTPLATE);
		registerItem(FUSOU_LEGGINGS);
		registerItem(FUSOU_BOOTS);
		registerItem(FUSOU_BOOTS_KAI);
		registerItem(NAGATO_HELMET);
		registerItem(NAGATO_CHESTPLATE);
		registerItem(NAGATO_LEGGINGS);
		registerItem(NAGATO_BOOTS);
		registerItem(NAGATO_BOOTS_KAI);
		
		registerItem(I168_HELMET);
		registerItem(I168_CHESTPLATE);
		registerItem(I168_LEGGINGS);
		registerItem(I168_BOOTS);
		registerItem(I13_HELMET);
		registerItem(I13_CHESTPLATE);
		registerItem(I13_LEGGINGS);
		registerItem(I13_BOOTS);
		registerItem(RO500_HELMET);
		registerItem(RO500_CHESTPLATE);
		registerItem(RO500_LEGGINGS);
		registerItem(RO500_BOOTS);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(FUBUKI_HELMET);
		registerRender(FUBUKI_CHESTPLATE);
		registerRender(FUBUKI_LEGGINGS);
		registerRender(FUBUKI_BOOTS);
		registerRender(FUBUKI_BOOTS_KAI);
		registerRender(KASUMI_HELMET);
		registerRender(KASUMI_CHESTPLATE);
		registerRender(KASUMI_LEGGINGS);
		registerRender(KASUMI_BOOTS);
		registerRender(KASUMI_BOOTS_KAI);
		registerRender(SHIRATSUYU_HELMET);
		registerRender(SHIRATSUYU_CHESTPLATE);
		registerRender(SHIRATSUYU_LEGGINGS);
		registerRender(SHIRATSUYU_BOOTS);
		registerRender(SHIRATSUYU_BOOTS_KAI);
		registerRender(SHIGURE_HELMET);
		registerRender(SHIGURE_CHESTPLATE);
		registerRender(SHIGURE_LEGGINGS);
		registerRender(SHIGURE_BOOTS);
		registerRender(SHIGURE_BOOTS_KAI);
		registerRender(AKATSUKI_HELMET);
		registerRender(AKATSUKI_CHESTPLATE);
		registerRender(AKATSUKI_LEGGINGS);
		registerRender(AKATSUKI_BOOTS);
		registerRender(AKATSUKI_BOOTS_KAI);
		
		registerRender(SENDAI_HELMET);
		registerRender(SENDAI_CHESTPLATE);
		registerRender(SENDAI_LEGGINGS);
		registerRender(SENDAI_BOOTS);
		registerRender(SENDAI_BOOTS_KAI);
		registerRender(YURA_HELMET);
		registerRender(YURA_CHESTPLATE);
		registerRender(YURA_LEGGINGS);
		registerRender(YURA_BOOTS);
		registerRender(YURA_BOOTS_KAI);

		registerRender(MOGAMI_HELMET);
		registerRender(MOGAMI_CHESTPLATE);
		registerRender(MOGAMI_LEGGINGS);
		registerRender(MOGAMI_BOOTS);
		registerRender(MOGAMI_BOOTS_KAI);
		registerRender(TONE_HELMET);
		registerRender(TONE_CHESTPLATE);
		registerRender(TONE_LEGGINGS);
		registerRender(TONE_BOOTS);
		registerRender(TONE_BOOTS_KAI);

		registerRender(RJ_HELMET);
		registerRender(RJ_CHESTPLATE);
		registerRender(RJ_LEGGINGS);
		registerRender(RJ_BOOTS);
		registerRender(RJ_BOOTS_KAI);
		registerRender(ZUIHOU_HELMET);
		registerRender(ZUIHOU_CHESTPLATE);
		registerRender(ZUIHOU_LEGGINGS);
		registerRender(ZUIHOU_BOOTS);
		registerRender(ZUIHOU_BOOTS_KAI);

		registerRender(AKAGI_HELMET);
		registerRender(AKAGI_CHESTPLATE);
		registerRender(AKAGI_LEGGINGS);
		registerRender(AKAGI_BOOTS);
		registerRender(AKAGI_BOOTS_KAI);
		registerRender(KAGA_HELMET);
		registerRender(KAGA_CHESTPLATE);
		registerRender(KAGA_LEGGINGS);
		registerRender(KAGA_BOOTS);
		registerRender(KAGA_BOOTS_KAI);

		registerRender(KONGOU_HELMET);
		registerRender(KONGOU_CHESTPLATE);
		registerRender(KONGOU_LEGGINGS);
		registerRender(KONGOU_BOOTS);
		registerRender(KONGOU_BOOTS_KAI);
		registerRender(FUSOU_HELMET);
		registerRender(FUSOU_CHESTPLATE);
		registerRender(FUSOU_LEGGINGS);
		registerRender(FUSOU_BOOTS);
		registerRender(FUSOU_BOOTS_KAI);
		registerRender(NAGATO_HELMET);
		registerRender(NAGATO_CHESTPLATE);
		registerRender(NAGATO_LEGGINGS);
		registerRender(NAGATO_BOOTS);
		registerRender(NAGATO_BOOTS_KAI);
		
		registerRender(I168_HELMET);
		registerRender(I168_CHESTPLATE);
		registerRender(I168_LEGGINGS);
		registerRender(I168_BOOTS);
		registerRender(I13_HELMET);
		registerRender(I13_CHESTPLATE);
		registerRender(I13_LEGGINGS);
		registerRender(I13_BOOTS);
		registerRender(RO500_HELMET);
		registerRender(RO500_CHESTPLATE);
		registerRender(RO500_LEGGINGS);
		registerRender(RO500_BOOTS);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

}
