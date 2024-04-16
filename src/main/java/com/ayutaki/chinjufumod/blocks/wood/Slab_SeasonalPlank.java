package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Slab_SeasonalPlank extends BaseSlabW {

	public Slab_SeasonalPlank(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.WOOD);
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

			if ((this == Seasonal_Blocks.SAKURA_slabhalf && item == Items_Seasonal.SAKURA_slabhalf) ||
					(this == Seasonal_Blocks.KAEDE_slabhalf && item == Items_Seasonal.KAEDE_slabhalf) ||
					(this == Seasonal_Blocks.ICHOH_slabhalf && item == Items_Seasonal.ICHOH_slabhalf)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == Seasonal_Blocks.SAKURA_slabhalf && item == Items_Seasonal.SAKURA_slabhalf) ||
					(this == Seasonal_Blocks.KAEDE_slabhalf && item == Items_Seasonal.KAEDE_slabhalf) ||
					(this == Seasonal_Blocks.ICHOH_slabhalf && item == Items_Seasonal.ICHOH_slabhalf)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** 側面で設置可能にするため false **/
		return false;
	}


	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = (state.getValue(DOUBLE) == true)? 2 : 1;
		stack.add(new ItemStack(this.takeItem(), i, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(this.takeItem(), 1, 0);
	}

	private Item takeItem() {
		if (this == Seasonal_Blocks.SAKURA_slabhalf) { return Items_Seasonal.SAKURA_slabhalf; }
		if (this == Seasonal_Blocks.KAEDE_slabhalf) { return Items_Seasonal.KAEDE_slabhalf; }
		if (this == Seasonal_Blocks.ICHOH_slabhalf) { return Items_Seasonal.ICHOH_slabhalf; }
		return null;
	}
}
