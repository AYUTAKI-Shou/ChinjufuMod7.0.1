package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.GuiHandler_CM;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tansu extends BlockContainer {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	//public static final PropertyBool OPEN = PropertyBool.create("open"); 追加は見送り
	
	public Tansu(String name) {
		super(Material.WOOD);
		setRegistryName(name);
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH));
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
					if (tile instanceof Tansu_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.TANSU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
	
		case SOUTH :
			if (!southState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (southState.getMaterial().isReplaceable()) {
				if (southState.getBlock() instanceof BlockStaticLiquid || southState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(southState.getBlock() instanceof BlockStaticLiquid) && !(southState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Tansu_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.TANSU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
	
		case EAST :
			if (!eastState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (eastState.getMaterial().isReplaceable()) {
				if (eastState.getBlock() instanceof BlockStaticLiquid || eastState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(eastState.getBlock() instanceof BlockStaticLiquid) && !(eastState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Tansu_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.TANSU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
				} }
			break;
			
		case WEST :
			if (!westState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (westState.getMaterial().isReplaceable()) {
				if (westState.getBlock() instanceof BlockStaticLiquid || westState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(westState.getBlock() instanceof BlockStaticLiquid) && !(westState.getBlock() instanceof BlockDynamicLiquid)) {
					if (tile instanceof Tansu_TileEntity) {
						playerIn.openGui(ChinjufuMod.instance, GuiHandler_CM.TANSU_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ()); }
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
		return new Tansu_TileEntity();
	}

	public TileEntity createTileEntity(World worldIn, IBlockState state) {
		return createNewTileEntity(worldIn, this.getMetaFromState(state));
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof Tansu_TileEntity) {
			((Tansu_TileEntity)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof Tansu_TileEntity) {
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
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/*IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる。*/
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(H_FACING)).getHorizontalIndex();
	}
	
	/*ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる。*/
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta));
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
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return true;
	}
	
	/*Create BlockStates in this block.。*/
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING });
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

		if (this == Furniture_Blocks.TANSU_OAK) { return new ItemStack(Items_Chinjufu.TANSU, 1, 0); }
		if (this == Furniture_Blocks.TANSU_SPRUCE) { return new ItemStack(Items_Chinjufu.TANSU, 1, 1); }
		if (this == Furniture_Blocks.TANSU_BIRCH) { return new ItemStack(Items_Chinjufu.TANSU, 1, 2); }
		if (this == Furniture_Blocks.TANSU_JUNGLE) { return new ItemStack(Items_Chinjufu.TANSU, 1, 3); }
		if (this == Furniture_Blocks.TANSU_ACACIA) { return new ItemStack(Items_Chinjufu.TANSU, 1, 4); }
		if (this == Furniture_Blocks.TANSU_DOAK) { return new ItemStack(Items_Chinjufu.TANSU, 1, 5); }
		if (this == Furniture_Blocks.TANSU_SAKURA) { return new ItemStack(Items_Chinjufu.TANSU, 1, 6); }
		if (this == Furniture_Blocks.TANSU_KAEDE) { return new ItemStack(Items_Chinjufu.TANSU, 1, 7); }
		if (this == Furniture_Blocks.TANSU_ICHOH) { return new ItemStack(Items_Chinjufu.TANSU, 1, 8); }
		return null;
	}
}
