package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.blocks.kitchen.Base_WineTana;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class Kit_Tana2Sake extends Base_WineTana {

	public Kit_Tana2Sake(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_4);

		if (item != this.takeItem()) {
			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(this.takeItem(), 1));
				CMEvents.soundTakeSakeBottle(worldIn, pos);
	
				if (i != 1) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
				if (i == 1) { worldIn.setBlockState(pos, Hakkou_Blocks.WINE_TANA.getDefaultState().with(H_FACING, state.get(H_FACING))); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == this.takeItem()) {
			if (i != 4) {
				CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);				
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
			
			if (i == 4) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	private Item takeItem() {
		if (this == Hakkou_Blocks.KIT_SAKENAMA) { return Items_Teatime.NAMASAKEBOT; }
		if (this == Hakkou_Blocks.KIT_SAKE) { return Items_Teatime.SAKEBOT; }
		if (this == Hakkou_Blocks.KIT_SAKEJUKU) { return Items_Teatime.JUKUSAKEBOT; }
		if (this == Hakkou_Blocks.KIT_CIDER) { return Items_Teatime.CIDERBOT; }
		if (this == Hakkou_Blocks.KIT_CIDERJUKU) { return Items_Teatime.JUKUCIDERBOT; }
		if (this == Hakkou_Blocks.KIT_WINE) { return Items_Teatime.WINEBOT; }
		if (this == Hakkou_Blocks.KIT_WINEJUKU) { return Items_Teatime.JUKUWINEBOT; }
		if (this == Hakkou_Blocks.KIT_MEAD) { return Items_Teatime.MEADBOT; }
		if (this == Hakkou_Blocks.KIT_MEADJUKU) { return Items_Teatime.JUKUMEADBOT; }
		return null;
	}
}
