package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.kansaiki.Fuel_KK;
import com.ayutaki.chinjufumod.items.kansaiki.Gyorai61cm;
import com.ayutaki.chinjufumod.items.kansaiki.KB_F4U;
import com.ayutaki.chinjufumod.items.kansaiki.KB_Ju87;
import com.ayutaki.chinjufumod.items.kansaiki.KB_Re2001;
import com.ayutaki.chinjufumod.items.kansaiki.KB_SBD;
import com.ayutaki.chinjufumod.items.kansaiki.KB_Suisei;
import com.ayutaki.chinjufumod.items.kansaiki.KB_Type99;
import com.ayutaki.chinjufumod.items.kansaiki.KB_TypeZero;
import com.ayutaki.chinjufumod.items.kansaiki.KK_Barracuda;
import com.ayutaki.chinjufumod.items.kansaiki.KK_Mosquito;
import com.ayutaki.chinjufumod.items.kansaiki.KK_Ryusei;
import com.ayutaki.chinjufumod.items.kansaiki.KK_Swordfish;
import com.ayutaki.chinjufumod.items.kansaiki.KK_TBF;
import com.ayutaki.chinjufumod.items.kansaiki.KK_Tenzan;
import com.ayutaki.chinjufumod.items.kansaiki.KK_Type97;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Kijyuu;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Large;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Medium;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Small;
import com.ayutaki.chinjufumod.items.weapon.Anchor;
import com.ayutaki.chinjufumod.items.weapon.FirstAid;
import com.ayutaki.chinjufumod.items.weapon.KoukakuHou100;
import com.ayutaki.chinjufumod.items.weapon.RensouHou127;
import com.ayutaki.chinjufumod.items.weapon.RensouHou155;
import com.ayutaki.chinjufumod.items.weapon.RensouHou203;
import com.ayutaki.chinjufumod.items.weapon.RensouHou203SKC34;
import com.ayutaki.chinjufumod.items.weapon.RensouHou356;
import com.ayutaki.chinjufumod.items.weapon.RensouHou356S3;
import com.ayutaki.chinjufumod.items.weapon.RensouHou380;
import com.ayutaki.chinjufumod.items.weapon.ShieldCM_Item;
import com.ayutaki.chinjufumod.items.weapon.ShigureHou;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;
import com.ayutaki.chinjufumod.items.weapon.SwordIchoh;
import com.ayutaki.chinjufumod.items.weapon.SwordKaede;
import com.ayutaki.chinjufumod.items.weapon.SwordSakura;
import com.ayutaki.chinjufumod.items.weapon.Triple_Kijyuu;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Weapon {

	public static Item AMMUNITION_L, AMMUNITION_M, AMMUNITION_S, AMMUNITION_K;
	public static Item CARTRIDGE_L, CARTRIDGE_M, CARTRIDGE_S, CARTRIDGE_K, KK_FUEL;

	public static Item RENSOUHOU_127, SHIGUREHOU, KOUKAKUHOU_100;
	public static Item RENSOUHOU_155, RENSOUHOU_203, RENSOUHOU_SKC;
	public static Item RENSOUHOU_356, RENSOUHOU_356S3, RENSOUHOU_380, RENSOUHOU_410, KIJYUU;

	public static Item TYPE97KK, TENZAN, RYUSEI, SWORDFISH, BARRACUDA, MOSQUITO, TBF;
	public static Item TYPE99, SUISEI, TYPEZERO, RE2001, JU87, SBD, F4U;
	public static Item GYORAI_61cm;
	public static Item SHIELD_kuchiku, SHIELD_yura, SHIELD_mogami, SHIELD_kongou;

	public static Item ANCHOR, DAMECON;
	public static Item SWORD_sakura, SWORD_ichoh, SWORD_kaede, SOUGANKYOU;


	public static void init() {

		AMMUNITION_L = new Ammo_Large("item_ammunition_kc");
		AMMUNITION_M = new Ammo_Medium("item_ammunition_medium");
		AMMUNITION_S = new Ammo_Small("item_ammunition_small");
		AMMUNITION_K = new Ammo_Kijyuu("item_ammunition_kijyuu");
		CARTRIDGE_L = new Item().setRegistryName("item_cartridge_kc").setUnlocalizedName("item_cartridge_kc");
		CARTRIDGE_M = new Item().setRegistryName("item_cartridge_medium").setUnlocalizedName("item_cartridge_medium");
		CARTRIDGE_S = new Item().setRegistryName("item_cartridge_small").setUnlocalizedName("item_cartridge_small");
		CARTRIDGE_K = new Item().setRegistryName("item_cartridge_kijyuu").setUnlocalizedName("item_cartridge_kijyuu");
		KK_FUEL = new Fuel_KK("item_kk_fuel");
		
		RENSOUHOU_127 = new RensouHou127("item_rensouhou127", 1100);
		SHIGUREHOU = new ShigureHou("item_shigurehou", 1100);
		KOUKAKUHOU_100 = new KoukakuHou100("item_koukakuhou100", 1100);
		RENSOUHOU_155 = new RensouHou155("item_rensouhou155", 2960);
		RENSOUHOU_203 = new RensouHou203("item_rensouhou203", 2600);
		RENSOUHOU_SKC = new RensouHou203SKC34("item_rensouhou203_skc34", 2100);
		RENSOUHOU_356 = new RensouHou356("item_rensouhou356", 5100);
		RENSOUHOU_356S3 = new RensouHou356S3("item_rensouhou356_s3", 4850);
		RENSOUHOU_380 = new RensouHou380("item_rensouhou380", 4600);
		RENSOUHOU_410 = new RensouHou380("item_rensouhou410", 5100);

		KIJYUU = new Triple_Kijyuu("item_3rensou_kijyuu", 900); //Damage from continuous use.
		
		TYPE97KK = new KK_Type97("item_kk_type97", 1100);
		TENZAN = new KK_Tenzan("item_kk_tenzan", 1600);
		RYUSEI = new KK_Ryusei("item_kk_ryusei", 2100);
		SWORDFISH = new KK_Swordfish("item_kk_swordfish", 1100);
		BARRACUDA = new KK_Barracuda("item_kk_barracuda", 1700);
		MOSQUITO = new KK_Mosquito("item_kk_mosquito", 1300); //wooden
		TBF = new KK_TBF("item_kk_tbf", 1900);

		TYPE99 = new KB_Type99("item_kb_type99", 1100);
		SUISEI = new KB_Suisei("item_kb_suisei", 1600);
		TYPEZERO = new KB_TypeZero("item_kb_typezero", 2100);
		RE2001 = new KB_Re2001("item_kb_re2001", 1300);
		JU87 = new KB_Ju87("item_kb_ju87", 1400); //1400
		SBD = new KB_SBD("item_kb_sbd", 1600);
		F4U = new KB_F4U("item_kb_f4u", 2100);
		GYORAI_61cm = new Gyorai61cm("item_gyorai_61cm");

		SHIELD_kuchiku = new ShieldCM_Item("item_shield_kuchiku", 1108);
		SHIELD_yura = new ShieldCM_Item("item_shield_yura", 1780);
		SHIELD_mogami = new ShieldCM_Item("item_shield_mogami", 2452);
		SHIELD_kongou = new ShieldCM_Item("item_shield_kongou", 3124); //336×9 + 100

		ANCHOR = new Anchor("item_anchor", Anchor.ANCHOR);
		DAMECON = new FirstAid("item_kit_firstaid");
		SWORD_sakura = new SwordSakura("item_sword_sakura", ToolMaterial.WOOD);
		SWORD_ichoh = new SwordIchoh("item_sword_ichoh", ToolMaterial.WOOD);
		SWORD_kaede = new SwordKaede("item_sword_kaede", ToolMaterial.WOOD);
		SOUGANKYOU = new SouganKyou("item_binoculars");
	}

	public static void register() {

		registerItem(AMMUNITION_L);
		registerItem(AMMUNITION_M);
		registerItem(AMMUNITION_S);
		registerItem(AMMUNITION_K);
		registerItem(CARTRIDGE_L);
		registerItem(CARTRIDGE_M);
		registerItem(CARTRIDGE_S);
		registerItem(CARTRIDGE_K);
		registerItem(KK_FUEL);
		
		registerItem(RENSOUHOU_127);
		registerItem(SHIGUREHOU);
		registerItem(KOUKAKUHOU_100);
		registerItem(RENSOUHOU_155);
		registerItem(RENSOUHOU_203);
		registerItem(RENSOUHOU_SKC);
		registerItem(RENSOUHOU_356);
		registerItem(RENSOUHOU_356S3);
		registerItem(RENSOUHOU_380);
		registerItem(RENSOUHOU_410);
		registerItem(KIJYUU);
		
		registerItem(TYPE97KK);
		registerItem(TENZAN);
		registerItem(RYUSEI);
		registerItem(SWORDFISH);
		registerItem(BARRACUDA);
		registerItem(MOSQUITO);
		registerItem(TBF);

		registerItem(TYPE99);
		registerItem(SUISEI);
		registerItem(TYPEZERO);
		registerItem(RE2001);
		registerItem(JU87);
		registerItem(SBD);
		registerItem(F4U);
		registerItem(GYORAI_61cm);

		registerItem(SHIELD_kuchiku);
		registerItem(SHIELD_yura);
		registerItem(SHIELD_mogami);
		registerItem(SHIELD_kongou);

		registerItem(ANCHOR);
		registerItem(DAMECON);
		registerItem(SWORD_sakura);
		registerItem(SWORD_ichoh);
		registerItem(SWORD_kaede);
		registerItem(SOUGANKYOU);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(AMMUNITION_L);
		registerRender(AMMUNITION_M);
		registerRender(AMMUNITION_S);
		registerRender(AMMUNITION_K);
		registerRender(CARTRIDGE_L);
		registerRender(CARTRIDGE_M);
		registerRender(CARTRIDGE_S);
		registerRender(CARTRIDGE_K);
		registerRender(KK_FUEL);
		
		registerRender(RENSOUHOU_127);
		registerRender(SHIGUREHOU);
		registerRender(KOUKAKUHOU_100);
		registerRender(RENSOUHOU_155);
		registerRender(RENSOUHOU_203);
		registerRender(RENSOUHOU_SKC);
		registerRender(RENSOUHOU_356);
		registerRender(RENSOUHOU_356S3);
		registerRender(RENSOUHOU_380);
		registerRender(RENSOUHOU_410);
		registerRender(KIJYUU);
		
		registerRender(TYPE97KK);
		registerRender(TENZAN);
		registerRender(RYUSEI);
		registerRender(SWORDFISH);
		registerRender(BARRACUDA);
		registerRender(MOSQUITO);
		registerRender(TBF);

		registerRender(TYPE99);
		registerRender(SUISEI);
		registerRender(TYPEZERO);
		registerRender(RE2001);
		registerRender(JU87);
		registerRender(SBD);
		registerRender(F4U);
		registerRender(GYORAI_61cm);

		registerRender(SHIELD_kuchiku);
		registerRender(SHIELD_yura);
		registerRender(SHIELD_mogami);
		registerRender(SHIELD_kongou);

		registerRender(ANCHOR);
		registerRenderMeta(DAMECON, 0, "item_kit_firstaid");
		registerRenderMeta(DAMECON, 1, "item_kit_goddess");
		registerRender(SWORD_sakura);
		registerRender(SWORD_ichoh);
		registerRender(SWORD_kaede);
		registerRender(SOUGANKYOU);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}
}
