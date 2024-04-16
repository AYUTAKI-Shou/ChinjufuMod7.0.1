package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.addinfo.AddInfo_Item;
import com.ayutaki.chinjufumod.items.fuel.Fuel_100;
import com.ayutaki.chinjufumod.items.fuel.Fuel_150;
import com.ayutaki.chinjufumod.items.fuel.Fuel_200;
import com.ayutaki.chinjufumod.items.fuel.Fuel_300;
import com.ayutaki.chinjufumod.items.fuel.Fuel_7200;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.items.weapon.AdmiralStamp;
import com.ayutaki.chinjufumod.items.weapon.Shouhou;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items_Chinjufu {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* noFuel -> ItemNameBlockItem */
	public static final RegistryObject<Item> ADMIRAL_STAMPB = register("item_admiralstamp_b", () -> new AdmiralStamp(ChinjufuMod_Blocks.I_ADMIRAL_STAMP.get(), new Item.Properties().durability(16)));
	public static final RegistryObject<Item> WORK_ORDER = register("item_workorder", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> REPORT_BOX = register("block_report_box", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.REPORT_BOX.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUHOU_empty = register("item_shouhou_empty", () -> new AddInfo_Item(new Item.Properties()));
	public static final RegistryObject<Item> SHOUHOU = register("item_shouhou", () -> new Shouhou(new Item.Properties()));

	public static final RegistryObject<Item> BAUXITE = register("item_bauxite", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ALUMINUM = register("item_ingot_alumi", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SUMI = register("item_sumi_c", () -> new AddInfo_Item(new Item.Properties()));

	public static final RegistryObject<Item> BAUXITE_ORE = register("block_bauxite_ore", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.BAUXITE_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BAUXITE_ORE_DEEP = register("block_bauxite_ore_deep", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.BAUXITE_ORE_DEEP.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> OIL_DRUM = register("block_fuel_can", () -> new Fuel_7200(ChinjufuMod_Blocks.OIL_DRUM.get(), new Item.Properties()));
	public static final RegistryObject<Item> EMPTY_BOX = register("block_empty_box", () -> new Fuel_100(ChinjufuMod_Blocks.EMPTY_BOX.get(), new Item.Properties()));
	public static final RegistryObject<Item> AMMOBOX = register("block_ammunition_box", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.AMMOBOX.get(), new Item.Properties()));
	public static final RegistryObject<Item> BAUXITE_BOX = register("block_bauxite_box", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.BAUXITE_BOX.get(), new Item.Properties()));
	public static final RegistryObject<Item> ALUMI_BLOCK = register("block_alumi_block", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.ALUMI_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> STEEL_BLOCK = register("block_steel_block", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.STEEL_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> COPPER_BLOCK = register("block_copper_block", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.COPPER_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> GOLD_BLOCK = register("block_gold_block", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.GOLD_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_BLOCK = register("block_netherite_block", () -> new ItemNameBlockItem(ChinjufuMod_Blocks.NETHERITE_BLOCK.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> DRESSINGTABLE = register("block_dressingtable", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_spruce = register("block_dressingtable_s", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_birch = register("block_dressingtable_b", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_jungle = register("block_dressingtable_j", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_acacia = register("block_dressingtable_a", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_darkoak = register("block_dressingtable_d", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_sakura = register("block_dressingtable_saku", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_kaede = register("block_dressingtable_kae", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRESSINGTABLE_ichoh = register("block_dressingtable_ich", () -> new ItemNameBlockItem(Furniture_Blocks.DRESSINGTABLE_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> UNITDESK = register("block_unitdesk", () -> new Fuel_300(Unit_Blocks.UNITDESK.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_spruce = register("block_unitdesk_spruce", () -> new Fuel_300(Unit_Blocks.UNITDESK_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_birch = register("block_unitdesk_birch", () -> new Fuel_300(Unit_Blocks.UNITDESK_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_jungle = register("block_unitdesk_jungle", () -> new Fuel_300(Unit_Blocks.UNITDESK_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_acacia = register("block_unitdesk_acacia", () -> new Fuel_300(Unit_Blocks.UNITDESK_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_darkoak = register("block_unitdesk_darkoak", () -> new Fuel_300(Unit_Blocks.UNITDESK_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_sakura = register("block_unitdesk_sakura", () -> new Fuel_300(Unit_Blocks.UNITDESK_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_kaede = register("block_unitdesk_kaede", () -> new Fuel_300(Unit_Blocks.UNITDESK_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNITDESK_ichoh = register("block_unitdesk_ichoh", () -> new Fuel_300(Unit_Blocks.UNITDESK_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> CAFETABLE = register("block_cafetable", () -> new Fuel_300(Unit_Blocks.CAFETABLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_spruce = register("block_cafetable_spruce", () -> new Fuel_300(Unit_Blocks.CAFETABLE_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_birch = register("block_cafetable_birch", () -> new Fuel_300(Unit_Blocks.CAFETABLE_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_jungle = register("block_cafetable_jungle", () -> new Fuel_300(Unit_Blocks.CAFETABLE_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_acacia = register("block_cafetable_acacia", () -> new Fuel_300(Unit_Blocks.CAFETABLE_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_darkoak = register("block_cafetable_darkoak", () -> new Fuel_300(Unit_Blocks.CAFETABLE_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_sakura = register("block_cafetable_sakura", () -> new Fuel_300(Unit_Blocks.CAFETABLE_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_kaede = register("block_cafetable_kaede", () -> new Fuel_300(Unit_Blocks.CAFETABLE_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFETABLE_ichoh = register("block_cafetable_ichoh", () -> new Fuel_300(Unit_Blocks.CAFETABLE_ichoh.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> DININGCHAIR = register("block_diningchair", () -> new Fuel_150(Chair_Blocks.DININGCHAIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_spruce = register("block_diningchair_s", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_birch = register("block_diningchair_b", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_jungle = register("block_diningchair_j", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_acacia = register("block_diningchair_a", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_darkoak = register("block_diningchair_d", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_sakura = register("block_diningchair_saku", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_kaede = register("block_diningchair_kae", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> DININGCHAIR_ichoh = register("block_diningchair_ich", () -> new Fuel_150(Chair_Blocks.DININGCHAIR_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> LOGCHAIR = register("block_logchair", () -> new Fuel_150(Chair_Blocks.LOGCHAIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_spruce = register("block_logchair_spruce", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_birch = register("block_logchair_birch", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_jungle = register("block_logchair_jungle", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_acacia = register("block_logchair_acacia", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_darkoak = register("block_logchair_darkoak", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_sakura = register("block_logchair_sakura", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_kaede = register("block_logchair_kaede", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOGCHAIR_ichoh = register("block_logchair_ichoh", () -> new Fuel_150(Chair_Blocks.LOGCHAIR_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> CAFECHAIR_white = register("block_cafechair_white", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_orange = register("block_cafechair_orange", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_magenta = register("block_cafechair_magenta", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_lightb = register("block_cafechair_lightb", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_yellow = register("block_cafechair_yellow", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_lime = register("block_cafechair_lime", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_pink = register("block_cafechair_pink", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_gray = register("block_cafechair_gray", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_lightg = register("block_cafechair_lightg", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_cyan = register("block_cafechair_cyan", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_purple = register("block_cafechair_purple", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_blue = register("block_cafechair_blue", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_brown = register("block_cafechair_brown", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_green = register("block_cafechair_green", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_red = register("block_cafechair_red", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> CAFECHAIR_black = register("block_cafechair_black", () -> new Fuel_150(Chair_Blocks.CAFECHAIR_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> SOFA_leather = register("block_sofa_leather", () -> new Fuel_150(Chair_Blocks.SOFA_leather.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_white = register("block_sofa_white", () -> new Fuel_150(Chair_Blocks.SOFA_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_orange = register("block_sofa_orange", () -> new Fuel_150(Chair_Blocks.SOFA_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_magenta = register("block_sofa_magenta", () -> new Fuel_150(Chair_Blocks.SOFA_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_lightb = register("block_sofa_lightblue", () -> new Fuel_150(Chair_Blocks.SOFA_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_yellow = register("block_sofa_yellow", () -> new Fuel_150(Chair_Blocks.SOFA_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_lime = register("block_sofa_lime", () -> new Fuel_150(Chair_Blocks.SOFA_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_pink = register("block_sofa_pink", () -> new Fuel_150(Chair_Blocks.SOFA_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_gray = register("block_sofa_gray", () -> new Fuel_150(Chair_Blocks.SOFA_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_lightg = register("block_sofa_lightgray", () -> new Fuel_150(Chair_Blocks.SOFA_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_cyan = register("block_sofa_cyan", () -> new Fuel_150(Chair_Blocks.SOFA_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_purple = register("block_sofa_purple", () -> new Fuel_150(Chair_Blocks.SOFA_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_blue = register("block_sofa_blue", () -> new Fuel_150(Chair_Blocks.SOFA_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_brown = register("block_sofa_brown", () -> new Fuel_150(Chair_Blocks.SOFA_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_green = register("block_sofa_green", () -> new Fuel_150(Chair_Blocks.SOFA_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_red = register("block_sofa_red", () -> new Fuel_150(Chair_Blocks.SOFA_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOFA_black = register("block_sofa_black", () -> new Fuel_150(Chair_Blocks.SOFA_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> BENCH = register("block_bench", () -> new Fuel_150(Chair_Blocks.BENCH.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_spru = register("block_bench_spru", () -> new Fuel_150(Chair_Blocks.BENCH_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_bir = register("block_bench_bir", () -> new Fuel_150(Chair_Blocks.BENCH_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_jun = register("block_bench_jun", () -> new Fuel_150(Chair_Blocks.BENCH_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_aca = register("block_bench_aca", () -> new Fuel_150(Chair_Blocks.BENCH_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_doak = register("block_bench_doak", () -> new Fuel_150(Chair_Blocks.BENCH_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_sakura = register("block_bench_saku", () -> new Fuel_150(Chair_Blocks.BENCH_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_kaede = register("block_bench_kae", () -> new Fuel_150(Chair_Blocks.BENCH_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> BENCH_ichoh = register("block_bench_ich", () -> new Fuel_150(Chair_Blocks.BENCH_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> SCHOOLCHAIR = register("block_schoolchair", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_spruce = register("block_schoolchair_s", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_birch = register("block_schoolchair_b", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_jungle = register("block_schoolchair_j", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_acacia = register("block_schoolchair_a", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_darkoak = register("block_schoolchair_d", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_sakura = register("block_schoolchair_saku", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_kaede = register("block_schoolchair_kae", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLCHAIR_ichoh = register("block_schoolchair_ich", () -> new Fuel_150(School_Blocks.SCHOOLCHAIR_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> SCHOOLDESK = register("block_schooldesk", () -> new Fuel_200(School_Blocks.SCHOOLDESK.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_spruce = register("block_schooldesk_s", () -> new Fuel_200(School_Blocks.SCHOOLDESK_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_birch = register("block_schooldesk_b", () -> new Fuel_200(School_Blocks.SCHOOLDESK_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_jungle = register("block_schooldesk_j", () -> new Fuel_200(School_Blocks.SCHOOLDESK_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_acacia = register("block_schooldesk_a", () -> new Fuel_200(School_Blocks.SCHOOLDESK_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_darkoak = register("block_schooldesk_d", () -> new Fuel_200(School_Blocks.SCHOOLDESK_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_sakura = register("block_schooldesk_saku", () -> new Fuel_200(School_Blocks.SCHOOLDESK_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_kaede = register("block_schooldesk_kae", () -> new Fuel_200(School_Blocks.SCHOOLDESK_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCHOOLDESK_ichoh = register("block_schooldesk_ich", () -> new Fuel_200(School_Blocks.SCHOOLDESK_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> TEACHERDESK = register("block_teacherdesk", () -> new Fuel_300(School_Blocks.TEACHERDESK.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_spruce = register("block_teacherdesk_s", () -> new Fuel_300(School_Blocks.TEACHERDESK_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_birch = register("block_teacherdesk_b", () -> new Fuel_300(School_Blocks.TEACHERDESK_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_jungle = register("block_teacherdesk_j", () -> new Fuel_300(School_Blocks.TEACHERDESK_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_acacia = register("block_teacherdesk_a", () -> new Fuel_300(School_Blocks.TEACHERDESK_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_darkoak = register("block_teacherdesk_d", () -> new Fuel_300(School_Blocks.TEACHERDESK_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_sakura = register("block_teacherdesk_saku", () -> new Fuel_300(School_Blocks.TEACHERDESK_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_kaede = register("block_teacherdesk_kae", () -> new Fuel_300(School_Blocks.TEACHERDESK_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEACHERDESK_ichoh = register("block_teacherdesk_ich", () -> new Fuel_300(School_Blocks.TEACHERDESK_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> LOWDESK = register("block_lowdesk", () -> new Fuel_150(Unit_Blocks.LOWDESK.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_spruce = register("block_lowdesk_spruce", () -> new Fuel_150(Unit_Blocks.LOWDESK_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_birch = register("block_lowdesk_birch", () -> new Fuel_150(Unit_Blocks.LOWDESK_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_jungle = register("block_lowdesk_jungle", () -> new Fuel_150(Unit_Blocks.LOWDESK_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_acacia = register("block_lowdesk_acacia", () -> new Fuel_150(Unit_Blocks.LOWDESK_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_darkoak = register("block_lowdesk_darkoak", () -> new Fuel_150(Unit_Blocks.LOWDESK_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_sakura = register("block_lowdesk_sakura", () -> new Fuel_150(Unit_Blocks.LOWDESK_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_kaede = register("block_lowdesk_kaede", () -> new Fuel_150(Unit_Blocks.LOWDESK_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOWDESK_ichoh = register("block_lowdesk_ichoh", () -> new Fuel_150(Unit_Blocks.LOWDESK_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> LETTERTRAY = register("block_lettertray_c", () -> new ItemNameBlockItem(Unit_Blocks.LETTERTRAY.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUDETRAY = register("block_fudetray_c", () -> new ItemNameBlockItem(Unit_Blocks.FUDETRAY.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLACKBOARD = register("block_blackboard", () -> new ItemNameBlockItem(School_Blocks.BLACKBOARD.get(), new Item.Properties()));

	public static final RegistryObject<Item> WINDOW_oak = register("block_window", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_spruce = register("block_window_spruce", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_birch = register("block_window_birch", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_jungle = register("block_window_jungle", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_acacia = register("block_window_acacia", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_darkoak = register("block_window_darkoak", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_sakura = register("block_window_sakura", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_kaede = register("block_window_kaede", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW_ichoh = register("block_window_ichoh", () -> new ItemNameBlockItem(Window_Blocks.WINDOW_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> WINDOWB_oak = register("block_windowb", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_spruce = register("block_windowb_spruce", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_birch = register("block_windowb_birch", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_jungle = register("block_windowb_jungle", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_acacia = register("block_windowb_acacia", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_darkoak = register("block_windowb_darkoak", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_sakura = register("block_windowb_sakura", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_kaede = register("block_windowb_kaede", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWB_ichoh = register("block_windowb_ichoh", () -> new ItemNameBlockItem(Window_Blocks.WINDOWB_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> WINDOWTALLBOT_oak = register("block_windowtallbot", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_spruce = register("block_windowtallbot_spruce", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_birch = register("block_windowtallbot_birch", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_jungle = register("block_windowtallbot_jungle", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_acacia = register("block_windowtallbot_acacia", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_darkoak = register("block_windowtallbot_darkoak", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_sakura = register("block_windowtallbot_sakura", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_kaede = register("block_windowtallbot_kaede", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALLBOT_ichoh = register("block_windowtallbot_ichoh", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALLBOT_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> WINDOWTALL_oak = register("block_windowtall", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_spruce = register("block_windowtall_spruce", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_birch = register("block_windowtall_birch", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_jungle = register("block_windowtall_jungle", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_acacia = register("block_windowtall_acacia", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_darkoak = register("block_windowtall_darkoak", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_sakura = register("block_windowtall_sakura", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_kaede = register("block_windowtall_kaede", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOWTALL_ichoh = register("block_windowtall_ichoh", () -> new ItemNameBlockItem(Window_Blocks.WINDOWTALL_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> CURTAIN_white = register("block_curtain_white", () -> new ItemCurtain(Window_Blocks.CURTAIN_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_orange = register("block_curtain_orange", () -> new ItemCurtain(Window_Blocks.CURTAIN_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_magenta = register("block_curtain_magenta", () -> new ItemCurtain(Window_Blocks.CURTAIN_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_lightblue = register("block_curtain_lightblue", () -> new ItemCurtain(Window_Blocks.CURTAIN_lightblue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_yellow = register("block_curtain_yellow", () -> new ItemCurtain(Window_Blocks.CURTAIN_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_lime = register("block_curtain_lime", () -> new ItemCurtain(Window_Blocks.CURTAIN_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_pink = register("block_curtain_pink", () -> new ItemCurtain(Window_Blocks.CURTAIN_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_gray = register("block_curtain_gray", () -> new ItemCurtain(Window_Blocks.CURTAIN_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_lightgray = register("block_curtain_lightgray", () -> new ItemCurtain(Window_Blocks.CURTAIN_lightgray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_cyan = register("block_curtain_cyan", () -> new ItemCurtain(Window_Blocks.CURTAIN_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_purple = register("block_curtain_purple", () -> new ItemCurtain(Window_Blocks.CURTAIN_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_blue = register("block_curtain_blue", () -> new ItemCurtain(Window_Blocks.CURTAIN_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_brown = register("block_curtain_brown", () -> new ItemCurtain(Window_Blocks.CURTAIN_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_green = register("block_curtain_green", () -> new ItemCurtain(Window_Blocks.CURTAIN_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_red = register("block_curtain_red", () -> new ItemCurtain(Window_Blocks.CURTAIN_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAIN_black = register("block_curtain_black", () -> new ItemCurtain(Window_Blocks.CURTAIN_black.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> CURTAINTALL_white = register("block_curtaintall_white", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_orange = register("block_curtaintall_orange", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_magenta = register("block_curtaintall_magenta", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_lightblue = register("block_curtaintall_lightblue", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_lightblue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_yellow = register("block_curtaintall_yellow", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_lime = register("block_curtaintall_lime", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_pink = register("block_curtaintall_pink", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_gray = register("block_curtaintall_gray", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_lightgray = register("block_curtaintall_lightgray", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_lightgray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_cyan = register("block_curtaintall_cyan", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_purple = register("block_curtaintall_purple", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_blue = register("block_curtaintall_blue", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_brown = register("block_curtaintall_brown", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_green = register("block_curtaintall_green", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_red = register("block_curtaintall_red", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINTALL_black = register("block_curtaintall_black", () -> new ItemCurtain(Window_Blocks.CURTAINTALL_black.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> CURTAINL_white = register("block_curtainlarge_white", () -> new ItemCurtain(Window_Blocks.CURTAINL_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_orange = register("block_curtainlarge_orange", () -> new ItemCurtain(Window_Blocks.CURTAINL_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_magenta = register("block_curtainlarge_magenta", () -> new ItemCurtain(Window_Blocks.CURTAINL_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_lightblue = register("block_curtainlarge_lightblue", () -> new ItemCurtain(Window_Blocks.CURTAINL_lightblue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_yellow = register("block_curtainlarge_yellow", () -> new ItemCurtain(Window_Blocks.CURTAINL_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_lime = register("block_curtainlarge_lime", () -> new ItemCurtain(Window_Blocks.CURTAINL_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_pink = register("block_curtainlarge_pink", () -> new ItemCurtain(Window_Blocks.CURTAINL_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_gray = register("block_curtainlarge_gray", () -> new ItemCurtain(Window_Blocks.CURTAINL_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_lightgray = register("block_curtainlarge_lightgray", () -> new ItemCurtain(Window_Blocks.CURTAINL_lightgray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_cyan = register("block_curtainlarge_cyan", () -> new ItemCurtain(Window_Blocks.CURTAINL_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_purple = register("block_curtainlarge_purple", () -> new ItemCurtain(Window_Blocks.CURTAINL_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_blue = register("block_curtainlarge_blue", () -> new ItemCurtain(Window_Blocks.CURTAINL_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_brown = register("block_curtainlarge_brown", () -> new ItemCurtain(Window_Blocks.CURTAINL_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_green = register("block_curtainlarge_green", () -> new ItemCurtain(Window_Blocks.CURTAINL_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_red = register("block_curtainlarge_red", () -> new ItemCurtain(Window_Blocks.CURTAINL_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> CURTAINL_black = register("block_curtainlarge_black", () -> new ItemCurtain(Window_Blocks.CURTAINL_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> STOVECHIMNEY = register("block_stovechimney", () -> new ItemNameBlockItem(School_Blocks.STOVECHIMNEY.get(), new Item.Properties()));
	public static final RegistryObject<Item> STOVECHIMNEY_joint = register("block_stovechimney_joint", () -> new ItemNameBlockItem(School_Blocks.STOVECHIMNEY_joint.get(), new Item.Properties()));
	public static final RegistryObject<Item> STOVECHIMNEY_topk = register("block_stovechimney_topk", () -> new ItemNameBlockItem(School_Blocks.STOVECHIMNEY_topk.get(), new Item.Properties()));
	public static final RegistryObject<Item> CSTOVE_bot = register("block_cstove_bot", () -> new ItemNameBlockItem(School_Blocks.CSTOVE_bot.get(), new Item.Properties()));

	public static final RegistryObject<Item> CANDLE_white = register("block_candle_white", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_orange = register("block_candle_orange", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_magenta = register("block_candle_magenta", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_lightb = register("block_candle_lightb", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_yellow = register("block_candle_yellow", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_lime = register("block_candle_lime", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_pink = register("block_candle_pink", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_gray = register("block_candle_gray", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_lightg = register("block_candle_lightg", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_cyan = register("block_candle_cyan", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_purple = register("block_candle_purple", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_blue = register("block_candle_blue", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_brown = register("block_candle_brown", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_green = register("block_candle_green", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_red = register("block_candle_red", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> CANDLE_black = register("block_candle_black", () -> new ItemNameBlockItem(Furniture_Blocks.CANDLE_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> LAMP = register("block_lamp", () -> new ItemNameBlockItem(Furniture_Blocks.LAMP.get(), new Item.Properties()));
	public static final RegistryObject<Item> STANDARM = register("block_standarm", () -> new ItemNameBlockItem(Furniture_Blocks.STANDARM.get(), new Item.Properties()));
	public static final RegistryObject<Item> STAND = register("block_standbedroom", () -> new ItemNameBlockItem(Furniture_Blocks.STAND.get(), new Item.Properties()));
	public static final RegistryObject<Item> M_LAMP = register("block_marinelamp", () -> new ItemNameBlockItem(Furniture_Blocks.M_LAMP.get(), new Item.Properties()));
	public static final RegistryObject<Item> E_LIGHT = register("block_lightembed", () -> new ItemNameBlockItem(Furniture_Blocks.E_LIGHT.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> ADMIRALCHAIR = register("block_admiralchair", () -> new Fuel_300(Chair_Blocks.ADMIRALCHAIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> ADMIRALCHAIR_red = register("block_admiralchair_red", () -> new Fuel_300(Chair_Blocks.ADMIRALCHAIR_red.get(), new Item.Properties()));

	public static final RegistryObject<Item> TANSU_OAK = register("block_tansu_oak", () -> new Fuel_300(Furniture_Blocks.TANSU_OAK.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_SPRUCE = register("block_tansu_spruce", () -> new Fuel_300(Furniture_Blocks.TANSU_SPRUCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_BIRCH = register("block_tansu_birch", () -> new Fuel_300(Furniture_Blocks.TANSU_BIRCH.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_JUNGLE = register("block_tansu_jungle", () -> new Fuel_300(Furniture_Blocks.TANSU_JUNGLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_ACACIA = register("block_tansu_acacia", () -> new Fuel_300(Furniture_Blocks.TANSU_ACACIA.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_DOAK = register("block_tansu_doak", () -> new Fuel_300(Furniture_Blocks.TANSU_DOAK.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_SAKURA = register("block_tansu_sakura", () -> new Fuel_300(Furniture_Blocks.TANSU_SAKURA.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_KAEDE = register("block_tansu_kaede", () -> new Fuel_300(Furniture_Blocks.TANSU_KAEDE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TANSU_ICHOH = register("block_tansu_ichoh", () -> new Fuel_300(Furniture_Blocks.TANSU_ICHOH.get(), new Item.Properties()));

	public static final RegistryObject<Item> KEIKAIBLOCK = register("block_keikai", () -> new ItemNameBlockItem(Harbor_Blocks.KEIKAIBLOCK.get(), new Item.Properties()));

	public static final RegistryObject<Item> KEIRYUKUI = register("block_keiryukui", () -> new ItemNameBlockItem(Harbor_Blocks.KEIRYUKUI.get(), new Item.Properties()));
	public static final RegistryObject<Item> KEIRYUKUI_b = register("block_keiryukui_b", () -> new ItemNameBlockItem(Harbor_Blocks.KEIRYUKUI_b.get(), new Item.Properties()));

	public static final RegistryObject<Item> TRUSS = register("block_ctruss", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_white = register("block_ctruss_white", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_orange = register("block_ctruss_orange", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_magenta = register("block_ctruss_magenta", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_lightb = register("block_ctruss_lightb", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_yellow = register("block_ctruss_yellow", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_lime = register("block_ctruss_lime", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_pink = register("block_ctruss_pink", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_gray = register("block_ctruss_gray", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_cyan = register("block_ctruss_cyan", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_purple = register("block_ctruss_purple", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_blue = register("block_ctruss_blue", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_brown = register("block_ctruss_brown", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_green = register("block_ctruss_green", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_red = register("block_ctruss_red", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRUSS_black = register("block_ctruss_black", () -> new ItemNameBlockItem(Harbor_Blocks.TRUSS_black.get(), new Item.Properties()));

	
	///* Register *///
	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}
}
