package com.ayutaki.chinjufumod.items.weapon;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CMTiers implements IItemTier {
	
	 ANCHOR(2, 500, 6.0F, 2.0F, 14, () -> {
		 return Ingredient.of(Items.IRON_INGOT);
	 });

	 private final int level;
	 private final int uses;
	 private final float speed;
	 private final float damage;
	 private final int enchantmentValue;
	 private final LazyValue<Ingredient> repairIngredient;

	 private CMTiers(int toolLevel, int durability, float atackSpeed, float atackDamage, int enchant, Supplier<Ingredient> repairItem) {
		this.level = toolLevel;
		this.uses = durability;
		this.speed = atackSpeed;
		this.damage = atackDamage;
		this.enchantmentValue = enchant;
		this.repairIngredient = new LazyValue<>(repairItem);
	 }

	 public int getUses() {
		return this.uses;
	 }

	 public float getSpeed() {
		return this.speed;
	 }

	 public float getAttackDamageBonus() {
		return this.damage;
	 }

	 public int getLevel() {
		return this.level;
	 }

	 public int getEnchantmentValue() {
		return this.enchantmentValue;
	 }

	 public Ingredient getRepairIngredient() {
		 return this.repairIngredient.get();
	}

}
