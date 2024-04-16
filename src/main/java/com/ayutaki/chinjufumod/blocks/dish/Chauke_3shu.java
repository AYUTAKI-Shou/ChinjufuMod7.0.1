package com.ayutaki.chinjufumod.blocks.dish;

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
import com.ayutaki.chinjufumod.registry.Items_Teatime;
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
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Chauke_3shu extends Block {

	/* Property */
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.28125D, 0.0D, 0.28125D, 0.71875D, 0.1875D, 0.71875D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.28125D, -0.5D, 0.28125D, 0.71875D, 0.01D, 0.71875D);

	public Chauke_3shu(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_15, Integer.valueOf(0)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		boolean empty = (i == 4 || i == 10 || i == 15);
		
		if (empty) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		if (!empty) {
			if (stack.isEmpty()) {
				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3);
				playerIn.inventory.addItemStackToInventory(this.takeStack(state)); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		
		if (i < 4) { return new ItemStack(Items_Teatime.SENBEI, 1); }
		if (i > 4 && i < 10) { return new ItemStack(Items_Teatime.FOOD_MIKAN, 1); }
		if (i > 10 && i < 15) { return new ItemStack(Items_Teatime.SCONE, 1); }
		return null;
	}
	
	/*Collision*/
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

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (15 - ((Integer)state.getValue(STAGE_0_15)).intValue()) * 2;
	}

	/* 描画指定 */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 0) { stack.add(new ItemStack(Items_Teatime.JPCHAUKE, 1, 0)); }
		if (i == 1) {
			stack.add(new ItemStack(Items_Teatime.SENBEI, 3, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 2) {
			stack.add(new ItemStack(Items_Teatime.SENBEI, 2, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 3) {
			stack.add(new ItemStack(Items_Teatime.SENBEI, 1, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }

		if (i == 5) { stack.add(new ItemStack(Items_Teatime.JPCHAUKE, 1, 1)); }
		if (i == 6) {
			stack.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 4, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 7) {
			stack.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 3, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 8) {
			stack.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 2, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 9) {
			stack.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }

		if (i == 11) { stack.add(new ItemStack(Items_Teatime.JPCHAUKE, 1, 2)); }
		if (i == 12) {
			stack.add(new ItemStack(Items_Teatime.SCONE, 3, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 13) {
			stack.add(new ItemStack(Items_Teatime.SCONE, 2, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		if (i == 14) {
			stack.add(new ItemStack(Items_Teatime.SCONE, 1, 0));
			stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }

		if (i == 4 || i == 10 || i == 15) { stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i < 4) { return new ItemStack(Items_Teatime.JPCHAUKE, 1, 0); }
		if (i > 4 && i < 10) { return new ItemStack(Items_Teatime.JPCHAUKE, 1, 1); }
		if (i > 10) { return new ItemStack(Items_Teatime.JPCHAUKE, 1, 2); }
		return new ItemStack(Items_Teatime.Item_SARA);
	}

}
