package com.ayutaki.chinjufumod.event;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.weapon.FirstAid;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID)
public class FirstAidEvent {

	/* LivingEntit */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void damageControl(LivingDeathEvent event) {
		
		if(!event.isCanceled() && event.getEntity() instanceof Player) {
			
			Player playerIn = (Player) event.getEntity();
			ItemStack stack = findFirstAid(playerIn);
			Level worldIn = playerIn.level();
			
			if(!stack.isEmpty()) {
				
				event.setCanceled(true);
				playerIn.removeAllEffects();
				playerIn.displayClientMessage(Component.translatable("text.chinjufumod.firstaid").withStyle(ChatFormatting.BOLD), true);
				
				if (stack.getItem() == Items_Weapon.MEGAMI.get()) {
					playerIn.setHealth(20.0F);
					worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.TOTEM_USE, SoundSource.MASTER, 1.0F, 1.0F);
					
					playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1)); //60 seconds
					playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 1));
					playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 0));
					
					worldIn.broadcastEntityEvent(playerIn, (byte)35);
					stack.shrink(1); }
				
				else {
					playerIn.setHealth(1.0F);
					worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.MASTER, 1.0F, 1.0F);
					
					playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1)); //30 seconds
					playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 1));
					playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 1));
					
					stack.shrink(1); }

			} //!stack.isEmpty()
		}//!event.isCanceled()
	}
	
	private static ItemStack findFirstAid(Player playerIn) {
		for (InteractionHand hand : InteractionHand.values()) {
			ItemStack stack = playerIn.getItemInHand(hand); /** MAIN or OFF **/
			
			if (!stack.isEmpty() && stack.getItem() instanceof FirstAid) { return stack; }
		}
		return ItemStack.EMPTY;
	}
}
