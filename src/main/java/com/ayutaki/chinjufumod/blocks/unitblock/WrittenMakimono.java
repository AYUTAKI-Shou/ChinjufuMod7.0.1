package com.ayutaki.chinjufumod.blocks.unitblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;

public class WrittenMakimono extends Block {

	/* Property */
	public static final PropertyInteger STAGE_1_4 = PropertyInteger.create("stage", 1, 4);
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	private static final AxisAlignedBB AABB_1S = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.578125);
	private static final AxisAlignedBB AABB_1W = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.578125);
	private static final AxisAlignedBB AABB_1N = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.578125);
	private static final AxisAlignedBB AABB_1E = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.578125);

	private static final AxisAlignedBB AABB_2S = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.734375);
	private static final AxisAlignedBB AABB_2W = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.734375);
	private static final AxisAlignedBB AABB_2N = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.734375);
	private static final AxisAlignedBB AABB_2E = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.421875, 0.75, 0.15625, 0.734375);
	
	private static final AxisAlignedBB AABB_3S = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.265625, 0.75, 0.15625, 0.734375);
	private static final AxisAlignedBB AABB_3W = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.265625, 0.75, 0.15625, 0.734375);
	private static final AxisAlignedBB AABB_3N = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.265625, 0.75, 0.15625, 0.734375);
	private static final AxisAlignedBB AABB_3E = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.265625, 0.75, 0.15625, 0.734375);
	
	private static final AxisAlignedBB AABB_4S = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	private static final AxisAlignedBB AABB_4W = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	private static final AxisAlignedBB AABB_4N = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	private static final AxisAlignedBB AABB_4E = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	
	private static final AxisAlignedBB DOWN_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);
	private static final AxisAlignedBB DOWN_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);
	private static final AxisAlignedBB DOWN_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);
	private static final AxisAlignedBB DOWN_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);

	
	public WrittenMakimono(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(0.5F);
		setResistance(0.5F);
		setLightOpacity(0);
		
		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(STAGE_1_4, Integer.valueOf(1))
				.withProperty(DOWN, Boolean.valueOf(false)));
	}

	/* BlockState when it was placed. */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(STAGE_1_4)).intValue() - 1 << 2;
		return i;
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(STAGE_1_4, Integer.valueOf(1 + (meta >> 2)));
	}

	@Override
	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (4 - ((Integer)state.getValue(STAGE_1_4)).intValue()) * 2;
	}

	/*Collision*/
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* Reaction to Neighboring blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		return block instanceof Chabudai || block instanceof LowDesk || block instanceof Kotatsu ||
					block instanceof Chabudai_sub || block instanceof LowDesk_sub || block instanceof Kotatsu_sub ||
					(block instanceof BaseFacingSlabW && state.getValue(BaseFacingSlabW.HALF) == SlabHalf.BOTTOM && state.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabW && state.getValue(BaseSlabW.HALF) == SlabHalf.BOTTOM && state.getValue(BaseSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabWType2 && state.getValue(BaseSlabWType2.HALF) == SlabHalf.BOTTOM && state.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(block instanceof BlockHalfWoodSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlabNew && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())));
	}

	/*Create BlockStates in this block. */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOWN, H_FACING, STAGE_1_4 });
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

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return ((Integer)state.getValue(STAGE_1_4)).intValue();
	}
	 
	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		return true;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (worldIn instanceof World) {
			LootTable table = null;
			switch (i) {
			case 1 :
				table = ((World) worldIn).getLootTableManager()
						.getLootTableFromLocation(new ResourceLocation(ChinjufuMod.MOD_ID, "blocks/block_written_book")); 
				break;
				
			case 2 :
				table = ((World) worldIn).getLootTableManager()
						.getLootTableFromLocation(new ResourceLocation(ChinjufuMod.MOD_ID, "blocks/block_written_book2")); 
				break;
				
			case 3 :
				table = ((World) worldIn).getLootTableManager()
						.getLootTableFromLocation(new ResourceLocation(ChinjufuMod.MOD_ID, "blocks/block_written_book3")); 
				break;
				
			case 4 :
				table = ((World) worldIn).getLootTableManager()
						.getLootTableFromLocation(new ResourceLocation(ChinjufuMod.MOD_ID, "blocks/block_written_book4")); 
				break;
				
			default : return; } // switch
			
			LootContext context = new LootContext.Builder(((WorldServer) worldIn)).build();
			drops.addAll(table.generateLootForPools(((World) worldIn).rand, context));
		}
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items.BOOK, 1, 0);
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
			case SOUTH:
				return flag? ((i == 1)? AABB_1S : ((i == 2)? AABB_2S : ((i == 3)? AABB_3S : AABB_4S))) : DOWN_SOUTH;
			case WEST:
				return flag? ((i == 1)? AABB_1W : ((i == 2)? AABB_2W : ((i == 3)? AABB_3W : AABB_4W))) : DOWN_WEST;
			case NORTH:
			default:
				return flag? ((i == 1)? AABB_1N : ((i == 2)? AABB_2N : ((i == 3)? AABB_3N : AABB_4N))) : DOWN_NORTH;
			case EAST:
				return flag? ((i == 1)? AABB_1E : ((i == 2)? AABB_2E : ((i == 3)? AABB_3E : AABB_4E))) : DOWN_EAST;
		}
	}
	
}
