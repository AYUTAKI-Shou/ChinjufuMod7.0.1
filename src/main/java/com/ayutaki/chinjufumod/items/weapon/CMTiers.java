package com.ayutaki.chinjufumod.items.weapon;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum CMTiers implements Tier {
	
	ANCHOR(2, 500, 6.0F, 2.0F, 14, () -> {
		return Ingredient.of(Items.IRON_INGOT);
	});
	
	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private CMTiers(int toolLevel, int durability, float atackSpeed, float atackDamage, int enchant, Supplier<Ingredient> repairItem) {
		this.level = toolLevel;
		this.uses = durability;
		this.speed = atackSpeed;
		this.damage = atackDamage;
		this.enchantmentValue = enchant;
		this.repairIngredient = new LazyLoadedValue<>(repairItem);
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

	//@javax.annotation.Nullable public net.minecraft.tags.Tag<net.minecraft.world.level.block.Block> getTag() { return net.minecraftforge.common.ForgeHooks.getTagFromVanillaTier(this); }
}
