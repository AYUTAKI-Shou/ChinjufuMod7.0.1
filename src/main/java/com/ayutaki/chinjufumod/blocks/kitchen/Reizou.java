package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.GuiHandler_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Reizou extends BlockContainer {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool RIGHT = PropertyBool.create("right");
	//public static final PropertyBool OPEN = PropertyBool.create("open"); 追加は見送り
	
	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, 0.0, 0.0, 0.8375, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, 0.0, 0.0, 0.8375, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, 0.0, 0.0, 0.8375, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, 0.0, 0.0, 0.8375, 1.0, 1.0);
	protected static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };
	
	public Reizou(String name) {
		super(Material.WOOD);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(RIGHT, Boolean.valueOf(false)));
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		this.setDefaultDirection(worldIn, pos, state);
	}

	private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			EnumFacing enumfacing = (EnumFacing)state.getValue(H_FACING);
			worldIn.setBlockState(pos, state.withProperty(H_FACING, enumfacing), 2);
		}
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		TileEntity tile = worldIn.getTileEntity(pos);
		
		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());
		
		switch (direction) {
		case NORTH :
		default:
			if (!northState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (northState.getMaterial().isReplaceable()) {
				if (northState.getBlock() instanceof BlockStaticLiquid || northState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(northState.getBlock() instanceof BlockStaticLiquid) && !(northState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Reizou_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.REIZOU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
	
		case SOUTH :
			if (!southState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (southState.getMaterial().isReplaceable()) {
				if (southState.getBlock() instanceof BlockStaticLiquid || southState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(southState.getBlock() instanceof BlockStaticLiquid) && !(southState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Reizou_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.REIZOU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
	
		case EAST :
			if (!eastState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (eastState.getMaterial().isReplaceable()) {
				if (eastState.getBlock() instanceof BlockStaticLiquid || eastState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(eastState.getBlock() instanceof BlockStaticLiquid) && !(eastState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Reizou_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.REIZOU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
			
		case WEST :
			if (!westState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (westState.getMaterial().isReplaceable()) {
				if (westState.getBlock() instanceof BlockStaticLiquid || westState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(westState.getBlock() instanceof BlockStaticLiquid) && !(westState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Reizou_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.REIZOU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
		} // switch

		return true;
	}
	
	/* TileEntityを返す */
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new Reizou_TileEntity();
	}

	public TileEntity createTileEntity(World worldIn, IBlockState state) {
		return createNewTileEntity(worldIn, this.getMetaFromState(state));
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof Reizou_TileEntity) {
			((Reizou_TileEntity)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof Reizou_TileEntity) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}
		super.breakBlock(worldIn, pos, state);
	}

	/* チェストを壊した時の処理 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasCustomBreakingProgress(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}
	
	/*BlockState when it was placed.*/
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		
		if (this == Kitchen_Blocks.KIT_REIZOU) {
			worldIn.setBlockState(pos.up(), Kitchen_Blocks.KIT_REIZOU_TOP.getDefaultState()
					.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite())
					.withProperty(RIGHT, Boolean.valueOf(placer.isSneaking()))); }
		
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite())
				.withProperty(RIGHT, Boolean.valueOf(placer.isSneaking()));
	}

	/*IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる。*/
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		if (((Boolean)state.getValue(RIGHT)).booleanValue()) {
			i |= 4;
		}
		return i;
	}
	
	/*ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる。*/
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(RIGHT, Boolean.valueOf((meta & 4) != 0));
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}
	
	/* チェストに使うRenderType */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	/*Create BlockStates in this block.。*/
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, RIGHT });
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
			@Nullable Entity entityIn, boolean t_f) {

		EnumFacing facing = state.getValue(H_FACING);
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB[facing.getHorizontalIndex()]);
	}
	
	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof ReizouTop) {
			worldIn.destroyBlock(pos.up(), false);
		}
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

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
		return new ItemStack(Items_Teatime.KIT_REIZOU, 1, 0);
	}
}
