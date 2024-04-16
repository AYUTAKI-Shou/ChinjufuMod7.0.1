package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FoodKara_Tei extends BaseStage4_FaceDown {
	/**1=玉子焼き定食, 2=焼き魚定食, 3=焼鮭定食, 4=エッグバーグ**/

	private static final AxisAlignedBB AABB_123_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.1875, 0.0, 0.125, 0.6875, 0.1875, 0.875);
	private static final AxisAlignedBB AABB_123_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.1875, 0.0, 0.125, 0.6875, 0.1875, 0.875);
	private static final AxisAlignedBB AABB_123_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.1875, 0.0, 0.125, 0.6875, 0.1875, 0.875);
	private static final AxisAlignedBB AABB_123_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.1875, 0.0, 0.125, 0.6875, 0.1875, 0.875);

	private static final AxisAlignedBB AABB_4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);
	private static final AxisAlignedBB AABB_4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);
	private static final AxisAlignedBB AABB_4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);
	private static final AxisAlignedBB AABB_4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);

	private static final AxisAlignedBB AABB_D123_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.1875, -0.5, 0.125, 0.6875, 0.01, 0.875);
	private static final AxisAlignedBB AABB_D123_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.1875, -0.5, 0.125, 0.6875, 0.01, 0.875);
	private static final AxisAlignedBB AABB_D123_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.1875, -0.5, 0.125, 0.6875, 0.01, 0.875);
	private static final AxisAlignedBB AABB_D123_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.1875, -0.5, 0.125, 0.6875, 0.01, 0.875);

	private static final AxisAlignedBB AABB_D4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);
	private static final AxisAlignedBB AABB_D4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);
	private static final AxisAlignedBB AABB_D4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);
	private static final AxisAlignedBB AABB_D4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0875, 0.0, 0.0625, 0.75, 0.125, 0.9375);

	public FoodKara_Tei(String name) {
		super(name);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		CMEvents.textIsEmpty(worldIn, pos, playerIn);
		/** 'true' to not put anything on top. **/
		return true;
	}
	
	/* Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		/**1=玉子焼き定食, 2=焼き魚定食, 3=焼鮭定食, 4=エッグバーグ**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case SOUTH:
			if (i == 4) { return flag? AABB_4_SOUTH : AABB_D4_SOUTH; }
			return flag? AABB_123_SOUTH : AABB_D123_SOUTH;

		case EAST:
			if (i == 4) { return flag? AABB_4_EAST : AABB_D4_EAST; }
			return flag? AABB_123_EAST : AABB_D123_EAST;

		case WEST:
			if (i == 4) { return flag? AABB_4_WEST : AABB_D4_WEST; }
			return flag? AABB_123_WEST : AABB_D123_WEST;

		case NORTH:
		default:
			if (i == 4) { return flag? AABB_4_NORTH : AABB_D4_NORTH; }
			return flag? AABB_123_NORTH : AABB_D123_NORTH;
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		/**1=玉子焼き定食, 2=焼き魚定食, 3=焼鮭定食, 4=エッグバーグ**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (i != 4) {
			stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 3));
			stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 4));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 2, 0));
			stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 1)); }
		if (i == 4) { stack.add(new ItemStack(Items_Teatime.Item_SARA, 4, 0)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Blocks.AIR);
	}
}
