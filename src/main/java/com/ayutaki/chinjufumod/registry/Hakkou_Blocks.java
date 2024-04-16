package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Dashi;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Hakkou;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Komezu;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Shouyu;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Cheese_block;
import com.ayutaki.chinjufumod.blocks.hakkou.Cheese_curd;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Wine;
import com.ayutaki.chinjufumod.blocks.hakkou.Kara_Bottle;
import com.ayutaki.chinjufumod.blocks.hakkou.Kara_Bottle_Mead;
import com.ayutaki.chinjufumod.blocks.hakkou.Kara_Bottle_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke_full;
import com.ayutaki.chinjufumod.blocks.hakkou.NabeAmazake_cooked;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Budoushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Cocoa;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Hachimitsushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Ringoshu;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Hakkou;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_HakusaiDuke;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Shouyu;
import com.ayutaki.chinjufumod.blocks.hakkou.Zundou_ColdMilk;

import net.minecraft.block.Block;

public final class Hakkou_Blocks {

	public static Block MIZUOKE, MIZUOKE_full;

	public static Block NAMASAKEBOT, SAKEBOT, JUKUSAKEBOT, NABEAMAZAKE;

	public static Block WINEBOT, JUKUWINEBOT, CIDERBOT, JUKUCIDERBOT, MEADBOT, JUKUMEADBOT;
	public static Block SAKEGLASS, WINEGLASS;

	public static Block KARABOT, KARABOTJP, KARABOTMEAD;

	public static Block HAKKOUBOT;

	public static Block COLD_MILK;
	public static Block CHEESE_CURD, CHEESE;

	public static Block SHOUYU_bot, KOMEZU_bot, DASHI_bot;

	public static Block HAKKOUTARU, SHOUYUTARU, HAKUSAITARU;
	public static Block RINGOSHU_TARU, BUDOUSHU_TARU, HACHIMITSUSHU_TARU, COCOA_TARU;


	public static void init() {

		MIZUOKE = new Mizuoke("block_mizuoke");
		MIZUOKE_full = new Mizuoke_full("block_mizuoke_full");

		NAMASAKEBOT = new Bottle_Sake("block_bot_sakenama_1");
		SAKEBOT = new Bottle_Sake("block_bot_sake_1");
		JUKUSAKEBOT = new Bottle_Sake("block_bot_sakejuku_1");
		NABEAMAZAKE = new NabeAmazake_cooked("block_food_nabeaz_1");

		WINEBOT = new Bottle_Sake("block_bot_wine_1");
		JUKUWINEBOT = new Bottle_Sake("block_bot_winejuku_1");
		CIDERBOT = new Bottle_Sake("block_bot_cider_1");
		JUKUCIDERBOT = new Bottle_Sake("block_bot_ciderjuku_1");
		MEADBOT = new Bottle_Sake("block_bot_mead_1");
		JUKUMEADBOT = new Bottle_Sake("block_bot_meadjuku_1");

		SAKEGLASS = new Glass_Sake("block_glass_sake");
		WINEGLASS = new Glass_Wine("block_glass_wine");

		KARABOT = new Kara_Bottle("block_bot_wine_k");
		KARABOTJP = new Kara_Bottle_Sake("block_bot_sake_k");
		KARABOTMEAD = new Kara_Bottle_Mead("block_bot_mead_k");

		HAKKOUBOT = new Bin_Hakkou("block_bin_hakkou");

		COLD_MILK = new Zundou_ColdMilk("block_zundou_coldmilk");
		CHEESE_CURD = new Cheese_curd("block_food_cheesecurd");
		CHEESE = new Cheese_block("block_food_cheese_1");

		SHOUYU_bot = new Bin_Shouyu("block_shouyu_bot");
		KOMEZU_bot = new Bin_Komezu("block_komezu_bot");
		DASHI_bot = new Bin_Dashi("block_dashi_bot");

		HAKKOUTARU = new Taru_Hakkou("block_taru_hakkou");
		RINGOSHU_TARU = new TaruY_Ringoshu("block_taru_ringoshu_f");
		BUDOUSHU_TARU = new TaruY_Budoushu("block_taru_budoushu_f");
		HACHIMITSUSHU_TARU = new TaruY_Hachimitsushu("block_taru_hachimitsushu_f");
		COCOA_TARU = new TaruY_Cocoa("block_taru_cocoa_f");

		SHOUYUTARU = new Taru_Shouyu("block_taru_hakkou_2");
		HAKUSAITARU = new Taru_HakusaiDuke("block_taru_hakusai_f");
	}

	public static void register() {

		registerBlock(MIZUOKE);
		registerBlock(MIZUOKE_full);

		registerBlock(NAMASAKEBOT);
		registerBlock(SAKEBOT);
		registerBlock(JUKUSAKEBOT);
		registerBlock(NABEAMAZAKE);

		registerBlock(WINEBOT);
		registerBlock(JUKUWINEBOT);
		registerBlock(CIDERBOT);
		registerBlock(JUKUCIDERBOT);
		registerBlock(MEADBOT);
		registerBlock(JUKUMEADBOT);

		registerBlock(SAKEGLASS);
		registerBlock(WINEGLASS);

		registerBlock(KARABOT);
		registerBlock(KARABOTJP);
		registerBlock(KARABOTMEAD);

		registerBlock(HAKKOUBOT);

		registerBlock(COLD_MILK);
		registerBlock(CHEESE_CURD);
		registerBlock(CHEESE);

		registerBlock(SHOUYU_bot);
		registerBlock(KOMEZU_bot);
		registerBlock(DASHI_bot);

		registerBlock(HAKKOUTARU);
		registerBlock(RINGOSHU_TARU);
		registerBlock(BUDOUSHU_TARU);
		registerBlock(HACHIMITSUSHU_TARU);

		registerBlock(COCOA_TARU);
		registerBlock(SHOUYUTARU);
		registerBlock(HAKUSAITARU);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
}
