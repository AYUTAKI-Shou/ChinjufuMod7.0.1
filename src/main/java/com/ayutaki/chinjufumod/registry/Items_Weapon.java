package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
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
import com.ayutaki.chinjufumod.items.weapon.CMTiers;
import com.ayutaki.chinjufumod.items.weapon.FirstAid;
import com.ayutaki.chinjufumod.items.weapon.KoukakuHou100;
import com.ayutaki.chinjufumod.items.weapon.RensouHou127;
import com.ayutaki.chinjufumod.items.weapon.RensouHou155;
import com.ayutaki.chinjufumod.items.weapon.RensouHou203;
import com.ayutaki.chinjufumod.items.weapon.RensouHou203SKC34;
import com.ayutaki.chinjufumod.items.weapon.RensouHou356;
import com.ayutaki.chinjufumod.items.weapon.RensouHou356S3;
import com.ayutaki.chinjufumod.items.weapon.RensouHou380;
import com.ayutaki.chinjufumod.items.weapon.RensouHou410;
import com.ayutaki.chinjufumod.items.weapon.Shield_CM;
import com.ayutaki.chinjufumod.items.weapon.ShigureHou;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;
import com.ayutaki.chinjufumod.items.weapon.Sword_CM;
import com.ayutaki.chinjufumod.items.weapon.Triple_Kijyuu;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Weapon {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static Item AMMUNITION_L = register("item_ammunition_kc", new Ammo_Large(new Item.Properties()));
	public static Item AMMUNITION_M = register("item_ammunition_medium", new Ammo_Medium(new Item.Properties()));
	public static Item AMMUNITION_S = register("item_ammunition_small", new Ammo_Small(new Item.Properties()));
	public static Item AMMUNITION_K = register("item_ammunition_kijyuu", new Ammo_Kijyuu(new Item.Properties()));
	public static Item KK_FUEL = register("item_kk_fuel", new Fuel_KK(new Item.Properties()));
	
	/* durability + 100 */
	public static Item RENSOUHOU_127 = register("item_rensouhou127", new RensouHou127(new Item.Properties().durability(1100))); //1100
	public static Item SHIGUREHOU = register("item_shigurehou", new ShigureHou(new Item.Properties().durability(1100)));
	public static Item KOUKAKUHOU_100 = register("item_koukakuhou100", new KoukakuHou100(new Item.Properties().durability(1100)));

	public static Item RENSOUHOU_155 = register("item_rensouhou155", new RensouHou155(new Item.Properties().durability(2960)));
	public static Item RENSOUHOU_203 = register("item_rensouhou203", new RensouHou203(new Item.Properties().durability(2600)));
	public static Item RENSOUHOU_SKC = register("item_rensouhou203_skc34", new RensouHou203SKC34(new Item.Properties().durability(2100)));

	public static Item RENSOUHOU_356 = register("item_rensouhou356", new RensouHou356(new Item.Properties().durability(5100)));
	public static Item RENSOUHOU_356S3 = register("item_rensouhou356_s3", new RensouHou356S3(new Item.Properties().durability(4850)));
	public static Item RENSOUHOU_380 = register("item_rensouhou380", new RensouHou380(new Item.Properties().durability(4600)));
	public static Item RENSOUHOU_410 = register("item_rensouhou410", new RensouHou410(new Item.Properties().durability(5100)));
	
	public static Item KIJYUU = register("item_3rensou_kijyuu", new Triple_Kijyuu(new Item.Properties().durability(900))); //Damage from continuous use.

	public static Item TYPE97KK = register("item_kk_type97", new KK_Type97(new Item.Properties().durability(4)));
	public static Item TENZAN = register("item_kk_tenzan", new KK_Tenzan(new Item.Properties().durability(1600)));
	public static Item RYUSEI = register("item_kk_ryusei", new KK_Ryusei(new Item.Properties().durability(2100)));
	public static Item SWORDFISH = register("item_kk_swordfish", new KK_Swordfish(new Item.Properties().durability(1100)));
	public static Item BARRACUDA = register("item_kk_barracuda", new KK_Barracuda(new Item.Properties().durability(1700)));
	public static Item MOSQUITO = register("item_kk_mosquito", new KK_Mosquito(new Item.Properties().durability(1300))); //wooden
	public static Item TBF = register("item_kk_tbf", new KK_TBF(new Item.Properties().durability(1900)));

	public static Item TYPE99 = register("item_kb_type99", new KB_Type99(new Item.Properties().durability(1100)));
	public static Item SUISEI = register("item_kb_suisei", new KB_Suisei(new Item.Properties().durability(1600)));
	public static Item TYPEZERO = register("item_kb_typezero", new KB_TypeZero(new Item.Properties().durability(2100)));
	public static Item RE2001 = register("item_kb_re2001", new KB_Re2001(new Item.Properties().durability(1300)));
	public static Item JU87 = register("item_kb_ju87", new KB_Ju87(new Item.Properties().durability(1400))); //1400
	public static Item SBD = register("item_kb_sbd", new KB_SBD(new Item.Properties().durability(1600)));
	public static Item F4U = register("item_kb_f4u", new KB_F4U(new Item.Properties().durability(2100)));
	
	public static Item GYORAI_61cm = register("item_gyorai_61cm", new Gyorai61cm(new Item.Properties()));

	public static Item SHIELD_kuchiku = register("item_shield_kuchiku", new Shield_CM(new Item.Properties().durability(1108)));
	public static Item SHIELD_yura = register("item_shield_yura", new Shield_CM(new Item.Properties().durability(1780)));
	public static Item SHIELD_mogami = register("item_shield_mogami", new Shield_CM(new Item.Properties().durability(2452)));
	public static Item SHIELD_kongou = register("item_shield_kongou", new Shield_CM(new Item.Properties().durability(3124)));

	public static Item ANCHOR = register("item_anchor", new Anchor(CMTiers.ANCHOR, 3, -2.4F, (new Item.Properties())));
	public static Item DAMECON = register("item_kit_firstaid", new FirstAid(new Item.Properties()));
	public static Item MEGAMI = register("item_kit_goddess", new FirstAid(new Item.Properties()));
	public static Item SWORD_sakura = register("item_sword_sakura", new Sword_CM(ItemTier.WOOD,3, -2.4F, (new Item.Properties())));
	public static Item SWORD_ichoh = register("item_sword_ichoh", new Sword_CM(ItemTier.WOOD,3, -2.4F, (new Item.Properties())));
	public static Item SWORD_kaede = register("item_sword_kaede", new Sword_CM(ItemTier.WOOD,3, -2.4F, (new Item.Properties())));

	public static Item SOUGANKYOU = register("item_binoculars", new SouganKyou(new Item.Properties().stacksTo(1)));
	
	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
