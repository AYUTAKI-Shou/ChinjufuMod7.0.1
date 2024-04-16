package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.Half;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class BambooStairs extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<Half> TYPE = EnumProperty.create("type", Half.class);

	/* Collision */
	protected static final VoxelShape BOT_BASE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = VoxelShapes.or(BOT_BASE, Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape BOT_WEST = VoxelShapes.or(BOT_BASE, Block.makeCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = VoxelShapes.or(BOT_BASE, Block.makeCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_EAST = VoxelShapes.or(BOT_BASE, Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape TOP_BASE = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TOP_SOUTH = VoxelShapes.or(TOP_BASE, Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
	protected static final VoxelShape TOP_WEST = VoxelShapes.or(TOP_BASE, Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TOP_NORTH = VoxelShapes.or(TOP_BASE, Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TOP_EAST = VoxelShapes.or(TOP_BASE, Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D));

	private final Block modelBlock;
	private final BlockState modelState;

	public BambooStairs(BlockState state, Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(TYPE, Half.BOTTOM)
				.with(WATERLOGGED, Boolean.valueOf(false)));

		this.modelState = state;
		this.modelBlock = state.getBlock();
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		BlockState blockState2 = this.getDefaultState().with(TYPE, Half.BOTTOM).with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER))
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
		Direction direction = context.getFace();

		return direction != Direction.DOWN && (direction == Direction.UP || context.getHitVec().y - (double)pos.getY() <= 0.5D) ? blockState2 : blockState2.with(TYPE, Half.TOP);
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		Half half = state.get(TYPE);
		
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
	public boolean isTransparent(BlockState state) {
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		this.modelBlock.animateTick(stateIn, worldIn, pos, rand);
	}

	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn) {
		this.modelState.onBlockClicked(worldIn, pos, playerIn);
	}

	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		this.modelBlock.onPlayerDestroy(worldIn, pos, state);
	}

	@SuppressWarnings("deprecation")
	public float getExplosionResistance() {
		return this.modelBlock.getExplosionResistance();
	}

	public int tickRate(IWorldReader worldIn) {
		return this.modelBlock.tickRate(worldIn);
	}

	@SuppressWarnings("deprecation")
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (state.getBlock() != state.getBlock()) {
			this.modelState.neighborChanged(worldIn, pos, Blocks.AIR, pos, false);
			this.modelBlock.onBlockAdded(this.modelState, worldIn, pos, oldState, false);
		}
	}

	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			this.modelState.onReplaced(worldIn, pos, newState, isMoving);
		}
	}

	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		this.modelBlock.onEntityWalk(worldIn, pos, entityIn);
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		this.modelBlock.tick(state, worldIn, pos, rand);
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hit) {
		return this.modelState.onBlockActivated(worldIn, playerIn, handIn, hit);
	}

	public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
		this.modelBlock.onExplosionDestroy(worldIn, pos, explosionIn);
	}
	
	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
