package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.registry.Items_NoTab;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseTaru_Stage05 extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_5 = IntegerProperty.create("stage", 0, 5);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.25D, 8.0D, 0.25D, 15.75D, 12.0D, 15.75D),
			Block.box(0.5D, 4.0D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.75D, 0.0D, 0.75D, 15.25D, 4.0D, 15.25D));
	
	public BaseTaru_Stage05(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_0_5, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (inWater(state, worldIn, pos) == true) { worldIn.scheduleTick(pos, this, 100); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos) == true) { worldIn.scheduleTick(pos, this, 100); }
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.getValue(STAGE_0_5);

		if (i < 5 && rand.nextInt(4) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_0_5, Integer.valueOf(i + 1)), 3); }

		else { }
	}
	
	protected void dropRottenfood(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get());
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_5, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }

}
