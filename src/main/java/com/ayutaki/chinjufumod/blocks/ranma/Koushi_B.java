package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Koushi_B extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty UP = BooleanProperty.create("up");
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final IntegerProperty VER = IntegerProperty.create("ver", 1, 2);
	
	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape S1_WEST = Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape S1_EAST = Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_WEST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape S2_EAST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Koushi_B(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(UP, Boolean.valueOf(false))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(VER, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(VER), 3);
				return InteractionResult.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return InteractionResult.SUCCESS; }
		}

		return InteractionResult.PASS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(UP, this.canConnectTo(worldIn, pos, Direction.UP))
				.setValue(DOWN, this.canConnectTo(worldIn, pos, Direction.DOWN));
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Connect the blocks. */
	private boolean canConnectTo(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockState state = worldIn.getBlockState(pos.relative(direct));
		return state.getBlock() == this;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		boolean up = canConnectTo(worldIn, pos, Direction.UP);
		boolean down = canConnectTo(worldIn, pos, Direction.DOWN);
		return state.setValue(UP, up).setValue(DOWN, down);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, VER, UP, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(VER);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : S2_NORTH;
		case SOUTH:
			return (i == 1)? S1_SOUTH : S2_SOUTH;
		case WEST:
			return (i == 1)? S1_WEST : S2_WEST;
		case EAST:
			return (i == 1)? S1_EAST : S2_EAST;
		}
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(new TranslatableComponent("tips.wp_stage2").withStyle(ChatFormatting.GRAY));
	}
}
