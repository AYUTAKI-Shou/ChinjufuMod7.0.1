package com.ayutaki.chinjufumod.event;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.weapon.FirstAid;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID)
public class FirstAidEvent {

	/* LivingEntit */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void damageControl(LivingDeathEvent event) {
		
		if(!event.isCanceled() && event.getEntityLiving() instanceof PlayerEntity) {
			
			PlayerEntity playerIn = (PlayerEntity) event.getEntityLiving();
			ItemStack stack = findFirstAid(playerIn);
			World worldIn = playerIn.level;
			
			if(!stack.isEmpty()) {
				
				event.setCanceled(true);
				playerIn.removeAllEffects();
				playerIn.displayClientMessage(new TranslationTextComponent("text.chinjufumod.firstaid").setStyle(Style.EMPTY.withBold(true)), true);
				
				if (stack.getItem() == Items_Weapon.MEGAMI) {
					playerIn.setHealth(20.0F);
					worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.TOTEM_USE, SoundCategory.MASTER, 1.0F, 1.0F);
					
					playerIn.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 1200, 1)); //60 seconds
					playerIn.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 1));
					playerIn.addEffect(new EffectInstance(Effects.ABSORPTION, 1200, 1));
					playerIn.addEffect(new EffectInstance(Effects.SATURATION, 20, 0));
					
					worldIn.broadcastEntityEvent(playerIn, (byte)35);
					stack.shrink(1); }
				
				else {
					playerIn.setHealth(1.0F);
					worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1.0F, 1.0F);
					
					playerIn.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 600, 1)); //30 seconds
					playerIn.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 600, 1));
					playerIn.addEffect(new EffectInstance(Effects.ABSORPTION, 600, 1));
					
					stack.shrink(1); }

			} //!stack.isEmpty()
		}//!event.isCanceled()
	}
	
	private static ItemStack findFirstAid(PlayerEntity playerIn) {
		for (Hand hand : Hand.values()) {
			ItemStack stack = playerIn.getItemInHand(hand); /** MAIN or OFF **/
			
			if (!stack.isEmpty() && stack.getItem() instanceof FirstAid) { return stack; }
		}
		return ItemStack.EMPTY;
	}
	
	@SubscribeEvent
	public void updateFOV(FOVUpdateEvent event){
		PlayerEntity entity = event.getEntity();
		if(entity == null) return;
		
		ItemStack stack = entity.getMainHandItem();
		if(stack != null && entity.isUsingItem()){
			if(stack.getItem() instanceof SouganKyou){ event.setNewfov(1.0F - 0.25F); }
		}
	}
}
