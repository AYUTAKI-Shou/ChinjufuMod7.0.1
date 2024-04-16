package com.ayutaki.chinjufumod.handler;

public class FlammableBlocks_CM {

	/** 1.16.5 setFlammable が不可視の為 IForgeBlock.class の state を使って個別対応 **/
	/* FireBlock を参考に 立方体・半ブロック・階段に絞る
	public static void setup() {

		registerFlammable(ChinjufuModBlocks.OIL_DRUM, 5, 5);
		registerFlammable(ChinjufuModBlocks.EMPTY_BOX, 5, 20);

		registerFlammable(JPdeco_Blocks.TATAMI_H, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_white, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_orange, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_magenta, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_lightb, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_yellow, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_lime, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_pink, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_gray, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_lightg, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_cyan, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_purple, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_blue, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_brown, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_green, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_red, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_H_black, 5, 20);

		registerFlammable(JPdeco_Blocks.TATAMI_HY, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_white, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_orange, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_magenta, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_lightb, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_yellow, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_lime, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_pink, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_gray, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_lightg, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_cyan, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_purple, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_blue, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_brown, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_green, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_red, 5, 20);
		registerFlammable(JPdeco_Blocks.TATAMI_HY_black, 5, 20);

		registerFlammable(JPdeco_Blocks.TAKECUBE, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKECUBE_Y, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKECUBE_K, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKE_ST, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKE_STY, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKE_STK, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKE_SH, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKE_SHY, 5, 20);
		registerFlammable(JPdeco_Blocks.TAKE_SHK, 5, 20);

		registerFlammable(Garden_Blocks.IKEGAKI, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_spruce, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_birch, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_jungle, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_acacia, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_darkoak, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_sakura, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_kaede, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_ichoh, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_kare, 5, 20);

		registerFlammable(Garden_Blocks.IKEGAKILONG, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_spruce, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_birch, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_jungle, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_acacia, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_darkoak, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_sakura, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_kaede, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_ichoh, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKILONG_kare, 5, 20);

		registerFlammable(Hakkou_Blocks.HAKKOU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.KOUJI_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.SHUBO_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.MOROMI_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.JUKUSEI_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.RINGOSHU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.BUDOUSHU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.HACHIMITSU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.COCOA_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.MISO_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.HAKUSAI_TARU1, 5, 20);
		registerFlammable(Hakkou_Blocks.HAKUSAI_TARU2, 5, 20);
		registerFlammable(Hakkou_Blocks.SHOUYU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.KOMEZU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.KINOKO_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.KONBU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.NORI_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.KOUCHA_TARU, 5, 20);

		registerFlammable(Pantry_Blocks.BOX_H_EMPTY, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_EMPTY2, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_EMPTY3, 5, 20);

		registerFlammable(Pantry_Blocks.BOX_H_APPLE, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_BEEF, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_BEETROOT, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_BREAD, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_CARROT, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_CHICKEN, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_CHORUS, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_COCO, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_COD, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_EGG, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_FISH, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_FLOUR, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_MUTTON, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_PORK, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_POTATO, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_RABBIT, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_SALMON, 5, 20);

		registerFlammable(Pantry_Blocks.BOX_H_CABBAGE, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_HAKUSAI, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_CHERRY, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_CITRUS, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_CORN, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_GRAPE, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_ONION, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_RICE, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_SOY, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_SPINACH, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_TOMATO, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_TGREEN, 5, 20);
		registerFlammable(Pantry_Blocks.BOX_H_TRED, 5, 20);
		registerFlammable(Pantry_Blocks.TAWARA, 5, 20);

		registerFlammable(Seasonal_Blocks.KUSATABA, 5, 20);
		registerFlammable(Seasonal_Blocks.KUSATABA_STAIRS, 5, 20);
		registerFlammable(Seasonal_Blocks.WARATABA, 5, 20);
		registerFlammable(Seasonal_Blocks.KUSATABADUMMY, 5, 20);
		registerFlammable(Seasonal_Blocks.KUSATABA_RF, 5, 20);
		registerFlammable(Seasonal_Blocks.WARATABA_RF, 5, 20);
		registerFlammable(Seasonal_Blocks.KAYATABA_RF, 5, 20);
		registerFlammable(Seasonal_Blocks.WARATABA_STAIRS, 5, 20);
		registerFlammable(Seasonal_Blocks.KAYATABA, 5, 20);
		registerFlammable(Seasonal_Blocks.KAYATABA_STAIRS, 5, 20);

		registerFlammable(Unit_Blocks.UNITDESK, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_spruce, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_birch, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_jungle, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_acacia, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_darkoak, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_sakura, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_kaede, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_ichoh, 5, 20);

		registerFlammable(Unit_Blocks.CAFETABLE, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_spruce, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_birch, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_jungle, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_acacia, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_darkoak, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_sakura, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_kaede, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_ichoh, 5, 20);

		registerFlammable(Unit_Blocks.ENDAI, 5, 20);
		registerFlammable(Unit_Blocks.ENDAI_r, 5, 20);
		registerFlammable(Unit_Blocks.TEATABLE, 5, 20);

		registerFlammable(WallPane_Blocks.PILLAR_oak, 5, 5);
		registerFlammable(WallPane_Blocks.PILLAR_spru, 5, 5);
		registerFlammable(WallPane_Blocks.PILLAR_bir, 5, 5);
		registerFlammable(WallPane_Blocks.PILLAR_jun, 5, 5);
		registerFlammable(WallPane_Blocks.PILLAR_aca, 5, 5);
		registerFlammable(WallPane_Blocks.PILLAR_doak, 5, 5);

		registerFlammable(Wood_Blocks.SAKURA_flow, 30, 60);
		registerFlammable(Wood_Blocks.KAEDE_leaf, 30, 60);
		registerFlammable(Wood_Blocks.ICHOH_leaf, 30, 60);
		registerFlammable(Wood_Blocks.OAKKARE_leaf, 30, 60);
		registerFlammable(Wood_Blocks.SAKURA_log, 5, 5);
		registerFlammable(Wood_Blocks.KAEDE_log, 5, 5);
		registerFlammable(Wood_Blocks.ICHOH_log, 5, 5);

		registerFlammable(Wood_Blocks.SAKURA_planks, 5, 20);
		registerFlammable(Wood_Blocks.KAEDE_planks, 5, 20);
		registerFlammable(Wood_Blocks.ICHOH_planks, 5, 20);
		registerFlammable(Wood_Blocks.SAKURA_slabhalf, 5, 20);
		registerFlammable(Wood_Blocks.KAEDE_slabhalf, 5, 20);
		registerFlammable(Wood_Blocks.ICHOH_slabhalf, 5, 20);
		registerFlammable(Wood_Blocks.SAKURA_stairs, 5, 20);
		registerFlammable(Wood_Blocks.KAEDE_stairs, 5, 20);
		registerFlammable(Wood_Blocks.ICHOH_stairs, 5, 20);
		registerFlammable(Wood_Blocks.PILLAR_saku, 5, 5);
		registerFlammable(Wood_Blocks.PILLAR_kae, 5, 5);
		registerFlammable(Wood_Blocks.PILLAR_ich, 5, 5);
		registerFlammable(Wood_Blocks.SAKURA_carpet, 60, 20);
		registerFlammable(Wood_Blocks.KAEDE_carpet, 60, 20);
		registerFlammable(Wood_Blocks.ICHOH_carpet, 60, 20);
		registerFlammable(Wood_Blocks.OCHIBA_carpet, 60, 20);

	}
	getFireSpreadSpeed, getFlammability
	public static void registerFlammable(Block block, int encouragement, int flammability) {
		FireBlock fireblock = (FireBlock)Blocks.FIRE;
		fireblock.setFireInfo(block, encouragement, flammability);
	} */

}
