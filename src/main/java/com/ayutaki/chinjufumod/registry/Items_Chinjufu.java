package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.chinjufu.AdmiralChair_Item;
import com.ayutaki.chinjufumod.items.chinjufu.AdmiralStamp_Item;
import com.ayutaki.chinjufumod.items.chinjufu.AlumiBlock_Item;
import com.ayutaki.chinjufumod.items.chinjufu.AmuBauxBox_Item;
import com.ayutaki.chinjufumod.items.chinjufu.Bench_Item;
import com.ayutaki.chinjufumod.items.chinjufu.CafeChair_Item;
import com.ayutaki.chinjufumod.items.chinjufu.CafeTable_Item;
import com.ayutaki.chinjufumod.items.chinjufu.ChinjufuGroup_Item;
import com.ayutaki.chinjufumod.items.chinjufu.DiningChair_Item;
import com.ayutaki.chinjufumod.items.chinjufu.LetterTray_Item;
import com.ayutaki.chinjufumod.items.chinjufu.LightEmbed_Item;
import com.ayutaki.chinjufumod.items.chinjufu.LogChair_Item;
import com.ayutaki.chinjufumod.items.chinjufu.LowDesk_Item;
import com.ayutaki.chinjufumod.items.chinjufu.OilDrum_Item;
import com.ayutaki.chinjufumod.items.chinjufu.SchoolChair_Item;
import com.ayutaki.chinjufumod.items.chinjufu.SchoolDesk_Item;
import com.ayutaki.chinjufumod.items.chinjufu.Shouhou_Item;
import com.ayutaki.chinjufumod.items.chinjufu.Sofa_Item;
import com.ayutaki.chinjufumod.items.chinjufu.TeacherDesk_Item;
import com.ayutaki.chinjufumod.items.chinjufu.Truss_Item;
import com.ayutaki.chinjufumod.items.chinjufu.UnitDesk_Item;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.furniture.Candle_Item;
import com.ayutaki.chinjufumod.items.furniture.DressingTable_Item;
import com.ayutaki.chinjufumod.items.furniture.Tansu_Item;
import com.ayutaki.chinjufumod.items.window.CurtainLarge_Item;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;
import com.ayutaki.chinjufumod.items.window.WindowB_Item;
import com.ayutaki.chinjufumod.items.window.WindowTallBot_Item;
import com.ayutaki.chinjufumod.items.window.WindowTall_Item;
import com.ayutaki.chinjufumod.items.window.Window_Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Chinjufu {

	public static Item EMBLEM_C;
	public static Item ADMIRAL_STAMP, ADMIRAL_STAMP_B, WORK_ORDER, REPORT_BOX;
	public static Item SHOUHOU_empty, SHOUHOU;
	
	public static Item BAUXITE, ALUMINUM;
	public static Item SUMI;

	public static Item BAUXITE_ORE;
	public static Item OIL_DRUM;
	public static Item EMPTY_BOX, AMUBAUX, ALUMI;
	public static Item B_ADMIRAL_STAMP;

	public static Item DRESSINGTABLE_item, UNITDESK_item, CAFETABLE_item;
	public static Item DININGCHAIR_item, LOGCHAIR_item, CAFECHAIR_item;
	public static Item BENCH_item, SOFA_item;

	public static Item SCHOOLCHAIR_item,SCHOOLDESK_item, TEACHERDESK_item;
	public static Item LOWDESK_item, LETTERTRAY, BLACKBOARD;

	public static Item WINDOW_item, WINDOWB_item, WINDOWTALLBOT_item, WINDOWTALL_item;
	public static Item CURTAIN_item, CURTAINTALL_item, CURTAINL1_item;

	public static Item STOVECHIMNEY, STOVECHIMNEY_joint, STOVECHIMNEY_topk;
	public static Item CSTOVE_bot;

	public static Item CANDLE_item;
	public static Item LAMP, STANDARM, STAND, M_LAMP, E_LIGHT;

	public static Item ADMIRALCHAIR, TANSU;

	public static Item KEIKAIBLOCK, KEIRYUKUI, KEIRYUKUI_b, TRUSS_item;


	/* アイテムのインスタンスを生成 Instantiate an item. */
	public static void init() {

		EMBLEM_C = new Item().setRegistryName("item_emblem_c").setUnlocalizedName("item_emblem_c");
		ADMIRAL_STAMP = new AdmiralStamp_Item("item_admiralstamp", Chinjufu_Blocks.ADMIRAL_STAMP1);
		ADMIRAL_STAMP_B = new AdmiralStamp_Item("item_admiralstamp_b", Chinjufu_Blocks.ADMIRAL_STAMP1).setCreativeTab(ChinjufuModTabs.CHINJUFU);
		WORK_ORDER = new ChinjufuGroup_Item("item_workorder");
		REPORT_BOX = new ItemBlock_noFuel("block_report_box", Chinjufu_Blocks.REPORT_BOX1);
		SHOUHOU_empty = new ChinjufuGroup_Item("item_shouhou_empty");
		SHOUHOU = new Shouhou_Item("item_shouhou");
		
		BAUXITE = new ChinjufuGroup_Item("item_bauxite");
		ALUMINUM = new ChinjufuGroup_Item("item_ingot_alumi");
		SUMI = new ChinjufuGroup_Item("item_sumi_c");

		BAUXITE_ORE = new ItemBlock_noFuel("block_bauxite_ore", Chinjufu_Blocks.BAUXITE_ORE);
		OIL_DRUM = new OilDrum_Item("block_fuel_can");
		EMPTY_BOX = new ItemBlock_Fuel100("block_empty_box", Chinjufu_Blocks.EMPTY_BOX);
		AMUBAUX = new AmuBauxBox_Item("block_ammunition_box");
		ALUMI = new AlumiBlock_Item("block_alumi_block");
		B_ADMIRAL_STAMP = new ItemBlock_noFuel("block_stamp_block", Chinjufu_Blocks.B_ADMIRAL_STAMP);

		DRESSINGTABLE_item = new DressingTable_Item("block_dressingtable");
		UNITDESK_item = new UnitDesk_Item("block_unitdesk");
		CAFETABLE_item = new CafeTable_Item("block_cafetable");
		DININGCHAIR_item = new DiningChair_Item("block_diningchair");
		LOGCHAIR_item = new LogChair_Item("block_logchair");
		CAFECHAIR_item = new CafeChair_Item("block_cafechair");
		BENCH_item = new Bench_Item("block_bench");
		SOFA_item = new Sofa_Item("block_sofa");
		
		SCHOOLCHAIR_item = new SchoolChair_Item("block_schoolchair");
		SCHOOLDESK_item = new SchoolDesk_Item("block_schooldesk");
		TEACHERDESK_item = new TeacherDesk_Item("block_teacherdesk");
		LOWDESK_item = new LowDesk_Item("block_lowdesk");
		LETTERTRAY = new LetterTray_Item("block_lettertray_c");
		BLACKBOARD = new ItemBlock_noFuel("block_blackboard", Furniture_Blocks.BLACKBOARD);

		WINDOW_item = new Window_Item("block_window");
		WINDOWB_item= new WindowB_Item("block_windowb");
		WINDOWTALLBOT_item = new WindowTallBot_Item("block_windowtallbot");
		WINDOWTALL_item = new WindowTall_Item("block_windowtall");
		CURTAIN_item = new Curtain_Item("block_curtain");
		CURTAINTALL_item = new CurtainTall_Item("block_curtaintall");
		CURTAINL1_item = new CurtainLarge_Item("block_curtainlarge");
		
		STOVECHIMNEY = new ItemBlock_noFuel("block_stovechimney", Furniture_Blocks.STOVECHIMNEY);
		STOVECHIMNEY_joint = new ItemBlock_noFuel("block_stovechimney_joint", Furniture_Blocks.STOVECHIMNEY_joint);
		STOVECHIMNEY_topk = new ItemBlock_noFuel("block_stovechimney_topk", Furniture_Blocks.STOVECHIMNEY_topk);
		CSTOVE_bot = new ItemBlock_noFuel("block_cstove_bot", Furniture_Blocks.CSTOVE_bot);

		CANDLE_item = new Candle_Item("block_candle");
		LAMP = new ItemBlock_noFuel("block_lamp", Lamp_Blocks.LAMP);
		STANDARM = new ItemBlock_noFuel("block_standarm", Lamp_Blocks.STANDARM);
		STAND = new ItemBlock_noFuel("block_standbedroom", Lamp_Blocks.STAND);
		M_LAMP = new ItemBlock_noFuel("block_marinelamp", Lamp_Blocks.M_LAMP);
		E_LIGHT = new LightEmbed_Item("block_lightembed", Lamp_Blocks.E_LIGHT);
		
		ADMIRALCHAIR = new AdmiralChair_Item("block_admiralchair");
		TANSU = new Tansu_Item("block_tansu");

		KEIKAIBLOCK = new ItemBlock_noFuel("block_keikai", Harbor_Blocks.KEIKAIBLOCK);
		KEIRYUKUI = new ItemBlock_noFuel("block_keiryukui", Harbor_Blocks.KEIRYUKUI);
		KEIRYUKUI_b = new ItemBlock_noFuel("block_keiryukui_b", Harbor_Blocks.KEIRYUKUI_b);
		TRUSS_item = new Truss_Item("block_ctruss_white");
	}


	/* アイテムを登録する, ここから Register Items. From here. ↓*/
	public static void register() {
		registerItem(EMBLEM_C);
		registerItem(ADMIRAL_STAMP);
		registerItem(ADMIRAL_STAMP_B);
		registerItem(WORK_ORDER);
		registerItem(REPORT_BOX);
		registerItem(SHOUHOU_empty);
		registerItem(SHOUHOU);
		
		registerItem(BAUXITE);
		registerItem(ALUMINUM);
		registerItem(SUMI);

		registerItem(BAUXITE_ORE);
		registerItem(OIL_DRUM);
		registerItem(EMPTY_BOX);
		registerItem(AMUBAUX);
		registerItem(ALUMI);
		registerItem(B_ADMIRAL_STAMP);

		registerItem(DRESSINGTABLE_item);
		registerItem(UNITDESK_item);
		registerItem(CAFETABLE_item);

		registerItem(DININGCHAIR_item);
		registerItem(LOGCHAIR_item);
		registerItem(CAFECHAIR_item);
		registerItem(BENCH_item);
		registerItem(SOFA_item);

		registerItem(SCHOOLCHAIR_item);
		registerItem(SCHOOLDESK_item);
		registerItem(TEACHERDESK_item);

		registerItem(LOWDESK_item);
		registerItem(LETTERTRAY);
		registerItem(BLACKBOARD);

		registerItem(WINDOW_item);
		registerItem(WINDOWB_item);
		registerItem(WINDOWTALLBOT_item);
		registerItem(WINDOWTALL_item);
		registerItem(CURTAIN_item);
		registerItem(CURTAINTALL_item);
		registerItem(CURTAINL1_item);
		
		registerItem(STOVECHIMNEY);
		registerItem(STOVECHIMNEY_joint);
		registerItem(STOVECHIMNEY_topk);
		registerItem(CSTOVE_bot);

		registerItem(CANDLE_item);
		registerItem(LAMP);
		registerItem(STANDARM);
		registerItem(STAND);
		registerItem(M_LAMP);
		registerItem(E_LIGHT);
		
		registerItem(ADMIRALCHAIR);
		registerItem(TANSU);

		registerItem(KEIKAIBLOCK);
		registerItem(KEIRYUKUI);
		registerItem(KEIRYUKUI_b);
		registerItem(TRUSS_item);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}
	/*ここまで So far↑ */


	/* ドロップ時やインベントリにおける, アイテムやアイテムブロックの描画を登録。ここから↓
	* Register rendering of Items and ItemBlocks in drop and inventory. From here↓*/
	public static void registerRenders() {

		registerRender(EMBLEM_C);
		registerRender(ADMIRAL_STAMP);
		registerRender(ADMIRAL_STAMP_B);
		registerRender(WORK_ORDER);
		registerRender(REPORT_BOX);
		registerRender(SHOUHOU_empty);
		registerRender(SHOUHOU);
		
		registerRender(BAUXITE);
		registerRender(ALUMINUM);
		registerRender(SUMI);

		registerRender(BAUXITE_ORE);
		registerRender(OIL_DRUM);
		registerRender(EMPTY_BOX);
		registerRenderMeta(AMUBAUX, 1, "block_ammunition_box");
		registerRenderMeta(AMUBAUX, 2, "block_bauxite_box");
		registerRenderMeta(ALUMI, 1, "block_alumi_block");
		registerRenderMeta(ALUMI, 2, "block_steel_block");
		registerRenderMeta(ALUMI, 3, "block_gold_block");
		registerRender(B_ADMIRAL_STAMP);

		registerRenderMeta(DRESSINGTABLE_item, 0, "block_dressingtable");
		registerRenderMeta(DRESSINGTABLE_item, 1, "block_dressingtable_s");
		registerRenderMeta(DRESSINGTABLE_item, 2, "block_dressingtable_b");
		registerRenderMeta(DRESSINGTABLE_item, 3, "block_dressingtable_j");
		registerRenderMeta(DRESSINGTABLE_item, 4, "block_dressingtable_a");
		registerRenderMeta(DRESSINGTABLE_item, 5, "block_dressingtable_d");
		registerRenderMeta(DRESSINGTABLE_item, 6, "block_dressingtable_saku");
		registerRenderMeta(DRESSINGTABLE_item, 7, "block_dressingtable_kae");
		registerRenderMeta(DRESSINGTABLE_item, 8, "block_dressingtable_ich");

		registerRenderMeta(UNITDESK_item, 0, "block_unitdesk");
		registerRenderMeta(UNITDESK_item, 1, "block_unitdesk_spruce");
		registerRenderMeta(UNITDESK_item, 2, "block_unitdesk_birch");
		registerRenderMeta(UNITDESK_item, 3, "block_unitdesk_jungle");
		registerRenderMeta(UNITDESK_item, 4, "block_unitdesk_acacia");
		registerRenderMeta(UNITDESK_item, 5, "block_unitdesk_darkoak");
		registerRenderMeta(UNITDESK_item, 6, "block_unitdesk_sakura");
		registerRenderMeta(UNITDESK_item, 7, "block_unitdesk_kaede");
		registerRenderMeta(UNITDESK_item, 8, "block_unitdesk_ichoh");

		registerRenderMeta(CAFETABLE_item, 0, "block_cafetable");
		registerRenderMeta(CAFETABLE_item, 1, "block_cafetable_spruce");
		registerRenderMeta(CAFETABLE_item, 2, "block_cafetable_birch");
		registerRenderMeta(CAFETABLE_item, 3, "block_cafetable_jungle");
		registerRenderMeta(CAFETABLE_item, 4, "block_cafetable_acacia");
		registerRenderMeta(CAFETABLE_item, 5, "block_cafetable_darkoak");
		registerRenderMeta(CAFETABLE_item, 6, "block_cafetable_sakura");
		registerRenderMeta(CAFETABLE_item, 7, "block_cafetable_kaede");
		registerRenderMeta(CAFETABLE_item, 8, "block_cafetable_ichoh");

		registerRenderMeta(DININGCHAIR_item, 0, "block_diningchair");
		registerRenderMeta(DININGCHAIR_item, 1, "block_diningchair_s");
		registerRenderMeta(DININGCHAIR_item, 2, "block_diningchair_b");
		registerRenderMeta(DININGCHAIR_item, 3, "block_diningchair_j");
		registerRenderMeta(DININGCHAIR_item, 4, "block_diningchair_a");
		registerRenderMeta(DININGCHAIR_item, 5, "block_diningchair_d");
		registerRenderMeta(DININGCHAIR_item, 6, "block_diningchair_saku");
		registerRenderMeta(DININGCHAIR_item, 7, "block_diningchair_kae");
		registerRenderMeta(DININGCHAIR_item, 8, "block_diningchair_ich");

		registerRenderMeta(LOGCHAIR_item, 0, "block_logchair");
		registerRenderMeta(LOGCHAIR_item, 1, "block_logchair_spruce");
		registerRenderMeta(LOGCHAIR_item, 2, "block_logchair_birch");
		registerRenderMeta(LOGCHAIR_item, 3, "block_logchair_jungle");
		registerRenderMeta(LOGCHAIR_item, 4, "block_logchair_acacia");
		registerRenderMeta(LOGCHAIR_item, 5, "block_logchair_darkoak");
		registerRenderMeta(LOGCHAIR_item, 6, "block_logchair_sakura");
		registerRenderMeta(LOGCHAIR_item, 7, "block_logchair_kaede");
		registerRenderMeta(LOGCHAIR_item, 8, "block_logchair_ichoh");

		registerRenderMeta(CAFECHAIR_item, 0, "block_cafechair_white");
		registerRenderMeta(CAFECHAIR_item, 1, "block_cafechair_orange");
		registerRenderMeta(CAFECHAIR_item, 2, "block_cafechair_magenta");
		registerRenderMeta(CAFECHAIR_item, 3, "block_cafechair_lightb");
		registerRenderMeta(CAFECHAIR_item, 4, "block_cafechair_yellow");
		registerRenderMeta(CAFECHAIR_item, 5, "block_cafechair_lime");
		registerRenderMeta(CAFECHAIR_item, 6, "block_cafechair_pink");
		registerRenderMeta(CAFECHAIR_item, 7, "block_cafechair_gray");
		registerRenderMeta(CAFECHAIR_item, 8, "block_cafechair_lightg");
		registerRenderMeta(CAFECHAIR_item, 9, "block_cafechair_cyan");
		registerRenderMeta(CAFECHAIR_item, 10, "block_cafechair_purple");
		registerRenderMeta(CAFECHAIR_item, 11, "block_cafechair_blue");
		registerRenderMeta(CAFECHAIR_item, 12, "block_cafechair_brown");
		registerRenderMeta(CAFECHAIR_item, 13, "block_cafechair_green");
		registerRenderMeta(CAFECHAIR_item, 14, "block_cafechair_red");
		registerRenderMeta(CAFECHAIR_item, 15, "block_cafechair_black");

		registerRenderMeta(BENCH_item, 0, "block_bench");
		registerRenderMeta(BENCH_item, 1, "block_bench_spru");
		registerRenderMeta(BENCH_item, 2, "block_bench_bir");
		registerRenderMeta(BENCH_item, 3, "block_bench_jun");
		registerRenderMeta(BENCH_item, 4, "block_bench_aca");
		registerRenderMeta(BENCH_item, 5, "block_bench_doak");
		registerRenderMeta(BENCH_item, 6, "block_bench_saku");
		registerRenderMeta(BENCH_item, 7, "block_bench_kae");
		registerRenderMeta(BENCH_item, 8, "block_bench_ich");
		registerRenderMeta(BENCH_item, 9, "block_sofa_leather");
		
		registerRenderMeta(SOFA_item, 0, "block_sofa_white");
		registerRenderMeta(SOFA_item, 1, "block_sofa_orange");
		registerRenderMeta(SOFA_item, 2, "block_sofa_magenta");
		registerRenderMeta(SOFA_item, 3, "block_sofa_lightblue");
		registerRenderMeta(SOFA_item, 4, "block_sofa_yellow");
		registerRenderMeta(SOFA_item, 5, "block_sofa_lime");
		registerRenderMeta(SOFA_item, 6, "block_sofa_pink");
		registerRenderMeta(SOFA_item, 7, "block_sofa_gray");
		registerRenderMeta(SOFA_item, 8, "block_sofa_lightgray");
		registerRenderMeta(SOFA_item, 9, "block_sofa_cyan");
		registerRenderMeta(SOFA_item, 10, "block_sofa_purple");
		registerRenderMeta(SOFA_item, 11, "block_sofa_blue");
		registerRenderMeta(SOFA_item, 12, "block_sofa_brown");
		registerRenderMeta(SOFA_item, 13, "block_sofa_green");
		registerRenderMeta(SOFA_item, 14, "block_sofa_red");
		registerRenderMeta(SOFA_item, 15, "block_sofa_black");

		registerRenderMeta(SCHOOLCHAIR_item, 0, "block_schoolchair");
		registerRenderMeta(SCHOOLCHAIR_item, 1, "block_schoolchair_s");
		registerRenderMeta(SCHOOLCHAIR_item, 2, "block_schoolchair_b");
		registerRenderMeta(SCHOOLCHAIR_item, 3, "block_schoolchair_j");
		registerRenderMeta(SCHOOLCHAIR_item, 4, "block_schoolchair_a");
		registerRenderMeta(SCHOOLCHAIR_item, 5, "block_schoolchair_d");
		registerRenderMeta(SCHOOLCHAIR_item, 6, "block_schoolchair_saku");
		registerRenderMeta(SCHOOLCHAIR_item, 7, "block_schoolchair_kae");
		registerRenderMeta(SCHOOLCHAIR_item, 8, "block_schoolchair_ich");

		registerRenderMeta(SCHOOLDESK_item, 0, "block_schooldesk");
		registerRenderMeta(SCHOOLDESK_item, 1, "block_schooldesk_s");
		registerRenderMeta(SCHOOLDESK_item, 2, "block_schooldesk_b");
		registerRenderMeta(SCHOOLDESK_item, 3, "block_schooldesk_j");
		registerRenderMeta(SCHOOLDESK_item, 4, "block_schooldesk_a");
		registerRenderMeta(SCHOOLDESK_item, 5, "block_schooldesk_d");
		registerRenderMeta(SCHOOLDESK_item, 6, "block_schooldesk_saku");
		registerRenderMeta(SCHOOLDESK_item, 7, "block_schooldesk_kae");
		registerRenderMeta(SCHOOLDESK_item, 8, "block_schooldesk_ich");

		registerRenderMeta(TEACHERDESK_item, 0, "block_teacherdesk");
		registerRenderMeta(TEACHERDESK_item, 1, "block_teacherdesk_s");
		registerRenderMeta(TEACHERDESK_item, 2, "block_teacherdesk_b");
		registerRenderMeta(TEACHERDESK_item, 3, "block_teacherdesk_j");
		registerRenderMeta(TEACHERDESK_item, 4, "block_teacherdesk_a");
		registerRenderMeta(TEACHERDESK_item, 5, "block_teacherdesk_d");
		registerRenderMeta(TEACHERDESK_item, 6, "block_teacherdesk_saku");
		registerRenderMeta(TEACHERDESK_item, 7, "block_teacherdesk_kae");
		registerRenderMeta(TEACHERDESK_item, 8, "block_teacherdesk_ich");

		registerRenderMeta(LOWDESK_item, 0, "block_lowdesk");
		registerRenderMeta(LOWDESK_item, 1, "block_lowdesk_spruce");
		registerRenderMeta(LOWDESK_item, 2, "block_lowdesk_birch");
		registerRenderMeta(LOWDESK_item, 3, "block_lowdesk_jungle");
		registerRenderMeta(LOWDESK_item, 4, "block_lowdesk_acacia");
		registerRenderMeta(LOWDESK_item, 5, "block_lowdesk_darkoak");
		registerRenderMeta(LOWDESK_item, 6, "block_lowdesk_sakura");
		registerRenderMeta(LOWDESK_item, 7, "block_lowdesk_kaede");
		registerRenderMeta(LOWDESK_item, 8, "block_lowdesk_ichoh");

		registerRenderMeta(LETTERTRAY, 1, "block_lettertray_c");
		registerRenderMeta(LETTERTRAY, 2, "block_fudetray_c");
		registerRender(BLACKBOARD);

		registerRenderMeta(WINDOW_item, 0, "block_window");
		registerRenderMeta(WINDOW_item, 1, "block_window_spruce");
		registerRenderMeta(WINDOW_item, 2, "block_window_birch");
		registerRenderMeta(WINDOW_item, 3, "block_window_jungle");
		registerRenderMeta(WINDOW_item, 4, "block_window_acacia");
		registerRenderMeta(WINDOW_item, 5, "block_window_darkoak");
		registerRenderMeta(WINDOW_item, 6, "block_window_sakura");
		registerRenderMeta(WINDOW_item, 7, "block_window_kaede");
		registerRenderMeta(WINDOW_item, 8, "block_window_ichoh");

		registerRenderMeta(WINDOWB_item, 0, "block_windowb");
		registerRenderMeta(WINDOWB_item, 1, "block_windowb_spruce");
		registerRenderMeta(WINDOWB_item, 2, "block_windowb_birch");
		registerRenderMeta(WINDOWB_item, 3, "block_windowb_jungle");
		registerRenderMeta(WINDOWB_item, 4, "block_windowb_acacia");
		registerRenderMeta(WINDOWB_item, 5, "block_windowb_darkoak");
		registerRenderMeta(WINDOWB_item, 6, "block_windowb_sakura");
		registerRenderMeta(WINDOWB_item, 7, "block_windowb_kaede");
		registerRenderMeta(WINDOWB_item, 8, "block_windowb_ichoh");

		registerRenderMeta(WINDOWTALLBOT_item, 0, "block_windowtallbot");
		registerRenderMeta(WINDOWTALLBOT_item, 1, "block_windowtallbot_spruce");
		registerRenderMeta(WINDOWTALLBOT_item, 2, "block_windowtallbot_birch");
		registerRenderMeta(WINDOWTALLBOT_item, 3, "block_windowtallbot_jungle");
		registerRenderMeta(WINDOWTALLBOT_item, 4, "block_windowtallbot_acacia");
		registerRenderMeta(WINDOWTALLBOT_item, 5, "block_windowtallbot_darkoak");
		registerRenderMeta(WINDOWTALLBOT_item, 6, "block_windowtallbot_sakura");
		registerRenderMeta(WINDOWTALLBOT_item, 7, "block_windowtallbot_kaede");
		registerRenderMeta(WINDOWTALLBOT_item, 8, "block_windowtallbot_ichoh");

		registerRenderMeta(WINDOWTALL_item, 0, "block_windowtall");
		registerRenderMeta(WINDOWTALL_item, 1, "block_windowtall_spruce");
		registerRenderMeta(WINDOWTALL_item, 2, "block_windowtall_birch");
		registerRenderMeta(WINDOWTALL_item, 3, "block_windowtall_jungle");
		registerRenderMeta(WINDOWTALL_item, 4, "block_windowtall_acacia");
		registerRenderMeta(WINDOWTALL_item, 5, "block_windowtall_darkoak");
		registerRenderMeta(WINDOWTALL_item, 6, "block_windowtall_sakura");
		registerRenderMeta(WINDOWTALL_item, 7, "block_windowtall_kaede");
		registerRenderMeta(WINDOWTALL_item, 8, "block_windowtall_ichoh");

		registerRenderMeta(CURTAIN_item, 0, "block_curtain_white");
		registerRenderMeta(CURTAIN_item, 1, "block_curtain_orange");
		registerRenderMeta(CURTAIN_item, 2, "block_curtain_magenta");
		registerRenderMeta(CURTAIN_item, 3, "block_curtain_lightblue");
		registerRenderMeta(CURTAIN_item, 4, "block_curtain_yellow");
		registerRenderMeta(CURTAIN_item, 5, "block_curtain_lime");
		registerRenderMeta(CURTAIN_item, 6, "block_curtain_pink");
		registerRenderMeta(CURTAIN_item, 7, "block_curtain_gray");
		registerRenderMeta(CURTAIN_item, 8, "block_curtain_lightgray");
		registerRenderMeta(CURTAIN_item, 9, "block_curtain_cyan");
		registerRenderMeta(CURTAIN_item, 10, "block_curtain_purple");
		registerRenderMeta(CURTAIN_item, 11, "block_curtain_blue");
		registerRenderMeta(CURTAIN_item, 12, "block_curtain_brown");
		registerRenderMeta(CURTAIN_item, 13, "block_curtain_green");
		registerRenderMeta(CURTAIN_item, 14, "block_curtain_red");
		registerRenderMeta(CURTAIN_item, 15, "block_curtain_black");

		registerRenderMeta(CURTAINTALL_item, 0, "block_curtaintall_white");
		registerRenderMeta(CURTAINTALL_item, 1, "block_curtaintall_orange");
		registerRenderMeta(CURTAINTALL_item, 2, "block_curtaintall_magenta");
		registerRenderMeta(CURTAINTALL_item, 3, "block_curtaintall_lightblue");
		registerRenderMeta(CURTAINTALL_item, 4, "block_curtaintall_yellow");
		registerRenderMeta(CURTAINTALL_item, 5, "block_curtaintall_lime");
		registerRenderMeta(CURTAINTALL_item, 6, "block_curtaintall_pink");
		registerRenderMeta(CURTAINTALL_item, 7, "block_curtaintall_gray");
		registerRenderMeta(CURTAINTALL_item, 8, "block_curtaintall_lightgray");
		registerRenderMeta(CURTAINTALL_item, 9, "block_curtaintall_cyan");
		registerRenderMeta(CURTAINTALL_item, 10, "block_curtaintall_purple");
		registerRenderMeta(CURTAINTALL_item, 11, "block_curtaintall_blue");
		registerRenderMeta(CURTAINTALL_item, 12, "block_curtaintall_brown");
		registerRenderMeta(CURTAINTALL_item, 13, "block_curtaintall_green");
		registerRenderMeta(CURTAINTALL_item, 14, "block_curtaintall_red");
		registerRenderMeta(CURTAINTALL_item, 15, "block_curtaintall_black");
		
		registerRenderMeta(CURTAINL1_item, 0, "block_curtainlarge_white");
		registerRenderMeta(CURTAINL1_item, 1, "block_curtainlarge_orange");
		registerRenderMeta(CURTAINL1_item, 2, "block_curtainlarge_magenta");
		registerRenderMeta(CURTAINL1_item, 3, "block_curtainlarge_lightblue");
		registerRenderMeta(CURTAINL1_item, 4, "block_curtainlarge_yellow");
		registerRenderMeta(CURTAINL1_item, 5, "block_curtainlarge_lime");
		registerRenderMeta(CURTAINL1_item, 6, "block_curtainlarge_pink");
		registerRenderMeta(CURTAINL1_item, 7, "block_curtainlarge_gray");
		registerRenderMeta(CURTAINL1_item, 8, "block_curtainlarge_lightgray");
		registerRenderMeta(CURTAINL1_item, 9, "block_curtainlarge_cyan");
		registerRenderMeta(CURTAINL1_item, 10, "block_curtainlarge_purple");
		registerRenderMeta(CURTAINL1_item, 11, "block_curtainlarge_blue");
		registerRenderMeta(CURTAINL1_item, 12, "block_curtainlarge_brown");
		registerRenderMeta(CURTAINL1_item, 13, "block_curtainlarge_green");
		registerRenderMeta(CURTAINL1_item, 14, "block_curtainlarge_red");
		registerRenderMeta(CURTAINL1_item, 15, "block_curtainlarge_black");
		
		registerRender(STOVECHIMNEY);
		registerRender(STOVECHIMNEY_joint);
		registerRender(STOVECHIMNEY_topk);
		registerRender(CSTOVE_bot);

		registerRenderMeta(CANDLE_item, 0, "block_candle_white");
		registerRenderMeta(CANDLE_item, 1, "block_candle_orange");
		registerRenderMeta(CANDLE_item, 2, "block_candle_magenta");
		registerRenderMeta(CANDLE_item, 3, "block_candle_lightb");
		registerRenderMeta(CANDLE_item, 4, "block_candle_yellow");
		registerRenderMeta(CANDLE_item, 5, "block_candle_lime");
		registerRenderMeta(CANDLE_item, 6, "block_candle_pink");
		registerRenderMeta(CANDLE_item, 7, "block_candle_gray");
		registerRenderMeta(CANDLE_item, 8, "block_candle_lightg");
		registerRenderMeta(CANDLE_item, 9, "block_candle_cyan");
		registerRenderMeta(CANDLE_item, 10, "block_candle_purple");
		registerRenderMeta(CANDLE_item, 11, "block_candle_blue");
		registerRenderMeta(CANDLE_item, 12, "block_candle_brown");
		registerRenderMeta(CANDLE_item, 13, "block_candle_green");
		registerRenderMeta(CANDLE_item, 14, "block_candle_red");
		registerRenderMeta(CANDLE_item, 15, "block_candle_black");

		registerRender(LAMP);
		registerRender(STANDARM);
		registerRender(STAND);
		registerRender(M_LAMP);
		registerRender(E_LIGHT);
		
		registerRenderMeta(ADMIRALCHAIR, 1, "block_admiralchair");
		registerRenderMeta(ADMIRALCHAIR, 2, "block_admiralchair_red");
		registerRenderMeta(TANSU, 0, "block_tansu_oak");
		registerRenderMeta(TANSU, 1, "block_tansu_spruce");
		registerRenderMeta(TANSU, 2, "block_tansu_birch");
		registerRenderMeta(TANSU, 3, "block_tansu_jungle");
		registerRenderMeta(TANSU, 4, "block_tansu_acacia");
		registerRenderMeta(TANSU, 5, "block_tansu_doak");
		registerRenderMeta(TANSU, 6, "block_tansu_sakura");
		registerRenderMeta(TANSU, 7, "block_tansu_kaede");
		registerRenderMeta(TANSU, 8, "block_tansu_ichoh");

		registerRender(KEIKAIBLOCK);
		registerRender(KEIRYUKUI);
		registerRender(KEIRYUKUI_b);

		registerRenderMeta(TRUSS_item, 0, "block_ctruss_white");
		registerRenderMeta(TRUSS_item, 1, "block_ctruss_orange");
		registerRenderMeta(TRUSS_item, 2, "block_ctruss_magenta");
		registerRenderMeta(TRUSS_item, 3, "block_ctruss_lightb");
		registerRenderMeta(TRUSS_item, 4, "block_ctruss_yellow");
		registerRenderMeta(TRUSS_item, 5, "block_ctruss_lime");
		registerRenderMeta(TRUSS_item, 6, "block_ctruss_pink");
		registerRenderMeta(TRUSS_item, 7, "block_ctruss_gray");
		registerRenderMeta(TRUSS_item, 8, "block_ctruss");
		registerRenderMeta(TRUSS_item, 9, "block_ctruss_cyan");
		registerRenderMeta(TRUSS_item, 10, "block_ctruss_purple");
		registerRenderMeta(TRUSS_item, 11, "block_ctruss_blue");
		registerRenderMeta(TRUSS_item, 12, "block_ctruss_brown");
		registerRenderMeta(TRUSS_item, 13, "block_ctruss_green");
		registerRenderMeta(TRUSS_item, 14, "block_ctruss_red");
		registerRenderMeta(TRUSS_item, 15, "block_ctruss_black");
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}
	/*ここまで So far↑ */
}
