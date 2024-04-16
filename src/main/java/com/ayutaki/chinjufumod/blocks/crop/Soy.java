package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Soy extends CropsBlock {

	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 2.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 3.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 6.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 8.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 10.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 12.0D, 15.0D),
			Block.box(1.0D, -1.0D, 1.0D, 15.0D, 12.0D, 15.0D) };

	public Soy(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Limit the place. */
	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES[state.getValue(this.getAgeProperty())];
	}

	/* Clone Item in Creative. */
	@Override
	protected IItemProvider getBaseSeedId() {
		return Items_Teatime.SEEDS_SOY;
	}
}
