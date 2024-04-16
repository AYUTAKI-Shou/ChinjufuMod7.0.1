package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Birch;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Oak;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Spruce;
import com.ayutaki.chinjufumod.blocks.wallpane.BrickBlock_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.BrickPillar_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.BrickSlabWater_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.BrickStairs_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Plaster;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Simple;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage2;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage3;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage4;
import com.ayutaki.chinjufumod.blocks.wood.WoodPillar_CM;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WallPanel_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block BRICK_GRA = register("block_brick_gra_c", bricks());
	public static Block BRICK_DIO = register("block_brick_dio_c", bricks());
	public static Block BRICK_AND = register("block_brick_and_c", bricks());
	public static Block BRICKGRA_CH = register("block_brick_gra_ch_c", bricks());
	public static Block BRICKDIO_CH = register("block_brick_dio_ch_c", bricks());
	public static Block BRICKAND_CH = register("block_brick_and_ch_c", bricks());
	public static Block BRICKGRA_CR = register("block_brick_gra_cr_c", bricks());
	public static Block BRICKDIO_CR = register("block_brick_dio_cr_c", bricks());
	public static Block BRICKAND_CR = register("block_brick_and_cr_c", bricks());
	public static Block BRICKGRA_MOS = register("block_brick_gra_mos_c", bricks());
	public static Block BRICKDIO_MOS = register("block_brick_dio_mos_c", bricks());
	public static Block BRICKAND_MOS = register("block_brick_and_mos_c", bricks());

	public static Block BRICKSTAIRS_GRA = register("block_brickstairs_gra_c", brickStairs());
	public static Block BRICKSTAIRS_DIO = register("block_brickstairs_dio_c", brickStairs());
	public static Block BRICKSTAIRS_AND = register("block_brickstairs_and_c", brickStairs());

	public static Block BGC_slabhalf = register("block_bgc_slabhalf", brickSlab());
	public static Block BDC_slabhalf = register("block_bdc_slabhalf", brickSlab());
	public static Block BAC_slabhalf = register("block_bac_slabhalf", brickSlab());

	public static Block BRICK_STONE_PIL = register("block_brick_stone_pil_c", brickPillar());
	public static Block BRICK_GRA_PIL = register("block_brick_gra_pil_c", brickPillar());
	public static Block BRICK_DIO_PIL = register("block_brick_dio_pil_c", brickPillar());
	public static Block BRICK_AND_PIL = register("block_brick_and_pil_c", brickPillar());

	public static Block PILLAR_oak = register("block_pillar_oak_c", logPillar());
	public static Block PILLAR_spru = register("block_pillar_spru_c", logPillar());
	public static Block PILLAR_bir = register("block_pillar_bir_c", logPillar());
	public static Block PILLAR_jun = register("block_pillar_jun_c", logPillar());
	public static Block PILLAR_aca = register("block_pillar_aca_c", logPillar());
	public static Block PILLAR_doak = register("block_pillar_doak_c", logPillar());

	public static Block PILLARSLAB_oak = register("block_kamoi_oak", new Kamoi_Oak(woodState()));
	public static Block PILLARSLAB_spru = register("block_kamoi_spruce", new Kamoi_Spruce(woodState()));
	public static Block PILLARSLAB_bir = register("block_kamoi_birch", new Kamoi_Birch(woodState()));
	public static Block PILLARSLAB_jun = register("block_kamoi_jungle", new Kamoi_Jungle(woodState()));
	public static Block PILLARSLAB_aca = register("block_kamoi_acacia", new Kamoi_Acacia(woodState()));
	public static Block PILLARSLAB_doak = register("block_kamoi_darkoak", new Kamoi_DarkOak(woodState()));

	public static Block WP_LOG_oak = register("block_wp_log_oak", woodPaneStage3());
	public static Block WP_LOG_spru = register("block_wp_log_spru", woodPaneStage3());
	public static Block WP_LOG_bir = register("block_wp_log_bir", woodPaneStage3());
	public static Block WP_LOG_jun = register("block_wp_log_jun", woodPaneStage3());
	public static Block WP_LOG_aca = register("block_wp_log_aca", woodPaneStage3());
	public static Block WP_LOG_doak = register("block_wp_log_doak", woodPaneStage3());

	public static Block WP_PLANK_oak = register("block_wp_plank_oak", woodPaneStage4());
	public static Block WP_PLANK_spru = register("block_wp_plank_spru", woodPaneStage4());
	public static Block WP_PLANK_bir = register("block_wp_plank_bir", woodPaneStage4());
	public static Block WP_PLANK_jun = register("block_wp_plank_jun", woodPaneStage4());
	public static Block WP_PLANK_aca = register("block_wp_plank_aca", woodPaneStage4());
	public static Block WP_PLANK_doak = register("block_wp_plank_doak", woodPaneStage4());

	public static Block WP_STONE = register("block_wp_stone", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 6.0F)));
	public static Block WP_STONE_M = register("block_wp_stone_m", stonePaneStage2());

	public static Block WP_STONE_gra = register("block_wp_stone_gra", stonePaneStage2());
	public static Block WP_STONE_dio = register("block_wp_stone_dio", stonePaneStage2());
	public static Block WP_STONE_and = register("block_wp_stone_and", stonePaneStage2());

	public static Block WP_STONE_B = register("block_wp_stone_b", stonePaneStage4());
	public static Block WP_STONE_graB = register("block_wp_stone_grab", stonePaneStage4());
	public static Block WP_STONE_dioB = register("block_wp_stone_diob", stonePaneStage4());
	public static Block WP_STONE_andB = register("block_wp_stone_andb", stonePaneStage4());

	public static Block WP_STONE_P = register("block_wp_stone_p", stonePaneStage3());
	public static Block WP_STONE_graP = register("block_wp_stone_grap", stonePaneStage3());
	public static Block WP_STONE_dioP = register("block_wp_stone_diop", stonePaneStage3());
	public static Block WP_STONE_andP = register("block_wp_stone_andp", stonePaneStage3());

	public static Block WP_BRICK = register("block_wp_brick", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 6.0F)));

	public static Block WP_SANDSTONE = register("block_wp_sand_stone", stonePaneStage3());
	public static Block WP_REDSANDSTONE = register("block_wp_redsand_stone", stonePaneStage3());

	public static Block WP_PRISMA = register("block_wp_prisma", stonePaneStage3());
	public static Block WP_OBSIDIAN = register("block_wp_obsidian", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 1200.0F)));

	public static Block WP_CLAY = register("block_wp_clay", clayPane());
	public static Block WP_CLAY_white = register("block_wp_clay_white", clayPane());
	public static Block WP_CLAY_orange = register("block_wp_clay_orange", clayPane());
	public static Block WP_CLAY_magenta = register("block_wp_clay_magenta", clayPane());
	public static Block WP_CLAY_lightb = register("block_wp_clay_lightb", clayPane());
	public static Block WP_CLAY_yellow = register("block_wp_clay_yellow", clayPane());
	public static Block WP_CLAY_lime = register("block_wp_clay_lime", clayPane());
	public static Block WP_CLAY_pink = register("block_wp_clay_pink", clayPane());
	public static Block WP_CLAY_gray = register("block_wp_clay_gray", clayPane());
	public static Block WP_CLAY_lightg = register("block_wp_clay_lightg", clayPane());
	public static Block WP_CLAY_cyan = register("block_wp_clay_cyan", clayPane());
	public static Block WP_CLAY_purple = register("block_wp_clay_purple", clayPane());
	public static Block WP_CLAY_blue = register("block_wp_clay_blue", clayPane());
	public static Block WP_CLAY_brown = register("block_wp_clay_brown", clayPane());
	public static Block WP_CLAY_green = register("block_wp_clay_green", clayPane());
	public static Block WP_CLAY_red = register("block_wp_clay_red", clayPane());
	public static Block WP_CLAY_black = register("block_wp_clay_black", clayPane());

	public static Block WP_GLASS = register("block_wp_glass", glassPane());
	public static Block WP_GLASS_white = register("block_wp_glass_white", glassPane());
	public static Block WP_GLASS_orange = register("block_wp_glass_orange", glassPane());
	public static Block WP_GLASS_magenta = register("block_wp_glass_magenta", glassPane());
	public static Block WP_GLASS_lightb = register("block_wp_glass_lightb", glassPane());
	public static Block WP_GLASS_yellow = register("block_wp_glass_yellow", glassPane());
	public static Block WP_GLASS_lime = register("block_wp_glass_lime", glassPane());
	public static Block WP_GLASS_pink = register("block_wp_glass_pink", glassPane());
	public static Block WP_GLASS_gray = register("block_wp_glass_gray", glassPane());
	public static Block WP_GLASS_lightg = register("block_wp_glass_lightg", glassPane());
	public static Block WP_GLASS_cyan = register("block_wp_glass_cyan", glassPane());
	public static Block WP_GLASS_purple = register("block_wp_glass_purple", glassPane());
	public static Block WP_GLASS_blue = register("block_wp_glass_blue", glassPane());
	public static Block WP_GLASS_brown = register("block_wp_glass_brown", glassPane());
	public static Block WP_GLASS_green = register("block_wp_glass_green", glassPane());
	public static Block WP_GLASS_red = register("block_wp_glass_red", glassPane());
	public static Block WP_GLASS_black = register("block_wp_glass_black", glassPane());

	public static Block WP_NETHE_rack = register("block_wp_netherrack", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 0.4F)));
	public static Block WP_NETHE_b = register("block_wp_netherb", stonePaneStage2());
	public static Block WP_QUARTZ = register("block_wp_quartz", stonePaneStage2());
	public static Block WP_QUARTZ_PIL = register("block_wp_quartz_pil", stonePaneStage3());

	public static Block WP_ENDSTONE = register("block_wp_endstone", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 9.0F)));
	public static Block WP_ENDBRICKS = register("block_wp_endstone_b", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 9.0F)));

	public static Block WP_PURPUR = register("block_wp_purpur", new WallPane_Simple(baseState().hardnessAndResistance(1.0F, 6.0F)));
	public static Block WP_PURPUR_PIL = register("block_wp_purpur_pil", stonePaneStage3());

	public static Block WP_BAMBOO = register("block_wp_bamboo", woodPaneStage3());
	public static Block WP_BAMBOO_Y = register("block_wp_bamboo_y", woodPaneStage3());
	public static Block WP_BAMBOO_K = register("block_wp_bamboo_k", woodPaneStage3());

	public static Block WP_DIRTWALL = register("block_wp_dirtwall", plasterPane());
	public static Block WP_PLASTER_white = register("block_wp_plaster_white", plasterPane());
	public static Block WP_PLASTER_orange = register("block_wp_plaster_orange", plasterPane());
	public static Block WP_PLASTER_magenta = register("block_wp_plaster_magenta", plasterPane());
	public static Block WP_PLASTER_lightb = register("block_wp_plaster_lightb", plasterPane());
	public static Block WP_PLASTER_yellow = register("block_wp_plaster_yellow", plasterPane());
	public static Block WP_PLASTER_lime = register("block_wp_plaster_lime", plasterPane());
	public static Block WP_PLASTER_pink = register("block_wp_plaster_pink", plasterPane());
	public static Block WP_PLASTER_gray = register("block_wp_plaster_gray", plasterPane());
	public static Block WP_PLASTER_lightg = register("block_wp_plaster_lightg", plasterPane());
	public static Block WP_PLASTER_cyan = register("block_wp_plaster_cyan", plasterPane());
	public static Block WP_PLASTER_purple = register("block_wp_plaster_purple", plasterPane());
	public static Block WP_PLASTER_blue = register("block_wp_plaster_blue", plasterPane());
	public static Block WP_PLASTER_brown = register("block_wp_plaster_brown", plasterPane());
	public static Block WP_PLASTER_green = register("block_wp_plaster_green", plasterPane());
	public static Block WP_PLASTER_red = register("block_wp_plaster_red", plasterPane());
	public static Block WP_PLASTER_black = register("block_wp_plaster_black", plasterPane());

	public static Block WP_NAMAKO_white = register("block_wp_namako_white", namakoPane());
	public static Block WP_NAMAKO_orange = register("block_wp_namako_orange", namakoPane());
	public static Block WP_NAMAKO_magenta = register("block_wp_namako_magenta", namakoPane());
	public static Block WP_NAMAKO_lightb = register("block_wp_namako_lightb", namakoPane());
	public static Block WP_NAMAKO_yellow = register("block_wp_namako_yellow", namakoPane());
	public static Block WP_NAMAKO_lime = register("block_wp_namako_lime", namakoPane());
	public static Block WP_NAMAKO_pink = register("block_wp_namako_pink", namakoPane());
	public static Block WP_NAMAKO_gray = register("block_wp_namako_gray", namakoPane());
	public static Block WP_NAMAKO_lightg = register("block_wp_namako_lightg", namakoPane());
	public static Block WP_NAMAKO_cyan = register("block_wp_namako_cyan", namakoPane());
	public static Block WP_NAMAKO_purple = register("block_wp_namako_purple", namakoPane());
	public static Block WP_NAMAKO_blue = register("block_wp_namako_blue", namakoPane());
	public static Block WP_NAMAKO_brown = register("block_wp_namako_brown", namakoPane());
	public static Block WP_NAMAKO_green = register("block_wp_namako_green", namakoPane());
	public static Block WP_NAMAKO_red = register("block_wp_namako_red", namakoPane());
	public static Block WP_NAMAKO_black = register("block_wp_namako_black", namakoPane());

	public static Block WP_NAMAKOB_white = register("block_wp_namako_b_white", namakoPaneBtype());
	public static Block WP_NAMAKOB_orange = register("block_wp_namako_b_orange", namakoPaneBtype());
	public static Block WP_NAMAKOB_magenta = register("block_wp_namako_b_magenta", namakoPaneBtype());
	public static Block WP_NAMAKOB_lightb = register("block_wp_namako_b_lightb", namakoPaneBtype());
	public static Block WP_NAMAKOB_yellow = register("block_wp_namako_b_yellow", namakoPaneBtype());
	public static Block WP_NAMAKOB_lime = register("block_wp_namako_b_lime", namakoPaneBtype());
	public static Block WP_NAMAKOB_pink = register("block_wp_namako_b_pink", namakoPaneBtype());
	public static Block WP_NAMAKOB_gray = register("block_wp_namako_b_gray", namakoPaneBtype());
	public static Block WP_NAMAKOB_lightg = register("block_wp_namako_b_lightg", namakoPaneBtype());
	public static Block WP_NAMAKOB_cyan = register("block_wp_namako_b_cyan", namakoPaneBtype());
	public static Block WP_NAMAKOB_purple = register("block_wp_namako_b_purple", namakoPaneBtype());
	public static Block WP_NAMAKOB_blue = register("block_wp_namako_b_blue", namakoPaneBtype());
	public static Block WP_NAMAKOB_brown = register("block_wp_namako_b_brown", namakoPaneBtype());
	public static Block WP_NAMAKOB_green = register("block_wp_namako_b_green", namakoPaneBtype());
	public static Block WP_NAMAKOB_red = register("block_wp_namako_b_red", namakoPaneBtype());
	public static Block WP_NAMAKOB_black = register("block_wp_namako_b_black", namakoPaneBtype());

	/* Share variables */
	private static Block bricks() {
		return new BrickBlock_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE));
	}

	private static BrickSlabWater_CM brickSlab() {
		return new BrickSlabWater_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE).notSolid());
	}

	private static BrickStairs_CM brickStairs() {
		return new BrickStairs_CM(BRICK_GRA.getDefaultState(), Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE).notSolid());
	}

	private static BrickPillar_CM brickPillar() {
		return new BrickPillar_CM(Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE));
	}

	private static WoodPillar_CM logPillar() {
		return new WoodPillar_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD));
	}

	private static WallPane_Stage3 woodPaneStage3() {
		return new WallPane_Stage3(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WallPane_Stage4 woodPaneStage4() {
		return new WallPane_Stage4(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WallPane_Stage2 stonePaneStage2() {
		return new WallPane_Stage2(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid());
	}

	private static WallPane_Stage3 stonePaneStage3() {
		return new WallPane_Stage3(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid());
	}

	private static WallPane_Stage4 stonePaneStage4() {
		return new WallPane_Stage4(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid());
	}

	private static WallPane_Clay clayPane() {
		return new WallPane_Clay(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 4.2F).sound(SoundType.STONE).notSolid());
	}

	private static WallPane_Glass glassPane() {
		return new WallPane_Glass(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 0.3F).sound(SoundType.GLASS).notSolid());
	}

	private static WallPane_Plaster plasterPane() {
		return new WallPane_Plaster(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE).notSolid());
	}

	private static WallPane_Namako namakoPane() {
		return new WallPane_Namako(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE).notSolid());
	}

	private static WallPane_Namako_B namakoPaneBtype() {
		return new WallPane_Namako_B(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE).notSolid());
	}

	private static Properties baseState() {
		return Block.Properties.create(Material.WOOD).sound(SoundType.STONE).notSolid();
	}
	
	private static Properties woodState() {
		return Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
