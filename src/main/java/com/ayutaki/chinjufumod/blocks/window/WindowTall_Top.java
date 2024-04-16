package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WindowTall_Top extends BaseStage3_Face {

	/* Collision */
	protected static final AxisAlignedBB SOUTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB EAST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB WEST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);
	protected static final AxisAlignedBB EAST_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);
	protected static final AxisAlignedBB WEST_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);
	protected static final AxisAlignedBB EAST_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);
	protected static final AxisAlignedBB WEST_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);

	public WindowTall_Top(String name) {
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
			if (hitY > 0.03125) {
				worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_3), 2); }
			
			return true;
		}
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
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof WindowTall_Bottom) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.down(), false); }
			else { worldIn.destroyBlock(pos.down(), true); }
		}
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}
}
