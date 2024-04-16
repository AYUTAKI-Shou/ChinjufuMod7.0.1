package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.world.ColorizerFoliage;
import net.minecraftforge.fml.client.FMLClientHandler;

public class TintColors_CM {

	public static void registerColorHandlers() {
		/* TintIndex Block */
		/** 20 Water=1, 35 CornSoup=2, 32 MisoSoup=3 **/
		IBlockColor blockColor35 = (state, worldIn, pos, tint) -> {
			return (tint == 1)? 4159204 : ((tint == 2)? 16441700 : ((tint == 3)? 15772230 : -1)); };
			registerColorHandlerForBlock(Garden_Blocks.CHOUZUBACHI, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI2, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHIB, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHIB2, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_T, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_T2, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_TB, blockColor35);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_TB2, blockColor35);
			registerColorHandlerForBlock(Kitchen_Blocks.KIT_SINK_TOP, blockColor35);
			registerColorHandlerForBlock(Kitchen_Blocks.KIT_SINK_BOT, blockColor35);

			registerColorHandlerForBlock(Hakkou_Blocks.MIZUOKE, blockColor35);
			registerColorHandlerForBlock(Hakkou_Blocks.MIZUOKE_full, blockColor35);
			registerColorHandlerForBlock(Hakkou_Blocks.HAKUSAITARU, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.KETTLE_full, blockColor35);
			
			registerColorHandlerForBlock(Dish_Blocks.MIZUMILKNABE, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.CURRY_RAW, blockColor35); //Raw Curry, Raw Stew
			registerColorHandlerForBlock(Dish_Blocks.FISH_ZUNDOU, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.UDONNABE, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.PASTANABE, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.ZUNDOU_RAMEN, blockColor35); /* 6.4.1 */
			registerColorHandlerForBlock(Dish_Blocks.ZUNDOU_RSOUP_nama, blockColor35); /* 6.4.1 */
			
			registerColorHandlerForBlock(Dish_Blocks.CURRY, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.CURRY_C, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.CURRY_T, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.CURRYSET, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.CURRYSET_C, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.CURRYSET_T, blockColor35);
			
			registerColorHandlerForBlock(Dish_Blocks.NABE_nama, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.NABECORNSOUP, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.NABE_nama_2, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.NABE_nama_TK, blockColor35);

			registerColorHandlerForBlock(Dish_Blocks.CORNSOUP, blockColor35);
			registerColorHandlerForBlock(Dish_Blocks.EGGBURGSET, blockColor35);
			
			
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		IBlockColor blockColor30 = (state, worldIn, pos, tint) -> {
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); };
			registerColorHandlerForBlock(Dish_Blocks.KYUSU, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.JPTEACUP, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.JPTEASET, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_salmon, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_fish, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_beef, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_tamago, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_4shoku, blockColor30);
			
			registerColorHandlerForBlock(Dish_Blocks.NABETORI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.NABEMISO, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.TONSUITORI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.MISOSOUP, blockColor30);
			
			registerColorHandlerForBlock(Dish_Blocks.TAMAGOYAKITEI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.YAKIZAKANATEI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.YAKIJYAKETEI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.TAMAGOYAKITEI_TAKE, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.YAKIZAKANATEI_TAKE, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.YAKIJYAKETEI_TAKE, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.TAMAGOYAKITEI_KURI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.YAKIZAKANATEI_KURI, blockColor30);
			registerColorHandlerForBlock(Dish_Blocks.YAKIJYAKETEI_KURI, blockColor30);
		
		/** 31 Black_Tea **/
		IBlockColor blockColor31 = (state, worldIn, pos, tint) -> { return (tint == 1)? 14493736 : -1; };
			registerColorHandlerForBlock(Dish_Blocks.TEAPOT, blockColor31);
			registerColorHandlerForBlock(Dish_Blocks.TEACUP, blockColor31);
			registerColorHandlerForBlock(Dish_Blocks.TEASET, blockColor31);
			
		/** 20 Water=1, 33 Aku **/
		IBlockColor blockColor33 = (state, worldIn, pos, tint) -> {
			return (tint == 1)? 4159204 : ((tint == 2)? 3297410 : -1); };
			registerColorHandlerForBlock(Dish_Blocks.SHIOAKUNABE, blockColor33);
			registerColorHandlerForBlock(Dish_Blocks.ORIITONABE, blockColor33);
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		IBlockColor blockColor40 = (state, worldIn, pos, tint) -> {
			return 	(tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); };
			registerColorHandlerForBlock(Crop_Blocks.ENDEN, blockColor40);
			
		/** 42 KAINASHI=1 **/
		IBlockColor blockColor42 = (state, worldIn, pos, tint) -> { return (tint == 1)? 15790315 : -1; };
			registerColorHandlerForBlock(Crop_Blocks.KAINASHI, blockColor42);

		/** 20 Water=1, 21 Raw_Sake=2, 22 Sake=3, 23 Aged_Sake=4 **/
		/** 24 Cider=5, 25 Aged_Cider=6, 26 Wine=7, 27 Aged_Wine=8, 28 Mead=9, 29 Aged_Mead=10 **/
		/** 34 AMAZAKE=11 **/
		IBlockColor sakeBlock = (state, worldIn, pos, tint) -> {
			return (tint == 1)? 4159204 :
						((tint == 2)? 12509680 :
						((tint == 3)? 9223890 :
						((tint == 4)? 11164250 :
						((tint == 5)? 15127945 :
						((tint == 6)? 14588001 :
						((tint == 7)? 8398655 :
						((tint == 8)? 5715258 :
						((tint == 9)? 13821640 :
						((tint == 10)? 13808770 :
						((tint == 11)? 16443100 : -1)))))))))); };
			registerColorHandlerForBlock(Hakkou_Blocks.SAKEGLASS, sakeBlock);
			registerColorHandlerForBlock(Hakkou_Blocks.WINEGLASS, sakeBlock);
			registerColorHandlerForBlock(Hakkou_Blocks.NABEAMAZAKE, sakeBlock);
			
		/** 1=oak, 2=spruce, 3=birch, 4=jungle, 5=acacia, 6=darkoak
		 * 7=KAEDE 226,66,31=14828063, 8=KAREOAK 175,105,15=11495695, #7cbd6b=7060860**/
		/** BiomeColors.class 設置場所の色を拾う BiomeColors.getFoliageColor(worldIn, pos)
		 ** Biome.class 気温と降雨量から色指定 FoliageColors.get(Temperature, Downfall) 1.0F以上はクラッシュする **/
		IBlockColor leafBlock = (state, worldIn, pos, tint) -> {
			return (tint == 1)? ColorizerFoliage.getFoliageColor(0.7F, 0.6F) :
						((tint == 2)? ColorizerFoliage.getFoliageColorPine() :
						((tint == 3)? ColorizerFoliage.getFoliageColorBirch() :
						((tint == 4)? ColorizerFoliage.getFoliageColor(0.9F, 0.9F) :
						((tint == 5)? ColorizerFoliage.getFoliageColor(0.9F, 0.0F) :
						((tint == 6)? ColorizerFoliage.getFoliageColor(0.7F, 0.8F) :
						((tint == 7)? 14828063 :
						((tint == 8)? 11495695 : -1))))))); };
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_oak, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_spru, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_bir, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_jun, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_doak, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_aca, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU_TOP, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU_BOT, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU2_TOP, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU2_BOT, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.IKEGAKI_L_TOP, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.IKEGAKI_L_BOT, leafBlock);
			registerColorHandlerForBlock(Garden_Blocks.IKEGAKI_S, leafBlock);
			registerColorHandlerForBlock(Seasonal_Blocks.KAEDE_leaf, leafBlock);
			registerColorHandlerForBlock(Seasonal_Blocks.OAKKARE_leaf, leafBlock);
			registerColorHandlerForBlock(Seasonal_Blocks.BONSAI_kaede, leafBlock);
			registerColorHandlerForBlock(Seasonal_Blocks.BONSAI_kare, leafBlock);
			registerColorHandlerForBlock(Seasonal_Blocks.KAEDE_CARPET, leafBlock);
			registerColorHandlerForBlock(Seasonal_Blocks.OCHIBA_CARPET, leafBlock);
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		IBlockColor reizou = (state, worldIn, pos, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); };
			registerColorHandlerForBlock(Kitchen_Blocks.KIT_REIZOU, reizou);
			registerColorHandlerForBlock(Kitchen_Blocks.KIT_REIZOU_TOP, reizou);
	
			
		/* TintIndex Item */
		/** 20 Water=1, 35 CornSoup=2, 32 MisoSoup=3 **/
		IItemColor itemColor35 = (stack, tint) -> {
			return (tint == 1)? 2185414 : ((tint == 2)? 11838790 : ((tint == 3)? 11174450 : -1)); };
			registerColorHandlerForItem(Items_Seasonal.SUIDEN, itemColor35);
			registerColorHandlerForItem(Items_Teatime.MIZUOKE_full, itemColor35);
			registerColorHandlerForItem(Items_Teatime.ZUNDOUMIZU, itemColor35);
			
			registerColorHandlerForItem(Items_Teatime.CURRY, itemColor35);
			registerColorHandlerForItem(Items_Teatime.CURRYSET, itemColor35);
			registerColorHandlerForItem(Items_Teatime.KETTLE_full, itemColor35);
			registerColorHandlerForItem(Items_Teatime.Item_YAKAN_boil, itemColor35);
			
			registerColorHandlerForItem(Items_Teatime.ZUNDOU, itemColor35);
			registerColorHandlerForItem(Items_Teatime.ZUNDOU_NAMA, itemColor35); //Raw Curry, Raw Stew
			registerColorHandlerForItem(Items_Teatime.ZUNDOU_RSOUP, itemColor35); /* 6.4.1 */
			registerColorHandlerForItem(Items_Teatime.NABE_NAMA_1, itemColor35);
			registerColorHandlerForItem(Items_Teatime.NABECORNSOUP, itemColor35);
			registerColorHandlerForItem(Items_Teatime.NABE_KAISUI, itemColor35);
			registerColorHandlerForItem(Items_Teatime.NABE_NAMA_2, itemColor35);
			registerColorHandlerForItem(Items_Teatime.NABE_NAMA_TK, itemColor35);
			registerColorHandlerForItem(Items_Teatime.KEIRYO_CUP_full, itemColor35);

			registerColorHandlerForItem(Items_Teatime.CORNSOUP, itemColor35);
			registerColorHandlerForItem(Items_Teatime.EGGBURGSET, itemColor35);
			registerColorHandlerForItem(Items_Seasonal.KURI_NABE, itemColor35);
			
			
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		IItemColor itemColor30 = (stack, tint) -> {
			return (tint == 1)? 16777053 : ((tint == 2)? 11174450 : -1); };
			registerColorHandlerForItem(Items_Teatime.KYUSU, itemColor30);
			registerColorHandlerForItem(Items_Teatime.JPTEACUP, itemColor30);
			registerColorHandlerForItem(Items_Teatime.JPTEASET, itemColor30);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_salmon, itemColor30);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_fish, itemColor30);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_beef, itemColor30);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_tamago, itemColor30);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_4shoku, itemColor30);
			
			registerColorHandlerForItem(Items_Teatime.NABETORI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.NABEMISO, itemColor30);
			registerColorHandlerForItem(Items_Teatime.TONSUITORI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.MISOSOUP, itemColor30);
			
			registerColorHandlerForItem(Items_Teatime.TAMAGOYAKITEI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.YAKIZAKANATEI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.YAKIJYAKETEI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.TAMAGOYAKITEI_TAKE, itemColor30);
			registerColorHandlerForItem(Items_Teatime.YAKIZAKANATEI_TAKE, itemColor30);
			registerColorHandlerForItem(Items_Teatime.YAKIJYAKETEI_TAKE, itemColor30);
			registerColorHandlerForItem(Items_Teatime.TAMAGOYAKITEI_KURI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.YAKIZAKANATEI_KURI, itemColor30);
			registerColorHandlerForItem(Items_Teatime.YAKIJYAKETEI_KURI, itemColor30);
		
		/** 42 KANSUI 63,98,168 _6.4.1 **/
		IItemColor itemColor42 = (stack, tint) -> { return (tint == 1)? 4154024 : -1; };
			registerColorHandlerForItem(Items_Teatime.KANSUI, itemColor42);
			
		/** 31 Black_Tea **/
		IItemColor itemColor31 = (stack, tint) -> { return (tint == 1)? 13505566 : -1; };
			registerColorHandlerForItem(Items_Teatime.TEAPOT, itemColor31);
			registerColorHandlerForItem(Items_Teatime.TEACUP, itemColor31);
			registerColorHandlerForItem(Items_Teatime.TEASET, itemColor31);
		
		/** 20 Water=1, 33 Aku **/
		IItemColor itemColor33 = (stack, tint) -> {
			return (tint == 1)? 2185414 : ((tint == 2)? 3297410 : -1); };
			registerColorHandlerForItem(Items_Teatime.ZUNDOUSHIO, itemColor33);
			registerColorHandlerForItem(Items_Seasonal.AKUNABE, itemColor33);
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		IItemColor itemColor40 = (stack, tint) -> { return (tint == 1)? 6587090 : -1; };
			registerColorHandlerForItem(Items_Teatime.ENDEN, itemColor40);
		

		/** 20 Water=1, 21 Raw_Sake=2, 22 Sake=3, 23 Aged_Sake=4 **/
		/** 24 Cider=5, 25 Aged_Cider=6, 26 Wine=7, 27 Aged_Wine=8, 28 Mead=9, 29 Aged_Mead=10 **/
		/** 34 AMAZAKE=11 **/
		IItemColor sakeItem = (stack, tint) -> {
			return (tint == 1)? 4159204 :
						((tint == 2)? 9217455 :
						((tint == 3)? 6589590 :
						((tint == 4)? 8208705 :
						((tint == 5)? 10852705 :
						((tint == 6)? 10645571 :
						((tint == 7)? 6102315 :
						((tint == 8)? 4072747 :
						((tint == 9)? 9874065 :
						((tint == 10)? 9863775 :
						((tint == 11)? 13806240 : -1)))))))))); };
			registerColorHandlerForItem(Items_Teatime.SAKEGLASS, sakeItem);
			registerColorHandlerForItem(Items_Teatime.WINEGLASS, sakeItem);
			registerColorHandlerForItem(Items_Teatime.NABEAMAZAKE, sakeItem);

		/** 1=oak, 2=spruce, 3=birch, 4=jungle, 5=acacia, 6=darkoak
		 * 7=KAEDE 226,66,31=14828063, 8=KAREOAK 175,105,15=11495695, #7cbd6b=7060860**/
		IItemColor leafItem = (stack, tint) -> {
			return (tint == 1)? ColorizerFoliage.getFoliageColor(0.7F, 0.6F) :
						((tint == 2)? ColorizerFoliage.getFoliageColorPine() :
						((tint == 3)? ColorizerFoliage.getFoliageColorBirch() :
						((tint == 4)? ColorizerFoliage.getFoliageColor(0.9F, 0.9F) :
						((tint == 5)? ColorizerFoliage.getFoliageColor(0.9F, 0.0F) :
						((tint == 6)? ColorizerFoliage.getFoliageColor(0.7F, 0.8F) :
						((tint == 7)? 14828063 :
						((tint == 8)? 11495695 : -1))))))); };
			registerColorHandlerForItem(Items_Wadeco.BONSAI_item, leafItem);
			registerColorHandlerForItem(Items_Wadeco.KANYOU_BOT, leafItem);
			registerColorHandlerForItem(Items_Wadeco.IKEGAKILONG_BOT, leafItem);
			registerColorHandlerForItem(Items_Wadeco.IKEGAKI, leafItem);
			registerColorHandlerForItem(Items_Seasonal.SKANYOU_BOT, leafItem);
			registerColorHandlerForItem(Items_Seasonal.SIKEGAKI, leafItem);
			registerColorHandlerForItem(Items_Seasonal.SIKEGAKILONG_BOT, leafItem);
			registerColorHandlerForItem(Items_Seasonal.KAEDE_leaf, leafItem);
			registerColorHandlerForItem(Items_Seasonal.OAKKARE_leaf, leafItem);
			registerColorHandlerForItem(Items_Seasonal.SBONSAI_item, leafItem);
			registerColorHandlerForItem(Items_Seasonal.S_CARPET, leafItem);
			
		/** Reizou 1=200,200,200 2=225,240,255**/
		IItemColor reizouItem = (stack, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); };
			registerColorHandlerForItem(Items_Teatime.KIT_REIZOU, reizouItem);
	}

	public static void registerColorHandlerForBlock(Block block, IBlockColor blockColor) {
		FMLClientHandler.instance().getClient().getBlockColors().registerBlockColorHandler(blockColor, block);
	}

	public static void registerColorHandlerForItem(Item item, IItemColor itemColor) {
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(itemColor, item);
	}

}
