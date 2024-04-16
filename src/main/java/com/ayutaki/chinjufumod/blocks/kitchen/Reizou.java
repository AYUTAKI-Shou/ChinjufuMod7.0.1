package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class Reizou extends AbstractReizou<Reizou_TileEntity> {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final BooleanProperty RIGHT = BooleanProperty.create("right");
	public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 13.4D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(2.6D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 2.6D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 13.4D, 16.0D, 16.0D);

	public Reizou(Block.Properties properties, Supplier<TileEntityType<? extends Reizou_TileEntity>> entityType) {
		super(properties, entityType);
		this.setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(WATERLOGGED, Boolean.valueOf(false))
				.with(OPEN, Boolean.valueOf(false))
				.with(RIGHT, Boolean.valueOf(false))
				.with(TYPE, ChestType.SINGLE));
	}

	public static TileEntityMerger.Type func_226919_h_(BlockState state) {
		return TileEntityMerger.Type.SINGLE;
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL; // BlockRenderType.MODEL でブロックのモデルを表示
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();
		
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(RIGHT, Boolean.valueOf(playerIn.isCrouching()))
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }

		else { return null; }
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

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Nullable
	private Direction candidatePartnerFacing(BlockItemUseContext context, Direction direct) {
		BlockState state = context.getWorld().getBlockState(context.getPos().offset(direct));
		return state.getBlock() == this && state.get(TYPE) == ChestType.SINGLE ? state.get(H_FACING) : null;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.up(), Kitchen_Blocks.KIT_REIZOU_TOP.getDefaultState()
				.with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()) == Fluids.WATER))
				.with(RIGHT, Boolean.valueOf(placer.isCrouching())), 3);
		
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof Reizou_TileEntity) {
				((Reizou_TileEntity)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof Reizou_TileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((Reizou_TileEntity) tileentity).getItems());
			}
		}
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hit) {

		if (worldIn.isRemote) { return ActionResultType.SUCCESS; }

		if (!worldIn.isRemote) {

			if (!state.get(WATERLOGGED)) {

				Direction direction = state.get(H_FACING);
				TileEntity tile = worldIn.getTileEntity(pos);
				
				BlockState northState = worldIn.getBlockState(pos.north());
				BlockState southState = worldIn.getBlockState(pos.south());
				BlockState eastState = worldIn.getBlockState(pos.east());
				BlockState westState = worldIn.getBlockState(pos.west());
				
				switch (direction) {
				case NORTH:
				default:
					if (!northState.getMaterial().isReplaceable()) { 
						CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (northState.getMaterial().isReplaceable()) {
						if (northState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn); }
						
						if (!(northState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Reizou_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Reizou_TileEntity)tile, pos); }
						} }
					break;

				case SOUTH:
					if (!southState.getMaterial().isReplaceable()) { 
						CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (southState.getMaterial().isReplaceable()) {
						if (southState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn); }
						
						if (!(southState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Reizou_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Reizou_TileEntity)tile, pos); }
						} }
					break;

				case EAST:
					if (!eastState.getMaterial().isReplaceable()) { 
						CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (eastState.getMaterial().isReplaceable()) {
						if (eastState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn); }
						
						if (!(eastState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Reizou_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Reizou_TileEntity)tile, pos); }
						} }
					break;
					
				case WEST:
					if (!westState.getMaterial().isReplaceable()) { 
						CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (westState.getMaterial().isReplaceable()) {
						if (westState.getBlock() instanceof FlowingFluidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn); }
						
						if (!(westState.getBlock() instanceof FlowingFluidBlock)) {
							if (tile instanceof Reizou_TileEntity) {
								NetworkHooks.openGui((ServerPlayerEntity)playerIn, (Reizou_TileEntity)tile, pos); }
						} }
					break;
				} // switch
			} // !state.get(WATERLOGGED)
			
			if (state.get(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		}
		
		return ActionResultType.SUCCESS;
	}

	protected Stat<ResourceLocation> getOpenStat() {
		return Stats.CUSTOM.get(Stats.OPEN_CHEST);
	}

	@Nullable
	public static IInventory getContainer(Reizou block, BlockState state, World worldIn, BlockPos pos, boolean flag) {
		return (IInventory)worldIn.getTileEntity(pos);
	}

	public TileEntityMerger.ICallbackWrapper<? extends Reizou_TileEntity> combine(BlockState state, World worldIn, BlockPos pos, boolean flag) {
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public static TileEntityMerger.ICallback<Reizou_TileEntity, Float2FloatFunction> opennessCombiner(final IChestLid lis) {
		return new TileEntityMerger.ICallback<Reizou_TileEntity, Float2FloatFunction>() {
			public Float2FloatFunction func_225539_a_(Reizou_TileEntity tileEntity_1, Reizou_TileEntity tileEntity_2) {
				return (p_226921_2_) -> {
					return Math.max(tileEntity_1.getLidAngle(p_226921_2_), tileEntity_2.getLidAngle(p_226921_2_));
				};
			}

			public Float2FloatFunction func_225538_a_(Reizou_TileEntity tileEntity) {
				return tileEntity::getLidAngle;
			}

			public Float2FloatFunction func_225537_b_() {
				return lis::getLidAngle;
			}
		};
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new Reizou_TileEntity();
	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(BlockState state, World worldIn, BlockPos pos) {
		return Container.calcRedstoneFromInventory(getContainer(this, state, worldIn, pos, false));
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, OPEN, WATERLOGGED, RIGHT, TYPE);
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType path) {
		return false;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
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
	
	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.up());
		/** False is not Drop. **/
		if (upState.getBlock() == Kitchen_Blocks.KIT_REIZOU_TOP) {
			worldIn.destroyBlock(pos.up(), false);
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}
}
