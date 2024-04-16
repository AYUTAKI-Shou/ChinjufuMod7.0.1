package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Soy extends BaseFarmCrop {

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0D * cw, -1.0D * cw, 0.0D * cw, 16.0D * cw, 1.0D * cw, 16.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 2.0D * cw, 15.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 3.0D * cw, 15.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 6.0D * cw, 15.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 8.0D * cw, 15.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 10.0D * cw, 15.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 12.0D * cw, 15.0D * cw),
			new AxisAlignedBB(1.0D * cw, -1.0D * cw, 1.0D * cw, 15.0D * cw, 12.0D * cw, 15.0D * cw) };

	public Soy(String name) {
		super(name);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	/* Cabbage 1, Corn 1, CCabbage 1, Onion 4, Rice 1, Soy 2, Spinach 1, Tomato 4 */
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		/* Property 0 1 2 3 4 5 6 (7) */
		int age = ((Integer)state.getValue(AGE)).intValue();
		Random rand = worldIn instanceof World ? ((World)worldIn).rand : new Random();
		int i = (rand.nextInt(5) == 0)? 3 + fortune : 2 + fortune;
		
		stack.add(new ItemStack(Items_Teatime.SEEDS_SOY, (age == 7)? i : 1, 0));
		stack.add(new ItemStack(Items_Teatime.SAYA, (age == 7)? 2 : 0, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.SEEDS_SOY, 1, 0);
	}
}

