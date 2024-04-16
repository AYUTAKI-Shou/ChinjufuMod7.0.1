package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.garden.Base_Niwaishi;
import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemChisel extends Item {

	public ItemChisel(Properties properties) {
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

		ItemStack stack = context.getItem();
		
		if (!playerIn.getCooldownTracker().hasCooldown(this)) {
			/** Stone **/
			if (block == Blocks.STONE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.GRANITE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_gra.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.DIORITE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_dio.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.ANDESITE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_and.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			/** Slab **/
			if (block == Blocks.STONE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.GRANITE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_gra.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.DIORITE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_dio.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }

			if (block == Blocks.ANDESITE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_and.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return ActionResultType.SUCCESS; }
			

			/** Base_Niwaishi **/
			if (block instanceof Base_Niwaishi) {
				int i = state.get(Base_Niwaishi.STAGE_0_15);
				boolean mode = playerIn.abilities.isCreativeMode;
				
				if (i <= 13) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, state.with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(i + 2)), 3);
					
					stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return ActionResultType.SUCCESS; }

				if (i == 14 || i == 15) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					if (!mode) { iworld.destroyBlock(pos, true); }
					if (mode) { iworld.destroyBlock(pos, false); }
				
					stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return ActionResultType.SUCCESS; }
			}
			
			
			/** oak **/
			if (block == Blocks.OAK_LOG) {
				Direction.Axis axis = state.get(RotatedPillarBlock.AXIS);
				
				if (axis == Direction.Axis.Y) {
					CMEvents.soundChiselWood(iworld, playerIn, pos);
					iworld.setBlockState(pos, Kitchen_Blocks.USU_TSUKI.getDefaultState().with(UsuTsuki.STAGE_0_15, Integer.valueOf(0)), 3);

					stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return ActionResultType.SUCCESS; }
			}

			/** USU **/
			if (block instanceof UsuTsuki) {
				int i = state.get(UsuTsuki.STAGE_0_15);
		
				if (i <= 2) {
					CMEvents.soundChiselWood(iworld, playerIn, pos);
					iworld.setBlockState(pos, state.with(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
					
					stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return ActionResultType.SUCCESS; }
			}
		}

		return ActionResultType.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_chisel").applyTextStyle(TextFormatting.GRAY));
	}
}
