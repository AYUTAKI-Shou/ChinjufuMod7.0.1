package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.crop.Inagi;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Suiden extends Block implements SimpleWaterloggedBlock {

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
	
	public Suiden(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WET_1_7, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int wet = state.getValue(WET_1_7);
		/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/

		/** 田起こし **/
		if (item instanceof HoeItem) {
			
			if (wet == 1) {
				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
				worldIn.playSound(null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(2)).setValue(WATERLOGGED, Boolean.valueOf(true)), 3); }
			
			if (wet == 5 || wet == 6 || wet == 7) {
				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
				worldIn.playSound(null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(false)), 3); }
			
			if (wet != 1 && wet != 5 && wet != 6 && wet != 7) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return InteractionResult.SUCCESS; }
		
		/** 米を植える **/
		if (item == Items_Teatime.SEEDS_RICE.get()) {
			
			if (wet == 2) {
				if (worldIn.getBlockState(pos.above()).canBeReplaced()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.WET_GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
					
					worldIn.setBlock(pos.above(), Crop_Blocks.RICE_8.get().defaultBlockState().setValue(Rice_8.AGE, Integer.valueOf(0)), 3); }
				
				if (!worldIn.getBlockState(pos.above()).canBeReplaced() && 
						worldIn.getBlockState(pos.above()).getBlock() != Crop_Blocks.RICE_8.get()) {
					CMEvents.textNoPlace(worldIn, pos, playerIn); } }
			
			if (wet != 2) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return InteractionResult.SUCCESS; }

		/** 土壌調整 **/
		if (item == Items_Teatime.INEWARA.get() || item == Items_Seasonal.WARAHAI.get() || item == Items_Seasonal.OCHIBA_carpet.get() || 
				item == Items_Seasonal.KAEDE_carpet.get() || item == Items.BONE_MEAL) {

			if (wet == 4 || wet == 3) {
				if (upAir(worldIn, pos)) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(5)).setValue(WATERLOGGED, Boolean.valueOf(false)), 3); }
				
				if (!upAir(worldIn, pos)) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
			
			if (wet != 4 && wet != 3) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return InteractionResult.SUCCESS; }

		/** 撮影用チート
		if (item == Items_Seasonal.ICHOH_carpet.get()) {
			CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(WET_1_7, Integer.valueOf(4)).setValue(WATERLOGGED, Boolean.valueOf(false)), 3);
			return InteractionResult.SUCCESS; } **/

		return InteractionResult.PASS;
	}
	
	/* Connect the blocks. */
	private boolean canConnectTo(BlockGetter worldIn, BlockPos pos, Direction direction, int wet) {
		BlockState state = worldIn.getBlockState(pos.relative(direction));
		return state.getBlock() == this && state.getValue(WET_1_7) == wet;		
	}
	
	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		/** 2の時だけ **/
		return (state.getValue(WATERLOGGED) && state.getValue(WET_1_7) == 2) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	public boolean canPlaceLiquid(@Nullable Player playerIn, BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return false;
	} // fix 20.2
	
	@Override
	public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		return false;
	}
	
	@Override
	public ItemStack pickupBlock(@Nullable Player playerIn, LevelAccessor worldIn, BlockPos pos, BlockState state) {
		return ItemStack.EMPTY;
	} // fix 20.2
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (facing == Direction.UP && !state.canSurvive(worldIn, pos)) {
			worldIn.scheduleTick(pos, Wood_Blocks.SUIDEN.get(), 1); }

		/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/
		int wet = state.getValue(WET_1_7);

		if (wet ==2) {
			if (growCrops(worldIn, pos)) { worldIn.scheduleTick(pos, Wood_Blocks.SUIDEN.get(), 1); } }

		if (wet ==3) {
			if (growCrops2(worldIn, pos)) { worldIn.scheduleTick(pos, Wood_Blocks.SUIDEN.get(), 1); } }

		if (wet ==3) {
			if (upAir(worldIn, pos)) { worldIn.scheduleTick(pos, Wood_Blocks.SUIDEN.get(), 1); } }

		boolean north = canConnectTo(worldIn, pos, Direction.NORTH, wet);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST, wet);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH, wet);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST, wet);
		return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Limit the place. */
	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		return !upState.isSolid() || upState.getBlock() instanceof FenceGateBlock || upState.getBlock() instanceof Rice_8 || 
				upState.getBlock() instanceof Inagi || upState.getBlock() instanceof MovingPistonBlock;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? Blocks.DIRT.defaultBlockState() : this.defaultBlockState();
	}
	
	/* Conditions for TickRandom. */
	public static void turnToDirt(BlockState state, Level worldIn, BlockPos pos) {
		worldIn.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
	}

	private boolean growCrops(BlockGetter worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock == Crop_Blocks.RICE_8.get() && upState.getValue(Rice_8.AGE) > 5);
	}

	private boolean growCrops2(BlockGetter worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock == Crop_Blocks.RICE_8.get() && upState.getValue(Rice_8.AGE) > 6);
	}

	private boolean upAir(BlockGetter worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock == Blocks.AIR);
	}

	private static boolean hasWater(LevelReader worldIn, BlockPos pos) {
		for(BlockPos nearPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
			if (worldIn.getFluidState(nearPos).is(FluidTags.WATER)) {
				return true;
			}
		}
		return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (!state.canSurvive(worldIn, pos)) { turnToDirt(state, worldIn, pos); }
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
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
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_COL;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WET_1_7, WATERLOGGED);
	}
	
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isViewBlocking(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return true;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_suiden").withStyle(ChatFormatting.GRAY));
	}
}
