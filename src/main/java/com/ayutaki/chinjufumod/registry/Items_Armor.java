package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

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

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items_Armor {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* Destroyer */
	public static final RegistryObject<Item> FUBUKI_HELMET = register("item_fubuki_helmet", () -> new Armor_Destroyer(CMArmorMaterial.FUBUKI, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> FUBUKI_CHESTPLATE = register("item_fubuki_chestplate", () -> new Armor_Destroyer(CMArmorMaterial.FUBUKI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> FUBUKI_LEGGINGS = register("item_fubuki_leggings", () -> new Armor_Destroyer(CMArmorMaterial.FUBUKI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> FUBUKI_BOOTS = register("item_fubuki_boots", () -> new Armor_Destroyer(CMArmorMaterial.FUBUKI, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> FUBUKI_BOOTS_KAI = register("item_fubuki_bootskai", () -> new Armor_DestroyerKai(CMArmorMaterial.FUBUKI, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> KASUMI_HELMET = register("item_kasumi_helmet", () -> new Armor_Kasumi(CMArmorMaterial.KASUMI, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> KASUMI_CHESTPLATE = register("item_kasumi_chestplate", () -> new Armor_Kasumi(CMArmorMaterial.KASUMI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> KASUMI_LEGGINGS = register("item_kasumi_leggings", () -> new Armor_Kasumi(CMArmorMaterial.KASUMI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> KASUMI_BOOTS = register("item_kasumi_boots", () -> new Armor_Kasumi(CMArmorMaterial.KASUMI, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> KASUMI_BOOTS_KAI = register("item_kasumi_bootskai", () -> new Armor_KasumiKai(CMArmorMaterial.KASUMI, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> SHIRATSUYU_HELMET = register("item_shiratsuyu_helmet", () -> new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> SHIRATSUYU_CHESTPLATE = register("item_shiratsuyu_chestplate", () -> new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> SHIRATSUYU_LEGGINGS = register("item_shiratsuyu_leggings", () -> new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> SHIRATSUYU_BOOTS = register("item_shiratsuyu_boots", () -> new Armor_Destroyer(CMArmorMaterial.SHIRATSUYU, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> SHIRATSUYU_BOOTS_KAI = register("item_shiratsuyu_bootskai", () -> new Armor_DestroyerKai(CMArmorMaterial.SHIRATSUYU, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> SHIGURE_HELMET = register("item_shigure_helmet", () -> new Armor_Destroyer(CMArmorMaterial.SHIGURE, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> SHIGURE_CHESTPLATE = register("item_shigure_chestplate", () -> new Armor_Destroyer(CMArmorMaterial.SHIGURE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> SHIGURE_LEGGINGS = register("item_shigure_leggings", () -> new Armor_Destroyer(CMArmorMaterial.SHIGURE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> SHIGURE_BOOTS = register("item_shigure_boots", () -> new Armor_Destroyer(CMArmorMaterial.SHIGURE, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> SHIGURE_BOOTS_KAI = register("item_shigure_bootskai", () -> new Armor_DestroyerKai(CMArmorMaterial.SHIGURE, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> AKATSUKI_HELMET = register("item_akatsuki_helmet", () -> new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> AKATSUKI_CHESTPLATE = register("item_akatsuki_chestplate", () -> new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> AKATSUKI_LEGGINGS = register("item_akatsuki_leggings", () -> new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> AKATSUKI_BOOTS = register("item_akatsuki_boots", () -> new Armor_Akatsuki(CMArmorMaterial.AKATSUKI, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> AKATSUKI_BOOTS_KAI = register("item_akatsuki_bootskai", () -> new Armor_AkatsukiKai(CMArmorMaterial.AKATSUKI, ArmorItem.Type.BOOTS, new Item.Properties()));
	
	/* Cruiser */
	public static final RegistryObject<Item> SENDAI_HELMET = register("item_sendai_helmet", () -> new Armor_Sendai(CMArmorMaterial.SENDAI, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> SENDAI_CHESTPLATE = register("item_sendai_chestplate", () -> new Armor_Sendai(CMArmorMaterial.SENDAI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> SENDAI_LEGGINGS = register("item_sendai_leggings", () -> new Armor_Sendai(CMArmorMaterial.SENDAI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> SENDAI_BOOTS = register("item_sendai_boots", () -> new Armor_Sendai(CMArmorMaterial.SENDAI, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> SENDAI_BOOTS_KAI = register("item_sendai_bootskai", () -> new Armor_SendaiKai(CMArmorMaterial.SENDAI, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> YURA_HELMET = register("item_yura_helmet", () -> new Armor_Yura(CMArmorMaterial.YURA, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> YURA_CHESTPLATE = register("item_yura_chestplate", () -> new Armor_Yura(CMArmorMaterial.YURA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> YURA_LEGGINGS = register("item_yura_leggings", () -> new Armor_Yura(CMArmorMaterial.YURA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> YURA_BOOTS = register("item_yura_boots", () -> new Armor_Yura(CMArmorMaterial.YURA, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> YURA_BOOTS_KAI = register("item_yura_bootskai", () -> new Armor_YuraKai(CMArmorMaterial.YURA, ArmorItem.Type.BOOTS, new Item.Properties()));

	/* Heavy Cruiser */
	public static final RegistryObject<Item> MOGAMI_HELMET = register("item_mogami_helmet", () -> new Armor_Mogami(CMArmorMaterial.MOGAMI, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> MOGAMI_CHESTPLATE = register("item_mogami_chestplate", () -> new Armor_Mogami(CMArmorMaterial.MOGAMI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> MOGAMI_LEGGINGS = register("item_mogami_leggings", () -> new Armor_Mogami(CMArmorMaterial.MOGAMI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> MOGAMI_BOOTS = register("item_mogami_boots", () -> new Armor_Mogami(CMArmorMaterial.MOGAMI, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> MOGAMI_BOOTS_KAI = register("item_mogami_bootskai", () -> new Armor_MogamiKai(CMArmorMaterial.MOGAMI, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> TONE_HELMET = register("item_tone_helmet", () -> new Armor_Tone(CMArmorMaterial.TONE, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> TONE_CHESTPLATE = register("item_tone_chestplate", () -> new Armor_Tone(CMArmorMaterial.TONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> TONE_LEGGINGS = register("item_tone_leggings", () -> new Armor_Tone(CMArmorMaterial.TONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> TONE_BOOTS = register("item_tone_boots", () -> new Armor_Tone(CMArmorMaterial.TONE, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> TONE_BOOTS_KAI = register("item_tone_bootskai", () -> new Armor_ToneKai(CMArmorMaterial.TONE, ArmorItem.Type.BOOTS, new Item.Properties()));

	/* Aircraft carrier */
	public static final RegistryObject<Item> RJ_HELMET = register("item_ryujou_helmet", () -> new Armor_RJ(CMArmorMaterial.RJ, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> RJ_CHESTPLATE = register("item_ryujou_chestplate", () -> new Armor_RJ(CMArmorMaterial.RJ, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> RJ_LEGGINGS = register("item_ryujou_leggings", () -> new Armor_RJ(CMArmorMaterial.RJ, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> RJ_BOOTS = register("item_ryujou_boots", () -> new Armor_RJ(CMArmorMaterial.RJ, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> RJ_BOOTS_KAI = register("item_ryujou_bootskai", () -> new Armor_RJKai(CMArmorMaterial.RJ, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> ZUIHOU_HELMET = register("item_zuihou_helmet", () -> new Armor_Zuihou(CMArmorMaterial.ZUIHOU, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> ZUIHOU_CHESTPLATE = register("item_zuihou_chestplate", () -> new Armor_Zuihou(CMArmorMaterial.ZUIHOU, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> ZUIHOU_LEGGINGS = register("item_zuihou_leggings", () -> new Armor_Zuihou(CMArmorMaterial.ZUIHOU, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> ZUIHOU_BOOTS = register("item_zuihou_boots", () -> new Armor_Zuihou(CMArmorMaterial.ZUIHOU, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> ZUIHOU_BOOTS_KAI = register("item_zuihou_bootskai", () -> new Armor_ZuihouKai(CMArmorMaterial.ZUIHOU, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> AKAGI_HELMET = register("item_akagi_helmet", () -> new Armor_Carrier(CMArmorMaterial.AKAGI, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> AKAGI_CHESTPLATE = register("item_akagi_chestplate", () -> new Armor_Carrier(CMArmorMaterial.AKAGI, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> AKAGI_LEGGINGS = register("item_akagi_leggings", () -> new Armor_Carrier(CMArmorMaterial.AKAGI, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> AKAGI_BOOTS = register("item_akagi_boots", () -> new Armor_Carrier(CMArmorMaterial.AKAGI, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> AKAGI_BOOTS_KAI = register("item_akagi_bootskai", () -> new Armor_CarrierKai(CMArmorMaterial.AKAGI, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> KAGA_HELMET = register("item_kaga_helmet", () -> new Armor_Carrier(CMArmorMaterial.KAGA, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> KAGA_CHESTPLATE = register("item_kaga_chestplate", () -> new Armor_Carrier(CMArmorMaterial.KAGA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> KAGA_LEGGINGS = register("item_kaga_leggings", () -> new Armor_Carrier(CMArmorMaterial.KAGA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> KAGA_BOOTS = register("item_kaga_boots", () -> new Armor_Carrier(CMArmorMaterial.KAGA, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> KAGA_BOOTS_KAI = register("item_kaga_bootskai", () -> new Armor_CarrierKai(CMArmorMaterial.KAGA, ArmorItem.Type.BOOTS, new Item.Properties()));

	/* Battleship */
	public static final RegistryObject<Item> KONGOU_HELMET = register("item_kongou_helmet", () -> new Armor_Battleship(CMArmorMaterial.KONGOU, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> KONGOU_CHESTPLATE = register("item_kongou_chestplate", () -> new Armor_Battleship(CMArmorMaterial.KONGOU, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> KONGOU_LEGGINGS = register("item_kongou_leggings", () -> new Armor_Battleship(CMArmorMaterial.KONGOU, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> KONGOU_BOOTS = register("item_kongou_boots", () -> new Armor_Battleship(CMArmorMaterial.KONGOU, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> KONGOU_BOOTS_KAI = register("item_kongou_bootskai", () -> new Armor_BattleshipKai(CMArmorMaterial.KONGOU, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> FUSOU_HELMET = register("item_fusou_helmet", () -> new Armor_Battleship(CMArmorMaterial.FUSOU, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> FUSOU_CHESTPLATE = register("item_fusou_chestplate", () -> new Armor_Battleship(CMArmorMaterial.FUSOU, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> FUSOU_LEGGINGS = register("item_fusou_leggings", () -> new Armor_Battleship(CMArmorMaterial.FUSOU, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> FUSOU_BOOTS = register("item_fusou_boots", () -> new Armor_Battleship(CMArmorMaterial.FUSOU, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> FUSOU_BOOTS_KAI = register("item_fusou_bootskai", () -> new Armor_BattleshipKai(CMArmorMaterial.FUSOU, ArmorItem.Type.BOOTS, new Item.Properties()));
	
	public static final RegistryObject<Item> NAGATO_HELMET = register("item_nagato_helmet", () -> new Armor_Nagato(CMArmorMaterial.NAGATO, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> NAGATO_CHESTPLATE = register("item_nagato_chestplate", () -> new Armor_Nagato(CMArmorMaterial.NAGATO, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> NAGATO_LEGGINGS = register("item_nagato_leggings", () -> new Armor_Nagato(CMArmorMaterial.NAGATO, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> NAGATO_BOOTS = register("item_nagato_boots", () -> new Armor_Nagato(CMArmorMaterial.NAGATO, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> NAGATO_BOOTS_KAI = register("item_nagato_bootskai", () -> new Armor_NagatoKai(CMArmorMaterial.NAGATO, ArmorItem.Type.BOOTS, new Item.Properties()));

	/* Submarine */
	public static final RegistryObject<Item> I168_HELMET = register("item_i168_helmet", () -> new Armor_i168(CMArmorMaterial.I168, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> I168_CHESTPLATE = register("item_i168_chestplate", () -> new Armor_i168(CMArmorMaterial.I168, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> I168_LEGGINGS = register("item_i168_leggings", () -> new Armor_i168(CMArmorMaterial.I168, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> I168_BOOTS = register("item_i168_boots", () -> new Armor_i168(CMArmorMaterial.I168, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> I13_HELMET = register("item_i13_helmet", () -> new Armor_i13(CMArmorMaterial.I13, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> I13_CHESTPLATE = register("item_i13_chestplate", () -> new Armor_i13(CMArmorMaterial.I13, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> I13_LEGGINGS = register("item_i13_leggings", () -> new Armor_i13(CMArmorMaterial.I13, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> I13_BOOTS = register( "item_i13_boots", () -> new Armor_i13(CMArmorMaterial.I13, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> RO500_HELMET = register("item_ro500_helmet", () -> new Armor_Ro500(CMArmorMaterial.RO500, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> RO500_CHESTPLATE = register("item_ro500_chestplate", () -> new Armor_Ro500(CMArmorMaterial.RO500, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> RO500_LEGGINGS = register("item_ro500_leggings", () -> new Armor_Ro500(CMArmorMaterial.RO500, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> RO500_BOOTS = register( "item_ro500_boots", () -> new Armor_Ro500(CMArmorMaterial.RO500, ArmorItem.Type.BOOTS, new Item.Properties()));

	
	///* Register *///
	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}
}
