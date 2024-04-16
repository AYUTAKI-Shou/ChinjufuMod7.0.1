package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TatamiSakura extends BaseTatamiWood {

	public TatamiSakura(String name) {
		super(name);
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		stack.add(new ItemStack(Items_Seasonal.SAKURA_slabhalf, 1, 0));
		return stack;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (this == JPDeco_Blocks.TATAMI_SAKURA_ew || this == JPDeco_Blocks.TATAMI_SAKURA_ns) { 
			if (i == 0) { return new ItemStack(Items_Wadeco.TATAMI_white, 1, 0); }
			if (i == 1) { return new ItemStack(Items_Wadeco.TATAMI_orange, 1, 0); }
			if (i == 2) { return new ItemStack(Items_Wadeco.TATAMI_magenta, 1, 0); }
			if (i == 3) { return new ItemStack(Items_Wadeco.TATAMI_lightb, 1, 0); }
			if (i == 4) { return new ItemStack(Items_Wadeco.TATAMI_yellow, 1, 0); }
			if (i == 5) { return new ItemStack(Items_Wadeco.TATAMI_lime, 1, 0); }
			if (i == 6) { return new ItemStack(Items_Wadeco.TATAMI_pink, 1, 0); }
			if (i == 7) { return new ItemStack(Items_Wadeco.TATAMI_gray, 1, 0); }
			if (i == 8) { return new ItemStack(Items_Wadeco.TATAMI_lightg, 1, 0); }
			if (i == 9) { return new ItemStack(Items_Wadeco.TATAMI_cyan, 1, 0); }
			if (i == 10) { return new ItemStack(Items_Wadeco.TATAMI_purple, 1, 0); }
			if (i == 11) { return new ItemStack(Items_Wadeco.TATAMI_blue, 1, 0); }
			if (i == 12) { return new ItemStack(Items_Wadeco.TATAMI_brown, 1, 0); }
			if (i == 13) { return new ItemStack(Items_Wadeco.TATAMI_green, 1, 0); }
			if (i == 14) { return new ItemStack(Items_Wadeco.TATAMI_red, 1, 0); }
			if (i == 15) { return new ItemStack(Items_Wadeco.TATAMI_black, 1, 0); }
		}
		
		if (this == JPDeco_Blocks.TATAMIY_SAKURA_ew || this == JPDeco_Blocks.TATAMIY_SAKURA_ns) { 
			if (i == 0) { return new ItemStack(Items_Wadeco.TATAMIY_white, 1, 0); }
			if (i == 1) { return new ItemStack(Items_Wadeco.TATAMIY_orange, 1, 0); }
			if (i == 2) { return new ItemStack(Items_Wadeco.TATAMIY_magenta, 1, 0); }
			if (i == 3) { return new ItemStack(Items_Wadeco.TATAMIY_lightb, 1, 0); }
			if (i == 4) { return new ItemStack(Items_Wadeco.TATAMIY_yellow, 1, 0); }
			if (i == 5) { return new ItemStack(Items_Wadeco.TATAMIY_lime, 1, 0); }
			if (i == 6) { return new ItemStack(Items_Wadeco.TATAMIY_pink, 1, 0); }
			if (i == 7) { return new ItemStack(Items_Wadeco.TATAMIY_gray, 1, 0); }
			if (i == 8) { return new ItemStack(Items_Wadeco.TATAMIY_lightg, 1, 0); }
			if (i == 9) { return new ItemStack(Items_Wadeco.TATAMIY_cyan, 1, 0); }
			if (i == 10) { return new ItemStack(Items_Wadeco.TATAMIY_purple, 1, 0); }
			if (i == 11) { return new ItemStack(Items_Wadeco.TATAMIY_blue, 1, 0); }
			if (i == 12) { return new ItemStack(Items_Wadeco.TATAMIY_brown, 1, 0); }
			if (i == 13) { return new ItemStack(Items_Wadeco.TATAMIY_green, 1, 0); }
			if (i == 14) { return new ItemStack(Items_Wadeco.TATAMIY_red, 1, 0); }
			if (i == 15) { return new ItemStack(Items_Wadeco.TATAMIY_black, 1, 0); }
		}
		return null;
	}
}
