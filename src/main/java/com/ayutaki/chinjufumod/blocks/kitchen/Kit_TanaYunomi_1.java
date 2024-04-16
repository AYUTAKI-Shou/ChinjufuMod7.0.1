package com.ayutaki.chinjufumod.blocks.kitchen;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Kit_TanaYunomi_1 extends Base_Tana7 {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape AABB_WEST = Block.box(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public Kit_TanaYunomi_1(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_7);

		if (item != Items_Teatime.YUNOMI && item != Items_Teatime.KYUSU_kara) {
			if (stack.isEmpty()) {
				if (i != 7) {
					playerIn.inventory.add(new ItemStack(Items_Teatime.YUNOMI));
					CMEvents.soundItemPick(worldIn, pos);
					
					if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(i - 1)), 3); }
					if (i == 1) { worldIn.setBlock(pos, Kitchen_Blocks.KIT_TANA.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)), 3); } }
		
				if (i == 7) {
					playerIn.inventory.add(new ItemStack(Items_Teatime.KYUSU_kara));
					CMEvents.soundItemPick(worldIn, pos);
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(i - 1)), 3); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.YUNOMI) {
			if (i < 6) {
				CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(i + 1)), 3); }
		
			if (i >= 6) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.KYUSU_kara) {
			if (i == 6) {
				CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(i + 1)), 3); }
			
			if (i != 6) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.KIT_TANA);
	}
}
