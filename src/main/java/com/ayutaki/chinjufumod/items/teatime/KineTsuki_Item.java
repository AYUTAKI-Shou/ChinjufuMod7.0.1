package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KineTsuki_Item extends Item {

	public KineTsuki_Item(Properties properties) {
		super(properties);
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();
		Direction direction = context.getFace();
		ItemStack stack = context.getItem();
		
		if (!playerIn.getCooldownTracker().hasCooldown(this)) {
			if (block == Kitchen_Blocks.USU_TSUKI) {
				int i = state.get(UsuTsuki.STAGE_0_15);
				
				if (direction == Direction.UP) {
					
					if (i >= 4 && i <= 14) {
						if (i >= 4 && i <= 6) { //volume, pitch
							iworld.playSound(playerIn, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F); }
			
						if (i >= 7 && i <= 14) {
							iworld.playSound(playerIn, pos, SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, SoundCategory.BLOCKS, 0.8F, 1.1F);
							iworld.playSound(playerIn, pos, SoundEvents.BLOCK_SLIME_BLOCK_STEP, SoundCategory.BLOCKS, 0.1F, 0.8F); }

						iworld.setBlockState(pos, Kitchen_Blocks.USU_TSUKI.getDefaultState().with(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
						stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
						playerIn.getCooldownTracker().setCooldown(this, 10); }
					
					else { }
				}
				
				if (direction != Direction.UP) { iworld.playSound(playerIn, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.8F); }

				return ActionResultType.SUCCESS;
			}
		}

		return ActionResultType.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.OAK_LOG;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_usutsuki").applyTextStyle(TextFormatting.GRAY));
	}
}
