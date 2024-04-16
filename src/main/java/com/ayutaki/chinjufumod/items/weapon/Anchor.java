package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class Anchor extends ItemSword {

	@SuppressWarnings("unused")
	private final float attackDamage;
	private final Item.ToolMaterial material;
	public static ToolMaterial ANCHOR = EnumHelper.addToolMaterial("ANCHOR", 2, 500, 6.0F, 2.0F, 14);
	
	public Anchor(String name, ToolMaterial material) {
		super(material);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.CMARMOR);
		
		this.material = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.attackDamage = 3.0F + material.getAttackDamage();
	}

	public float getAttackDamage() {
		return this.material.getAttackDamage();
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if (entityIn != null && entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer)entityIn;
			boolean destroyer = ShipTypes_CM.typeDestroyer(playerIn);
	 		
			if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() == Items_Weapon.ANCHOR) {
				
				if (destroyer) {
					if (!(playerIn.isPotionActive(MobEffects.STRENGTH))) {
						playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 100, 1));
					} //!DAMAGE_BOOST
					
					if (playerIn.isPotionActive(MobEffects.STRENGTH)) { }
				}
				
				if (!destroyer) { }
			} //MAINHAND
			
			if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() != Items_Weapon.ANCHOR) { }
		} //Player
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == Items.IRON_INGOT;
	}

	protected void playEquipSound(EntityPlayer player, ItemStack stack) {
		if (!stack.isEmpty()) {
			SoundEvent soundevent = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
			Item item = stack.getItem();

			if (item instanceof Anchor) {
				soundevent = SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA;
			}
			else if (item == Items.ELYTRA) {
				soundevent = SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA;
			}
			player.playSound(soundevent, 1.0F, 1.0F);
		}
	}
}
