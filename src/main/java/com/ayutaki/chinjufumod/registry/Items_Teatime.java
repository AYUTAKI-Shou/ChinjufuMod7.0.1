package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.crops.ChanokiNae_Item;
import com.ayutaki.chinjufumod.items.crops.Enden_Item;
import com.ayutaki.chinjufumod.items.crops.GrapeNae_Item;
import com.ayutaki.chinjufumod.items.crops.Hamaguri_Item;
import com.ayutaki.chinjufumod.items.crops.HodaGi_Item;
import com.ayutaki.chinjufumod.items.crops.Inagi_Item;
import com.ayutaki.chinjufumod.items.crops.MikanNae_Item;
import com.ayutaki.chinjufumod.items.crops.SeedCorn_Item;
import com.ayutaki.chinjufumod.items.crops.Seed_Item;
import com.ayutaki.chinjufumod.items.crops.SeedsBox_Item;
import com.ayutaki.chinjufumod.items.crops.Spice_nae;
import com.ayutaki.chinjufumod.items.dish.ChickenSmall_Item;
import com.ayutaki.chinjufumod.items.dish.CornSoup_Item;
import com.ayutaki.chinjufumod.items.dish.CurryNabe_Item;
import com.ayutaki.chinjufumod.items.dish.CurrySet_Item;
import com.ayutaki.chinjufumod.items.dish.Curry_Item;
import com.ayutaki.chinjufumod.items.dish.DonGOK_Item;
import com.ayutaki.chinjufumod.items.dish.DonKatsu_Item;
import com.ayutaki.chinjufumod.items.dish.DonMeshi_Item;
import com.ayutaki.chinjufumod.items.dish.Eggburg_Item;
import com.ayutaki.chinjufumod.items.dish.Face4_1Stone_Item;
import com.ayutaki.chinjufumod.items.dish.Face4_1Wood_Item;
import com.ayutaki.chinjufumod.items.dish.FishBoiled_Item;
import com.ayutaki.chinjufumod.items.dish.FryPanKara_Item;
import com.ayutaki.chinjufumod.items.dish.FrypanBake1_Item;
import com.ayutaki.chinjufumod.items.dish.FrypanBake2_Item;
import com.ayutaki.chinjufumod.items.dish.FrypanNama1_Item;
import com.ayutaki.chinjufumod.items.dish.FrypanNama2_Item;
import com.ayutaki.chinjufumod.items.dish.FrypanNama3_Item;
import com.ayutaki.chinjufumod.items.dish.FrypanNama4_Item;
import com.ayutaki.chinjufumod.items.dish.GohanKuri_Item;
import com.ayutaki.chinjufumod.items.dish.GohanTake_Item;
import com.ayutaki.chinjufumod.items.dish.Gohan_Item;
import com.ayutaki.chinjufumod.items.dish.Hakusaiduke_Item;
import com.ayutaki.chinjufumod.items.dish.Icecream_Item;
import com.ayutaki.chinjufumod.items.dish.JPChaUke_Item;
import com.ayutaki.chinjufumod.items.dish.KettleBoil_Item;
import com.ayutaki.chinjufumod.items.dish.KettleFull_Item;
import com.ayutaki.chinjufumod.items.dish.KettleKara_Item;
import com.ayutaki.chinjufumod.items.dish.KyusuKara_Item;
import com.ayutaki.chinjufumod.items.dish.MisoSoup_Item;
import com.ayutaki.chinjufumod.items.dish.NabeCookedSNT_Item;
import com.ayutaki.chinjufumod.items.dish.NabeCooked_Item;
import com.ayutaki.chinjufumod.items.dish.NabeKaisui_Item;
import com.ayutaki.chinjufumod.items.dish.NabeKara_Item;
import com.ayutaki.chinjufumod.items.dish.NabeNama1_Item;
import com.ayutaki.chinjufumod.items.dish.NabeNama2_Item;
import com.ayutaki.chinjufumod.items.dish.NabeNama_TKGohan_Item;
import com.ayutaki.chinjufumod.items.dish.Okonomiyaki_Item;
import com.ayutaki.chinjufumod.items.dish.PastaSeafood_Item;
import com.ayutaki.chinjufumod.items.dish.PastaTCK_Item;
import com.ayutaki.chinjufumod.items.dish.PizzaCooked_Item;
import com.ayutaki.chinjufumod.items.dish.Ramen_Item;
import com.ayutaki.chinjufumod.items.dish.RiceSmall_Item;
import com.ayutaki.chinjufumod.items.dish.SconeSet1_Item;
import com.ayutaki.chinjufumod.items.dish.ShouyuSara_Item;
import com.ayutaki.chinjufumod.items.dish.StewNabe_Item;
import com.ayutaki.chinjufumod.items.dish.Stew_Item;
import com.ayutaki.chinjufumod.items.dish.SushiGetaKara_Item;
import com.ayutaki.chinjufumod.items.dish.SushiMeshi_Item;
import com.ayutaki.chinjufumod.items.dish.SushiOkeFull_Item;
import com.ayutaki.chinjufumod.items.dish.SushiOkeKara_Item;
import com.ayutaki.chinjufumod.items.dish.Tamagoyaki_Item;
import com.ayutaki.chinjufumod.items.dish.TeaCupJP_Item;
import com.ayutaki.chinjufumod.items.dish.TeaCup_Item;
import com.ayutaki.chinjufumod.items.dish.TeaPotKara_Item;
import com.ayutaki.chinjufumod.items.dish.TeaStand_Item;
import com.ayutaki.chinjufumod.items.dish.ToriTonsui_Item;
import com.ayutaki.chinjufumod.items.dish.UdonNT_Item;
import com.ayutaki.chinjufumod.items.dish.UdonSu_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouDashi_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouMilk_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouMizu_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouNama_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouRsoup_Item;
import com.ayutaki.chinjufumod.items.dish.ZundouShioMizu_Item;
import com.ayutaki.chinjufumod.items.dish.Zundou_Item;
import com.ayutaki.chinjufumod.items.food.HamaguriFood_Item;
import com.ayutaki.chinjufumod.items.food.ItemBentou;
import com.ayutaki.chinjufumod.items.food.ItemCheese;
import com.ayutaki.chinjufumod.items.food.ItemCherry;
import com.ayutaki.chinjufumod.items.food.ItemKirimi;
import com.ayutaki.chinjufumod.items.food.ItemMochiFood;
import com.ayutaki.chinjufumod.items.food.ItemOnigiri;
import com.ayutaki.chinjufumod.items.food.ItemPizza;
import com.ayutaki.chinjufumod.items.food.ItemSenbei;
import com.ayutaki.chinjufumod.items.food.ItemSushi;
import com.ayutaki.chinjufumod.items.food.ItemSushi_Shouyu;
import com.ayutaki.chinjufumod.items.food.KushiSakana_Item;
import com.ayutaki.chinjufumod.items.food.ModFood_Item;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.hakkou.BinKouboFull_Item;
import com.ayutaki.chinjufumod.items.hakkou.BinKoubo_Item;
import com.ayutaki.chinjufumod.items.hakkou.BinNyusanFull_Item;
import com.ayutaki.chinjufumod.items.hakkou.BinNyusan_Item;
import com.ayutaki.chinjufumod.items.hakkou.CheeseBlock_Item;
import com.ayutaki.chinjufumod.items.hakkou.CheeseCurd_Item;
import com.ayutaki.chinjufumod.items.hakkou.Dashi1_Item;
import com.ayutaki.chinjufumod.items.hakkou.Dashi2_Item;
import com.ayutaki.chinjufumod.items.hakkou.Dashi3_Item;
import com.ayutaki.chinjufumod.items.hakkou.Dashi4_Item;
import com.ayutaki.chinjufumod.items.hakkou.GlassSake_Item;
import com.ayutaki.chinjufumod.items.hakkou.GlassWine_Item;
import com.ayutaki.chinjufumod.items.hakkou.ItemHakkouTaru;
import com.ayutaki.chinjufumod.items.hakkou.ItemHakkouTaru_Hakusai;
import com.ayutaki.chinjufumod.items.hakkou.ItemHakkouTaru_Shouyu;
import com.ayutaki.chinjufumod.items.hakkou.ItemMizuoke_milk;
import com.ayutaki.chinjufumod.items.hakkou.ItemMoromi;
import com.ayutaki.chinjufumod.items.hakkou.ItemNimame;
import com.ayutaki.chinjufumod.items.hakkou.ItemSakekasu;
import com.ayutaki.chinjufumod.items.hakkou.ItemShubo;
import com.ayutaki.chinjufumod.items.hakkou.Komezu1_Item;
import com.ayutaki.chinjufumod.items.hakkou.Komezu2_Item;
import com.ayutaki.chinjufumod.items.hakkou.MizuokeFull_Item;
import com.ayutaki.chinjufumod.items.hakkou.MizuokeKara_Item;
import com.ayutaki.chinjufumod.items.hakkou.NabeAmazakeNama_Item;
import com.ayutaki.chinjufumod.items.hakkou.Shouyu1_Item;
import com.ayutaki.chinjufumod.items.hakkou.Shouyu2_Item;
import com.ayutaki.chinjufumod.items.hakkou.Shouyu3_Item;
import com.ayutaki.chinjufumod.items.hakkou.Shouyu4_Item;
import com.ayutaki.chinjufumod.items.teatime.Chaba_Item;
import com.ayutaki.chinjufumod.items.teatime.DishesClay_Item;
import com.ayutaki.chinjufumod.items.teatime.Dishes_Item;
import com.ayutaki.chinjufumod.items.teatime.IkaRaw_Item;
import com.ayutaki.chinjufumod.items.teatime.Ine_Item;
import com.ayutaki.chinjufumod.items.teatime.ItemKineTsuki;
import com.ayutaki.chinjufumod.items.teatime.Kaihori_Item;
import com.ayutaki.chinjufumod.items.teatime.KinokoAmakara_Item;
import com.ayutaki.chinjufumod.items.teatime.KitSink_Item;
import com.ayutaki.chinjufumod.items.teatime.Komugi_Item;
import com.ayutaki.chinjufumod.items.teatime.Match_Item;
import com.ayutaki.chinjufumod.items.teatime.Mayo1_Item;
import com.ayutaki.chinjufumod.items.teatime.Mayo2_Item;
import com.ayutaki.chinjufumod.items.teatime.Mayo3_Item;
import com.ayutaki.chinjufumod.items.teatime.Mayo4_Item;
import com.ayutaki.chinjufumod.items.teatime.MeasureCup_Item;
import com.ayutaki.chinjufumod.items.teatime.MeasureCup_Kansui;
import com.ayutaki.chinjufumod.items.teatime.MeasureCup_full;
import com.ayutaki.chinjufumod.items.teatime.Mushigome_Item;
import com.ayutaki.chinjufumod.items.teatime.OSauce1_Item;
import com.ayutaki.chinjufumod.items.teatime.OSauce2_Item;
import com.ayutaki.chinjufumod.items.teatime.OSauce3_Item;
import com.ayutaki.chinjufumod.items.teatime.OSauce4_Item;
import com.ayutaki.chinjufumod.items.teatime.PastaNama_Item;
import com.ayutaki.chinjufumod.items.teatime.RamenNama_Item;
import com.ayutaki.chinjufumod.items.teatime.Shio_Item;
import com.ayutaki.chinjufumod.items.teatime.Spice_Item;
import com.ayutaki.chinjufumod.items.teatime.TTime_Item;
import com.ayutaki.chinjufumod.items.teatime.TeaTable_Item;
import com.ayutaki.chinjufumod.items.teatime.ToamiWide_Item;
import com.ayutaki.chinjufumod.items.teatime.Toami_Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Teatime {

	/* 種・作物 */
	public static Item SEEDSBOX;
	public static Item SEEDS_CABBAGE, SEEDS_HAKUSAI, SEEDS_CORN, SEEDS_GREENONION, 
								SEEDS_ONION, SEEDS_RICE, SEEDS_SOY,
								SEEDS_SPINACH, SEEDS_TOMATO, SEEDS_CHERRY;
	public static Item CHANOKI, BUDOUNOKI, MIKAN_NAE, SPICE_NAE;
	public static Item HODAGI_BOT;

	public static Item CHABA;
	public static Item INAGI, INEWARA, INE, KOME, SAYA, SOY, SPICE;

	public static Item FOOD_CABBAGE, FOOD_HAKUSAI, FOOD_CORN, FOOD_GREENONION,
								FOOD_ONION, FOOD_SPINACH, FOOD_TOMATO,
								FOOD_GRAPE, FOOD_CHERRY, FOOD_MIKAN, FOOD_CORN_B;

	public static Item BOX_H_EMPTY, BOX_H_APPLE, BOX_H_BEEF,
								BOX_H_BEETROOT, BOX_H_BREAD, BOX_H_CARROT,
								BOX_H_CHICKEN, BOX_H_CHORUS, BOX_H_COCO,
								BOX_H_EGG, BOX_H_FISH, BOX_H_FLOUR,
								BOX_H_MUTTON, BOX_H_PORK, BOX_H_POTATO,
								BOX_H_RABBIT, BOX_H_SALMON;

	public static Item BOX_H_CABBAGE, BOX_H_HAKUSAI, BOX_H_CITRUS, 
								BOX_H_CORN, BOX_H_GRAPE, BOX_H_GREENONION, BOX_H_ONION, 
								BOX_H_RICE, BOX_H_SOY, BOX_H_SPINACH, 
								BOX_H_TOMATO, BOX_H_CHERRY, BOX_H_TAKENOKO, BOX_H_KURI,
								BOX_H_TGREEN, BOX_H_TRED, BOX_H_BPEPPER, BOX_H_CUMIN, BOX_H_TURMERIC, BOX_H_CHILI;
	
	public static Item CHADUTSU, CANTEA, TAWARA;

	/* 発酵 */
	public static Item KOUBOBOT_full, NYUSANBOT_full;
	public static Item KOUBO, NYUSAN;

	public static Item MIZUOKE, MIZUOKE_full, MIZUOKE_Milk;
	public static Item HAKKOUTARU;
	public static Item RINGOSHU_TARU, BUDOUSHU_TARU, HACHIMITSUSHU_TARU;
	public static Item NAMASAKEBOT, SAKEBOT, JUKUSAKEBOT;
	public static Item NABEAMAZAKE_nama, NABEAMAZAKE;
	public static Item CIDERBOT, JUKUCIDERBOT;
	public static Item WINEBOT, JUKUWINEBOT;
	public static Item MEADBOT, JUKUMEADBOT;

	public static Item SAKEGLASS, WINEGLASS;
	public static Item WINE_TANA;

	public static Item HAKUSAI_TARU, SHOUYU_TARU;

	public static Item SHOUYU_bot_1, SHOUYU_bot_2, SHOUYU_bot_3, SHOUYU_bot_4;
	public static Item KOMEZU_bot_1, KOMEZU_bot_2;
	public static Item DASHI_bot_1, DASHI_bot_2, DASHI_bot_3, DASHI_bot_4;
	public static Item OSAUCE_bot_1, OSAUCE_bot_2, OSAUCE_bot_3, OSAUCE_bot_4;
	public static Item MAYO_bot_1, MAYO_bot_2, MAYO_bot_3, MAYO_bot_4;
	
	/* 食器 */
	public static Item Item_MATCH;
	public static Item Item_SARA, Item_DISH, CLAY_DISH;

	/* 中間素材 */
	public static Item SHIO;
	public static Item MUSHIGOME, KOMEKOUJI, SHUBO, MORO, SAKEKASU;
	public static Item NIMAME, MISO;
	public static Item KOMUGI, PASTA;
	public static Item KEIRYO_CUP, KEIRYO_CUP_full, KANSUI, RAMEN_nama;
	
	/* 調理済み 寸胴 -> 鍋 -> フライパン */
	public static Item ZUNDOU, ZUNDOU_NAMA, ZUNDOUMIZU, ZUNDOUMILK, ZUNDOUSHIO;
	public static Item CURRYNABE, STEWNABE, DASHINABE, ZUNDOU_RSOUP;

	public static Item NABE_kara, NABE_NAMA_1, NABE_KAISUI, NABE_NAMA_2, NABE_NAMA_TK;
	public static Item NABETORI, NABEMISO, NABEGOHAN, NABEGOHAN_TAKE, NABEGOHAN_KURI, NABECORNSOUP, NABE_SNT;

	public static Item FRYPAN_kara, FRYPAN_NAMA_1, FRYPAN_NAMA_3, FRYPAN_NAMA_2, FPKINOKOAK_nama, FRYPAN_NAMA_4;
	public static Item FRYPAN_BAKE_1, FRYPAN_BAKE_2, FPKINOKOAK;

	public static Item NIBOSHI;
	public static Item CURRY, CURRYSET, STEW;
	public static Item UDON_SU, UDON_NIKU, UDON_TSUKIMI, RAMEN;
	public static Item TONSUITORI, MISOSOUP, GOHAN, GOHAN_TAKE, GOHAN_KURI, RICE;

	public static Item DONBURI_MESHI, DONBURI_GYU, DONBURI_OYAKO, DONBURI_KATSU, DONBURI_KAISEN;

	public static Item FOOD_HAKUSAI2, HAKUSAIDUKE;
	public static Item TAMAGOYAKI, TAMAGOYAKITEI ,YAKIZAKANATEI, YAKIJYAKETEI,
								TAMAGOYAKITEI_TAKE, YAKIZAKANATEI_TAKE, YAKIJYAKETEI_TAKE,
								TAMAGOYAKITEI_KURI,YAKIZAKANATEI_KURI,YAKIJYAKETEI_KURI;
	public static Item CORNSOUP, EGGBURG, EGGBURGSET;

	public static Item PASTATOMATO, PASTACHEESE, PASTAKINOKO, PASTASEAFOOD;
	public static Item PIZZA, PC_PIZZA, OKONOMIYAKI, CHICKEN, CHICKEN_small;

	public static Item SUSHIMESHI;
	public static Item SUSHIGETA_kara, SUSHISET_salmon, SUSHISET_fish, SUSHISET_beef, SUSHISET_tamago, SUSHISET_4shoku;
	public static Item SUSHIOKE, SUSHISET_1;
	public static Item SHOUYUSARA;

	public static Item Item_YAKAN_kara, KETTLE_full, Item_YAKAN_boil;
	public static Item KYUSU_kara, KYUSU, JPTEACUP, JPTEASET, JPCHAUKE;
	public static Item TEAPOT_kara, TEAPOT, TEACUP, TEASET;
	public static Item SCONESET_kara, SCONESET_1;

	public static Item ICECREAM;
	public static Item CHEESE_CURD, CHEESE;
	public static Item FRESH_CHEESE, PIECE_CHEESE;
	public static Item CHEESE_TANA;

	public static Item CAKE, BUN, SCONE, SENBEI, TOUFU;
	public static Item CHICKENSAND, EGGSAND;
	public static Item KIRIMI, SUSHI, SHOUYUSUSHI;

	public static Item NORIAMI, NORI_N, NORI_I, ONIGIRI;
	public static Item KUSHI_SAKANA, KUSHI_SAKANA_C, BENTOU;
	public static Item MOCHI, MOCHI_FOOD;

	public static Item KIT_TANA;
	public static Item KITCHEN, KIT_BOARD, KIT_SINK1, KIT_STOVE, KIT_OVEN, KIT_OVEN_B, IRORI, KIT_REIZOU;

	public static Item KIT_KANKI_1, KIT_HAIKIDUCT, KIT_DUCTEND_1;

	public static Item TEATABLE;
	public static Item ENDEN;

	public static Item TOAMI, TOAMI_W, CUT_IKA, COOKED_IKA, IKA;
	public static Item KAIHORI, HAMAGURI_KARA, HAMAGURI, HAMAGURI_COOK;
	public static Item KINE_YOKO, USU_TSUKI;

	//public static Item TEST;
	
	/* アイテムのインスタンスを生成 Instantiate items. */
	public static void init() {

		/* 種・作物 */
		SEEDSBOX = new SeedsBox_Item("block_seedsbox");
		SEEDS_CABBAGE = new Seed_Item("item_seeds_cabbage", Crop_Blocks.CABBAGE);
		SEEDS_HAKUSAI = new Seed_Item("item_seeds_hakusai", Crop_Blocks.HAKUSAI);
		SEEDS_CORN = new SeedCorn_Item("item_seeds_corn");
		/** 6.4.1 **/ SEEDS_GREENONION = new Seed_Item("item_seeds_greenonion", Crop_Blocks.GREENONION);
		SEEDS_ONION = new Seed_Item("item_seeds_onion", Crop_Blocks.ONION);
		SEEDS_RICE = new Seed_Item("item_seeds_rice", Crop_Blocks.RICE);
		SEEDS_SOY = new Seed_Item("item_seeds_soy", Crop_Blocks.SOY);
		SEEDS_SPINACH = new Seed_Item("item_seeds_spinach", Crop_Blocks.SPINACH);
		SEEDS_TOMATO = new Seed_Item("item_seeds_tomato", Crop_Blocks.TOMATO);
		SEEDS_CHERRY = new Seed_Item("item_seeds_cherry", Crop_Blocks.SAKURA);
		CHANOKI = new ChanokiNae_Item("block_wood_chanoki_nae");
		BUDOUNOKI = new GrapeNae_Item("block_wood_grape_nae");
		MIKAN_NAE = new MikanNae_Item("block_wood_mikan");
		SPICE_NAE = new Spice_nae("item_seeds_spice");
		HODAGI_BOT = new HodaGi_Item("block_hodagi_a_bot");

		CHABA = new Chaba_Item("item_chaba");

		INAGI = new Inagi_Item("block_inagi");
		INEWARA = new TTime_Item("item_inewara");
		INE = new Ine_Item("item_ine");
		KOME = new TTime_Item("item_kome");
		SAYA = new TTime_Item("item_saya");
		SOY = new TTime_Item("item_soy");
		SPICE = new Spice_Item("item_spice");
		
		FOOD_CABBAGE = new ModFood_Item("item_food_cabbage", 2, 0.3F, false);
		FOOD_HAKUSAI = new ModFood_Item("item_food_hakusai", 2, 0.3F, false);
		FOOD_CORN = new ModFood_Item("item_food_corn", 1, 0.3F, false);
		FOOD_GRAPE = new ModFood_Item("item_food_grape", 1, 0.3F, false);
		/** 6.4.1 **/ FOOD_GREENONION = new ModFood_Item("item_food_greenonion", 1, 0.3F, false);
		FOOD_ONION = new ModFood_Item("item_food_onion", 1, 0.3F, false);
		FOOD_SPINACH = new ModFood_Item("item_food_spinach", 1, 0.3F, false);
		FOOD_TOMATO = new ModFood_Item("item_food_tomato", 1, 0.3F, false);
		FOOD_CHERRY = new ItemCherry("item_food_cherry", 1, 0.3F, false);
		FOOD_MIKAN = new ModFood_Item("item_food_mikan", 1, 0.3F, false);
		FOOD_CORN_B = new ModFood_Item("item_food_cornb", 5, 0.6F, false);

		BOX_H_EMPTY = new ItemBlock_noFuel("block_boxh_empty", Kitchen_Blocks.BOX_H_EMPTY);
		BOX_H_APPLE = new ItemBlock_Fuel100("block_boxh_apple", Kitchen_Blocks.BOX_H_APPLE);
		BOX_H_BEEF = new ItemBlock_Fuel100("block_boxh_beef", Kitchen_Blocks.BOX_H_BEEF);
		BOX_H_BEETROOT = new ItemBlock_Fuel100("block_boxh_beetroot", Kitchen_Blocks.BOX_H_BEETROOT);
		BOX_H_BREAD = new ItemBlock_Fuel100("block_boxh_bread", Kitchen_Blocks.BOX_H_BREAD);
		BOX_H_CARROT = new ItemBlock_Fuel100("block_boxh_carrot", Kitchen_Blocks.BOX_H_CARROT);
		BOX_H_CHICKEN = new ItemBlock_Fuel100("block_boxh_chicken", Kitchen_Blocks.BOX_H_CHICKEN);
		BOX_H_CHORUS = new ItemBlock_Fuel100("block_boxh_chorus", Kitchen_Blocks.BOX_H_CHORUS);
		BOX_H_COCO = new ItemBlock_Fuel100("block_boxh_coco", Kitchen_Blocks.BOX_H_COCO);
		BOX_H_EGG = new ItemBlock_Fuel100("block_boxh_egg", Kitchen_Blocks.BOX_H_EGG);
		BOX_H_FISH = new ItemBlock_Fuel100("block_boxh_fish", Kitchen_Blocks.BOX_H_FISH);
		BOX_H_FLOUR = new ItemBlock_Fuel100("block_boxh_flour", Kitchen_Blocks.BOX_H_FLOUR);
		BOX_H_MUTTON = new ItemBlock_Fuel100("block_boxh_mutton", Kitchen_Blocks.BOX_H_MUTTON);
		BOX_H_PORK = new ItemBlock_Fuel100("block_boxh_pork", Kitchen_Blocks.BOX_H_PORK);
		BOX_H_POTATO = new ItemBlock_Fuel100("block_boxh_potato", Kitchen_Blocks.BOX_H_POTATO);
		BOX_H_RABBIT = new ItemBlock_Fuel100("block_boxh_rabbit", Kitchen_Blocks.BOX_H_RABBIT);
		BOX_H_SALMON = new ItemBlock_Fuel100("block_boxh_salmon", Kitchen_Blocks.BOX_H_SALMON);

		BOX_H_CABBAGE = new ItemBlock_Fuel100("block_boxh_cabbage", Kitchen_Blocks.BOX_H_CABBAGE);
		BOX_H_HAKUSAI = new ItemBlock_Fuel100("block_boxh_hakusai", Kitchen_Blocks.BOX_H_HAKUSAI);
		BOX_H_CITRUS = new ItemBlock_Fuel100("block_boxh_citrus", Kitchen_Blocks.BOX_H_CITRUS);
		BOX_H_CORN = new ItemBlock_Fuel100("block_boxh_corn", Kitchen_Blocks.BOX_H_CORN);
		BOX_H_GRAPE = new ItemBlock_Fuel100("block_boxh_grape", Kitchen_Blocks.BOX_H_GRAPE);
		/** 6.4.1 **/ BOX_H_GREENONION = new ItemBlock_Fuel100("block_boxh_greenonion", Kitchen_Blocks.BOX_H_GREENONION);
		BOX_H_ONION = new ItemBlock_Fuel100("block_boxh_onion", Kitchen_Blocks.BOX_H_ONION);
		BOX_H_RICE = new ItemBlock_Fuel100("block_boxh_rice", Kitchen_Blocks.BOX_H_RICE);
		BOX_H_SOY = new ItemBlock_Fuel100("block_boxh_soy", Kitchen_Blocks.BOX_H_SOY);
		BOX_H_SPINACH = new ItemBlock_Fuel100("block_boxh_spinach", Kitchen_Blocks.BOX_H_SPINACH);
		BOX_H_TOMATO = new ItemBlock_Fuel100("block_boxh_tomato", Kitchen_Blocks.BOX_H_TOMATO);
		BOX_H_CHERRY = new ItemBlock_Fuel100("block_boxh_cherry", Kitchen_Blocks.BOX_H_CHERRY);
		BOX_H_TAKENOKO = new ItemBlock_Fuel100("block_boxh_takenoko", Kitchen_Blocks.BOX_H_TAKENOKO);
		BOX_H_KURI = new ItemBlock_Fuel100("block_boxh_chestnut", Kitchen_Blocks.BOX_H_KURI);
		BOX_H_TGREEN = new ItemBlock_Fuel100("block_boxh_tgreen", Kitchen_Blocks.BOX_H_TGREEN);
		BOX_H_TRED = new ItemBlock_Fuel100("block_boxh_tred", Kitchen_Blocks.BOX_H_TRED);

		BOX_H_BPEPPER = new ItemBlock_Fuel100("block_boxh_bpepper", Kitchen_Blocks.BOX_H_BPEPPER);
		BOX_H_CUMIN = new ItemBlock_Fuel100("block_boxh_cumin", Kitchen_Blocks.BOX_H_CUMIN);
		BOX_H_TURMERIC = new ItemBlock_Fuel100("block_boxh_turmeric", Kitchen_Blocks.BOX_H_TURMERIC);
		BOX_H_CHILI = new ItemBlock_Fuel100("block_boxh_chili", Kitchen_Blocks.BOX_H_CHILI);
		
		CHADUTSU = new ItemBlock_noFuel("block_tea_chadutsu", Kitchen_Blocks.CHADUTSU);
		CANTEA = new ItemBlock_noFuel("block_tea_can", Kitchen_Blocks.CANTEA);
		TAWARA = new ItemBlock_Fuel200("block_tawara_cm", Kitchen_Blocks.TAWARA);

		/* 発酵 */
		KOUBOBOT_full = new BinKouboFull_Item("block_bin_koubo_f");
		NYUSANBOT_full = new BinNyusanFull_Item("block_bin_nyusan_f");
		KOUBO = new BinKoubo_Item("item_koubo");
		NYUSAN = new BinNyusan_Item("item_nyusan");

		MIZUOKE = new MizuokeKara_Item("block_mizuoke", Blocks.AIR);
		MIZUOKE_full = new MizuokeFull_Item("block_mizuoke_full");
		MIZUOKE_Milk = new ItemMizuoke_milk("item_mizuoke_milk");

		HAKKOUTARU = new ItemHakkouTaru("block_taru_hakkou");
		RINGOSHU_TARU = new ItemBlock_noFuel("block_taru_ringoshu_f", Hakkou_Blocks.RINGOSHU_TARU);
		BUDOUSHU_TARU = new ItemBlock_noFuel("block_taru_budoushu_f", Hakkou_Blocks.BUDOUSHU_TARU);
		HACHIMITSUSHU_TARU = new ItemBlock_noFuel("block_taru_hachimitsushu_f", Hakkou_Blocks.HACHIMITSUSHU_TARU);

		NAMASAKEBOT = new ItemBlock_noFuel("block_bot_sakenama_1", Hakkou_Blocks.NAMASAKEBOT);
		SAKEBOT = new ItemBlock_noFuel("block_bot_sake_1", Hakkou_Blocks.SAKEBOT);
		JUKUSAKEBOT = new ItemBlock_noFuel("block_bot_sakejuku_1", Hakkou_Blocks.JUKUSAKEBOT);
		NABEAMAZAKE_nama = new NabeAmazakeNama_Item("block_food_nabeaz_n");
		NABEAMAZAKE = new NabeCooked_Item("block_food_nabeaz_1", Hakkou_Blocks.NABEAMAZAKE);
		CIDERBOT = new ItemBlock_noFuel("block_bot_cider_1", Hakkou_Blocks.CIDERBOT);
		JUKUCIDERBOT = new ItemBlock_noFuel("block_bot_ciderjuku_1", Hakkou_Blocks.JUKUCIDERBOT);
		WINEBOT = new ItemBlock_noFuel("block_bot_wine_1", Hakkou_Blocks.WINEBOT);
		JUKUWINEBOT = new ItemBlock_noFuel("block_bot_winejuku_1", Hakkou_Blocks.JUKUWINEBOT);
		MEADBOT = new ItemBlock_noFuel("block_bot_mead_1", Hakkou_Blocks.MEADBOT);
		JUKUMEADBOT = new ItemBlock_noFuel("block_bot_meadjuku_1", Hakkou_Blocks.JUKUMEADBOT);

		SAKEGLASS = new GlassSake_Item("block_glass_sake");
		WINEGLASS = new GlassWine_Item("block_glass_wine");
		WINE_TANA = new ItemBlock_Fuel300("block_kit2_tana", Kitchen_Blocks.WINE_TANA);
		HAKUSAI_TARU = new ItemHakkouTaru_Hakusai("block_taru_hakusai_f");
		SHOUYU_TARU = new ItemHakkouTaru_Shouyu("block_taru_hakkou_2");

		SHOUYU_bot_1 = new Shouyu1_Item("block_shouyu_bot");
		SHOUYU_bot_2 = new Shouyu2_Item("block_shouyu_bot_2");
		SHOUYU_bot_3 = new Shouyu3_Item("block_shouyu_bot_3");
		SHOUYU_bot_4 = new Shouyu4_Item("block_shouyu_bot_4");

		KOMEZU_bot_1 = new Komezu1_Item("block_komezu_bot");
		KOMEZU_bot_2 = new Komezu2_Item("block_komezu_bot_2");

		DASHI_bot_1 = new Dashi1_Item("block_dashi_bot");
		DASHI_bot_2 = new Dashi2_Item("block_dashi_bot_2");
		DASHI_bot_3 = new Dashi3_Item("block_dashi_bot_3");
		DASHI_bot_4 = new Dashi4_Item("block_dashi_bot_4");

		OSAUCE_bot_1 = new OSauce1_Item("block_osauce_bot");
		OSAUCE_bot_2 = new OSauce2_Item("block_osauce_bot_2");
		OSAUCE_bot_3 = new OSauce3_Item("block_osauce_bot_3");
		OSAUCE_bot_4 = new OSauce4_Item("block_osauce_bot_4");
		MAYO_bot_1 = new Mayo1_Item("block_mayo_bot");
		MAYO_bot_2 = new Mayo2_Item("block_mayo_bot_2");
		MAYO_bot_3 = new Mayo3_Item("block_mayo_bot_3");
		MAYO_bot_4 = new Mayo4_Item("block_mayo_bot_4");
	
		/* 食器 */
		Item_MATCH = new Match_Item("item_match_cm");
		Item_SARA = new TTime_Item("item_food_sara");
		Item_DISH = new Dishes_Item().setRegistryName("item_food_dish");
		CLAY_DISH = new DishesClay_Item().setRegistryName("item_clay_dish");

		/* 中間素材 */
		SHIO = new Shio_Item("item_salt");

		MUSHIGOME = new Mushigome_Item("item_mushigome");
		KOMEKOUJI = new TTime_Item("item_komekouji");
		SHUBO = new ItemShubo("item_shubo");
		MORO = new ItemMoromi("item_moromi");
		SAKEKASU = new ItemSakekasu("item_sakekasu");

		NIMAME = new ItemNimame("item_nimame");
		MISO = new TTime_Item("item_miso");

		KOMUGI = new Komugi_Item("item_komugi");
		PASTA = new PastaNama_Item("item_pasta");

		KEIRYO_CUP = new MeasureCup_Item("block_measurecup", Blocks.AIR);
		KEIRYO_CUP_full = new MeasureCup_full("item_measurecup_full");
		KANSUI = new MeasureCup_Kansui("item_kansui");
		RAMEN_nama = new RamenNama_Item("item_ramen_n");
		
		/* 調理済み 寸胴 -> 鍋 -> フライパン */
		ZUNDOU = new Zundou_Item("block_food_zundou");
		ZUNDOU_NAMA = new ZundouNama_Item("block_food_cunabe_n");
		ZUNDOUMIZU = new ZundouMizu_Item("block_zundou_mizu");
		ZUNDOUMILK = new ZundouMilk_Item("block_zundou_milk");
		ZUNDOUSHIO = new ZundouShioMizu_Item("block_zundou_shiomizu");
		CURRYNABE = new CurryNabe_Item("block_food_cunabe_1");
		STEWNABE = new StewNabe_Item("block_food_stewnabe_1");
		DASHINABE = new ZundouDashi_Item("block_food_dashinabe_1");
		ZUNDOU_RSOUP = new ZundouRsoup_Item("block_food_rsoup_n");

		NABE_kara = new NabeKara_Item("block_food_karanabe", Blocks.AIR);
		NABE_NAMA_1 = new NabeNama1_Item("block_food_nabenama_1");
		NABE_KAISUI = new NabeKaisui_Item("block_food_nabeshio_n");
		NABE_NAMA_2 = new NabeNama2_Item("block_food_nabenama_2");
		NABE_NAMA_TK = new NabeNama_TKGohan_Item("block_food_nabegohantake_n");
		NABETORI = new NabeCooked_Item("block_food_nabe_1", Dish_Blocks.NABETORI);
		NABEMISO = new NabeCooked_Item("block_food_nabemiso_1", Dish_Blocks.NABEMISO);
		NABEGOHAN = new NabeCooked_Item("block_food_nabegohan_1", Dish_Blocks.NABEGOHAN);
		NABEGOHAN_TAKE = new NabeCooked_Item("block_food_nabegohantake_1", Dish_Blocks.NABEGOHAN_TAKE);
		NABEGOHAN_KURI = new NabeCooked_Item("block_food_nabegohankuri_1", Dish_Blocks.NABEGOHAN_KURI);
		NABECORNSOUP = new NabeCooked_Item("block_food_nabecorns_1", Dish_Blocks.NABECORNSOUP);
		NABE_SNT = new NabeCookedSNT_Item("block_food_nabecooked_snt");
		
		FRYPAN_kara = new FryPanKara_Item("block_food_frypan");
		FRYPAN_NAMA_1 = new FrypanNama1_Item("block_food_frypan_n1");
		FRYPAN_NAMA_3 = new FrypanNama3_Item("block_food_frypan_n3");
		FRYPAN_NAMA_2 = new FrypanNama2_Item("block_food_frypan_n2");
		FPKINOKOAK_nama = new ItemBlock_noFuel("block_food_frypan_n_kinokoak", Dish_Blocks.FPKINOKOAK_nama);
		FRYPAN_BAKE_1 = new FrypanBake1_Item("block_food_frypan_b1");
		FRYPAN_BAKE_2 = new FrypanBake2_Item("block_food_frypan_b2");
		FPKINOKOAK = new KinokoAmakara_Item("item_food_frypan_b_kinokoak");
		FRYPAN_NAMA_4 = new FrypanNama4_Item("block_food_frypan_n4");
		
		NIBOSHI = new FishBoiled_Item("block_niboshi");
		CURRY = new Curry_Item("block_food_curry_1", 10, 1.0F, false);
		CURRYSET = new CurrySet_Item("block_food_curryset_1");
		STEW = new Stew_Item("block_food_stew_1", 8, 0.6F, false);

		UDON_SU = new UdonSu_Item("block_food_udonsu_1", 5, 0.6F, false);
		UDON_NIKU = new UdonNT_Item("block_food_udonniku_1", 10, 0.8F, false);
		UDON_TSUKIMI = new UdonNT_Item("block_food_udontsukimi_1", 10, 0.8F, false);
		RAMEN = new Ramen_Item("block_food_ramen", 10, 1.0F, false);
		
		TONSUITORI = new ToriTonsui_Item("block_food_tonsui_1", 2, 0.5F, false);
		MISOSOUP = new MisoSoup_Item("block_food_misosp_1", 2, 0.3F, false);
		GOHAN = new Gohan_Item("block_food_gohan_1", 3, 0.6F, false);
		GOHAN_TAKE = new GohanTake_Item("block_food_gohantake_1", 3, 0.6F, false);
		GOHAN_KURI = new GohanKuri_Item("block_food_gohankuri_1", 3, 0.6F, false);
		RICE = new RiceSmall_Item("block_food_rice_1", 3, 0.6F, false);

		DONBURI_MESHI = new DonMeshi_Item("block_food_donmeshi_1", 5, 0.6F, false);
		DONBURI_GYU = new DonGOK_Item("block_food_dongyu_1", 10, 0.8F, false);
		DONBURI_OYAKO = new DonGOK_Item("block_food_donoyako_1", 10, 0.8F, false);
		DONBURI_KATSU = new DonKatsu_Item("block_food_donkatsu_1", 10, 1.0F, false);
		DONBURI_KAISEN = new DonGOK_Item("block_food_donkaisen_1", 10, 0.8F, false);
		
		FOOD_HAKUSAI2 = new ModFood_Item("item_food_hakusai2", 2, 0.6F, false);
		HAKUSAIDUKE = new Hakusaiduke_Item("block_food_hsd_1", 1, 0.2F, false);

		TAMAGOYAKI = new Tamagoyaki_Item("block_food_tgy_1", 3, 0.5F, false);
		TAMAGOYAKITEI = new Face4_1Wood_Item("block_food_tgytei_1", Dish_Blocks.TAMAGOYAKITEI);
		YAKIZAKANATEI = new Face4_1Wood_Item("block_food_yakizakanatei_1", Dish_Blocks.YAKIZAKANATEI);
		YAKIJYAKETEI = new Face4_1Wood_Item("block_food_yakijyaketei_1", Dish_Blocks.YAKIJYAKETEI);
		TAMAGOYAKITEI_TAKE = new Face4_1Wood_Item("block_food_tgyteitake_1", Dish_Blocks.TAMAGOYAKITEI_TAKE);
		YAKIZAKANATEI_TAKE = new Face4_1Wood_Item("block_food_yakizakanateitake_1", Dish_Blocks.YAKIZAKANATEI_TAKE);
		YAKIJYAKETEI_TAKE = new Face4_1Wood_Item("block_food_yakijyaketeitake_1", Dish_Blocks.YAKIJYAKETEI_TAKE);
		TAMAGOYAKITEI_KURI = new Face4_1Wood_Item("block_food_tgyteikuri_1", Dish_Blocks.TAMAGOYAKITEI_KURI);
		YAKIZAKANATEI_KURI = new Face4_1Wood_Item("block_food_yakizakanateikuri_1",Dish_Blocks.YAKIZAKANATEI_KURI);
		YAKIJYAKETEI_KURI = new Face4_1Wood_Item("block_food_yakijyaketeikuri_1", Dish_Blocks.YAKIJYAKETEI_KURI);

		CORNSOUP = new CornSoup_Item("block_food_cornsp_1", 2, 0.3F, false);
		EGGBURG = new Eggburg_Item("block_food_egb_1", 5, 0.6F, false);
		EGGBURGSET = new Face4_1Stone_Item("block_food_egbset_1", Dish_Blocks.EGGBURGSET);

		PASTATOMATO = new PastaTCK_Item("block_food_pastatoma_1", 10, 0.8F, false);
		PASTACHEESE = new PastaTCK_Item("block_food_pastacheese_1", 10, 0.8F, false);
		PASTAKINOKO = new PastaTCK_Item("block_food_pastakinoko_1", 10, 0.8F, false);
		PASTASEAFOOD = new PastaSeafood_Item("block_food_pastaseafood_1", 10, 1.0F, false);
		
		PIZZA = new PizzaCooked_Item("block_food_pizza_1");
		PC_PIZZA = new ItemPizza("item_food_pizza", 6, 0.6F, false);
		OKONOMIYAKI = new Okonomiyaki_Item("block_food_okonomiyaki_1", 8, 1.0F, false);
		CHICKEN = new Face4_1Stone_Item("block_food_roastchicken_1", Dish_Blocks.CHICKEN);
		CHICKEN_small = new ChickenSmall_Item("block_food_chickenb_1", 3, 0.5F, false);

		SUSHIMESHI = new SushiMeshi_Item("block_food_sushimeshi");
		SUSHIGETA_kara = new SushiGetaKara_Item("block_food_sushigeta_kara");
		SUSHISET_salmon = new Face4_1Wood_Item("block_food_sushiset_salmon", Dish_Blocks.SUSHISET_salmon);
		SUSHISET_fish = new Face4_1Wood_Item("block_food_sushiset_fish", Dish_Blocks.SUSHISET_fish);
		SUSHISET_beef = new Face4_1Wood_Item("block_food_sushiset_beef", Dish_Blocks.SUSHISET_beef);
		SUSHISET_tamago = new Face4_1Wood_Item("block_food_sushiset_tamago", Dish_Blocks.SUSHISET_tamago);
		SUSHISET_4shoku = new Face4_1Wood_Item("block_food_sushiset_4shoku", Dish_Blocks.SUSHISET_4shoku);
		SUSHIOKE = new SushiOkeKara_Item("block_food_sushioke_kara");
		SUSHISET_1 = new SushiOkeFull_Item("block_food_sushiokefull_1");
		SHOUYUSARA = new ShouyuSara_Item("block_food_shouyusara_1");

		Item_YAKAN_kara = new KettleKara_Item("item_kettle_kara");
		KETTLE_full = new KettleFull_Item("block_kettle_full");
		Item_YAKAN_boil = new KettleBoil_Item("item_kettle_boil");
		KYUSU_kara = new KyusuKara_Item("block_food_kyusu");
		KYUSU = new Face4_1Stone_Item("block_food_kyusu_1", Dish_Blocks.KYUSU);
		JPTEACUP = new TeaCupJP_Item("block_food_jpteacup_1"); //drink
		JPTEASET = new Face4_1Stone_Item("block_food_jpteaset_1", Dish_Blocks.JPTEASET);
		JPCHAUKE = new JPChaUke_Item("block_food_jpchauke");

		TEAPOT_kara = new TeaPotKara_Item("block_food_teapot");
		TEAPOT = new Face4_1Stone_Item("block_food_teapot_1", Dish_Blocks.TEAPOT);
		TEACUP = new TeaCup_Item("block_food_teacup_1"); //drink
		TEASET = new Face4_1Stone_Item("block_food_teaset_1", Dish_Blocks.TEASET);
		SCONESET_kara = new TeaStand_Item("block_food_teastand");
		SCONESET_1 = new SconeSet1_Item("block_food_sconeset_1");

		ICECREAM = new Icecream_Item("block_food_icecream_1", 0, 0.0F, false);

		CHEESE_CURD = new CheeseCurd_Item("block_food_cheesecurd");
		CHEESE = new CheeseBlock_Item("block_food_cheese_1");

		/*バニラの食料
		registerItem(260, "apple", (new ItemFood(4, 0.3F, false)).setUnlocalizedName("apple"));
		registerItem(391, "carrot", (new ItemSeedFood(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).setUnlocalizedName("carrots"));

		registerItem(392, "potato", (new ItemSeedFood(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).setUnlocalizedName("potato"));
		registerItem(393, "baked_potato", (new ItemFood(5, 0.6F, false)).setUnlocalizedName("potatoBaked"));

		registerItem(297, "bread", (new ItemFood(5, 0.6F, false)).setUnlocalizedName("bread"));
		5＝肉メモリ2.5個分
		registerItem(364, "cooked_beef", (new ItemFood(8, 0.8F, true)).setUnlocalizedName("beefCooked"));
		registerItem(366, "cooked_chicken", (new ItemFood(6, 0.6F, true)).setUnlocalizedName("chickenCooked"));*/

		FRESH_CHEESE = new ModFood_Item("item_food_cheesef", 1, 0.3F, false);
		PIECE_CHEESE = new ItemCheese("item_food_cheese", 1, 0.3F, false);
		CHEESE_TANA = new ItemBlock_Fuel150("block_kit_cheese_tana", Kitchen_Blocks.CHEESE_TANA);

		CAKE = new ModFood_Item("item_food_cake", 5, 0.4F, false);
		BUN = new ModFood_Item("item_food_bun", 6, 0.4F, false);
		SCONE = new ModFood_Item("item_food_scone", 4, 0.3F, false);
		SENBEI = new ItemSenbei("item_food_senbei", 4, 0.3F, false);
		TOUFU = new ModFood_Item("item_food_toufu", 4, 0.3F, false);

		CHICKENSAND = new ModFood_Item("item_food_chickensand", 6, 0.6F, false);
		EGGSAND = new ModFood_Item("item_food_eggsand", 6, 0.6F, false);
		KIRIMI = new ItemKirimi("item_food_kirimi", 1, 0.1F, false);
		SUSHI = new ItemSushi("item_food_sushi", 4, 0.6F, false);
		SHOUYUSUSHI = new ItemSushi_Shouyu("item_food_sushishouyu", 5, 0.8F, false);

		NORIAMI = new ItemBlock_noFuel("block_noriami", Crop_Blocks.NORIAMI);
		NORI_N = new TTime_Item("item_food_norinama");
		NORI_I = new ModFood_Item("item_food_noriita", 1, 0.1F, false);
		ONIGIRI = new ItemOnigiri("item_food_onigiri", 4, 0.6F, false);

		KUSHI_SAKANA = new TTime_Item("item_kushi_sakana");
		KUSHI_SAKANA_C = new KushiSakana_Item("item_kushi_sakana_c", 5, 0.8F, false);
		BENTOU = new ItemBentou("item_bentou", 10, 0.8F, false);
		MOCHI = new TTime_Item("item_mochi");
		MOCHI_FOOD = new ItemMochiFood("item_food_mochi", 4, 0.6F, false);

		KIT_TANA = new ItemBlock_Fuel150("block_kit_tana", Kitchen_Blocks.KIT_TANA);
		KITCHEN = new ItemBlock_Fuel150("block_kitchen", Kitchen_Blocks.KITCHEN);

		KIT_BOARD = new ItemBlock_Fuel300("block_kit_board", Kitchen_Blocks.KIT_BOARD);
		KIT_SINK1 = new KitSink_Item("block_kit_sink1");

		KIT_STOVE = new ItemBlock_noFuel("block_kit_stove", Kitchen_Blocks.KIT_STOVE);
		KIT_OVEN = new ItemBlock_noFuel("block_kit_oven", Kitchen_Blocks.KIT_OVEN);
		KIT_OVEN_B = new ItemBlock_noFuel("block_kit_oven_black", Kitchen_Blocks.KIT_OVEN_B);
		IRORI = new ItemBlock_noFuel("block_irori", Kitchen_Blocks.IRORI);
		KIT_REIZOU = new ItemBlock_noFuel("block_kit_reizou", Kitchen_Blocks.KIT_REIZOU);

		KIT_KANKI_1 = new ItemBlock_noFuel("block_kit_kanki", Kitchen_Blocks.KIT_KANKI_1);
		KIT_HAIKIDUCT = new ItemBlock_noFuel("block_kit_duct", Kitchen_Blocks.KIT_HAIKIDUCT);
		KIT_DUCTEND_1 = new ItemBlock_noFuel("block_kit_ductend", Kitchen_Blocks.KIT_DUCTEND_1);

		TEATABLE = new TeaTable_Item("block_teatable");
		ENDEN = new Enden_Item("block_enden");
		
		TOAMI = new Toami_Item("item_toami");
		TOAMI_W = new ToamiWide_Item("item_toami_wide", Crop_Blocks.TOAMI_W);
		CUT_IKA = new ModFood_Item("item_squid_cut", 2, 0.1F, false);
		COOKED_IKA = new ModFood_Item("item_squid_cooked", 6, 0.8F, false);
		IKA = new IkaRaw_Item("item_squid_raw");

		KAIHORI = new Kaihori_Item("item_kaihori");
		HAMAGURI_KARA = new Item().setRegistryName("item_hamaguri_shell").setUnlocalizedName("item_hamaguri_shell");
		HAMAGURI = new Hamaguri_Item("block_hamaguri", Crop_Blocks.HAMAGURI);
		HAMAGURI_COOK = new HamaguriFood_Item("item_food_hamaguri", 2, 0.3F, false);
		
		KINE_YOKO = new ItemKineTsuki("item_kineyoko");
		USU_TSUKI = new ItemBlock_Fuel300("block_usutsuki", Kitchen_Blocks.USU_TSUKI);
		
		//TEST = new TestCrop_Item();
	}

	/* アイテムを登録する, ここから Register Items. From here. ↓*/
	public static void register() {

		registerItem(SEEDSBOX);
		registerItem(SEEDS_CABBAGE);
		registerItem(SEEDS_HAKUSAI);
		registerItem(SEEDS_CORN);
		registerItem(SEEDS_GREENONION);
		registerItem(SEEDS_ONION);
		registerItem(SEEDS_RICE);
		registerItem(SEEDS_SOY);
		registerItem(SEEDS_SPINACH);
		registerItem(SEEDS_TOMATO);
		registerItem(SEEDS_CHERRY);
		registerItem(CHANOKI);
		registerItem(BUDOUNOKI);
		registerItem(MIKAN_NAE);
		registerItem(SPICE_NAE);
		registerItem(HODAGI_BOT);

		registerItem(CHABA);
		registerItem(INAGI);
		registerItem(INEWARA);
		registerItem(INE);
		registerItem(KOME);
		registerItem(SAYA);
		registerItem(SOY);
		registerItem(SPICE);
		
		registerItem(FOOD_CABBAGE);
		registerItem(FOOD_HAKUSAI);
		registerItem(FOOD_CORN);
		registerItem(FOOD_GREENONION);
		registerItem(FOOD_ONION);
		registerItem(FOOD_SPINACH);
		registerItem(FOOD_TOMATO);
		registerItem(FOOD_GRAPE);
		registerItem(FOOD_CHERRY);
		registerItem(FOOD_MIKAN);
		registerItem(FOOD_CORN_B);

		registerItem(BOX_H_EMPTY);
		registerItem(BOX_H_APPLE);
		registerItem(BOX_H_BEEF);
		registerItem(BOX_H_BEETROOT);
		registerItem(BOX_H_BREAD);
		registerItem(BOX_H_CARROT);
		registerItem(BOX_H_CHICKEN);
		registerItem(BOX_H_CHORUS);
		registerItem(BOX_H_COCO);
		registerItem(BOX_H_EGG);
		registerItem(BOX_H_FISH);
		registerItem(BOX_H_FLOUR);
		registerItem(BOX_H_MUTTON);
		registerItem(BOX_H_PORK);
		registerItem(BOX_H_POTATO);
		registerItem(BOX_H_RABBIT);
		registerItem(BOX_H_SALMON);

		registerItem(BOX_H_CABBAGE);
		registerItem(BOX_H_HAKUSAI);
		registerItem(BOX_H_CITRUS);
		registerItem(BOX_H_CORN);
		registerItem(BOX_H_GRAPE);
		registerItem(BOX_H_GREENONION);
		registerItem(BOX_H_ONION);
		registerItem(BOX_H_RICE);
		registerItem(BOX_H_SOY);
		registerItem(BOX_H_SPINACH);
		registerItem(BOX_H_TOMATO);
		registerItem(BOX_H_CHERRY);		
		registerItem(BOX_H_TAKENOKO);	
		registerItem(BOX_H_KURI);	
		registerItem(BOX_H_TGREEN);
		registerItem(BOX_H_TRED);

		registerItem(BOX_H_BPEPPER);
		registerItem(BOX_H_CUMIN);
		registerItem(BOX_H_TURMERIC);
		registerItem(BOX_H_CHILI);
		
		registerItem(CHADUTSU);
		registerItem(CANTEA);
		registerItem(TAWARA);

		registerItem(KOUBOBOT_full);
		registerItem(NYUSANBOT_full);
		registerItem(KOUBO);
		registerItem(NYUSAN);

		registerItem(MIZUOKE);
		registerItem(MIZUOKE_full);
		registerItem(MIZUOKE_Milk);

		registerItem(HAKKOUTARU);
		registerItem(RINGOSHU_TARU);
		registerItem(BUDOUSHU_TARU);
		registerItem(HACHIMITSUSHU_TARU);

		registerItem(NAMASAKEBOT);
		registerItem(SAKEBOT);
		registerItem(JUKUSAKEBOT);
		registerItem(NABEAMAZAKE_nama);
		registerItem(NABEAMAZAKE);
		registerItem(CIDERBOT);
		registerItem(JUKUCIDERBOT);
		registerItem(WINEBOT);
		registerItem(JUKUWINEBOT);
		registerItem(MEADBOT);
		registerItem(JUKUMEADBOT);

		registerItem(SAKEGLASS);
		registerItem(WINEGLASS);
		registerItem(WINE_TANA);

		registerItem(HAKUSAI_TARU);
		registerItem(SHOUYU_TARU);

		registerItem(SHOUYU_bot_1);
		registerItem(SHOUYU_bot_2);
		registerItem(SHOUYU_bot_3);
		registerItem(SHOUYU_bot_4);

		registerItem(KOMEZU_bot_1);
		registerItem(KOMEZU_bot_2);

		registerItem(DASHI_bot_1);
		registerItem(DASHI_bot_2);
		registerItem(DASHI_bot_3);
		registerItem(DASHI_bot_4);

		registerItem(OSAUCE_bot_1);
		registerItem(OSAUCE_bot_2);
		registerItem(OSAUCE_bot_3);
		registerItem(OSAUCE_bot_4);
		registerItem(MAYO_bot_1);
		registerItem(MAYO_bot_2);
		registerItem(MAYO_bot_3);
		registerItem(MAYO_bot_4);
		
		registerItem(Item_MATCH);
		registerItem(Item_SARA);
		registerItem(Item_DISH);
		registerItem(CLAY_DISH);

		registerItem(SHIO);

		registerItem(MUSHIGOME);
		registerItem(KOMEKOUJI);
		registerItem(SHUBO);
		registerItem(MORO);
		registerItem(SAKEKASU);

		registerItem(NIMAME);
		registerItem(MISO);

		registerItem(KOMUGI);
		registerItem(PASTA);
		registerItem(KEIRYO_CUP);
		registerItem(KEIRYO_CUP_full);
		registerItem(KANSUI);
		registerItem(RAMEN_nama);
		
		registerItem(ZUNDOU);
		registerItem(ZUNDOU_NAMA);
		registerItem(ZUNDOUMIZU);
		registerItem(ZUNDOUMILK);
		registerItem(ZUNDOUSHIO);
		registerItem(CURRYNABE);
		registerItem(STEWNABE);
		registerItem(DASHINABE);
		registerItem(ZUNDOU_RSOUP);

		registerItem(NABE_kara);
		registerItem(NABE_NAMA_1);
		registerItem(NABE_KAISUI);
		registerItem(NABE_NAMA_2);
		registerItem(NABE_NAMA_TK);
		registerItem(NABETORI);
		registerItem(NABEMISO);
		registerItem(NABEGOHAN);
		registerItem(NABEGOHAN_TAKE);
		registerItem(NABEGOHAN_KURI);
		registerItem(NABECORNSOUP);
		registerItem(NABE_SNT);

		registerItem(FRYPAN_kara);
		registerItem(FRYPAN_NAMA_1);
		registerItem(FRYPAN_NAMA_3);
		registerItem(FRYPAN_NAMA_2);
		registerItem(FPKINOKOAK_nama);
		registerItem(FRYPAN_NAMA_4);
		registerItem(FRYPAN_BAKE_1);
		registerItem(FRYPAN_BAKE_2);
		registerItem(FPKINOKOAK);

		registerItem(NIBOSHI);
		registerItem(CURRY);
		registerItem(CURRYSET);
		registerItem(STEW);

		registerItem(UDON_SU);
		registerItem(UDON_NIKU);
		registerItem(UDON_TSUKIMI);
		registerItem(RAMEN);
		
		registerItem(TONSUITORI);
		registerItem(MISOSOUP);
		registerItem(GOHAN);
		registerItem(GOHAN_TAKE);
		registerItem(GOHAN_KURI);
		registerItem(RICE);

		registerItem(DONBURI_MESHI);
		registerItem(DONBURI_GYU);
		registerItem(DONBURI_OYAKO);
		registerItem(DONBURI_KATSU);
		registerItem(DONBURI_KAISEN);
		
		registerItem(FOOD_HAKUSAI2);
		registerItem(HAKUSAIDUKE);

		registerItem(TAMAGOYAKI);
		registerItem(TAMAGOYAKITEI);
		registerItem(YAKIZAKANATEI);
		registerItem(YAKIJYAKETEI);
		registerItem(TAMAGOYAKITEI_TAKE);
		registerItem(YAKIZAKANATEI_TAKE);
		registerItem(YAKIJYAKETEI_TAKE);
		registerItem(TAMAGOYAKITEI_KURI);
		registerItem(YAKIZAKANATEI_KURI);
		registerItem(YAKIJYAKETEI_KURI);
		
		registerItem(CORNSOUP);
		registerItem(EGGBURG);
		registerItem(EGGBURGSET);

		registerItem(PASTATOMATO);
		registerItem(PASTACHEESE);
		registerItem(PASTAKINOKO);
		registerItem(PASTASEAFOOD);
		
		registerItem(PIZZA);
		registerItem(PC_PIZZA);
		registerItem(OKONOMIYAKI);
		registerItem(CHICKEN);
		registerItem(CHICKEN_small);

		registerItem(SUSHIMESHI);
		registerItem(SUSHIGETA_kara);
		registerItem(SUSHISET_salmon);
		registerItem(SUSHISET_fish);
		registerItem(SUSHISET_beef);
		registerItem(SUSHISET_tamago);
		registerItem(SUSHISET_4shoku);
		registerItem(SUSHIOKE);
		registerItem(SUSHISET_1);
		registerItem(SHOUYUSARA);

		registerItem(Item_YAKAN_kara);
		registerItem(KETTLE_full);
		registerItem(Item_YAKAN_boil);
		registerItem(KYUSU_kara);
		registerItem(KYUSU);
		registerItem(JPTEACUP);
		registerItem(JPTEASET);
		registerItem(JPCHAUKE);

		registerItem(TEAPOT_kara);
		registerItem(TEAPOT);
		registerItem(TEACUP);
		registerItem(TEASET);
		registerItem(SCONESET_kara);
		registerItem(SCONESET_1);

		registerItem(ICECREAM);

		registerItem(CHEESE_CURD);
		registerItem(CHEESE);
		registerItem(FRESH_CHEESE);
		registerItem(PIECE_CHEESE);
		registerItem(CHEESE_TANA);

		registerItem(CAKE);
		registerItem(BUN);
		registerItem(SCONE);
		registerItem(SENBEI);
		registerItem(TOUFU);
		registerItem(CHICKENSAND);
		registerItem(EGGSAND);
		registerItem(KIRIMI);
		registerItem(SUSHI);
		registerItem(SHOUYUSUSHI);

		registerItem(NORIAMI);
		registerItem(NORI_N);
		registerItem(NORI_I);
		registerItem(ONIGIRI);

		registerItem(KUSHI_SAKANA);
		registerItem(KUSHI_SAKANA_C);
		registerItem(BENTOU);
		registerItem(MOCHI);
		registerItem(MOCHI_FOOD);

		registerItem(KIT_TANA);
		registerItem(KITCHEN);
		registerItem(KIT_BOARD);
		registerItem(KIT_SINK1);
		registerItem(KIT_STOVE);
		registerItem(KIT_OVEN);
		registerItem(KIT_OVEN_B);
		registerItem(IRORI);
		registerItem(KIT_REIZOU);

		registerItem(KIT_KANKI_1);
		registerItem(KIT_HAIKIDUCT);
		registerItem(KIT_DUCTEND_1);

		registerItem(TEATABLE);
		registerItem(ENDEN);
		
		registerItem(TOAMI);
		registerItem(TOAMI_W);
		registerItem(CUT_IKA);
		registerItem(COOKED_IKA);
		registerItem(IKA);
		
		registerItem(KAIHORI);
		registerItem(HAMAGURI_KARA);
		registerItem(HAMAGURI);
		registerItem(HAMAGURI_COOK);
		registerItem(KINE_YOKO);
		registerItem(USU_TSUKI);

		//registerItem(TEST);
		/** registerItem の順番に沿って, registerRenders が表示される **/
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}
	/*ここまで So far↑ */


	/* ドロップ時やインベントリにおける, アイテムの描画を登録。ここから↓
	* Register rendering of Items in drop and inventory. From here↓*/
	public static void registerRenders() {
		registerRender(SEEDSBOX);
		registerRender(SEEDS_CABBAGE);
		registerRender(SEEDS_HAKUSAI);
		registerRender(SEEDS_CORN);
		registerRender(SEEDS_GREENONION);
		registerRender(SEEDS_ONION);
		registerRender(SEEDS_RICE);
		registerRender(SEEDS_SOY);
		registerRender(SEEDS_SPINACH);
		registerRender(SEEDS_TOMATO);
		registerRender(SEEDS_CHERRY);
		registerRender(CHANOKI);
		registerRender(BUDOUNOKI);
		registerRender(MIKAN_NAE);
		registerRenderMeta(SPICE_NAE, 0, "item_seeds_pepper");
		registerRenderMeta(SPICE_NAE, 1, "item_seeds_cumin");
		registerRenderMeta(SPICE_NAE, 2, "item_seeds_turmeric");
		registerRenderMeta(SPICE_NAE, 3, "item_seeds_chilipepper");
		registerRender(HODAGI_BOT);

		registerRenderMeta(CHABA, 0, "item_chaba");
		registerRenderMeta(CHABA, 1, "item_chaba_green");
		registerRenderMeta(CHABA, 2, "item_chaba_red");
		registerRender(INAGI);
		registerRender(INEWARA);
		registerRenderMeta(INE, 0, "item_ine");
		registerRenderMeta(INE, 1, "item_ine_dry");
		registerRender(KOME);
		registerRender(SAYA);
		registerRender(SOY);
		registerRenderMeta(SPICE, 0, "item_crop_pepper");
		registerRenderMeta(SPICE, 1, "item_crop_pepperdry");
		registerRenderMeta(SPICE, 2, "item_crop_chilipepper");
		registerRenderMeta(SPICE, 3, "item_dust_blackpepper");
		registerRenderMeta(SPICE, 4, "item_dust_cumin");
		registerRenderMeta(SPICE, 5, "item_dust_turmeric");
		registerRenderMeta(SPICE, 6, "item_dust_chili");
		registerRenderMeta(SPICE, 7, "item_curry_roux");

		registerRender(FOOD_CABBAGE);
		registerRender(FOOD_HAKUSAI);
		registerRender(FOOD_CORN);
		registerRender(FOOD_GREENONION);
		registerRender(FOOD_ONION);
		registerRender(FOOD_SPINACH);
		registerRender(FOOD_TOMATO);
		registerRender(FOOD_GRAPE);
		registerRender(FOOD_CHERRY);
		registerRender(FOOD_MIKAN);
		registerRender(FOOD_CORN_B);

		registerRender(BOX_H_EMPTY);
		registerRender(BOX_H_APPLE);
		registerRender(BOX_H_BEEF);
		registerRender(BOX_H_BEETROOT);
		registerRender(BOX_H_BREAD);
		registerRender(BOX_H_CARROT);
		registerRender(BOX_H_CHICKEN);
		registerRender(BOX_H_CHORUS);
		registerRender(BOX_H_COCO);
		registerRender(BOX_H_EGG);
		registerRender(BOX_H_FISH);
		registerRender(BOX_H_FLOUR);
		registerRender(BOX_H_MUTTON);
		registerRender(BOX_H_PORK);
		registerRender(BOX_H_POTATO);
		registerRender(BOX_H_RABBIT);
		registerRender(BOX_H_SALMON);

		registerRender(BOX_H_CABBAGE);
		registerRender(BOX_H_HAKUSAI);
		registerRender(BOX_H_CITRUS);
		registerRender(BOX_H_CORN);
		registerRender(BOX_H_GRAPE);
		registerRender(BOX_H_GREENONION);
		registerRender(BOX_H_ONION);
		registerRender(BOX_H_RICE);
		registerRender(BOX_H_SOY);
		registerRender(BOX_H_SPINACH);
		registerRender(BOX_H_TOMATO);
		registerRender(BOX_H_CHERRY);		
		registerRender(BOX_H_TAKENOKO);	
		registerRender(BOX_H_KURI);	
		registerRender(BOX_H_TGREEN);
		registerRender(BOX_H_TRED);

		registerRender(BOX_H_BPEPPER);
		registerRender(BOX_H_CUMIN);
		registerRender(BOX_H_TURMERIC);
		registerRender(BOX_H_CHILI);
		
		registerRender(CHADUTSU);
		registerRender(CANTEA);
		registerRender(TAWARA);

		registerRender(KOUBOBOT_full);
		registerRender(NYUSANBOT_full);
		registerRender(KOUBO);
		registerRender(NYUSAN);

		registerRender(MIZUOKE);
		registerRender(MIZUOKE_full);
		registerRender(MIZUOKE_Milk);

		registerRenderMeta(HAKKOUTARU, 0, "block_taru_hakkou");
		registerRenderMeta(HAKKOUTARU, 1, "block_taru_kouji_f");
		registerRenderMeta(HAKKOUTARU, 2, "block_taru_shubo_f");
		registerRenderMeta(HAKKOUTARU, 3, "block_taru_moromi_f");
		registerRenderMeta(HAKKOUTARU, 4, "block_taru_jukusei_f");
		registerRender(RINGOSHU_TARU);
		registerRender(BUDOUSHU_TARU);
		registerRender(HACHIMITSUSHU_TARU);

		registerRender(NAMASAKEBOT);
		registerRender(SAKEBOT);
		registerRender(JUKUSAKEBOT);
		registerRender(NABEAMAZAKE_nama);
		registerRender(NABEAMAZAKE);
		registerRender(CIDERBOT);
		registerRender(JUKUCIDERBOT);
		registerRender(WINEBOT);
		registerRender(JUKUWINEBOT);
		registerRender(MEADBOT);
		registerRender(JUKUMEADBOT);

		registerRenderMeta(SAKEGLASS, 1, "block_glass_sakenama");
		registerRenderMeta(SAKEGLASS, 2, "block_glass_sake");
		registerRenderMeta(SAKEGLASS, 3, "block_glass_sakejuku");
		registerRenderMeta(SAKEGLASS, 4, "block_glass_amazake");
		registerRenderMeta(WINEGLASS, 1, "block_glass_wine");
		registerRenderMeta(WINEGLASS, 2, "block_glass_winejuku");
		registerRenderMeta(WINEGLASS, 3, "block_glass_cider");
		registerRenderMeta(WINEGLASS, 4, "block_glass_ciderjuku");
		registerRenderMeta(WINEGLASS, 5, "block_glass_mead");
		registerRenderMeta(WINEGLASS, 6, "block_glass_meadjuku");
		registerRender(WINE_TANA);

		registerRenderMeta(HAKKOUTARU, 5, "block_taru_miso_f");
		registerRenderMeta(HAKUSAI_TARU, 1, "block_taru_hakusai_f");
		registerRenderMeta(HAKUSAI_TARU, 2, "block_taru_hakusai_f2");

		registerRenderMeta(SHOUYU_TARU, 1, "block_taru_shouyu_f");
		registerRenderMeta(SHOUYU_TARU, 2, "block_taru_komezu_f");
		registerRenderMeta(SHOUYU_TARU, 3, "block_taru_kinoko_f");
		registerRenderMeta(SHOUYU_TARU, 4, "block_taru_nori_f");
		registerRenderMeta(SHOUYU_TARU, 5, "block_taru_pepper_f");
		registerRenderMeta(HAKKOUTARU, 6, "block_taru_koucha_f");

		registerRender(SHOUYU_bot_1);
		registerRender(SHOUYU_bot_2);
		registerRender(SHOUYU_bot_3);
		registerRender(SHOUYU_bot_4);

		registerRender(KOMEZU_bot_1);
		registerRender(KOMEZU_bot_2);

		registerRender(DASHI_bot_1);
		registerRender(DASHI_bot_2);
		registerRender(DASHI_bot_3);
		registerRender(DASHI_bot_4);

		registerRender(OSAUCE_bot_1);
		registerRender(OSAUCE_bot_2);
		registerRender(OSAUCE_bot_3);
		registerRender(OSAUCE_bot_4);
		registerRender(MAYO_bot_1);
		registerRender(MAYO_bot_2);
		registerRender(MAYO_bot_3);
		registerRender(MAYO_bot_4);
		
		registerRender(Item_MATCH);
		registerRender(Item_SARA);
		registerRenderMeta(Item_DISH, 1, "item_food_yunomi");
		registerRenderMeta(Item_DISH, 2, "item_food_teacup");
		registerRenderMeta(Item_DISH, 3, "item_food_chawan");
		registerRenderMeta(Item_DISH, 4, "item_food_shikki");
		registerRenderMeta(Item_DISH, 5, "item_food_tonsui");
		registerRenderMeta(Item_DISH, 6, "item_food_donburi");
		registerRenderMeta(Item_DISH, 7, "item_food_driglass");
		registerRenderMeta(Item_DISH, 8, "item_food_sakebot");
		registerRenderMeta(Item_DISH, 9, "item_bentouhako");
		
		registerRenderMeta(CLAY_DISH, 1, "item_clay_sara");
		registerRenderMeta(CLAY_DISH, 2, "item_clay_yunomi");
		registerRenderMeta(CLAY_DISH, 3, "item_clay_kyusu");
		registerRenderMeta(CLAY_DISH, 4, "item_clay_teacup");
		registerRenderMeta(CLAY_DISH, 5, "item_clay_teapot");
		registerRenderMeta(CLAY_DISH, 6, "item_clay_chawan");
		registerRenderMeta(CLAY_DISH, 7, "item_clay_nabe");
		registerRenderMeta(CLAY_DISH, 8, "item_clay_tonsui");
		registerRenderMeta(CLAY_DISH, 9, "item_clay_donburi");

		registerRenderMeta(SHIO, 0, "item_salt");
		registerRenderMeta(SHIO, 1, "item_nigari");
		registerRenderMeta(SHIO, 2, "item_rennet");

		registerRenderMeta(MUSHIGOME, 0, "item_mushigome");
		registerRenderMeta(MUSHIGOME, 1, "item_mushigome_take");
		registerRenderMeta(MUSHIGOME, 2, "item_mushigome_kuri");
		registerRender(KOMEKOUJI);
		registerRender(SHUBO);
		registerRender(MORO);
		registerRender(SAKEKASU);

		registerRender(NIMAME);
		registerRender(MISO);

		registerRenderMeta(KOMUGI, 1, "item_flour");
		registerRenderMeta(KOMUGI, 2, "item_butter");
		registerRenderMeta(KOMUGI, 3, "item_kiji_bun");
		registerRenderMeta(KOMUGI, 4, "item_kiji_burg");
		registerRenderMeta(KOMUGI, 5, "item_kiji_scone");
		registerRenderMeta(KOMUGI, 6, "item_kiji_senbei");
		registerRenderMeta(KOMUGI, 7, "item_kiji_pizza");
		registerRenderMeta(KOMUGI, 8, "item_food_pizza_n");
		registerRenderMeta(KOMUGI, 9, "item_food_pizza_cn");
		registerRenderMeta(KOMUGI, 10, "item_food_pizza_tn");
		registerRenderMeta(KOMUGI, 11, "item_food_pizza_sn");
		
		registerRenderMeta(PASTA, 1, "item_food_pasta_n");
		registerRenderMeta(PASTA, 2, "item_food_pasta_s");
		registerRenderMeta(PASTA, 3, "item_food_udon_n");
		registerRenderMeta(PASTA, 4, "item_food_shouyu_don");
		registerRenderMeta(PASTA, 5, "item_food_tsuyu_don");

		registerRender(KEIRYO_CUP);
		registerRender(KEIRYO_CUP_full);
		registerRender(KANSUI);
		registerRenderMeta(RAMEN_nama, 0, "item_food_ramen_n");
		registerRenderMeta(RAMEN_nama, 1, "item_food_tare_shouyu");
		registerRenderMeta(RAMEN_nama, 2, "item_food_tare_miso");
		registerRenderMeta(RAMEN_nama, 3, "item_food_tare_shio");
		registerRenderMeta(RAMEN_nama, 4, "item_food_rsoup_shouyu");
		registerRenderMeta(RAMEN_nama, 5, "item_food_rsoup_miso");
		registerRenderMeta(RAMEN_nama, 6, "item_food_rsoup_shio");
		registerRenderMeta(RAMEN_nama, 7, "item_food_sobaplate");
		
		registerRender(ZUNDOU);
		registerRenderMeta(ZUNDOU_NAMA, 2, "block_food_cunabe_n");
		registerRenderMeta(ZUNDOU_NAMA, 1, "block_food_cunabe_cn");
		registerRenderMeta(ZUNDOU_NAMA, 4, "block_food_cunabe_tn");
		registerRenderMeta(ZUNDOU_NAMA, 3, "block_food_stewnabe_n");
		registerRender(ZUNDOUMIZU);
		registerRender(ZUNDOUMILK);
		registerRender(ZUNDOUSHIO);
		registerRenderMeta(CURRYNABE, 0, "block_food_cunabe_1");
		registerRenderMeta(CURRYNABE, 1, "block_food_cunabe_c1");
		registerRenderMeta(CURRYNABE, 2, "block_food_cunabe_t1");
		registerRender(STEWNABE);
		registerRender(DASHINABE);
		registerRenderMeta(ZUNDOU_RSOUP, 0, "block_food_rsoup_n");
		registerRenderMeta(ZUNDOU_RSOUP, 1, "block_food_rsoup_1");

		registerRender(NABE_kara);
		registerRenderMeta(NABE_NAMA_1, 1, "block_food_nabe_n");
		registerRenderMeta(NABE_NAMA_1, 2, "block_food_nabemiso_n");
		registerRenderMeta(NABE_NAMA_1, 3, "block_food_nabegohan_n");
		registerRenderMeta(NABE_NAMA_1, 4, "block_food_nabecorns_n");

		registerRender(NABE_KAISUI);
		registerRenderMeta(NABE_NAMA_2, 2, "block_food_nabenimame_n");
		registerRenderMeta(NABE_NAMA_2, 3, "block_food_nabetoufu_n");
		registerRenderMeta(NABE_NAMA_TK, 1, "block_food_nabegohantake_n");
		registerRenderMeta(NABE_NAMA_TK, 2, "block_food_nabegohankuri_n");
		
		registerRender(NABETORI);
		registerRender(NABEMISO);
		registerRender(NABEGOHAN);
		registerRender(NABEGOHAN_TAKE);
		registerRender(NABEGOHAN_KURI);
		registerRender(NABECORNSOUP);

		registerRenderMeta(NABE_SNT, 1, "block_food_nabeshio_b");
		registerRenderMeta(NABE_SNT, 2, "block_food_nabenimame_b");
		registerRenderMeta(NABE_SNT, 3, "block_food_nabetoufu_b");
		
		registerRender(FRYPAN_kara);
		registerRenderMeta(FRYPAN_NAMA_1, 1, "block_food_frypan_n_tamago");
		registerRenderMeta(FRYPAN_NAMA_1, 2, "block_food_frypan_n_eggb");
		registerRenderMeta(FRYPAN_NAMA_1, 3, "block_food_frypan_n_tomatos");
		registerRenderMeta(FRYPAN_NAMA_1, 4, "block_food_frypan_n_kinokos");
		registerRenderMeta(FRYPAN_NAMA_3, 1, "block_food_frypan_n_seafood");
		registerRenderMeta(FRYPAN_NAMA_3, 3, "block_food_frypan_n_roux");
		
		registerRenderMeta(FRYPAN_NAMA_2, 1, "block_food_frypan_n_gyudon");
		registerRenderMeta(FRYPAN_NAMA_2, 2, "block_food_frypan_n_oyakodon");
		registerRenderMeta(FRYPAN_NAMA_2, 3, "block_food_frypan_n_katsu");
		registerRenderMeta(FRYPAN_NAMA_2, 4, "block_food_frypan_n_katsudon");
		registerRender(FPKINOKOAK_nama);
		registerRenderMeta(FRYPAN_NAMA_4, 1, "block_food_frypan_n_osauce");
		registerRenderMeta(FRYPAN_NAMA_4, 2, "block_food_teppan_n_okonomiyaki");
		registerRenderMeta(FRYPAN_NAMA_4, 3, "block_food_teppan_n_okonomis");
		registerRenderMeta(FRYPAN_NAMA_4, 4, "block_food_teppan_n_okonomic");
		registerRenderMeta(FRYPAN_NAMA_4, 5, "block_food_teppan_n_okonomisoba");
		registerRenderMeta(FRYPAN_NAMA_4, 6, "block_food_teppan_n_okonomisobas");
		registerRenderMeta(FRYPAN_NAMA_4, 7, "block_food_teppan_n_okonomisobac");
		registerRenderMeta(FRYPAN_NAMA_4, 8, "block_food_teppan_n_yakisoba");
		registerRenderMeta(FRYPAN_NAMA_4, 9, "block_food_teppan_n_yakisobashio");
		
		registerRenderMeta(FRYPAN_BAKE_1, 1, "block_food_frypan_b_tamago");
		registerRenderMeta(FRYPAN_BAKE_1, 2, "block_food_frypan_b_eggb");
		registerRenderMeta(FRYPAN_BAKE_1, 3, "block_food_frypan_b_tomatos");
		registerRenderMeta(FRYPAN_BAKE_1, 4, "block_food_frypan_b_kinokos");
		registerRenderMeta(FRYPAN_NAMA_3, 2, "block_food_frypan_b_seafood");
		
		registerRenderMeta(FRYPAN_BAKE_2, 1, "block_food_frypan_b_gyudon");
		registerRenderMeta(FRYPAN_BAKE_2, 2, "block_food_frypan_b_oyakodon");
		registerRenderMeta(FRYPAN_BAKE_2, 3, "block_food_frypan_b_katsu");
		registerRenderMeta(FRYPAN_BAKE_2, 4, "block_food_frypan_b_katsudon");
		registerRender(FPKINOKOAK);

		registerRender(NIBOSHI);
		registerRenderMeta(CURRY, 0, "block_food_curry_1");
		registerRenderMeta(CURRY, 1, "block_food_curry_c1");
		registerRenderMeta(CURRY, 2, "block_food_curry_t1");
		registerRenderMeta(CURRYSET, 0, "block_food_curryset_1");
		registerRenderMeta(CURRYSET, 1, "block_food_curryset_c1");
		registerRenderMeta(CURRYSET, 2, "block_food_curryset_t1");
		registerRender(STEW);

		registerRender(UDON_SU);
		registerRender(UDON_NIKU);
		registerRender(UDON_TSUKIMI);
		registerRenderMeta(RAMEN, 0, "block_food_ramenshouyu_1");
		registerRenderMeta(RAMEN, 1, "block_food_ramenmiso_1");
		registerRenderMeta(RAMEN, 2, "block_food_ramenshio_1");
		
		registerRender(TONSUITORI);
		registerRender(MISOSOUP);
		registerRender(GOHAN);
		registerRender(GOHAN_TAKE);
		registerRender(GOHAN_KURI);
		registerRender(RICE);

		registerRender(DONBURI_MESHI);
		registerRender(DONBURI_GYU);
		registerRender(DONBURI_OYAKO);
		registerRender(DONBURI_KATSU);
		registerRender(DONBURI_KAISEN);
		
		registerRender(FOOD_HAKUSAI2);
		registerRender(HAKUSAIDUKE);

		registerRender(TAMAGOYAKI);
		registerRender(TAMAGOYAKITEI);
		registerRender(YAKIZAKANATEI);
		registerRender(YAKIJYAKETEI);
		registerRender(TAMAGOYAKITEI_TAKE);
		registerRender(YAKIZAKANATEI_TAKE);
		registerRender(YAKIJYAKETEI_TAKE);
		registerRender(TAMAGOYAKITEI_KURI);
		registerRender(YAKIZAKANATEI_KURI);
		registerRender(YAKIJYAKETEI_KURI);
		
		registerRender(CORNSOUP);
		registerRender(EGGBURG);
		registerRender(EGGBURGSET);

		registerRender(PASTATOMATO);
		registerRender(PASTACHEESE);
		registerRender(PASTAKINOKO);
		registerRender(PASTASEAFOOD);
		
		registerRenderMeta(PIZZA, 0, "block_food_pizza_1");
		registerRenderMeta(PIZZA, 1, "block_food_pizza_c1");
		registerRenderMeta(PIZZA, 2, "block_food_pizza_t1");
		registerRenderMeta(PIZZA, 3, "block_food_pizza_s1");
		registerRenderMeta(PC_PIZZA, 0, "item_food_pizza");
		registerRenderMeta(PC_PIZZA, 1, "item_food_pizzac");
		registerRenderMeta(PC_PIZZA, 2, "item_food_pizzas");
		registerRenderMeta(PC_PIZZA, 3, "item_food_pizzat");
		registerRenderMeta(OKONOMIYAKI, 0, "block_food_okonomiyaki_1");
		registerRenderMeta(OKONOMIYAKI, 1, "block_food_okonomis_1");
		registerRenderMeta(OKONOMIYAKI, 2, "block_food_okonomic_1");
		registerRenderMeta(OKONOMIYAKI, 3, "block_food_okonomisoba_1");
		registerRenderMeta(OKONOMIYAKI, 4, "block_food_okonomisobas_1");
		registerRenderMeta(OKONOMIYAKI, 5, "block_food_okonomisobac_1");
		registerRenderMeta(OKONOMIYAKI, 6, "block_food_yakisoba_1");
		registerRenderMeta(OKONOMIYAKI, 7, "block_food_yakisobashio_1");
		
		registerRender(CHICKEN);
		registerRender(CHICKEN_small);

		registerRender(SUSHIMESHI);
		registerRender(SUSHIGETA_kara);
		registerRender(SUSHISET_salmon);
		registerRender(SUSHISET_fish);
		registerRender(SUSHISET_beef);
		registerRender(SUSHISET_tamago);
		registerRender(SUSHISET_4shoku);
		registerRender(SUSHIOKE);
		registerRender(SUSHISET_1);
		registerRender(SHOUYUSARA);

		registerRender(Item_YAKAN_kara);
		registerRender(KETTLE_full);
		registerRender(Item_YAKAN_boil);
		registerRender(KYUSU_kara);
		registerRender(KYUSU);
		registerRender(JPTEACUP);
		registerRender(JPTEASET);
		registerRenderMeta(JPCHAUKE, 0, "block_food_senbei");
		registerRenderMeta(JPCHAUKE, 1, "block_food_mikan");
		registerRenderMeta(JPCHAUKE, 2, "block_food_scone");

		registerRender(TEAPOT_kara);
		registerRender(TEAPOT);
		registerRender(TEACUP);
		registerRender(TEASET);
		registerRender(SCONESET_kara);
		registerRender(SCONESET_1);

		registerRender(ICECREAM);

		registerRender(CHEESE_CURD);
		registerRender(CHEESE);
		registerRender(FRESH_CHEESE);
		registerRender(PIECE_CHEESE);
		registerRender(CHEESE_TANA);

		registerRender(CAKE);
		registerRender(BUN);
		registerRender(SCONE);
		registerRender(SENBEI);
		registerRender(TOUFU);
		registerRender(CHICKENSAND);
		registerRender(EGGSAND);
		registerRenderMeta(KIRIMI, 1, "item_food_kirimi_salmon");
		registerRenderMeta(KIRIMI, 2, "item_food_kirimi_fish");
		registerRenderMeta(KIRIMI, 3, "item_food_kirimi_beef");
		registerRenderMeta(KIRIMI, 4, "item_food_kirimi_tamago");

		registerRenderMeta(SUSHI, 1, "item_food_sushi_salmon");
		registerRenderMeta(SUSHI, 2, "item_food_sushi_fish");
		registerRenderMeta(SUSHI, 3, "item_food_sushi_beef");
		registerRenderMeta(SUSHI, 4, "item_food_sushi_tamago");

		registerRenderMeta(SHOUYUSUSHI, 1, "item_food_sushishouyu_salmon");
		registerRenderMeta(SHOUYUSUSHI, 2, "item_food_sushishouyu_fish");
		registerRenderMeta(SHOUYUSUSHI, 3, "item_food_sushishouyu_beef");
		registerRenderMeta(SHOUYUSUSHI, 4, "item_food_sushishouyu_tamago");

		registerRender(NORIAMI);
		registerRender(NORI_N);
		registerRender(NORI_I);
		registerRenderMeta(ONIGIRI, 0, "item_food_onigiri");
		registerRenderMeta(ONIGIRI, 1, "item_food_onigirishake");
		registerRenderMeta(ONIGIRI, 3, "item_food_onigiritakenoko");
		registerRenderMeta(ONIGIRI, 4, "item_food_onigirikuri");
		registerRenderMeta(ONIGIRI, 2, "item_food_futomaki");

		registerRender(KUSHI_SAKANA);
		registerRender(KUSHI_SAKANA_C);

		registerRenderMeta(BENTOU, 0, "item_bentou");
		registerRenderMeta(BENTOU, 1, "item_bentoushake");
		registerRenderMeta(BENTOU, 2, "item_bentou_take");
		registerRenderMeta(BENTOU, 3, "item_bentoushake_take");
		registerRenderMeta(BENTOU, 4, "item_bentou_kuri");
		registerRenderMeta(BENTOU, 5, "item_bentoushake_kuri");
		registerRender(MOCHI);
		registerRenderMeta(MOCHI_FOOD, 0, "item_food_mochinori");
		registerRenderMeta(MOCHI_FOOD, 1, "item_food_mochikinako");

		registerRender(KIT_TANA);
		registerRender(KITCHEN);
		registerRender(KIT_BOARD);
		registerRender(KIT_SINK1);

		registerRender(KIT_STOVE);
		registerRender(KIT_OVEN);
		registerRender(KIT_OVEN_B);
		registerRender(IRORI);
		registerRender(KIT_REIZOU);

		registerRender(KIT_KANKI_1);
		registerRender(KIT_HAIKIDUCT);
		registerRender(KIT_DUCTEND_1);

		registerRender(TEATABLE);
		registerRender(ENDEN);
		
		registerRender(TOAMI);
		registerRender(TOAMI_W);
		registerRender(CUT_IKA);
		registerRender(COOKED_IKA);
		registerRender(IKA);
		
		registerRender(KAIHORI);
		registerRender(HAMAGURI_KARA);
		registerRender(HAMAGURI);
		registerRender(HAMAGURI_COOK);
		registerRender(KINE_YOKO);
		registerRender(USU_TSUKI);

		/*registerRenderMeta(TEST, 0, "test_crop_0");
		registerRenderMeta(TEST, 1, "test_crop_1");
		registerRenderMeta(TEST, 2, "test_crop_2");
		registerRenderMeta(TEST, 3, "test_crop_3");
		registerRenderMeta(TEST, 4, "test_crop_4");
		registerRenderMeta(TEST, 5, "test_crop_5");
		registerRenderMeta(TEST, 6, "test_crop_6");
		registerRenderMeta(TEST, 7, "test_crop_7");
		registerRenderMeta(TEST, 8, "test_crop_8");
		registerRenderMeta(TEST, 9, "test_crop_9");
		registerRenderMeta(TEST, 10, "test_crop_10");
		registerRenderMeta(TEST, 11, "test_crop_11");
		registerRenderMeta(TEST, 12, "test_crop_12");
		registerRenderMeta(TEST, 13, "test_crop_13");
		registerRenderMeta(TEST, 14, "test_crop_14");
		registerRenderMeta(TEST, 15, "test_crop_15"); */ 
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}
	/*ここまで So far↑ */
}
