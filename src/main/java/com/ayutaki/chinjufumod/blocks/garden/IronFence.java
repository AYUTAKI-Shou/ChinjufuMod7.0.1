package com.ayutaki.chinjufumod.blocks.garden;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.state.TypeLR;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
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
	protected static final VoxelShape BOT_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_WEST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_EAST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

	protected static final VoxelShape TOP_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 27.0D, 8.5D);
	protected static final VoxelShape TOP_WEST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 27.0D, 16.0D);
	protected static final VoxelShape TOP_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 27.0D, 16.0D, 8.5D);
	protected static final VoxelShape TOP_EAST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 27.0D, 16.0D);

	public IronFence(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(TYPE, TypeLR.DEFAULT)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
	}
	
	/* Limit the place. */
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		BlockState downState = worldIn.getBlockState(downPos);

		if (state.get(HALF) == DoubleBlockHalf.LOWER) { return true; }
		
		else { return downState.getBlock() == this; }
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

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, Direction targetDirection) {
		BlockState state = worldIn.getBlockState(source.offset(direction));

		if (state.getBlock() == this) {
			Direction fenceDirection = state.get(H_FACING);
			return fenceDirection.equals(targetDirection);
		}
		return false;
	}

	private BlockState getConnectState(BlockState state, IWorld worldIn, BlockPos pos, Direction dir) {
		boolean left = canConnectTo(worldIn, pos, dir.rotateY(), dir) || canConnectTo(worldIn, pos, dir.rotateY(), dir.rotateY());
		boolean right = canConnectTo(worldIn, pos, dir.rotateYCCW(), dir) || canConnectTo(worldIn, pos, dir.rotateYCCW(), dir.rotateYCCW());

		if (left && right) {
			return state.with(TYPE, TypeLR.BOTH);
		}

		else if (left) {
			return state.with(TYPE, TypeLR.RIGHT);
		}

		else if (right) {
			return state.with(TYPE, TypeLR.LEFT);
		}
		return state.with(TYPE, TypeLR.DEFAULT);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : this.getConnectState(state, worldIn, pos, state.get(H_FACING));
		}
		else {
			return Blocks.AIR.getDefaultState();
		}
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.get(HALF);
		BlockPos pos1 = half == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState state1 = worldIn.getBlockState(pos1);

		if (state1.getBlock() == this && state1.get(HALF) != half) {
			worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(playerIn, 2001, pos1, Block.getStateId(state1));

			ItemStack stack = playerIn.getHeldItemMainhand();
			if (!worldIn.isRemote && !playerIn.isCreative() && playerIn.canHarvestBlock(state1)) {
				Block.spawnDrops(state, worldIn, pos, (TileEntity)null, playerIn, stack);
				Block.spawnDrops(state1, worldIn, pos1, (TileEntity)null, playerIn, stack);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}
	
	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, TYPE, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch(direction) {
		case NORTH:
		default:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_NORTH : TOP_NORTH;
		case SOUTH:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_SOUTH : TOP_SOUTH;
		case WEST:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_WEST : TOP_WEST;
		case EAST:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_EAST : TOP_EAST;
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
}
