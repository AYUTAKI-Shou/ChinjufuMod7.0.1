package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Endai_sub extends Block {

	/* Property */
	public static final PropertyBool BACK = PropertyBool.create("back");
	public static final PropertyBool FORWARD = PropertyBool.create("forward");
	public static final PropertyBool LEFT = PropertyBool.create("left");
	public static final PropertyBool RIGHT = PropertyBool.create("right");

	/** 0=縁台, 1=縁台(赤), 2=ティーテーブル **/
	public static final PropertyInteger STAGE_0_2 = PropertyInteger.create("stage", 0, 2);

	public Endai_sub(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(BACK, false)
				.withProperty(FORWARD, false)
				.withProperty(LEFT, false)
				.withProperty(RIGHT, false)
				.withProperty(STAGE_0_2, Integer.valueOf(0)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_0_2)).intValue();

		if (stack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundWoodPlace(worldIn, pos);
	
				if (i == 0) { worldIn.setBlockState(pos, Unit_Blocks.ENDAI.getDefaultState()
						.withProperty(Endai.STAGE_0_2, Integer.valueOf(0))); }
				if (i == 1) { worldIn.setBlockState(pos, Unit_Blocks.ENDAI.getDefaultState()
						.withProperty(Endai.STAGE_0_2, Integer.valueOf(1))); }
				if (i == 2) { worldIn.setBlockState(pos, Unit_Blocks.ENDAI.getDefaultState()
						.withProperty(Endai.STAGE_0_2, Integer.valueOf(2))); } }
			
			if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
			
			return true;
		}
		return false;
	}

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_2, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_2)).intValue();
	}

	/* Connect the blocks. */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		boolean back = worldIn.getBlockState(pos.south()).getBlock() == this;
		boolean forward = worldIn.getBlockState(pos.north()).getBlock() == this;
		boolean left = worldIn.getBlockState(pos.west()).getBlock() == this;
		boolean right = worldIn.getBlockState(pos.east()).getBlock() == this;
		return state.withProperty(BACK, back)
				.withProperty(FORWARD, forward)
				.withProperty(LEFT, left)
				.withProperty(RIGHT, right);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { BACK, FORWARD, LEFT, RIGHT, STAGE_0_2 });
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/** 0=縁台, 1=縁台(赤), 2=ティーテーブル **/
		int i = ((Integer)state.getValue(STAGE_0_2)).intValue();

		if (i == 0) { stack.add(new ItemStack(Items_Wadeco.ENDAI, 1, 0)); }
		if (i == 1) { stack.add(new ItemStack(Items_Wadeco.ENDAI, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Teatime.TEATABLE, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		/** 0=縁台, 1=縁台(赤), 2=ティーテーブル **/
		int i = ((Integer)state.getValue(STAGE_0_2)).intValue();

		if (i == 1) { return new ItemStack(Items_Wadeco.ENDAI, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Teatime.TEATABLE); }
		return new ItemStack(Items_Wadeco.ENDAI, 1, 0);
	}


}
