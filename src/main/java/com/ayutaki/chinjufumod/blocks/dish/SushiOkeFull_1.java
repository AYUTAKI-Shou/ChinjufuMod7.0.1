package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
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

public class SushiOkeFull_1 extends BaseFood_Stage9Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.5D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(0.0D, -8.0D, 0.0D, 16.0D, -0.1D, 16.0D);
	
	protected static final VoxelShape AABB9_BOX = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.5D, 15.0D);
	protected static final VoxelShape AABB9_DOWN = Block.box(1.0D, -8.0D, 1.0D, 15.0D, 0.1D, 15.0D);
	
	public SushiOkeFull_1(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_9);

		/** Hand is empty. **/
		if (stack.isEmpty()) {
			
			CMEvents.soundTake_Pick(worldIn, pos);	
			if (i < 8) {
				if (i == 1) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_S.get())); }
				if (i == 2) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_F.get())); }
				if (i == 3) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_B.get())); }
				if (i == 4) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_T.get())); }

				if (i == 5) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_S.get())); }
				if (i == 6) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_F.get())); }
				if (i == 7) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_B.get())); }

				worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }

			if (i == 8) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.SUSHI_T.get()));

				worldIn.setBlock(pos, Dish_Blocks.SUSHIOKE_FULL_9.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
			
			if (i == 9) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_9);
		
		if (i != 9) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, Dish_Blocks.SUSHIOKE_FULL_9.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(SushiOkeFull_9.STAGE_1_9, Integer.valueOf(9))
						.setValue(SushiOkeFull_9.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }

		if (i == 9) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		int i = state.getValue(STAGE_1_9);

		if (i == 9) { return flag? AABB9_BOX : AABB9_DOWN; }
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SUSHIOKE_FULL_1.get());
	}
}
