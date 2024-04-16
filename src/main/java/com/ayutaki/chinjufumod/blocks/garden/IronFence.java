package com.ayutaki.chinjufumod.blocks.garden;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.state.TypeLR;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class IronFence extends CM_WaterLogged {

	/* Property */
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final EnumProperty<TypeLR> TYPE = EnumProperty.create("type", TypeLR.class);
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

	/* Collision */
	protected static final VoxelShape BOT_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_WEST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_NORTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_EAST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

	protected static final VoxelShape TOP_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 27.0D, 8.5D);
	protected static final VoxelShape TOP_WEST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 27.0D, 16.0D);
	protected static final VoxelShape TOP_NORTH = Block.box(0.0D, 0.0D, 7.5D, 27.0D, 16.0D, 8.5D);
	protected static final VoxelShape TOP_EAST = Block.box(7.5D, 0.0D, 0.0D, 8.5D, 27.0D, 16.0D);

	public IronFence(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(TYPE, TypeLR.DEFAULT)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
		}

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}
	
	/* Limit the place. */
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downState.getBlock() == this; }
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

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, Direction targetDirection) {
		BlockState state = worldIn.getBlockState(source.relative(direction));

		if(state.getBlock() == this) {
			Direction fenceDirection = state.getValue(H_FACING);
			return fenceDirection.equals(targetDirection);
		}
		return false;
	}

	private BlockState getConnectState(BlockState state, IWorld worldIn, BlockPos pos, Direction dir) {
		boolean left = canConnectTo(worldIn, pos, dir.getClockWise(), dir) || canConnectTo(worldIn, pos, dir.getClockWise(), dir.getClockWise());
		boolean right = canConnectTo(worldIn, pos, dir.getCounterClockWise(), dir) || canConnectTo(worldIn, pos, dir.getCounterClockWise(), dir.getCounterClockWise());

		if(left && right) {
			return state.setValue(TYPE, TypeLR.BOTH);
		}

		else if(left) {
			return state.setValue(TYPE, TypeLR.RIGHT);
		}

		else if(right) {
			return state.setValue(TYPE, TypeLR.LEFT);
		}
		return state.setValue(TYPE, TypeLR.DEFAULT);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.getValue(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : this.getConnectState(state, worldIn, pos, state.getValue(H_FACING));
		}
		else {
			return Blocks.AIR.defaultBlockState();
		}
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); }
			else { dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void breakLowerPart(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downPos = pos.below();
			BlockState downState = worldIn.getBlockState(downPos);

			if (downState.getBlock() == state.getBlock() && downState.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downPos, Block.getId(downState));
			}
		}
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, TYPE, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? BOT_NORTH : TOP_NORTH;
		case SOUTH:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? BOT_SOUTH : TOP_SOUTH;
		case WEST:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? BOT_WEST : TOP_WEST;
		case EAST:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? BOT_EAST : TOP_EAST;
		}
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
