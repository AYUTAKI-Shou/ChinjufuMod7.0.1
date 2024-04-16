package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NabeCooked_Item extends ItemBlockBace {

	public NabeCooked_Item(String name, Block putBlock) {
		super(name, putBlock);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(this.block, pos, false, facing, (Entity)null)) {

			/** Put the Block. **/
			IBlockState state1 = this.block.getDefaultState()
					.withProperty(BaseNabe.H_FACING, direction)
					.withProperty(BaseNabe.STAGE_1_4, Integer.valueOf(1));
			worldIn.setBlockState(pos, state1, 10);

			CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
	
	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		if (this == Items_Teatime.NABEMISO) { tooltip.add(I18n.format("tips.block_food_nabemiso_1.name", meta)); }
		if (this == Items_Teatime.NABETORI) { tooltip.add(I18n.format("tips.block_food_nabe_1.name", meta)); }
		if (this == Items_Teatime.NABECORNSOUP) { tooltip.add(I18n.format("tips.block_food_nabecorns_1.name", meta)); }
		
		if (this == Items_Teatime.NABEGOHAN) { tooltip.add(I18n.format("tips.block_food_nabegohan_1.name", meta)); }
		if (this == Items_Teatime.NABEGOHAN_TAKE || this == Items_Teatime.NABEGOHAN_KURI) { 
			tooltip.add(I18n.format("tips.block_food_nabegohantake_1.name", meta)); }

		if (this == Items_Teatime.NABEAMAZAKE) { tooltip.add(I18n.format("tips.block_food_nabeaz_1.name", meta)); }
	}
}
