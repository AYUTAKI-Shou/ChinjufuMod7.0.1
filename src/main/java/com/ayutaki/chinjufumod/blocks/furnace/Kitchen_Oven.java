package com.ayutaki.chinjufumod.blocks.furnace;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.tileentity.Oven_TileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

/* Abstract を用意する */
public class Kitchen_Oven extends AbstractOvenBlock {

	/* Collision */
	protected static final VoxelShape TOP = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(TOP, Block.makeCuboidShape(0.5D, 0.0D, 1.0D, 15.5D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(TOP, Block.makeCuboidShape(1.0D, 0.0D, 0.5D, 15.0D, 15.0D, 15.5D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(TOP, Block.makeCuboidShape(0.5D, 0.0D, 1.0D, 15.5D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(TOP, Block.makeCuboidShape(1.0D, 0.0D, 0.5D, 15.0D, 15.0D, 15.5D));

	public Kitchen_Oven(Block.Properties properties) {
		super(properties);
	}

	/* 生成する TileEntity */
	public TileEntity createNewTileEntity(IBlockReader world) {
		return new Oven_TileEntity();
	}

	protected void interactWith(World worldIn, BlockPos pos, PlayerEntity playerIn) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof Oven_TileEntity) {
			playerIn.openContainer((INamedContainerProvider)tileentity);
			playerIn.addStat(Stats.INTERACT_WITH_FURNACE);
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
