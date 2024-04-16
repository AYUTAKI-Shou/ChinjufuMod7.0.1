package com.ayutaki.chinjufumod.items.seasonal;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Top;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Top;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class S_Kanyou_Item extends ItemBlockBace {

	public S_Kanyou_Item(String name) {
		super(name, Garden_Blocks.KANYOU_BOT);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_kanyousakura_bot";
		case 1:
			return "item." + "block_kanyoukaede_bot";
		case 2:
			return "item." + "block_kanyouichoh_bot";
		case 3:
			return "item." + "block_kanyouoakkare_bot";
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

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (!playerIn.isSneaking() && !stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Garden_Blocks.KANYOU_BOT, pos, false, facing, (Entity)null)) {
	
			IBlockState state1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(k + 6));
			IBlockState state2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(k + 6));
			worldIn.setBlockState(pos, state1);
			worldIn.setBlockState(pos.up(), state2);

			CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}
		
		if (playerIn.isSneaking() && !stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Garden_Blocks.KANYOU2_BOT, pos, false, facing, (Entity)null)) {
	
			IBlockState state1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(k + 6));
			IBlockState state2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(k + 6));
			worldIn.setBlockState(pos, state1);
			worldIn.setBlockState(pos.up(), state2);
			
			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}
		
		else { return EnumActionResult.FAIL; }
	}

	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kanyou.name", meta));
	}
}
