package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_1;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_2;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_3;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_4;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.HangLamp;
import com.ayutaki.chinjufumod.blocks.furniture.LightEmbed;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_1;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_2;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_3;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_4;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Candle;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_HangLamp;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_MarineLamp;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_StandBedroom;
import com.ayutaki.chinjufumod.blocks.furniture.MarineLamp;
import com.ayutaki.chinjufumod.blocks.furniture.StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.StandBedroom;
import com.ayutaki.chinjufumod.blocks.garden.Lit_Takeakari;
import com.ayutaki.chinjufumod.blocks.garden.Takeakari;

import net.minecraft.block.Block;

public class Lamp_Blocks {

	public static Block CANDLE, LIT_CANDLE;

	public static Block LAMP, STANDARM, STAND, M_LAMP;
	public static Block LIT_LAMP, LIT_STANDARM, LIT_STAND, LIT_M_LAMP, E_LIGHT;

	public static Block ANDON_1, ANDON_2, ANDON_3, ANDON_4;
	public static Block LIT_ANDON_1, LIT_ANDON_2, LIT_ANDON_3, LIT_ANDON_4;

	public static Block TAKEAKARI, LIT_TAKEAKARI;


	public static void init() {
		CANDLE = new Candle("block_candle");
		LIT_CANDLE = new Lit_Candle("lit_candle");

		LAMP = new HangLamp("block_lamp");
		STANDARM = new StandArm("block_standarm");
		STAND = new StandBedroom("block_standbedroom");
		M_LAMP = new MarineLamp("block_marinelamp");
		LIT_LAMP = new Lit_HangLamp("lit_lamp");
		LIT_STANDARM = new Lit_StandArm("lit_standarm");
		LIT_STAND = new Lit_StandBedroom("lit_standbedroom");
		LIT_M_LAMP = new Lit_MarineLamp("lit_marinelamp");
		E_LIGHT = new LightEmbed("block_lightembed");
		
		ANDON_1 = new Andon_1("block_andon");
		ANDON_2 = new Andon_2("block_andon_2");
		ANDON_3 = new Andon_3("block_andon_3");
		ANDON_4 = new Andon_4("block_andon_4");
		LIT_ANDON_1 = new Lit_Andon_1("lit_andon");
		LIT_ANDON_2 = new Lit_Andon_2("lit_andon_2");
		LIT_ANDON_3 = new Lit_Andon_3("lit_andon_3");
		LIT_ANDON_4 = new Lit_Andon_4("lit_andon_4");

		TAKEAKARI = new Takeakari("block_takeakari");
		LIT_TAKEAKARI = new Lit_Takeakari("lit_takeakari");
	}


	public static void register() {
		registerBlock(CANDLE);
		registerBlock(LIT_CANDLE);

		registerBlock(LAMP);
		registerBlock(STANDARM);
		registerBlock(STAND);
		registerBlock(M_LAMP);
		registerBlock(LIT_LAMP);
		registerBlock(LIT_STANDARM);
		registerBlock(LIT_STAND);
		registerBlock(LIT_M_LAMP);
		registerBlock(E_LIGHT);
		registerBlock(ANDON_1);
		registerBlock(ANDON_2);
		registerBlock(ANDON_3);
		registerBlock(ANDON_4);
		registerBlock(LIT_ANDON_1);
		registerBlock(LIT_ANDON_2);
		registerBlock(LIT_ANDON_3);
		registerBlock(LIT_ANDON_4);

		registerBlock(TAKEAKARI);
		registerBlock(LIT_TAKEAKARI);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
