package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.cmblock.Dummy;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Birch;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Oak;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Spruce;
import com.ayutaki.chinjufumod.blocks.wallpane.BlockPlank_Pillar;
import com.ayutaki.chinjufumod.blocks.wallpane.Bricks_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.StoneCM_Slab;
import com.ayutaki.chinjufumod.blocks.wallpane.StoneCM_Stairs;
import com.ayutaki.chinjufumod.blocks.wallpane.Stone_Pillar;

import net.minecraft.block.Block;

public class WallBrick_Blocks {

	public static Block DUMMY;

	public static StoneCM_Slab RGRA_slabhalf, RDIO_slabhalf, RAND_slabhalf;
	public static Block RGRA_stairs, RDIO_stairs, RAND_stairs;

	public static Block ROCK;
	public static StoneCM_Slab BGC_slabhalf, BDC_slabhalf, BAC_slabhalf;
	public static Block BGRA_stairs, BDIO_stairs, BAND_stairs;

	public static Block BRICK_STONE_PIL, BRICK_GRA_PIL, BRICK_DIO_PIL, BRICK_AND_PIL;
	public static Block PILLAR_oak, PILLAR_spru, PILLAR_bir, PILLAR_jun, PILLAR_aca, PILLAR_doak;
	public static Block PILLARSLAB_oak, PILLARSLAB_spru, PILLARSLAB_bir, PILLARSLAB_jun, PILLARSLAB_aca, PILLARSLAB_doak;

	public static void init() {

		DUMMY = new Dummy("block_dummy");

		RGRA_slabhalf = new StoneCM_Slab("block_rgra_slabhalf");
		RDIO_slabhalf = new StoneCM_Slab("block_rdio_slabhalf");
		RAND_slabhalf = new StoneCM_Slab("block_rand_slabhalf");
		RGRA_stairs = new StoneCM_Stairs("block_rockstairs_gra", DUMMY.getDefaultState()).setCreativeTab(ChinjufuModTabs.WALLPANEL);
		RDIO_stairs = new StoneCM_Stairs("block_rockstairs_dio", DUMMY.getDefaultState()).setCreativeTab(ChinjufuModTabs.WALLPANEL);
		RAND_stairs = new StoneCM_Stairs("block_rockstairs_and", DUMMY.getDefaultState()).setCreativeTab(ChinjufuModTabs.WALLPANEL);

		ROCK = new Bricks_CM("block_bricks_c");
		BGC_slabhalf = new StoneCM_Slab("block_bgc_slabhalf");
		BDC_slabhalf = new StoneCM_Slab("block_bdc_slabhalf");
		BAC_slabhalf = new StoneCM_Slab("block_bac_slabhalf");
		BGRA_stairs = new StoneCM_Stairs("block_brickstairs_gra_c", DUMMY.getDefaultState()).setCreativeTab(ChinjufuModTabs.WALLPANEL);
		BDIO_stairs = new StoneCM_Stairs("block_brickstairs_dio_c", DUMMY.getDefaultState()).setCreativeTab(ChinjufuModTabs.WALLPANEL);
		BAND_stairs = new StoneCM_Stairs("block_brickstairs_and_c", DUMMY.getDefaultState()).setCreativeTab(ChinjufuModTabs.WALLPANEL);

		BRICK_STONE_PIL = new Stone_Pillar("block_brick_stone_pil_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		BRICK_GRA_PIL = new Stone_Pillar("block_brick_gra_pil_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		BRICK_DIO_PIL = new Stone_Pillar("block_brick_dio_pil_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		BRICK_AND_PIL = new Stone_Pillar("block_brick_and_pil_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);

		PILLAR_oak = new BlockPlank_Pillar("block_pillar_oak_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLAR_spru = new BlockPlank_Pillar("block_pillar_spru_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLAR_bir = new BlockPlank_Pillar("block_pillar_bir_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLAR_jun = new BlockPlank_Pillar("block_pillar_jun_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLAR_aca = new BlockPlank_Pillar("block_pillar_aca_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLAR_doak = new BlockPlank_Pillar("block_pillar_doak_c").setCreativeTab(ChinjufuModTabs.WALLPANEL);

		PILLARSLAB_oak = new Kamoi_Oak("block_kamoi_oak").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLARSLAB_spru = new Kamoi_Spruce("block_kamoi_spruce").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLARSLAB_bir = new Kamoi_Birch("block_kamoi_birch").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLARSLAB_jun = new Kamoi_Jungle("block_kamoi_jungle").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLARSLAB_aca = new Kamoi_Acacia("block_kamoi_acacia").setCreativeTab(ChinjufuModTabs.WALLPANEL);
		PILLARSLAB_doak = new Kamoi_DarkOak("block_kamoi_darkoak").setCreativeTab(ChinjufuModTabs.WALLPANEL);

	}


	public static void register() {
		registerBlock(DUMMY);

		registerBlock(RGRA_slabhalf);
		registerBlock(RDIO_slabhalf);
		registerBlock(RAND_slabhalf);

		registerBlock(RGRA_stairs);
		registerBlock(RDIO_stairs);
		registerBlock(RAND_stairs);

		registerBlock(ROCK);
		registerBlock(BGC_slabhalf);
		registerBlock(BDC_slabhalf);
		registerBlock(BAC_slabhalf);

		registerBlock(BGRA_stairs);
		registerBlock(BDIO_stairs);
		registerBlock(BAND_stairs);

		registerBlock(BRICK_STONE_PIL);
		registerBlock(BRICK_GRA_PIL);
		registerBlock(BRICK_DIO_PIL);
		registerBlock(BRICK_AND_PIL);

		registerBlock(PILLAR_oak);
		registerBlock(PILLAR_spru);
		registerBlock(PILLAR_bir);
		registerBlock(PILLAR_jun);
		registerBlock(PILLAR_aca);
		registerBlock(PILLAR_doak);

		registerBlock(PILLARSLAB_oak);
		registerBlock(PILLARSLAB_spru);
		registerBlock(PILLARSLAB_bir);
		registerBlock(PILLARSLAB_jun);
		registerBlock(PILLARSLAB_aca);
		registerBlock(PILLARSLAB_doak);


	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
