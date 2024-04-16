package com.ayutaki.chinjufumod.items.chinjufu;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DiningChair_Item extends Item {

	public DiningChair_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 150;
	}
	
	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_diningchair";
		case 1:
			return "item." + "block_diningchair_s";
		case 2:
			return "item." + "block_diningchair_b";
		case 3:
			return "item." + "block_diningchair_j";
		case 4:
			return "item." + "block_diningchair_a";
		case 5:
			return "item." + "block_diningchair_d";
		case 6:
			return "item." + "block_diningchair_saku";
		case 7:
			return "item." + "block_diningchair_kae";
		case 8:
			return "item." + "block_diningchair_ich";
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
		}
	}
	
	/* Call this when you use the item. ex) Place a block. */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (facing != EnumFacing.UP) { return EnumActionResult.FAIL; }

		else {
			IBlockState state = worldIn.getBlockState(pos);
			Block block = state.getBlock();

			if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack stack = playerIn.getHeldItem(hand);
			IBlockState putState = this.takeBlock(playerIn, hand).getDefaultState().withProperty(DiningChair.H_FACING, direction);
			
			/** Put "this.block". **/
			if (playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {
				
				worldIn.setBlockState(pos, putState.withProperty(DiningChair.HALF, DiningChair.Half.LOWER), 2);
				worldIn.setBlockState(pos.up(), putState.withProperty(DiningChair.HALF, DiningChair.Half.UPPER), 2);
				
				CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS;
			}

			else { return EnumActionResult.FAIL; }
		}
	}
	
	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Furniture_Blocks.DININGCHAIR; }
		if (k == 1) { return Furniture_Blocks.DININGCHAIR_s; }
		if (k == 2) { return Furniture_Blocks.DININGCHAIR_b; }
		if (k == 3) { return Furniture_Blocks.DININGCHAIR_j; }
		if (k == 4) { return Furniture_Blocks.DININGCHAIR_a; }
		if (k == 5) { return Furniture_Blocks.DININGCHAIR_d; }
		if (k == 6) { return Furniture_Blocks.DININGCHAIR_saku; }
		if (k == 7) { return Furniture_Blocks.DININGCHAIR_kae; }
		if (k == 8) { return Furniture_Blocks.DININGCHAIR_ich; }
		return null;
	}
	
	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_isu.name", meta));
	}
}
