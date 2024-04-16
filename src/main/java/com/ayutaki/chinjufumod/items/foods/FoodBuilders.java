package com.ayutaki.chinjufumod.items.foods;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodBuilders {

	/* 食べ物に各種値を付与 .isMeat() = オオカミが食べる */
	public static final Food CAKE = (new Food.Builder()).nutrition(5).saturationMod(0.4F).build();
	public static final Food BUN = (new Food.Builder()).nutrition(6).saturationMod(0.4F).build();
	public static final Food SCONE = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final Food SENBEI = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final Food TOUFU = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();

	public static final Food CHICKENSAND = (new Food.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final Food EGGSAND = (new Food.Builder()).nutrition(6).saturationMod(0.6F).build();

	public static final Food CABBAGE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food HAKUSAI = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food CORN = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food GREENONION = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food ONION = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food SPINACH = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food TOMATO = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food GRAPE = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food MIKAN = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();

	public static final Food CORN_B = (new Food.Builder()).nutrition(5).saturationMod(0.6F).build();
	public static final Food HAKUSAI2 = (new Food.Builder()).nutrition(2).saturationMod(0.6F).build();

	public static final Food FCHEESE = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_CHEESE = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 600, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZA = (new Food.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1200, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZAC = (new Food.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1200, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZAT = (new Food.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1400, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 70, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food PC_PIZZAS = (new Food.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1400, 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, 70, 1), 1.0F).build();
	
	public static final Food KIRIMI = (new Food.Builder()).nutrition(1).saturationMod(0.1F).build();
	public static final Food SUSHI = (new Food.Builder()).nutrition(4).saturationMod(0.6F).alwaysEat().build();

	 /* 非推奨だが、アイテムの返しがない追加効果は Builder で完結させる */
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_S = (new Food.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_F = (new Food.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new EffectInstance(Effects.MOVEMENT_SPEED, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_B = (new Food.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new EffectInstance(Effects.DAMAGE_BOOST, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food SHOUYUSUSHI_T = (new Food.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1200, 0), 1.0F).alwaysEat().build();

	public static final Food NORI_I = (new Food.Builder()).nutrition(1).saturationMod(0.1F).build();
	public static final Food ONIGIRI = (new Food.Builder()).nutrition(4).saturationMod(0.6F).build();
	@SuppressWarnings("deprecation")
	public static final Food ONIGIRISHAKE = (new Food.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food ONIGIRI_TAKEKURI = (new Food.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 200, 0), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final Food MOCHI = (new Food.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 200, 0), 1.0F).build();
	
	@SuppressWarnings("deprecation")
	public static final Food FUTOMAKI = (new Food.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1200, 0), 1.0F).alwaysEat().build();

	@SuppressWarnings("deprecation")
	public static final Food CHOCO = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.MOVEMENT_SPEED, 600, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_A = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_C = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.DAMAGE_BOOST, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_G = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.NIGHT_VISION, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_T = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final Food CHOCO_H = (new Food.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new EffectInstance(Effects.LUCK, 3000, 0), 1.0F).alwaysEat().build();

	@SuppressWarnings("deprecation")
	public static final Food ROTTEN_FOOD = (new Food.Builder()).nutrition(3).saturationMod(0.1F)
			.effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.8F).build();
	
	public static final Food CUT_IKA = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final Food COOKED_IKA = (new Food.Builder()).nutrition(6).saturationMod(0.8F).build();
	public static final Food KURI_ROAST = (new Food.Builder()).nutrition(2).saturationMod(0.4F).build();
	public static final Food KURI_SWEET = (new Food.Builder()).nutrition(4).saturationMod(0.6F).build();
	@SuppressWarnings("deprecation")
	public static final Food KURI_CHOCO = (new Food.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new EffectInstance(Effects.DIG_SPEED, 200, 0), 1.0F).alwaysEat().build();
	public static final Food TAKENOKO_ROAST = (new Food.Builder()).nutrition(4).saturationMod(0.6F).build();
}
