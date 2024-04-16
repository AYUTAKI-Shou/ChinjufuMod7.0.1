package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Bot_Nyusan extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(1.5D, 0.0, 1.5D, 6.5D, 7.0D, 6.5D);
	protected static final VoxelShape AABB_WEST = Block.box(9.5D, 0.0, 1.5D, 14.5D, 7.0D, 6.5D);
	protected static final VoxelShape AABB_NORTH = Block.box(9.5D, 0.0, 9.5D, 14.5D, 7.0D, 14.5D);
	protected static final VoxelShape AABB_EAST = Block.box(1.5D, 0.0, 9.5D, 6.5D, 7.0D, 14.5D);
	
	public Bot_Nyusan(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {

		if (!worldIn.isLoaded(pos)) return;

		int i = state.getValue(STAGE_1_4);

		if (i < 4 && rand.nextInt(4) == 0) {
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

		else { }
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
		}
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return true;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_bin_nyusan").withStyle(ChatFormatting.GRAY));
	}
}
