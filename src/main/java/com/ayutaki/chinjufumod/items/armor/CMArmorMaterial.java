package com.ayutaki.chinjufumod.items.armor;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.registry.Items_NoTab;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/* net.minecraft.world.item.ArmorMaterials.class */
public enum CMArmorMaterial implements ArmorMaterial {
	
	FUBUKI("fubuki", 17, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),

	KASUMI("kasumi", 17, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),

	SHIGURE("shigure", 17, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),

	SHIRATSUYU("shiratsuyu", 17, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),
	
	AKATSUKI("akatsuki", 17, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),

	/* 0.42×45=18.9 */
	YURA("yura", 19, new int[]{ 2, 6, 7, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),
	/* 0.42×48=20.1 */
	SENDAI("sendai", 20, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),

	/* 0.42×50=21 */
	RJ("ryujou", 21, new int[]{ 3, 6, 7, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),
	
	/* 0.42×59=24.78 */
	ZUIHOU("zuihou", 25, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),
	
	/* 0.42×50=21 */
	MOGAMI("mogami", 21, new int[]{ 3, 6, 7, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),
	/* 0.42×59=24.78 */
	TONE("tone", 25, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
		Items.IRON_INGOT),

	/* 0.42×72=30.24 */
	KAGA("kaga", 30, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.1F, () ->
		Items.IRON_INGOT),
	/* 0.42×69=28.98 */
	AKAGI("akagi", 29, new int[]{ 2, 6, 7, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.1F, () ->
		Items.IRON_INGOT),
	
	/* 33÷82≒0.4 調整値+0.02 ダイヤモンド相当を前提 */
	KONGOU("kongou", 33, new int[]{ 3, 6, 8, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () ->
		Items.IRON_INGOT),
	FUSOU("fusou", 33, new int[]{ 3, 6, 8, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () ->
		Items.IRON_INGOT),
	NAGATO("nagato", 35, new int[]{ 3, 6, 8, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () ->
		Items.IRON_INGOT),

	/* 0.42×15=6.3 */
	I168("i168", 7, new int[] { 2, 4, 4, 2 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
	Items.IRON_INGOT),
	/* 0.42×21=8.8 */
	I13("i13", 9, new int[] { 2, 4, 4, 2 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
	Items.IRON_INGOT),
	/* 0.42×13=5.46 */
	RO500("ro500", 6, new int[] { 3, 4, 4, 3 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
	Items.IRON_INGOT),
	
	AKASHISANTA("santaakashi", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	KUMANOSANTA("santakumano", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	SUZUYASANTA("santasuzuya", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	RYUJOUSANTA("santaryujou", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	TEITOKUSANTA("santattk", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),

	IKADUCHIYKT("ykt_ikaduchi", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	INADUMAYKT("ykt_inaduma", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	HAMAKAZEYKT("ykt_hamakaze", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	URAKAZEYKT("ykt_urakaze", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	KAWAKAZEYKT("ykt_kawakaze", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	OBOROYKT("ykt_oboro", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	TTOKUYKT("ykt_ttoku", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get()),
	TTOKUYKTB("ykt_ttokub", 6, new int[]{ 1, 2, 2, 1 }, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
		Items_NoTab.EMBLEM_C.get());
	
	private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Item> repairItem;

	private CMArmorMaterial(String name, int maxDamageFactor, int[] damageReduction, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Item> repairItem) {
		this.name = name;
		this.durabilityMultiplier = maxDamageFactor;
		this.slotProtections = damageReduction;
		this.enchantmentValue = enchantability;
		this.sound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairItem = repairItem;
	}

	public int getDurabilityForSlot(EquipmentSlot slot) {
		return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.slotProtections[slot.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return Ingredient.of(repairItem.get());
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
