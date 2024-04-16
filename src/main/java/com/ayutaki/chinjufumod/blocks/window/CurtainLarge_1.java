package com.ayutaki.chinjufumod.blocks.window;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CurtainLarge_1 extends BaseCurtainLarge {

	/* Collision */
	protected static final AxisAlignedBB CLOSE_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB CLOSE_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB CLOSE_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB CLOSE_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);

	protected static final AxisAlignedBB RAIL_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.953125, 0.953125, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB RAIL_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.953125, 0.953125, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB RAIL_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.953125, 0.953125, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB RAIL_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.953125, 0.953125, 0.0, 1.0, 1.0, 1.0);
	
	public CurtainLarge_1(String name) {
		super(name, Material.WOOD);
	}

	/* RightClick Action */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// if (item instanceof Base_ItemHake) { return false; } Too Complex.

		HalfState half = state.getValue(HALF);
		IBlockState upState = worldIn.getBlockState(pos.up());
		IBlockState downState = worldIn.getBlockState(pos.down()); 
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		CMEvents.soundCurtain(worldIn, pos, 0.8F, 0.8F);
		
		if (half == HalfState.LOWER) {
			HingeState upHinge = upState.getValue(HINGE);
			EnumFacing direction = state.getValue(H_FACING);
			boolean flag = state.getValue(OPEN)? false : true;
			
			IBlockState blockState1 = this.getDefaultState().withProperty(H_FACING, direction).withProperty(OPEN, Boolean.valueOf(flag));
			IBlockState blockState2 = this.takeBlock2().getDefaultState().withProperty(H_FACING, direction).withProperty(OPEN, Boolean.valueOf(flag));
			
			IBlockState Up_LEFT1 = blockState1.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Low_LEFT1 = blockState1.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Up_LEFT2 = blockState2.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Low_LEFT2 = blockState2.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.LEFT);
			
			IBlockState Up_RIGHT1 = blockState1.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Low_RIGHT1 = blockState1.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Up_RIGHT2 = blockState2.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Low_RIGHT2 = blockState2.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.RIGHT);
			
			switch (upHinge) {
			case LEFT:
			default:
				worldIn.setBlockState(pos.up(), Up_LEFT1, 3);
				worldIn.setBlockState(pos, Low_LEFT1, 3);
				
				switch (direction) {
				case NORTH :
				default :
					worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_LEFT2, 3);
					break;

				case SOUTH :
					worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_LEFT2, 3);
					break;

				case EAST :
					worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_LEFT2, 3);
					break;
					
				case WEST :
					worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_LEFT2, 3);
					break;
				} // direction
				break;


			case RIGHT:
				worldIn.setBlockState(pos.up(), Up_RIGHT1, 3);
				worldIn.setBlockState(pos, Low_RIGHT1, 3);
				
				switch (direction) {
				case NORTH :
				default :
					worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_RIGHT2, 3);
					break;

				case SOUTH :
					worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_RIGHT2, 3);
					break;

				case EAST :
					worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_RIGHT2, 3);
					break;
					
				case WEST :
					worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_RIGHT2, 3);
					break;
				} // direction
				break;
			}
		} //HalfState.LOWER
		
		else {
			HingeState hinge = state.getValue(HINGE);
			EnumFacing dDirection = downState.getValue(H_FACING);
			boolean flag = downState.getValue(OPEN)? false : true;
			
			IBlockState blockState1 = this.getDefaultState().withProperty(H_FACING, dDirection).withProperty(OPEN, Boolean.valueOf(flag));
			IBlockState blockState2 = this.takeBlock2().getDefaultState().withProperty(H_FACING, dDirection).withProperty(OPEN, Boolean.valueOf(flag));
			
			IBlockState Up_LEFT1 = blockState1.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Low_LEFT1 = blockState1.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Up_LEFT2 = blockState2.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Low_LEFT2 = blockState2.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.LEFT);
			
			IBlockState Up_RIGHT1 = blockState1.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Low_RIGHT1 = blockState1.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Up_RIGHT2 = blockState2.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Low_RIGHT2 = blockState2.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.RIGHT);
			
			switch (hinge) {
			case LEFT:
			default:
				worldIn.setBlockState(pos, Up_LEFT1, 3);
				worldIn.setBlockState(pos.down(), Low_LEFT1, 3);
				
				switch (dDirection) {
				case NORTH :
				default :
					worldIn.setBlockState(new BlockPos(x - 1, y, z), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Low_LEFT2, 3);
					break;

				case SOUTH :
					worldIn.setBlockState(new BlockPos(x + 1, y, z), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Low_LEFT2, 3);
					break;

				case EAST :
					worldIn.setBlockState(new BlockPos(x, y, z - 1), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Low_LEFT2, 3);
					break;
					
				case WEST :
					worldIn.setBlockState(new BlockPos(x, y, z + 1), Up_LEFT2, 3);
					worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Low_LEFT2, 3);
					break;
				} // direction
				break;


			case RIGHT:
				worldIn.setBlockState(pos, Up_RIGHT1, 3);
				worldIn.setBlockState(pos.down(), Low_RIGHT1, 3);
				
				switch (dDirection) {
				case NORTH :
				default :
					worldIn.setBlockState(new BlockPos(x + 1, y, z), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Low_RIGHT2, 3);
					break;

				case SOUTH :
					worldIn.setBlockState(new BlockPos(x - 1, y, z), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Low_RIGHT2, 3);
					break;

				case EAST :
					worldIn.setBlockState(new BlockPos(x, y, z + 1), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Low_RIGHT2, 3);
					break;
					
				case WEST :
					worldIn.setBlockState(new BlockPos(x, y, z - 1), Up_RIGHT2, 3);
					worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Low_RIGHT2, 3);
					break;
				} // direction
				break;
			}
		}
		return true;
	}
	
	private Block takeBlock2() {
		if (this == Window_Blocks.CURTAINL1_white) { return Window_Blocks.CURTAINL2_white; }
		if (this == Window_Blocks.CURTAINL1_orange) { return Window_Blocks.CURTAINL2_orange; }
		if (this == Window_Blocks.CURTAINL1_magenta) { return Window_Blocks.CURTAINL2_magenta; }
		if (this == Window_Blocks.CURTAINL1_lightblue) { return Window_Blocks.CURTAINL2_lightblue; }
		if (this == Window_Blocks.CURTAINL1_yellow) { return Window_Blocks.CURTAINL2_yellow; }
		if (this == Window_Blocks.CURTAINL1_lime) { return Window_Blocks.CURTAINL2_lime; }
		if (this == Window_Blocks.CURTAINL1_pink) { return Window_Blocks.CURTAINL2_pink; }
		if (this == Window_Blocks.CURTAINL1_gray) { return Window_Blocks.CURTAINL2_gray; }
		if (this == Window_Blocks.CURTAINL1_lightgray) { return Window_Blocks.CURTAINL2_lightgray; }
		if (this == Window_Blocks.CURTAINL1_cyan) { return Window_Blocks.CURTAINL2_cyan; }
		if (this == Window_Blocks.CURTAINL1_purple) { return Window_Blocks.CURTAINL2_purple; }
		if (this == Window_Blocks.CURTAINL1_blue) { return Window_Blocks.CURTAINL2_blue; }
		if (this == Window_Blocks.CURTAINL1_brown) { return Window_Blocks.CURTAINL2_brown; }
		if (this == Window_Blocks.CURTAINL1_green) { return Window_Blocks.CURTAINL2_green; }
		if (this == Window_Blocks.CURTAINL1_red) { return Window_Blocks.CURTAINL2_red; }
		if (this == Window_Blocks.CURTAINL1_black) { return Window_Blocks.CURTAINL2_black; }
		return null;
	}
	
	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
		boolean flag1 = (state.getValue(HALF) == HalfState.UPPER);
		AxisAlignedBB AABB_EMPTY = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		
		switch (direction) {
		case SOUTH:
			return flag ? CLOSE_SOUTH : (flag1 ? RAIL_SOUTH : AABB_EMPTY);
			
		case EAST:
			return flag ? CLOSE_EAST : (flag1 ? RAIL_EAST : AABB_EMPTY);
			
		case WEST:
			return flag ? CLOSE_WEST : (flag1 ? RAIL_WEST : AABB_EMPTY);
			
		case NORTH:
		default:
			return flag ? CLOSE_NORTH : (flag1 ? RAIL_NORTH : AABB_EMPTY);
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.down()).getMaterial().isReplaceable();
	}

	/* A block that breaks at the same time when it is broken. */
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		HalfState half = state.getValue(HALF);
		IBlockState upState = worldIn.getBlockState(pos.up());
		IBlockState downState = worldIn.getBlockState(pos.down()); 
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (half == HalfState.LOWER && upState.getBlock() == this) {
			EnumFacing direction = state.getValue(H_FACING);
			boolean upLeft = (upState.getValue(HINGE) == HingeState.LEFT);
			
			worldIn.destroyBlock(pos, mode? false : true);
			worldIn.destroyBlock(pos.up(), false);
			
			switch (direction) {
			case NORTH :
			default :
				worldIn.destroyBlock(upLeft? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
				worldIn.destroyBlock(upLeft? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
				break;

			case SOUTH :
				worldIn.destroyBlock(upLeft? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
				worldIn.destroyBlock(upLeft? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
				break;

			case EAST :
				worldIn.destroyBlock(upLeft? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
				worldIn.destroyBlock(upLeft? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
				break;
				
			case WEST :
				worldIn.destroyBlock(upLeft? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
				worldIn.destroyBlock(upLeft? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
				break;
			} // direction
		} //HalfState.LOWER
		
		if (half == HalfState.UPPER && downState.getBlock() == this) { 
			EnumFacing dDirection = downState.getValue(H_FACING);
			boolean left = (state.getValue(HINGE) == HingeState.LEFT);
			
			worldIn.destroyBlock(pos.down(), mode? false : true);
			
			switch (dDirection) {
			case NORTH :
			default :
				worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
				worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
				break;

			case SOUTH :
				worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
				worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
				break;

			case EAST :
				worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
				worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
				break;
				
			case WEST :
				worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
				worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
				break;
			} // direction
		} //HalfState.UPPER
	}

}
