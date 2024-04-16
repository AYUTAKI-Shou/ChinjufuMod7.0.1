package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.Pizza;
import com.ayutaki.chinjufumod.blocks.dish.Pizza_CTS;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PizzaCooked_Item extends Item {

	public PizzaCooked_Item(String name) {
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
			return "item." + "block_food_pizza_1";
		case 1:
			return "item." + "block_food_pizza_c1";
		case 2:
			return "item." + "block_food_pizza_t1";
		case 3:
			return "item." + "block_food_pizza_s1";
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

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		Block pizza = (k == 0)? Dish_Blocks.PIZZA : Dish_Blocks.PIZZA_CTS;
		
		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(pizza, pos, false, facing, (Entity)null)) {

			if (k == 0) { 
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA.getDefaultState().withProperty(Pizza.STAGE_1_6, Integer.valueOf(1)), 10); }

			if (k == 1) { 
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA_CTS.getDefaultState().withProperty(Pizza_CTS.STAGE_0_11, Integer.valueOf(0)), 10); }
			
			if (k == 2) { 
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA_CTS.getDefaultState().withProperty(Pizza_CTS.STAGE_0_11, Integer.valueOf(4)), 10); }
			
			if (k == 3) { 
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA_CTS.getDefaultState().withProperty(Pizza_CTS.STAGE_0_11, Integer.valueOf(8)), 10); }

			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_pizza_cheese.name", meta));
	}
}
