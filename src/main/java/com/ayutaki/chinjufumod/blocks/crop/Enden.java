package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.MovingPistonBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
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

public class Enden extends Block {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	/* 1=水を張った、2、3、4、5=塩1、6=塩1、7=塩2、8=塩2、9=塩3 */
	public static final IntegerProperty WET_1_9 = IntegerProperty.create("wet", 1, 9);

	protected static final VoxelShape AABB_1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.5D, 16.0D);
	protected static final VoxelShape AABB_9 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Enden(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false))
				.with(EAST, Boolean.valueOf(false))
				.with(SOUTH, Boolean.valueOf(false))
				.with(WEST, Boolean.valueOf(false))
				.with(WET_1_9, Integer.valueOf(1)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(WET_1_9);
		/* 1=水を張った、2、3、4、5=塩1、6=塩1、7=塩2、8=塩2、9=塩3 */

		/** Too early to collect **/
		if (i < 5) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	

		/** Can harvest **/
		if (i >= 5) {
			if (stack.isEmpty()) {

				CMEvents.soundTake_Pick(worldIn, pos);
				
				if (i == 5 || i == 6) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHIO, 1)); }
				if (i == 7 || i == 8) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHIO, 2)); }
				if (i == 9) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHIO, 3));
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NIGARI, 1))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.NIGARI, 1), false); } }
				
				worldIn.setBlockState(pos, Crop_Blocks.ENDEN_k.getDefaultState());
			}
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Blocks.SAND.getDefaultState() : this.getDefaultState();
	}

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction) {
		BlockState state = worldIn.getBlockState(source.offset(direction));
		return state.getBlock() == this;
	}

	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2);

		boolean north = canConnectTo(worldIn, pos, Direction.NORTH);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST);
		return state.with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.up());
		return !upState.getMaterial().isSolid() || upState.getBlock() instanceof FenceGateBlock || upState.getBlock() instanceof MovingPistonBlock;
	}

	/* Conditions for TickRandom. */
	public static void turnToSand(BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, Blocks.SAND.getDefaultState());
	}

	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if (!state.isValidPosition(worldIn, pos)) { turnToSand(state, worldIn, pos); }
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		BlockState upState = worldIn.getBlockState(pos.up());
		if (upState.getBlock() instanceof FlowingFluidBlock) { 
			if (rand.nextInt(2) == 0) { turnToSand(state, worldIn, pos); }
		}
		
		/** WATERLOGGED で水面より下と成るため pos.up() か **/
		if (!worldIn.canSeeSky(pos.up())) { }

		if (worldIn.canSeeSky(pos.up())) {

			int i = state.get(WET_1_9);

			if (!worldIn.isRainingAt(pos.up())) {
				if (i != 9) {
					if (worldIn.isDaytime()) {
						if (rand.nextInt(6) == 0) { worldIn.setBlockState(pos, state.with(WET_1_9, Integer.valueOf(i + 1)), 3); } }
	
					if (!worldIn.isDaytime()) { } }
				
				if (i == 9) { }
			}

			if (worldIn.isRainingAt(pos.up())) {
				if (i != 1) {
					if (rand.nextInt(2) == 0) { worldIn.setBlockState(pos, state.with(WET_1_9, Integer.valueOf(i - 1)), 3); } }
				
				if (i == 1) { }
			}
		}
	}

	/* Collision */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_9;
	}

	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(WET_1_9);
		return (i == 9)? AABB_9 : AABB_1;
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WET_1_9);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ENDEN);
	}

	/* Harvest ToolType. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.SHOVEL;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
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

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isViewBlocking(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_enden").applyTextStyle(TextFormatting.GRAY));
	}
}
