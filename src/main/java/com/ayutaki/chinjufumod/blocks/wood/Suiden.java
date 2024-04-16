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

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.MovingPistonBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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

	protected static final VoxelShape AABB_COL = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public Suiden(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WET_1_7, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int wet = state.getValue(WET_1_7);
		/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/

		/** 田起こし **/
		if (item instanceof HoeItem) {
			
			if (wet == 1) {
				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
				worldIn.playSound(null, pos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(2)).setValue(WATERLOGGED, Boolean.valueOf(true)), 3); }
			
			if (wet == 5 || wet == 6 || wet == 7) {
				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
				worldIn.playSound(null, pos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(false)), 3); }
			
			if (wet != 1 && wet != 5 && wet != 6 && wet != 7) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS; }
		
		/** 米を植える **/
		if (item == Items_Teatime.SEEDS_RICE) {
			
			if (wet == 2) {
				if (worldIn.getBlockState(pos.above()).getMaterial().isReplaceable()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.WET_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlock(pos.above(), Crop_Blocks.RICE_8.defaultBlockState().setValue(Rice_8.AGE, Integer.valueOf(0)), 3); }
				
				if (!worldIn.getBlockState(pos.above()).getMaterial().isReplaceable() && 
						worldIn.getBlockState(pos.above()).getBlock() != Crop_Blocks.RICE_8) {
					CMEvents.textNoPlace(worldIn, pos, playerIn); } }
			
			if (wet != 2) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS; }

		/** 土壌調整 **/
		if (item == Items_Teatime.INEWARA || item == Items_Seasonal.WARAHAI || item == Items_Seasonal.OCHIBA_carpet || 
				item == Items_Seasonal.KAEDE_carpet || item == Items.BONE_MEAL) {

			if (wet == 4 || wet == 3) {
				if (upAir(worldIn, pos)) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(5)).setValue(WATERLOGGED, Boolean.valueOf(false)), 3); }
				
				if (!upAir(worldIn, pos)) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
			
			if (wet != 4 && wet != 3) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS; }

		/** 撮影用チート
		if (item == Items_Seasonal.ICHOH_carpet) {
			CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(4)).setValue(WATERLOGGED, Boolean.valueOf(false)));
			return ActionResultType.SUCCESS; } **/

		return ActionResultType.PASS;
	}

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, int wet) {
		BlockState state = worldIn.getBlockState(source.relative(direction));
		return state.getBlock() == this && state.getValue(WET_1_7) == wet;
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		/** 2の時だけ **/
		return (state.getValue(WATERLOGGED) && state.getValue(WET_1_7) == 2) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return false;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		return false;
	}

	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		return Fluids.EMPTY;
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		if (facing == Direction.UP && !state.canSurvive(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); }

		/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/
		int wet = state.getValue(WET_1_7);

		if (wet == 2) {
			if (growCrops(worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); } }

		if (wet == 3) {
			if (growCrops2(worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); } }

		if (wet == 3) {
			if (upAir(worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, Wood_Blocks.SUIDEN, 1); } }

		boolean north = canConnectTo(worldIn, pos, Direction.NORTH, wet);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST, wet);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH, wet);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST, wet);
		return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		return !upState.getMaterial().isSolid() || upState.getBlock() instanceof FenceGateBlock || upState.getBlock() instanceof Rice_8 || 
				upState.getBlock() instanceof Inagi || upState.getBlock() instanceof MovingPistonBlock;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? Blocks.DIRT.defaultBlockState() : this.defaultBlockState();
	}

	/* Conditions for TickRandom. */
	public static void turnToDirt(BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
	}

	private boolean growCrops(IBlockReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock == Crop_Blocks.RICE_8 && upState.getValue(Rice_8.AGE) > 5);
	}

	private boolean growCrops2(IBlockReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock == Crop_Blocks.RICE_8 && upState.getValue(Rice_8.AGE) > 6);
	}

	private boolean upAir(IBlockReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock == Blocks.AIR);
	}

	private static boolean hasWater(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos nearPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
			if (worldIn.getFluidState(nearPos).is(FluidTags.WATER)) {
				return true;
			}
		}
		return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.canSurvive(worldIn, pos)) { turnToDirt(state, worldIn, pos); }
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.above())) { 
			if (rand.nextInt(2) == 0) { turnToDirt(state, worldIn, pos); }
		}
		
		else {
			/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/
			int wet = state.getValue(WET_1_7);

			if (wet == 1 && rand.nextInt(1) == 0) {
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(2)).setValue(WATERLOGGED, Boolean.valueOf(true)), 2); }

			if (wet == 2) {
				if (!growCrops(worldIn, pos)) { }

				else { worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(3)).setValue(WATERLOGGED, Boolean.valueOf(false)), 2); } }

			if (wet == 3) {
				if (!growCrops2(worldIn, pos) && !upAir(worldIn, pos)) { }

				else { worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(4)).setValue(WATERLOGGED, Boolean.valueOf(false)), 2); } }

			if (wet == 4) { }

			if (wet == 5 && rand.nextInt(3) == 0) {
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(6)).setValue(WATERLOGGED, Boolean.valueOf(false)), 2); }

			if (wet == 6 && rand.nextInt(3) == 0) {
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(7)).setValue(WATERLOGGED, Boolean.valueOf(false)), 2); }

			if (wet == 7) { }
		}
	}

	/* Collisions that change with properties*/
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
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WET_1_7, WATERLOGGED);
	}

	/* 透過 */
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isViewBlocking(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
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
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_suiden").withStyle(TextFormatting.GRAY));
	}
}
