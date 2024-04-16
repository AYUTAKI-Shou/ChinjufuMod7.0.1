package com.ayutaki.chinjufumod.blocks.school;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class StoveChimney extends CM_WaterLogged {

	/* Property */
	public static final BooleanProperty UP = BooleanProperty.create("up");
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");

	/* Collision */
	private static final VoxelShape AABB_CENTER = Block.box(5.9D, 5.9D, 5.9D, 10.1D, 10.1D, 10.1D);
	private static final VoxelShape AABB_UP = Block.box(5.9D, 10.1D, 5.9D, 10.1D, 16.0D, 10.1D);
	private static final VoxelShape AABB_DOWN = Block.box(5.9D, 0.0D, 5.9D, 10.1D, 10.1D, 10.1D);
	private static final VoxelShape AABB_NORTH = Block.box(5.9D, 5.9D, 0.0D, 10.1D, 10.1D, 5.9D);
	private static final VoxelShape AABB_EAST = Block.box(10.1D, 5.9D, 5.9D, 16.0D, 10.1D, 10.1D);
	private static final VoxelShape AABB_SOUTH = Block.box(5.9D, 5.9D, 10.1D, 10.1D, 10.1D, 16.0D);
	private static final VoxelShape AABB_WEST = Block.box(0.0D, 5.9D, 5.9D, 5.9D, 10.1D, 10.1D);

	public StoveChimney(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(UP, Boolean.valueOf(false))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction) {
		BlockState state = worldIn.getBlockState(source.relative(direction));
		return state.getBlock() == this;
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		boolean up = canConnectTo(worldIn, pos, Direction.UP);
		boolean down = canConnectTo(worldIn, pos, Direction.DOWN);
		boolean north = canConnectTo(worldIn, pos, Direction.NORTH);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST);
		return stateIn.setValue(UP, up).setValue(DOWN, down).setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean up = state.getValue(UP).booleanValue();
		boolean down = state.getValue(DOWN).booleanValue();
		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!up && !north && !south && !east && !west && !down) {
			shape = VoxelShapes.or(shape, AABB_UP, AABB_DOWN); }

		if (up) {
			if (down) { shape = VoxelShapes.or(shape, AABB_UP, AABB_DOWN); }
			if (!north && !south && !east && !west && !down) { shape = VoxelShapes.or(shape, AABB_UP, AABB_DOWN); }
			shape = VoxelShapes.or(shape, AABB_UP);
		}

		if (down) {
			if (up) { shape = VoxelShapes.or(shape, AABB_UP, AABB_DOWN); }
			if (!north && !south && !east && !west && !up) { shape = VoxelShapes.or(shape, AABB_UP, AABB_DOWN); }
			shape = VoxelShapes.or(shape, AABB_DOWN);
		}

		if (north) {
			if (south) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_SOUTH); }
			if (!up && !down && !east && !west && !south) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_SOUTH); }
			shape = VoxelShapes.or(shape, AABB_NORTH);
		}

		if (south) {
			if (north) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_SOUTH); }
			if (!up && !down && !east && !west && !north) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_SOUTH); }
			shape = VoxelShapes.or(shape, AABB_SOUTH);
		}

		if (east) {
			if (west) { shape = VoxelShapes.or(shape, AABB_WEST, AABB_EAST); }
			if (!up && !down && !north && !south && !west) { shape = VoxelShapes.or(shape, AABB_WEST, AABB_EAST); }
			shape = VoxelShapes.or(shape, AABB_EAST);
		}

		if (west) {
			if (east) { shape = VoxelShapes.or(shape, AABB_WEST, AABB_EAST); }
			if (!up && !down && !north && !south && !east) { shape = VoxelShapes.or(shape, AABB_WEST, AABB_EAST); }
			shape = VoxelShapes.or(shape, AABB_WEST);
		}

		return shape;
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST, WATERLOGGED);
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
