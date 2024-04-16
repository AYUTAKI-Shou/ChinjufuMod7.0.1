package com.ayutaki.chinjufumod.blocks.slidedoor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;

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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShoujiHalf extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE1_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSE1_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSE1_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape CLOSE1_EAST = Shapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));

	protected static final VoxelShape OPEN2_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPEN2_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D));
	protected static final VoxelShape OPEN2_NORTH = Shapes.or(FRAME_NORTH, Block.box(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D));
	protected static final VoxelShape OPEN2_EAST = Shapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D));

	protected static final VoxelShape CLOSE3_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape CLOSE3_WEST = Shapes.or(FRAME_WEST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSE3_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSE3_EAST = Shapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D));

	protected static final VoxelShape OPEN4_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D));
	protected static final VoxelShape OPEN4_WEST = Shapes.or(FRAME_WEST, Block.box(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D));
	protected static final VoxelShape OPEN4_NORTH = Shapes.or(FRAME_NORTH, Block.box(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPEN4_EAST = Shapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D));

	public ShoujiHalf(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		/** 1=Close、2=Open、3=Close、4=Open **/
		int i = state.getValue(STAGE_1_4);
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return InteractionResult.PASS; }

		else {
			if (i == 1 || i == 3) {
				CMEvents.soundFusumaS(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
			if (i == 2 || i == 4) {
				CMEvents.soundFusumaS(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
			return InteractionResult.SUCCESS;
		}
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
					.setValue(STAGE_1_4, Integer.valueOf(3)).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_4, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_4);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE1_NORTH : ((i == 2)? OPEN2_NORTH : ((i == 3)? CLOSE3_NORTH : OPEN4_NORTH));
		case SOUTH:
			return (i == 1)? CLOSE1_SOUTH : ((i == 2)? OPEN2_SOUTH : ((i == 3)? CLOSE3_SOUTH : OPEN4_SOUTH));
		case WEST:
			return (i == 1)? CLOSE1_WEST : ((i == 2)? OPEN2_WEST : ((i == 3)? CLOSE3_WEST : OPEN4_WEST));
		case EAST:
			return (i == 1)? CLOSE1_EAST : ((i == 2)? OPEN2_EAST : ((i == 3)? CLOSE3_EAST : OPEN4_EAST));
		}
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_shoujihalf").withStyle(ChatFormatting.GRAY));
	}
}
