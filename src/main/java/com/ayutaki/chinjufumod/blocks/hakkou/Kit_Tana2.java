package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

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

public class Kit_Tana2 extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_WEST = Block.box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);

	public Kit_Tana2(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item == Items_Teatime.NAMASAKEBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_SAKENAMA.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.SAKEBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_SAKE.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUSAKEBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_SAKEJUKU.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.CIDERBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_CIDER.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUCIDERBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_CIDERJUKU.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.WINEBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_WINE.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUWINEBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_WINEJUKU.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.MEADBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_MEAD.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUMEADBOT.get()) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlock(pos, Hakkou_Blocks.KIT_MEADJUKU.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item != Items_Teatime.NAMASAKEBOT.get() && item != Items_Teatime.SAKEBOT.get() && item != Items_Teatime.JUKUSAKEBOT.get() &&
				item != Items_Teatime.CIDERBOT.get() && item != Items_Teatime.JUKUCIDERBOT.get() &&
				item != Items_Teatime.WINEBOT.get() && item != Items_Teatime.JUKUWINEBOT.get() &&
				item != Items_Teatime.MEADBOT.get() && item != Items_Teatime.JUKUMEADBOT.get()) {
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
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.WINE_TANA.get());
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kit2_tana").withStyle(ChatFormatting.GRAY));
	}
}
