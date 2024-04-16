package com.ayutaki.chinjufumod.event;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.weapon.FirstAid;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID)
public class FirstAidEvent {

	/* EntityLivingBase */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void damageControl(LivingDeathEvent event) {
		
		if(!event.isCanceled() && event.getEntityLiving() instanceof EntityPlayer) {
			
			EntityPlayer playerIn = (EntityPlayer) event.getEntityLiving();
			ItemStack stack = findFirstAid(playerIn);
			World worldIn = playerIn.getEntityWorld();
			
			if(!stack.isEmpty()) {
				
				event.setCanceled(true);
				playerIn.clearActivePotions();
				playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.firstaid.name", new Object[0]).setStyle(new Style().setBold(true)), true);

				int k;
				k = stack.getMetadata();
				if (k == 1) {
					playerIn.setHealth(20.0F);
					worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 1.0F, 1.0F);
					
					playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1200, 1)); //60 seconds
					playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1200, 1));
					playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1200, 1));
					playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20, 0));
					
					worldIn.setEntityState(playerIn, (byte)35);
					stack.shrink(1); }
				
				else {
					playerIn.setHealth(1.0F);
					worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1.0F, 1.0F);

					playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 1)); //30 seconds
					playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 600, 1));
					playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 600, 1));
					
					stack.shrink(1); }

			} //!stack.isEmpty()
		} //!event.isCanceled()
	}

	private static ItemStack findFirstAid(EntityPlayer playerIn) {
		for (EnumHand hand : EnumHand.values()) {
			ItemStack stack = playerIn.getHeldItem(hand); /** MAIN or OFF **/

			if (!stack.isEmpty() && stack.getItem() instanceof FirstAid) { return stack; }
		}
		return ItemStack.EMPTY;
	}
}
