package com.ayutaki.chinjufumod.items.foods;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodBuilders {

	/* 食べ物に各種値を付与 .isMeat() = オオカミが食べる */
	public static final Food CAKE = (new Food.Builder()).hunger(5).saturation(0.4F).build();
	public static final Food BUN = (new Food.Builder()).hunger(6).saturation(0.4F).build();
	public static final Food SCONE = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food SENBEI = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food TOUFU = (new Food.Builder()).hunger(3).saturation(0.3F).build();

	public static final Food CHICKENSAND = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food EGGSAND = (new Food.Builder()).hunger(6).saturation(0.6F).build();

	public static final Food CABBAGE = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food HAKUSAI = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food CORN = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food GREENONION = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	public static final Food ONION = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	public static final Food SPINACH = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	public static final Food TOMATO = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	public static final Food GRAPE = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	public static final Food MIKAN = (new Food.Builder()).hunger(1).saturation(0.3F).build();

	public static final Food CORN_B = (new Food.Builder()).hunger(5).saturation(0.6F).build();
	public static final Food HAKUSAI2 = (new Food.Builder()).hunger(2).saturation(0.6F).build();

	public static final Food FCHEESE = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_CHEESE = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.HASTE, 600, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZA = (new Food.Builder()).hunger(6).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 1200, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZAC = (new Food.Builder()).hunger(6).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 1200, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZAT = (new Food.Builder()).hunger(6).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 1400, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 70, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZAS = (new Food.Builder()).hunger(6).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 1400, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 70, 1), 1.0F).build();
	
	public static final Food KIRIMI = (new Food.Builder()).hunger(1).saturation(0.1F).build();
	public static final Food SUSHI = (new Food.Builder()).hunger(4).saturation(0.6F).setAlwaysEdible().build();

	 /* 非推奨だが、add Itemがないadd Potion Effectは Builder で完結させる */
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_S = (new Food.Builder()).hunger(5).saturation(0.8F)
			.effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_F = (new Food.Builder()).hunger(5).saturation(0.8F)
			.effect(new EffectInstance(Effects.SPEED, 1000, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_B = (new Food.Builder()).hunger(5).saturation(0.8F)
			.effect(new EffectInstance(Effects.STRENGTH, 1000, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_T = (new Food.Builder()).hunger(5).saturation(0.8F)
			.effect(new EffectInstance(Effects.HASTE, 1200, 0), 1.0F).setAlwaysEdible().build();

	public static final Food NORI_I = (new Food.Builder()).hunger(1).saturation(0.1F).build();
	public static final Food ONIGIRI = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	@SuppressWarnings("deprecation")
	public static final Food ONIGIRISHAKE = (new Food.Builder()).hunger(4).saturation(0.6F)
			.effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food ONIGIRI_TAKEKURI = (new Food.Builder()).hunger(4).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 200, 0), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food MOCHI = (new Food.Builder()).hunger(4).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 200, 0), 1.0F).build();
	
	@SuppressWarnings("deprecation")
	public static final Food FUTOMAKI = (new Food.Builder()).hunger(4).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 1200, 0), 1.0F).setAlwaysEdible().build();

	@SuppressWarnings("deprecation")
	public static final Food CHOCO = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.SPEED, 600, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_A = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.RESISTANCE, 1000, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_C = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.STRENGTH, 1000, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_G = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.NIGHT_VISION, 1000, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_T = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.HASTE, 1000, 0), 1.0F).setAlwaysEdible().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_H = (new Food.Builder()).hunger(1).saturation(0.3F)
			.effect(new EffectInstance(Effects.LUCK, 3000, 0), 1.0F).setAlwaysEdible().build();

	@SuppressWarnings("deprecation")
	public static final Food ROTTEN_FOOD = (new Food.Builder()).hunger(3).saturation(0.1F)
			.effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.8F).build();
	
	public static final Food CUT_IKA = (new Food.Builder()).hunger(2).saturation(0.1F).build();
	public static final Food COOKED_IKA = (new Food.Builder()).hunger(6).saturation(0.8F).build();
	public static final Food KURI_ROAST = (new Food.Builder()).hunger(2).saturation(0.4F).build();
	public static final Food KURI_SWEET = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	@SuppressWarnings("deprecation")
	public static final Food KURI_CHOCO = (new Food.Builder()).hunger(4).saturation(0.6F)
			.effect(new EffectInstance(Effects.HASTE, 800, 0), 1.0F).setAlwaysEdible().build();
	public static final Food TAKENOKO_ROAST = (new Food.Builder()).hunger(4).saturation(0.6F).build();
}
