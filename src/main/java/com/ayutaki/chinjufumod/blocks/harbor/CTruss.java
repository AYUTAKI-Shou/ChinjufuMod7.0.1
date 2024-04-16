package com.ayutaki.chinjufumod.blocks.harbor;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CTruss extends BaseFacingWater {

	public CTruss(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Opaque 0.0F -> 1.0F Transparent */
	@Override
	public float getShadeBrightness(BlockState state, BlockGetter world, BlockPos pos) {
		return 1.0F;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter world, BlockPos pos) {
		return true;
	}
}
