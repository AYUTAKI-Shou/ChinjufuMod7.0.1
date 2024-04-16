package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.function.Predicate;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.AbstractKK_Entity;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Base_BowKansaiki extends BowItem {

	public Base_BowKansaiki(Item.Properties properties) {
		super(properties.group(ItemGroups_CM.CMARMOR));
		
		this.addPropertyOverride(new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F;
		});
	}

	/* Power to be charged. */
	public static float getArrowVelocity(int charge) {
		float f = (float)charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		
		if (f > 1.0F) { f = 1.0F; }
		return f;
	}

	/* Time to continue the action. */
	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	/* Action when using. */
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(stack).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (stack.getDamage() >= (stack.getMaxDamage())) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
			stack.shrink(1); 
			playerIn.addStat(Stats.ITEM_USED.get(this)); }
		
		if (!playerIn.abilities.isCreativeMode && !flag) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.ERROR, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.sendStatusMessage(new TranslationTextComponent("text.chinjufumod.rightclick.empty_fuel"), true);
			return ActionResult.resultFail(stack); }
		
		if (playerIn.areEyesInFluid(FluidTags.WATER, true)) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.ERROR, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.sendStatusMessage(new TranslationTextComponent("text.chinjufumod.rightclick.waterlogged"), true);
			return ActionResult.resultFail(stack); }
		
		else {
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(stack);
		}
	}

	public void onUse(World worldIn, LivingEntity playerIn, ItemStack stack, int count) {
		int tickCount = playerIn.getItemInUseCount();
		if (tickCount != 0 && tickCount % 3 == 0) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.KK_START, SoundCategory.PLAYERS, 0.5F, 1.2F); }
	}
	
	public AbstractKK_Entity customAmmo(AbstractKK_Entity arrow) {
		return arrow;
	}
	
	/* Ammo to be used. */
	public static final Predicate<ItemStack> FUEL = (projectile) -> {
		return projectile.getItem() == Items_Weapon.KK_FUEL;
	};

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return FUEL;
	}
	
	@Override
	public int getItemEnchantability() {
		return 1;
	}
	
	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items_Chinjufu.ALUMINUM;
	}
}
