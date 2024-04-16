package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Tatami extends BaseTatami {
//16色、2方角、9木材

	public Tatami(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		EnumFacing direction = state.getValue(H_FACING);
		
		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == JPDeco_Blocks.TATAMI && item == Items_Wadeco.TATAMI) ||
					(this == JPDeco_Blocks.TATAMI_white && item == Items_Wadeco.TATAMI_white) ||
					(this == JPDeco_Blocks.TATAMI_orange && item == Items_Wadeco.TATAMI_orange) ||
					(this == JPDeco_Blocks.TATAMI_magenta && item == Items_Wadeco.TATAMI_magenta) ||
					(this == JPDeco_Blocks.TATAMI_yellow && item == Items_Wadeco.TATAMI_yellow) ||
					(this == JPDeco_Blocks.TATAMI_lime && item == Items_Wadeco.TATAMI_lime) ||
					(this == JPDeco_Blocks.TATAMI_pink && item == Items_Wadeco.TATAMI_pink) ||
					(this == JPDeco_Blocks.TATAMI_gray && item == Items_Wadeco.TATAMI_gray) ||
					(this == JPDeco_Blocks.TATAMI_lightb && item == Items_Wadeco.TATAMI_lightb) ||
					(this == JPDeco_Blocks.TATAMI_lightg && item == Items_Wadeco.TATAMI_lightg) ||
					(this == JPDeco_Blocks.TATAMI_cyan && item == Items_Wadeco.TATAMI_cyan) ||
					(this == JPDeco_Blocks.TATAMI_purple && item == Items_Wadeco.TATAMI_purple) ||
					(this == JPDeco_Blocks.TATAMI_blue && item == Items_Wadeco.TATAMI_blue) ||
					(this == JPDeco_Blocks.TATAMI_brown && item == Items_Wadeco.TATAMI_brown) ||
					(this == JPDeco_Blocks.TATAMI_green && item == Items_Wadeco.TATAMI_green) ||
					(this == JPDeco_Blocks.TATAMI_red && item == Items_Wadeco.TATAMI_red) ||
					(this == JPDeco_Blocks.TATAMI_black && item == Items_Wadeco.TATAMI_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == JPDeco_Blocks.TATAMI && item == Items_Wadeco.TATAMI) ||
					(this == JPDeco_Blocks.TATAMI_white && item == Items_Wadeco.TATAMI_white) ||
					(this == JPDeco_Blocks.TATAMI_orange && item == Items_Wadeco.TATAMI_orange) ||
					(this == JPDeco_Blocks.TATAMI_magenta && item == Items_Wadeco.TATAMI_magenta) ||
					(this == JPDeco_Blocks.TATAMI_yellow && item == Items_Wadeco.TATAMI_yellow) ||
					(this == JPDeco_Blocks.TATAMI_lime && item == Items_Wadeco.TATAMI_lime) ||
					(this == JPDeco_Blocks.TATAMI_pink && item == Items_Wadeco.TATAMI_pink) ||
					(this == JPDeco_Blocks.TATAMI_gray && item == Items_Wadeco.TATAMI_gray) ||
					(this == JPDeco_Blocks.TATAMI_lightb && item == Items_Wadeco.TATAMI_lightb) ||
					(this == JPDeco_Blocks.TATAMI_lightg && item == Items_Wadeco.TATAMI_lightg) ||
					(this == JPDeco_Blocks.TATAMI_cyan && item == Items_Wadeco.TATAMI_cyan) ||
					(this == JPDeco_Blocks.TATAMI_purple && item == Items_Wadeco.TATAMI_purple) ||
					(this == JPDeco_Blocks.TATAMI_blue && item == Items_Wadeco.TATAMI_blue) ||
					(this == JPDeco_Blocks.TATAMI_brown && item == Items_Wadeco.TATAMI_brown) ||
					(this == JPDeco_Blocks.TATAMI_green && item == Items_Wadeco.TATAMI_green) ||
					(this == JPDeco_Blocks.TATAMI_red && item == Items_Wadeco.TATAMI_red) ||
					(this == JPDeco_Blocks.TATAMI_black && item == Items_Wadeco.TATAMI_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; } // tatami
			
			if (item == new ItemStack(Blocks.WOODEN_SLAB).getItem()) {
				int k;
				k = stack.getMetadata();
				
				if (k == 0) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundWoodPlace(worldIn, pos);
					if (this == JPDeco_Blocks.TATAMI) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 0));
							break;
					} } // less
					
					if (this == JPDeco_Blocks.TATAMI_white) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
					} } // white

					if (this == JPDeco_Blocks.TATAMI_orange) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
					} } // orange
					
					if (this == JPDeco_Blocks.TATAMI_magenta) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
					} } // magenta
					
					if (this == JPDeco_Blocks.TATAMI_lightb) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
					} } // lightb
					
					if (this == JPDeco_Blocks.TATAMI_yellow) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
					} } // yellow
					
					if (this == JPDeco_Blocks.TATAMI_lime) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
					} } // lime
					
					if (this == JPDeco_Blocks.TATAMI_pink) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
					} } // pink
					
					if (this == JPDeco_Blocks.TATAMI_gray) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
					} } // gray
					
					if (this == JPDeco_Blocks.TATAMI_lightg) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
					} } // lightg
					
					if (this == JPDeco_Blocks.TATAMI_cyan) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
					} } // cyan
					
					if (this == JPDeco_Blocks.TATAMI_purple) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
					} } // purple
					
					if (this == JPDeco_Blocks.TATAMI_blue) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
					} } // blue
					
					if (this == JPDeco_Blocks.TATAMI_brown) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
					} } // brown
					
					if (this == JPDeco_Blocks.TATAMI_green) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
					} } // green
					
					if (this == JPDeco_Blocks.TATAMI_red) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
					} } // red
					
					if (this == JPDeco_Blocks.TATAMI_black) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_OAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
					} } // black
				return true; } // oak
				
				
				if (k == 1) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundWoodPlace(worldIn, pos);
					if (this == JPDeco_Blocks.TATAMI) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 1));
							break;
					} } // less
					
					if (this == JPDeco_Blocks.TATAMI_white) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
					} } // white

					if (this == JPDeco_Blocks.TATAMI_orange) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
					} } // orange
					
					if (this == JPDeco_Blocks.TATAMI_magenta) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
					} } // magenta
					
					if (this == JPDeco_Blocks.TATAMI_lightb) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
					} } // lightb
					
					if (this == JPDeco_Blocks.TATAMI_yellow) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
					} } // yellow
					
					if (this == JPDeco_Blocks.TATAMI_lime) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
					} } // lime
					
					if (this == JPDeco_Blocks.TATAMI_pink) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
					} } // pink
					
					if (this == JPDeco_Blocks.TATAMI_gray) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
					} } // gray
					
					if (this == JPDeco_Blocks.TATAMI_lightg) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
					} } // lightg
					
					if (this == JPDeco_Blocks.TATAMI_cyan) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
					} } // cyan
					
					if (this == JPDeco_Blocks.TATAMI_purple) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
					} } // purple
					
					if (this == JPDeco_Blocks.TATAMI_blue) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
					} } // blue
					
					if (this == JPDeco_Blocks.TATAMI_brown) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
					} } // brown
					
					if (this == JPDeco_Blocks.TATAMI_green) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
					} } // green
					
					if (this == JPDeco_Blocks.TATAMI_red) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
					} } // red
					
					if (this == JPDeco_Blocks.TATAMI_black) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SPRUCE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
					} } // black
				return true; } // spruce
				
				
				if (k == 2) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundWoodPlace(worldIn, pos);
					if (this == JPDeco_Blocks.TATAMI) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 2));
							break;
					} } // less
					
					if (this == JPDeco_Blocks.TATAMI_white) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
					} } // white

					if (this == JPDeco_Blocks.TATAMI_orange) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
					} } // orange
					
					if (this == JPDeco_Blocks.TATAMI_magenta) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
					} } // magenta
					
					if (this == JPDeco_Blocks.TATAMI_lightb) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
					} } // lightb
					
					if (this == JPDeco_Blocks.TATAMI_yellow) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
					} } // yellow
					
					if (this == JPDeco_Blocks.TATAMI_lime) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
					} } // lime
					
					if (this == JPDeco_Blocks.TATAMI_pink) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
					} } // pink
					
					if (this == JPDeco_Blocks.TATAMI_gray) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
					} } // gray
					
					if (this == JPDeco_Blocks.TATAMI_lightg) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
					} } // lightg
					
					if (this == JPDeco_Blocks.TATAMI_cyan) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
					} } // cyan
					
					if (this == JPDeco_Blocks.TATAMI_purple) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
					} } // purple
					
					if (this == JPDeco_Blocks.TATAMI_blue) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
					} } // blue
					
					if (this == JPDeco_Blocks.TATAMI_brown) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
					} } // brown
					
					if (this == JPDeco_Blocks.TATAMI_green) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
					} } // green
					
					if (this == JPDeco_Blocks.TATAMI_red) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
					} } // red
					
					if (this == JPDeco_Blocks.TATAMI_black) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_BIRCH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
					} } // black
				return true; } // birch
				
				
				if (k == 3) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundWoodPlace(worldIn, pos);
					if (this == JPDeco_Blocks.TATAMI) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 3));
							break;
					} } // less
					
					if (this == JPDeco_Blocks.TATAMI_white) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
					} } // white

					if (this == JPDeco_Blocks.TATAMI_orange) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
					} } // orange
					
					if (this == JPDeco_Blocks.TATAMI_magenta) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
					} } // magenta
					
					if (this == JPDeco_Blocks.TATAMI_lightb) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
					} } // lightb
					
					if (this == JPDeco_Blocks.TATAMI_yellow) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
					} } // yellow
					
					if (this == JPDeco_Blocks.TATAMI_lime) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
					} } // lime
					
					if (this == JPDeco_Blocks.TATAMI_pink) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
					} } // pink
					
					if (this == JPDeco_Blocks.TATAMI_gray) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
					} } // gray
					
					if (this == JPDeco_Blocks.TATAMI_lightg) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
					} } // lightg
					
					if (this == JPDeco_Blocks.TATAMI_cyan) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
					} } // cyan
					
					if (this == JPDeco_Blocks.TATAMI_purple) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
					} } // purple
					
					if (this == JPDeco_Blocks.TATAMI_blue) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
					} } // blue
					
					if (this == JPDeco_Blocks.TATAMI_brown) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
					} } // brown
					
					if (this == JPDeco_Blocks.TATAMI_green) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
					} } // green
					
					if (this == JPDeco_Blocks.TATAMI_red) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
					} } // red
					
					if (this == JPDeco_Blocks.TATAMI_black) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_JUNGLE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
					} } // black
				return true; } // jungle
				
				
				if (k == 4) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundWoodPlace(worldIn, pos);
					if (this == JPDeco_Blocks.TATAMI) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 4));
							break;
					} } // less
					
					if (this == JPDeco_Blocks.TATAMI_white) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
					} } // white

					if (this == JPDeco_Blocks.TATAMI_orange) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
					} } // orange
					
					if (this == JPDeco_Blocks.TATAMI_magenta) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
					} } // magenta
					
					if (this == JPDeco_Blocks.TATAMI_lightb) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
					} } // lightb
					
					if (this == JPDeco_Blocks.TATAMI_yellow) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
					} } // yellow
					
					if (this == JPDeco_Blocks.TATAMI_lime) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
					} } // lime
					
					if (this == JPDeco_Blocks.TATAMI_pink) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
					} } // pink
					
					if (this == JPDeco_Blocks.TATAMI_gray) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
					} } // gray
					
					if (this == JPDeco_Blocks.TATAMI_lightg) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
					} } // lightg
					
					if (this == JPDeco_Blocks.TATAMI_cyan) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
					} } // cyan
					
					if (this == JPDeco_Blocks.TATAMI_purple) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
					} } // purple
					
					if (this == JPDeco_Blocks.TATAMI_blue) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
					} } // blue
					
					if (this == JPDeco_Blocks.TATAMI_brown) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
					} } // brown
					
					if (this == JPDeco_Blocks.TATAMI_green) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
					} } // green
					
					if (this == JPDeco_Blocks.TATAMI_red) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
					} } // red
					
					if (this == JPDeco_Blocks.TATAMI_black) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ACACIA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
					} } // black
				return true; } // acacia
				
				
				if (k == 5) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundWoodPlace(worldIn, pos);
					if (this == JPDeco_Blocks.TATAMI) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 5));
							break;
					} } // less
					
					if (this == JPDeco_Blocks.TATAMI_white) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
							break;
					} } // white

					if (this == JPDeco_Blocks.TATAMI_orange) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
							break;
					} } // orange
					
					if (this == JPDeco_Blocks.TATAMI_magenta) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
							break;
					} } // magenta
					
					if (this == JPDeco_Blocks.TATAMI_lightb) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
							break;
					} } // lightb
					
					if (this == JPDeco_Blocks.TATAMI_yellow) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
							break;
					} } // yellow
					
					if (this == JPDeco_Blocks.TATAMI_lime) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
							break;
					} } // lime
					
					if (this == JPDeco_Blocks.TATAMI_pink) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
							break;
					} } // pink
					
					if (this == JPDeco_Blocks.TATAMI_gray) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
							break;
					} } // gray
					
					if (this == JPDeco_Blocks.TATAMI_lightg) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
							break;
					} } // lightg
					
					if (this == JPDeco_Blocks.TATAMI_cyan) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
							break;
					} } // cyan
					
					if (this == JPDeco_Blocks.TATAMI_purple) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
							break;
					} } // purple
					
					if (this == JPDeco_Blocks.TATAMI_blue) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
							break;
					} } // blue
					
					if (this == JPDeco_Blocks.TATAMI_brown) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
							break;
					} } // brown
					
					if (this == JPDeco_Blocks.TATAMI_green) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
							break;
					} } // green
					
					if (this == JPDeco_Blocks.TATAMI_red) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
							break;
					} } // red
					
					if (this == JPDeco_Blocks.TATAMI_black) {
						switch (direction) {
						case NORTH :
						default :
						case SOUTH :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
						case EAST :
						case WEST :
							worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_DOAK_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
							break;
					} } // black
				return true; } // darkoak
			} // wooden slab
			
			if (item == Items_Seasonal.SAKURA_slabhalf) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				if (this == JPDeco_Blocks.TATAMI) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 6));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 6));
						break;
				} } // less
				
				if (this == JPDeco_Blocks.TATAMI_white) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
						break;
				} } // white

				if (this == JPDeco_Blocks.TATAMI_orange) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
						break;
				} } // orange
				
				if (this == JPDeco_Blocks.TATAMI_magenta) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
						break;
				} } // magenta
				
				if (this == JPDeco_Blocks.TATAMI_lightb) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
						break;
				} } // lightb
				
				if (this == JPDeco_Blocks.TATAMI_yellow) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
						break;
				} } // yellow
				
				if (this == JPDeco_Blocks.TATAMI_lime) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
						break;
				} } // lime
				
				if (this == JPDeco_Blocks.TATAMI_pink) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
						break;
				} } // pink
				
				if (this == JPDeco_Blocks.TATAMI_gray) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
						break;
				} } // gray
				
				if (this == JPDeco_Blocks.TATAMI_lightg) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
						break;
				} } // lightg
				
				if (this == JPDeco_Blocks.TATAMI_cyan) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
						break;
				} } // cyan
				
				if (this == JPDeco_Blocks.TATAMI_purple) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
						break;
				} } // purple
				
				if (this == JPDeco_Blocks.TATAMI_blue) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
						break;
				} } // blue
				
				if (this == JPDeco_Blocks.TATAMI_brown) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
						break;
				} } // brown
				
				if (this == JPDeco_Blocks.TATAMI_green) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
						break;
				} } // green
				
				if (this == JPDeco_Blocks.TATAMI_red) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
						break;
				} } // red
				
				if (this == JPDeco_Blocks.TATAMI_black) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_SAKURA_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
						break;
				} } // black
			return true; } // sakura
			
			
			if (item == Items_Seasonal.KAEDE_slabhalf) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				if (this == JPDeco_Blocks.TATAMI) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 7));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 7));
						break;
				} } // less
				
				if (this == JPDeco_Blocks.TATAMI_white) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
						break;
				} } // white

				if (this == JPDeco_Blocks.TATAMI_orange) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
						break;
				} } // orange
				
				if (this == JPDeco_Blocks.TATAMI_magenta) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
						break;
				} } // magenta
				
				if (this == JPDeco_Blocks.TATAMI_lightb) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
						break;
				} } // lightb
				
				if (this == JPDeco_Blocks.TATAMI_yellow) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
						break;
				} } // yellow
				
				if (this == JPDeco_Blocks.TATAMI_lime) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
						break;
				} } // lime
				
				if (this == JPDeco_Blocks.TATAMI_pink) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
						break;
				} } // pink
				
				if (this == JPDeco_Blocks.TATAMI_gray) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
						break;
				} } // gray
				
				if (this == JPDeco_Blocks.TATAMI_lightg) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
						break;
				} } // lightg
				
				if (this == JPDeco_Blocks.TATAMI_cyan) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
						break;
				} } // cyan
				
				if (this == JPDeco_Blocks.TATAMI_purple) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
						break;
				} } // purple
				
				if (this == JPDeco_Blocks.TATAMI_blue) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
						break;
				} } // blue
				
				if (this == JPDeco_Blocks.TATAMI_brown) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
						break;
				} } // brown
				
				if (this == JPDeco_Blocks.TATAMI_green) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
						break;
				} } // green
				
				if (this == JPDeco_Blocks.TATAMI_red) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
						break;
				} } // red
				
				if (this == JPDeco_Blocks.TATAMI_black) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_KAEDE_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
						break;
				} } // black
			return true; } // kaede
			
			
			if (item == Items_Seasonal.ICHOH_slabhalf) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				if (this == JPDeco_Blocks.TATAMI) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ns.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 8));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_WOOD_ew.getDefaultState().withProperty(TatamiWood.STAGE_0_8, 8));
						break;
				} } // less
				
				if (this == JPDeco_Blocks.TATAMI_white) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 0));
						break;
				} } // white

				if (this == JPDeco_Blocks.TATAMI_orange) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 1));
						break;
				} } // orange
				
				if (this == JPDeco_Blocks.TATAMI_magenta) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 2));
						break;
				} } // magenta
				
				if (this == JPDeco_Blocks.TATAMI_lightb) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 3));
						break;
				} } // lightb
				
				if (this == JPDeco_Blocks.TATAMI_yellow) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 4));
						break;
				} } // yellow
				
				if (this == JPDeco_Blocks.TATAMI_lime) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 5));
						break;
				} } // lime
				
				if (this == JPDeco_Blocks.TATAMI_pink) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 6));
						break;
				} } // pink
				
				if (this == JPDeco_Blocks.TATAMI_gray) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 7));
						break;
				} } // gray
				
				if (this == JPDeco_Blocks.TATAMI_lightg) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 8));
						break;
				} } // lightg
				
				if (this == JPDeco_Blocks.TATAMI_cyan) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 9));
						break;
				} } // cyan
				
				if (this == JPDeco_Blocks.TATAMI_purple) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 10));
						break;
				} } // purple
				
				if (this == JPDeco_Blocks.TATAMI_blue) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 11));
						break;
				} } // blue
				
				if (this == JPDeco_Blocks.TATAMI_brown) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 12));
						break;
				} } // brown
				
				if (this == JPDeco_Blocks.TATAMI_green) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 13));
						break;
				} } // green
				
				if (this == JPDeco_Blocks.TATAMI_red) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 14));
						break;
				} } // red
				
				if (this == JPDeco_Blocks.TATAMI_black) {
					switch (direction) {
					case NORTH :
					default :
					case SOUTH :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ns.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
						break;
					case EAST :
					case WEST :
						worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_ICHOH_ew.getDefaultState().withProperty(BaseTatamiWood.STAGE_0_15, 15));
						break;
				} } // black
			return true; } // ichoh
		}

		/** 側面で設置可能にするため false **/
		return false;
	}

	/*Drop Item and Clone Item.*/
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
		if (this == JPDeco_Blocks.TATAMI) { return Items_Wadeco.TATAMI; }
		if (this == JPDeco_Blocks.TATAMI_white) { return Items_Wadeco.TATAMI_white; }
		if (this == JPDeco_Blocks.TATAMI_orange) { return Items_Wadeco.TATAMI_orange; }
		if (this == JPDeco_Blocks.TATAMI_magenta) { return Items_Wadeco.TATAMI_magenta; }
		if (this == JPDeco_Blocks.TATAMI_lightb) { return Items_Wadeco.TATAMI_lightb; }
		if (this == JPDeco_Blocks.TATAMI_yellow) { return Items_Wadeco.TATAMI_yellow; }
		if (this == JPDeco_Blocks.TATAMI_lime) { return Items_Wadeco.TATAMI_lime; }
		if (this == JPDeco_Blocks.TATAMI_pink) { return Items_Wadeco.TATAMI_pink; }
		if (this == JPDeco_Blocks.TATAMI_gray) { return Items_Wadeco.TATAMI_gray; }
		if (this == JPDeco_Blocks.TATAMI_lightg) { return Items_Wadeco.TATAMI_lightg; }
		if (this == JPDeco_Blocks.TATAMI_cyan) { return Items_Wadeco.TATAMI_cyan; }
		if (this == JPDeco_Blocks.TATAMI_purple) { return Items_Wadeco.TATAMI_purple; }
		if (this == JPDeco_Blocks.TATAMI_blue) { return Items_Wadeco.TATAMI_blue; }
		if (this == JPDeco_Blocks.TATAMI_brown) { return Items_Wadeco.TATAMI_brown; }
		if (this == JPDeco_Blocks.TATAMI_green) { return Items_Wadeco.TATAMI_green; }
		if (this == JPDeco_Blocks.TATAMI_red) { return Items_Wadeco.TATAMI_red; }
		if (this == JPDeco_Blocks.TATAMI_black) { return Items_Wadeco.TATAMI_black; }
		return null;
	}
}
