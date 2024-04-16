package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Rice_8 extends Block implements IGrowable {

	/* Property */
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 8);

	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.makeCuboidShape(0.0D, -3.0D, 0.0D, 16.0D, 1.0D, 16.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 3.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 5.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 9.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.makeCuboidShape(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D) };

	public Rice_8(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	/* Limit the place. */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() == Wood_Blocks.SUIDEN;
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		int i = stateIn.get(AGE);

		if (i < 8 && worldIn.getLightSubtracted(pos, 0) >= 9) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Crop_Blocks.RICE_8, 4500 + (300 * worldIn.getRandom().nextInt(5)));
		}

		return !stateIn.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		if (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.canSeeSky(pos)) {
			return this.isValidGround(worldIn.getBlockState(downPos), worldIn, downPos);
		}
		return false;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState();
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES[state.get(this.getAgeProperty())];
	}

	/* TickRandom 個体差回避の為 PendingBlockTicks() を採用 */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, Crop_Blocks.RICE_8, 4500 + (500 * worldIn.rand.nextInt(5)));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(AGE);

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (i < 8 && worldIn.getLightSubtracted(pos, 0) >= 9) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)));
			worldIn.getPendingBlockTicks().scheduleTick(pos, Crop_Blocks.RICE_8, 4500 + (500 * rand.nextInt(5)));
		}
		else { }
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_RICE);
	}
	
	/* Use Bonemeal. */
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 8;
	}

	protected int getAge(BlockState state) {
		return state.get(this.getAgeProperty());
	}

	public BlockState withAge(int age) {
		return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(BlockState state) {
		return state.get(this.getAgeProperty()) >= this.getMaxAge();
	}

	public void grow(World worldIn, BlockPos pos, BlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}
		worldIn.setBlockState(pos, this.withAge(i), 2);
	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.rand, 2, 5);
	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		this.grow(worldIn, pos, state);
	}
}
/*
24000tick=20min. 1200=1min.
good 48000tick=40min. 7*7000
bad 96000tick=80min. 7*14000
 */
