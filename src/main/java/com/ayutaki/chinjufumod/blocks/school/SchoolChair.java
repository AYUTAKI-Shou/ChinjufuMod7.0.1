package com.ayutaki.chinjufumod.blocks.school;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SchoolChair extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D);
	
	protected static final VoxelShape AABB_SOUTH = Shapes.or(BASE, Block.box(2.0D, 7.0D, 2.0D, 14.0D, 16.0D, 4.0D));
	protected static final VoxelShape AABB_WEST = Shapes.or(BASE, Block.box(12.0D, 7.0D, 2.0D, 14.0D, 16.0D, 14.0D));
	protected static final VoxelShape AABB_NORTH = Shapes.or(BASE, Block.box(2.0D, 7.0D, 12.0D, 14.0D, 16.0D, 14.0D));
	protected static final VoxelShape AABB_EAST = Shapes.or(BASE, Block.box(2.0D, 7.0D, 2.0D, 4.0D, 16.0D, 14.0D));

	public SchoolChair(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {

		CMEvents.soundSitChair(worldIn, pos);
		return SitableEntity.create(worldIn, pos, 0.22, playerIn);
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

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_isu").withStyle(ChatFormatting.GRAY));
	}
}
