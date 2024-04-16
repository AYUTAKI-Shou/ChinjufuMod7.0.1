package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.state.TypeLR;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class IronFence_Top extends BaseFacingSapo {

	public static final PropertyEnum<TypeLR> TYPE = PropertyEnum.create("type", TypeLR.class);

	private static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB( 0.0D, 0.0D, 0.46875D, 1.0D, 1.6875D, 0.53125D);
	private static final AxisAlignedBB EAST_AABB = new AxisAlignedBB( 0.46875D, 0.0D, 0.0D, 0.53125D, 1.6875D, 1.0D);
	private static final AxisAlignedBB WEST_AABB = new AxisAlignedBB( 0.46875D, 0.0D, 0.0D, 0.53125D, 1.6875D, 1.0D);
	private static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB( 0.0D, 0.0D, 0.46875D, 1.0D, 1.6875D, 0.53125D);

	public IronFence_Top(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return SOUTH_AABB;
			
		case EAST:
			return EAST_AABB;
			
		case WEST:
			return WEST_AABB;
			
		case NORTH:
		default:
			return NORTH_AABB;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB);
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB);
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB);
			break;
		}
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = left_block.getBlock() instanceof IronFence_Top && left_block.getValue(H_FACING).equals(facing);
		boolean right = right_block.getBlock() instanceof IronFence_Top && right_block.getValue(H_FACING).equals(facing);

		 if (right) {

			if (left) { return state.withProperty(TYPE, TypeLR.BOTH); }

			else { return state.withProperty(TYPE, TypeLR.RIGHT); }
		}

		else if (left) {

			if (right) { return state.withProperty(TYPE, TypeLR.BOTH); }

			else { return state.withProperty(TYPE, TypeLR.LEFT); }
		}
		return state.withProperty(TYPE, TypeLR.DEFAULT);
	}


	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, TYPE });
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof IronFence_Bot) {
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
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
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
}
