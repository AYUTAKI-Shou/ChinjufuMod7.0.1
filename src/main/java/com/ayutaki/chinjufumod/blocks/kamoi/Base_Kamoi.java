package com.ayutaki.chinjufumod.blocks.kamoi;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Base_Kamoi extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape TOP = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape WEST_2 = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape NORTH_2 = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape EAST_2 = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH_3 = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape WEST_3 = Shapes.or(Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape NORTH_3 = Shapes.or(Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EAST_3 = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));

	public Base_Kamoi(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_4);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? BOTTOM : ((i == 2)? NORTH_2 : ((i == 3)? NORTH_3 : TOP));
		case SOUTH:
			return (i == 1)? BOTTOM : ((i == 2)? SOUTH_2 : ((i == 3)? SOUTH_3 : TOP));
		case WEST:
			return (i == 1)? BOTTOM : ((i == 2)? WEST_2 : ((i == 3)? WEST_3 : TOP));
		case EAST:
			return (i == 1)? BOTTOM : ((i == 2)? EAST_2 : ((i == 3)? EAST_3 : TOP));
		}
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.wp_stage4").withStyle(ChatFormatting.GRAY));
	}
}
