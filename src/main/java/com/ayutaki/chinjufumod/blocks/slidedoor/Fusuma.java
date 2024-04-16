package com.ayutaki.chinjufumod.blocks.slidedoor;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Fusuma extends BaseFusuma {

	public Fusuma(String name) {
		super(name, Material.WOOD);
		/** Registry **/
		ForgeRegistries.BLOCKS.register(this);
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
		if (state.getValue(HALF) == HalfState.UPPER) { return new ItemStack(Items.AIR); }
		
		if (state.getValue(HALF) != HalfState.UPPER) {
			if (this == Fusuma_Blocks.FUSUMA_white) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 0); }
			if (this == Fusuma_Blocks.FUSUMA_orange) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 1); }
			if (this == Fusuma_Blocks.FUSUMA_magenta) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 2); }
			if (this == Fusuma_Blocks.FUSUMA_lightblue) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 3); }
			if (this == Fusuma_Blocks.FUSUMA_yellow) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 4); }
			if (this == Fusuma_Blocks.FUSUMA_lime) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 5); }
			if (this == Fusuma_Blocks.FUSUMA_pink) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 6); }
			if (this == Fusuma_Blocks.FUSUMA_gray) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 7); }
			if (this == Fusuma_Blocks.FUSUMA_lightgray) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 8); }
			if (this == Fusuma_Blocks.FUSUMA_cyan) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 9); }
			if (this == Fusuma_Blocks.FUSUMA_purple) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 10); }
			if (this == Fusuma_Blocks.FUSUMA_blue) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 11); }
			if (this == Fusuma_Blocks.FUSUMA_brown) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 12); }
			if (this == Fusuma_Blocks.FUSUMA_green) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 13); }
			if (this == Fusuma_Blocks.FUSUMA_red) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 14); }
			if (this == Fusuma_Blocks.FUSUMA_black) { return new ItemStack(Items_Wadeco.FUSUMA_item, 1, 15); } }
		return null;
	}
}
