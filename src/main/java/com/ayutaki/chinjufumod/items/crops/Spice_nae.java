package com.ayutaki.chinjufumod.items.crops;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Pepper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockFarmland;
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
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Spice_nae extends Item {

	public Spice_nae(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "item_seeds_pepper";
		case 1:
			return "item." + "item_seeds_cumin";
		case 2:
			return "item." + "item_seeds_turmeric";
		case 3:
			return "item." + "item_seeds_chilipepper";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
		}
	}
	
	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		float temp = worldIn.getBiome(pos).getTemperature(pos);
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) {
			if (temp >= 0.5F) {
				boolean canPlace = (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable());
				
				if (state.getBlock() instanceof BlockDirt && !stack.isEmpty() && canPlace) {
					worldIn.setBlockState(pos, Crop_Blocks.PEPPER.getDefaultState().withProperty(Pepper.STAGE_0_15, Integer.valueOf(0)), 10);
					worldIn.setBlockState(pos.up(), Crop_Blocks.PEPPER.getDefaultState().withProperty(Pepper.STAGE_0_15, Integer.valueOf(8)), 10);

					CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
				
				else { return EnumActionResult.FAIL; }
			}
			
			else { 
				playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.too_cold.name", new Object[0]), true);
				return EnumActionResult.FAIL; }
		}
		
		if (k == 1) {
			if (temp <= 0.85F) {
				if (state.getBlock() instanceof BlockFarmland && !stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {

					worldIn.setBlockState(pos, Crop_Blocks.CUMIN.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);
					CMEvents.Consume_1Grass(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
				
				else { return EnumActionResult.FAIL; }
			}
			
			else { 
				playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.too_hot.name", new Object[0]), true);
				return EnumActionResult.FAIL; }
		}
		
		if (k == 2) {
			if (temp >= 0.5F) {
				if (state.getBlock() instanceof BlockFarmland && !stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {

					worldIn.setBlockState(pos, Crop_Blocks.TURMERIC.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);
					CMEvents.Consume_1Grass(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
				
				else { return EnumActionResult.FAIL; }
			}
			
			else { 
				playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.too_cold.name", new Object[0]), true);
				return EnumActionResult.FAIL; }
		}
		
		if (k == 3) {
			if (temp >= 0.5F) {
				if (state.getBlock() instanceof BlockFarmland && !stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {

					worldIn.setBlockState(pos, Crop_Blocks.CHILI.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);
					CMEvents.Consume_1Grass(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
				
				else { return EnumActionResult.FAIL; }
			}
			
			else { 
				playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.too_cold.name", new Object[0]), true);
				return EnumActionResult.FAIL; }
		}
		
		else { return EnumActionResult.FAIL; }
	}


	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		if (meta == 0) { tooltip.add(I18n.format("tips.item_seeds_pepper.name", meta)); }
		if (meta == 1) { 
			tooltip.add(I18n.format("tips.item_seeds_cumin.name", meta));
			tooltip.add(I18n.format("tips.item_crop_pepperdry.name", meta)); }
		if (meta == 2) { 
			tooltip.add(I18n.format("tips.item_seeds_turmeric.name", meta));
			tooltip.add(I18n.format("tips.item_crop_pepperdry.name", meta)); }
		if (meta == 3) { 
			tooltip.add(I18n.format("tips.item_seeds_turmeric.name", meta)); }
	}
}
