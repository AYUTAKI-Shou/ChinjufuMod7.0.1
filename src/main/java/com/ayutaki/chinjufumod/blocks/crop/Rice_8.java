package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Rice_8 extends Block implements net.minecraftforge.common.IPlantable, BonemealableBlock {

	/* Property */
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 8);
	
	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.box(0.0D, -3.0D, 0.0D, 16.0D, 1.0D, 16.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 3.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 5.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 9.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D),
			Block.box(2.0D, -3.0D, 2.0D, 14.0D, 13.0D, 14.0D) };

	public Rice_8(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	}
	
	/* Limit the place. */
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.getBlock() == Wood_Blocks.SUIDEN.get();
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		int i = state.getValue(AGE);

		if (i < 8 && worldIn.getRawBrightness(pos, 0) >= 9) {
			worldIn.scheduleTick(pos, Crop_Blocks.RICE_8.get(), 4500 + (300 * worldIn.getRandom().nextInt(5))); }

		return !(state.canSurvive(worldIn, pos)) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Limit the place. */
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		if (worldIn.getRawBrightness(pos, 0) >= 8 || worldIn.canSeeSky(pos)) {
			return this.mayPlaceOn(worldIn.getBlockState(downPos), worldIn, downPos); }
		
		return false;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState();
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPES[state.getValue(this.getAgeProperty())];
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, Crop_Blocks.RICE_8.get(), 4500 + (500 * worldIn.random.nextInt(5)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(AGE);

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (i < 8 && worldIn.getRawBrightness(pos, 0) >= 9) {
			worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 3);
			worldIn.scheduleTick(pos, Crop_Blocks.RICE_8.get(), 4500 + (500 * rand.nextInt(5))); }
		
		else { }
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_RICE.get());
	}
	
	/* Use Bonemeal */
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 8;
	}

	protected int getAge(BlockState state) {
		return state.getValue(this.getAgeProperty());
	}

	public BlockState withAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(BlockState state) {
		return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	public void growCrops(Level worldIn, BlockPos pos, BlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}
		worldIn.setBlock(pos, this.withAge(i), 2);
	}

	protected int getBonemealAgeIncrease(Level worldIn) {
		return Mth.nextInt(worldIn.random, 2, 5);
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState state) {
		return !this.isMaxAge(state);
	} // fix 20.2

	public void performBonemeal(ServerLevel worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		this.growCrops(worldIn, pos, state);
	}

	public boolean isBonemealSuccess(Level worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() != this) return defaultBlockState();
		return state;
	}
}
