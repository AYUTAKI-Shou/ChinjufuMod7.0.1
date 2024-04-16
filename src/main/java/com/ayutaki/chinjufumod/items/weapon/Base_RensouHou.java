package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Base_RensouHou extends BowItem {

	public Base_RensouHou(Item.Properties properties) {
		super(properties.group(ItemGroups_CM.CMARMOR));
		
		this.addPropertyOverride(new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F; });
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

		if (!playerIn.abilities.isCreativeMode && !flag) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.EMPTY_AMMO, SoundCategory.PLAYERS, 0.8F, 0.6F);
			return ActionResult.resultFail(stack); }
		
		else {
			if (!playerIn.getCooldownTracker().hasCooldown(this)) {
				worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.SET_GUN, SoundCategory.PLAYERS, 0.8F, 0.8F);
				playerIn.setActiveHand(handIn);
				return ActionResult.resultConsume(stack); }
			
			else { return ActionResult.resultFail(stack); }
		}
	}

	public AbstractAmmo_Entity customAmmo(AbstractAmmo_Entity arrow) {
		return arrow;
	}
	
	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}
}
