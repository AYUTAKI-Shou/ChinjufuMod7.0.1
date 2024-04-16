package com.ayutaki.chinjufumod.blocks.garden;

import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Niwaishi extends Base_Niwaishi {

	/* Collision */
	protected static final VoxelShape AABB_0 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 16.0D, 13.5D);
	protected static final VoxelShape AABB_2 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 14.0D, 13.5D);
	protected static final VoxelShape AABB_4 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 12.0D, 13.5D);
	protected static final VoxelShape AABB_6 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 10.0D, 13.5D);
	protected static final VoxelShape AABB_8 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 8.0D, 13.5D);
	protected static final VoxelShape AABB_10 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 6.0D, 13.5D);
	protected static final VoxelShape AABB_12 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 4.0D, 13.5D);
	protected static final VoxelShape AABB_14 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 2.0D, 13.5D);

	public Niwaishi(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_15);

		switch (i) {
		case 0 :
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
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		if (this == Garden_Blocks.NIWAISHI_and.get()) { return new ItemStack(Items.ANDESITE); }
		if (this == Garden_Blocks.NIWAISHI_dio.get()) { return new ItemStack(Items.DIORITE); }
		if (this == Garden_Blocks.NIWAISHI_gra.get()) { return new ItemStack(Items.GRANITE); }
		return new ItemStack(Items.STONE);
	}
}
