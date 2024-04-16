package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Wadaiko_Small extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape BOT_SOUTH = Block.box(4.0D, 1.0D, 4.0D, 12.0D, 6.5D, 13.0D);
	protected static final VoxelShape BOT_WEST = Block.box(3.0D, 1.0D, 4.0D, 12.0D, 6.5D, 12.0D);
	protected static final VoxelShape BOT_NORTH = Block.box(4.0D, 1.0D, 3.0D, 12.0D, 6.5D, 12.0D);
	protected static final VoxelShape BOT_EAST = Block.box(4.0D, 1.0D, 4.0D, 13.0D, 6.5D, 12.0D);

	protected static final VoxelShape BOT2_SOUTH = Block.box(4.0D, 11.0D, 4.0D, 12.0D, 16.0D, 13.0D);
	protected static final VoxelShape BOT2_WEST = Block.box(3.0D, 11.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape BOT2_NORTH = Block.box(4.0D, 11.0D, 3.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape BOT2_EAST = Block.box(4.0D, 11.0D, 4.0D, 13.0D, 16.0D, 12.0D);

	public Wadaiko_Small(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (!playerIn.isCrouching()) {
			if (hit.getDirection() == Direction.UP) {
				if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 0.8F, 1.4F); }
				else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.4F); } }

			if (hit.getDirection() != Direction.UP) {
				if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 0.8F, 1.3F); }
				else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.3F); } }
		}

		if (playerIn.isCrouching()) {
			if (stack.isEmpty()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_2), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Player playerIn = context.getPlayer();
		
		if (playerIn.isCrouching()) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(STAGE_1_2, Integer.valueOf(2)); }

		else { return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(STAGE_1_2, Integer.valueOf(1)); }
	}
		
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_2);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? BOT_NORTH : BOT2_NORTH;
		case SOUTH:
			return (i == 1)? BOT_SOUTH : BOT2_SOUTH;
		case WEST:
			return (i == 1)? BOT_WEST : BOT2_WEST;
		case EAST:
			return (i == 1)? BOT_EAST : BOT2_EAST;
		}
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_wadaiko").withStyle(ChatFormatting.GRAY));
	}
}
