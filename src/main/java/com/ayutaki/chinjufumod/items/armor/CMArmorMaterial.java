package com.ayutaki.chinjufumod.items.armor;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.ayutaki.chinjufumod.registry.Items_NoTab;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/* net.minecraft.world.item.ArmorMaterials.class */
@SuppressWarnings("deprecation")
public enum CMArmorMaterial implements ArmorMaterial {

	FUBUKI("fubuki", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),

	KASUMI("kasumi", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),

	SHIGURE("shigure", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),

	SHIRATSUYU("shiratsuyu", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),

	AKATSUKI("akatsuki", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),

	/* 0.42×45=18.9 */
	YURA("yura", 19, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	/* 0.42×48=20.1 */
	SENDAI("sendai", 20, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	/* 0.42×50=21 */
	RJ("ryujou", 21, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	/* 0.42×59=24.78 */
	ZUIHOU("zuihou", 25, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	/* 0.42×50=21 */
	MOGAMI("mogami", 21, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	/* 0.42×59=24.78 */
	TONE("tone", 25, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	/* 0.42×72=30.24 */
	KAGA("kaga", 30, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	/* 0.42×69=28.98 */
	AKAGI("akagi", 29, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	/* 33÷82≒0.4 調整値+0.02 ダイヤモンド相当を前提 */
	KONGOU("kongou", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	FUSOU("fusou", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	NAGATO("nagato", 35, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	/* 0.42×15=6.3 */
	I168("i168", 7, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 4);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	/* 0.42×21=8.8 */
	I13("i13", 9, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 4);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	/* 0.42×13=5.46 */
	RO500("ro500", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 4);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items.IRON_INGOT); }),
	
	/* SantaCos */
	AKASHISANTA("santaakashi", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),

	KUMANOSANTA("santakumano", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	SUZUYASANTA("santasuzuya", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	RYUJOUSANTA("santaryujou", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	TEITOKUSANTA("santattk", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	/* YUKATA */
	IKADUCHIYKT("ykt_ikaduchi", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	INADUMAYKT("ykt_inaduma", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	HAMAKAZEYKT("ykt_hamakaze", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	URAKAZEYKT("ykt_urakaze", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	KAWAKAZEYKT("ykt_kawakaze", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	OBOROYKT("ykt_oboro", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	TTOKUYKT("ykt_ttoku", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); }),
	
	TTOKUYKTB("ykt_ttokub", 6, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> { 
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items_NoTab.EMBLEM_C.get()); });
	

	/* Share variables */
	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 13);
		map.put(ArmorItem.Type.LEGGINGS, 15);
		map.put(ArmorItem.Type.CHESTPLATE, 16);
		map.put(ArmorItem.Type.HELMET, 11);
	});
		
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;
	
	private CMArmorMaterial(String nameIn, int maxDamageFactor, EnumMap<ArmorItem.Type, Integer> type, int enchantability, 
		SoundEvent equipSound, float tough, float knockbackResist, Supplier<Ingredient> repairItem) {
		this.name = nameIn;
		this.durabilityMultiplier = maxDamageFactor;
		this.protectionFunctionForType = type;
		this.enchantmentValue = enchantability;
		this.sound = equipSound;
		this.toughness = tough;
		this.knockbackResistance = knockbackResist;
		this.repairIngredient = new LazyLoadedValue<>(repairItem);
	}
	
	@Override
	public int getDurabilityForType(ArmorItem.Type slot) {
		return HEALTH_FUNCTION_FOR_TYPE.get(slot) * this.durabilityMultiplier;
	}
	
	@Override
	public int getDefenseForType(ArmorItem.Type slot) {
		return this.protectionFunctionForType.get(slot);
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	public SoundEvent getEquipSound() {
		return this.sound;
	}
	
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
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

	public String getSerializedName() {
		return this.name;
	}
}
