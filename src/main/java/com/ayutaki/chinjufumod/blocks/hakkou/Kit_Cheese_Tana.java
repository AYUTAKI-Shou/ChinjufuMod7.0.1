package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Kit_Cheese_Tana extends BaseStage3_FaceWater {

	protected static final int COOK_TIME = 12000;
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_WEST = Block.box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);

	/* stage1=OOO, stage2=OOA, stage3=OOB */
	public Kit_Cheese_Tana(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int i = state.getValue(STAGE_1_3);

		/** Hand is empty. **/
		if (stack.isEmpty() && item != Items_Teatime.CHEESE_CURD.get() && item != Items_Teatime.CHEESE.get()) {
			
			/** stage1=OOO **/
			if (i == 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			/** stage2=OOA **/
			if (i == 2) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.getInventory().add(new ItemStack(Items_Teatime.CHEESE_CURD.get()));

				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		
			/** stage3=OOB **/
			if (i == 3) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.getInventory().add(new ItemStack(Items_Teatime.CHEESE.get()));

				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		}
		
		/** Hand is not empty. **/
		if (!stack.isEmpty()) {
			
			if (item == Items_Teatime.CHEESE_CURD.get()) {
				if (i == 1) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(2)), 3); } /* -> OOA */

				if (i == 2) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Hakkou_Blocks.CHEESE_OAA.get().defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* -> OAA */
				
				if (i == 3) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Hakkou_Blocks.CHEESE_OAA.get().defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(2))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* -> OBA */
			}
			
			if (item == Items_Teatime.CHEESE.get()) {
				if (i == 1) {
					CMEvents.Consume1Item_Cheese(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3); } /* -> OOB */
				
				if (i == 2) {
					CMEvents.Consume1Item_Cheese(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Hakkou_Blocks.CHEESE_OAA.get().defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(2))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* -> OBA */
				
				if (i == 3) {
					CMEvents.Consume1Item_Cheese(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Hakkou_Blocks.CHEESE_OAA.get().defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(3))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* -> OBB */
			}
			
			if (item != Items_Teatime.CHEESE_CURD.get() && item != Items_Teatime.CHEESE.get()) { CMEvents.textFullItem(worldIn, pos, playerIn); }	
		}

		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	protected static boolean hasWater(LevelReader worldIn, BlockPos pos) {
		for(BlockPos nearPos : BlockPos.betweenClosed(pos.offset(-2, -2, -2), pos.offset(2, 2, 2))) {
			if (worldIn.getFluidState(nearPos).is(FluidTags.WATER)) {
				return true;
			}
		}
		return false;
	}
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Hakkou_Blocks.CHEESE_TANA.get(), COOK_TIME + (100 * worldIn.getRandom().nextInt(5))); }
		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Hakkou_Blocks.CHEESE_TANA.get(), 100); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Hakkou_Blocks.CHEESE_TANA.get(), COOK_TIME + (100 * worldIn.getRandom().nextInt(5))); }
		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Hakkou_Blocks.CHEESE_TANA.get(), 100); }
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		/* stage1=OOO, stage2=OOA, stage3=OOB */
		int i = state.getValue(STAGE_1_3);

		if (inWater(state, worldIn, pos)) {
			if (i != 1) {
				worldIn.scheduleTick(pos, Hakkou_Blocks.CHEESE_TANA.get(), 100);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			if (i == 1) { }
		}

		if (!inWater(state, worldIn, pos)) { 
			if (i == 2 && !hasWater(worldIn, pos)) {
				worldIn.scheduleTick(pos, Hakkou_Blocks.CHEESE_TANA.get(), COOK_TIME + (100 * rand.nextInt(5)));
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
			
			else { } }
	}
	
	protected void dropRottenfood(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get());
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
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
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.CHEESE_TANA.get());
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kit_cheese_tana").withStyle(ChatFormatting.GRAY));
	}
}
