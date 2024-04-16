package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SushiSet extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 5.0D, 14.0D, 3.0D, 12.5D);
	protected static final VoxelShape AABB_WEST = Block.box(3.5D, 0.0D, 0.0D, 11.0D, 3.0D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(2.0D, 0.0D, 3.5D, 16.0D, 3.0D, 11.0D);
	protected static final VoxelShape AABB_EAST = Block.box(5.0D, 0.0D, 2.0D, 12.5D, 3.0D, 16.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(0.0D, -8.0D, 5.0D, 14.0D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_WEST = Block.box(3.5D, -8.0D, 0.0D, 11.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(2.0D, -8.0D, 3.5D, 16.0D, 0.1D, 11.0D);
	protected static final VoxelShape DOWN_EAST = Block.box(5.0D, -8.0D, 2.0D, 12.5D, 0.1D, 16.0D);
	
	public SushiSet(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_5);

		if (i != 5) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);	
				if (i == 1) {
					if (this == Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_S.get())); }
					if (this != Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(this.takeSushi()); } }
	
				if (i == 2) {
					if (this == Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_F.get())); }
					if (this != Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(this.takeSushi()); } }
	
				if (i == 3) {
					if (this == Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_B.get())); }
					if (this != Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(this.takeSushi()); } }
	
				if (i == 4) {
					if (this == Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_T.get())); }
					if (this != Dish_Blocks.SUSHISET_4shoku.get()) { playerIn.getInventory().add(this.takeSushi()); } }
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	private ItemStack takeSushi() {
		if (this == Dish_Blocks.SUSHISET_salmon.get()) { return new ItemStack(Items_Teatime.SHOUYUSUSHI_S.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_fish.get()) { return new ItemStack(Items_Teatime.SHOUYUSUSHI_F.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_beef.get()) { return new ItemStack(Items_Teatime.SHOUYUSUSHI_B.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_tamago.get()) { return new ItemStack(Items_Teatime.SHOUYUSUSHI_T.get(), 1); }
		return null;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_5);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(5)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 5) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case NORTH:
		default:
			return flag? AABB_NORTH : DOWN_NORTH;
		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;
		case WEST:
			return flag? AABB_WEST : DOWN_WEST;
		case EAST:
			return flag? AABB_EAST : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.SUSHISET_4shoku.get()) { return new ItemStack(Items_Teatime.SUSHISET_4shoku.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_salmon.get()) { return new ItemStack(Items_Teatime.SUSHISET_salmon.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_fish.get()) { return new ItemStack(Items_Teatime.SUSHISET_fish.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_beef.get()) { return new ItemStack(Items_Teatime.SUSHISET_beef.get(), 1); }
		if (this == Dish_Blocks.SUSHISET_tamago.get()) { return new ItemStack(Items_Teatime.SUSHISET_tamago.get(), 1); }
		return null;
	}
}
