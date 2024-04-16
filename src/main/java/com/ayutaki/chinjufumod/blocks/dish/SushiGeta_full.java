package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SushiGeta_full extends BaseStage4_FaceDown {

	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.4375, 0.0, 0.125, 0.78125, 0.09375, 0.9375);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.4375, 0.0, 0.125, 0.78125, 0.09375, 0.9375);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.4375, 0.0, 0.125, 0.78125, 0.09375, 0.9375);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.4375, 0.0, 0.125, 0.78125, 0.09375, 0.9375);

	private static final AxisAlignedBB AABB_DOWN_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.4375, -0.5, 0.125, 0.78125, 0.01, 0.9375);
	private static final AxisAlignedBB AABB_DOWN_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.4375, -0.5, 0.125, 0.78125, 0.01, 0.9375);
	private static final AxisAlignedBB AABB_DOWN_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.4375, -0.5, 0.125, 0.78125, 0.01, 0.9375);
	private static final AxisAlignedBB AABB_DOWN_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.4375, -0.5, 0.125, 0.78125, 0.01, 0.9375);

	public SushiGeta_full(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (stack.isEmpty()) {
			CMEvents.soundItemPick(worldIn, pos);
			playerIn.inventory.addItemStackToInventory(this.takeStack());
			
			if (i == 1) {
				worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_kara1_4.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(2))); }

			if (i == 2) {
				worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_kara1_4.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(3))); }

			if (i == 3) {
				worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_kara1_4.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(4))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Dish_Blocks.FOODKARA_SUSHI.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(2))); }
		}

		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private ItemStack takeStack() {
		if (this == Dish_Blocks.SUSHIGETA_salmon) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 1); }
		if (this == Dish_Blocks.SUSHIGETA_fish) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 2); }
		if (this == Dish_Blocks.SUSHIGETA_beef) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 3); }
		if (this == Dish_Blocks.SUSHIGETA_tamago) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 4); }
		return null;
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case SOUTH:
			return flag ? AABB_SOUTH : AABB_DOWN_SOUTH;

		case EAST:
			return flag ? AABB_EAST : AABB_DOWN_EAST;

		case WEST:
			return flag ? AABB_WEST : AABB_DOWN_WEST;

		case NORTH:
		default:
			/** !down= true : false **/
			return flag ? AABB_NORTH : AABB_DOWN_NORTH;
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Teatime.SUSHIGETA_kara, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.SUSHIGETA_kara, 1, 0);
	}
}
