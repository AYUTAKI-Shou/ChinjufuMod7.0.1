package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Sudare extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_3 = IntegerProperty.create("stage", 1, 3);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.makeCuboidShape(0.0D, -16.0D, 0.0D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape S1_WEST = Block.makeCuboidShape(15.5D, -16.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.makeCuboidShape(0.0D, -16.0D, 15.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_EAST = Block.makeCuboidShape(0.0D, -16.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape S2_WEST = Block.makeCuboidShape(15.5D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_EAST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	protected static final VoxelShape S3_SOUTH = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape S3_WEST = Block.makeCuboidShape(15.5D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S3_NORTH = Block.makeCuboidShape(0.0D, 14.0D, 15.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S3_EAST = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public Sudare(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_3, Integer.valueOf(1))
				.with(HALF, DoubleBlockHalf.UPPER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_3);

		if (stack.isEmpty()) {
			if (playerIn.isSneaking() && state.get(HALF) == DoubleBlockHalf.UPPER) {
				CMEvents.soundWoolPlace(worldIn, pos);

				if (i == 1) {
					worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState()); }

				if (i == 2) {
					worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1))); }

				if (i == 3 && worldIn.getBlockState(pos.down()).getMaterial().isReplaceable()) {
					worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(1)));
					worldIn.setBlockState(pos.down(), this.getDefaultState().with(H_FACING, state.get(H_FACING))
							.with(HALF, DoubleBlockHalf.LOWER).with(STAGE_1_3, Integer.valueOf(1))); } }
			
			if (!playerIn.isSneaking()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (worldIn.getBlockState(pos.down()).isReplaceable(context)) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(STAGE_1_3, Integer.valueOf(1)).with(HALF, DoubleBlockHalf.UPPER); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidDown = worldIn.getFluidState(pos.down());

		worldIn.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(fluidDown.isTagged(FluidTags.WATER))), 3);
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
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.up());
		BlockState downState = worldIn.getBlockState(pos.down());

		if (downState.getBlock() == this) { worldIn.destroyBlock(pos.down(), false); }

		if (upState.getBlock() == this) {
			if (playerIn.isCreative()) { worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35); }
			if (!playerIn.isCreative()) { worldIn.destroyBlock(pos.up(), true); } }

		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@OnlyIn(Dist.CLIENT)
	public long getPositionRandom(BlockState state, BlockPos pos) {
		return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, HALF, STAGE_1_3, WATERLOGGED);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_1_3);
		Direction direction = state.get(H_FACING);

		switch(direction) {
		case NORTH:
		default:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_NORTH : ((i == 2)? S2_NORTH : S3_NORTH));
		case SOUTH:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_SOUTH : ((i == 2)? S2_SOUTH : S3_SOUTH));
		case WEST:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_WEST : ((i == 2)? S2_WEST : S3_WEST));
		case EAST:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_EAST : ((i == 2)? S2_EAST : S3_EAST));
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Wadeco.SUDARE);
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
		tooltip.add(new TranslationTextComponent("tips.block_sudare").applyTextStyle(TextFormatting.GRAY));
	}
}
