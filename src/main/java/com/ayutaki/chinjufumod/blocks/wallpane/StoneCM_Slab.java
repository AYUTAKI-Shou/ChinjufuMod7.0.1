package com.ayutaki.chinjufumod.blocks.wallpane;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_WallPane;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;
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

public class StoneCM_Slab extends BaseSlabW {

	public StoneCM_Slab(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.WALLPANEL);

		setSoundType(SoundType.STONE);
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

			if ((this == WallBrick_Blocks.RGRA_slabhalf && item == Items_WallPane.RGRA_slabhalf) ||
					(this == WallBrick_Blocks.RDIO_slabhalf && item == Items_WallPane.RDIO_slabhalf) ||
					(this == WallBrick_Blocks.RAND_slabhalf && item == Items_WallPane.RAND_slabhalf) ||
					(this == WallBrick_Blocks.BGC_slabhalf && item == Items_WallPane.BGC_slabhalf) ||
					(this == WallBrick_Blocks.BDC_slabhalf && item == Items_WallPane.BDC_slabhalf) ||
					(this == WallBrick_Blocks.BAC_slabhalf && item == Items_WallPane.BAC_slabhalf)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == WallBrick_Blocks.RGRA_slabhalf && item == Items_WallPane.RGRA_slabhalf) ||
					(this == WallBrick_Blocks.RDIO_slabhalf && item == Items_WallPane.RDIO_slabhalf) ||
					(this == WallBrick_Blocks.RAND_slabhalf && item == Items_WallPane.RAND_slabhalf) ||
					(this == WallBrick_Blocks.BGC_slabhalf && item == Items_WallPane.BGC_slabhalf) ||
					(this == WallBrick_Blocks.BDC_slabhalf && item == Items_WallPane.BDC_slabhalf) ||
					(this == WallBrick_Blocks.BAC_slabhalf && item == Items_WallPane.BAC_slabhalf)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** スニーキング右クリックで CRA を往復 **/


		/** 側面で設置可能にするため false **/
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
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn,
			BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(this.takeItem(), 1, 0);
	}

	private Item takeItem() {
		if (this == WallBrick_Blocks.RGRA_slabhalf) { return Items_WallPane.RGRA_slabhalf; }
		if (this == WallBrick_Blocks.RDIO_slabhalf) { return Items_WallPane.RDIO_slabhalf; }
		if (this == WallBrick_Blocks.RAND_slabhalf) { return Items_WallPane.RAND_slabhalf; }
		if (this == WallBrick_Blocks.BGC_slabhalf) { return Items_WallPane.BGC_slabhalf; }
		if (this == WallBrick_Blocks.BDC_slabhalf) { return Items_WallPane.BDC_slabhalf; }
		if (this == WallBrick_Blocks.BAC_slabhalf) { return Items_WallPane.BAC_slabhalf; }
		return null;
	}
}
