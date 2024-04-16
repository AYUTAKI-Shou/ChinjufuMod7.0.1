package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Kit_Cooktop_aida extends Base_Cooktop {

	public Kit_Cooktop_aida(String name) {
		super(name);
	}

	/* 点火 */
	@Override
	public int tickRate(World worldIn) {
		return 10;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, Kitchen_Blocks.KIT_STOVE_1, this.tickRate(worldIn));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		worldIn.scheduleUpdate(pos, Kitchen_Blocks.KIT_STOVE_1, this.tickRate(worldIn));
		worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
		worldIn.setBlockState(pos, Kitchen_Blocks.LIT_KITSTOVE.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
				.withProperty(TEPPAN, state.getValue(TEPPAN)));
	}
}
