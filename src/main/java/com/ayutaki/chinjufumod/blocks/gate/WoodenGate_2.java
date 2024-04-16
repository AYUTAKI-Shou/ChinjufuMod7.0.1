package com.ayutaki.chinjufumod.blocks.gate;

import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

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

public class WoodenGate_2 extends BaseGate_Part2 {

	/* Collision */
	protected static final AxisAlignedBB LOW_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB LOW_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.0, 0.5, 1.0, 1.0);

	protected static final AxisAlignedBB UP_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	protected static final AxisAlignedBB UP_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	protected static final AxisAlignedBB UP_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	protected static final AxisAlignedBB UP_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.0, 0.5, 2.0, 1.0);
	
	protected static final AxisAlignedBB OLL_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.0, 1.0, 1.0, 0.5);
	protected static final AxisAlignedBB OLL_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.0, 1.0, 1.0, 0.5);
	protected static final AxisAlignedBB OLL_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.0, 1.0, 1.0, 0.5);
	protected static final AxisAlignedBB OLL_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.0, 1.0, 1.0, 0.5);

	protected static final AxisAlignedBB OLR_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.5, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB OLR_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.5, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB OLR_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.5, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB OLR_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.5, 1.0, 1.0, 1.0);
	
	protected static final AxisAlignedBB OUL_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.0, 1.0, 2.0, 0.5);
	protected static final AxisAlignedBB OUL_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.0, 1.0, 2.0, 0.5);
	protected static final AxisAlignedBB OUL_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.0, 1.0, 2.0, 0.5);
	protected static final AxisAlignedBB OUL_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.0, 1.0, 2.0, 0.5);

	protected static final AxisAlignedBB OUR_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.2375, 0.0, 0.5, 1.0, 2.0, 1.0);
	protected static final AxisAlignedBB OUR_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.2375, 0.0, 0.5, 1.0, 2.0, 1.0);
	protected static final AxisAlignedBB OUR_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.2375, 0.0, 0.5, 1.0, 2.0, 1.0);
	protected static final AxisAlignedBB OUR_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.2375, 0.0, 0.5, 1.0, 2.0, 1.0);
	
	public WoodenGate_2(Material material, String name) {
		super(material, name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
		
		/** Registry **/
		ForgeRegistries.BLOCKS.register(this);
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		state = state.getActualState(worldIn, pos);
		HalfState half = state.getValue(HALF);

		IBlockState upState = worldIn.getBlockState(pos.up()); 
		IBlockState downState = worldIn.getBlockState(pos.down());
		
		if (half == HalfState.LOWER) {
			if (upState.getBlock() == this && upState.getValue(HALF) == HalfState.UPPER) {
				
				HingeState upHinge = upState.getValue(HINGE);
				EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
				boolean flag = ((Boolean)state.getValue(OPEN)).booleanValue();
				
				switch (direction) {
				case NORTH :
				default :
					return flag? (upHinge == HingeState.LEFT? OLL_NORTH : OLR_NORTH) : LOW_NORTH;

				case SOUTH :
					return flag? (upHinge == HingeState.LEFT? OLL_SOUTH : OLR_SOUTH) : LOW_SOUTH;

				case EAST :
					return flag? (upHinge == HingeState.LEFT? OLL_EAST : OLR_EAST) : LOW_EAST;
					
				case WEST :
					return flag? (upHinge == HingeState.LEFT? OLL_WEST : OLR_WEST) : LOW_WEST;
				} // direction
			}
		}
		
		else {
			if (downState.getBlock() == this && downState.getValue(HALF) == HalfState.LOWER) { 
				HingeState hinge = state.getValue(HINGE);
				EnumFacing dDirection = downState.getValue(H_FACING);
				boolean flag1 = ((Boolean)downState.getValue(OPEN)).booleanValue();
				
				switch (dDirection) {
				case NORTH :
				default :
					return flag1? (hinge == HingeState.LEFT? OUL_NORTH : OUR_NORTH) : UP_NORTH;

				case SOUTH :
					return flag1? (hinge == HingeState.LEFT? OUL_SOUTH : OUR_SOUTH) : UP_SOUTH;

				case EAST :
					return flag1? (hinge == HingeState.LEFT? OUL_EAST : OUR_EAST) : UP_EAST;
					
				case WEST :
					return flag1? (hinge == HingeState.LEFT? OUL_WEST : OUR_WEST) : UP_WEST;
				} // direction
			}
		}
		return null;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {
		HalfState half = state.getValue(HALF);

		IBlockState upState = worldIn.getBlockState(pos.up()); 
		IBlockState downState = worldIn.getBlockState(pos.down());
		
		if (half == HalfState.LOWER) {
			if (upState.getBlock() == this && upState.getValue(HALF) == HalfState.UPPER) {
				
				HingeState upHinge = upState.getValue(HINGE);
				EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
				boolean flag = ((Boolean)state.getValue(OPEN)).booleanValue();
				
				switch (direction) {
				case NORTH :
				default :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? (upHinge == HingeState.LEFT? OLL_NORTH : OLR_NORTH) : FULL_BLOCK_AABB);
					break;

				case SOUTH :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? (upHinge == HingeState.LEFT? OLL_SOUTH : OLR_SOUTH) : FULL_BLOCK_AABB);
					break;

				case EAST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? (upHinge == HingeState.LEFT? OLL_EAST : OLR_EAST) : FULL_BLOCK_AABB);
					break;
					
				case WEST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? (upHinge == HingeState.LEFT? OLL_WEST : OLR_WEST) : FULL_BLOCK_AABB);
					break;
				} // direction
			}
		}
		
		else {
			if (downState.getBlock() == this && downState.getValue(HALF) == HalfState.LOWER) { 
				HingeState hinge = state.getValue(HINGE);
				EnumFacing dDirection = downState.getValue(H_FACING);
				boolean flag1 = ((Boolean)downState.getValue(OPEN)).booleanValue();
				
				AxisAlignedBB UP_COLL = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
				switch (dDirection) {
				case NORTH :
				default :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? (hinge == HingeState.LEFT? OUL_NORTH : OUR_NORTH) : UP_COLL);
					break;

				case SOUTH :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? (hinge == HingeState.LEFT? OUL_SOUTH : OUR_SOUTH) : UP_COLL);
					break;

				case EAST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? (hinge == HingeState.LEFT? OUL_EAST : OUR_EAST) : UP_COLL);
					break;
					
				case WEST :
					super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag1? (hinge == HingeState.LEFT? OUL_WEST : OUR_WEST) : UP_COLL);
					break;
				} // direction
			}
		}
	}

}
