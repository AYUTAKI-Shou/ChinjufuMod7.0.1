package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.slidedoor.Shouji;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Shouji_Blocks {

	public static Shouji SHOUJI;
	public static Shouji SHOUJI_ACA;
	public static Shouji SHOUJI_BIR;
	public static Shouji SHOUJI_DOAK;
	public static Shouji SHOUJI_JUN;
	public static Shouji SHOUJI_SPRU;
	public static Shouji SHOUJI_SAKU;
	public static Shouji SHOUJI_ICH;
	public static Shouji SHOUJI_KAE;

	public static Shouji SHOUJIB;
	public static Shouji SHOUJIB_ACA;
	public static Shouji SHOUJIB_BIR;
	public static Shouji SHOUJIB_DOAK;
	public static Shouji SHOUJIB_JUN;
	public static Shouji SHOUJIB_SPRU;
	public static Shouji SHOUJIB_SAKU;
	public static Shouji SHOUJIB_ICH;
	public static Shouji SHOUJIB_KAE;


	/* -> main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		SHOUJI = new Shouji("block_shouji");
		SHOUJI_ACA = new Shouji("block_shouji_acacia");
		SHOUJI_BIR = new Shouji("block_shouji_birch");
		SHOUJI_DOAK = new Shouji("block_shouji_darkoak");
		SHOUJI_JUN = new Shouji("block_shouji_jungle");
		SHOUJI_SPRU = new Shouji("block_shouji_spruce");
		SHOUJI_SAKU = new Shouji("block_shouji_sakura");
		SHOUJI_ICH = new Shouji("block_shouji_ichoh");
		SHOUJI_KAE = new Shouji("block_shouji_kaede");

		SHOUJIB = new Shouji("block_shoujib");
		SHOUJIB_ACA = new Shouji("block_shoujib_acacia");
		SHOUJIB_BIR = new Shouji("block_shoujib_birch");
		SHOUJIB_DOAK = new Shouji("block_shoujib_darkoak");
		SHOUJIB_JUN = new Shouji("block_shoujib_jungle");
		SHOUJIB_SPRU = new Shouji("block_shoujib_spruce");
		SHOUJIB_SAKU = new Shouji("block_shoujib_sakura");
		SHOUJIB_ICH = new Shouji("block_shoujib_ichoh");
		SHOUJIB_KAE = new Shouji("block_shoujib_kaede");
	}
}
