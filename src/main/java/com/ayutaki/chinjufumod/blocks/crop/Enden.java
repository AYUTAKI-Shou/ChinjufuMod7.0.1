package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Enden extends Block {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	/* 1=水を張った、2、3、4、5=塩1、6=塩1、7=塩2、8=塩2、9=塩3 */
	public static final IntegerProperty WET_1_9 = IntegerProperty.create("wet", 1, 9);

	/* Collision */
	protected static final VoxelShape AABB_1 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.5D, 16.0D);
	protected static final VoxelShape AABB_9 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Enden(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WET_1_9, Integer.valueOf(1)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(WET_1_9);
		/* 1=水を張った、2、3、4、5=塩1、6=塩1、7=塩2、8=塩2、9=塩3 */

		/** Too early to collect **/
		if (i < 5) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	

		/** Can harvest **/
		if (i >= 5) {
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				
				if (i == 5 || i == 6) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHIO.get(), 1)); }
				if (i == 7 || i == 8) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHIO.get(), 2)); }
				if (i == 9) {
					playerIn.getInventory().add(new ItemStack(Items_Teatime.SHIO.get(), 3));
					if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.NIGARI.get(), 1))) {
						playerIn.drop(new ItemStack(Items_Teatime.NIGARI.get(), 1), false); } }
				
				worldIn.setBlock(pos, Crop_Blocks.ENDEN_k.get().defaultBlockState(), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? Blocks.SAND.defaultBlockState() : this.defaultBlockState();
	}
	
	/* Connect the blocks. */
	private boolean canConnectTo(BlockGetter worldIn, BlockPos pos, Direction direction) {
		BlockState state = worldIn.getBlockState(pos.relative(direction));
		return state.getBlock() == this;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (!state.canSurvive(worldIn, pos)) { worldIn.scheduleTick(pos, this, 2); }
		
		boolean north = canConnectTo(worldIn, pos, Direction.NORTH);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST);
		return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		return !upState.isSolid() || upState.getBlock() instanceof FenceGateBlock || upState.getBlock() instanceof MovingPistonBlock;
	}
	
	/* Conditions for TickRandom. */
	public static void turnToSand(BlockState state, Level worldIn, BlockPos pos) {
		worldIn.setBlockAndUpdate(pos, Blocks.SAND.defaultBlockState());
	}
	
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!state.canSurvive(worldIn, pos)) { worldIn.scheduleTick(pos, this, 2); }
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (!state.canSurvive(worldIn, pos)) { turnToSand(state, worldIn, pos); }
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }
		
		BlockState upState = worldIn.getBlockState(pos.above());
		if (upState.getBlock() instanceof LiquidBlock) { 
			if (rand.nextInt(2) == 0) { turnToSand(state, worldIn, pos); }
		}
		
		/** WATERLOGGED で水面より下と成るため pos.above() か **/
		if (!worldIn.canSeeSky(pos.above())) { }

		if (worldIn.canSeeSky(pos.above())) {
			int i = state.getValue(WET_1_9);

			if (!worldIn.isRainingAt(pos.above())) {
				if (i != 9) {
					if (worldIn.isDay()) {
						if (rand.nextInt(6) == 0) { worldIn.setBlock(pos, state.setValue(WET_1_9, Integer.valueOf(i + 1)), 3); } }
	
					if (!worldIn.isDay()) { } }
				
				if (i == 9) { }
			}

			if (worldIn.isRainingAt(pos.above())) {
				if (i != 1) {
					if (rand.nextInt(2) == 0) { worldIn.setBlock(pos, state.setValue(WET_1_9, Integer.valueOf(i - 1)), 3); } }
				
				if (i == 1) { }
			}
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_9;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(WET_1_9);
		return (i == 9)? AABB_9 : AABB_1;
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WET_1_9);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ENDEN.get());
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
		tooltip.add(Component.translatable("tips.block_enden").withStyle(ChatFormatting.GRAY));
	}
}
