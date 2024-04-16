package com.ayutaki.chinjufumod.items.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodBuilders {

	@SuppressWarnings("deprecation")
	public static final FoodProperties ROTTEN_FOOD = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F)
			.effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).build();

	/* Teatime */
	public static final FoodProperties CABBAGE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties HAKUSAI = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties CORN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties GREENONION = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties ONION = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties SPINACH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties TOMATO = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties GRAPE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties MIKAN = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();

	public static final FoodProperties CORN_B = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
	public static final FoodProperties HAKUSAI2 = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).build();

	public static final FoodProperties FCHEESE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties PC_CHEESE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties PC_PIZZA = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties PC_PIZZAC = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties PC_PIZZAT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1400, 0), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 70, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties PC_PIZZAS = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1400, 0), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 70, 1), 1.0F).build();

	public static final FoodProperties KIRIMI = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
	public static final FoodProperties SUSHI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).alwaysEat().build();

	@SuppressWarnings("deprecation")
	public static final FoodProperties SHOUYUSUSHI_S = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties SHOUYUSUSHI_F = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties SHOUYUSUSHI_B = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties SHOUYUSUSHI_T = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties FUTOMAKI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).alwaysEat().build();
	
	public static final FoodProperties CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
	public static final FoodProperties BUN = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).build();
	public static final FoodProperties SCONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties SENBEI = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties TOUFU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();

	public static final FoodProperties CHICKENSAND = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties EGGSAND = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();

	public static final FoodProperties NORI_I = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
	public static final FoodProperties ONIGIRI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties ONIGIRISHAKE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties ONIGIRI_TAKEKURI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 1.0F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties MOCHI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 1.0F).build();
	
	public static final FoodProperties CUT_IKA = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties COOKED_IKA = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
	
	/* Seasonal */
	public static final FoodProperties KURI_ROAST = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).build();
	public static final FoodProperties KURI_SWEET = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties KURI_CHOCO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 1.0F).alwaysEat().build();
	public static final FoodProperties TAKENOKO_ROAST = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();

	@SuppressWarnings("deprecation")
	public static final FoodProperties CHOCO = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties CHOCO_A = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties CHOCO_C = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties CHOCO_G = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties CHOCO_T = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0), 1.0F).alwaysEat().build();
	@SuppressWarnings("deprecation")
	public static final FoodProperties CHOCO_H = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.LUCK, 3000, 0), 1.0F).alwaysEat().build();
}
