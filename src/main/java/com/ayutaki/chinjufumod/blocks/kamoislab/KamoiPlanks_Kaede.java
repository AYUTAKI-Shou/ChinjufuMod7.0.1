package com.ayutaki.chinjufumod.blocks.kamoislab;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class KamoiPlanks_Kaede extends Base_KamoiPlank {

	public KamoiPlanks_Kaede(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.PILLARSLAB_kae.get());
	}
}
