package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Grape_3B_B extends BaseStage4_Face {

	/** 1, 2, 3, 4完熟 **/
	private static final AxisAlignedBB AABB_1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.3125, 0.0, 0.0, 0.75, 1.5, 1.0);
	private static final AxisAlignedBB AABB_1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.3125, 0.0, 0.0, 0.75, 1.5, 1.0);
	private static final AxisAlignedBB AABB_1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.3125, 0.0, 0.0, 0.75, 1.5, 1.0);
	private static final AxisAlignedBB AABB_1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.3125, 0.0, 0.0, 0.75, 1.5, 1.0);

	private static final AxisAlignedBB AABB_2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);

	private static final AxisAlignedBB AABB_3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);

	private static final AxisAlignedBB AABB_4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);
	private static final AxisAlignedBB AABB_4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.0, 0.8125, 1.5, 1.0);

	/*RandomTick*/
	public Grape_3B_B(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);

		setTickRandomly(true);
	}

	/* RandomTick */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		if (!worldIn.isAreaLoaded(pos, 1)) return;

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (worldIn.getBlockState(pos.down()).getBlock() instanceof BlockDirt && worldIn
				.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(8) == 0) {

			if (i != 4) {
				int i1 = i + 1;
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i1))); }

			if (i == 4) { }
			/** 1, 2, 3, 4完熟 **/
		}
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		/** 1, 2, 3, 4完熟 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/** Too early to collect **/
		if (i < 4) {
			if (item == Items.DYE && k == 15) {
				CMEvents.Consume_1Item(playerIn, hand);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
				
				if (i != 3) {
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)));
					worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_B.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 2))); }
				
				if (i == 3) {
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(4)));
					worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_B.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); } 
			}
			
			if ((item == Items.DYE && k != 15) || item != Items.DYE) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
			}
		}
		
		/** Can harvest **/
		if (i == 4) {
			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_GRAPE, 2));
				
				worldIn.setBlockState(pos, Crop_Blocks.BUDOUNOKI_C.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_C.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		EnumFacing direction = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		switch (direction) {
		case SOUTH:
			return (i == 1)? AABB_1_SOUTH : ((i == 2)? AABB_2_SOUTH : ((i == 3)? AABB_3_SOUTH : AABB_4_SOUTH));

		case EAST:
			return (i == 1)? AABB_1_EAST : ((i == 2)? AABB_2_EAST : ((i == 3)? AABB_3_EAST : AABB_4_EAST));

		case WEST:
			return (i == 1)? AABB_1_WEST : ((i == 2)? AABB_2_WEST : ((i == 3)? AABB_3_WEST : AABB_4_WEST));

		case NORTH:
		default:
			return (i == 1)? AABB_1_NORTH : ((i == 2)? AABB_2_NORTH : ((i == 3)? AABB_3_NORTH : AABB_4_NORTH));
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* Change DownBlock. */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {

		if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos); }

		else { }
	}

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

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof GrapeTop_3B_B) {
			worldIn.destroyBlock(pos.up(), false); }
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = state.getValue(STAGE_1_4).intValue();

		stack.add(new ItemStack(Items_Teatime.BUDOUNOKI, (i == 4)? 3 : 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.BUDOUNOKI, 1, 0);
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
