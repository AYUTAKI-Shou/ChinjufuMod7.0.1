package com.ayutaki.chinjufumod.blocks.window;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;
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
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WindowTall extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool OPEN = PropertyBool.create("open");
	public static final PropertyEnum<HingeState> HINGE = PropertyEnum.<HingeState>create("hinge", HingeState.class);
	public static final PropertyEnum<HalfState> HALF = PropertyEnum.<HalfState>create("half", HalfState.class);

	/* Collision */
	protected static final AxisAlignedBB SOUTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0);
	protected static final AxisAlignedBB EAST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0);
	protected static final AxisAlignedBB WEST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_OPEN_R = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.4375, 0.0125, 0.8625, 1.4375, 0.9875, 0.9875);
	protected static final AxisAlignedBB EAST_AABB_OPEN_R = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.4375, 0.0125, 0.8625, 1.4375, 0.9875, 0.9875);
	protected static final AxisAlignedBB WEST_AABB_OPEN_R = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.4375, 0.0125, 0.8625, 1.4375, 0.9875, 0.9875);
	protected static final AxisAlignedBB NORTH_AABB_OPEN_R = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.4375, 0.0125, 0.8625, 1.4375, 0.9875, 0.9875);

	protected static final AxisAlignedBB SOUTH_AABB_OPEN_L = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.4375, 0.0125, 0.0125, 1.4375, 0.9875, 0.1375);
	protected static final AxisAlignedBB EAST_AABB_OPEN_L = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.4375, 0.0125, 0.0125, 1.4375, 0.9875, 0.1375);
	protected static final AxisAlignedBB WEST_AABB_OPEN_L = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.4375, 0.0125, 0.0125, 1.4375, 0.9875, 0.1375);
	protected static final AxisAlignedBB NORTH_AABB_OPEN_L = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.4375, 0.0125, 0.0125, 1.4375, 0.9875, 0.1375);

	public WindowTall(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
		
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(OPEN, Boolean.valueOf(false))
				.withProperty(HINGE, HingeState.RIGHT)
				.withProperty(HALF, HalfState.LOWER));
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
		boolean flag1 = state.getValue(HINGE) == HingeState.LEFT;

		switch (direction) {
		case SOUTH:
			return flag ? SOUTH_AABB_CLOSE : (flag1 ? SOUTH_AABB_OPEN_L : SOUTH_AABB_OPEN_R);
			
		case EAST:
			return flag ? EAST_AABB_CLOSE : (flag1 ? EAST_AABB_OPEN_L : EAST_AABB_OPEN_R);
			
		case WEST:
			return flag ? WEST_AABB_CLOSE : (flag1 ? WEST_AABB_OPEN_L : WEST_AABB_OPEN_R);
			
		case NORTH:
		default:
			return flag ? NORTH_AABB_CLOSE : (flag1 ? NORTH_AABB_OPEN_L : NORTH_AABB_OPEN_R);
		}
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

	/* Sound */
	private SoundEvent getCloseSound() {
		return SoundEvents_CM.WINDOW_CLOSE;
	}

	private SoundEvent getOpenSound() {
		return SoundEvents_CM.WINDOW_OPEN;
	}

	/* RightClick Action */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		BlockPos pos1 = state.getValue(HALF) == HalfState.LOWER ? pos : pos.down();
		IBlockState state1 = pos.equals(pos1) ? state : worldIn.getBlockState(pos1);
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Curtain_Item || item instanceof CurtainTall_Item) { return false; }

		else {
			state = state1.cycleProperty(OPEN);
			worldIn.setBlockState(pos1, state, 10);
			worldIn.markBlockRangeForRenderUpdate(pos1, pos);
			worldIn.playSound(null, pos, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
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
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
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
			if (this == Window_Blocks.WINDOWTALL_oak) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 0); }
			if (this == Window_Blocks.WINDOWTALL_spruce) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 1); }
			if (this == Window_Blocks.WINDOWTALL_birch) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 2); }
			if (this == Window_Blocks.WINDOWTALL_jungle) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 3); }
			if (this == Window_Blocks.WINDOWTALL_acacia) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 4); }
			if (this == Window_Blocks.WINDOWTALL_darkoak) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 5); }
			if (this == Window_Blocks.WINDOWTALL_sakura) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 6); }
			if (this == Window_Blocks.WINDOWTALL_kaede) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 7); }
			if (this == Window_Blocks.WINDOWTALL_ichoh) { return new ItemStack(Items_Chinjufu.WINDOWTALL_item, 1, 8); } 
		}
		return null;
	}
	
	/* Methods for BlockState. */
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		if (state.getValue(HALF) == HalfState.LOWER) {
			IBlockState upState = worldIn.getBlockState(pos.up());

			if (upState.getBlock() == this) {
				state = state.withProperty(HINGE, upState.getValue(HINGE)); }
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

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
