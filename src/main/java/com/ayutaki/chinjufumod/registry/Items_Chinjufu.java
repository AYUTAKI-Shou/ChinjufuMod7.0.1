package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.items.addinfo.AddInfo_Item;
import com.ayutaki.chinjufumod.items.fuel.Chinjufu_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.Chinjufu_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.Chinjufu_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.Chinjufu_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.Chinjufu_Fuel7200;
import com.ayutaki.chinjufumod.items.fuel.Chinjufu_noFuel;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.items.fuel.NoGroup_noFuel;
import com.ayutaki.chinjufumod.items.weapon.AdmiralStamp;
import com.ayutaki.chinjufumod.items.weapon.Shouhou;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Chinjufu {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* Chinjufu */
	public static Item ADMIRAL_STAMPB = register("item_admiralstamp_b", new AdmiralStamp(ChinjufuMod_Blocks.I_ADMIRAL_STAMP, new Item.Properties().durability(16).tab(ItemGroups_CM.CHINJUFU)));
	public static Item WORK_ORDER = register("item_workorder", new Item(new Item.Properties().tab(ItemGroups_CM.CHINJUFU)));
	public static Item REPORT_BOX = register("block_report_box", new Chinjufu_noFuel(ChinjufuMod_Blocks.REPORT_BOX, new Item.Properties()));
	
	public static Item SHOUHOU_empty = register("item_shouhou_empty", new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.CHINJUFU)));
	public static Item SHOUHOU = register("item_shouhou", new Shouhou(new Item.Properties()));

	public static Item BAUXITE = register("item_bauxite", new Item(new Item.Properties().tab(ItemGroups_CM.CHINJUFU)));
	public static Item ALUMINUM = register("item_ingot_alumi", new Item(new Item.Properties().tab(ItemGroups_CM.CHINJUFU)));
	public static Item SUMI = register("item_sumi_c", new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.CHINJUFU)));

	public static Item BAUXITE_ORE = register("block_bauxite_ore", new Chinjufu_noFuel(ChinjufuMod_Blocks.BAUXITE_ORE, new Item.Properties()));

	public static Item OIL_DRUM = register("block_fuel_can", new Chinjufu_Fuel7200(ChinjufuMod_Blocks.OIL_DRUM, new Item.Properties()));
	public static Item EMPTY_BOX = register("block_empty_box", new Chinjufu_Fuel100(ChinjufuMod_Blocks.EMPTY_BOX, new Item.Properties()));
	public static Item AMMOBOX = register("block_ammunition_box", new Chinjufu_noFuel(ChinjufuMod_Blocks.AMMOBOX, new Item.Properties()));
	public static Item BAUXITE_BOX = register("block_bauxite_box", new Chinjufu_noFuel(ChinjufuMod_Blocks.BAUXITE_BOX, new Item.Properties()));
	public static Item ALUMI_BLOCK = register("block_alumi_block", new Chinjufu_noFuel(ChinjufuMod_Blocks.ALUMI_BLOCK, new Item.Properties()));
	public static Item STEEL_BLOCK = register("block_steel_block", new Chinjufu_noFuel(ChinjufuMod_Blocks.STEEL_BLOCK, new Item.Properties()));
	public static Item GOLD_BLOCK = register("block_gold_block", new Chinjufu_noFuel(ChinjufuMod_Blocks.GOLD_BLOCK, new Item.Properties()));
	public static Item NETHERITE_BLOCK = register("block_netherite_block", new Chinjufu_noFuel(ChinjufuMod_Blocks.NETHERITE_BLOCK, new Item.Properties()));
	public static Item B_ADMIRAL_STAMP = register("block_stamp_block", new NoGroup_noFuel(ChinjufuMod_Blocks.B_ADMIRAL_STAMP, new Item.Properties()));

	public static Item DRESSINGTABLE = register("block_dressingtable", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE, new Item.Properties()));
	public static Item DRESSINGTABLE_spruce = register("block_dressingtable_s", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_spruce, new Item.Properties()));
	public static Item DRESSINGTABLE_birch = register("block_dressingtable_b", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_birch, new Item.Properties()));
	public static Item DRESSINGTABLE_jungle = register("block_dressingtable_j", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_jungle, new Item.Properties()));
	public static Item DRESSINGTABLE_acacia = register("block_dressingtable_a", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_acacia, new Item.Properties()));
	public static Item DRESSINGTABLE_darkoak = register("block_dressingtable_d", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_darkoak, new Item.Properties()));
	public static Item DRESSINGTABLE_sakura = register("block_dressingtable_saku", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_sakura, new Item.Properties()));
	public static Item DRESSINGTABLE_kaede = register("block_dressingtable_kae", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_kaede, new Item.Properties()));
	public static Item DRESSINGTABLE_ichoh = register("block_dressingtable_ich", new Chinjufu_noFuel(Furniture_Blocks.DRESSINGTABLE_ichoh, new Item.Properties()));

	public static Item UNITDESK = register("block_unitdesk", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK, new Item.Properties()));
	public static Item UNITDESK_spruce = register("block_unitdesk_spruce", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_spruce, new Item.Properties()));
	public static Item UNITDESK_birch = register("block_unitdesk_birch", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_birch, new Item.Properties()));
	public static Item UNITDESK_jungle = register("block_unitdesk_jungle", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_jungle, new Item.Properties()));
	public static Item UNITDESK_acacia = register("block_unitdesk_acacia", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_acacia, new Item.Properties()));
	public static Item UNITDESK_darkoak = register("block_unitdesk_darkoak", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_darkoak, new Item.Properties()));
	public static Item UNITDESK_sakura = register("block_unitdesk_sakura", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_sakura, new Item.Properties()));
	public static Item UNITDESK_kaede = register("block_unitdesk_kaede", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_kaede, new Item.Properties()));
	public static Item UNITDESK_ichoh = register("block_unitdesk_ichoh", new Chinjufu_Fuel300(Unit_Blocks.UNITDESK_ichoh, new Item.Properties()));

	public static Item CAFETABLE = register("block_cafetable", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE, new Item.Properties()));
	public static Item CAFETABLE_spruce = register("block_cafetable_spruce", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_spruce, new Item.Properties()));
	public static Item CAFETABLE_birch = register("block_cafetable_birch", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_birch, new Item.Properties()));
	public static Item CAFETABLE_jungle = register("block_cafetable_jungle", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_jungle, new Item.Properties()));
	public static Item CAFETABLE_acacia = register("block_cafetable_acacia", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_acacia, new Item.Properties()));
	public static Item CAFETABLE_darkoak = register("block_cafetable_darkoak", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_darkoak, new Item.Properties()));
	public static Item CAFETABLE_sakura = register("block_cafetable_sakura", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_sakura, new Item.Properties()));
	public static Item CAFETABLE_kaede = register("block_cafetable_kaede", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_kaede, new Item.Properties()));
	public static Item CAFETABLE_ichoh = register("block_cafetable_ichoh", new Chinjufu_Fuel300(Unit_Blocks.CAFETABLE_ichoh, new Item.Properties()));

	public static Item DININGCHAIR = register("block_diningchair", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR, new Item.Properties()));
	public static Item DININGCHAIR_spruce = register("block_diningchair_s", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_spruce, new Item.Properties()));
	public static Item DININGCHAIR_birch = register("block_diningchair_b", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_birch, new Item.Properties()));
	public static Item DININGCHAIR_jungle = register("block_diningchair_j", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_jungle, new Item.Properties()));
	public static Item DININGCHAIR_acacia = register("block_diningchair_a", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_acacia, new Item.Properties()));
	public static Item DININGCHAIR_darkoak = register("block_diningchair_d", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_darkoak, new Item.Properties()));
	public static Item DININGCHAIR_sakura = register("block_diningchair_saku", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_sakura, new Item.Properties()));
	public static Item DININGCHAIR_kaede = register("block_diningchair_kae", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_kaede, new Item.Properties()));
	public static Item DININGCHAIR_ichoh = register("block_diningchair_ich", new Chinjufu_Fuel150(Chair_Blocks.DININGCHAIR_ichoh, new Item.Properties()));

	public static Item LOGCHAIR = register("block_logchair", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR, new Item.Properties()));
	public static Item LOGCHAIR_spruce = register("block_logchair_spruce", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_spruce, new Item.Properties()));
	public static Item LOGCHAIR_birch = register("block_logchair_birch", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_birch, new Item.Properties()));
	public static Item LOGCHAIR_jungle = register("block_logchair_jungle", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_jungle, new Item.Properties()));
	public static Item LOGCHAIR_acacia = register("block_logchair_acacia", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_acacia, new Item.Properties()));
	public static Item LOGCHAIR_darkoak = register("block_logchair_darkoak", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_darkoak, new Item.Properties()));
	public static Item LOGCHAIR_sakura = register("block_logchair_sakura", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_sakura, new Item.Properties()));
	public static Item LOGCHAIR_kaede = register("block_logchair_kaede", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_kaede, new Item.Properties()));
	public static Item LOGCHAIR_ichoh = register("block_logchair_ichoh", new Chinjufu_Fuel150(Chair_Blocks.LOGCHAIR_ichoh, new Item.Properties()));

	public static Item CAFECHAIR_white = register("block_cafechair_white", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_white, new Item.Properties()));
	public static Item CAFECHAIR_orange = register("block_cafechair_orange", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_orange, new Item.Properties()));
	public static Item CAFECHAIR_magenta = register("block_cafechair_magenta", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_magenta, new Item.Properties()));
	public static Item CAFECHAIR_lightb = register("block_cafechair_lightb", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_lightb, new Item.Properties()));
	public static Item CAFECHAIR_yellow = register("block_cafechair_yellow", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_yellow, new Item.Properties()));
	public static Item CAFECHAIR_lime = register("block_cafechair_lime", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_lime, new Item.Properties()));
	public static Item CAFECHAIR_pink = register("block_cafechair_pink", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_pink, new Item.Properties()));
	public static Item CAFECHAIR_gray = register("block_cafechair_gray", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_gray, new Item.Properties()));
	public static Item CAFECHAIR_lightg = register("block_cafechair_lightg", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_lightg, new Item.Properties()));
	public static Item CAFECHAIR_cyan = register("block_cafechair_cyan", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_cyan, new Item.Properties()));
	public static Item CAFECHAIR_purple = register("block_cafechair_purple", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_purple, new Item.Properties()));
	public static Item CAFECHAIR_blue = register("block_cafechair_blue", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_blue, new Item.Properties()));
	public static Item CAFECHAIR_brown = register("block_cafechair_brown", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_brown, new Item.Properties()));
	public static Item CAFECHAIR_green = register("block_cafechair_green", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_green, new Item.Properties()));
	public static Item CAFECHAIR_red = register("block_cafechair_red", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_red, new Item.Properties()));
	public static Item CAFECHAIR_black = register("block_cafechair_black", new Chinjufu_Fuel150(Chair_Blocks.CAFECHAIR_black, new Item.Properties()));

	public static Item SOFA_leather = register("block_sofa_leather", new Chinjufu_Fuel150(Chair_Blocks.SOFA_leather, new Item.Properties()));
	public static Item SOFA_white = register("block_sofa_white", new Chinjufu_Fuel150(Chair_Blocks.SOFA_white, new Item.Properties()));
	public static Item SOFA_orange = register("block_sofa_orange", new Chinjufu_Fuel150(Chair_Blocks.SOFA_orange, new Item.Properties()));
	public static Item SOFA_magenta = register("block_sofa_magenta", new Chinjufu_Fuel150(Chair_Blocks.SOFA_magenta, new Item.Properties()));
	public static Item SOFA_lightb = register("block_sofa_lightblue", new Chinjufu_Fuel150(Chair_Blocks.SOFA_lightb, new Item.Properties()));
	public static Item SOFA_yellow = register("block_sofa_yellow", new Chinjufu_Fuel150(Chair_Blocks.SOFA_yellow, new Item.Properties()));
	public static Item SOFA_lime = register("block_sofa_lime", new Chinjufu_Fuel150(Chair_Blocks.SOFA_lime, new Item.Properties()));
	public static Item SOFA_pink = register("block_sofa_pink", new Chinjufu_Fuel150(Chair_Blocks.SOFA_pink, new Item.Properties()));
	public static Item SOFA_gray = register("block_sofa_gray", new Chinjufu_Fuel150(Chair_Blocks.SOFA_gray, new Item.Properties()));
	public static Item SOFA_lightg = register("block_sofa_lightgray", new Chinjufu_Fuel150(Chair_Blocks.SOFA_lightg, new Item.Properties()));
	public static Item SOFA_cyan = register("block_sofa_cyan", new Chinjufu_Fuel150(Chair_Blocks.SOFA_cyan, new Item.Properties()));
	public static Item SOFA_purple = register("block_sofa_purple", new Chinjufu_Fuel150(Chair_Blocks.SOFA_purple, new Item.Properties()));
	public static Item SOFA_blue = register("block_sofa_blue", new Chinjufu_Fuel150(Chair_Blocks.SOFA_blue, new Item.Properties()));
	public static Item SOFA_brown = register("block_sofa_brown", new Chinjufu_Fuel150(Chair_Blocks.SOFA_brown, new Item.Properties()));
	public static Item SOFA_green = register("block_sofa_green", new Chinjufu_Fuel150(Chair_Blocks.SOFA_green, new Item.Properties()));
	public static Item SOFA_red = register("block_sofa_red", new Chinjufu_Fuel150(Chair_Blocks.SOFA_red, new Item.Properties()));
	public static Item SOFA_black = register("block_sofa_black", new Chinjufu_Fuel150(Chair_Blocks.SOFA_black, new Item.Properties()));

	public static Item BENCH = register("block_bench", new Chinjufu_Fuel150(Chair_Blocks.BENCH, new Item.Properties()));
	public static Item BENCH_spru = register("block_bench_spru", new Chinjufu_Fuel150(Chair_Blocks.BENCH_spruce, new Item.Properties()));
	public static Item BENCH_bir = register("block_bench_bir", new Chinjufu_Fuel150(Chair_Blocks.BENCH_birch, new Item.Properties()));
	public static Item BENCH_jun = register("block_bench_jun", new Chinjufu_Fuel150(Chair_Blocks.BENCH_jungle, new Item.Properties()));
	public static Item BENCH_aca = register("block_bench_aca", new Chinjufu_Fuel150(Chair_Blocks.BENCH_acacia, new Item.Properties()));
	public static Item BENCH_doak = register("block_bench_doak", new Chinjufu_Fuel150(Chair_Blocks.BENCH_darkoak, new Item.Properties()));
	public static Item BENCH_sakura = register("block_bench_saku", new Chinjufu_Fuel150(Chair_Blocks.BENCH_sakura, new Item.Properties()));
	public static Item BENCH_kaede = register("block_bench_kae", new Chinjufu_Fuel150(Chair_Blocks.BENCH_kaede, new Item.Properties()));
	public static Item BENCH_ichoh = register("block_bench_ich", new Chinjufu_Fuel150(Chair_Blocks.BENCH_ichoh, new Item.Properties()));

	public static Item SCHOOLCHAIR = register("block_schoolchair", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR, new Item.Properties()));
	public static Item SCHOOLCHAIR_spruce = register("block_schoolchair_s", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_spruce, new Item.Properties()));
	public static Item SCHOOLCHAIR_birch = register("block_schoolchair_b", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_birch, new Item.Properties()));
	public static Item SCHOOLCHAIR_jungle = register("block_schoolchair_j", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_jungle, new Item.Properties()));
	public static Item SCHOOLCHAIR_acacia = register("block_schoolchair_a", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_acacia, new Item.Properties()));
	public static Item SCHOOLCHAIR_darkoak = register("block_schoolchair_d", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_darkoak, new Item.Properties()));
	public static Item SCHOOLCHAIR_sakura = register("block_schoolchair_saku", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_sakura, new Item.Properties()));
	public static Item SCHOOLCHAIR_kaede = register("block_schoolchair_kae", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_kaede, new Item.Properties()));
	public static Item SCHOOLCHAIR_ichoh = register("block_schoolchair_ich", new Chinjufu_Fuel150(School_Blocks.SCHOOLCHAIR_ichoh, new Item.Properties()));

	public static Item SCHOOLDESK = register("block_schooldesk", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK, new Item.Properties()));
	public static Item SCHOOLDESK_spruce = register("block_schooldesk_s", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_spruce, new Item.Properties()));
	public static Item SCHOOLDESK_birch = register("block_schooldesk_b", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_birch, new Item.Properties()));
	public static Item SCHOOLDESK_jungle = register("block_schooldesk_j", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_jungle, new Item.Properties()));
	public static Item SCHOOLDESK_acacia = register("block_schooldesk_a", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_acacia, new Item.Properties()));
	public static Item SCHOOLDESK_darkoak = register("block_schooldesk_d", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_darkoak, new Item.Properties()));
	public static Item SCHOOLDESK_sakura = register("block_schooldesk_saku", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_sakura, new Item.Properties()));
	public static Item SCHOOLDESK_kaede = register("block_schooldesk_kae", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_kaede, new Item.Properties()));
	public static Item SCHOOLDESK_ichoh = register("block_schooldesk_ich", new Chinjufu_Fuel200(School_Blocks.SCHOOLDESK_ichoh, new Item.Properties()));

	public static Item TEACHERDESK = register("block_teacherdesk", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK, new Item.Properties()));
	public static Item TEACHERDESK_spruce = register("block_teacherdesk_s", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_spruce, new Item.Properties()));
	public static Item TEACHERDESK_birch = register("block_teacherdesk_b", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_birch, new Item.Properties()));
	public static Item TEACHERDESK_jungle = register("block_teacherdesk_j", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_jungle, new Item.Properties()));
	public static Item TEACHERDESK_acacia = register("block_teacherdesk_a", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_acacia, new Item.Properties()));
	public static Item TEACHERDESK_darkoak = register("block_teacherdesk_d", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_darkoak, new Item.Properties()));
	public static Item TEACHERDESK_sakura = register("block_teacherdesk_saku", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_sakura, new Item.Properties()));
	public static Item TEACHERDESK_kaede = register("block_teacherdesk_kae", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_kaede, new Item.Properties()));
	public static Item TEACHERDESK_ichoh = register("block_teacherdesk_ich", new Chinjufu_Fuel300(School_Blocks.TEACHERDESK_ichoh, new Item.Properties()));

	public static Item LOWDESK = register("block_lowdesk", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK, new Item.Properties()));
	public static Item LOWDESK_spruce = register("block_lowdesk_spruce", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_spruce, new Item.Properties()));
	public static Item LOWDESK_birch = register("block_lowdesk_birch", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_birch, new Item.Properties()));
	public static Item LOWDESK_jungle = register("block_lowdesk_jungle", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_jungle, new Item.Properties()));
	public static Item LOWDESK_acacia = register("block_lowdesk_acacia", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_acacia, new Item.Properties()));
	public static Item LOWDESK_darkoak = register("block_lowdesk_darkoak", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_darkoak, new Item.Properties()));
	public static Item LOWDESK_sakura = register("block_lowdesk_sakura", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_sakura, new Item.Properties()));
	public static Item LOWDESK_kaede = register("block_lowdesk_kaede", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_kaede, new Item.Properties()));
	public static Item LOWDESK_ichoh = register("block_lowdesk_ichoh", new Chinjufu_Fuel150(Unit_Blocks.LOWDESK_ichoh, new Item.Properties()));

	public static Item LETTERTRAY = register("block_lettertray_c", new Chinjufu_noFuel(Unit_Blocks.LETTERTRAY, new Item.Properties()));
	public static Item FUDETRAY = register("block_fudetray_c", new Chinjufu_noFuel(Unit_Blocks.FUDETRAY, new Item.Properties()));
	public static Item BLACKBOARD = register("block_blackboard", new Chinjufu_noFuel(School_Blocks.BLACKBOARD, new Item.Properties()));

	public static Item WINDOW_oak = register("block_window", new Chinjufu_noFuel(Window_Blocks.WINDOW_oak, new Item.Properties()));
	public static Item WINDOW_spruce = register("block_window_spruce", new Chinjufu_noFuel(Window_Blocks.WINDOW_spruce, new Item.Properties()));
	public static Item WINDOW_birch = register("block_window_birch", new Chinjufu_noFuel(Window_Blocks.WINDOW_birch, new Item.Properties()));
	public static Item WINDOW_jungle = register("block_window_jungle", new Chinjufu_noFuel(Window_Blocks.WINDOW_jungle, new Item.Properties()));
	public static Item WINDOW_acacia = register("block_window_acacia", new Chinjufu_noFuel(Window_Blocks.WINDOW_acacia, new Item.Properties()));
	public static Item WINDOW_darkoak = register("block_window_darkoak", new Chinjufu_noFuel(Window_Blocks.WINDOW_darkoak, new Item.Properties()));
	public static Item WINDOW_sakura = register("block_window_sakura", new Chinjufu_noFuel(Window_Blocks.WINDOW_sakura, new Item.Properties()));
	public static Item WINDOW_kaede = register("block_window_kaede", new Chinjufu_noFuel(Window_Blocks.WINDOW_kaede, new Item.Properties()));
	public static Item WINDOW_ichoh = register("block_window_ichoh", new Chinjufu_noFuel(Window_Blocks.WINDOW_ichoh, new Item.Properties()));

	public static Item WINDOWB_oak = register("block_windowb", new Chinjufu_noFuel(Window_Blocks.WINDOWB_oak, new Item.Properties()));
	public static Item WINDOWB_spruce = register("block_windowb_spruce", new Chinjufu_noFuel(Window_Blocks.WINDOWB_spruce, new Item.Properties()));
	public static Item WINDOWB_birch = register("block_windowb_birch", new Chinjufu_noFuel(Window_Blocks.WINDOWB_birch, new Item.Properties()));
	public static Item WINDOWB_jungle = register("block_windowb_jungle", new Chinjufu_noFuel(Window_Blocks.WINDOWB_jungle, new Item.Properties()));
	public static Item WINDOWB_acacia = register("block_windowb_acacia", new Chinjufu_noFuel(Window_Blocks.WINDOWB_acacia, new Item.Properties()));
	public static Item WINDOWB_darkoak = register("block_windowb_darkoak", new Chinjufu_noFuel(Window_Blocks.WINDOWB_darkoak, new Item.Properties()));
	public static Item WINDOWB_sakura = register("block_windowb_sakura", new Chinjufu_noFuel(Window_Blocks.WINDOWB_sakura, new Item.Properties()));
	public static Item WINDOWB_kaede = register("block_windowb_kaede", new Chinjufu_noFuel(Window_Blocks.WINDOWB_kaede, new Item.Properties()));
	public static Item WINDOWB_ichoh = register("block_windowb_ichoh", new Chinjufu_noFuel(Window_Blocks.WINDOWB_ichoh, new Item.Properties()));

	public static Item WINDOWTALLBOT_oak = register("block_windowtallbot", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_oak, new Item.Properties()));
	public static Item WINDOWTALLBOT_spruce = register("block_windowtallbot_spruce", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_spruce, new Item.Properties()));
	public static Item WINDOWTALLBOT_birch = register("block_windowtallbot_birch", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_birch, new Item.Properties()));
	public static Item WINDOWTALLBOT_jungle = register("block_windowtallbot_jungle", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_jungle, new Item.Properties()));
	public static Item WINDOWTALLBOT_acacia = register("block_windowtallbot_acacia", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_acacia, new Item.Properties()));
	public static Item WINDOWTALLBOT_darkoak = register("block_windowtallbot_darkoak", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_darkoak, new Item.Properties()));
	public static Item WINDOWTALLBOT_sakura = register("block_windowtallbot_sakura", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_sakura, new Item.Properties()));
	public static Item WINDOWTALLBOT_kaede = register("block_windowtallbot_kaede", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_kaede, new Item.Properties()));
	public static Item WINDOWTALLBOT_ichoh = register("block_windowtallbot_ichoh", new Chinjufu_noFuel(Window_Blocks.WINDOWTALLBOT_ichoh, new Item.Properties()));

	public static Item WINDOWTALL_oak = register("block_windowtall", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_oak, new Item.Properties()));
	public static Item WINDOWTALL_spruce = register("block_windowtall_spruce", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_spruce, new Item.Properties()));
	public static Item WINDOWTALL_birch = register("block_windowtall_birch", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_birch, new Item.Properties()));
	public static Item WINDOWTALL_jungle = register("block_windowtall_jungle", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_jungle, new Item.Properties()));
	public static Item WINDOWTALL_acacia = register("block_windowtall_acacia", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_acacia, new Item.Properties()));
	public static Item WINDOWTALL_darkoak = register("block_windowtall_darkoak", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_darkoak, new Item.Properties()));
	public static Item WINDOWTALL_sakura = register("block_windowtall_sakura", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_sakura, new Item.Properties()));
	public static Item WINDOWTALL_kaede = register("block_windowtall_kaede", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_kaede, new Item.Properties()));
	public static Item WINDOWTALL_ichoh = register("block_windowtall_ichoh", new Chinjufu_noFuel(Window_Blocks.WINDOWTALL_ichoh, new Item.Properties()));

	public static Item CURTAIN_white = register("block_curtain_white", new ItemCurtain(Window_Blocks.CURTAIN_white, new Item.Properties()));
	public static Item CURTAIN_orange = register("block_curtain_orange", new ItemCurtain(Window_Blocks.CURTAIN_orange, new Item.Properties()));
	public static Item CURTAIN_magenta = register("block_curtain_magenta", new ItemCurtain(Window_Blocks.CURTAIN_magenta, new Item.Properties()));
	public static Item CURTAIN_lightblue = register("block_curtain_lightblue", new ItemCurtain(Window_Blocks.CURTAIN_lightblue, new Item.Properties()));
	public static Item CURTAIN_yellow = register("block_curtain_yellow", new ItemCurtain(Window_Blocks.CURTAIN_yellow, new Item.Properties()));
	public static Item CURTAIN_lime = register("block_curtain_lime", new ItemCurtain(Window_Blocks.CURTAIN_lime, new Item.Properties()));
	public static Item CURTAIN_pink = register("block_curtain_pink", new ItemCurtain(Window_Blocks.CURTAIN_pink, new Item.Properties()));
	public static Item CURTAIN_gray = register("block_curtain_gray", new ItemCurtain(Window_Blocks.CURTAIN_gray, new Item.Properties()));
	public static Item CURTAIN_lightgray = register("block_curtain_lightgray", new ItemCurtain(Window_Blocks.CURTAIN_lightgray, new Item.Properties()));
	public static Item CURTAIN_cyan = register("block_curtain_cyan", new ItemCurtain(Window_Blocks.CURTAIN_cyan, new Item.Properties()));
	public static Item CURTAIN_purple = register("block_curtain_purple", new ItemCurtain(Window_Blocks.CURTAIN_purple, new Item.Properties()));
	public static Item CURTAIN_blue = register("block_curtain_blue", new ItemCurtain(Window_Blocks.CURTAIN_blue, new Item.Properties()));
	public static Item CURTAIN_brown = register("block_curtain_brown", new ItemCurtain(Window_Blocks.CURTAIN_brown, new Item.Properties()));
	public static Item CURTAIN_green = register("block_curtain_green", new ItemCurtain(Window_Blocks.CURTAIN_green, new Item.Properties()));
	public static Item CURTAIN_red = register("block_curtain_red", new ItemCurtain(Window_Blocks.CURTAIN_red, new Item.Properties()));
	public static Item CURTAIN_black = register("block_curtain_black", new ItemCurtain(Window_Blocks.CURTAIN_black, new Item.Properties()));
	
	public static Item CURTAINTALL_white = register("block_curtaintall_white", new ItemCurtain(Window_Blocks.CURTAINTALL_white, new Item.Properties()));
	public static Item CURTAINTALL_orange = register("block_curtaintall_orange", new ItemCurtain(Window_Blocks.CURTAINTALL_orange, new Item.Properties()));
	public static Item CURTAINTALL_magenta = register("block_curtaintall_magenta", new ItemCurtain(Window_Blocks.CURTAINTALL_magenta, new Item.Properties()));
	public static Item CURTAINTALL_lightblue = register("block_curtaintall_lightblue", new ItemCurtain(Window_Blocks.CURTAINTALL_lightblue, new Item.Properties()));
	public static Item CURTAINTALL_yellow = register("block_curtaintall_yellow", new ItemCurtain(Window_Blocks.CURTAINTALL_yellow, new Item.Properties()));
	public static Item CURTAINTALL_lime = register("block_curtaintall_lime", new ItemCurtain(Window_Blocks.CURTAINTALL_lime, new Item.Properties()));
	public static Item CURTAINTALL_pink = register("block_curtaintall_pink", new ItemCurtain(Window_Blocks.CURTAINTALL_pink, new Item.Properties()));
	public static Item CURTAINTALL_gray = register("block_curtaintall_gray", new ItemCurtain(Window_Blocks.CURTAINTALL_gray, new Item.Properties()));
	public static Item CURTAINTALL_lightgray = register("block_curtaintall_lightgray", new ItemCurtain(Window_Blocks.CURTAINTALL_lightgray, new Item.Properties()));
	public static Item CURTAINTALL_cyan = register("block_curtaintall_cyan", new ItemCurtain(Window_Blocks.CURTAINTALL_cyan, new Item.Properties()));
	public static Item CURTAINTALL_purple = register("block_curtaintall_purple", new ItemCurtain(Window_Blocks.CURTAINTALL_purple, new Item.Properties()));
	public static Item CURTAINTALL_blue = register("block_curtaintall_blue", new ItemCurtain(Window_Blocks.CURTAINTALL_blue, new Item.Properties()));
	public static Item CURTAINTALL_brown = register("block_curtaintall_brown", new ItemCurtain(Window_Blocks.CURTAINTALL_brown, new Item.Properties()));
	public static Item CURTAINTALL_green = register("block_curtaintall_green", new ItemCurtain(Window_Blocks.CURTAINTALL_green, new Item.Properties()));
	public static Item CURTAINTALL_red = register("block_curtaintall_red", new ItemCurtain(Window_Blocks.CURTAINTALL_red, new Item.Properties()));
	public static Item CURTAINTALL_black = register("block_curtaintall_black", new ItemCurtain(Window_Blocks.CURTAINTALL_black, new Item.Properties()));
	
	public static Item CURTAINL_white = register("block_curtainlarge_white", new ItemCurtain(Window_Blocks.CURTAINL_white, new Item.Properties()));
	public static Item CURTAINL_orange = register("block_curtainlarge_orange", new ItemCurtain(Window_Blocks.CURTAINL_orange, new Item.Properties()));
	public static Item CURTAINL_magenta = register("block_curtainlarge_magenta", new ItemCurtain(Window_Blocks.CURTAINL_magenta, new Item.Properties()));
	public static Item CURTAINL_lightblue = register("block_curtainlarge_lightblue", new ItemCurtain(Window_Blocks.CURTAINL_lightblue, new Item.Properties()));
	public static Item CURTAINL_yellow = register("block_curtainlarge_yellow", new ItemCurtain(Window_Blocks.CURTAINL_yellow, new Item.Properties()));
	public static Item CURTAINL_lime = register("block_curtainlarge_lime", new ItemCurtain(Window_Blocks.CURTAINL_lime, new Item.Properties()));
	public static Item CURTAINL_pink = register("block_curtainlarge_pink", new ItemCurtain(Window_Blocks.CURTAINL_pink, new Item.Properties()));
	public static Item CURTAINL_gray = register("block_curtainlarge_gray", new ItemCurtain(Window_Blocks.CURTAINL_gray, new Item.Properties()));
	public static Item CURTAINL_lightgray = register("block_curtainlarge_lightgray", new ItemCurtain(Window_Blocks.CURTAINL_lightgray, new Item.Properties()));
	public static Item CURTAINL_cyan = register("block_curtainlarge_cyan", new ItemCurtain(Window_Blocks.CURTAINL_cyan, new Item.Properties()));
	public static Item CURTAINL_purple = register("block_curtainlarge_purple", new ItemCurtain(Window_Blocks.CURTAINL_purple, new Item.Properties()));
	public static Item CURTAINL_blue = register("block_curtainlarge_blue", new ItemCurtain(Window_Blocks.CURTAINL_blue, new Item.Properties()));
	public static Item CURTAINL_brown = register("block_curtainlarge_brown", new ItemCurtain(Window_Blocks.CURTAINL_brown, new Item.Properties()));
	public static Item CURTAINL_green = register("block_curtainlarge_green", new ItemCurtain(Window_Blocks.CURTAINL_green, new Item.Properties()));
	public static Item CURTAINL_red = register("block_curtainlarge_red", new ItemCurtain(Window_Blocks.CURTAINL_red, new Item.Properties()));
	public static Item CURTAINL_black = register("block_curtainlarge_black", new ItemCurtain(Window_Blocks.CURTAINL_black, new Item.Properties()));
	
	public static Item STOVECHIMNEY = register("block_stovechimney", new Chinjufu_noFuel(School_Blocks.STOVECHIMNEY, new Item.Properties()));
	public static Item STOVECHIMNEY_joint = register("block_stovechimney_joint", new Chinjufu_noFuel(School_Blocks.STOVECHIMNEY_joint, new Item.Properties()));
	public static Item STOVECHIMNEY_topk = register("block_stovechimney_topk", new Chinjufu_noFuel(School_Blocks.STOVECHIMNEY_topk, new Item.Properties()));
	public static Item CSTOVE_bot = register("block_cstove_bot", new Chinjufu_noFuel(School_Blocks.CSTOVE_bot, new Item.Properties()));

	public static Item CANDLE_white = register("block_candle_white", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_white, new Item.Properties()));
	public static Item CANDLE_orange = register("block_candle_orange", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_orange, new Item.Properties()));
	public static Item CANDLE_magenta = register("block_candle_magenta", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_magenta, new Item.Properties()));
	public static Item CANDLE_lightb = register("block_candle_lightb", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_lightb, new Item.Properties()));
	public static Item CANDLE_yellow = register("block_candle_yellow", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_yellow, new Item.Properties()));
	public static Item CANDLE_lime = register("block_candle_lime", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_lime, new Item.Properties()));
	public static Item CANDLE_pink = register("block_candle_pink", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_pink, new Item.Properties()));
	public static Item CANDLE_gray = register("block_candle_gray", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_gray, new Item.Properties()));
	public static Item CANDLE_lightg = register("block_candle_lightg", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_lightg, new Item.Properties()));
	public static Item CANDLE_cyan = register("block_candle_cyan", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_cyan, new Item.Properties()));
	public static Item CANDLE_purple = register("block_candle_purple", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_purple, new Item.Properties()));
	public static Item CANDLE_blue = register("block_candle_blue", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_blue, new Item.Properties()));
	public static Item CANDLE_brown = register("block_candle_brown", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_brown, new Item.Properties()));
	public static Item CANDLE_green = register("block_candle_green", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_green, new Item.Properties()));
	public static Item CANDLE_red = register("block_candle_red", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_red, new Item.Properties()));
	public static Item CANDLE_black = register("block_candle_black", new Chinjufu_noFuel(Furniture_Blocks.CANDLE_black, new Item.Properties()));

	public static Item LAMP = register("block_lamp", new Chinjufu_noFuel(Furniture_Blocks.LAMP, new Item.Properties()));
	public static Item STANDARM = register("block_standarm", new Chinjufu_noFuel(Furniture_Blocks.STANDARM, new Item.Properties()));
	public static Item STAND = register("block_standbedroom", new Chinjufu_noFuel(Furniture_Blocks.STAND, new Item.Properties()));
	public static Item M_LAMP = register("block_marinelamp", new Chinjufu_noFuel(Furniture_Blocks.M_LAMP, new Item.Properties()));
	public static Item E_LIGHT = register("block_lightembed", new Chinjufu_noFuel(Furniture_Blocks.E_LIGHT, new Item.Properties()));

	public static Item ADMIRALCHAIR = register("block_admiralchair", new Chinjufu_Fuel300(Chair_Blocks.ADMIRALCHAIR, new Item.Properties()));
	public static Item ADMIRALCHAIR_red = register("block_admiralchair_red", new Chinjufu_Fuel300(Chair_Blocks.ADMIRALCHAIR_red, new Item.Properties()));

	public static Item TANSU_OAK = register("block_tansu_oak", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_OAK, new Item.Properties()));
	public static Item TANSU_SPRUCE = register("block_tansu_spruce", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_SPRUCE, new Item.Properties()));
	public static Item TANSU_BIRCH = register("block_tansu_birch", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_BIRCH, new Item.Properties()));
	public static Item TANSU_JUNGLE = register("block_tansu_jungle", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_JUNGLE, new Item.Properties()));
	public static Item TANSU_ACACIA = register("block_tansu_acacia", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_ACACIA, new Item.Properties()));
	public static Item TANSU_DOAK = register("block_tansu_doak", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_DOAK, new Item.Properties()));
	public static Item TANSU_SAKURA = register("block_tansu_sakura", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_SAKURA, new Item.Properties()));
	public static Item TANSU_KAEDE = register("block_tansu_kaede", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_KAEDE, new Item.Properties()));
	public static Item TANSU_ICHOH = register("block_tansu_ichoh", new Chinjufu_Fuel300(Furniture_Blocks.TANSU_ICHOH, new Item.Properties()));
	
	public static Item KEIKAIBLOCK = register("block_keikai", new Chinjufu_noFuel(Harbor_Blocks.KEIKAIBLOCK, new Item.Properties()));

	public static Item KEIRYUKUI = register("block_keiryukui", new Chinjufu_noFuel(Harbor_Blocks.KEIRYUKUI, new Item.Properties()));
	public static Item KEIRYUKUI_b = register("block_keiryukui_b", new Chinjufu_noFuel(Harbor_Blocks.KEIRYUKUI_b, new Item.Properties()));

	public static Item TRUSS = register("block_ctruss", new Chinjufu_noFuel(Harbor_Blocks.TRUSS, new Item.Properties()));
	public static Item TRUSS_white = register("block_ctruss_white", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_white, new Item.Properties()));
	public static Item TRUSS_orange = register("block_ctruss_orange", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_orange, new Item.Properties()));
	public static Item TRUSS_magenta = register("block_ctruss_magenta", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_magenta, new Item.Properties()));
	public static Item TRUSS_lightb = register("block_ctruss_lightb", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_lightb, new Item.Properties()));
	public static Item TRUSS_yellow = register("block_ctruss_yellow", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_yellow, new Item.Properties()));
	public static Item TRUSS_lime = register("block_ctruss_lime", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_lime, new Item.Properties()));
	public static Item TRUSS_pink = register("block_ctruss_pink", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_pink, new Item.Properties()));
	public static Item TRUSS_gray = register("block_ctruss_gray", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_gray, new Item.Properties()));
	public static Item TRUSS_cyan = register("block_ctruss_cyan", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_cyan, new Item.Properties()));
	public static Item TRUSS_purple = register("block_ctruss_purple", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_purple, new Item.Properties()));
	public static Item TRUSS_blue = register("block_ctruss_blue", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_blue, new Item.Properties()));
	public static Item TRUSS_brown = register("block_ctruss_brown", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_brown, new Item.Properties()));
	public static Item TRUSS_green = register("block_ctruss_green", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_green, new Item.Properties()));
	public static Item TRUSS_red = register("block_ctruss_red", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_red, new Item.Properties()));
	public static Item TRUSS_black = register("block_ctruss_black", new Chinjufu_noFuel(Harbor_Blocks.TRUSS_black, new Item.Properties()));


	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
