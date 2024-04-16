package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Fusuma_Blocks {

	public static Fusuma FUSUMA_black;
	public static Fusuma FUSUMA_blue;
	public static Fusuma FUSUMA_brown;
	public static Fusuma FUSUMA_cyan;
	public static Fusuma FUSUMA_gray;
	public static Fusuma FUSUMA_green;
	public static Fusuma FUSUMA_lightblue;
	public static Fusuma FUSUMA_lightgray;
	public static Fusuma FUSUMA_lime;
	public static Fusuma FUSUMA_magenta;
	public static Fusuma FUSUMA_orange;
	public static Fusuma FUSUMA_pink;
	public static Fusuma FUSUMA_purple;
	public static Fusuma FUSUMA_red;
	public static Fusuma FUSUMA_white;
	public static Fusuma FUSUMA_yellow;

	public static Fusuma_B FUSUMAB_black;
	public static Fusuma_B FUSUMAB_blue;
	public static Fusuma_B FUSUMAB_brown;
	public static Fusuma_B FUSUMAB_cyan;
	public static Fusuma_B FUSUMAB_gray;
	public static Fusuma_B FUSUMAB_green;
	public static Fusuma_B FUSUMAB_lightblue;
	public static Fusuma_B FUSUMAB_lightgray;
	public static Fusuma_B FUSUMAB_lime;
	public static Fusuma_B FUSUMAB_magenta;
	public static Fusuma_B FUSUMAB_orange;
	public static Fusuma_B FUSUMAB_pink;
	public static Fusuma_B FUSUMAB_purple;
	public static Fusuma_B FUSUMAB_red;
	public static Fusuma_B FUSUMAB_white;
	public static Fusuma_B FUSUMAB_yellow;



	/* -> main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		FUSUMA_black = new Fusuma("block_fusuma_black");
		FUSUMA_blue = new Fusuma("block_fusuma_blue");
		FUSUMA_brown = new Fusuma("block_fusuma_brown");
		FUSUMA_cyan = new Fusuma("block_fusuma_cyan");
		FUSUMA_gray = new Fusuma("block_fusuma_gray");
		FUSUMA_green = new Fusuma("block_fusuma_green");
		FUSUMA_lightblue = new Fusuma("block_fusuma_lightb");
		FUSUMA_lightgray = new Fusuma("block_fusuma_lightg");
		FUSUMA_lime = new Fusuma("block_fusuma_lime");
		FUSUMA_magenta = new Fusuma("block_fusuma_magenta");
		FUSUMA_orange = new Fusuma("block_fusuma_orange");
		FUSUMA_pink = new Fusuma("block_fusuma_pink");
		FUSUMA_purple = new Fusuma("block_fusuma_purple");
		FUSUMA_red = new Fusuma("block_fusuma_red");
		FUSUMA_white = new Fusuma("block_fusuma");
		FUSUMA_yellow = new Fusuma("block_fusuma_yellow");

		FUSUMAB_black = new Fusuma_B("block_fusumab_black");
		FUSUMAB_blue = new Fusuma_B("block_fusumab_blue");
		FUSUMAB_brown = new Fusuma_B("block_fusumab_brown");
		FUSUMAB_cyan = new Fusuma_B("block_fusumab_cyan");
		FUSUMAB_gray = new Fusuma_B("block_fusumab_gray");
		FUSUMAB_green = new Fusuma_B("block_fusumab_green");
		FUSUMAB_lightblue = new Fusuma_B("block_fusumab_lightb");
		FUSUMAB_lightgray = new Fusuma_B("block_fusumab_lightg");
		FUSUMAB_lime = new Fusuma_B("block_fusumab_lime");
		FUSUMAB_magenta = new Fusuma_B("block_fusumab_magenta");
		FUSUMAB_orange = new Fusuma_B("block_fusumab_orange");
		FUSUMAB_pink = new Fusuma_B("block_fusumab_pink");
		FUSUMAB_purple = new Fusuma_B("block_fusumab_purple");
		FUSUMAB_red = new Fusuma_B("block_fusumab_red");
		FUSUMAB_white = new Fusuma_B("block_fusumab");
		FUSUMAB_yellow = new Fusuma_B("block_fusumab_yellow");
	}
}
