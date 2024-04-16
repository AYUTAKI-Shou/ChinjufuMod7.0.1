package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kitchen.BaseKit_TanaWine;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kit_Tana2Sake extends BaseKit_TanaWine {

	public Kit_Tana2Sake(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item != this.takeItem()) {
			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(this.takeItem(), 1, 0));
				CMEvents.soundTakeSakeBottle(worldIn, pos);
	
				if (i == 1) { worldIn.setBlockState(pos, Kitchen_Blocks.WINE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))); }
				if (i != 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == this.takeItem()) {
			if (i != 4) {
				CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (i == 4) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		/** 'true' to not put anything on top. **/
		return true;
	}

	private Item takeItem() {
		if (this == Kitchen_Blocks.KIT_SAKENAMA) { return Items_Teatime.NAMASAKEBOT; }
		if (this == Kitchen_Blocks.KIT_SAKE) { return Items_Teatime.SAKEBOT; }
		if (this == Kitchen_Blocks.KIT_SAKEJUKU) { return Items_Teatime.JUKUSAKEBOT; }
		if (this == Kitchen_Blocks.KIT_CIDER) { return Items_Teatime.CIDERBOT; }
		if (this == Kitchen_Blocks.KIT_CIDERJUKU) { return Items_Teatime.JUKUCIDERBOT; }
		if (this == Kitchen_Blocks.KIT_WINE) { return Items_Teatime.WINEBOT; }
		if (this == Kitchen_Blocks.KIT_WINEJUKU) { return Items_Teatime.JUKUWINEBOT; }
		if (this == Kitchen_Blocks.KIT_MEAD) { return Items_Teatime.MEADBOT; }
		if (this == Kitchen_Blocks.KIT_MEADJUKU) { return Items_Teatime.JUKUMEADBOT; }
		return null;
	}
	
	/* Drop Item and Clone Item. */
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(this.takeItem(), 1, 0)); }

		if (i == 2) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(this.takeItem(), 2, 0)); }

		if (i == 3) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(this.takeItem(), 3, 0)); }

		if (i == 4) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(this.takeItem(), 4, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.WINE_TANA);
	}
}
