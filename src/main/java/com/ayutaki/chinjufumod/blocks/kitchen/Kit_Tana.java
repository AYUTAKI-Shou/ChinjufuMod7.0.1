package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Kit_Tana extends BaseFacingSapo {

	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, 0.0, 0.0, 0.625, 1.0, 1.0);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, 0.0, 0.0, 0.625, 1.0, 1.0);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, 0.0, 0.0, 0.625, 1.0, 1.0);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, 0.0, 0.0, 0.625, 1.0, 1.0);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public Kit_Tana(String name) {
		super(name, Material.WOOD);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		if (item == Items_Teatime.Item_SARA) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_SARA1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 5) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_TONSUI1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 1) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_YUNOMI1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 2) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_TCUP1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 3) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_CHAWAN1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 4) {
			CMEvents.Consume1Item_WDish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_SHIKKI1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 7) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_DRINKGLASS1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.Item_DISH && k == 6) {
			CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_DONBURI1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }

		if (item == Items_Teatime.SUSHIGETA_kara) {
			CMEvents.Consume1Item_WDish(worldIn, pos, playerIn, hand);
			
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_SUSHIGETA1
					.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }
		
		/* You don't have any usable items. */
		if (item != Items_Teatime.Item_SARA && item != Items_Teatime.Item_DISH && 
				item != Items_Teatime.SUSHIGETA_kara) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
			@Nullable Entity entityIn, boolean t_f) {
		EnumFacing facing = state.getValue(H_FACING);
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB[facing.getHorizontalIndex()]);
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/*Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kit_tana.name", meta));
	}

}
