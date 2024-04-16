package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.ChestType;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class Tansu extends AbstractTansu<Tansu_TileEntity> {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;

	public Tansu(AbstractBlock.Properties properties, Supplier<TileEntityType<? extends Tansu_TileEntity>> entityType) {
		super(properties, entityType);
		this.registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(OPEN, Boolean.valueOf(false))
				.setValue(TYPE, ChestType.SINGLE));
	}

	public static TileEntityMerger.Type getBlockType(BlockState state) {
		return TileEntityMerger.Type.SINGLE;
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL; // BlockRenderType.MODEL でブロックのモデルを表示
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.block();
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Nullable
	private Direction candidatePartnerFacing(BlockItemUseContext context, Direction direct) {
		BlockState state = context.getLevel().getBlockState(context.getClickedPos().relative(direct));
		return state.is(this) && state.getValue(TYPE) == ChestType.SINGLE ? state.getValue(H_FACING) : null;
	}

	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		if (stack.hasCustomHoverName()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof Tansu_TileEntity) {
				((Tansu_TileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState facingState, boolean p_196243_5_) {
		if (!state.is(facingState.getBlock())) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof IInventory) {
				InventoryHelper.dropContents(worldIn, pos, (IInventory)tileentity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, worldIn, pos, facingState, p_196243_5_);
		}
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		if (worldIn.isClientSide) { return ActionResultType.SUCCESS; }

		if (!worldIn.isClientSide) {

			if (!state.getValue(WATERLOGGED)) {

				Direction direction = state.getValue(H_FACING);
				TileEntity tile = worldIn.getBlockEntity(pos);
				
				BlockState northState = worldIn.getBlockState(pos.north());
				BlockState southState = worldIn.getBlockState(pos.south());
				BlockState eastState = worldIn.getBlockState(pos.east());
				BlockState westState = worldIn.getBlockState(pos.west());
				
				switch (direction) {
				case NORTH:
				default:
					if (!northState.getMaterial().isReplaceable()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return ActionResultType.SUCCESS; }
					
					if (northState.getMaterial().isReplaceable()) {
						if (northState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return ActionResultType.SUCCESS; }
						
						if (!(northState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Tansu_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Tansu_TileEntity)tile, pos); }
						} }
					break;

				case SOUTH:
					if (!southState.getMaterial().isReplaceable()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return ActionResultType.SUCCESS; }
					
					if (southState.getMaterial().isReplaceable()) {
						if (southState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return ActionResultType.SUCCESS; }
						
						if (!(southState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Tansu_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Tansu_TileEntity)tile, pos); }
						} }
					break;

				case EAST:
					if (!eastState.getMaterial().isReplaceable()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return ActionResultType.SUCCESS; }
					
					if (eastState.getMaterial().isReplaceable()) {
						if (eastState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return ActionResultType.SUCCESS; }
						
						if (!(eastState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Tansu_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Tansu_TileEntity)tile, pos); }
						} }
					break;
					
				case WEST:
					if (!westState.getMaterial().isReplaceable()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return ActionResultType.SUCCESS; }
					
					if (westState.getMaterial().isReplaceable()) {
						if (westState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return ActionResultType.SUCCESS; }
						
						if (!(westState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Tansu_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Tansu_TileEntity)tile, pos); }
						} }
					break;
				} // switch
			} // !state.getValue(WATERLOGGED)
			
			if (state.getValue(WATERLOGGED)) { 
				CMEvents.textIsWaterlogged(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}
		return ActionResultType.CONSUME;
	}

	protected Stat<ResourceLocation> getOpenChestStat() {
		return Stats.CUSTOM.get(Stats.OPEN_CHEST);
	}

	@Nullable
	public static IInventory getContainer(Tansu block, BlockState state, World worldIn, BlockPos pos, boolean flag) {
		return (IInventory)worldIn.getBlockEntity(pos);
	}

	public TileEntityMerger.ICallbackWrapper<? extends Tansu_TileEntity> combine(BlockState state, World worldIn, BlockPos pos, boolean flag) {
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public static TileEntityMerger.ICallback<Tansu_TileEntity, Float2FloatFunction> opennessCombiner(final IChestLid lis) {
		return new TileEntityMerger.ICallback<Tansu_TileEntity, Float2FloatFunction>() {
			public Float2FloatFunction acceptDouble(Tansu_TileEntity tileEntity_1, Tansu_TileEntity tileEntity_2) {
				return (p_226921_2_) -> {
					return Math.max(tileEntity_1.getOpenNess(p_226921_2_), tileEntity_2.getOpenNess(p_226921_2_));
				};
			}

			public Float2FloatFunction acceptSingle(Tansu_TileEntity tileEntity) {
				return tileEntity::getOpenNess;
			}

			public Float2FloatFunction acceptNone() {
				return lis::getOpenNess;
			}
		};
	}

	public TileEntity newBlockEntity(IBlockReader worldIn) {
		return new Tansu_TileEntity();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState state, World worldIn, BlockPos pos) {
		return Container.getRedstoneSignalFromContainer(getContainer(this, state, worldIn, pos, false));
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

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, OPEN, WATERLOGGED, TYPE);
	}

	@Override
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType path) {
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
