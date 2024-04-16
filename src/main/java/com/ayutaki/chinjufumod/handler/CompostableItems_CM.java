package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

public class CompostableItems_CM {

	public static void setup() {

		registerCompostable(0.3F, Items.POISONOUS_POTATO);
		registerCompostable(0.3F, Items_Teatime.SEEDS_CABBAGE);
		registerCompostable(0.3F, Items_Teatime.SEEDS_HAKUSAI);
		registerCompostable(0.3F, Items_Teatime.SEEDS_CORN);
		registerCompostable(0.3F, Items_Teatime.SEEDS_ONION);
		registerCompostable(0.3F, Items_Teatime.SEEDS_RICE);
		registerCompostable(0.3F, Items_Teatime.SEEDS_SOY);
		registerCompostable(0.3F, Items_Teatime.SEEDS_SPINACH);
		registerCompostable(0.3F, Items_Teatime.SEEDS_TOMATO);
		registerCompostable(0.3F, Items_Teatime.SEEDS_CHERRY);

		registerCompostable(0.5F, Items_Teatime.CAKE);
		registerCompostable(0.5F, Items_Teatime.BUN);
		registerCompostable(0.5F, Items_Teatime.SCONE);
		registerCompostable(0.5F, Items_Teatime.SENBEI);
		registerCompostable(0.5F, Items_Teatime.TOUFU);

		registerCompostable(0.5F, Items_Teatime.CHICKENSAND);
		registerCompostable(0.5F, Items_Teatime.EGGSAND);

		registerCompostable(0.5F, Items_Teatime.FOOD_CABBAGE);
		registerCompostable(0.5F, Items_Teatime.FOOD_HAKUSAI);
		registerCompostable(0.5F, Items_Teatime.FOOD_CORN);
		registerCompostable(0.5F, Items_Teatime.FOOD_ONION);
		registerCompostable(0.5F, Items_Teatime.FOOD_SPINACH);
		registerCompostable(0.5F, Items_Teatime.FOOD_TOMATO);
		registerCompostable(0.5F, Items_Teatime.FOOD_GRAPE);
		registerCompostable(0.5F, Items_Teatime.FOOD_CHERRY);
		registerCompostable(0.5F, Items_Teatime.FOOD_MIKAN);
		registerCompostable(0.5F, Items_Teatime.FOOD_CORN_B);
		registerCompostable(0.5F, Items_Teatime.FOOD_HAKUSAI2);

		registerCompostable(0.5F, Items_Teatime.FCHEESE);
		registerCompostable(0.5F, Items_Teatime.PC_CHEESE);
		registerCompostable(0.5F, Items_Teatime.PC_PIZZA);
		registerCompostable(0.3F, Items_Teatime.KIRIMI_S);
		registerCompostable(0.3F, Items_Teatime.KIRIMI_F);
		registerCompostable(0.3F, Items_Teatime.KIRIMI_B);
		registerCompostable(0.3F, Items_Teatime.KIRIMI_T);
		registerCompostable(0.5F, Items_Teatime.SUSHI_S);
		registerCompostable(0.5F, Items_Teatime.SUSHI_F);
		registerCompostable(0.5F, Items_Teatime.SUSHI_B);
		registerCompostable(0.5F, Items_Teatime.SUSHI_T);
		registerCompostable(0.5F, Items_Teatime.SHOUYUSUSHI_S);
		registerCompostable(0.5F, Items_Teatime.SHOUYUSUSHI_F);
		registerCompostable(0.5F, Items_Teatime.SHOUYUSUSHI_B);
		registerCompostable(0.5F, Items_Teatime.SHOUYUSUSHI_T);
		registerCompostable(0.3F, Items_Teatime.NORI_N);
		registerCompostable(0.3F, Items_Teatime.NORI_I);
		registerCompostable(0.5F, Items_Teatime.ONIGIRI);
		registerCompostable(0.5F, Items_Teatime.ONIGIRI_SHAKE);
		registerCompostable(0.5F, Items_Teatime.ONIGIRI_TAKE);
		registerCompostable(0.5F, Items_Teatime.ONIGIRI_KURI);
		registerCompostable(0.5F, Items_Teatime.FUTOMAKI);
		registerCompostable(0.5F, Items_Teatime.KUSHI_SAKANA);
		registerCompostable(0.5F, Items_Teatime.KUSHI_SAKANA_C);

		registerCompostable(0.3F, Items_Seasonal.FOOD_CHOCO);
		registerCompostable(0.3F, Items_Seasonal.FOOD_CHOCO_A);
		registerCompostable(0.3F, Items_Seasonal.FOOD_CHOCO_C);
		registerCompostable(0.3F, Items_Seasonal.FOOD_CHOCO_G);
		registerCompostable(0.3F, Items_Seasonal.FOOD_CHOCO_T);
		registerCompostable(0.3F, Items_Seasonal.FOOD_CHOCO_H);
		registerCompostable(0.3F, Items_Seasonal.FOOD_WATAGASHI);
		registerCompostable(0.3F, Items_Seasonal.FOOD_WATAGASHI_A);
		registerCompostable(0.3F, Items_Seasonal.FOOD_WATAGASHI_C);
		registerCompostable(0.3F, Items_Seasonal.FOOD_WATAGASHI_G);
		registerCompostable(0.3F, Items_Seasonal.FOOD_WATAGASHI_T);
		registerCompostable(0.1F, Items_NoTab.IGA);
		registerCompostable(0.5F, Items_Seasonal.KURI_IGA);
		registerCompostable(0.3F, Items_Seasonal.KURI);
		registerCompostable(0.3F, Items_Seasonal.KURI_ROAST);
		registerCompostable(0.3F, Items_Seasonal.KURI_CHOCO);
		registerCompostable(0.3F, Items_Seasonal.TAKENOKO);
		registerCompostable(0.3F, Items_Seasonal.TAKENOKO_ROAST);
		
		registerCompostable(0.5F, Items_NoTab.ROTTEN_FOOD);

		registerCompostable(0.3F, Items_Teatime.CHABA);
		registerCompostable(0.3F, Items_Teatime.CHABA_GREEN);
		registerCompostable(0.3F, Items_Teatime.CHABA_RED);
		registerCompostable(0.3F, Items_Teatime.INEWARA);
		registerCompostable(0.3F, Items_Teatime.INE);
		registerCompostable(0.3F, Items_Teatime.KOME);
		registerCompostable(0.3F, Items_Teatime.SAYA);
		registerCompostable(0.3F, Items_Teatime.SOY);

		registerCompostable(0.3F, Items_Teatime.RENNET);

		registerCompostable(0.3F, Items_Teatime.MUSHIGOME);
		registerCompostable(0.3F, Items_Teatime.KOMEKOUJI);
		registerCompostable(0.3F, Items_Teatime.SHUBO);
		registerCompostable(0.3F, Items_Teatime.SAKEKASU);
		registerCompostable(0.3F, Items_Teatime.MOROMI);
		registerCompostable(0.3F, Items_Teatime.NIMAME);
		registerCompostable(0.3F, Items_Teatime.MISO);

		registerCompostable(0.3F, Items_Teatime.KOMUGI);
		registerCompostable(0.3F, Items_Teatime.BUTTER);
		registerCompostable(0.3F, Items_Teatime.KIJI_BUN);
		registerCompostable(0.3F, Items_Teatime.KIJI_BURG);
		registerCompostable(0.3F, Items_Teatime.KIJI_SCONE);
		registerCompostable(0.3F, Items_Teatime.KIJI_SENBEI);
		registerCompostable(0.3F, Items_Teatime.KIJI_PIZA);
		registerCompostable(0.3F, Items_Teatime.PIZZA_nama);
		registerCompostable(1.0F, Items_Teatime.PIZZA);

		registerCompostable(1.0F, Items_Teatime.CHEESE_CURD);
		registerCompostable(1.0F, Items_Teatime.CHEESE);

	}

	public static void registerCompostable(float chance, IItemProvider item) {
		ComposterBlock.CHANCES.put(item.asItem(), chance);
	}

}
