package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Hamaguri extends Block {

	/* Collision */
	protected static final AxisAlignedBB AABB_BOX = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.125D, 0.6875D);

	public Hamaguri(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setSoundType(SoundType.SNOW);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);

		this.setDefaultState(this.blockState.getBaseState());
	}
	
	/* RandomTick */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, Crop_Blocks.HAMAGURI, 2);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		if (hasWater(worldIn, pos)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos.down(), Crop_Blocks.KAINASHI.getDefaultState(), 3);
			worldIn.setBlockState(pos, Blocks.WATER.getDefaultState(), 3);
			worldIn.scheduleUpdate(pos, Crop_Blocks.HAMAGURI, 2); }
		
		if (!hasWater(worldIn, pos)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos.down(), Crop_Blocks.KAINASHI.getDefaultState(), 3);
			worldIn.setBlockToAir(pos);
			worldIn.scheduleUpdate(pos, Crop_Blocks.HAMAGURI, 2); }
	}
	
	private boolean hasWater(World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		return (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial() == Material.WATER);
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB_BOX;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}
	
	/* Rendering */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
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

	public boolean isReplaceable() { return true; }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_chestnut.name", meta));
	}
}
