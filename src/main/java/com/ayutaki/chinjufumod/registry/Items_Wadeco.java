package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.color.ItemHake_Black;
import com.ayutaki.chinjufumod.items.color.ItemHake_Blue;
import com.ayutaki.chinjufumod.items.color.ItemHake_Brown;
import com.ayutaki.chinjufumod.items.color.ItemHake_Cyan;
import com.ayutaki.chinjufumod.items.color.ItemHake_Gray;
import com.ayutaki.chinjufumod.items.color.ItemHake_Green;
import com.ayutaki.chinjufumod.items.color.ItemHake_LightBlue;
import com.ayutaki.chinjufumod.items.color.ItemHake_LightGray;
import com.ayutaki.chinjufumod.items.color.ItemHake_Lime;
import com.ayutaki.chinjufumod.items.color.ItemHake_Magenta;
import com.ayutaki.chinjufumod.items.color.ItemHake_Orange;
import com.ayutaki.chinjufumod.items.color.ItemHake_Pink;
import com.ayutaki.chinjufumod.items.color.ItemHake_Purple;
import com.ayutaki.chinjufumod.items.color.ItemHake_Red;
import com.ayutaki.chinjufumod.items.color.ItemHake_White;
import com.ayutaki.chinjufumod.items.color.ItemHake_Yellow;
import com.ayutaki.chinjufumod.items.fuel.Fuel_100;
import com.ayutaki.chinjufumod.items.fuel.Fuel_150;
import com.ayutaki.chinjufumod.items.fuel.Fuel_200;
import com.ayutaki.chinjufumod.items.fuel.Fuel_300;
import com.ayutaki.chinjufumod.items.garden.ItemChisel;
import com.ayutaki.chinjufumod.items.garden.ItemKumade;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items_Wadeco {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Item> GARASUDO = register("block_garasudo", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDO.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_SPRU = register("block_garasudo_spruce", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDO_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_BIR = register("block_garasudo_birch", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDO_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_JUN = register("block_garasudo_jungle", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDO_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_ACA = register("block_garasudo_acacia", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDO_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_DOAK = register("block_garasudo_darkoak", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDO_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> GARASUDOB = register("block_garasudob", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOB.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_SPRU = register("block_garasudob_spruce", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOB_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_BIR = register("block_garasudob_birch", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOB_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_JUN = register("block_garasudob_jungle", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOB_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_ACA = register("block_garasudob_acacia", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOB_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_DOAK = register("block_garasudob_darkoak", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOB_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> GARASUDOH = register("block_garasudohalf", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOH.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_SPRU = register("block_garasudohalf_spruce", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOH_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_BIR = register("block_garasudohalf_birch", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOH_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_JUN = register("block_garasudohalf_jungle", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOH_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_ACA = register("block_garasudohalf_acacia", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOH_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_DOAK = register("block_garasudohalf_darkoak", () -> new ItemNameBlockItem(Slidedoor_Blocks.GARASUDOH_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUJI = register("block_shouji", () -> new Fuel_200(Slidedoor_Blocks.SHOUJI.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_SPRU = register("block_shouji_spruce", () -> new Fuel_200(Slidedoor_Blocks.SHOUJI_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_BIR = register("block_shouji_birch", () -> new Fuel_200(Slidedoor_Blocks.SHOUJI_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_JUN = register("block_shouji_jungle", () -> new Fuel_200(Slidedoor_Blocks.SHOUJI_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_ACA = register("block_shouji_acacia", () -> new Fuel_200(Slidedoor_Blocks.SHOUJI_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_DOAK = register("block_shouji_darkoak", () -> new Fuel_200(Slidedoor_Blocks.SHOUJI_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUJIB = register("block_shoujib", () -> new Fuel_200(Slidedoor_Blocks.SHOUJIB.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_SPRU = register("block_shoujib_spruce", () -> new Fuel_200(Slidedoor_Blocks.SHOUJIB_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_BIR = register("block_shoujib_birch", () -> new Fuel_200(Slidedoor_Blocks.SHOUJIB_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_JUN = register("block_shoujib_jungle", () -> new Fuel_200(Slidedoor_Blocks.SHOUJIB_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_ACA = register("block_shoujib_acacia", () -> new Fuel_200(Slidedoor_Blocks.SHOUJIB_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_DOAK = register("block_shoujib_darkoak", () -> new Fuel_200(Slidedoor_Blocks.SHOUJIB_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUJIH = register("block_shoujihalf", () -> new Fuel_100(Slidedoor_Blocks.SHOUJIH.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_SPRU = register("block_shoujihalf_spruce", () -> new Fuel_100(Slidedoor_Blocks.SHOUJIH_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_BIR = register("block_shoujihalf_birch", () -> new Fuel_100(Slidedoor_Blocks.SHOUJIH_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_JUN = register("block_shoujihalf_jungle", () -> new Fuel_100(Slidedoor_Blocks.SHOUJIH_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_ACA = register("block_shoujihalf_acacia", () -> new Fuel_100(Slidedoor_Blocks.SHOUJIH_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_DOAK = register("block_shoujihalf_darkoak", () -> new Fuel_100(Slidedoor_Blocks.SHOUJIH_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUJI_WIN = register("block_shoujih", () -> new Fuel_100(Slidedoor_Blocks.SHOUJI_WIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_SPRU = register("block_shoujih_spruce", () -> new Fuel_100(Slidedoor_Blocks.SHOUJI_WIN_SPRU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_BIR = register("block_shoujih_birch", () -> new Fuel_100(Slidedoor_Blocks.SHOUJI_WIN_BIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_JUN = register("block_shoujih_jungle", () -> new Fuel_100(Slidedoor_Blocks.SHOUJI_WIN_JUN.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_ACA = register("block_shoujih_acacia", () -> new Fuel_100(Slidedoor_Blocks.SHOUJI_WIN_ACA.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_DOAK = register("block_shoujih_darkoak", () -> new Fuel_100(Slidedoor_Blocks.SHOUJI_WIN_DOAK.get(), new Item.Properties()));

	public static final RegistryObject<Item> RANMA_oak = register("block_ranma_oak", () -> new Fuel_150(Ranma_Blocks.RANMA_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_spruce = register("block_ranma_spru", () -> new Fuel_150(Ranma_Blocks.RANMA_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_birch = register("block_ranma_bir", () -> new Fuel_150(Ranma_Blocks.RANMA_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_jungle = register("block_ranma_jun", () -> new Fuel_150(Ranma_Blocks.RANMA_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_acacia = register("block_ranma_aca", () -> new Fuel_150(Ranma_Blocks.RANMA_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_darkoak = register("block_ranma_doak", () -> new Fuel_150(Ranma_Blocks.RANMA_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> RANMAB_oak = register("block_ranmab_oak", () -> new Fuel_150(Ranma_Blocks.RANMAB_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_spruce = register("block_ranmab_spru", () -> new Fuel_150(Ranma_Blocks.RANMAB_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_birch = register("block_ranmab_bir", () -> new Fuel_150(Ranma_Blocks.RANMAB_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_jungle = register("block_ranmab_jun", () -> new Fuel_150(Ranma_Blocks.RANMAB_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_acacia = register("block_ranmab_aca", () -> new Fuel_150(Ranma_Blocks.RANMAB_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_darkoak = register("block_ranmab_doak", () -> new Fuel_150(Ranma_Blocks.RANMAB_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> RANMAC_oak = register("block_ranmac_oak", () -> new ItemNameBlockItem(Ranma_Blocks.RANMAC_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_spruce = register("block_ranmac_spru", () -> new ItemNameBlockItem(Ranma_Blocks.RANMAC_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_birch = register("block_ranmac_bir", () -> new ItemNameBlockItem(Ranma_Blocks.RANMAC_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_jungle = register("block_ranmac_jun", () -> new ItemNameBlockItem(Ranma_Blocks.RANMAC_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_acacia = register("block_ranmac_aca", () -> new ItemNameBlockItem(Ranma_Blocks.RANMAC_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_darkoak = register("block_ranmac_doak", () -> new ItemNameBlockItem(Ranma_Blocks.RANMAC_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> KANKI_oak = register("block_kanki_oak", () -> new Fuel_150(Ranma_Blocks.KANKI_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_spruce = register("block_kanki_spru", () -> new Fuel_150(Ranma_Blocks.KANKI_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_birch = register("block_kanki_bir", () -> new Fuel_150(Ranma_Blocks.KANKI_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_jungle = register("block_kanki_jun", () -> new Fuel_150(Ranma_Blocks.KANKI_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_acacia = register("block_kanki_aca", () -> new Fuel_150(Ranma_Blocks.KANKI_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_darkoak = register("block_kanki_doak", () -> new Fuel_150(Ranma_Blocks.KANKI_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> KOUSHI_oak = register("block_koushi_oak", () -> new Fuel_150(Ranma_Blocks.KOUSHI_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_spruce = register("block_koushi_spru", () -> new Fuel_150(Ranma_Blocks.KOUSHI_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_birch = register("block_koushi_bir", () -> new Fuel_150(Ranma_Blocks.KOUSHI_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_jungle = register("block_koushi_jun", () -> new Fuel_150(Ranma_Blocks.KOUSHI_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_acacia = register("block_koushi_aca", () -> new Fuel_150(Ranma_Blocks.KOUSHI_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_darkoak = register("block_koushi_doak", () -> new Fuel_150(Ranma_Blocks.KOUSHI_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> KOUSHIB_oak = register("block_koushib_oak", () -> new Fuel_150(Ranma_Blocks.KOUSHIB_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_spruce = register("block_koushib_spru", () -> new Fuel_150(Ranma_Blocks.KOUSHIB_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_birch = register("block_koushib_bir", () -> new Fuel_150(Ranma_Blocks.KOUSHIB_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_jungle = register("block_koushib_jun", () -> new Fuel_150(Ranma_Blocks.KOUSHIB_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_acacia = register("block_koushib_aca", () -> new Fuel_150(Ranma_Blocks.KOUSHIB_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_darkoak = register("block_koushib_doak", () -> new Fuel_150(Ranma_Blocks.KOUSHIB_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> FUSUMA_white = register("block_fusuma", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_orange = register("block_fusuma_orange", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_magenta = register("block_fusuma_magenta", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_lightb = register("block_fusuma_lightb", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_yellow = register("block_fusuma_yellow", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_lime = register("block_fusuma_lime", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_pink = register("block_fusuma_pink", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_gray = register("block_fusuma_gray", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_lightg = register("block_fusuma_lightg", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_cyan = register("block_fusuma_cyan", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_purple = register("block_fusuma_purple", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_blue = register("block_fusuma_blue", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_brown = register("block_fusuma_brown", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_green = register("block_fusuma_green", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_red = register("block_fusuma_red", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMA_black = register("block_fusuma_black", () -> new Fuel_200(Slidedoor_Blocks.FUSUMA_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> FUSUMAB_white = register("block_fusumab", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_orange = register("block_fusumab_orange", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_magenta = register("block_fusumab_magenta", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_lightb = register("block_fusumab_lightb", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_yellow = register("block_fusumab_yellow", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_lime = register("block_fusumab_lime", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_pink = register("block_fusumab_pink", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_gray = register("block_fusumab_gray", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_lightg = register("block_fusumab_lightg", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_cyan = register("block_fusumab_cyan", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_purple = register("block_fusumab_purple", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_blue = register("block_fusumab_blue", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_brown = register("block_fusumab_brown", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_green = register("block_fusumab_green", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_red = register("block_fusumab_red", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUSUMAB_black = register("block_fusumab_black", () -> new Fuel_200(Slidedoor_Blocks.FUSUMAB_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> SUDARE = register("block_sudare_1", () -> new Fuel_100(Garden_Blocks.SUDARE.get(), new Item.Properties()));

	public static final RegistryObject<Item> NOREN_white = register("block_noren_white", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_orange = register("block_noren_orange", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_magenta = register("block_noren_magenta", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_lightb = register("block_noren_lightb", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_yellow = register("block_noren_yellow", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_lime = register("block_noren_lime", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_pink = register("block_noren_pink", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_gray = register("block_noren_gray", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_lightg = register("block_noren_lightg", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_cyan = register("block_noren_cyan", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_purple = register("block_noren_purple", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_blue = register("block_noren_blue", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_brown = register("block_noren_brown", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_green = register("block_noren_green", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_red = register("block_noren_red", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> NOREN_black = register("block_noren_black", () -> new ItemNameBlockItem(Ranma_Blocks.NOREN_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> WARAZABUTON = register("block_wara_zabuton", () -> new Fuel_100(JPChair_Blocks.WARAZABUTON.get(), new Item.Properties()));

	public static final RegistryObject<Item> ZABUTON_white = register("block_mzabuton_white", () -> new Fuel_100(JPChair_Blocks.ZABUTON_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_orange = register("block_mzabuton_orange", () -> new Fuel_100(JPChair_Blocks.ZABUTON_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_magenta = register("block_mzabuton_magenta", () -> new Fuel_100(JPChair_Blocks.ZABUTON_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_lightb = register("block_mzabuton_lightb", () -> new Fuel_100(JPChair_Blocks.ZABUTON_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_yellow = register("block_mzabuton_yellow", () -> new Fuel_100(JPChair_Blocks.ZABUTON_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_lime = register("block_mzabuton_lime", () -> new Fuel_100(JPChair_Blocks.ZABUTON_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_pink = register("block_mzabuton_pink", () -> new Fuel_100(JPChair_Blocks.ZABUTON_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_gray = register("block_mzabuton_gray", () -> new Fuel_100(JPChair_Blocks.ZABUTON_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_lightg = register("block_mzabuton_lightg", () -> new Fuel_100(JPChair_Blocks.ZABUTON_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_cyan = register("block_mzabuton_cyan", () -> new Fuel_100(JPChair_Blocks.ZABUTON_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_purple = register("block_mzabuton_purple", () -> new Fuel_100(JPChair_Blocks.ZABUTON_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_blue = register("block_mzabuton_blue", () -> new Fuel_100(JPChair_Blocks.ZABUTON_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_brown = register("block_mzabuton_brown", () -> new Fuel_100(JPChair_Blocks.ZABUTON_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_green = register("block_mzabuton_green", () -> new Fuel_100(JPChair_Blocks.ZABUTON_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_red = register("block_mzabuton_red", () -> new Fuel_100(JPChair_Blocks.ZABUTON_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZABUTON_black = register("block_mzabuton_black", () -> new Fuel_100(JPChair_Blocks.ZABUTON_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> ZAISU_white = register("block_zaisu_white", () -> new Fuel_150(JPChair_Blocks.ZAISU_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_orange = register("block_zaisu_orange", () -> new Fuel_150(JPChair_Blocks.ZAISU_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_magenta = register("block_zaisu_magenta", () -> new Fuel_150(JPChair_Blocks.ZAISU_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_lightb = register("block_zaisu_lightb", () -> new Fuel_150(JPChair_Blocks.ZAISU_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_yellow = register("block_zaisu_yellow", () -> new Fuel_150(JPChair_Blocks.ZAISU_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_lime = register("block_zaisu_lime", () -> new Fuel_150(JPChair_Blocks.ZAISU_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_pink = register("block_zaisu_pink", () -> new Fuel_150(JPChair_Blocks.ZAISU_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_gray = register("block_zaisu_gray", () -> new Fuel_150(JPChair_Blocks.ZAISU_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_lightg = register("block_zaisu_lightg", () -> new Fuel_150(JPChair_Blocks.ZAISU_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_cyan = register("block_zaisu_cyan", () -> new Fuel_150(JPChair_Blocks.ZAISU_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_purple = register("block_zaisu_purple", () -> new Fuel_150(JPChair_Blocks.ZAISU_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_blue = register("block_zaisu_blue", () -> new Fuel_150(JPChair_Blocks.ZAISU_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_brown = register("block_zaisu_brown", () -> new Fuel_150(JPChair_Blocks.ZAISU_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_green = register("block_zaisu_green", () -> new Fuel_150(JPChair_Blocks.ZAISU_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_red = register("block_zaisu_red", () -> new Fuel_150(JPChair_Blocks.ZAISU_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZAISU_black = register("block_zaisu_black", () -> new Fuel_150(JPChair_Blocks.ZAISU_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> TATAMI_H = register("block_tatamih", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_white = register("block_tatamih_white", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_orange = register("block_tatamih_orange", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_magenta = register("block_tatamih_magenta", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_lightb = register("block_tatamih_lightb", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_yellow = register("block_tatamih_yellow", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_lime = register("block_tatamih_lime", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_pink = register("block_tatamih_pink", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_gray = register("block_tatamih_gray", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_lightg = register("block_tatamih_lightg", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_cyan = register("block_tatamih_cyan", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_purple = register("block_tatamih_purple", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_blue = register("block_tatamih_blue", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_brown = register("block_tatamih_brown", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_green = register("block_tatamih_green", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_red = register("block_tatamih_red", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_H_black = register("block_tatamih_black", () -> new Fuel_150(JPDeco_Blocks.TATAMI_H_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> TATAMI_HY = register("block_tatamih_y", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_white = register("block_tatamih_y_white", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_orange = register("block_tatamih_y_orange", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_magenta = register("block_tatamih_y_magenta", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_lightb = register("block_tatamih_y_lightb", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_yellow = register("block_tatamih_y_yellow", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_lime = register("block_tatamih_y_lime", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_pink = register("block_tatamih_y_pink", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_gray = register("block_tatamih_y_gray", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_lightg = register("block_tatamih_y_lightg", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_cyan = register("block_tatamih_y_cyan", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_purple = register("block_tatamih_y_purple", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_blue = register("block_tatamih_y_blue", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_brown = register("block_tatamih_y_brown", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_green = register("block_tatamih_y_green", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_red = register("block_tatamih_y_red", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> TATAMI_HY_black = register("block_tatamih_y_black", () -> new Fuel_150(JPDeco_Blocks.TATAMI_HY_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> TAKECUBE = register("block_bamboo_cube", () -> new Fuel_200(JPDeco_Blocks.TAKECUBE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKECUBE_Y = register("block_bamboo_y_cube", () -> new Fuel_200(JPDeco_Blocks.TAKECUBE_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKECUBE_K = register("block_bamboo_k_cube", () -> new Fuel_200(JPDeco_Blocks.TAKECUBE_K.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_ST = register("block_bamboo_stairs", () -> new Fuel_150(JPDeco_Blocks.TAKE_ST.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_STY = register("block_bamboo_y_stairs", () -> new Fuel_150(JPDeco_Blocks.TAKE_STY.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_STK = register("block_bamboo_k_stairs", () -> new Fuel_150(JPDeco_Blocks.TAKE_STK.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_SH = register("block_bamboo_slab", () -> new Fuel_100(JPDeco_Blocks.TAKE_SH.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_SHY = register("block_bamboo_y_slab", () -> new Fuel_100(JPDeco_Blocks.TAKE_SHY.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_SHK = register("block_bamboo_k_slab", () -> new Fuel_100(JPDeco_Blocks.TAKE_SHK.get(), new Item.Properties()));

	public static final RegistryObject<Item> TAKEFENCE = register("block_bamboo_fence", () -> new Fuel_150(JPDeco_Blocks.TAKEFENCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEFENCE_Y = register("block_bamboo_y_fence", () -> new Fuel_150(JPDeco_Blocks.TAKEFENCE_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEFENCE_K = register("block_bamboo_k_fence", () -> new Fuel_150(JPDeco_Blocks.TAKEFENCE_K.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEFENCEGATE = register("block_bamboo_fencegate", () -> new Fuel_150(JPDeco_Blocks.TAKEFENCEGATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEFENCEGATE_Y = register("block_bamboo_y_fencegate", () -> new Fuel_150(JPDeco_Blocks.TAKEFENCEGATE_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEFENCEGATE_K = register("block_bamboo_k_fencegate", () -> new Fuel_150(JPDeco_Blocks.TAKEFENCEGATE_K.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEDOOR = register("block_bamboo_door", () -> new Fuel_150(JPDeco_Blocks.TAKEDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEDOOR_Y = register("block_bamboo_y_door", () -> new Fuel_150(JPDeco_Blocks.TAKEDOOR_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEDOOR_K = register("block_bamboo_k_door", () -> new Fuel_150(JPDeco_Blocks.TAKEDOOR_K.get(), new Item.Properties()));

	public static final RegistryObject<Item> TAKE_TRAPDOOR = register("block_bamboo_trapdoor", () -> new Fuel_150(JPDeco_Blocks.TAKE_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_TRAPDOOR_Y = register("block_bamboo_y_trapdoor", () -> new Fuel_150(JPDeco_Blocks.TAKE_TRAPDOOR_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_TRAPDOOR_K = register("block_bamboo_k_trapdoor", () -> new Fuel_150(JPDeco_Blocks.TAKE_TRAPDOOR_K.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_PLATE = register("block_bamboo_plate", () -> new Fuel_150(JPDeco_Blocks.TAKE_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_PLATE_Y = register("block_bamboo_y_plate", () -> new Fuel_150(JPDeco_Blocks.TAKE_PLATE_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_PLATE_K = register("block_bamboo_k_plate", () -> new Fuel_150(JPDeco_Blocks.TAKE_PLATE_K.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_BUTTON = register("block_bamboo_button", () -> new Fuel_100(JPDeco_Blocks.TAKE_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_BUTTON_Y = register("block_bamboo_y_button", () -> new Fuel_100(JPDeco_Blocks.TAKE_BUTTON_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKE_BUTTON_K = register("block_bamboo_k_button", () -> new Fuel_100(JPDeco_Blocks.TAKE_BUTTON_K.get(), new Item.Properties()));

	public static final RegistryObject<Item> FUTON_white = register("block_futon_c_white", () -> new Fuel_150(JPDeco_Blocks.FUTON_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_orange = register("block_futon_c_orange", () -> new Fuel_150(JPDeco_Blocks.FUTON_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_magenta = register("block_futon_c_magenta", () -> new Fuel_150(JPDeco_Blocks.FUTON_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_lightb = register("block_futon_c_lightb", () -> new Fuel_150(JPDeco_Blocks.FUTON_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_yellow = register("block_futon_c_yellow", () -> new Fuel_150(JPDeco_Blocks.FUTON_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_lime = register("block_futon_c_lime", () -> new Fuel_150(JPDeco_Blocks.FUTON_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_pink = register("block_futon_c_pink", () -> new Fuel_150(JPDeco_Blocks.FUTON_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_gray = register("block_futon_c_gray", () -> new Fuel_150(JPDeco_Blocks.FUTON_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_lightg = register("block_futon_c_lightg", () -> new Fuel_150(JPDeco_Blocks.FUTON_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_cyan = register("block_futon_c_cyan", () -> new Fuel_150(JPDeco_Blocks.FUTON_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_purple = register("block_futon_c_purple", () -> new Fuel_150(JPDeco_Blocks.FUTON_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_blue = register("block_futon_c_blue", () -> new Fuel_150(JPDeco_Blocks.FUTON_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_brown = register("block_futon_c_brown", () -> new Fuel_150(JPDeco_Blocks.FUTON_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_green = register("block_futon_c_green", () -> new Fuel_150(JPDeco_Blocks.FUTON_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_red = register("block_futon_c_red", () -> new Fuel_150(JPDeco_Blocks.FUTON_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> FUTON_black = register("block_futon_c_black", () -> new Fuel_150(JPDeco_Blocks.FUTON_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> ANDON_white = register("block_andon_white", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_orange = register("block_andon_orange", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_magenta = register("block_andon_magenta", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_lightb = register("block_andon_lightb", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_yellow = register("block_andon_yellow", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_lime = register("block_andon_lime", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_pink = register("block_andon_pink", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_gray = register("block_andon_gray", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_lightg = register("block_andon_lightg", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_cyan = register("block_andon_cyan", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_purple = register("block_andon_purple", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_blue = register("block_andon_blue", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_brown = register("block_andon_brown", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_green = register("block_andon_green", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_red = register("block_andon_red", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANDON_black = register("block_andon_black", () -> new ItemNameBlockItem(JPDeco_Blocks.ANDON_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> KASA_white = register("block_mkasa_white", () -> new ItemNameBlockItem(Unit_Blocks.KASA_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_orange = register("block_mkasa_orange", () -> new ItemNameBlockItem(Unit_Blocks.KASA_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_magenta = register("block_mkasa_magenta", () -> new ItemNameBlockItem(Unit_Blocks.KASA_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_lightb = register("block_mkasa_lightb", () -> new ItemNameBlockItem(Unit_Blocks.KASA_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_yellow = register("block_mkasa_yellow", () -> new ItemNameBlockItem(Unit_Blocks.KASA_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_lime = register("block_mkasa_lime", () -> new ItemNameBlockItem(Unit_Blocks.KASA_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_pink = register("block_mkasa_pink", () -> new ItemNameBlockItem(Unit_Blocks.KASA_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_gray = register("block_mkasa_gray", () -> new ItemNameBlockItem(Unit_Blocks.KASA_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_lightg = register("block_mkasa_lightg", () -> new ItemNameBlockItem(Unit_Blocks.KASA_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_cyan = register("block_mkasa_cyan", () -> new ItemNameBlockItem(Unit_Blocks.KASA_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_purple = register("block_mkasa_purple", () -> new ItemNameBlockItem(Unit_Blocks.KASA_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_blue = register("block_mkasa_blue", () -> new ItemNameBlockItem(Unit_Blocks.KASA_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_brown = register("block_mkasa_brown", () -> new ItemNameBlockItem(Unit_Blocks.KASA_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_green = register("block_mkasa_green", () -> new ItemNameBlockItem(Unit_Blocks.KASA_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_red = register("block_mkasa_red", () -> new ItemNameBlockItem(Unit_Blocks.KASA_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASA_black = register("block_mkasa_black", () -> new ItemNameBlockItem(Unit_Blocks.KASA_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> TOBUKURO_S = register("block_tobukuro_spruce", () -> new Fuel_300(Slidedoor_Blocks.TOBUKURO_S.get(), new Item.Properties()));
	public static final RegistryObject<Item> TOBUKUROWIN_S = register("block_tobukurowin_spruce", () -> new Fuel_150(Slidedoor_Blocks.TOBUKUROWIN_S.get(), new Item.Properties()));
	public static final RegistryObject<Item> TOBUKURO = register("block_tobukuro", () -> new Fuel_300(Slidedoor_Blocks.TOBUKURO.get(), new Item.Properties()));
	public static final RegistryObject<Item> TOBUKUROWIN = register("block_tobukurowin", () -> new Fuel_150(Slidedoor_Blocks.TOBUKUROWIN.get(), new Item.Properties()));

	public static final RegistryObject<Item> BONSAI_oak = register("block_bonsai_oak", () -> new ItemNameBlockItem(Garden_Blocks.BONSAI_oak.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_spru = register("block_bonsai_spruce", () -> new ItemNameBlockItem(Garden_Blocks.BONSAI_spru.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_bir = register("block_bonsai_birch", () -> new ItemNameBlockItem(Garden_Blocks.BONSAI_bir.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_jun = register("block_bonsai_jungle", () -> new ItemNameBlockItem(Garden_Blocks.BONSAI_jun.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_aca = register("block_bonsai_acacia", () -> new ItemNameBlockItem(Garden_Blocks.BONSAI_aca.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_doak = register("block_bonsai_darkoak", () -> new ItemNameBlockItem(Garden_Blocks.BONSAI_doak.get(), new Item.Properties()));

	public static final RegistryObject<Item> KANYOU = register("block_kanyouoak_bot", () -> new ItemNameBlockItem(Garden_Blocks.KANYOU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_spruce = register("block_kanyouspruce_bot", () -> new ItemNameBlockItem(Garden_Blocks.KANYOU_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_birch = register("block_kanyoubirch_bot", () -> new ItemNameBlockItem(Garden_Blocks.KANYOU_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_jungle = register("block_kanyoujungle_bot", () -> new ItemNameBlockItem(Garden_Blocks.KANYOU_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_acacia = register("block_kanyouacacia_bot", () -> new ItemNameBlockItem(Garden_Blocks.KANYOU_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_darkoak = register("block_kanyoudarkoak_bot", () -> new ItemNameBlockItem(Garden_Blocks.KANYOU_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> IKEGAKI = register("block_low_oak", () -> new Fuel_150(Garden_Blocks.IKEGAKI.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_spruce = register("block_low_spruce", () -> new Fuel_150(Garden_Blocks.IKEGAKI_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_birch = register("block_low_birch", () -> new Fuel_150(Garden_Blocks.IKEGAKI_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_jungle = register("block_low_jungle", () -> new Fuel_150(Garden_Blocks.IKEGAKI_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_acacia = register("block_low_acacia", () -> new Fuel_150(Garden_Blocks.IKEGAKI_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_darkoak = register("block_low_darkoak", () -> new Fuel_150(Garden_Blocks.IKEGAKI_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> IKEGAKILONG = register("block_longoak_bot", () -> new Fuel_300(Garden_Blocks.IKEGAKILONG.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_spruce = register("block_longspruce_bot", () -> new Fuel_300(Garden_Blocks.IKEGAKILONG_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_birch = register("block_longbirch_bot", () -> new Fuel_300(Garden_Blocks.IKEGAKILONG_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_jungle = register("block_longjungle_bot", () -> new Fuel_300(Garden_Blocks.IKEGAKILONG_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_acacia = register("block_longacacia_bot", () -> new Fuel_300(Garden_Blocks.IKEGAKILONG_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_darkoak = register("block_longdarkoak_bot", () -> new Fuel_300(Garden_Blocks.IKEGAKILONG_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> ITABEI = register("block_itabei", () -> new Fuel_200(Garden_Blocks.ITABEI.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_spruce = register("block_itabei_spruce", () -> new Fuel_200(Garden_Blocks.ITABEI_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_birch = register("block_itabei_birch", () -> new Fuel_200(Garden_Blocks.ITABEI_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_jungle = register("block_itabei_jungle", () -> new Fuel_200(Garden_Blocks.ITABEI_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_acacia = register("block_itabei_acacia", () -> new Fuel_200(Garden_Blocks.ITABEI_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_darkoak = register("block_itabei_darkoak", () -> new Fuel_200(Garden_Blocks.ITABEI_darkoak.get(), new Item.Properties()));

	public static final RegistryObject<Item> KIDO = register("block_kido", () -> new Fuel_200(Garden_Blocks.KIDO.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_spruce = register("block_kido_spruce", () -> new Fuel_200(Garden_Blocks.KIDO_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_birch = register("block_kido_birch", () -> new Fuel_200(Garden_Blocks.KIDO_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_jungle = register("block_kido_jungle", () -> new Fuel_200(Garden_Blocks.KIDO_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_acacia = register("block_kido_acacia", () -> new Fuel_200(Garden_Blocks.KIDO_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_darkoak = register("block_kido_darkoak", () -> new Fuel_200(Garden_Blocks.KIDO_darkoak.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> SHISHIODOSHI = register("block_shishiodoshi", () -> new ItemNameBlockItem(Garden_Blocks.SHISHIODOSHI.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHOUZUBACHI = register("block_chouzubachi_kara", () -> new ItemNameBlockItem(Garden_Blocks.CHOUZUBACHI.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHOUZUBACHI_gra = register("block_chouzu_gra_kara", () -> new ItemNameBlockItem(Garden_Blocks.CHOUZUBACHI_gra.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHOUZUBACHI_dio = register("block_chouzu_dio_kara", () -> new ItemNameBlockItem(Garden_Blocks.CHOUZUBACHI_dio.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHOUZUBACHI_and = register("block_chouzu_and_kara", () -> new ItemNameBlockItem(Garden_Blocks.CHOUZUBACHI_and.get(), new Item.Properties()));

	public static final RegistryObject<Item> ISHITOUROU = register("block_ishitourou_stone", () -> new ItemNameBlockItem(Garden_Blocks.ISHITOUROU.get(), new Item.Properties()));
	public static final RegistryObject<Item> ISHITOUROU_gra = register("block_ishitourou_gra", () -> new ItemNameBlockItem(Garden_Blocks.ISHITOUROU_gra.get(), new Item.Properties()));
	public static final RegistryObject<Item> ISHITOUROU_dio = register("block_ishitourou_dio", () -> new ItemNameBlockItem(Garden_Blocks.ISHITOUROU_dio.get(), new Item.Properties()));
	public static final RegistryObject<Item> ISHITOUROU_and = register("block_ishitourou_and", () -> new ItemNameBlockItem(Garden_Blocks.ISHITOUROU_and.get(), new Item.Properties()));

	public static final RegistryObject<Item> LONGTOUROU = register("block_longtourou_stone", () -> new ItemNameBlockItem(Garden_Blocks.LONGTOUROU.get(), new Item.Properties()));
	public static final RegistryObject<Item> LONGTOUROU_gra = register("block_longtourou_gra", () -> new ItemNameBlockItem(Garden_Blocks.LONGTOUROU_gra.get(), new Item.Properties()));
	public static final RegistryObject<Item> LONGTOUROU_dio = register("block_longtourou_dio", () -> new ItemNameBlockItem(Garden_Blocks.LONGTOUROU_dio.get(), new Item.Properties()));
	public static final RegistryObject<Item> LONGTOUROU_and = register("block_longtourou_and", () -> new ItemNameBlockItem(Garden_Blocks.LONGTOUROU_and.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEAKARI = register("block_takeakari", () -> new Fuel_100(Garden_Blocks.TAKEAKARI.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEAKARI_Y = register("block_takeakari_y", () -> new Fuel_100(Garden_Blocks.TAKEAKARI_Y.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKEAKARI_K = register("block_takeakari_k", () -> new Fuel_100(Garden_Blocks.TAKEAKARI_K.get(), new Item.Properties()));

	public static final RegistryObject<Item> WADAIKO = register("block_wadaiko", () -> new Fuel_300(JPDeco_Blocks.WADAIKO.get(), new Item.Properties()));
	public static final RegistryObject<Item> WADAIKO_small = register("block_wadaiko_small", () -> new Fuel_150(JPDeco_Blocks.WADAIKO_small.get(), new Item.Properties()));

	public static final RegistryObject<Item> ENDAI = register("block_mendai", () -> new Fuel_300(Unit_Blocks.ENDAI.get(), new Item.Properties()));
	public static final RegistryObject<Item> ENDAI_r = register("block_mendai_red", () -> new Fuel_300(Unit_Blocks.ENDAI_r.get(), new Item.Properties()));

	public static final RegistryObject<Item> GATE_SPRUCE = register("block_gate_spruce", () -> new ItemNameBlockItem(Gate_Blocks.GATE_SPRUCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GATE_SPRUCE_B = register("block_gate_spruce_b", () -> new ItemNameBlockItem(Gate_Blocks.GATE_SPRUCE_B.get(), new Item.Properties()));
	public static final RegistryObject<Item> GATE_IRON = register("block_gate_iron", () -> new ItemNameBlockItem(Gate_Blocks.GATE_IRON.get(), new Item.Properties()));
	public static final RegistryObject<Item> GATE_IRONGRILL = register("block_gate_irongrill", () -> new ItemNameBlockItem(Gate_Blocks.GATE_IRONGRILL.get(), new Item.Properties()));
	public static final RegistryObject<Item> TETSUSAKU_BOT = register("block_ironfence_bot", () -> new ItemNameBlockItem(Garden_Blocks.TETSUSAKU_BOT.get(), new Item.Properties()));

	public static final RegistryObject<Item> HAKE = register("item_hake", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_white = register("item_hake_white", () -> new ItemHake_White(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_orange = register("item_hake_orange", () -> new ItemHake_Orange(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_magenta = register("item_hake_magenta", () -> new ItemHake_Magenta(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_lightb = register("item_hake_lightblue", () -> new ItemHake_LightBlue(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_yellow = register("item_hake_yellow", () -> new ItemHake_Yellow(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_lime = register("item_hake_lime", () -> new ItemHake_Lime(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_pink = register("item_hake_pink", () -> new ItemHake_Pink(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_gray = register("item_hake_gray", () -> new ItemHake_Gray(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_lightg = register("item_hake_lightgray", () -> new ItemHake_LightGray(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_cyan = register("item_hake_cyan", () -> new ItemHake_Cyan(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_purple = register("item_hake_purple", () -> new ItemHake_Purple(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_blue = register("item_hake_blue", () -> new ItemHake_Blue(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_brown = register("item_hake_brown", () -> new ItemHake_Brown(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_green = register("item_hake_green", () -> new ItemHake_Green(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_red = register("item_hake_red", () -> new ItemHake_Red(new Item.Properties()));
	public static final RegistryObject<Item> HAKE_black = register("item_hake_black", () -> new ItemHake_Black(new Item.Properties()));

	public static final RegistryObject<Item> KUMADE = register("item_kumade", () -> new ItemKumade(new Item.Properties()));
	public static final RegistryObject<Item> NOMI = register("item_chisel", () -> new ItemChisel(new Item.Properties()));
	
	public static final RegistryObject<Item> MAKIBISHI = register("block_makibishi", () -> new ItemNameBlockItem(Garden_Blocks.MAKIBISHI.get(), new Item.Properties()));
	

	///* Register *///
	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}
}
