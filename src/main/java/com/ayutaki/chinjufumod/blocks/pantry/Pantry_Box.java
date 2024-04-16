package com.ayutaki.chinjufumod.blocks.pantry;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Pantry_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pantry_Box extends BaseFacingSlab_Water {

	/* Collision */
	protected static final VoxelShape BOX_BOTTOM = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 6.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 6.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape BOX_TOP = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 14.0D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 14.0D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape BOX_DOUBLE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 14.0D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 14.0D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D));

	public Pantry_Box(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, this, 60); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, this, 60);
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		SlabType slabType = state.getValue(TYPE);

		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);

			if (slabType != SlabType.DOUBLE) { this.dropRottenfood(worldIn, pos); }
			if (slabType == SlabType.DOUBLE) { this.dropRottenfood2(worldIn, pos); }

			if (this == Pantry_Blocks.BOX_H_BEEF.get() || this == Pantry_Blocks.BOX_H_CHICKEN.get() || 
					this == Pantry_Blocks.BOX_H_COD.get() || this == Pantry_Blocks.BOX_H_FISH.get() || 
					this == Pantry_Blocks.BOX_H_MUTTON.get() || this == Pantry_Blocks.BOX_H_PORK.get() || 
					this == Pantry_Blocks.BOX_H_RABBIT.get() || this == Pantry_Blocks.BOX_H_SALMON.get()) {

				worldIn.setBlock(pos, Pantry_Blocks.BOX_H_EMPTY2.get().defaultBlockState()
						.setValue(BaseFacingSlab_Water.H_FACING, state.getValue(H_FACING))
						.setValue(BaseFacingSlab_Water.TYPE, state.getValue(TYPE))
						.setValue(BaseFacingSlab_Water.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }

			else {
				worldIn.setBlock(pos, Pantry_Blocks.BOX_H_EMPTY.get().defaultBlockState()
						.setValue(BaseFacingSlab_Water.H_FACING, state.getValue(H_FACING))
						.setValue(BaseFacingSlab_Water.TYPE, state.getValue(TYPE))
						.setValue(BaseFacingSlab_Water.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
			}

		else { }
	}

	protected void dropRottenfood(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get());
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropRottenfood2(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get(), 2);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		SlabType slabType = state.getValue(TYPE);
		switch (slabType) {
		case DOUBLE:
			return BOX_DOUBLE;
		case TOP:
			return BOX_TOP;
		default:
			return BOX_BOTTOM;
		}
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
	
}
