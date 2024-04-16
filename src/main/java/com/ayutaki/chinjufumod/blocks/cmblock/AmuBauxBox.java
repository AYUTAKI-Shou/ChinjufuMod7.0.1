package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AmuBauxBox extends BaseStage2_Face {

	/** 1=弾薬, 2=ボーキサイト **/
	public AmuBauxBox(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(2);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		/** Hand is Empty. **/
		if (stack.isEmpty() && facing == EnumFacing.UP) {
			if (i == 1) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.AMUBAUX, 1, 1));

				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }

			if (i == 2) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.AMUBAUX, 1, 2));

				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }
			return true;
		}
		
		if (!stack.isEmpty() && item != Items_Chinjufu.AMUBAUX) { 
			CMEvents.textFullItem(worldIn, pos, playerIn);
			return true; }
		
		return false;
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}
	
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		if (i == 2) { return new ItemStack(Items_Chinjufu.AMUBAUX, 1, 2); }
		return new ItemStack(Items_Chinjufu.AMUBAUX, 1, 1);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		if (i == 1) {
			stack.add(new ItemStack(Items_Chinjufu.EMPTY_BOX, 1, 0));
			stack.add(new ItemStack(Items_Weapon.AMMUNITION_L, 8, 0)); }

		if (i == 2) {
			stack.add(new ItemStack(Items_Chinjufu.EMPTY_BOX, 1, 0));
			stack.add(new ItemStack(Items_Chinjufu.BAUXITE, 8, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		if (i == 2) { return new ItemStack(Items_Chinjufu.AMUBAUX, 1, 2); }
		return new ItemStack(Items_Chinjufu.AMUBAUX, 1, 1);
	}
}
