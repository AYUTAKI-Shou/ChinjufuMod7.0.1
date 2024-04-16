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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Bench extends BaseSofa {

	/* Collision */
	protected static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = Shapes.or(BASE, Block.box(0.0D, 7.0D, 0.0D, 16.0D, 15.0D, 5.0D));
	protected static final VoxelShape AABB_WEST = Shapes.or(BASE, Block.box(11.0D, 7.0D, 0.0D, 16.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_NORTH = Shapes.or(BASE, Block.box(0.0D, 7.0D, 11.0D, 16.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_EAST = Shapes.or(BASE, Block.box(0.0D, 7.0D, 0.0D, 5.0D, 15.0D, 16.0D));

	public Bench(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {

		CMEvents.soundKinuzure(worldIn, pos);
		return SitableEntity.create(worldIn, pos, 0.25, playerIn);
	}

	/* Collisions for each property. */
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
}
