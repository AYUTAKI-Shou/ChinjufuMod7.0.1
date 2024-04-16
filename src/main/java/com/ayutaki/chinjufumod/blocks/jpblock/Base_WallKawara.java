package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.garden.Itabei;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;
import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoor;
import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoorHalf;
import com.ayutaki.chinjufumod.blocks.slidedoor.Shouji;
import com.ayutaki.chinjufumod.blocks.slidedoor.ShoujiHalf;
import com.ayutaki.chinjufumod.blocks.slidedoor.ShoujiWindow;
import com.ayutaki.chinjufumod.blocks.window.Window;
import com.ayutaki.chinjufumod.blocks.window.WindowB;
import com.ayutaki.chinjufumod.blocks.window.WindowTall;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_Bottom;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_Top;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Base_WallKawara extends Block {

	/* Property */
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);

	/* Collision ...Based on the value of WallBlock.*/
	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {
			new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5D, 0.875D),
			new AxisAlignedBB(0.125D, 0.0D, 0.25D, 0.875D, 0.5D, 1.0D), //SOUTH
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 0.75D, 0.5D, 0.875D), //WEST
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 0.875D, 0.5D, 1.0D),
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 0.875D, 0.5D, 0.75D), //NORTH
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 0.875D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.875D, 0.5D, 0.875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.875D, 0.5D, 1.0D),
			new AxisAlignedBB(0.25D, 0.0D, 0.125D, 1.0D, 0.5D, 0.875D), //EAST
			new AxisAlignedBB(0.125D, 0.0D, 0.125D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 1.0D, 0.5D, 0.875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 1.0D, 0.5D, 0.875D),
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D) };
	
	public Base_WallKawara(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(NORTH, false)
				.withProperty(EAST, false)
				.withProperty(SOUTH, false)
				.withProperty(WEST, false)
				.withProperty(STAGE_0_15, Integer.valueOf(0)));

		setLightOpacity(1);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return BOUNDING_BOXES[getBoundingBoxIdx(state)];
	}

	private static int getBoundingBoxIdx(IBlockState state) {
		int i = 0;
		if (((Boolean)state.getValue(NORTH)).booleanValue()) { i |= 1 << EnumFacing.NORTH.getHorizontalIndex(); }
		if (((Boolean)state.getValue(EAST)).booleanValue()) { i |= 1 << EnumFacing.EAST.getHorizontalIndex(); }
		if (((Boolean)state.getValue(SOUTH)).booleanValue()) { i |= 1 << EnumFacing.SOUTH.getHorizontalIndex(); }
		if (((Boolean)state.getValue(WEST)).booleanValue()) { i |= 1 << EnumFacing.WEST.getHorizontalIndex(); }
		return i;
	}
	
	/* Connect the blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
		IBlockState state = worldIn.getBlockState(pos);
		BlockFaceShape faceshape = state.getBlockFaceShape(worldIn, pos, facing);
		Block block = state.getBlock();
		boolean flag = (block instanceof Base_Wall || block instanceof Wall_DirtWall || block instanceof Base_WallKawara || block instanceof Wall_Sama ||
				block instanceof GlassDoor || block instanceof GlassDoorHalf || block instanceof BlockWall ||
				block instanceof Shouji || block instanceof ShoujiWindow || block instanceof ShoujiHalf ||
				block instanceof Fusuma || block instanceof Fusuma_B || block instanceof Window || block instanceof WindowB ||
				block instanceof WindowTall_Bottom || block instanceof WindowTall_Top || block instanceof WindowTall || block instanceof Itabei ||
				block instanceof BlockFenceGate || block instanceof BlockWall || block instanceof BlockPane);
		return !isExcepBlockForAttachWithPiston(block) && faceshape == BlockFaceShape.SOLID || flag;
	}
	
	protected static boolean isExcepBlockForAttachWithPiston(Block blockIn) {
		return Block.isExceptBlockForAttachWithPiston(blockIn) || blockIn == Blocks.BARRIER || 
				blockIn == Blocks.MELON_BLOCK || blockIn == Blocks.PUMPKIN || blockIn == Blocks.LIT_PUMPKIN;
	}
	
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return canConnectTo(world, pos.offset(facing), facing.getOpposite());
	}

	private boolean canWallConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		BlockPos other = pos.offset(facing);
		Block block = world.getBlockState(other).getBlock();
		return block.canBeConnectedTo(world, other, facing.getOpposite()) || canConnectTo(world, other, facing.getOpposite());
	}
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		IBlockState downState = worldIn.getBlockState(downPos);

		boolean cube = downState.isFullCube();
		boolean sama = downState.getBlock() instanceof Wall_Sama;
		boolean samaEW = sama && (downState.getValue(Wall_Sama.H_FACING) == EnumFacing.EAST || downState.getValue(Wall_Sama.H_FACING) == EnumFacing.WEST);
		boolean samaNS = sama && (downState.getValue(Wall_Sama.H_FACING) == EnumFacing.NORTH || downState.getValue(Wall_Sama.H_FACING) == EnumFacing.SOUTH);
		
		boolean itabei = downState.getBlock() instanceof Itabei && !downState.getValue(Itabei.CHECK);
		boolean itabeiEW = itabei && (downState.getValue(Itabei.H_FACING) == EnumFacing.EAST || downState.getValue(Itabei.H_FACING) == EnumFacing.WEST);
		boolean itabeiNS = itabei && (downState.getValue(Itabei.H_FACING) == EnumFacing.NORTH || downState.getValue(Itabei.H_FACING) == EnumFacing.SOUTH);
		
		boolean north = canWallConnectTo(worldIn, pos, EnumFacing.NORTH) ||
				(!cube && canWallConnectTo(worldIn, pos.down(), EnumFacing.NORTH)) || samaEW || itabeiEW;
		
		boolean east = canWallConnectTo(worldIn, pos, EnumFacing.EAST) ||
				(!cube && canWallConnectTo(worldIn, pos.down(), EnumFacing.EAST)) || samaNS || itabeiNS;
		
		boolean south = canWallConnectTo(worldIn, pos, EnumFacing.SOUTH) ||
				(!cube && canWallConnectTo(worldIn, pos.down(), EnumFacing.SOUTH)) || samaEW || itabeiEW;
		
		boolean west = canWallConnectTo(worldIn, pos, EnumFacing.WEST) ||
				(!cube && canWallConnectTo(worldIn, pos.down(), EnumFacing.WEST)) || samaNS || itabeiNS;
		
		return state.withProperty(NORTH, north).withProperty(EAST, east).withProperty(SOUTH, south).withProperty(WEST, west);
	}
	
	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	@Override
	public boolean isSideSolid(IBlockState baseState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, SOUTH, WEST, STAGE_0_15 });
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

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}
}
