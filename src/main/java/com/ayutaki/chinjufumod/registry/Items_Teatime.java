package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
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
import com.ayutaki.chinjufumod.items.fuel.Fuel_100;
import com.ayutaki.chinjufumod.items.fuel.Fuel_150;
import com.ayutaki.chinjufumod.items.fuel.Fuel_200;
import com.ayutaki.chinjufumod.items.fuel.Fuel_300;
import com.ayutaki.chinjufumod.items.hakkou.HakkouItem_Tips;
import com.ayutaki.chinjufumod.items.hakkou.MizuokeMilk_Item;
import com.ayutaki.chinjufumod.items.hakkou.Mizuoke_Item;
import com.ayutaki.chinjufumod.items.hakkou.SakeGlass;
import com.ayutaki.chinjufumod.items.teatime.AmiShikake_Item;
import com.ayutaki.chinjufumod.items.teatime.AmiYoushoku_Item;
import com.ayutaki.chinjufumod.items.teatime.Kaihori_Item;
import com.ayutaki.chinjufumod.items.teatime.KineYoko_Item;
import com.ayutaki.chinjufumod.items.teatime.Match_Item;
import com.ayutaki.chinjufumod.items.teatime.MeasureCup_Item;
import com.ayutaki.chinjufumod.items.teatime.Toami_Item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items_Teatime {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Item> SEEDSBOX = register("block_seedsbox", () -> new ItemNameBlockItem(Crop_Blocks.SEEDSBOX.get(), new Item.Properties()));

	public static final RegistryObject<Item> SEEDS_CABBAGE = register("item_seeds_cabbage", () -> new ItemNameBlockItem(Crop_Blocks.CABBAGE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_HAKUSAI = register("item_seeds_hakusai", () -> new ItemNameBlockItem(Crop_Blocks.HAKUSAI.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_CORN = register("item_seeds_corn", () -> new ItemNameBlockItem(Crop_Blocks.CORN.get(), new Item.Properties()));
	/** 6.4.1 **/ public static final RegistryObject<Item> SEEDS_GREENONION = register("item_seeds_greenonion", () -> new ItemNameBlockItem(Crop_Blocks.GREENONION.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_ONION = register("item_seeds_onion", () -> new ItemNameBlockItem(Crop_Blocks.ONION.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_RICE = register("item_seeds_rice", () -> new ItemNameBlockItem(Crop_Blocks.RICE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_SOY = register("item_seeds_soy", () -> new ItemNameBlockItem(Crop_Blocks.SOY.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_SPINACH = register("item_seeds_spinach", () -> new ItemNameBlockItem(Crop_Blocks.SPINACH.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_TOMATO = register("item_seeds_tomato", () -> new ItemNameBlockItem(Crop_Blocks.TOMATO.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_CHERRY = register("item_seeds_cherry", () -> new ItemNameBlockItem(Crop_Blocks.SAKURA.get(), new Item.Properties()));

	public static final RegistryObject<Item> CHANOKI = register("block_wood_chanoki_nae", () -> new ItemNameBlockItem(Crop_Blocks.CHANOKI.get(), new Item.Properties()));
	public static final RegistryObject<Item> BUDOUNOKI = register("block_wood_grape_nae", () -> new ItemNameBlockItem(Crop_Blocks.BUDOUNOKI.get(), new Item.Properties()));
	public static final RegistryObject<Item> MIKAN = register("block_wood_mikan", () -> new ItemNameBlockItem(Crop_Blocks.MIKAN.get(), new Item.Properties()));
	public static final RegistryObject<Item> HODAGI = register("block_hodagi_a_bot", () -> new ItemNameBlockItem(Crop_Blocks.HODAGI_A_BOT.get(), new Item.Properties()));

	public static final RegistryObject<Item> SEEDS_PEPPER = register("item_seeds_pepper", () -> new ItemNameBlockItem(Crop_Blocks.PEPPER.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_CUMIN = register("item_seeds_cumin", () -> new ItemNameBlockItem(Crop_Blocks.CUMIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_TURMERIC = register("item_seeds_turmeric", () -> new ItemNameBlockItem(Crop_Blocks.TURMERIC.get(), new Item.Properties()));
	public static final RegistryObject<Item> SEEDS_CHILI = register("item_seeds_chilipepper", () -> new ItemNameBlockItem(Crop_Blocks.CHILI.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> CHABA = register("item_chaba", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CHABA_GREEN = register("item_chaba_green", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CHABA_RED = register("item_chaba_red", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> INAGI = register("block_inagi", () -> new ItemNameBlockItem(Crop_Blocks.INAGI.get(), new Item.Properties()));
	public static final RegistryObject<Item> INEWARA = register("item_inewara", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INE = register("item_ine", () -> new Item(new Item.Properties().craftRemainder(Items_Teatime.INEWARA.get())));
	public static final RegistryObject<Item> INE_D = register("item_ine_dry", () -> new Item(new Item.Properties().craftRemainder(Items_Teatime.INEWARA.get())));
	public static final RegistryObject<Item> KOME = register("item_kome", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> SAYA = register("item_saya", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SOY = register("item_soy", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PEPPER_RAW = register("item_crop_pepper", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> PEPPER_DRY = register("item_crop_pepperdry", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CHILIPEPPER = register("item_crop_chilipepper", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> DUST_PEPPER = register("item_dust_blackpepper", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUST_CUMIN = register("item_dust_cumin", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUST_TURMERIC = register("item_dust_turmeric", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DUST_CHILI = register("item_dust_chili", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CURRY_ROUX = register("item_curry_roux", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> FOOD_CABBAGE = register("item_food_cabbage", () -> new Item(new Item.Properties().food(FoodBuilders.CABBAGE)));
	public static final RegistryObject<Item> FOOD_HAKUSAI = register("item_food_hakusai", () -> new Item(new Item.Properties().food(FoodBuilders.HAKUSAI)));
	public static final RegistryObject<Item> FOOD_CHERRY = register("item_food_cherry", () -> new FoodAnytime_addItem(new Item.Properties()));
	public static final RegistryObject<Item> FOOD_MIKAN = register("item_food_mikan", () -> new Item(new Item.Properties().food(FoodBuilders.MIKAN)));
	public static final RegistryObject<Item> FOOD_CORN = register("item_food_corn", () -> new Item(new Item.Properties().food(FoodBuilders.CORN)));
	public static final RegistryObject<Item> FOOD_GRAPE = register("item_food_grape", () -> new Item(new Item.Properties().food(FoodBuilders.GRAPE)));
	/** 6.4.1 **/ public static final RegistryObject<Item> FOOD_GREENONION = register("item_food_greenonion", () -> new Item(new Item.Properties().food(FoodBuilders.GREENONION)));
	public static final RegistryObject<Item> FOOD_ONION = register("item_food_onion", () -> new Item(new Item.Properties().food(FoodBuilders.ONION)));
	public static final RegistryObject<Item> FOOD_SPINACH = register("item_food_spinach", () -> new Item(new Item.Properties().food(FoodBuilders.SPINACH)));
	public static final RegistryObject<Item> FOOD_TOMATO = register("item_food_tomato", () -> new Item(new Item.Properties().food(FoodBuilders.TOMATO)));

	public static final RegistryObject<Item> FOOD_CORN_B = register("item_food_cornb", () -> new Item(new Item.Properties().food(FoodBuilders.CORN_B)));

	public static final RegistryObject<Item> BOX_H_EMPTY = register("block_boxh_empty", () -> new ItemNameBlockItem(Pantry_Blocks.BOX_H_EMPTY.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_APPLE = register("block_boxh_apple", () -> new Fuel_100(Pantry_Blocks.BOX_H_APPLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_BEEF = register("block_boxh_beef", () -> new Fuel_100(Pantry_Blocks.BOX_H_BEEF.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_BEETROOT = register("block_boxh_beetroot", () -> new Fuel_100(Pantry_Blocks.BOX_H_BEETROOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_BREAD = register("block_boxh_bread", () -> new Fuel_100(Pantry_Blocks.BOX_H_BREAD.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CARROT = register("block_boxh_carrot", () -> new Fuel_100(Pantry_Blocks.BOX_H_CARROT.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CHICKEN = register("block_boxh_chicken", () -> new Fuel_100(Pantry_Blocks.BOX_H_CHICKEN.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CHORUS = register("block_boxh_chorus", () -> new Fuel_100(Pantry_Blocks.BOX_H_CHORUS.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_COCO = register("block_boxh_coco", () -> new Fuel_100(Pantry_Blocks.BOX_H_COCO.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_COD = register("block_boxh_cod", () -> new Fuel_100(Pantry_Blocks.BOX_H_COD.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_EGG = register("block_boxh_egg", () -> new Fuel_100(Pantry_Blocks.BOX_H_EGG.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_FISH = register("block_boxh_fish", () -> new Fuel_100(Pantry_Blocks.BOX_H_FISH.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_FLOUR = register("block_boxh_flour", () -> new Fuel_100(Pantry_Blocks.BOX_H_FLOUR.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_MUTTON = register("block_boxh_mutton", () -> new Fuel_100(Pantry_Blocks.BOX_H_MUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_PORK = register("block_boxh_pork", () -> new Fuel_100(Pantry_Blocks.BOX_H_PORK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_POTATO = register("block_boxh_potato", () -> new Fuel_100(Pantry_Blocks.BOX_H_POTATO.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_RABBIT = register("block_boxh_rabbit", () -> new Fuel_100(Pantry_Blocks.BOX_H_RABBIT.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_SALMON = register("block_boxh_salmon", () -> new Fuel_100(Pantry_Blocks.BOX_H_SALMON.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_SWBERRY = register("block_boxh_swberry", () -> new Fuel_100(Pantry_Blocks.BOX_H_SWBERRY.get(), new Item.Properties()));

	public static final RegistryObject<Item> BOX_H_CABBAGE = register("block_boxh_cabbage", () -> new Fuel_100(Pantry_Blocks.BOX_H_CABBAGE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_HAKUSAI = register("block_boxh_hakusai", () -> new Fuel_100(Pantry_Blocks.BOX_H_HAKUSAI.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CITRUS = register("block_boxh_citrus", () -> new Fuel_100(Pantry_Blocks.BOX_H_CITRUS.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CORN = register("block_boxh_corn", () -> new Fuel_100(Pantry_Blocks.BOX_H_CORN.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_GRAPE = register("block_boxh_grape", () -> new Fuel_100(Pantry_Blocks.BOX_H_GRAPE.get(), new Item.Properties()));
	/** 6.4.1 **/ public static final RegistryObject<Item> BOX_H_GREENONION = register("block_boxh_greenonion", () -> new Fuel_100(Pantry_Blocks.BOX_H_GREENONION.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_ONION = register("block_boxh_onion", () -> new Fuel_100(Pantry_Blocks.BOX_H_ONION.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_RICE = register("block_boxh_rice", () -> new Fuel_100(Pantry_Blocks.BOX_H_RICE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_SOY = register("block_boxh_soy", () -> new Fuel_100(Pantry_Blocks.BOX_H_SOY.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_SPINACH = register("block_boxh_spinach", () -> new Fuel_100(Pantry_Blocks.BOX_H_SPINACH.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_TOMATO = register("block_boxh_tomato", () -> new Fuel_100(Pantry_Blocks.BOX_H_TOMATO.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CHERRY = register("block_boxh_cherry", () -> new Fuel_100(Pantry_Blocks.BOX_H_CHERRY.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_TAKENOKO = register("block_boxh_takenoko", () -> new Fuel_100(Pantry_Blocks.BOX_H_TAKENOKO.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_KURI = register("block_boxh_chestnut", () -> new Fuel_100(Pantry_Blocks.BOX_H_KURI.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_TGREEN = register("block_boxh_tgreen", () -> new Fuel_100(Pantry_Blocks.BOX_H_TGREEN.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_TRED = register("block_boxh_tred", () -> new Fuel_100(Pantry_Blocks.BOX_H_TRED.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> BOX_H_BPEPPER = register("block_boxh_bpepper", () -> new Fuel_100(Pantry_Blocks.BOX_H_BPEPPER.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CUMIN = register("block_boxh_cumin", () -> new Fuel_100(Pantry_Blocks.BOX_H_CUMIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_TURMERIC = register("block_boxh_turmeric", () -> new Fuel_100(Pantry_Blocks.BOX_H_TURMERIC.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOX_H_CHILI = register("block_boxh_chili", () -> new Fuel_100(Pantry_Blocks.BOX_H_CHILI.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> CHADUTSU = register("block_tea_chadutsu", () -> new ItemNameBlockItem(Pantry_Blocks.CHADUTSU.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANTEA = register("block_tea_can", () -> new ItemNameBlockItem(Pantry_Blocks.CANTEA.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAWARA = register("block_tawara_cm", () -> new Fuel_200(Pantry_Blocks.TAWARA.get(), new Item.Properties()));

	/* Barrel */
	public static final RegistryObject<Item> KOUBOBOT_full = register("block_bin_koubo_f", () -> new ItemNameBlockItem(Hakkou_Blocks.KOUBOBOT_full.get(), new Item.Properties()));
	public static final RegistryObject<Item> NYUSANBOT_full = register("block_bin_nyusan_f", () -> new ItemNameBlockItem(Hakkou_Blocks.NYUSANBOT_full.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUBO = register("item_koubo", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> NYUSAN = register("item_nyusan", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

	public static final RegistryObject<Item> MIZUOKE = register("block_mizuoke", () -> new Mizuoke_Item(Fluids.EMPTY, Hakkou_Blocks.MIZUOKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> MIZUOKE_full = register("block_mizuoke_full", () -> new Mizuoke_Item(Fluids.WATER, Hakkou_Blocks.MIZUOKE_full.get(), new Item.Properties().craftRemainder(Items_Teatime.MIZUOKE.get())));
	public static final RegistryObject<Item> MIZUOKE_Milk = register("item_mizuoke_milk", () -> new MizuokeMilk_Item(new Item.Properties().craftRemainder(Items_Teatime.MIZUOKE.get())));

	public static final RegistryObject<Item> CHEESE_CURD = register("block_food_cheesecurd", () -> new ItemNameBlockItem(Hakkou_Blocks.CHEESE_CURD.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHEESE = register("block_food_cheese_1", () -> new ItemNameBlockItem(Hakkou_Blocks.CHEESE.get(), new Item.Properties()));
	public static final RegistryObject<Item> FCHEESE = register("item_food_cheesef", () -> new Item(new Item.Properties().food(FoodBuilders.FCHEESE)));
	public static final RegistryObject<Item> PC_CHEESE = register("item_food_cheese", () -> new Item(new Item.Properties().food(FoodBuilders.PC_CHEESE)));
	public static final RegistryObject<Item> CHEESE_TANA = register("block_kit_cheese_tana", () -> new Fuel_150(Hakkou_Blocks.CHEESE_TANA.get(), new Item.Properties()));

	public static final RegistryObject<Item> HAKKOU_TARU = register("block_taru_hakkou", () -> new ItemNameBlockItem(Hakkou_Blocks.HAKKOU_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUJI_TARU = register("block_taru_kouji_f", () -> new ItemNameBlockItem(Hakkou_Blocks.KOUJI_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHUBO_TARU = register("block_taru_shubo_f", () -> new ItemNameBlockItem(Hakkou_Blocks.SHUBO_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> MOROMI_TARU = register("block_taru_moromi_f", () -> new ItemNameBlockItem(Hakkou_Blocks.MOROMI_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUSEI_TARU = register("block_taru_jukusei_f", () -> new ItemNameBlockItem(Hakkou_Blocks.JUKUSEI_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> RINGOSHU_TARU = register("block_taru_ringoshu_f", () -> new ItemNameBlockItem(Hakkou_Blocks.RINGOSHU_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> BUDOUSHU_TARU = register("block_taru_budoushu_f", () -> new ItemNameBlockItem(Hakkou_Blocks.BUDOUSHU_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> HACHIMITSU_TARU = register("block_taru_hachimitsushu_f", () -> new ItemNameBlockItem(Hakkou_Blocks.HACHIMITSU_TARU.get(), new Item.Properties()));

	/* Bottle */
	public static final RegistryObject<Item> NAMASAKEBOT = register("block_bot_sakenama_1", () -> new ItemNameBlockItem(Hakkou_Blocks.NAMASAKEBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> SAKEBOT = register("block_bot_sake_1", () -> new ItemNameBlockItem(Hakkou_Blocks.SAKEBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUSAKEBOT = register("block_bot_sakejuku_1", () -> new ItemNameBlockItem(Hakkou_Blocks.JUKUSAKEBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEAMAZAKE_nama = register("block_food_nabeaz_n", () -> new ItemNameBlockItem(Hakkou_Blocks.NABEAMAZAKE_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEAMAZAKE = register("block_food_nabeaz_1", () -> new ItemNameBlockItem(Hakkou_Blocks.NABEAMAZAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CIDERBOT = register("block_bot_cider_1", () -> new ItemNameBlockItem(Hakkou_Blocks.CIDERBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUCIDERBOT = register("block_bot_ciderjuku_1", () -> new ItemNameBlockItem(Hakkou_Blocks.JUKUCIDERBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINEBOT = register("block_bot_wine_1", () -> new ItemNameBlockItem(Hakkou_Blocks.WINEBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUWINEBOT = register("block_bot_winejuku_1", () -> new ItemNameBlockItem(Hakkou_Blocks.JUKUWINEBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEADBOT = register("block_bot_mead_1", () -> new ItemNameBlockItem(Hakkou_Blocks.MEADBOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUMEADBOT = register("block_bot_meadjuku_1", () -> new ItemNameBlockItem(Hakkou_Blocks.JUKUMEADBOT.get(), new Item.Properties()));

	/* Glass */
	public static final RegistryObject<Item> NAMASAKEGLASS = register("block_glass_sakenama", () -> new SakeGlass(Hakkou_Blocks.NAMASAKEGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> SAKEGLASS = register("block_glass_sake", () -> new SakeGlass(Hakkou_Blocks.SAKEGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUSAKEGLASS = register("block_glass_sakejuku", () -> new SakeGlass(Hakkou_Blocks.JUKUSAKEGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> AMAZAKEGLASS = register("block_glass_amazake", () -> new SakeGlass(Hakkou_Blocks.AMAZAKEGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CIDERGLASS = register("block_glass_cider", () -> new SakeGlass(Hakkou_Blocks.CIDERGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUCIDERGLASS = register("block_glass_ciderjuku", () -> new SakeGlass(Hakkou_Blocks.JUKUCIDERGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINEGLASS = register("block_glass_wine", () -> new SakeGlass(Hakkou_Blocks.WINEGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUWINEGLASS = register("block_glass_winejuku", () -> new SakeGlass(Hakkou_Blocks.JUKUWINEGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEADGLASS = register("block_glass_mead", () -> new SakeGlass(Hakkou_Blocks.MEADGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUKUMEADGLASS = register("block_glass_meadjuku", () -> new SakeGlass(Hakkou_Blocks.JUKUMEADGLASS.get(), new Item.Properties()));

	public static final RegistryObject<Item> WINE_TANA = register("block_kit2_tana", () -> new Fuel_150(Hakkou_Blocks.WINE_TANA.get(), new Item.Properties()));

	public static final RegistryObject<Item> MISO_TARU = register("block_taru_miso_f", () -> new ItemNameBlockItem(Hakkou_Blocks.MISO_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> HAKUSAI_TARU1 = register("block_taru_hakusai_f", () -> new ItemNameBlockItem(Hakkou_Blocks.HAKUSAI_TARU1.get(), new Item.Properties()));
	public static final RegistryObject<Item> HAKUSAI_TARU2 = register("block_taru_hakusai_f2", () -> new ItemNameBlockItem(Hakkou_Blocks.HAKUSAI_TARU2.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUYU_TARU = register("block_taru_shouyu_f", () -> new ItemNameBlockItem(Hakkou_Blocks.SHOUYU_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOMEZU_TARU = register("block_taru_komezu_f", () -> new ItemNameBlockItem(Hakkou_Blocks.KOMEZU_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KINOKO_TARU = register("block_taru_kinoko_f", () -> new ItemNameBlockItem(Hakkou_Blocks.KINOKO_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KONBU_TARU = register("block_taru_konbu_f", () -> new ItemNameBlockItem(Hakkou_Blocks.KONBU_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> NORI_TARU = register("block_taru_nori_f", () -> new ItemNameBlockItem(Hakkou_Blocks.NORI_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUCHA_TARU = register("block_taru_koucha_f", () -> new ItemNameBlockItem(Hakkou_Blocks.KOUCHA_TARU.get(), new Item.Properties()));
	public static final RegistryObject<Item> PEPPER_TARU = register("block_taru_pepper_f", () -> new ItemNameBlockItem(Hakkou_Blocks.PEPPER_TARU.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUYU_bot_1 = register("block_shouyu_bot", () -> new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_1.get(), new Item.Properties().craftRemainder(Items_NoTab.SHOUYU_bot_2.get())));
	public static final RegistryObject<Item> KOMEZU_bot_1 = register("block_komezu_bot", () -> new HakkouItem_Tips(Hakkou_Blocks.KOMEZU_bot_1.get(), new Item.Properties().craftRemainder(Items_NoTab.KOMEZU_bot_2.get())));
	public static final RegistryObject<Item> DASHI_bot_1 = register("block_dashi_bot", () -> new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_1.get(), new Item.Properties().craftRemainder(Items_NoTab.DASHI_bot_2.get())));
	public static final RegistryObject<Item> OSAUCE_bot_1 = register("block_osauce_bot", () -> new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_1.get(), new Item.Properties().craftRemainder(Items_NoTab.OSAUCE_bot_2.get())));
	public static final RegistryObject<Item> MAYO_bot_1 = register("block_mayo_bot", () -> new HakkouItem_Tips(Dish_Blocks.MAYO_bot_1.get(), new Item.Properties().craftRemainder(Items_NoTab.MAYO_bot_2.get())));
	public static final RegistryObject<Item> MATCH = register("item_match_cm", () -> new Match_Item(new Item.Properties()));

	public static final RegistryObject<Item> SARA = register("item_food_sara", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> YUNOMI = register("item_food_yunomi", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> TCUP_kara = register("item_food_teacup", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CHAWAN = register("item_food_chawan", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SHIKKI = register("item_food_shikki", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> TONSUI = register("item_food_tonsui", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> DONBURI = register("item_food_donburi", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> DRINKGLASS = register("item_food_driglass", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SAKEBOTTLE = register("item_food_sakebot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BENTOUHAKO = register("item_bentouhako", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> CLAY_SARA = register("item_clay_sara", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_YUNOMI = register("item_clay_yunomi", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_KYUSU = register("item_clay_kyusu", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_TCUP = register("item_clay_teacup", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_TPOT = register("item_clay_teapot", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_CHAWAN = register("item_clay_chawan", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_NABE = register("item_clay_nabe", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_TONSUI = register("item_clay_tonsui", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> CLAY_DONBURI = register("item_clay_donburi", () -> new AddInfo_Item(new Item.Properties()));

	/* Salt */
	public static final RegistryObject<Item> ENDEN = register("block_enden", () -> new ItemNameBlockItem(Crop_Blocks.ENDEN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHIO = register("item_salt", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NIGARI = register("item_nigari", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> RENNET = register("item_rennet", () -> new AddInfo_Item(new Item.Properties()));

	public static final RegistryObject<Item> MUSHIGOME = register("item_mushigome", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> MUSHIGOME_TAKE = register("item_mushigome_take", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> MUSHIGOME_KURI = register("item_mushigome_kuri", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> KOMEKOUJI = register("item_komekouji", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SHUBO = register("item_shubo", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> SAKEKASU = register("item_sakekasu", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> MOROMI = register("item_moromi", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items_Teatime.SAKEKASU.get())));

	public static final RegistryObject<Item> NIMAME = register("item_nimame", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> MISO = register("item_miso", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> KOMUGI = register("item_flour", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BUTTER = register("item_butter", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> KIJI_BUN = register("item_kiji_bun", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> KIJI_BURG = register("item_kiji_burg", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> KIJI_SCONE= register("item_kiji_scone", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> KIJI_SENBEI = register("item_kiji_senbei", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> KIJI_PIZA = register("item_kiji_pizza", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PIZZA_nama = register("item_food_pizza_n", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PIZZAC_nama = register("item_food_pizza_cn", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PIZZAT_nama = register("item_food_pizza_tn", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PIZZAS_nama = register("item_food_pizza_sn", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> PASTA_nama = register("item_food_pasta_n", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PASTA_sara = register("item_food_pasta_s", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> UDON_nama = register("item_food_udon_n", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SHOUYU_donburi = register("item_food_shouyu_don", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> TSUYU_donburi = register("item_food_tsuyu_don", () -> new AddInfo_Item(new Item.Properties()));
	/** 6.4.1 **/
	public static final RegistryObject<Item> KEIRYO_CUP = register("block_measurecup", () -> new MeasureCup_Item(Fluids.EMPTY, Dish_Blocks.KEIRYO_CUP.get(), new Item.Properties()));
	public static final RegistryObject<Item> KEIRYO_CUP_full = register("item_measurecup_full", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items_Teatime.KEIRYO_CUP.get())));
	public static final RegistryObject<Item> KANSUI = register("item_kansui", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items_Teatime.KEIRYO_CUP.get())));
	public static final RegistryObject<Item> RAMEN_nama = register("item_food_ramen_n", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SHOUYU_TARE = register("item_food_tare_shouyu", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> MISO_TARE = register("item_food_tare_miso", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SHIO_TARE = register("item_food_tare_shio", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SHOUYU_Rsoup = register("item_food_rsoup_shouyu", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> MISO_Rsoup = register("item_food_rsoup_miso", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SHIO_Rsoup = register("item_food_rsoup_shio", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SOBA_PLATE = register("item_food_sobaplate", () -> new AddInfo_Item(new Item.Properties()));
	
	/* Cooking */
	public static final RegistryObject<Item> ZUNDOU = register("block_food_zundou", () -> new ZundouKara_Item(Dish_Blocks.ZUNDOU.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_MIZU = register("block_zundou_mizu", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_MIZU.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_SHIO = register("block_zundou_shiomizu", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_SHIO.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_MILK = register("block_zundou_milk", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_MILK.get(), new Item.Properties()));

	public static final RegistryObject<Item> ZUNDOU_NCURRY = register("block_food_cunabe_n", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_NCURRY.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_CURRY = register("block_food_cunabe_1", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_CURRY.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_NCURRY_C = register("block_food_cunabe_cn", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_NCURRY_C.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_CURRY_C = register("block_food_cunabe_c1", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_CURRY_C.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_NCURRY_T = register("block_food_cunabe_tn", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_NCURRY_T.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_CURRY_T = register("block_food_cunabe_t1", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_CURRY_T.get(), new Item.Properties()));

	public static final RegistryObject<Item> ZUNDOU_NSTEW = register("block_food_stewnabe_n", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_NSTEW.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_STEW = register("block_food_stewnabe_1", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_STEW.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_DASHI = register("block_food_dashinabe_1", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_DASHI.get(), new Item.Properties()));
	/** 6.4.1 **/
	public static final RegistryObject<Item> ZUNDOU_RSOUP_nama = register("block_food_rsoup_n", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_RSOUP_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZUNDOU_RSOUP = register("block_food_rsoup_1", () -> new ItemNameBlockItem(Dish_Blocks.ZUNDOU_RSOUP.get(), new Item.Properties()));

	public static final RegistryObject<Item> NABE_kara = register("block_food_karanabe", () -> new DonabeKara_Item(Fluids.EMPTY, Dish_Blocks.NABE_kara.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABETORI_nama = register("block_food_nabe_n", () -> new ItemNameBlockItem(Dish_Blocks.NABETORI_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEMISO_nama = register("block_food_nabemiso_n", () -> new ItemNameBlockItem(Dish_Blocks.NABEMISO_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEGOHAN_nama = register("block_food_nabegohan_n", () -> new ItemNameBlockItem(Dish_Blocks.NABEGOHAN_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEGOHANTAKE_nama = register("block_food_nabegohantake_n", () -> new ItemNameBlockItem(Dish_Blocks.NABEGOHANTAKE_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEGOHANKURI_nama = register("block_food_nabegohankuri_n", () -> new ItemNameBlockItem(Dish_Blocks.NABEGOHANKURI_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABECORN_nama = register("block_food_nabecorns_n", () -> new ItemNameBlockItem(Dish_Blocks.NABECORN_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABESHIO_nama = register("block_food_nabeshio_n", () -> new ItemNameBlockItem(Dish_Blocks.NABESHIO_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABENIMAME_nama = register("block_food_nabenimame_n", () -> new ItemNameBlockItem(Dish_Blocks.NABENIMAME_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABETOUFU_nama = register("block_food_nabetoufu_n", () -> new ItemNameBlockItem(Dish_Blocks.NABETOUFU_nama.get(), new Item.Properties()));

	public static final RegistryObject<Item> NABETORI = register("block_food_nabe_1", () -> new ItemNameBlockItem(Dish_Blocks.NABETORI.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEMISO = register("block_food_nabemiso_1", () -> new ItemNameBlockItem(Dish_Blocks.NABEMISO.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEGOHAN = register("block_food_nabegohan_1", () -> new ItemNameBlockItem(Dish_Blocks.NABEGOHAN.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEGOHAN_TAKE = register("block_food_nabegohantake_1", () -> new ItemNameBlockItem(Dish_Blocks.NABEGOHAN_TAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABEGOHAN_KURI = register("block_food_nabegohankuri_1", () -> new ItemNameBlockItem(Dish_Blocks.NABEGOHAN_KURI.get(), new Item.Properties()));
	public static final RegistryObject<Item> NABECORN = register("block_food_nabecorns_1", () -> new ItemNameBlockItem(Dish_Blocks.NABECORN.get(), new Item.Properties()));

	public static final RegistryObject<Item> FRYPAN_kara = register("block_food_frypan", () -> new ItemNameBlockItem(Dish_Blocks.FRYPAN_kara.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPTAMAGO_nama = register("block_food_frypan_n_tamago", () -> new ItemNameBlockItem(Dish_Blocks.FPTAMAGO_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPGYUDON_nama = register("block_food_frypan_n_gyudon", () -> new ItemNameBlockItem(Dish_Blocks.FPGYUDON_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPOYAKODON_nama = register("block_food_frypan_n_oyakodon", () -> new ItemNameBlockItem(Dish_Blocks.FPOYAKODON_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPKATSU_nama = register("block_food_frypan_n_katsu", () -> new ItemNameBlockItem(Dish_Blocks.FPKATSU_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPKATSU_bake = register("block_food_frypan_b_katsu", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> FPKATSUDON_nama = register("block_food_frypan_n_katsudon", () -> new ItemNameBlockItem(Dish_Blocks.FPKATSUDON_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPEGGBURG_nama = register("block_food_frypan_n_eggb", () -> new ItemNameBlockItem(Dish_Blocks.FPEGGBURG_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPTOMATO_nama = register("block_food_frypan_n_tomatos", () -> new ItemNameBlockItem(Dish_Blocks.FPTOMATO_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPKINOKO_nama = register("block_food_frypan_n_kinokos", () -> new ItemNameBlockItem(Dish_Blocks.FPKINOKO_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPSEAFOOD_nama = register("block_food_frypan_n_seafood", () -> new ItemNameBlockItem(Dish_Blocks.FPSEAFOOD_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPKINOKOAK_nama = register("block_food_frypan_n_kinokoak", () -> new ItemNameBlockItem(Dish_Blocks.FPKINOKOAK_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPKINOKOAK = register("item_food_frypan_b_kinokoak", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items_Teatime.FRYPAN_kara.get())));
	public static final RegistryObject<Item> FPCURRY_nama = register("block_food_frypan_n_roux", () -> new ItemNameBlockItem(Dish_Blocks.FPCURRY_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> FPOSAUCE_nama = register("block_food_frypan_n_osauce", () -> new ItemNameBlockItem(Dish_Blocks.FPOSAUCE_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMIYAKI_nama = register("block_food_teppan_n_okonomiyaki", () -> new ItemNameBlockItem(Dish_Blocks.OKONOMIYAKI_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMIS_nama = register("block_food_teppan_n_okonomis", () -> new ItemNameBlockItem(Dish_Blocks.OKONOMIS_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMIC_nama = register("block_food_teppan_n_okonomic", () -> new ItemNameBlockItem(Dish_Blocks.OKONOMIC_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMISOBA_nama = register("block_food_teppan_n_okonomisoba", () -> new ItemNameBlockItem(Dish_Blocks.OKONOMISOBA_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMISOBAS_nama = register("block_food_teppan_n_okonomisobas", () -> new ItemNameBlockItem(Dish_Blocks.OKONOMISOBAS_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMISOBAC_nama = register("block_food_teppan_n_okonomisobac", () -> new ItemNameBlockItem(Dish_Blocks.OKONOMISOBAC_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKISOBA_nama = register("block_food_teppan_n_yakisoba", () -> new ItemNameBlockItem(Dish_Blocks.YAKISOBA_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKISOBASHIO_nama = register("block_food_teppan_n_yakisobashio", () -> new ItemNameBlockItem(Dish_Blocks.YAKISOBASHIO_nama.get(), new Item.Properties()));

	public static final RegistryObject<Item> NIBOSHI = register("block_niboshi", () -> new ItemNameBlockItem(Dish_Blocks.NIBOSHI.get(), new Item.Properties()));

	public static final RegistryObject<Item> CURRY = register("block_food_curry_1", () -> new Curry_Item(Dish_Blocks.CURRY.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURRYSET = register("block_food_curryset_1", () -> new ItemNameBlockItem(Dish_Blocks.CURRYSET.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURRY_C = register("block_food_curry_c1", () -> new Curry_Item(Dish_Blocks.CURRY_C.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURRYSET_C = register("block_food_curryset_c1", () -> new ItemNameBlockItem(Dish_Blocks.CURRYSET_C.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURRY_T = register("block_food_curry_t1", () -> new Curry_Item(Dish_Blocks.CURRY_T.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURRYSET_T = register("block_food_curryset_t1", () -> new ItemNameBlockItem(Dish_Blocks.CURRYSET_T.get(), new Item.Properties()));

	public static final RegistryObject<Item> STEW = register("block_food_stew_1", () -> new Dish_Plate(Dish_Blocks.STEW.get(), new Item.Properties()));
	public static final RegistryObject<Item> UDON_SU = register("block_food_udonsu_1", () -> new Dish_Donburi(Dish_Blocks.UDON_SU.get(), new Item.Properties()));
	public static final RegistryObject<Item> UDON_NIKU = register("block_food_udonniku_1", () -> new Dish_Donburi(Dish_Blocks.UDON_NIKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> UDON_TSUKIMI = register("block_food_udontsukimi_1", () -> new Dish_Donburi(Dish_Blocks.UDON_TSUKIMI.get(), new Item.Properties()));
	/** 6.4.1 **/
	public static final RegistryObject<Item> RAMEN_SHOUYU = register("block_food_ramenshouyu_1", () -> new Dish_Donburi(Dish_Blocks.RAMEN_SHOUYU.get(), new Item.Properties()));
	public static final RegistryObject<Item> RAMEN_MISO = register("block_food_ramenmiso_1", () -> new Dish_Donburi(Dish_Blocks.RAMEN_MISO.get(), new Item.Properties()));
	public static final RegistryObject<Item> RAMEN_SHIO = register("block_food_ramenshio_1", () -> new Dish_Donburi(Dish_Blocks.RAMEN_SHIO.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> TONSUITORI = register("block_food_tonsui_1", () -> new Dish_addItem(Dish_Blocks.TONSUITORI.get(), new Item.Properties()));
	public static final RegistryObject<Item> MISOSOUP = register("block_food_misosp_1", () -> new Dish_addItem(Dish_Blocks.MISOSOUP.get(), new Item.Properties()));
	public static final RegistryObject<Item> GOHAN = register("block_food_gohan_1", () -> new Dish_addItem(Dish_Blocks.GOHAN.get(), new Item.Properties()));
	public static final RegistryObject<Item> GOHAN_TAKE = register("block_food_gohantake_1", () -> new Dish_addItem(Dish_Blocks.GOHAN_TAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GOHAN_KURI = register("block_food_gohankuri_1", () -> new Dish_addItem(Dish_Blocks.GOHAN_KURI.get(), new Item.Properties()));
	public static final RegistryObject<Item> RICE = register("block_food_rice_1", () -> new Dish_Plate(Dish_Blocks.RICE.get(), new Item.Properties()));
	public static final RegistryObject<Item> DONBURI_MESHI = register("block_food_donmeshi_1", () -> new Dish_Donburi(Dish_Blocks.DONBURI_MESHI.get(), new Item.Properties()));

	public static final RegistryObject<Item> DONBURI_GYU = register("block_food_dongyu_1", () -> new Dish_Donburi(Dish_Blocks.DONBURI_GYU.get(), new Item.Properties()));
	public static final RegistryObject<Item> DONBURI_OYAKO = register("block_food_donoyako_1", () -> new Dish_Donburi(Dish_Blocks.DONBURI_OYAKO.get(), new Item.Properties()));
	public static final RegistryObject<Item> DONBURI_KATSU = register("block_food_donkatsu_1", () -> new Dish_Donburi(Dish_Blocks.DONBURI_KATSU.get(), new Item.Properties()));
	public static final RegistryObject<Item> DONBURI_KAISEN = register("block_food_donkaisen_1", () -> new Dish_Donburi(Dish_Blocks.DONBURI_KAISEN.get(), new Item.Properties()));

	public static final RegistryObject<Item> FOOD_HAKUSAI2 = register("item_food_hakusai2", () -> new Item(new Item.Properties().food(FoodBuilders.HAKUSAI2)));
	public static final RegistryObject<Item> HAKUSAIDUKE = register("block_food_hsd_1", () -> new Dish_Plate(Dish_Blocks.HAKUSAIDUKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAMAGOYAKI = register("block_food_tgy_1", () -> new Dish_Plate(Dish_Blocks.TAMAGOYAKI.get(), (new Item.Properties()).craftRemainder(Items_Teatime.SARA.get())));

	public static final RegistryObject<Item> TAMAGOYAKITEI = register("block_food_tgytei_1", () -> new ItemNameBlockItem(Dish_Blocks.TAMAGOYAKITEI.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKIZAKANATEI = register("block_food_yakizakanatei_1", () -> new ItemNameBlockItem(Dish_Blocks.YAKIZAKANATEI.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKIJYAKETEI = register("block_food_yakijyaketei_1", () -> new ItemNameBlockItem(Dish_Blocks.YAKIJYAKETEI.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAMAGOYAKITEI_TAKE = register("block_food_tgyteitake_1", () -> new ItemNameBlockItem(Dish_Blocks.TAMAGOYAKITEI_TAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKIZAKANATEI_TAKE = register("block_food_yakizakanateitake_1", () -> new ItemNameBlockItem(Dish_Blocks.YAKIZAKANATEI_TAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKIJYAKETEI_TAKE = register("block_food_yakijyaketeitake_1", () -> new ItemNameBlockItem(Dish_Blocks.YAKIJYAKETEI_TAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAMAGOYAKITEI_KURI = register("block_food_tgyteikuri_1", () -> new ItemNameBlockItem(Dish_Blocks.TAMAGOYAKITEI_KURI.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKIZAKANATEI_KURI = register("block_food_yakizakanateikuri_1", () -> new ItemNameBlockItem(Dish_Blocks.YAKIZAKANATEI_KURI.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKIJYAKETEI_KURI = register("block_food_yakijyaketeikuri_1", () -> new ItemNameBlockItem(Dish_Blocks.YAKIJYAKETEI_KURI.get(), new Item.Properties()));

	public static final RegistryObject<Item> CORNSOUP = register("block_food_cornsp_1", () -> new Dish_Plate(Dish_Blocks.CORNSOUP.get(), new Item.Properties()));

	public static final RegistryObject<Item> EGGBURG = register("block_food_egb_1", () -> new Dish_Plate(Dish_Blocks.EGGBURG.get(), new Item.Properties()));
	public static final RegistryObject<Item> EGGBURGSET = register("block_food_egbset_1", () -> new ItemNameBlockItem(Dish_Blocks.EGGBURGSET.get(), new Item.Properties()));

	public static final RegistryObject<Item> PASTATOMATO = register("block_food_pastatoma_1", () -> new Dish_Plate(Dish_Blocks.PASTATOMATO.get(), new Item.Properties()));
	public static final RegistryObject<Item> PASTACHEESE = register("block_food_pastacheese_1", () -> new Dish_Plate(Dish_Blocks.PASTACHEESE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PASTAKINOKO = register("block_food_pastakinoko_1", () -> new Dish_Plate(Dish_Blocks.PASTAKINOKO.get(), new Item.Properties()));
	public static final RegistryObject<Item> PASTASEAFOOD = register("block_food_pastaseafood_1", () -> new Dish_addItem(Dish_Blocks.PASTASEAFOOD.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> PIZZA = register("block_food_pizza_1", () -> new ItemNameBlockItem(Dish_Blocks.PIZZA.get(), new Item.Properties()));
	public static final RegistryObject<Item> PIZZA_C = register("block_food_pizza_c1", () -> new ItemNameBlockItem(Dish_Blocks.PIZZA_C.get(), new Item.Properties()));
	public static final RegistryObject<Item> PIZZA_T = register("block_food_pizza_t1", () -> new ItemNameBlockItem(Dish_Blocks.PIZZA_T.get(), new Item.Properties()));
	public static final RegistryObject<Item> PIZZA_S = register("block_food_pizza_s1", () -> new ItemNameBlockItem(Dish_Blocks.PIZZA_S.get(), new Item.Properties()));
	public static final RegistryObject<Item> PC_PIZZA = register("item_food_pizza", () -> new Item(new Item.Properties().food(FoodBuilders.PC_PIZZA)));
	public static final RegistryObject<Item> PC_PIZZAC = register("item_food_pizzac", () -> new Item(new Item.Properties().food(FoodBuilders.PC_PIZZAC)));
	public static final RegistryObject<Item> PC_PIZZAT = register("item_food_pizzat", () -> new Item(new Item.Properties().food(FoodBuilders.PC_PIZZAT)));
	public static final RegistryObject<Item> PC_PIZZAS = register("item_food_pizzas", () -> new Item(new Item.Properties().food(FoodBuilders.PC_PIZZAS)));
	public static final RegistryObject<Item> OKONOMIYAKI = register("block_food_okonomiyaki_1", () -> new Dish_Plate(Dish_Blocks.OKONOMIYAKI.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMIS = register("block_food_okonomis_1", () -> new Dish_Plate(Dish_Blocks.OKONOMIS.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMIC = register("block_food_okonomic_1", () -> new Dish_Plate(Dish_Blocks.OKONOMIC.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMISOBA = register("block_food_okonomisoba_1", () -> new Dish_Plate(Dish_Blocks.OKONOMISOBA.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMISOBAS = register("block_food_okonomisobas_1", () -> new Dish_Plate(Dish_Blocks.OKONOMISOBAS.get(), new Item.Properties()));
	public static final RegistryObject<Item> OKONOMISOBAC = register("block_food_okonomisobac_1", () -> new Dish_Plate(Dish_Blocks.OKONOMISOBAC.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKISOBA = register("block_food_yakisoba_1", () -> new Dish_Plate(Dish_Blocks.YAKISOBA.get(), new Item.Properties()));
	public static final RegistryObject<Item> YAKISOBASHIO = register("block_food_yakisobashio_1", () -> new Dish_Plate(Dish_Blocks.YAKISOBASHIO.get(), new Item.Properties()));

	public static final RegistryObject<Item> CHICKEN = register("block_food_roastchicken_1", () -> new ItemNameBlockItem(Dish_Blocks.CHICKEN.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHICKEN_small = register("block_food_chickenb_1", () -> new Dish_Plate(Dish_Blocks.CHICKEN_small.get(), new Item.Properties()));

	public static final RegistryObject<Item> SUSHIMESHI = register("block_food_sushimeshi", () -> new ItemNameBlockItem(Dish_Blocks.SUSHIMESHI.get(), (new Item.Properties()).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> SUSHIGETA_kara = register("block_food_sushigeta_kara", () -> new ItemNameBlockItem(Dish_Blocks.SUSHIGETA_kara.get(), new Item.Properties()));

	public static final RegistryObject<Item> SUSHISET_salmon = register("block_food_sushiset_salmon", () -> new ItemNameBlockItem(Dish_Blocks.SUSHISET_salmon.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUSHISET_fish = register("block_food_sushiset_fish", () -> new ItemNameBlockItem(Dish_Blocks.SUSHISET_fish.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUSHISET_beef = register("block_food_sushiset_beef", () -> new ItemNameBlockItem(Dish_Blocks.SUSHISET_beef.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUSHISET_tamago = register("block_food_sushiset_tamago", () -> new ItemNameBlockItem(Dish_Blocks.SUSHISET_tamago.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUSHISET_4shoku = register("block_food_sushiset_4shoku", () -> new ItemNameBlockItem(Dish_Blocks.SUSHISET_4shoku.get(), new Item.Properties()));

	public static final RegistryObject<Item> SUSHIOKE = register("block_food_sushioke_kara", () -> new ItemNameBlockItem(Dish_Blocks.SUSHIOKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUSHIOKE_FULL_1 = register("block_food_sushiokefull_1", () -> new ItemNameBlockItem(Dish_Blocks.SUSHIOKE_FULL_1.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUYUSARA_1 = register("block_food_shouyusara_1", () -> new ItemNameBlockItem(Dish_Blocks.SHOUYUSARA_1.get(), new Item.Properties()));

	public static final RegistryObject<Item> KIRIMI_S = register("item_food_kirimi_salmon", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.KIRIMI)));
	public static final RegistryObject<Item> KIRIMI_F = register("item_food_kirimi_fish", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.KIRIMI)));
	public static final RegistryObject<Item> KIRIMI_B = register("item_food_kirimi_beef", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.KIRIMI)));
	public static final RegistryObject<Item> KIRIMI_T = register("item_food_kirimi_tamago", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.KIRIMI)));

	public static final RegistryObject<Item> SUSHI_S = register("item_food_sushi_salmon", () -> new Item(new Item.Properties().food(FoodBuilders.SUSHI)));
	public static final RegistryObject<Item> SUSHI_F = register("item_food_sushi_fish", () -> new Item(new Item.Properties().food(FoodBuilders.SUSHI)));
	public static final RegistryObject<Item> SUSHI_B = register("item_food_sushi_beef", () -> new Item(new Item.Properties().food(FoodBuilders.SUSHI)));
	public static final RegistryObject<Item> SUSHI_T = register("item_food_sushi_tamago", () -> new Item(new Item.Properties().food(FoodBuilders.SUSHI)));

	public static final RegistryObject<Item> SHOUYUSUSHI_S = register("item_food_sushishouyu_salmon", () -> new Item(new Item.Properties().food(FoodBuilders.SHOUYUSUSHI_S)));
	public static final RegistryObject<Item> SHOUYUSUSHI_F = register("item_food_sushishouyu_fish", () -> new Item(new Item.Properties().food(FoodBuilders.SHOUYUSUSHI_F)));
	public static final RegistryObject<Item> SHOUYUSUSHI_B = register("item_food_sushishouyu_beef", () -> new Item(new Item.Properties().food(FoodBuilders.SHOUYUSUSHI_B)));
	public static final RegistryObject<Item> SHOUYUSUSHI_T = register("item_food_sushishouyu_tamago", () -> new Item(new Item.Properties().food(FoodBuilders.SHOUYUSUSHI_T)));
	public static final RegistryObject<Item> FUTOMAKI = register("item_food_futomaki", () -> new Item(new Item.Properties().food(FoodBuilders.FUTOMAKI)));

	public static final RegistryObject<Item> KETTLE_kara = register("item_kettle_kara", () -> new ItemNameBlockItem(Dish_Blocks.KETTLE_kara.get(), new Item.Properties()));
	public static final RegistryObject<Item> KETTLE_full = register("block_kettle_full", () -> new ItemNameBlockItem(Dish_Blocks.KETTLE_full.get(), new Item.Properties()));
	public static final RegistryObject<Item> KETTLE_boil = register("item_kettle_boil", () -> new Item(new Item.Properties().craftRemainder(Items_Teatime.KETTLE_kara.get())));

	public static final RegistryObject<Item> KYUSU_kara = register("block_food_kyusu", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> KYUSU = register("block_food_kyusu_1", () -> new ItemNameBlockItem(Dish_Blocks.KYUSU.get(), new Item.Properties()));
	public static final RegistryObject<Item> JPTEACUP = register("block_food_jpteacup_1", () -> new Dish_always(Dish_Blocks.JPTEACUP.get(), new Item.Properties()));

	public static final RegistryObject<Item> JPTEASET = register("block_food_jpteaset_1", () -> new ItemNameBlockItem(Dish_Blocks.JPTEASET.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHAUKE_SENBEI = register("block_food_senbei", () -> new ItemNameBlockItem(Dish_Blocks.CHAUKE_SENBEI.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHAUKE_MIKAN = register("block_food_mikan", () -> new ItemNameBlockItem(Dish_Blocks.CHAUKE_MIKAN.get(), new Item.Properties()));

	public static final RegistryObject<Item> TEAPOT_kara = register("block_food_teapot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> TEAPOT = register("block_food_teapot_1", () -> new ItemNameBlockItem(Dish_Blocks.TEAPOT.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACUP = register("block_food_teacup_1", () -> new TeaCup_Item(Dish_Blocks.TEACUP.get(), new Item.Properties()));

	public static final RegistryObject<Item> TEASET = register("block_food_teaset_1", () -> new ItemNameBlockItem(Dish_Blocks.TEASET.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHAUKE_SCONE = register("block_food_scone", () -> new ItemNameBlockItem(Dish_Blocks.CHAUKE_SCONE.get(), new Item.Properties()));

	public static final RegistryObject<Item> SCONESET_kara = register("block_food_teastand", () -> new ItemNameBlockItem(Dish_Blocks.SCONESET_kara.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCONESET_1 = register("block_food_sconeset_1", () -> new ItemNameBlockItem(Dish_Blocks.SCONESET_1.get(), new Item.Properties()));

	public static final RegistryObject<Item> ICECREAM = register("block_food_icecream_1", () -> new Dish_always(Dish_Blocks.ICECREAM.get(), (new Item.Properties())));

	/* FOOD */
	public static final RegistryObject<Item> CAKE = register("item_food_cake", () -> new Item(new Item.Properties().food(FoodBuilders.CAKE)));
	public static final RegistryObject<Item> BUN = register("item_food_bun", () -> new Item(new Item.Properties().food(FoodBuilders.BUN)));
	public static final RegistryObject<Item> SCONE = register("item_food_scone", () -> new Item(new Item.Properties().food(FoodBuilders.SCONE)));
	public static final RegistryObject<Item> SENBEI = register("item_food_senbei", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.SENBEI)));
	public static final RegistryObject<Item> TOUFU = register("item_food_toufu", () -> new Item(new Item.Properties().food(FoodBuilders.TOUFU)));

	public static final RegistryObject<Item> CHICKENSAND = register("item_food_chickensand", () -> new Item(new Item.Properties().food(FoodBuilders.CHICKENSAND)));
	public static final RegistryObject<Item> EGGSAND = register("item_food_eggsand", () -> new Item(new Item.Properties().food(FoodBuilders.EGGSAND)));

	public static final RegistryObject<Item> NORIAMI = register("block_noriami", () -> new ItemNameBlockItem(Crop_Blocks.NORIAMI.get(), new Item.Properties()));
	public static final RegistryObject<Item> NORI_N = register("item_food_norinama", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NORI_I = register("item_food_noriita", () -> new Item(new Item.Properties().food(FoodBuilders.NORI_I)));
	public static final RegistryObject<Item> ONIGIRI = register("item_food_onigiri", () -> new Item(new Item.Properties().food(FoodBuilders.ONIGIRI)));
	public static final RegistryObject<Item> ONIGIRI_SHAKE = register("item_food_onigirishake", () -> new Item(new Item.Properties().food(FoodBuilders.ONIGIRISHAKE)));
	public static final RegistryObject<Item> ONIGIRI_TAKE = register("item_food_onigiritakenoko", () -> new Item(new Item.Properties().food(FoodBuilders.ONIGIRI_TAKEKURI)));
	public static final RegistryObject<Item> ONIGIRI_KURI = register("item_food_onigirikuri", () -> new Item(new Item.Properties().food(FoodBuilders.ONIGIRI_TAKEKURI)));

	public static final RegistryObject<Item> KUSHI_SAKANA = register("item_kushi_sakana", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> KUSHI_SAKANA_C = register("item_kushi_sakana_c", () -> new FoodNeed_addItem(new Item.Properties()));

	public static final RegistryObject<Item> BENTOU = register("item_bentou", () -> new Bentou(new Item.Properties()));
	public static final RegistryObject<Item> SHAKEBEN = register("item_bentoushake", () -> new Bentou(new Item.Properties()));
	public static final RegistryObject<Item> BENTOU_TAKE = register("item_bentou_take", () -> new Bentou(new Item.Properties()));
	public static final RegistryObject<Item> SHAKEBEN_TAKE = register("item_bentoushake_take", () -> new Bentou(new Item.Properties()));
	public static final RegistryObject<Item> BENTOU_KURI = register("item_bentou_kuri", () -> new Bentou(new Item.Properties()));
	public static final RegistryObject<Item> SHAKEBEN_KURI = register("item_bentoushake_kuri", () -> new Bentou(new Item.Properties()));
	
	public static final RegistryObject<Item> MOCHI = register("item_mochi", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MOCHI_NORI = register("item_food_mochinori", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.MOCHI)));
	public static final RegistryObject<Item> MOCHI_KINAKO = register("item_food_mochikinako", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.MOCHI)));

	
	/* Kitchen */
	public static final RegistryObject<Item> KIT_TANA = register("block_kit_tana", () -> new Fuel_150(Kitchen_Blocks.KIT_TANA.get(), new Item.Properties()));
	public static final RegistryObject<Item> KITCHEN = register("block_kitchen", () -> new Fuel_150(Kitchen_Blocks.KITCHEN.get(), new Item.Properties()));

	public static final RegistryObject<Item> KIT_BOARD = register("block_kit_board", () -> new Fuel_300(Kitchen_Blocks.KIT_BOARD.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIT_SINK = register("block_kit_sink", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_SINK.get(), new Item.Properties()));

	public static final RegistryObject<Item> KIT_COOKTOP = register("block_kit_stove", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_COOKTOP.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIT_OVEN = register("block_kit_oven", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_OVEN.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIT_OVEN_B = register("block_kit_oven_black", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_OVEN_B.get(), new Item.Properties()));
	public static final RegistryObject<Item> IRORI = register("block_irori", () -> new ItemNameBlockItem(Kitchen_Blocks.IRORI.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIT_REIZOU = register("block_kit_reizou", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_REIZOU.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> KIT_KANKI_1 = register("block_kit_kanki", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_KANKI_1.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIT_HAIKIDUCT = register("block_kit_duct", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_HAIKIDUCT.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIT_DUCTEND_1 = register("block_kit_ductend", () -> new ItemNameBlockItem(Kitchen_Blocks.KIT_DUCTEND_1.get(), new Item.Properties()));

	public static final RegistryObject<Item> TEATABLE = register("block_teatable", () -> new Fuel_300(Unit_Blocks.TEATABLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TOAMI = register("item_toami", () -> new Toami_Item(Crop_Blocks.TOAMI.get(), new Item.Properties().durability(32)));
	public static final RegistryObject<Item> SHIKAKE_AMI = register("block_ami_shikake", () -> new AmiShikake_Item(Crop_Blocks.SHIKAKE_AMI.get(), new Item.Properties().durability(12)));
	public static final RegistryObject<Item> YOUSHOKU_AMI = register("block_ami_youshoku", () -> new AmiYoushoku_Item(Crop_Blocks.YOUSHOKU_AMI.get(), new Item.Properties().durability(12)));
	
	public static final RegistryObject<Item> CUT_IKA = register("item_squid_cut", () -> new Item(new Item.Properties().food(FoodBuilders.CUT_IKA)));
	public static final RegistryObject<Item> COOKED_IKA = register("item_squid_cooked", () -> new Item(new Item.Properties().food(FoodBuilders.COOKED_IKA)));
	public static final RegistryObject<Item> IKA = register("item_squid_raw", () -> new AddInfo_Item(new Item.Properties().craftRemainder(Items_Teatime.CUT_IKA.get())));	
	
	public static final RegistryObject<Item> KAIHORI = register("item_kaihori", () -> new Kaihori_Item(new Item.Properties().durability(256)));
	public static final RegistryObject<Item> HAMAGURI_COOK = register("item_food_hamaguri", () -> new FoodNeed_addItem(new Item.Properties()));
	public static final RegistryObject<Item> HAMAGURI = register("block_hamaguri", () -> new ItemNameBlockItem(Crop_Blocks.HAMAGURI.get(), new Item.Properties()));

	public static final RegistryObject<Item> KINE_YOKO = register("item_kineyoko", () -> new KineYoko_Item(new Item.Properties()));
	public static final RegistryObject<Item> USU_TSUKI = register("block_usutsuki", () -> new Fuel_300(Kitchen_Blocks.USU_TSUKI.get(), new Item.Properties()));

	
	///* Register *///
	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}
}
