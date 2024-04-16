package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;

public class CompostableItems_CM {
	
	public static void register() {

		ComposterBlock.COMPOSTABLES.put(Items.POISONOUS_POTATO, 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_CABBAGE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_HAKUSAI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_CORN.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_GREENONION.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_ONION.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_RICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_SOY.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_SPINACH.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_TOMATO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SEEDS_CHERRY.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CAKE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.BUN.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SCONE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SENBEI.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.TOUFU.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CHICKENSAND.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.EGGSAND.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_CABBAGE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_HAKUSAI.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_CORN.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_GREENONION.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_ONION.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_SPINACH.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_TOMATO.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_GRAPE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_CHERRY.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_MIKAN.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_CORN_B.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FOOD_HAKUSAI2.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FCHEESE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.PC_CHEESE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.PC_PIZZA.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIRIMI_S.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIRIMI_F.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIRIMI_B.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIRIMI_T.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SUSHI_S.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SUSHI_F.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SUSHI_B.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SUSHI_T.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SHOUYUSUSHI_S.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SHOUYUSUSHI_F.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SHOUYUSUSHI_B.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SHOUYUSUSHI_T.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.NORI_N.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.NORI_I.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.ONIGIRI.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.ONIGIRI_SHAKE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.ONIGIRI_TAKE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.ONIGIRI_KURI.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.FUTOMAKI.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KUSHI_SAKANA.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KUSHI_SAKANA_C.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_CHOCO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_CHOCO_A.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_CHOCO_C.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_CHOCO_G.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_CHOCO_T.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_CHOCO_H.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_WATAGASHI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_WATAGASHI_A.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_WATAGASHI_C.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_WATAGASHI_G.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.FOOD_WATAGASHI_T.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_NoTab.IGA.get(), 0.1F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.KURI_IGA.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.KURI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.KURI_ROAST.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.KURI_CHOCO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.TAKENOKO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Seasonal.TAKENOKO_ROAST.get(), 0.3F);
		
		ComposterBlock.COMPOSTABLES.put(Items_NoTab.ROTTEN_FOOD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CHABA.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CHABA_GREEN.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CHABA_RED.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.INEWARA.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.INE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KOME.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SAYA.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SOY.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.RENNET.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.MUSHIGOME.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KOMEKOUJI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SHUBO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.SAKEKASU.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.MOROMI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.NIMAME.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.MISO.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KOMUGI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.BUTTER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIJI_BUN.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIJI_BURG.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIJI_SCONE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIJI_SENBEI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.KIJI_PIZA.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.PIZZA_nama.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.PIZZA.get(), 1.0F);

		ComposterBlock.COMPOSTABLES.put(Items_Teatime.PASTA_nama.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.UDON_nama.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.RAMEN_nama.get(), 0.3F);
		
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CHEESE_CURD.get(), 1.0F);
		ComposterBlock.COMPOSTABLES.put(Items_Teatime.CHEESE.get(), 1.0F);
	}
}
