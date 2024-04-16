package com.ayutaki.chinjufumod.blocks.garden;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShishiOdoshi_2 extends Base_ShishiOdoshi {

	/** 水45, 水22.5, 水0, 水-22.5 **/
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, 0.0, 0.0625, 0.875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, 0.0, 0.0625, 0.875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, 0.0, 0.0625, 0.875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, 0.0, 0.0625, 0.875, 1.0, 0.875);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public ShishiOdoshi_2(String name) {
		super(name);
	}

	/* TickRandom */
	@Override
	public int tickRate(World worldIn) {
		return 30;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, Garden_Blocks.SHISHIODOSHI2, this.tickRate(worldIn));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		EnumFacing direction = state.getValue(H_FACING);

		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());
		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();

		switch (i) {
		case 1 :
		default :
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_T2.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 1)));
			
			worldIn.scheduleUpdate(pos, Garden_Blocks.SHISHIODOSHI2, this.tickRate(worldIn));
			break;

		case 2 :
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_T2.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 1)));

			if (direction == EnumFacing.NORTH) {

				/** 石=空0,1,2,3 GRA=空4,5,6,7 DIO=空8,9,10,11 AND=空12,13,14,15 空スタートで確定 **/
				if (eastBlock instanceof Chouzubachi &&
						(eastState.getValue(Chouzubachi.STAGE_0_15) != 3 && eastState.getValue(Chouzubachi.STAGE_0_15) != 7 &&
							eastState.getValue(Chouzubachi.STAGE_0_15) != 11 && eastState.getValue(Chouzubachi.STAGE_0_15) != 15)) {
					worldIn.setBlockState(pos.east(), eastState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(eastState.getValue(Chouzubachi.STAGE_0_15) + 1))); }
				else { } }

			if (direction == EnumFacing.SOUTH) {
				if (westBlock instanceof Chouzubachi &&
						(westState.getValue(Chouzubachi.STAGE_0_15) != 3 && westState.getValue(Chouzubachi.STAGE_0_15) != 7 &&
							westState.getValue(Chouzubachi.STAGE_0_15) != 11 && westState.getValue(Chouzubachi.STAGE_0_15) != 15)) {
					worldIn.setBlockState(pos.west(), westState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(westState.getValue(Chouzubachi.STAGE_0_15) + 1))); }
				else { } }

			if (direction == EnumFacing.EAST) {
				if (southBlock instanceof Chouzubachi &&
						(southState.getValue(Chouzubachi.STAGE_0_15) != 3 && southState.getValue(Chouzubachi.STAGE_0_15) != 7 &&
							southState.getValue(Chouzubachi.STAGE_0_15) != 11 && southState.getValue(Chouzubachi.STAGE_0_15) != 15)) {
					worldIn.setBlockState(pos.south(), southState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(southState.getValue(Chouzubachi.STAGE_0_15) + 1))); }
				else { } }

			if (direction == EnumFacing.WEST) {
				if (northBlock instanceof Chouzubachi &&
						(northState.getValue(Chouzubachi.STAGE_0_15) != 3 && northState.getValue(Chouzubachi.STAGE_0_15) != 7 &&
							northState.getValue(Chouzubachi.STAGE_0_15) != 11 && northState.getValue(Chouzubachi.STAGE_0_15) != 15)) {
					worldIn.setBlockState(pos.north(), northState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(northState.getValue(Chouzubachi.STAGE_0_15) + 1))); }
				else { } }
			
			worldIn.scheduleUpdate(pos, Garden_Blocks.SHISHIODOSHI2, this.tickRate(worldIn));
			break;

		case 3 :
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_T2.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 1)));

			if (direction == EnumFacing.NORTH) {

				/** 石=空0,1,2,3 GRA=空4,5,6,7 DIO=空8,9,10,11 AND=空12,13,14,15 空スタートで確定 **/
				if (eastBlock instanceof Chouzubachi && eastState.getValue(Chouzubachi.STAGE_0_15) < 3) {
					worldIn.setBlockState(pos.east(), eastState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(3))); }

				if (eastBlock instanceof Chouzubachi &&
						(eastState.getValue(Chouzubachi.STAGE_0_15) >= 4 && eastState.getValue(Chouzubachi.STAGE_0_15) < 7)) {
					worldIn.setBlockState(pos.east(), eastState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(7))); }

				if (eastBlock instanceof Chouzubachi &&
						(eastState.getValue(Chouzubachi.STAGE_0_15) >= 8 && eastState.getValue(Chouzubachi.STAGE_0_15) < 11)) {
					worldIn.setBlockState(pos.east(), eastState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(11))); }

				if (eastBlock instanceof Chouzubachi &&
						(eastState.getValue(Chouzubachi.STAGE_0_15) >= 12 && eastState.getValue(Chouzubachi.STAGE_0_15) < 15)) {
					worldIn.setBlockState(pos.east(), eastState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(15))); }
				else { } }

			if (direction == EnumFacing.SOUTH) {
				if (westBlock instanceof Chouzubachi && westState.getValue(Chouzubachi.STAGE_0_15) < 3) {
					worldIn.setBlockState(pos.west(), westState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(3))); }

				if (westBlock instanceof Chouzubachi &&
						(westState.getValue(Chouzubachi.STAGE_0_15) >= 4 && westState.getValue(Chouzubachi.STAGE_0_15) < 7)) {
					worldIn.setBlockState(pos.west(), westState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(7))); }

				if (westBlock instanceof Chouzubachi &&
						(westState.getValue(Chouzubachi.STAGE_0_15) >= 8 && westState.getValue(Chouzubachi.STAGE_0_15) < 11)) {
					worldIn.setBlockState(pos.west(), westState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(11))); }

				if (westBlock instanceof Chouzubachi &&
						(westState.getValue(Chouzubachi.STAGE_0_15) >= 12 && westState.getValue(Chouzubachi.STAGE_0_15) < 15)) {
					worldIn.setBlockState(pos.west(), westState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(15))); }
				else { } }

			if (direction == EnumFacing.EAST) {
				if (southBlock instanceof Chouzubachi && southState.getValue(Chouzubachi.STAGE_0_15) < 3) {
					worldIn.setBlockState(pos.south(), southState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(3))); }

				if (southBlock instanceof Chouzubachi &&
						(southState.getValue(Chouzubachi.STAGE_0_15) >= 4 && southState.getValue(Chouzubachi.STAGE_0_15) < 7)) {
					worldIn.setBlockState(pos.south(), southState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(7))); }

				if (southBlock instanceof Chouzubachi &&
						(southState.getValue(Chouzubachi.STAGE_0_15) >= 8 && southState.getValue(Chouzubachi.STAGE_0_15) < 11)) {
					worldIn.setBlockState(pos.south(), southState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(11))); }

				if (southBlock instanceof Chouzubachi &&
						(southState.getValue(Chouzubachi.STAGE_0_15) >= 12 && southState.getValue(Chouzubachi.STAGE_0_15) < 15)) {
					worldIn.setBlockState(pos.south(), southState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(15))); }
				else { } }

			if (direction == EnumFacing.WEST) {
				if (northBlock instanceof Chouzubachi && northState.getValue(Chouzubachi.STAGE_0_15) < 3) {
					worldIn.setBlockState(pos.north(), northState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(3))); }

				if (northBlock instanceof Chouzubachi &&
						(northState.getValue(Chouzubachi.STAGE_0_15) >= 4 && northState.getValue(Chouzubachi.STAGE_0_15) < 7)) {
					worldIn.setBlockState(pos.north(), northState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(7))); }

				if (northBlock instanceof Chouzubachi &&
						(northState.getValue(Chouzubachi.STAGE_0_15) >= 8 && northState.getValue(Chouzubachi.STAGE_0_15) < 11)) {
					worldIn.setBlockState(pos.north(), northState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(11))); }

				if (northBlock instanceof Chouzubachi &&
						(northState.getValue(Chouzubachi.STAGE_0_15) >= 12 && northState.getValue(Chouzubachi.STAGE_0_15) < 15)) {
					worldIn.setBlockState(pos.north(), northState.withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(15))); }
				else { } }
			
			worldIn.scheduleUpdate(pos, Garden_Blocks.SHISHIODOSHI2, this.tickRate(worldIn));
			break;
			
		case 4 :
			worldIn.playSound(null, pos, SoundEvents_CM.SHISHIODOSHI, SoundCategory.BLOCKS, 0.5F, 1.0F);

			worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHI.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_T.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
			
			worldIn.scheduleUpdate(pos, Garden_Blocks.SHISHIODOSHI2, this.tickRate(worldIn));
			break;
		} // switch
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		worldIn.playSound(x, y, z, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, 0.25F, rand.nextFloat() + 0.75F, false);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);

		if (stack.isEmpty()) {
			CMEvents.soundStoneButton_Off(worldIn, pos);

			worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHI.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_T.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}
}
