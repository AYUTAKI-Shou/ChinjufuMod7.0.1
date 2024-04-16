package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.crop.Cabbage;
import com.ayutaki.chinjufumod.blocks.crop.Chanoki;
import com.ayutaki.chinjufumod.blocks.crop.Chilipepper;
import com.ayutaki.chinjufumod.blocks.crop.Corn;
import com.ayutaki.chinjufumod.blocks.crop.Corn_Top;
import com.ayutaki.chinjufumod.blocks.crop.Cumin;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.blocks.crop.Enden_kara;
import com.ayutaki.chinjufumod.blocks.crop.GrapeTop_3B_B;
import com.ayutaki.chinjufumod.blocks.crop.GrapeTop_C_kare;
import com.ayutaki.chinjufumod.blocks.crop.GrapeTop_Nae_3;
import com.ayutaki.chinjufumod.blocks.crop.Grape_3B_B;
import com.ayutaki.chinjufumod.blocks.crop.Grape_C_kare;
import com.ayutaki.chinjufumod.blocks.crop.Grape_Nae_3;
import com.ayutaki.chinjufumod.blocks.crop.GreenOnion;
import com.ayutaki.chinjufumod.blocks.crop.Hakusai;
import com.ayutaki.chinjufumod.blocks.crop.Hamaguri;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Top;
import com.ayutaki.chinjufumod.blocks.crop.Inagi;
import com.ayutaki.chinjufumod.blocks.crop.Inagi_Top;
import com.ayutaki.chinjufumod.blocks.crop.LostClam;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Nae;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Top;
import com.ayutaki.chinjufumod.blocks.crop.NoriAmi;
import com.ayutaki.chinjufumod.blocks.crop.Onion;
import com.ayutaki.chinjufumod.blocks.crop.Pepper;
import com.ayutaki.chinjufumod.blocks.crop.Rice;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.blocks.crop.Sakura_me;
import com.ayutaki.chinjufumod.blocks.crop.SeedsBox;
import com.ayutaki.chinjufumod.blocks.crop.Soy;
import com.ayutaki.chinjufumod.blocks.crop.Spinach;
import com.ayutaki.chinjufumod.blocks.crop.Toami_Wide;
import com.ayutaki.chinjufumod.blocks.crop.Tomato;
import com.ayutaki.chinjufumod.blocks.crop.Turmeric;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class Crop_Blocks {

	public static Block SEEDSBOX;

	public static Block CHANOKI;
	public static Block BUDOUNOKI_nae, BUDOUNOKI_B, BUDOUNOKI_C,
								BUDOUTOP_nae, BUDOUTOP_B, BUDOUTOP_C;
	public static Block MIKAN, MIKAN_TOP, PEPPER, CUMIN, TURMERIC, CHILI;

	public static Block CABBAGE, HAKUSAI, CORN, CORN_TOP;
	public static Block GREENONION, ONION, RICE, RICE_8;
	public static Block SOY, SPINACH, TOMATO, SAKURA;

	public static Block HODAGI_A_BOT, HODAGI_A_TOP;
	public static Block HODAGI_B_BOT, HODAGI_B_TOP;
	public static Block HODAGI_C_BOT, HODAGI_C_TOP;

	public static Block INAGI_BOT, INAGI_TOP, NORIAMI, ENDEN, ENDEN_k ,TOAMI_W;
	public static Block HAMAGURI, KAINASHI;
	//public static Block TEST;

	public static void init() {

		SEEDSBOX = new SeedsBox("block_seedsbox", Material.GRASS);

		CHANOKI = new Chanoki("block_wood_chanoki_4");
		BUDOUNOKI_nae = new Grape_Nae_3("block_wood_grape_3");
		BUDOUNOKI_B = new Grape_3B_B("block_wood_grape_b");
		BUDOUNOKI_C = new Grape_C_kare("block_wood_grape_c");
		BUDOUTOP_nae = new GrapeTop_Nae_3("block_wood_grapetop_3");
		BUDOUTOP_B = new GrapeTop_3B_B("block_wood_grapetop_b");
		BUDOUTOP_C = new GrapeTop_C_kare("block_wood_grapetop_c");
		MIKAN = new Mikan_Nae("block_wood_mikan");
		MIKAN_TOP = new Mikan_Top(	"block_wood_mikan_top");
		PEPPER = new Pepper("block_spice_pepper");
		CUMIN = new Cumin("block_spice_cumin");
		TURMERIC = new Turmeric("block_spice_turmeric");
		CHILI = new Chilipepper("block_spice_chilipepper");
		
		CABBAGE = new Cabbage("block_vege_cabbage");
		HAKUSAI = new Hakusai("block_vege_hakusai");
		CORN = new Corn("block_vege_corn");
		CORN_TOP = new Corn_Top("block_vege_corn_top");
		/** 6.4.1 **/ GREENONION = new GreenOnion("block_vege_greenonion");
		ONION = new Onion("block_vege_onion");
		RICE = new Rice("block_vege_rice");
		RICE_8 = new Rice_8("block_vege_rice_8");
		SOY = new Soy("block_vege_soy");
		SPINACH = new Spinach("block_vege_spinach");
		TOMATO = new Tomato("block_vege_tomato");
		SAKURA = new Sakura_me("block_tree_sakura_me");

		HODAGI_A_BOT = new HodaGi_A_Bot("block_hodagi_a_bot");
		HODAGI_A_TOP = new HodaGi_A_Top("block_hodagi_a_top");
		HODAGI_B_BOT = new HodaGi_B_Bot("block_hodagi_b_bot");
		HODAGI_B_TOP = new HodaGi_B_Top("block_hodagi_b_top");
		HODAGI_C_BOT = new HodaGi_C_Bot("block_hodagi_c_bot");
		HODAGI_C_TOP = new HodaGi_C_Top(	"block_hodagi_c_top");

		INAGI_BOT = new Inagi("block_inagi");
		INAGI_TOP = new Inagi_Top("block_inagi_top");

		NORIAMI = new NoriAmi("block_noriami");
		ENDEN = new Enden("block_enden");
		ENDEN_k = new Enden_kara("block_enden_k");
		TOAMI_W = new Toami_Wide("item_toami_wide");
		
		HAMAGURI = new Hamaguri("block_hamaguri");
		KAINASHI = new LostClam("block_lostclam");
		
		//TEST = new TestCrop("test_crop");
	}


	public static void register() {

		registerBlock(SEEDSBOX);

		registerBlock(CHANOKI);
		registerBlock(BUDOUNOKI_nae);
		registerBlock(BUDOUNOKI_B);
		registerBlock(BUDOUNOKI_C);
		registerBlock(BUDOUTOP_nae);
		registerBlock(BUDOUTOP_B);
		registerBlock(BUDOUTOP_C);
		registerBlock(MIKAN);
		registerBlock(MIKAN_TOP);
		registerBlock(PEPPER);
		registerBlock(CUMIN);
		registerBlock(TURMERIC);
		registerBlock(CHILI);
		
		registerBlock(CABBAGE);
		registerBlock(HAKUSAI);
		registerBlock(CORN);
		registerBlock(CORN_TOP);
		registerBlock(GREENONION);
		registerBlock(ONION);
		registerBlock(RICE);
		registerBlock(RICE_8);
		registerBlock(SOY);
		registerBlock(SPINACH);
		registerBlock(TOMATO);
		registerBlock(SAKURA);

		registerBlock(HODAGI_A_BOT);
		registerBlock(HODAGI_A_TOP);
		registerBlock(HODAGI_B_BOT);
		registerBlock(HODAGI_B_TOP);
		registerBlock(HODAGI_C_BOT);
		registerBlock(HODAGI_C_TOP);

		registerBlock(INAGI_BOT);
		registerBlock(INAGI_TOP);

		registerBlock(NORIAMI);
		registerBlock(ENDEN);
		registerBlock(ENDEN_k);
		registerBlock(TOAMI_W);
		
		registerBlock(HAMAGURI);
		registerBlock(KAINASHI);
		//registerBlock(TEST);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
