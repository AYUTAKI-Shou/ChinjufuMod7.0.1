package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk_sub;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Glass_Wine extends Block {

	/* Property */
	/** 1=ワイン 2 3, 4=熟成ワイン 5 6, 7=シードル 8 9, 10=熟成シードル 11 12, 13=甘酒 14 15 **/
	public static final PropertyInteger STAGE_1_15 = PropertyInteger.create("stage", 1, 15);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.425D, 0.0D, 0.425D, 0.575D, 0.3125D, 0.575D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.425D, -0.5D, 0.425D, 0.575D, 0.01D, 0.575D);
	private static final AxisAlignedBB AABB2 = new AxisAlignedBB(0.425D, 0.0D, 0.425D, 0.575D, 0.2D, 0.575D);
	private static final AxisAlignedBB AABB_DOWN2 = new AxisAlignedBB(0.425D, -0.5D, 0.425D, 0.575D, 0.01D, 0.575D);

	public Glass_Wine(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(STAGE_1_15, Integer.valueOf(1))
				.withProperty(DOWN, Boolean.valueOf(false)));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);

		/** 1=ワイン 2 3, 4=熟成ワイン 5 6, 7=シードル 8 9, 10=熟成シードル 11 12, 13=甘酒 14 15 **/
		int i = ((Integer)state.getValue(STAGE_1_15)).intValue();

		/** Hand is Empty. **/
		if (stack.isEmpty()) {

			if (i != 3 && i != 6 && i != 9 && i != 12 && i != 15) {
				CMEvents.soundDrink(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_15, Integer.valueOf(i + 1)), 3);

				/* ワイン */
				if (i == 1) {
					/** 1秒＝20 酒は ×60=1200 **/
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1200, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1400, 0)); }

				if (i == 2) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1500, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1720, 0)); }

				/* 熟成ワイン */
				if (i == 4) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1200, 1));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 0)); }

				if (i == 5) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1500, 1));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1500, 0)); }


				/* シードル */
				if (i == 7) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1200, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1400, 0)); }

				if (i == 8) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1500, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1720, 0)); }

				/* 熟成シードル */
				if (i == 10) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1200, 1));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 0)); }

				if (i == 11) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1500, 1));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1500, 0)); }


				/* 甘酒 */
				if (i == 13) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.HASTE, 1200, 0)); }

				if (i == 14) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.HASTE, 1200, 0)); }
			}
			
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* Data value */
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_1_15)).intValue();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_1_15, Integer.valueOf(meta));
	}

	@Override
	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (9 - ((Integer)state.getValue(STAGE_1_15)).intValue()) * 2;
	}

	/*Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** 1=ワイン 2 3, 4=熟成ワイン 5 6, 7=シードル 8 9, 10=熟成シードル 11 12, 13=甘酒 14 15 **/
		int i = ((Integer)state.getValue(STAGE_1_15)).intValue();

		if (i <= 6) { return flag? AABB : AABB_DOWN; }
		return flag? AABB2 : AABB_DOWN2;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* Reaction to Neighboring blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		return block instanceof Chabudai || block instanceof LowDesk || block instanceof Kotatsu ||
					block instanceof Chabudai_sub || block instanceof LowDesk_sub || block instanceof Kotatsu_sub ||
					(block instanceof BaseFacingSlabW && state.getValue(BaseFacingSlabW.HALF) == SlabHalf.BOTTOM && state.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabW && state.getValue(BaseSlabW.HALF) == SlabHalf.BOTTOM && state.getValue(BaseSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabWType2 && state.getValue(BaseSlabWType2.HALF) == SlabHalf.BOTTOM && state.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(block instanceof BlockHalfWoodSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlabNew && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()));
	}

	/*Create BlockStates in this block. */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOWN, STAGE_1_15 });
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

	/* Drop Item and Clone Item. */
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/** 1=ワイン 2 3, 4=熟成ワイン 5 6, 7=シードル 8 9, 10=熟成シードル 11 12, 13=甘酒 14 15 **/
		int i = ((Integer)state.getValue(STAGE_1_15)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.WINEGLASS, 1, 1)); }
		if (i == 4) { stack.add(new ItemStack(Items_Teatime.WINEGLASS, 1, 2)); }
		if (i == 7) { stack.add(new ItemStack(Items_Teatime.WINEGLASS, 1, 3)); }
		if (i == 10) { stack.add(new ItemStack(Items_Teatime.WINEGLASS, 1, 4)); }
		if (i == 13) { stack.add(new ItemStack(Items_Teatime.SAKEGLASS, 1, 4)); }
		if (i == 14 || i == 15) { stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 1)); }
		if (i != 1 && i != 4 && i != 7 && i != 10 && i != 13 && i != 14 && i != 15) {
			stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 7)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		/** 1=ワイン 2 3, 4=熟成ワイン 5 6, 7=シードル 8 9, 10=熟成シードル 11 12, 13=甘酒 14 15 **/
		int i = ((Integer)state.getValue(STAGE_1_15)).intValue();

		if (i == 1 || i == 2) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 1); }
		if (i == 4 || i == 5) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 2); }
		if (i == 7 || i == 8) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 3); }
		if (i == 10 || i == 11) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 4); }
		if (i == 13 || i == 14) { return new ItemStack(Items_Teatime.SAKEGLASS, 1, 4); }
		if (i == 15) { return new ItemStack(Items_Teatime.Item_DISH, 1, 1); }
		return new ItemStack(Items_Teatime.Item_DISH, 1, 7);
	}
}
