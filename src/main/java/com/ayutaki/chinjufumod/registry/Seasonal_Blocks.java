package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.garden.Bonsai;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Sakura;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_Opacity0;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_Opacity1;
import com.ayutaki.chinjufumod.blocks.season.Hinadan;
import com.ayutaki.chinjufumod.blocks.season.Hinakazari;
import com.ayutaki.chinjufumod.blocks.season.Kourihata;
import com.ayutaki.chinjufumod.blocks.season.KusaDummy;
import com.ayutaki.chinjufumod.blocks.season.KusaRoof;
import com.ayutaki.chinjufumod.blocks.season.KusaTaba;
import com.ayutaki.chinjufumod.blocks.season.KusaTaba_Stairs;
import com.ayutaki.chinjufumod.blocks.season.NewYear_Xmas;
import com.ayutaki.chinjufumod.blocks.season.NewYear_Xmas_Top;
import com.ayutaki.chinjufumod.blocks.season.Present;
import com.ayutaki.chinjufumod.blocks.season.Present_B;
import com.ayutaki.chinjufumod.blocks.season.Shimenawa;
import com.ayutaki.chinjufumod.blocks.season.SnowCore;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot1;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot1D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot2;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot2D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot3;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot3D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot4;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot4D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot5;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot5D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top1;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top2;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top3;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top4;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top5;
import com.ayutaki.chinjufumod.blocks.season.Uchiwa;
import com.ayutaki.chinjufumod.blocks.season.Wataame_block;
import com.ayutaki.chinjufumod.blocks.wallpane.BlockPlank_Pillar;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_log;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_plank;
import com.ayutaki.chinjufumod.blocks.wood.Carpet_Leaf;
import com.ayutaki.chinjufumod.blocks.wood.FallLeaf;
import com.ayutaki.chinjufumod.blocks.wood.Fence_CM;
import com.ayutaki.chinjufumod.blocks.wood.KuriIga_Bush;
import com.ayutaki.chinjufumod.blocks.wood.KuriIga_Fall;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Sakuraflower;
import com.ayutaki.chinjufumod.blocks.wood.Log_WoodCM;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Nae_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Sakura;
import com.ayutaki.chinjufumod.blocks.wood.Planks_CM;
import com.ayutaki.chinjufumod.blocks.wood.PressurePlate_CM;
import com.ayutaki.chinjufumod.blocks.wood.Slab_SeasonalPlank;
import com.ayutaki.chinjufumod.blocks.wood.Stairs_SeasonalPlank;
import com.ayutaki.chinjufumod.blocks.wood.Suiden;
import com.ayutaki.chinjufumod.blocks.wood.Take_CM;
import com.ayutaki.chinjufumod.blocks.wood.Takenoko;
import com.ayutaki.chinjufumod.blocks.wood.TrapDoor_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodButton_CM;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Seasonal_Blocks {

	public static Block FALL_LEAF, SUIDEN;

	public static Block SAKURA_flow, KAEDE_leaf, ICHOH_leaf, OAKKARE_leaf;
	public static Block SAKURA_log, KAEDE_log, ICHOH_log, OAKKARE_log;
	public static Block SAKURA_nae, KAEDE_nae, ICHOH_nae, OAKKARE_nae;
	public static Block KURIIGA_FALL, TAKE;
	public static KuriIga_Bush KURIIGA_BUSH; //Gen use this.
	public static Takenoko TAKENOKO; //Gen use this.
	public static Block PLANKS;
	public static Block SAKURA_stairs, KAEDE_stairs, ICHOH_stairs;
	public static Slab_SeasonalPlank SAKURA_slabhalf, KAEDE_slabhalf, ICHOH_slabhalf;
	public static Block PILLAR_saku, PILLAR_kae, PILLAR_ich;
	public static Block PILLARSLAB_saku, PILLARSLAB_kae, PILLARSLAB_ich;
	public static Block SAKURA_FENCE, KAEDE_FENCE, ICHOH_FENCE;

	public static Block SAKURA_TRAPDOOR, KAEDE_TRAPDOOR, ICHOH_TRAPDOOR;
	public static Block SAKURA_PLATE, KAEDE_PLATE, ICHOH_PLATE;
	public static Block SAKURA_BUTTON, KAEDE_BUTTON, ICHOH_BUTTON;

	public static Block SAKURA_CARPET, KAEDE_CARPET, ICHOH_CARPET, OCHIBA_CARPET;

	public static Block WP_LOG_sakura, WP_LOG_kaede, WP_LOG_ichoh;
	public static Block WP_PLANK_sakura, WP_PLANK_kaede, WP_PLANK_ichoh;

	public static Block RANMA_saku, RANMA_kae, RANMA_ich;
	public static Block RANMAB_saku, RANMAB_kae, RANMAB_ich;
	public static Block RANMAC_saku, RANMAC_kae, RANMAC_ich;
	public static Block KANKI_saku, KANKI_kae, KANKI_ich;
	public static Block KOUSHI_saku, KOUSHI_kae, KOUSHI_ich;
	public static Block KOUSHIB_saku, KOUSHIB_kae, KOUSHIB_ich;

	public static Block BONSAI_sakura, BONSAI_kaede, BONSAI_ichoh, BONSAI_kare;

	public static Block DUMMY_KUSA;
	public static Block KUSATABA, KUSATABA_STAIRS, WARATABA;
	public static Block KUSATABA_RF, WARATABA_RF, KAYATABA_RF;
	public static Block WARATABA_STAIRS, KAYATABA, KAYATABA_STAIRS;

	public static Block SHIMENAWA;
	public static Block NEWYEAR_XMAS, NEWYEAR_XMAS_TOP;
	public static Block PRESENT, PRESENT_B;
	public static Block HINAKAZARI, HINADAN;

	public static Block UCHIWA_white, UCHIWA_orange, UCHIWA_magenta, UCHIWA_lightb,
								UCHIWA_yellow, UCHIWA_lime, UCHIWA_pink, UCHIWA_gray,
								UCHIWA_lightg, UCHIWA_cyan, UCHIWA_purple, UCHIWA_blue,
								UCHIWA_brown, UCHIWA_green, UCHIWA_red, UCHIWA_black;

	public static Block WATAGASHI_block, WATAGASHI_pink, WATAGASHI_red, WATAGASHI_yellow, WATAGASHI_green;
	public static Block KAKIGOURI_hata;
	
	public static Block SNOWCORE;
	public static Block SNOWMAN_TOP1, SNOWMAN_TOP2, SNOWMAN_TOP3, SNOWMAN_TOP4, SNOWMAN_TOP5;
	public static Block SNOWMAN_BOT1, SNOWMAN_BOT2, SNOWMAN_BOT3, SNOWMAN_BOT4, SNOWMAN_BOT5;
	public static Block SNOWMAN_BOT1D, SNOWMAN_BOT2D, SNOWMAN_BOT3D, SNOWMAN_BOT4D, SNOWMAN_BOT5D;

	public static void init() {

		FALL_LEAF = new FallLeaf("block_fall_leaf");
		SUIDEN = new Suiden("block_suiden");

		SAKURA_flow = new Leaf_Sakuraflower("block_tree_sakura_flow");
		KAEDE_leaf = new Leaf_Kaede("block_tree_kaede_leaf");
		ICHOH_leaf = new Leaf_Ichoh("block_tree_ichoh_leaf");
		OAKKARE_leaf = new Leaf_OakKare("block_tree_oakkare_leaf");

		SAKURA_log = new Log_WoodCM("block_tree_sakura_log");
		KAEDE_log = new Log_WoodCM("block_tree_kaede_log");
		ICHOH_log = new Log_WoodCM("block_tree_ichoh_log");
		OAKKARE_log = new Log_WoodCM("block_tree_oakkare_log");
		
		SAKURA_nae = new Nae_Sakura("block_tree_sakura_nae");
		KAEDE_nae = new Nae_Kaede("block_tree_kaede_nae");
		ICHOH_nae = new Nae_Ichoh("block_tree_ichoh_nae");
		OAKKARE_nae = new Nae_OakKare("block_tree_oakkare_nae");

		KURIIGA_FALL = new KuriIga_Fall("block_chestnuts");
		KURIIGA_BUSH = new KuriIga_Bush("block_chestnuts_bush");
		TAKE = new Take_CM("block_take");
		TAKENOKO = new Takenoko("block_takenoko");
		
		PLANKS = new Planks_CM("block_planks_c");
		SAKURA_stairs = new Stairs_SeasonalPlank("block_stairs_sakura", PLANKS.getDefaultState());
		KAEDE_stairs = new Stairs_SeasonalPlank("block_stairs_kaede", PLANKS.getDefaultState());
		ICHOH_stairs = new Stairs_SeasonalPlank("block_stairs_ichoh", PLANKS.getDefaultState());
		SAKURA_slabhalf = new Slab_SeasonalPlank("block_slabhalf_sakura");
		KAEDE_slabhalf = new Slab_SeasonalPlank("block_slabhalf_kaede");
		ICHOH_slabhalf = new Slab_SeasonalPlank("block_slabhalf_ichoh");

		PILLAR_saku = new BlockPlank_Pillar("block_pillar_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLAR_kae = new BlockPlank_Pillar("block_pillar_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLAR_ich = new BlockPlank_Pillar("block_pillar_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLARSLAB_saku = new Kamoi_Sakura("block_kamoi_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLARSLAB_kae = new Kamoi_Kaede("block_kamoi_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLARSLAB_ich = new Kamoi_Ichoh("block_kamoi_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);

		SAKURA_FENCE = new Fence_CM("block_fence_sakura");
		KAEDE_FENCE = new Fence_CM("block_fence_kaede");
		ICHOH_FENCE = new Fence_CM("block_fence_ichoh");

		SAKURA_TRAPDOOR = new TrapDoor_CM("block_trapdoor_sakura");
		KAEDE_TRAPDOOR = new TrapDoor_CM("block_trapdoor_kaede");
		ICHOH_TRAPDOOR = new TrapDoor_CM("block_trapdoor_ichoh");
		SAKURA_PLATE = new PressurePlate_CM("block_plate_sakura");
		KAEDE_PLATE = new PressurePlate_CM("block_plate_kaede");
		ICHOH_PLATE = new PressurePlate_CM("block_plate_ichoh");
		SAKURA_BUTTON = new WoodButton_CM("block_button_sakura");
		KAEDE_BUTTON = new WoodButton_CM("block_button_kaede");
		ICHOH_BUTTON = new WoodButton_CM("block_button_ichoh");

		SAKURA_CARPET = new Carpet_Leaf("block_carpet_sakura");
		KAEDE_CARPET = new Carpet_Leaf("block_carpet_kaede");
		ICHOH_CARPET = new Carpet_Leaf("block_carpet_ichoh");
		OCHIBA_CARPET = new Carpet_Leaf("block_carpet_ochiba");

		WP_LOG_sakura = new WP_log("block_wp_log_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_LOG_kaede = new WP_log("block_wp_log_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_LOG_ichoh = new WP_log("block_wp_log_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);

		WP_PLANK_sakura = new WP_plank("block_wp_plank_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_PLANK_kaede = new WP_plank("block_wp_plank_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_PLANK_ichoh = new WP_plank("block_wp_plank_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);

		BONSAI_sakura = new Bonsai("block_bonsai_sakura");
		BONSAI_kaede = new Bonsai("block_bonsai_kaede");
		BONSAI_ichoh = new Bonsai("block_bonsai_ichoh");
		BONSAI_kare = new Bonsai("block_bonsai_oakkare");

		RANMA_saku = new Ranma_Opacity0("block_ranma_saku").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMA_kae = new Ranma_Opacity0("block_ranma_kae").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMA_ich = new Ranma_Opacity0("block_ranma_ich").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMAB_saku = new Ranma_Opacity1("block_ranmab_saku").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMAB_kae = new Ranma_Opacity1("block_ranmab_kae").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMAB_ich = new Ranma_Opacity1("block_ranmab_ich").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMAC_saku = new Ranma_Opacity0("block_ranmac_saku").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMAC_kae = new Ranma_Opacity0("block_ranmac_kae").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RANMAC_ich = new Ranma_Opacity0("block_ranmac_ich").setCreativeTab(ChinjufuModTabs.SEASONAL);

		KANKI_saku = new Ranma_Opacity1("block_kanki_saku").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KANKI_kae = new Ranma_Opacity1("block_kanki_kae").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KANKI_ich = new Ranma_Opacity1("block_kanki_ich").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KOUSHI_saku = new Ranma_Opacity0("block_koushi_saku").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KOUSHI_kae = new Ranma_Opacity0("block_koushi_kae").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KOUSHI_ich = new Ranma_Opacity0("block_koushi_ich").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KOUSHIB_saku = new KoushiB("block_koushib_saku").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KOUSHIB_kae = new KoushiB("block_koushib_kae").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KOUSHIB_ich = new KoushiB("block_koushib_ich").setCreativeTab(ChinjufuModTabs.SEASONAL);

		DUMMY_KUSA = new KusaDummy("block_dummy_kusa");
		KUSATABA = new KusaTaba("block_tabakusa", Material.PLANTS);
		WARATABA = new KusaTaba("block_tabawara", Material.PLANTS);
		KAYATABA = new KusaTaba("block_tabakaya", Material.PLANTS);
		KUSATABA_RF = new KusaRoof("block_tabakusa_roof");
		WARATABA_RF = new KusaRoof("block_tabawara_roof");
		KAYATABA_RF = new KusaRoof("block_tabakaya_roof");
		KUSATABA_STAIRS = new KusaTaba_Stairs("block_tabakusa_stairs", DUMMY_KUSA.getDefaultState());
		WARATABA_STAIRS = new KusaTaba_Stairs("block_tabawara_stairs", DUMMY_KUSA.getDefaultState());
		KAYATABA_STAIRS = new KusaTaba_Stairs("block_tabakaya_stairs", DUMMY_KUSA.getDefaultState());

		SHIMENAWA = new Shimenawa("block_shimenawa");
		NEWYEAR_XMAS = new NewYear_Xmas("block_kadomatsu");
		NEWYEAR_XMAS_TOP = new NewYear_Xmas_Top("block_kadomatsu_top");
		PRESENT = new Present("block_present");
		PRESENT_B = new Present_B("block_present_b");
		HINAKAZARI = new Hinakazari("block_hinakazari");
		HINADAN = new Hinadan("block_hinadan");

		UCHIWA_white = new Uchiwa("block_uchiwa_white");
		UCHIWA_orange = new Uchiwa("block_uchiwa_orange");
		UCHIWA_magenta = new Uchiwa("block_uchiwa_magenta");
		UCHIWA_lightb = new Uchiwa("block_uchiwa_lightb");
		UCHIWA_yellow = new Uchiwa("block_uchiwa_yellow");
		UCHIWA_lime = new Uchiwa("block_uchiwa_lime");
		UCHIWA_pink = new Uchiwa("block_uchiwa_pink");
		UCHIWA_gray = new Uchiwa("block_uchiwa_gray");
		UCHIWA_lightg = new Uchiwa("block_uchiwa_lightg");
		UCHIWA_cyan = new Uchiwa("block_uchiwa_cyan");
		UCHIWA_purple = new Uchiwa("block_uchiwa_purple");
		UCHIWA_blue = new Uchiwa("block_uchiwa_blue");
		UCHIWA_brown = new Uchiwa("block_uchiwa_brown");
		UCHIWA_green = new Uchiwa("block_uchiwa_green");
		UCHIWA_red = new Uchiwa("block_uchiwa_red");
		UCHIWA_black = new Uchiwa("block_uchiwa_black");

		WATAGASHI_block = new Wataame_block("block_watagashi");
		WATAGASHI_pink = new Wataame_block("block_watagashi_pink");
		WATAGASHI_red = new Wataame_block("block_watagashi_red");
		WATAGASHI_yellow = new Wataame_block("block_watagashi_yellow");
		WATAGASHI_green = new Wataame_block("block_watagashi_green");

		KAKIGOURI_hata = new Kourihata("block_kakigouri_hata");

		SNOWCORE = new SnowCore("block_snowcore");
		SNOWMAN_TOP1 = new SnowMan_Top1("block_snowman_top1");
		SNOWMAN_TOP2 = new SnowMan_Top2("block_snowman_top2");
		SNOWMAN_TOP3 = new SnowMan_Top3("block_snowman_top3");
		SNOWMAN_TOP4 = new SnowMan_Top4("block_snowman_top4");
		SNOWMAN_TOP5 = new SnowMan_Top5("block_snowman_top5");
		
		SNOWMAN_BOT1 = new SnowMan_Bot1("block_snowman_bot1");
		SNOWMAN_BOT2 = new SnowMan_Bot2("block_snowman_bot2");
		SNOWMAN_BOT3 = new SnowMan_Bot3("block_snowman_bot3");
		SNOWMAN_BOT4 = new SnowMan_Bot4("block_snowman_bot4");
		SNOWMAN_BOT5 = new SnowMan_Bot5("block_snowman_bot5");

		SNOWMAN_BOT1D = new SnowMan_Bot1D("block_snowman_bot1d");
		SNOWMAN_BOT2D = new SnowMan_Bot2D("block_snowman_bot2d");
		SNOWMAN_BOT3D = new SnowMan_Bot3D("block_snowman_bot3d");
		SNOWMAN_BOT4D = new SnowMan_Bot4D("block_snowman_bot4d");
		SNOWMAN_BOT5D = new SnowMan_Bot5D("block_snowman_bot5d");

	}


	public static void register() {

		registerBlock(FALL_LEAF);
		registerBlock(SUIDEN);

		registerBlock(SAKURA_log);
		registerBlock(KAEDE_log);
		registerBlock(ICHOH_log);
		registerBlock(OAKKARE_log);
		
		registerBlock(SAKURA_flow);
		registerBlock(KAEDE_leaf);
		registerBlock(ICHOH_leaf);
		registerBlock(OAKKARE_leaf);

		registerBlock(SAKURA_nae);
		registerBlock(KAEDE_nae);
		registerBlock(ICHOH_nae);
		registerBlock(OAKKARE_nae);
		registerBlock(KURIIGA_FALL);
		registerBlock(KURIIGA_BUSH);
		registerBlock(TAKE);
		registerBlock(TAKENOKO);
		
		registerBlock(PLANKS);
		registerBlock(SAKURA_stairs);
		registerBlock(KAEDE_stairs);
		registerBlock(ICHOH_stairs);
		registerBlock(SAKURA_slabhalf);
		registerBlock(KAEDE_slabhalf);
		registerBlock(ICHOH_slabhalf);

		registerBlock(PILLAR_saku);
		registerBlock(PILLAR_kae);
		registerBlock(PILLAR_ich);
		registerBlock(PILLARSLAB_saku);
		registerBlock(PILLARSLAB_kae);
		registerBlock(PILLARSLAB_ich);

		registerBlock(SAKURA_FENCE);
		registerBlock(KAEDE_FENCE);
		registerBlock(ICHOH_FENCE);

		registerBlock(SAKURA_TRAPDOOR);
		registerBlock(KAEDE_TRAPDOOR);
		registerBlock(ICHOH_TRAPDOOR);
		registerBlock(SAKURA_PLATE);
		registerBlock(KAEDE_PLATE);
		registerBlock(ICHOH_PLATE);
		registerBlock(SAKURA_BUTTON);
		registerBlock(KAEDE_BUTTON);
		registerBlock(ICHOH_BUTTON);

		registerBlock(SAKURA_CARPET);
		registerBlock(KAEDE_CARPET);
		registerBlock(ICHOH_CARPET);
		registerBlock(OCHIBA_CARPET);

		registerBlock(WP_LOG_sakura);
		registerBlock(WP_LOG_kaede);
		registerBlock(WP_LOG_ichoh);

		registerBlock(WP_PLANK_sakura);
		registerBlock(WP_PLANK_kaede);
		registerBlock(WP_PLANK_ichoh);

		registerBlock(RANMA_saku);
		registerBlock(RANMA_kae);
		registerBlock(RANMA_ich);
		registerBlock(RANMAB_saku);
		registerBlock(RANMAB_kae);
		registerBlock(RANMAB_ich);
		registerBlock(RANMAC_saku);
		registerBlock(RANMAC_kae);
		registerBlock(RANMAC_ich);

		registerBlock(KANKI_saku);
		registerBlock(KANKI_kae);
		registerBlock(KANKI_ich);

		registerBlock(KOUSHI_saku);
		registerBlock(KOUSHI_kae);
		registerBlock(KOUSHI_ich);
		registerBlock(KOUSHIB_saku);
		registerBlock(KOUSHIB_kae);
		registerBlock(KOUSHIB_ich);

		registerBlock(BONSAI_sakura);
		registerBlock(BONSAI_kaede);
		registerBlock(BONSAI_ichoh);
		registerBlock(BONSAI_kare);

		registerBlock(DUMMY_KUSA);
		registerBlock(KUSATABA);
		registerBlock(WARATABA);
		registerBlock(KAYATABA);
		registerBlock(KUSATABA_RF);
		registerBlock(WARATABA_RF);
		registerBlock(KAYATABA_RF);
		registerBlock(KUSATABA_STAIRS);
		registerBlock(WARATABA_STAIRS);
		registerBlock(KAYATABA_STAIRS);

		registerBlock(SHIMENAWA);
		registerBlock(NEWYEAR_XMAS);
		registerBlock(NEWYEAR_XMAS_TOP);
		registerBlock(PRESENT);
		registerBlock(PRESENT_B);
		registerBlock(HINAKAZARI);
		registerBlock(HINADAN);

		registerBlock(UCHIWA_white);
		registerBlock(UCHIWA_orange);
		registerBlock(UCHIWA_magenta);
		registerBlock(UCHIWA_lightb);
		registerBlock(UCHIWA_yellow);
		registerBlock(UCHIWA_lime);
		registerBlock(UCHIWA_pink);
		registerBlock(UCHIWA_gray);
		registerBlock(UCHIWA_lightg);
		registerBlock(UCHIWA_cyan);
		registerBlock(UCHIWA_purple);
		registerBlock(UCHIWA_blue);
		registerBlock(UCHIWA_brown);
		registerBlock(UCHIWA_green);
		registerBlock(UCHIWA_red);
		registerBlock(UCHIWA_black);

		registerBlock(WATAGASHI_block);
		registerBlock(WATAGASHI_pink);
		registerBlock(WATAGASHI_red);
		registerBlock(WATAGASHI_yellow);
		registerBlock(WATAGASHI_green);

		registerBlock(KAKIGOURI_hata);
		
		registerBlock(SNOWCORE);
		registerBlock(SNOWMAN_TOP1);
		registerBlock(SNOWMAN_TOP2);
		registerBlock(SNOWMAN_TOP3);
		registerBlock(SNOWMAN_TOP4);
		registerBlock(SNOWMAN_TOP5);
		
		registerBlock(SNOWMAN_BOT1);
		registerBlock(SNOWMAN_BOT2);
		registerBlock(SNOWMAN_BOT3);
		registerBlock(SNOWMAN_BOT4);
		registerBlock(SNOWMAN_BOT5);

		registerBlock(SNOWMAN_BOT1D);
		registerBlock(SNOWMAN_BOT2D);
		registerBlock(SNOWMAN_BOT3D);
		registerBlock(SNOWMAN_BOT4D);
		registerBlock(SNOWMAN_BOT5D);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
