package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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

public class Kit_Tana extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape AABB_WEST = Block.box(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public Kit_Tana(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item == Items_Teatime.SARA.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SARA1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.TONSUI.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_TONSUI1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.YUNOMI.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_YUNOMI1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana7.STAGE_1_7, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.TCUP_kara.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_TCUP1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana7.STAGE_1_7, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.CHAWAN.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_CHAWAN1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.SHIKKI.get()) {
			CMEvents.Consume1Item_WDish(worldIn, pos, playerIn, hand);		
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SHIKKI1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.DRINKGLASS.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_DRINKGLASS1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana9.STAGE_1_9, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.DONBURI.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_DONBURI1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana4.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.SUSHIGETA_kara.get()) {
			CMEvents.Consume1Item_WDish(worldIn, pos, playerIn, hand);		
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SUSHIGETA1.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana4.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item != Items_Teatime.SARA.get() && item != Items_Teatime.TONSUI.get() && item != Items_Teatime.YUNOMI.get() &&
				item != Items_Teatime.TCUP_kara.get() && item != Items_Teatime.CHAWAN.get() && item != Items_Teatime.SHIKKI.get() &&
				item != Items_Teatime.DRINKGLASS.get() && item != Items_Teatime.DONBURI.get() && item != Items_Teatime.SUSHIGETA_kara.get()) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	
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

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kit_tana").withStyle(ChatFormatting.GRAY));
	}
}
