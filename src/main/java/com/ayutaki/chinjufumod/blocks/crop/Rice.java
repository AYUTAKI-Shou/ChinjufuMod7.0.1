package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Rice extends BaseFarmCrop {

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0D * cw, -1.0D * cw, 0.0D * cw, 16.0D * cw, 2.0D * cw, 16.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 5.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 7.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 10.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 12.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw) };

	public Rice(String name) {
		super(name);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		return Items_Teatime.SEEDS_RICE;
	}

	@Override
	protected Item getCrop() {
		return Items_Teatime.INE;
	}

	/* Cabbage 1, Corn 1, CCabbage 1, Onion 4, Rice 1, Soy 2, Spinach 1, Tomato 4 */
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}
}
