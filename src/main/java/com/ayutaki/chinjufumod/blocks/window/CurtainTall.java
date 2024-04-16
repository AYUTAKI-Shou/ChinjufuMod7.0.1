package com.ayutaki.chinjufumod.blocks.window;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CurtainTall extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool OPEN = PropertyBool.create("open");
	public static final PropertyEnum<HingeState> HINGE = PropertyEnum.<HingeState>create("hinge", HingeState.class);
	public static final PropertyEnum<HalfState> HALF = PropertyEnum.<HalfState>create("half", HalfState.class);

	/* Collision */
	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);

	protected static final AxisAlignedBB AABB_OR_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.86875, 0.0, 0.875, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OR_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.86875, 0.0, 0.875, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OR_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.86875, 0.0, 0.875, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_OR_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.86875, 0.0, 0.875, 1.0, 1.0, 1.0);

	protected static final AxisAlignedBB AABB_OL_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.86875, 0.0, 0.0, 1.0, 1.0, 0.125);
	protected static final AxisAlignedBB AABB_OL_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.86875, 0.0, 0.0, 1.0, 1.0, 0.125);
	protected static final AxisAlignedBB AABB_OL_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.86875, 0.0, 0.0, 1.0, 1.0, 0.125);
	protected static final AxisAlignedBB AABB_OL_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.86875, 0.0, 0.0, 1.0, 1.0, 0.125);

	public CurtainTall(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.CLOTH);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
		
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(OPEN, Boolean.valueOf(false))
				.withProperty(HINGE, HingeState.RIGHT)
				.withProperty(HALF, HalfState.UPPER));
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
		boolean flag1 = state.getValue(HINGE) == HingeState.LEFT;

		switch (direction) {
		case SOUTH:
			return flag ? AABB_SOUTH : (flag1 ? AABB_OL_SOUTH : AABB_OR_SOUTH);
			
		case EAST:
			return flag ? AABB_EAST : (flag1 ? AABB_OL_EAST : AABB_OR_EAST);
			
		case WEST:
			return flag ? AABB_WEST : (flag1 ? AABB_OL_WEST : AABB_OR_WEST);
			
		case NORTH:
		default:
			return flag ? AABB_NORTH : (flag1 ? AABB_OL_NORTH : AABB_OR_NORTH);
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}
	
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public static boolean isOpen(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos) {
		return getFacing(combineMetadata(worldIn, pos));
	}

	public static int combineMetadata(IBlockAccess worldIn, BlockPos pos) {

		IBlockState state = worldIn.getBlockState(pos);
		int i = state.getBlock().getMetaFromState(state);
		boolean flag = isTop(i);
		IBlockState downState = worldIn.getBlockState(pos.down());
		int j = downState.getBlock().getMetaFromState(downState);
		int k = flag ? j : i;
		IBlockState upState = worldIn.getBlockState(pos.up());
		int l = upState.getBlock().getMetaFromState(upState);
		int i1 = flag ? i : l;
		boolean flag1 = (i1 & 1) != 0;
		boolean flag2 = (i1 & 2) != 0;
		return removeHalfBit(k) | (flag ? 8 : 0) | (flag1 ? 16 : 0) | (flag2 ? 32 : 0);
	}

	protected static boolean isOpen(int combinedMeta) {
		return (combinedMeta & 4) != 0;
	}

	public static EnumFacing getFacing(int combinedMeta) {
		return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
	}

	protected static boolean isTop(int meta) {
		return (meta & 8) != 0;
	}

	protected static int removeHalfBit(int meta) {
		return meta & 7;
	}

	/* RightClick Action */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		BlockPos pos1 = state.getValue(HALF) == HalfState.LOWER ? pos : pos.down();
		IBlockState state1 = pos.equals(pos1) ? state : worldIn.getBlockState(pos1);
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			state = state1.cycleProperty(OPEN);
			worldIn.setBlockState(pos1, state, 10);
			worldIn.markBlockRangeForRenderUpdate(pos1, pos);
			CMEvents.soundCurtain(worldIn, pos, 0.8F, 0.85F);
			return true;
		}
	}

	/* Power on/off. Destroy blocks. */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		if (state.getValue(HALF) == HalfState.UPPER) {
			BlockPos downPos = pos.down();
			IBlockState downState = worldIn.getBlockState(downPos);

			if (downState.getBlock() != this) { worldIn.setBlockToAir(pos); }
			
			else if (blockIn != this) { downState.neighborChanged(worldIn, downPos, blockIn, fromPos); }
		}

		else {
			boolean flag1 = false;
			BlockPos upPos = pos.up();
			IBlockState upState = worldIn.getBlockState(upPos);

			if (upState.getBlock() != this) {
				worldIn.setBlockToAir(pos);
				flag1 = true; }

			if (flag1) {
				if (!worldIn.isRemote) { this.dropBlockAsItem(worldIn, pos, state, 0); }
			}

			else { }
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.down()).getMaterial().isReplaceable();
	}

	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	/* A block that breaks at the same time when it is broken. */
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		BlockPos downPos = pos.down();
		BlockPos upPos = pos.up();

		if (playerIn.capabilities.isCreativeMode && state.getValue(HALF) == HalfState.UPPER && worldIn.getBlockState(downPos).getBlock() == this) {
			worldIn.setBlockToAir(downPos); }

		if (state.getValue(HALF) == HalfState.LOWER && worldIn.getBlockState(upPos).getBlock() == this) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.setBlockToAir(pos); }
			worldIn.setBlockToAir(upPos); }
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		if (state.getValue(HALF) == HalfState.UPPER) { return new ItemStack(Items.AIR); }
		
		if (state.getValue(HALF) != HalfState.UPPER) {
			if (this == Window_Blocks.CURTAINTALL_white) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 0); }
			if (this == Window_Blocks.CURTAINTALL_orange) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 1); }
			if (this == Window_Blocks.CURTAINTALL_magenta) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 2); }
			if (this == Window_Blocks.CURTAINTALL_lightblue) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 3); }
			if (this == Window_Blocks.CURTAINTALL_yellow) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 4); }
			if (this == Window_Blocks.CURTAINTALL_lime) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 5); }
			if (this == Window_Blocks.CURTAINTALL_pink) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 6); }
			if (this == Window_Blocks.CURTAINTALL_gray) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 7); }
			if (this == Window_Blocks.CURTAINTALL_lightgray) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 8); }
			if (this == Window_Blocks.CURTAINTALL_cyan) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 9); }
			if (this == Window_Blocks.CURTAINTALL_purple) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 10); }
			if (this == Window_Blocks.CURTAINTALL_blue) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 11); }
			if (this == Window_Blocks.CURTAINTALL_brown) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 12); }
			if (this == Window_Blocks.CURTAINTALL_green) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 13); }
			if (this == Window_Blocks.CURTAINTALL_red) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 14); }
			if (this == Window_Blocks.CURTAINTALL_black) { return new ItemStack(Items_Chinjufu.CURTAINTALL_item, 1, 15); } }
		return null;
	}
	
	/* Methods for BlockState. */
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		if (state.getValue(HALF) == HalfState.LOWER) {
			IBlockState upState = worldIn.getBlockState(pos.up());

			if (upState.getBlock() == this) { state = state.withProperty(HINGE, upState.getValue(HINGE)); }
		}

		else {
			IBlockState downState = worldIn.getBlockState(pos.down());

			if (downState.getBlock() == this) {
				state = state.withProperty(H_FACING, downState.getValue(H_FACING)).withProperty(OPEN, downState.getValue(OPEN)); }
		}
		return state;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.getValue(HALF) != HalfState.LOWER ? state : state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING))).cycleProperty(HINGE);
	}

	public IBlockState getStateFromMeta(int meta) {
		return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, HalfState.UPPER)
				.withProperty(HINGE, (meta & 1) > 0 ? HingeState.LEFT : HingeState.RIGHT) : this.getDefaultState()
				.withProperty(HALF, HalfState.LOWER)
				.withProperty(H_FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW())
				.withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (state.getValue(HALF) == HalfState.UPPER) {
			i = i | 8;

			if (state.getValue(HINGE) == HingeState.LEFT) { i |= 1; }
		}

		else {
			i = i | ((EnumFacing)state.getValue(H_FACING)).rotateY().getHorizontalIndex();

			if (((Boolean)state.getValue(OPEN)).booleanValue()) { i |= 4; }
		}
		return i;
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { HALF, H_FACING, OPEN, HINGE });
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	@Override
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
}
