package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tobukuro_Item extends Item {

	public Tobukuro_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.WADECO);
	}
	
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 150;
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

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(takeRight(), pos, false, facing, (Entity)null)) {

			if (playerIn.isSneaking()) {
				worldIn.setBlockState(pos, takeLeft().getDefaultState().withProperty(BaseStage3_Face.H_FACING, direction)
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)), 10);
				worldIn.setBlockState(pos.up(), takeLeftTop().getDefaultState().withProperty(BaseStage3_Face.H_FACING, direction)
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)), 10); }

			else { worldIn.setBlockState(pos, takeRight().getDefaultState().withProperty(BaseStage3_Face.H_FACING, direction)
					.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)), 10);
					worldIn.setBlockState(pos.up(), takeRightTop().getDefaultState().withProperty(BaseStage3_Face.H_FACING, direction)
							.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)), 10); }

			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
	
	private Block takeRight() {
		if (this == Items_Wadeco.TOBUKURO_BOTR) { return Slidedoor_Blocks.TOBUKURO_BOTR; }
		if (this == Items_Wadeco.TOBUKUROS_BOTR) { return Slidedoor_Blocks.TOBUKUROS_BOTR; }
		return null;
	}
	
	private Block takeRightTop() {
		if (this == Items_Wadeco.TOBUKURO_BOTR) { return Slidedoor_Blocks.TOBUKURO_TOPR; }
		if (this == Items_Wadeco.TOBUKUROS_BOTR) { return Slidedoor_Blocks.TOBUKUROS_TOPR; }
		return null;
	}
	
	private Block takeLeft() {
		if (this == Items_Wadeco.TOBUKURO_BOTR) { return Slidedoor_Blocks.TOBUKURO_BOTL; }
		if (this == Items_Wadeco.TOBUKUROS_BOTR) { return Slidedoor_Blocks.TOBUKUROS_BOTL; }
		return null;
	}
	
	private Block takeLeftTop() {
		if (this == Items_Wadeco.TOBUKURO_BOTR) { return Slidedoor_Blocks.TOBUKURO_TOPL; }
		if (this == Items_Wadeco.TOBUKUROS_BOTR) { return Slidedoor_Blocks.TOBUKUROS_TOPL; }
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_tobukuro.name", meta));
	}
}
