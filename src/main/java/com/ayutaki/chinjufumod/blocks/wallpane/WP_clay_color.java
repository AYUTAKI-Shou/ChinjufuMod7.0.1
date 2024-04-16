package com.ayutaki.chinjufumod.blocks.wallpane;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class WP_clay_color extends BaseSimpleWP {

	public WP_clay_color(String name) {
		super(name, Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WALLPANEL);

		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}
}
