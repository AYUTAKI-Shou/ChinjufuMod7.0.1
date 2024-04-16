package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class Anchor extends SwordItem {

	private final float attackDamage;
	private final float attackSpeed = -2.4F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	public Anchor(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties) {
		super(tier, attackDamageIn, attackSpeedIn, properties.tab(ItemGroups_CM.CMARMOR));
		
		this.attackDamage = (float)attackDamageIn + tier.getAttackDamageBonus();
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	public float getAttackDamage() {
		return attackDamage;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
		return slot == EquipmentSlotType.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int slot, boolean selected) {
		
				if (entity != null && entity instanceof PlayerEntity) {
					PlayerEntity playerIn = (PlayerEntity)entity;
				boolean destroyer = ShipTypes_CM.typeDestroyer(playerIn);
				
			if (playerIn.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == Items_Weapon.ANCHOR) {
				
				if (destroyer) {
					if (!(playerIn.hasEffect(Effects.DAMAGE_BOOST))) {
						playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 100, 1));
					} //!DAMAGE_BOOST
					
					if (playerIn.hasEffect(Effects.DAMAGE_BOOST)) { }
				}
				
				if (!destroyer) { }
			} //MAINHAND
			
			if (playerIn.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() != Items_Weapon.ANCHOR) { }
				} //Player
	}
}
