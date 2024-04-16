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
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Base_BowKansaiki extends BowItem {

	public Base_BowKansaiki(Properties properties) {
		super(properties.tab(ItemGroups_CM.CMARMOR));
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
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		boolean flag = !playerIn.getProjectile(stack).isEmpty();
		
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (stack.getDamageValue() >= (stack.getMaxDamage())) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ITEM_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.awardStat(Stats.ITEM_USED.get(this));
			stack.shrink(1); }
		
		if (!playerIn.abilities.instabuild && !flag) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.ERROR, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.displayClientMessage(new TranslationTextComponent("text.chinjufumod.rightclick.empty_fuel"), true);
			return ActionResult.fail(stack); }
		
		if (playerIn.isUnderWater()) { 
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.ERROR, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.displayClientMessage(new TranslationTextComponent("text.chinjufumod.rightclick.waterlogged"), true);
			return ActionResult.fail(stack); }
		
		else {
			playerIn.startUsingItem(handIn);
			return ActionResult.consume(stack); }
	}

	public void onUseTick(World worldIn, LivingEntity playerIn, ItemStack stack, int timeLeft) {
		int tickCount = playerIn.getTicksUsingItem();
		if (tickCount != 0 && tickCount % 3 == 0) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.KK_START, SoundCategory.PLAYERS, 0.5F, 1.2F); }
	}
	
	public AbstractKK_Entity customAmmo(AbstractKK_Entity arrow) {
		return arrow;
	}

	/* Ammo to be used. */
	public static final Predicate<ItemStack> FUEL = (projectile) -> {
		return projectile.getItem() == Items_Weapon.KK_FUEL;
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return FUEL;
	}
	
	/* Return the enchantability factor of the item, most of the time is based on material. */
	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items_Chinjufu.ALUMINUM;
	}
}
