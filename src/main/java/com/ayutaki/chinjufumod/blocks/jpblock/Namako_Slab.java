package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;
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

public class Namako_Slab extends BaseSlabWType2 {

	public Namako_Slab(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.WABLOCK);

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

		if (item instanceof Base_ItemHake) { return false; }
		
		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == JPBlock_Blocks.NAMAKO_SH_white && item == Items_Wablock.NAMAKO_SH_white) ||
					(this == JPBlock_Blocks.NAMAKO_SH_orange && item == Items_Wablock.NAMAKO_SH_orange) ||
					(this == JPBlock_Blocks.NAMAKO_SH_magenta && item == Items_Wablock.NAMAKO_SH_magenta) ||
					(this == JPBlock_Blocks.NAMAKO_SH_yellow && item == Items_Wablock.NAMAKO_SH_yellow) ||
					(this == JPBlock_Blocks.NAMAKO_SH_lime && item == Items_Wablock.NAMAKO_SH_lime) ||
					(this == JPBlock_Blocks.NAMAKO_SH_pink && item == Items_Wablock.NAMAKO_SH_pink) ||
					(this == JPBlock_Blocks.NAMAKO_SH_gray && item == Items_Wablock.NAMAKO_SH_gray) ||
					(this == JPBlock_Blocks.NAMAKO_SH_lightb && item == Items_Wablock.NAMAKO_SH_lightb) ||
					(this == JPBlock_Blocks.NAMAKO_SH_lightg && item == Items_Wablock.NAMAKO_SH_lightg) ||
					(this == JPBlock_Blocks.NAMAKO_SH_cyan && item == Items_Wablock.NAMAKO_SH_cyan) ||
					(this == JPBlock_Blocks.NAMAKO_SH_purple && item == Items_Wablock.NAMAKO_SH_purple) ||
					(this == JPBlock_Blocks.NAMAKO_SH_blue && item == Items_Wablock.NAMAKO_SH_blue) ||
					(this == JPBlock_Blocks.NAMAKO_SH_brown && item == Items_Wablock.NAMAKO_SH_brown) ||
					(this == JPBlock_Blocks.NAMAKO_SH_green && item == Items_Wablock.NAMAKO_SH_green) ||
					(this == JPBlock_Blocks.NAMAKO_SH_red && item == Items_Wablock.NAMAKO_SH_red) ||
					(this == JPBlock_Blocks.NAMAKO_SH_black && item == Items_Wablock.NAMAKO_SH_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == JPBlock_Blocks.NAMAKO_SH_white && item == Items_Wablock.NAMAKO_SH_white) ||
					(this == JPBlock_Blocks.NAMAKO_SH_orange && item == Items_Wablock.NAMAKO_SH_orange) ||
					(this == JPBlock_Blocks.NAMAKO_SH_magenta && item == Items_Wablock.NAMAKO_SH_magenta) ||
					(this == JPBlock_Blocks.NAMAKO_SH_yellow && item == Items_Wablock.NAMAKO_SH_yellow) ||
					(this == JPBlock_Blocks.NAMAKO_SH_lime && item == Items_Wablock.NAMAKO_SH_lime) ||
					(this == JPBlock_Blocks.NAMAKO_SH_pink && item == Items_Wablock.NAMAKO_SH_pink) ||
					(this == JPBlock_Blocks.NAMAKO_SH_gray && item == Items_Wablock.NAMAKO_SH_gray) ||
					(this == JPBlock_Blocks.NAMAKO_SH_lightb && item == Items_Wablock.NAMAKO_SH_lightb) ||
					(this == JPBlock_Blocks.NAMAKO_SH_lightg && item == Items_Wablock.NAMAKO_SH_lightg) ||
					(this == JPBlock_Blocks.NAMAKO_SH_cyan && item == Items_Wablock.NAMAKO_SH_cyan) ||
					(this == JPBlock_Blocks.NAMAKO_SH_purple && item == Items_Wablock.NAMAKO_SH_purple) ||
					(this == JPBlock_Blocks.NAMAKO_SH_blue && item == Items_Wablock.NAMAKO_SH_blue) ||
					(this == JPBlock_Blocks.NAMAKO_SH_brown && item == Items_Wablock.NAMAKO_SH_brown) ||
					(this == JPBlock_Blocks.NAMAKO_SH_green && item == Items_Wablock.NAMAKO_SH_green) ||
					(this == JPBlock_Blocks.NAMAKO_SH_red && item == Items_Wablock.NAMAKO_SH_red) ||
					(this == JPBlock_Blocks.NAMAKO_SH_black && item == Items_Wablock.NAMAKO_SH_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		else {
			if (stack.isEmpty()) {
				/** スニーキング右クリックで CRA を往復 **/
				if (playerIn.isSneaking()) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlockState(pos, state.cycleProperty(CRA), 2); }
				return true; 
			}
		}
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
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(this.takeItem(), 1, 0);
	}

	private Item takeItem() {
		if (this == JPBlock_Blocks.NAMAKO_SH_white) { return Items_Wablock.NAMAKO_SH_white; }
		if (this == JPBlock_Blocks.NAMAKO_SH_orange) { return Items_Wablock.NAMAKO_SH_orange; }
		if (this == JPBlock_Blocks.NAMAKO_SH_magenta) { return Items_Wablock.NAMAKO_SH_magenta; }
		if (this == JPBlock_Blocks.NAMAKO_SH_lightb) { return Items_Wablock.NAMAKO_SH_lightb; }
		if (this == JPBlock_Blocks.NAMAKO_SH_yellow) { return Items_Wablock.NAMAKO_SH_yellow; }
		if (this == JPBlock_Blocks.NAMAKO_SH_lime) { return Items_Wablock.NAMAKO_SH_lime; }
		if (this == JPBlock_Blocks.NAMAKO_SH_pink) { return Items_Wablock.NAMAKO_SH_pink; }
		if (this == JPBlock_Blocks.NAMAKO_SH_gray) { return Items_Wablock.NAMAKO_SH_gray; }
		if (this == JPBlock_Blocks.NAMAKO_SH_lightg) { return Items_Wablock.NAMAKO_SH_lightg; }
		if (this == JPBlock_Blocks.NAMAKO_SH_cyan) { return Items_Wablock.NAMAKO_SH_cyan; }
		if (this == JPBlock_Blocks.NAMAKO_SH_purple) { return Items_Wablock.NAMAKO_SH_purple; }
		if (this == JPBlock_Blocks.NAMAKO_SH_blue) { return Items_Wablock.NAMAKO_SH_blue; }
		if (this == JPBlock_Blocks.NAMAKO_SH_brown) { return Items_Wablock.NAMAKO_SH_brown; }
		if (this == JPBlock_Blocks.NAMAKO_SH_green) { return Items_Wablock.NAMAKO_SH_green; }
		if (this == JPBlock_Blocks.NAMAKO_SH_red) { return Items_Wablock.NAMAKO_SH_red; }
		if (this == JPBlock_Blocks.NAMAKO_SH_black) { return Items_Wablock.NAMAKO_SH_black; }
		return null;
	}
}
