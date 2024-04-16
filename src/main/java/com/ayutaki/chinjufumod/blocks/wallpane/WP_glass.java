package com.ayutaki.chinjufumod.blocks.wallpane;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class WP_glass extends BaseSimpleWP {

	public WP_glass(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.GLASS);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
