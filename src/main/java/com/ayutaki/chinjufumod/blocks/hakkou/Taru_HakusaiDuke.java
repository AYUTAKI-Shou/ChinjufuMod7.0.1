package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Taru_HakusaiDuke extends Block {

	protected static final int COOK_TIME = 2000;
	/* Property */
	/** 0=下漬けF, 1=下漬け1, 2=本漬けF, 3=本漬け1, 4=白菜漬1, 5=白菜漬2, 6=白菜漬3, 7=白菜漬4, 8=空, 9=下漬けの空 **/
	public static final PropertyInteger STAGE_0_9 = PropertyInteger.create("stage", 0, 9);

	public Taru_HakusaiDuke(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* TickRandom */
	@Override
	public int tickRate(World worldIn) {
		return COOK_TIME;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();
		/** 0=下漬けF, 1=下漬け1, 2=本漬けF, 3=本漬け1, 4=白菜漬1, 5=白菜漬2, 6=白菜漬3, 7=白菜漬4, 8=空, 9=下漬けの空 **/
		if (i == 1 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9) { }

		if (i == 0) { worldIn.setBlockState(pos, this.getDefaultState().withProperty(Taru_HakusaiDuke.STAGE_0_9, Integer.valueOf(1))); }
		if (i == 2) { worldIn.setBlockState(pos, this.getDefaultState().withProperty(Taru_HakusaiDuke.STAGE_0_9, Integer.valueOf(3))); }
		if (i == 3) { worldIn.setBlockState(pos, this.getDefaultState().withProperty(Taru_HakusaiDuke.STAGE_0_9, Integer.valueOf(4))); }

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		/** 0=下漬けF, 1=下漬け1, 2=本漬けF, 3=本漬け1, 4=白菜漬1, 5=白菜漬2, 6=白菜漬3, 7=白菜漬4, 8=空, 9=下漬けの空 **/
		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();

		/** Too early to collect **/
		if (i == 0 || i == 2 || i == 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		if (i == 1) {
			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3);
	
				if (stack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_HAKUSAI2, 1)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_HAKUSAI2, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.FOOD_HAKUSAI2, 1), false); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i >= 4 && i <= 7) {
			if (item == Items_Teatime.Item_SARA) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_9, Integer.valueOf(i + 1)), 3);
	
				if (i == 4) {
					/** 経験値取得 **/
					playerIn.addExperience(1);
					worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F); }
	
				if (stack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.HAKUSAIDUKE, 1)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.HAKUSAIDUKE, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.HAKUSAIDUKE, 1), false); } }
			
			if (item != Items_Teatime.Item_SARA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** It is Empty. **/
		if (i == 8 || i == 9) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_9, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_9)).intValue();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_9 });
	}

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (6 - ((Integer)state.getValue(STAGE_0_9)).intValue()) * 2;
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
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		/** 0=下漬けF, 1=下漬け1, 2=本漬けF, 3=本漬け1, 4=白菜漬1, 5=白菜漬2, 6=白菜漬3, 7=白菜漬4, 8=空, 9=下漬けの空 **/
		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();

		if (i == 0) { return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.4375D, 1.0D); }
		if (i == 1) { return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.15625D, 1.0D); }
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();

		/** 0=下漬けF, 1=下漬け1, 2=本漬けF, 3=本漬け1, 4=白菜漬1, 5=白菜漬2, 6=白菜漬3, 7=白菜漬4, 8=空, 9=下漬けの空 **/
		if (i == 0) { stack.add(new ItemStack(Items_Teatime.HAKUSAI_TARU, 1, 1)); }

		if (i == 1) {
			stack.add(new ItemStack(Blocks.STONE_SLAB, 2, 0));
			stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0));
			stack.add(new ItemStack(Items_Teatime.FOOD_HAKUSAI2, 1, 0)); }

		if (i == 2 || i == 3) { stack.add(new ItemStack(Items_Teatime.HAKUSAI_TARU, 1, 2)); }

		if (i == 4 || i == 5 || i == 6 || i == 7 || i == 8) {
			stack.add(new ItemStack(Blocks.STONE_SLAB, 1, 0));
			stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }

		if (i == 9) {
			stack.add(new ItemStack(Blocks.STONE_SLAB, 2, 0));
			stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();
		/** 0=下漬けF, 1=下漬け1, 2=本漬けF, 3=本漬け1, 4=白菜漬1, 5=白菜漬2, 6=白菜漬3, 7=白菜漬4, 8=空, 9=下漬けの空 **/

		if (i == 0 || i == 1) { return new ItemStack(Items_Teatime.HAKUSAI_TARU, 1, 1); }
		if (i == 8 || i == 9) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0); }
		return new ItemStack(Items_Teatime.HAKUSAI_TARU, 1, 2);
	}

}
