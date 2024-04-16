package com.ayutaki.chinjufumod.blocks.pantry;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Sack_H extends BaseFacingSlabW {

	/* Collision */
	private static final AxisAlignedBB DOUBLE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	private static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB TOP_COLL = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

	public Sack_H(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		
		setSoundType(SoundType.PLANT);
		setHardness(1.0F);
		setResistance(5.0F);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == Kitchen_Blocks.BOX_H_COCO && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_COCO)) ||
					(this == Kitchen_Blocks.BOX_H_FLOUR && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_FLOUR)) ||
					(this == Kitchen_Blocks.BOX_H_RICE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_RICE)) ||
					(this == Kitchen_Blocks.BOX_H_SOY && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_SOY)) ||
					(this == Kitchen_Blocks.BOX_H_TGREEN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TGREEN)) ||
					(this == Kitchen_Blocks.BOX_H_TRED && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TRED)) ||
					(this == Kitchen_Blocks.BOX_H_KURI && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_KURI)) ||
					
					(this == Kitchen_Blocks.BOX_H_BPEPPER && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BPEPPER)) ||
					(this == Kitchen_Blocks.BOX_H_CUMIN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CUMIN)) ||
					(this == Kitchen_Blocks.BOX_H_TURMERIC && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TURMERIC)) ||
					(this == Kitchen_Blocks.BOX_H_CHILI && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHILI))) {

				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == Kitchen_Blocks.BOX_H_COCO && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_COCO)) ||
					(this == Kitchen_Blocks.BOX_H_FLOUR && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_FLOUR)) ||
					(this == Kitchen_Blocks.BOX_H_RICE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_RICE)) ||
					(this == Kitchen_Blocks.BOX_H_SOY && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_SOY)) ||
					(this == Kitchen_Blocks.BOX_H_TGREEN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TGREEN)) ||
					(this == Kitchen_Blocks.BOX_H_TRED && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TRED)) ||
					(this == Kitchen_Blocks.BOX_H_KURI && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_KURI)) ||
					
					(this == Kitchen_Blocks.BOX_H_BPEPPER && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BPEPPER)) ||
					(this == Kitchen_Blocks.BOX_H_CUMIN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CUMIN)) ||
					(this == Kitchen_Blocks.BOX_H_TURMERIC && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TURMERIC)) ||
					(this == Kitchen_Blocks.BOX_H_CHILI && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHILI))) {

				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** Slab は素手で回収可能 **/
		if (state.getValue(DOUBLE) != true && stack.isEmpty() && facing == EnumFacing.UP) {

			if (this == Kitchen_Blocks.BOX_H_COCO) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_COCO, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_FLOUR) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_FLOUR, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_RICE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_RICE, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_SOY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_SOY, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_TGREEN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TGREEN, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_TRED) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TRED, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_KURI) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_KURI, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_BPEPPER) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BPEPPER, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_CUMIN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CUMIN, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_TURMERIC) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TURMERIC, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_CHILI) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHILI, 1, 0)); }
			
			CMEvents.soundItemPick(worldIn, pos);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			return true; }


		/* Double */
		/** Double は素手で回収可能 **/
		if (state.getValue(DOUBLE) == true && stack.isEmpty() && facing == EnumFacing.UP) {

			if (this == Kitchen_Blocks.BOX_H_COCO) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_COCO, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_FLOUR) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_FLOUR, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_RICE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_RICE, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_SOY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_SOY, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_TGREEN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TGREEN, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_TRED) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TRED, 1, 0)); }

			if (this == Kitchen_Blocks.BOX_H_KURI) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_KURI, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_BPEPPER) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BPEPPER, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_CUMIN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CUMIN, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_TURMERIC) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TURMERIC, 1, 0)); }
			
			if (this == Kitchen_Blocks.BOX_H_CHILI) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHILI, 1, 0)); }
			
			CMEvents.soundItemPick(worldIn, pos);
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(DOUBLE, Boolean.valueOf(false)).withProperty(BaseFacingSlabW.HALF, SlabHalf.BOTTOM));
			return true; }

		/** 側面で設置可能にするため false **/
		return false;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		if (state.getValue(DOUBLE) == true) { return DOUBLE_AABB; }

		else { return (state.getValue(HALF) == SlabHalf.TOP)? TOP_AABB : BOTTOM_AABB; }
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		boolean flag = (state.getValue(DOUBLE) == true);
		SlabHalf blockhalf = state.getValue(HALF);

		switch(blockhalf) {
		case TOP :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : TOP_COLL); /** flag? true : false; **/
			break;
			
		case BOTTOM :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : BOTTOM_AABB);
			break;
		}
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
		int i = (state.getValue(DOUBLE) == true)? 2 : 1;
		return new ItemStack(this.takeItem(), i, 0);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = (state.getValue(DOUBLE) == true)? 2 : 1;
		int i8 = (state.getValue(DOUBLE) == true)? 16 : 8;
		
		if (this == Kitchen_Blocks.BOX_H_COCO) { stack.add(new ItemStack(Items.DYE, i8, 3)); }
		if (this == Kitchen_Blocks.BOX_H_FLOUR) { stack.add(new ItemStack(Items.WHEAT, i8, 0)); }
		if (this == Kitchen_Blocks.BOX_H_RICE) { stack.add(new ItemStack(Items_Teatime.SEEDS_RICE, i8, 0)); }
		if (this == Kitchen_Blocks.BOX_H_SOY) { stack.add(new ItemStack(Items_Teatime.SEEDS_SOY, i8, 0)); }
		if (this == Kitchen_Blocks.BOX_H_TGREEN) { stack.add(new ItemStack(Items_Teatime.CHADUTSU, i8, 0)); }
		if (this == Kitchen_Blocks.BOX_H_TRED) { stack.add(new ItemStack(Items_Teatime.CANTEA, i8, 0)); }
		if (this == Kitchen_Blocks.BOX_H_KURI) { stack.add(new ItemStack(Items_Seasonal.KURI, i8, 0)); }
		
		if (this == Kitchen_Blocks.BOX_H_BPEPPER) { stack.add(new ItemStack(Items_Teatime.SPICE, i8, 1)); }
		if (this == Kitchen_Blocks.BOX_H_CUMIN) { stack.add(new ItemStack(Items_Teatime.SPICE_NAE, i8, 1)); }
		if (this == Kitchen_Blocks.BOX_H_TURMERIC) { stack.add(new ItemStack(Items_Teatime.SPICE_NAE, i8, 2)); }
		if (this == Kitchen_Blocks.BOX_H_CHILI) { stack.add(new ItemStack(Items_Teatime.SPICE, i8, 2)); }
		
		stack.add(new ItemStack(Items_Teatime.BOX_H_EMPTY, i, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(this.takeItem(), 1, 0);
	}
	
	private Item takeItem() {
		if (this == Kitchen_Blocks.BOX_H_COCO) { return Items_Teatime.BOX_H_COCO; }
		if (this == Kitchen_Blocks.BOX_H_FLOUR) { return Items_Teatime.BOX_H_FLOUR; }
		if (this == Kitchen_Blocks.BOX_H_RICE) { return Items_Teatime.BOX_H_RICE; }
		if (this == Kitchen_Blocks.BOX_H_SOY) { return Items_Teatime.BOX_H_SOY; }
		if (this == Kitchen_Blocks.BOX_H_TGREEN) { return Items_Teatime.BOX_H_TGREEN; }
		if (this == Kitchen_Blocks.BOX_H_TRED) { return Items_Teatime.BOX_H_TRED; }
		if (this == Kitchen_Blocks.BOX_H_KURI) { return Items_Teatime.BOX_H_KURI; }
		
		if (this == Kitchen_Blocks.BOX_H_BPEPPER) { return Items_Teatime.BOX_H_BPEPPER; }
		if (this == Kitchen_Blocks.BOX_H_CUMIN) { return Items_Teatime.BOX_H_CUMIN; }
		if (this == Kitchen_Blocks.BOX_H_TURMERIC) { return Items_Teatime.BOX_H_TURMERIC; }
		if (this == Kitchen_Blocks.BOX_H_CHILI) { return Items_Teatime.BOX_H_CHILI; }
		
		return null;
	}
}
