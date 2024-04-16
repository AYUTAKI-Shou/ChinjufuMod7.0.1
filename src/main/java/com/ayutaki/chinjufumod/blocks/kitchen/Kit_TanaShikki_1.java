package com.ayutaki.chinjufumod.blocks.kitchen;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Kit_TanaShikki_1 extends Base_Tana6 {

	public Kit_TanaShikki_1(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_6);

		if (item != Items_Teatime.SHIKKI.get()) {
			if (stack.isEmpty()) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.SHIKKI.get()));
				CMEvents.soundItemPick(worldIn, pos);

				if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i - 1)), 3); }
				if (i == 1) { worldIn.setBlock(pos, Kitchen_Blocks.KIT_TANA.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)), 3); } }

			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.SHIKKI.get()) {
			if (i != 6) {
				CMEvents.Consume1Item_WDish(worldIn, pos, playerIn, hand);;
				worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i + 1)), 3); }
			
			if (i == 6) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
}
