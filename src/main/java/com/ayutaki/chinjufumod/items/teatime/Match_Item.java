package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Match_Item extends Item {

	public Match_Item(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.TEATIME));
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		ItemStack stack = context.getItemInHand();
		boolean mode = playerIn.abilities.instabuild;

		if (CampfireBlock.canLight(state)) {
			worldIn.playSound(playerIn, pos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);

			if (!mode) { stack.shrink(1); }
			if (mode) { }

			return ActionResultType.sidedSuccess(worldIn.isClientSide());
		}

		else {
			BlockPos pos1 = pos.relative(context.getClickedFace());

			if (AbstractFireBlock.canBePlacedAt(worldIn, pos1, context.getHorizontalDirection())) {
				worldIn.playSound(playerIn, pos1, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
				BlockState state1 = AbstractFireBlock.getState(worldIn, pos1);
				worldIn.setBlock(pos1, state1, 11);

				if (playerIn instanceof ServerPlayerEntity) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos1, stack);

					if (!mode) { stack.shrink(1); }
					if (mode) { }
				}

				return ActionResultType.sidedSuccess(worldIn.isClientSide());
			}
			else {
				return ActionResultType.FAIL;
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_match_cm").withStyle(TextFormatting.GRAY));
	}
}
