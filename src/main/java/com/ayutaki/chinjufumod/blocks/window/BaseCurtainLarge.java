package com.ayutaki.chinjufumod.blocks.window;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseCurtainLarge extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool OPEN = PropertyBool.create("open");
	public static final PropertyEnum<HingeState> HINGE = PropertyEnum.<HingeState>create("hinge", HingeState.class);
	public static final PropertyEnum<HalfState> HALF = PropertyEnum.<HalfState>create("half", HalfState.class);

	public BaseCurtainLarge(String name, Material material) {
		super(material);
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

	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	@Override
	 public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			if (state.getValue(HALF) == HalfState.UPPER) {
				if (worldIn.getBlockState(pos.down()).getBlock() != this) { worldIn.setBlockToAir(pos); } }
			
			else {
				if (worldIn.getBlockState(pos.up()).getBlock() != this) { worldIn.setBlockToAir(pos); }
			}
		}
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
			if (this == Window_Blocks.CURTAINL1_white || this == Window_Blocks.CURTAINL2_white) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 0); }
			if (this == Window_Blocks.CURTAINL1_orange || this == Window_Blocks.CURTAINL2_orange) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 1); }
			if (this == Window_Blocks.CURTAINL1_magenta || this == Window_Blocks.CURTAINL2_magenta) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 2); }
			if (this == Window_Blocks.CURTAINL1_lightblue || this == Window_Blocks.CURTAINL2_lightblue) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 3); }
			if (this == Window_Blocks.CURTAINL1_yellow || this == Window_Blocks.CURTAINL2_yellow) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 4); }
			if (this == Window_Blocks.CURTAINL1_lime || this == Window_Blocks.CURTAINL2_lime) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 5); }
			if (this == Window_Blocks.CURTAINL1_pink || this == Window_Blocks.CURTAINL2_pink) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 6); }
			if (this == Window_Blocks.CURTAINL1_gray || this == Window_Blocks.CURTAINL2_gray) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 7); }
			if (this == Window_Blocks.CURTAINL1_lightgray || this == Window_Blocks.CURTAINL2_lightgray) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 8); }
			if (this == Window_Blocks.CURTAINL1_cyan || this == Window_Blocks.CURTAINL2_cyan) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 9); }
			if (this == Window_Blocks.CURTAINL1_purple || this == Window_Blocks.CURTAINL2_purple) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 10); }
			if (this == Window_Blocks.CURTAINL1_blue || this == Window_Blocks.CURTAINL2_blue) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 11); }
			if (this == Window_Blocks.CURTAINL1_brown || this == Window_Blocks.CURTAINL2_brown) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 12); }
			if (this == Window_Blocks.CURTAINL1_green || this == Window_Blocks.CURTAINL2_green) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 13); }
			if (this == Window_Blocks.CURTAINL1_red || this == Window_Blocks.CURTAINL2_red) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 14); }
			if (this == Window_Blocks.CURTAINL1_black || this == Window_Blocks.CURTAINL2_black) { return new ItemStack(Items_Chinjufu.CURTAINL1_item, 1, 15); } }
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
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
