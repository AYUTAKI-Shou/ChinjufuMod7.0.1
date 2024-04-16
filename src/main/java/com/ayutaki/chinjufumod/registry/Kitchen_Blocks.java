package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.furnace.Lit_Irori;
import com.ayutaki.chinjufumod.blocks.hakkou.Kit_Cheese_AAA;
import com.ayutaki.chinjufumod.blocks.hakkou.Kit_Cheese_OAA;
import com.ayutaki.chinjufumod.blocks.hakkou.Kit_Cheese_Tana;
import com.ayutaki.chinjufumod.blocks.hakkou.Kit_Tana2;
import com.ayutaki.chinjufumod.blocks.hakkou.Kit_Tana2Sake;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_aida;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_on;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaChawan_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaChawan_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDonburi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_E;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSara_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSara_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaShikki_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaShikki_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSushiGeta_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTcup_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTcup_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTonsui_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTonsui_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaYunomi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaYunomi_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_board;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_duct;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_ductend;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_kanki_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_kanki_on;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Sink_bot;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Sink_top;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen_Donabe;
import com.ayutaki.chinjufumod.blocks.kitchen.Reizou;
import com.ayutaki.chinjufumod.blocks.kitchen.ReizouTop;
import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.blocks.pantry.Box_H;
import com.ayutaki.chinjufumod.blocks.pantry.Box_HCM;
import com.ayutaki.chinjufumod.blocks.pantry.CanTea;
import com.ayutaki.chinjufumod.blocks.pantry.Chadutsu;
import com.ayutaki.chinjufumod.blocks.pantry.Sack_H;
import com.ayutaki.chinjufumod.blocks.pantry.Tawara;

import net.minecraft.block.Block;

public class Kitchen_Blocks {

	public static Box_H BOX_H_EMPTY;
	public static Box_H BOX_H_APPLE;
	public static Box_H BOX_H_BEEF;
	public static Box_H BOX_H_BEETROOT;
	public static Box_H BOX_H_BREAD;
	public static Box_H BOX_H_CARROT;
	public static Box_H BOX_H_CHICKEN;
	public static Box_H BOX_H_CHORUS;
	public static Sack_H BOX_H_COCO;
	public static Box_H BOX_H_EGG;
	public static Box_H BOX_H_FISH;
	public static Sack_H BOX_H_FLOUR;
	public static Box_H BOX_H_MUTTON;
	public static Box_H BOX_H_PORK;
	public static Box_H BOX_H_POTATO;
	public static Box_H BOX_H_RABBIT;
	public static Box_H BOX_H_SALMON;

	public static Box_HCM BOX_H_CABBAGE;
	public static Box_HCM BOX_H_HAKUSAI;
	public static Box_HCM BOX_H_CITRUS;
	public static Box_HCM BOX_H_CORN;
	public static Box_HCM BOX_H_GREENONION;
	public static Box_HCM BOX_H_GRAPE;
	public static Box_HCM BOX_H_ONION;
	public static Sack_H BOX_H_RICE;
	public static Sack_H BOX_H_SOY;
	public static Box_HCM BOX_H_SPINACH;
	public static Box_HCM BOX_H_TOMATO;
	public static Box_HCM BOX_H_CHERRY;
	public static Box_HCM BOX_H_TAKENOKO;
	public static Sack_H BOX_H_KURI;
	public static Sack_H BOX_H_TGREEN;
	public static Sack_H BOX_H_TRED;
	public static Sack_H BOX_H_BPEPPER;
	public static Sack_H BOX_H_CUMIN;
	public static Sack_H BOX_H_TURMERIC;
	public static Sack_H BOX_H_CHILI;
	
	public static Block CHADUTSU, CANTEA, TAWARA;

	public static Block KITCHEN;

	public static Block KIT_BOARD, KIT_SINK_TOP, KIT_SINK_BOT;
	public static Block KIT_STOVE, KIT_STOVE_1, LIT_KITSTOVE,
								KIT_OVEN, LIT_KITOVEN, KIT_OVEN_B, LIT_KITOVEN_B, IRORI, LIT_IRORI;
	public static Block KIT_REIZOU, KIT_REIZOU_TOP;
	
	public static Block KIT_KANKI_1, KIT_KANKI_2, KIT_HAIKIDUCT, KIT_DUCTEND_1;

	public static Block KIT_TANA, WINE_TANA, CHEESE_TANA;

	public static Block KIT_DONABE;

	public static Block KIT_CHAWAN1, KIT_CHAWANA;
	public static Block KIT_SHIKKI1, KIT_SHIKKIA;
	public static Block KIT_YUNOMI1, KIT_YUNOMIA;
	public static Block KIT_SARA1, KIT_SARAA;
	public static Block KIT_TCUP1, KIT_TCUPA;
	public static Block KIT_TONSUI1, KIT_TONSUIA;
	public static Block KIT_DRINKGLASS1, KIT_DRINKGLASSA, KIT_DRINKGLASSE;
	public static Block KIT_DONBURI1, KIT_SUSHIGETA1;
	public static Block USU_TSUKI;
	
	public static Block CHEESE_OAA, CHEESE_AAA;

	public static Block KIT_SAKENAMA, KIT_SAKE, KIT_SAKEJUKU;
	public static Block KIT_CIDER, KIT_CIDERJUKU;
	public static Block KIT_WINE, KIT_WINEJUKU;
	public static Block KIT_MEAD, KIT_MEADJUKU;


	public static void init() {

		BOX_H_EMPTY = new Box_H("block_boxh_empty");
		BOX_H_APPLE = new Box_H("block_boxh_apple");
		BOX_H_BEEF = new Box_H("block_boxh_beef");
		BOX_H_BEETROOT = new Box_H("block_boxh_beetroot");
		BOX_H_BREAD = new Box_H("block_boxh_bread");
		BOX_H_CARROT = new Box_H("block_boxh_carrot");
		BOX_H_CHICKEN = new Box_H("block_boxh_chicken");
		BOX_H_CHORUS = new Box_H("block_boxh_chorus");
		BOX_H_COCO = new Sack_H("block_boxh_coco");
		BOX_H_EGG = new Box_H("block_boxh_egg");
		BOX_H_FISH = new Box_H("block_boxh_fish");
		BOX_H_FLOUR = new Sack_H("block_boxh_flour");
		BOX_H_MUTTON = new Box_H("block_boxh_mutton");
		BOX_H_PORK = new Box_H("block_boxh_pork");
		BOX_H_POTATO = new Box_H("block_boxh_potato");
		BOX_H_RABBIT = new Box_H("block_boxh_rabbit");
		BOX_H_SALMON = new Box_H("block_boxh_salmon");

		BOX_H_CABBAGE = new Box_HCM("block_boxh_cabbage");
		BOX_H_HAKUSAI = new Box_HCM("block_boxh_hakusai");
		BOX_H_CITRUS = new Box_HCM("block_boxh_citrus");
		BOX_H_CORN = new Box_HCM("block_boxh_corn");
		/** 6.4.1 **/ BOX_H_GREENONION = new Box_HCM("block_boxh_greenonion");
		BOX_H_GRAPE = new Box_HCM("block_boxh_grape");
		BOX_H_ONION = new Box_HCM("block_boxh_onion");
		BOX_H_RICE = new Sack_H("block_boxh_rice");
		BOX_H_SOY = new Sack_H("block_boxh_soy");
		BOX_H_SPINACH = new Box_HCM("block_boxh_spinach");
		BOX_H_TOMATO = new Box_HCM("block_boxh_tomato");
		BOX_H_CHERRY = new Box_HCM("block_boxh_cherry");
		BOX_H_TAKENOKO = new Box_HCM("block_boxh_takenoko");
		BOX_H_KURI = new Sack_H("block_boxh_chestnut");
		BOX_H_TGREEN = new Sack_H("block_boxh_tgreen");
		BOX_H_TRED = new Sack_H("block_boxh_tred");

		BOX_H_BPEPPER = new Sack_H("block_boxh_bpepper");
		BOX_H_CUMIN = new Sack_H("block_boxh_cumin");
		BOX_H_TURMERIC = new Sack_H("block_boxh_turmeric");
		BOX_H_CHILI = new Sack_H("block_boxh_chili");
		
		CHADUTSU = new Chadutsu("block_tea_chadutsu");
		CANTEA = new CanTea("block_tea_can");
		TAWARA = new Tawara("block_tawara_cm");

		KITCHEN = new Kitchen("block_kitchen");

		KIT_BOARD = new Kit_board("block_kit_board");
		KIT_SINK_TOP = new Kit_Sink_top("block_kit_sink2");
		KIT_SINK_BOT = new Kit_Sink_bot("block_kit_sink1");

		KIT_STOVE = new Kit_Cooktop_off("block_kit_stove");
		KIT_STOVE_1 = new Kit_Cooktop_aida("block_kit_stove_1");
		LIT_KITSTOVE = new Kit_Cooktop_on("lit_block_kit_stove");
		KIT_OVEN = new Kitchen_Oven(false, "block_kit_oven");
		LIT_KITOVEN = new Kitchen_Oven(true, "lit_block_kit_oven").setHardness(1.0F).setResistance(10.0F);
		KIT_OVEN_B = new Kitchen_Oven_B(false, "block_kit_oven_black");
		LIT_KITOVEN_B = new Kitchen_Oven_B(true, "lit_block_kit_oven_black").setHardness(1.0F).setResistance(10.0F);
		IRORI = new Irori("block_irori");
		LIT_IRORI = new Lit_Irori("lit_block_irori");
		KIT_REIZOU = new Reizou("block_kit_reizou");
		KIT_REIZOU_TOP = new ReizouTop("block_kit_reizou_top");
		
		KIT_KANKI_1 = new Kit_kanki_off("block_kit_kanki");
		KIT_KANKI_2 = new Kit_kanki_on("block_kit_kanki_2");
		KIT_HAIKIDUCT = new Kit_duct("block_kit_duct");
		KIT_DUCTEND_1 = new Kit_ductend("block_kit_ductend");

		KIT_TANA = new Kit_Tana("block_kit_tana");
		WINE_TANA = new Kit_Tana2("block_kit2_tana");
		CHEESE_TANA = new Kit_Cheese_Tana("block_kit_cheese_tana");

		KIT_DONABE = new Kitchen_Donabe("block_kit_donabe1");

		KIT_CHAWAN1 = new Kit_TanaChawan_1("block_kit_chawan1");
		KIT_CHAWANA = new Kit_TanaChawan_A("block_kit_chawana");
		KIT_SHIKKI1 = new Kit_TanaShikki_1("block_kit_shikki1");
		KIT_SHIKKIA = new Kit_TanaShikki_A("block_kit_shikkia");
		KIT_YUNOMI1 = new Kit_TanaYunomi_1("block_kit_yunomi1");
		KIT_YUNOMIA = new Kit_TanaYunomi_A("block_kit_yunomia");
		KIT_SARA1 = new Kit_TanaSara_1("block_kit_sara1");
		KIT_SARAA = new Kit_TanaSara_A("block_kit_saraa");
		KIT_TCUP1 = new Kit_TanaTcup_1("block_kit_tcup1");
		KIT_TCUPA = new Kit_TanaTcup_A("block_kit_tcupa");
		KIT_TONSUI1 = new Kit_TanaTonsui_1("block_kit_tonsui1");
		KIT_TONSUIA = new Kit_TanaTonsui_A("block_kit_tonsuia");
		KIT_DRINKGLASS1 = new Kit_TanaDrinkglass_1("block_kit_driglass1");
		KIT_DRINKGLASSA = new Kit_TanaDrinkglass_A("block_kit_driglassa");
		KIT_DRINKGLASSE = new Kit_TanaDrinkglass_E("block_kit_driglasse");
		KIT_DONBURI1 = new Kit_TanaDonburi_1("block_kit_donburi1");
		KIT_SUSHIGETA1 = new Kit_TanaSushiGeta_1("block_kit_sushigeta1");
		USU_TSUKI = new UsuTsuki("block_usutsuki");
		
		CHEESE_OAA = new Kit_Cheese_OAA("block_kit_cheese_oaa");
		CHEESE_AAA = new Kit_Cheese_AAA("block_kit_cheese_aaa");

		KIT_SAKENAMA = new Kit_Tana2Sake("block_kit2_sakenama");
		KIT_SAKE = new Kit_Tana2Sake("block_kit2_sake");
		KIT_SAKEJUKU = new Kit_Tana2Sake("block_kit2_sakejuku");
		KIT_WINE = new Kit_Tana2Sake("block_kit2_wine");
		KIT_WINEJUKU = new Kit_Tana2Sake("block_kit2_winejuku");
		KIT_CIDER = new Kit_Tana2Sake("block_kit2_cider");
		KIT_CIDERJUKU = new Kit_Tana2Sake("block_kit2_ciderjuku");
		KIT_MEAD = new Kit_Tana2Sake("block_kit2_mead");
		KIT_MEADJUKU = new Kit_Tana2Sake("block_kit2_meadjuku");
	}


	public static void register() {

		registerBlock(BOX_H_EMPTY);
		registerBlock(BOX_H_APPLE);
		registerBlock(BOX_H_BEEF);
		registerBlock(BOX_H_BEETROOT);
		registerBlock(BOX_H_BREAD);
		registerBlock(BOX_H_CARROT);
		registerBlock(BOX_H_CHICKEN);
		registerBlock(BOX_H_CHORUS);
		registerBlock(BOX_H_COCO);
		registerBlock(BOX_H_EGG);
		registerBlock(BOX_H_FISH);
		registerBlock(BOX_H_FLOUR);
		registerBlock(BOX_H_MUTTON);
		registerBlock(BOX_H_PORK);
		registerBlock(BOX_H_POTATO);
		registerBlock(BOX_H_RABBIT);
		registerBlock(BOX_H_SALMON);

		registerBlock(BOX_H_CABBAGE);
		registerBlock(BOX_H_HAKUSAI);
		registerBlock(BOX_H_CITRUS);
		registerBlock(BOX_H_CORN);
		registerBlock(BOX_H_GREENONION);
		registerBlock(BOX_H_GRAPE);
		registerBlock(BOX_H_ONION);
		registerBlock(BOX_H_RICE);
		registerBlock(BOX_H_SOY);
		registerBlock(BOX_H_SPINACH);
		registerBlock(BOX_H_TOMATO);
		registerBlock(BOX_H_CHERRY);
		registerBlock(BOX_H_TAKENOKO);
		registerBlock(BOX_H_KURI);
		registerBlock(BOX_H_TGREEN);
		registerBlock(BOX_H_TRED);

		registerBlock(BOX_H_BPEPPER);
		registerBlock(BOX_H_CUMIN);
		registerBlock(BOX_H_TURMERIC);
		registerBlock(BOX_H_CHILI);
		
		registerBlock(CHADUTSU);
		registerBlock(CANTEA);
		registerBlock(TAWARA);

		registerBlock(KITCHEN);
		registerBlock(KIT_BOARD);
		registerBlock(KIT_SINK_TOP);
		registerBlock(KIT_SINK_BOT);

		registerBlock(KIT_STOVE);
		registerBlock(KIT_STOVE_1);
		registerBlock(LIT_KITSTOVE);
		registerBlock(KIT_OVEN);
		registerBlock(LIT_KITOVEN);
		registerBlock(KIT_OVEN_B);
		registerBlock(LIT_KITOVEN_B);
		registerBlock(IRORI);
		registerBlock(LIT_IRORI);
		registerBlock(KIT_REIZOU);
		registerBlock(KIT_REIZOU_TOP);
		
		registerBlock(KIT_KANKI_1);
		registerBlock(KIT_KANKI_2);
		registerBlock(KIT_HAIKIDUCT);
		registerBlock(KIT_DUCTEND_1);

		registerBlock(KIT_TANA);
		registerBlock(WINE_TANA);

		registerBlock(CHEESE_TANA);

		registerBlock(KIT_DONABE);

		registerBlock(KIT_CHAWAN1);
		registerBlock(KIT_CHAWANA);
		registerBlock(KIT_SHIKKI1);
		registerBlock(KIT_SHIKKIA);
		registerBlock(KIT_YUNOMI1);
		registerBlock(KIT_YUNOMIA);
		registerBlock(KIT_SARA1);
		registerBlock(KIT_SARAA);
		registerBlock(KIT_TCUP1);
		registerBlock(KIT_TCUPA);
		registerBlock(KIT_TONSUI1);
		registerBlock(KIT_TONSUIA);
		registerBlock(KIT_DRINKGLASS1);
		registerBlock(KIT_DRINKGLASSA);
		registerBlock(KIT_DRINKGLASSE);
		registerBlock(KIT_DONBURI1);
		registerBlock(KIT_SUSHIGETA1);
		registerBlock(USU_TSUKI);
		
		registerBlock(CHEESE_OAA);
		registerBlock(CHEESE_AAA);

		registerBlock(KIT_SAKENAMA);
		registerBlock(KIT_SAKE);
		registerBlock(KIT_SAKEJUKU);
		registerBlock(KIT_WINE);
		registerBlock(KIT_WINEJUKU);
		registerBlock(KIT_CIDER);
		registerBlock(KIT_CIDERJUKU);
		registerBlock(KIT_MEAD);
		registerBlock(KIT_MEADJUKU);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
