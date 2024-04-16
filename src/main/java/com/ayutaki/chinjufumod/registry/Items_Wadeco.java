package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.bamboo.BButton_Item;
import com.ayutaki.chinjufumod.items.bamboo.BFenceGate_Item;
import com.ayutaki.chinjufumod.items.bamboo.BFence_Item;
import com.ayutaki.chinjufumod.items.bamboo.BPlate_Item;
import com.ayutaki.chinjufumod.items.color.ItemHake;
import com.ayutaki.chinjufumod.items.color.ItemHake_Black;
import com.ayutaki.chinjufumod.items.color.ItemHake_Blue;
import com.ayutaki.chinjufumod.items.color.ItemHake_Brown;
import com.ayutaki.chinjufumod.items.color.ItemHake_Cyan;
import com.ayutaki.chinjufumod.items.color.ItemHake_Gray;
import com.ayutaki.chinjufumod.items.color.ItemHake_Green;
import com.ayutaki.chinjufumod.items.color.ItemHake_LightBlue;
import com.ayutaki.chinjufumod.items.color.ItemHake_LightGray;
import com.ayutaki.chinjufumod.items.color.ItemHake_Lime;
import com.ayutaki.chinjufumod.items.color.ItemHake_Magenta;
import com.ayutaki.chinjufumod.items.color.ItemHake_Orange;
import com.ayutaki.chinjufumod.items.color.ItemHake_Pink;
import com.ayutaki.chinjufumod.items.color.ItemHake_Purple;
import com.ayutaki.chinjufumod.items.color.ItemHake_Red;
import com.ayutaki.chinjufumod.items.color.ItemHake_White;
import com.ayutaki.chinjufumod.items.color.ItemHake_Yellow;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.furniture.Andon1_Item;
import com.ayutaki.chinjufumod.items.furniture.Andon2_Item;
import com.ayutaki.chinjufumod.items.furniture.Andon3_Item;
import com.ayutaki.chinjufumod.items.furniture.Andon4_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Bonsai_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Chouzubachi_Item;
import com.ayutaki.chinjufumod.items.jpdeco.DoorBamboo_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Endai_Item;
import com.ayutaki.chinjufumod.items.jpdeco.FusumaB_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Fusuma_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Futon_Item;
import com.ayutaki.chinjufumod.items.jpdeco.GarasudoHalf_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Garasudo_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Gate_Item;
import com.ayutaki.chinjufumod.items.jpdeco.IkegakiLong_Item;
import com.ayutaki.chinjufumod.items.jpdeco.IkegakiSmall_Item;
import com.ayutaki.chinjufumod.items.jpdeco.IronFence_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Ishitourou_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Itabei_Item;
import com.ayutaki.chinjufumod.items.jpdeco.ItemChisel;
import com.ayutaki.chinjufumod.items.jpdeco.ItemKumade;
import com.ayutaki.chinjufumod.items.jpdeco.Kanki_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Kanyou_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Kasa_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Kido_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Koushi_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Longtourou_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Noren_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Ranma_Item;
import com.ayutaki.chinjufumod.items.jpdeco.ShishiOdoshi_Item;
import com.ayutaki.chinjufumod.items.jpdeco.ShoujiHalf_Item;
import com.ayutaki.chinjufumod.items.jpdeco.ShoujiWindow_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Shouji_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Takeakari_Item;
import com.ayutaki.chinjufumod.items.jpdeco.TobukuroWin_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Tobukuro_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Wadaiko_Item;
import com.ayutaki.chinjufumod.items.jpdeco.ZabutonWara_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Zabuton_Item;
import com.ayutaki.chinjufumod.items.jpdeco.Zaisu_Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Wadeco {

	public static Item GARASUDO_item, GARASUDOH_item, SHOUJI_item, SHOUJIH_item, SHOUJIWIN_item;

	public static Item RANMA_item, KANKI_item, KOUSHI_item;

	public static Item FUSUMA_item, FUSUMAB_item;
	public static Item SUDARE, NOREN_item;

	public static Item WARAZABUTON, ZABUTON_item, ZAISU_item;

	public static Item TATAMI, TATAMI_white, TATAMI_orange, TATAMI_magenta, TATAMI_lightb,
								TATAMI_yellow, TATAMI_lime, TATAMI_pink, TATAMI_gray,
								TATAMI_lightg, TATAMI_cyan, TATAMI_purple, TATAMI_blue,
								TATAMI_brown, TATAMI_green, TATAMI_red, TATAMI_black;

	public static Item TATAMIY, TATAMIY_white, TATAMIY_orange, TATAMIY_magenta, TATAMIY_lightb,
								TATAMIY_yellow, TATAMIY_lime, TATAMIY_pink, TATAMIY_gray,
								TATAMIY_lightg, TATAMIY_cyan, TATAMIY_purple, TATAMIY_blue,
								TATAMIY_brown, TATAMIY_green, TATAMIY_red, TATAMIY_black;

	public static Item TAKECUBE, TAKECUBE_Y, TAKECUBE_K, TAKE_SH, TAKE_SHY, TAKE_SHK, TAKE_ST, TAKE_STY, TAKE_STK;
	public static Item TAKEFENCE, TAKEFENCEGATE, TAKEDOOR;
	public static Item TAKE_TRAPDOOR, TAKE_TRAPDOOR_Y, TAKE_TRAPDOOR_K;
	public static Item TAKE_PLATE, TAKE_BUTTON;

	public static Item FUTON_item;
	public static Item ANDON_1, ANDON_2, ANDON_3, ANDON_4;
	public static Item KASA_item;

	public static Item TOBUKUROS_WINR, TOBUKUROS_BOTR, TOBUKURO_WINR, TOBUKURO_BOTR;

	public static Item BONSAI_item, KANYOU_BOT, IKEGAKI, IKEGAKILONG_BOT, ITABEI_item, KIDO_item;

	public static Item SHISHIODOSHI;
	public static Item CHOUZUBACHI, ISHITOUROU, LONGTOUROU;
	public static Item TAKEAKARI;

	public static Item WADAIKO, WADAIKO_small;

	public static Item ENDAI;

	public static Item GATE, TETSUSAKU_BOT;

	public static Item HAKE;
	public static Item HAKE_white, HAKE_orange, HAKE_magenta, HAKE_lightb,
								HAKE_yellow, HAKE_lime, HAKE_pink, HAKE_gray,
								HAKE_lightg, HAKE_cyan, HAKE_purple, HAKE_blue,
								HAKE_brown, HAKE_green, HAKE_red, HAKE_black;

	public static Item KUMADE, NOMI, MAKIBISHI;

	public static void init() {

		GARASUDO_item = new Garasudo_Item("block_garasudo");
		GARASUDOH_item = new GarasudoHalf_Item("block_garasudohalf");
		SHOUJI_item = new Shouji_Item("block_shouji");
		SHOUJIH_item = new ShoujiHalf_Item("block_shoujihalf");
		SHOUJIWIN_item = new ShoujiWindow_Item("block_shoujih");

		RANMA_item = new Ranma_Item("block_ranma");
		KANKI_item = new Kanki_Item("block_kanki");
		KOUSHI_item = new Koushi_Item("block_koushi");

		FUSUMA_item = new Fusuma_Item("block_fusuma");
		FUSUMAB_item = new FusumaB_Item("block_fusumab");
		SUDARE = new ItemBlock_Fuel100("block_sudare_1", JPDeco_Blocks.SUDARE);
		NOREN_item = new Noren_Item("block_noren");
		
		WARAZABUTON = new ZabutonWara_Item("block_wara_zabuton");
		ZABUTON_item = new Zabuton_Item("block_mzabuton");
		ZAISU_item = new Zaisu_Item("block_zaisu");

		TATAMI = new ItemBlock_Fuel150("block_tatamih", JPDeco_Blocks.TATAMI);
		TATAMI_white = new ItemBlock_Fuel150("block_tatamih_white", JPDeco_Blocks.TATAMI_white);
		TATAMI_orange = new ItemBlock_Fuel150("block_tatamih_orange", JPDeco_Blocks.TATAMI_orange);
		TATAMI_magenta = new ItemBlock_Fuel150("block_tatamih_magenta", JPDeco_Blocks.TATAMI_magenta);
		TATAMI_lightb = new ItemBlock_Fuel150("block_tatamih_lightb", JPDeco_Blocks.TATAMI_lightb);
		TATAMI_yellow = new ItemBlock_Fuel150("block_tatamih_yellow", JPDeco_Blocks.TATAMI_yellow);
		TATAMI_lime = new ItemBlock_Fuel150("block_tatamih_lime", JPDeco_Blocks.TATAMI_lime);
		TATAMI_pink = new ItemBlock_Fuel150("block_tatamih_pink", JPDeco_Blocks.TATAMI_pink);
		TATAMI_gray = new ItemBlock_Fuel150("block_tatamih_gray", JPDeco_Blocks.TATAMI_gray);
		TATAMI_lightg = new ItemBlock_Fuel150("block_tatamih_lightg", JPDeco_Blocks.TATAMI_lightg);
		TATAMI_cyan = new ItemBlock_Fuel150("block_tatamih_cyan", JPDeco_Blocks.TATAMI_cyan);
		TATAMI_purple = new ItemBlock_Fuel150("block_tatamih_purple", JPDeco_Blocks.TATAMI_purple);
		TATAMI_blue = new ItemBlock_Fuel150("block_tatamih_blue", JPDeco_Blocks.TATAMI_blue);
		TATAMI_brown = new ItemBlock_Fuel150("block_tatamih_brown", JPDeco_Blocks.TATAMI_brown);
		TATAMI_green = new ItemBlock_Fuel150("block_tatamih_green", JPDeco_Blocks.TATAMI_green);
		TATAMI_red = new ItemBlock_Fuel150("block_tatamih_red", JPDeco_Blocks.TATAMI_red);
		TATAMI_black = new ItemBlock_Fuel150("block_tatamih_black", JPDeco_Blocks.TATAMI_black);

		TATAMIY = new ItemBlock_Fuel150("block_tatamih_y", JPDeco_Blocks.TATAMIY);
		TATAMIY_white = new ItemBlock_Fuel150("block_tatamih_y_white", JPDeco_Blocks.TATAMIY_white);
		TATAMIY_orange = new ItemBlock_Fuel150("block_tatamih_y_orange", JPDeco_Blocks.TATAMIY_orange);
		TATAMIY_magenta = new ItemBlock_Fuel150("block_tatamih_y_magenta", JPDeco_Blocks.TATAMIY_magenta);
		TATAMIY_lightb = new ItemBlock_Fuel150("block_tatamih_y_lightb", JPDeco_Blocks.TATAMIY_lightb);
		TATAMIY_yellow = new ItemBlock_Fuel150("block_tatamih_y_yellow", JPDeco_Blocks.TATAMIY_yellow);
		TATAMIY_lime = new ItemBlock_Fuel150("block_tatamih_y_lime", JPDeco_Blocks.TATAMIY_lime);
		TATAMIY_pink = new ItemBlock_Fuel150("block_tatamih_y_pink", JPDeco_Blocks.TATAMIY_pink);
		TATAMIY_gray = new ItemBlock_Fuel150("block_tatamih_y_gray", JPDeco_Blocks.TATAMIY_gray);
		TATAMIY_lightg = new ItemBlock_Fuel150("block_tatamih_y_lightg", JPDeco_Blocks.TATAMIY_lightg);
		TATAMIY_cyan = new ItemBlock_Fuel150("block_tatamih_y_cyan", JPDeco_Blocks.TATAMIY_cyan);
		TATAMIY_purple = new ItemBlock_Fuel150("block_tatamih_y_purple", JPDeco_Blocks.TATAMIY_purple);
		TATAMIY_blue = new ItemBlock_Fuel150("block_tatamih_y_blue", JPDeco_Blocks.TATAMIY_blue);
		TATAMIY_brown = new ItemBlock_Fuel150("block_tatamih_y_brown", JPDeco_Blocks.TATAMIY_brown);
		TATAMIY_green = new ItemBlock_Fuel150("block_tatamih_y_green", JPDeco_Blocks.TATAMIY_green);
		TATAMIY_red = new ItemBlock_Fuel150("block_tatamih_y_red", JPDeco_Blocks.TATAMIY_red);
		TATAMIY_black = new ItemBlock_Fuel150("block_tatamih_y_black", JPDeco_Blocks.TATAMIY_black);

		TAKECUBE = new ItemBlock_Fuel200("block_bamboo_cube", JPDeco_Blocks.TAKECUBE);
		TAKECUBE_Y = new ItemBlock_Fuel200("block_bamboo_y_cube", JPDeco_Blocks.TAKECUBE_Y);
		TAKECUBE_K = new ItemBlock_Fuel200("block_bamboo_k_cube", JPDeco_Blocks.TAKECUBE_K);
		TAKE_SH = new ItemBlock_Fuel100("block_bamboo_slab", JPDeco_Blocks.TAKE_SH);
		TAKE_SHY = new ItemBlock_Fuel100("block_bamboo_y_slab", JPDeco_Blocks.TAKE_SHY);
		TAKE_SHK = new ItemBlock_Fuel100("block_bamboo_k_slab", JPDeco_Blocks.TAKE_SHK);
		TAKE_ST = new ItemBlock_Fuel150("block_bamboo_stairs", JPDeco_Blocks.TAKE_ST);
		TAKE_STY = new ItemBlock_Fuel150("block_bamboo_y_stairs", JPDeco_Blocks.TAKE_STY);
		TAKE_STK = new ItemBlock_Fuel150("block_bamboo_k_stairs", JPDeco_Blocks.TAKE_STK);

		TAKEFENCE = new BFence_Item("block_bamboo_fence");
		TAKEFENCEGATE = new BFenceGate_Item("block_bamboo_fencegate");
		TAKEDOOR = new DoorBamboo_Item("block_bamboo_door");

		TAKE_TRAPDOOR = new ItemBlock_Fuel150("block_bamboo_trapdoor", JPDeco_Blocks.TAKE_TRAPDOOR);
		TAKE_TRAPDOOR_Y = new ItemBlock_Fuel150("block_bamboo_y_trapdoor", JPDeco_Blocks.TAKE_TRAPDOOR_Y);
		TAKE_TRAPDOOR_K = new ItemBlock_Fuel150("block_bamboo_k_trapdoor", JPDeco_Blocks.TAKE_TRAPDOOR_K);
		TAKE_PLATE = new BPlate_Item("block_bamboo_plate");
		TAKE_BUTTON = new BButton_Item("block_bamboo_button");

		FUTON_item = new Futon_Item("block_futon");
		ANDON_1 = new Andon1_Item("block_andon");
		ANDON_2 = new Andon2_Item("block_andon_2");
		ANDON_3 = new Andon3_Item("block_andon_3");
		ANDON_4 = new Andon4_Item("block_andon_4");
		KASA_item = new Kasa_Item("block_mkasa");
		
		TOBUKUROS_WINR = new TobukuroWin_Item("block_tobukurowin_spruce");
		TOBUKUROS_BOTR = new Tobukuro_Item("block_tobukuro_spruce");
		TOBUKURO_WINR = new TobukuroWin_Item("block_tobukurowin");
		TOBUKURO_BOTR = new Tobukuro_Item("block_tobukuro");

		BONSAI_item = new Bonsai_Item("block_bonsai");
		KANYOU_BOT = new Kanyou_Item("block_kanyou_bottom");
		IKEGAKI = new IkegakiSmall_Item("block_ikegaki_small");
		IKEGAKILONG_BOT = new IkegakiLong_Item("block_ikegakilong_bottom");

		ITABEI_item = new Itabei_Item("block_itabei");
		KIDO_item = new Kido_Item("block_kido");
		
		SHISHIODOSHI = new ShishiOdoshi_Item("block_shishiodoshi");
		CHOUZUBACHI = new Chouzubachi_Item("block_chouzubachi_kara");
		ISHITOUROU = new Ishitourou_Item("block_ishitourou_stone");
		LONGTOUROU = new Longtourou_Item("block_longtourou_bot");

		TAKEAKARI = new Takeakari_Item("block_takeakari");

		WADAIKO = new Wadaiko_Item("block_wadaiko");
		WADAIKO_small = new ItemBlock_Fuel150("block_wadaiko_small", JPDeco_Blocks.WADAIKO_small);

		ENDAI = new Endai_Item("block_mendai");

		GATE = new Gate_Item("block_gate");
		TETSUSAKU_BOT = new IronFence_Item("block_ironfence_bot");

		HAKE = new ItemHake("item_hake");
		HAKE_white = new ItemHake_White("item_hake_white");
		HAKE_orange = new ItemHake_Orange("item_hake_orange");
		HAKE_magenta = new ItemHake_Magenta("item_hake_magenta");
		HAKE_lightb = new ItemHake_LightBlue("item_hake_lightblue");
		HAKE_yellow = new ItemHake_Yellow("item_hake_yellow");
		HAKE_lime = new ItemHake_Lime("item_hake_lime");
		HAKE_pink = new ItemHake_Pink("item_hake_pink");
		HAKE_gray = new ItemHake_Gray("item_hake_gray");
		HAKE_lightg = new ItemHake_LightGray("item_hake_lightgray");
		HAKE_cyan = new ItemHake_Cyan("item_hake_cyan");
		HAKE_purple = new ItemHake_Purple("item_hake_purple");
		HAKE_blue = new ItemHake_Blue("item_hake_blue");
		HAKE_brown = new ItemHake_Brown("item_hake_brown");
		HAKE_green = new ItemHake_Green("item_hake_green");
		HAKE_red = new ItemHake_Red("item_hake_red");
		HAKE_black = new ItemHake_Black("item_hake_black");

		KUMADE = new ItemKumade("item_kumade");
		NOMI = new ItemChisel("item_chisel");
		MAKIBISHI = new ItemBlock_noFuel("block_makibishi", Garden_Blocks.MAKIBISHI);
	}

	public static void register() {

		registerItem(GARASUDO_item);
		registerItem(GARASUDOH_item);
		registerItem(SHOUJI_item);
		registerItem(SHOUJIH_item);
		registerItem(SHOUJIWIN_item);

		registerItem(RANMA_item);
		registerItem(KANKI_item);
		registerItem(KOUSHI_item);

		registerItem(FUSUMA_item);
		registerItem(FUSUMAB_item);
		registerItem(SUDARE);
		registerItem(NOREN_item);

		registerItem(WARAZABUTON);
		registerItem(ZABUTON_item);
		registerItem(ZAISU_item);

		registerItem(TATAMI);
		registerItem(TATAMI_white);
		registerItem(TATAMI_orange);
		registerItem(TATAMI_magenta);
		registerItem(TATAMI_lightb);
		registerItem(TATAMI_yellow);
		registerItem(TATAMI_lime);
		registerItem(TATAMI_pink);
		registerItem(TATAMI_gray);
		registerItem(TATAMI_lightg);
		registerItem(TATAMI_cyan);
		registerItem(TATAMI_purple);
		registerItem(TATAMI_blue);
		registerItem(TATAMI_brown);
		registerItem(TATAMI_green);
		registerItem(TATAMI_red);
		registerItem(TATAMI_black);

		registerItem(TATAMIY);
		registerItem(TATAMIY_white);
		registerItem(TATAMIY_orange);
		registerItem(TATAMIY_magenta);
		registerItem(TATAMIY_lightb);
		registerItem(TATAMIY_yellow);
		registerItem(TATAMIY_lime);
		registerItem(TATAMIY_pink);
		registerItem(TATAMIY_gray);
		registerItem(TATAMIY_lightg);
		registerItem(TATAMIY_cyan);
		registerItem(TATAMIY_purple);
		registerItem(TATAMIY_blue);
		registerItem(TATAMIY_brown);
		registerItem(TATAMIY_green);
		registerItem(TATAMIY_red);
		registerItem(TATAMIY_black);

		registerItem(TAKECUBE);
		registerItem(TAKECUBE_Y);
		registerItem(TAKECUBE_K);
		registerItem(TAKE_SH);
		registerItem(TAKE_SHY);
		registerItem(TAKE_SHK);
		registerItem(TAKE_ST);
		registerItem(TAKE_STY);
		registerItem(TAKE_STK);

		registerItem(TAKEFENCE);
		registerItem(TAKEFENCEGATE);
		registerItem(TAKEDOOR);

		registerItem(TAKE_TRAPDOOR);
		registerItem(TAKE_TRAPDOOR_Y);
		registerItem(TAKE_TRAPDOOR_K);
		registerItem(TAKE_PLATE);
		registerItem(TAKE_BUTTON);

		registerItem(FUTON_item);
		registerItem(ANDON_1);
		registerItem(ANDON_2);
		registerItem(ANDON_3);
		registerItem(ANDON_4);
		registerItem(KASA_item);

		registerItem(TOBUKUROS_WINR);
		registerItem(TOBUKUROS_BOTR);
		registerItem(TOBUKURO_WINR);
		registerItem(TOBUKURO_BOTR);

		registerItem(BONSAI_item);
		registerItem(KANYOU_BOT);
		registerItem(IKEGAKI);
		registerItem(IKEGAKILONG_BOT);

		registerItem(ITABEI_item);
		registerItem(KIDO_item);
		
		registerItem(SHISHIODOSHI);
		registerItem(CHOUZUBACHI);
		registerItem(ISHITOUROU);
		registerItem(LONGTOUROU);

		registerItem(TAKEAKARI);

		registerItem(WADAIKO);
		registerItem(WADAIKO_small);

		registerItem(ENDAI);

		registerItem(GATE);
		registerItem(TETSUSAKU_BOT);

		registerItem(HAKE);
		registerItem(HAKE_white);
		registerItem(HAKE_orange);
		registerItem(HAKE_magenta);
		registerItem(HAKE_lightb);
		registerItem(HAKE_yellow);
		registerItem(HAKE_lime);
		registerItem(HAKE_pink);
		registerItem(HAKE_gray);
		registerItem(HAKE_lightg);
		registerItem(HAKE_cyan);
		registerItem(HAKE_purple);
		registerItem(HAKE_blue);
		registerItem(HAKE_brown);
		registerItem(HAKE_green);
		registerItem(HAKE_red);
		registerItem(HAKE_black);

		registerItem(KUMADE);
		registerItem(NOMI);
		registerItem(MAKIBISHI);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRenderMeta(GARASUDO_item, 0, "block_garasudo");
		registerRenderMeta(GARASUDO_item, 1, "block_garasudo_spruce");
		registerRenderMeta(GARASUDO_item, 2, "block_garasudo_birch");
		registerRenderMeta(GARASUDO_item, 3, "block_garasudo_jungle");
		registerRenderMeta(GARASUDO_item, 4, "block_garasudo_acacia");
		registerRenderMeta(GARASUDO_item, 5, "block_garasudo_darkoak");
		registerRenderMeta(GARASUDO_item, 6, "block_garasudob");
		registerRenderMeta(GARASUDO_item, 7, "block_garasudob_spruce");
		registerRenderMeta(GARASUDO_item, 8, "block_garasudob_birch");
		registerRenderMeta(GARASUDO_item, 9, "block_garasudob_jungle");
		registerRenderMeta(GARASUDO_item, 10, "block_garasudob_acacia");
		registerRenderMeta(GARASUDO_item, 11, "block_garasudob_darkoak");

		registerRenderMeta(GARASUDOH_item, 0, "block_garasudohalf");
		registerRenderMeta(GARASUDOH_item, 1, "block_garasudohalf_spruce");
		registerRenderMeta(GARASUDOH_item, 2, "block_garasudohalf_birch");
		registerRenderMeta(GARASUDOH_item, 3, "block_garasudohalf_jungle");
		registerRenderMeta(GARASUDOH_item, 4, "block_garasudohalf_acacia");
		registerRenderMeta(GARASUDOH_item, 5, "block_garasudohalf_darkoak");

		registerRenderMeta(SHOUJI_item, 0, "block_shouji");
		registerRenderMeta(SHOUJI_item, 1, "block_shouji_spruce");
		registerRenderMeta(SHOUJI_item, 2, "block_shouji_birch");
		registerRenderMeta(SHOUJI_item, 3, "block_shouji_jungle");
		registerRenderMeta(SHOUJI_item, 4, "block_shouji_acacia");
		registerRenderMeta(SHOUJI_item, 5, "block_shouji_darkoak");
		registerRenderMeta(SHOUJI_item, 6, "block_shoujib");
		registerRenderMeta(SHOUJI_item, 7, "block_shoujib_spruce");
		registerRenderMeta(SHOUJI_item, 8, "block_shoujib_birch");
		registerRenderMeta(SHOUJI_item, 9, "block_shoujib_jungle");
		registerRenderMeta(SHOUJI_item, 10, "block_shoujib_acacia");
		registerRenderMeta(SHOUJI_item, 11, "block_shoujib_darkoak");
		registerRenderMeta(SHOUJIH_item, 0, "block_shoujihalf");
		registerRenderMeta(SHOUJIH_item, 1, "block_shoujihalf_spruce");
		registerRenderMeta(SHOUJIH_item, 2, "block_shoujihalf_birch");
		registerRenderMeta(SHOUJIH_item, 3, "block_shoujihalf_jungle");
		registerRenderMeta(SHOUJIH_item, 4, "block_shoujihalf_acacia");
		registerRenderMeta(SHOUJIH_item, 5, "block_shoujihalf_darkoak");
		registerRenderMeta(SHOUJIWIN_item, 0, "block_shoujih");
		registerRenderMeta(SHOUJIWIN_item, 1, "block_shoujih_spruce");
		registerRenderMeta(SHOUJIWIN_item, 2, "block_shoujih_birch");
		registerRenderMeta(SHOUJIWIN_item, 3, "block_shoujih_jungle");
		registerRenderMeta(SHOUJIWIN_item, 4, "block_shoujih_acacia");
		registerRenderMeta(SHOUJIWIN_item, 5, "block_shoujih_darkoak");
		
		registerRenderMeta(RANMA_item, 0, "block_ranma_oak");
		registerRenderMeta(RANMA_item, 1, "block_ranma_spru");
		registerRenderMeta(RANMA_item, 2, "block_ranma_bir");
		registerRenderMeta(RANMA_item, 3, "block_ranma_jun");
		registerRenderMeta(RANMA_item, 4, "block_ranma_aca");
		registerRenderMeta(RANMA_item, 5, "block_ranma_doak");
		registerRenderMeta(RANMA_item, 6, "block_ranmab_oak");
		registerRenderMeta(RANMA_item, 7, "block_ranmab_spru");
		registerRenderMeta(RANMA_item, 8, "block_ranmab_bir");
		registerRenderMeta(RANMA_item, 9, "block_ranmab_jun");
		registerRenderMeta(RANMA_item, 10, "block_ranmab_aca");
		registerRenderMeta(RANMA_item, 11, "block_ranmab_doak");

		registerRenderMeta(KANKI_item, 0, "block_ranmac_oak");
		registerRenderMeta(KANKI_item, 1, "block_ranmac_spru");
		registerRenderMeta(KANKI_item, 2, "block_ranmac_bir");
		registerRenderMeta(KANKI_item, 3, "block_ranmac_jun");
		registerRenderMeta(KANKI_item, 4, "block_ranmac_aca");
		registerRenderMeta(KANKI_item, 5, "block_ranmac_doak");
		registerRenderMeta(KANKI_item, 6, "block_kanki_oak");
		registerRenderMeta(KANKI_item, 7, "block_kanki_spru");
		registerRenderMeta(KANKI_item, 8, "block_kanki_bir");
		registerRenderMeta(KANKI_item, 9, "block_kanki_jun");
		registerRenderMeta(KANKI_item, 10, "block_kanki_aca");
		registerRenderMeta(KANKI_item, 11, "block_kanki_doak");

		registerRenderMeta(KOUSHI_item, 0, "block_koushi_oak");
		registerRenderMeta(KOUSHI_item, 1, "block_koushi_spru");
		registerRenderMeta(KOUSHI_item, 2, "block_koushi_bir");
		registerRenderMeta(KOUSHI_item, 3, "block_koushi_jun");
		registerRenderMeta(KOUSHI_item, 4, "block_koushi_aca");
		registerRenderMeta(KOUSHI_item, 5, "block_koushi_doak");
		registerRenderMeta(KOUSHI_item, 6, "block_koushib_oak");
		registerRenderMeta(KOUSHI_item, 7, "block_koushib_spru");
		registerRenderMeta(KOUSHI_item, 8, "block_koushib_bir");
		registerRenderMeta(KOUSHI_item, 9, "block_koushib_jun");
		registerRenderMeta(KOUSHI_item, 10, "block_koushib_aca");
		registerRenderMeta(KOUSHI_item, 11, "block_koushib_doak");

		registerRenderMeta(FUSUMA_item, 0, "block_fusuma");
		registerRenderMeta(FUSUMA_item, 1, "block_fusuma_orange");
		registerRenderMeta(FUSUMA_item, 2, "block_fusuma_magenta");
		registerRenderMeta(FUSUMA_item, 3, "block_fusuma_lightb");
		registerRenderMeta(FUSUMA_item, 4, "block_fusuma_yellow");
		registerRenderMeta(FUSUMA_item, 5, "block_fusuma_lime");
		registerRenderMeta(FUSUMA_item, 6, "block_fusuma_pink");
		registerRenderMeta(FUSUMA_item, 7, "block_fusuma_gray");
		registerRenderMeta(FUSUMA_item, 8, "block_fusuma_lightg");
		registerRenderMeta(FUSUMA_item, 9, "block_fusuma_cyan");
		registerRenderMeta(FUSUMA_item, 10, "block_fusuma_purple");
		registerRenderMeta(FUSUMA_item, 11, "block_fusuma_blue");
		registerRenderMeta(FUSUMA_item, 12, "block_fusuma_brown");
		registerRenderMeta(FUSUMA_item, 13, "block_fusuma_green");
		registerRenderMeta(FUSUMA_item, 14, "block_fusuma_red");
		registerRenderMeta(FUSUMA_item, 15, "block_fusuma_black");

		registerRenderMeta(FUSUMAB_item, 0, "block_fusumab");
		registerRenderMeta(FUSUMAB_item, 1, "block_fusumab_orange");
		registerRenderMeta(FUSUMAB_item, 2, "block_fusumab_magenta");
		registerRenderMeta(FUSUMAB_item, 3, "block_fusumab_lightb");
		registerRenderMeta(FUSUMAB_item, 4, "block_fusumab_yellow");
		registerRenderMeta(FUSUMAB_item, 5, "block_fusumab_lime");
		registerRenderMeta(FUSUMAB_item, 6, "block_fusumab_pink");
		registerRenderMeta(FUSUMAB_item, 7, "block_fusumab_gray");
		registerRenderMeta(FUSUMAB_item, 8, "block_fusumab_lightg");
		registerRenderMeta(FUSUMAB_item, 9, "block_fusumab_cyan");
		registerRenderMeta(FUSUMAB_item, 10, "block_fusumab_purple");
		registerRenderMeta(FUSUMAB_item, 11, "block_fusumab_blue");
		registerRenderMeta(FUSUMAB_item, 12, "block_fusumab_brown");
		registerRenderMeta(FUSUMAB_item, 13, "block_fusumab_green");
		registerRenderMeta(FUSUMAB_item, 14, "block_fusumab_red");
		registerRenderMeta(FUSUMAB_item, 15, "block_fusumab_black");

		registerRender(SUDARE);

		registerRenderMeta(NOREN_item, 0, "block_noren_white");
		registerRenderMeta(NOREN_item, 1, "block_noren_orange");
		registerRenderMeta(NOREN_item, 2, "block_noren_magenta");
		registerRenderMeta(NOREN_item, 3, "block_noren_lightb");
		registerRenderMeta(NOREN_item, 4, "block_noren_yellow");
		registerRenderMeta(NOREN_item, 5, "block_noren_lime");
		registerRenderMeta(NOREN_item, 6, "block_noren_pink");
		registerRenderMeta(NOREN_item, 7, "block_noren_gray");
		registerRenderMeta(NOREN_item, 8, "block_noren_lightg");
		registerRenderMeta(NOREN_item, 9, "block_noren_cyan");
		registerRenderMeta(NOREN_item, 10, "block_noren_purple");
		registerRenderMeta(NOREN_item, 11, "block_noren_blue");
		registerRenderMeta(NOREN_item, 12, "block_noren_brown");
		registerRenderMeta(NOREN_item, 13, "block_noren_green");
		registerRenderMeta(NOREN_item, 14, "block_noren_red");
		registerRenderMeta(NOREN_item, 15, "block_noren_black");

		registerRender(WARAZABUTON);
		registerRenderMeta(ZABUTON_item, 0, "block_mzabuton_white");
		registerRenderMeta(ZABUTON_item, 1, "block_mzabuton_orange");
		registerRenderMeta(ZABUTON_item, 2, "block_mzabuton_magenta");
		registerRenderMeta(ZABUTON_item, 3, "block_mzabuton_lightb");
		registerRenderMeta(ZABUTON_item, 4, "block_mzabuton_yellow");
		registerRenderMeta(ZABUTON_item, 5, "block_mzabuton_lime");
		registerRenderMeta(ZABUTON_item, 6, "block_mzabuton_pink");
		registerRenderMeta(ZABUTON_item, 7, "block_mzabuton_gray");
		registerRenderMeta(ZABUTON_item, 8, "block_mzabuton_lightg");
		registerRenderMeta(ZABUTON_item, 9, "block_mzabuton_cyan");
		registerRenderMeta(ZABUTON_item, 10, "block_mzabuton_purple");
		registerRenderMeta(ZABUTON_item, 11, "block_mzabuton_blue");
		registerRenderMeta(ZABUTON_item, 12, "block_mzabuton_brown");
		registerRenderMeta(ZABUTON_item, 13, "block_mzabuton_green");
		registerRenderMeta(ZABUTON_item, 14, "block_mzabuton_red");
		registerRenderMeta(ZABUTON_item, 15, "block_mzabuton_black");

		registerRenderMeta(ZAISU_item, 0, "block_zaisu_white");
		registerRenderMeta(ZAISU_item, 1, "block_zaisu_orange");
		registerRenderMeta(ZAISU_item, 2, "block_zaisu_magenta");
		registerRenderMeta(ZAISU_item, 3, "block_zaisu_lightb");
		registerRenderMeta(ZAISU_item, 4, "block_zaisu_yellow");
		registerRenderMeta(ZAISU_item, 5, "block_zaisu_lime");
		registerRenderMeta(ZAISU_item, 6, "block_zaisu_pink");
		registerRenderMeta(ZAISU_item, 7, "block_zaisu_gray");
		registerRenderMeta(ZAISU_item, 8, "block_zaisu_lightg");
		registerRenderMeta(ZAISU_item, 9, "block_zaisu_cyan");
		registerRenderMeta(ZAISU_item, 10, "block_zaisu_purple");
		registerRenderMeta(ZAISU_item, 11, "block_zaisu_blue");
		registerRenderMeta(ZAISU_item, 12, "block_zaisu_brown");
		registerRenderMeta(ZAISU_item, 13, "block_zaisu_green");
		registerRenderMeta(ZAISU_item, 14, "block_zaisu_red");
		registerRenderMeta(ZAISU_item, 15, "block_zaisu_black");

		registerRender(TATAMI);
		registerRender(TATAMI_white);
		registerRender(TATAMI_orange);
		registerRender(TATAMI_magenta);
		registerRender(TATAMI_lightb);
		registerRender(TATAMI_yellow);
		registerRender(TATAMI_lime);
		registerRender(TATAMI_pink);
		registerRender(TATAMI_gray);
		registerRender(TATAMI_lightg);
		registerRender(TATAMI_cyan);
		registerRender(TATAMI_purple);
		registerRender(TATAMI_blue);
		registerRender(TATAMI_brown);
		registerRender(TATAMI_green);
		registerRender(TATAMI_red);
		registerRender(TATAMI_black);

		registerRender(TATAMIY);
		registerRender(TATAMIY_white);
		registerRender(TATAMIY_orange);
		registerRender(TATAMIY_magenta);
		registerRender(TATAMIY_lightb);
		registerRender(TATAMIY_yellow);
		registerRender(TATAMIY_lime);
		registerRender(TATAMIY_pink);
		registerRender(TATAMIY_gray);
		registerRender(TATAMIY_lightg);
		registerRender(TATAMIY_cyan);
		registerRender(TATAMIY_purple);
		registerRender(TATAMIY_blue);
		registerRender(TATAMIY_brown);
		registerRender(TATAMIY_green);
		registerRender(TATAMIY_red);
		registerRender(TATAMIY_black);

		registerRender(TAKECUBE);
		registerRender(TAKECUBE_Y);
		registerRender(TAKECUBE_K);
		registerRender(TAKE_SH);
		registerRender(TAKE_SHY);
		registerRender(TAKE_SHK);
		registerRender(TAKE_ST);
		registerRender(TAKE_STY);
		registerRender(TAKE_STK);

		registerRenderMeta(TAKEFENCE, 0, "block_bamboo_fence");
		registerRenderMeta(TAKEFENCE, 1, "block_bamboo_y_fence");
		registerRenderMeta(TAKEFENCE, 2, "block_bamboo_k_fence");
		registerRenderMeta(TAKEFENCEGATE, 0, "block_bamboo_fencegate");
		registerRenderMeta(TAKEFENCEGATE, 1, "block_bamboo_y_fencegate");
		registerRenderMeta(TAKEFENCEGATE, 2, "block_bamboo_k_fencegate");
		registerRenderMeta(TAKEDOOR, 0, "block_bamboo_door");
		registerRenderMeta(TAKEDOOR, 1, "block_bamboo_y_door");
		registerRenderMeta(TAKEDOOR, 2, "block_bamboo_k_door");
		
		registerRender(TAKE_TRAPDOOR);
		registerRender(TAKE_TRAPDOOR_Y);
		registerRender(TAKE_TRAPDOOR_K);
		registerRenderMeta(TAKE_PLATE, 0, "block_bamboo_plate");
		registerRenderMeta(TAKE_PLATE, 1, "block_bamboo_y_plate");
		registerRenderMeta(TAKE_PLATE, 2, "block_bamboo_k_plate");
		registerRenderMeta(TAKE_BUTTON, 0, "block_bamboo_button");
		registerRenderMeta(TAKE_BUTTON, 1, "block_bamboo_y_button");
		registerRenderMeta(TAKE_BUTTON, 2, "block_bamboo_k_button");
		
		registerRenderMeta(FUTON_item, 0, "block_futon_c_white");
		registerRenderMeta(FUTON_item, 1, "block_futon_c_orange");
		registerRenderMeta(FUTON_item, 2, "block_futon_c_magenta");
		registerRenderMeta(FUTON_item, 3, "block_futon_c_lightb");
		registerRenderMeta(FUTON_item, 4, "block_futon_c_yellow");
		registerRenderMeta(FUTON_item, 5, "block_futon_c_lime");
		registerRenderMeta(FUTON_item, 6, "block_futon_c_pink");
		registerRenderMeta(FUTON_item, 7, "block_futon_c_gray");
		registerRenderMeta(FUTON_item, 8, "block_futon_c_lightg");
		registerRenderMeta(FUTON_item, 9, "block_futon_c_cyan");
		registerRenderMeta(FUTON_item, 10, "block_futon_c_purple");
		registerRenderMeta(FUTON_item, 11, "block_futon_c_blue");
		registerRenderMeta(FUTON_item, 12, "block_futon_c_brown");
		registerRenderMeta(FUTON_item, 13, "block_futon_c_green");
		registerRenderMeta(FUTON_item, 14, "block_futon_c_red");
		registerRenderMeta(FUTON_item, 15, "block_futon_c_black");

		registerRenderMeta(ANDON_1, 1, "block_andon_white");
		registerRenderMeta(ANDON_1, 2, "block_andon_orange");
		registerRenderMeta(ANDON_1, 3, "block_andon_magenta");
		registerRenderMeta(ANDON_1, 4, "block_andon_lightb");
		registerRenderMeta(ANDON_2, 1, "block_andon_yellow");
		registerRenderMeta(ANDON_2, 2, "block_andon_lime");
		registerRenderMeta(ANDON_2, 3, "block_andon_pink");
		registerRenderMeta(ANDON_2, 4, "block_andon_gray");
		registerRenderMeta(ANDON_3, 1, "block_andon_lightg");
		registerRenderMeta(ANDON_3, 2, "block_andon_cyan");
		registerRenderMeta(ANDON_3, 3, "block_andon_purple");
		registerRenderMeta(ANDON_3, 4, "block_andon_blue");
		registerRenderMeta(ANDON_4, 1, "block_andon_brown");
		registerRenderMeta(ANDON_4, 2, "block_andon_green");
		registerRenderMeta(ANDON_4, 3, "block_andon_red");
		registerRenderMeta(ANDON_4, 4, "block_andon_black");

		registerRenderMeta(KASA_item, 0, "block_mkasa_white");
		registerRenderMeta(KASA_item, 1, "block_mkasa_orange");
		registerRenderMeta(KASA_item, 2, "block_mkasa_magenta");
		registerRenderMeta(KASA_item, 3, "block_mkasa_lightb");
		registerRenderMeta(KASA_item, 4, "block_mkasa_yellow");
		registerRenderMeta(KASA_item, 5, "block_mkasa_lime");
		registerRenderMeta(KASA_item, 6, "block_mkasa_pink");
		registerRenderMeta(KASA_item, 7, "block_mkasa_gray");
		registerRenderMeta(KASA_item, 8, "block_mkasa_lightg");
		registerRenderMeta(KASA_item, 9, "block_mkasa_cyan");
		registerRenderMeta(KASA_item, 10, "block_mkasa_purple");
		registerRenderMeta(KASA_item, 11, "block_mkasa_blue");
		registerRenderMeta(KASA_item, 12, "block_mkasa_brown");
		registerRenderMeta(KASA_item, 13, "block_mkasa_green");
		registerRenderMeta(KASA_item, 14, "block_mkasa_red");
		registerRenderMeta(KASA_item, 15, "block_mkasa_black");

		registerRender(TOBUKUROS_WINR);
		registerRender(TOBUKUROS_BOTR);
		registerRender(TOBUKURO_WINR);
		registerRender(TOBUKURO_BOTR);

		registerRenderMeta(BONSAI_item, 0, "block_bonsai_oak");
		registerRenderMeta(BONSAI_item, 1, "block_bonsai_spruce");
		registerRenderMeta(BONSAI_item, 2, "block_bonsai_birch");
		registerRenderMeta(BONSAI_item, 3, "block_bonsai_jungle");
		registerRenderMeta(BONSAI_item, 4, "block_bonsai_acacia");
		registerRenderMeta(BONSAI_item, 5, "block_bonsai_darkoak");

		registerRenderMeta(KANYOU_BOT, 0, "block_kanyouoak_bot");
		registerRenderMeta(KANYOU_BOT, 1, "block_kanyouspruce_bot");
		registerRenderMeta(KANYOU_BOT, 2, "block_kanyoubirch_bot");
		registerRenderMeta(KANYOU_BOT, 3, "block_kanyoujungle_bot");
		registerRenderMeta(KANYOU_BOT, 4, "block_kanyouacacia_bot");
		registerRenderMeta(KANYOU_BOT, 5, "block_kanyoudarkoak_bot");
		registerRenderMeta(IKEGAKI, 0, "block_low_oak");
		registerRenderMeta(IKEGAKI, 1, "block_low_spruce");
		registerRenderMeta(IKEGAKI, 2, "block_low_birch");
		registerRenderMeta(IKEGAKI, 3, "block_low_jungle");
		registerRenderMeta(IKEGAKI, 4, "block_low_acacia");
		registerRenderMeta(IKEGAKI, 5, "block_low_darkoak");
		registerRenderMeta(IKEGAKILONG_BOT, 0, "block_longoak_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 1, "block_longspruce_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 2, "block_longbirch_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 3, "block_longjungle_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 4, "block_longacacia_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 5, "block_longdarkoak_bot");

		registerRenderMeta(ITABEI_item, 0, "block_itabei");
		registerRenderMeta(ITABEI_item, 1, "block_itabei_spruce");
		registerRenderMeta(ITABEI_item, 2, "block_itabei_birch");
		registerRenderMeta(ITABEI_item, 3, "block_itabei_jungle");
		registerRenderMeta(ITABEI_item, 4, "block_itabei_acacia");
		registerRenderMeta(ITABEI_item, 5, "block_itabei_darkoak");
		registerRenderMeta(KIDO_item, 0, "block_kido");
		registerRenderMeta(KIDO_item, 1, "block_kido_spruce");
		registerRenderMeta(KIDO_item, 2, "block_kido_birch");
		registerRenderMeta(KIDO_item, 3, "block_kido_jungle");
		registerRenderMeta(KIDO_item, 4, "block_kido_acacia");
		registerRenderMeta(KIDO_item, 5, "block_kido_darkoak");
		
		registerRender(SHISHIODOSHI);
		registerRenderMeta(CHOUZUBACHI, 0, "block_chouzubachi_kara");
		registerRenderMeta(CHOUZUBACHI, 1, "block_chouzu_gra_kara");
		registerRenderMeta(CHOUZUBACHI, 2, "block_chouzu_dio_kara");
		registerRenderMeta(CHOUZUBACHI, 3, "block_chouzu_and_kara");
		registerRenderMeta(ISHITOUROU, 1, "block_ishitourou_stone");
		registerRenderMeta(ISHITOUROU, 2, "block_ishitourou_gra");
		registerRenderMeta(ISHITOUROU, 3, "block_ishitourou_dio");
		registerRenderMeta(ISHITOUROU, 4, "block_ishitourou_and");
		registerRenderMeta(LONGTOUROU, 1, "block_longtourou_stone");
		registerRenderMeta(LONGTOUROU, 2, "block_longtourou_gra");
		registerRenderMeta(LONGTOUROU, 3, "block_longtourou_dio");
		registerRenderMeta(LONGTOUROU, 4, "block_longtourou_and");

		registerRenderMeta(TAKEAKARI, 0, "block_takeakari");
		registerRenderMeta(TAKEAKARI, 1, "block_takeakari_y");
		registerRenderMeta(TAKEAKARI, 2, "block_takeakari_k");
		
		registerRender(WADAIKO);
		registerRender(WADAIKO_small);

		registerRenderMeta(ENDAI, 0, "block_mendai");
		registerRenderMeta(ENDAI, 1, "block_mendai_red");

		registerRenderMeta(GATE, 0, "block_gate_spruce_b");
		registerRenderMeta(GATE, 1, "block_gate_spruce");
		registerRenderMeta(GATE, 2, "block_gate_iron");
		registerRenderMeta(GATE, 3, "block_gate_irongrill");
		registerRender(TETSUSAKU_BOT);

		registerRender(HAKE);
		registerRender(HAKE_white);
		registerRender(HAKE_orange);
		registerRender(HAKE_magenta);
		registerRender(HAKE_lightb);
		registerRender(HAKE_yellow);
		registerRender(HAKE_lime);
		registerRender(HAKE_pink);
		registerRender(HAKE_gray);
		registerRender(HAKE_lightg);
		registerRender(HAKE_cyan);
		registerRender(HAKE_purple);
		registerRender(HAKE_blue);
		registerRender(HAKE_brown);
		registerRender(HAKE_green);
		registerRender(HAKE_red);
		registerRender(HAKE_black);

		registerRender(KUMADE);
		registerRender(NOMI);
		registerRender(MAKIBISHI);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

}
