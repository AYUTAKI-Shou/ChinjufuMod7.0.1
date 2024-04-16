package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Spruce;
import com.ayutaki.chinjufumod.blocks.kamoislab.Kamoi_DirtWall;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KamoiPlaster_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> KAMOI_dirt_oak = register("block_ka_dirt_oak", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_spru = register("block_ka_dirt_spru", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_bir = register("block_ka_dirt_bir", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_jun = register("block_ka_dirt_jun", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_aca = register("block_ka_dirt_aca", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_doak = register("block_ka_dirt_doak", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_sakura = register("block_ka_dirt_saku", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_kaede = register("block_ka_dirt_kae", () -> kamoiDirtWall());
	public static final RegistryObject<Block> KAMOI_dirt_ichoh = register("block_ka_dirt_ich", () -> kamoiDirtWall());


	public static final RegistryObject<Block> KAMOI_white_oak = register("block_ka_white_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_orange_oak = register("block_ka_orange_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_magenta_oak = register("block_ka_magenta_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_lightb_oak = register("block_ka_lightb_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_yellow_oak = register("block_ka_yellow_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_lime_oak = register("block_ka_lime_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_pink_oak = register("block_ka_pink_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_gray_oak = register("block_ka_gray_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_lightg_oak = register("block_ka_lightg_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_cyan_oak = register("block_ka_cyan_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_purple_oak = register("block_ka_purple_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_blue_oak = register("block_ka_blue_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_brown_oak = register("block_ka_brown_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_green_oak = register("block_ka_green_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_red_oak = register("block_ka_red_o", () -> kamoiPlasterOak());
	public static final RegistryObject<Block> KAMOI_black_oak = register("block_ka_black_o", () -> kamoiPlasterOak());

	public static final RegistryObject<Block> KAMOI_white_spru = register("block_ka_white_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_orange_spru = register("block_ka_orange_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_magenta_spru = register("block_ka_magenta_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_lightb_spru = register("block_ka_lightb_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_yellow_spru = register("block_ka_yellow_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_lime_spru = register("block_ka_lime_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_pink_spru = register("block_ka_pink_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_gray_spru = register("block_ka_gray_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_lightg_spru = register("block_ka_lightg_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_cyan_spru = register("block_ka_cyan_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_purple_spru = register("block_ka_purple_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_blue_spru = register("block_ka_blue_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_brown_spru = register("block_ka_brown_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_green_spru = register("block_ka_green_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_red_spru = register("block_ka_red_s", () -> kamoiPlasterSpruce());
	public static final RegistryObject<Block> KAMOI_black_spru = register("block_ka_black_s", () -> kamoiPlasterSpruce());

	public static final RegistryObject<Block> KAMOI_white_bir = register("block_ka_white_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_orange_bir = register("block_ka_orange_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_magenta_bir = register("block_ka_magenta_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_lightb_bir = register("block_ka_lightb_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_yellow_bir = register("block_ka_yellow_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_lime_bir = register("block_ka_lime_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_pink_bir = register("block_ka_pink_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_gray_bir = register("block_ka_gray_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_lightg_bir = register("block_ka_lightg_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_cyan_bir = register("block_ka_cyan_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_purple_bir = register("block_ka_purple_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_blue_bir = register("block_ka_blue_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_brown_bir = register("block_ka_brown_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_green_bir = register("block_ka_green_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_red_bir = register("block_ka_red_b", () -> kamoiPlasterBirch());
	public static final RegistryObject<Block> KAMOI_black_bir = register("block_ka_black_b", () -> kamoiPlasterBirch());

	public static final RegistryObject<Block> KAMOI_white_jun = register("block_ka_white_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_orange_jun = register("block_ka_orange_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_magenta_jun = register("block_ka_magenta_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_lightb_jun = register("block_ka_lightb_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_yellow_jun = register("block_ka_yellow_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_lime_jun = register("block_ka_lime_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_pink_jun = register("block_ka_pink_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_gray_jun = register("block_ka_gray_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_lightg_jun = register("block_ka_lightg_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_cyan_jun = register("block_ka_cyan_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_purple_jun = register("block_ka_purple_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_blue_jun = register("block_ka_blue_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_brown_jun = register("block_ka_brown_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_green_jun = register("block_ka_green_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_red_jun = register("block_ka_red_j", () -> kamoiPlasterJungle());
	public static final RegistryObject<Block> KAMOI_black_jun = register("block_ka_black_j", () -> kamoiPlasterJungle());

	public static final RegistryObject<Block> KAMOI_white_aca = register("block_ka_white_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_orange_aca = register("block_ka_orange_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_magenta_aca = register("block_ka_magenta_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_lightb_aca = register("block_ka_lightb_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_yellow_aca = register("block_ka_yellow_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_lime_aca = register("block_ka_lime_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_pink_aca = register("block_ka_pink_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_gray_aca = register("block_ka_gray_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_lightg_aca = register("block_ka_lightg_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_cyan_aca = register("block_ka_cyan_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_purple_aca = register("block_ka_purple_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_blue_aca = register("block_ka_blue_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_brown_aca = register("block_ka_brown_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_green_aca = register("block_ka_green_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_red_aca = register("block_ka_red_a", () -> kamoiPlasterAcacia());
	public static final RegistryObject<Block> KAMOI_black_aca = register("block_ka_black_a", () -> kamoiPlasterAcacia());

	public static final RegistryObject<Block> KAMOI_white_doak = register("block_ka_white_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_orange_doak = register("block_ka_orange_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_magenta_doak = register("block_ka_magenta_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_lightb_doak = register("block_ka_lightb_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_yellow_doak = register("block_ka_yellow_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_lime_doak = register("block_ka_lime_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_pink_doak = register("block_ka_pink_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_gray_doak = register("block_ka_gray_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_lightg_doak = register("block_ka_lightg_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_cyan_doak = register("block_ka_cyan_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_purple_doak = register("block_ka_purple_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_blue_doak = register("block_ka_blue_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_brown_doak = register("block_ka_brown_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_green_doak = register("block_ka_green_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_red_doak = register("block_ka_red_d", () -> kamoiPlasterDarkOak());
	public static final RegistryObject<Block> KAMOI_black_doak = register("block_ka_black_d", () -> kamoiPlasterDarkOak());

	public static final RegistryObject<Block> KAMOI_white_sakura = register("block_ka_white_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_orange_sakura = register("block_ka_orange_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_magenta_sakura = register("block_ka_magenta_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_lightb_sakura = register("block_ka_lightb_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_yellow_sakura = register("block_ka_yellow_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_lime_sakura = register("block_ka_lime_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_pink_sakura = register("block_ka_pink_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_gray_sakura = register("block_ka_gray_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_lightg_sakura = register("block_ka_lightg_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_cyan_sakura = register("block_ka_cyan_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_purple_sakura = register("block_ka_purple_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_blue_sakura = register("block_ka_blue_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_brown_sakura = register("block_ka_brown_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_green_sakura = register("block_ka_green_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_red_sakura = register("block_ka_red_saku", () -> kamoiPlasterSakura());
	public static final RegistryObject<Block> KAMOI_black_sakura = register("block_ka_black_saku", () -> kamoiPlasterSakura());

	public static final RegistryObject<Block> KAMOI_white_kaede = register("block_ka_white_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_orange_kaede = register("block_ka_orange_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_magenta_kaede = register("block_ka_magenta_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_lightb_kaede = register("block_ka_lightb_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_yellow_kaede = register("block_ka_yellow_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_lime_kaede = register("block_ka_lime_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_pink_kaede = register("block_ka_pink_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_gray_kaede = register("block_ka_gray_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_lightg_kaede = register("block_ka_lightg_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_cyan_kaede = register("block_ka_cyan_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_purple_kaede = register("block_ka_purple_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_blue_kaede = register("block_ka_blue_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_brown_kaede = register("block_ka_brown_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_green_kaede = register("block_ka_green_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_red_kaede = register("block_ka_red_kae", () -> kamoiPlasterKaede());
	public static final RegistryObject<Block> KAMOI_black_kaede = register("block_ka_black_kae", () -> kamoiPlasterKaede());

	public static final RegistryObject<Block> KAMOI_white_ichoh = register("block_ka_white_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_orange_ichoh = register("block_ka_orange_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_magenta_ichoh = register("block_ka_magenta_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_lightb_ichoh = register("block_ka_lightb_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_yellow_ichoh = register("block_ka_yellow_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_lime_ichoh = register("block_ka_lime_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_pink_ichoh = register("block_ka_pink_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_gray_ichoh = register("block_ka_gray_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_lightg_ichoh = register("block_ka_lightg_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_cyan_ichoh = register("block_ka_cyan_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_purple_ichoh = register("block_ka_purple_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_blue_ichoh = register("block_ka_blue_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_brown_ichoh = register("block_ka_brown_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_green_ichoh = register("block_ka_green_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_red_ichoh = register("block_ka_red_ich", () -> kamoiPlasterIchoh());
	public static final RegistryObject<Block> KAMOI_black_ichoh = register("block_ka_black_ich", () -> kamoiPlasterIchoh());

	/* Share variables */
	private static Properties stoneState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F, 4.2F).sound(SoundType.STONE);
	}
	
	private static Kamoi_DirtWall kamoiDirtWall() {
		return new Kamoi_DirtWall(stoneState());
	}


	private static KamoiPlaster_Oak kamoiPlasterOak() {
		return new KamoiPlaster_Oak(stoneState());
	}

	private static KamoiPlaster_Spruce kamoiPlasterSpruce() {
		return new KamoiPlaster_Spruce(stoneState());
	}

	private static KamoiPlaster_Birch kamoiPlasterBirch() {
		return new KamoiPlaster_Birch(stoneState());
	}

	private static KamoiPlaster_Jungle kamoiPlasterJungle() {
		return new KamoiPlaster_Jungle(stoneState());
	}

	private static KamoiPlaster_Acacia kamoiPlasterAcacia() {
		return new KamoiPlaster_Acacia(stoneState());
	}

	private static KamoiPlaster_DarkOak kamoiPlasterDarkOak() {
		return new KamoiPlaster_DarkOak(stoneState());
	}

	private static KamoiPlaster_Sakura kamoiPlasterSakura() {
		return new KamoiPlaster_Sakura(stoneState());
	}

	private static KamoiPlaster_Kaede kamoiPlasterKaede() {
		return new KamoiPlaster_Kaede(stoneState());
	}

	private static KamoiPlaster_Ichoh kamoiPlasterIchoh() {
		return new KamoiPlaster_Ichoh(stoneState());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
