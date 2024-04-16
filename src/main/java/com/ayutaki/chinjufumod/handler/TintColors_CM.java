package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TintColors_CM {

	/* TintIndex によるブロック色 0は使わずに1以降から */
	public static void registerBlockColors() {
		/** 20 Water=1, 35 CornSoup=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? BiomeColors.getWaterColor(worldIn, pos) : ((tint == 2)? 16441700 : -1); },
				Garden_Blocks.CHOUZUBACHI,
				Garden_Blocks.CHOUZUBACHI_gra,
				Garden_Blocks.CHOUZUBACHI_dio,
				Garden_Blocks.CHOUZUBACHI_and,
				Garden_Blocks.SHISHIODOSHI,
				Garden_Blocks.SHISHIODOSHI2,
				Kitchen_Blocks.KIT_SINK,
				Wood_Blocks.SUIDEN,

				Hakkou_Blocks.MIZUOKE,
				Hakkou_Blocks.MIZUOKE_full,
				Hakkou_Blocks.HAKUSAI_TARU1,
				Hakkou_Blocks.HAKUSAI_TARU2,
				
				Dish_Blocks.KEIRYO_CUP,
				Dish_Blocks.CURRY,
				Dish_Blocks.CURRY_C,
				Dish_Blocks.CURRY_T,
				Dish_Blocks.CURRYSET,
				Dish_Blocks.CURRYSET_C,
				Dish_Blocks.CURRYSET_T,
				Dish_Blocks.ZUNDOU_NCURRY,
				Dish_Blocks.ZUNDOU_NCURRY_C,
				Dish_Blocks.ZUNDOU_NCURRY_T,
				Dish_Blocks.KETTLE_full,
				Dish_Blocks.ZUNDOU_MIZU,
				Dish_Blocks.ZUNDOU_SHIO,
				Dish_Blocks.ZUNDOU_FISH,
				Dish_Blocks.ZUNDOU_UDON,
				Dish_Blocks.ZUNDOU_PASTA,
				Dish_Blocks.ZUNDOU_RAMEN, /* 6.4.1 */
				Dish_Blocks.ZUNDOU_RSOUP_nama, /* 6.4.1 */
				
				Dish_Blocks.NABETORI_nama,
				Dish_Blocks.NABEMISO_nama,
				Dish_Blocks.NABEGOHAN_nama,
				Dish_Blocks.NABEGOHANKURI_nama,
				Dish_Blocks.NABEGOHANTAKE_nama,
				Dish_Blocks.NABESHIO_nama,
				Dish_Blocks.NABENIMAME_nama,
				Dish_Blocks.KURI_NABE_nama,
			
				Dish_Blocks.NABECORN_nama,
				Dish_Blocks.NABECORN,
				Dish_Blocks.CORNSOUP,
				Dish_Blocks.EGGBURGSET );
		
		/** 21 Raw_Sake **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 12509680 : -1; },
				Hakkou_Blocks.NAMASAKEGLASS );
		
		/** 22 Sake **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 9223890 : -1; },
				Hakkou_Blocks.SAKEGLASS );
		
		/** 23 Aged_Sake **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 11164250 : -1; },
				Hakkou_Blocks.JUKUSAKEGLASS );
		
		/** 24 Cider **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 15127945 : -1; },
				Hakkou_Blocks.CIDERGLASS );
		
		/** 25 Aged_Cider **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 14588001 : -1; },
				Hakkou_Blocks.JUKUCIDERGLASS );
		
		/** 26 Wine **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 8398655 : -1; },
				Hakkou_Blocks.WINEGLASS );
		
		/** 27 Aged_Wine **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 5715258 : -1; },
				Hakkou_Blocks.JUKUWINEGLASS );
		
		/** 28 Mead **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 13821640 : -1; },
				Hakkou_Blocks.MEADGLASS );
		
		/** 29 Aged_Mead **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 13808770 : -1; },
				Hakkou_Blocks.JUKUMEADGLASS );
		
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); },
				Dish_Blocks.KYUSU, 
				Dish_Blocks.JPTEACUP,
				Dish_Blocks.JPTEASET,
				Dish_Blocks.SUSHISET_salmon,
				Dish_Blocks.SUSHISET_fish,
				Dish_Blocks.SUSHISET_beef,
				Dish_Blocks.SUSHISET_tamago,
				Dish_Blocks.SUSHISET_4shoku,
				
				Dish_Blocks.NABETORI,
				Dish_Blocks.NABEMISO,
				Dish_Blocks.TONSUITORI,
				Dish_Blocks.MISOSOUP,
				
				Dish_Blocks.TAMAGOYAKITEI,
				Dish_Blocks.YAKIZAKANATEI,
				Dish_Blocks.YAKIJYAKETEI,
				Dish_Blocks.TAMAGOYAKITEI_TAKE,
				Dish_Blocks.YAKIZAKANATEI_TAKE,
				Dish_Blocks.YAKIJYAKETEI_TAKE,
				Dish_Blocks.TAMAGOYAKITEI_KURI,
				Dish_Blocks.YAKIZAKANATEI_KURI,
				Dish_Blocks.YAKIJYAKETEI_KURI );
		
		/** 31 Black_Tea **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 14493736 : -1; },
				Dish_Blocks.TEAPOT, 
				Dish_Blocks.TEACUP,
				Dish_Blocks.TEASET );

		/** 33 Aku **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 3297410 : -1; },
				Dish_Blocks.ZUNDOU_AKU,
				Dish_Blocks.ZUNDOU_ORIITO );

		/** 20 Water=1, 34 AMAZAKE=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? BiomeColors.getWaterColor(worldIn, pos) : ((tint == 2)? 16443100 : -1); },
				Hakkou_Blocks.NABEAMAZAKE_nama,
				Hakkou_Blocks.NABEAMAZAKE,
				Hakkou_Blocks.AMAZAKEGLASS );
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); },
				Crop_Blocks.ENDEN );
		
		/** 42 KAINASHI=1 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 15790315 : -1; },
				Crop_Blocks.KAINASHI );
		
		/* BiomeColors.class 設置場所の色を拾う BiomeColors.getFoliageColor(worldIn, pos) */
		/* Biome.class 気温と降雨量から色指定 FoliageColors.get(Temperature, Downfall) 1.0F以上はクラッシュする */
		/** 1 Oak **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColors.get(0.7F, 0.6F) : -1; },
				Garden_Blocks.BONSAI_oak,
				Garden_Blocks.KANYOU,
				Garden_Blocks.IKEGAKILONG,
				Garden_Blocks.IKEGAKI );
		
		/** 2 Spruce **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColors.getSpruce() : -1; },
				Garden_Blocks.BONSAI_spru,
				Garden_Blocks.KANYOU_spruce,
				Garden_Blocks.IKEGAKILONG_spruce,
				Garden_Blocks.IKEGAKI_spruce );
		
		/** 3 Birch **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColors.getBirch() : -1; },
				Garden_Blocks.BONSAI_bir,
				Garden_Blocks.KANYOU_birch,
				Garden_Blocks.IKEGAKILONG_birch,
				Garden_Blocks.IKEGAKI_birch );
		
		/** 4 Jungle **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColors.get(0.9F, 0.9F) : -1; }, //緑
				Garden_Blocks.BONSAI_jun,
				Garden_Blocks.KANYOU_jungle,
				Garden_Blocks.IKEGAKILONG_jungle,
				Garden_Blocks.IKEGAKI_jungle );
		
		/** 5 Acacia **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColors.get(0.9F, 0.0F) : -1; },
				Garden_Blocks.BONSAI_aca,
				Garden_Blocks.KANYOU_acacia,
				Garden_Blocks.IKEGAKILONG_acacia,
				Garden_Blocks.IKEGAKI_acacia );
		
		/** 6 DarkOak **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColors.get(0.7F, 0.8F) : -1; }, //黒
				Garden_Blocks.BONSAI_doak,
				Garden_Blocks.KANYOU_darkoak,
				Garden_Blocks.IKEGAKILONG_darkoak,
				Garden_Blocks.IKEGAKI_darkoak );
		
		/** 7 Acer **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 14828063 : -1; },
				Garden_Blocks.BONSAI_kaede,
				Garden_Blocks.KANYOU_kaede,
				Garden_Blocks.IKEGAKILONG_kaede,
				Garden_Blocks.IKEGAKI_kaede,
				Wood_Blocks.KAEDE_leaf,
				Wood_Blocks.KAEDE_carpet );
		
		/** 8 Autumn_Oak **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 11495695 : -1; },
				Garden_Blocks.BONSAI_kare,
				Garden_Blocks.KANYOU_kare,
				Garden_Blocks.IKEGAKILONG_kare,
				Garden_Blocks.IKEGAKI_kare,
				Wood_Blocks.OAKKARE_leaf,
				Wood_Blocks.OCHIBA_carpet );
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); },
				Kitchen_Blocks.KIT_REIZOU,
				Kitchen_Blocks.KIT_REIZOU_TOP );
	}

	
	/* TintIndex によるアイテム色 */
	public static void registerItemColors() {
		
		/** 20 Water waterColor(4159204) from Biome=1, 35 CornSoup=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 4159204 : ((tint == 2)? 16441700 : -1); },
				Items_Seasonal.SUIDEN,
				Items_Seasonal.KURI_NABE,
				
				Items_Teatime.MIZUOKE_full,
				Items_Teatime.HAKUSAI_TARU1,
				Items_Teatime.HAKUSAI_TARU2,

				Items_Teatime.KEIRYO_CUP_full,
				Items_Teatime.CURRY,
				Items_Teatime.CURRY_C,
				Items_Teatime.CURRY_T,
				Items_Teatime.CURRYSET,
				Items_Teatime.CURRYSET_C,
				Items_Teatime.CURRYSET_T,
				Items_Teatime.KETTLE_full,
				Items_Teatime.KETTLE_boil,
				Items_Teatime.ZUNDOU_MIZU,
				Items_Teatime.ZUNDOU_SHIO,
				Items_Teatime.ZUNDOU_NCURRY,
				Items_Teatime.ZUNDOU_NCURRY_C,
				Items_Teatime.ZUNDOU_NCURRY_T,
				Items_Teatime.ZUNDOU_RSOUP_nama, /* 6.4.1 */
				
				Items_Teatime.NABETORI_nama,
				Items_Teatime.NABEMISO_nama,
				Items_Teatime.NABEGOHAN_nama,
				Items_Teatime.NABEGOHANKURI_nama,
				Items_Teatime.NABEGOHANTAKE_nama,
				Items_Teatime.NABESHIO_nama,
				Items_Teatime.NABENIMAME_nama,
				
				Items_Teatime.NABECORN_nama,
				Items_Teatime.NABECORN,
				Items_Teatime.CORNSOUP,
				Items_Teatime.EGGBURGSET );
		
		/** 42 KANSUI 63,98,168 _6.4.1 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 4154024 : -1; },
				Items_Teatime.KANSUI );
		
		/** 21 Raw_Sake **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 12509680 : -1; },
				Items_Teatime.NAMASAKEGLASS );
		
		/** 22 Sake **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 9223890 : -1; },
				Items_Teatime.SAKEGLASS );
		
		/** 23 Aged_Sake **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 11164250 : -1; },
				Items_Teatime.JUKUSAKEGLASS );
		
		/** 24 Cider **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 15127945 : -1; },
				Items_Teatime.CIDERGLASS );
		
		/** 25 Aged_Cider **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 14588001 : -1; },
				Items_Teatime.JUKUCIDERGLASS );
		
		/** 26 Wine **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 8398655 : -1; },
				Items_Teatime.WINEGLASS );
		
		/** 27 Aged_Wine **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 5715258 : -1; },
				Items_Teatime.JUKUWINEGLASS );
		
		/** 28 Mead **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 13821640 : -1; },
				Items_Teatime.MEADGLASS );
		
		/** 29 Aged_Mead **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 13808770 : -1; },
				Items_Teatime.JUKUMEADGLASS );
		
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { 
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); },
				Items_Teatime.KYUSU,
				Items_Teatime.JPTEACUP,
				Items_Teatime.JPTEASET,
				Items_Teatime.SUSHISET_salmon,
				Items_Teatime.SUSHISET_fish,
				Items_Teatime.SUSHISET_beef,
				Items_Teatime.SUSHISET_tamago,
				Items_Teatime.SUSHISET_4shoku,
				
				Items_Teatime.NABETORI,
				Items_Teatime.NABEMISO,
				Items_Teatime.TONSUITORI,
				Items_Teatime.MISOSOUP,
				
				Items_Teatime.TAMAGOYAKITEI,
				Items_Teatime.YAKIZAKANATEI,
				Items_Teatime.YAKIJYAKETEI,
				Items_Teatime.TAMAGOYAKITEI_TAKE,
				Items_Teatime.YAKIZAKANATEI_TAKE,
				Items_Teatime.YAKIJYAKETEI_TAKE,
				Items_Teatime.TAMAGOYAKITEI_KURI,
				Items_Teatime.YAKIZAKANATEI_KURI,
				Items_Teatime.YAKIJYAKETEI_KURI );
		
		/** 31 Black_Tea **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 14493736 : -1; },
				Items_Teatime.TEAPOT,
				Items_Teatime.TEACUP,
				Items_Teatime.TEASET );

		/** 33 Aku **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 3297410 : -1; },
				Items_Seasonal.ZUNDOU_AKU );

		/** 20 Water=1, 34 AMAZAKE=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { 
			return (tint == 1)? 4159204 : ((tint == 2)? 16443100 : -1); },
				Items_Teatime.NABEAMAZAKE_nama,
				Items_Teatime.NABEAMAZAKE,
				Items_Teatime.AMAZAKEGLASS );
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { 
			return (tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); },
				Items_Teatime.ENDEN );
		
		
		/** 1 Oak **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColors.get(0.7F, 0.6F) : -1; },
				Items_Wadeco.BONSAI_oak,
				Items_Wadeco.KANYOU,
				Items_Wadeco.IKEGAKILONG,
				Items_Wadeco.IKEGAKI );
		
		/** 2 Spruce **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColors.getSpruce() : -1; },
				Items_Wadeco.BONSAI_spru,
				Items_Wadeco.KANYOU_spruce,
				Items_Wadeco.IKEGAKILONG_spruce,
				Items_Wadeco.IKEGAKI_spruce );

		/** 3 Birch **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColors.getBirch() : -1; },
				Items_Wadeco.BONSAI_bir,
				Items_Wadeco.KANYOU_birch,
				Items_Wadeco.IKEGAKILONG_birch,
				Items_Wadeco.IKEGAKI_birch );
		
		/** 4 Jungle **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColors.get(0.9F, 0.9F) : -1; }, //緑
				Items_Wadeco.BONSAI_jun,
				Items_Wadeco.KANYOU_jungle,
				Items_Wadeco.IKEGAKILONG_jungle,
				Items_Wadeco.IKEGAKI_jungle );
		
		/** 5 Acacia **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColors.get(0.9F, 0.0F) : -1; },
				Items_Wadeco.BONSAI_aca,
				Items_Wadeco.KANYOU_acacia,
				Items_Wadeco.IKEGAKILONG_acacia,
				Items_Wadeco.IKEGAKI_acacia );
		
		/** 6 DarkOak **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColors.get(0.7F, 0.8F) : -1; }, //黒
				Items_Wadeco.BONSAI_doak,
				Items_Wadeco.KANYOU_darkoak,
				Items_Wadeco.IKEGAKILONG_darkoak,
				Items_Wadeco.IKEGAKI_darkoak );
		
		/** 7 Acer **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 14828063 : -1; },
				Items_Seasonal.BONSAI_kaede,
				Items_Seasonal.KANYOU_kaede,
				Items_Seasonal.IKEGAKILONG_kaede,
				Items_Seasonal.IKEGAKI_kaede,
				Items_Seasonal.KAEDE_leaf,
				Items_Seasonal.KAEDE_carpet );
		
		/** 8 Autumn_Oak **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 11495695 : -1; },
				Items_Seasonal.BONSAI_kare,
				Items_Seasonal.KANYOU_kare,
				Items_Seasonal.IKEGAKILONG_kare,
				Items_Seasonal.IKEGAKI_kare,
				Items_Seasonal.OAKKARE_leaf,
				Items_Seasonal.OCHIBA_carpet );
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); },
				Items_Teatime.KIT_REIZOU );
	}
}
