package com.ayutaki.chinjufumod.blocks.wallpane;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class WP_endtone extends BaseSimpleWP {

	public WP_endtone(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(15.0F);
		setLightOpacity(1);
	}
}
