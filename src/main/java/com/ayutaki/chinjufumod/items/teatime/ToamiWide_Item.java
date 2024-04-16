package com.ayutaki.chinjufumod.items.teatime;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToamiWide_Item extends ItemBlock {

	public ToamiWide_Item(String name, Block putBlock) {
		super(putBlock);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		playerIn.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		if (!worldIn.isRemote) { playerIn.inventory.deleteStack(stack); }
		return ActionResult.newResult(EnumActionResult.PASS, stack);
	}
	
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getHeldItem(hand);
		playerIn.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		playerIn.inventory.deleteStack(stack);
		return EnumActionResult.PASS;
	}
}
