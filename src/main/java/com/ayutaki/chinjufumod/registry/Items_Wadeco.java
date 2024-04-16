package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ItemGroups_CM;
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
import com.ayutaki.chinjufumod.items.fuel.Wadeco_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.Wadeco_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.Wadeco_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.Wadeco_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.Wadeco_noFuel;
import com.ayutaki.chinjufumod.items.garden.ItemChisel;
import com.ayutaki.chinjufumod.items.garden.ItemKumade;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Wadeco {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static Item GARASUDO = register("block_garasudo", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDO, new Item.Properties()));
	public static Item GARASUDO_SPRU = register("block_garasudo_spruce", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDO_SPRU, new Item.Properties()));
	public static Item GARASUDO_BIR = register("block_garasudo_birch", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDO_BIR, new Item.Properties()));
	public static Item GARASUDO_JUN = register("block_garasudo_jungle", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDO_JUN, new Item.Properties()));
	public static Item GARASUDO_ACA = register("block_garasudo_acacia", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDO_ACA, new Item.Properties()));
	public static Item GARASUDO_DOAK = register("block_garasudo_darkoak", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDO_DOAK, new Item.Properties()));

	public static Item GARASUDOB = register("block_garasudob", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOB, new Item.Properties()));
	public static Item GARASUDOB_SPRU = register("block_garasudob_spruce", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOB_SPRU, new Item.Properties()));
	public static Item GARASUDOB_BIR = register("block_garasudob_birch", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOB_BIR, new Item.Properties()));
	public static Item GARASUDOB_JUN = register("block_garasudob_jungle", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOB_JUN, new Item.Properties()));
	public static Item GARASUDOB_ACA = register("block_garasudob_acacia", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOB_ACA, new Item.Properties()));
	public static Item GARASUDOB_DOAK = register("block_garasudob_darkoak", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOB_DOAK, new Item.Properties()));

	public static Item GARASUDOH = register("block_garasudohalf", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOH, new Item.Properties()));
	public static Item GARASUDOH_SPRU = register("block_garasudohalf_spruce", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOH_SPRU, new Item.Properties()));
	public static Item GARASUDOH_BIR = register("block_garasudohalf_birch", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOH_BIR, new Item.Properties()));
	public static Item GARASUDOH_JUN = register("block_garasudohalf_jungle", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOH_JUN, new Item.Properties()));
	public static Item GARASUDOH_ACA = register("block_garasudohalf_acacia", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOH_ACA, new Item.Properties()));
	public static Item GARASUDOH_DOAK = register("block_garasudohalf_darkoak", new Wadeco_noFuel(Slidedoor_Blocks.GARASUDOH_DOAK, new Item.Properties()));

	public static Item SHOUJI = register("block_shouji", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJI, new Item.Properties()));
	public static Item SHOUJI_SPRU = register("block_shouji_spruce", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJI_SPRU, new Item.Properties()));
	public static Item SHOUJI_BIR = register("block_shouji_birch", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJI_BIR, new Item.Properties()));
	public static Item SHOUJI_JUN = register("block_shouji_jungle", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJI_JUN, new Item.Properties()));
	public static Item SHOUJI_ACA = register("block_shouji_acacia", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJI_ACA, new Item.Properties()));
	public static Item SHOUJI_DOAK = register("block_shouji_darkoak", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJI_DOAK, new Item.Properties()));

	public static Item SHOUJIB = register("block_shoujib", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJIB, new Item.Properties()));
	public static Item SHOUJIB_SPRU = register("block_shoujib_spruce", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJIB_SPRU, new Item.Properties()));
	public static Item SHOUJIB_BIR = register("block_shoujib_birch", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJIB_BIR, new Item.Properties()));
	public static Item SHOUJIB_JUN = register("block_shoujib_jungle", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJIB_JUN, new Item.Properties()));
	public static Item SHOUJIB_ACA = register("block_shoujib_acacia", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJIB_ACA, new Item.Properties()));
	public static Item SHOUJIB_DOAK = register("block_shoujib_darkoak", new Wadeco_Fuel200(Slidedoor_Blocks.SHOUJIB_DOAK, new Item.Properties()));

	public static Item SHOUJIH = register("block_shoujihalf", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJIH, new Item.Properties()));
	public static Item SHOUJIH_SPRU = register("block_shoujihalf_spruce", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJIH_SPRU, new Item.Properties()));
	public static Item SHOUJIH_BIR = register("block_shoujihalf_birch", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJIH_BIR, new Item.Properties()));
	public static Item SHOUJIH_JUN = register("block_shoujihalf_jungle", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJIH_JUN, new Item.Properties()));
	public static Item SHOUJIH_ACA = register("block_shoujihalf_acacia", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJIH_ACA, new Item.Properties()));
	public static Item SHOUJIH_DOAK = register("block_shoujihalf_darkoak", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJIH_DOAK, new Item.Properties()));

	public static Item SHOUJI_WIN = register("block_shoujih", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJI_WIN, new Item.Properties()));
	public static Item SHOUJI_WIN_SPRU = register("block_shoujih_spruce", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_SPRU, new Item.Properties()));
	public static Item SHOUJI_WIN_BIR = register("block_shoujih_birch", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_BIR, new Item.Properties()));
	public static Item SHOUJI_WIN_JUN = register("block_shoujih_jungle", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_JUN, new Item.Properties()));
	public static Item SHOUJI_WIN_ACA = register("block_shoujih_acacia", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_ACA, new Item.Properties()));
	public static Item SHOUJI_WIN_DOAK = register("block_shoujih_darkoak", new Wadeco_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_DOAK, new Item.Properties()));

	public static Item RANMA_oak = register("block_ranma_oak", new Wadeco_Fuel150(Ranma_Blocks.RANMA_oak, new Item.Properties()));
	public static Item RANMA_spruce = register("block_ranma_spru", new Wadeco_Fuel150(Ranma_Blocks.RANMA_spruce, new Item.Properties()));
	public static Item RANMA_birch = register("block_ranma_bir", new Wadeco_Fuel150(Ranma_Blocks.RANMA_birch, new Item.Properties()));
	public static Item RANMA_jungle = register("block_ranma_jun", new Wadeco_Fuel150(Ranma_Blocks.RANMA_jungle, new Item.Properties()));
	public static Item RANMA_acacia = register("block_ranma_aca", new Wadeco_Fuel150(Ranma_Blocks.RANMA_acacia, new Item.Properties()));
	public static Item RANMA_darkoak = register("block_ranma_doak", new Wadeco_Fuel150(Ranma_Blocks.RANMA_darkoak, new Item.Properties()));

	public static Item RANMAB_oak = register("block_ranmab_oak", new Wadeco_Fuel150(Ranma_Blocks.RANMAB_oak, new Item.Properties()));
	public static Item RANMAB_spruce = register("block_ranmab_spru", new Wadeco_Fuel150(Ranma_Blocks.RANMAB_spruce, new Item.Properties()));
	public static Item RANMAB_birch = register("block_ranmab_bir", new Wadeco_Fuel150(Ranma_Blocks.RANMAB_birch, new Item.Properties()));
	public static Item RANMAB_jungle = register("block_ranmab_jun", new Wadeco_Fuel150(Ranma_Blocks.RANMAB_jungle, new Item.Properties()));
	public static Item RANMAB_acacia = register("block_ranmab_aca", new Wadeco_Fuel150(Ranma_Blocks.RANMAB_acacia, new Item.Properties()));
	public static Item RANMAB_darkoak = register("block_ranmab_doak", new Wadeco_Fuel150(Ranma_Blocks.RANMAB_darkoak, new Item.Properties()));

	public static Item RANMAC_oak = register("block_ranmac_oak", new Wadeco_noFuel(Ranma_Blocks.RANMAC_oak, new Item.Properties()));
	public static Item RANMAC_spruce = register("block_ranmac_spru", new Wadeco_noFuel(Ranma_Blocks.RANMAC_spruce, new Item.Properties()));
	public static Item RANMAC_birch = register("block_ranmac_bir", new Wadeco_noFuel(Ranma_Blocks.RANMAC_birch, new Item.Properties()));
	public static Item RANMAC_jungle = register("block_ranmac_jun", new Wadeco_noFuel(Ranma_Blocks.RANMAC_jungle, new Item.Properties()));
	public static Item RANMAC_acacia = register("block_ranmac_aca", new Wadeco_noFuel(Ranma_Blocks.RANMAC_acacia, new Item.Properties()));
	public static Item RANMAC_darkoak = register("block_ranmac_doak", new Wadeco_noFuel(Ranma_Blocks.RANMAC_darkoak, new Item.Properties()));

	public static Item KANKI_oak = register("block_kanki_oak", new Wadeco_Fuel150(Ranma_Blocks.KANKI_oak, new Item.Properties()));
	public static Item KANKI_spruce = register("block_kanki_spru", new Wadeco_Fuel150(Ranma_Blocks.KANKI_spruce, new Item.Properties()));
	public static Item KANKI_birch = register("block_kanki_bir", new Wadeco_Fuel150(Ranma_Blocks.KANKI_birch, new Item.Properties()));
	public static Item KANKI_jungle = register("block_kanki_jun", new Wadeco_Fuel150(Ranma_Blocks.KANKI_jungle, new Item.Properties()));
	public static Item KANKI_acacia = register("block_kanki_aca", new Wadeco_Fuel150(Ranma_Blocks.KANKI_acacia, new Item.Properties()));
	public static Item KANKI_darkoak = register("block_kanki_doak", new Wadeco_Fuel150(Ranma_Blocks.KANKI_darkoak, new Item.Properties()));

	public static Item KOUSHI_oak = register("block_koushi_oak", new Wadeco_Fuel150(Ranma_Blocks.KOUSHI_oak, new Item.Properties()));
	public static Item KOUSHI_spruce = register("block_koushi_spru", new Wadeco_Fuel150(Ranma_Blocks.KOUSHI_spruce, new Item.Properties()));
	public static Item KOUSHI_birch = register("block_koushi_bir", new Wadeco_Fuel150(Ranma_Blocks.KOUSHI_birch, new Item.Properties()));
	public static Item KOUSHI_jungle = register("block_koushi_jun", new Wadeco_Fuel150(Ranma_Blocks.KOUSHI_jungle, new Item.Properties()));
	public static Item KOUSHI_acacia = register("block_koushi_aca", new Wadeco_Fuel150(Ranma_Blocks.KOUSHI_acacia, new Item.Properties()));
	public static Item KOUSHI_darkoak = register("block_koushi_doak", new Wadeco_Fuel150(Ranma_Blocks.KOUSHI_darkoak, new Item.Properties()));

	public static Item KOUSHIB_oak = register("block_koushib_oak", new Wadeco_Fuel150(Ranma_Blocks.KOUSHIB_oak, new Item.Properties()));
	public static Item KOUSHIB_spruce = register("block_koushib_spru", new Wadeco_Fuel150(Ranma_Blocks.KOUSHIB_spruce, new Item.Properties()));
	public static Item KOUSHIB_birch = register("block_koushib_bir", new Wadeco_Fuel150(Ranma_Blocks.KOUSHIB_birch, new Item.Properties()));
	public static Item KOUSHIB_jungle = register("block_koushib_jun", new Wadeco_Fuel150(Ranma_Blocks.KOUSHIB_jungle, new Item.Properties()));
	public static Item KOUSHIB_acacia = register("block_koushib_aca", new Wadeco_Fuel150(Ranma_Blocks.KOUSHIB_acacia, new Item.Properties()));
	public static Item KOUSHIB_darkoak = register("block_koushib_doak", new Wadeco_Fuel150(Ranma_Blocks.KOUSHIB_darkoak, new Item.Properties()));

	public static Item FUSUMA_white = register("block_fusuma", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_white, new Item.Properties()));
	public static Item FUSUMA_orange = register("block_fusuma_orange", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_orange, new Item.Properties()));
	public static Item FUSUMA_magenta = register("block_fusuma_magenta", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_magenta, new Item.Properties()));
	public static Item FUSUMA_lightb = register("block_fusuma_lightb", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_lightb, new Item.Properties()));
	public static Item FUSUMA_yellow = register("block_fusuma_yellow", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_yellow, new Item.Properties()));
	public static Item FUSUMA_lime = register("block_fusuma_lime", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_lime, new Item.Properties()));
	public static Item FUSUMA_pink = register("block_fusuma_pink", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_pink, new Item.Properties()));
	public static Item FUSUMA_gray = register("block_fusuma_gray", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_gray, new Item.Properties()));
	public static Item FUSUMA_lightg = register("block_fusuma_lightg", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_lightg, new Item.Properties()));
	public static Item FUSUMA_cyan = register("block_fusuma_cyan", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_cyan, new Item.Properties()));
	public static Item FUSUMA_purple = register("block_fusuma_purple", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_purple, new Item.Properties()));
	public static Item FUSUMA_blue = register("block_fusuma_blue", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_blue, new Item.Properties()));
	public static Item FUSUMA_brown = register("block_fusuma_brown", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_brown, new Item.Properties()));
	public static Item FUSUMA_green = register("block_fusuma_green", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_green, new Item.Properties()));
	public static Item FUSUMA_red = register("block_fusuma_red", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_red, new Item.Properties()));
	public static Item FUSUMA_black = register("block_fusuma_black", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMA_black, new Item.Properties()));

	public static Item FUSUMAB_white = register("block_fusumab", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_white, new Item.Properties()));
	public static Item FUSUMAB_orange = register("block_fusumab_orange", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_orange, new Item.Properties()));
	public static Item FUSUMAB_magenta = register("block_fusumab_magenta", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_magenta, new Item.Properties()));
	public static Item FUSUMAB_lightb = register("block_fusumab_lightb", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_lightb, new Item.Properties()));
	public static Item FUSUMAB_yellow = register("block_fusumab_yellow", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_yellow, new Item.Properties()));
	public static Item FUSUMAB_lime = register("block_fusumab_lime", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_lime, new Item.Properties()));
	public static Item FUSUMAB_pink = register("block_fusumab_pink", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_pink, new Item.Properties()));
	public static Item FUSUMAB_gray = register("block_fusumab_gray", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_gray, new Item.Properties()));
	public static Item FUSUMAB_lightg = register("block_fusumab_lightg", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_lightg, new Item.Properties()));
	public static Item FUSUMAB_cyan = register("block_fusumab_cyan", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_cyan, new Item.Properties()));
	public static Item FUSUMAB_purple = register("block_fusumab_purple", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_purple, new Item.Properties()));
	public static Item FUSUMAB_blue = register("block_fusumab_blue", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_blue, new Item.Properties()));
	public static Item FUSUMAB_brown = register("block_fusumab_brown", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_brown, new Item.Properties()));
	public static Item FUSUMAB_green = register("block_fusumab_green", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_green, new Item.Properties()));
	public static Item FUSUMAB_red = register("block_fusumab_red", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_red, new Item.Properties()));
	public static Item FUSUMAB_black = register("block_fusumab_black", new Wadeco_Fuel200(Slidedoor_Blocks.FUSUMAB_black, new Item.Properties()));

	public static Item SUDARE = register("block_sudare_1", new Wadeco_Fuel100(Garden_Blocks.SUDARE, new Item.Properties()));

	public static Item NOREN_white = register("block_noren_white", new Wadeco_noFuel(Ranma_Blocks.NOREN_white, new Item.Properties()));
	public static Item NOREN_orange = register("block_noren_orange", new Wadeco_noFuel(Ranma_Blocks.NOREN_orange, new Item.Properties()));
	public static Item NOREN_magenta = register("block_noren_magenta", new Wadeco_noFuel(Ranma_Blocks.NOREN_magenta, new Item.Properties()));
	public static Item NOREN_lightb = register("block_noren_lightb", new Wadeco_noFuel(Ranma_Blocks.NOREN_lightb, new Item.Properties()));
	public static Item NOREN_yellow = register("block_noren_yellow", new Wadeco_noFuel(Ranma_Blocks.NOREN_yellow, new Item.Properties()));
	public static Item NOREN_lime = register("block_noren_lime", new Wadeco_noFuel(Ranma_Blocks.NOREN_lime, new Item.Properties()));
	public static Item NOREN_pink = register("block_noren_pink", new Wadeco_noFuel(Ranma_Blocks.NOREN_pink, new Item.Properties()));
	public static Item NOREN_gray = register("block_noren_gray", new Wadeco_noFuel(Ranma_Blocks.NOREN_gray, new Item.Properties()));
	public static Item NOREN_lightg = register("block_noren_lightg", new Wadeco_noFuel(Ranma_Blocks.NOREN_lightg, new Item.Properties()));
	public static Item NOREN_cyan = register("block_noren_cyan", new Wadeco_noFuel(Ranma_Blocks.NOREN_cyan, new Item.Properties()));
	public static Item NOREN_purple = register("block_noren_purple", new Wadeco_noFuel(Ranma_Blocks.NOREN_purple, new Item.Properties()));
	public static Item NOREN_blue = register("block_noren_blue", new Wadeco_noFuel(Ranma_Blocks.NOREN_blue, new Item.Properties()));
	public static Item NOREN_brown = register("block_noren_brown", new Wadeco_noFuel(Ranma_Blocks.NOREN_brown, new Item.Properties()));
	public static Item NOREN_green = register("block_noren_green", new Wadeco_noFuel(Ranma_Blocks.NOREN_green, new Item.Properties()));
	public static Item NOREN_red = register("block_noren_red", new Wadeco_noFuel(Ranma_Blocks.NOREN_red, new Item.Properties()));
	public static Item NOREN_black = register("block_noren_black", new Wadeco_noFuel(Ranma_Blocks.NOREN_black, new Item.Properties()));

	public static Item WARAZABUTON = register("block_wara_zabuton", new Wadeco_Fuel100(JPChair_Blocks.WARAZABUTON, new Item.Properties()));

	public static Item ZABUTON_white = register("block_mzabuton_white", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_white, new Item.Properties()));
	public static Item ZABUTON_orange = register("block_mzabuton_orange", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_orange, new Item.Properties()));
	public static Item ZABUTON_magenta = register("block_mzabuton_magenta", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_magenta, new Item.Properties()));
	public static Item ZABUTON_lightb = register("block_mzabuton_lightb", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_lightb, new Item.Properties()));
	public static Item ZABUTON_yellow = register("block_mzabuton_yellow", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_yellow, new Item.Properties()));
	public static Item ZABUTON_lime = register("block_mzabuton_lime", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_lime, new Item.Properties()));
	public static Item ZABUTON_pink = register("block_mzabuton_pink", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_pink, new Item.Properties()));
	public static Item ZABUTON_gray = register("block_mzabuton_gray", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_gray, new Item.Properties()));
	public static Item ZABUTON_lightg = register("block_mzabuton_lightg", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_lightg, new Item.Properties()));
	public static Item ZABUTON_cyan = register("block_mzabuton_cyan", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_cyan, new Item.Properties()));
	public static Item ZABUTON_purple = register("block_mzabuton_purple", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_purple, new Item.Properties()));
	public static Item ZABUTON_blue = register("block_mzabuton_blue", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_blue, new Item.Properties()));
	public static Item ZABUTON_brown = register("block_mzabuton_brown", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_brown, new Item.Properties()));
	public static Item ZABUTON_green = register("block_mzabuton_green", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_green, new Item.Properties()));
	public static Item ZABUTON_red = register("block_mzabuton_red", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_red, new Item.Properties()));
	public static Item ZABUTON_black = register("block_mzabuton_black", new Wadeco_Fuel100(JPChair_Blocks.ZABUTON_black, new Item.Properties()));

	public static Item ZAISU_white = register("block_zaisu_white", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_white, new Item.Properties()));
	public static Item ZAISU_orange = register("block_zaisu_orange", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_orange, new Item.Properties()));
	public static Item ZAISU_magenta = register("block_zaisu_magenta", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_magenta, new Item.Properties()));
	public static Item ZAISU_lightb = register("block_zaisu_lightb", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_lightb, new Item.Properties()));
	public static Item ZAISU_yellow = register("block_zaisu_yellow", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_yellow, new Item.Properties()));
	public static Item ZAISU_lime = register("block_zaisu_lime", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_lime, new Item.Properties()));
	public static Item ZAISU_pink = register("block_zaisu_pink", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_pink, new Item.Properties()));
	public static Item ZAISU_gray = register("block_zaisu_gray", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_gray, new Item.Properties()));
	public static Item ZAISU_lightg = register("block_zaisu_lightg", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_lightg, new Item.Properties()));
	public static Item ZAISU_cyan = register("block_zaisu_cyan", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_cyan, new Item.Properties()));
	public static Item ZAISU_purple = register("block_zaisu_purple", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_purple, new Item.Properties()));
	public static Item ZAISU_blue = register("block_zaisu_blue", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_blue, new Item.Properties()));
	public static Item ZAISU_brown = register("block_zaisu_brown", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_brown, new Item.Properties()));
	public static Item ZAISU_green = register("block_zaisu_green", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_green, new Item.Properties()));
	public static Item ZAISU_red = register("block_zaisu_red", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_red, new Item.Properties()));
	public static Item ZAISU_black = register("block_zaisu_black", new Wadeco_Fuel150(JPChair_Blocks.ZAISU_black, new Item.Properties()));

	public static Item TATAMI_H = register("block_tatamih", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H, new Item.Properties()));
	public static Item TATAMI_H_white = register("block_tatamih_white", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_white, new Item.Properties()));
	public static Item TATAMI_H_orange = register("block_tatamih_orange", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_orange, new Item.Properties()));
	public static Item TATAMI_H_magenta = register("block_tatamih_magenta", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_magenta, new Item.Properties()));
	public static Item TATAMI_H_lightb = register("block_tatamih_lightb", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_lightb, new Item.Properties()));
	public static Item TATAMI_H_yellow = register("block_tatamih_yellow", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_yellow, new Item.Properties()));
	public static Item TATAMI_H_lime = register("block_tatamih_lime", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_lime, new Item.Properties()));
	public static Item TATAMI_H_pink = register("block_tatamih_pink", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_pink, new Item.Properties()));
	public static Item TATAMI_H_gray = register("block_tatamih_gray", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_gray, new Item.Properties()));
	public static Item TATAMI_H_lightg = register("block_tatamih_lightg", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_lightg, new Item.Properties()));
	public static Item TATAMI_H_cyan = register("block_tatamih_cyan", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_cyan, new Item.Properties()));
	public static Item TATAMI_H_purple = register("block_tatamih_purple", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_purple, new Item.Properties()));
	public static Item TATAMI_H_blue = register("block_tatamih_blue", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_blue, new Item.Properties()));
	public static Item TATAMI_H_brown = register("block_tatamih_brown", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_brown, new Item.Properties()));
	public static Item TATAMI_H_green = register("block_tatamih_green", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_green, new Item.Properties()));
	public static Item TATAMI_H_red = register("block_tatamih_red", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_red, new Item.Properties()));
	public static Item TATAMI_H_black = register("block_tatamih_black", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_H_black, new Item.Properties()));

	public static Item TATAMI_HY = register("block_tatamih_y", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY, new Item.Properties()));
	public static Item TATAMI_HY_white = register("block_tatamih_y_white", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_white, new Item.Properties()));
	public static Item TATAMI_HY_orange = register("block_tatamih_y_orange", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_orange, new Item.Properties()));
	public static Item TATAMI_HY_magenta = register("block_tatamih_y_magenta", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_magenta, new Item.Properties()));
	public static Item TATAMI_HY_lightb = register("block_tatamih_y_lightb", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_lightb, new Item.Properties()));
	public static Item TATAMI_HY_yellow = register("block_tatamih_y_yellow", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_yellow, new Item.Properties()));
	public static Item TATAMI_HY_lime = register("block_tatamih_y_lime", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_lime, new Item.Properties()));
	public static Item TATAMI_HY_pink = register("block_tatamih_y_pink", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_pink, new Item.Properties()));
	public static Item TATAMI_HY_gray = register("block_tatamih_y_gray", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_gray, new Item.Properties()));
	public static Item TATAMI_HY_lightg = register("block_tatamih_y_lightg", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_lightg, new Item.Properties()));
	public static Item TATAMI_HY_cyan = register("block_tatamih_y_cyan", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_cyan, new Item.Properties()));
	public static Item TATAMI_HY_purple = register("block_tatamih_y_purple", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_purple, new Item.Properties()));
	public static Item TATAMI_HY_blue = register("block_tatamih_y_blue", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_blue, new Item.Properties()));
	public static Item TATAMI_HY_brown = register("block_tatamih_y_brown", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_brown, new Item.Properties()));
	public static Item TATAMI_HY_green = register("block_tatamih_y_green", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_green, new Item.Properties()));
	public static Item TATAMI_HY_red = register("block_tatamih_y_red", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_red, new Item.Properties()));
	public static Item TATAMI_HY_black = register("block_tatamih_y_black", new Wadeco_Fuel150(JPDeco_Blocks.TATAMI_HY_black, new Item.Properties()));

	public static Item TAKECUBE = register("block_bamboo_cube", new Wadeco_Fuel200(JPDeco_Blocks.TAKECUBE, new Item.Properties()));
	public static Item TAKECUBE_Y = register("block_bamboo_y_cube", new Wadeco_Fuel200(JPDeco_Blocks.TAKECUBE_Y, new Item.Properties()));
	public static Item TAKECUBE_K = register("block_bamboo_k_cube", new Wadeco_Fuel200(JPDeco_Blocks.TAKECUBE_K, new Item.Properties()));
	public static Item TAKE_ST = register("block_bamboo_stairs", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_ST, new Item.Properties()));
	public static Item TAKE_STY = register("block_bamboo_y_stairs", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_STY, new Item.Properties()));
	public static Item TAKE_STK = register("block_bamboo_k_stairs", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_STK, new Item.Properties()));
	public static Item TAKE_SH = register("block_bamboo_slab", new Wadeco_Fuel100(JPDeco_Blocks.TAKE_SH, new Item.Properties()));
	public static Item TAKE_SHY = register("block_bamboo_y_slab", new Wadeco_Fuel100(JPDeco_Blocks.TAKE_SHY, new Item.Properties()));
	public static Item TAKE_SHK = register("block_bamboo_k_slab", new Wadeco_Fuel100(JPDeco_Blocks.TAKE_SHK, new Item.Properties()));

	public static Item TAKEFENCE = register("block_bamboo_fence", new Wadeco_Fuel150(JPDeco_Blocks.TAKEFENCE, new Item.Properties()));
	public static Item TAKEFENCE_Y = register("block_bamboo_y_fence", new Wadeco_Fuel150(JPDeco_Blocks.TAKEFENCE_Y, new Item.Properties()));
	public static Item TAKEFENCE_K = register("block_bamboo_k_fence", new Wadeco_Fuel150(JPDeco_Blocks.TAKEFENCE_K, new Item.Properties()));
	public static Item TAKEFENCEGATE = register("block_bamboo_fencegate", new Wadeco_Fuel150(JPDeco_Blocks.TAKEFENCEGATE, new Item.Properties()));
	public static Item TAKEFENCEGATE_Y = register("block_bamboo_y_fencegate", new Wadeco_Fuel150(JPDeco_Blocks.TAKEFENCEGATE_Y, new Item.Properties()));
	public static Item TAKEFENCEGATE_K = register("block_bamboo_k_fencegate", new Wadeco_Fuel150(JPDeco_Blocks.TAKEFENCEGATE_K, new Item.Properties()));
	public static Item TAKEDOOR = register("block_bamboo_door", new Wadeco_Fuel150(JPDeco_Blocks.TAKEDOOR, new Item.Properties()));
	public static Item TAKEDOOR_Y = register("block_bamboo_y_door", new Wadeco_Fuel150(JPDeco_Blocks.TAKEDOOR_Y, new Item.Properties()));
	public static Item TAKEDOOR_K = register("block_bamboo_k_door", new Wadeco_Fuel150(JPDeco_Blocks.TAKEDOOR_K, new Item.Properties()));

	public static Item TAKE_TRAPDOOR = register("block_bamboo_trapdoor", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_TRAPDOOR, new Item.Properties()));
	public static Item TAKE_TRAPDOOR_Y = register("block_bamboo_y_trapdoor", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_TRAPDOOR_Y, new Item.Properties()));
	public static Item TAKE_TRAPDOOR_K = register("block_bamboo_k_trapdoor", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_TRAPDOOR_K, new Item.Properties()));
	public static Item TAKE_PLATE = register("block_bamboo_plate", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_PLATE, new Item.Properties()));
	public static Item TAKE_PLATE_Y = register("block_bamboo_y_plate", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_PLATE_Y, new Item.Properties()));
	public static Item TAKE_PLATE_K = register("block_bamboo_k_plate", new Wadeco_Fuel150(JPDeco_Blocks.TAKE_PLATE_K, new Item.Properties()));
	public static Item TAKE_BUTTON = register("block_bamboo_button", new Wadeco_Fuel100(JPDeco_Blocks.TAKE_BUTTON, new Item.Properties()));
	public static Item TAKE_BUTTON_Y = register("block_bamboo_y_button", new Wadeco_Fuel100(JPDeco_Blocks.TAKE_BUTTON_Y, new Item.Properties()));
	public static Item TAKE_BUTTON_K = register("block_bamboo_k_button", new Wadeco_Fuel100(JPDeco_Blocks.TAKE_BUTTON_K, new Item.Properties()));

	public static Item FUTON_white = register("block_futon_c_white", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_white, new Item.Properties()));
	public static Item FUTON_orange = register("block_futon_c_orange", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_orange, new Item.Properties()));
	public static Item FUTON_magenta = register("block_futon_c_magenta", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_magenta, new Item.Properties()));
	public static Item FUTON_lightb = register("block_futon_c_lightb", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_lightb, new Item.Properties()));
	public static Item FUTON_yellow = register("block_futon_c_yellow", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_yellow, new Item.Properties()));
	public static Item FUTON_lime = register("block_futon_c_lime", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_lime, new Item.Properties()));
	public static Item FUTON_pink = register("block_futon_c_pink", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_pink, new Item.Properties()));
	public static Item FUTON_gray = register("block_futon_c_gray", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_gray, new Item.Properties()));
	public static Item FUTON_lightg = register("block_futon_c_lightg", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_lightg, new Item.Properties()));
	public static Item FUTON_cyan = register("block_futon_c_cyan", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_cyan, new Item.Properties()));
	public static Item FUTON_purple = register("block_futon_c_purple", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_purple, new Item.Properties()));
	public static Item FUTON_blue = register("block_futon_c_blue", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_blue, new Item.Properties()));
	public static Item FUTON_brown = register("block_futon_c_brown", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_brown, new Item.Properties()));
	public static Item FUTON_green = register("block_futon_c_green", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_green, new Item.Properties()));
	public static Item FUTON_red = register("block_futon_c_red", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_red, new Item.Properties()));
	public static Item FUTON_black = register("block_futon_c_black", new Wadeco_Fuel150(JPDeco_Blocks.FUTON_black, new Item.Properties()));

	public static Item ANDON_white = register("block_andon_white", new Wadeco_noFuel(JPDeco_Blocks.ANDON_white, new Item.Properties()));
	public static Item ANDON_orange = register("block_andon_orange", new Wadeco_noFuel(JPDeco_Blocks.ANDON_orange, new Item.Properties()));
	public static Item ANDON_magenta = register("block_andon_magenta", new Wadeco_noFuel(JPDeco_Blocks.ANDON_magenta, new Item.Properties()));
	public static Item ANDON_lightb = register("block_andon_lightb", new Wadeco_noFuel(JPDeco_Blocks.ANDON_lightb, new Item.Properties()));
	public static Item ANDON_yellow = register("block_andon_yellow", new Wadeco_noFuel(JPDeco_Blocks.ANDON_yellow, new Item.Properties()));
	public static Item ANDON_lime = register("block_andon_lime", new Wadeco_noFuel(JPDeco_Blocks.ANDON_lime, new Item.Properties()));
	public static Item ANDON_pink = register("block_andon_pink", new Wadeco_noFuel(JPDeco_Blocks.ANDON_pink, new Item.Properties()));
	public static Item ANDON_gray = register("block_andon_gray", new Wadeco_noFuel(JPDeco_Blocks.ANDON_gray, new Item.Properties()));
	public static Item ANDON_lightg = register("block_andon_lightg", new Wadeco_noFuel(JPDeco_Blocks.ANDON_lightg, new Item.Properties()));
	public static Item ANDON_cyan = register("block_andon_cyan", new Wadeco_noFuel(JPDeco_Blocks.ANDON_cyan, new Item.Properties()));
	public static Item ANDON_purple = register("block_andon_purple", new Wadeco_noFuel(JPDeco_Blocks.ANDON_purple, new Item.Properties()));
	public static Item ANDON_blue = register("block_andon_blue", new Wadeco_noFuel(JPDeco_Blocks.ANDON_blue, new Item.Properties()));
	public static Item ANDON_brown = register("block_andon_brown", new Wadeco_noFuel(JPDeco_Blocks.ANDON_brown, new Item.Properties()));
	public static Item ANDON_green = register("block_andon_green", new Wadeco_noFuel(JPDeco_Blocks.ANDON_green, new Item.Properties()));
	public static Item ANDON_red = register("block_andon_red", new Wadeco_noFuel(JPDeco_Blocks.ANDON_red, new Item.Properties()));
	public static Item ANDON_black = register("block_andon_black", new Wadeco_noFuel(JPDeco_Blocks.ANDON_black, new Item.Properties()));

	public static Item KASA_white = register("block_mkasa_white", new Wadeco_noFuel(Unit_Blocks.KASA_white, new Item.Properties()));
	public static Item KASA_orange = register("block_mkasa_orange", new Wadeco_noFuel(Unit_Blocks.KASA_orange, new Item.Properties()));
	public static Item KASA_magenta = register("block_mkasa_magenta", new Wadeco_noFuel(Unit_Blocks.KASA_magenta, new Item.Properties()));
	public static Item KASA_lightb = register("block_mkasa_lightb", new Wadeco_noFuel(Unit_Blocks.KASA_lightb, new Item.Properties()));
	public static Item KASA_yellow = register("block_mkasa_yellow", new Wadeco_noFuel(Unit_Blocks.KASA_yellow, new Item.Properties()));
	public static Item KASA_lime = register("block_mkasa_lime", new Wadeco_noFuel(Unit_Blocks.KASA_lime, new Item.Properties()));
	public static Item KASA_pink = register("block_mkasa_pink", new Wadeco_noFuel(Unit_Blocks.KASA_pink, new Item.Properties()));
	public static Item KASA_gray = register("block_mkasa_gray", new Wadeco_noFuel(Unit_Blocks.KASA_gray, new Item.Properties()));
	public static Item KASA_lightg = register("block_mkasa_lightg", new Wadeco_noFuel(Unit_Blocks.KASA_lightg, new Item.Properties()));
	public static Item KASA_cyan = register("block_mkasa_cyan", new Wadeco_noFuel(Unit_Blocks.KASA_cyan, new Item.Properties()));
	public static Item KASA_purple = register("block_mkasa_purple", new Wadeco_noFuel(Unit_Blocks.KASA_purple, new Item.Properties()));
	public static Item KASA_blue = register("block_mkasa_blue", new Wadeco_noFuel(Unit_Blocks.KASA_blue, new Item.Properties()));
	public static Item KASA_brown = register("block_mkasa_brown", new Wadeco_noFuel(Unit_Blocks.KASA_brown, new Item.Properties()));
	public static Item KASA_green = register("block_mkasa_green", new Wadeco_noFuel(Unit_Blocks.KASA_green, new Item.Properties()));
	public static Item KASA_red = register("block_mkasa_red", new Wadeco_noFuel(Unit_Blocks.KASA_red, new Item.Properties()));
	public static Item KASA_black = register("block_mkasa_black", new Wadeco_noFuel(Unit_Blocks.KASA_black, new Item.Properties()));

	public static Item TOBUKURO_S = register("block_tobukuro_spruce", new Wadeco_Fuel300(Slidedoor_Blocks.TOBUKURO_S, new Item.Properties()));
	public static Item TOBUKUROWIN_S = register("block_tobukurowin_spruce", new Wadeco_Fuel150(Slidedoor_Blocks.TOBUKUROWIN_S, new Item.Properties()));
	public static Item TOBUKURO = register("block_tobukuro", new Wadeco_Fuel300(Slidedoor_Blocks.TOBUKURO, new Item.Properties()));
	public static Item TOBUKUROWIN = register("block_tobukurowin", new Wadeco_Fuel150(Slidedoor_Blocks.TOBUKUROWIN, new Item.Properties()));

	public static Item BONSAI_oak = register("block_bonsai_oak", new Wadeco_noFuel(Garden_Blocks.BONSAI_oak, new Item.Properties()));
	public static Item BONSAI_spru = register("block_bonsai_spruce", new Wadeco_noFuel(Garden_Blocks.BONSAI_spru, new Item.Properties()));
	public static Item BONSAI_bir = register("block_bonsai_birch", new Wadeco_noFuel(Garden_Blocks.BONSAI_bir, new Item.Properties()));
	public static Item BONSAI_jun = register("block_bonsai_jungle", new Wadeco_noFuel(Garden_Blocks.BONSAI_jun, new Item.Properties()));
	public static Item BONSAI_aca = register("block_bonsai_acacia", new Wadeco_noFuel(Garden_Blocks.BONSAI_aca, new Item.Properties()));
	public static Item BONSAI_doak = register("block_bonsai_darkoak", new Wadeco_noFuel(Garden_Blocks.BONSAI_doak, new Item.Properties()));

	public static Item KANYOU = register("block_kanyouoak_bot", new Wadeco_noFuel(Garden_Blocks.KANYOU, new Item.Properties()));
	public static Item KANYOU_spruce = register("block_kanyouspruce_bot", new Wadeco_noFuel(Garden_Blocks.KANYOU_spruce, new Item.Properties()));
	public static Item KANYOU_birch = register("block_kanyoubirch_bot", new Wadeco_noFuel(Garden_Blocks.KANYOU_birch, new Item.Properties()));
	public static Item KANYOU_jungle = register("block_kanyoujungle_bot", new Wadeco_noFuel(Garden_Blocks.KANYOU_jungle, new Item.Properties()));
	public static Item KANYOU_acacia = register("block_kanyouacacia_bot", new Wadeco_noFuel(Garden_Blocks.KANYOU_acacia, new Item.Properties()));
	public static Item KANYOU_darkoak = register("block_kanyoudarkoak_bot", new Wadeco_noFuel(Garden_Blocks.KANYOU_darkoak, new Item.Properties()));

	public static Item IKEGAKI = register("block_low_oak", new Wadeco_Fuel150(Garden_Blocks.IKEGAKI, new Item.Properties()));
	public static Item IKEGAKI_spruce = register("block_low_spruce", new Wadeco_Fuel150(Garden_Blocks.IKEGAKI_spruce, new Item.Properties()));
	public static Item IKEGAKI_birch = register("block_low_birch", new Wadeco_Fuel150(Garden_Blocks.IKEGAKI_birch, new Item.Properties()));
	public static Item IKEGAKI_jungle = register("block_low_jungle", new Wadeco_Fuel150(Garden_Blocks.IKEGAKI_jungle, new Item.Properties()));
	public static Item IKEGAKI_acacia = register("block_low_acacia", new Wadeco_Fuel150(Garden_Blocks.IKEGAKI_acacia, new Item.Properties()));
	public static Item IKEGAKI_darkoak = register("block_low_darkoak", new Wadeco_Fuel150(Garden_Blocks.IKEGAKI_darkoak, new Item.Properties()));

	public static Item IKEGAKILONG = register("block_longoak_bot", new Wadeco_Fuel300(Garden_Blocks.IKEGAKILONG, new Item.Properties()));
	public static Item IKEGAKILONG_spruce = register("block_longspruce_bot", new Wadeco_Fuel300(Garden_Blocks.IKEGAKILONG_spruce, new Item.Properties()));
	public static Item IKEGAKILONG_birch = register("block_longbirch_bot", new Wadeco_Fuel300(Garden_Blocks.IKEGAKILONG_birch, new Item.Properties()));
	public static Item IKEGAKILONG_jungle = register("block_longjungle_bot", new Wadeco_Fuel300(Garden_Blocks.IKEGAKILONG_jungle, new Item.Properties()));
	public static Item IKEGAKILONG_acacia = register("block_longacacia_bot", new Wadeco_Fuel300(Garden_Blocks.IKEGAKILONG_acacia, new Item.Properties()));
	public static Item IKEGAKILONG_darkoak = register("block_longdarkoak_bot", new Wadeco_Fuel300(Garden_Blocks.IKEGAKILONG_darkoak, new Item.Properties()));

	public static Item ITABEI = register("block_itabei", new Wadeco_Fuel200(Garden_Blocks.ITABEI, new Item.Properties()));
	public static Item ITABEI_spruce = register("block_itabei_spruce", new Wadeco_Fuel200(Garden_Blocks.ITABEI_spruce, new Item.Properties()));
	public static Item ITABEI_birch = register("block_itabei_birch", new Wadeco_Fuel200(Garden_Blocks.ITABEI_birch, new Item.Properties()));
	public static Item ITABEI_jungle = register("block_itabei_jungle", new Wadeco_Fuel200(Garden_Blocks.ITABEI_jungle, new Item.Properties()));
	public static Item ITABEI_acacia = register("block_itabei_acacia", new Wadeco_Fuel200(Garden_Blocks.ITABEI_acacia, new Item.Properties()));
	public static Item ITABEI_darkoak = register("block_itabei_darkoak", new Wadeco_Fuel200(Garden_Blocks.ITABEI_darkoak, new Item.Properties()));

	public static Item KIDO = register("block_kido", new Wadeco_Fuel200(Garden_Blocks.KIDO, new Item.Properties()));
	public static Item KIDO_spruce = register("block_kido_spruce", new Wadeco_Fuel200(Garden_Blocks.KIDO_spruce, new Item.Properties()));
	public static Item KIDO_birch = register("block_kido_birch", new Wadeco_Fuel200(Garden_Blocks.KIDO_birch, new Item.Properties()));
	public static Item KIDO_jungle = register("block_kido_jungle", new Wadeco_Fuel200(Garden_Blocks.KIDO_jungle, new Item.Properties()));
	public static Item KIDO_acacia = register("block_kido_acacia", new Wadeco_Fuel200(Garden_Blocks.KIDO_acacia, new Item.Properties()));
	public static Item KIDO_darkoak = register("block_kido_darkoak", new Wadeco_Fuel200(Garden_Blocks.KIDO_darkoak, new Item.Properties()));
	
	public static Item SHISHIODOSHI = register("block_shishiodoshi", new Wadeco_noFuel(Garden_Blocks.SHISHIODOSHI, new Item.Properties()));
	public static Item CHOUZUBACHI = register("block_chouzubachi_kara", new Wadeco_noFuel(Garden_Blocks.CHOUZUBACHI, new Item.Properties()));
	public static Item CHOUZUBACHI_gra = register("block_chouzu_gra_kara", new Wadeco_noFuel(Garden_Blocks.CHOUZUBACHI_gra, new Item.Properties()));
	public static Item CHOUZUBACHI_dio = register("block_chouzu_dio_kara", new Wadeco_noFuel(Garden_Blocks.CHOUZUBACHI_dio, new Item.Properties()));
	public static Item CHOUZUBACHI_and = register("block_chouzu_and_kara", new Wadeco_noFuel(Garden_Blocks.CHOUZUBACHI_and, new Item.Properties()));

	public static Item ISHITOUROU = register("block_ishitourou_stone", new Wadeco_noFuel(Garden_Blocks.ISHITOUROU, new Item.Properties()));
	public static Item ISHITOUROU_gra = register("block_ishitourou_gra", new Wadeco_noFuel(Garden_Blocks.ISHITOUROU_gra, new Item.Properties()));
	public static Item ISHITOUROU_dio = register("block_ishitourou_dio", new Wadeco_noFuel(Garden_Blocks.ISHITOUROU_dio, new Item.Properties()));
	public static Item ISHITOUROU_and = register("block_ishitourou_and", new Wadeco_noFuel(Garden_Blocks.ISHITOUROU_and, new Item.Properties()));

	public static Item LONGTOUROU = register("block_longtourou_stone", new Wadeco_noFuel(Garden_Blocks.LONGTOUROU, new Item.Properties()));
	public static Item LONGTOUROU_gra = register("block_longtourou_gra", new Wadeco_noFuel(Garden_Blocks.LONGTOUROU_gra, new Item.Properties()));
	public static Item LONGTOUROU_dio = register("block_longtourou_dio", new Wadeco_noFuel(Garden_Blocks.LONGTOUROU_dio, new Item.Properties()));
	public static Item LONGTOUROU_and = register("block_longtourou_and", new Wadeco_noFuel(Garden_Blocks.LONGTOUROU_and, new Item.Properties()));
	public static Item TAKEAKARI = register("block_takeakari", new Wadeco_Fuel100(Garden_Blocks.TAKEAKARI, new Item.Properties()));
	public static Item TAKEAKARI_Y = register("block_takeakari_y", new Wadeco_Fuel100(Garden_Blocks.TAKEAKARI_Y, new Item.Properties()));
	public static Item TAKEAKARI_K = register("block_takeakari_k", new Wadeco_Fuel100(Garden_Blocks.TAKEAKARI_K, new Item.Properties()));
	
	public static Item WADAIKO = register("block_wadaiko", new Wadeco_Fuel300(JPDeco_Blocks.WADAIKO, new Item.Properties()));
	public static Item WADAIKO_small = register("block_wadaiko_small", new Wadeco_Fuel150(JPDeco_Blocks.WADAIKO_small, new Item.Properties()));

	public static Item ENDAI = register("block_mendai", new Wadeco_Fuel300(Unit_Blocks.ENDAI, new Item.Properties()));
	public static Item ENDAI_r = register("block_mendai_red", new Wadeco_Fuel300(Unit_Blocks.ENDAI_r, new Item.Properties()));

	public static Item GATE_SPRUCE = register("block_gate_spruce", new Wadeco_noFuel(Gate_Blocks.GATE_SPRUCE, new Item.Properties()));
	public static Item GATE_SPRUCE_B = register("block_gate_spruce_b", new Wadeco_noFuel(Gate_Blocks.GATE_SPRUCE_B, new Item.Properties()));
	public static Item GATE_IRON = register("block_gate_iron", new Wadeco_noFuel(Gate_Blocks.GATE_IRON, new Item.Properties()));
	public static Item GATE_IRONGRILL = register("block_gate_irongrill", new Wadeco_noFuel(Gate_Blocks.GATE_IRONGRILL, new Item.Properties()));
	public static Item TETSUSAKU_BOT = register("block_ironfence_bot", new Wadeco_noFuel(Garden_Blocks.TETSUSAKU_BOT, new Item.Properties()));
	
	public static Item HAKE = register("item_hake", new Item(new Item.Properties().tab(ItemGroups_CM.WADECO)));
	public static Item HAKE_white = register("item_hake_white", new ItemHake_White(new Item.Properties()));
	public static Item HAKE_orange = register("item_hake_orange", new ItemHake_Orange(new Item.Properties()));
	public static Item HAKE_magenta = register("item_hake_magenta", new ItemHake_Magenta(new Item.Properties()));
	public static Item HAKE_lightb = register("item_hake_lightblue", new ItemHake_LightBlue(new Item.Properties()));
	public static Item HAKE_yellow = register("item_hake_yellow", new ItemHake_Yellow(new Item.Properties()));
	public static Item HAKE_lime = register("item_hake_lime", new ItemHake_Lime(new Item.Properties()));
	public static Item HAKE_pink = register("item_hake_pink", new ItemHake_Pink(new Item.Properties()));
	public static Item HAKE_gray = register("item_hake_gray", new ItemHake_Gray(new Item.Properties()));
	public static Item HAKE_lightg = register("item_hake_lightgray", new ItemHake_LightGray(new Item.Properties()));
	public static Item HAKE_cyan = register("item_hake_cyan", new ItemHake_Cyan(new Item.Properties()));
	public static Item HAKE_purple = register("item_hake_purple", new ItemHake_Purple(new Item.Properties()));
	public static Item HAKE_blue = register("item_hake_blue", new ItemHake_Blue(new Item.Properties()));
	public static Item HAKE_brown = register("item_hake_brown", new ItemHake_Brown(new Item.Properties()));
	public static Item HAKE_green = register("item_hake_green", new ItemHake_Green(new Item.Properties()));
	public static Item HAKE_red = register("item_hake_red", new ItemHake_Red(new Item.Properties()));
	public static Item HAKE_black = register("item_hake_black", new ItemHake_Black(new Item.Properties()));

	public static Item KUMADE = register("item_kumade", new ItemKumade(new Item.Properties().durability(128)));
	public static Item NOMI = register("item_chisel", new ItemChisel(new Item.Properties()));
	
	public static Item MAKIBISHI = register("block_makibishi", new Wadeco_noFuel(Garden_Blocks.MAKIBISHI, new Item.Properties()));

	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
