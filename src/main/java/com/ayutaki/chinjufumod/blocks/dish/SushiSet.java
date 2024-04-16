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

public class SushiSet extends BaseStage4_FaceDown {

	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.3125, 0.0, 0.125, 0.78125, 0.1875, 1.0);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.3125, 0.0, 0.125, 0.78125, 0.1875, 1.0);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.3125, 0.0, 0.125, 0.78125, 0.1875, 1.0);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.3125, 0.0, 0.125, 0.78125, 0.1875, 1.0);

	private static final AxisAlignedBB AABB_DOWN_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.3125, -0.5, 0.125, 0.78125, 0.01, 1.0);
	private static final AxisAlignedBB AABB_DOWN_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.3125, -0.5, 0.125, 0.78125, 0.01, 1.0);
	private static final AxisAlignedBB AABB_DOWN_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.3125, -0.5, 0.125, 0.78125, 0.01, 1.0);
	private static final AxisAlignedBB AABB_DOWN_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.3125, -0.5, 0.125, 0.78125, 0.01, 1.0);

	public SushiSet(String name) {
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

		/** Hand is Empty. **/
		if (stack.isEmpty()) {
			CMEvents.soundTake_Pick(worldIn, pos);
			
			if (i == 1) {
				if (this == Dish_Blocks.SUSHISET_4shoku) { 
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 1)); }
				if (this != Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(this.takeSushi()); }
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3);	
			}

			if (i == 2) {
				if (this == Dish_Blocks.SUSHISET_4shoku) { 
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 2)); }
				if (this != Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(this.takeSushi()); } 
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3);	
			}

			if (i == 3) {
				if (this == Dish_Blocks.SUSHISET_4shoku) { 
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 3)); }
				if (this != Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(this.takeSushi()); }
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3);	
			}

			if (i == 4) {
				if (this == Dish_Blocks.SUSHISET_4shoku) { 
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 4)); }
				if (this != Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(this.takeSushi()); } 
				
				worldIn.setBlockState(pos, Dish_Blocks.FOODKARA_SUSHI.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(3))); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private ItemStack takeSushi() {
		if (this == Dish_Blocks.SUSHISET_salmon) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 1); }
		if (this == Dish_Blocks.SUSHISET_fish) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 2); }
		if (this == Dish_Blocks.SUSHISET_beef) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 3); }
		if (this == Dish_Blocks.SUSHISET_tamago) { return new ItemStack(Items_Teatime.SHOUYUSUSHI, 1, 4); }
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

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(this.takeStack()); }
		if (i != 1) {
			stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 1));
			stack.add(new ItemStack(Items_Teatime.SUSHIGETA_kara, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Dish_Blocks.SUSHISET_4shoku) { return new ItemStack(Items_Teatime.SUSHISET_4shoku, 1, 0); }
		if (this == Dish_Blocks.SUSHISET_salmon) { return new ItemStack(Items_Teatime.SUSHISET_salmon, 1, 0); }
		if (this == Dish_Blocks.SUSHISET_fish) { return new ItemStack(Items_Teatime.SUSHISET_fish, 1, 0); }
		if (this == Dish_Blocks.SUSHISET_beef) { return new ItemStack(Items_Teatime.SUSHISET_beef, 1, 0); }
		if (this == Dish_Blocks.SUSHISET_tamago) { return new ItemStack(Items_Teatime.SUSHISET_tamago, 1, 0); }
		return null;
	}
}
