package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Gate_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.JPdeco_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTypes_CM {

	public static void register() {

		RenderType cutout = RenderType.getCutout();
		RenderType trans = RenderType.getTranslucent();
		RenderType light = RenderType.getCutoutMipped();

		RenderTypeLookup.setRenderLayer(ChinjufuMod_Blocks.WAKE_WATER1, cutout);
		RenderTypeLookup.setRenderLayer(ChinjufuMod_Blocks.WAKE_WATER2, cutout);
		RenderTypeLookup.setRenderLayer(ChinjufuMod_Blocks.WAKE_WATER3, cutout);

		RenderTypeLookup.setRenderLayer(Crop_Blocks.CABBAGE, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.HAKUSAI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.CORN, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.GREENONION, cutout); /** 6.4.1 **/
		RenderTypeLookup.setRenderLayer(Crop_Blocks.ONION, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.RICE, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.RICE_8, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.SOY, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.SPINACH, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.TOMATO, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.SAKURA, cutout);

		RenderTypeLookup.setRenderLayer(Crop_Blocks.CHANOKI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.BUDOUNOKI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.MIKAN, cutout);

		RenderTypeLookup.setRenderLayer(Crop_Blocks.HODAGI_A_BOT, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.HODAGI_A_TOP, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.HODAGI_B_BOT, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.HODAGI_B_TOP, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.HODAGI_C_BOT, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.HODAGI_C_TOP, cutout);
		
		RenderTypeLookup.setRenderLayer(Crop_Blocks.PEPPER, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.CUMIN, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.TURMERIC, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.CHILI, cutout);
		
		RenderTypeLookup.setRenderLayer(Crop_Blocks.NORIAMI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.INAGI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.ENDEN_k, light);
		
		RenderTypeLookup.setRenderLayer(Crop_Blocks.TOAMI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.SHIKAKE_AMI, cutout);
		RenderTypeLookup.setRenderLayer(Crop_Blocks.YOUSHOKU_AMI, cutout);
		
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_MIZU, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_SHIO, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_NSTEW, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_FISH, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_DASHI, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_UDON, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_PASTA, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_DASHI, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_RSOUP_nama, trans); /** 6.4.1 **/
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_RSOUP, trans); /** 6.4.1 **/
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_RAMEN, trans); /** 6.4.1 **/
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_AKU, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_ORIITO, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.NABETORI_nama, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.NABEGOHAN_nama, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.NABEGOHANKURI_nama, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.NABESHIO_nama, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.NABENIMAME_nama, trans);
		
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_NCURRY, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_NCURRY_C, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.ZUNDOU_NCURRY_T, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.CURRY, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.CURRY_C, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.CURRY_T, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.CURRYSET, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.CURRYSET_C, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.CURRYSET_T, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.UDON_SU, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.UDON_NIKU, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.UDON_TSUKIMI, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.KETTLE_full, trans);

		RenderTypeLookup.setRenderLayer(Dish_Blocks.OSAUCE_bot_1, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.OSAUCE_bot_2, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.OSAUCE_bot_3, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.OSAUCE_bot_4, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.MAYO_bot_1, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.MAYO_bot_2, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.MAYO_bot_3, trans);
		RenderTypeLookup.setRenderLayer(Dish_Blocks.MAYO_bot_4, trans);
		
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_white, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_orange, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_magenta, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_lightb, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_yellow, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_lime, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_pink, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_gray, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_lightg, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_cyan, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_purple, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_blue, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_brown, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_green, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_red, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.CANDLE_black, cutout);
		RenderTypeLookup.setRenderLayer(Furniture_Blocks.M_LAMP, trans);

		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_oak, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_spru, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_bir, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_jun, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_aca, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_doak, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.BONSAI_kare, cutout);

		RenderTypeLookup.setRenderLayer(Garden_Blocks.CHOUZUBACHI, trans);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.CHOUZUBACHI_gra, trans);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.CHOUZUBACHI_dio, trans);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.CHOUZUBACHI_and, trans);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.SHISHIODOSHI, trans);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.SHISHIODOSHI2, trans);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.ISHITOUROU, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.ISHITOUROU_gra, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.ISHITOUROU_dio, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.ISHITOUROU_and, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.LONGTOUROU, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.LONGTOUROU_gra, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.LONGTOUROU_dio, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.LONGTOUROU_and, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.TAKEAKARI, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.TAKEAKARI_Y, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.TAKEAKARI_K, cutout);

		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_birch, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.KANYOU_kare, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_birch, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKILONG_kare, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_birch, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.IKEGAKI_kare, cutout);
		RenderTypeLookup.setRenderLayer(Garden_Blocks.MAKIBISHI, cutout);
		
		RenderTypeLookup.setRenderLayer(Gate_Blocks.DOOR_SAKURA, cutout);

		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KOUBOBOT_full, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.NYUSANBOT_full, trans);

		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.MIZUOKE, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.MIZUOKE_full, trans);

		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.HAKUSAI_TARU1, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.HAKUSAI_TARU2, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KINOKO_TARU, cutout);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KONBU_TARU, cutout);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.PEPPER_TARU, cutout);
		
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.NAMASAKEBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.SAKEBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.JUKUSAKEBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.NABEAMAZAKE_nama, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.CIDERBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.JUKUCIDERBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.WINEBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.JUKUWINEBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.MEADBOT, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.JUKUMEADBOT, trans);

		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_1, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_2, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_3, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_4, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KOMEZU_bot_1, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KOMEZU_bot_2, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.DASHI_bot_1, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.DASHI_bot_2, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.DASHI_bot_3, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.DASHI_bot_4, trans);

		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_white, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_orange, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_magenta, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_lightb, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_yellow, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_lime, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_pink, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_gray, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_cyan, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_purple, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_blue, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_brown, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_green, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_red, cutout);
		RenderTypeLookup.setRenderLayer(Harbor_Blocks.TRUSS_black, cutout);

		//RenderTypeLookup.setRenderLayer(Kitchen_Blocks.KIT_SINK, trans); 台が消えるため使用しない
		RenderTypeLookup.setRenderLayer(Kitchen_Blocks.KIT_COOKTOP, cutout);
		RenderTypeLookup.setRenderLayer(Kitchen_Blocks.KIT_OVEN, trans);
		RenderTypeLookup.setRenderLayer(Kitchen_Blocks.KIT_OVEN_B, trans);
		RenderTypeLookup.setRenderLayer(Kitchen_Blocks.IRORI, cutout);

		RenderTypeLookup.setRenderLayer(Kitchen_Blocks.KIT_KANKI_1, cutout);

		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_SAKENAMA, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_SAKE, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_SAKEJUKU, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_CIDER, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_CIDERJUKU, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_WINE, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_WINEJUKU, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_MEAD, trans);
		RenderTypeLookup.setRenderLayer(Hakkou_Blocks.KIT_MEADJUKU, trans);

		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_oak, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_birch, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Ranma_Blocks.RANMAC_ichoh, cutout);

		RenderTypeLookup.setRenderLayer(School_Blocks.CSTOVE_top, cutout);

		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.KADOMATSU, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.SHIMENAWA, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.KAGAMIMOCHI, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.HINAKAZARI, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.XMASTREE, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.XMASTREE_W, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_app, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_bok, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_dia, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_lap, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_bla, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_chc, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.PRESENT_chh, cutout);
		RenderTypeLookup.setRenderLayer(Seasonal_Blocks.SNOWMAN, cutout);
		
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_SPRU, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_BIR, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_JUN, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_ACA, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_DOAK, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_SAKU, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_KAE, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDO_ICH, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_SPRU, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_BIR, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_JUN, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_ACA, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_DOAK, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_SAKU, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_KAE, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOB_ICH, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_SPRU, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_BIR, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_JUN, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_ACA, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_DOAK, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_SAKU, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_KAE, cutout);
		RenderTypeLookup.setRenderLayer(Slidedoor_Blocks.GARASUDOH_ICH, cutout);

		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_white, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_orange, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_magenta, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_lightb, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_yellow, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_lime, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_pink, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_gray, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_lightg, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_cyan, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_purple, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_blue, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_brown, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_green, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_red, cutout);
		RenderTypeLookup.setRenderLayer(JPdeco_Blocks.ANDON_black, cutout);

		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_white, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_orange, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_magenta, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_lightb, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_yellow, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_lime, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_pink, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_gray, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_lightg, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_cyan, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_purple, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_blue, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_brown, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_green, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_red, cutout);
		RenderTypeLookup.setRenderLayer(Unit_Blocks.KASA_black, cutout);

		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS, cutout);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_white, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_orange, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_magenta, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_lightb, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_yellow, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_lime, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_pink, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_gray, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_lightg, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_cyan, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_purple, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_blue, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_brown, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_green, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_red, trans);
		RenderTypeLookup.setRenderLayer(WallPanel_Blocks.WP_GLASS_black, trans);

		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_oak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_birch, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOW_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_oak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_birch, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWB_ichoh, cutout);

		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_oak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_birch, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLBOT_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_oak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_birch, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALLTOP_ichoh, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_oak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_spruce, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_birch, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_jungle, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_acacia, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_darkoak, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_sakura, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_kaede, cutout);
		RenderTypeLookup.setRenderLayer(Window_Blocks.WINDOWTALL_ichoh, cutout);

		//RenderTypeLookup.setRenderLayer(Wood_Blocks.SUIDEN, trans); 1.15では WATERLOGGED を使う
		RenderTypeLookup.setRenderLayer(Wood_Blocks.FALL_LEAF, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.SAKURA_flow, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.KAEDE_leaf, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.ICHOH_leaf, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.OAKKARE_leaf, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.SAKURA_nae, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.KAEDE_nae, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.ICHOH_nae, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.OAKKARE_nae, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.SAKURA_carpet, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.KAEDE_carpet, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.ICHOH_carpet, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.OCHIBA_carpet, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.SAKURA_TRAPDOOR, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.KURIIGA_FALL, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.KURIIGA_BUSH, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.TAKE, cutout);
		RenderTypeLookup.setRenderLayer(Wood_Blocks.TAKENOKO, cutout);
	}

}
