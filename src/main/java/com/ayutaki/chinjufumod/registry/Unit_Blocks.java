package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.unitblock.CafeTable;
import com.ayutaki.chinjufumod.blocks.unitblock.CafeTable_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Endai;
import com.ayutaki.chinjufumod.blocks.unitblock.Endai_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.TrayLetter;
import com.ayutaki.chinjufumod.blocks.unitblock.UnitDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.UnitDesk_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenBook;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenMakimono;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenMakimono5;

import net.minecraft.block.Block;

public final class Unit_Blocks {

	public static Block UNITDESK, UNITDESK_sub;
	public static Block CAFETABLE, CAFETABLE_sub;
	public static Block ENDAI, ENDAI_sub;

	public static Block LOWDESK, LOWDESK_sub;
	public static Block LETTERTRAY;
	public static Block CHABUDAI, CHABUDAI_sub;
	public static Block KOTATSU, KOTATSU_sub;
	public static Block WRITTEN_BOOK, WRITTEN_MAKIMONO, WRITTEN_MAKIMONO5;

	public static void init() {

		UNITDESK = new UnitDesk("block_unitdesk");
		UNITDESK_sub = new UnitDesk_sub("block_unitdesk_sub");
		CAFETABLE = new CafeTable("block_cafetable");
		CAFETABLE_sub = new CafeTable_sub("block_cafetable_sub");
		ENDAI = new Endai("block_mendai");
		ENDAI_sub = new Endai_sub("block_mendai_sub");

		LOWDESK = new LowDesk("block_lowdesk");
		LOWDESK_sub = new LowDesk_sub("block_lowdesk_sub");
		LETTERTRAY = new TrayLetter("block_lettertray_c");
		CHABUDAI = new Chabudai("block_chabudai");
		CHABUDAI_sub = new Chabudai_sub("block_chabudai_sub");
		KOTATSU = new Kotatsu("block_kotatsu");
		KOTATSU_sub = new Kotatsu_sub("block_kotatsu_sub");
		
		WRITTEN_BOOK = new WrittenBook("block_written_book");
		WRITTEN_MAKIMONO = new WrittenMakimono("block_written_makimono");
		WRITTEN_MAKIMONO5 = new WrittenMakimono5("block_written_makimono5");
	}

	public static void register() {

		registerBlock(UNITDESK);
		registerBlock(UNITDESK_sub);
		registerBlock(CAFETABLE);
		registerBlock(CAFETABLE_sub);
		registerBlock(ENDAI);
		registerBlock(ENDAI_sub);

		registerBlock(LOWDESK);
		registerBlock(LOWDESK_sub);
		registerBlock(LETTERTRAY);
		registerBlock(CHABUDAI);
		registerBlock(CHABUDAI_sub);
		registerBlock(KOTATSU);
		registerBlock(KOTATSU_sub);
		registerBlock(WRITTEN_BOOK);
		registerBlock(WRITTEN_MAKIMONO);
		registerBlock(WRITTEN_MAKIMONO5);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
