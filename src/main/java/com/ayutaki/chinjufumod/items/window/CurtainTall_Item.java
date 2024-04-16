package com.ayutaki.chinjufumod.items.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.window.CurtainTall;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CurtainTall_Item extends Item {

	public CurtainTall_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_curtaintall_white";
		case 1:
			return "item." + "block_curtaintall_orange";
		case 2:
			return "item." + "block_curtaintall_magenta";
		case 3:
			return "item." + "block_curtaintall_lightblue";
		case 4:
			return "item." + "block_curtaintall_yellow";
		case 5:
			return "item." + "block_curtaintall_lime";
		case 6:
			return "item." + "block_curtaintall_pink";
		case 7:
			return "item." + "block_curtaintall_gray";
		case 8:
			return "item." + "block_curtaintall_lightgray";
		case 9:
			return "item." + "block_curtaintall_cyan";
		case 10:
			return "item." + "block_curtaintall_purple";
		case 11:
			return "item." + "block_curtaintall_blue";
		case 12:
			return "item." + "block_curtaintall_brown";
		case 13:
			return "item." + "block_curtaintall_green";
		case 14:
			return "item." + "block_curtaintall_red";
		case 15:
			return "item." + "block_curtaintall_black";
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
	
	/* Call this when you use the item. ex) Place a block. */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (facing != EnumFacing.UP && facing != EnumFacing.DOWN) {
			
			IBlockState state = worldIn.getBlockState(pos);
			Block block = state.getBlock();
	
			if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }
	
			ItemStack stack = playerIn.getHeldItem(hand);
		
			IBlockState putState = this.takeBlock(playerIn, hand).getDefaultState().withProperty(CurtainTall.H_FACING, facing.getOpposite())
					.withProperty(CurtainTall.OPEN, Boolean.valueOf(false));
			
			/** Put "this.block". **/
			if (playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {
	
				if (playerIn.isSneaking()) {
					worldIn.setBlockState(pos, putState.withProperty(CurtainTall.HINGE, HingeState.RIGHT).withProperty(CurtainTall.HALF, HalfState.UPPER), 2);
					worldIn.setBlockState(pos.down(), putState.withProperty(CurtainTall.HINGE, HingeState.RIGHT).withProperty(CurtainTall.HALF, HalfState.LOWER), 2);
					CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
	
				/** デフォルトは left。右取手・左蝶番で開くのが hinge=left **/
				else {
					worldIn.setBlockState(pos, putState.withProperty(CurtainTall.HINGE, HingeState.LEFT).withProperty(CurtainTall.HALF, HalfState.UPPER), 2);
					worldIn.setBlockState(pos.down(), putState.withProperty(CurtainTall.HINGE, HingeState.LEFT).withProperty(CurtainTall.HALF, HalfState.LOWER), 2);
					CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
			}
			return EnumActionResult.FAIL;
		}
		else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Window_Blocks.CURTAINTALL_white; }
		if (k == 1) { return Window_Blocks.CURTAINTALL_orange; }
		if (k == 2) { return Window_Blocks.CURTAINTALL_magenta; }
		if (k == 3) { return Window_Blocks.CURTAINTALL_lightblue; }
		if (k == 4) { return Window_Blocks.CURTAINTALL_yellow; }
		if (k == 5) { return Window_Blocks.CURTAINTALL_lime; }
		if (k == 6) { return Window_Blocks.CURTAINTALL_pink; }
		if (k == 7) { return Window_Blocks.CURTAINTALL_gray; }
		if (k == 8) { return Window_Blocks.CURTAINTALL_lightgray; }
		if (k == 9) { return Window_Blocks.CURTAINTALL_cyan; }
		if (k == 10) { return Window_Blocks.CURTAINTALL_purple; }
		if (k == 11) { return Window_Blocks.CURTAINTALL_blue; }
		if (k == 12) { return Window_Blocks.CURTAINTALL_brown; }
		if (k == 13) { return Window_Blocks.CURTAINTALL_green; }
		if (k == 14) { return Window_Blocks.CURTAINTALL_red; }
		if (k == 15) { return Window_Blocks.CURTAINTALL_black; }
		return null;
	}
	
	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_window.name", meta));
	}
}
