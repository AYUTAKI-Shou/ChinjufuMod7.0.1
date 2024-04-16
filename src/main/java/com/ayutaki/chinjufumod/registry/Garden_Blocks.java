package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.garden.Bonsai;
import com.ayutaki.chinjufumod.blocks.garden.Chouzubachi;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Top;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiSmall;
import com.ayutaki.chinjufumod.blocks.garden.IronFence_Bot;
import com.ayutaki.chinjufumod.blocks.garden.IronFence_Top;
import com.ayutaki.chinjufumod.blocks.garden.Ishitourou;
import com.ayutaki.chinjufumod.blocks.garden.Itabei;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Top;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Top;
import com.ayutaki.chinjufumod.blocks.garden.Lit_Ishitourou;
import com.ayutaki.chinjufumod.blocks.garden.Lit_Longtourou;
import com.ayutaki.chinjufumod.blocks.garden.Longtourou_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Longtourou_Top;
import com.ayutaki.chinjufumod.blocks.garden.Makibishi;
import com.ayutaki.chinjufumod.blocks.garden.Niwaishi;
import com.ayutaki.chinjufumod.blocks.garden.Niwaishi_slab;
import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop_2;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop_B;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop_B2;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_2;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_B;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_B2;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;

public class Garden_Blocks {

	public static Block KASA_white, KASA_orange, KASA_magenta, KASA_lightb,
								KASA_yellow, KASA_lime, KASA_pink, KASA_gray,
								KASA_lightg, KASA_cyan, KASA_purple, KASA_blue,
								KASA_brown, KASA_green, KASA_red, KASA_black;

	public static Block BONSAI_oak, BONSAI_spru, BONSAI_bir, BONSAI_jun, BONSAI_aca, BONSAI_doak;
	public static Block KANYOU_TOP, KANYOU_BOT, KANYOU2_TOP, KANYOU2_BOT;
	public static Block IKEGAKI_S;
	public static Block IKEGAKI_L_TOP, IKEGAKI_L_BOT;

	public static Block ITABEI, ITABEI_spruce, ITABEI_birch, ITABEI_jungle, ITABEI_acacia, 
								ITABEI_darkoak, ITABEI_sakura, ITABEI_kaede, ITABEI_ichoh;
	
	public static Block CHOUZUBACHI;
	public static Block SHISHIODOSHI, SHISHIODOSHI2, SHISHIODOSHIB, SHISHIODOSHIB2,
								SHISHIODOSHI_T, SHISHIODOSHI_T2, SHISHIODOSHI_TB, SHISHIODOSHI_TB2;

	public static Block ISHITOUROU, LIT_ISHITOUROU;
	public static Block LONGTOUROU_TOP, LONGTOUROU_BOT, LIT_LONGTOUROU_TOP;

	public static Block TETSUSAKU_TOP, TETSUSAKU_BOT;
	public static Block SAMON, SAMON_B;
	public static Block NIWAISHI, NIWAISHI_gra, NIWAISHI_dio, NIWAISHI_and;
	public static Block NIWAISHI_slab, NIWAISHI_slab_gra, NIWAISHI_slab_dio, NIWAISHI_slab_and;
	public static Block MAKIBISHI;
	
	public static void init() {

		KASA_white = new Wagasa("block_mkasa_white", MapColor.SNOW);
		KASA_orange = new Wagasa("block_mkasa_orange", MapColor.ADOBE);
		KASA_magenta = new Wagasa("block_mkasa_magenta", MapColor.MAGENTA);
		KASA_lightb = new Wagasa("block_mkasa_lightb", MapColor.LIGHT_BLUE);
		KASA_yellow = new Wagasa("block_mkasa_yellow", MapColor.YELLOW);
		KASA_lime = new Wagasa("block_mkasa_lime", MapColor.LIME);
		KASA_pink = new Wagasa("block_mkasa_pink", MapColor.PINK);
		KASA_gray = new Wagasa("block_mkasa_gray", MapColor.GRAY);
		KASA_lightg = new Wagasa("block_mkasa_lightg", MapColor.SILVER);
		KASA_cyan = new Wagasa("block_mkasa_cyan", MapColor.CYAN);
		KASA_purple = new Wagasa("block_mkasa_purple", MapColor.PURPLE);
		KASA_blue = new Wagasa("block_mkasa_blue", MapColor.BLUE);
		KASA_brown = new Wagasa("block_mkasa_brown", MapColor.BROWN);
		KASA_green = new Wagasa("block_mkasa_green", MapColor.GREEN);
		KASA_red = new Wagasa("block_mkasa_red", MapColor.RED);
		KASA_black = new Wagasa("block_mkasa_black", MapColor.BLACK);

		BONSAI_oak = new Bonsai("block_bonsai_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_spru = new Bonsai("block_bonsai_spruce").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_bir = new Bonsai("block_bonsai_birch").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_jun = new Bonsai("block_bonsai_jungle").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_aca = new Bonsai("block_bonsai_acacia").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_doak = new Bonsai("block_bonsai_darkoak").setCreativeTab(ChinjufuModTabs.WADECO);

		KANYOU_TOP = new Kanyou_Top("block_kanyou_top");
		KANYOU_BOT = new Kanyou_Bottom("block_kanyou_bottom");
		KANYOU2_TOP = new Kanyou2_Top("block_kanyou2_top");
		KANYOU2_BOT = new Kanyou2_Bottom("block_kanyou2_bottom");
		IKEGAKI_S = new IkegakiSmall("block_ikegaki_small", MapColor.FOLIAGE);
		IKEGAKI_L_TOP = new IkegakiLong_Top("block_ikegakilong_top", MapColor.FOLIAGE);
		IKEGAKI_L_BOT = new IkegakiLong_Bottom("block_ikegakilong_bottom", MapColor.FOLIAGE);

		ITABEI = new Itabei("block_itabei");
		ITABEI_spruce = new Itabei("block_itabei_spruce");
		ITABEI_birch = new Itabei("block_itabei_birch");
		ITABEI_jungle = new Itabei("block_itabei_jungle");
		ITABEI_acacia = new Itabei("block_itabei_acacia");
		ITABEI_darkoak = new Itabei("block_itabei_darkoak");
		ITABEI_sakura = new Itabei("block_itabei_sakura");
		ITABEI_kaede = new Itabei("block_itabei_kaede");
		ITABEI_ichoh = new Itabei("block_itabei_ichoh");
		
		CHOUZUBACHI = new Chouzubachi("block_chouzubachi_kara");
		SHISHIODOSHI = new ShishiOdoshi("block_shishiodoshi");
		SHISHIODOSHI2 = new ShishiOdoshi_2("block_shishiodoshi2");
		SHISHIODOSHIB = new ShishiOdoshi_B("block_shishiodoshi_b");
		SHISHIODOSHIB2 = new ShishiOdoshi_B2("block_shishiodoshi_b2");
		SHISHIODOSHI_T = new ShishiOdoshiTop("block_shishitop");
		SHISHIODOSHI_T2 = new ShishiOdoshiTop_2("block_shishitop_2");
		SHISHIODOSHI_TB = new ShishiOdoshiTop_B("block_shishitop_b");
		SHISHIODOSHI_TB2 = new ShishiOdoshiTop_B2("block_shishitop_b2");

		ISHITOUROU = new Ishitourou("block_ishitourou_stone");
		LIT_ISHITOUROU = new Lit_Ishitourou("lit_ishitourou_stone");
		LONGTOUROU_TOP = new Longtourou_Top("block_longtourou_top");
		LONGTOUROU_BOT = new Longtourou_Bottom("block_longtourou_bot");
		LIT_LONGTOUROU_TOP = new Lit_Longtourou("lit_longtourou_top");

		TETSUSAKU_TOP = new IronFence_Top("block_ironfence_top");
		TETSUSAKU_BOT = new IronFence_Bot("block_ironfence_bot");

		SAMON = new Samon("block_samon");
		SAMON_B = new Samon("block_samon_black");
		NIWAISHI = new Niwaishi("block_niwaishi");
		NIWAISHI_gra = new Niwaishi("block_niwaishi_gra");
		NIWAISHI_dio = new Niwaishi("block_niwaishi_dio");
		NIWAISHI_and = new Niwaishi("block_niwaishi_and");
		
		NIWAISHI_slab = new Niwaishi_slab("block_niwaishi_slab");
		NIWAISHI_slab_gra = new Niwaishi_slab("block_niwaishi_slab_gra");
		NIWAISHI_slab_dio = new Niwaishi_slab("block_niwaishi_slab_dio");
		NIWAISHI_slab_and = new Niwaishi_slab("block_niwaishi_slab_and");
		MAKIBISHI = new Makibishi("block_makibishi");
	}


	public static void register() {

		registerBlock(KASA_white);
		registerBlock(KASA_orange);
		registerBlock(KASA_magenta);
		registerBlock(KASA_lightb);
		registerBlock(KASA_yellow);
		registerBlock(KASA_lime);
		registerBlock(KASA_pink);
		registerBlock(KASA_gray);
		registerBlock(KASA_lightg);
		registerBlock(KASA_cyan);
		registerBlock(KASA_purple);
		registerBlock(KASA_blue);
		registerBlock(KASA_brown);
		registerBlock(KASA_green);
		registerBlock(KASA_red);
		registerBlock(KASA_black);

		registerBlock(BONSAI_oak);
		registerBlock(BONSAI_spru);
		registerBlock(BONSAI_bir);
		registerBlock(BONSAI_jun);
		registerBlock(BONSAI_aca);
		registerBlock(BONSAI_doak);

		registerBlock(KANYOU_TOP);
		registerBlock(KANYOU_BOT);
		registerBlock(KANYOU2_TOP);
		registerBlock(KANYOU2_BOT);
		registerBlock(IKEGAKI_S);
		registerBlock(IKEGAKI_L_TOP);
		registerBlock(IKEGAKI_L_BOT);

		registerBlock(ITABEI);
		registerBlock(ITABEI_spruce);
		registerBlock(ITABEI_birch);
		registerBlock(ITABEI_jungle);
		registerBlock(ITABEI_acacia);
		registerBlock(ITABEI_darkoak);
		registerBlock(ITABEI_sakura);
		registerBlock(ITABEI_kaede);
		registerBlock(ITABEI_ichoh);
		
		registerBlock(CHOUZUBACHI);
		registerBlock(SHISHIODOSHI);
		registerBlock(SHISHIODOSHI2);
		registerBlock(SHISHIODOSHIB);
		registerBlock(SHISHIODOSHIB2);
		registerBlock(SHISHIODOSHI_T);
		registerBlock(SHISHIODOSHI_T2);
		registerBlock(SHISHIODOSHI_TB);
		registerBlock(SHISHIODOSHI_TB2);

		registerBlock(ISHITOUROU);
		registerBlock(LIT_ISHITOUROU);
		registerBlock(LONGTOUROU_TOP);
		registerBlock(LONGTOUROU_BOT);
		registerBlock(LIT_LONGTOUROU_TOP);

		registerBlock(TETSUSAKU_TOP);
		registerBlock(TETSUSAKU_BOT);
		
		registerBlock(SAMON);
		registerBlock(SAMON_B);
		registerBlock(NIWAISHI);
		registerBlock(NIWAISHI_gra);
		registerBlock(NIWAISHI_dio);
		registerBlock(NIWAISHI_and);
		
		registerBlock(NIWAISHI_slab);
		registerBlock(NIWAISHI_slab_gra);
		registerBlock(NIWAISHI_slab_dio);
		registerBlock(NIWAISHI_slab_and);
		registerBlock(MAKIBISHI);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
