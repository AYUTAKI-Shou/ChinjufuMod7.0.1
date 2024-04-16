package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair_Top;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.LogChair;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStamp;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampItem1;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampItem2;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampItem3;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampItem4;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock_W;
import com.ayutaki.chinjufumod.blocks.cmblock.AmuBauxBox;
import com.ayutaki.chinjufumod.blocks.cmblock.BauxiteOre;
import com.ayutaki.chinjufumod.blocks.cmblock.EmptyBox;
import com.ayutaki.chinjufumod.blocks.cmblock.Report_Box1;
import com.ayutaki.chinjufumod.blocks.cmblock.Report_Box2;
import com.ayutaki.chinjufumod.blocks.cmblock.Report_Box3;
import com.ayutaki.chinjufumod.blocks.cmblock.Report_Box4;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater1;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater2;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater3;

import net.minecraft.block.Block;

public class Chinjufu_Blocks {

	/* 追加するブロックの宣言 Declare blocks to add. */
	public static Block BAUXITE_ORE;
	public static Block EMPTY_BOX;

	public static Block AMUBAUX;
	public static Block ALUMI, ALUMI_W;
	public static Block ADMIRAL_STAMP1, ADMIRAL_STAMP2, ADMIRAL_STAMP3, ADMIRAL_STAMP4, B_ADMIRAL_STAMP;

	public static Block WAKE_WATER1, WAKE_WATER2, WAKE_WATER3;
	public static Block REPORT_BOX1, REPORT_BOX2, REPORT_BOX3, REPORT_BOX4;

	public static Block ADMIRALCHAIR_TOP, ADMIRALCHAIR;
	public static Block CAFECHAIR, LOGCHAIR;


	/* ブロックのインスタンスを生成 Instantiate blocks. */
	public static void init() {
		BAUXITE_ORE = new BauxiteOre("block_bauxite_ore");
		EMPTY_BOX = new EmptyBox("block_empty_box");

		AMUBAUX = new AmuBauxBox("block_ammunition_box");
		ALUMI = new AlumiBlock("block_alumi_block");
		ALUMI_W = new AlumiBlock_W("block_alumiw_block");
		
		ADMIRAL_STAMP1 = new AdmiralStampItem1("item_admiralstamp_1");
		ADMIRAL_STAMP2 = new AdmiralStampItem2("item_admiralstamp_2");
		ADMIRAL_STAMP3 = new AdmiralStampItem3("item_admiralstamp_3");
		ADMIRAL_STAMP4 = new AdmiralStampItem4("item_admiralstamp_4");
		B_ADMIRAL_STAMP = new AdmiralStamp("block_stamp_block");

		WAKE_WATER1 = new WakeWater1("block_wake_water1");
		WAKE_WATER2 = new WakeWater2("block_wake_water2");
		WAKE_WATER3 = new WakeWater3("block_wake_water3");

		REPORT_BOX1 = new Report_Box1("block_report_box");
		REPORT_BOX2 = new Report_Box2("block_report_box2");
		REPORT_BOX3 = new Report_Box3("block_report_box3");
		REPORT_BOX4 = new Report_Box4("block_report_box4");
		
		ADMIRALCHAIR_TOP = new AdmiralChair_Top("block_admiralchair_top");
		ADMIRALCHAIR = new AdmiralChair("block_admiralchair");

		CAFECHAIR = new CafeChair("block_cafechair");
		LOGCHAIR = new LogChair("block_logchair");
	}


	/* ブロックを登録する, ここから Register Blocks. From here. ↓*/
	public static void register() {
		registerBlock(BAUXITE_ORE);
		registerBlock(EMPTY_BOX);

		registerBlock(AMUBAUX);
		registerBlock(ALUMI);
		registerBlock(ALUMI_W);
		registerBlock(ADMIRAL_STAMP1);
		registerBlock(ADMIRAL_STAMP2);
		registerBlock(ADMIRAL_STAMP3);
		registerBlock(ADMIRAL_STAMP4);
		registerBlock(B_ADMIRAL_STAMP);

		registerBlock(WAKE_WATER1);
		registerBlock(WAKE_WATER2);
		registerBlock(WAKE_WATER3);

		registerBlock(REPORT_BOX1);
		registerBlock(REPORT_BOX2);
		registerBlock(REPORT_BOX3);
		registerBlock(REPORT_BOX4);
		
		registerBlock(ADMIRALCHAIR_TOP);
		registerBlock(ADMIRALCHAIR);

		registerBlock(CAFECHAIR);
		registerBlock(LOGCHAIR);
	}

	/** ブロックの登録 Register Blocks. **/
	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
	/*ここまで So far↑ */
}
