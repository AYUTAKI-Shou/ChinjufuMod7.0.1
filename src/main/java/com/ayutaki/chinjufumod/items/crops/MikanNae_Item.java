package com.ayutaki.chinjufumod.items.crops;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Nae;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Top;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MikanNae_Item extends ItemBlockBace {

	public MikanNae_Item(String name) {
		super(name, Crop_Blocks.MIKAN);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		float temp = worldIn.getBiome(pos).getTemperature(pos);
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);

		if (temp >= 0.5F) {
			boolean canPlace = (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable());
			
			if (state.getBlock() instanceof BlockDirt && !stack.isEmpty() && canPlace) {
				worldIn.setBlockState(pos, Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(0)), 10);
				worldIn.setBlockState(pos.up(), Crop_Blocks.MIKAN_TOP.getDefaultState().withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(0)), 10);
	
				CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS;
			}
			
			else { return EnumActionResult.FAIL; }
		}
		
		else { 
			playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.too_cold.name", new Object[0]), true);
			return EnumActionResult.FAIL; }
	}


	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_wood_mikan.name", meta));
	}
}
