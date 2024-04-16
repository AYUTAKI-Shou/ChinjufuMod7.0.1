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

public class Niwaishi_slab extends Base_Niwaishi {

	/* Collision */
	protected static final VoxelShape AABB_0 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_1 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_2 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 14.0D, 12.0D);
	protected static final VoxelShape AABB_3 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 14.0D, 16.0D);
	protected static final VoxelShape AABB_4 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	protected static final VoxelShape AABB_5 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 12.0D, 16.0D);
	protected static final VoxelShape AABB_6 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 10.0D, 12.0D);
	protected static final VoxelShape AABB_7 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 10.0D, 16.0D);
	protected static final VoxelShape AABB_8 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 8.0D, 12.0D);
	protected static final VoxelShape AABB_9 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
	protected static final VoxelShape AABB_10 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 6.0D, 12.0D);
	protected static final VoxelShape AABB_11 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 6.0D, 16.0D);
	protected static final VoxelShape AABB_12 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 4.0D, 12.0D);
	protected static final VoxelShape AABB_13 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 4.0D, 16.0D);
	protected static final VoxelShape AABB_14 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 2.0D, 12.0D);
	protected static final VoxelShape AABB_15 = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 2.0D, 16.0D);

	public Niwaishi_slab(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_15);

		switch (i) {
		case 0 :
		default: return AABB_0;
		case 1: return AABB_1;
		case 2: return AABB_2;
		case 3: return AABB_3;
		case 4: return AABB_4;
		case 5: return AABB_5;
		case 6: return AABB_6;
		case 7: return AABB_7;
		case 8: return AABB_8;
		case 9: return AABB_9;
		case 10: return AABB_10;
		case 11: return AABB_11;
		case 12: return AABB_12;
		case 13: return AABB_13;
		case 14: return AABB_14;
		case 15: return AABB_15;
		} // switch
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		if (this == Garden_Blocks.NIWAISHI_slab_and.get()) { return new ItemStack(Items.ANDESITE_SLAB); }
		if (this == Garden_Blocks.NIWAISHI_slab_dio.get()) { return new ItemStack(Items.DIORITE_SLAB); }
		if (this == Garden_Blocks.NIWAISHI_slab_gra.get()) { return new ItemStack(Items.GRANITE_SLAB); }
		return new ItemStack(Items.STONE_SLAB);
	}
}
