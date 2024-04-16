package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class BaseFarmCrop extends BlockCrops {

	protected static final double cw = 0.0625;

	public BaseFarmCrop(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
	}
	
	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() instanceof BlockFarmland;
	}
}
