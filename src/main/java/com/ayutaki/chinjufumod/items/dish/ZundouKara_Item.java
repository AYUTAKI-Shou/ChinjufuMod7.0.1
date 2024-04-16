package com.ayutaki.chinjufumod.items.dish;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;

/* BucketItem を参照。extends は BlockNamedItem とする */
public class ZundouKara_Item extends BlockNamedItem {

	public ZundouKara_Item(Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.TEATIME));
	}

	/* 水を入れる ItemBucket 淡水を使う為、ヤカンと寸胴は適用外 */

	/* 牛乳を汲む ShearsItem, CowEntity */
	@Override
	public net.minecraft.util.ActionResultType interactLivingEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand handIn) {

		boolean mode = playerIn.abilities.instabuild;

		if (entity.level.isClientSide) return net.minecraft.util.ActionResultType.PASS;

		if (stack.getItem() == Items_Teatime.ZUNDOU) {

			if (entity instanceof CowEntity && !mode && !entity.isBaby()) {

				entity.playSound(SoundEvents.COW_MILK, 2.0F, 1.0F);

				if (!playerIn.inventory.add(new ItemStack(Items_Teatime.ZUNDOU_MILK))) {
					playerIn.drop(new ItemStack(Items_Teatime.ZUNDOU_MILK), false); }

				/* 消費を最後に回す */
				stack.shrink(1);
				return net.minecraft.util.ActionResultType.SUCCESS;
			}

			return net.minecraft.util.ActionResultType.PASS;
		}
		return net.minecraft.util.ActionResultType.PASS;
	}
}
