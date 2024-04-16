package com.ayutaki.chinjufumod.blocks.chair;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.entity.helper.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Zaisu extends BaseFacingSapo {

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.1875, 0.9375);

	private static final AxisAlignedBB CHAIR_BASE = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.1875, 0.875);
	private static final AxisAlignedBB CHAIR_BACKREST_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, 0.1875, 0.125, 0.1875, 0.875, 0.875);
	private static final AxisAlignedBB CHAIR_BACKREST_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, 0.1875, 0.125, 0.1875, 0.875, 0.875);
	private static final AxisAlignedBB CHAIR_BACKREST_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, 0.1875, 0.125, 0.1875, 0.875, 0.875);
	private static final AxisAlignedBB CHAIR_BACKREST_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, 0.1875, 0.125, 0.1875, 0.875, 0.875);

	public Zaisu(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			if (SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 0 * 0.0625)) {
				worldIn.updateComparatorOutputLevel(pos, this);
				CMEvents.soundKinuzure(worldIn, pos);
				return true;
			}
		}
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		if (!(entityIn instanceof SitableEntity)) {

			EnumFacing direction= state.getValue(H_FACING);
			switch(direction) {
			case SOUTH:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_SOUTH);
				break;
				
			case EAST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_EAST);
				break;
				
			case WEST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_WEST);
				break;
				
			case NORTH:
			default:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_NORTH);
				break;
			}
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BASE);
		}
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return SittableUtil.isSomeoneSitting(worldIn, pos.getX(), pos.getY(), pos.getZ()) ? 1 : 0;
	}


	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
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
		if (this == JPDeco_Blocks.ZAISU_white) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 0); }
		if (this == JPDeco_Blocks.ZAISU_orange) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 1); }
		if (this == JPDeco_Blocks.ZAISU_magenta) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 2); }
		if (this == JPDeco_Blocks.ZAISU_lightb) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 3); }
		if (this == JPDeco_Blocks.ZAISU_yellow) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 4); }
		if (this == JPDeco_Blocks.ZAISU_lime) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 5); }
		if (this == JPDeco_Blocks.ZAISU_pink) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 6); }
		if (this == JPDeco_Blocks.ZAISU_gray) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 7); }
		if (this == JPDeco_Blocks.ZAISU_lightg) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 8); }
		if (this == JPDeco_Blocks.ZAISU_cyan) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 9); }
		if (this == JPDeco_Blocks.ZAISU_purple) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 10); }
		if (this == JPDeco_Blocks.ZAISU_blue) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 11); }
		if (this == JPDeco_Blocks.ZAISU_brown) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 12); }
		if (this == JPDeco_Blocks.ZAISU_green) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 13); }
		if (this == JPDeco_Blocks.ZAISU_red) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 14); }
		if (this == JPDeco_Blocks.ZAISU_black) { return new ItemStack(Items_Wadeco.ZAISU_item, 1, 15); }
		return null;
	}
}
