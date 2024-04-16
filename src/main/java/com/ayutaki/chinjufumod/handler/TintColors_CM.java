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
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TintColors_CM {

	/* TintIndex of Block. Small values version. */
	public static void registerBlockColors() {
		/** 20 Water=1, 35 CornSoup=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? BiomeColors.getAverageWaterColor(worldIn, pos) : ((tint == 2)? 16441700 : -1); },
				Garden_Blocks.CHOUZUBACHI.get(),
				Garden_Blocks.CHOUZUBACHI_gra.get(),
				Garden_Blocks.CHOUZUBACHI_dio.get(),
				Garden_Blocks.CHOUZUBACHI_and.get(),
				Garden_Blocks.SHISHIODOSHI.get(),
				Garden_Blocks.SHISHIODOSHI2.get(),
				Kitchen_Blocks.KIT_SINK.get(),
				Wood_Blocks.SUIDEN.get(),

				Hakkou_Blocks.MIZUOKE.get(),
				Hakkou_Blocks.MIZUOKE_full.get(),
				Hakkou_Blocks.HAKUSAI_TARU1.get(),
				Hakkou_Blocks.HAKUSAI_TARU2.get(),
				
				Dish_Blocks.KEIRYO_CUP.get(),
				Dish_Blocks.CURRY.get(),
				Dish_Blocks.CURRY_C.get(),
				Dish_Blocks.CURRY_T.get(),
				Dish_Blocks.CURRYSET.get(),
				Dish_Blocks.CURRYSET_C.get(),
				Dish_Blocks.CURRYSET_T.get(),
				Dish_Blocks.ZUNDOU_NCURRY.get(),
				Dish_Blocks.ZUNDOU_NCURRY_C.get(),
				Dish_Blocks.ZUNDOU_NCURRY_T.get(),
				Dish_Blocks.ZUNDOU_RAMEN.get(), /* 6.4.1 */
				Dish_Blocks.ZUNDOU_RSOUP_nama.get(), /* 6.4.1 */
				
				Dish_Blocks.KETTLE_full.get(),
				Dish_Blocks.ZUNDOU_MIZU.get(),
				Dish_Blocks.ZUNDOU_SHIO.get(),
				Dish_Blocks.ZUNDOU_FISH.get(),
				Dish_Blocks.ZUNDOU_UDON.get(),
				Dish_Blocks.ZUNDOU_PASTA.get(),
				
				Dish_Blocks.NABETORI_nama.get(),
				Dish_Blocks.NABEMISO_nama.get(),
				Dish_Blocks.NABEGOHAN_nama.get(),
				Dish_Blocks.NABEGOHANKURI_nama.get(),
				Dish_Blocks.NABEGOHANTAKE_nama.get(),
				Dish_Blocks.NABESHIO_nama.get(),
				Dish_Blocks.NABENIMAME_nama.get(),
				Dish_Blocks.KURI_NABE_nama.get(),
				
				Dish_Blocks.NABECORN_nama.get(),
				Dish_Blocks.NABECORN.get(),
				Dish_Blocks.CORNSOUP.get(),
				Dish_Blocks.EGGBURGSET.get() );

		/** 21 Raw_Sake **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 12509680 : -1; },
				Hakkou_Blocks.NAMASAKEGLASS.get() );
		
		/** 22 Sake **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 9223890 : -1; },
				Hakkou_Blocks.SAKEGLASS.get() );
		
		/** 23 Aged_Sake **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 11164250 : -1; },
				Hakkou_Blocks.JUKUSAKEGLASS.get() );
		
		/** 24 Cider **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 15127945 : -1; },
				Hakkou_Blocks.CIDERGLASS.get() );
		
		/** 25 Aged_Cider **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 14588001 : -1; },
				Hakkou_Blocks.JUKUCIDERGLASS.get() );
		
		/** 26 Wine **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 8398655 : -1; },
				Hakkou_Blocks.WINEGLASS.get() );
		
		/** 27 Aged_Wine **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 5715258 : -1; },
				Hakkou_Blocks.JUKUWINEGLASS.get() );
		
		/** 28 Mead **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 13821640 : -1; },
				Hakkou_Blocks.MEADGLASS.get() );
		
		/** 29 Aged_Mead **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 13808770 : -1; },
				Hakkou_Blocks.JUKUMEADGLASS.get() );
		
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); },
				Dish_Blocks.KYUSU.get(), 
				Dish_Blocks.JPTEACUP.get(),
				Dish_Blocks.JPTEASET.get(),
				Dish_Blocks.SUSHISET_salmon.get(),
				Dish_Blocks.SUSHISET_fish.get(),
				Dish_Blocks.SUSHISET_beef.get(),
				Dish_Blocks.SUSHISET_tamago.get(),
				Dish_Blocks.SUSHISET_4shoku.get(),
				
				Dish_Blocks.NABETORI.get(),
				Dish_Blocks.NABEMISO.get(),
				Dish_Blocks.TONSUITORI.get(),
				Dish_Blocks.MISOSOUP.get(),
				
				Dish_Blocks.TAMAGOYAKITEI.get(),
				Dish_Blocks.YAKIZAKANATEI.get(),
				Dish_Blocks.YAKIJYAKETEI.get(),
				Dish_Blocks.TAMAGOYAKITEI_TAKE.get(),
				Dish_Blocks.YAKIZAKANATEI_TAKE.get(),
				Dish_Blocks.YAKIJYAKETEI_TAKE.get(),
				Dish_Blocks.TAMAGOYAKITEI_KURI.get(),
				Dish_Blocks.YAKIZAKANATEI_KURI.get(),
				Dish_Blocks.YAKIJYAKETEI_KURI.get() );
		
		/** 31 Black_Tea **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 14493736 : -1; },
				Dish_Blocks.TEAPOT.get(), 
				Dish_Blocks.TEACUP.get(),
				Dish_Blocks.TEASET.get() );

		/** 33 Aku **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { return (tint == 1)? 3297410 : -1; },
				Dish_Blocks.ZUNDOU_AKU.get(),
				Dish_Blocks.ZUNDOU_ORIITO.get() );

		/** 20 Water=1, 34 AMAZAKE=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? BiomeColors.getAverageWaterColor(worldIn, pos) : ((tint == 2)? 16443100 : -1); },
				Hakkou_Blocks.NABEAMAZAKE_nama.get(),
				Hakkou_Blocks.NABEAMAZAKE.get(),
				Hakkou_Blocks.AMAZAKEGLASS.get() );
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); },
				Crop_Blocks.ENDEN.get() );
		
		/** 42 KAINASHI=1 **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 15790315 : -1; },
				Crop_Blocks.KAINASHI.get() );
		
		/* BiomeColors.class 設置場所の色を拾う BiomeColors.getFoliageColor(worldIn, pos) */
		/* Biome.class 気温と降雨量から色指定 FoliageColor.get(Temperature, Downfall) 1.0F以上はクラッシュする */
		/** 1 Oak **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.6F) : -1; },
				Garden_Blocks.BONSAI_oak.get(),
				Garden_Blocks.KANYOU.get(),
				Garden_Blocks.IKEGAKILONG.get(),
				Garden_Blocks.IKEGAKI.get() );
		
		/** 2 Spruce **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.getEvergreenColor() : -1; },
				Garden_Blocks.BONSAI_spru.get(),
				Garden_Blocks.KANYOU_spruce.get(),
				Garden_Blocks.IKEGAKILONG_spruce.get(),
				Garden_Blocks.IKEGAKI_spruce.get() );

		/** 3 Birch **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.getBirchColor() : -1; },
				Garden_Blocks.BONSAI_bir.get(),
				Garden_Blocks.KANYOU_birch.get(),
				Garden_Blocks.IKEGAKILONG_birch.get(),
				Garden_Blocks.IKEGAKI_birch.get() );
		
		/** 4 Jungle **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.9F) : -1; }, //緑
				Garden_Blocks.BONSAI_jun.get(),
				Garden_Blocks.KANYOU_jungle.get(),
				Garden_Blocks.IKEGAKILONG_jungle.get(),
				Garden_Blocks.IKEGAKI_jungle.get() );
		
		/** 5 Acacia **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.0F) : -1; },
				Garden_Blocks.BONSAI_aca.get(),
				Garden_Blocks.KANYOU_acacia.get(),
				Garden_Blocks.IKEGAKILONG_acacia.get(),
				Garden_Blocks.IKEGAKI_acacia.get() );
		
		/** 6 DarkOak **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.8F) : -1; }, //黒
				Garden_Blocks.BONSAI_doak.get(),
				Garden_Blocks.KANYOU_darkoak.get(),
				Garden_Blocks.IKEGAKILONG_darkoak.get(),
				Garden_Blocks.IKEGAKI_darkoak.get() );
		
		/** 7 Acer **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 14828063 : -1; },
				Garden_Blocks.BONSAI_kaede.get(),
				Garden_Blocks.KANYOU_kaede.get(),
				Garden_Blocks.IKEGAKILONG_kaede.get(),
				Garden_Blocks.IKEGAKI_kaede.get(),
				Wood_Blocks.KAEDE_leaf.get(),
				Wood_Blocks.KAEDE_carpet.get() );
		
		/** 8 Autumn_Oak **/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 11495695 : -1; },
				Garden_Blocks.BONSAI_kare.get(),
				Garden_Blocks.KANYOU_kare.get(),
				Garden_Blocks.IKEGAKILONG_kare.get(),
				Garden_Blocks.IKEGAKI_kare.get(),
				Wood_Blocks.OAKKARE_leaf.get(),
				Wood_Blocks.OCHIBA_carpet.get() );
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		Minecraft.getInstance().getBlockColors().register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); },
				Kitchen_Blocks.KIT_REIZOU.get(),
				Kitchen_Blocks.KIT_REIZOU_TOP.get() );
	}
	
	
	/* TintIndex of ItemBlock */
	public static void registerItemColors() {
		/** 20 Water waterColor(4159204) from Biome=1, 35 CornSoup=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 4159204 : ((tint == 2)? 16441700 : -1); },
				Items_Seasonal.SUIDEN.get(),
				Items_Seasonal.KURI_NABE.get(),
				
				Items_Teatime.MIZUOKE_full.get(),
				Items_Teatime.HAKUSAI_TARU1.get(),
				Items_Teatime.HAKUSAI_TARU2.get(),

				Items_Teatime.KEIRYO_CUP_full.get(),
				Items_Teatime.CURRY.get(),
				Items_Teatime.CURRY_C.get(),
				Items_Teatime.CURRY_T.get(),
				Items_Teatime.CURRYSET.get(),
				Items_Teatime.CURRYSET_C.get(),
				Items_Teatime.CURRYSET_T.get(),
				Items_Teatime.ZUNDOU_NCURRY.get(),
				Items_Teatime.ZUNDOU_NCURRY_C.get(),
				Items_Teatime.ZUNDOU_NCURRY_T.get(),
				Items_Teatime.ZUNDOU_RSOUP_nama.get(), /* 6.4.1 */
				
				Items_Teatime.KETTLE_full.get(),
				Items_Teatime.KETTLE_boil.get(),
				Items_Teatime.ZUNDOU_MIZU.get(),
				Items_Teatime.ZUNDOU_SHIO.get(),
				
				Items_Teatime.NABETORI_nama.get(),
				Items_Teatime.NABEMISO_nama.get(),
				Items_Teatime.NABEGOHAN_nama.get(),
				Items_Teatime.NABEGOHANKURI_nama.get(),
				Items_Teatime.NABEGOHANTAKE_nama.get(),
				Items_Teatime.NABESHIO_nama.get(),
				Items_Teatime.NABENIMAME_nama.get(),
				
				Items_Teatime.NABECORN_nama.get(),
				Items_Teatime.NABECORN.get(),
				Items_Teatime.CORNSOUP.get(),
				Items_Teatime.EGGBURGSET.get() );

		/** 42 KANSUI 63,98,168 _6.4.1 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 4154024 : -1; },
				Items_Teatime.KANSUI.get() );
		
		/** 21 Raw_Sake **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 12509680 : -1; },
				Items_Teatime.NAMASAKEGLASS.get() );
		
		/** 22 Sake **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 9223890 : -1; },
				Items_Teatime.SAKEGLASS.get() );
		
		/** 23 Aged_Sake **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 11164250 : -1; },
				Items_Teatime.JUKUSAKEGLASS.get() );
		
		/** 24 Cider **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 15127945 : -1; },
				Items_Teatime.CIDERGLASS.get() );
		
		/** 25 Aged_Cider **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 14588001 : -1; },
				Items_Teatime.JUKUCIDERGLASS.get() );
		
		/** 26 Wine **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 8398655 : -1; },
				Items_Teatime.WINEGLASS.get() );
		
		/** 27 Aged_Wine **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 5715258 : -1; },
				Items_Teatime.JUKUWINEGLASS.get() );
		
		/** 28 Mead **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 13821640 : -1; },
				Items_Teatime.MEADGLASS.get() );
		
		/** 29 Aged_Mead **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 13808770 : -1; },
				Items_Teatime.JUKUMEADGLASS.get() );
		
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { 
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); },
				Items_Teatime.KYUSU.get(),
				Items_Teatime.JPTEACUP.get(),
				Items_Teatime.JPTEASET.get(),
				Items_Teatime.SUSHISET_salmon.get(),
				Items_Teatime.SUSHISET_fish.get(),
				Items_Teatime.SUSHISET_beef.get(),
				Items_Teatime.SUSHISET_tamago.get(),
				Items_Teatime.SUSHISET_4shoku.get(),
				
				Items_Teatime.NABETORI.get(),
				Items_Teatime.NABEMISO.get(),
				Items_Teatime.TONSUITORI.get(),
				Items_Teatime.MISOSOUP.get(),
				
				Items_Teatime.TAMAGOYAKITEI.get(),
				Items_Teatime.YAKIZAKANATEI.get(),
				Items_Teatime.YAKIJYAKETEI.get(),
				Items_Teatime.TAMAGOYAKITEI_TAKE.get(),
				Items_Teatime.YAKIZAKANATEI_TAKE.get(),
				Items_Teatime.YAKIJYAKETEI_TAKE.get(),
				Items_Teatime.TAMAGOYAKITEI_KURI.get(),
				Items_Teatime.YAKIZAKANATEI_KURI.get(),
				Items_Teatime.YAKIJYAKETEI_KURI.get() );
		
		/** 31 Black_Tea **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 14493736 : -1; },
				Items_Teatime.TEAPOT.get(),
				Items_Teatime.TEACUP.get(),
				Items_Teatime.TEASET.get() );

		/** 33 Aku **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { return (tint == 1)? 3297410 : -1; },
				Items_Seasonal.ZUNDOU_AKU.get() );

		/** 20 Water=1, 34 AMAZAKE=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { 
			return (tint == 1)? 4159204 : ((tint == 2)? 16443100 : -1); },
				Items_Teatime.NABEAMAZAKE_nama.get(),
				Items_Teatime.NABEAMAZAKE.get(),
				Items_Teatime.AMAZAKEGLASS.get() );
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> { 
			return (tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); },
				Items_Teatime.ENDEN.get() );
		
		
		/** 1 Oak **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.6F) : -1; },
				Items_Wadeco.BONSAI_oak.get(),
				Items_Wadeco.KANYOU.get(),
				Items_Wadeco.IKEGAKILONG.get(),
				Items_Wadeco.IKEGAKI.get() );
		
		/** 2 Spruce **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColor.getEvergreenColor() : -1; },
				Items_Wadeco.BONSAI_spru.get(),
				Items_Wadeco.KANYOU_spruce.get(),
				Items_Wadeco.IKEGAKILONG_spruce.get(),
				Items_Wadeco.IKEGAKI_spruce.get() );

		/** 3 Birch **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColor.getBirchColor() : -1; },
				Items_Wadeco.BONSAI_bir.get(),
				Items_Wadeco.KANYOU_birch.get(),
				Items_Wadeco.IKEGAKILONG_birch.get(),
				Items_Wadeco.IKEGAKI_birch.get() );
		
		/** 4 Jungle **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.9F) : -1; }, //緑
				Items_Wadeco.BONSAI_jun.get(),
				Items_Wadeco.KANYOU_jungle.get(),
				Items_Wadeco.IKEGAKILONG_jungle.get(),
				Items_Wadeco.IKEGAKI_jungle.get() );
		
		/** 5 Acacia **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.0F) : -1; },
				Items_Wadeco.BONSAI_aca.get(),
				Items_Wadeco.KANYOU_acacia.get(),
				Items_Wadeco.IKEGAKILONG_acacia.get(),
				Items_Wadeco.IKEGAKI_acacia.get() );
		
		/** 6 DarkOak **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.8F) : -1; }, //黒
				Items_Wadeco.BONSAI_doak.get(),
				Items_Wadeco.KANYOU_darkoak.get(),
				Items_Wadeco.IKEGAKILONG_darkoak.get(),
				Items_Wadeco.IKEGAKI_darkoak.get() );
		
		/** 7 Acer **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 14828063 : -1; },
				Items_Seasonal.BONSAI_kaede.get(),
				Items_Seasonal.KANYOU_kaede.get(),
				Items_Seasonal.IKEGAKILONG_kaede.get(),
				Items_Seasonal.IKEGAKI_kaede.get(),
				Items_Seasonal.KAEDE_leaf.get(),
				Items_Seasonal.KAEDE_carpet.get() );
		
		/** 8 Autumn_Oak **/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 11495695 : -1; },
				Items_Seasonal.BONSAI_kare.get(),
				Items_Seasonal.KANYOU_kare.get(),
				Items_Seasonal.IKEGAKILONG_kare.get(),
				Items_Seasonal.IKEGAKI_kare.get(),
				Items_Seasonal.OAKKARE_leaf.get(),
				Items_Seasonal.OCHIBA_carpet.get() );
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		Minecraft.getInstance().getItemColors().register((stack, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); },
				Items_Teatime.KIT_REIZOU.get() );
	}
}
