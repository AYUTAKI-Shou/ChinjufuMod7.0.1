package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Spruce;

import net.minecraft.block.Block;

public class KamoiPlanks_Blocks {

	public static Block KAMOI_oak_oak, KAMOI_spru_oak, KAMOI_bir_oak, KAMOI_jun_oak, KAMOI_aca_oak,
								KAMOI_doak_oak, KAMOI_saku_oak, KAMOI_kae_oak, KAMOI_ich_oak;
	public static Block KAMOI_oak_spru, KAMOI_spru_spru, KAMOI_bir_spru, KAMOI_jun_spru, KAMOI_aca_spru,
								KAMOI_doak_spru, KAMOI_saku_spru, KAMOI_kae_spru, KAMOI_ich_spru;
	public static Block KAMOI_oak_bir, KAMOI_spru_bir, KAMOI_bir_bir, KAMOI_jun_bir, KAMOI_aca_bir,
								KAMOI_doak_bir, KAMOI_saku_bir, KAMOI_kae_bir, KAMOI_ich_bir;
	public static Block KAMOI_oak_jun, KAMOI_spru_jun, KAMOI_bir_jun, KAMOI_jun_jun, KAMOI_aca_jun,
								KAMOI_doak_jun, KAMOI_saku_jun, KAMOI_kae_jun, KAMOI_ich_jun;
	public static Block KAMOI_oak_aca, KAMOI_spru_aca, KAMOI_bir_aca, KAMOI_jun_aca, KAMOI_aca_aca,
								KAMOI_doak_aca, KAMOI_saku_aca, KAMOI_kae_aca, KAMOI_ich_aca;
	public static Block KAMOI_oak_doak, KAMOI_spru_doak, KAMOI_bir_doak, KAMOI_jun_doak, KAMOI_aca_doak,
								KAMOI_doak_doak, KAMOI_saku_doak, KAMOI_kae_doak, KAMOI_ich_doak;

	public static Block KAMOI_oak_saku, KAMOI_spru_saku, KAMOI_bir_saku, KAMOI_jun_saku, KAMOI_aca_saku,
								KAMOI_doak_saku, KAMOI_saku_saku, KAMOI_kae_saku, KAMOI_ich_saku;
	public static Block KAMOI_oak_kae, KAMOI_spru_kae, KAMOI_bir_kae, KAMOI_jun_kae, KAMOI_aca_kae,
								KAMOI_doak_kae, KAMOI_saku_kae, KAMOI_kae_kae, KAMOI_ich_kae;
	public static Block KAMOI_oak_ich, KAMOI_spru_ich, KAMOI_bir_ich, KAMOI_jun_ich, KAMOI_aca_ich,
								KAMOI_doak_ich, KAMOI_saku_ich, KAMOI_kae_ich, KAMOI_ich_ich;


	public static void init() {

		/** ハーフ-柱 **/
		KAMOI_oak_oak = new KamoiPlanks_Oak("block_ka_oak_oak");
		KAMOI_spru_oak = new KamoiPlanks_Oak("block_ka_spru_oak");
		KAMOI_bir_oak = new KamoiPlanks_Oak("block_ka_bir_oak");
		KAMOI_jun_oak = new KamoiPlanks_Oak("block_ka_jun_oak");
		KAMOI_aca_oak = new KamoiPlanks_Oak("block_ka_aca_oak");
		KAMOI_doak_oak = new KamoiPlanks_Oak("block_ka_doak_oak");
		KAMOI_saku_oak = new KamoiPlanks_Oak("block_ka_saku_oak");
		KAMOI_kae_oak = new KamoiPlanks_Oak("block_ka_kae_oak");
		KAMOI_ich_oak = new KamoiPlanks_Oak("block_ka_ich_oak");

		KAMOI_oak_spru = new KamoiPlanks_Spruce("block_ka_oak_spru");
		KAMOI_spru_spru = new KamoiPlanks_Spruce("block_ka_spru_spru");
		KAMOI_bir_spru = new KamoiPlanks_Spruce("block_ka_bir_spru");
		KAMOI_jun_spru = new KamoiPlanks_Spruce("block_ka_jun_spru");
		KAMOI_aca_spru = new KamoiPlanks_Spruce("block_ka_aca_spru");
		KAMOI_doak_spru = new KamoiPlanks_Spruce("block_ka_doak_spru");
		KAMOI_saku_spru = new KamoiPlanks_Spruce("block_ka_saku_spru");
		KAMOI_kae_spru = new KamoiPlanks_Spruce("block_ka_kae_spru");
		KAMOI_ich_spru = new KamoiPlanks_Spruce("block_ka_ich_spru");

		KAMOI_oak_bir = new KamoiPlanks_Birch("block_ka_oak_bir");
		KAMOI_spru_bir = new KamoiPlanks_Birch("block_ka_spru_bir");
		KAMOI_bir_bir = new KamoiPlanks_Birch("block_ka_bir_bir");
		KAMOI_jun_bir = new KamoiPlanks_Birch("block_ka_jun_bir");
		KAMOI_aca_bir = new KamoiPlanks_Birch("block_ka_aca_bir");
		KAMOI_doak_bir = new KamoiPlanks_Birch("block_ka_doak_bir");
		KAMOI_saku_bir = new KamoiPlanks_Birch("block_ka_saku_bir");
		KAMOI_kae_bir = new KamoiPlanks_Birch("block_ka_kae_bir");
		KAMOI_ich_bir = new KamoiPlanks_Birch("block_ka_ich_bir");

		KAMOI_oak_jun = new KamoiPlanks_Jungle("block_ka_oak_jun");
		KAMOI_spru_jun = new KamoiPlanks_Jungle("block_ka_spru_jun");
		KAMOI_bir_jun = new KamoiPlanks_Jungle("block_ka_bir_jun");
		KAMOI_jun_jun = new KamoiPlanks_Jungle("block_ka_jun_jun");
		KAMOI_aca_jun = new KamoiPlanks_Jungle("block_ka_aca_jun");
		KAMOI_doak_jun = new KamoiPlanks_Jungle("block_ka_doak_jun");
		KAMOI_saku_jun = new KamoiPlanks_Jungle("block_ka_saku_jun");
		KAMOI_kae_jun = new KamoiPlanks_Jungle("block_ka_kae_jun");
		KAMOI_ich_jun = new KamoiPlanks_Jungle("block_ka_ich_jun");

		KAMOI_oak_aca = new KamoiPlanks_Acacia("block_ka_oak_aca");
		KAMOI_spru_aca = new KamoiPlanks_Acacia("block_ka_spru_aca");
		KAMOI_bir_aca = new KamoiPlanks_Acacia("block_ka_bir_aca");
		KAMOI_jun_aca = new KamoiPlanks_Acacia("block_ka_jun_aca");
		KAMOI_aca_aca = new KamoiPlanks_Acacia("block_ka_aca_aca");
		KAMOI_doak_aca = new KamoiPlanks_Acacia("block_ka_doak_aca");
		KAMOI_saku_aca = new KamoiPlanks_Acacia("block_ka_saku_aca");
		KAMOI_kae_aca = new KamoiPlanks_Acacia("block_ka_kae_aca");
		KAMOI_ich_aca = new KamoiPlanks_Acacia("block_ka_ich_aca");

		KAMOI_oak_doak = new KamoiPlanks_DarkOak("block_ka_oak_doak");
		KAMOI_spru_doak = new KamoiPlanks_DarkOak("block_ka_spru_doak");
		KAMOI_bir_doak = new KamoiPlanks_DarkOak("block_ka_bir_doak");
		KAMOI_jun_doak = new KamoiPlanks_DarkOak("block_ka_jun_doak");
		KAMOI_aca_doak = new KamoiPlanks_DarkOak("block_ka_aca_doak");
		KAMOI_doak_doak = new KamoiPlanks_DarkOak("block_ka_doak_doak");
		KAMOI_saku_doak = new KamoiPlanks_DarkOak("block_ka_saku_doak");
		KAMOI_kae_doak = new KamoiPlanks_DarkOak("block_ka_kae_doak");
		KAMOI_ich_doak = new KamoiPlanks_DarkOak("block_ka_ich_doak");

		KAMOI_oak_saku = new KamoiPlanks_Sakura("block_ka_oak_saku");
		KAMOI_spru_saku = new KamoiPlanks_Sakura("block_ka_spru_saku");
		KAMOI_bir_saku = new KamoiPlanks_Sakura("block_ka_bir_saku");
		KAMOI_jun_saku = new KamoiPlanks_Sakura("block_ka_jun_saku");
		KAMOI_aca_saku = new KamoiPlanks_Sakura("block_ka_aca_saku");
		KAMOI_doak_saku = new KamoiPlanks_Sakura("block_ka_doak_saku");
		KAMOI_saku_saku = new KamoiPlanks_Sakura("block_ka_saku_saku");
		KAMOI_kae_saku = new KamoiPlanks_Sakura("block_ka_kae_saku");
		KAMOI_ich_saku = new KamoiPlanks_Sakura("block_ka_ich_saku");

		KAMOI_oak_kae = new KamoiPlanks_Kaede("block_ka_oak_kae");
		KAMOI_spru_kae = new KamoiPlanks_Kaede("block_ka_spru_kae");
		KAMOI_bir_kae = new KamoiPlanks_Kaede("block_ka_bir_kae");
		KAMOI_jun_kae = new KamoiPlanks_Kaede("block_ka_jun_kae");
		KAMOI_aca_kae = new KamoiPlanks_Kaede("block_ka_aca_kae");
		KAMOI_doak_kae = new KamoiPlanks_Kaede("block_ka_doak_kae");
		KAMOI_saku_kae = new KamoiPlanks_Kaede("block_ka_saku_kae");
		KAMOI_kae_kae = new KamoiPlanks_Kaede("block_ka_kae_kae");
		KAMOI_ich_kae = new KamoiPlanks_Kaede("block_ka_ich_kae");

		KAMOI_oak_ich = new KamoiPlanks_Ichoh("block_ka_oak_ich");
		KAMOI_spru_ich = new KamoiPlanks_Ichoh("block_ka_spru_ich");
		KAMOI_bir_ich = new KamoiPlanks_Ichoh("block_ka_bir_ich");
		KAMOI_jun_ich = new KamoiPlanks_Ichoh("block_ka_jun_ich");
		KAMOI_aca_ich = new KamoiPlanks_Ichoh("block_ka_aca_ich");
		KAMOI_doak_ich = new KamoiPlanks_Ichoh("block_ka_doak_ich");
		KAMOI_saku_ich = new KamoiPlanks_Ichoh("block_ka_saku_ich");
		KAMOI_kae_ich = new KamoiPlanks_Ichoh("block_ka_kae_ich");
		KAMOI_ich_ich = new KamoiPlanks_Ichoh("block_ka_ich_ich");
	}


	public static void register() {
		registerBlock(KAMOI_oak_oak);
		registerBlock(KAMOI_spru_oak);
		registerBlock(KAMOI_bir_oak);
		registerBlock(KAMOI_jun_oak);
		registerBlock(KAMOI_aca_oak);
		registerBlock(KAMOI_doak_oak);
		registerBlock(KAMOI_saku_oak);
		registerBlock(KAMOI_kae_oak);
		registerBlock(KAMOI_ich_oak);

		registerBlock(KAMOI_oak_spru);
		registerBlock(KAMOI_spru_spru);
		registerBlock(KAMOI_bir_spru);
		registerBlock(KAMOI_jun_spru);
		registerBlock(KAMOI_aca_spru);
		registerBlock(KAMOI_doak_spru);
		registerBlock(KAMOI_saku_spru);
		registerBlock(KAMOI_kae_spru);
		registerBlock(KAMOI_ich_spru);

		registerBlock(KAMOI_oak_bir);
		registerBlock(KAMOI_spru_bir);
		registerBlock(KAMOI_bir_bir);
		registerBlock(KAMOI_jun_bir);
		registerBlock(KAMOI_aca_bir);
		registerBlock(KAMOI_doak_bir);
		registerBlock(KAMOI_saku_bir);
		registerBlock(KAMOI_kae_bir);
		registerBlock(KAMOI_ich_bir);

		registerBlock(KAMOI_oak_jun);
		registerBlock(KAMOI_spru_jun);
		registerBlock(KAMOI_bir_jun);
		registerBlock(KAMOI_jun_jun);
		registerBlock(KAMOI_aca_jun);
		registerBlock(KAMOI_doak_jun);
		registerBlock(KAMOI_saku_jun);
		registerBlock(KAMOI_kae_jun);
		registerBlock(KAMOI_ich_jun);

		registerBlock(KAMOI_oak_aca);
		registerBlock(KAMOI_spru_aca);
		registerBlock(KAMOI_bir_aca);
		registerBlock(KAMOI_jun_aca);
		registerBlock(KAMOI_aca_aca);
		registerBlock(KAMOI_doak_aca);
		registerBlock(KAMOI_saku_aca);
		registerBlock(KAMOI_kae_aca);
		registerBlock(KAMOI_ich_aca);

		registerBlock(KAMOI_oak_doak);
		registerBlock(KAMOI_spru_doak);
		registerBlock(KAMOI_bir_doak);
		registerBlock(KAMOI_jun_doak);
		registerBlock(KAMOI_aca_doak);
		registerBlock(KAMOI_doak_doak);
		registerBlock(KAMOI_saku_doak);
		registerBlock(KAMOI_kae_doak);
		registerBlock(KAMOI_ich_doak);

		registerBlock(KAMOI_oak_saku);
		registerBlock(KAMOI_spru_saku);
		registerBlock(KAMOI_bir_saku);
		registerBlock(KAMOI_jun_saku);
		registerBlock(KAMOI_aca_saku);
		registerBlock(KAMOI_doak_saku);
		registerBlock(KAMOI_saku_saku);
		registerBlock(KAMOI_kae_saku);
		registerBlock(KAMOI_ich_saku);

		registerBlock(KAMOI_oak_kae);
		registerBlock(KAMOI_spru_kae);
		registerBlock(KAMOI_bir_kae);
		registerBlock(KAMOI_jun_kae);
		registerBlock(KAMOI_aca_kae);
		registerBlock(KAMOI_doak_kae);
		registerBlock(KAMOI_saku_kae);
		registerBlock(KAMOI_kae_kae);
		registerBlock(KAMOI_ich_kae);

		registerBlock(KAMOI_oak_ich);
		registerBlock(KAMOI_spru_ich);
		registerBlock(KAMOI_bir_ich);
		registerBlock(KAMOI_jun_ich);
		registerBlock(KAMOI_aca_ich);
		registerBlock(KAMOI_doak_ich);
		registerBlock(KAMOI_saku_ich);
		registerBlock(KAMOI_kae_ich);
		registerBlock(KAMOI_ich_ich);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
