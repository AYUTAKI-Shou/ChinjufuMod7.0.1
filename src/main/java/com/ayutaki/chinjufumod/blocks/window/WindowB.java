package com.ayutaki.chinjufumod.blocks.window;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WindowB extends BaseStage4_Face {

	/* Collision */
	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);

	protected static final AxisAlignedBB AABB_OL_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OL_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OL_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OL_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);

	protected static final AxisAlignedBB AABB_OR_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OR_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OR_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OR_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);

	public WindowB(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		/** 1=Close, 2=Open Left, 3=Open Right, 4=Open **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = state.getValue(H_FACING);
		EnumFacing playerfacing = playerIn.getHorizontalFacing();
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Curtain_Item || item instanceof CurtainTall_Item) { return false; }

		else {
			switch (i) {
			case 1 :
			default:
				/* ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					/* プレイヤーの向きと叩く位置 */
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.5) || (playerfacing == EnumFacing.SOUTH && hitX < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.5) || (playerfacing == EnumFacing.SOUTH && hitX > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.5) || (playerfacing == EnumFacing.SOUTH && hitX < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.5) || (playerfacing == EnumFacing.SOUTH && hitX > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.5) || (playerfacing == EnumFacing.WEST && hitZ < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.5) || (playerfacing == EnumFacing.WEST && hitZ > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.5) || (playerfacing == EnumFacing.WEST && hitZ < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.5) || (playerfacing == EnumFacing.WEST && hitZ > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
					break;
				} /* ブロックの向き */
				break;
		
			case 2 :
				/* ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					/* プレイヤーの向きと叩く位置 */
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.25) || (playerfacing == EnumFacing.SOUTH && hitX < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.5) || (playerfacing == EnumFacing.SOUTH && hitX > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.5) || (playerfacing == EnumFacing.SOUTH && hitX < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.75) || (playerfacing == EnumFacing.SOUTH && hitX > 0.75)) {
					CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.25) || (playerfacing == EnumFacing.WEST && hitZ < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.5) || (playerfacing == EnumFacing.WEST && hitZ > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.5) || (playerfacing == EnumFacing.WEST && hitZ < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.75) || (playerfacing == EnumFacing.WEST && hitZ > 0.75)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
					break;
				} /* ブロックの向き */
				break;
		
			case 3 :
				/* ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					/* プレイヤーの向きと叩く位置 */
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.5) || (playerfacing == EnumFacing.SOUTH && hitX < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.75) || (playerfacing == EnumFacing.SOUTH && hitX > 0.75)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.25) || (playerfacing == EnumFacing.SOUTH && hitX < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.5) || (playerfacing == EnumFacing.SOUTH && hitX > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.5) || (playerfacing == EnumFacing.WEST && hitZ < 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.75) || (playerfacing == EnumFacing.WEST && hitZ > 0.75)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.25) || (playerfacing == EnumFacing.WEST && hitZ < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.5) || (playerfacing == EnumFacing.WEST && hitZ > 0.5)) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
					break;
				} /* ブロックの向き */
				break;
				
			case 4 :
				/* ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					/* プレイヤーの向きと叩く位置 */
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.25) || (playerfacing == EnumFacing.SOUTH && hitX < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.75) || (playerfacing == EnumFacing.SOUTH && hitX > 0.75)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.25) || (playerfacing == EnumFacing.SOUTH && hitX < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
	
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.75) || (playerfacing == EnumFacing.SOUTH && hitX > 0.75)) {
					CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.25) || (playerfacing == EnumFacing.WEST && hitZ < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.75) || (playerfacing == EnumFacing.WEST && hitZ > 0.75)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.25) || (playerfacing == EnumFacing.WEST && hitZ < 0.25)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)), 3); }
	
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.75) || (playerfacing == EnumFacing.WEST && hitZ > 0.75)) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
					break;
				} /* ブロックの向き */
				break;
			} // switch
	
			return true;
		}
	}


	/* BlockState when it was placed. */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite())
				.withProperty(Window.STAGE_1_4, Integer.valueOf(1));
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return AABB_SOUTH;

		case EAST:
			return AABB_EAST;

		case WEST:
			return AABB_WEST;

		case NORTH:
		default:
			return AABB_NORTH;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox,
					collidingBoxes, (i == 1)? AABB_SOUTH : ((i == 2)? AABB_OL_SOUTH : ((i == 3) ? AABB_OR_SOUTH : NULL_AABB)));
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox,
					collidingBoxes, (i == 1)? AABB_EAST : ((i == 2)? AABB_OL_EAST : ((i == 3) ? AABB_OR_EAST : NULL_AABB)));
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox,
					collidingBoxes, (i == 1)? AABB_WEST : ((i == 2)? AABB_OL_WEST : ((i == 3) ? AABB_OR_WEST : NULL_AABB)));
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox,
					collidingBoxes, (i == 1)? AABB_NORTH : ((i == 2)? AABB_OL_EAST : ((i == 3) ? AABB_OR_NORTH : NULL_AABB)));
			break;
		}
	}

	/* Arrow pass. */
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		return (i == 1)? state.getBoundingBox(source, pos) : NULL_AABB;
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack());
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Window_Blocks.WINDOWB_oak) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 0); }
		if (this == Window_Blocks.WINDOWB_spruce) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 1); }
		if (this == Window_Blocks.WINDOWB_birch) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 2); }
		if (this == Window_Blocks.WINDOWB_jungle) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 3); }
		if (this == Window_Blocks.WINDOWB_acacia) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 4); }
		if (this == Window_Blocks.WINDOWB_darkoak) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 5); }
		if (this == Window_Blocks.WINDOWB_sakura) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 6); }
		if (this == Window_Blocks.WINDOWB_kaede) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 7); }
		if (this == Window_Blocks.WINDOWB_ichoh) { return new ItemStack(Items_Chinjufu.WINDOWB_item, 1, 8); }
		return null;
	}
}
