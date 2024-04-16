package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SushiGeta_kara1_5 extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(1.0D, 0.0D, 7.0D, 14.0D, 1.5D, 12.5D);
	protected static final VoxelShape AABB_WEST = Block.box(3.5D, 0.0D, 1.0D, 9.0D, 1.5D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(2.0D, 0.0D, 3.5D, 15.0D, 1.5D, 9.0D);
	protected static final VoxelShape AABB_EAST = Block.box(7.0D, 0.0D, 2.0D, 12.5D, 1.5D, 15.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(1.0D, -8.0D, 7.0D, 14.0D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_WEST = Block.box(3.5D, -8.0D, 1.0D, 9.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(2.0D, -8.0D, 3.5D, 15.0D, 0.1D, 9.0D);
	protected static final VoxelShape DOWN_EAST = Block.box(7.0D, -8.0D, 2.0D, 12.5D, 0.1D, 15.0D);
	
	public SushiGeta_kara1_5(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_5);
		boolean sushi = (item == Items_Teatime.SUSHI_S.get() || item == Items_Teatime.SUSHI_F.get() || item == Items_Teatime.SUSHI_B.get() || item == Items_Teatime.SUSHI_T.get());
		boolean shouyu = (item == Items_Teatime.SHOUYU_bot_1.get() || item == Items_NoTab.SHOUYU_bot_2.get() || item == Items_NoTab.SHOUYU_bot_3.get() || item == Items_NoTab.SHOUYU_bot_4.get());

		if (!state.getValue(WATERLOGGED)) {
			
			/** Soy sauce is empty **/
			if (i == 1) {
				if (shouyu) {
					if (item == Items_Teatime.SHOUYU_bot_1.get()) { CMEvents.SoysauceTo2(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_2.get()) { CMEvents.SoysauceTo3(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_3.get()) { CMEvents.SoysauceTo4(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_4.get()) { CMEvents.SoysauceToBottle(worldIn, pos, playerIn, hand); }
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(2)), 3); }
				
				if (!shouyu) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
			
			/** Soy sauce is not empty **/
			if (i != 1) {
				if (item == Items_Teatime.SUSHI_S.get()) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Dish_Blocks.SUSHIGETA_salmon.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(DOWN, state.getValue(DOWN))
							.setValue(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				
				if (item == Items_Teatime.SUSHI_F.get()) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Dish_Blocks.SUSHIGETA_fish.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(DOWN, state.getValue(DOWN))
							.setValue(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				
				if (item == Items_Teatime.SUSHI_B.get()) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Dish_Blocks.SUSHIGETA_beef.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(DOWN, state.getValue(DOWN))
							.setValue(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				
				if (item == Items_Teatime.SUSHI_T.get()) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlock(pos, Dish_Blocks.SUSHIGETA_tamago.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(DOWN, state.getValue(DOWN))
							.setValue(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
				
				if (!sushi) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_5);
		
		if (i != 1) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(1)), 3); }
		
			else { } }
		
		if (i == 1) { }
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
		return new ItemStack(Items_Teatime.SUSHIGETA_kara.get());
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_food_sushigeta_kara").withStyle(ChatFormatting.GRAY));
	}
}
