package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooButton;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooCube;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooFence;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooPressurePlate;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooSlab;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooStairs;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooTrapDoor;
import com.ayutaki.chinjufumod.blocks.chair.WaraZabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton_down;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Bot;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Small;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Top;
import com.ayutaki.chinjufumod.blocks.garden.Sudare;
import com.ayutaki.chinjufumod.blocks.jpdeco.Futon;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiAcacia;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiBirch;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiDarkOak;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiIchoh;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiJungle;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiKaede;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiOak;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiSakura;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiSpruce;
import com.ayutaki.chinjufumod.blocks.jpdeco.TatamiWood;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami_Y;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB;
import com.ayutaki.chinjufumod.blocks.ranma.Noren;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_Opacity0;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_Opacity1;

import net.minecraft.block.Block;

public class JPDeco_Blocks {

	public static Block RANMA_oak, RANMA_spru, RANMA_bir, RANMA_jun, RANMA_aca, RANMA_doak;
	public static Block RANMAB_oak, RANMAB_spru, RANMAB_bir, RANMAB_jun, RANMAB_aca, RANMAB_doak;
	public static Block RANMAC_oak, RANMAC_spru, RANMAC_bir, RANMAC_jun, RANMAC_aca, RANMAC_doak;
	public static Block KANKI_oak, KANKI_spru, KANKI_bir, KANKI_jun, KANKI_aca, KANKI_doak;
	public static Block KOUSHI_oak, KOUSHI_spru, KOUSHI_bir, KOUSHI_jun, KOUSHI_aca, KOUSHI_doak;
	public static Block KOUSHIB_oak, KOUSHIB_spru, KOUSHIB_bir, KOUSHIB_jun, KOUSHIB_aca, KOUSHIB_doak;

	public static Block SUDARE;

	public static Block NOREN_white, NOREN_orange, NOREN_magenta, NOREN_lightb,
								NOREN_yellow, NOREN_lime, NOREN_pink, NOREN_gray,
								NOREN_lightg, NOREN_cyan, NOREN_purple, NOREN_blue,
								NOREN_brown, NOREN_green, NOREN_red, NOREN_black;

	public static Block ZABUTON, ZABUTON_down, WARAZABUTON;

	public static Block ZAISU_white, ZAISU_orange, ZAISU_magenta, ZAISU_lightb,
								ZAISU_yellow, ZAISU_lime, ZAISU_pink, ZAISU_gray,
								ZAISU_lightg, ZAISU_cyan, ZAISU_purple, ZAISU_blue,
								ZAISU_brown, ZAISU_green, ZAISU_red, ZAISU_black;

	public static Tatami TATAMI, TATAMI_white, TATAMI_orange, TATAMI_magenta, TATAMI_lightb,
								TATAMI_yellow, TATAMI_lime, TATAMI_pink, TATAMI_gray,
								TATAMI_lightg, TATAMI_cyan, TATAMI_purple, TATAMI_blue,
								TATAMI_brown, TATAMI_green, TATAMI_red, TATAMI_black;

	public static Tatami_Y TATAMIY, TATAMIY_white, TATAMIY_orange, TATAMIY_magenta, TATAMIY_lightb,
								TATAMIY_yellow, TATAMIY_lime, TATAMIY_pink, TATAMIY_gray,
								TATAMIY_lightg, TATAMIY_cyan, TATAMIY_purple, TATAMIY_blue,
								TATAMIY_brown, TATAMIY_green, TATAMIY_red, TATAMIY_black;

	public static Block TATAMI_OAK_ew, TATAMI_OAK_ns, TATAMI_SPRUCE_ew, TATAMI_SPRUCE_ns,
								TATAMI_BIRCH_ew, TATAMI_BIRCH_ns, TATAMI_JUNGLE_ew, TATAMI_JUNGLE_ns,
								TATAMI_ACACIA_ew, TATAMI_ACACIA_ns, TATAMI_DOAK_ew, TATAMI_DOAK_ns,
								TATAMI_SAKURA_ew, TATAMI_SAKURA_ns, TATAMI_KAEDE_ew, TATAMI_KAEDE_ns,
								TATAMI_ICHOH_ew, TATAMI_ICHOH_ns, TATAMI_WOOD_ew, TATAMI_WOOD_ns;
	
	public static Block TATAMIY_OAK_ew, TATAMIY_OAK_ns, TATAMIY_SPRUCE_ew, TATAMIY_SPRUCE_ns,
								TATAMIY_BIRCH_ew, TATAMIY_BIRCH_ns, TATAMIY_JUNGLE_ew, TATAMIY_JUNGLE_ns,
								TATAMIY_ACACIA_ew, TATAMIY_ACACIA_ns, TATAMIY_DOAK_ew, TATAMIY_DOAK_ns,
								TATAMIY_SAKURA_ew, TATAMIY_SAKURA_ns, TATAMIY_KAEDE_ew, TATAMIY_KAEDE_ns,
								TATAMIY_ICHOH_ew, TATAMIY_ICHOH_ns, TATAMIY_WOOD_ew, TATAMIY_WOOD_ns;
	
	public static Block FUTON_black, FUTON_blue, FUTON_brown, FUTON_cyan,
								FUTON_gray, FUTON_green, FUTON_lightb, FUTON_lightg,
								FUTON_lime, FUTON_magenta, FUTON_orange, FUTON_pink,
								FUTON_purple, FUTON_red, FUTON_white, FUTON_yellow;
	
	public static Block TAKECUBE, TAKECUBE_Y, TAKECUBE_K, TAKE_ST, TAKE_STY, TAKE_STK;
	public static BambooSlab TAKE_SH, TAKE_SHY, TAKE_SHK;
	public static Block TAKEFENCE, TAKEFENCE_Y, TAKEFENCE_K;
	public static Block TAKE_TRAPDOOR, TAKE_TRAPDOOR_Y, TAKE_TRAPDOOR_K;
	public static Block TAKE_PLATE, TAKE_PLATE_Y, TAKE_PLATE_K;
	public static Block TAKE_BUTTON, TAKE_BUTTON_Y, TAKE_BUTTON_K;

	public static Block WADAIKO_TOP, WADAIKO_BOT, WADAIKO_small;


	public static void init() {

		RANMA_oak = new Ranma_Opacity0("block_ranma_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMA_spru = new Ranma_Opacity0("block_ranma_spru").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMA_bir = new Ranma_Opacity0("block_ranma_bir").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMA_jun = new Ranma_Opacity0("block_ranma_jun").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMA_aca = new Ranma_Opacity0("block_ranma_aca").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMA_doak = new Ranma_Opacity0("block_ranma_doak").setCreativeTab(ChinjufuModTabs.WADECO);

		RANMAB_oak = new Ranma_Opacity1("block_ranmab_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAB_spru = new Ranma_Opacity1("block_ranmab_spru").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAB_bir = new Ranma_Opacity1("block_ranmab_bir").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAB_jun = new Ranma_Opacity1("block_ranmab_jun").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAB_aca = new Ranma_Opacity1("block_ranmab_aca").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAB_doak = new Ranma_Opacity1("block_ranmab_doak").setCreativeTab(ChinjufuModTabs.WADECO);

		RANMAC_oak = new Ranma_Opacity0("block_ranmac_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAC_spru = new Ranma_Opacity0("block_ranmac_spru").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAC_bir = new Ranma_Opacity0("block_ranmac_bir").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAC_jun = new Ranma_Opacity0("block_ranmac_jun").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAC_aca = new Ranma_Opacity0("block_ranmac_aca").setCreativeTab(ChinjufuModTabs.WADECO);
		RANMAC_doak = new Ranma_Opacity0("block_ranmac_doak").setCreativeTab(ChinjufuModTabs.WADECO);

		KANKI_oak = new Ranma_Opacity1("block_kanki_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		KANKI_spru = new Ranma_Opacity1("block_kanki_spru").setCreativeTab(ChinjufuModTabs.WADECO);
		KANKI_bir = new Ranma_Opacity1("block_kanki_bir").setCreativeTab(ChinjufuModTabs.WADECO);
		KANKI_jun = new Ranma_Opacity1("block_kanki_jun").setCreativeTab(ChinjufuModTabs.WADECO);
		KANKI_aca = new Ranma_Opacity1("block_kanki_aca").setCreativeTab(ChinjufuModTabs.WADECO);
		KANKI_doak = new Ranma_Opacity1("block_kanki_doak").setCreativeTab(ChinjufuModTabs.WADECO);

		KOUSHI_oak = new Ranma_Opacity0("block_koushi_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHI_spru = new Ranma_Opacity0("block_koushi_spru").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHI_bir = new Ranma_Opacity0("block_koushi_bir").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHI_jun = new Ranma_Opacity0("block_koushi_jun").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHI_aca = new Ranma_Opacity0("block_koushi_aca").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHI_doak = new Ranma_Opacity0("block_koushi_doak").setCreativeTab(ChinjufuModTabs.WADECO);

		KOUSHIB_oak = new KoushiB("block_koushib_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHIB_spru = new KoushiB("block_koushib_spru").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHIB_bir = new KoushiB("block_koushib_bir").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHIB_jun = new KoushiB("block_koushib_jun").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHIB_aca = new KoushiB("block_koushib_aca").setCreativeTab(ChinjufuModTabs.WADECO);
		KOUSHIB_doak = new KoushiB("block_koushib_doak").setCreativeTab(ChinjufuModTabs.WADECO);

		SUDARE = new Sudare("block_sudare_1");

		NOREN_white = new Noren("block_noren_white");
		NOREN_orange = new Noren("block_noren_orange");
		NOREN_magenta = new Noren("block_noren_magenta");
		NOREN_lightb = new Noren("block_noren_lightb");
		NOREN_yellow = new Noren("block_noren_yellow");
		NOREN_lime = new Noren("block_noren_lime");
		NOREN_pink = new Noren("block_noren_pink");
		NOREN_gray = new Noren("block_noren_gray");
		NOREN_lightg = new Noren("block_noren_lightg");
		NOREN_cyan = new Noren("block_noren_cyan");
		NOREN_purple = new Noren("block_noren_purple");
		NOREN_blue = new Noren("block_noren_blue");
		NOREN_brown = new Noren("block_noren_brown");
		NOREN_green = new Noren("block_noren_green");
		NOREN_red = new Noren("block_noren_red");
		NOREN_black = new Noren("block_noren_black");

		ZABUTON = new Zabuton("block_mzabuton");
		ZABUTON_down = new Zabuton_down("block_mzabuton_down");
		WARAZABUTON = new WaraZabuton("block_wara_zabuton");

		ZAISU_white = new Zaisu("block_zaisu_white");
		ZAISU_orange = new Zaisu("block_zaisu_orange");
		ZAISU_magenta = new Zaisu("block_zaisu_magenta");
		ZAISU_lightb = new Zaisu("block_zaisu_lightb");
		ZAISU_yellow = new Zaisu("block_zaisu_yellow");
		ZAISU_lime = new Zaisu("block_zaisu_lime");
		ZAISU_pink = new Zaisu("block_zaisu_pink");
		ZAISU_gray = new Zaisu("block_zaisu_gray");
		ZAISU_lightg = new Zaisu("block_zaisu_lightg");
		ZAISU_cyan = new Zaisu("block_zaisu_cyan");
		ZAISU_purple = new Zaisu("block_zaisu_purple");
		ZAISU_blue = new Zaisu("block_zaisu_blue");
		ZAISU_brown = new Zaisu("block_zaisu_brown");
		ZAISU_green = new Zaisu("block_zaisu_green");
		ZAISU_red = new Zaisu("block_zaisu_red");
		ZAISU_black = new Zaisu("block_zaisu_black");

		TATAMI = new Tatami("block_tatamih");
		TATAMI_white = new Tatami("block_tatamih_white");
		TATAMI_orange = new Tatami("block_tatamih_orange");
		TATAMI_magenta = new Tatami("block_tatamih_magenta");
		TATAMI_lightb = new Tatami("block_tatamih_lightb");
		TATAMI_yellow = new Tatami("block_tatamih_yellow");
		TATAMI_lime = new Tatami("block_tatamih_lime");
		TATAMI_pink = new Tatami("block_tatamih_pink");
		TATAMI_gray = new Tatami("block_tatamih_gray");
		TATAMI_lightg = new Tatami("block_tatamih_lightg");
		TATAMI_cyan = new Tatami("block_tatamih_cyan");
		TATAMI_purple = new Tatami("block_tatamih_purple");
		TATAMI_blue = new Tatami("block_tatamih_blue");
		TATAMI_brown = new Tatami("block_tatamih_brown");
		TATAMI_green = new Tatami("block_tatamih_green");
		TATAMI_red = new Tatami("block_tatamih_red");
		TATAMI_black = new Tatami("block_tatamih_black");

		TATAMIY = new Tatami_Y("block_tatamih_y");
		TATAMIY_white = new Tatami_Y("block_tatamih_y_white");
		TATAMIY_orange = new Tatami_Y("block_tatamih_y_orange");
		TATAMIY_magenta = new Tatami_Y("block_tatamih_y_magenta");
		TATAMIY_lightb = new Tatami_Y("block_tatamih_y_lightb");
		TATAMIY_yellow = new Tatami_Y("block_tatamih_y_yellow");
		TATAMIY_lime = new Tatami_Y("block_tatamih_y_lime");
		TATAMIY_pink = new Tatami_Y("block_tatamih_y_pink");
		TATAMIY_gray = new Tatami_Y("block_tatamih_y_gray");
		TATAMIY_lightg = new Tatami_Y("block_tatamih_y_lightg");
		TATAMIY_cyan = new Tatami_Y("block_tatamih_y_cyan");
		TATAMIY_purple = new Tatami_Y("block_tatamih_y_purple");
		TATAMIY_blue = new Tatami_Y("block_tatamih_y_blue");
		TATAMIY_brown = new Tatami_Y("block_tatamih_y_brown");
		TATAMIY_green = new Tatami_Y("block_tatamih_y_green");
		TATAMIY_red = new Tatami_Y("block_tatamih_y_red");
		TATAMIY_black = new Tatami_Y("block_tatamih_y_black");

		TATAMI_OAK_ew = new TatamiOak("block_tatami_oak_ew");
		TATAMI_OAK_ns = new TatamiOak("block_tatami_oak_ns");
		TATAMI_SPRUCE_ew = new TatamiSpruce("block_tatami_spruce_ew");
		TATAMI_SPRUCE_ns = new TatamiSpruce("block_tatami_spruce_ns");
		TATAMI_BIRCH_ew = new TatamiBirch("block_tatami_birch_ew");
		TATAMI_BIRCH_ns = new TatamiBirch("block_tatami_birch_ns");
		TATAMI_JUNGLE_ew = new TatamiJungle("block_tatami_jungle_ew");
		TATAMI_JUNGLE_ns = new TatamiJungle("block_tatami_jungle_ns");
		TATAMI_ACACIA_ew = new TatamiAcacia("block_tatami_acacia_ew");
		TATAMI_ACACIA_ns = new TatamiAcacia("block_tatami_acacia_ns");
		TATAMI_DOAK_ew = new TatamiDarkOak("block_tatami_darkoak_ew");
		TATAMI_DOAK_ns = new TatamiDarkOak("block_tatami_darkoak_ns");
		TATAMI_SAKURA_ew = new TatamiSakura("block_tatami_sakura_ew");
		TATAMI_SAKURA_ns = new TatamiSakura("block_tatami_sakura_ns");
		TATAMI_KAEDE_ew = new TatamiKaede("block_tatami_kaede_ew");
		TATAMI_KAEDE_ns = new TatamiKaede("block_tatami_kaede_ns");
		TATAMI_ICHOH_ew = new TatamiIchoh("block_tatami_ichoh_ew");
		TATAMI_ICHOH_ns = new TatamiIchoh("block_tatami_ichoh_ns");
		TATAMI_WOOD_ew = new TatamiWood("block_tatami_wood_ew");
		TATAMI_WOOD_ns = new TatamiWood("block_tatami_wood_ns");

		TATAMIY_OAK_ew = new TatamiOak("block_tatamiy_oak_ew");
		TATAMIY_OAK_ns = new TatamiOak("block_tatamiy_oak_ns");
		TATAMIY_SPRUCE_ew = new TatamiSpruce("block_tatamiy_spruce_ew");
		TATAMIY_SPRUCE_ns = new TatamiSpruce("block_tatamiy_spruce_ns");
		TATAMIY_BIRCH_ew = new TatamiBirch("block_tatamiy_birch_ew");
		TATAMIY_BIRCH_ns = new TatamiBirch("block_tatamiy_birch_ns");
		TATAMIY_JUNGLE_ew = new TatamiJungle("block_tatamiy_jungle_ew");
		TATAMIY_JUNGLE_ns = new TatamiJungle("block_tatamiy_jungle_ns");
		TATAMIY_ACACIA_ew = new TatamiAcacia("block_tatamiy_acacia_ew");
		TATAMIY_ACACIA_ns = new TatamiAcacia("block_tatamiy_acacia_ns");
		TATAMIY_DOAK_ew = new TatamiDarkOak("block_tatamiy_darkoak_ew");
		TATAMIY_DOAK_ns = new TatamiDarkOak("block_tatamiy_darkoak_ns");
		TATAMIY_SAKURA_ew = new TatamiSakura("block_tatamiy_sakura_ew");
		TATAMIY_SAKURA_ns = new TatamiSakura("block_tatamiy_sakura_ns");
		TATAMIY_KAEDE_ew = new TatamiKaede("block_tatamiy_kaede_ew");
		TATAMIY_KAEDE_ns = new TatamiKaede("block_tatamiy_kaede_ns");
		TATAMIY_ICHOH_ew = new TatamiIchoh("block_tatamiy_ichoh_ew");
		TATAMIY_ICHOH_ns = new TatamiIchoh("block_tatamiy_ichoh_ns");
		TATAMIY_WOOD_ew = new TatamiWood("block_tatamiy_wood_ew");
		TATAMIY_WOOD_ns = new TatamiWood("block_tatamiy_wood_ns");

		FUTON_black = new Futon("block_futon_c_black");
		FUTON_blue = new Futon("block_futon_c_blue");
		FUTON_brown = new Futon("block_futon_c_brown");
		FUTON_cyan = new Futon("block_futon_c_cyan");
		FUTON_gray = new Futon("block_futon_c_gray");
		FUTON_green = new Futon("block_futon_c_green");
		FUTON_lightb = new Futon("block_futon_c_lightb");
		FUTON_lightg = new Futon("block_futon_c_lightg");
		FUTON_lime = new Futon("block_futon_c_lime");
		FUTON_magenta = new Futon("block_futon_c_magenta");
		FUTON_orange = new Futon("block_futon_c_orange");
		FUTON_pink = new Futon("block_futon_c_pink");
		FUTON_purple = new Futon("block_futon_c_purple");
		FUTON_red = new Futon("block_futon_c_red");
		FUTON_white = new Futon("block_futon_c_white");
		FUTON_yellow = new Futon("block_futon_c_yellow");
		
		TAKECUBE = new BambooCube("block_bamboo_cube");
		TAKECUBE_Y = new BambooCube("block_bamboo_y_cube");
		TAKECUBE_K = new BambooCube("block_bamboo_k_cube");
		TAKE_ST = new BambooStairs("block_bamboo_stairs");
		TAKE_STY = new BambooStairs("block_bamboo_y_stairs");
		TAKE_STK = new BambooStairs("block_bamboo_k_stairs");
		TAKE_SH = new BambooSlab("block_bamboo_slab");
		TAKE_SHY = new BambooSlab("block_bamboo_y_slab");
		TAKE_SHK = new BambooSlab("block_bamboo_k_slab");

		TAKEFENCE = new BambooFence("block_bamboo_fence");
		TAKEFENCE_Y = new BambooFence("block_bamboo_y_fence");
		TAKEFENCE_K = new BambooFence("block_bamboo_k_fence");

		TAKE_TRAPDOOR = new BambooTrapDoor("block_bamboo_trapdoor");
		TAKE_TRAPDOOR_Y = new BambooTrapDoor("block_bamboo_y_trapdoor");
		TAKE_TRAPDOOR_K = new BambooTrapDoor("block_bamboo_k_trapdoor");
		TAKE_PLATE = new BambooPressurePlate("block_bamboo_plate");
		TAKE_PLATE_Y = new BambooPressurePlate("block_bamboo_y_plate");
		TAKE_PLATE_K = new BambooPressurePlate("block_bamboo_k_plate");
		TAKE_BUTTON = new BambooButton("block_bamboo_button");
		TAKE_BUTTON_Y = new BambooButton("block_bamboo_y_button");
		TAKE_BUTTON_K = new BambooButton("block_bamboo_k_button");

		WADAIKO_TOP = new Wadaiko_Top("block_wadaiko_top");
		WADAIKO_BOT = new Wadaiko_Bot("block_wadaiko");
		WADAIKO_small = new Wadaiko_Small("block_wadaiko_small");
	}


	public static void register() {

		registerBlock(RANMA_oak);
		registerBlock(RANMA_spru);
		registerBlock(RANMA_bir);
		registerBlock(RANMA_jun);
		registerBlock(RANMA_aca);
		registerBlock(RANMA_doak);

		registerBlock(RANMAB_oak);
		registerBlock(RANMAB_spru);
		registerBlock(RANMAB_bir);
		registerBlock(RANMAB_jun);
		registerBlock(RANMAB_aca);
		registerBlock(RANMAB_doak);

		registerBlock(RANMAC_oak);
		registerBlock(RANMAC_spru);
		registerBlock(RANMAC_bir);
		registerBlock(RANMAC_jun);
		registerBlock(RANMAC_aca);
		registerBlock(RANMAC_doak);

		registerBlock(KANKI_oak);
		registerBlock(KANKI_spru);
		registerBlock(KANKI_bir);
		registerBlock(KANKI_jun);
		registerBlock(KANKI_aca);
		registerBlock(KANKI_doak);

		registerBlock(KOUSHI_oak);
		registerBlock(KOUSHI_spru);
		registerBlock(KOUSHI_bir);
		registerBlock(KOUSHI_jun);
		registerBlock(KOUSHI_aca);
		registerBlock(KOUSHI_doak);

		registerBlock(KOUSHIB_oak);
		registerBlock(KOUSHIB_spru);
		registerBlock(KOUSHIB_bir);
		registerBlock(KOUSHIB_jun);
		registerBlock(KOUSHIB_aca);
		registerBlock(KOUSHIB_doak);

		registerBlock(SUDARE);

		registerBlock(NOREN_white);
		registerBlock(NOREN_orange);
		registerBlock(NOREN_magenta);
		registerBlock(NOREN_lightb);
		registerBlock(NOREN_yellow);
		registerBlock(NOREN_lime);
		registerBlock(NOREN_pink);
		registerBlock(NOREN_gray);
		registerBlock(NOREN_lightg);
		registerBlock(NOREN_cyan);
		registerBlock(NOREN_purple);
		registerBlock(NOREN_blue);
		registerBlock(NOREN_brown);
		registerBlock(NOREN_green);
		registerBlock(NOREN_red);
		registerBlock(NOREN_black);

		registerBlock(ZABUTON);
		registerBlock(ZABUTON_down);
		registerBlock(WARAZABUTON);

		registerBlock(ZAISU_white);
		registerBlock(ZAISU_orange);
		registerBlock(ZAISU_magenta);
		registerBlock(ZAISU_lightb);
		registerBlock(ZAISU_yellow);
		registerBlock(ZAISU_lime);
		registerBlock(ZAISU_pink);
		registerBlock(ZAISU_gray);
		registerBlock(ZAISU_lightg);
		registerBlock(ZAISU_cyan);
		registerBlock(ZAISU_purple);
		registerBlock(ZAISU_blue);
		registerBlock(ZAISU_brown);
		registerBlock(ZAISU_green);
		registerBlock(ZAISU_red);
		registerBlock(ZAISU_black);

		registerBlock(TATAMI);
		registerBlock(TATAMI_white);
		registerBlock(TATAMI_orange);
		registerBlock(TATAMI_magenta);
		registerBlock(TATAMI_lightb);
		registerBlock(TATAMI_yellow);
		registerBlock(TATAMI_lime);
		registerBlock(TATAMI_pink);
		registerBlock(TATAMI_gray);
		registerBlock(TATAMI_lightg);
		registerBlock(TATAMI_cyan);
		registerBlock(TATAMI_purple);
		registerBlock(TATAMI_blue);
		registerBlock(TATAMI_brown);
		registerBlock(TATAMI_green);
		registerBlock(TATAMI_red);
		registerBlock(TATAMI_black);

		registerBlock(TATAMIY);
		registerBlock(TATAMIY_white);
		registerBlock(TATAMIY_orange);
		registerBlock(TATAMIY_magenta);
		registerBlock(TATAMIY_lightb);
		registerBlock(TATAMIY_yellow);
		registerBlock(TATAMIY_lime);
		registerBlock(TATAMIY_pink);
		registerBlock(TATAMIY_gray);
		registerBlock(TATAMIY_lightg);
		registerBlock(TATAMIY_cyan);
		registerBlock(TATAMIY_purple);
		registerBlock(TATAMIY_blue);
		registerBlock(TATAMIY_brown);
		registerBlock(TATAMIY_green);
		registerBlock(TATAMIY_red);
		registerBlock(TATAMIY_black);

		registerBlock(TATAMI_OAK_ew);
		registerBlock(TATAMI_OAK_ns);
		registerBlock(TATAMI_SPRUCE_ew);
		registerBlock(TATAMI_SPRUCE_ns);
		registerBlock(TATAMI_BIRCH_ew);
		registerBlock(TATAMI_BIRCH_ns);
		registerBlock(TATAMI_JUNGLE_ew);
		registerBlock(TATAMI_JUNGLE_ns);
		registerBlock(TATAMI_ACACIA_ew);
		registerBlock(TATAMI_ACACIA_ns);
		registerBlock(TATAMI_DOAK_ew);
		registerBlock(TATAMI_DOAK_ns);
		registerBlock(TATAMI_SAKURA_ew);
		registerBlock(TATAMI_SAKURA_ns);
		registerBlock(TATAMI_KAEDE_ew);
		registerBlock(TATAMI_KAEDE_ns);
		registerBlock(TATAMI_ICHOH_ew);
		registerBlock(TATAMI_ICHOH_ns);
		registerBlock(TATAMI_WOOD_ew);
		registerBlock(TATAMI_WOOD_ns);

		registerBlock(TATAMIY_OAK_ew);
		registerBlock(TATAMIY_OAK_ns);
		registerBlock(TATAMIY_SPRUCE_ew);
		registerBlock(TATAMIY_SPRUCE_ns);
		registerBlock(TATAMIY_BIRCH_ew);
		registerBlock(TATAMIY_BIRCH_ns);
		registerBlock(TATAMIY_JUNGLE_ew);
		registerBlock(TATAMIY_JUNGLE_ns);
		registerBlock(TATAMIY_ACACIA_ew);
		registerBlock(TATAMIY_ACACIA_ns);
		registerBlock(TATAMIY_DOAK_ew);
		registerBlock(TATAMIY_DOAK_ns);
		registerBlock(TATAMIY_SAKURA_ew);
		registerBlock(TATAMIY_SAKURA_ns);
		registerBlock(TATAMIY_KAEDE_ew);
		registerBlock(TATAMIY_KAEDE_ns);
		registerBlock(TATAMIY_ICHOH_ew);
		registerBlock(TATAMIY_ICHOH_ns);
		registerBlock(TATAMIY_WOOD_ew);
		registerBlock(TATAMIY_WOOD_ns);

		registerBlock(FUTON_black);
		registerBlock(FUTON_blue);
		registerBlock(FUTON_brown);
		registerBlock(FUTON_cyan);
		registerBlock(FUTON_gray);
		registerBlock(FUTON_green);
		registerBlock(FUTON_lightb);
		registerBlock(FUTON_lightg);
		registerBlock(FUTON_lime);
		registerBlock(FUTON_magenta);
		registerBlock(FUTON_orange);
		registerBlock(FUTON_pink);
		registerBlock(FUTON_purple);
		registerBlock(FUTON_red);
		registerBlock(FUTON_white);
		registerBlock(FUTON_yellow);
		
		registerBlock(TAKECUBE);
		registerBlock(TAKECUBE_Y);
		registerBlock(TAKECUBE_K);
		registerBlock(TAKE_ST);
		registerBlock(TAKE_STY);
		registerBlock(TAKE_STK);
		registerBlock(TAKE_SH);
		registerBlock(TAKE_SHY);
		registerBlock(TAKE_SHK);

		registerBlock(TAKEFENCE);
		registerBlock(TAKEFENCE_Y);
		registerBlock(TAKEFENCE_K);

		registerBlock(TAKE_TRAPDOOR);
		registerBlock(TAKE_TRAPDOOR_Y);
		registerBlock(TAKE_TRAPDOOR_K);
		registerBlock(TAKE_PLATE);
		registerBlock(TAKE_PLATE_Y);
		registerBlock(TAKE_PLATE_K);
		registerBlock(TAKE_BUTTON);
		registerBlock(TAKE_BUTTON_Y);
		registerBlock(TAKE_BUTTON_K);

		registerBlock(WADAIKO_TOP);
		registerBlock(WADAIKO_BOT);
		registerBlock(WADAIKO_small);

	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
