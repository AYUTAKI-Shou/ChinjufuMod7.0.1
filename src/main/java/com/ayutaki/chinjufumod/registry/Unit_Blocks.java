package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.unitblock.CafeTable;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Endai;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.TrayFude;
import com.ayutaki.chinjufumod.blocks.unitblock.TrayLetter;
import com.ayutaki.chinjufumod.blocks.unitblock.UnitDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenBook;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenMakimono;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Unit_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block UNITDESK = register("block_unitdesk", unitDesk());
	public static Block UNITDESK_spruce = register("block_unitdesk_spruce", unitDesk());
	public static Block UNITDESK_birch = register("block_unitdesk_birch", unitDesk());
	public static Block UNITDESK_jungle = register("block_unitdesk_jungle", unitDesk());
	public static Block UNITDESK_acacia = register("block_unitdesk_acacia", unitDesk());
	public static Block UNITDESK_darkoak = register("block_unitdesk_darkoak", unitDesk());
	public static Block UNITDESK_sakura = register("block_unitdesk_sakura", unitDesk());
	public static Block UNITDESK_kaede = register("block_unitdesk_kaede", unitDesk());
	public static Block UNITDESK_ichoh = register("block_unitdesk_ichoh", unitDesk());

	public static Block CAFETABLE = register("block_cafetable", cafeTable());
	public static Block CAFETABLE_spruce = register("block_cafetable_spruce", cafeTable());
	public static Block CAFETABLE_birch = register("block_cafetable_birch", cafeTable());
	public static Block CAFETABLE_jungle = register("block_cafetable_jungle", cafeTable());
	public static Block CAFETABLE_acacia = register("block_cafetable_acacia", cafeTable());
	public static Block CAFETABLE_darkoak = register("block_cafetable_darkoak", cafeTable());
	public static Block CAFETABLE_sakura = register("block_cafetable_sakura", cafeTable());
	public static Block CAFETABLE_kaede = register("block_cafetable_kaede", cafeTable());
	public static Block CAFETABLE_ichoh = register("block_cafetable_ichoh", cafeTable());

	public static Block ENDAI = register("block_mendai", endai());
	public static Block ENDAI_r = register("block_mendai_red", endai());
	public static Block TEATABLE = register("block_teatable", cafeTable());

	public static Block LOWDESK = register("block_lowdesk", lowDesk());
	public static Block LOWDESK_spruce = register("block_lowdesk_spruce", lowDesk());
	public static Block LOWDESK_birch = register("block_lowdesk_birch", lowDesk());
	public static Block LOWDESK_jungle = register("block_lowdesk_jungle", lowDesk());
	public static Block LOWDESK_acacia = register("block_lowdesk_acacia", lowDesk());
	public static Block LOWDESK_darkoak = register("block_lowdesk_darkoak", lowDesk());
	public static Block LOWDESK_sakura = register("block_lowdesk_sakura", lowDesk());
	public static Block LOWDESK_kaede = register("block_lowdesk_kaede", lowDesk());
	public static Block LOWDESK_ichoh = register("block_lowdesk_ichoh", lowDesk());

	public static Block LETTERTRAY = register("block_lettertray_c", new TrayLetter(trayState()));
	public static Block FUDETRAY = register("block_fudetray_c", new TrayFude(trayState()));

	public static Block CHABUDAI = register("block_chabudai", chabudai());
	public static Block CHABUDAI_spruce = register("block_chabudai_spruce", chabudai());
	public static Block CHABUDAI_birch = register("block_chabudai_birch", chabudai());
	public static Block CHABUDAI_jungle = register("block_chabudai_jungle", chabudai());
	public static Block CHABUDAI_acacia = register("block_chabudai_acacia", chabudai());
	public static Block CHABUDAI_darkoak = register("block_chabudai_darkoak", chabudai());
	public static Block CHABUDAI_sakura = register("block_chabudai_sakura", chabudai());
	public static Block CHABUDAI_kaede = register("block_chabudai_kaede", chabudai());
	public static Block CHABUDAI_ichoh = register("block_chabudai_ichoh", chabudai());

	public static Block KOTATSU = register("block_kotatsu", kotatsu());
	public static Block KOTATSU_spruce = register("block_kotatsu_spruce", kotatsu());
	public static Block KOTATSU_birch = register("block_kotatsu_birch", kotatsu());
	public static Block KOTATSU_jungle = register("block_kotatsu_jungle", kotatsu());
	public static Block KOTATSU_acacia = register("block_kotatsu_acacia", kotatsu());
	public static Block KOTATSU_darkoak = register("block_kotatsu_darkoak", kotatsu());
	public static Block KOTATSU_sakura = register("block_kotatsu_sakura", kotatsu());
	public static Block KOTATSU_kaede = register("block_kotatsu_kaede", kotatsu());
	public static Block KOTATSU_ichoh = register("block_kotatsu_ichoh", kotatsu());

	public static Block KASA_white = register("block_mkasa_white", wagasa(MaterialColor.SNOW));
	public static Block KASA_orange = register("block_mkasa_orange", wagasa(MaterialColor.ADOBE));
	public static Block KASA_magenta = register("block_mkasa_magenta", wagasa(MaterialColor.MAGENTA));
	public static Block KASA_lightb = register("block_mkasa_lightb", wagasa(MaterialColor.LIGHT_BLUE));
	public static Block KASA_yellow = register("block_mkasa_yellow", wagasa(MaterialColor.YELLOW));
	public static Block KASA_lime = register("block_mkasa_lime", wagasa(MaterialColor.LIME));
	public static Block KASA_pink = register("block_mkasa_pink", wagasa(MaterialColor.PINK));
	public static Block KASA_gray = register("block_mkasa_gray", wagasa(MaterialColor.GRAY));
	public static Block KASA_lightg = register("block_mkasa_lightg", wagasa(MaterialColor.LIGHT_GRAY));
	public static Block KASA_cyan = register("block_mkasa_cyan", wagasa(MaterialColor.CYAN));
	public static Block KASA_purple = register("block_mkasa_purple", wagasa(MaterialColor.PURPLE));
	public static Block KASA_blue = register("block_mkasa_blue", wagasa(MaterialColor.BLUE));
	public static Block KASA_brown = register("block_mkasa_brown", wagasa(MaterialColor.BROWN));
	public static Block KASA_green = register("block_mkasa_green", wagasa(MaterialColor.GREEN));
	public static Block KASA_red = register("block_mkasa_red", wagasa(MaterialColor.RED));
	public static Block KASA_black = register("block_mkasa_black", wagasa(MaterialColor.BLACK));
	
	public static Block WRITTEN_BOOK = register("block_written_book", new WrittenBook(bookState()));
	public static Block WRITTEN_MAKIMONO = register("block_written_makimono", new WrittenMakimono(bookState()));

	/* Share variables */
	private static UnitDesk unitDesk() {
		return new UnitDesk(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static CafeTable cafeTable() {
		return new CafeTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Endai endai() {
		return new Endai(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static LowDesk lowDesk() {
		return new LowDesk(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Chabudai chabudai() {
		return new Chabudai(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Kotatsu kotatsu() {
		return new Kotatsu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Wagasa wagasa(MaterialColor color) {
		return new Wagasa(Block.Properties.create(Material.WOOD, color).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.CLOTH).notSolid());
	}

	private static Properties trayState() {
		return Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).doesNotBlockMovement().notSolid();
	}
	
	private static Properties bookState() {
		return Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.5F).doesNotBlockMovement().notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
