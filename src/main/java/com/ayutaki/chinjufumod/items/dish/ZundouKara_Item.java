package com.ayutaki.chinjufumod.items.dish;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ZundouKara_Item extends ItemNameBlockItem {

	public ZundouKara_Item(Block block, Item.Properties properties) {
		super(block, properties);
	}

	/* Get the MIZUOKE_Milk. ShearsItem, CowEntity */
	@SuppressWarnings("resource")
	@Override
	public net.minecraft.world.InteractionResult interactLivingEntity(ItemStack stack, net.minecraft.world.entity.player.Player playerIn, LivingEntity entity, net.minecraft.world.InteractionHand hand) {
		boolean mode = playerIn.getAbilities().instabuild;

		if (entity.level().isClientSide) return InteractionResult.PASS;

		if (stack.getItem() == Items_Teatime.ZUNDOU.get()) {

			if (entity instanceof Cow && !mode && !entity.isBaby()) {

				entity.playSound(SoundEvents.COW_MILK, 2.0F, 1.0F);
				if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.ZUNDOU_MILK.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.ZUNDOU_MILK.get()), false); }

				/* 消費を最後に回す */
				stack.shrink(1);
				return InteractionResult.SUCCESS; }

			if (entity instanceof Goat && !mode && !entity.isBaby()) {

				entity.playSound(SoundEvents.GOAT_MILK, 2.0F, 1.0F);
				if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.ZUNDOU_MILK.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.ZUNDOU_MILK.get()), false); }

				stack.shrink(1);
				return InteractionResult.SUCCESS; }
			
			return InteractionResult.PASS;
		}
		return InteractionResult.PASS;
	}
}
