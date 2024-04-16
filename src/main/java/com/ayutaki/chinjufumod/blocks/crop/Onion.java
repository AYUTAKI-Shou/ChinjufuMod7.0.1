package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Onion extends CropBlock {

	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D) };

	public Onion(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* Limit the place. */
	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmBlock;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPES[state.getValue(this.getAgeProperty())];
	}
	
	/* Clone Item in Creative. */
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_ONION.get());
	}
}
