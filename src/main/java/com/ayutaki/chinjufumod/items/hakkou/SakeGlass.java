package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* MilkBucketItem を参照。extends は BlockNamedItem とする */
public class SakeGlass extends BlockNamedItem {

	public SakeGlass(Block block, Item.Properties properties) {
		super(block, properties.group(ItemGroups_CM.TEATIME));
	}

	/* Added after using the item. */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		if (this == Items_Teatime.NAMASAKEGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2600, 0)); }
		if (this == Items_Teatime.SAKEGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2600, 0)); }
		if (this == Items_Teatime.JUKUSAKEGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 2));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2250, 0)); }

		if (this == Items_Teatime.AMAZAKEGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 2000, 0)); }

		if (this == Items_Teatime.CIDERGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2600, 0)); }
		if (this == Items_Teatime.JUKUCIDERGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2250, 0)); }
		if (this == Items_Teatime.WINEGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2600, 0)); }
		if (this == Items_Teatime.JUKUWINEGLASS) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2250, 0)); }

		if (this == Items_Teatime.MEADGLASS) {
			entityLiving.removePotionEffect(Effects.POISON);
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2600, 0)); }
		if (this == Items_Teatime.JUKUMEADGLASS) {
			entityLiving.removePotionEffect(Effects.POISON);
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 2250, 1));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2250, 0)); }

		if (playerIn != null) {
			playerIn.addStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.isCreativeMode) {
				if (this != Items_Teatime.AMAZAKEGLASS) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DRINKGLASS); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DRINKGLASS))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.DRINKGLASS), false); } }

				if (this == Items_Teatime.AMAZAKEGLASS) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.YUNOMI); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.YUNOMI))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.YUNOMI), false); } }

				stack.shrink(1);
			}
		}
		return stack;
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		playerIn.setActiveHand(hand);
		return ActionResult.resultSuccess(playerIn.getHeldItem(hand));
	}

	/* 設置処理の分岐 スニーク時 playerIn.isSneaking() 座っている時 playerIn.isPassenger() */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getFace() == Direction.UP && (playerIn.isSneaking() || playerIn.isPassenger()) ) {
			return this.tryPlace(new BlockItemUseContext(context)); }

		else {
			return this.onItemRightClick(context.getWorld(), context.getPlayer(), context.getHand()).getType(); }
	}

	/* ToolTip*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").applyTextStyle(TextFormatting.GRAY));
	}
}
