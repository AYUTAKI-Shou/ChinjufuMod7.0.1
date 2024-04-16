package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class Anchor extends SwordItem {

	private final float attackDamage;
	private final float attackSpeed;
	
	public Anchor(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties) {
		super(tier, attackDamageIn, attackSpeedIn, properties.group(ItemGroups_CM.CMARMOR));
		
		this.attackSpeed = attackSpeedIn;
		this.attackDamage = (float)attackDamageIn + tier.getAttackDamage();
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity playerIn) {
		stack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
		return true;
	}
	
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
		
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
		
		if (entity != null && entity instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entity;
			boolean destroyer = ShipTypes_CM.typeDestroyer(playerIn);
	 		
			if (playerIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem() == Items_Weapon.ANCHOR) {
				
				if (destroyer) {
					if (!(playerIn.isPotionActive(Effects.STRENGTH))) {
						playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 100, 1));
					} //!DAMAGE_BOOST
					
					if (playerIn.isPotionActive(Effects.STRENGTH)) { }
				}
				
				if (!destroyer) { }
			} //MAINHAND
			
			if (playerIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem() != Items_Weapon.ANCHOR) { }
		} //Player
	}
	
	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}
}