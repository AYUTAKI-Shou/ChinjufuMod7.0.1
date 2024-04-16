package com.ayutaki.chinjufumod.blocks.window;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WindowTall_Bottom extends BaseStage3_Face {

	/* Collision */
	protected static final AxisAlignedBB SOUTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.0, 0.59375, 1.0625, 1.0);
	protected static final AxisAlignedBB EAST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.0, 0.59375, 1.0625, 1.0);
	protected static final AxisAlignedBB WEST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.0, 0.59375, 1.0625, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.0, 0.59375, 1.0625, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.5, 0.0, 0.59375, 1.5625, 1.0);
	protected static final AxisAlignedBB EAST_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.5, 0.0, 0.59375, 1.5625, 1.0);
	protected static final AxisAlignedBB WEST_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.5, 0.0, 0.59375, 1.5625, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.5, 0.0, 0.59375, 1.5625, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.875, 0.0, 0.59375, 1.9375, 1.0);
	protected static final AxisAlignedBB EAST_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.875, 0.0, 0.59375, 1.9375, 1.0);
	protected static final AxisAlignedBB WEST_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.875, 0.0, 0.59375, 1.9375, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.875, 0.0, 0.59375, 1.9375, 1.0);

	public WindowTall_Bottom(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return (i == 1)? SOUTH_AABB_CLOSE : ((i ==2)? SOUTH_AABB_2 : SOUTH_AABB_3);

		case EAST:
			return (i == 1)? EAST_AABB_CLOSE : ((i ==2)? EAST_AABB_2 : EAST_AABB_3);

		case WEST:
			return (i == 1)? WEST_AABB_CLOSE : ((i ==2)? WEST_AABB_2 : WEST_AABB_3);

		case NORTH:
		default:
			return (i == 1)? NORTH_AABB_CLOSE : ((i ==2)? NORTH_AABB_2 : NORTH_AABB_3);
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? SOUTH_AABB_CLOSE : ((i ==2)? SOUTH_AABB_2 : SOUTH_AABB_3));
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? EAST_AABB_CLOSE : ((i ==2)? EAST_AABB_2 : EAST_AABB_3));
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? WEST_AABB_CLOSE : ((i ==2)? WEST_AABB_2 : WEST_AABB_3));
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? NORTH_AABB_CLOSE : ((i ==2)? NORTH_AABB_2 : NORTH_AABB_3));
			break;
		}
	}

	/* RightClick Action */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Curtain_Item || item instanceof CurtainTall_Item) { return false; }

		else {
			if (hitY < 0.96875) {
				worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_3), 3); }
			
			return true;
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/* BlockState when it was placed. */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
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

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof WindowTall_Top) {
			worldIn.destroyBlock(pos.up(), false);
		}
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
		if (this == Window_Blocks.WINDOWTALLBOT_oak) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 0); }
		if (this == Window_Blocks.WINDOWTALLBOT_spruce) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 1); }
		if (this == Window_Blocks.WINDOWTALLBOT_birch) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 2); }
		if (this == Window_Blocks.WINDOWTALLBOT_jungle) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_acacia) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 4); }
		if (this == Window_Blocks.WINDOWTALLBOT_darkoak) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 5); }
		if (this == Window_Blocks.WINDOWTALLBOT_sakura) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 6); }
		if (this == Window_Blocks.WINDOWTALLBOT_kaede) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 7); }
		if (this == Window_Blocks.WINDOWTALLBOT_ichoh) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_item, 1, 8); }
		return null;
	}
}
