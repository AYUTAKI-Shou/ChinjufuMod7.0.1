package com.ayutaki.chinjufumod.blocks.jpdeco;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BambooStairs extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<Half> TYPE = EnumProperty.create("type", Half.class);
	
	/* Collision */
	protected static final VoxelShape BOT_BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = Shapes.or(BOT_BASE, Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape BOT_WEST = Shapes.or(BOT_BASE, Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = Shapes.or(BOT_BASE, Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_EAST = Shapes.or(BOT_BASE, Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape TOP_BASE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TOP_SOUTH = Shapes.or(TOP_BASE, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
	protected static final VoxelShape TOP_WEST = Shapes.or(TOP_BASE, Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TOP_NORTH = Shapes.or(TOP_BASE, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TOP_EAST = Shapes.or(TOP_BASE, Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D));
	
	private final Block base;
	private final BlockState baseState;
	
	public BambooStairs(BlockState state, BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(TYPE, Half.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));

		this.baseState = state;
		this.base = state.getBlock();
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		BlockState blockState2 = this.defaultBlockState().setValue(TYPE, Half.BOTTOM).setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
		Direction direction = context.getClickedFace();

		return direction != Direction.DOWN && (direction == Direction.UP || context.getClickLocation().y - (double)pos.getY() <= 0.5D) ? blockState2 : blockState2.setValue(TYPE, Half.TOP);
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
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	@Override
	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		switch (type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).is(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		Half half = state.getValue(TYPE);
		
		switch (half) {
		case BOTTOM :
		default:
			
			switch (direction) {
			case NORTH:
			default: return BOT_NORTH;
			case SOUTH: return BOT_SOUTH;
			case EAST: return BOT_EAST;
			case WEST: return BOT_WEST;
			} // switch

		case TOP :
			
			switch (direction) {
			case NORTH:
			default: return TOP_NORTH;
			case SOUTH: return TOP_SOUTH;
			case EAST: return TOP_EAST;
			case WEST: return TOP_WEST;
			} // switch
		} // switch LOWER-UPPER
	}
	
	/* from StairsBlock */
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
		this.base.animateTick(stateIn, worldIn, pos, rand);
	}

	public void attack(BlockState state, Level worldIn, BlockPos pos, Player playerIn) {
		this.baseState.attack(worldIn, pos, playerIn);
	}

	public void destroy(LevelAccessor worldIn, BlockPos pos, BlockState state) {
		this.base.destroy(worldIn, pos, state);
	}

	@SuppressWarnings("deprecation")
	public float getExplosionResistance() {
		return this.base.getExplosionResistance();
	}

	@SuppressWarnings("deprecation")
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (state.getBlock() != state.getBlock()) {
			this.baseState.neighborChanged(worldIn, pos, Blocks.AIR, pos, false);
			this.base.onPlace(this.baseState, worldIn, pos, oldState, false);
		}
	}

	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			this.baseState.onRemove(worldIn, pos, newState, isMoving);
		}
	}

	public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
		this.base.stepOn(worldIn, pos, state, entityIn);
	}

	public boolean isRandomlyTicking(BlockState state) {
		return this.base.isRandomlyTicking(state);
	}

	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		this.base.randomTick(state, worldIn, pos, rand);
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		this.base.tick(state, worldIn, pos, rand);
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		return this.baseState.use(worldIn, playerIn, hand, hit);
	}

	public void wasExploded(Level worldIn, BlockPos pos, Explosion expl) {
		this.base.wasExploded(worldIn, pos, expl);
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
	
}
