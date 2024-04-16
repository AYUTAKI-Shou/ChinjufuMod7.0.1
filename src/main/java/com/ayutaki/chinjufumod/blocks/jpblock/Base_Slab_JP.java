package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Base_Slab_JP extends Block implements IWaterLoggable {

	/* Property */
	public static final EnumProperty<SlabType> TYPE = EnumProperty.create("type", SlabType.class);
	public static final BooleanProperty CRACK = BooleanProperty.create("cra");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape AABB_TOP = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Base_Slab_JP(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)
		.setValue(CRACK, Boolean.valueOf(false))
		.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			if (stack.isEmpty()) {
				if (playerIn.isCrouching()) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlock(pos, state.cycle(CRACK), 3);
					return ActionResultType.SUCCESS; }
			}

			return ActionResultType.PASS;
		}
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		FluidState fluid = worldIn.getFluidState(pos);
		
		if (state.getBlock() == this) {
			/** Change to SlabType.DOUBLE. **/
			return state.setValue(TYPE, SlabType.DOUBLE);
		}

		else {
			BlockState blockState2 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)
					.setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)))
					.setValue(CRACK, Boolean.valueOf(false));
			Direction direction = context.getClickedFace();

			return direction != Direction.DOWN && (direction == Direction.UP || context.getClickLocation().y - (double)pos.getY() <= 0.5D) ? blockState2 : blockState2.setValue(TYPE, SlabType.TOP);
		}
	}

	/* DOUBLE への置き換え boolean t/f */
	@Override
	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) {
		ItemStack stack = context.getItemInHand();
		SlabType slabType = state.getValue(TYPE);

		/** DOUBLE でない時 かつ これをアイテム(アイテムブロック)として使う時 **/
		if (slabType != SlabType.DOUBLE && stack.getItem() == this.asItem()) {

			if (context.replacingClickedOnBlock()) {
				boolean flag = context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5D;
				Direction direction = context.getClickedFace();

				if (slabType == SlabType.BOTTOM) { return direction == Direction.UP || flag && direction.getAxis().isHorizontal(); }

				else { return direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal(); }
			}
			else { return true; }
		}
		else { return false; }
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		return state.getValue(TYPE) != SlabType.DOUBLE ? IWaterLoggable.super.placeLiquid(worldIn, pos, state, fluid) : false;
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return state.getValue(TYPE) != SlabType.DOUBLE ? IWaterLoggable.super.canPlaceLiquid(worldIn, pos, state, fluid) : false;
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
		builder.add(CRACK, TYPE, WATERLOGGED);
	}

	public boolean useShapeForLightOcclusion(BlockState state) {
		return state.getValue(TYPE) != SlabType.DOUBLE;
	}

	/* Collisions for each property. */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		SlabType slabType = state.getValue(TYPE);
		switch (slabType) {
		case DOUBLE:
			return VoxelShapes.block();
		case TOP:
			return AABB_TOP;
		default:
			return AABB_BOTTOM;
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
