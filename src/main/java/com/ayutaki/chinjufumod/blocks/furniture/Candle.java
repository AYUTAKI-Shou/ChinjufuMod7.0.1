package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk_sub;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;
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
import net.minecraft.block.properties.PropertyInteger;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Candle extends Block {

	/* Property */
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.425D, 0.0D, 0.425D, 0.575D, 0.15625D, 0.575D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.425D, -0.5D, 0.425D, 0.575D, 0.01D, 0.575D);

	public Candle(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(STAGE_0_15, Integer.valueOf(0))
				.withProperty(DOWN, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			if (item == Items.FLINT_AND_STEEL) {
				CMEvents.soundFlint(worldIn, pos);
	
				if (i == 0) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(0))); }
				if (i == 1) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(1))); }
				if (i == 2) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(2))); }
				if (i == 3) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(3))); }
				if (i == 4) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(4))); }
				if (i == 5) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(5))); }
				if (i == 6) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(6))); }
				if (i == 7) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(7))); }
				if (i == 8) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(8))); }
				if (i == 9) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(9))); }
				if (i == 10) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(10))); }
				if (i == 11) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(11))); }
				if (i == 12) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(12))); }
				if (i == 13) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(13))); }
				if (i == 14) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(14))); }
				if (i == 15) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(15))); }
	
				stack.damageItem(1, playerIn); }
	
			if (item == Items_Teatime.Item_MATCH) {
				CMEvents.Consume1Item_Flint(worldIn, pos, playerIn, hand);	
	
				if (i == 0) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(0))); }
				if (i == 1) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(1))); }
				if (i == 2) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(2))); }
				if (i == 3) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(3))); }
				if (i == 4) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(4))); }
				if (i == 5) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(5))); }
				if (i == 6) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(6))); }
				if (i == 7) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(7))); }
				if (i == 8) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(8))); }
				if (i == 9) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(9))); }
				if (i == 10) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(10))); }
				if (i == 11) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(11))); }
				if (i == 12) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(12))); }
				if (i == 13) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(13))); }
				if (i == 14) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(14))); }
				if (i == 15) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_CANDLE.getDefaultState()
						.withProperty(Lit_Candle.STAGE_0_15, Integer.valueOf(15))); } }
		
			if (item != Items.FLINT_AND_STEEL && item != Items_Teatime.Item_MATCH) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB : AABB_DOWN;
	}

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
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()));
	}

	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOWN, STAGE_0_15 });
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

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
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}

	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		
		if (i == 0) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 0); }
		if (i == 1) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 4); }
		if (i == 5) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 5); }
		if (i == 6) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 6); }
		if (i == 7) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 7); }
		if (i == 8) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 8); }
		if (i == 9) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 9); }
		if (i == 10) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 10); }
		if (i == 11) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 11); }
		if (i == 12) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 12); }
		if (i == 13) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 13); }
		if (i == 14) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 14); }
		if (i == 15) { return new ItemStack(Items_Chinjufu.CANDLE_item, 1, 15); }
		return null;
	}
}
