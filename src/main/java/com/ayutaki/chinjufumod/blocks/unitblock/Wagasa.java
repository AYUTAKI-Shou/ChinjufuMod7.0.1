package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Wagasa extends Block {

	public static final PropertyBool BACK = PropertyBool.create("back");
	public static final PropertyBool FORWARD = PropertyBool.create("forward");
	public static final PropertyBool LEFT = PropertyBool.create("left");
	public static final PropertyBool RIGHT = PropertyBool.create("right");

	public Wagasa(String name, MapColor color) {
		super(Material.CLOTH, color);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.CLOTH);
		setHardness(0.8F);
		setResistance(1.0F);
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(BACK, false)
				.withProperty(FORWARD, false)
				.withProperty(LEFT, false)
				.withProperty(RIGHT, false));
	}

	@Override
	public boolean isSideSolid(IBlockState baseState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {

		if (side == EnumFacing.UP) { return true; }
		return false;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		boolean back = worldIn.getBlockState(pos.south()).getBlock() == this;
		boolean forward = worldIn.getBlockState(pos.north()).getBlock() == this;
		boolean left = worldIn.getBlockState(pos.west()).getBlock() == this;
		boolean right = worldIn.getBlockState(pos.east()).getBlock() == this;
		return state.withProperty(BACK, back).withProperty(FORWARD, forward).withProperty(LEFT, left).withProperty(RIGHT, right);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { BACK, FORWARD, LEFT, RIGHT });
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
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
		if (this == Garden_Blocks.KASA_white) { return new ItemStack(Items_Wadeco.KASA_item, 1, 0); }
		if (this == Garden_Blocks.KASA_orange) { return new ItemStack(Items_Wadeco.KASA_item, 1, 1); }
		if (this == Garden_Blocks.KASA_magenta) { return new ItemStack(Items_Wadeco.KASA_item, 1, 2); }
		if (this == Garden_Blocks.KASA_lightb) { return new ItemStack(Items_Wadeco.KASA_item, 1, 3); }
		if (this == Garden_Blocks.KASA_yellow) { return new ItemStack(Items_Wadeco.KASA_item, 1, 4); }
		if (this == Garden_Blocks.KASA_lime) { return new ItemStack(Items_Wadeco.KASA_item, 1, 5); }
		if (this == Garden_Blocks.KASA_pink) { return new ItemStack(Items_Wadeco.KASA_item, 1, 6); }
		if (this == Garden_Blocks.KASA_gray) { return new ItemStack(Items_Wadeco.KASA_item, 1, 7); }
		if (this == Garden_Blocks.KASA_lightg) { return new ItemStack(Items_Wadeco.KASA_item, 1, 8); }
		if (this == Garden_Blocks.KASA_cyan) { return new ItemStack(Items_Wadeco.KASA_item, 1, 9); }
		if (this == Garden_Blocks.KASA_purple) { return new ItemStack(Items_Wadeco.KASA_item, 1, 10); }
		if (this == Garden_Blocks.KASA_blue) { return new ItemStack(Items_Wadeco.KASA_item, 1, 11); }
		if (this == Garden_Blocks.KASA_brown) { return new ItemStack(Items_Wadeco.KASA_item, 1, 12); }
		if (this == Garden_Blocks.KASA_green) { return new ItemStack(Items_Wadeco.KASA_item, 1, 13); }
		if (this == Garden_Blocks.KASA_red) { return new ItemStack(Items_Wadeco.KASA_item, 1, 14); }
		if (this == Garden_Blocks.KASA_black) { return new ItemStack(Items_Wadeco.KASA_item, 1, 15); }
		return null;
	}
}
