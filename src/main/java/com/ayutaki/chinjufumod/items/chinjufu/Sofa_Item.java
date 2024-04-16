package com.ayutaki.chinjufumod.items.chinjufu;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;

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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Sofa_Item extends Item {

	public Sofa_Item(String name) {
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
			return "item." + "block_sofa_white";
		case 1:
			return "item." + "block_sofa_orange";
		case 2:
			return "item." + "block_sofa_magenta";
		case 3:
			return "item." + "block_sofa_lightblue";
		case 4:
			return "item." + "block_sofa_yellow";
		case 5:
			return "item." + "block_sofa_lime";
		case 6:
			return "item." + "block_sofa_pink";
		case 7:
			return "item." + "block_sofa_gray";
		case 8:
			return "item." + "block_sofa_lightgray";
		case 9:
			return "item." + "block_sofa_cyan";
		case 10:
			return "item." + "block_sofa_purple";
		case 11:
			return "item." + "block_sofa_blue";
		case 12:
			return "item." + "block_sofa_brown";
		case 13:
			return "item." + "block_sofa_green";
		case 14:
			return "item." + "block_sofa_red";
		case 15:
			return "item." + "block_sofa_black";
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
			items.add(new ItemStack(this, 1, 9));
			items.add(new ItemStack(this, 1, 10));
			items.add(new ItemStack(this, 1, 11));
			items.add(new ItemStack(this, 1, 12));
			items.add(new ItemStack(this, 1, 13));
			items.add(new ItemStack(this, 1, 14));
			items.add(new ItemStack(this, 1, 15));
		}
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
		int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		EnumFacing direction = EnumFacing.getHorizontal(i);
		ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(this.takeBlock(playerIn, hand), pos, false, facing, (Entity)null)) {

			worldIn.setBlockState(pos, this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseFacingSapo.H_FACING, direction), 10);
			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (k == 0) { return Furniture_Blocks.SOFA_white; }
		if (k == 1) { return Furniture_Blocks.SOFA_orange; }
		if (k == 2) { return Furniture_Blocks.SOFA_magenta; }
		if (k == 3) { return Furniture_Blocks.SOFA_lightb; }
		if (k == 4) { return Furniture_Blocks.SOFA_yellow; }
		if (k == 5) { return Furniture_Blocks.SOFA_lime; }
		if (k == 6) { return Furniture_Blocks.SOFA_pink; }
		if (k == 7) { return Furniture_Blocks.SOFA_gray; }
		if (k == 8) { return Furniture_Blocks.SOFA_lightg; }
		if (k == 9) { return Furniture_Blocks.SOFA_cyan; }
		if (k == 10) { return Furniture_Blocks.SOFA_purple; }
		if (k == 11) { return Furniture_Blocks.SOFA_blue; }
		if (k == 12) { return Furniture_Blocks.SOFA_brown; }
		if (k == 13) { return Furniture_Blocks.SOFA_green; }
		if (k == 14) { return Furniture_Blocks.SOFA_red; }
		if (k == 15) { return Furniture_Blocks.SOFA_black; }
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