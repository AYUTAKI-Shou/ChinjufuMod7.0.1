package com.ayutaki.chinjufumod.blocks.bamboo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BambooFence extends BlockFence {

	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {new AxisAlignedBB(0.40625D, 0.0D, 0.40625D, 0.59375D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.40625D, 0.59375D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.40625D, 0.59375D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.0D, 0.0D, 0.40625D, 0.59375D, 1.0D, 1.0D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.0D, 0.59375D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.0D, 0.59375D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.59375D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.59375D, 1.0D, 1.0D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.40625D, 1.0D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.40625D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.40625D, 1.0D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.0D, 0.0D, 0.40625D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.0D, 1.0D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.40625D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.59375D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};

	public static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.40625D, 0.0D, 0.40625D, 0.59375D, 1.5D, 0.59375D);
	public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.40625D, 0.0D, 0.59375D, 0.59375D, 1.5D, 1.0D);
	public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.40625D, 0.40625D, 1.5D, 0.59375D);
	public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.40625D, 0.0D, 0.0D, 0.59375D, 1.5D, 0.40625D);
	public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.59375D, 0.0D, 0.40625D, 1.0D, 1.5D, 0.59375D);


	public BambooFence(String name) {
		super(Material.WOOD, BlockPlanks.EnumType.OAK.getMapColor());
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.WOOD);
		setHardness(2.0F);
		setResistance(5.0F);
	}

	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
			@Nullable Entity entityIn, boolean isActualState) {

		if (!isActualState) { state = state.getActualState(worldIn, pos); }

		addCollisionBoxToList(pos, entityBox, collidingBoxes, PILLAR_AABB);

		if (((Boolean)state.getValue(NORTH)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB); }

		if (((Boolean)state.getValue(EAST)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB); }

		if (((Boolean)state.getValue(SOUTH)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB); }

		if (((Boolean)state.getValue(WEST)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB); }
	}

	private static int getBoundingBoxIdx(IBlockState state) {
		int i = 0;

		if (((Boolean)state.getValue(NORTH)).booleanValue()) { i |= 1 << EnumFacing.NORTH.getHorizontalIndex(); }

		if (((Boolean)state.getValue(EAST)).booleanValue()) { i |= 1 << EnumFacing.EAST.getHorizontalIndex(); }

		if (((Boolean)state.getValue(SOUTH)).booleanValue()) { i |= 1 << EnumFacing.SOUTH.getHorizontalIndex(); }

		if (((Boolean)state.getValue(WEST)).booleanValue()) { i |= 1 << EnumFacing.WEST.getHorizontalIndex(); }

		return i;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return BOUNDING_BOXES[getBoundingBoxIdx(state)];
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

	public ItemStack takeStack() {
		if (this == JPDeco_Blocks.TAKEFENCE) { return new ItemStack(Items_Wadeco.TAKEFENCE, 1, 0); }
		if (this == JPDeco_Blocks.TAKEFENCE_Y) { return new ItemStack(Items_Wadeco.TAKEFENCE, 1, 1); }
		if (this == JPDeco_Blocks.TAKEFENCE_K) { return new ItemStack(Items_Wadeco.TAKEFENCE, 1, 2); }
		return null;
	}
}
