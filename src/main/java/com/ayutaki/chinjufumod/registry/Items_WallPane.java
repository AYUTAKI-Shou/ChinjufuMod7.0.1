package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.chinjufu.BrickC_Item;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.jpblock.PillarSlab_Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_WallPane {

	public static Item RGRA_slabhalf, RDIO_slabhalf, RAND_slabhalf;
	public static Item RGRA_stairs, RDIO_stairs, RAND_stairs;

	public static Item BRICK_C;
	public static Item BGC_slabhalf, BDC_slabhalf, BAC_slabhalf;
	public static Item BGRA_stairs, BDIO_stairs, BAND_stairs;

	public static Item BRICK_STONE_PIL, BRICK_GRA_PIL, BRICK_DIO_PIL, BRICK_AND_PIL;
	public static Item PILLAR_oak, PILLAR_spru, PILLAR_bir, PILLAR_jun, PILLAR_aca, PILLAR_doak;
	public static Item PILLARSLAB;

	public static void init() {

		RGRA_slabhalf = new ItemBlock_noFuel("block_rgra_slabhalf", WallBrick_Blocks.RGRA_slabhalf);
		RDIO_slabhalf = new ItemBlock_noFuel("block_rdio_slabhalf", WallBrick_Blocks.RDIO_slabhalf);
		RAND_slabhalf = new ItemBlock_noFuel("block_rand_slabhalf", WallBrick_Blocks.RAND_slabhalf);
		RGRA_stairs = new ItemBlock_noFuel("block_rockstairs_gra", WallBrick_Blocks.RGRA_stairs);
		RDIO_stairs = new ItemBlock_noFuel("block_rockstairs_dio", WallBrick_Blocks.RDIO_stairs);
		RAND_stairs = new ItemBlock_noFuel("block_rockstairs_and", WallBrick_Blocks.RAND_stairs);

		BRICK_C = new BrickC_Item("block_bricks_c");
		BGC_slabhalf = new ItemBlock_noFuel("block_bgc_slabhalf", WallBrick_Blocks.BGC_slabhalf);
		BDC_slabhalf = new ItemBlock_noFuel("block_bdc_slabhalf", WallBrick_Blocks.BDC_slabhalf);
		BAC_slabhalf = new ItemBlock_noFuel("block_bac_slabhalf", WallBrick_Blocks.BAC_slabhalf);
		BGRA_stairs = new ItemBlock_noFuel("block_brickstairs_gra_c", WallBrick_Blocks.BGRA_stairs);
		BDIO_stairs = new ItemBlock_noFuel("block_brickstairs_dio_c", WallBrick_Blocks.BDIO_stairs);
		BAND_stairs = new ItemBlock_noFuel("block_brickstairs_and_c", WallBrick_Blocks.BAND_stairs);

		BRICK_STONE_PIL = new ItemBlock_noFuel("block_brick_stone_pil_c", WallBrick_Blocks.BRICK_STONE_PIL);
		BRICK_GRA_PIL = new ItemBlock_noFuel("block_brick_gra_pil_c", WallBrick_Blocks.BRICK_GRA_PIL);
		BRICK_DIO_PIL = new ItemBlock_noFuel("block_brick_dio_pil_c", WallBrick_Blocks.BRICK_DIO_PIL);
		BRICK_AND_PIL = new ItemBlock_noFuel("block_brick_and_pil_c", WallBrick_Blocks.BRICK_AND_PIL);

		PILLAR_oak = new ItemBlock_Fuel300("block_pillar_oak_c", WallBrick_Blocks.PILLAR_oak);
		PILLAR_spru = new ItemBlock_Fuel300("block_pillar_spru_c", WallBrick_Blocks.PILLAR_spru);
		PILLAR_bir = new ItemBlock_Fuel300("block_pillar_bir_c", WallBrick_Blocks.PILLAR_bir);
		PILLAR_jun = new ItemBlock_Fuel300("block_pillar_jun_c", WallBrick_Blocks.PILLAR_jun);
		PILLAR_aca = new ItemBlock_Fuel300("block_pillar_aca_c", WallBrick_Blocks.PILLAR_aca);
		PILLAR_doak = new ItemBlock_Fuel300("block_pillar_doak_c", WallBrick_Blocks.PILLAR_doak);

		PILLARSLAB = new PillarSlab_Item("block_kamoi");

	}

	public static void register() {

		registerItem(RGRA_slabhalf);
		registerItem(RDIO_slabhalf);
		registerItem(RAND_slabhalf);
		registerItem(RGRA_stairs);
		registerItem(RDIO_stairs);
		registerItem(RAND_stairs);

		registerItem(BRICK_C);
		registerItem(BGC_slabhalf);
		registerItem(BDC_slabhalf);
		registerItem(BAC_slabhalf);
		registerItem(BGRA_stairs);
		registerItem(BDIO_stairs);
		registerItem(BAND_stairs);

		registerItem(BRICK_STONE_PIL);
		registerItem(BRICK_GRA_PIL);
		registerItem(BRICK_DIO_PIL);
		registerItem(BRICK_AND_PIL);

		registerItem(PILLAR_oak);
		registerItem(PILLAR_spru);
		registerItem(PILLAR_bir);
		registerItem(PILLAR_jun);
		registerItem(PILLAR_aca);
		registerItem(PILLAR_doak);

		registerItem(PILLARSLAB);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(RGRA_slabhalf);
		registerRender(RDIO_slabhalf);
		registerRender(RAND_slabhalf);
		registerRender(RGRA_stairs);
		registerRender(RDIO_stairs);
		registerRender(RAND_stairs);

		registerRenderMeta(BRICK_C, 1, "block_brick_gra_c");
		registerRenderMeta(BRICK_C, 2, "block_brick_dio_c");
		registerRenderMeta(BRICK_C, 3, "block_brick_and_c");
		registerRenderMeta(BRICK_C, 4, "block_brick_gra_ch_c");
		registerRenderMeta(BRICK_C, 5, "block_brick_dio_ch_c");
		registerRenderMeta(BRICK_C, 6, "block_brick_and_ch_c");
		registerRenderMeta(BRICK_C, 7, "block_brick_gra_cr_c");
		registerRenderMeta(BRICK_C, 8, "block_brick_dio_cr_c");
		registerRenderMeta(BRICK_C, 9, "block_brick_and_cr_c");
		registerRenderMeta(BRICK_C, 10, "block_brick_gra_mos_c");
		registerRenderMeta(BRICK_C, 11, "block_brick_dio_mos_c");
		registerRenderMeta(BRICK_C, 12, "block_brick_and_mos_c");

		registerRender(BGC_slabhalf);
		registerRender(BDC_slabhalf);
		registerRender(BAC_slabhalf);
		registerRender(BGRA_stairs);
		registerRender(BDIO_stairs);
		registerRender(BAND_stairs);

		registerRender(BRICK_STONE_PIL);
		registerRender(BRICK_GRA_PIL);
		registerRender(BRICK_DIO_PIL);
		registerRender(BRICK_AND_PIL);

		registerRender(PILLAR_oak);
		registerRender(PILLAR_spru);
		registerRender(PILLAR_bir);
		registerRender(PILLAR_jun);
		registerRender(PILLAR_aca);
		registerRender(PILLAR_doak);

		registerRenderMeta(PILLARSLAB, 0, "block_kamoi_oak");
		registerRenderMeta(PILLARSLAB, 1, "block_kamoi_spruce");
		registerRenderMeta(PILLARSLAB, 2, "block_kamoi_birch");
		registerRenderMeta(PILLARSLAB, 3, "block_kamoi_jungle");
		registerRenderMeta(PILLARSLAB, 4, "block_kamoi_acacia");
		registerRenderMeta(PILLARSLAB, 5, "block_kamoi_darkoak");
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

}
