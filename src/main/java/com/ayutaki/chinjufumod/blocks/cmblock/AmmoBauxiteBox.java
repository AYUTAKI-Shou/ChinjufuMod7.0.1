package com.ayutaki.chinjufumod.blocks.cmblock;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AmmoBauxiteBox extends BaseFacingWater {

	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(0.01D, 0.0D, 0.01D, 15.99D, 15.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 15.99D, 16.0D, 1.0D),
			Block.box(0.01D, 0.0D, 15.0D, 15.99D, 16.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 1.0D, 16.0D, 15.99D),
			Block.box(15.0D, 0.0D, 0.01D, 15.99D, 16.0D, 15.99D));
	
	public AmmoBauxiteBox(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
}
