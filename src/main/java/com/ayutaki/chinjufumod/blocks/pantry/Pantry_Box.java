package com.ayutaki.chinjufumod.blocks.pantry;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Pantry_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Pantry_Box extends BaseFacingSlab_Water {

	/* Collision */
	protected static final VoxelShape BOX_BOTTOM = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.makeCuboidShape(0.0D, 6.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.makeCuboidShape(15.5D, 6.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape BOX_TOP = VoxelShapes.or(Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.makeCuboidShape(0.0D, 14.0D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.makeCuboidShape(15.5D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.makeCuboidShape(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.makeCuboidShape(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape BOX_DOUBLE = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.makeCuboidShape(0.0D, 14.0D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.makeCuboidShape(15.5D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D));

	public Pantry_Box(Block.Properties properties) {
		super(properties);
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(stateIn, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60); }

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		SlabType slabType = state.get(TYPE);
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			
			if (slabType != SlabType.DOUBLE) { this.dropRottenfood(worldIn, pos); }
			if (slabType == SlabType.DOUBLE) { this.dropRottenfood2(worldIn, pos); }

			if (this == Pantry_Blocks.BOX_H_BEEF || this == Pantry_Blocks.BOX_H_CHICKEN || 
					this == Pantry_Blocks.BOX_H_COD || this == Pantry_Blocks.BOX_H_FISH || 
					this == Pantry_Blocks.BOX_H_MUTTON || this == Pantry_Blocks.BOX_H_PORK || 
					this == Pantry_Blocks.BOX_H_RABBIT || this == Pantry_Blocks.BOX_H_SALMON) {

				worldIn.setBlockState(pos, Pantry_Blocks.BOX_H_EMPTY2.getDefaultState()
						.with(BaseFacingSlab_Water.H_FACING, state.get(H_FACING))
						.with(BaseFacingSlab_Water.TYPE, state.get(TYPE))
						.with(BaseFacingSlab_Water.WATERLOGGED, state.get(WATERLOGGED))); }

			else {
				worldIn.setBlockState(pos, Pantry_Blocks.BOX_H_EMPTY.getDefaultState()
						.with(BaseFacingSlab_Water.H_FACING, state.get(H_FACING))
						.with(BaseFacingSlab_Water.TYPE, state.get(TYPE))
						.with(BaseFacingSlab_Water.WATERLOGGED, state.get(WATERLOGGED))); }
			}

		else { }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropRottenfood2(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD, 2);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	/* Collisions for each property. */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		SlabType slabType = state.get(TYPE);
		switch(slabType) {
		case DOUBLE:
			return BOX_DOUBLE;
		case TOP:
			return BOX_TOP;
		default:
			return BOX_BOTTOM;
		}
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
