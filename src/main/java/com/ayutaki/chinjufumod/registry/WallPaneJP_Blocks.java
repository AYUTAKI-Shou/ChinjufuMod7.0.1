package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_bamboo;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_plaster;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WallPaneJP_Blocks {

	public static Block WP_BAMBOO, WP_BAMBOO_Y, WP_BAMBOO_K;

	public static Block WP_DIRTWALL;

	public static Block WP_PLASTER_white, WP_PLASTER_orange, WP_PLASTER_magenta, WP_PLASTER_lightb,
								WP_PLASTER_yellow, WP_PLASTER_lime, WP_PLASTER_pink, WP_PLASTER_gray,
								WP_PLASTER_lightg, WP_PLASTER_cyan, WP_PLASTER_purple, WP_PLASTER_blue,
								WP_PLASTER_brown, WP_PLASTER_green, WP_PLASTER_red, WP_PLASTER_black;

	public static Block WP_NAMAKO_white, WP_NAMAKO_orange, WP_NAMAKO_magenta, WP_NAMAKO_lightb,
								WP_NAMAKO_yellow, WP_NAMAKO_lime, WP_NAMAKO_pink, WP_NAMAKO_gray,
								WP_NAMAKO_lightg, WP_NAMAKO_cyan, WP_NAMAKO_purple, WP_NAMAKO_blue,
								WP_NAMAKO_brown, WP_NAMAKO_green, WP_NAMAKO_red, WP_NAMAKO_black;

	public static Block WP_NAMAKOB_white, WP_NAMAKOB_orange, WP_NAMAKOB_magenta, WP_NAMAKOB_lightb,
								WP_NAMAKOB_yellow, WP_NAMAKOB_lime, WP_NAMAKOB_pink, WP_NAMAKOB_gray,
								WP_NAMAKOB_lightg, WP_NAMAKOB_cyan, WP_NAMAKOB_purple, WP_NAMAKOB_blue,
								WP_NAMAKOB_brown, WP_NAMAKOB_green, WP_NAMAKOB_red, WP_NAMAKOB_black;

	public static void init() {

		WP_BAMBOO = new WP_bamboo("block_wp_bamboo");
		WP_BAMBOO_Y = new WP_bamboo("block_wp_bamboo_y");
		WP_BAMBOO_K = new WP_bamboo("block_wp_bamboo_k");

		WP_DIRTWALL = new WP_plaster("block_wp_dirtwall");
		WP_PLASTER_white = new WP_plaster("block_wp_plaster_white");
		WP_PLASTER_orange = new WP_plaster("block_wp_plaster_orange");
		WP_PLASTER_magenta = new WP_plaster("block_wp_plaster_magenta");
		WP_PLASTER_lightb = new WP_plaster("block_wp_plaster_lightb");
		WP_PLASTER_yellow = new WP_plaster("block_wp_plaster_yellow");
		WP_PLASTER_lime = new WP_plaster("block_wp_plaster_lime");
		WP_PLASTER_pink = new WP_plaster("block_wp_plaster_pink");
		WP_PLASTER_gray = new WP_plaster("block_wp_plaster_gray");
		WP_PLASTER_lightg = new WP_plaster("block_wp_plaster_lightg");
		WP_PLASTER_cyan = new WP_plaster("block_wp_plaster_cyan");
		WP_PLASTER_purple = new WP_plaster("block_wp_plaster_purple");
		WP_PLASTER_blue = new WP_plaster("block_wp_plaster_blue");
		WP_PLASTER_brown = new WP_plaster("block_wp_plaster_brown");
		WP_PLASTER_green = new WP_plaster("block_wp_plaster_green");
		WP_PLASTER_red = new WP_plaster("block_wp_plaster_red");
		WP_PLASTER_black = new WP_plaster("block_wp_plaster_black");

		WP_NAMAKO_white = new WP_namako("block_wp_namako_white");
		WP_NAMAKO_orange = new WP_namako("block_wp_namako_orange");
		WP_NAMAKO_magenta = new WP_namako("block_wp_namako_magenta");
		WP_NAMAKO_lightb = new WP_namako("block_wp_namako_lightb");
		WP_NAMAKO_yellow = new WP_namako("block_wp_namako_yellow");
		WP_NAMAKO_lime = new WP_namako("block_wp_namako_lime");
		WP_NAMAKO_pink = new WP_namako("block_wp_namako_pink");
		WP_NAMAKO_gray = new WP_namako("block_wp_namako_gray");
		WP_NAMAKO_lightg = new WP_namako("block_wp_namako_lightg");
		WP_NAMAKO_cyan = new WP_namako("block_wp_namako_cyan");
		WP_NAMAKO_purple = new WP_namako("block_wp_namako_purple");
		WP_NAMAKO_blue = new WP_namako("block_wp_namako_blue");
		WP_NAMAKO_brown = new WP_namako("block_wp_namako_brown");
		WP_NAMAKO_green = new WP_namako("block_wp_namako_green");
		WP_NAMAKO_red = new WP_namako("block_wp_namako_red");
		WP_NAMAKO_black = new WP_namako("block_wp_namako_black");

		WP_NAMAKOB_white = new WP_namako_B("block_wp_namako_b_white");
		WP_NAMAKOB_orange = new WP_namako_B("block_wp_namako_b_orange");
		WP_NAMAKOB_magenta = new WP_namako_B("block_wp_namako_b_magenta");
		WP_NAMAKOB_lightb = new WP_namako_B("block_wp_namako_b_lightb");
		WP_NAMAKOB_yellow = new WP_namako_B("block_wp_namako_b_yellow");
		WP_NAMAKOB_lime = new WP_namako_B("block_wp_namako_b_lime");
		WP_NAMAKOB_pink = new WP_namako_B("block_wp_namako_b_pink");
		WP_NAMAKOB_gray = new WP_namako_B("block_wp_namako_b_gray");
		WP_NAMAKOB_lightg = new WP_namako_B("block_wp_namako_b_lightg");
		WP_NAMAKOB_cyan = new WP_namako_B("block_wp_namako_b_cyan");
		WP_NAMAKOB_purple = new WP_namako_B("block_wp_namako_b_purple");
		WP_NAMAKOB_blue = new WP_namako_B("block_wp_namako_b_blue");
		WP_NAMAKOB_brown = new WP_namako_B("block_wp_namako_b_brown");
		WP_NAMAKOB_green = new WP_namako_B("block_wp_namako_b_green");
		WP_NAMAKOB_red = new WP_namako_B("block_wp_namako_b_red");
		WP_NAMAKOB_black = new WP_namako_B("block_wp_namako_b_black");

	}


	public static void register() {

		registerBlock(WP_BAMBOO);
		registerBlock(WP_BAMBOO_Y);
		registerBlock(WP_BAMBOO_K);

		registerBlock(WP_DIRTWALL);

		registerBlock(WP_PLASTER_white);
		registerBlock(WP_PLASTER_orange);
		registerBlock(WP_PLASTER_magenta);
		registerBlock(WP_PLASTER_lightb);
		registerBlock(WP_PLASTER_yellow);
		registerBlock(WP_PLASTER_lime);
		registerBlock(WP_PLASTER_pink);
		registerBlock(WP_PLASTER_gray);
		registerBlock(WP_PLASTER_lightg);
		registerBlock(WP_PLASTER_cyan);
		registerBlock(WP_PLASTER_purple);
		registerBlock(WP_PLASTER_blue);
		registerBlock(WP_PLASTER_brown);
		registerBlock(WP_PLASTER_green);
		registerBlock(WP_PLASTER_red);
		registerBlock(WP_PLASTER_black);

		registerBlock(WP_NAMAKO_white);
		registerBlock(WP_NAMAKO_orange);
		registerBlock(WP_NAMAKO_magenta);
		registerBlock(WP_NAMAKO_lightb);
		registerBlock(WP_NAMAKO_yellow);
		registerBlock(WP_NAMAKO_lime);
		registerBlock(WP_NAMAKO_pink);
		registerBlock(WP_NAMAKO_gray);
		registerBlock(WP_NAMAKO_lightg);
		registerBlock(WP_NAMAKO_cyan);
		registerBlock(WP_NAMAKO_purple);
		registerBlock(WP_NAMAKO_blue);
		registerBlock(WP_NAMAKO_brown);
		registerBlock(WP_NAMAKO_green);
		registerBlock(WP_NAMAKO_red);
		registerBlock(WP_NAMAKO_black);

		registerBlock(WP_NAMAKOB_white);
		registerBlock(WP_NAMAKOB_orange);
		registerBlock(WP_NAMAKOB_magenta);
		registerBlock(WP_NAMAKOB_lightb);
		registerBlock(WP_NAMAKOB_yellow);
		registerBlock(WP_NAMAKOB_lime);
		registerBlock(WP_NAMAKOB_pink);
		registerBlock(WP_NAMAKOB_gray);
		registerBlock(WP_NAMAKOB_lightg);
		registerBlock(WP_NAMAKOB_cyan);
		registerBlock(WP_NAMAKOB_purple);
		registerBlock(WP_NAMAKOB_blue);
		registerBlock(WP_NAMAKOB_brown);
		registerBlock(WP_NAMAKOB_green);
		registerBlock(WP_NAMAKOB_red);
		registerBlock(WP_NAMAKOB_black);

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

		registerRender(WP_BAMBOO);
		registerRender(WP_BAMBOO_Y);
		registerRender(WP_BAMBOO_K);

		registerRender(WP_DIRTWALL);

		registerRender(WP_PLASTER_white);
		registerRender(WP_PLASTER_orange);
		registerRender(WP_PLASTER_magenta);
		registerRender(WP_PLASTER_lightb);
		registerRender(WP_PLASTER_yellow);
		registerRender(WP_PLASTER_lime);
		registerRender(WP_PLASTER_pink);
		registerRender(WP_PLASTER_gray);
		registerRender(WP_PLASTER_lightg);
		registerRender(WP_PLASTER_cyan);
		registerRender(WP_PLASTER_purple);
		registerRender(WP_PLASTER_blue);
		registerRender(WP_PLASTER_brown);
		registerRender(WP_PLASTER_green);
		registerRender(WP_PLASTER_red);
		registerRender(WP_PLASTER_black);

		registerRender(WP_NAMAKO_white);
		registerRender(WP_NAMAKO_orange);
		registerRender(WP_NAMAKO_magenta);
		registerRender(WP_NAMAKO_lightb);
		registerRender(WP_NAMAKO_yellow);
		registerRender(WP_NAMAKO_lime);
		registerRender(WP_NAMAKO_pink);
		registerRender(WP_NAMAKO_gray);
		registerRender(WP_NAMAKO_lightg);
		registerRender(WP_NAMAKO_cyan);
		registerRender(WP_NAMAKO_purple);
		registerRender(WP_NAMAKO_blue);
		registerRender(WP_NAMAKO_brown);
		registerRender(WP_NAMAKO_green);
		registerRender(WP_NAMAKO_red);
		registerRender(WP_NAMAKO_black);

		registerRender(WP_NAMAKOB_white);
		registerRender(WP_NAMAKOB_orange);
		registerRender(WP_NAMAKOB_magenta);
		registerRender(WP_NAMAKOB_lightb);
		registerRender(WP_NAMAKOB_yellow);
		registerRender(WP_NAMAKOB_lime);
		registerRender(WP_NAMAKOB_pink);
		registerRender(WP_NAMAKOB_gray);
		registerRender(WP_NAMAKOB_lightg);
		registerRender(WP_NAMAKOB_cyan);
		registerRender(WP_NAMAKOB_purple);
		registerRender(WP_NAMAKOB_blue);
		registerRender(WP_NAMAKOB_brown);
		registerRender(WP_NAMAKOB_green);
		registerRender(WP_NAMAKOB_red);
		registerRender(WP_NAMAKOB_black);

	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}

}
