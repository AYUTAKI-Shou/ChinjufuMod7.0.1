package com.ayutaki.chinjufumod.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class CMArmorMaterial {

	/* .addArmorMaterial(name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
	 * name "Material名"
	 * textureName テクスチャの名前 "Modid:pngファイル名の_layer前まで"
	 * durability 防具の耐久度 革5 鉄15 金7 ダイヤモンド33
	 * reductionAmounts 各部の防御ポイント 革{ 1, 2, 3, 1 }, 鉄{ 2, 5, 6, 2 }, 金{ 1, 3, 5, 2 }, ダイヤモンド{ 3, 6, 8, 3 }
	 * enchantability 数値が大きいほど良いエンチャントが付き易い 革15, 鉄9, 金25, ダイヤモンド10
	 * soundOnEquip 効果音
	 * toughness タフネス, ダメージカット率をより上げる デフォルト0 ダイヤモンドのみ2 */

	public static ArmorMaterial FUBUKI = EnumHelper
			.addArmorMaterial("FUBUKI", "chinjufumod:fubuki", 17, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	public static ArmorMaterial KASUMI = EnumHelper
			.addArmorMaterial("KASUMI", "chinjufumod:kasumi", 17, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	public static ArmorMaterial SHIRATSUYU = EnumHelper
			.addArmorMaterial("SHIRATSUYU", "chinjufumod:shiratsuyu", 17, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	public static ArmorMaterial SHIGURE = EnumHelper
			.addArmorMaterial("SHIGURE", "chinjufumod:shigure", 17, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	public static ArmorMaterial AKATSUKI = EnumHelper
			.addArmorMaterial("AKATSUKI", "chinjufumod:akatsuki", 17, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);


	public static ArmorMaterial AKASHISANTA = EnumHelper
			.addArmorMaterial("AKASHISANTA", "chinjufumod:santaakashi", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial KUMANOSANTA = EnumHelper
			.addArmorMaterial("KUMANOSANTA", "chinjufumod:santakumano", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial SUZUYASANTA = EnumHelper
			.addArmorMaterial("SUZUYASANTA", "chinjufumod:santasuzuya", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial RYUJOUSANTA = EnumHelper
			.addArmorMaterial("RYUJOUSANTA", "chinjufumod:santaryujou", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial TEITOKUSANTA = EnumHelper
			.addArmorMaterial("TEITOKUSANTA", "chinjufumod:santattk", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	/* 0.42×45=18.9 */
	public static ArmorMaterial YURA = EnumHelper
			.addArmorMaterial("YURA", "chinjufumod:yura", 19, new int[] { 2, 6, 7, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	/* 0.42×48=20.1 */
	public static ArmorMaterial SENDAI = EnumHelper
			.addArmorMaterial("SENDAI", "chinjufumod:sendai", 20, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	/* 0.42×50=21 */
	public static ArmorMaterial RJ = EnumHelper
			.addArmorMaterial("RJ", "chinjufumod:ryujou", 21, new int[] { 3, 6, 7, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	/* 0.42×59=24.78 */
	public static ArmorMaterial ZUIHOU = EnumHelper
			.addArmorMaterial("ZUIHOU", "chinjufumod:zuihou", 25, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
	
	/* 0.42×50=21 */
	public static ArmorMaterial MOGAMI = EnumHelper
			.addArmorMaterial("MOGAMI", "chinjufumod:mogami", 21, new int[] { 3, 6, 7, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	/* 0.42×59=24.78 */
	public static ArmorMaterial TONE = EnumHelper
			.addArmorMaterial("TONE", "chinjufumod:tone", 25, new int[] { 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

	/* 0.42×72=30.24 */
	public static ArmorMaterial KAGA = EnumHelper
			.addArmorMaterial("KAGA", "chinjufumod:kaga", 30, new int[] { 2, 6, 7, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1);

	/* 0.42×69=28.98 */
	public static ArmorMaterial AKAGI = EnumHelper
			.addArmorMaterial("AKAGI", "chinjufumod:akagi", 29, new int[] { 2, 6, 7, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1);

	/* 33÷82≒0.4 調整値+0.02 ダイヤモンド相当を前提 */
	public static ArmorMaterial KONGOU = EnumHelper
			.addArmorMaterial("KONGOU", "chinjufumod:kongou", 33, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);

	public static ArmorMaterial FUSOU = EnumHelper
			.addArmorMaterial("FUSOU", "chinjufumod:fusou", 33, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
	
	public static ArmorMaterial NAGATO = EnumHelper
			.addArmorMaterial("NAGATO", "chinjufumod:nagato", 35, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
	
	/* 0.42×15=6.3 */
	public static ArmorMaterial I168 = EnumHelper
			.addArmorMaterial("I168", "chinjufumod:i168", 7, new int[] { 2, 4, 4, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	/* 0.42×21=8.8 */
	public static ArmorMaterial I13 = EnumHelper
			.addArmorMaterial("I13", "chinjufumod:i13", 9, new int[] { 2, 4, 4, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	/* 0.42×13=5.46 */
	public static ArmorMaterial RO500 = EnumHelper
			.addArmorMaterial("RO500", "chinjufumod:ro500", 6, new int[] { 3, 4, 4, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	
	public static ArmorMaterial IKADUCHIYKT = EnumHelper
			.addArmorMaterial("IKADUCHIYKT", "chinjufumod:ykt_ikaduchi", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial INADUMAYKT = EnumHelper
			.addArmorMaterial("INADUMAYKT", "chinjufumod:ykt_inaduma", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial HAMAKAZEYKT = EnumHelper
			.addArmorMaterial("HAMAKAZEYKT", "chinjufumod:ykt_hamakaze", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial URAKAZEYKT = EnumHelper
			.addArmorMaterial("URAKAZEYKT", "chinjufumod:ykt_urakaze", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial KAWAKAZEYKT = EnumHelper
			.addArmorMaterial("KAWAKAZEYKT", "chinjufumod:ykt_kawakaze", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial OBOROYKT = EnumHelper
			.addArmorMaterial("OBOROYKT", "chinjufumod:ykt_oboro", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial TTOKUYKT = EnumHelper
			.addArmorMaterial("TTOKUYKT", "chinjufumod:ykt_ttoku", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

	public static ArmorMaterial TTOKUYKTB = EnumHelper
			.addArmorMaterial("TTOKUYKTB", "chinjufumod:ykt_ttokub", 6, new int[] { 1, 2, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

}
