package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.fuel.Wall_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.Wall_noFuel;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_WallPanel {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static Item BRICK_GRA = register("block_brick_gra_c", new Wall_noFuel(WallPanel_Blocks.BRICK_GRA, new Item.Properties()));
	public static Item BRICK_DIO = register("block_brick_dio_c", new Wall_noFuel(WallPanel_Blocks.BRICK_DIO, new Item.Properties()));
	public static Item BRICK_AND = register("block_brick_and_c", new Wall_noFuel(WallPanel_Blocks.BRICK_AND, new Item.Properties()));
	public static Item BRICKGRA_CH = register("block_brick_gra_ch_c", new Wall_noFuel(WallPanel_Blocks.BRICKGRA_CH, new Item.Properties()));
	public static Item BRICKDIO_CH = register("block_brick_dio_ch_c", new Wall_noFuel(WallPanel_Blocks.BRICKDIO_CH, new Item.Properties()));
	public static Item BRICKAND_CH = register("block_brick_and_ch_c", new Wall_noFuel(WallPanel_Blocks.BRICKAND_CH, new Item.Properties()));
	public static Item BRICKGRA_CR = register("block_brick_gra_cr_c", new Wall_noFuel(WallPanel_Blocks.BRICKGRA_CR, new Item.Properties()));
	public static Item BRICKDIO_CR = register("block_brick_dio_cr_c", new Wall_noFuel(WallPanel_Blocks.BRICKDIO_CR, new Item.Properties()));
	public static Item BRICKAND_CR = register("block_brick_and_cr_c", new Wall_noFuel(WallPanel_Blocks.BRICKAND_CR, new Item.Properties()));
	public static Item BRICKGRA_MOS = register("block_brick_gra_mos_c", new Wall_noFuel(WallPanel_Blocks.BRICKGRA_MOS, new Item.Properties()));
	public static Item BRICKDIO_MOS = register("block_brick_dio_mos_c", new Wall_noFuel(WallPanel_Blocks.BRICKDIO_MOS, new Item.Properties()));
	public static Item BRICKAND_MOS = register("block_brick_and_mos_c", new Wall_noFuel(WallPanel_Blocks.BRICKAND_MOS, new Item.Properties()));

	public static Item BRICKSTAIRS_GRA = register("block_brickstairs_gra_c", new Wall_noFuel(WallPanel_Blocks.BRICKSTAIRS_GRA, new Item.Properties()));
	public static Item BRICKSTAIRS_DIO = register("block_brickstairs_dio_c", new Wall_noFuel(WallPanel_Blocks.BRICKSTAIRS_DIO, new Item.Properties()));
	public static Item BRICKSTAIRS_AND = register("block_brickstairs_and_c", new Wall_noFuel(WallPanel_Blocks.BRICKSTAIRS_AND, new Item.Properties()));

	public static Item BGC_slabhalf = register("block_bgc_slabhalf", new Wall_noFuel(WallPanel_Blocks.BGC_slabhalf, new Item.Properties()));
	public static Item BDC_slabhalf = register("block_bdc_slabhalf", new Wall_noFuel(WallPanel_Blocks.BDC_slabhalf, new Item.Properties()));
	public static Item BAC_slabhalf = register("block_bac_slabhalf", new Wall_noFuel(WallPanel_Blocks.BAC_slabhalf, new Item.Properties()));

	public static Item BRICK_STONE_PIL = register("block_brick_stone_pil_c", new Wall_noFuel(WallPanel_Blocks.BRICK_STONE_PIL, new Item.Properties()));
	public static Item BRICK_GRA_PIL = register("block_brick_gra_pil_c", new Wall_noFuel(WallPanel_Blocks.BRICK_GRA_PIL, new Item.Properties()));
	public static Item BRICK_DIO_PIL = register("block_brick_dio_pil_c", new Wall_noFuel(WallPanel_Blocks.BRICK_DIO_PIL, new Item.Properties()));
	public static Item BRICK_AND_PIL = register("block_brick_and_pil_c", new Wall_noFuel(WallPanel_Blocks.BRICK_AND_PIL, new Item.Properties()));

	public static Item PILLAR_oak = register("block_pillar_oak_c", new Wall_noFuel(WallPanel_Blocks.PILLAR_oak, new Item.Properties()));
	public static Item PILLAR_spru = register("block_pillar_spru_c", new Wall_noFuel(WallPanel_Blocks.PILLAR_spru, new Item.Properties()));
	public static Item PILLAR_bir = register("block_pillar_bir_c", new Wall_noFuel(WallPanel_Blocks.PILLAR_bir, new Item.Properties()));
	public static Item PILLAR_jun = register("block_pillar_jun_c", new Wall_noFuel(WallPanel_Blocks.PILLAR_jun, new Item.Properties()));
	public static Item PILLAR_aca = register("block_pillar_aca_c", new Wall_noFuel(WallPanel_Blocks.PILLAR_aca, new Item.Properties()));
	public static Item PILLAR_doak = register("block_pillar_doak_c", new Wall_noFuel(WallPanel_Blocks.PILLAR_doak, new Item.Properties()));
	public static Item PILLARSLAB_oak = register("block_kamoi_oak", new Wall_Fuel150(WallPanel_Blocks.PILLARSLAB_oak, new Item.Properties()));
	public static Item PILLARSLAB_spru = register("block_kamoi_spruce", new Wall_Fuel150(WallPanel_Blocks.PILLARSLAB_spru, new Item.Properties()));
	public static Item PILLARSLAB_bir = register("block_kamoi_birch", new Wall_Fuel150(WallPanel_Blocks.PILLARSLAB_bir, new Item.Properties()));
	public static Item PILLARSLAB_jun = register("block_kamoi_jungle", new Wall_Fuel150(WallPanel_Blocks.PILLARSLAB_jun, new Item.Properties()));
	public static Item PILLARSLAB_aca = register("block_kamoi_acacia", new Wall_Fuel150(WallPanel_Blocks.PILLARSLAB_aca, new Item.Properties()));
	public static Item PILLARSLAB_doak = register("block_kamoi_darkoak", new Wall_Fuel150(WallPanel_Blocks.PILLARSLAB_doak, new Item.Properties()));

	public static Item WP_LOG_oak = register("block_wp_log_oak", new Wall_noFuel(WallPanel_Blocks.WP_LOG_oak, new Item.Properties()));
	public static Item WP_LOG_spru = register("block_wp_log_spru", new Wall_noFuel(WallPanel_Blocks.WP_LOG_spru, new Item.Properties()));
	public static Item WP_LOG_bir = register("block_wp_log_bir", new Wall_noFuel(WallPanel_Blocks.WP_LOG_bir, new Item.Properties()));
	public static Item WP_LOG_jun = register("block_wp_log_jun", new Wall_noFuel(WallPanel_Blocks.WP_LOG_jun, new Item.Properties()));
	public static Item WP_LOG_aca = register("block_wp_log_aca", new Wall_noFuel(WallPanel_Blocks.WP_LOG_aca, new Item.Properties()));
	public static Item WP_LOG_doak = register("block_wp_log_doak", new Wall_noFuel(WallPanel_Blocks.WP_LOG_doak, new Item.Properties()));

	public static Item WP_PLANK_oak = register("block_wp_plank_oak", new Wall_noFuel(WallPanel_Blocks.WP_PLANK_oak, new Item.Properties()));
	public static Item WP_PLANK_spru = register("block_wp_plank_spru", new Wall_noFuel(WallPanel_Blocks.WP_PLANK_spru, new Item.Properties()));
	public static Item WP_PLANK_bir = register("block_wp_plank_bir", new Wall_noFuel(WallPanel_Blocks.WP_PLANK_bir, new Item.Properties()));
	public static Item WP_PLANK_jun = register("block_wp_plank_jun", new Wall_noFuel(WallPanel_Blocks.WP_PLANK_jun, new Item.Properties()));
	public static Item WP_PLANK_aca = register("block_wp_plank_aca", new Wall_noFuel(WallPanel_Blocks.WP_PLANK_aca, new Item.Properties()));
	public static Item WP_PLANK_doak = register("block_wp_plank_doak", new Wall_noFuel(WallPanel_Blocks.WP_PLANK_doak, new Item.Properties()));

	public static Item WP_STONE = register("block_wp_stone", new Wall_noFuel(WallPanel_Blocks.WP_STONE, new Item.Properties()));
	public static Item WP_STONE_M = register("block_wp_stone_m", new Wall_noFuel(WallPanel_Blocks.WP_STONE_M, new Item.Properties()));

	public static Item WP_STONE_gra = register("block_wp_stone_gra", new Wall_noFuel(WallPanel_Blocks.WP_STONE_gra, new Item.Properties()));
	public static Item WP_STONE_dio = register("block_wp_stone_dio", new Wall_noFuel(WallPanel_Blocks.WP_STONE_dio, new Item.Properties()));
	public static Item WP_STONE_and = register("block_wp_stone_and", new Wall_noFuel(WallPanel_Blocks.WP_STONE_and, new Item.Properties()));

	public static Item WP_STONE_B = register("block_wp_stone_b", new Wall_noFuel(WallPanel_Blocks.WP_STONE_B, new Item.Properties()));
	public static Item WP_STONE_graB = register("block_wp_stone_grab", new Wall_noFuel(WallPanel_Blocks.WP_STONE_graB, new Item.Properties()));
	public static Item WP_STONE_dioB = register("block_wp_stone_diob", new Wall_noFuel(WallPanel_Blocks.WP_STONE_dioB, new Item.Properties()));
	public static Item WP_STONE_andB = register("block_wp_stone_andb", new Wall_noFuel(WallPanel_Blocks.WP_STONE_andB, new Item.Properties()));

	public static Item WP_STONE_P = register("block_wp_stone_p", new Wall_noFuel(WallPanel_Blocks.WP_STONE_P, new Item.Properties()));
	public static Item WP_STONE_graP = register("block_wp_stone_grap", new Wall_noFuel(WallPanel_Blocks.WP_STONE_graP, new Item.Properties()));
	public static Item WP_STONE_dioP = register("block_wp_stone_diop", new Wall_noFuel(WallPanel_Blocks.WP_STONE_dioP, new Item.Properties()));
	public static Item WP_STONE_andP = register("block_wp_stone_andp", new Wall_noFuel(WallPanel_Blocks.WP_STONE_andP, new Item.Properties()));

	public static Item WP_BRICK = register("block_wp_brick", new Wall_noFuel(WallPanel_Blocks.WP_BRICK, new Item.Properties()));

	public static Item WP_SANDSTONE = register("block_wp_sand_stone", new Wall_noFuel(WallPanel_Blocks.WP_SANDSTONE, new Item.Properties()));
	public static Item WP_REDSANDSTONE = register("block_wp_redsand_stone", new Wall_noFuel(WallPanel_Blocks.WP_REDSANDSTONE, new Item.Properties()));

	public static Item WP_PRISMA = register("block_wp_prisma", new Wall_noFuel(WallPanel_Blocks.WP_PRISMA, new Item.Properties()));
	public static Item WP_OBSIDIAN = register("block_wp_obsidian", new Wall_noFuel(WallPanel_Blocks.WP_OBSIDIAN, new Item.Properties()));

	public static Item WP_CLAY = register("block_wp_clay", new Wall_noFuel(WallPanel_Blocks.WP_CLAY, new Item.Properties()));
	public static Item WP_CLAY_white = register("block_wp_clay_white", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_white, new Item.Properties()));
	public static Item WP_CLAY_orange = register("block_wp_clay_orange", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_orange, new Item.Properties()));
	public static Item WP_CLAY_magenta = register("block_wp_clay_magenta", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_magenta, new Item.Properties()));
	public static Item WP_CLAY_lightb = register("block_wp_clay_lightb", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_lightb, new Item.Properties()));
	public static Item WP_CLAY_yellow = register("block_wp_clay_yellow", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_yellow, new Item.Properties()));
	public static Item WP_CLAY_lime = register("block_wp_clay_lime", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_lime, new Item.Properties()));
	public static Item WP_CLAY_pink = register("block_wp_clay_pink", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_pink, new Item.Properties()));
	public static Item WP_CLAY_gray = register("block_wp_clay_gray", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_gray, new Item.Properties()));
	public static Item WP_CLAY_lightg = register("block_wp_clay_lightg", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_lightg, new Item.Properties()));
	public static Item WP_CLAY_cyan = register("block_wp_clay_cyan", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_cyan, new Item.Properties()));
	public static Item WP_CLAY_purple = register("block_wp_clay_purple", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_purple, new Item.Properties()));
	public static Item WP_CLAY_blue = register("block_wp_clay_blue", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_blue, new Item.Properties()));
	public static Item WP_CLAY_brown = register("block_wp_clay_brown", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_brown, new Item.Properties()));
	public static Item WP_CLAY_green = register("block_wp_clay_green", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_green, new Item.Properties()));
	public static Item WP_CLAY_red = register("block_wp_clay_red", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_red, new Item.Properties()));
	public static Item WP_CLAY_black = register("block_wp_clay_black", new Wall_noFuel(WallPanel_Blocks.WP_CLAY_black, new Item.Properties()));

	public static Item WP_GLASS = register("block_wp_glass", new Wall_noFuel(WallPanel_Blocks.WP_GLASS, new Item.Properties()));
	public static Item WP_GLASS_white = register("block_wp_glass_white", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_white, new Item.Properties()));
	public static Item WP_GLASS_orange = register("block_wp_glass_orange", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_orange, new Item.Properties()));
	public static Item WP_GLASS_magenta = register("block_wp_glass_magenta", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_magenta, new Item.Properties()));
	public static Item WP_GLASS_lightb = register("block_wp_glass_lightb", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_lightb, new Item.Properties()));
	public static Item WP_GLASS_yellow = register("block_wp_glass_yellow", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_yellow, new Item.Properties()));
	public static Item WP_GLASS_lime = register("block_wp_glass_lime", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_lime, new Item.Properties()));
	public static Item WP_GLASS_pink = register("block_wp_glass_pink", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_pink, new Item.Properties()));
	public static Item WP_GLASS_gray = register("block_wp_glass_gray", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_gray, new Item.Properties()));
	public static Item WP_GLASS_lightg = register("block_wp_glass_lightg", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_lightg, new Item.Properties()));
	public static Item WP_GLASS_cyan = register("block_wp_glass_cyan", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_cyan, new Item.Properties()));
	public static Item WP_GLASS_purple = register("block_wp_glass_purple", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_purple, new Item.Properties()));
	public static Item WP_GLASS_blue = register("block_wp_glass_blue", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_blue, new Item.Properties()));
	public static Item WP_GLASS_brown = register("block_wp_glass_brown", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_brown, new Item.Properties()));
	public static Item WP_GLASS_green = register("block_wp_glass_green", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_green, new Item.Properties()));
	public static Item WP_GLASS_red = register("block_wp_glass_red", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_red, new Item.Properties()));
	public static Item WP_GLASS_black = register("block_wp_glass_black", new Wall_noFuel(WallPanel_Blocks.WP_GLASS_black, new Item.Properties()));

	public static Item WP_NETHE_rack = register("block_wp_netherrack", new Wall_noFuel(WallPanel_Blocks.WP_NETHE_rack, new Item.Properties()));
	public static Item WP_NETHE_b = register("block_wp_netherb", new Wall_noFuel(WallPanel_Blocks.WP_NETHE_b, new Item.Properties()));
	public static Item WP_QUARTZ = register("block_wp_quartz", new Wall_noFuel(WallPanel_Blocks.WP_QUARTZ, new Item.Properties()));
	public static Item WP_QUARTZ_PIL = register("block_wp_quartz_pil", new Wall_noFuel(WallPanel_Blocks.WP_QUARTZ_PIL, new Item.Properties()));

	public static Item WP_ENDSTONE = register("block_wp_endstone", new Wall_noFuel(WallPanel_Blocks.WP_ENDSTONE, new Item.Properties()));
	public static Item WP_ENDBRICKS = register("block_wp_endstone_b", new Wall_noFuel(WallPanel_Blocks.WP_ENDBRICKS, new Item.Properties()));

	public static Item WP_PURPUR = register("block_wp_purpur", new Wall_noFuel(WallPanel_Blocks.WP_PURPUR, new Item.Properties()));
	public static Item WP_PURPUR_PIL = register("block_wp_purpur_pil", new Wall_noFuel(WallPanel_Blocks.WP_PURPUR_PIL, new Item.Properties()));

	public static Item WP_BAMBOO = register("block_wp_bamboo", new Wall_noFuel(WallPanel_Blocks.WP_BAMBOO, new Item.Properties()));
	public static Item WP_BAMBOO_Y = register("block_wp_bamboo_y", new Wall_noFuel(WallPanel_Blocks.WP_BAMBOO_Y, new Item.Properties()));
	public static Item WP_BAMBOO_K = register("block_wp_bamboo_k", new Wall_noFuel(WallPanel_Blocks.WP_BAMBOO_K, new Item.Properties()));

	public static Item WP_DIRTWALL = register("block_wp_dirtwall", new Wall_noFuel(WallPanel_Blocks.WP_DIRTWALL, new Item.Properties()));
	public static Item WP_PLASTER_white = register("block_wp_plaster_white", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_white, new Item.Properties()));
	public static Item WP_PLASTER_orange = register("block_wp_plaster_orange", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_orange, new Item.Properties()));
	public static Item WP_PLASTER_magenta = register("block_wp_plaster_magenta", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_magenta, new Item.Properties()));
	public static Item WP_PLASTER_lightb = register("block_wp_plaster_lightb", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_lightb, new Item.Properties()));
	public static Item WP_PLASTER_yellow = register("block_wp_plaster_yellow", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_yellow, new Item.Properties()));
	public static Item WP_PLASTER_lime = register("block_wp_plaster_lime", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_lime, new Item.Properties()));
	public static Item WP_PLASTER_pink = register("block_wp_plaster_pink", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_pink, new Item.Properties()));
	public static Item WP_PLASTER_gray = register("block_wp_plaster_gray", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_gray, new Item.Properties()));
	public static Item WP_PLASTER_lightg = register("block_wp_plaster_lightg", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_lightg, new Item.Properties()));
	public static Item WP_PLASTER_cyan = register("block_wp_plaster_cyan", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_cyan, new Item.Properties()));
	public static Item WP_PLASTER_purple = register("block_wp_plaster_purple", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_purple, new Item.Properties()));
	public static Item WP_PLASTER_blue = register("block_wp_plaster_blue", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_blue, new Item.Properties()));
	public static Item WP_PLASTER_brown = register("block_wp_plaster_brown", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_brown, new Item.Properties()));
	public static Item WP_PLASTER_green = register("block_wp_plaster_green", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_green, new Item.Properties()));
	public static Item WP_PLASTER_red = register("block_wp_plaster_red", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_red, new Item.Properties()));
	public static Item WP_PLASTER_black = register("block_wp_plaster_black", new Wall_noFuel(WallPanel_Blocks.WP_PLASTER_black, new Item.Properties()));

	public static Item WP_NAMAKO_white = register("block_wp_namako_white", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_white, new Item.Properties()));
	public static Item WP_NAMAKO_orange = register("block_wp_namako_orange", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_orange, new Item.Properties()));
	public static Item WP_NAMAKO_magenta = register("block_wp_namako_magenta", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_magenta, new Item.Properties()));
	public static Item WP_NAMAKO_lightb = register("block_wp_namako_lightb", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_lightb, new Item.Properties()));
	public static Item WP_NAMAKO_yellow = register("block_wp_namako_yellow", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_yellow, new Item.Properties()));
	public static Item WP_NAMAKO_lime = register("block_wp_namako_lime", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_lime, new Item.Properties()));
	public static Item WP_NAMAKO_pink = register("block_wp_namako_pink", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_pink, new Item.Properties()));
	public static Item WP_NAMAKO_gray = register("block_wp_namako_gray", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_gray, new Item.Properties()));
	public static Item WP_NAMAKO_lightg = register("block_wp_namako_lightg", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_lightg, new Item.Properties()));
	public static Item WP_NAMAKO_cyan = register("block_wp_namako_cyan", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_cyan, new Item.Properties()));
	public static Item WP_NAMAKO_purple = register("block_wp_namako_purple", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_purple, new Item.Properties()));
	public static Item WP_NAMAKO_blue = register("block_wp_namako_blue", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_blue, new Item.Properties()));
	public static Item WP_NAMAKO_brown = register("block_wp_namako_brown", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_brown, new Item.Properties()));
	public static Item WP_NAMAKO_green = register("block_wp_namako_green", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_green, new Item.Properties()));
	public static Item WP_NAMAKO_red = register("block_wp_namako_red", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_red, new Item.Properties()));
	public static Item WP_NAMAKO_black = register("block_wp_namako_black", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKO_black, new Item.Properties()));

	public static Item WP_NAMAKOB_white = register("block_wp_namako_b_white", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_white, new Item.Properties()));
	public static Item WP_NAMAKOB_orange = register("block_wp_namako_b_orange", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_orange, new Item.Properties()));
	public static Item WP_NAMAKOB_magenta = register("block_wp_namako_b_magenta", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_magenta, new Item.Properties()));
	public static Item WP_NAMAKOB_lightb = register("block_wp_namako_b_lightb", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_lightb, new Item.Properties()));
	public static Item WP_NAMAKOB_yellow = register("block_wp_namako_b_yellow", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_yellow, new Item.Properties()));
	public static Item WP_NAMAKOB_lime = register("block_wp_namako_b_lime", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_lime, new Item.Properties()));
	public static Item WP_NAMAKOB_pink = register("block_wp_namako_b_pink", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_pink, new Item.Properties()));
	public static Item WP_NAMAKOB_gray = register("block_wp_namako_b_gray", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_gray, new Item.Properties()));
	public static Item WP_NAMAKOB_lightg = register("block_wp_namako_b_lightg", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_lightg, new Item.Properties()));
	public static Item WP_NAMAKOB_cyan = register("block_wp_namako_b_cyan", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_cyan, new Item.Properties()));
	public static Item WP_NAMAKOB_purple = register("block_wp_namako_b_purple", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_purple, new Item.Properties()));
	public static Item WP_NAMAKOB_blue = register("block_wp_namako_b_blue", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_blue, new Item.Properties()));
	public static Item WP_NAMAKOB_brown = register("block_wp_namako_b_brown", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_brown, new Item.Properties()));
	public static Item WP_NAMAKOB_green = register("block_wp_namako_b_green", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_green, new Item.Properties()));
	public static Item WP_NAMAKOB_red = register("block_wp_namako_b_red", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_red, new Item.Properties()));
	public static Item WP_NAMAKOB_black = register("block_wp_namako_b_black", new Wall_noFuel(WallPanel_Blocks.WP_NAMAKOB_black, new Item.Properties()));

	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
