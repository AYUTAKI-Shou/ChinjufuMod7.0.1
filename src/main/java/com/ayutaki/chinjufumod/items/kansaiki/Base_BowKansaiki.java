package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.function.Predicate;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class Base_BowKansaiki extends BowItem {

	public Base_BowKansaiki(Item.Properties properties) {
		super(properties);
	}
	
	/* Power to be charged. */
	public static float getPowerForTime(int charge) {
		float f = (float)charge / 20.0F;
		f = (f + 2.0F) / 3.0F;
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
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		boolean flag = !playerIn.getProjectile(stack).isEmpty();
		
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (stack.getDamageValue() >= (stack.getMaxDamage())) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
			playerIn.awardStat(Stats.ITEM_USED.get(this));
			stack.shrink(1); }
		
		if (!playerIn.getAbilities().instabuild && !flag) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.ERROR.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
			playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.empty_fuel"), true);
			return InteractionResultHolder.fail(stack); }
		
		if (playerIn.isUnderWater()) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.ERROR.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
			playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.waterlogged"), true);
			return InteractionResultHolder.fail(stack); }
		
		else {
			playerIn.startUsingItem(handIn);
			return InteractionResultHolder.consume(stack);
		}
	}

	public void onUseTick(Level worldIn, LivingEntity playerIn, ItemStack stack, int timeLeft) {
		int tickCount = playerIn.getTicksUsingItem();
		if (tickCount != 0 && tickCount % 3 == 0) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.KK_START.get(), SoundSource.PLAYERS, 0.5F, 1.2F); }
	}
	
	public AbstractAmmo_Entity customAmmo(AbstractAmmo_Entity arrow) {
		return arrow;
	}

	/* Ammo to be used. */
	public static final Predicate<ItemStack> FUEL = (projectile) -> {
		return projectile.getItem() == Items_Weapon.KK_FUEL.get();
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return FUEL;
	}
	
	/* Items needed for repair. */
	@Override
	public int getEnchantmentValue() {
		return 1;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items_Chinjufu.ALUMINUM.get(); }
}
