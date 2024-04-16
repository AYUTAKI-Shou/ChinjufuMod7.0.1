package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
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

public class ShouyuSara_1 extends BaseFood_Stage9Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(6.0D, 0.0D, 9.0D, 10.0D, 0.5D, 13.0D);
	protected static final VoxelShape AABB_WEST = Block.box(3.0D, 0.0D, 6.0D, 7.0D, 0.5D, 10.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(6.0D, 0.0D, 3.0D, 10.0D, 0.5D, 7.0D);
	protected static final VoxelShape AABB_EAST = Block.box(9.0D, 0.0D, 6.0D, 13.0D, 0.5D, 10.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(6.0D, -8.0D, 9.0D, 10.0D, 0.1D, 13.0D);
	protected static final VoxelShape DOWN_WEST = Block.box(3.0D, -8.0D, 6.0D, 7.0D, 0.1D, 10.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(6.0D, -8.0D, 3.0D, 10.0D, 0.1D, 7.0D);
	protected static final VoxelShape DOWN_EAST = Block.box(9.0D, -8.0D, 6.0D, 13.0D, 0.1D, 10.0D);
	
	public ShouyuSara_1(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_9);
		boolean sushi = (item == Items_Teatime.SUSHI_S.get() || item == Items_Teatime.SUSHI_F.get() || item == Items_Teatime.SUSHI_B.get() || item == Items_Teatime.SUSHI_T.get());
		boolean shouyu = (item == Items_Teatime.SHOUYU_bot_1.get() || item == Items_NoTab.SHOUYU_bot_2.get() || item == Items_NoTab.SHOUYU_bot_3.get() || item == Items_NoTab.SHOUYU_bot_4.get());

		if (!state.getValue(WATERLOGGED)) {
			
			/** Not empty **/
			if (i != 9) {
				if (sushi) {
					if (item == Items_Teatime.SUSHI_S.get()) {
						/** Collect with an Item **/
						CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
						
						if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_S.get(), 1)); }
						else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_S.get(), 1))) {
							playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_S.get(), 1), false); } }
					
					if (item == Items_Teatime.SUSHI_F.get()) {
						/** Collect with an Item **/
						CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
						
						if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_F.get(), 1)); }
						else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_F.get(), 1))) {
							playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_F.get(), 1), false); } }
					
					if (item == Items_Teatime.SUSHI_B.get()) {
						/** Collect with an Item **/
						CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
						
						if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_B.get(), 1)); }
						else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_B.get(), 1))) {
							playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_B.get(), 1), false); } }
					
					if (item == Items_Teatime.SUSHI_T.get()) {
						/** Collect with an Item **/
						CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
						
						if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_T.get(), 1)); }
						else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYUSUSHI_T.get(), 1))) {
							playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_T.get(), 1), false); } }
		
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }
				
				if (!sushi) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		
			/** Empty **/
			if (i == 9) {
				if (shouyu) {
					if (item == Items_Teatime.SHOUYU_bot_1.get()) { CMEvents.SoysauceTo2(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_2.get()) { CMEvents.SoysauceTo3(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_3.get()) { CMEvents.SoysauceTo4(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_4.get()) { CMEvents.SoysauceToBottle(worldIn, pos, playerIn, hand); }
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
				
				if (!shouyu) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
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
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(9)), 3); }
			
			else { } }
		
		if (i == 9) { }
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
		return new ItemStack(Items_Teatime.SHOUYUSARA_1.get(), 1);
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_food_shouyusara_1").withStyle(ChatFormatting.GRAY));
	}
}
