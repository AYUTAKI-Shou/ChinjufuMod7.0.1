package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
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

public class KineYoko_Item extends Item {

	public KineYoko_Item(Properties properties) {
		super(properties.durability(128).tab(ItemGroups_CM.TEATIME));
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();
		Direction direction = context.getClickedFace();
		ItemStack stack = context.getItemInHand();
		
		if (!playerIn.getCooldowns().isOnCooldown(this)) {
			
			if (block instanceof UsuTsuki) {
				int i = state.getValue(UsuTsuki.STAGE_0_15);
				
				if (direction == Direction.UP) {
					
					if (i >= 4 && i <= 14) {
						if (i >= 4 && i <= 6) { //volume, pitch
							iworld.playSound(playerIn, pos, SoundEvents.SNOW_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F); }
			
						if (i >= 7 && i <= 14) {
							iworld.playSound(playerIn, pos, SoundEvents.PLAYER_ATTACK_STRONG, SoundCategory.BLOCKS, 0.8F, 1.1F);
							iworld.playSound(playerIn, pos, SoundEvents.SLIME_JUMP, SoundCategory.BLOCKS, 0.1F, 0.8F); }

						iworld.setBlock(pos, Kitchen_Blocks.USU_TSUKI.defaultBlockState().setValue(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
						stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } ); 
						playerIn.getCooldowns().addCooldown(this, 10); }
					
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
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.OAK_LOG; }

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_usutsuki").withStyle(TextFormatting.GRAY));
	}
}
