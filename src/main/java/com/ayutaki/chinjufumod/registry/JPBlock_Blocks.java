package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.cmblock.Dummy;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_DirtWall;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoBCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_PlasterCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Sama;

import net.minecraft.block.Block;

public class JPBlock_Blocks {

	public static Block DUMMY;

	public static Block KAWARA, KAWARA_CR;
	public static Kawara_Slab KAWARA_SH_white, KAWARA_SH_orange, KAWARA_SH_magenta, KAWARA_SH_lightb,
								KAWARA_SH_yellow, KAWARA_SH_lime, KAWARA_SH_pink, KAWARA_SH_gray,
								KAWARA_SH_lightg, KAWARA_SH_cyan, KAWARA_SH_purple, KAWARA_SH_blue,
								KAWARA_SH_brown, KAWARA_SH_green, KAWARA_SH_red, KAWARA_SH_black;

	public static Block KAWARA_ST_white, KAWARA_ST_orange, KAWARA_ST_magenta, KAWARA_ST_lightb,
								KAWARA_ST_yellow, KAWARA_ST_lime, KAWARA_ST_pink, KAWARA_ST_gray,
								KAWARA_ST_lightg, KAWARA_ST_cyan, KAWARA_ST_purple, KAWARA_ST_blue,
								KAWARA_ST_brown, KAWARA_ST_green, KAWARA_ST_red, KAWARA_ST_black;

	public static Plaster_Slab DIRTWALL_SH;
	public static Block DIRTWALL_ST;

	public static Block SHIKKUI, SHIKKUI_CR;
	public static Plaster_Slab SHIKKUI_SH_white, SHIKKUI_SH_orange, SHIKKUI_SH_magenta, SHIKKUI_SH_lightb,
								SHIKKUI_SH_yellow, SHIKKUI_SH_lime, SHIKKUI_SH_pink, SHIKKUI_SH_gray,
								SHIKKUI_SH_lightg, SHIKKUI_SH_cyan, SHIKKUI_SH_purple, SHIKKUI_SH_blue,
								SHIKKUI_SH_brown, SHIKKUI_SH_green, SHIKKUI_SH_red, SHIKKUI_SH_black;

	public static Block SHIKKUI_ST_white, SHIKKUI_ST_orange, SHIKKUI_ST_magenta, SHIKKUI_ST_lightb,
								SHIKKUI_ST_yellow, SHIKKUI_ST_lime, SHIKKUI_ST_pink, SHIKKUI_ST_gray,
								SHIKKUI_ST_lightg, SHIKKUI_ST_cyan, SHIKKUI_ST_purple, SHIKKUI_ST_blue,
								SHIKKUI_ST_brown, SHIKKUI_ST_green, SHIKKUI_ST_red, SHIKKUI_ST_black;

	public static Block NAMAKO, NAMAKO_CR;
	public static Namako_Slab NAMAKO_SH_white, NAMAKO_SH_orange, NAMAKO_SH_magenta, NAMAKO_SH_lightb,
								NAMAKO_SH_yellow, NAMAKO_SH_lime, NAMAKO_SH_pink, NAMAKO_SH_gray,
								NAMAKO_SH_lightg, NAMAKO_SH_cyan, NAMAKO_SH_purple, NAMAKO_SH_blue,
								NAMAKO_SH_brown, NAMAKO_SH_green, NAMAKO_SH_red, NAMAKO_SH_black;

	public static Block NAMAKO_ST_white, NAMAKO_ST_orange, NAMAKO_ST_magenta, NAMAKO_ST_lightb,
								NAMAKO_ST_yellow, NAMAKO_ST_lime, NAMAKO_ST_pink, NAMAKO_ST_gray,
								NAMAKO_ST_lightg, NAMAKO_ST_cyan, NAMAKO_ST_purple, NAMAKO_ST_blue,
								NAMAKO_ST_brown, NAMAKO_ST_green, NAMAKO_ST_red, NAMAKO_ST_black;

	public static Block NAMAKOB, NAMAKOB_CR;
	public static NamakoB_Slab NAMAKOB_SH_white, NAMAKOB_SH_orange, NAMAKOB_SH_magenta, NAMAKOB_SH_lightb,
								NAMAKOB_SH_yellow, NAMAKOB_SH_lime, NAMAKOB_SH_pink, NAMAKOB_SH_gray,
								NAMAKOB_SH_lightg, NAMAKOB_SH_cyan, NAMAKOB_SH_purple, NAMAKOB_SH_blue,
								NAMAKOB_SH_brown, NAMAKOB_SH_green, NAMAKOB_SH_red, NAMAKOB_SH_black;

	public static Block NAMAKOB_ST_white, NAMAKOB_ST_orange, NAMAKOB_ST_magenta, NAMAKOB_ST_lightb,
								NAMAKOB_ST_yellow, NAMAKOB_ST_lime, NAMAKOB_ST_pink, NAMAKOB_ST_gray,
								NAMAKOB_ST_lightg, NAMAKOB_ST_cyan, NAMAKOB_ST_purple, NAMAKOB_ST_blue,
								NAMAKOB_ST_brown, NAMAKOB_ST_green, NAMAKOB_ST_red, NAMAKOB_ST_black;

	public static Block DIRTWALL_WALL, SHIKKUI_WALL, SHIKKUI_WALL_CR;
	public static Block NAMAKO_WALL, NAMAKO_WALL_CR;
	public static Block NAMAKOB_WALL, NAMAKOB_WALL_CR;
	public static Block DIRTWALL_SAMA, SHIKKUI_SAMA_white, SHIKKUI_SAMA_orange, SHIKKUI_SAMA_magenta, SHIKKUI_SAMA_lightb,
								SHIKKUI_SAMA_yellow, SHIKKUI_SAMA_lime, SHIKKUI_SAMA_pink, SHIKKUI_SAMA_gray,
								SHIKKUI_SAMA_lightg, SHIKKUI_SAMA_cyan, SHIKKUI_SAMA_purple, SHIKKUI_SAMA_blue,
								SHIKKUI_SAMA_brown, SHIKKUI_SAMA_green, SHIKKUI_SAMA_red, SHIKKUI_SAMA_black;
	public static Block KAWARA_WALL;
	
	
	public static void init() {

		DUMMY = new Dummy("block_dummy_jp");

		KAWARA = new Kawara("block_kawara");
		KAWARA_CR = new Kawara_Crash("block_kawara_crash");
		KAWARA_SH_white = new Kawara_Slab("block_ksh_white");
		KAWARA_SH_orange = new Kawara_Slab("block_ksh_orange");
		KAWARA_SH_magenta = new Kawara_Slab("block_ksh_magenta");
		KAWARA_SH_lightb = new Kawara_Slab("block_ksh_lightb");
		KAWARA_SH_yellow = new Kawara_Slab("block_ksh_yellow");
		KAWARA_SH_lime = new Kawara_Slab("block_ksh_lime");
		KAWARA_SH_pink = new Kawara_Slab("block_ksh_pink");
		KAWARA_SH_gray = new Kawara_Slab("block_ksh_gray");
		KAWARA_SH_lightg = new Kawara_Slab("block_ksh_lightg");
		KAWARA_SH_cyan = new Kawara_Slab("block_ksh_cyan");
		KAWARA_SH_purple = new Kawara_Slab("block_ksh_purple");
		KAWARA_SH_blue = new Kawara_Slab("block_ksh_blue");
		KAWARA_SH_brown = new Kawara_Slab("block_ksh_brown");
		KAWARA_SH_green = new Kawara_Slab("block_ksh_green");
		KAWARA_SH_red = new Kawara_Slab("block_ksh_red");
		KAWARA_SH_black = new Kawara_Slab("block_ksh_black");

		KAWARA_ST_white = new Kawara_Stairs("block_kst_white", DUMMY.getDefaultState());
		KAWARA_ST_orange = new Kawara_Stairs("block_kst_orange", DUMMY.getDefaultState());
		KAWARA_ST_magenta = new Kawara_Stairs("block_kst_magenta", DUMMY.getDefaultState());
		KAWARA_ST_lightb = new Kawara_Stairs("block_kst_lightb", DUMMY.getDefaultState());
		KAWARA_ST_yellow = new Kawara_Stairs("block_kst_yellow", DUMMY.getDefaultState());
		KAWARA_ST_lime = new Kawara_Stairs("block_kst_lime", DUMMY.getDefaultState());
		KAWARA_ST_pink = new Kawara_Stairs("block_kst_pink", DUMMY.getDefaultState());
		KAWARA_ST_gray = new Kawara_Stairs("block_kst_gray", DUMMY.getDefaultState());
		KAWARA_ST_lightg = new Kawara_Stairs("block_kst_lightg", DUMMY.getDefaultState());
		KAWARA_ST_cyan = new Kawara_Stairs("block_kst_cyan", DUMMY.getDefaultState());
		KAWARA_ST_purple = new Kawara_Stairs("block_kst_purple", DUMMY.getDefaultState());
		KAWARA_ST_blue = new Kawara_Stairs("block_kst_blue", DUMMY.getDefaultState());
		KAWARA_ST_brown = new Kawara_Stairs("block_kst_brown", DUMMY.getDefaultState());
		KAWARA_ST_green = new Kawara_Stairs("block_kst_green", DUMMY.getDefaultState());
		KAWARA_ST_red = new Kawara_Stairs("block_kst_red", DUMMY.getDefaultState());
		KAWARA_ST_black = new Kawara_Stairs("block_kst_black", DUMMY.getDefaultState());

		DIRTWALL_SH = new Plaster_Slab("block_dirtwall_sh");
		DIRTWALL_ST = new Plaster_Stairs("block_dirtwall_st", DUMMY.getDefaultState());

		SHIKKUI = new Plaster("block_plaster");
		SHIKKUI_CR = new Plaster_Crash("block_plaster_crash");
		SHIKKUI_SH_white = new Plaster_Slab("block_psh_white");
		SHIKKUI_SH_orange = new Plaster_Slab("block_psh_orange");
		SHIKKUI_SH_magenta = new Plaster_Slab("block_psh_magenta");
		SHIKKUI_SH_lightb = new Plaster_Slab("block_psh_lightb");
		SHIKKUI_SH_yellow = new Plaster_Slab("block_psh_yellow");
		SHIKKUI_SH_lime = new Plaster_Slab("block_psh_lime");
		SHIKKUI_SH_pink = new Plaster_Slab("block_psh_pink");
		SHIKKUI_SH_gray = new Plaster_Slab("block_psh_gray");
		SHIKKUI_SH_lightg = new Plaster_Slab("block_psh_lightg");
		SHIKKUI_SH_cyan = new Plaster_Slab("block_psh_cyan");
		SHIKKUI_SH_purple = new Plaster_Slab("block_psh_purple");
		SHIKKUI_SH_blue = new Plaster_Slab("block_psh_blue");
		SHIKKUI_SH_brown = new Plaster_Slab("block_psh_brown");
		SHIKKUI_SH_green = new Plaster_Slab("block_psh_green");
		SHIKKUI_SH_red = new Plaster_Slab("block_psh_red");
		SHIKKUI_SH_black = new Plaster_Slab("block_psh_black");

		SHIKKUI_ST_white = new Plaster_Stairs("block_pst_white", DUMMY.getDefaultState());
		SHIKKUI_ST_orange = new Plaster_Stairs("block_pst_orange", DUMMY.getDefaultState());
		SHIKKUI_ST_magenta = new Plaster_Stairs("block_pst_magenta", DUMMY.getDefaultState());
		SHIKKUI_ST_lightb = new Plaster_Stairs("block_pst_lightb", DUMMY.getDefaultState());
		SHIKKUI_ST_yellow = new Plaster_Stairs("block_pst_yellow", DUMMY.getDefaultState());
		SHIKKUI_ST_lime = new Plaster_Stairs("block_pst_lime", DUMMY.getDefaultState());
		SHIKKUI_ST_pink = new Plaster_Stairs("block_pst_pink", DUMMY.getDefaultState());
		SHIKKUI_ST_gray = new Plaster_Stairs("block_pst_gray", DUMMY.getDefaultState());
		SHIKKUI_ST_lightg = new Plaster_Stairs("block_pst_lightg", DUMMY.getDefaultState());
		SHIKKUI_ST_cyan = new Plaster_Stairs("block_pst_cyan", DUMMY.getDefaultState());
		SHIKKUI_ST_purple = new Plaster_Stairs("block_pst_purple", DUMMY.getDefaultState());
		SHIKKUI_ST_blue = new Plaster_Stairs("block_pst_blue", DUMMY.getDefaultState());
		SHIKKUI_ST_brown = new Plaster_Stairs("block_pst_brown", DUMMY.getDefaultState());
		SHIKKUI_ST_green = new Plaster_Stairs("block_pst_green", DUMMY.getDefaultState());
		SHIKKUI_ST_red = new Plaster_Stairs("block_pst_red", DUMMY.getDefaultState());
		SHIKKUI_ST_black = new Plaster_Stairs("block_pst_black", DUMMY.getDefaultState());

		NAMAKO = new Namako("block_namako");
		NAMAKO_CR = new Namako_Crash("block_namako_crash");
		NAMAKO_SH_white = new Namako_Slab("block_nsh_white");
		NAMAKO_SH_orange = new Namako_Slab("block_nsh_orange");
		NAMAKO_SH_magenta = new Namako_Slab("block_nsh_magenta");
		NAMAKO_SH_lightb = new Namako_Slab("block_nsh_lightb");
		NAMAKO_SH_yellow = new Namako_Slab("block_nsh_yellow");
		NAMAKO_SH_lime = new Namako_Slab("block_nsh_lime");
		NAMAKO_SH_pink = new Namako_Slab("block_nsh_pink");
		NAMAKO_SH_gray = new Namako_Slab("block_nsh_gray");
		NAMAKO_SH_lightg = new Namako_Slab("block_nsh_lightg");
		NAMAKO_SH_cyan = new Namako_Slab("block_nsh_cyan");
		NAMAKO_SH_purple = new Namako_Slab("block_nsh_purple");
		NAMAKO_SH_blue = new Namako_Slab("block_nsh_blue");
		NAMAKO_SH_brown = new Namako_Slab("block_nsh_brown");
		NAMAKO_SH_green = new Namako_Slab("block_nsh_green");
		NAMAKO_SH_red = new Namako_Slab("block_nsh_red");
		NAMAKO_SH_black = new Namako_Slab("block_nsh_black");

		NAMAKO_ST_white = new Namako_Stairs("block_nst_white", DUMMY.getDefaultState());
		NAMAKO_ST_orange = new Namako_Stairs("block_nst_orange", DUMMY.getDefaultState());
		NAMAKO_ST_magenta = new Namako_Stairs("block_nst_magenta", DUMMY.getDefaultState());
		NAMAKO_ST_lightb = new Namako_Stairs("block_nst_lightb", DUMMY.getDefaultState());
		NAMAKO_ST_yellow = new Namako_Stairs("block_nst_yellow", DUMMY.getDefaultState());
		NAMAKO_ST_lime = new Namako_Stairs("block_nst_lime", DUMMY.getDefaultState());
		NAMAKO_ST_pink = new Namako_Stairs("block_nst_pink", DUMMY.getDefaultState());
		NAMAKO_ST_gray = new Namako_Stairs("block_nst_gray", DUMMY.getDefaultState());
		NAMAKO_ST_lightg = new Namako_Stairs("block_nst_lightg", DUMMY.getDefaultState());
		NAMAKO_ST_cyan = new Namako_Stairs("block_nst_cyan", DUMMY.getDefaultState());
		NAMAKO_ST_purple = new Namako_Stairs("block_nst_purple", DUMMY.getDefaultState());
		NAMAKO_ST_blue = new Namako_Stairs("block_nst_blue", DUMMY.getDefaultState());
		NAMAKO_ST_brown = new Namako_Stairs("block_nst_brown", DUMMY.getDefaultState());
		NAMAKO_ST_green = new Namako_Stairs("block_nst_green", DUMMY.getDefaultState());
		NAMAKO_ST_red = new Namako_Stairs("block_nst_red", DUMMY.getDefaultState());
		NAMAKO_ST_black = new Namako_Stairs("block_nst_black", DUMMY.getDefaultState());

		NAMAKOB = new NamakoB("block_namako_b");
		NAMAKOB_CR = new NamakoB_Crash("block_namako_b_crash");
		NAMAKOB_SH_white = new NamakoB_Slab("block_nsh_b_white");
		NAMAKOB_SH_orange = new NamakoB_Slab("block_nsh_b_orange");
		NAMAKOB_SH_magenta = new NamakoB_Slab("block_nsh_b_magenta");
		NAMAKOB_SH_lightb = new NamakoB_Slab("block_nsh_b_lightb");
		NAMAKOB_SH_yellow = new NamakoB_Slab("block_nsh_b_yellow");
		NAMAKOB_SH_lime = new NamakoB_Slab("block_nsh_b_lime");
		NAMAKOB_SH_pink = new NamakoB_Slab("block_nsh_b_pink");
		NAMAKOB_SH_gray = new NamakoB_Slab("block_nsh_b_gray");
		NAMAKOB_SH_lightg = new NamakoB_Slab("block_nsh_b_lightg");
		NAMAKOB_SH_cyan = new NamakoB_Slab("block_nsh_b_cyan");
		NAMAKOB_SH_purple = new NamakoB_Slab("block_nsh_b_purple");
		NAMAKOB_SH_blue = new NamakoB_Slab("block_nsh_b_blue");
		NAMAKOB_SH_brown = new NamakoB_Slab("block_nsh_b_brown");
		NAMAKOB_SH_green = new NamakoB_Slab("block_nsh_b_green");
		NAMAKOB_SH_red = new NamakoB_Slab("block_nsh_b_red");
		NAMAKOB_SH_black = new NamakoB_Slab("block_nsh_b_black");

		NAMAKOB_ST_white = new NamakoB_Stairs("block_nst_b_white", DUMMY.getDefaultState());
		NAMAKOB_ST_orange = new NamakoB_Stairs("block_nst_b_orange", DUMMY.getDefaultState());
		NAMAKOB_ST_magenta = new NamakoB_Stairs("block_nst_b_magenta", DUMMY.getDefaultState());
		NAMAKOB_ST_lightb = new NamakoB_Stairs("block_nst_b_lightb", DUMMY.getDefaultState());
		NAMAKOB_ST_yellow = new NamakoB_Stairs("block_nst_b_yellow", DUMMY.getDefaultState());
		NAMAKOB_ST_lime = new NamakoB_Stairs("block_nst_b_lime", DUMMY.getDefaultState());
		NAMAKOB_ST_pink = new NamakoB_Stairs("block_nst_b_pink", DUMMY.getDefaultState());
		NAMAKOB_ST_gray = new NamakoB_Stairs("block_nst_b_gray", DUMMY.getDefaultState());
		NAMAKOB_ST_lightg = new NamakoB_Stairs("block_nst_b_lightg", DUMMY.getDefaultState());
		NAMAKOB_ST_cyan = new NamakoB_Stairs("block_nst_b_cyan", DUMMY.getDefaultState());
		NAMAKOB_ST_purple = new NamakoB_Stairs("block_nst_b_purple", DUMMY.getDefaultState());
		NAMAKOB_ST_blue = new NamakoB_Stairs("block_nst_b_blue", DUMMY.getDefaultState());
		NAMAKOB_ST_brown = new NamakoB_Stairs("block_nst_b_brown", DUMMY.getDefaultState());
		NAMAKOB_ST_green = new NamakoB_Stairs("block_nst_b_green", DUMMY.getDefaultState());
		NAMAKOB_ST_red = new NamakoB_Stairs("block_nst_b_red", DUMMY.getDefaultState());
		NAMAKOB_ST_black = new NamakoB_Stairs("block_nst_b_black", DUMMY.getDefaultState());

		DIRTWALL_WALL = new Wall_DirtWall("block_dirtwall_wall");
		SHIKKUI_WALL = new Wall_Plaster("block_pwall");
		SHIKKUI_WALL_CR = new Wall_PlasterCrash("block_pwallcr");
		NAMAKO_WALL = new Wall_Namako("block_nwall");
		NAMAKO_WALL_CR = new Wall_NamakoCrash("block_nwallcr");
		NAMAKOB_WALL = new Wall_NamakoB("block_nwall_b");
		NAMAKOB_WALL_CR = new Wall_NamakoBCrash("block_nwallcr_b");
		
		DIRTWALL_SAMA = new Wall_Sama("block_dirtwall_sama");
		SHIKKUI_SAMA_white = new Wall_Sama("block_sama_white");
		SHIKKUI_SAMA_orange = new Wall_Sama("block_sama_orange");
		SHIKKUI_SAMA_magenta = new Wall_Sama("block_sama_magenta");
		SHIKKUI_SAMA_lightb = new Wall_Sama("block_sama_lightb");
		SHIKKUI_SAMA_yellow = new Wall_Sama("block_sama_yellow");
		SHIKKUI_SAMA_lime = new Wall_Sama("block_sama_lime");
		SHIKKUI_SAMA_pink = new Wall_Sama("block_sama_pink");
		SHIKKUI_SAMA_gray = new Wall_Sama("block_sama_gray");
		SHIKKUI_SAMA_lightg = new Wall_Sama("block_sama_lightg");
		SHIKKUI_SAMA_cyan = new Wall_Sama("block_sama_cyan");
		SHIKKUI_SAMA_purple = new Wall_Sama("block_sama_purple");
		SHIKKUI_SAMA_blue = new Wall_Sama("block_sama_blue");
		SHIKKUI_SAMA_brown = new Wall_Sama("block_sama_brown");
		SHIKKUI_SAMA_green = new Wall_Sama("block_sama_green");
		SHIKKUI_SAMA_red = new Wall_Sama("block_sama_red");
		SHIKKUI_SAMA_black = new Wall_Sama("block_sama_black");
		KAWARA_WALL = new Wall_Kawara("block_kwall");
	}


	public static void register() {
		registerBlock(DUMMY);

		registerBlock(KAWARA);
		registerBlock(KAWARA_CR);
		registerBlock(KAWARA_SH_white);
		registerBlock(KAWARA_SH_orange);
		registerBlock(KAWARA_SH_magenta);
		registerBlock(KAWARA_SH_lightb);
		registerBlock(KAWARA_SH_yellow);
		registerBlock(KAWARA_SH_lime);
		registerBlock(KAWARA_SH_pink);
		registerBlock(KAWARA_SH_gray);
		registerBlock(KAWARA_SH_lightg);
		registerBlock(KAWARA_SH_cyan);
		registerBlock(KAWARA_SH_purple);
		registerBlock(KAWARA_SH_blue);
		registerBlock(KAWARA_SH_brown);
		registerBlock(KAWARA_SH_green);
		registerBlock(KAWARA_SH_red);
		registerBlock(KAWARA_SH_black);
		registerBlock(KAWARA_ST_white);
		registerBlock(KAWARA_ST_orange);
		registerBlock(KAWARA_ST_magenta);
		registerBlock(KAWARA_ST_lightb);
		registerBlock(KAWARA_ST_yellow);
		registerBlock(KAWARA_ST_lime);
		registerBlock(KAWARA_ST_pink);
		registerBlock(KAWARA_ST_gray);
		registerBlock(KAWARA_ST_lightg);
		registerBlock(KAWARA_ST_cyan);
		registerBlock(KAWARA_ST_purple);
		registerBlock(KAWARA_ST_blue);
		registerBlock(KAWARA_ST_brown);
		registerBlock(KAWARA_ST_green);
		registerBlock(KAWARA_ST_red);
		registerBlock(KAWARA_ST_black);

		registerBlock(DIRTWALL_SH);
		registerBlock(DIRTWALL_ST);

		registerBlock(SHIKKUI);
		registerBlock(SHIKKUI_CR);
		registerBlock(SHIKKUI_SH_white);
		registerBlock(SHIKKUI_SH_orange);
		registerBlock(SHIKKUI_SH_magenta);
		registerBlock(SHIKKUI_SH_lightb);
		registerBlock(SHIKKUI_SH_yellow);
		registerBlock(SHIKKUI_SH_lime);
		registerBlock(SHIKKUI_SH_pink);
		registerBlock(SHIKKUI_SH_gray);
		registerBlock(SHIKKUI_SH_lightg);
		registerBlock(SHIKKUI_SH_cyan);
		registerBlock(SHIKKUI_SH_purple);
		registerBlock(SHIKKUI_SH_blue);
		registerBlock(SHIKKUI_SH_brown);
		registerBlock(SHIKKUI_SH_green);
		registerBlock(SHIKKUI_SH_red);
		registerBlock(SHIKKUI_SH_black);
		registerBlock(SHIKKUI_ST_white);
		registerBlock(SHIKKUI_ST_orange);
		registerBlock(SHIKKUI_ST_magenta);
		registerBlock(SHIKKUI_ST_lightb);
		registerBlock(SHIKKUI_ST_yellow);
		registerBlock(SHIKKUI_ST_lime);
		registerBlock(SHIKKUI_ST_pink);
		registerBlock(SHIKKUI_ST_gray);
		registerBlock(SHIKKUI_ST_lightg);
		registerBlock(SHIKKUI_ST_cyan);
		registerBlock(SHIKKUI_ST_purple);
		registerBlock(SHIKKUI_ST_blue);
		registerBlock(SHIKKUI_ST_brown);
		registerBlock(SHIKKUI_ST_green);
		registerBlock(SHIKKUI_ST_red);
		registerBlock(SHIKKUI_ST_black);

		registerBlock(NAMAKO);
		registerBlock(NAMAKO_CR);
		registerBlock(NAMAKO_SH_white);
		registerBlock(NAMAKO_SH_orange);
		registerBlock(NAMAKO_SH_magenta);
		registerBlock(NAMAKO_SH_lightb);
		registerBlock(NAMAKO_SH_yellow);
		registerBlock(NAMAKO_SH_lime);
		registerBlock(NAMAKO_SH_pink);
		registerBlock(NAMAKO_SH_gray);
		registerBlock(NAMAKO_SH_lightg);
		registerBlock(NAMAKO_SH_cyan);
		registerBlock(NAMAKO_SH_purple);
		registerBlock(NAMAKO_SH_blue);
		registerBlock(NAMAKO_SH_brown);
		registerBlock(NAMAKO_SH_green);
		registerBlock(NAMAKO_SH_red);
		registerBlock(NAMAKO_SH_black);
		registerBlock(NAMAKO_ST_white);
		registerBlock(NAMAKO_ST_orange);
		registerBlock(NAMAKO_ST_magenta);
		registerBlock(NAMAKO_ST_lightb);
		registerBlock(NAMAKO_ST_yellow);
		registerBlock(NAMAKO_ST_lime);
		registerBlock(NAMAKO_ST_pink);
		registerBlock(NAMAKO_ST_gray);
		registerBlock(NAMAKO_ST_lightg);
		registerBlock(NAMAKO_ST_cyan);
		registerBlock(NAMAKO_ST_purple);
		registerBlock(NAMAKO_ST_blue);
		registerBlock(NAMAKO_ST_brown);
		registerBlock(NAMAKO_ST_green);
		registerBlock(NAMAKO_ST_red);
		registerBlock(NAMAKO_ST_black);

		registerBlock(NAMAKOB);
		registerBlock(NAMAKOB_CR);
		registerBlock(NAMAKOB_SH_white);
		registerBlock(NAMAKOB_SH_orange);
		registerBlock(NAMAKOB_SH_magenta);
		registerBlock(NAMAKOB_SH_lightb);
		registerBlock(NAMAKOB_SH_yellow);
		registerBlock(NAMAKOB_SH_lime);
		registerBlock(NAMAKOB_SH_pink);
		registerBlock(NAMAKOB_SH_gray);
		registerBlock(NAMAKOB_SH_lightg);
		registerBlock(NAMAKOB_SH_cyan);
		registerBlock(NAMAKOB_SH_purple);
		registerBlock(NAMAKOB_SH_blue);
		registerBlock(NAMAKOB_SH_brown);
		registerBlock(NAMAKOB_SH_green);
		registerBlock(NAMAKOB_SH_red);
		registerBlock(NAMAKOB_SH_black);
		registerBlock(NAMAKOB_ST_white);
		registerBlock(NAMAKOB_ST_orange);
		registerBlock(NAMAKOB_ST_magenta);
		registerBlock(NAMAKOB_ST_lightb);
		registerBlock(NAMAKOB_ST_yellow);
		registerBlock(NAMAKOB_ST_lime);
		registerBlock(NAMAKOB_ST_pink);
		registerBlock(NAMAKOB_ST_gray);
		registerBlock(NAMAKOB_ST_lightg);
		registerBlock(NAMAKOB_ST_cyan);
		registerBlock(NAMAKOB_ST_purple);
		registerBlock(NAMAKOB_ST_blue);
		registerBlock(NAMAKOB_ST_brown);
		registerBlock(NAMAKOB_ST_green);
		registerBlock(NAMAKOB_ST_red);
		registerBlock(NAMAKOB_ST_black);

		registerBlock(DIRTWALL_WALL);
		registerBlock(SHIKKUI_WALL);
		registerBlock(SHIKKUI_WALL_CR);
		registerBlock(NAMAKO_WALL);
		registerBlock(NAMAKO_WALL_CR);
		registerBlock(NAMAKOB_WALL);
		registerBlock(NAMAKOB_WALL_CR);
		
		registerBlock(DIRTWALL_SAMA);
		registerBlock(SHIKKUI_SAMA_white);
		registerBlock(SHIKKUI_SAMA_orange);
		registerBlock(SHIKKUI_SAMA_magenta);
		registerBlock(SHIKKUI_SAMA_lightb);
		registerBlock(SHIKKUI_SAMA_yellow);
		registerBlock(SHIKKUI_SAMA_lime);
		registerBlock(SHIKKUI_SAMA_pink);
		registerBlock(SHIKKUI_SAMA_gray);
		registerBlock(SHIKKUI_SAMA_lightg);
		registerBlock(SHIKKUI_SAMA_cyan);
		registerBlock(SHIKKUI_SAMA_purple);
		registerBlock(SHIKKUI_SAMA_blue);
		registerBlock(SHIKKUI_SAMA_brown);
		registerBlock(SHIKKUI_SAMA_green);
		registerBlock(SHIKKUI_SAMA_red);
		registerBlock(SHIKKUI_SAMA_black);
		registerBlock(KAWARA_WALL);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
