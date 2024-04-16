package com.ayutaki.chinjufumod.items.weapon;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CMTiers implements IItemTier {
	
	ANCHOR(2, 500, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(Items.IRON_INGOT);
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

	public int getMaxUses() {
		return this.uses;
	}

	public float getEfficiency() {
		return this.speed;
	}

	public float getAttackDamage() {
		return this.damage;
	}

	public int getHarvestLevel() {
		return this.level;
	}

	public int getEnchantability() {
		return this.enchantmentValue;
	}

	public Ingredient getRepairMaterial() {
		return this.repairIngredient.getValue();
	}
}
