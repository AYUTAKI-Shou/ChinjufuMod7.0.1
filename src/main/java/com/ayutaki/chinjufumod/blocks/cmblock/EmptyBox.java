package com.ayutaki.chinjufumod.blocks.cmblock;

import com.ayutaki.chinjufumod.blocks.base.BaseWaterLogged;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmptyBox extends BaseWaterLogged {

	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(0.01D, 0.0D, 0.01D, 15.99D, 1.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 15.99D, 16.0D, 1.0D),
			Block.box(0.01D, 0.0D, 15.0D, 15.99D, 16.0D, 15.99D),
			Block.box(0.01D, 0.0D, 0.01D, 1.0D, 16.0D, 15.99D),
			Block.box(15.0D, 0.0D, 0.01D, 15.99D, 16.0D, 15.99D));
	
	public EmptyBox(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}

	/* Flammable Block */
	/** IForgeBlock.class Called when fire is updating, checks if a block face can catch fire. **/
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	/** Called when fire is updating on a neighbor block. **/
	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	/**Chance that fire will spread and consume this block. 300 being a 100% chance, 0, being a 0% chance **/
	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
}
