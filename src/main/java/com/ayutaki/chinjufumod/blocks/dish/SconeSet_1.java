package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage8_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
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

public class SconeSet_1 extends BaseStage8_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.5D, 13.0D);
	
	public SconeSet_1(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_8);

		/** Hand is empty. **/
		if (stack.isEmpty()) {

			CMEvents.soundTake_Pick(worldIn, pos);

			if (i != 8) {
				if (i == 1) { playerIn.getInventory().add(new ItemStack(Items_Teatime.EGGSAND.get())); }
				if (i == 2) { playerIn.getInventory().add(new ItemStack(Items_Teatime.CHICKENSAND.get())); }
				if (i == 3) { playerIn.getInventory().add(new ItemStack(Items_Teatime.EGGSAND.get())); }
				if (i == 4) { playerIn.getInventory().add(new ItemStack(Items_Teatime.CHICKENSAND.get())); }

				if (i == 5) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SCONE.get())); }
				if (i == 6) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SCONE.get())); }
				if (i == 7) { playerIn.getInventory().add(new ItemStack(Items_Teatime.CAKE.get())); }

				worldIn.setBlock(pos, state.setValue(STAGE_1_8, Integer.valueOf(i + 1)), 3); }

			if (i == 8) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.CAKE.get()));

				worldIn.setBlock(pos, Dish_Blocks.SCONESET_kara.get().defaultBlockState()
						.setValue(BaseFacingWater.H_FACING, state.getValue(H_FACING)), 3); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, this, 60);
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.SCONESET_kara.get().defaultBlockState()
					.setValue(SconeSet_kara.H_FACING, state.getValue(H_FACING))
					.setValue(SconeSet_kara.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}

	protected void dropRottenfood(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get());
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SCONESET_1.get(), 1);
	}
}
