package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Items_Wablock;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Wall_Kawara extends Base_WallKawara {

	public Wall_Kawara(String name) {
		super(name);
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 0) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 0); }
		if (i == 1) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 4); }
		if (i == 5) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 5); }
		if (i == 6) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 6); }
		if (i == 7) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 7); }
		if (i == 8) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 8); }
		if (i == 9) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 9); }
		if (i == 10) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 10); }
		if (i == 11) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 11); }
		if (i == 12) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 12); }
		if (i == 13) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 13); }
		if (i == 14) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 14); }
		if (i == 15) { return new ItemStack(Items_Wablock.KAWARA_WALL, 1, 15); }
		return null;
	}
}
