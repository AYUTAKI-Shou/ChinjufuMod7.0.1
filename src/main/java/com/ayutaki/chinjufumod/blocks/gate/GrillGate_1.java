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

public class GrillGate_1 extends BaseGate_Part1 {

	/* Collision */
	protected static final AxisAlignedBB LOW_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.46875, 0.0, 0.0, 0.53125, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.46875, 0.0, 0.0, 0.53125, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.46875, 0.0, 0.0, 0.53125, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.46875, 0.0, 0.0, 0.53125, 1.0, 1.0);

	protected static final AxisAlignedBB UP_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.46875, 0.0, 0.0, 0.53125, 2.0, 1.0);
	protected static final AxisAlignedBB UP_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.46875, 0.0, 0.0, 0.53125, 2.0, 1.0);
	protected static final AxisAlignedBB UP_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.46875, 0.0, 0.0, 0.53125, 2.0, 1.0);
	protected static final AxisAlignedBB UP_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.46875, 0.0, 0.0, 0.53125, 2.0, 1.0);
	
	public GrillGate_1(Material material, String name) {
		super(material, name);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(20.0F);
		setLightOpacity(0);
		
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

		IBlockState upState = worldIn.getBlockState(pos.up()); 
		IBlockState downState = worldIn.getBlockState(pos.down());
		
		if (half == HalfState.LOWER) {
			if (upState.getBlock() == this && upState.getValue(HALF) == HalfState.UPPER) {
				EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
				boolean flag = ((Boolean)state.getValue(OPEN)).booleanValue();
				
				switch (direction) {
				case NORTH :
				default :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? NULL_AABB : LOW_NORTH);
					break;

				case SOUTH :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? NULL_AABB : LOW_SOUTH);
					break;

				case EAST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? NULL_AABB : LOW_EAST);
					break;
					
				case WEST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? NULL_AABB : LOW_WEST);
					break;
				} // direction
			}
		}
		
		else {
			if (downState.getBlock() == this && downState.getValue(HALF) == HalfState.LOWER) { 
				EnumFacing dDirection = downState.getValue(H_FACING);
				boolean flag1 = ((Boolean)downState.getValue(OPEN)).booleanValue();
				
				switch (dDirection) {
				case NORTH :
				default :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? NULL_AABB : UP_NORTH);
					break;

				case SOUTH :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? NULL_AABB : UP_SOUTH);
					break;

				case EAST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? NULL_AABB : UP_EAST);
					break;
					
				case WEST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? NULL_AABB : UP_WEST);
					break;
				} // direction
			}
		}
	}
}
