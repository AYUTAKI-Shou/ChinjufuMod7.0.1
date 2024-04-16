package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Spruce;
import com.ayutaki.chinjufumod.blocks.kamoislab.Kamoi_DirtWall;

import net.minecraft.block.Block;

public class KamoiShikkui_Blocks {

	public static Block KAMOI_dirt_oak, KAMOI_dirt_spru, KAMOI_dirt_bir, KAMOI_dirt_jun, KAMOI_dirt_aca, KAMOI_dirt_doak,
								KAMOI_dirt_saku, KAMOI_dirt_kae, KAMOI_dirt_ich;

	public static Block KAMOI_white_o, KAMOI_orange_o, KAMOI_magenta_o, KAMOI_lightb_o,
								KAMOI_yellow_o, KAMOI_lime_o, KAMOI_pink_o, KAMOI_gray_o,
								KAMOI_lightg_o, KAMOI_cyan_o, KAMOI_purple_o, KAMOI_blue_o,
								KAMOI_brown_o, KAMOI_green_o, KAMOI_red_o, KAMOI_black_o;

	public static Block KAMOI_white_s, KAMOI_orange_s, KAMOI_magenta_s, KAMOI_lightb_s,
								KAMOI_yellow_s, KAMOI_lime_s, KAMOI_pink_s, KAMOI_gray_s,
								KAMOI_lightg_s, KAMOI_cyan_s, KAMOI_purple_s, KAMOI_blue_s,
								KAMOI_brown_s, KAMOI_green_s, KAMOI_red_s, KAMOI_black_s;

	public static Block KAMOI_white_b, KAMOI_orange_b, KAMOI_magenta_b, KAMOI_lightb_b,
								KAMOI_yellow_b, KAMOI_lime_b, KAMOI_pink_b, KAMOI_gray_b,
								KAMOI_lightg_b, KAMOI_cyan_b, KAMOI_purple_b, KAMOI_blue_b,
								KAMOI_brown_b, KAMOI_green_b, KAMOI_red_b, KAMOI_black_b;

	public static Block KAMOI_white_j, KAMOI_orange_j, KAMOI_magenta_j, KAMOI_lightb_j,
								KAMOI_yellow_j, KAMOI_lime_j, KAMOI_pink_j, KAMOI_gray_j,
								KAMOI_lightg_j, KAMOI_cyan_j, KAMOI_purple_j, KAMOI_blue_j,
								KAMOI_brown_j, KAMOI_green_j, KAMOI_red_j, KAMOI_black_j;

	public static Block KAMOI_white_a, KAMOI_orange_a, KAMOI_magenta_a, KAMOI_lightb_a,
								KAMOI_yellow_a, KAMOI_lime_a, KAMOI_pink_a, KAMOI_gray_a,
								KAMOI_lightg_a, KAMOI_cyan_a, KAMOI_purple_a, KAMOI_blue_a,
								KAMOI_brown_a, KAMOI_green_a, KAMOI_red_a, KAMOI_black_a;

	public static Block KAMOI_white_d, KAMOI_orange_d, KAMOI_magenta_d, KAMOI_lightb_d,
								KAMOI_yellow_d, KAMOI_lime_d, KAMOI_pink_d, KAMOI_gray_d,
								KAMOI_lightg_d, KAMOI_cyan_d, KAMOI_purple_d, KAMOI_blue_d,
								KAMOI_brown_d, KAMOI_green_d, KAMOI_red_d, KAMOI_black_d;

	public static Block KAMOI_white_saku, KAMOI_orange_saku, KAMOI_magenta_saku, KAMOI_lightb_saku,
								KAMOI_yellow_saku, KAMOI_lime_saku, KAMOI_pink_saku, KAMOI_gray_saku,
								KAMOI_lightg_saku, KAMOI_cyan_saku, KAMOI_purple_saku, KAMOI_blue_saku,
								KAMOI_brown_saku, KAMOI_green_saku, KAMOI_red_saku, KAMOI_black_saku;

	public static Block KAMOI_white_kae, KAMOI_orange_kae, KAMOI_magenta_kae, KAMOI_lightb_kae,
								KAMOI_yellow_kae, KAMOI_lime_kae, KAMOI_pink_kae, KAMOI_gray_kae,
								KAMOI_lightg_kae, KAMOI_cyan_kae, KAMOI_purple_kae, KAMOI_blue_kae,
								KAMOI_brown_kae, KAMOI_green_kae, KAMOI_red_kae, KAMOI_black_kae;

	public static Block KAMOI_white_ich, KAMOI_orange_ich, KAMOI_magenta_ich, KAMOI_lightb_ich,
								KAMOI_yellow_ich, KAMOI_lime_ich, KAMOI_pink_ich, KAMOI_gray_ich,
								KAMOI_lightg_ich, KAMOI_cyan_ich, KAMOI_purple_ich, KAMOI_blue_ich,
								KAMOI_brown_ich, KAMOI_green_ich, KAMOI_red_ich, KAMOI_black_ich;


	public static void init() {

		KAMOI_dirt_oak = new Kamoi_DirtWall("block_ka_dirt_oak");
		KAMOI_dirt_spru = new Kamoi_DirtWall("block_ka_dirt_spru");
		KAMOI_dirt_bir = new Kamoi_DirtWall("block_ka_dirt_bir");
		KAMOI_dirt_jun = new Kamoi_DirtWall("block_ka_dirt_jun");
		KAMOI_dirt_aca = new Kamoi_DirtWall("block_ka_dirt_aca");
		KAMOI_dirt_doak = new Kamoi_DirtWall("block_ka_dirt_doak");
		KAMOI_dirt_saku = new Kamoi_DirtWall("block_ka_dirt_saku");
		KAMOI_dirt_kae = new Kamoi_DirtWall("block_ka_dirt_kae");
		KAMOI_dirt_ich = new Kamoi_DirtWall("block_ka_dirt_ich");

		/** しっくい-柱 **/
		KAMOI_white_o = new KamoiPlaster_Oak("block_ka_white_o");
		KAMOI_orange_o = new KamoiPlaster_Oak("block_ka_orange_o");
		KAMOI_magenta_o = new KamoiPlaster_Oak("block_ka_magenta_o");
		KAMOI_lightb_o = new KamoiPlaster_Oak("block_ka_lightb_o");
		KAMOI_yellow_o = new KamoiPlaster_Oak("block_ka_yellow_o");
		KAMOI_lime_o = new KamoiPlaster_Oak("block_ka_lime_o");
		KAMOI_pink_o = new KamoiPlaster_Oak("block_ka_pink_o");
		KAMOI_gray_o = new KamoiPlaster_Oak("block_ka_gray_o");
		KAMOI_lightg_o = new KamoiPlaster_Oak("block_ka_lightg_o");
		KAMOI_cyan_o = new KamoiPlaster_Oak("block_ka_cyan_o");
		KAMOI_purple_o = new KamoiPlaster_Oak("block_ka_purple_o");
		KAMOI_blue_o = new KamoiPlaster_Oak("block_ka_blue_o");
		KAMOI_brown_o = new KamoiPlaster_Oak("block_ka_brown_o");
		KAMOI_green_o = new KamoiPlaster_Oak("block_ka_green_o");
		KAMOI_red_o = new KamoiPlaster_Oak("block_ka_red_o");
		KAMOI_black_o = new KamoiPlaster_Oak("block_ka_black_o");

		KAMOI_white_s = new KamoiPlaster_Spruce("block_ka_white_s");
		KAMOI_orange_s = new KamoiPlaster_Spruce("block_ka_orange_s");
		KAMOI_magenta_s = new KamoiPlaster_Spruce("block_ka_magenta_s");
		KAMOI_lightb_s = new KamoiPlaster_Spruce("block_ka_lightb_s");
		KAMOI_yellow_s = new KamoiPlaster_Spruce("block_ka_yellow_s");
		KAMOI_lime_s = new KamoiPlaster_Spruce("block_ka_lime_s");
		KAMOI_pink_s = new KamoiPlaster_Spruce("block_ka_pink_s");
		KAMOI_gray_s = new KamoiPlaster_Spruce("block_ka_gray_s");
		KAMOI_lightg_s = new KamoiPlaster_Spruce("block_ka_lightg_s");
		KAMOI_cyan_s = new KamoiPlaster_Spruce("block_ka_cyan_s");
		KAMOI_purple_s = new KamoiPlaster_Spruce("block_ka_purple_s");
		KAMOI_blue_s = new KamoiPlaster_Spruce("block_ka_blue_s");
		KAMOI_brown_s = new KamoiPlaster_Spruce("block_ka_brown_s");
		KAMOI_green_s = new KamoiPlaster_Spruce("block_ka_green_s");
		KAMOI_red_s = new KamoiPlaster_Spruce("block_ka_red_s");
		KAMOI_black_s = new KamoiPlaster_Spruce("block_ka_black_s");

		KAMOI_white_b = new KamoiPlaster_Birch("block_ka_white_b");
		KAMOI_orange_b = new KamoiPlaster_Birch("block_ka_orange_b");
		KAMOI_magenta_b = new KamoiPlaster_Birch("block_ka_magenta_b");
		KAMOI_lightb_b = new KamoiPlaster_Birch("block_ka_lightb_b");
		KAMOI_yellow_b = new KamoiPlaster_Birch("block_ka_yellow_b");
		KAMOI_lime_b = new KamoiPlaster_Birch("block_ka_lime_b");
		KAMOI_pink_b = new KamoiPlaster_Birch("block_ka_pink_b");
		KAMOI_gray_b = new KamoiPlaster_Birch("block_ka_gray_b");
		KAMOI_lightg_b = new KamoiPlaster_Birch("block_ka_lightg_b");
		KAMOI_cyan_b = new KamoiPlaster_Birch("block_ka_cyan_b");
		KAMOI_purple_b = new KamoiPlaster_Birch("block_ka_purple_b");
		KAMOI_blue_b = new KamoiPlaster_Birch("block_ka_blue_b");
		KAMOI_brown_b = new KamoiPlaster_Birch("block_ka_brown_b");
		KAMOI_green_b = new KamoiPlaster_Birch("block_ka_green_b");
		KAMOI_red_b = new KamoiPlaster_Birch("block_ka_red_b");
		KAMOI_black_b = new KamoiPlaster_Birch("block_ka_black_b");

		KAMOI_white_j = new KamoiPlaster_Jungle("block_ka_white_j");
		KAMOI_orange_j = new KamoiPlaster_Jungle("block_ka_orange_j");
		KAMOI_magenta_j = new KamoiPlaster_Jungle("block_ka_magenta_j");
		KAMOI_lightb_j = new KamoiPlaster_Jungle("block_ka_lightb_j");
		KAMOI_yellow_j = new KamoiPlaster_Jungle("block_ka_yellow_j");
		KAMOI_lime_j = new KamoiPlaster_Jungle("block_ka_lime_j");
		KAMOI_pink_j = new KamoiPlaster_Jungle("block_ka_pink_j");
		KAMOI_gray_j = new KamoiPlaster_Jungle("block_ka_gray_j");
		KAMOI_lightg_j = new KamoiPlaster_Jungle("block_ka_lightg_j");
		KAMOI_cyan_j = new KamoiPlaster_Jungle("block_ka_cyan_j");
		KAMOI_purple_j = new KamoiPlaster_Jungle("block_ka_purple_j");
		KAMOI_blue_j = new KamoiPlaster_Jungle("block_ka_blue_j");
		KAMOI_brown_j = new KamoiPlaster_Jungle("block_ka_brown_j");
		KAMOI_green_j = new KamoiPlaster_Jungle("block_ka_green_j");
		KAMOI_red_j = new KamoiPlaster_Jungle("block_ka_red_j");
		KAMOI_black_j = new KamoiPlaster_Jungle("block_ka_black_j");

		KAMOI_white_a = new KamoiPlaster_Acacia("block_ka_white_a");
		KAMOI_orange_a = new KamoiPlaster_Acacia("block_ka_orange_a");
		KAMOI_magenta_a = new KamoiPlaster_Acacia("block_ka_magenta_a");
		KAMOI_lightb_a = new KamoiPlaster_Acacia("block_ka_lightb_a");
		KAMOI_yellow_a = new KamoiPlaster_Acacia("block_ka_yellow_a");
		KAMOI_lime_a = new KamoiPlaster_Acacia("block_ka_lime_a");
		KAMOI_pink_a = new KamoiPlaster_Acacia("block_ka_pink_a");
		KAMOI_gray_a = new KamoiPlaster_Acacia("block_ka_gray_a");
		KAMOI_lightg_a = new KamoiPlaster_Acacia("block_ka_lightg_a");
		KAMOI_cyan_a = new KamoiPlaster_Acacia("block_ka_cyan_a");
		KAMOI_purple_a = new KamoiPlaster_Acacia("block_ka_purple_a");
		KAMOI_blue_a = new KamoiPlaster_Acacia("block_ka_blue_a");
		KAMOI_brown_a = new KamoiPlaster_Acacia("block_ka_brown_a");
		KAMOI_green_a = new KamoiPlaster_Acacia("block_ka_green_a");
		KAMOI_red_a = new KamoiPlaster_Acacia("block_ka_red_a");
		KAMOI_black_a = new KamoiPlaster_Acacia("block_ka_black_a");

		KAMOI_white_d = new KamoiPlaster_DarkOak("block_ka_white_d");
		KAMOI_orange_d = new KamoiPlaster_DarkOak("block_ka_orange_d");
		KAMOI_magenta_d = new KamoiPlaster_DarkOak("block_ka_magenta_d");
		KAMOI_lightb_d = new KamoiPlaster_DarkOak("block_ka_lightb_d");
		KAMOI_yellow_d = new KamoiPlaster_DarkOak("block_ka_yellow_d");
		KAMOI_lime_d = new KamoiPlaster_DarkOak("block_ka_lime_d");
		KAMOI_pink_d = new KamoiPlaster_DarkOak("block_ka_pink_d");
		KAMOI_gray_d = new KamoiPlaster_DarkOak("block_ka_gray_d");
		KAMOI_lightg_d = new KamoiPlaster_DarkOak("block_ka_lightg_d");
		KAMOI_cyan_d = new KamoiPlaster_DarkOak("block_ka_cyan_d");
		KAMOI_purple_d = new KamoiPlaster_DarkOak("block_ka_purple_d");
		KAMOI_blue_d = new KamoiPlaster_DarkOak("block_ka_blue_d");
		KAMOI_brown_d = new KamoiPlaster_DarkOak("block_ka_brown_d");
		KAMOI_green_d = new KamoiPlaster_DarkOak("block_ka_green_d");
		KAMOI_red_d = new KamoiPlaster_DarkOak("block_ka_red_d");
		KAMOI_black_d = new KamoiPlaster_DarkOak("block_ka_black_d");

		KAMOI_white_saku = new KamoiPlaster_Sakura("block_ka_white_saku");
		KAMOI_orange_saku = new KamoiPlaster_Sakura("block_ka_orange_saku");
		KAMOI_magenta_saku = new KamoiPlaster_Sakura("block_ka_magenta_saku");
		KAMOI_lightb_saku = new KamoiPlaster_Sakura("block_ka_lightb_saku");
		KAMOI_yellow_saku = new KamoiPlaster_Sakura("block_ka_yellow_saku");
		KAMOI_lime_saku = new KamoiPlaster_Sakura("block_ka_lime_saku");
		KAMOI_pink_saku = new KamoiPlaster_Sakura("block_ka_pink_saku");
		KAMOI_gray_saku = new KamoiPlaster_Sakura("block_ka_gray_saku");
		KAMOI_lightg_saku = new KamoiPlaster_Sakura("block_ka_lightg_saku");
		KAMOI_cyan_saku = new KamoiPlaster_Sakura("block_ka_cyan_saku");
		KAMOI_purple_saku = new KamoiPlaster_Sakura("block_ka_purple_saku");
		KAMOI_blue_saku = new KamoiPlaster_Sakura("block_ka_blue_saku");
		KAMOI_brown_saku = new KamoiPlaster_Sakura("block_ka_brown_saku");
		KAMOI_green_saku = new KamoiPlaster_Sakura("block_ka_green_saku");
		KAMOI_red_saku = new KamoiPlaster_Sakura("block_ka_red_saku");
		KAMOI_black_saku = new KamoiPlaster_Sakura("block_ka_black_saku");

		KAMOI_white_kae = new KamoiPlaster_Kaede("block_ka_white_kae");
		KAMOI_orange_kae = new KamoiPlaster_Kaede("block_ka_orange_kae");
		KAMOI_magenta_kae = new KamoiPlaster_Kaede("block_ka_magenta_kae");
		KAMOI_lightb_kae = new KamoiPlaster_Kaede("block_ka_lightb_kae");
		KAMOI_yellow_kae = new KamoiPlaster_Kaede("block_ka_yellow_kae");
		KAMOI_lime_kae = new KamoiPlaster_Kaede("block_ka_lime_kae");
		KAMOI_pink_kae = new KamoiPlaster_Kaede("block_ka_pink_kae");
		KAMOI_gray_kae = new KamoiPlaster_Kaede("block_ka_gray_kae");
		KAMOI_lightg_kae = new KamoiPlaster_Kaede("block_ka_lightg_kae");
		KAMOI_cyan_kae = new KamoiPlaster_Kaede("block_ka_cyan_kae");
		KAMOI_purple_kae = new KamoiPlaster_Kaede("block_ka_purple_kae");
		KAMOI_blue_kae = new KamoiPlaster_Kaede("block_ka_blue_kae");
		KAMOI_brown_kae = new KamoiPlaster_Kaede("block_ka_brown_kae");
		KAMOI_green_kae = new KamoiPlaster_Kaede("block_ka_green_kae");
		KAMOI_red_kae = new KamoiPlaster_Kaede("block_ka_red_kae");
		KAMOI_black_kae = new KamoiPlaster_Kaede("block_ka_black_kae");

		KAMOI_white_ich = new KamoiPlaster_Ichoh("block_ka_white_ich");
		KAMOI_orange_ich = new KamoiPlaster_Ichoh("block_ka_orange_ich");
		KAMOI_magenta_ich = new KamoiPlaster_Ichoh("block_ka_magenta_ich");
		KAMOI_lightb_ich = new KamoiPlaster_Ichoh("block_ka_lightb_ich");
		KAMOI_yellow_ich = new KamoiPlaster_Ichoh("block_ka_yellow_ich");
		KAMOI_lime_ich = new KamoiPlaster_Ichoh("block_ka_lime_ich");
		KAMOI_pink_ich = new KamoiPlaster_Ichoh("block_ka_pink_ich");
		KAMOI_gray_ich = new KamoiPlaster_Ichoh("block_ka_gray_ich");
		KAMOI_lightg_ich = new KamoiPlaster_Ichoh("block_ka_lightg_ich");
		KAMOI_cyan_ich = new KamoiPlaster_Ichoh("block_ka_cyan_ich");
		KAMOI_purple_ich = new KamoiPlaster_Ichoh("block_ka_purple_ich");
		KAMOI_blue_ich = new KamoiPlaster_Ichoh("block_ka_blue_ich");
		KAMOI_brown_ich = new KamoiPlaster_Ichoh("block_ka_brown_ich");
		KAMOI_green_ich = new KamoiPlaster_Ichoh("block_ka_green_ich");
		KAMOI_red_ich = new KamoiPlaster_Ichoh("block_ka_red_ich");
		KAMOI_black_ich = new KamoiPlaster_Ichoh("block_ka_black_ich");
	}


	public static void register() {

		registerBlock(KAMOI_dirt_oak);
		registerBlock(KAMOI_dirt_spru);
		registerBlock(KAMOI_dirt_bir);
		registerBlock(KAMOI_dirt_jun);
		registerBlock(KAMOI_dirt_aca);
		registerBlock(KAMOI_dirt_doak);
		registerBlock(KAMOI_dirt_saku);
		registerBlock(KAMOI_dirt_kae);
		registerBlock(KAMOI_dirt_ich);

		registerBlock(KAMOI_white_o);
		registerBlock(KAMOI_orange_o);
		registerBlock(KAMOI_magenta_o);
		registerBlock(KAMOI_lightb_o);
		registerBlock(KAMOI_yellow_o);
		registerBlock(KAMOI_lime_o);
		registerBlock(KAMOI_pink_o);
		registerBlock(KAMOI_gray_o);
		registerBlock(KAMOI_lightg_o);
		registerBlock(KAMOI_cyan_o);
		registerBlock(KAMOI_purple_o);
		registerBlock(KAMOI_blue_o);
		registerBlock(KAMOI_brown_o);
		registerBlock(KAMOI_green_o);
		registerBlock(KAMOI_red_o);
		registerBlock(KAMOI_black_o);

		registerBlock(KAMOI_white_s);
		registerBlock(KAMOI_orange_s);
		registerBlock(KAMOI_magenta_s);
		registerBlock(KAMOI_lightb_s);
		registerBlock(KAMOI_yellow_s);
		registerBlock(KAMOI_lime_s);
		registerBlock(KAMOI_pink_s);
		registerBlock(KAMOI_gray_s);
		registerBlock(KAMOI_lightg_s);
		registerBlock(KAMOI_cyan_s);
		registerBlock(KAMOI_purple_s);
		registerBlock(KAMOI_blue_s);
		registerBlock(KAMOI_brown_s);
		registerBlock(KAMOI_green_s);
		registerBlock(KAMOI_red_s);
		registerBlock(KAMOI_black_s);

		registerBlock(KAMOI_white_b);
		registerBlock(KAMOI_orange_b);
		registerBlock(KAMOI_magenta_b);
		registerBlock(KAMOI_lightb_b);
		registerBlock(KAMOI_yellow_b);
		registerBlock(KAMOI_lime_b);
		registerBlock(KAMOI_pink_b);
		registerBlock(KAMOI_gray_b);
		registerBlock(KAMOI_lightg_b);
		registerBlock(KAMOI_cyan_b);
		registerBlock(KAMOI_purple_b);
		registerBlock(KAMOI_blue_b);
		registerBlock(KAMOI_brown_b);
		registerBlock(KAMOI_green_b);
		registerBlock(KAMOI_red_b);
		registerBlock(KAMOI_black_b);

		registerBlock(KAMOI_white_j);
		registerBlock(KAMOI_orange_j);
		registerBlock(KAMOI_magenta_j);
		registerBlock(KAMOI_lightb_j);
		registerBlock(KAMOI_yellow_j);
		registerBlock(KAMOI_lime_j);
		registerBlock(KAMOI_pink_j);
		registerBlock(KAMOI_gray_j);
		registerBlock(KAMOI_lightg_j);
		registerBlock(KAMOI_cyan_j);
		registerBlock(KAMOI_purple_j);
		registerBlock(KAMOI_blue_j);
		registerBlock(KAMOI_brown_j);
		registerBlock(KAMOI_green_j);
		registerBlock(KAMOI_red_j);
		registerBlock(KAMOI_black_j);

		registerBlock(KAMOI_white_a);
		registerBlock(KAMOI_orange_a);
		registerBlock(KAMOI_magenta_a);
		registerBlock(KAMOI_lightb_a);
		registerBlock(KAMOI_yellow_a);
		registerBlock(KAMOI_lime_a);
		registerBlock(KAMOI_pink_a);
		registerBlock(KAMOI_gray_a);
		registerBlock(KAMOI_lightg_a);
		registerBlock(KAMOI_cyan_a);
		registerBlock(KAMOI_purple_a);
		registerBlock(KAMOI_blue_a);
		registerBlock(KAMOI_brown_a);
		registerBlock(KAMOI_green_a);
		registerBlock(KAMOI_red_a);
		registerBlock(KAMOI_black_a);

		registerBlock(KAMOI_white_d);
		registerBlock(KAMOI_orange_d);
		registerBlock(KAMOI_magenta_d);
		registerBlock(KAMOI_lightb_d);
		registerBlock(KAMOI_yellow_d);
		registerBlock(KAMOI_lime_d);
		registerBlock(KAMOI_pink_d);
		registerBlock(KAMOI_gray_d);
		registerBlock(KAMOI_lightg_d);
		registerBlock(KAMOI_cyan_d);
		registerBlock(KAMOI_purple_d);
		registerBlock(KAMOI_blue_d);
		registerBlock(KAMOI_brown_d);
		registerBlock(KAMOI_green_d);
		registerBlock(KAMOI_red_d);
		registerBlock(KAMOI_black_d);

		registerBlock(KAMOI_white_saku);
		registerBlock(KAMOI_orange_saku);
		registerBlock(KAMOI_magenta_saku);
		registerBlock(KAMOI_lightb_saku);
		registerBlock(KAMOI_yellow_saku);
		registerBlock(KAMOI_lime_saku);
		registerBlock(KAMOI_pink_saku);
		registerBlock(KAMOI_gray_saku);
		registerBlock(KAMOI_lightg_saku);
		registerBlock(KAMOI_cyan_saku);
		registerBlock(KAMOI_purple_saku);
		registerBlock(KAMOI_blue_saku);
		registerBlock(KAMOI_brown_saku);
		registerBlock(KAMOI_green_saku);
		registerBlock(KAMOI_red_saku);
		registerBlock(KAMOI_black_saku);

		registerBlock(KAMOI_white_kae);
		registerBlock(KAMOI_orange_kae);
		registerBlock(KAMOI_magenta_kae);
		registerBlock(KAMOI_lightb_kae);
		registerBlock(KAMOI_yellow_kae);
		registerBlock(KAMOI_lime_kae);
		registerBlock(KAMOI_pink_kae);
		registerBlock(KAMOI_gray_kae);
		registerBlock(KAMOI_lightg_kae);
		registerBlock(KAMOI_cyan_kae);
		registerBlock(KAMOI_purple_kae);
		registerBlock(KAMOI_blue_kae);
		registerBlock(KAMOI_brown_kae);
		registerBlock(KAMOI_green_kae);
		registerBlock(KAMOI_red_kae);
		registerBlock(KAMOI_black_kae);

		registerBlock(KAMOI_white_ich);
		registerBlock(KAMOI_orange_ich);
		registerBlock(KAMOI_magenta_ich);
		registerBlock(KAMOI_lightb_ich);
		registerBlock(KAMOI_yellow_ich);
		registerBlock(KAMOI_lime_ich);
		registerBlock(KAMOI_pink_ich);
		registerBlock(KAMOI_gray_ich);
		registerBlock(KAMOI_lightg_ich);
		registerBlock(KAMOI_cyan_ich);
		registerBlock(KAMOI_purple_ich);
		registerBlock(KAMOI_blue_ich);
		registerBlock(KAMOI_brown_ich);
		registerBlock(KAMOI_green_ich);
		registerBlock(KAMOI_red_ich);
		registerBlock(KAMOI_black_ich);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
