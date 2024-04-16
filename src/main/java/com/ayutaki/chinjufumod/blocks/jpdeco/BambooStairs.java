package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
	protected static final VoxelShape BOT_BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = VoxelShapes.or(BOT_BASE, Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape BOT_WEST = VoxelShapes.or(BOT_BASE, Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = VoxelShapes.or(BOT_BASE, Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_EAST = VoxelShapes.or(BOT_BASE, Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape TOP_BASE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TOP_SOUTH = VoxelShapes.or(TOP_BASE, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
	protected static final VoxelShape TOP_WEST = VoxelShapes.or(TOP_BASE, Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TOP_NORTH = VoxelShapes.or(TOP_BASE, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TOP_EAST = VoxelShapes.or(TOP_BASE, Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D));
	
	private final Block base;
	private final BlockState baseState;

	public BambooStairs(BlockState state, Block.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(TYPE, Half.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));

		this.baseState = state;
		this.base = state.getBlock();
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		BlockState blockState2 = this.defaultBlockState().setValue(TYPE, Half.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)))
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
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return super.updateShape(stateIn, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
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
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		this.base.animateTick(stateIn, worldIn, pos, rand);
	}

	public void attack(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn) {
		this.baseState.attack(worldIn, pos, playerIn);
	}

	public void destroy(IWorld worldIn, BlockPos pos, BlockState state) {
		this.base.destroy(worldIn, pos, state);
	}

	@SuppressWarnings("deprecation")
	public float getExplosionResistance() {
		return this.base.getExplosionResistance();
	}

	@SuppressWarnings("deprecation")
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (state.getBlock() != state.getBlock()) {
			this.baseState.neighborChanged(worldIn, pos, Blocks.AIR, pos, false);
			this.base.onPlace(this.baseState, worldIn, pos, oldState, false);
		}
	}

	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			this.baseState.onRemove(worldIn, pos, newState, isMoving);
		}
	}

	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
		this.base.stepOn(worldIn, pos, entityIn);
	}

	public boolean isRandomlyTicking(BlockState state) {
		return this.base.isRandomlyTicking(state);
	}

	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		this.base.randomTick(state, worldIn, pos, rand);
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		this.base.tick(state, worldIn, pos, rand);
	}

	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hit) {
		return this.baseState.use(worldIn, playerIn, handIn, hit);
	}

	public void wasExploded(World worldIn, BlockPos pos, Explosion expl) {
		this.base.wasExploded(worldIn, pos, expl);
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }
	
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
