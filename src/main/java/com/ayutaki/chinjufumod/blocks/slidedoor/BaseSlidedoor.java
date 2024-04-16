package com.ayutaki.chinjufumod.blocks.slidedoor;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class BaseSlidedoor extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<DoorHingeSide> HINGE = EnumProperty.create("hinge", DoorHingeSide.class);
	public static final BooleanProperty POWERED = BooleanProperty.create("powered");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSEB_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSEB_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSEB_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape CLOSEB_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));

	protected static final VoxelShape OPENBR_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(14.0D, 0.0D, 8.0D, 30.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPENBR_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 14.0D, 8.0D, 16.0D, 30.0D));
	protected static final VoxelShape OPENBR_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(-14.0D, 0.0D, 6.5D, 2.0D, 16.0D, 8.0D));
	protected static final VoxelShape OPENBR_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, -14.0D, 9.5D, 16.0D, 2.0D));

	protected static final VoxelShape OPENBL_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPENBL_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D));
	protected static final VoxelShape OPENBL_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D));
	protected static final VoxelShape OPENBL_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D));
	
	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape CLOSE_WEST = Block.box(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape CLOSE_EAST = Block.box(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

	protected static final VoxelShape OPENR_SOUTH = Block.box(14.0D, 0.0D, 8.0D, 30.0D, 16.0D, 9.5D);
	protected static final VoxelShape OPENR_WEST = Block.box(6.5D, 0.0D, 14.0D, 8.0D, 16.0D, 30.0D);
	protected static final VoxelShape OPENR_NORTH = Block.box(-14.0D, 0.0D, 6.5D, 2.0D, 16.0D, 8.0D);
	protected static final VoxelShape OPENR_EAST = Block.box(8.0D, 0.0D, -14.0D, 9.5D, 16.0D, 2.0D);

	protected static final VoxelShape OPENL_SOUTH = Block.box(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D);
	protected static final VoxelShape OPENL_WEST = Block.box(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D);
	protected static final VoxelShape OPENL_NORTH = Block.box(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D);
	protected static final VoxelShape OPENL_EAST = Block.box(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D);

	public BaseSlidedoor(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(OPEN, Boolean.valueOf(false))
				.setValue(HINGE, DoorHingeSide.LEFT)
				.setValue(POWERED, Boolean.valueOf(false))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();
		
		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			boolean flag = worldIn.hasNeighborSignal(pos) || worldIn.hasNeighborSignal(pos.above());

			if (playerIn.isCrouching()) {
				return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
						.setValue(HINGE, DoorHingeSide.RIGHT).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)).setValue(HALF, DoubleBlockHalf.LOWER); }

			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)).setValue(HALF, DoubleBlockHalf.LOWER);
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
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downState.getBlock() == this; }
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return mirror == Mirror.NONE ? state : state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Return a random long to be passed to {@link IBakedModel#getQuads}, used for random model rotations */
	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState state, BlockPos pos) {
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() == this && facingState.getValue(HALF) != half ? state
					.setValue(H_FACING, facingState.getValue(H_FACING)).setValue(OPEN, facingState.getValue(OPEN))
					.setValue(HINGE, facingState.getValue(HINGE)).setValue(POWERED, facingState.getValue(POWERED)) : Blocks.AIR.defaultBlockState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch (type) {
		case LAND:
			return state.getValue(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.getValue(OPEN);
		default:
			return false;
		}
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); }
			else { dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

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

	/* @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine. */
	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	/* Create Blockstate */
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, OPEN, HINGE, POWERED, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		boolean flagopen = !state.getValue(OPEN);
		boolean flagright = (state.getValue(HINGE) == DoorHingeSide.RIGHT);

		switch (half) {
		case LOWER:
		default:
			switch (direction) {
			case NORTH:
			default:
				return flagopen? CLOSEB_NORTH : (flagright? OPENBL_NORTH : OPENBR_NORTH);
			case SOUTH:
				return flagopen? CLOSEB_SOUTH : (flagright? OPENBL_SOUTH : OPENBR_SOUTH);
			case WEST:
				return flagopen? CLOSEB_WEST : (flagright? OPENBL_WEST : OPENBR_WEST);
			case EAST:
				return flagopen? CLOSEB_EAST : (flagright? OPENBL_EAST : OPENBR_EAST);
			}

		case UPPER:
			switch (direction) {
			case NORTH:
			default:
				return flagopen? CLOSE_NORTH : (flagright? OPENL_NORTH : OPENR_NORTH);
			case SOUTH:
				return flagopen? CLOSE_SOUTH : (flagright? OPENL_SOUTH : OPENR_SOUTH);
			case WEST:
				return flagopen? CLOSE_WEST : (flagright? OPENL_WEST : OPENR_WEST);
			case EAST:
				return flagopen? CLOSE_EAST : (flagright? OPENL_EAST : OPENR_EAST);
			}
		} // switch LOWER-UPPER
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
