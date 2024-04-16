package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Corn_Top extends BlockCrops {

	private static final double cw = 0.0625;
	public Corn_Top(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setTickRandomly(false);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(AGE)).intValue();
		
		if (i == 5) { new AxisAlignedBB(2.0D * cw, 0.0D * cw, 2.0D * cw, 14.0D * cw, 8.0D * cw, 14.0D * cw); } 
		if (i == 6) { new AxisAlignedBB(2.0D * cw, 0.0D * cw, 2.0D * cw, 14.0D * cw, 12.0D * cw, 14.0D * cw); } 
		if (i == 7) { new AxisAlignedBB(2.0D * cw, 0.0D * cw, 2.0D * cw, 14.0D * cw, 16.0D * cw, 14.0D * cw); } 
		return new AxisAlignedBB(0.499D, -1.0D, 0.499D, 0.501D, -0.5D, 0.501D);
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return false;
	}

	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Crop_Blocks.CORN;
	}

	@Override
	protected Item getSeed() {
		return Items_Teatime.SEEDS_CORN;
	}

	@Override
	protected Item getCrop() {
		return Items_Teatime.FOOD_CORN;
	}

	/* Cabbage 1, Corn 1, CCabbage 1, Onion 4, Rice 1, Soy 2, Spinach 1, Tomato 4 */
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();

		if (i > j) { i = j; }
		worldIn.setBlockState(pos, this.withAge(i));
		worldIn.setBlockState(pos.down(), Crop_Blocks.CORN.getDefaultState().withProperty(AGE, Integer.valueOf(i)));
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof Corn) {
			worldIn.destroyBlock(pos.down(), false);
		}
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
