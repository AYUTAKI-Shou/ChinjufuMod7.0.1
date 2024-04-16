package com.ayutaki.chinjufumod.blocks.hakkou;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(1.0D, 14.0D, 1.0D, 15.0D, 16.0D, 15.0D),
			Block.box(0.5D, 12.0D, 0.5D, 15.5D, 14.0D, 15.5D),
			Block.box(0.0D, 4.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.5D, 2.0D, 0.5D, 15.5D, 4.0D, 15.5D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D));

	protected static final VoxelShape AABB_X = VoxelShapes.or(Block.box(0.0D, 1.0D, 1.0D, 2.0D, 15.0D, 15.0D),
			Block.box(2.0D, 0.5D, 0.5D, 4.0D, 15.5D, 15.5D),
			Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D),
			Block.box(12.0D, 0.5D, 0.5D, 14.0D, 15.5D, 15.5D),
			Block.box(14.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D));

	protected static final VoxelShape AABB_Z = VoxelShapes.or(Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 2.0D),
			Block.box(0.5D, 0.5D, 2.0D, 15.5D, 15.5D, 4.0D),
			Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D),
			Block.box(0.5D, 0.5D, 12.0D, 15.5D, 15.5D, 14.0D),
			Block.box(1.0D, 1.0D, 14.0D, 15.0D, 15.0D, 16.0D));

	public BaseTaru_Yoh(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y)
				.setValue(STAGE_1_6, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis())
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
			if (!worldIn.isClientSide()) {
				worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
				worldIn.getLiquidTicks().scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
			return true;
		}
		else { return false; }
	}

	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		else { return Fluids.EMPTY; }
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AXIS, STAGE_1_6, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction.Axis)state.getValue(AXIS)) {
		case X:
			return AABB_X;
		case Z:
			return AABB_Z;
		case Y:
		default:
			return AABB_BOX;
		}
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
