package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class WindowTall extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<DoorHingeSide> HINGE = EnumProperty.create("hinge", DoorHingeSide.class);
	public static final BooleanProperty POWERED = BooleanProperty.create("powered");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);

	protected static final VoxelShape CLOSEB_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D));
	protected static final VoxelShape CLOSEB_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSEB_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D));
	protected static final VoxelShape CLOSEB_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape OPENBR_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(13.8D, 0.0D, 7.0D, 15.8D, 16.0D, 23.0D));
	protected static final VoxelShape OPENBR_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(-7.0D, 0.0D, 13.8D, 9.0D, 16.0D, 15.8D));
	protected static final VoxelShape OPENBR_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.2D, 0.0D, -7.0D, 2.2D, 16.0D, 9.0D));
	protected static final VoxelShape OPENBR_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(7.0D, 0.0D, 0.2D, 23.0D, 16.0D, 2.2D));

	protected static final VoxelShape OPENBL_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.2D, 0.0D, 7.0D, 2.2D, 16.0D, 23.0D));
	protected static final VoxelShape OPENBL_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(-7.0D, 0.0D, 0.2D, 9.0D, 16.0D, 2.2D));
	protected static final VoxelShape OPENBL_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(13.8D, 0.0D, -7.0D, 15.8D, 16.0D, 9.0D));
	protected static final VoxelShape OPENBL_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(7.0D, 0.0D, 13.8D, 23.0D, 16.0D, 15.8D));
	
	protected static final VoxelShape CLOSE_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape CLOSE_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape CLOSE_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);

	protected static final VoxelShape OPENR_SOUTH = Block.makeCuboidShape(13.8D, 0.0D, 7.0D, 15.8D, 16.0D, 23.0D);
	protected static final VoxelShape OPENR_WEST = Block.makeCuboidShape(-7.0D, 0.0D, 13.8D, 9.0D, 16.0D, 15.8D);
	protected static final VoxelShape OPENR_NORTH = Block.makeCuboidShape(0.2D, 0.0D, -7.0D, 2.2D, 16.0D, 9.0D);
	protected static final VoxelShape OPENR_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.2D, 23.0D, 16.0D, 2.2D);

	protected static final VoxelShape OPENL_SOUTH = Block.makeCuboidShape(0.2D, 0.0D, 7.0D, 2.2D, 16.0D, 23.0D);
	protected static final VoxelShape OPENL_WEST = Block.makeCuboidShape(-7.0D, 0.0D, 0.2D, 9.0D, 16.0D, 2.2D);
	protected static final VoxelShape OPENL_NORTH = Block.makeCuboidShape(13.8D, 0.0D, -7.0D, 15.8D, 16.0D, 9.0D);
	protected static final VoxelShape OPENL_EAST = Block.makeCuboidShape(7.0D, 0.0D, 13.8D, 23.0D, 16.0D, 15.8D);

	public WindowTall(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(OPEN, Boolean.valueOf(false))
				.with(HINGE, DoorHingeSide.LEFT)
				.with(POWERED, Boolean.valueOf(false))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return ActionResultType.PASS; }

		else {
			state = state.cycle(OPEN);
			worldIn.setBlockState(pos, state, 10);
	
			if (state.get(OPEN) == true) { CMEvents.soundWin_OpenL(worldIn, pos); }
			if (state.get(OPEN) != true) { CMEvents.soundWin_CloseL(worldIn, pos); }
	
			return ActionResultType.SUCCESS;
		}
	}

	public void toggleDoor(BlockState state, World worldIn, BlockPos pos, boolean open) {
		BlockState state1 = worldIn.getBlockState(pos);
		if (state1.getBlock() == this && state1.get(OPEN) != open) {
			worldIn.setBlockState(pos, state1.with(OPEN, Boolean.valueOf(open)), 10);
			this.moveSound(worldIn, pos, open);
		}
	}
	
	/* Get POWER. */
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));

		if (block != this && flag != state.get(POWERED)) {
			if (flag != state.get(OPEN)) { this.moveSound(worldIn, pos, flag); }
			worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)), 2);
		}
	}

	/* Play Sound */
	private void moveSound(World worldIn, BlockPos pos, boolean isOpening) {
		if (isOpening == true) { CMEvents.soundWin_OpenL(worldIn, pos); }
		if (isOpening != true) { CMEvents.soundWin_CloseL(worldIn, pos); }
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.up());

			if (playerIn.isSneaking()) {
				return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
						.with(HINGE, DoorHingeSide.RIGHT).with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)).with(HALF, DoubleBlockHalf.LOWER); }

			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(HINGE, DoorHingeSide.LEFT).with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)).with(HALF, DoubleBlockHalf.LOWER);
		}

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
	
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(H_FACING, rot.rotate(state.get(H_FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.toRotation(state.get(H_FACING))).cycle(HINGE);
	}

	/* Return a random long to be passed to {@link IBakedModel#getQuads}, used for random model rotations */
	@OnlyIn(Dist.CLIENT)
	public long getPositionRandom(BlockState state, BlockPos pos) {
		return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() == this && facingState.get(HALF) != half ? state
					.with(H_FACING, facingState.get(H_FACING)).with(OPEN, facingState.get(OPEN))
					.with(HINGE, facingState.get(HINGE)).with(POWERED, facingState.get(POWERED)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		boolean flagopen = !state.get(OPEN);
		boolean flagright = (state.get(HINGE) == DoorHingeSide.RIGHT);

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

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
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

	/* @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine. */
	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return state.get(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.get(OPEN);
		default:
			return false;
		}
	}
	
	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, OPEN, HINGE, POWERED, WATERLOGGED);
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

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_window").applyTextStyle(TextFormatting.GRAY));
	}
}
