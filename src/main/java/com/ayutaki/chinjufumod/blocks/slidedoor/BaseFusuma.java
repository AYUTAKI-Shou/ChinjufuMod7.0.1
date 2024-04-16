package com.ayutaki.chinjufumod.blocks.slidedoor;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseFusuma extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool OPEN = PropertyBool.create("open");
	/** 右取手・左蝶番で開くのが hinge=left **/
	/** 取手は引き戸のイメージ通りに, 上下を跨がず, 下ブロック内に付けるので決定稿 ガラス戸や障子も同様 **/
	public static final PropertyEnum<HingeState> HINGE = PropertyEnum.<HingeState>create("hinge", HingeState.class);
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	public static final PropertyEnum<HalfState> HALF = PropertyEnum.<HalfState>create("half", HalfState.class);

	/* Collision 0.40625D 0.59375D*/
	protected static final AxisAlignedBB SOUTH_AABB_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, 0.5D, 1.0D, 1.0D, 0.59375D);
	protected static final AxisAlignedBB SOUTH_AABB_OPEN_R = new AxisAlignedBB( -0.875D, 0.0D, 0.5D, 0.125D, 1.0D, 0.59375D);
	protected static final AxisAlignedBB SOUTH_AABB_OPEN_L = new AxisAlignedBB( 1.875D, 0.0D, 0.5D, 0.875D, 1.0D, 0.59375D);

	protected static final AxisAlignedBB EAST_AABB_CLOSE = new AxisAlignedBB( 0.5D, 0.0D, 0.0D, 0.59375D, 1.0D, 1.0D);
	protected static final AxisAlignedBB EAST_AABB_OPEN_R = new AxisAlignedBB( 0.5D, 0.0D, 1.875D, 0.59375D, 1.0D, 0.875D);
	protected static final AxisAlignedBB EAST_AABB_OPEN_L = new AxisAlignedBB( 0.5D, 0.0D, -0.875D, 0.59375D, 1.0D, 0.125D);

	protected static final AxisAlignedBB WEST_AABB_CLOSE = new AxisAlignedBB( 0.40625D, 0.0D, 0.0D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB WEST_AABB_OPEN_R = new AxisAlignedBB( 0.40625D, 0.0D, -0.875D, 0.5D, 1.0D, 0.125D);
	protected static final AxisAlignedBB WEST_AABB_OPEN_L = new AxisAlignedBB( 0.40625D, 0.0D, 1.875D, 0.5D, 1.0D, 0.875D);

	protected static final AxisAlignedBB NORTH_AABB_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, 0.40625D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB NORTH_AABB_OPEN_R = new AxisAlignedBB( 1.875D, 0.0D, 0.40625D, 0.875D, 1.0D, 0.5D);
	protected static final AxisAlignedBB NORTH_AABB_OPEN_L = new AxisAlignedBB( -0.875D, 0.0D, 0.40625D, 0.125D, 1.0D, 0.5D);

	protected BaseFusuma(String name, Material material) {
		super(material);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
		
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(OPEN, Boolean.valueOf(false))
				.withProperty(HINGE, HingeState.RIGHT)
				.withProperty(POWERED, Boolean.valueOf(false))
				.withProperty(HALF, HalfState.LOWER));
	}

	/* Collision */
	@Override
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

	@Override
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
		return SoundEvents_CM.FUSUMA;
	}

	private SoundEvent getOpenSound() {
		return SoundEvents_CM.FUSUMA;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		BlockPos pos1 = state.getValue(HALF) == HalfState.LOWER ? pos : pos.down();
		IBlockState state1 = pos.equals(pos1) ? state : worldIn.getBlockState(pos1);
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake || item instanceof Curtain_Item || item instanceof CurtainTall_Item) { return false; }

		else {
			state = state1.cycleProperty(OPEN);
			worldIn.setBlockState(pos1, state, 10);
			worldIn.markBlockRangeForRenderUpdate(pos1, pos);
			worldIn.playSound(null, pos, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			return true;
		}
	}

	/* 留め釘 村人AIが参照 他に参照がなく, 無くてもドアは動く？
	public void toggleDoor(World worldIn, BlockPos pos, boolean open) {
		IBlockState state = worldIn.getBlockState(pos);

		if (state.getBlock() == this) {

			BlockPos pos1 = state.getValue(HALF) == BlockBlockStateHalf.LOWER ? pos : pos.down();
			IBlockState state1 = pos == pos1 ? state : worldIn.getBlockState(pos1);

			if (state1.getBlock() == this && ((Boolean)state1.getValue(OPEN)).booleanValue() != open) {

				worldIn.setBlockState(pos1, state1.withProperty(OPEN, Boolean.valueOf(open)), 10);
				worldIn.markBlockRangeForRenderUpdate(pos1, pos);
				worldIn.playSound(null, pos, open ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}*/

	/* Power on/off. Destroy blocks. */
	@Override
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

			/* 下がガラス等だとアイテム化
			if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)) {
				worldIn.setBlockToAir(pos);
				flag1 = true;

				if (upState.getBlock() == this) { worldIn.setBlockToAir(upPos); }
			} */

			if (flag1) {
				if (!worldIn.isRemote) { this.dropBlockAsItem(worldIn, pos, state, 0); }
			}

			else {
				boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(upPos);

				if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean)upState.getValue(POWERED)).booleanValue()) {

					worldIn.setBlockState(upPos, upState.withProperty(POWERED, Boolean.valueOf(flag)), 2);

					if (flag != ((Boolean)state.getValue(OPEN)).booleanValue()) {
						worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
						worldIn.markBlockRangeForRenderUpdate(pos, pos);
						worldIn.playSound(null, pos, flag ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F); }
				}
			}
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
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
	
	/* Methods for BlockState. */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		if (state.getValue(HALF) == HalfState.LOWER) {
			IBlockState upState = worldIn.getBlockState(pos.up());

			if (upState.getBlock() == this) {
				state = state.withProperty(HINGE, upState.getValue(HINGE)).withProperty(POWERED, upState.getValue(POWERED)); }
		}

		else {
			IBlockState downState = worldIn.getBlockState(pos.down());

			if (downState.getBlock() == this) {
				state = state.withProperty(H_FACING, downState.getValue(H_FACING)).withProperty(OPEN, downState.getValue(OPEN)); }
		}
		return state;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.getValue(HALF) != HalfState.LOWER ? state : state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING))).cycleProperty(HINGE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, HalfState.UPPER)
				.withProperty(HINGE, (meta & 1) > 0 ? HingeState.LEFT : HingeState.RIGHT)
				.withProperty(POWERED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState()
				.withProperty(HALF, HalfState.LOWER)
				.withProperty(H_FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW())
				.withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (state.getValue(HALF) == HalfState.UPPER) {
			i = i | 8;

			if (state.getValue(HINGE) == HingeState.LEFT) { i |= 1; }

			if (((Boolean)state.getValue(POWERED)).booleanValue()) { i |= 2; }
		}

		else {
			i = i | ((EnumFacing)state.getValue(H_FACING)).rotateY().getHorizontalIndex();

			if (((Boolean)state.getValue(OPEN)).booleanValue()) { i |= 4; }
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { HALF, H_FACING, OPEN, HINGE, POWERED });
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
