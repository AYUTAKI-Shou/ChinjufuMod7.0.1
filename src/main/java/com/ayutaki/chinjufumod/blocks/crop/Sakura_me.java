package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Sakura_me extends BaseFarmCrop {

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0D * cw, -1.0D * cw, 0.0D * cw, 16.0D * cw, 3.0D * cw, 16.0D * cw),
			new AxisAlignedBB(5.0D * cw, -1.0D * cw, 5.0D * cw, 11.0D * cw, 8.0D * cw, 11.0D * cw),
			new AxisAlignedBB(4.0D * cw, -1.0D * cw, 4.0D * cw, 12.0D * cw, 8.0D * cw, 12.0D * cw),
			new AxisAlignedBB(4.0D * cw, -1.0D * cw, 4.0D * cw, 12.0D * cw, 10.0D * cw, 12.0D * cw),
			new AxisAlignedBB(4.0D * cw, -1.0D * cw, 4.0D * cw, 12.0D * cw, 12.0D * cw, 12.0D * cw),
			new AxisAlignedBB(3.0D * cw, -1.0D * cw, 3.0D * cw, 13.0D * cw, 12.0D * cw, 13.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 13.0D * cw, 14.0D * cw, 14.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 15.0D * cw, 15.0D * cw) };

	public Sakura_me(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	/* 育ちきったら苗木を回収できる */
	@Override
	protected Item getSeed() {
		return Item.getItemFromBlock(Blocks.AIR);
	}

	@Override
	protected Item getCrop() {
		return Item.getItemFromBlock(Blocks.AIR);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = state.getValue(AGE).intValue();

		if (i != 7) { stack.add(new ItemStack(Items_Teatime.SEEDS_CHERRY, 1, 0)); }
		if (i == 7) { stack.add(new ItemStack(Seasonal_Blocks.SAKURA_nae, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.SEEDS_CHERRY, 1, 0);
	}
}
