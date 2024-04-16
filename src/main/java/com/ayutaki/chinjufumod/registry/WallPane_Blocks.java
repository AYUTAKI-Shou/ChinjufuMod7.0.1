package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_brick;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_clay_color;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_endtone;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_endtone_b;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_glass_stained;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_log;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_netherb;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_netherrack;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_obsidian;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_plank;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_prisma;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_purpur;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_purpur_pil;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_quartz;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_quartz_pil;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_redsand_stone;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_sand_stone;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_stone_C;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_stone_brick;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_stone_maru;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_stone_pillar;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_yakiishi;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WallPane_Blocks {

	public static Block WP_LOG_oak, WP_LOG_spru, WP_LOG_bir, WP_LOG_jun, WP_LOG_aca, WP_LOG_doak;
	public static Block WP_PLANK_oak, WP_PLANK_spru, WP_PLANK_bir, WP_PLANK_jun, WP_PLANK_aca, WP_PLANK_doak;
	public static Block WP_STONE, WP_STONE_M;

	public static Block WP_STONE_gra,WP_STONE_dio, WP_STONE_and;

	public static Block WP_STONE_B, WP_STONE_graB, WP_STONE_dioB, WP_STONE_andB;

	public static Block WP_STONE_P, WP_STONE_graP, WP_STONE_dioP, WP_STONE_andP;

	public static Block WP_BRICK;

	public static Block WP_SANDSTONE;
	public static Block WP_REDSANDSTONE;

	public static Block WP_PRISMA;
	public static Block WP_OBSIDIAN;

	public static Block WP_CLAY, WP_CLAY_white, WP_CLAY_orange, WP_CLAY_magenta, WP_CLAY_lightb,
								WP_CLAY_yellow, WP_CLAY_lime, WP_CLAY_pink, WP_CLAY_gray,
								WP_CLAY_lightg, WP_CLAY_cyan, WP_CLAY_purple, WP_CLAY_blue,
								WP_CLAY_brown, WP_CLAY_green, WP_CLAY_red, WP_CLAY_black;

	public static Block WP_GLASS, WP_GLASS_white, WP_GLASS_orange, WP_GLASS_magenta, WP_GLASS_lightb,
								WP_GLASS_yellow, WP_GLASS_lime, WP_GLASS_pink, WP_GLASS_gray,
								WP_GLASS_lightg, WP_GLASS_cyan, WP_GLASS_purple, WP_GLASS_blue,
								WP_GLASS_brown, WP_GLASS_green, WP_GLASS_red, WP_GLASS_black;

	public static Block WP_NETHE_rack;
	public static Block WP_NETHE_b;
	public static Block WP_QUARTZ;
	public static Block WP_QUARTZ_PIL;

	public static Block WP_ENDSTONE;
	public static Block WP_ENDBRICKS;

	public static Block WP_PURPUR;
	public static Block WP_PURPUR_PIL;

	public static void init() {

		WP_LOG_oak = new WP_log("block_wp_log_oak").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_LOG_spru = new WP_log("block_wp_log_spru").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_LOG_bir = new WP_log("block_wp_log_bir").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_LOG_jun = new WP_log("block_wp_log_jun").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_LOG_aca = new WP_log("block_wp_log_aca").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_LOG_doak = new WP_log("block_wp_log_doak").setCreativeTab(ChinjufuModTabs.WALLPANEL);

		WP_PLANK_oak = new WP_plank("block_wp_plank_oak").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_PLANK_spru = new WP_plank("block_wp_plank_spru").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_PLANK_bir = new WP_plank("block_wp_plank_bir").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_PLANK_jun = new WP_plank("block_wp_plank_jun").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_PLANK_aca = new WP_plank("block_wp_plank_aca").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		WP_PLANK_doak = new WP_plank("block_wp_plank_doak").setCreativeTab(ChinjufuModTabs.WALLPANEL);

		WP_STONE = new WP_yakiishi("block_wp_stone");
		WP_STONE_M = new WP_stone_maru("block_wp_stone_m");

		WP_STONE_gra = new WP_stone_C("block_wp_stone_gra");
		WP_STONE_dio = new WP_stone_C("block_wp_stone_dio");
		WP_STONE_and = new WP_stone_C("block_wp_stone_and");

		WP_STONE_B = new WP_stone_brick("block_wp_stone_b");
		WP_STONE_graB = new WP_stone_brick("block_wp_stone_grab");
		WP_STONE_dioB = new WP_stone_brick("block_wp_stone_diob");
		WP_STONE_andB = new WP_stone_brick("block_wp_stone_andb");

		WP_STONE_P = new WP_stone_pillar("block_wp_stone_p");
		WP_STONE_graP = new WP_stone_pillar("block_wp_stone_grap");
		WP_STONE_dioP = new WP_stone_pillar("block_wp_stone_diop");
		WP_STONE_andP = new WP_stone_pillar("block_wp_stone_andp");

		WP_BRICK = new WP_brick("block_wp_brick");

		WP_SANDSTONE = new WP_sand_stone("block_wp_sand_stone");
		WP_REDSANDSTONE = new WP_redsand_stone("block_wp_redsand_stone");

		WP_PRISMA = new WP_prisma("block_wp_prisma");
		WP_OBSIDIAN = new WP_obsidian("block_wp_obsidian");

		WP_CLAY = new WP_clay("block_wp_clay");
		WP_CLAY_white = new WP_clay_color("block_wp_clay_white");
		WP_CLAY_orange = new WP_clay_color("block_wp_clay_orange");
		WP_CLAY_magenta = new WP_clay_color("block_wp_clay_magenta");
		WP_CLAY_lightb = new WP_clay_color("block_wp_clay_lightb");
		WP_CLAY_yellow = new WP_clay_color("block_wp_clay_yellow");
		WP_CLAY_lime = new WP_clay_color("block_wp_clay_lime");
		WP_CLAY_pink = new WP_clay_color("block_wp_clay_pink");
		WP_CLAY_gray = new WP_clay_color("block_wp_clay_gray");
		WP_CLAY_lightg = new WP_clay_color("block_wp_clay_lightg");
		WP_CLAY_cyan = new WP_clay_color("block_wp_clay_cyan");
		WP_CLAY_purple = new WP_clay_color("block_wp_clay_purple");
		WP_CLAY_blue = new WP_clay_color("block_wp_clay_blue");
		WP_CLAY_brown = new WP_clay_color("block_wp_clay_brown");
		WP_CLAY_green = new WP_clay_color("block_wp_clay_green");
		WP_CLAY_red = new WP_clay_color("block_wp_clay_red");
		WP_CLAY_black = new WP_clay_color("block_wp_clay_black");

		WP_GLASS = new WP_glass("block_wp_glass");
		WP_GLASS_white = new WP_glass_stained("block_wp_glass_white");
		WP_GLASS_orange = new WP_glass_stained("block_wp_glass_orange");
		WP_GLASS_magenta = new WP_glass_stained("block_wp_glass_magenta");
		WP_GLASS_lightb = new WP_glass_stained("block_wp_glass_lightb");
		WP_GLASS_yellow = new WP_glass_stained("block_wp_glass_yellow");
		WP_GLASS_lime = new WP_glass_stained("block_wp_glass_lime");
		WP_GLASS_pink = new WP_glass_stained("block_wp_glass_pink");
		WP_GLASS_gray = new WP_glass_stained("block_wp_glass_gray");
		WP_GLASS_lightg = new WP_glass_stained("block_wp_glass_lightg");
		WP_GLASS_cyan = new WP_glass_stained("block_wp_glass_cyan");
		WP_GLASS_purple = new WP_glass_stained("block_wp_glass_purple");
		WP_GLASS_blue = new WP_glass_stained("block_wp_glass_blue");
		WP_GLASS_brown = new WP_glass_stained("block_wp_glass_brown");
		WP_GLASS_green = new WP_glass_stained("block_wp_glass_green");
		WP_GLASS_red = new WP_glass_stained("block_wp_glass_red");
		WP_GLASS_black = new WP_glass_stained("block_wp_glass_black");

		WP_NETHE_rack = new WP_netherrack("block_wp_netherrack");
		WP_NETHE_b = new WP_netherb("block_wp_netherb");
		WP_QUARTZ = new WP_quartz("block_wp_quartz");
		WP_QUARTZ_PIL = new WP_quartz_pil("block_wp_quartz_pil");

		WP_ENDSTONE = new WP_endtone("block_wp_endstone");
		WP_ENDBRICKS = new WP_endtone_b("block_wp_endstone_b");

		WP_PURPUR = new WP_purpur("block_wp_purpur");
		WP_PURPUR_PIL = new WP_purpur_pil("block_wp_purpur_pil");
	}


	public static void register() {

		registerBlock(WP_LOG_oak);
		registerBlock(WP_LOG_spru);
		registerBlock(WP_LOG_bir);
		registerBlock(WP_LOG_jun);
		registerBlock(WP_LOG_aca);
		registerBlock(WP_LOG_doak);

		registerBlock(WP_PLANK_oak);
		registerBlock(WP_PLANK_spru);
		registerBlock(WP_PLANK_bir);
		registerBlock(WP_PLANK_jun);
		registerBlock(WP_PLANK_aca);
		registerBlock(WP_PLANK_doak);

		registerBlock(WP_STONE);
		registerBlock(WP_STONE_M);
		registerBlock(WP_STONE_gra);
		registerBlock(WP_STONE_dio);
		registerBlock(WP_STONE_and);


		registerBlock(WP_STONE_B);
		registerBlock(WP_STONE_graB);
		registerBlock(WP_STONE_dioB);
		registerBlock(WP_STONE_andB);

		registerBlock(WP_STONE_P);
		registerBlock(WP_STONE_graP);
		registerBlock(WP_STONE_dioP);
		registerBlock(WP_STONE_andP);

		registerBlock(WP_BRICK);

		registerBlock(WP_SANDSTONE);
		registerBlock(WP_REDSANDSTONE);
		registerBlock(WP_PRISMA);
		registerBlock(WP_OBSIDIAN);

		registerBlock(WP_CLAY);
		registerBlock(WP_CLAY_white);
		registerBlock(WP_CLAY_orange);
		registerBlock(WP_CLAY_magenta);
		registerBlock(WP_CLAY_lightb);
		registerBlock(WP_CLAY_yellow);
		registerBlock(WP_CLAY_lime);
		registerBlock(WP_CLAY_pink);
		registerBlock(WP_CLAY_gray);
		registerBlock(WP_CLAY_lightg);
		registerBlock(WP_CLAY_cyan);
		registerBlock(WP_CLAY_purple);
		registerBlock(WP_CLAY_blue);
		registerBlock(WP_CLAY_brown);
		registerBlock(WP_CLAY_green);
		registerBlock(WP_CLAY_red);
		registerBlock(WP_CLAY_black);

		registerBlock(WP_GLASS);
		registerBlock(WP_GLASS_white);
		registerBlock(WP_GLASS_orange);
		registerBlock(WP_GLASS_magenta);
		registerBlock(WP_GLASS_lightb);
		registerBlock(WP_GLASS_yellow);
		registerBlock(WP_GLASS_lime);
		registerBlock(WP_GLASS_pink);
		registerBlock(WP_GLASS_gray);
		registerBlock(WP_GLASS_lightg);
		registerBlock(WP_GLASS_cyan);
		registerBlock(WP_GLASS_purple);
		registerBlock(WP_GLASS_blue);
		registerBlock(WP_GLASS_brown);
		registerBlock(WP_GLASS_green);
		registerBlock(WP_GLASS_red);
		registerBlock(WP_GLASS_black);

		registerBlock(WP_NETHE_rack);
		registerBlock(WP_NETHE_b);
		registerBlock(WP_QUARTZ);
		registerBlock(WP_QUARTZ_PIL);

		registerBlock(WP_ENDSTONE);
		registerBlock(WP_ENDBRICKS);

		registerBlock(WP_PURPUR);
		registerBlock(WP_PURPUR_PIL);
	}

	public static void registerBlock(Block block) {
		registerBlock(block, new ItemBlock(block));
	}

	public static void registerBlock(Block block, ItemBlock item) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
		item.setRegistryName(block.getRegistryName());
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(WP_LOG_oak);
		registerRender(WP_LOG_spru);
		registerRender(WP_LOG_bir);
		registerRender(WP_LOG_jun);
		registerRender(WP_LOG_aca);
		registerRender(WP_LOG_doak);

		registerRender(WP_PLANK_oak);
		registerRender(WP_PLANK_spru);
		registerRender(WP_PLANK_bir);
		registerRender(WP_PLANK_jun);
		registerRender(WP_PLANK_aca);
		registerRender(WP_PLANK_doak);

		registerRender(WP_STONE);
		registerRender(WP_STONE_M);
		registerRender(WP_STONE_gra);
		registerRender(WP_STONE_dio);
		registerRender(WP_STONE_and);

		registerRender(WP_STONE_B);
		registerRender(WP_STONE_graB);
		registerRender(WP_STONE_dioB);
		registerRender(WP_STONE_andB);

		registerRender(WP_STONE_P);
		registerRender(WP_STONE_graP);
		registerRender(WP_STONE_dioP);
		registerRender(WP_STONE_andP);

		registerRender(WP_BRICK);

		registerRender(WP_SANDSTONE);
		registerRender(WP_REDSANDSTONE);
		registerRender(WP_PRISMA);
		registerRender(WP_OBSIDIAN);

		registerRender(WP_CLAY);
		registerRender(WP_CLAY_white);
		registerRender(WP_CLAY_orange);
		registerRender(WP_CLAY_magenta);
		registerRender(WP_CLAY_lightb);
		registerRender(WP_CLAY_yellow);
		registerRender(WP_CLAY_lime);
		registerRender(WP_CLAY_pink);
		registerRender(WP_CLAY_gray);
		registerRender(WP_CLAY_lightg);
		registerRender(WP_CLAY_cyan);
		registerRender(WP_CLAY_purple);
		registerRender(WP_CLAY_blue);
		registerRender(WP_CLAY_brown);
		registerRender(WP_CLAY_green);
		registerRender(WP_CLAY_red);
		registerRender(WP_CLAY_black);

		registerRender(WP_GLASS);
		registerRender(WP_GLASS_white);
		registerRender(WP_GLASS_orange);
		registerRender(WP_GLASS_magenta);
		registerRender(WP_GLASS_lightb);
		registerRender(WP_GLASS_yellow);
		registerRender(WP_GLASS_lime);
		registerRender(WP_GLASS_pink);
		registerRender(WP_GLASS_gray);
		registerRender(WP_GLASS_lightg);
		registerRender(WP_GLASS_cyan);
		registerRender(WP_GLASS_purple);
		registerRender(WP_GLASS_blue);
		registerRender(WP_GLASS_brown);
		registerRender(WP_GLASS_green);
		registerRender(WP_GLASS_red);
		registerRender(WP_GLASS_black);

		registerRender(WP_NETHE_rack);
		registerRender(WP_NETHE_b);
		registerRender(WP_QUARTZ);
		registerRender(WP_QUARTZ_PIL);

		registerRender(WP_ENDSTONE);
		registerRender(WP_ENDBRICKS);

		registerRender(WP_PURPUR);
		registerRender(WP_PURPUR_PIL);

	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}
}
