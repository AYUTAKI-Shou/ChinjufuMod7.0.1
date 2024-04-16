package com.ayutaki.chinjufumod.blocks.furnace;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.BlockEntity_CM;
import com.ayutaki.chinjufumod.tileentity.Oven_TileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Kitchen_Oven extends AbstractOvenBlock {

	/* Collision */
	protected static final VoxelShape TOP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = Shapes.or(TOP, Block.box(0.5D, 0.0D, 1.0D, 15.5D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = Shapes.or(TOP, Block.box(1.0D, 0.0D, 0.5D, 15.0D, 15.0D, 15.5D));
	protected static final VoxelShape AABB_NORTH = Shapes.or(TOP, Block.box(0.5D, 0.0D, 1.0D, 15.5D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = Shapes.or(TOP, Block.box(1.0D, 0.0D, 0.5D, 15.0D, 15.0D, 15.5D));

	public Kitchen_Oven(BlockBehaviour.Properties properties) {
		super(properties);
	}

	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new Oven_TileEntity(pos, state);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level worldIn, BlockState state, BlockEntityType<T> blockEntity) {
		return createFurnaceTicker(worldIn, blockEntity, BlockEntity_CM.KIT_OVEN.get());
	}
	 
	protected void openContainer(Level worldIn, BlockPos pos, Player playerIn) {
		BlockEntity blockentity = worldIn.getBlockEntity(pos);
		if (blockentity instanceof Oven_TileEntity) {
			playerIn.openMenu((MenuProvider)blockentity);
			playerIn.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}
}
