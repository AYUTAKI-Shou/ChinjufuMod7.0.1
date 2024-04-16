package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.crop.Inagi;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.MovingPistonBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Suiden extends Block implements IWaterLoggable {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	/* 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 */
	public static final IntegerProperty WET_1_7 = IntegerProperty.create("wet", 1, 7);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	protected static final VoxelShape AABB_COL = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public Suiden(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false))
				.with(EAST, Boolean.valueOf(false))
				.with(SOUTH, Boolean.valueOf(false))
				.with(WEST, Boolean.valueOf(false))
				.with(WET_1_7, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int wet = state.get(WET_1_7);
		/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/

		/** 田起こし **/
		if (item instanceof HoeItem) {
			
			if (wet == 1) {
				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
				worldIn.playSound(null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(2)).with(WATERLOGGED, Boolean.valueOf(true))); }
			
			if (wet == 5 || wet == 6 || wet == 7) {
				stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
				worldIn.playSound(null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(1)).with(WATERLOGGED, Boolean.valueOf(false))); }
			
			if (wet != 1 && wet != 5 && wet != 6 && wet != 7) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS; }
		
		/** 米を植える **/
		if (item == Items_Teatime.SEEDS_RICE) { 
			
			if (wet == 2) {
				if (worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					
					worldIn.setBlockState(pos.up(), Crop_Blocks.RICE_8.getDefaultState().with(Rice_8.AGE, Integer.valueOf(0))); }
				
				if (!worldIn.getBlockState(pos.up()).getMaterial().isReplaceable() && 
						worldIn.getBlockState(pos.up()).getBlock() != Crop_Blocks.RICE_8) {
					CMEvents.textNoPlace(worldIn, pos, playerIn); } }
			
			if (wet != 2) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS; }

		/** 土壌調整 **/
		if (item == Items_Teatime.INEWARA || item == Items_Seasonal.WARAHAI || item == Items_Seasonal
				.OCHIBA_carpet || item == Items_Seasonal.KAEDE_carpet || item == Items.BONE_MEAL) {

			if (wet == 4 || wet == 3) {
				if (upAir(worldIn, pos)) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(5)).with(WATERLOGGED, Boolean.valueOf(false))); }
				
				if (!upAir(worldIn, pos)) {
					CMEvents.textNoPlace(worldIn, pos, playerIn); } }
			
			if (wet != 4 && wet != 3) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS; }
		
		/** 撮影用チート
		if (item == Items_Seasonal.ICHOH_carpet) {
			CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
			worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(4)).with(WATERLOGGED, Boolean.valueOf(false)));
			return ActionResultType.SUCCESS;
		} **/

		return ActionResultType.PASS;
	}

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, int wet) {
		BlockState state = worldIn.getBlockState(source.offset(direction));
		return state.getBlock() == this && state.get(WET_1_7) == wet;
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		/** 2の時だけ **/
		return (state.get(WATERLOGGED) && state.get(WET_1_7) == 2) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}
	
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		return false;
	}

	@Override
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		return Fluids.EMPTY;
	}

	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		if (facing == Direction.UP && !state.isValidPosition(worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); }

		/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/
		int wet = state.get(WET_1_7);

		if (wet ==2) {
			if (growCrops(worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); } }

		if (wet ==3) {
			if (growCrops2(worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); } }

		if (wet ==3) {
			if (upAir(worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); } }

		boolean north = canConnectTo(worldIn, pos, Direction.NORTH, wet);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST, wet);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH, wet);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST, wet);
		return state.with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.up());
		return !upState.getMaterial().isSolid() || upState.getBlock() instanceof FenceGateBlock || upState
				.getBlock() instanceof Rice_8 || upState.getBlock() instanceof Inagi || upState
				.getBlock() instanceof MovingPistonBlock;
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Blocks.DIRT.getDefaultState() : this.getDefaultState();
	}

	/* Conditions for TickRandom. */
	public static void turnToDirt(BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, Blocks.DIRT.getDefaultState(), worldIn, pos));
	}

	private boolean growCrops(IBlockReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		return (upBlock == Crop_Blocks.RICE_8 && upState.get(Rice_8.AGE) > 5);
	}

	private boolean growCrops2(IBlockReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		return (upBlock == Crop_Blocks.RICE_8 && upState.get(Rice_8.AGE) > 6);
	}

	private boolean upAir(IBlockReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		return (upBlock == Blocks.AIR);
	}

	private static boolean hasWater(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos nearPos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (worldIn.getFluidState(nearPos).isTagged(FluidTags.WATER)) {
				return true;
			}
		}
		return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.isValidPosition(worldIn, pos)) { turnToDirt(state, worldIn, pos); }
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up())) { 
			if (rand.nextInt(2) == 0) { turnToDirt(state, worldIn, pos); }
		}

		else {
			/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/
			int wet = state.get(WET_1_7);

			if (wet == 1 && rand.nextInt(1) == 0) {
				worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(2)).with(WATERLOGGED, Boolean.valueOf(true)), 2); }

			if (wet == 2) {
				if (!growCrops(worldIn, pos)) { }

				else { worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(3)).with(WATERLOGGED, Boolean.valueOf(false)), 2); } }

			if (wet == 3) {
				if (!growCrops2(worldIn, pos) && !upAir(worldIn, pos)) { }

				else { worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(4)).with(WATERLOGGED, Boolean.valueOf(false)), 2); } }

			if (wet == 4) { }

			if (wet == 5 && rand.nextInt(3) == 0) {
				worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(6)).with(WATERLOGGED, Boolean.valueOf(false)), 2); }

			if (wet == 6 && rand.nextInt(3) == 0) {
				worldIn.setBlockState(pos, state.with(WET_1_7, Integer.valueOf(7)).with(WATERLOGGED, Boolean.valueOf(false)), 2); }

			if (wet == 7) { }
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_COL;
	}

	/* Collision */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WET_1_7, WATERLOGGED);
	}

	/* 透過 */
	public boolean isTransparent(BlockState state) {
		return true;
	}

	/* Can't breathe. 滑るため false */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isViewBlocking(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		int wet = state.get(WET_1_7);
		if (wet == 2) { return false; }
		return true;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.SHOVEL;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_suiden").applyTextStyle(TextFormatting.GRAY));
	}
}
