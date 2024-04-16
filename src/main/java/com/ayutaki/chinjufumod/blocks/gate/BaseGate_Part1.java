package com.ayutaki.chinjufumod.blocks.gate;

import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseGate_Part1 extends BaseGate {
	
	public BaseGate_Part1(Material material, String name) {
		super(material, name);
	}

	/* Get Power */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		HalfState half = state.getValue(HALF);
		IBlockState upState = worldIn.getBlockState(pos.up());
		IBlockState downState = worldIn.getBlockState(pos.down()); 
		
		if (half == HalfState.UPPER) {
			if (!worldIn.isRemote && downState.getBlock() != this) { worldIn.setBlockToAir(pos); }
			if (blockIn != this) { downState.neighborChanged(worldIn, pos.down(), blockIn, fromPos); }
		} // Block1_UPPER

		else {
			if (!worldIn.isRemote && upState.getBlock() != this) { worldIn.setBlockToAir(pos); }
			
			HingeState upHinge = upState.getValue(HINGE);
			EnumFacing direction = state.getValue(H_FACING);
			
			double x = (double) pos.getX();
			double y = (double) pos.getY();
			double z = (double) pos.getZ();

			/** Power Flag **/
			boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.up());
			
			IBlockState blockState1 = this.getDefaultState().withProperty(H_FACING, direction).withProperty(OPEN, Boolean.valueOf(flag)); 
			IBlockState blockState2 = this.takeBlock2().getDefaultState().withProperty(H_FACING, direction).withProperty(OPEN, Boolean.valueOf(flag)); 
			
			IBlockState Low_LEFT1 = blockState1.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Up_LEFT2 = blockState2.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.LEFT);
			IBlockState Low_LEFT2 = blockState2.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.LEFT);
			
			IBlockState Low_RIGHT1 = blockState1.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Up_RIGHT2 = blockState2.withProperty(HALF, HalfState.UPPER).withProperty(HINGE, HingeState.RIGHT);
			IBlockState Low_RIGHT2 = blockState2.withProperty(HALF, HalfState.LOWER).withProperty(HINGE, HingeState.RIGHT);
			
			if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean)upState.getValue(POWERED)).booleanValue()) {
				worldIn.setBlockState(pos.up(), upState.withProperty(POWERED, Boolean.valueOf(flag)), 2);

				if (flag != ((Boolean)state.getValue(OPEN)).booleanValue()) {
					if (flag != state.getValue(OPEN)) { this.moveSound(worldIn, pos, flag); }
					worldIn.markBlockRangeForRenderUpdate(pos, pos);
					
					switch (upHinge) {
					case LEFT:
					default:
						worldIn.setBlockState(pos, Low_LEFT1, 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_LEFT2, 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_LEFT2, 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_LEFT2, 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_LEFT2, 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_LEFT2, 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_LEFT2, 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_LEFT2, 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_LEFT2, 2);
							break;
						} // direction
						break;


					case RIGHT:
						worldIn.setBlockState(pos, Low_RIGHT1, 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_RIGHT2, 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_RIGHT2, 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_RIGHT2, 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_RIGHT2, 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_RIGHT2, 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_RIGHT2, 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_RIGHT2, 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_RIGHT2, 2);
							break;
						} // direction
						break;
					}
				} //flag != OPEN
			} // Powered
		} // Block1_LOWER
	}
	
	private Block takeBlock2() {
		if (this == Gate_Blocks.GATE_SPRUCE) { return Gate_Blocks.GATE_SPRUCE2; }
		if (this == Gate_Blocks.GATE_SPRUCE_B) { return Gate_Blocks.GATE_SPRUCE_B2; }
		if (this == Gate_Blocks.GATE_IRON) { return Gate_Blocks.GATE_IRON2; }
		if (this == Gate_Blocks.GATE_IRONGRILL) { return Gate_Blocks.GATE_IRONGRILL2; }
		return null;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
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
