package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemKumade extends Item {

	public ItemKumade(Properties properties) {
		super(properties.tab(ItemGroups_CM.WADECO));
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();

		ItemStack stack = context.getItemInHand();

		if (!playerIn.getCooldowns().isOnCooldown(this)) {

			if (block == Blocks.SAND) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.SAMON.defaultBlockState().setValue(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.GRAVEL) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.SAMON_B.defaultBlockState().setValue(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return ActionResultType.SUCCESS; }
			
			/** Samon **/
			if (block instanceof Samon) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlock(pos, state.cycle(Samon.STAGE_0_7), 3);
				
				playerIn.getCooldowns().addCooldown(this, 10);
				return ActionResultType.SUCCESS; }
		}
		
		return ActionResultType.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.STICK;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_kumade").withStyle(TextFormatting.GRAY));
	}
}
