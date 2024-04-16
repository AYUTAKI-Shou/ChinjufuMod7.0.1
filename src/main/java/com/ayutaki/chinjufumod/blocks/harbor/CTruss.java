package com.ayutaki.chinjufumod.blocks.harbor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CTruss extends BaseFacingSapo {

	public CTruss(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(0);
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.SOLID;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

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
		if (this == Harbor_Blocks.TRUSS_white) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 0); }
		if (this == Harbor_Blocks.TRUSS_orange) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 1); }
		if (this == Harbor_Blocks.TRUSS_magenta) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 2); }
		if (this == Harbor_Blocks.TRUSS_lightb) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 3); }
		if (this == Harbor_Blocks.TRUSS_yellow) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 4); }
		if (this == Harbor_Blocks.TRUSS_lime) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 5); }
		if (this == Harbor_Blocks.TRUSS_pink) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 6); }
		if (this == Harbor_Blocks.TRUSS_gray) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 7); }
		if (this == Harbor_Blocks.TRUSS) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 8); }
		if (this == Harbor_Blocks.TRUSS_cyan) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 9); }
		if (this == Harbor_Blocks.TRUSS_purple) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 10); }
		if (this == Harbor_Blocks.TRUSS_blue) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 11); }
		if (this == Harbor_Blocks.TRUSS_brown) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 12); }
		if (this == Harbor_Blocks.TRUSS_green) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 13); }
		if (this == Harbor_Blocks.TRUSS_red) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 14); }
		if (this == Harbor_Blocks.TRUSS_black) { return new ItemStack(Items_Chinjufu.TRUSS_item, 1, 15); }
		return null;
	}
}
