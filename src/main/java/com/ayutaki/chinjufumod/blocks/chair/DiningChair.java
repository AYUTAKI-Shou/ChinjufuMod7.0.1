package com.ayutaki.chinjufumod.blocks.chair;

import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DiningChair extends BaseDoubleChair {

	/* Collision */
	protected static final VoxelShape BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 9.0D, 14.0D);

	protected static final VoxelShape BOT_SOUTH = Shapes.or(BASE, Block.box(2.0D, 9.0D, 2.0D, 14.0D, 16.0D, 3.0D));
	protected static final VoxelShape BOT_WEST = Shapes.or(BASE, Block.box(13.0D, 9.0D, 2.0D, 14.0D, 16.0D, 14.0D));
	protected static final VoxelShape BOT_NORTH = Shapes.or(BASE, Block.box(2.0D, 9.0D, 13.0D, 14.0D, 16.0D, 14.0D));
	protected static final VoxelShape BOT_EAST = Shapes.or(BASE, Block.box(2.0D, 9.0D, 2.0D, 3.0D, 16.0D, 14.0D));

	protected static final VoxelShape TOP_SOUTH = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 3.0D);
	protected static final VoxelShape TOP_WEST = Block.box(13.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
	protected static final VoxelShape TOP_NORTH = Block.box(2.0D, 0.0D, 13.0D, 14.0D, 4.0D, 14.0D);
	protected static final VoxelShape TOP_EAST = Block.box(2.0D, 0.0D, 2.0D, 3.0D, 4.0D, 14.0D);

	public DiningChair(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {

		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			CMEvents.soundSitChair(worldIn, pos);
			return SitableEntity.create(worldIn, pos, 0.35, playerIn);
		}
		return InteractionResult.PASS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		
		switch (half) {
		case LOWER:
		default:
			
			switch (direction) {
			case NORTH:
			default: return BOT_NORTH;
			case SOUTH: return BOT_SOUTH;
			case EAST: return BOT_EAST;
			case WEST: return BOT_WEST;
			} // switch

		case UPPER:
			
			switch (direction) {
			case NORTH:
			default: return TOP_NORTH;
			case SOUTH: return TOP_SOUTH;
			case EAST: return TOP_EAST;
			case WEST: return TOP_WEST;
			} // switch
		} // switch LOWER-UPPER
	}
}
