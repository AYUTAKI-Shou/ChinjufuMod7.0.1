package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.items.addinfo.AddInfo_Item;
import com.ayutaki.chinjufumod.items.dish.Curry_Item;
import com.ayutaki.chinjufumod.items.dish.Dish_Donburi;
import com.ayutaki.chinjufumod.items.dish.Dish_Plate;
import com.ayutaki.chinjufumod.items.dish.Dish_addItem;
import com.ayutaki.chinjufumod.items.dish.Dish_always;
import com.ayutaki.chinjufumod.items.dish.DonabeKara_Item;
import com.ayutaki.chinjufumod.items.dish.TeaCup_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouKara_Item;
import com.ayutaki.chinjufumod.items.foods.Bentou;
import com.ayutaki.chinjufumod.items.foods.FoodAnytime_addItem;
import com.ayutaki.chinjufumod.items.foods.FoodBuilders;
import com.ayutaki.chinjufumod.items.foods.FoodNeed_addItem;
import com.ayutaki.chinjufumod.items.fuel.Teatime_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.Teatime_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.Teatime_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.Teatime_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.Teatime_noFuel;
import com.ayutaki.chinjufumod.items.hakkou.HakkouItem_Tips;
import com.ayutaki.chinjufumod.items.hakkou.MizuokeMilk_Item;
import com.ayutaki.chinjufumod.items.hakkou.Mizuoke_Item;
import com.ayutaki.chinjufumod.items.hakkou.SakeGlass;
import com.ayutaki.chinjufumod.items.teatime.AmiShikake_Item;
import com.ayutaki.chinjufumod.items.teatime.AmiYoushoku_Item;
import com.ayutaki.chinjufumod.items.teatime.Kaihori_Item;
import com.ayutaki.chinjufumod.items.teatime.KineTsuki_Item;
import com.ayutaki.chinjufumod.items.teatime.Match_Item;
import com.ayutaki.chinjufumod.items.teatime.MeasureCup_Item;
import com.ayutaki.chinjufumod.items.teatime.Toami_Item;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Teatime {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* SEEDS・CROPS */
	public static Item SEEDSBOX = register("block_seedsbox", new Teatime_noFuel(Crop_Blocks.SEEDSBOX, new Item.Properties()));

	public static Item SEEDS_CABBAGE = register("item_seeds_cabbage", new Teatime_noFuel(Crop_Blocks.CABBAGE, new Item.Properties()));
	public static Item SEEDS_HAKUSAI = register("item_seeds_hakusai", new Teatime_noFuel(Crop_Blocks.HAKUSAI, new Item.Properties()));
	public static Item SEEDS_CORN = register("item_seeds_corn", new Teatime_noFuel(Crop_Blocks.CORN, new Item.Properties()));
	/** 6.4.1 **/ public static Item SEEDS_GREENONION = register("item_seeds_greenonion", new Teatime_noFuel(Crop_Blocks.GREENONION, new Item.Properties()));
	public static Item SEEDS_ONION = register("item_seeds_onion", new Teatime_noFuel(Crop_Blocks.ONION, new Item.Properties()));
	public static Item SEEDS_RICE = register("item_seeds_rice", new Teatime_noFuel(Crop_Blocks.RICE, new Item.Properties()));
	public static Item SEEDS_SOY = register("item_seeds_soy", new Teatime_noFuel(Crop_Blocks.SOY, new Item.Properties()));
	public static Item SEEDS_SPINACH = register("item_seeds_spinach", new Teatime_noFuel(Crop_Blocks.SPINACH, new Item.Properties()));
	public static Item SEEDS_TOMATO = register("item_seeds_tomato", new Teatime_noFuel(Crop_Blocks.TOMATO, new Item.Properties()));
	public static Item SEEDS_CHERRY = register("item_seeds_cherry", new Teatime_noFuel(Crop_Blocks.SAKURA, new Item.Properties()));

	public static Item CHANOKI = register("block_wood_chanoki_nae", new Teatime_noFuel(Crop_Blocks.CHANOKI, new Item.Properties()));
	public static Item BUDOUNOKI = register("block_wood_grape_nae", new Teatime_noFuel(Crop_Blocks.BUDOUNOKI, new Item.Properties()));
	public static Item MIKAN = register("block_wood_mikan", new Teatime_noFuel(Crop_Blocks.MIKAN, new Item.Properties()));
	public static Item HODAGI = register("block_hodagi_a_bot", new Teatime_noFuel(Crop_Blocks.HODAGI_A_BOT, new Item.Properties()));

	public static Item SEEDS_PEPPER = register("item_seeds_pepper", new Teatime_noFuel(Crop_Blocks.PEPPER, new Item.Properties()));
	public static Item SEEDS_CUMIN = register("item_seeds_cumin", new Teatime_noFuel(Crop_Blocks.CUMIN, new Item.Properties()));
	public static Item SEEDS_TURMERIC = register("item_seeds_turmeric", new Teatime_noFuel(Crop_Blocks.TURMERIC, new Item.Properties()));
	public static Item SEEDS_CHILI = register("item_seeds_chilipepper", new Teatime_noFuel(Crop_Blocks.CHILI, new Item.Properties()));
	
	public static Item CHABA = register("item_chaba", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CHABA_GREEN = register("item_chaba_green", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CHABA_RED = register("item_chaba_red", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item INAGI = register("block_inagi", new Teatime_noFuel(Crop_Blocks.INAGI, new Item.Properties()));
	public static Item INEWARA = register("item_inewara", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item INE = register("item_ine", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_Teatime.INEWARA)));
	public static Item INE_D = register("item_ine_dry", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_Teatime.INEWARA)));
	public static Item KOME = register("item_kome", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item SAYA = register("item_saya", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SOY = register("item_soy", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PEPPER_RAW = register("item_crop_pepper", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PEPPER_DRY = register("item_crop_pepperdry", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CHILIPEPPER = register("item_crop_chilipepper", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item DUST_PEPPER = register("item_dust_blackpepper", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item DUST_CUMIN = register("item_dust_cumin", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item DUST_TURMERIC = register("item_dust_turmeric", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item DUST_CHILI = register("item_dust_chili", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CURRY_ROUX = register("item_curry_roux", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item FOOD_CABBAGE = register("item_food_cabbage", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.CABBAGE)));
	public static Item FOOD_HAKUSAI = register("item_food_hakusai", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.HAKUSAI)));
	public static Item FOOD_CHERRY = register("item_food_cherry", new FoodAnytime_addItem(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item FOOD_MIKAN = register("item_food_mikan", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.MIKAN)));
	public static Item FOOD_CORN = register("item_food_corn", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.CORN)));
	public static Item FOOD_GRAPE = register("item_food_grape", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.GRAPE)));
	/** 6.4.1 **/ public static Item FOOD_GREENONION = register("item_food_greenonion", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.GREENONION)));
	public static Item FOOD_ONION = register("item_food_onion", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.ONION)));
	public static Item FOOD_SPINACH = register("item_food_spinach", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SPINACH)));
	public static Item FOOD_TOMATO = register("item_food_tomato", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.TOMATO)));

	public static Item FOOD_CORN_B = register("item_food_cornb", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.CORN_B)));

	public static Item BOX_H_EMPTY = register("block_boxh_empty", new Teatime_noFuel(Pantry_Blocks.BOX_H_EMPTY, new Item.Properties()));
	public static Item BOX_H_APPLE = register("block_boxh_apple", new Teatime_Fuel100(Pantry_Blocks.BOX_H_APPLE, new Item.Properties()));
	public static Item BOX_H_BEEF = register("block_boxh_beef", new Teatime_Fuel100(Pantry_Blocks.BOX_H_BEEF, new Item.Properties()));
	public static Item BOX_H_BEETROOT = register("block_boxh_beetroot", new Teatime_Fuel100(Pantry_Blocks.BOX_H_BEETROOT, new Item.Properties()));
	public static Item BOX_H_BREAD = register("block_boxh_bread", new Teatime_Fuel100(Pantry_Blocks.BOX_H_BREAD, new Item.Properties()));
	public static Item BOX_H_CARROT = register("block_boxh_carrot", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CARROT, new Item.Properties()));
	public static Item BOX_H_CHICKEN = register("block_boxh_chicken", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CHICKEN, new Item.Properties()));
	public static Item BOX_H_CHORUS = register("block_boxh_chorus", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CHORUS, new Item.Properties()));
	public static Item BOX_H_COCO = register("block_boxh_coco", new Teatime_Fuel100(Pantry_Blocks.BOX_H_COCO, new Item.Properties()));
	public static Item BOX_H_COD = register("block_boxh_cod", new Teatime_Fuel100(Pantry_Blocks.BOX_H_COD, new Item.Properties()));
	public static Item BOX_H_EGG = register("block_boxh_egg", new Teatime_Fuel100(Pantry_Blocks.BOX_H_EGG, new Item.Properties()));
	public static Item BOX_H_FISH = register("block_boxh_fish", new Teatime_Fuel100(Pantry_Blocks.BOX_H_FISH, new Item.Properties()));
	public static Item BOX_H_FLOUR = register("block_boxh_flour", new Teatime_Fuel100(Pantry_Blocks.BOX_H_FLOUR, new Item.Properties()));
	public static Item BOX_H_MUTTON = register("block_boxh_mutton", new Teatime_Fuel100(Pantry_Blocks.BOX_H_MUTTON, new Item.Properties()));
	public static Item BOX_H_PORK = register("block_boxh_pork", new Teatime_Fuel100(Pantry_Blocks.BOX_H_PORK, new Item.Properties()));
	public static Item BOX_H_POTATO = register("block_boxh_potato", new Teatime_Fuel100(Pantry_Blocks.BOX_H_POTATO, new Item.Properties()));
	public static Item BOX_H_RABBIT = register("block_boxh_rabbit", new Teatime_Fuel100(Pantry_Blocks.BOX_H_RABBIT, new Item.Properties()));
	public static Item BOX_H_SALMON = register("block_boxh_salmon", new Teatime_Fuel100(Pantry_Blocks.BOX_H_SALMON, new Item.Properties()));
	public static Item BOX_H_SWBERRY = register("block_boxh_swberry", new Teatime_Fuel100(Pantry_Blocks.BOX_H_SWBERRY, new Item.Properties()));

	public static Item BOX_H_CABBAGE = register("block_boxh_cabbage", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CABBAGE, new Item.Properties()));
	public static Item BOX_H_HAKUSAI = register("block_boxh_hakusai", new Teatime_Fuel100(Pantry_Blocks.BOX_H_HAKUSAI, new Item.Properties()));
	public static Item BOX_H_CITRUS = register("block_boxh_citrus", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CITRUS, new Item.Properties()));
	public static Item BOX_H_CORN = register("block_boxh_corn", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CORN, new Item.Properties()));
	public static Item BOX_H_GRAPE = register("block_boxh_grape", new Teatime_Fuel100(Pantry_Blocks.BOX_H_GRAPE, new Item.Properties()));
	/** 6.4.1 **/ public static Item BOX_H_GREENONION = register("block_boxh_greenonion", new Teatime_Fuel100(Pantry_Blocks.BOX_H_GREENONION, new Item.Properties()));
	public static Item BOX_H_ONION = register("block_boxh_onion", new Teatime_Fuel100(Pantry_Blocks.BOX_H_ONION, new Item.Properties()));
	public static Item BOX_H_RICE = register("block_boxh_rice", new Teatime_Fuel100(Pantry_Blocks.BOX_H_RICE, new Item.Properties()));
	public static Item BOX_H_SOY = register("block_boxh_soy", new Teatime_Fuel100(Pantry_Blocks.BOX_H_SOY, new Item.Properties()));
	public static Item BOX_H_SPINACH = register("block_boxh_spinach", new Teatime_Fuel100(Pantry_Blocks.BOX_H_SPINACH, new Item.Properties()));
	public static Item BOX_H_TOMATO = register("block_boxh_tomato", new Teatime_Fuel100(Pantry_Blocks.BOX_H_TOMATO, new Item.Properties()));
	public static Item BOX_H_CHERRY = register("block_boxh_cherry", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CHERRY, new Item.Properties()));
	public static Item BOX_H_TAKENOKO = register("block_boxh_takenoko", new Teatime_Fuel100(Pantry_Blocks.BOX_H_TAKENOKO, new Item.Properties()));
	public static Item BOX_H_KURI = register("block_boxh_chestnut", new Teatime_Fuel100(Pantry_Blocks.BOX_H_KURI, new Item.Properties()));
	public static Item BOX_H_TGREEN = register("block_boxh_tgreen", new Teatime_Fuel100(Pantry_Blocks.BOX_H_TGREEN, new Item.Properties()));
	public static Item BOX_H_TRED = register("block_boxh_tred", new Teatime_Fuel100(Pantry_Blocks.BOX_H_TRED, new Item.Properties()));
	
	public static Item BOX_H_BPEPPER = register("block_boxh_bpepper", new Teatime_Fuel100(Pantry_Blocks.BOX_H_BPEPPER, new Item.Properties()));
	public static Item BOX_H_CUMIN = register("block_boxh_cumin", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CUMIN, new Item.Properties()));
	public static Item BOX_H_TURMERIC = register("block_boxh_turmeric", new Teatime_Fuel100(Pantry_Blocks.BOX_H_TURMERIC, new Item.Properties()));
	public static Item BOX_H_CHILI = register("block_boxh_chili", new Teatime_Fuel100(Pantry_Blocks.BOX_H_CHILI, new Item.Properties()));
	
	public static Item CHADUTSU = register("block_tea_chadutsu", new Teatime_noFuel(Pantry_Blocks.CHADUTSU, new Item.Properties()));
	public static Item CANTEA = register("block_tea_can", new Teatime_noFuel(Pantry_Blocks.CANTEA, new Item.Properties()));
	public static Item TAWARA = register("block_tawara_cm", new Teatime_Fuel200(Pantry_Blocks.TAWARA, new Item.Properties()));

	/* Barrel */
	public static Item KOUBOBOT_full = register("block_bin_koubo_f", new Teatime_noFuel(Hakkou_Blocks.KOUBOBOT_full, new Item.Properties()));
	public static Item NYUSANBOT_full = register("block_bin_nyusan_f", new Teatime_noFuel(Hakkou_Blocks.NYUSANBOT_full, new Item.Properties()));
	public static Item KOUBO = register("item_koubo", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.GLASS_BOTTLE)));
	public static Item NYUSAN = register("item_nyusan", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.GLASS_BOTTLE)));

	public static Item MIZUOKE = register("block_mizuoke", new Mizuoke_Item(Fluids.EMPTY, Hakkou_Blocks.MIZUOKE, new Item.Properties()));
	public static Item MIZUOKE_full = register("block_mizuoke_full", new Mizuoke_Item(Fluids.WATER, Hakkou_Blocks.MIZUOKE_full, new Item.Properties().containerItem(Items_Teatime.MIZUOKE)));
	public static Item MIZUOKE_Milk = register("item_mizuoke_milk", new MizuokeMilk_Item(new Item.Properties().containerItem(Items_Teatime.MIZUOKE)));

	public static Item HAKKOU_TARU = register("block_taru_hakkou", new Teatime_noFuel(Hakkou_Blocks.HAKKOU_TARU, new Item.Properties()));
	public static Item KOUJI_TARU = register("block_taru_kouji_f", new Teatime_noFuel(Hakkou_Blocks.KOUJI_TARU, new Item.Properties()));
	public static Item SHUBO_TARU = register("block_taru_shubo_f", new Teatime_noFuel(Hakkou_Blocks.SHUBO_TARU, new Item.Properties()));
	public static Item MOROMI_TARU = register("block_taru_moromi_f", new Teatime_noFuel(Hakkou_Blocks.MOROMI_TARU, new Item.Properties()));
	public static Item JUKUSEI_TARU = register("block_taru_jukusei_f", new Teatime_noFuel(Hakkou_Blocks.JUKUSEI_TARU, new Item.Properties()));
	public static Item RINGOSHU_TARU = register("block_taru_ringoshu_f", new Teatime_noFuel(Hakkou_Blocks.RINGOSHU_TARU, new Item.Properties()));
	public static Item BUDOUSHU_TARU = register("block_taru_budoushu_f", new Teatime_noFuel(Hakkou_Blocks.BUDOUSHU_TARU, new Item.Properties()));
	public static Item HACHIMITSU_TARU = register("block_taru_hachimitsushu_f", new Teatime_noFuel(Hakkou_Blocks.HACHIMITSU_TARU, new Item.Properties()));

	/* Bottle */
	public static Item NAMASAKEBOT = register("block_bot_sakenama_1", new Teatime_noFuel(Hakkou_Blocks.NAMASAKEBOT, new Item.Properties()));
	public static Item SAKEBOT = register("block_bot_sake_1", new Teatime_noFuel(Hakkou_Blocks.SAKEBOT, new Item.Properties()));
	public static Item JUKUSAKEBOT = register("block_bot_sakejuku_1", new Teatime_noFuel(Hakkou_Blocks.JUKUSAKEBOT, new Item.Properties()));
	public static Item NABEAMAZAKE_nama = register("block_food_nabeaz_n", new Teatime_noFuel(Hakkou_Blocks.NABEAMAZAKE_nama, new Item.Properties()));
	public static Item NABEAMAZAKE = register("block_food_nabeaz_1", new Teatime_noFuel(Hakkou_Blocks.NABEAMAZAKE, new Item.Properties()));
	public static Item CIDERBOT = register("block_bot_cider_1", new Teatime_noFuel(Hakkou_Blocks.CIDERBOT, new Item.Properties()));
	public static Item JUKUCIDERBOT = register("block_bot_ciderjuku_1", new Teatime_noFuel(Hakkou_Blocks.JUKUCIDERBOT, new Item.Properties()));
	public static Item WINEBOT = register("block_bot_wine_1", new Teatime_noFuel(Hakkou_Blocks.WINEBOT, new Item.Properties()));
	public static Item JUKUWINEBOT = register("block_bot_winejuku_1", new Teatime_noFuel(Hakkou_Blocks.JUKUWINEBOT, new Item.Properties()));
	public static Item MEADBOT = register("block_bot_mead_1", new Teatime_noFuel(Hakkou_Blocks.MEADBOT, new Item.Properties()));
	public static Item JUKUMEADBOT = register("block_bot_meadjuku_1", new Teatime_noFuel(Hakkou_Blocks.JUKUMEADBOT, new Item.Properties()));

	/* Glass */
	public static Item NAMASAKEGLASS = register("block_glass_sakenama", new SakeGlass(Hakkou_Blocks.NAMASAKEGLASS, new Item.Properties()));
	public static Item SAKEGLASS = register("block_glass_sake", new SakeGlass(Hakkou_Blocks.SAKEGLASS, new Item.Properties()));
	public static Item JUKUSAKEGLASS = register("block_glass_sakejuku", new SakeGlass(Hakkou_Blocks.JUKUSAKEGLASS, new Item.Properties()));
	public static Item AMAZAKEGLASS = register("block_glass_amazake", new SakeGlass(Hakkou_Blocks.AMAZAKEGLASS, new Item.Properties()));
	public static Item CIDERGLASS = register("block_glass_cider", new SakeGlass(Hakkou_Blocks.CIDERGLASS, new Item.Properties()));
	public static Item JUKUCIDERGLASS = register("block_glass_ciderjuku", new SakeGlass(Hakkou_Blocks.JUKUCIDERGLASS, new Item.Properties()));
	public static Item WINEGLASS = register("block_glass_wine", new SakeGlass(Hakkou_Blocks.WINEGLASS, new Item.Properties()));
	public static Item JUKUWINEGLASS = register("block_glass_winejuku", new SakeGlass(Hakkou_Blocks.JUKUWINEGLASS, new Item.Properties()));
	public static Item MEADGLASS = register("block_glass_mead", new SakeGlass(Hakkou_Blocks.MEADGLASS, new Item.Properties()));
	public static Item JUKUMEADGLASS = register("block_glass_meadjuku", new SakeGlass(Hakkou_Blocks.JUKUMEADGLASS, new Item.Properties()));

	public static Item WINE_TANA = register("block_kit2_tana", new Teatime_Fuel150(Hakkou_Blocks.WINE_TANA, new Item.Properties()));

	public static Item MISO_TARU = register("block_taru_miso_f", new Teatime_noFuel(Hakkou_Blocks.MISO_TARU, new Item.Properties()));
	public static Item HAKUSAI_TARU1 = register("block_taru_hakusai_f", new Teatime_noFuel(Hakkou_Blocks.HAKUSAI_TARU1, new Item.Properties()));
	public static Item HAKUSAI_TARU2 = register("block_taru_hakusai_f2", new Teatime_noFuel(Hakkou_Blocks.HAKUSAI_TARU2, new Item.Properties()));
	public static Item SHOUYU_TARU = register("block_taru_shouyu_f", new Teatime_noFuel(Hakkou_Blocks.SHOUYU_TARU, new Item.Properties()));
	public static Item KOMEZU_TARU = register("block_taru_komezu_f", new Teatime_noFuel(Hakkou_Blocks.KOMEZU_TARU, new Item.Properties()));
	public static Item KINOKO_TARU = register("block_taru_kinoko_f", new Teatime_noFuel(Hakkou_Blocks.KINOKO_TARU, new Item.Properties()));
	public static Item KONBU_TARU = register("block_taru_konbu_f", new Teatime_noFuel(Hakkou_Blocks.KONBU_TARU, new Item.Properties()));
	public static Item NORI_TARU = register("block_taru_nori_f", new Teatime_noFuel(Hakkou_Blocks.NORI_TARU, new Item.Properties()));
	public static Item KOUCHA_TARU = register("block_taru_koucha_f", new Teatime_noFuel(Hakkou_Blocks.KOUCHA_TARU, new Item.Properties()));
	public static Item PEPPER_TARU = register("block_taru_pepper_f", new Teatime_noFuel(Hakkou_Blocks.PEPPER_TARU, new Item.Properties()));

	public static Item SHOUYU_bot_1 = register("block_shouyu_bot", new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_1, new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_NoTab.SHOUYU_bot_2)));
	public static Item KOMEZU_bot_1 = register("block_komezu_bot", new HakkouItem_Tips(Hakkou_Blocks.KOMEZU_bot_1, new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_NoTab.KOMEZU_bot_2)));
	public static Item DASHI_bot_1 = register("block_dashi_bot", new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_1, new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_NoTab.DASHI_bot_2)));
	public static Item OSAUCE_bot_1 = register("block_osauce_bot", new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_1, new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_NoTab.OSAUCE_bot_2)));
	public static Item MAYO_bot_1 = register("block_mayo_bot", new HakkouItem_Tips(Dish_Blocks.MAYO_bot_1, new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_NoTab.MAYO_bot_2)));

	public static Item MATCH = register("item_match_cm", new Match_Item(new Item.Properties()));

	public static Item SARA = register("item_food_sara", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item YUNOMI = register("item_food_yunomi", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item TCUP_kara = register("item_food_teacup", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CHAWAN = register("item_food_chawan", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHIKKI = register("item_food_shikki", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item TONSUI = register("item_food_tonsui", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item DONBURI = register("item_food_donburi", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item DRINKGLASS = register("item_food_driglass", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SAKEBOTTLE = register("item_food_sakebot", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item BENTOUHAKO = register("item_bentouhako", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	
	public static Item CLAY_SARA = register("item_clay_sara", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_YUNOMI = register("item_clay_yunomi", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_KYUSU = register("item_clay_kyusu", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_TCUP = register("item_clay_teacup", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_TPOT = register("item_clay_teapot", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_CHAWAN = register("item_clay_chawan", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_NABE = register("item_clay_nabe", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_TONSUI = register("item_clay_tonsui", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item CLAY_DONBURI = register("item_clay_donburi", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	/* Salt */
	public static Item SHIO = register("item_salt", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item NIGARI = register("item_nigari", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item RENNET = register("item_rennet", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item MUSHIGOME = register("item_mushigome", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.BOWL)));
	public static Item MUSHIGOME_TAKE = register("item_mushigome_take", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.BOWL)));
	public static Item MUSHIGOME_KURI = register("item_mushigome_kuri", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.BOWL)));
	public static Item KOMEKOUJI = register("item_komekouji", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHUBO = register("item_shubo", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.BOWL)));
	public static Item SAKEKASU = register("item_sakekasu", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.BOWL)));
	public static Item MOROMI = register("item_moromi", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_Teatime.SAKEKASU)));

	public static Item NIMAME = register("item_nimame", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items.BOWL)));
	public static Item MISO = register("item_miso", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item KOMUGI = register("item_flour", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item BUTTER = register("item_butter", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KIJI_BUN = register("item_kiji_bun", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KIJI_BURG = register("item_kiji_burg", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KIJI_SCONE= register("item_kiji_scone", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KIJI_SENBEI = register("item_kiji_senbei", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KIJI_PIZA = register("item_kiji_pizza", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PIZZA_nama = register("item_food_pizza_n", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PIZZAC_nama = register("item_food_pizza_cn", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PIZZAT_nama = register("item_food_pizza_tn", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PIZZAS_nama = register("item_food_pizza_sn", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	
	public static Item PASTA_nama = register("item_food_pasta_n", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item PASTA_sara = register("item_food_pasta_s", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item UDON_nama = register("item_food_udon_n", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHOUYU_donburi = register("item_food_shouyu_don", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item TSUYU_donburi = register("item_food_tsuyu_don", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	/** 6.4.1 **/
	public static Item KEIRYO_CUP = register("block_measurecup", new MeasureCup_Item(Fluids.EMPTY, Dish_Blocks.KEIRYO_CUP, new Item.Properties()));
	public static Item KEIRYO_CUP_full = register("item_measurecup_full", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_Teatime.KEIRYO_CUP)));
	public static Item KANSUI = register("item_kansui", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_Teatime.KEIRYO_CUP)));
	public static Item RAMEN_nama = register("item_food_ramen_n", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHOUYU_TARE = register("item_food_tare_shouyu", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item MISO_TARE = register("item_food_tare_miso", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHIO_TARE = register("item_food_tare_shio", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHOUYU_Rsoup = register("item_food_rsoup_shouyu", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item MISO_Rsoup = register("item_food_rsoup_miso", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SHIO_Rsoup = register("item_food_rsoup_shio", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item SOBA_PLATE = register("item_food_sobaplate", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	/* Cooking */
	public static Item ZUNDOU = register("block_food_zundou", new ZundouKara_Item(Dish_Blocks.ZUNDOU, new Item.Properties()));
	public static Item ZUNDOU_MIZU = register("block_zundou_mizu", new Teatime_noFuel(Dish_Blocks.ZUNDOU_MIZU, new Item.Properties()));
	public static Item ZUNDOU_SHIO = register("block_zundou_shiomizu", new Teatime_noFuel(Dish_Blocks.ZUNDOU_SHIO, new Item.Properties()));
	public static Item ZUNDOU_MILK = register("block_zundou_milk", new Teatime_noFuel(Dish_Blocks.ZUNDOU_MILK, new Item.Properties()));

	public static Item ZUNDOU_NCURRY = register("block_food_cunabe_n", new Teatime_noFuel(Dish_Blocks.ZUNDOU_NCURRY, new Item.Properties()));
	public static Item ZUNDOU_CURRY = register("block_food_cunabe_1", new Teatime_noFuel(Dish_Blocks.ZUNDOU_CURRY, new Item.Properties()));
	public static Item ZUNDOU_NCURRY_C = register("block_food_cunabe_cn", new Teatime_noFuel(Dish_Blocks.ZUNDOU_NCURRY_C, new Item.Properties()));
	public static Item ZUNDOU_CURRY_C = register("block_food_cunabe_c1", new Teatime_noFuel(Dish_Blocks.ZUNDOU_CURRY_C, new Item.Properties()));
	public static Item ZUNDOU_NCURRY_T = register("block_food_cunabe_tn", new Teatime_noFuel(Dish_Blocks.ZUNDOU_NCURRY_T, new Item.Properties()));
	public static Item ZUNDOU_CURRY_T = register("block_food_cunabe_t1", new Teatime_noFuel(Dish_Blocks.ZUNDOU_CURRY_T, new Item.Properties()));

	public static Item ZUNDOU_NSTEW = register("block_food_stewnabe_n", new Teatime_noFuel(Dish_Blocks.ZUNDOU_NSTEW, new Item.Properties()));
	public static Item ZUNDOU_STEW = register("block_food_stewnabe_1", new Teatime_noFuel(Dish_Blocks.ZUNDOU_STEW, new Item.Properties()));
	public static Item ZUNDOU_DASHI = register("block_food_dashinabe_1", new Teatime_noFuel(Dish_Blocks.ZUNDOU_DASHI, new Item.Properties()));
	/** 6.4.1 **/
	public static Item ZUNDOU_RSOUP_nama = register("block_food_rsoup_n", new Teatime_noFuel(Dish_Blocks.ZUNDOU_RSOUP_nama, new Item.Properties()));
	public static Item ZUNDOU_RSOUP = register("block_food_rsoup_1", new Teatime_noFuel(Dish_Blocks.ZUNDOU_RSOUP, new Item.Properties()));

	public static Item NABE_kara = register("block_food_karanabe", new DonabeKara_Item(Fluids.EMPTY, Dish_Blocks.NABE_kara, new Item.Properties()));
	public static Item NABETORI_nama = register("block_food_nabe_n", new Teatime_noFuel(Dish_Blocks.NABETORI_nama, new Item.Properties()));
	public static Item NABEMISO_nama = register("block_food_nabemiso_n", new Teatime_noFuel(Dish_Blocks.NABEMISO_nama, new Item.Properties()));
	public static Item NABEGOHAN_nama = register("block_food_nabegohan_n", new Teatime_noFuel(Dish_Blocks.NABEGOHAN_nama, new Item.Properties()));
	public static Item NABEGOHANTAKE_nama = register("block_food_nabegohantake_n", new Teatime_noFuel(Dish_Blocks.NABEGOHANTAKE_nama, new Item.Properties()));
	public static Item NABEGOHANKURI_nama = register("block_food_nabegohankuri_n", new Teatime_noFuel(Dish_Blocks.NABEGOHANKURI_nama, new Item.Properties()));
	public static Item NABECORN_nama = register("block_food_nabecorns_n", new Teatime_noFuel(Dish_Blocks.NABECORN_nama, new Item.Properties()));
	public static Item NABESHIO_nama = register("block_food_nabeshio_n", new Teatime_noFuel(Dish_Blocks.NABESHIO_nama, new Item.Properties()));
	public static Item NABENIMAME_nama = register("block_food_nabenimame_n", new Teatime_noFuel(Dish_Blocks.NABENIMAME_nama, new Item.Properties()));
	public static Item NABETOUFU_nama = register("block_food_nabetoufu_n", new Teatime_noFuel(Dish_Blocks.NABETOUFU_nama, new Item.Properties()));

	public static Item NABETORI = register("block_food_nabe_1", new Teatime_noFuel(Dish_Blocks.NABETORI, new Item.Properties()));
	public static Item NABEMISO = register("block_food_nabemiso_1", new Teatime_noFuel(Dish_Blocks.NABEMISO, new Item.Properties()));
	public static Item NABEGOHAN = register("block_food_nabegohan_1", new Teatime_noFuel(Dish_Blocks.NABEGOHAN, new Item.Properties()));
	public static Item NABEGOHAN_TAKE = register("block_food_nabegohantake_1", new Teatime_noFuel(Dish_Blocks.NABEGOHAN_TAKE, new Item.Properties()));
	public static Item NABEGOHAN_KURI = register("block_food_nabegohankuri_1", new Teatime_noFuel(Dish_Blocks.NABEGOHAN_KURI, new Item.Properties()));
	public static Item NABECORN = register("block_food_nabecorns_1", new Teatime_noFuel(Dish_Blocks.NABECORN, new Item.Properties()));

	public static Item FRYPAN_kara = register("block_food_frypan", new Teatime_noFuel(Dish_Blocks.FRYPAN_kara, new Item.Properties()));
	public static Item FPTAMAGO_nama = register("block_food_frypan_n_tamago", new Teatime_noFuel(Dish_Blocks.FPTAMAGO_nama, new Item.Properties()));
	public static Item FPGYUDON_nama = register("block_food_frypan_n_gyudon", new Teatime_noFuel(Dish_Blocks.FPGYUDON_nama, new Item.Properties()));
	public static Item FPOYAKODON_nama = register("block_food_frypan_n_oyakodon", new Teatime_noFuel(Dish_Blocks.FPOYAKODON_nama, new Item.Properties()));
	public static Item FPKATSU_nama = register("block_food_frypan_n_katsu", new Teatime_noFuel(Dish_Blocks.FPKATSU_nama, new Item.Properties()));
	public static Item FPKATSU_bake = register("block_food_frypan_b_katsu", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item FPKATSUDON_nama = register("block_food_frypan_n_katsudon", new Teatime_noFuel(Dish_Blocks.FPKATSUDON_nama, new Item.Properties()));
	public static Item FPEGGBURG_nama = register("block_food_frypan_n_eggb", new Teatime_noFuel(Dish_Blocks.FPEGGBURG_nama, new Item.Properties()));
	public static Item FPTOMATO_nama = register("block_food_frypan_n_tomatos", new Teatime_noFuel(Dish_Blocks.FPTOMATO_nama, new Item.Properties()));
	public static Item FPKINOKO_nama = register("block_food_frypan_n_kinokos", new Teatime_noFuel(Dish_Blocks.FPKINOKO_nama, new Item.Properties()));
	public static Item FPSEAFOOD_nama = register("block_food_frypan_n_seafood", new Teatime_noFuel(Dish_Blocks.FPSEAFOOD_nama, new Item.Properties()));
	public static Item FPKINOKOAK_nama = register("block_food_frypan_n_kinokoak", new Teatime_noFuel(Dish_Blocks.FPKINOKOAK_nama, new Item.Properties()));
	public static Item FPKINOKOAK = register("item_food_frypan_b_kinokoak", new AddInfo_Item(new Item.Properties().containerItem(Items_Teatime.FRYPAN_kara).group(ItemGroups_CM.TEATIME)));
	public static Item FPCURRY_nama = register("block_food_frypan_n_roux", new Teatime_noFuel(Dish_Blocks.FPCURRY_nama, new Item.Properties()));
	// 6.3.3
	public static Item FPOSAUCE_nama = register("block_food_frypan_n_osauce", new Teatime_noFuel(Dish_Blocks.FPOSAUCE_nama, new Item.Properties()));
	public static Item OKONOMIYAKI_nama = register("block_food_teppan_n_okonomiyaki", new Teatime_noFuel(Dish_Blocks.OKONOMIYAKI_nama, new Item.Properties()));
	public static Item OKONOMIS_nama = register("block_food_teppan_n_okonomis", new Teatime_noFuel(Dish_Blocks.OKONOMIS_nama, new Item.Properties()));
	public static Item OKONOMIC_nama = register("block_food_teppan_n_okonomic", new Teatime_noFuel(Dish_Blocks.OKONOMIC_nama, new Item.Properties()));
	public static Item OKONOMISOBA_nama = register("block_food_teppan_n_okonomisoba", new Teatime_noFuel(Dish_Blocks.OKONOMISOBA_nama, new Item.Properties()));
	public static Item OKONOMISOBAS_nama = register("block_food_teppan_n_okonomisobas", new Teatime_noFuel(Dish_Blocks.OKONOMISOBAS_nama, new Item.Properties()));
	public static Item OKONOMISOBAC_nama = register("block_food_teppan_n_okonomisobac", new Teatime_noFuel(Dish_Blocks.OKONOMISOBAC_nama, new Item.Properties()));
	public static Item YAKISOBA_nama = register("block_food_teppan_n_yakisoba", new Teatime_noFuel(Dish_Blocks.YAKISOBA_nama, new Item.Properties()));
	public static Item YAKISOBASHIO_nama = register("block_food_teppan_n_yakisobashio", new Teatime_noFuel(Dish_Blocks.YAKISOBASHIO_nama, new Item.Properties()));

	public static Item NIBOSHI = register("block_niboshi", new Teatime_noFuel(Dish_Blocks.NIBOSHI, new Item.Properties()));

	public static Item CURRY = register("block_food_curry_1", new Curry_Item(Dish_Blocks.CURRY, new Item.Properties()));
	public static Item CURRYSET = register("block_food_curryset_1", new Teatime_noFuel(Dish_Blocks.CURRYSET, new Item.Properties()));
	public static Item CURRY_C = register("block_food_curry_c1", new Curry_Item(Dish_Blocks.CURRY_C, new Item.Properties()));
	public static Item CURRYSET_C = register("block_food_curryset_c1", new Teatime_noFuel(Dish_Blocks.CURRYSET_C, new Item.Properties()));
	public static Item CURRY_T = register("block_food_curry_t1", new Curry_Item(Dish_Blocks.CURRY_T, new Item.Properties()));
	public static Item CURRYSET_T = register("block_food_curryset_t1", new Teatime_noFuel(Dish_Blocks.CURRYSET_T, new Item.Properties()));

	public static Item STEW = register("block_food_stew_1", new Dish_addItem(Dish_Blocks.STEW, new Item.Properties()));
	public static Item UDON_SU = register("block_food_udonsu_1", new Dish_Donburi(Dish_Blocks.UDON_SU, new Item.Properties()));
	public static Item UDON_NIKU = register("block_food_udonniku_1", new Dish_Donburi(Dish_Blocks.UDON_NIKU, new Item.Properties()));
	public static Item UDON_TSUKIMI = register("block_food_udontsukimi_1", new Dish_Donburi(Dish_Blocks.UDON_TSUKIMI, new Item.Properties()));
	/** 6.4.1 **/
	public static Item RAMEN_SHOUYU = register("block_food_ramenshouyu_1", new Dish_Donburi(Dish_Blocks.RAMEN_SHOUYU, new Item.Properties()));
	public static Item RAMEN_MISO = register("block_food_ramenmiso_1", new Dish_Donburi(Dish_Blocks.RAMEN_MISO, new Item.Properties()));
	public static Item RAMEN_SHIO = register("block_food_ramenshio_1", new Dish_Donburi(Dish_Blocks.RAMEN_SHIO, new Item.Properties()));

	public static Item TONSUITORI = register("block_food_tonsui_1", new Dish_addItem(Dish_Blocks.TONSUITORI, new Item.Properties()));
	public static Item MISOSOUP = register("block_food_misosp_1", new Dish_addItem(Dish_Blocks.MISOSOUP, new Item.Properties()));
	public static Item GOHAN = register("block_food_gohan_1", new Dish_addItem(Dish_Blocks.GOHAN, new Item.Properties()));
	public static Item GOHAN_TAKE = register("block_food_gohantake_1", new Dish_addItem(Dish_Blocks.GOHAN_TAKE, new Item.Properties()));
	public static Item GOHAN_KURI = register("block_food_gohankuri_1", new Dish_addItem(Dish_Blocks.GOHAN_KURI, new Item.Properties()));
	public static Item RICE = register("block_food_rice_1", new Dish_Plate(Dish_Blocks.RICE, new Item.Properties()));
	public static Item DONBURI_MESHI = register("block_food_donmeshi_1", new Dish_Donburi(Dish_Blocks.DONBURI_MESHI, new Item.Properties()));

	public static Item DONBURI_GYU = register("block_food_dongyu_1", new Dish_Donburi(Dish_Blocks.DONBURI_GYU, new Item.Properties()));
	public static Item DONBURI_OYAKO = register("block_food_donoyako_1", new Dish_Donburi(Dish_Blocks.DONBURI_OYAKO, new Item.Properties()));
	public static Item DONBURI_KATSU = register("block_food_donkatsu_1", new Dish_Donburi(Dish_Blocks.DONBURI_KATSU, new Item.Properties()));
	public static Item DONBURI_KAISEN = register("block_food_donkaisen_1", new Dish_Donburi(Dish_Blocks.DONBURI_KAISEN, new Item.Properties()));

	public static Item FOOD_HAKUSAI2 = register("item_food_hakusai2", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.HAKUSAI2)));
	public static Item HAKUSAIDUKE = register("block_food_hsd_1", new Dish_Plate(Dish_Blocks.HAKUSAIDUKE, new Item.Properties()));
	public static Item TAMAGOYAKI = register("block_food_tgy_1", new Dish_Plate(Dish_Blocks.TAMAGOYAKI, (new Item.Properties()).containerItem(Items_Teatime.SARA)));

	public static Item TAMAGOYAKITEI = register("block_food_tgytei_1", new Teatime_noFuel(Dish_Blocks.TAMAGOYAKITEI, new Item.Properties()));
	public static Item YAKIZAKANATEI = register("block_food_yakizakanatei_1", new Teatime_noFuel(Dish_Blocks.YAKIZAKANATEI, new Item.Properties()));
	public static Item YAKIJYAKETEI = register("block_food_yakijyaketei_1", new Teatime_noFuel(Dish_Blocks.YAKIJYAKETEI, new Item.Properties()));
	public static Item TAMAGOYAKITEI_TAKE = register("block_food_tgyteitake_1", new Teatime_noFuel(Dish_Blocks.TAMAGOYAKITEI_TAKE, new Item.Properties()));
	public static Item YAKIZAKANATEI_TAKE = register("block_food_yakizakanateitake_1", new Teatime_noFuel(Dish_Blocks.YAKIZAKANATEI_TAKE, new Item.Properties()));
	public static Item YAKIJYAKETEI_TAKE = register("block_food_yakijyaketeitake_1", new Teatime_noFuel(Dish_Blocks.YAKIJYAKETEI_TAKE, new Item.Properties()));
	public static Item TAMAGOYAKITEI_KURI = register("block_food_tgyteikuri_1", new Teatime_noFuel(Dish_Blocks.TAMAGOYAKITEI_KURI, new Item.Properties()));
	public static Item YAKIZAKANATEI_KURI = register("block_food_yakizakanateikuri_1", new Teatime_noFuel(Dish_Blocks.YAKIZAKANATEI_KURI, new Item.Properties()));
	public static Item YAKIJYAKETEI_KURI = register("block_food_yakijyaketeikuri_1", new Teatime_noFuel(Dish_Blocks.YAKIJYAKETEI_KURI, new Item.Properties()));
	
	public static Item CORNSOUP = register("block_food_cornsp_1", new Dish_Plate(Dish_Blocks.CORNSOUP, new Item.Properties()));

	public static Item EGGBURG = register("block_food_egb_1", new Dish_Plate(Dish_Blocks.EGGBURG, new Item.Properties()));
	public static Item EGGBURGSET = register("block_food_egbset_1", new Teatime_noFuel(Dish_Blocks.EGGBURGSET, new Item.Properties()));

	public static Item PASTATOMATO = register("block_food_pastatoma_1", new Dish_Plate(Dish_Blocks.PASTATOMATO, new Item.Properties()));
	public static Item PASTACHEESE = register("block_food_pastacheese_1", new Dish_Plate(Dish_Blocks.PASTACHEESE, new Item.Properties()));
	public static Item PASTAKINOKO = register("block_food_pastakinoko_1", new Dish_Plate(Dish_Blocks.PASTAKINOKO, new Item.Properties()));
	public static Item PASTASEAFOOD = register("block_food_pastaseafood_1", new Dish_addItem(Dish_Blocks.PASTASEAFOOD, new Item.Properties()));
	
	public static Item PIZZA = register("block_food_pizza_1", new Teatime_noFuel(Dish_Blocks.PIZZA, new Item.Properties()));
	public static Item PIZZA_C = register("block_food_pizza_c1", new Teatime_noFuel(Dish_Blocks.PIZZA_C, new Item.Properties()));
	public static Item PIZZA_T = register("block_food_pizza_t1", new Teatime_noFuel(Dish_Blocks.PIZZA_T, new Item.Properties()));
	public static Item PIZZA_S = register("block_food_pizza_s1", new Teatime_noFuel(Dish_Blocks.PIZZA_S, new Item.Properties()));
	public static Item PC_PIZZA = register("item_food_pizza", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.PC_PIZZA)));
	public static Item PC_PIZZAC = register("item_food_pizzac", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.PC_PIZZAC)));
	public static Item PC_PIZZAT = register("item_food_pizzat", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.PC_PIZZAT)));
	public static Item PC_PIZZAS = register("item_food_pizzas", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.PC_PIZZAS)));
	public static Item OKONOMIYAKI = register("block_food_okonomiyaki_1", new Dish_Plate(Dish_Blocks.OKONOMIYAKI, new Item.Properties()));
	public static Item OKONOMIS = register("block_food_okonomis_1", new Dish_Plate(Dish_Blocks.OKONOMIS, new Item.Properties()));
	public static Item OKONOMIC = register("block_food_okonomic_1", new Dish_Plate(Dish_Blocks.OKONOMIC, new Item.Properties()));
	public static Item OKONOMISOBA = register("block_food_okonomisoba_1", new Dish_Plate(Dish_Blocks.OKONOMISOBA, new Item.Properties()));
	public static Item OKONOMISOBAS = register("block_food_okonomisobas_1", new Dish_Plate(Dish_Blocks.OKONOMISOBAS, new Item.Properties()));
	public static Item OKONOMISOBAC = register("block_food_okonomisobac_1", new Dish_Plate(Dish_Blocks.OKONOMISOBAC, new Item.Properties()));
	public static Item YAKISOBA = register("block_food_yakisoba_1", new Dish_Plate(Dish_Blocks.YAKISOBA, new Item.Properties()));
	public static Item YAKISOBASHIO = register("block_food_yakisobashio_1", new Dish_Plate(Dish_Blocks.YAKISOBASHIO, new Item.Properties()));

	public static Item CHICKEN = register("block_food_roastchicken_1", new Teatime_noFuel(Dish_Blocks.CHICKEN, new Item.Properties()));
	public static Item CHICKEN_small = register("block_food_chickenb_1", new Dish_Plate(Dish_Blocks.CHICKEN_small, new Item.Properties()));

	public static Item SUSHIMESHI = register("block_food_sushimeshi", new Teatime_noFuel(Dish_Blocks.SUSHIMESHI, (new Item.Properties()).containerItem(Items.BOWL)));
	public static Item SUSHIGETA_kara = register("block_food_sushigeta_kara", new Teatime_noFuel(Dish_Blocks.SUSHIGETA_kara, new Item.Properties()));

	public static Item SUSHISET_salmon = register("block_food_sushiset_salmon", new Teatime_noFuel(Dish_Blocks.SUSHISET_salmon, new Item.Properties()));
	public static Item SUSHISET_fish = register("block_food_sushiset_fish", new Teatime_noFuel(Dish_Blocks.SUSHISET_fish, new Item.Properties()));
	public static Item SUSHISET_beef = register("block_food_sushiset_beef", new Teatime_noFuel(Dish_Blocks.SUSHISET_beef, new Item.Properties()));
	public static Item SUSHISET_tamago = register("block_food_sushiset_tamago", new Teatime_noFuel(Dish_Blocks.SUSHISET_tamago, new Item.Properties()));
	public static Item SUSHISET_4shoku = register("block_food_sushiset_4shoku", new Teatime_noFuel(Dish_Blocks.SUSHISET_4shoku, new Item.Properties()));

	public static Item SUSHIOKE = register("block_food_sushioke_kara", new Teatime_noFuel(Dish_Blocks.SUSHIOKE, new Item.Properties()));
	public static Item SUSHIOKE_FULL_1 = register("block_food_sushiokefull_1", new Teatime_noFuel(Dish_Blocks.SUSHIOKE_FULL_1, new Item.Properties()));
	public static Item SHOUYUSARA_1 = register("block_food_shouyusara_1", new Teatime_noFuel(Dish_Blocks.SHOUYUSARA_1, new Item.Properties()));

	public static Item KETTLE_kara = register("item_kettle_kara", new Teatime_noFuel(Dish_Blocks.KETTLE_kara, new Item.Properties()));
	public static Item KETTLE_full = register("block_kettle_full", new Teatime_noFuel(Dish_Blocks.KETTLE_full, new Item.Properties()));
	public static Item KETTLE_boil = register("item_kettle_boil", new Item(new Item.Properties().containerItem(Items_Teatime.KETTLE_kara).group(ItemGroups_CM.TEATIME)));

	public static Item KYUSU_kara = register("block_food_kyusu", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KYUSU = register("block_food_kyusu_1", new Teatime_noFuel(Dish_Blocks.KYUSU, new Item.Properties()));
	public static Item JPTEACUP = register("block_food_jpteacup_1", new Dish_always(Dish_Blocks.JPTEACUP, new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item JPTEASET = register("block_food_jpteaset_1", new Teatime_noFuel(Dish_Blocks.JPTEASET, new Item.Properties()));
	public static Item CHAUKE_SENBEI = register("block_food_senbei", new Teatime_noFuel(Dish_Blocks.CHAUKE_SENBEI, new Item.Properties()));
	public static Item CHAUKE_MIKAN = register("block_food_mikan", new Teatime_noFuel(Dish_Blocks.CHAUKE_MIKAN, new Item.Properties()));

	public static Item TEAPOT_kara = register("block_food_teapot", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item TEAPOT = register("block_food_teapot_1", new Teatime_noFuel(Dish_Blocks.TEAPOT, new Item.Properties()));
	public static Item TEACUP = register("block_food_teacup_1", new TeaCup_Item(Dish_Blocks.TEACUP, new Item.Properties()));

	public static Item TEASET = register("block_food_teaset_1", new Teatime_noFuel(Dish_Blocks.TEASET, new Item.Properties()));
	public static Item CHAUKE_SCONE = register("block_food_scone", new Teatime_noFuel(Dish_Blocks.CHAUKE_SCONE, new Item.Properties()));

	public static Item SCONESET_kara = register("block_food_teastand", new Teatime_noFuel(Dish_Blocks.SCONESET_kara, new Item.Properties()));
	public static Item SCONESET_1 = register("block_food_sconeset_1", new Teatime_noFuel(Dish_Blocks.SCONESET_1, new Item.Properties()));

	public static Item ICECREAM = register("block_food_icecream_1", new Dish_always(Dish_Blocks.ICECREAM, (new Item.Properties()).group(ItemGroups_CM.TEATIME)));

	public static Item CHEESE_CURD = register("block_food_cheesecurd", new Teatime_noFuel(Hakkou_Blocks.CHEESE_CURD, new Item.Properties()));
	public static Item CHEESE = register("block_food_cheese_1", new Teatime_noFuel(Hakkou_Blocks.CHEESE, new Item.Properties()));
	public static Item FCHEESE = register("item_food_cheesef", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.FCHEESE)));
	public static Item PC_CHEESE = register("item_food_cheese", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.PC_CHEESE)));
	public static Item CHEESE_TANA = register("block_kit_cheese_tana", new Teatime_Fuel150(Hakkou_Blocks.CHEESE_TANA, new Item.Properties()));

	/* FOOD */
	public static Item CAKE = register("item_food_cake", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.CAKE)));
	public static Item BUN = register("item_food_bun", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.BUN)));
	public static Item SCONE = register("item_food_scone", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SCONE)));
	public static Item SENBEI = register("item_food_senbei", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SENBEI)));
	public static Item TOUFU = register("item_food_toufu", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.TOUFU)));

	public static Item CHICKENSAND = register("item_food_chickensand", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.CHICKENSAND)));
	public static Item EGGSAND = register("item_food_eggsand", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.EGGSAND)));

	public static Item KIRIMI_S = register("item_food_kirimi_salmon", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.KIRIMI)));
	public static Item KIRIMI_F = register("item_food_kirimi_fish", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.KIRIMI)));
	public static Item KIRIMI_B = register("item_food_kirimi_beef", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.KIRIMI)));
	public static Item KIRIMI_T = register("item_food_kirimi_tamago", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.KIRIMI)));

	public static Item SUSHI_S = register("item_food_sushi_salmon", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SUSHI)));
	public static Item SUSHI_F = register("item_food_sushi_fish", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SUSHI)));
	public static Item SUSHI_B = register("item_food_sushi_beef", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SUSHI)));
	public static Item SUSHI_T = register("item_food_sushi_tamago", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SUSHI)));

	public static Item SHOUYUSUSHI_S = register("item_food_sushishouyu_salmon", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SHOUYUSUSHI_S)));
	public static Item SHOUYUSUSHI_F = register("item_food_sushishouyu_fish", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SHOUYUSUSHI_F)));
	public static Item SHOUYUSUSHI_B = register("item_food_sushishouyu_beef", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SHOUYUSUSHI_B)));
	public static Item SHOUYUSUSHI_T = register("item_food_sushishouyu_tamago", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.SHOUYUSUSHI_T)));

	public static Item NORIAMI = register("block_noriami", new Teatime_noFuel(Crop_Blocks.NORIAMI, new Item.Properties()));
	public static Item NORI_N = register("item_food_norinama", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item NORI_I = register("item_food_noriita", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.NORI_I)));
	public static Item ONIGIRI = register("item_food_onigiri", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.ONIGIRI)));
	public static Item ONIGIRI_SHAKE = register("item_food_onigirishake", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.ONIGIRISHAKE)));
	public static Item ONIGIRI_TAKE = register("item_food_onigiritakenoko", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.ONIGIRI_TAKEKURI)));
	public static Item ONIGIRI_KURI = register("item_food_onigirikuri", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.ONIGIRI_TAKEKURI)));
	public static Item FUTOMAKI = register("item_food_futomaki", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.FUTOMAKI)));

	public static Item KUSHI_SAKANA = register("item_kushi_sakana", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item KUSHI_SAKANA_C = register("item_kushi_sakana_c", new FoodNeed_addItem(new Item.Properties().group(ItemGroups_CM.TEATIME)));

	public static Item BENTOU = register("item_bentou", new Bentou(new Item.Properties()));
	public static Item SHAKEBEN = register("item_bentoushake", new Bentou(new Item.Properties()));
	public static Item BENTOU_TAKE = register("item_bentou_take", new Bentou(new Item.Properties()));
	public static Item SHAKEBEN_TAKE = register("item_bentoushake_take", new Bentou(new Item.Properties()));
	public static Item BENTOU_KURI = register("item_bentou_kuri", new Bentou(new Item.Properties()));
	public static Item SHAKEBEN_KURI = register("item_bentoushake_kuri", new Bentou(new Item.Properties()));
	
	public static Item MOCHI = register("item_mochi", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item MOCHI_NORI = register("item_food_mochinori", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.MOCHI)));
	public static Item MOCHI_KINAKO = register("item_food_mochikinako", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.MOCHI)));

	
	/* Kitchen */
	public static Item KIT_TANA = register("block_kit_tana", new Teatime_Fuel150(Kitchen_Blocks.KIT_TANA, new Item.Properties()));
	public static Item KITCHEN = register("block_kitchen", new Teatime_Fuel150(Kitchen_Blocks.KITCHEN, new Item.Properties()));

	public static Item KIT_BOARD = register("block_kit_board", new Teatime_Fuel300(Kitchen_Blocks.KIT_BOARD, new Item.Properties()));
	public static Item KIT_SINK = register("block_kit_sink", new Teatime_noFuel(Kitchen_Blocks.KIT_SINK, new Item.Properties()));

	public static Item KIT_COOKTOP = register("block_kit_stove", new Teatime_noFuel(Kitchen_Blocks.KIT_COOKTOP, new Item.Properties()));
	public static Item KIT_OVEN = register("block_kit_oven", new Teatime_noFuel(Kitchen_Blocks.KIT_OVEN, new Item.Properties()));
	public static Item KIT_OVEN_B = register("block_kit_oven_black", new Teatime_noFuel(Kitchen_Blocks.KIT_OVEN_B, new Item.Properties()));
	public static Item IRORI = register("block_irori", new Teatime_noFuel(Kitchen_Blocks.IRORI, new Item.Properties()));
	public static Item KIT_REIZOU = register("block_kit_reizou", new Teatime_noFuel(Kitchen_Blocks.KIT_REIZOU, new Item.Properties()));

	public static Item KIT_KANKI_1 = register("block_kit_kanki", new Teatime_noFuel(Kitchen_Blocks.KIT_KANKI_1, new Item.Properties()));
	public static Item KIT_HAIKIDUCT = register("block_kit_duct", new Teatime_noFuel(Kitchen_Blocks.KIT_HAIKIDUCT, new Item.Properties()));
	public static Item KIT_DUCTEND_1 = register("block_kit_ductend", new Teatime_noFuel(Kitchen_Blocks.KIT_DUCTEND_1, new Item.Properties()));

	public static Item TEATABLE = register("block_teatable", new Teatime_Fuel300(Unit_Blocks.TEATABLE, new Item.Properties()));
	public static Item ENDEN = register("block_enden", new Teatime_noFuel(Crop_Blocks.ENDEN, new Item.Properties()));
	public static Item TOAMI = register("item_toami", new Toami_Item(Crop_Blocks.TOAMI, new Item.Properties().maxStackSize(1).maxDamage(32).group(ItemGroups_CM.TEATIME)));
	public static Item SHIKAKE_AMI = register("block_ami_shikake", new AmiShikake_Item(Crop_Blocks.SHIKAKE_AMI, new Item.Properties().maxStackSize(1).maxDamage(12)));
	public static Item YOUSHOKU_AMI = register("block_ami_youshoku", new AmiYoushoku_Item(Crop_Blocks.YOUSHOKU_AMI, new Item.Properties().maxStackSize(1).maxDamage(12)));
	
	public static Item CUT_IKA = register("item_squid_cut", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.CUT_IKA)));
	public static Item COOKED_IKA = register("item_squid_cooked", new Item(new Item.Properties().group(ItemGroups_CM.TEATIME).food(FoodBuilders.COOKED_IKA)));
	public static Item IKA = register("item_squid_raw", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.TEATIME).containerItem(Items_Teatime.CUT_IKA)));	
	
	public static Item KAIHORI = register("item_kaihori", new Kaihori_Item(new Item.Properties().maxDamage(256)));
	public static Item HAMAGURI_COOK = register("item_food_hamaguri", new FoodNeed_addItem(new Item.Properties().group(ItemGroups_CM.TEATIME)));
	public static Item HAMAGURI = register("block_hamaguri", new Teatime_noFuel(Crop_Blocks.HAMAGURI, new Item.Properties()));
	
	public static Item KINE_YOKO = register("item_kineyoko", new KineTsuki_Item(new Item.Properties().maxDamage(128).group(ItemGroups_CM.TEATIME)));
	public static Item USU_TSUKI = register("block_usutsuki", new Teatime_Fuel300(Kitchen_Blocks.USU_TSUKI, new Item.Properties()));

	
	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}

}
