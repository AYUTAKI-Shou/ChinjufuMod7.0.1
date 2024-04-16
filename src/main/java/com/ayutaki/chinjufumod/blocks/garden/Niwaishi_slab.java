package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_WallPane;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Niwaishi_slab extends Base_Niwaishi {
	
	protected static final AxisAlignedBB AABB_0 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 1.0, 0.75);
	protected static final AxisAlignedBB AABB_1 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_2 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.875, 0.75);
	protected static final AxisAlignedBB AABB_3 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.875, 1.0);
	protected static final AxisAlignedBB AABB_4 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.75, 0.75);
	protected static final AxisAlignedBB AABB_5 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.75, 1.0);
	protected static final AxisAlignedBB AABB_6 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.625, 0.75);
	protected static final AxisAlignedBB AABB_7 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.625, 1.0);
	protected static final AxisAlignedBB AABB_8 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.5, 0.75);
	protected static final AxisAlignedBB AABB_9 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.5, 1.0);
	protected static final AxisAlignedBB AABB_10 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.375, 0.75);
	protected static final AxisAlignedBB AABB_11 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.375, 1.0);
	protected static final AxisAlignedBB AABB_12 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.25, 0.75);
	protected static final AxisAlignedBB AABB_13 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.25, 1.0);
	protected static final AxisAlignedBB AABB_14 = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 0.125, 0.75);
	protected static final AxisAlignedBB AABB_15 = new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 0.125, 1.0);

	public Niwaishi_slab(String name) {
		super(name);
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		switch (i) {
		case 0 : 
		default : return AABB_0;
		case 1 : return AABB_1;
		case 2 : return AABB_2;
		case 3 : return AABB_3;
		case 4 : return AABB_4;
		case 5 : return AABB_5;
		case 6 : return AABB_6;
		case 7 : return AABB_7;
		case 8 : return AABB_8;
		case 9 : return AABB_9;
		case 10 : return AABB_10;
		case 11 : return AABB_11;
		case 12 : return AABB_12;
		case 13 : return AABB_13;
		case 14 : return AABB_14;
		case 15 : return AABB_15;
		} // switch
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		return (i == 0 || i == 1)? true : false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack());
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Garden_Blocks.NIWAISHI_slab) { return new ItemStack(Blocks.STONE_SLAB, 1, 0); }
		if (this == Garden_Blocks.NIWAISHI_slab_gra) { return new ItemStack(Items_WallPane.RGRA_slabhalf, 1, 0); }
		if (this == Garden_Blocks.NIWAISHI_slab_dio) { return new ItemStack(Items_WallPane.RDIO_slabhalf, 1, 0); }
		if (this == Garden_Blocks.NIWAISHI_slab_and) { return new ItemStack(Items_WallPane.RAND_slabhalf, 1, 0); }
		return null;
	}
}
