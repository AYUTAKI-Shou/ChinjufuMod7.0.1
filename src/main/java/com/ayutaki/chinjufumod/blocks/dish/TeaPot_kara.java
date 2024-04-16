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

public class TeaPot_kara extends BaseStage4_FaceDown {
	/** 1=ティーポット, 2=急須, ３=ローストチキン, 4=カレーセット **/
	/* Collision */
	private static final AxisAlignedBB AABB_1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);
	private static final AxisAlignedBB AABB_1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);
	private static final AxisAlignedBB AABB_1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);
	private static final AxisAlignedBB AABB_1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);

	private static final AxisAlignedBB AABB_D1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_D1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_D1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_D1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);

	private static final AxisAlignedBB AABB_2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.375, 0.0, 0.375, 0.625, 0.2, 0.75);
	private static final AxisAlignedBB AABB_2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.375, 0.0, 0.375, 0.625, 0.2, 0.75);
	private static final AxisAlignedBB AABB_2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.375, 0.0, 0.375, 0.625, 0.2, 0.75);
	private static final AxisAlignedBB AABB_2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.375, 0.0, 0.375, 0.625, 0.2, 0.75);

	private static final AxisAlignedBB AABB_D2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_D2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_D2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_D2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);

	private static final AxisAlignedBB AABB_3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.1875, 0.0, 0.1875, 0.8125, 0.0625, 0.8125);
	private static final AxisAlignedBB AABB_3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.1875, 0.0, 0.1875, 0.8125, 0.0625, 0.8125);
	private static final AxisAlignedBB AABB_3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.1875, 0.0, 0.1875, 0.8125, 0.0625, 0.8125);
	private static final AxisAlignedBB AABB_3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.1875, 0.0, 0.1875, 0.8125, 0.0625, 0.8125);

	private static final AxisAlignedBB AABB_D3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.1875, -0.5, 0.1875, 0.8125, 0.01, 0.8125);
	private static final AxisAlignedBB AABB_D3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.1875, -0.5, 0.1875, 0.8125, 0.01, 0.8125);
	private static final AxisAlignedBB AABB_D3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.1875, -0.5, 0.1875, 0.8125, 0.01, 0.8125);
	private static final AxisAlignedBB AABB_D3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.1875, -0.5, 0.1875, 0.8125, 0.01, 0.8125);

	private static final AxisAlignedBB AABB_4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);
	private static final AxisAlignedBB AABB_4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);
	private static final AxisAlignedBB AABB_4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);
	private static final AxisAlignedBB AABB_4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);

	private static final AxisAlignedBB AABB_D4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);
	private static final AxisAlignedBB AABB_D4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);
	private static final AxisAlignedBB AABB_D4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);
	private static final AxisAlignedBB AABB_D4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0875, 0.0, 0.1875, 0.6875, 0.1875, 0.8125);

	public TeaPot_kara(String name) {
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
		/** 1=ティーポット, 2=急須, ３=ローストチキン, 4=カレーセット **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case SOUTH:
			if (i == 2) { return flag? AABB_2_SOUTH : AABB_D2_SOUTH; }
			if (i == 3) { return flag? AABB_3_SOUTH : AABB_D3_SOUTH; }
			if (i == 4) { return flag? AABB_4_SOUTH : AABB_D4_SOUTH; }
			return flag? AABB_1_SOUTH : AABB_D1_SOUTH;

		case EAST:
			if (i == 2) { return flag? AABB_2_EAST : AABB_D2_EAST; }
			if (i == 3) { return flag? AABB_3_EAST : AABB_D3_EAST; }
			if (i == 4) { return flag? AABB_4_EAST : AABB_D4_EAST; }
			return flag? AABB_1_EAST : AABB_D1_EAST;

		case WEST:
			if (i == 2) { return flag? AABB_2_WEST : AABB_D2_WEST; }
			if (i == 3) { return flag? AABB_3_WEST : AABB_D3_WEST; }
			if (i == 4) { return flag? AABB_4_WEST : AABB_D4_WEST; }
			return flag? AABB_1_WEST : AABB_D1_WEST;

		case NORTH:
		default:
			if (i == 2) { return flag? AABB_2_NORTH : AABB_D2_NORTH; }
			if (i == 3) { return flag? AABB_3_NORTH : AABB_D3_NORTH; }
			if (i == 4) { return flag? AABB_4_NORTH : AABB_D4_NORTH; }
			return flag? AABB_1_NORTH : AABB_D1_NORTH;
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {

		/** 1=ティーポット, 2=急須, ３=ローストチキン, 4=カレーセット **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.TEAPOT_kara, 1, 0)); }
		if (i == 2) { stack.add(new ItemStack(Items_Teatime.KYUSU_kara, 1, 0)); }
		if (i == 3) { stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 4) { stack.add(new ItemStack(Items_Teatime.Item_SARA, 2, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		/** 1=ティーポット, 2=急須, ３=ローストチキン, 4=カレーセット **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2) { return new ItemStack(Items_Teatime.KYUSU_kara); }
		if (i == 3) { return new ItemStack(Items_Teatime.Item_SARA); }
		if (i == 4) { return new ItemStack(Blocks.AIR); }
		return new ItemStack(Items_Teatime.TEAPOT_kara);
	}

}
