package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKumade extends Item {

	public ItemKumade(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.WADECO);

		this.maxStackSize = 1;
		setMaxDamage(128);
	}

	/* FlintAndSteel */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World iworld, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		IBlockState state = iworld.getBlockState(pos);
		ItemStack stack = playerIn.getHeldItem(hand);
		Block block = state.getBlock();
		
		if(!playerIn.getCooldownTracker().hasCooldown(this)) {
			
			if (state.getBlock() instanceof BlockSand && state.getValue(BlockSand.VARIANT) == BlockSand.EnumType.SAND) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.SAMON.getDefaultState().withProperty(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				stack.damageItem(1, playerIn);
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return EnumActionResult.SUCCESS; }
			
			if (state.getBlock() instanceof BlockGravel) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.SAMON_B.getDefaultState().withProperty(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				stack.damageItem(1, playerIn);
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return EnumActionResult.SUCCESS; }

			/** Samon **/
			if (block instanceof Samon) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlockState(pos, state.cycleProperty(Samon.STAGE_0_7), 3);
				
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return EnumActionResult.SUCCESS; }
		}
		
		return EnumActionResult.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.STICK);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_kumade.name", meta));
	}

}
