package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.window.Curtain;
import com.ayutaki.chinjufumod.blocks.window.CurtainLarge_1;
import com.ayutaki.chinjufumod.blocks.window.CurtainLarge_2;
import com.ayutaki.chinjufumod.blocks.window.CurtainTall;
import com.ayutaki.chinjufumod.blocks.window.Window;
import com.ayutaki.chinjufumod.blocks.window.WindowB;
import com.ayutaki.chinjufumod.blocks.window.WindowTall;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_Bottom;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_Top;

import net.minecraft.block.Block;

public class Window_Blocks {

	public static Block WINDOW_oak, WINDOW_acacia, WINDOW_birch,
								WINDOW_darkoak, WINDOW_jungle, WINDOW_spruce,
								WINDOW_sakura, WINDOW_kaede, WINDOW_ichoh;

	public static Block WINDOWB_oak, WINDOWB_acacia, WINDOWB_birch,
								WINDOWB_darkoak, WINDOWB_jungle, WINDOWB_spruce,
								WINDOWB_sakura, WINDOWB_kaede, WINDOWB_ichoh;

	public static Block WINDOWTALL_oak, WINDOWTALL_acacia, WINDOWTALL_birch,
								WINDOWTALL_darkoak, WINDOWTALL_jungle, WINDOWTALL_spruce,
								WINDOWTALL_sakura, WINDOWTALL_kaede, WINDOWTALL_ichoh;

	public static Block WINDOWTALLBOT_oak, WINDOWTALLBOT_acacia, WINDOWTALLBOT_birch,
								WINDOWTALLBOT_darkoak, WINDOWTALLBOT_jungle, WINDOWTALLBOT_spruce,
								WINDOWTALLBOT_sakura, WINDOWTALLBOT_kaede, WINDOWTALLBOT_ichoh;

	public static Block WINDOWTALLTOP_oak, WINDOWTALLTOP_acacia, WINDOWTALLTOP_birch,
								WINDOWTALLTOP_darkoak, WINDOWTALLTOP_jungle, WINDOWTALLTOP_spruce,
								WINDOWTALLTOP_sakura, WINDOWTALLTOP_kaede, WINDOWTALLTOP_ichoh;

	public static Block CURTAIN_white, CURTAIN_orange, CURTAIN_magenta, CURTAIN_lightblue,
								CURTAIN_yellow, CURTAIN_lime, CURTAIN_pink, CURTAIN_gray,
								CURTAIN_lightgray, CURTAIN_cyan, CURTAIN_purple, CURTAIN_blue,
								CURTAIN_brown, CURTAIN_green, CURTAIN_red, CURTAIN_black;

	public static Block CURTAINTALL_white, CURTAINTALL_orange, CURTAINTALL_magenta, CURTAINTALL_lightblue,
								CURTAINTALL_yellow, CURTAINTALL_lime, CURTAINTALL_pink, CURTAINTALL_gray,
								CURTAINTALL_lightgray, CURTAINTALL_cyan, CURTAINTALL_purple, CURTAINTALL_blue,
								CURTAINTALL_brown, CURTAINTALL_green, CURTAINTALL_red, CURTAINTALL_black;
	
	public static Block CURTAINL1_white, CURTAINL1_orange, CURTAINL1_magenta, CURTAINL1_lightblue,
								CURTAINL1_yellow, CURTAINL1_lime, CURTAINL1_pink, CURTAINL1_gray,
								CURTAINL1_lightgray, CURTAINL1_cyan, CURTAINL1_purple, CURTAINL1_blue,
								CURTAINL1_brown, CURTAINL1_green, CURTAINL1_red, CURTAINL1_black,
								CURTAINL2_white, CURTAINL2_orange, CURTAINL2_magenta, CURTAINL2_lightblue,
								CURTAINL2_yellow, CURTAINL2_lime, CURTAINL2_pink, CURTAINL2_gray,
								CURTAINL2_lightgray, CURTAINL2_cyan, CURTAINL2_purple, CURTAINL2_blue,
								CURTAINL2_brown, CURTAINL2_green, CURTAINL2_red, CURTAINL2_black;
	
	public static void init() {

		WINDOW_oak = new Window("block_window");
		WINDOW_acacia = new Window("block_window_acacia");
		WINDOW_birch = new Window("block_window_birch");
		WINDOW_darkoak = new Window("block_window_darkoak");
		WINDOW_jungle = new Window("block_window_jungle");
		WINDOW_spruce = new Window("block_window_spruce");
		WINDOW_sakura = new Window("block_window_sakura");
		WINDOW_kaede = new Window("block_window_kaede");
		WINDOW_ichoh = new Window("block_window_ichoh");

		WINDOWB_oak = new WindowB("block_windowb");
		WINDOWB_acacia = new WindowB("block_windowb_acacia");
		WINDOWB_birch = new WindowB("block_windowb_birch");
		WINDOWB_darkoak = new WindowB("block_windowb_darkoak");
		WINDOWB_jungle = new WindowB("block_windowb_jungle");
		WINDOWB_spruce = new WindowB("block_windowb_spruce");
		WINDOWB_sakura = new WindowB("block_windowb_sakura");
		WINDOWB_kaede = new WindowB("block_windowb_kaede");
		WINDOWB_ichoh = new WindowB("block_windowb_ichoh");

		WINDOWTALL_oak = new WindowTall("block_windowtall");
		WINDOWTALL_acacia = new WindowTall("block_windowtall_acacia");
		WINDOWTALL_birch = new WindowTall("block_windowtall_birch");
		WINDOWTALL_darkoak = new WindowTall("block_windowtall_darkoak");
		WINDOWTALL_jungle = new WindowTall("block_windowtall_jungle");
		WINDOWTALL_spruce = new WindowTall("block_windowtall_spruce");
		WINDOWTALL_sakura = new WindowTall("block_windowtall_sakura");
		WINDOWTALL_kaede = new WindowTall("block_windowtall_kaede");
		WINDOWTALL_ichoh = new WindowTall("block_windowtall_ichoh");

		WINDOWTALLBOT_oak = new WindowTall_Bottom("block_windowtallbot");
		WINDOWTALLTOP_oak = new WindowTall_Top("block_windowtalltop");
		WINDOWTALLBOT_acacia = new WindowTall_Bottom("block_windowtallbot_acacia");
		WINDOWTALLTOP_acacia = new WindowTall_Top("block_windowtalltop_acacia");
		WINDOWTALLBOT_birch = new WindowTall_Bottom("block_windowtallbot_birch");
		WINDOWTALLTOP_birch = new WindowTall_Top("block_windowtalltop_birch");
		WINDOWTALLBOT_darkoak = new WindowTall_Bottom("block_windowtallbot_darkoak");
		WINDOWTALLTOP_darkoak = new WindowTall_Top("block_windowtalltop_darkoak");
		WINDOWTALLBOT_jungle = new WindowTall_Bottom("block_windowtallbot_jungle");
		WINDOWTALLTOP_jungle = new WindowTall_Top("block_windowtalltop_jungle");
		WINDOWTALLBOT_spruce = new WindowTall_Bottom("block_windowtallbot_spruce");
		WINDOWTALLTOP_spruce = new WindowTall_Top("block_windowtalltop_spruce");
		WINDOWTALLBOT_sakura = new WindowTall_Bottom("block_windowtallbot_sakura");
		WINDOWTALLTOP_sakura = new WindowTall_Top("block_windowtalltop_sakura");
		WINDOWTALLBOT_kaede = new WindowTall_Bottom("block_windowtallbot_kaede");
		WINDOWTALLTOP_kaede = new WindowTall_Top("block_windowtalltop_kaede");
		WINDOWTALLBOT_ichoh = new WindowTall_Bottom("block_windowtallbot_ichoh");
		WINDOWTALLTOP_ichoh = new WindowTall_Top("block_windowtalltop_ichoh");

		CURTAIN_white = new Curtain("block_curtain_white");
		CURTAIN_orange = new Curtain("block_curtain_orange");
		CURTAIN_magenta = new Curtain("block_curtain_magenta");
		CURTAIN_lightblue = new Curtain("block_curtain_lightblue");
		CURTAIN_yellow = new Curtain("block_curtain_yellow");
		CURTAIN_lime = new Curtain("block_curtain_lime");
		CURTAIN_pink = new Curtain("block_curtain_pink");
		CURTAIN_gray = new Curtain("block_curtain_gray");
		CURTAIN_lightgray = new Curtain("block_curtain_lightgray");
		CURTAIN_cyan = new Curtain("block_curtain_cyan");
		CURTAIN_purple = new Curtain("block_curtain_purple");
		CURTAIN_blue = new Curtain("block_curtain_blue");
		CURTAIN_brown = new Curtain("block_curtain_brown");
		CURTAIN_green = new Curtain("block_curtain_green");
		CURTAIN_red = new Curtain("block_curtain_red");
		CURTAIN_black = new Curtain("block_curtain_black");

		CURTAINTALL_white = new CurtainTall("block_curtaintall_white");
		CURTAINTALL_orange = new CurtainTall("block_curtaintall_orange");
		CURTAINTALL_magenta = new CurtainTall("block_curtaintall_magenta");
		CURTAINTALL_lightblue = new CurtainTall("block_curtaintall_lightblue");
		CURTAINTALL_yellow = new CurtainTall("block_curtaintall_yellow");
		CURTAINTALL_lime = new CurtainTall("block_curtaintall_lime");
		CURTAINTALL_pink = new CurtainTall("block_curtaintall_pink");
		CURTAINTALL_gray = new CurtainTall("block_curtaintall_gray");
		CURTAINTALL_lightgray = new CurtainTall("block_curtaintall_lightgray");
		CURTAINTALL_cyan = new CurtainTall("block_curtaintall_cyan");
		CURTAINTALL_purple = new CurtainTall("block_curtaintall_purple");
		CURTAINTALL_blue = new CurtainTall("block_curtaintall_blue");
		CURTAINTALL_brown = new CurtainTall("block_curtaintall_brown");
		CURTAINTALL_green = new CurtainTall("block_curtaintall_green");
		CURTAINTALL_red = new CurtainTall("block_curtaintall_red");
		CURTAINTALL_black = new CurtainTall("block_curtaintall_black");
		
		CURTAINL1_white = new CurtainLarge_1("block_curtainlarge_white");
		CURTAINL1_orange = new CurtainLarge_1("block_curtainlarge_orange");
		CURTAINL1_magenta = new CurtainLarge_1("block_curtainlarge_magenta");
		CURTAINL1_lightblue = new CurtainLarge_1("block_curtainlarge_lightblue");
		CURTAINL1_yellow = new CurtainLarge_1("block_curtainlarge_yellow");
		CURTAINL1_lime = new CurtainLarge_1("block_curtainlarge_lime");
		CURTAINL1_pink = new CurtainLarge_1("block_curtainlarge_pink");
		CURTAINL1_gray = new CurtainLarge_1("block_curtainlarge_gray");
		CURTAINL1_lightgray = new CurtainLarge_1("block_curtainlarge_lightgray");
		CURTAINL1_cyan = new CurtainLarge_1("block_curtainlarge_cyan");
		CURTAINL1_purple = new CurtainLarge_1("block_curtainlarge_purple");
		CURTAINL1_blue = new CurtainLarge_1("block_curtainlarge_blue");
		CURTAINL1_brown = new CurtainLarge_1("block_curtainlarge_brown");
		CURTAINL1_green = new CurtainLarge_1("block_curtainlarge_green");
		CURTAINL1_red = new CurtainLarge_1("block_curtainlarge_red");
		CURTAINL1_black = new CurtainLarge_1("block_curtainlarge_black");
		
		CURTAINL2_white = new CurtainLarge_2("block_curtainlarge_white2");
		CURTAINL2_orange = new CurtainLarge_2("block_curtainlarge_orange2");
		CURTAINL2_magenta = new CurtainLarge_2("block_curtainlarge_magenta2");
		CURTAINL2_lightblue = new CurtainLarge_2("block_curtainlarge_lightblue2");
		CURTAINL2_yellow = new CurtainLarge_2("block_curtainlarge_yellow2");
		CURTAINL2_lime = new CurtainLarge_2("block_curtainlarge_lime2");
		CURTAINL2_pink = new CurtainLarge_2("block_curtainlarge_pink2");
		CURTAINL2_gray = new CurtainLarge_2("block_curtainlarge_gray2");
		CURTAINL2_lightgray = new CurtainLarge_2("block_curtainlarge_lightgray2");
		CURTAINL2_cyan = new CurtainLarge_2("block_curtainlarge_cyan2");
		CURTAINL2_purple = new CurtainLarge_2("block_curtainlarge_purple2");
		CURTAINL2_blue = new CurtainLarge_2("block_curtainlarge_blue2");
		CURTAINL2_brown = new CurtainLarge_2("block_curtainlarge_brown2");
		CURTAINL2_green = new CurtainLarge_2("block_curtainlarge_green2");
		CURTAINL2_red = new CurtainLarge_2("block_curtainlarge_red2");
		CURTAINL2_black = new CurtainLarge_2("block_curtainlarge_black2");
	}


	public static void register() {

		registerBlock(WINDOW_oak);
		registerBlock(WINDOW_acacia);
		registerBlock(WINDOW_birch);
		registerBlock(WINDOW_darkoak);
		registerBlock(WINDOW_jungle);
		registerBlock(WINDOW_spruce);
		registerBlock(WINDOW_sakura);
		registerBlock(WINDOW_kaede);
		registerBlock(WINDOW_ichoh);

		registerBlock(WINDOWB_oak);
		registerBlock(WINDOWB_acacia);
		registerBlock(WINDOWB_birch);
		registerBlock(WINDOWB_darkoak);
		registerBlock(WINDOWB_jungle);
		registerBlock(WINDOWB_spruce);
		registerBlock(WINDOWB_sakura);
		registerBlock(WINDOWB_kaede);
		registerBlock(WINDOWB_ichoh);

		registerBlock(WINDOWTALL_oak);
		registerBlock(WINDOWTALL_acacia);
		registerBlock(WINDOWTALL_birch);
		registerBlock(WINDOWTALL_darkoak);
		registerBlock(WINDOWTALL_jungle);
		registerBlock(WINDOWTALL_spruce);
		registerBlock(WINDOWTALL_sakura);
		registerBlock(WINDOWTALL_kaede);
		registerBlock(WINDOWTALL_ichoh);

		registerBlock(WINDOWTALLBOT_oak);
		registerBlock(WINDOWTALLBOT_acacia);
		registerBlock(WINDOWTALLBOT_birch);
		registerBlock(WINDOWTALLBOT_darkoak);
		registerBlock(WINDOWTALLBOT_jungle);
		registerBlock(WINDOWTALLBOT_spruce);
		registerBlock(WINDOWTALLBOT_sakura);
		registerBlock(WINDOWTALLBOT_kaede);
		registerBlock(WINDOWTALLBOT_ichoh);

		registerBlock(WINDOWTALLTOP_oak);
		registerBlock(WINDOWTALLTOP_acacia);
		registerBlock(WINDOWTALLTOP_birch);
		registerBlock(WINDOWTALLTOP_darkoak);
		registerBlock(WINDOWTALLTOP_jungle);
		registerBlock(WINDOWTALLTOP_spruce);
		registerBlock(WINDOWTALLTOP_sakura);
		registerBlock(WINDOWTALLTOP_kaede);
		registerBlock(WINDOWTALLTOP_ichoh);

		registerBlock(CURTAIN_white);
		registerBlock(CURTAIN_orange);
		registerBlock(CURTAIN_magenta);
		registerBlock(CURTAIN_lightblue);
		registerBlock(CURTAIN_yellow);
		registerBlock(CURTAIN_lime);
		registerBlock(CURTAIN_pink);
		registerBlock(CURTAIN_gray);
		registerBlock(CURTAIN_lightgray);
		registerBlock(CURTAIN_cyan);
		registerBlock(CURTAIN_purple);
		registerBlock(CURTAIN_blue);
		registerBlock(CURTAIN_brown);
		registerBlock(CURTAIN_green);
		registerBlock(CURTAIN_red);
		registerBlock(CURTAIN_black);

		registerBlock(CURTAINTALL_white);
		registerBlock(CURTAINTALL_orange);
		registerBlock(CURTAINTALL_magenta);
		registerBlock(CURTAINTALL_lightblue);
		registerBlock(CURTAINTALL_yellow);
		registerBlock(CURTAINTALL_lime);
		registerBlock(CURTAINTALL_pink);
		registerBlock(CURTAINTALL_gray);
		registerBlock(CURTAINTALL_lightgray);
		registerBlock(CURTAINTALL_cyan);
		registerBlock(CURTAINTALL_purple);
		registerBlock(CURTAINTALL_blue);
		registerBlock(CURTAINTALL_brown);
		registerBlock(CURTAINTALL_green);
		registerBlock(CURTAINTALL_red);
		registerBlock(CURTAINTALL_black);
		
		registerBlock(CURTAINL1_white);
		registerBlock(CURTAINL1_orange);
		registerBlock(CURTAINL1_magenta);
		registerBlock(CURTAINL1_lightblue);
		registerBlock(CURTAINL1_yellow);
		registerBlock(CURTAINL1_lime);
		registerBlock(CURTAINL1_pink);
		registerBlock(CURTAINL1_gray);
		registerBlock(CURTAINL1_lightgray);
		registerBlock(CURTAINL1_cyan);
		registerBlock(CURTAINL1_purple);
		registerBlock(CURTAINL1_blue);
		registerBlock(CURTAINL1_brown);
		registerBlock(CURTAINL1_green);
		registerBlock(CURTAINL1_red);
		registerBlock(CURTAINL1_black);
		
		registerBlock(CURTAINL2_white);
		registerBlock(CURTAINL2_orange);
		registerBlock(CURTAINL2_magenta);
		registerBlock(CURTAINL2_lightblue);
		registerBlock(CURTAINL2_yellow);
		registerBlock(CURTAINL2_lime);
		registerBlock(CURTAINL2_pink);
		registerBlock(CURTAINL2_gray);
		registerBlock(CURTAINL2_lightgray);
		registerBlock(CURTAINL2_cyan);
		registerBlock(CURTAINL2_purple);
		registerBlock(CURTAINL2_blue);
		registerBlock(CURTAINL2_brown);
		registerBlock(CURTAINL2_green);
		registerBlock(CURTAINL2_red);
		registerBlock(CURTAINL2_black);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
