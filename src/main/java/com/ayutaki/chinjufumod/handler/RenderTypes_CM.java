package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTypes_CM {

	public static void register() {

		RenderType cutout = RenderType.cutout();
		RenderType trans = RenderType.translucent();
		RenderType light = RenderType.cutoutMipped();

		ItemBlockRenderTypes.setRenderLayer(ChinjufuMod_Blocks.WAKE_WATER1.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(ChinjufuMod_Blocks.WAKE_WATER2.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(ChinjufuMod_Blocks.WAKE_WATER3.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.CABBAGE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HAKUSAI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.CORN.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.GREENONION.get(), cutout); /** 6.4.1 **/
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.ONION.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.RICE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.RICE_8.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.SOY.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.SPINACH.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.TOMATO.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.SAKURA.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.CHANOKI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.BUDOUNOKI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.MIKAN.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HODAGI_A_BOT.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HODAGI_A_TOP.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HODAGI_B_BOT.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HODAGI_B_TOP.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HODAGI_C_BOT.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.HODAGI_C_TOP.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.PEPPER.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.CUMIN.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.TURMERIC.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.CHILI.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.NORIAMI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.INAGI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.ENDEN_k.get(), light);
		
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.TOAMI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.SHIKAKE_AMI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Crop_Blocks.YOUSHOKU_AMI.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_MIZU.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_SHIO.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_NSTEW.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_FISH.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_DASHI.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_UDON.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_PASTA.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_DASHI.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_RSOUP_nama.get(), trans); /** 6.4.1 **/
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_RSOUP.get(), trans); /** 6.4.1 **/
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_RAMEN.get(), trans); /** 6.4.1 **/
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_AKU.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_ORIITO.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.NABETORI_nama.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.NABEGOHAN_nama.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.NABEGOHANKURI_nama.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.NABESHIO_nama.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.NABENIMAME_nama.get(), trans);
		
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_NCURRY.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_NCURRY_C.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.ZUNDOU_NCURRY_T.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.CURRY.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.CURRY_C.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.CURRY_T.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.CURRYSET.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.CURRYSET_C.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.CURRYSET_T.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.KETTLE_full.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.OSAUCE_bot_1.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.OSAUCE_bot_2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.OSAUCE_bot_3.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.OSAUCE_bot_4.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.MAYO_bot_1.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.MAYO_bot_2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.MAYO_bot_3.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Dish_Blocks.MAYO_bot_4.get(), trans);
		
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_white.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_orange.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_magenta.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_lightb.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_yellow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_lime.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_pink.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_gray.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_lightg.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_cyan.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_purple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_blue.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_brown.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_green.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_red.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.CANDLE_black.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Furniture_Blocks.M_LAMP.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_spru.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_bir.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_jun.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_aca.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_doak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.BONSAI_kare.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.CHOUZUBACHI.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.CHOUZUBACHI_gra.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.CHOUZUBACHI_dio.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.CHOUZUBACHI_and.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.SHISHIODOSHI.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.SHISHIODOSHI2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.ISHITOUROU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.ISHITOUROU_gra.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.ISHITOUROU_dio.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.ISHITOUROU_and.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.LONGTOUROU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.LONGTOUROU_gra.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.LONGTOUROU_dio.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.LONGTOUROU_and.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.TAKEAKARI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.TAKEAKARI_Y.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.TAKEAKARI_K.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.KANYOU_kare.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKILONG_kare.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.IKEGAKI_kare.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Garden_Blocks.MAKIBISHI.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.DOOR_SAKURA.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KOUBOBOT_full.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.NYUSANBOT_full.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.MIZUOKE.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.MIZUOKE_full.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.HAKUSAI_TARU1.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.HAKUSAI_TARU2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KINOKO_TARU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KONBU_TARU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.PEPPER_TARU.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.NAMASAKEBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.SAKEBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.JUKUSAKEBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.NABEAMAZAKE_nama.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.CIDERBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.JUKUCIDERBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.WINEBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.JUKUWINEBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.MEADBOT.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.JUKUMEADBOT.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_1.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_3.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.SHOUYU_bot_4.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KOMEZU_bot_1.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KOMEZU_bot_2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.DASHI_bot_1.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.DASHI_bot_2.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.DASHI_bot_3.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.DASHI_bot_4.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_white.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_orange.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_magenta.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_lightb.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_yellow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_lime.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_pink.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_gray.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_cyan.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_purple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_blue.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_brown.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_green.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_red.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Harbor_Blocks.TRUSS_black.get(), cutout);

		//ItemBlockRenderTypes.setRenderLayer(Kitchen_Blocks.KIT_SINK.get(), trans); Stop using.
		ItemBlockRenderTypes.setRenderLayer(Kitchen_Blocks.KIT_COOKTOP.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Kitchen_Blocks.KIT_OVEN.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Kitchen_Blocks.KIT_OVEN_B.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Kitchen_Blocks.IRORI.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Kitchen_Blocks.KIT_KANKI_1.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_SAKENAMA.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_SAKE.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_SAKEJUKU.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_CIDER.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_CIDERJUKU.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_WINE.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_WINEJUKU.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_MEAD.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(Hakkou_Blocks.KIT_MEADJUKU.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Ranma_Blocks.RANMAC_ichoh.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(School_Blocks.CSTOVE_top.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.KADOMATSU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.SHIMENAWA.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.KAGAMIMOCHI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.HINAKAZARI.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.XMASTREE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.XMASTREE_W.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_app.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_bok.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_dia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_lap.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_bla.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_chc.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.PRESENT_chh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Seasonal_Blocks.SNOWMAN.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_SPRU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_BIR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_JUN.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_ACA.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_DOAK.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_SAKU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_KAE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDO_ICH.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_SPRU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_BIR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_JUN.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_ACA.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_DOAK.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_SAKU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_KAE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOB_ICH.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_SPRU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_BIR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_JUN.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_ACA.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_DOAK.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_SAKU.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_KAE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Slidedoor_Blocks.GARASUDOH_ICH.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_white.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_orange.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_magenta.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_lightb.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_yellow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_lime.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_pink.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_gray.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_lightg.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_cyan.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_purple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_blue.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_brown.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_green.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_red.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(JPDeco_Blocks.ANDON_black.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_white.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_orange.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_magenta.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_lightb.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_yellow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_lime.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_pink.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_gray.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_lightg.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_cyan.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_purple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_blue.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_brown.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_green.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_red.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Unit_Blocks.KASA_black.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_white.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_orange.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_magenta.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_lightb.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_yellow.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_lime.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_pink.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_gray.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_lightg.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_cyan.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_purple.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_blue.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_brown.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_green.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_red.get(), trans);
		ItemBlockRenderTypes.setRenderLayer(WallPanel_Blocks.WP_GLASS_black.get(), trans);

		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOW_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWB_ichoh.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLBOT_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALLTOP_ichoh.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_oak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_spruce.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_birch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_jungle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_acacia.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_darkoak.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_sakura.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_kaede.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Window_Blocks.WINDOWTALL_ichoh.get(), cutout);

		//ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.SUIDEN.get(), trans); Use 'WATERLOGGED' in 1.15.
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.FALL_LEAF.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.SAKURA_flow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.KAEDE_leaf.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.ICHOH_leaf.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.OAKKARE_leaf.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.SAKURA_nae.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.KAEDE_nae.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.ICHOH_nae.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.OAKKARE_nae.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.SAKURA_carpet.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.KAEDE_carpet.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.ICHOH_carpet.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.OCHIBA_carpet.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.SAKURA_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.KURIIGA_FALL.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.KURIIGA_BUSH.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.TAKE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(Wood_Blocks.TAKENOKO.get(), cutout);
	}
}
