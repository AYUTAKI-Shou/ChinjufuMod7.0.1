package com.ayutaki.chinjufumod.blocks.school;

import com.ayutaki.chinjufumod.blocks.base.BaseWaterLogged;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StoveChimney_top extends BaseWaterLogged {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(7.0D, 15.0D, 7.0D, 9.0D, 16.0D, 9.0D),
			Block.box(5.5D, 14.0D, 5.5D, 10.5D, 15.0D, 10.5D),
			Block.box(4.0D, 13.0D, 4.0D, 12.0D, 14.0D, 12.0D),
			Block.box(5.9D, 0.0D, 5.9D, 10.1D, 13.0D, 10.1D));

	public StoveChimney_top(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
}
