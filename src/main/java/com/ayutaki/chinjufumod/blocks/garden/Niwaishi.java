package com.ayutaki.chinjufumod.blocks.garden;

import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Niwaishi extends Base_Niwaishi {

	/* Collision */
	protected static final VoxelShape AABB_0 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 16.0D, 13.5D);
	protected static final VoxelShape AABB_2 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 14.0D, 13.5D);
	protected static final VoxelShape AABB_4 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 12.0D, 13.5D);
	protected static final VoxelShape AABB_6 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 10.0D, 13.5D);
	protected static final VoxelShape AABB_8 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 8.0D, 13.5D);
	protected static final VoxelShape AABB_10 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 6.0D, 13.5D);
	protected static final VoxelShape AABB_12 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 4.0D, 13.5D);
	protected static final VoxelShape AABB_14 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 2.0D, 13.5D);

	public Niwaishi(Block.Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_0_15);

		switch (i) {
		case 0:
		case 1: 
		default:
			return AABB_0;
		case 2:
		case 3: 
			return AABB_2;
		case 4:
		case 5:
			return AABB_4;
		case 6:
		case 7: 
			return AABB_6;
		case 8:
		case 9: 
			return AABB_8;
		case 10:
		case 11: 
			return AABB_10;
		case 12:
		case 13: 
			return AABB_12;
		case 14:
		case 15: 
			return AABB_14;
		} // switch
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {

		if (this == Garden_Blocks.NIWAISHI_and) { return new ItemStack(Items.ANDESITE); }
		if (this == Garden_Blocks.NIWAISHI_dio) { return new ItemStack(Items.DIORITE); }
		if (this == Garden_Blocks.NIWAISHI_gra) { return new ItemStack(Items.GRANITE); }
		return new ItemStack(Items.STONE);
	}

}
