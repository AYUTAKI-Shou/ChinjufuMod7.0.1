package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoor;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Garasudo_Blocks {

	public static GlassDoor GARASUDO;
	public static GlassDoor GARASUDO_ACA;
	public static GlassDoor GARASUDO_BIR;
	public static GlassDoor GARASUDO_DOAK;
	public static GlassDoor GARASUDO_JUN;
	public static GlassDoor GARASUDO_SPRU;
	public static GlassDoor GARASUDO_SAKU;
	public static GlassDoor GARASUDO_ICH;
	public static GlassDoor GARASUDO_KAE;

	public static GlassDoor GARASUDOB;
	public static GlassDoor GARASUDOB_ACA;
	public static GlassDoor GARASUDOB_BIR;
	public static GlassDoor GARASUDOB_DOAK;
	public static GlassDoor GARASUDOB_JUN;
	public static GlassDoor GARASUDOB_SPRU;
	public static GlassDoor GARASUDOB_SAKU;
	public static GlassDoor GARASUDOB_ICH;
	public static GlassDoor GARASUDOB_KAE;


	/* -> main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		GARASUDO = new GlassDoor("block_garasudo");
		GARASUDO_ACA = new GlassDoor("block_garasudo_acacia");
		GARASUDO_BIR = new GlassDoor("block_garasudo_birch");
		GARASUDO_DOAK = new GlassDoor("block_garasudo_darkoak");
		GARASUDO_JUN = new GlassDoor("block_garasudo_jungle");
		GARASUDO_SPRU = new GlassDoor("block_garasudo_spruce");
		GARASUDO_SAKU = new GlassDoor("block_garasudo_sakura");
		GARASUDO_ICH = new GlassDoor("block_garasudo_ichoh");
		GARASUDO_KAE = new GlassDoor("block_garasudo_kaede");

		GARASUDOB = new GlassDoor("block_garasudob");
		GARASUDOB_ACA = new GlassDoor("block_garasudob_acacia");
		GARASUDOB_BIR = new GlassDoor("block_garasudob_birch");
		GARASUDOB_DOAK = new GlassDoor("block_garasudob_darkoak");
		GARASUDOB_JUN = new GlassDoor("block_garasudob_jungle");
		GARASUDOB_SPRU = new GlassDoor("block_garasudob_spruce");
		GARASUDOB_SAKU = new GlassDoor("block_garasudob_sakura");
		GARASUDOB_ICH = new GlassDoor("block_garasudob_ichoh");
		GARASUDOB_KAE = new GlassDoor("block_garasudob_kaede");
	}
}
