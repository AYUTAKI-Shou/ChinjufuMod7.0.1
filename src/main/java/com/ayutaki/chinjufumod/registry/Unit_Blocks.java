package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

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

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Unit_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> UNITDESK = register("block_unitdesk", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_spruce = register("block_unitdesk_spruce", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_birch = register("block_unitdesk_birch", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_jungle = register("block_unitdesk_jungle", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_acacia = register("block_unitdesk_acacia", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_darkoak = register("block_unitdesk_darkoak", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_sakura = register("block_unitdesk_sakura", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_kaede = register("block_unitdesk_kaede", () -> unitDesk());
	public static final RegistryObject<Block> UNITDESK_ichoh = register("block_unitdesk_ichoh", () -> unitDesk());

	public static final RegistryObject<Block> CAFETABLE = register("block_cafetable", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_spruce = register("block_cafetable_spruce", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_birch = register("block_cafetable_birch", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_jungle = register("block_cafetable_jungle", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_acacia = register("block_cafetable_acacia", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_darkoak = register("block_cafetable_darkoak", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_sakura = register("block_cafetable_sakura", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_kaede = register("block_cafetable_kaede", () -> cafeTable());
	public static final RegistryObject<Block> CAFETABLE_ichoh = register("block_cafetable_ichoh", () -> cafeTable());
	public static final RegistryObject<Block> TEATABLE = register("block_teatable", () -> cafeTable());
	
	public static final RegistryObject<Block> LOWDESK = register("block_lowdesk", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_spruce = register("block_lowdesk_spruce", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_birch = register("block_lowdesk_birch", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_jungle = register("block_lowdesk_jungle", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_acacia = register("block_lowdesk_acacia", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_darkoak = register("block_lowdesk_darkoak", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_sakura = register("block_lowdesk_sakura", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_kaede = register("block_lowdesk_kaede", () -> lowDesk());
	public static final RegistryObject<Block> LOWDESK_ichoh = register("block_lowdesk_ichoh", () -> lowDesk());
	
	public static final RegistryObject<Block> LETTERTRAY = register("block_lettertray_c", () -> new TrayLetter(woodState()));
	public static final RegistryObject<Block> FUDETRAY = register("block_fudetray_c", () -> new TrayFude(woodState()));
	public static final RegistryObject<Block> WRITTEN_BOOK = register("block_written_book", () -> new WrittenBook(bookState()));
	public static final RegistryObject<Block> WRITTEN_MAKIMONO = register("block_written_makimono", () -> new WrittenMakimono(bookState()));

	public static final RegistryObject<Block> CHABUDAI = register("block_chabudai", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_spruce = register("block_chabudai_spruce", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_birch = register("block_chabudai_birch", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_jungle = register("block_chabudai_jungle", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_acacia = register("block_chabudai_acacia", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_darkoak = register("block_chabudai_darkoak", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_sakura = register("block_chabudai_sakura", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_kaede = register("block_chabudai_kaede", () -> chabudai());
	public static final RegistryObject<Block> CHABUDAI_ichoh = register("block_chabudai_ichoh", () -> chabudai());

	public static final RegistryObject<Block> KOTATSU = register("block_kotatsu", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_spruce = register("block_kotatsu_spruce", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_birch = register("block_kotatsu_birch", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_jungle = register("block_kotatsu_jungle", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_acacia = register("block_kotatsu_acacia", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_darkoak = register("block_kotatsu_darkoak", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_sakura = register("block_kotatsu_sakura", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_kaede = register("block_kotatsu_kaede", () -> kotatsu());
	public static final RegistryObject<Block> KOTATSU_ichoh = register("block_kotatsu_ichoh", () -> kotatsu());
	
	public static final RegistryObject<Block> KASA_white = register("block_mkasa_white", () -> wagasa(MapColor.SNOW));
	public static final RegistryObject<Block> KASA_orange = register("block_mkasa_orange", () -> wagasa(MapColor.COLOR_ORANGE));
	public static final RegistryObject<Block> KASA_magenta = register("block_mkasa_magenta", () -> wagasa(MapColor.COLOR_MAGENTA));
	public static final RegistryObject<Block> KASA_lightb = register("block_mkasa_lightb", () -> wagasa(MapColor.COLOR_LIGHT_BLUE));
	public static final RegistryObject<Block> KASA_yellow = register("block_mkasa_yellow", () -> wagasa(MapColor.COLOR_YELLOW));
	public static final RegistryObject<Block> KASA_lime = register("block_mkasa_lime", () -> wagasa(MapColor.COLOR_LIGHT_GREEN));
	public static final RegistryObject<Block> KASA_pink = register("block_mkasa_pink", () -> wagasa(MapColor.COLOR_PINK));
	public static final RegistryObject<Block> KASA_gray = register("block_mkasa_gray", () -> wagasa(MapColor.COLOR_GRAY));
	public static final RegistryObject<Block> KASA_lightg = register("block_mkasa_lightg", () -> wagasa(MapColor.COLOR_LIGHT_GRAY));
	public static final RegistryObject<Block> KASA_cyan = register("block_mkasa_cyan", () -> wagasa(MapColor.COLOR_CYAN));
	public static final RegistryObject<Block> KASA_purple = register("block_mkasa_purple", () -> wagasa(MapColor.COLOR_PURPLE));
	public static final RegistryObject<Block> KASA_blue = register("block_mkasa_blue", () -> wagasa(MapColor.COLOR_BLUE));
	public static final RegistryObject<Block> KASA_brown = register("block_mkasa_brown", () -> wagasa(MapColor.COLOR_BROWN));
	public static final RegistryObject<Block> KASA_green = register("block_mkasa_green", () -> wagasa(MapColor.COLOR_GREEN));
	public static final RegistryObject<Block> KASA_red = register("block_mkasa_red", () -> wagasa(MapColor.COLOR_RED));
	public static final RegistryObject<Block> KASA_black = register("block_mkasa_black", () -> wagasa(MapColor.COLOR_BLACK));

	public static final RegistryObject<Block> ENDAI = register("block_mendai", () -> endai());
	public static final RegistryObject<Block> ENDAI_r = register("block_mendai_red", () -> endai());

	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties woodState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never);
	}
	
	private static Properties bookState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never);
	}
	
	private static UnitDesk unitDesk() {
		return new UnitDesk(woodState());
	}

	private static CafeTable cafeTable() {
		return new CafeTable(woodState());
	}
	
	private static LowDesk lowDesk() {
		return new LowDesk(woodState());
	}
	
	private static Chabudai chabudai() {
		return new Chabudai(woodState());
	}

	private static Kotatsu kotatsu() {
		return new Kotatsu(woodState());
	}
	
	private static Wagasa wagasa(MapColor color) {
		return new Wagasa(BlockBehaviour.Properties.of().mapColor(color).strength(1.0F, 1.0F).sound(SoundType.WOOL)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}
	
	private static Endai endai() {
		return new Endai(woodState());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
