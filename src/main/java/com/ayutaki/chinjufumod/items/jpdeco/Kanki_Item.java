package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.ranma.BaseRanma;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

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

public class Kanki_Item extends Item {

	public Kanki_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.WADECO);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		int k = stack.getMetadata();
		return (k <= 5)? -1 : 150;
	}
	
	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_ranmac_oak";
		case 1:
			return "item." + "block_ranmac_spru";
		case 2:
			return "item." + "block_ranmac_bir";
		case 3:
			return "item." + "block_ranmac_jun";
		case 4:
			return "item." + "block_ranmac_aca";
		case 5:
			return "item." + "block_ranmac_doak";
			
		case 6:
			return "item." + "block_kanki_oak";
		case 7:
			return "item." + "block_kanki_spru";
		case 8:
			return "item." + "block_kanki_bir";
		case 9:
			return "item." + "block_kanki_jun";
		case 10:
			return "item." + "block_kanki_aca";
		case 11:
			return "item." + "block_kanki_doak";
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

			worldIn.setBlockState(pos, this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseRanma.H_FACING, direction)
					.withProperty(BaseRanma.VER, Integer.valueOf(1)), 2);
			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (k == 0) { return JPDeco_Blocks.RANMAC_oak; }
		if (k == 1) { return JPDeco_Blocks.RANMAC_spru; }
		if (k == 2) { return JPDeco_Blocks.RANMAC_bir; }
		if (k == 3) { return JPDeco_Blocks.RANMAC_jun; }
		if (k == 4) { return JPDeco_Blocks.RANMAC_aca; }
		if (k == 5) { return JPDeco_Blocks.RANMAC_doak; }
		
		if (k == 6) { return JPDeco_Blocks.KANKI_oak; }
		if (k == 7) { return JPDeco_Blocks.KANKI_spru; }
		if (k == 8) { return JPDeco_Blocks.KANKI_bir; }
		if (k == 9) { return JPDeco_Blocks.KANKI_jun; }
		if (k == 10) { return JPDeco_Blocks.KANKI_aca; }
		if (k == 11) { return JPDeco_Blocks.KANKI_doak; }
		return null;
	}
	
	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		if (meta <= 5) { tooltip.add(I18n.format("tips.block_ranma.name", meta)); }
		tooltip.add(I18n.format("tips.wp_stage2.name", meta));
	}
}
