package com.ayutaki.chinjufumod.blocks.hakkou;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BaseTaru_Yoh extends RotatedPillarBlock implements IWaterLoggable {

	/* Property */
	public static final IntegerProperty STAGE_1_6 = IntegerProperty.create("stage", 1, 6);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.makeCuboidShape(1.0D, 14.0D, 1.0D, 15.0D, 16.0D, 15.0D),
			Block.makeCuboidShape(0.5D, 12.0D, 0.5D, 15.5D, 14.0D, 15.5D),
			Block.makeCuboidShape(0.0D, 4.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.5D, 2.0D, 0.5D, 15.5D, 4.0D, 15.5D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D));

	protected static final VoxelShape AABB_X = VoxelShapes.or(Block.makeCuboidShape(0.0D, 1.0D, 1.0D, 2.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(2.0D, 0.5D, 0.5D, 4.0D, 15.5D, 15.5D),
			Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(12.0D, 0.5D, 0.5D, 14.0D, 15.5D, 15.5D),
			Block.makeCuboidShape(14.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D));

	protected static final VoxelShape AABB_Z = VoxelShapes.or(Block.makeCuboidShape(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(0.5D, 0.5D, 2.0D, 15.5D, 15.5D, 4.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D),
			Block.makeCuboidShape(0.5D, 0.5D, 12.0D, 15.5D, 15.5D, 14.0D),
			Block.makeCuboidShape(1.0D, 1.0D, 14.0D, 15.0D, 15.0D, 16.0D));

	public BaseTaru_Yoh(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.Y)
				.with(STAGE_1_6, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(AXIS, context.getFace().getAxis()).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}
	
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}

	@Override
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.get(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		
		else { return Fluids.EMPTY; }
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AXIS, STAGE_1_6, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch((Direction.Axis)state.get(AXIS)) {
		case X:
			return AABB_X;
		case Z:
			return AABB_Z;
		case Y:
		default:
			return AABB_BOX;
		}
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
