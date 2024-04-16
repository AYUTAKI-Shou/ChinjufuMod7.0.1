package com.ayutaki.chinjufumod.items.foods;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Bentou extends Item {

	public Bentou(Item.Properties properties) {
		super(properties.group(ItemGroups_CM.TEATIME));
		
		this.addPropertyOverride(new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F; } );
	}

	/* Finish RightClick Action */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** add SATURATION **/
		entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 0));
		entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 3500, 0));
		entityLiving.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 0));
		entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 3500, 0));

		/** add Item **/
		if (playerIn != null) {
			playerIn.addStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.isCreativeMode) {

				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.BENTOUHAKO); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BENTOUHAKO))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.BENTOUHAKO), false); }

				stack.shrink(1);
			}
		}
		return stack;
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		/** 食物が必要な時だけ成功 **/
		if (playerIn.getFoodStats().needFood() == true) {
			playerIn.setActiveHand(hand);
			return ActionResult.resultSuccess(playerIn.getHeldItem(hand));
		}

		return ActionResult.resultFail(playerIn.getHeldItem(hand));
	}

	/* ToolTip*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_bentou").applyTextStyle(TextFormatting.GRAY));
	}
}
