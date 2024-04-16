package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.chair.Bench;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.furnace.CStove_bot;
import com.ayutaki.chinjufumod.blocks.furnace.CStove_top;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable_Top;
import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.blocks.school.BlackBoard;
import com.ayutaki.chinjufumod.blocks.school.SchoolChair;
import com.ayutaki.chinjufumod.blocks.school.SchoolDesk;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_joint;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_topk;
import com.ayutaki.chinjufumod.blocks.school.TeacherDesk;

import net.minecraft.block.Block;

public class Furniture_Blocks {

	public static Block DRESSINGTABLE, DRESSINGTABLE_s, DRESSINGTABLE_b,
								DRESSINGTABLE_j, DRESSINGTABLE_a, DRESSINGTABLE_d,
								DRESSINGTABLE_saku, DRESSINGTABLE_kae, DRESSINGTABLE_ich,
								DRESSINGTABLE_TOP1, DRESSINGTABLE_TOP2, DRESSINGTABLE_TOP3;

	public static Block DININGCHAIR, DININGCHAIR_s, DININGCHAIR_b,
								DININGCHAIR_j, DININGCHAIR_a, DININGCHAIR_d,
								DININGCHAIR_saku, DININGCHAIR_kae, DININGCHAIR_ich;

	public static Block SOFA_leather, SOFA_white, SOFA_orange, SOFA_magenta, SOFA_lightb,
								SOFA_yellow, SOFA_lime, SOFA_pink, SOFA_gray,
								SOFA_lightg, SOFA_cyan, SOFA_purple, SOFA_blue,
								SOFA_brown, SOFA_green, SOFA_red, SOFA_black;

	public static Block BENCH, BENCH_spru, BENCH_bir,
								BENCH_jun, BENCH_aca, BENCH_doak,
								BENCH_saku, BENCH_kae, BENCH_ich;

	public static Block BLACKBOARD;

	public static Block SCHOOLCHAIR, SCHOOLCHAIR_s,SCHOOLCHAIR_b,
								SCHOOLCHAIR_j, SCHOOLCHAIR_a, SCHOOLCHAIR_d,
								SCHOOLCHAIR_saku, SCHOOLCHAIR_kae, SCHOOLCHAIR_ich;

	public static Block SCHOOLDESK, SCHOOLDESK_s,SCHOOLDESK_b,
								SCHOOLDESK_j, SCHOOLDESK_a, SCHOOLDESK_d,
								SCHOOLDESK_saku, SCHOOLDESK_kae, SCHOOLDESK_ich;

	public static Block TEACHERDESK, TEACHERDESK_s,TEACHERDESK_b,
								TEACHERDESK_j, TEACHERDESK_a, TEACHERDESK_d,
								TEACHERDESK_saku, TEACHERDESK_kae, TEACHERDESK_ich;

	public static Block STOVECHIMNEY, STOVECHIMNEY_joint, STOVECHIMNEY_topk;

	public static Block CSTOVE_top, LIT_CSTOVE_top, CSTOVE_bot;

	public static Block TANSU_OAK, TANSU_SPRUCE, TANSU_BIRCH, TANSU_JUNGLE, TANSU_ACACIA,
								TANSU_DOAK, TANSU_SAKURA, TANSU_KAEDE, TANSU_ICHOH;


	public static void init() {

		DRESSINGTABLE = new DressingTable("block_dressingtable");
		DRESSINGTABLE_s = new DressingTable("block_dressingtable_s");
		DRESSINGTABLE_b = new DressingTable("block_dressingtable_b");
		DRESSINGTABLE_j = new DressingTable("block_dressingtable_j");
		DRESSINGTABLE_a = new DressingTable("block_dressingtable_a");
		DRESSINGTABLE_d = new DressingTable("block_dressingtable_d");
		DRESSINGTABLE_saku = new DressingTable("block_dressingtable_saku");
		DRESSINGTABLE_kae = new DressingTable("block_dressingtable_kae");
		DRESSINGTABLE_ich = new DressingTable("block_dressingtable_ich");

		DRESSINGTABLE_TOP1 = new DressingTable_Top("block_dressingtable_top1");
		DRESSINGTABLE_TOP2 = new DressingTable_Top("block_dressingtable_top2");
		DRESSINGTABLE_TOP3 = new DressingTable_Top("block_dressingtable_top3");

		DININGCHAIR = new DiningChair("block_diningchair");
		DININGCHAIR_s = new DiningChair("block_diningchair_s");
		DININGCHAIR_b = new DiningChair("block_diningchair_b");
		DININGCHAIR_j = new DiningChair("block_diningchair_j");
		DININGCHAIR_a = new DiningChair("block_diningchair_a");
		DININGCHAIR_d = new DiningChair("block_diningchair_d");
		DININGCHAIR_saku = new DiningChair("block_diningchair_saku");
		DININGCHAIR_kae = new DiningChair("block_diningchair_kae");
		DININGCHAIR_ich = new DiningChair("block_diningchair_ich");

		SOFA_leather = new Sofa("block_sofa_leather");
		SOFA_white = new Sofa("block_sofa_white");
		SOFA_orange = new Sofa("block_sofa_orange");
		SOFA_magenta = new Sofa("block_sofa_magenta");
		SOFA_lightb = new Sofa("block_sofa_lightblue");
		SOFA_yellow = new Sofa("block_sofa_yellow");
		SOFA_lime = new Sofa("block_sofa_lime");
		SOFA_pink = new Sofa("block_sofa_pink");
		SOFA_gray = new Sofa("block_sofa_gray");
		SOFA_lightg = new Sofa("block_sofa_lightgray");
		SOFA_cyan = new Sofa("block_sofa_cyan");
		SOFA_purple = new Sofa("block_sofa_purple");
		SOFA_blue = new Sofa("block_sofa_blue");
		SOFA_brown = new Sofa("block_sofa_brown");
		SOFA_green = new Sofa("block_sofa_green");
		SOFA_red = new Sofa("block_sofa_red");
		SOFA_black = new Sofa("block_sofa_black");

		BENCH = new Bench("block_bench");
		BENCH_spru = new Bench("block_bench_spru");
		BENCH_bir = new Bench("block_bench_bir");
		BENCH_jun = new Bench("block_bench_jun");
		BENCH_aca = new Bench("block_bench_aca");
		BENCH_doak = new Bench("block_bench_doak");
		BENCH_saku = new Bench("block_bench_saku");
		BENCH_kae = new Bench("block_bench_kae");
		BENCH_ich = new Bench("block_bench_ich");

		BLACKBOARD = new BlackBoard("block_blackboard");

		SCHOOLCHAIR = new SchoolChair("block_schoolchair");
		SCHOOLCHAIR_s = new SchoolChair("block_schoolchair_s");
		SCHOOLCHAIR_b = new SchoolChair("block_schoolchair_b");
		SCHOOLCHAIR_j = new SchoolChair("block_schoolchair_j");
		SCHOOLCHAIR_a = new SchoolChair("block_schoolchair_a");
		SCHOOLCHAIR_d = new SchoolChair("block_schoolchair_d");
		SCHOOLCHAIR_saku = new SchoolChair("block_schoolchair_saku");
		SCHOOLCHAIR_kae = new SchoolChair("block_schoolchair_kae");
		SCHOOLCHAIR_ich = new SchoolChair("block_schoolchair_ich");

		SCHOOLDESK = new SchoolDesk("block_schooldesk");
		SCHOOLDESK_s = new SchoolDesk("block_schooldesk_s");
		SCHOOLDESK_b = new SchoolDesk("block_schooldesk_b");
		SCHOOLDESK_j = new SchoolDesk("block_schooldesk_j");
		SCHOOLDESK_a = new SchoolDesk("block_schooldesk_a");
		SCHOOLDESK_d = new SchoolDesk("block_schooldesk_d");
		SCHOOLDESK_saku = new SchoolDesk("block_schooldesk_saku");
		SCHOOLDESK_kae = new SchoolDesk("block_schooldesk_kae");
		SCHOOLDESK_ich = new SchoolDesk("block_schooldesk_ich");

		TEACHERDESK = new TeacherDesk("block_teacherdesk");
		TEACHERDESK_s = new TeacherDesk("block_teacherdesk_s");
		TEACHERDESK_b = new TeacherDesk("block_teacherdesk_b");
		TEACHERDESK_j = new TeacherDesk("block_teacherdesk_j");
		TEACHERDESK_a = new TeacherDesk("block_teacherdesk_a");
		TEACHERDESK_d = new TeacherDesk("block_teacherdesk_d");
		TEACHERDESK_saku = new TeacherDesk("block_teacherdesk_saku");
		TEACHERDESK_kae = new TeacherDesk("block_teacherdesk_kae");
		TEACHERDESK_ich = new TeacherDesk("block_teacherdesk_ich");

		STOVECHIMNEY = new StoveChimney("block_stovechimney");
		STOVECHIMNEY_joint = new StoveChimney_joint("block_stovechimney_joint");
		STOVECHIMNEY_topk = new StoveChimney_topk("block_stovechimney_topk");

		CSTOVE_top = new CStove_top(false, "block_cstove_top");
		LIT_CSTOVE_top = new CStove_top(true, "lit_block_cstove_top").setHardness(1.0F).setResistance(10.0F);
		CSTOVE_bot = new CStove_bot("block_cstove_bot");

		TANSU_OAK = new Tansu("block_tansu_oak").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_SPRUCE = new Tansu("block_tansu_spruce").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_BIRCH = new Tansu("block_tansu_birch").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_JUNGLE = new Tansu("block_tansu_jungle").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_ACACIA = new Tansu("block_tansu_acacia").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_DOAK = new Tansu("block_tansu_doak").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_SAKURA = new Tansu("block_tansu_sakura").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_KAEDE = new Tansu("block_tansu_kaede").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		TANSU_ICHOH = new Tansu("block_tansu_ichoh").setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}


	public static void register() {

		registerBlock(DRESSINGTABLE);
		registerBlock(DRESSINGTABLE_s);
		registerBlock(DRESSINGTABLE_b);
		registerBlock(DRESSINGTABLE_j);
		registerBlock(DRESSINGTABLE_a);
		registerBlock(DRESSINGTABLE_d);
		registerBlock(DRESSINGTABLE_saku);
		registerBlock(DRESSINGTABLE_kae);
		registerBlock(DRESSINGTABLE_ich);

		registerBlock(DRESSINGTABLE_TOP1);
		registerBlock(DRESSINGTABLE_TOP2);
		registerBlock(DRESSINGTABLE_TOP3);

		registerBlock(DININGCHAIR);
		registerBlock(DININGCHAIR_s);
		registerBlock(DININGCHAIR_b);
		registerBlock(DININGCHAIR_j);
		registerBlock(DININGCHAIR_a);
		registerBlock(DININGCHAIR_d);
		registerBlock(DININGCHAIR_saku);
		registerBlock(DININGCHAIR_kae);
		registerBlock(DININGCHAIR_ich);

		registerBlock(SOFA_leather);
		registerBlock(SOFA_white);
		registerBlock(SOFA_orange);
		registerBlock(SOFA_magenta);
		registerBlock(SOFA_lightb);
		registerBlock(SOFA_yellow);
		registerBlock(SOFA_lime);
		registerBlock(SOFA_pink);
		registerBlock(SOFA_gray);
		registerBlock(SOFA_lightg);
		registerBlock(SOFA_cyan);
		registerBlock(SOFA_purple);
		registerBlock(SOFA_blue);
		registerBlock(SOFA_brown);
		registerBlock(SOFA_green);
		registerBlock(SOFA_red);
		registerBlock(SOFA_black);

		registerBlock(BENCH);
		registerBlock(BENCH_spru);
		registerBlock(BENCH_bir);
		registerBlock(BENCH_jun);
		registerBlock(BENCH_aca);
		registerBlock(BENCH_doak);
		registerBlock(BENCH_saku);
		registerBlock(BENCH_kae);
		registerBlock(BENCH_ich);

		registerBlock(BLACKBOARD);

		registerBlock(SCHOOLCHAIR);
		registerBlock(SCHOOLCHAIR_s);
		registerBlock(SCHOOLCHAIR_b);
		registerBlock(SCHOOLCHAIR_j);
		registerBlock(SCHOOLCHAIR_a);
		registerBlock(SCHOOLCHAIR_d);
		registerBlock(SCHOOLCHAIR_saku);
		registerBlock(SCHOOLCHAIR_kae);
		registerBlock(SCHOOLCHAIR_ich);

		registerBlock(SCHOOLDESK);
		registerBlock(SCHOOLDESK_s);
		registerBlock(SCHOOLDESK_b);
		registerBlock(SCHOOLDESK_j);
		registerBlock(SCHOOLDESK_a);
		registerBlock(SCHOOLDESK_d);
		registerBlock(SCHOOLDESK_saku);
		registerBlock(SCHOOLDESK_kae);
		registerBlock(SCHOOLDESK_ich);

		registerBlock(TEACHERDESK);
		registerBlock(TEACHERDESK_s);
		registerBlock(TEACHERDESK_b);
		registerBlock(TEACHERDESK_j);
		registerBlock(TEACHERDESK_a);
		registerBlock(TEACHERDESK_d);
		registerBlock(TEACHERDESK_saku);
		registerBlock(TEACHERDESK_kae);
		registerBlock(TEACHERDESK_ich);

		registerBlock(STOVECHIMNEY);
		registerBlock(STOVECHIMNEY_joint);
		registerBlock(STOVECHIMNEY_topk);

		registerBlock(CSTOVE_top);
		registerBlock(LIT_CSTOVE_top);
		registerBlock(CSTOVE_bot);

		registerBlock(TANSU_OAK);
		registerBlock(TANSU_SPRUCE);
		registerBlock(TANSU_BIRCH);
		registerBlock(TANSU_JUNGLE);
		registerBlock(TANSU_ACACIA);
		registerBlock(TANSU_DOAK);
		registerBlock(TANSU_SAKURA);
		registerBlock(TANSU_KAEDE);
		registerBlock(TANSU_ICHOH);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
