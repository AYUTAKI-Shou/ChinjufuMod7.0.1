package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.amado.AmadoWindow;
import com.ayutaki.chinjufumod.blocks.amado.Amado_Bot;
import com.ayutaki.chinjufumod.blocks.amado.Amado_Top;
import com.ayutaki.chinjufumod.blocks.amado.TobukuroWindowL;
import com.ayutaki.chinjufumod.blocks.amado.TobukuroWindowR;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_BotL;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_BotL2;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_BotR;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_BotR2;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_TopL;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_TopL2;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_TopR;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_TopR2;
import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoorHalf;
import com.ayutaki.chinjufumod.blocks.slidedoor.ShoujiHalf;
import com.ayutaki.chinjufumod.blocks.slidedoor.ShoujiWindow;

import net.minecraft.block.Block;

public final class Slidedoor_Blocks {

	public static Block GARASUDOH, GARASUDOH_SPRU, GARASUDOH_BIR,
								GARASUDOH_JUN, GARASUDOH_ACA, GARASUDOH_DOAK,
								GARASUDOH_SAKU, GARASUDOH_KAE, GARASUDOH_ICH;

	public static Block SHOUJIH, SHOUJIH_SPRU, SHOUJIH_BIR,
								SHOUJIH_JUN, SHOUJIH_ACA, SHOUJIH_DOAK,
								SHOUJIH_SAKU, SHOUJIH_KAE, SHOUJIH_ICH;

	public static Block SHOUJIWIN_oak, SHOUJIWIN_acacia, SHOUJIWIN_birch,
								SHOUJIWIN_darkoak, SHOUJIWIN_jungle, SHOUJIWIN_spruce,
								SHOUJIWIN_sakura, SHOUJIWIN_kaede, SHOUJIWIN_ichoh;

	public static Block SHOUJIWINR_oak, SHOUJIWINR_acacia, SHOUJIWINR_birch,
								SHOUJIWINR_darkoak, SHOUJIWINR_jungle, SHOUJIWINR_spruce,
								SHOUJIWINR_sakura, SHOUJIWINR_kaede, SHOUJIWINR_ichoh;

	public static Block AMADOS_WIN, AMADOS_TOP, AMADOS_BOT;
	public static Block TOBUKUROS_WINR, TOBUKUROS_WINL;
	public static Block TOBUKUROS_TOPR2, TOBUKUROS_TOPR, TOBUKUROS_BOTR2, TOBUKUROS_BOTR;
	public static Block TOBUKUROS_TOPL2, TOBUKUROS_TOPL, TOBUKUROS_BOTL2, TOBUKUROS_BOTL;

	public static Block AMADO_WIN, AMADO_TOP, AMADO_BOT;
	public static Block TOBUKURO_WINR, TOBUKURO_WINL;
	public static Block TOBUKURO_TOPR2, TOBUKURO_TOPR, TOBUKURO_BOTR2, TOBUKURO_BOTR;
	public static Block TOBUKURO_TOPL2, TOBUKURO_TOPL, TOBUKURO_BOTL2, TOBUKURO_BOTL;


	public static void init() {

		GARASUDOH = new GlassDoorHalf("block_garasudohalf");
		GARASUDOH_SPRU = new GlassDoorHalf("block_garasudohalf_spruce");
		GARASUDOH_BIR = new GlassDoorHalf("block_garasudohalf_birch");
		GARASUDOH_JUN = new GlassDoorHalf("block_garasudohalf_jungle");
		GARASUDOH_ACA = new GlassDoorHalf("block_garasudohalf_acacia");
		GARASUDOH_DOAK = new GlassDoorHalf("block_garasudohalf_darkoak");
		GARASUDOH_SAKU = new GlassDoorHalf("block_garasudohalf_sakura");
		GARASUDOH_KAE = new GlassDoorHalf("block_garasudohalf_kaede");
		GARASUDOH_ICH = new GlassDoorHalf("block_garasudohalf_ichoh");

		SHOUJIH = new ShoujiHalf("block_shoujihalf");
		SHOUJIH_SPRU = new ShoujiHalf("block_shoujihalf_spruce");
		SHOUJIH_BIR = new ShoujiHalf("block_shoujihalf_birch");
		SHOUJIH_JUN = new ShoujiHalf("block_shoujihalf_jungle");
		SHOUJIH_ACA = new ShoujiHalf("block_shoujihalf_acacia");
		SHOUJIH_DOAK = new ShoujiHalf("block_shoujihalf_darkoak");
		SHOUJIH_SAKU = new ShoujiHalf("block_shoujihalf_sakura");
		SHOUJIH_KAE = new ShoujiHalf("block_shoujihalf_kaede");
		SHOUJIH_ICH = new ShoujiHalf("block_shoujihalf_ichoh");

		SHOUJIWIN_oak = new ShoujiWindow("block_shoujih");
		SHOUJIWIN_acacia = new ShoujiWindow("block_shoujih_acacia");
		SHOUJIWIN_birch = new ShoujiWindow("block_shoujih_birch");
		SHOUJIWIN_darkoak = new ShoujiWindow("block_shoujih_darkoak");
		SHOUJIWIN_jungle = new ShoujiWindow("block_shoujih_jungle");
		SHOUJIWIN_spruce = new ShoujiWindow("block_shoujih_spruce");
		SHOUJIWIN_sakura = new ShoujiWindow("block_shoujih_sakura");
		SHOUJIWIN_kaede = new ShoujiWindow("block_shoujih_kaede");
		SHOUJIWIN_ichoh = new ShoujiWindow("block_shoujih_ichoh");

		SHOUJIWINR_oak = new ShoujiWindow("block_shoujihr");
		SHOUJIWINR_acacia = new ShoujiWindow("block_shoujihr_acacia");
		SHOUJIWINR_birch = new ShoujiWindow("block_shoujihr_birch");
		SHOUJIWINR_darkoak = new ShoujiWindow("block_shoujihr_darkoak");
		SHOUJIWINR_jungle = new ShoujiWindow("block_shoujihr_jungle");
		SHOUJIWINR_spruce = new ShoujiWindow("block_shoujihr_spruce");
		SHOUJIWINR_sakura = new ShoujiWindow("block_shoujihr_sakura");
		SHOUJIWINR_kaede = new ShoujiWindow("block_shoujihr_kaede");
		SHOUJIWINR_ichoh = new ShoujiWindow("block_shoujihr_ichoh");

		AMADOS_WIN = new AmadoWindow("block_amados_window");
		AMADOS_TOP = new Amado_Top("block_amados_top");
		AMADOS_BOT = new Amado_Bot("block_amados_bot");

		TOBUKUROS_WINR = new TobukuroWindowR("block_tobukuros_wr");
		TOBUKUROS_WINL = new TobukuroWindowL("block_tobukuros_wl");

		TOBUKUROS_TOPR2 = new Tobukuro_TopR2("block_tobukuros_topr2");
		TOBUKUROS_TOPR = new Tobukuro_TopR("block_tobukuros_topr");
		TOBUKUROS_BOTR2 = new Tobukuro_BotR2("block_tobukuros_botr2");
		TOBUKUROS_BOTR = new Tobukuro_BotR("block_tobukuros_botr");

		TOBUKUROS_TOPL2 = new Tobukuro_TopL2("block_tobukuros_topl2");
		TOBUKUROS_TOPL = new Tobukuro_TopL("block_tobukuros_topl");
		TOBUKUROS_BOTL2 = new Tobukuro_BotL2("block_tobukuros_botl2");
		TOBUKUROS_BOTL = new Tobukuro_BotL("block_tobukuros_botl");


		AMADO_WIN = new AmadoWindow("block_amado_window");
		AMADO_TOP = new Amado_Top("block_amado_top");
		AMADO_BOT = new Amado_Bot("block_amado_bot");

		TOBUKURO_WINR = new TobukuroWindowR("block_tobukuro_wr");
		TOBUKURO_WINL = new TobukuroWindowL("block_tobukuro_wl");

		TOBUKURO_TOPR2 = new Tobukuro_TopR2("block_tobukuro_topr2");
		TOBUKURO_TOPR = new Tobukuro_TopR("block_tobukuro_topr");
		TOBUKURO_BOTR2 = new Tobukuro_BotR2("block_tobukuro_botr2");
		TOBUKURO_BOTR = new Tobukuro_BotR("block_tobukuro_botr");

		TOBUKURO_TOPL2 = new Tobukuro_TopL2("block_tobukuro_topl2");
		TOBUKURO_TOPL = new Tobukuro_TopL("block_tobukuro_topl");
		TOBUKURO_BOTL2 = new Tobukuro_BotL2("block_tobukuro_botl2");
		TOBUKURO_BOTL = new Tobukuro_BotL("block_tobukuro_botl");
	}


	public static void register() {

		registerBlock(GARASUDOH);
		registerBlock(GARASUDOH_SPRU);
		registerBlock(GARASUDOH_BIR);
		registerBlock(GARASUDOH_JUN);
		registerBlock(GARASUDOH_ACA);
		registerBlock(GARASUDOH_DOAK);
		registerBlock(GARASUDOH_SAKU);
		registerBlock(GARASUDOH_KAE);
		registerBlock(GARASUDOH_ICH);

		registerBlock(SHOUJIH);
		registerBlock(SHOUJIH_SPRU);
		registerBlock(SHOUJIH_BIR);
		registerBlock(SHOUJIH_JUN);
		registerBlock(SHOUJIH_ACA);
		registerBlock(SHOUJIH_DOAK);
		registerBlock(SHOUJIH_SAKU);
		registerBlock(SHOUJIH_KAE);
		registerBlock(SHOUJIH_ICH);

		registerBlock(SHOUJIWIN_oak);
		registerBlock(SHOUJIWIN_acacia);
		registerBlock(SHOUJIWIN_birch);
		registerBlock(SHOUJIWIN_darkoak);
		registerBlock(SHOUJIWIN_jungle);
		registerBlock(SHOUJIWIN_spruce);
		registerBlock(SHOUJIWIN_sakura);
		registerBlock(SHOUJIWIN_kaede);
		registerBlock(SHOUJIWIN_ichoh);

		registerBlock(SHOUJIWINR_oak);
		registerBlock(SHOUJIWINR_acacia);
		registerBlock(SHOUJIWINR_birch);
		registerBlock(SHOUJIWINR_darkoak);
		registerBlock(SHOUJIWINR_jungle);
		registerBlock(SHOUJIWINR_spruce);
		registerBlock(SHOUJIWINR_sakura);
		registerBlock(SHOUJIWINR_kaede);
		registerBlock(SHOUJIWINR_ichoh);

		registerBlock(AMADOS_WIN);
		registerBlock(AMADOS_TOP);
		registerBlock(AMADOS_BOT);
		registerBlock(TOBUKUROS_WINR);
		registerBlock(TOBUKUROS_WINL);
		registerBlock(TOBUKUROS_TOPR2);
		registerBlock(TOBUKUROS_TOPR);
		registerBlock(TOBUKUROS_BOTR2);
		registerBlock(TOBUKUROS_BOTR);
		registerBlock(TOBUKUROS_TOPL2);
		registerBlock(TOBUKUROS_TOPL);
		registerBlock(TOBUKUROS_BOTL2);
		registerBlock(TOBUKUROS_BOTL);

		registerBlock(AMADO_WIN);
		registerBlock(AMADO_TOP);
		registerBlock(AMADO_BOT);
		registerBlock(TOBUKURO_WINR);
		registerBlock(TOBUKURO_WINL);
		registerBlock(TOBUKURO_TOPR2);
		registerBlock(TOBUKURO_TOPR);
		registerBlock(TOBUKURO_BOTR2);
		registerBlock(TOBUKURO_BOTR);
		registerBlock(TOBUKURO_TOPL2);
		registerBlock(TOBUKURO_TOPL);
		registerBlock(TOBUKURO_BOTL2);
		registerBlock(TOBUKURO_BOTL);

	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
