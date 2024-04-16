package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.jpblock.DirtWall_Item;
import com.ayutaki.chinjufumod.items.jpblock.ItemClayKawara;
import com.ayutaki.chinjufumod.items.jpblock.ItemSlakedlime;
import com.ayutaki.chinjufumod.items.jpblock.Kawara_Item;
import com.ayutaki.chinjufumod.items.jpblock.NamakoB_Item;
import com.ayutaki.chinjufumod.items.jpblock.Namako_Item;
import com.ayutaki.chinjufumod.items.jpblock.Shikkui_Item;
import com.ayutaki.chinjufumod.items.jpblock.WallKawara_Item;
import com.ayutaki.chinjufumod.items.jpblock.WallNamakoB_Item;
import com.ayutaki.chinjufumod.items.jpblock.WallNamako_Item;
import com.ayutaki.chinjufumod.items.jpblock.WallPlaster_Item;
import com.ayutaki.chinjufumod.items.jpblock.Wall_DirtWall_Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Wablock {

	public static Item CLAYKAWARA, SHOUSEKKAI;

	public static Item KAWARA;
	public static Item KAWARA_SH_white, KAWARA_SH_orange, KAWARA_SH_magenta, KAWARA_SH_lightb,
								KAWARA_SH_yellow, KAWARA_SH_lime, KAWARA_SH_pink, KAWARA_SH_gray,
								KAWARA_SH_lightg, KAWARA_SH_cyan, KAWARA_SH_purple, KAWARA_SH_blue,
								KAWARA_SH_brown, KAWARA_SH_green, KAWARA_SH_red, KAWARA_SH_black;
	public static Item KAWARA_ST_white, KAWARA_ST_orange, KAWARA_ST_magenta, KAWARA_ST_lightb,
								KAWARA_ST_yellow, KAWARA_ST_lime, KAWARA_ST_pink, KAWARA_ST_gray,
								KAWARA_ST_lightg, KAWARA_ST_cyan, KAWARA_ST_purple, KAWARA_ST_blue,
								KAWARA_ST_brown, KAWARA_ST_green, KAWARA_ST_red, KAWARA_ST_black;

	public static Item DIRTWALL, DIRTWALL_SH, DIRTWALL_ST;

	public static Item SHIKKUI;
	public static Item SHIKKUI_SH_white, SHIKKUI_SH_orange, SHIKKUI_SH_magenta, SHIKKUI_SH_lightb,
								SHIKKUI_SH_yellow, SHIKKUI_SH_lime, SHIKKUI_SH_pink, SHIKKUI_SH_gray,
								SHIKKUI_SH_lightg, SHIKKUI_SH_cyan, SHIKKUI_SH_purple, SHIKKUI_SH_blue,
								SHIKKUI_SH_brown, SHIKKUI_SH_green, SHIKKUI_SH_red, SHIKKUI_SH_black;
	public static Item SHIKKUI_ST_white, SHIKKUI_ST_orange, SHIKKUI_ST_magenta, SHIKKUI_ST_lightb,
								SHIKKUI_ST_yellow, SHIKKUI_ST_lime, SHIKKUI_ST_pink, SHIKKUI_ST_gray,
								SHIKKUI_ST_lightg, SHIKKUI_ST_cyan, SHIKKUI_ST_purple, SHIKKUI_ST_blue,
								SHIKKUI_ST_brown, SHIKKUI_ST_green, SHIKKUI_ST_red, SHIKKUI_ST_black;

	public static Item NAMAKO;
	public static Item NAMAKO_SH_white, NAMAKO_SH_orange, NAMAKO_SH_magenta, NAMAKO_SH_lightb,
								NAMAKO_SH_yellow, NAMAKO_SH_lime, NAMAKO_SH_pink, NAMAKO_SH_gray,
								NAMAKO_SH_lightg, NAMAKO_SH_cyan, NAMAKO_SH_purple, NAMAKO_SH_blue,
								NAMAKO_SH_brown, NAMAKO_SH_green, NAMAKO_SH_red, NAMAKO_SH_black;
	public static Item NAMAKO_ST_white, NAMAKO_ST_orange, NAMAKO_ST_magenta, NAMAKO_ST_lightb,
								NAMAKO_ST_yellow, NAMAKO_ST_lime, NAMAKO_ST_pink, NAMAKO_ST_gray,
								NAMAKO_ST_lightg, NAMAKO_ST_cyan, NAMAKO_ST_purple, NAMAKO_ST_blue,
								NAMAKO_ST_brown, NAMAKO_ST_green, NAMAKO_ST_red, NAMAKO_ST_black;

	public static Item NAMAKOB;
	public static Item NAMAKOB_SH_white, NAMAKOB_SH_orange, NAMAKOB_SH_magenta, NAMAKOB_SH_lightb,
								NAMAKOB_SH_yellow, NAMAKOB_SH_lime, NAMAKOB_SH_pink, NAMAKOB_SH_gray,
								NAMAKOB_SH_lightg, NAMAKOB_SH_cyan, NAMAKOB_SH_purple, NAMAKOB_SH_blue,
								NAMAKOB_SH_brown, NAMAKOB_SH_green, NAMAKOB_SH_red, NAMAKOB_SH_black;
	public static Item NAMAKOB_ST_white, NAMAKOB_ST_orange, NAMAKOB_ST_magenta, NAMAKOB_ST_lightb,
								NAMAKOB_ST_yellow, NAMAKOB_ST_lime, NAMAKOB_ST_pink, NAMAKOB_ST_gray,
								NAMAKOB_ST_lightg, NAMAKOB_ST_cyan, NAMAKOB_ST_purple, NAMAKOB_ST_blue,
								NAMAKOB_ST_brown, NAMAKOB_ST_green, NAMAKOB_ST_red, NAMAKOB_ST_black;

	public static Item DIRTWALL_WALL, SHIKKUI_WALL, NAMAKO_WALL, NAMAKOB_WALL;
	public static Item DIRTWALL_SAMA, SHIKKUI_SAMA_white, SHIKKUI_SAMA_orange, SHIKKUI_SAMA_magenta, SHIKKUI_SAMA_lightb,
								SHIKKUI_SAMA_yellow, SHIKKUI_SAMA_lime, SHIKKUI_SAMA_pink, SHIKKUI_SAMA_gray,
								SHIKKUI_SAMA_lightg, SHIKKUI_SAMA_cyan, SHIKKUI_SAMA_purple, SHIKKUI_SAMA_blue,
								SHIKKUI_SAMA_brown, SHIKKUI_SAMA_green, SHIKKUI_SAMA_red, SHIKKUI_SAMA_black;
	public static Item KAWARA_WALL;
	
	
	public static void init() {

		CLAYKAWARA = new ItemClayKawara().setRegistryName("item_claykawara").setUnlocalizedName("item_claykawara").setCreativeTab(ChinjufuModTabs.WABLOCK);
		SHOUSEKKAI = new ItemSlakedlime().setRegistryName("item_shousekkai_c").setUnlocalizedName("item_shousekkai_c").setCreativeTab(ChinjufuModTabs.WABLOCK);

		KAWARA = new Kawara_Item("block_kawara");
		KAWARA_SH_white = new ItemBlock_noFuel("block_ksh_white", JPBlock_Blocks.KAWARA_SH_white);
		KAWARA_SH_orange = new ItemBlock_noFuel("block_ksh_orange", JPBlock_Blocks.KAWARA_SH_orange);
		KAWARA_SH_magenta = new ItemBlock_noFuel("block_ksh_magenta", JPBlock_Blocks.KAWARA_SH_magenta);
		KAWARA_SH_lightb = new ItemBlock_noFuel("block_ksh_lightb", JPBlock_Blocks.KAWARA_SH_lightb);
		KAWARA_SH_yellow = new ItemBlock_noFuel("block_ksh_yellow", JPBlock_Blocks.KAWARA_SH_yellow);
		KAWARA_SH_lime = new ItemBlock_noFuel("block_ksh_lime", JPBlock_Blocks.KAWARA_SH_lime);
		KAWARA_SH_pink = new ItemBlock_noFuel("block_ksh_pink", JPBlock_Blocks.KAWARA_SH_pink);
		KAWARA_SH_gray = new ItemBlock_noFuel("block_ksh_gray", JPBlock_Blocks.KAWARA_SH_gray);
		KAWARA_SH_lightg = new ItemBlock_noFuel("block_ksh_lightg", JPBlock_Blocks.KAWARA_SH_lightg);
		KAWARA_SH_cyan = new ItemBlock_noFuel("block_ksh_cyan", JPBlock_Blocks.KAWARA_SH_cyan);
		KAWARA_SH_purple = new ItemBlock_noFuel("block_ksh_purple", JPBlock_Blocks.KAWARA_SH_purple);
		KAWARA_SH_blue = new ItemBlock_noFuel("block_ksh_blue", JPBlock_Blocks.KAWARA_SH_blue);
		KAWARA_SH_brown = new ItemBlock_noFuel("block_ksh_brown", JPBlock_Blocks.KAWARA_SH_brown);
		KAWARA_SH_green = new ItemBlock_noFuel("block_ksh_green", JPBlock_Blocks.KAWARA_SH_green);
		KAWARA_SH_red = new ItemBlock_noFuel("block_ksh_red", JPBlock_Blocks.KAWARA_SH_red);
		KAWARA_SH_black = new ItemBlock_noFuel("block_ksh_black", JPBlock_Blocks.KAWARA_SH_black);
		KAWARA_ST_white = new ItemBlock_noFuel("block_kst_white", JPBlock_Blocks.KAWARA_ST_white);
		KAWARA_ST_orange = new ItemBlock_noFuel("block_kst_orange", JPBlock_Blocks.KAWARA_ST_orange);
		KAWARA_ST_magenta = new ItemBlock_noFuel("block_kst_magenta", JPBlock_Blocks.KAWARA_ST_magenta);
		KAWARA_ST_lightb = new ItemBlock_noFuel("block_kst_lightb", JPBlock_Blocks.KAWARA_ST_lightb);
		KAWARA_ST_yellow = new ItemBlock_noFuel("block_kst_yellow", JPBlock_Blocks.KAWARA_ST_yellow);
		KAWARA_ST_lime = new ItemBlock_noFuel("block_kst_lime", JPBlock_Blocks.KAWARA_ST_lime);
		KAWARA_ST_pink = new ItemBlock_noFuel("block_kst_pink", JPBlock_Blocks.KAWARA_ST_pink);
		KAWARA_ST_gray = new ItemBlock_noFuel("block_kst_gray", JPBlock_Blocks.KAWARA_ST_gray);
		KAWARA_ST_lightg = new ItemBlock_noFuel("block_kst_lightg", JPBlock_Blocks.KAWARA_ST_lightg);
		KAWARA_ST_cyan = new ItemBlock_noFuel("block_kst_cyan", JPBlock_Blocks.KAWARA_ST_cyan);
		KAWARA_ST_purple = new ItemBlock_noFuel("block_kst_purple", JPBlock_Blocks.KAWARA_ST_purple);
		KAWARA_ST_blue = new ItemBlock_noFuel("block_kst_blue", JPBlock_Blocks.KAWARA_ST_blue);
		KAWARA_ST_brown = new ItemBlock_noFuel("block_kst_brown", JPBlock_Blocks.KAWARA_ST_brown);
		KAWARA_ST_green = new ItemBlock_noFuel("block_kst_green", JPBlock_Blocks.KAWARA_ST_green);
		KAWARA_ST_red = new ItemBlock_noFuel("block_kst_red", JPBlock_Blocks.KAWARA_ST_red);
		KAWARA_ST_black = new ItemBlock_noFuel("block_kst_black", JPBlock_Blocks.KAWARA_ST_black);

		DIRTWALL = new DirtWall_Item("block_dirtwall");
		DIRTWALL_SH = new ItemBlock_noFuel("block_dirtwall_sh", JPBlock_Blocks.DIRTWALL_SH);
		DIRTWALL_ST = new ItemBlock_noFuel("block_dirtwall_st", JPBlock_Blocks.DIRTWALL_ST);

		SHIKKUI = new Shikkui_Item("block_plaster");
		SHIKKUI_SH_white = new ItemBlock_noFuel("block_psh_white", JPBlock_Blocks.SHIKKUI_SH_white);
		SHIKKUI_SH_orange = new ItemBlock_noFuel("block_psh_orange", JPBlock_Blocks.SHIKKUI_SH_orange);
		SHIKKUI_SH_magenta = new ItemBlock_noFuel("block_psh_magenta", JPBlock_Blocks.SHIKKUI_SH_magenta);
		SHIKKUI_SH_lightb = new ItemBlock_noFuel("block_psh_lightb", JPBlock_Blocks.SHIKKUI_SH_lightb);
		SHIKKUI_SH_yellow = new ItemBlock_noFuel("block_psh_yellow", JPBlock_Blocks.SHIKKUI_SH_yellow);
		SHIKKUI_SH_lime = new ItemBlock_noFuel("block_psh_lime", JPBlock_Blocks.SHIKKUI_SH_lime);
		SHIKKUI_SH_pink = new ItemBlock_noFuel("block_psh_pink", JPBlock_Blocks.SHIKKUI_SH_pink);
		SHIKKUI_SH_gray = new ItemBlock_noFuel("block_psh_gray", JPBlock_Blocks.SHIKKUI_SH_gray);
		SHIKKUI_SH_lightg = new ItemBlock_noFuel("block_psh_lightg", JPBlock_Blocks.SHIKKUI_SH_lightg);
		SHIKKUI_SH_cyan = new ItemBlock_noFuel("block_psh_cyan", JPBlock_Blocks.SHIKKUI_SH_cyan);
		SHIKKUI_SH_purple = new ItemBlock_noFuel("block_psh_purple", JPBlock_Blocks.SHIKKUI_SH_purple);
		SHIKKUI_SH_blue = new ItemBlock_noFuel("block_psh_blue", JPBlock_Blocks.SHIKKUI_SH_blue);
		SHIKKUI_SH_brown = new ItemBlock_noFuel("block_psh_brown", JPBlock_Blocks.SHIKKUI_SH_brown);
		SHIKKUI_SH_green = new ItemBlock_noFuel("block_psh_green", JPBlock_Blocks.SHIKKUI_SH_green);
		SHIKKUI_SH_red = new ItemBlock_noFuel("block_psh_red", JPBlock_Blocks.SHIKKUI_SH_red);
		SHIKKUI_SH_black = new ItemBlock_noFuel("block_psh_black", JPBlock_Blocks.SHIKKUI_SH_black);
		SHIKKUI_ST_white = new ItemBlock_noFuel("block_pst_white", JPBlock_Blocks.SHIKKUI_ST_white);
		SHIKKUI_ST_orange = new ItemBlock_noFuel("block_pst_orange", JPBlock_Blocks.SHIKKUI_ST_orange);
		SHIKKUI_ST_magenta = new ItemBlock_noFuel("block_pst_magenta", JPBlock_Blocks.SHIKKUI_ST_magenta);
		SHIKKUI_ST_lightb = new ItemBlock_noFuel("block_pst_lightb", JPBlock_Blocks.SHIKKUI_ST_lightb);
		SHIKKUI_ST_yellow = new ItemBlock_noFuel("block_pst_yellow", JPBlock_Blocks.SHIKKUI_ST_yellow);
		SHIKKUI_ST_lime = new ItemBlock_noFuel("block_pst_lime", JPBlock_Blocks.SHIKKUI_ST_lime);
		SHIKKUI_ST_pink = new ItemBlock_noFuel("block_pst_pink", JPBlock_Blocks.SHIKKUI_ST_pink);
		SHIKKUI_ST_gray = new ItemBlock_noFuel("block_pst_gray", JPBlock_Blocks.SHIKKUI_ST_gray);
		SHIKKUI_ST_lightg = new ItemBlock_noFuel("block_pst_lightg", JPBlock_Blocks.SHIKKUI_ST_lightg);
		SHIKKUI_ST_cyan = new ItemBlock_noFuel("block_pst_cyan", JPBlock_Blocks.SHIKKUI_ST_cyan);
		SHIKKUI_ST_purple = new ItemBlock_noFuel("block_pst_purple", JPBlock_Blocks.SHIKKUI_ST_purple);
		SHIKKUI_ST_blue = new ItemBlock_noFuel("block_pst_blue", JPBlock_Blocks.SHIKKUI_ST_blue);
		SHIKKUI_ST_brown = new ItemBlock_noFuel("block_pst_brown", JPBlock_Blocks.SHIKKUI_ST_brown);
		SHIKKUI_ST_green = new ItemBlock_noFuel("block_pst_green", JPBlock_Blocks.SHIKKUI_ST_green);
		SHIKKUI_ST_red = new ItemBlock_noFuel("block_pst_red", JPBlock_Blocks.SHIKKUI_ST_red);
		SHIKKUI_ST_black = new ItemBlock_noFuel("block_pst_black", JPBlock_Blocks.SHIKKUI_ST_black);

		NAMAKO = new Namako_Item("block_namako");
		NAMAKO_SH_white = new ItemBlock_noFuel("block_nsh_white", JPBlock_Blocks.NAMAKO_SH_white);
		NAMAKO_SH_orange = new ItemBlock_noFuel("block_nsh_orange", JPBlock_Blocks.NAMAKO_SH_orange);
		NAMAKO_SH_magenta = new ItemBlock_noFuel("block_nsh_magenta", JPBlock_Blocks.NAMAKO_SH_magenta);
		NAMAKO_SH_lightb = new ItemBlock_noFuel("block_nsh_lightb", JPBlock_Blocks.NAMAKO_SH_lightb);
		NAMAKO_SH_yellow = new ItemBlock_noFuel("block_nsh_yellow", JPBlock_Blocks.NAMAKO_SH_yellow);
		NAMAKO_SH_lime = new ItemBlock_noFuel("block_nsh_lime", JPBlock_Blocks.NAMAKO_SH_lime);
		NAMAKO_SH_pink = new ItemBlock_noFuel("block_nsh_pink", JPBlock_Blocks.NAMAKO_SH_pink);
		NAMAKO_SH_gray = new ItemBlock_noFuel("block_nsh_gray", JPBlock_Blocks.NAMAKO_SH_gray);
		NAMAKO_SH_lightg = new ItemBlock_noFuel("block_nsh_lightg", JPBlock_Blocks.NAMAKO_SH_lightg);
		NAMAKO_SH_cyan = new ItemBlock_noFuel("block_nsh_cyan", JPBlock_Blocks.NAMAKO_SH_cyan);
		NAMAKO_SH_purple = new ItemBlock_noFuel("block_nsh_purple", JPBlock_Blocks.NAMAKO_SH_purple);
		NAMAKO_SH_blue = new ItemBlock_noFuel("block_nsh_blue", JPBlock_Blocks.NAMAKO_SH_blue);
		NAMAKO_SH_brown = new ItemBlock_noFuel("block_nsh_brown", JPBlock_Blocks.NAMAKO_SH_brown);
		NAMAKO_SH_green = new ItemBlock_noFuel("block_nsh_green", JPBlock_Blocks.NAMAKO_SH_green);
		NAMAKO_SH_red = new ItemBlock_noFuel("block_nsh_red", JPBlock_Blocks.NAMAKO_SH_red);
		NAMAKO_SH_black = new ItemBlock_noFuel("block_nsh_black", JPBlock_Blocks.NAMAKO_SH_black);
		NAMAKO_ST_white = new ItemBlock_noFuel("block_nst_white", JPBlock_Blocks.NAMAKO_ST_white);
		NAMAKO_ST_orange = new ItemBlock_noFuel("block_nst_orange", JPBlock_Blocks.NAMAKO_ST_orange);
		NAMAKO_ST_magenta = new ItemBlock_noFuel("block_nst_magenta", JPBlock_Blocks.NAMAKO_ST_magenta);
		NAMAKO_ST_lightb = new ItemBlock_noFuel("block_nst_lightb", JPBlock_Blocks.NAMAKO_ST_lightb);
		NAMAKO_ST_yellow = new ItemBlock_noFuel("block_nst_yellow", JPBlock_Blocks.NAMAKO_ST_yellow);
		NAMAKO_ST_lime = new ItemBlock_noFuel("block_nst_lime", JPBlock_Blocks.NAMAKO_ST_lime);
		NAMAKO_ST_pink = new ItemBlock_noFuel("block_nst_pink", JPBlock_Blocks.NAMAKO_ST_pink);
		NAMAKO_ST_gray = new ItemBlock_noFuel("block_nst_gray", JPBlock_Blocks.NAMAKO_ST_gray);
		NAMAKO_ST_lightg = new ItemBlock_noFuel("block_nst_lightg", JPBlock_Blocks.NAMAKO_ST_lightg);
		NAMAKO_ST_cyan = new ItemBlock_noFuel("block_nst_cyan", JPBlock_Blocks.NAMAKO_ST_cyan);
		NAMAKO_ST_purple = new ItemBlock_noFuel("block_nst_purple", JPBlock_Blocks.NAMAKO_ST_purple);
		NAMAKO_ST_blue = new ItemBlock_noFuel("block_nst_blue", JPBlock_Blocks.NAMAKO_ST_blue);
		NAMAKO_ST_brown = new ItemBlock_noFuel("block_nst_brown", JPBlock_Blocks.NAMAKO_ST_brown);
		NAMAKO_ST_green = new ItemBlock_noFuel("block_nst_green", JPBlock_Blocks.NAMAKO_ST_green);
		NAMAKO_ST_red = new ItemBlock_noFuel("block_nst_red", JPBlock_Blocks.NAMAKO_ST_red);
		NAMAKO_ST_black = new ItemBlock_noFuel("block_nst_black", JPBlock_Blocks.NAMAKO_ST_black);

		NAMAKOB = new NamakoB_Item("block_namako_b");
		NAMAKOB_SH_white = new ItemBlock_noFuel("block_nsh_b_white", JPBlock_Blocks.NAMAKOB_SH_white);
		NAMAKOB_SH_orange = new ItemBlock_noFuel("block_nsh_b_orange", JPBlock_Blocks.NAMAKOB_SH_orange);
		NAMAKOB_SH_magenta = new ItemBlock_noFuel("block_nsh_b_magenta", JPBlock_Blocks.NAMAKOB_SH_magenta);
		NAMAKOB_SH_lightb = new ItemBlock_noFuel("block_nsh_b_lightb", JPBlock_Blocks.NAMAKOB_SH_lightb);
		NAMAKOB_SH_yellow = new ItemBlock_noFuel("block_nsh_b_yellow", JPBlock_Blocks.NAMAKOB_SH_yellow);
		NAMAKOB_SH_lime = new ItemBlock_noFuel("block_nsh_b_lime", JPBlock_Blocks.NAMAKOB_SH_lime);
		NAMAKOB_SH_pink = new ItemBlock_noFuel("block_nsh_b_pink", JPBlock_Blocks.NAMAKOB_SH_pink);
		NAMAKOB_SH_gray = new ItemBlock_noFuel("block_nsh_b_gray", JPBlock_Blocks.NAMAKOB_SH_gray);
		NAMAKOB_SH_lightg = new ItemBlock_noFuel("block_nsh_b_lightg", JPBlock_Blocks.NAMAKOB_SH_lightg);
		NAMAKOB_SH_cyan = new ItemBlock_noFuel("block_nsh_b_cyan", JPBlock_Blocks.NAMAKOB_SH_cyan);
		NAMAKOB_SH_purple = new ItemBlock_noFuel("block_nsh_b_purple", JPBlock_Blocks.NAMAKOB_SH_purple);
		NAMAKOB_SH_blue = new ItemBlock_noFuel("block_nsh_b_blue", JPBlock_Blocks.NAMAKOB_SH_blue);
		NAMAKOB_SH_brown = new ItemBlock_noFuel("block_nsh_b_brown", JPBlock_Blocks.NAMAKOB_SH_brown);
		NAMAKOB_SH_green = new ItemBlock_noFuel("block_nsh_b_green", JPBlock_Blocks.NAMAKOB_SH_green);
		NAMAKOB_SH_red = new ItemBlock_noFuel("block_nsh_b_red", JPBlock_Blocks.NAMAKOB_SH_red);
		NAMAKOB_SH_black = new ItemBlock_noFuel("block_nsh_b_black", JPBlock_Blocks.NAMAKOB_SH_black);
		NAMAKOB_ST_white = new ItemBlock_noFuel("block_nst_b_white", JPBlock_Blocks.NAMAKOB_ST_white);
		NAMAKOB_ST_orange = new ItemBlock_noFuel("block_nst_b_orange", JPBlock_Blocks.NAMAKOB_ST_orange);
		NAMAKOB_ST_magenta = new ItemBlock_noFuel("block_nst_b_magenta", JPBlock_Blocks.NAMAKOB_ST_magenta);
		NAMAKOB_ST_lightb = new ItemBlock_noFuel("block_nst_b_lightb", JPBlock_Blocks.NAMAKOB_ST_lightb);
		NAMAKOB_ST_yellow = new ItemBlock_noFuel("block_nst_b_yellow", JPBlock_Blocks.NAMAKOB_ST_yellow);
		NAMAKOB_ST_lime = new ItemBlock_noFuel("block_nst_b_lime", JPBlock_Blocks.NAMAKOB_ST_lime);
		NAMAKOB_ST_pink = new ItemBlock_noFuel("block_nst_b_pink", JPBlock_Blocks.NAMAKOB_ST_pink);
		NAMAKOB_ST_gray = new ItemBlock_noFuel("block_nst_b_gray", JPBlock_Blocks.NAMAKOB_ST_gray);
		NAMAKOB_ST_lightg = new ItemBlock_noFuel("block_nst_b_lightg", JPBlock_Blocks.NAMAKOB_ST_lightg);
		NAMAKOB_ST_cyan = new ItemBlock_noFuel("block_nst_b_cyan", JPBlock_Blocks.NAMAKOB_ST_cyan);
		NAMAKOB_ST_purple = new ItemBlock_noFuel("block_nst_b_purple", JPBlock_Blocks.NAMAKOB_ST_purple);
		NAMAKOB_ST_blue = new ItemBlock_noFuel("block_nst_b_blue", JPBlock_Blocks.NAMAKOB_ST_blue);
		NAMAKOB_ST_brown = new ItemBlock_noFuel("block_nst_b_brown", JPBlock_Blocks.NAMAKOB_ST_brown);
		NAMAKOB_ST_green = new ItemBlock_noFuel("block_nst_b_green", JPBlock_Blocks.NAMAKOB_ST_green);
		NAMAKOB_ST_red = new ItemBlock_noFuel("block_nst_b_red", JPBlock_Blocks.NAMAKOB_ST_red);
		NAMAKOB_ST_black = new ItemBlock_noFuel("block_nst_b_black", JPBlock_Blocks.NAMAKOB_ST_black);

		DIRTWALL_WALL = new Wall_DirtWall_Item("block_dirtwall_wall");
		SHIKKUI_WALL = new WallPlaster_Item("block_pwall");
		NAMAKO_WALL = new WallNamako_Item("block_nwall");
		NAMAKOB_WALL = new WallNamakoB_Item("block_nwall_b");
		
		DIRTWALL_SAMA = new ItemBlock_noFuel("block_dirtwall_sama", JPBlock_Blocks.DIRTWALL_SAMA);
		SHIKKUI_SAMA_white = new ItemBlock_noFuel("block_sama_white", JPBlock_Blocks.SHIKKUI_SAMA_white);
		SHIKKUI_SAMA_orange = new ItemBlock_noFuel("block_sama_orange", JPBlock_Blocks.SHIKKUI_SAMA_orange);
		SHIKKUI_SAMA_magenta = new ItemBlock_noFuel("block_sama_magenta", JPBlock_Blocks.SHIKKUI_SAMA_magenta);
		SHIKKUI_SAMA_lightb = new ItemBlock_noFuel("block_sama_lightb", JPBlock_Blocks.SHIKKUI_SAMA_lightb);
		SHIKKUI_SAMA_yellow = new ItemBlock_noFuel("block_sama_yellow", JPBlock_Blocks.SHIKKUI_SAMA_yellow);
		SHIKKUI_SAMA_lime = new ItemBlock_noFuel("block_sama_lime", JPBlock_Blocks.SHIKKUI_SAMA_lime);
		SHIKKUI_SAMA_pink = new ItemBlock_noFuel("block_sama_pink", JPBlock_Blocks.SHIKKUI_SAMA_pink);
		SHIKKUI_SAMA_gray = new ItemBlock_noFuel("block_sama_gray", JPBlock_Blocks.SHIKKUI_SAMA_gray);
		SHIKKUI_SAMA_lightg = new ItemBlock_noFuel("block_sama_lightg", JPBlock_Blocks.SHIKKUI_SAMA_lightg);
		SHIKKUI_SAMA_cyan = new ItemBlock_noFuel("block_sama_cyan", JPBlock_Blocks.SHIKKUI_SAMA_cyan);
		SHIKKUI_SAMA_purple = new ItemBlock_noFuel("block_sama_purple", JPBlock_Blocks.SHIKKUI_SAMA_purple);
		SHIKKUI_SAMA_blue = new ItemBlock_noFuel("block_sama_blue", JPBlock_Blocks.SHIKKUI_SAMA_blue);
		SHIKKUI_SAMA_brown = new ItemBlock_noFuel("block_sama_brown", JPBlock_Blocks.SHIKKUI_SAMA_brown);
		SHIKKUI_SAMA_green = new ItemBlock_noFuel("block_sama_green", JPBlock_Blocks.SHIKKUI_SAMA_green);
		SHIKKUI_SAMA_red = new ItemBlock_noFuel("block_sama_red", JPBlock_Blocks.SHIKKUI_SAMA_red);
		SHIKKUI_SAMA_black = new ItemBlock_noFuel("block_sama_black", JPBlock_Blocks.SHIKKUI_SAMA_black);
		
		KAWARA_WALL = new WallKawara_Item("block_kwall");
	}

	public static void register() {

		registerItem(CLAYKAWARA);
		registerItem(SHOUSEKKAI);

		registerItem(KAWARA);
		registerItem(KAWARA_SH_white);
		registerItem(KAWARA_SH_orange);
		registerItem(KAWARA_SH_magenta);
		registerItem(KAWARA_SH_lightb);
		registerItem(KAWARA_SH_yellow);
		registerItem(KAWARA_SH_lime);
		registerItem(KAWARA_SH_pink);
		registerItem(KAWARA_SH_gray);
		registerItem(KAWARA_SH_lightg);
		registerItem(KAWARA_SH_cyan);
		registerItem(KAWARA_SH_purple);
		registerItem(KAWARA_SH_blue);
		registerItem(KAWARA_SH_brown);
		registerItem(KAWARA_SH_green);
		registerItem(KAWARA_SH_red);
		registerItem(KAWARA_SH_black);
		registerItem(KAWARA_ST_white);
		registerItem(KAWARA_ST_orange);
		registerItem(KAWARA_ST_magenta);
		registerItem(KAWARA_ST_lightb);
		registerItem(KAWARA_ST_yellow);
		registerItem(KAWARA_ST_lime);
		registerItem(KAWARA_ST_pink);
		registerItem(KAWARA_ST_gray);
		registerItem(KAWARA_ST_lightg);
		registerItem(KAWARA_ST_cyan);
		registerItem(KAWARA_ST_purple);
		registerItem(KAWARA_ST_blue);
		registerItem(KAWARA_ST_brown);
		registerItem(KAWARA_ST_green);
		registerItem(KAWARA_ST_red);
		registerItem(KAWARA_ST_black);

		registerItem(DIRTWALL);
		registerItem(DIRTWALL_SH);
		registerItem(DIRTWALL_ST);

		registerItem(SHIKKUI);
		registerItem(SHIKKUI_SH_white);
		registerItem(SHIKKUI_SH_orange);
		registerItem(SHIKKUI_SH_magenta);
		registerItem(SHIKKUI_SH_lightb);
		registerItem(SHIKKUI_SH_yellow);
		registerItem(SHIKKUI_SH_lime);
		registerItem(SHIKKUI_SH_pink);
		registerItem(SHIKKUI_SH_gray);
		registerItem(SHIKKUI_SH_lightg);
		registerItem(SHIKKUI_SH_cyan);
		registerItem(SHIKKUI_SH_purple);
		registerItem(SHIKKUI_SH_blue);
		registerItem(SHIKKUI_SH_brown);
		registerItem(SHIKKUI_SH_green);
		registerItem(SHIKKUI_SH_red);
		registerItem(SHIKKUI_SH_black);
		registerItem(SHIKKUI_ST_white);
		registerItem(SHIKKUI_ST_orange);
		registerItem(SHIKKUI_ST_magenta);
		registerItem(SHIKKUI_ST_lightb);
		registerItem(SHIKKUI_ST_yellow);
		registerItem(SHIKKUI_ST_lime);
		registerItem(SHIKKUI_ST_pink);
		registerItem(SHIKKUI_ST_gray);
		registerItem(SHIKKUI_ST_lightg);
		registerItem(SHIKKUI_ST_cyan);
		registerItem(SHIKKUI_ST_purple);
		registerItem(SHIKKUI_ST_blue);
		registerItem(SHIKKUI_ST_brown);
		registerItem(SHIKKUI_ST_green);
		registerItem(SHIKKUI_ST_red);
		registerItem(SHIKKUI_ST_black);

		registerItem(NAMAKO);
		registerItem(NAMAKO_SH_white);
		registerItem(NAMAKO_SH_orange);
		registerItem(NAMAKO_SH_magenta);
		registerItem(NAMAKO_SH_lightb);
		registerItem(NAMAKO_SH_yellow);
		registerItem(NAMAKO_SH_lime);
		registerItem(NAMAKO_SH_pink);
		registerItem(NAMAKO_SH_gray);
		registerItem(NAMAKO_SH_lightg);
		registerItem(NAMAKO_SH_cyan);
		registerItem(NAMAKO_SH_purple);
		registerItem(NAMAKO_SH_blue);
		registerItem(NAMAKO_SH_brown);
		registerItem(NAMAKO_SH_green);
		registerItem(NAMAKO_SH_red);
		registerItem(NAMAKO_SH_black);
		registerItem(NAMAKO_ST_white);
		registerItem(NAMAKO_ST_orange);
		registerItem(NAMAKO_ST_magenta);
		registerItem(NAMAKO_ST_lightb);
		registerItem(NAMAKO_ST_yellow);
		registerItem(NAMAKO_ST_lime);
		registerItem(NAMAKO_ST_pink);
		registerItem(NAMAKO_ST_gray);
		registerItem(NAMAKO_ST_lightg);
		registerItem(NAMAKO_ST_cyan);
		registerItem(NAMAKO_ST_purple);
		registerItem(NAMAKO_ST_blue);
		registerItem(NAMAKO_ST_brown);
		registerItem(NAMAKO_ST_green);
		registerItem(NAMAKO_ST_red);
		registerItem(NAMAKO_ST_black);

		registerItem(NAMAKOB);
		registerItem(NAMAKOB_SH_white);
		registerItem(NAMAKOB_SH_orange);
		registerItem(NAMAKOB_SH_magenta);
		registerItem(NAMAKOB_SH_lightb);
		registerItem(NAMAKOB_SH_yellow);
		registerItem(NAMAKOB_SH_lime);
		registerItem(NAMAKOB_SH_pink);
		registerItem(NAMAKOB_SH_gray);
		registerItem(NAMAKOB_SH_lightg);
		registerItem(NAMAKOB_SH_cyan);
		registerItem(NAMAKOB_SH_purple);
		registerItem(NAMAKOB_SH_blue);
		registerItem(NAMAKOB_SH_brown);
		registerItem(NAMAKOB_SH_green);
		registerItem(NAMAKOB_SH_red);
		registerItem(NAMAKOB_SH_black);
		registerItem(NAMAKOB_ST_white);
		registerItem(NAMAKOB_ST_orange);
		registerItem(NAMAKOB_ST_magenta);
		registerItem(NAMAKOB_ST_lightb);
		registerItem(NAMAKOB_ST_yellow);
		registerItem(NAMAKOB_ST_lime);
		registerItem(NAMAKOB_ST_pink);
		registerItem(NAMAKOB_ST_gray);
		registerItem(NAMAKOB_ST_lightg);
		registerItem(NAMAKOB_ST_cyan);
		registerItem(NAMAKOB_ST_purple);
		registerItem(NAMAKOB_ST_blue);
		registerItem(NAMAKOB_ST_brown);
		registerItem(NAMAKOB_ST_green);
		registerItem(NAMAKOB_ST_red);
		registerItem(NAMAKOB_ST_black);

		registerItem(DIRTWALL_WALL);
		registerItem(SHIKKUI_WALL);
		registerItem(NAMAKO_WALL);
		registerItem(NAMAKOB_WALL);
		
		registerItem(DIRTWALL_SAMA);
		registerItem(SHIKKUI_SAMA_white);
		registerItem(SHIKKUI_SAMA_orange);
		registerItem(SHIKKUI_SAMA_magenta);
		registerItem(SHIKKUI_SAMA_lightb);
		registerItem(SHIKKUI_SAMA_yellow);
		registerItem(SHIKKUI_SAMA_lime);
		registerItem(SHIKKUI_SAMA_pink);
		registerItem(SHIKKUI_SAMA_gray);
		registerItem(SHIKKUI_SAMA_lightg);
		registerItem(SHIKKUI_SAMA_cyan);
		registerItem(SHIKKUI_SAMA_purple);
		registerItem(SHIKKUI_SAMA_blue);
		registerItem(SHIKKUI_SAMA_brown);
		registerItem(SHIKKUI_SAMA_green);
		registerItem(SHIKKUI_SAMA_red);
		registerItem(SHIKKUI_SAMA_black);
		registerItem(KAWARA_WALL);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(CLAYKAWARA);
		registerRender(SHOUSEKKAI);

		registerRenderMeta(KAWARA, 0, "block_kawara_white");
		registerRenderMeta(KAWARA, 1, "block_kawara_orange");
		registerRenderMeta(KAWARA, 2, "block_kawara_magenta");
		registerRenderMeta(KAWARA, 3, "block_kawara_lightb");
		registerRenderMeta(KAWARA, 4, "block_kawara_yellow");
		registerRenderMeta(KAWARA, 5, "block_kawara_lime");
		registerRenderMeta(KAWARA, 6, "block_kawara_pink");
		registerRenderMeta(KAWARA, 7, "block_kawara_gray");
		registerRenderMeta(KAWARA, 8, "block_kawara_lightg");
		registerRenderMeta(KAWARA, 9, "block_kawara_cyan");
		registerRenderMeta(KAWARA, 10, "block_kawara_purple");
		registerRenderMeta(KAWARA, 11, "block_kawara_blue");
		registerRenderMeta(KAWARA, 12, "block_kawara_brown");
		registerRenderMeta(KAWARA, 13, "block_kawara_green");
		registerRenderMeta(KAWARA, 14, "block_kawara_red");
		registerRenderMeta(KAWARA, 15, "block_kawara_black");
		registerRender(KAWARA_SH_white);
		registerRender(KAWARA_SH_orange);
		registerRender(KAWARA_SH_magenta);
		registerRender(KAWARA_SH_lightb);
		registerRender(KAWARA_SH_yellow);
		registerRender(KAWARA_SH_lime);
		registerRender(KAWARA_SH_pink);
		registerRender(KAWARA_SH_gray);
		registerRender(KAWARA_SH_lightg);
		registerRender(KAWARA_SH_cyan);
		registerRender(KAWARA_SH_purple);
		registerRender(KAWARA_SH_blue);
		registerRender(KAWARA_SH_brown);
		registerRender(KAWARA_SH_green);
		registerRender(KAWARA_SH_red);
		registerRender(KAWARA_SH_black);
		registerRender(KAWARA_ST_white);
		registerRender(KAWARA_ST_orange);
		registerRender(KAWARA_ST_magenta);
		registerRender(KAWARA_ST_lightb);
		registerRender(KAWARA_ST_yellow);
		registerRender(KAWARA_ST_lime);
		registerRender(KAWARA_ST_pink);
		registerRender(KAWARA_ST_gray);
		registerRender(KAWARA_ST_lightg);
		registerRender(KAWARA_ST_cyan);
		registerRender(KAWARA_ST_purple);
		registerRender(KAWARA_ST_blue);
		registerRender(KAWARA_ST_brown);
		registerRender(KAWARA_ST_green);
		registerRender(KAWARA_ST_red);
		registerRender(KAWARA_ST_black);

		registerRender(DIRTWALL);
		registerRender(DIRTWALL_SH);
		registerRender(DIRTWALL_ST);

		registerRenderMeta(SHIKKUI, 0, "block_plaster_white");
		registerRenderMeta(SHIKKUI, 1, "block_plaster_orange");
		registerRenderMeta(SHIKKUI, 2, "block_plaster_magenta");
		registerRenderMeta(SHIKKUI, 3, "block_plaster_lightb");
		registerRenderMeta(SHIKKUI, 4, "block_plaster_yellow");
		registerRenderMeta(SHIKKUI, 5, "block_plaster_lime");
		registerRenderMeta(SHIKKUI, 6, "block_plaster_pink");
		registerRenderMeta(SHIKKUI, 7, "block_plaster_gray");
		registerRenderMeta(SHIKKUI, 8, "block_plaster_lightg");
		registerRenderMeta(SHIKKUI, 9, "block_plaster_cyan");
		registerRenderMeta(SHIKKUI, 10, "block_plaster_purple");
		registerRenderMeta(SHIKKUI, 11, "block_plaster_blue");
		registerRenderMeta(SHIKKUI, 12, "block_plaster_brown");
		registerRenderMeta(SHIKKUI, 13, "block_plaster_green");
		registerRenderMeta(SHIKKUI, 14, "block_plaster_red");
		registerRenderMeta(SHIKKUI, 15, "block_plaster_black");
		registerRender(SHIKKUI_SH_white);
		registerRender(SHIKKUI_SH_orange);
		registerRender(SHIKKUI_SH_magenta);
		registerRender(SHIKKUI_SH_lightb);
		registerRender(SHIKKUI_SH_yellow);
		registerRender(SHIKKUI_SH_lime);
		registerRender(SHIKKUI_SH_pink);
		registerRender(SHIKKUI_SH_gray);
		registerRender(SHIKKUI_SH_lightg);
		registerRender(SHIKKUI_SH_cyan);
		registerRender(SHIKKUI_SH_purple);
		registerRender(SHIKKUI_SH_blue);
		registerRender(SHIKKUI_SH_brown);
		registerRender(SHIKKUI_SH_green);
		registerRender(SHIKKUI_SH_red);
		registerRender(SHIKKUI_SH_black);
		registerRender(SHIKKUI_ST_white);
		registerRender(SHIKKUI_ST_orange);
		registerRender(SHIKKUI_ST_magenta);
		registerRender(SHIKKUI_ST_lightb);
		registerRender(SHIKKUI_ST_yellow);
		registerRender(SHIKKUI_ST_lime);
		registerRender(SHIKKUI_ST_pink);
		registerRender(SHIKKUI_ST_gray);
		registerRender(SHIKKUI_ST_lightg);
		registerRender(SHIKKUI_ST_cyan);
		registerRender(SHIKKUI_ST_purple);
		registerRender(SHIKKUI_ST_blue);
		registerRender(SHIKKUI_ST_brown);
		registerRender(SHIKKUI_ST_green);
		registerRender(SHIKKUI_ST_red);
		registerRender(SHIKKUI_ST_black);

		registerRenderMeta(NAMAKO, 0, "block_namako_white");
		registerRenderMeta(NAMAKO, 1, "block_namako_orange");
		registerRenderMeta(NAMAKO, 2, "block_namako_magenta");
		registerRenderMeta(NAMAKO, 3, "block_namako_lightb");
		registerRenderMeta(NAMAKO, 4, "block_namako_yellow");
		registerRenderMeta(NAMAKO, 5, "block_namako_lime");
		registerRenderMeta(NAMAKO, 6, "block_namako_pink");
		registerRenderMeta(NAMAKO, 7, "block_namako_gray");
		registerRenderMeta(NAMAKO, 8, "block_namako_lightg");
		registerRenderMeta(NAMAKO, 9, "block_namako_cyan");
		registerRenderMeta(NAMAKO, 10, "block_namako_purple");
		registerRenderMeta(NAMAKO, 11, "block_namako_blue");
		registerRenderMeta(NAMAKO, 12, "block_namako_brown");
		registerRenderMeta(NAMAKO, 13, "block_namako_green");
		registerRenderMeta(NAMAKO, 14, "block_namako_red");
		registerRenderMeta(NAMAKO, 15, "block_namako_black");
		registerRender(NAMAKO_SH_white);
		registerRender(NAMAKO_SH_orange);
		registerRender(NAMAKO_SH_magenta);
		registerRender(NAMAKO_SH_lightb);
		registerRender(NAMAKO_SH_yellow);
		registerRender(NAMAKO_SH_lime);
		registerRender(NAMAKO_SH_pink);
		registerRender(NAMAKO_SH_gray);
		registerRender(NAMAKO_SH_lightg);
		registerRender(NAMAKO_SH_cyan);
		registerRender(NAMAKO_SH_purple);
		registerRender(NAMAKO_SH_blue);
		registerRender(NAMAKO_SH_brown);
		registerRender(NAMAKO_SH_green);
		registerRender(NAMAKO_SH_red);
		registerRender(NAMAKO_SH_black);
		registerRender(NAMAKO_ST_white);
		registerRender(NAMAKO_ST_orange);
		registerRender(NAMAKO_ST_magenta);
		registerRender(NAMAKO_ST_lightb);
		registerRender(NAMAKO_ST_yellow);
		registerRender(NAMAKO_ST_lime);
		registerRender(NAMAKO_ST_pink);
		registerRender(NAMAKO_ST_gray);
		registerRender(NAMAKO_ST_lightg);
		registerRender(NAMAKO_ST_cyan);
		registerRender(NAMAKO_ST_purple);
		registerRender(NAMAKO_ST_blue);
		registerRender(NAMAKO_ST_brown);
		registerRender(NAMAKO_ST_green);
		registerRender(NAMAKO_ST_red);
		registerRender(NAMAKO_ST_black);

		registerRenderMeta(NAMAKOB, 0, "block_namako_b_white");
		registerRenderMeta(NAMAKOB, 1, "block_namako_b_orange");
		registerRenderMeta(NAMAKOB, 2, "block_namako_b_magenta");
		registerRenderMeta(NAMAKOB, 3, "block_namako_b_lightb");
		registerRenderMeta(NAMAKOB, 4, "block_namako_b_yellow");
		registerRenderMeta(NAMAKOB, 5, "block_namako_b_lime");
		registerRenderMeta(NAMAKOB, 6, "block_namako_b_pink");
		registerRenderMeta(NAMAKOB, 7, "block_namako_b_gray");
		registerRenderMeta(NAMAKOB, 8, "block_namako_b_lightg");
		registerRenderMeta(NAMAKOB, 9, "block_namako_b_cyan");
		registerRenderMeta(NAMAKOB, 10, "block_namako_b_purple");
		registerRenderMeta(NAMAKOB, 11, "block_namako_b_blue");
		registerRenderMeta(NAMAKOB, 12, "block_namako_b_brown");
		registerRenderMeta(NAMAKOB, 13, "block_namako_b_green");
		registerRenderMeta(NAMAKOB, 14, "block_namako_b_red");
		registerRenderMeta(NAMAKOB, 15, "block_namako_b_black");
		registerRender(NAMAKOB_SH_white);
		registerRender(NAMAKOB_SH_orange);
		registerRender(NAMAKOB_SH_magenta);
		registerRender(NAMAKOB_SH_lightb);
		registerRender(NAMAKOB_SH_yellow);
		registerRender(NAMAKOB_SH_lime);
		registerRender(NAMAKOB_SH_pink);
		registerRender(NAMAKOB_SH_gray);
		registerRender(NAMAKOB_SH_lightg);
		registerRender(NAMAKOB_SH_cyan);
		registerRender(NAMAKOB_SH_purple);
		registerRender(NAMAKOB_SH_blue);
		registerRender(NAMAKOB_SH_brown);
		registerRender(NAMAKOB_SH_green);
		registerRender(NAMAKOB_SH_red);
		registerRender(NAMAKOB_SH_black);
		registerRender(NAMAKOB_ST_white);
		registerRender(NAMAKOB_ST_orange);
		registerRender(NAMAKOB_ST_magenta);
		registerRender(NAMAKOB_ST_lightb);
		registerRender(NAMAKOB_ST_yellow);
		registerRender(NAMAKOB_ST_lime);
		registerRender(NAMAKOB_ST_pink);
		registerRender(NAMAKOB_ST_gray);
		registerRender(NAMAKOB_ST_lightg);
		registerRender(NAMAKOB_ST_cyan);
		registerRender(NAMAKOB_ST_purple);
		registerRender(NAMAKOB_ST_blue);
		registerRender(NAMAKOB_ST_brown);
		registerRender(NAMAKOB_ST_green);
		registerRender(NAMAKOB_ST_red);
		registerRender(NAMAKOB_ST_black);

		registerRender(DIRTWALL_WALL);
		registerRenderMeta(SHIKKUI_WALL, 0, "block_pwall_white");
		registerRenderMeta(SHIKKUI_WALL, 1, "block_pwall_orange");
		registerRenderMeta(SHIKKUI_WALL, 2, "block_pwall_magenta");
		registerRenderMeta(SHIKKUI_WALL, 3, "block_pwall_lightb");
		registerRenderMeta(SHIKKUI_WALL, 4, "block_pwall_yellow");
		registerRenderMeta(SHIKKUI_WALL, 5, "block_pwall_lime");
		registerRenderMeta(SHIKKUI_WALL, 6, "block_pwall_pink");
		registerRenderMeta(SHIKKUI_WALL, 7, "block_pwall_gray");
		registerRenderMeta(SHIKKUI_WALL, 8, "block_pwall_lightg");
		registerRenderMeta(SHIKKUI_WALL, 9, "block_pwall_cyan");
		registerRenderMeta(SHIKKUI_WALL, 10, "block_pwall_purple");
		registerRenderMeta(SHIKKUI_WALL, 11, "block_pwall_blue");
		registerRenderMeta(SHIKKUI_WALL, 12, "block_pwall_brown");
		registerRenderMeta(SHIKKUI_WALL, 13, "block_pwall_green");
		registerRenderMeta(SHIKKUI_WALL, 14, "block_pwall_red");
		registerRenderMeta(SHIKKUI_WALL, 15, "block_pwall_black");
		registerRenderMeta(NAMAKO_WALL, 0, "block_nwall_white");
		registerRenderMeta(NAMAKO_WALL, 1, "block_nwall_orange");
		registerRenderMeta(NAMAKO_WALL, 2, "block_nwall_magenta");
		registerRenderMeta(NAMAKO_WALL, 3, "block_nwall_lightb");
		registerRenderMeta(NAMAKO_WALL, 4, "block_nwall_yellow");
		registerRenderMeta(NAMAKO_WALL, 5, "block_nwall_lime");
		registerRenderMeta(NAMAKO_WALL, 6, "block_nwall_pink");
		registerRenderMeta(NAMAKO_WALL, 7, "block_nwall_gray");
		registerRenderMeta(NAMAKO_WALL, 8, "block_nwall_lightg");
		registerRenderMeta(NAMAKO_WALL, 9, "block_nwall_cyan");
		registerRenderMeta(NAMAKO_WALL, 10, "block_nwall_purple");
		registerRenderMeta(NAMAKO_WALL, 11, "block_nwall_blue");
		registerRenderMeta(NAMAKO_WALL, 12, "block_nwall_brown");
		registerRenderMeta(NAMAKO_WALL, 13, "block_nwall_green");
		registerRenderMeta(NAMAKO_WALL, 14, "block_nwall_red");
		registerRenderMeta(NAMAKO_WALL, 15, "block_nwall_black");
		registerRenderMeta(NAMAKOB_WALL, 0, "block_nwall_b_white");
		registerRenderMeta(NAMAKOB_WALL, 1, "block_nwall_b_orange");
		registerRenderMeta(NAMAKOB_WALL, 2, "block_nwall_b_magenta");
		registerRenderMeta(NAMAKOB_WALL, 3, "block_nwall_b_lightb");
		registerRenderMeta(NAMAKOB_WALL, 4, "block_nwall_b_yellow");
		registerRenderMeta(NAMAKOB_WALL, 5, "block_nwall_b_lime");
		registerRenderMeta(NAMAKOB_WALL, 6, "block_nwall_b_pink");
		registerRenderMeta(NAMAKOB_WALL, 7, "block_nwall_b_gray");
		registerRenderMeta(NAMAKOB_WALL, 8, "block_nwall_b_lightg");
		registerRenderMeta(NAMAKOB_WALL, 9, "block_nwall_b_cyan");
		registerRenderMeta(NAMAKOB_WALL, 10, "block_nwall_b_purple");
		registerRenderMeta(NAMAKOB_WALL, 11, "block_nwall_b_blue");
		registerRenderMeta(NAMAKOB_WALL, 12, "block_nwall_b_brown");
		registerRenderMeta(NAMAKOB_WALL, 13, "block_nwall_b_green");
		registerRenderMeta(NAMAKOB_WALL, 14, "block_nwall_b_red");
		registerRenderMeta(NAMAKOB_WALL, 15, "block_nwall_b_black");
		
		registerRender(DIRTWALL_SAMA);
		registerRender(SHIKKUI_SAMA_white);
		registerRender(SHIKKUI_SAMA_orange);
		registerRender(SHIKKUI_SAMA_magenta);
		registerRender(SHIKKUI_SAMA_lightb);
		registerRender(SHIKKUI_SAMA_yellow);
		registerRender(SHIKKUI_SAMA_lime);
		registerRender(SHIKKUI_SAMA_pink);
		registerRender(SHIKKUI_SAMA_gray);
		registerRender(SHIKKUI_SAMA_lightg);
		registerRender(SHIKKUI_SAMA_cyan);
		registerRender(SHIKKUI_SAMA_purple);
		registerRender(SHIKKUI_SAMA_blue);
		registerRender(SHIKKUI_SAMA_brown);
		registerRender(SHIKKUI_SAMA_green);
		registerRender(SHIKKUI_SAMA_red);
		registerRender(SHIKKUI_SAMA_black);
		
		registerRenderMeta(KAWARA_WALL, 0, "block_kwall_white");
		registerRenderMeta(KAWARA_WALL, 1, "block_kwall_orange");
		registerRenderMeta(KAWARA_WALL, 2, "block_kwall_magenta");
		registerRenderMeta(KAWARA_WALL, 3, "block_kwall_lightb");
		registerRenderMeta(KAWARA_WALL, 4, "block_kwall_yellow");
		registerRenderMeta(KAWARA_WALL, 5, "block_kwall_lime");
		registerRenderMeta(KAWARA_WALL, 6, "block_kwall_pink");
		registerRenderMeta(KAWARA_WALL, 7, "block_kwall_gray");
		registerRenderMeta(KAWARA_WALL, 8, "block_kwall_lightg");
		registerRenderMeta(KAWARA_WALL, 9, "block_kwall_cyan");
		registerRenderMeta(KAWARA_WALL, 10, "block_kwall_purple");
		registerRenderMeta(KAWARA_WALL, 11, "block_kwall_blue");
		registerRenderMeta(KAWARA_WALL, 12, "block_kwall_brown");
		registerRenderMeta(KAWARA_WALL, 13, "block_kwall_green");
		registerRenderMeta(KAWARA_WALL, 14, "block_kwall_red");
		registerRenderMeta(KAWARA_WALL, 15, "block_kwall_black");
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

}
