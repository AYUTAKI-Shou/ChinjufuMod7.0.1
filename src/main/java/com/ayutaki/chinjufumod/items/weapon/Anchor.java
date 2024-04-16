package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class Anchor extends SwordItem {
	
	private final float attackDamage;
	private final float attackSpeed = -2.4F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	public Anchor(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties) {
		super(tier, attackDamageIn, attackSpeedIn, properties);
		
		this.attackDamage = (float)attackDamageIn + tier.getAttackDamageBonus();
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	public float getAttackDamage() {
		return attackDamage;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean flag) {
		
		if (entity != null && entity instanceof Player) {
	 		Player playerIn = (Player)entity;
	 		boolean destroyer = ShipTypes_CM.typeDestroyer(playerIn);
	 		
				if (playerIn.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == Items_Weapon.ANCHOR.get()) {
					
					if (destroyer) {
						if (!(playerIn.hasEffect(MobEffects.DAMAGE_BOOST))) {
							playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));
						} //!DAMAGE_BOOST
						
						if (playerIn.hasEffect(MobEffects.DAMAGE_BOOST)) { }
					}
					
					if (!destroyer) { }
				} //MAINHAND
				
				if (playerIn.getItemBySlot(EquipmentSlot.MAINHAND).getItem() != Items_Weapon.ANCHOR.get()) { }
		} //Player
	}
}
