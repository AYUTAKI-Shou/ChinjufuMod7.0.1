package com.ayutaki.chinjufumod.blocks.kitchen;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class Kit_TanaShikki_1 extends Base_Tana6 {

	public Kit_TanaShikki_1(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_6);

		if (item != Items_Teatime.SHIKKI) {
			if (stack.isEmpty()) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.SHIKKI));
				CMEvents.soundItemPick(worldIn, pos);

				if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i - 1)), 3); }
				if (i == 1) { worldIn.setBlock(pos, Kitchen_Blocks.KIT_TANA.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)), 3); } }

			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.SHIKKI) {
			if (i != 6) {
				CMEvents.Consume1Item_WDish(worldIn, pos, playerIn, hand);	
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i + 1)), 3); }
			
			if (i == 6) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
