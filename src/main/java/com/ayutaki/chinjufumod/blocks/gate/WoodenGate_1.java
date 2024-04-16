package com.ayutaki.chinjufumod.blocks.gate;

import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.state.HalfState;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class WoodenGate_1 extends BaseGate_Part1 {

	/* Collision */
	protected static final AxisAlignedBB LOW_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);

	protected static final AxisAlignedBB UP_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	protected static final AxisAlignedBB UP_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	protected static final AxisAlignedBB UP_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	protected static final AxisAlignedBB UP_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	
	public WoodenGate_1(Material material, String name) {
		super(material, name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
		
		/** Registry **/
		ForgeRegistries.BLOCKS.register(this);
	}
	
	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = (state.getValue(HALF) == HalfState.LOWER);
		boolean flag1 = ((Boolean)state.getValue(OPEN)).booleanValue();
		AxisAlignedBB AABB_EMPTY = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

		switch (direction) {
		case SOUTH:
			return flag1? AABB_EMPTY : (flag? LOW_SOUTH : UP_SOUTH);
			
		case EAST:
			return flag1? AABB_EMPTY : (flag? LOW_EAST : UP_EAST);
			
		case WEST:
			return flag1? AABB_EMPTY : (flag? LOW_WEST : UP_WEST);
			
		case NORTH:
		default:
			return flag1? AABB_EMPTY : (flag? LOW_NORTH : UP_NORTH);
		}
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {
		HalfState half = state.getValue(HALF);

		switch (half) {
		case LOWER:
		default:
			boolean flag = ((Boolean)state.getValue(OPEN)).booleanValue();
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, ((flag)? NULL_AABB : FULL_BLOCK_AABB));
			break;

		case UPPER:
			IBlockState downState = worldIn.getBlockState(pos.down()); 
			boolean flag1 = (downState.getBlock() == this && ((Boolean)downState.getValue(OPEN)).booleanValue());
			AxisAlignedBB UP_COLL = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
			
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, ((flag1)? NULL_AABB : UP_COLL));
			break;
		} // half
	}
}
