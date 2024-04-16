package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.harbor.Keikai;
import com.ayutaki.chinjufumod.blocks.harbor.Keiryukui;

import net.minecraft.block.Block;

public class Harbor_Blocks {

	public static Block KEIKAIBLOCK;

	public static Block KEIRYUKUI,KEIRYUKUI_b;

	public static Block TRUSS, TRUSS_white, TRUSS_orange, TRUSS_magenta,
								TRUSS_lightb, TRUSS_yellow, TRUSS_lime, TRUSS_pink,
								TRUSS_gray, TRUSS_cyan, TRUSS_purple, TRUSS_blue,
								TRUSS_brown, TRUSS_green, TRUSS_red, TRUSS_black;

	public static void init() {
		KEIKAIBLOCK = new Keikai("block_keikai");

		KEIRYUKUI = new Keiryukui("block_keiryukui");
		KEIRYUKUI_b = new Keiryukui("block_keiryukui_b");

		TRUSS = new CTruss("block_ctruss");
		TRUSS_white = new CTruss("block_ctruss_white");
		TRUSS_orange = new CTruss("block_ctruss_orange");
		TRUSS_magenta = new CTruss("block_ctruss_magenta");
		TRUSS_lightb = new CTruss("block_ctruss_lightb");
		TRUSS_yellow = new CTruss("block_ctruss_yellow");
		TRUSS_lime = new CTruss("block_ctruss_lime");
		TRUSS_pink = new CTruss("block_ctruss_pink");
		TRUSS_gray = new CTruss("block_ctruss_gray");
		TRUSS_cyan = new CTruss("block_ctruss_cyan");
		TRUSS_purple = new CTruss("block_ctruss_purple");
		TRUSS_blue = new CTruss("block_ctruss_blue");
		TRUSS_brown = new CTruss("block_ctruss_brown");
		TRUSS_green = new CTruss("block_ctruss_green");
		TRUSS_red = new CTruss("block_ctruss_red");
		TRUSS_black = new CTruss("block_ctruss_black");
	}


	public static void register() {
		registerBlock(KEIKAIBLOCK);
		registerBlock(KEIRYUKUI);
		registerBlock(KEIRYUKUI_b);

		registerBlock(TRUSS);
		registerBlock(TRUSS_white);
		registerBlock(TRUSS_orange);
		registerBlock(TRUSS_magenta);
		registerBlock(TRUSS_lightb);
		registerBlock(TRUSS_yellow);
		registerBlock(TRUSS_lime);
		registerBlock(TRUSS_pink);
		registerBlock(TRUSS_gray);
		registerBlock(TRUSS_cyan);
		registerBlock(TRUSS_purple);
		registerBlock(TRUSS_blue);
		registerBlock(TRUSS_brown);
		registerBlock(TRUSS_green);
		registerBlock(TRUSS_red);
		registerBlock(TRUSS_black);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
