package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Enden_kara extends Block {

	/* Property */
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool EAST = PropertyBool.create("east");

	private static final AxisAlignedBB AABB_1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.90625D, 1.0D);

	public Enden_kara(String name) {
		super(Material.SAND);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.SAND);
		setHardness(2.0F);
		setResistance(10.0F);
		setLightOpacity(3);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(SOUTH, false)
				.withProperty(NORTH, false)
				.withProperty(WEST, false)
				.withProperty(EAST, false));
		
		setTickRandomly(true);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item == Items_Teatime.MIZUOKE_full) {
			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlockState(pos, Crop_Blocks.ENDEN.getDefaultState().withProperty(Enden.STAGE_1_9, Integer.valueOf(1)), 3); }
		
		if (item != Items_Teatime.MIZUOKE_full) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Connect the blocks. */
	private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
		IBlockState state = worldIn.getBlockState(pos.offset(facing));
		return state.getBlock() == this;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		boolean south = canConnectTo(worldIn, pos, EnumFacing.SOUTH);
		boolean north = canConnectTo(worldIn, pos, EnumFacing.NORTH);
		boolean west = canConnectTo(worldIn, pos, EnumFacing.WEST);
		boolean east = canConnectTo(worldIn, pos, EnumFacing.EAST);
		return state.withProperty(SOUTH, south)
				.withProperty(NORTH, north)
				.withProperty(WEST, west)
				.withProperty(EAST, east);
	}


	/* TickRandom */
	public static void turnToSand(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, Blocks.SAND.getDefaultState());
	}

	private boolean upAir(World worldIn, BlockPos pos) {
		IBlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		return (upBlock == Blocks.AIR);
	}

	/* RandomTick */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 1)) return;
		if (!upAir(worldIn, pos)) { turnToSand(worldIn, pos); }
	}

	@SuppressWarnings("deprecation")
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) { turnToSand(worldIn, pos); }
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB_1;
	}

	@Override
	public boolean isSideSolid(IBlockState baseState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP) { return true; }
		return false;
	}

	/* Data value */
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { SOUTH, NORTH, WEST, EAST });
	}

	/* モンスターをSpawnするようにする */
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess worldIn, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {
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

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Item.getItemFromBlock(Blocks.SAND)));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Item.getItemFromBlock(Blocks.SAND));
	}
}
