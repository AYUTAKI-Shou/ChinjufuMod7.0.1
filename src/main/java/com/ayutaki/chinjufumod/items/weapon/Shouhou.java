package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Shouhou extends Item {

	public Shouhou(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.CHINJUFU));
	}

	/* RightClick Action */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);

		if (!worldIn.isClientSide) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.BOOK_PAGE_TURN, SoundCategory.PLAYERS, 1.2F, 1.0F);
			
			worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), 100));
			stack.shrink(1);
			
			return ActionResult.success(stack);
		}
		return ActionResult.success(stack);
	}
	
	/* ToolTip ...Item.class 222(1.16.5) */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_shouhou").withStyle(TextFormatting.GRAY));
	}
}
