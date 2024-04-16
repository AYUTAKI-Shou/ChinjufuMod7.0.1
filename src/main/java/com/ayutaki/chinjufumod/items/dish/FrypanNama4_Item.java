package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.dish.Teppan_Stage4;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.kitchen.Base_Cooktop;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;

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

public class FrypanNama4_Item extends Item {

	public FrypanNama4_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.TEATIME);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "block_food_frypan_n_osauce";
		case 2:
			return "item." + "block_food_teppan_n_okonomiyaki";
		case 3:
			return "item." + "block_food_teppan_n_okonomis";
		case 4:
			return "item." + "block_food_teppan_n_okonomic";
		case 5:
			return "item." + "block_food_teppan_n_okonomisoba";
		case 6:
			return "item." + "block_food_teppan_n_okonomisobas";
		case 7:
			return "item." + "block_food_teppan_n_okonomisobac";
		case 8:
			return "item." + "block_food_teppan_n_yakisoba";
		case 9:
			return "item." + "block_food_teppan_n_yakisobashio";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
			items.add(new ItemStack(this, 1, 9));
		}
	}

	/* Call this when you use the item. ex) Place a block. */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
		int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		EnumFacing direction = EnumFacing.getHorizontal(i);
		
		if (k == 1 && playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {
			worldIn.setBlockState(pos, this.takeBlock(playerIn, hand).getDefaultState()
					.withProperty(BaseStage4_Face.H_FACING, direction)
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 2);
			CMEvents.Consume_1Metal(worldIn, pos, playerIn, hand);
			
			return EnumActionResult.SUCCESS; }

		
		IBlockState downState = worldIn.getBlockState(pos.down());
		Block downBlock = downState.getBlock();
		boolean teppan = (downBlock instanceof Kitchen_Oven || downBlock instanceof Kitchen_Oven_B || downBlock instanceof Base_Cooktop);
		
		if (k != 1 && playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {
			worldIn.setBlockState(pos, this.takeBlock(playerIn, hand).getDefaultState()
					.withProperty(Teppan_Stage4.H_FACING, direction)
					.withProperty(Teppan_Stage4.STAGE_1_4, Integer.valueOf(1))
					.withProperty(Teppan_Stage4.DOWN, Boolean.valueOf(teppan)), 2);
			CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
			
			return EnumActionResult.SUCCESS; }
		
		else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (k == 1) { return Dish_Blocks.FPOSAUCE_nama; }
		if (k == 2) { return Dish_Blocks.OKONOMIYAKI_nama; }
		if (k == 3) { return Dish_Blocks.OKONOMIS_nama; }
		if (k == 4) { return Dish_Blocks.OKONOMIC_nama; }
		if (k == 5) { return Dish_Blocks.OKONOMISOBA_nama; }
		if (k == 6) { return Dish_Blocks.OKONOMISOBAS_nama; }
		if (k == 7) { return Dish_Blocks.OKONOMISOBAC_nama; }
		if (k == 8) { return Dish_Blocks.YAKISOBA_nama; }
		if (k == 9) { return Dish_Blocks.YAKISOBASHIO_nama; }
		return null;
	}
	
	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int k = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_frypan.name"));
		if (k == 1) { tooltip.add(I18n.format("tips.block_food_frypan_osauce.name")); }
		if (k != 1) { tooltip.add(I18n.format("tips.block_food_frypan_sara.name")); } 
	}
}
