package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Base_Niwaishi;
import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneSlab;
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

public class ItemChisel extends Item {

	public ItemChisel(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.WADECO);

		this.maxStackSize = 1;
		setMaxDamage(256);
	}

	/* FlintAndSteel */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World iworld, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		IBlockState state = iworld.getBlockState(pos);
		ItemStack stack = playerIn.getHeldItem(hand);
		Block block = state.getBlock();
		
		if(!playerIn.getCooldownTracker().hasCooldown(this)) {
			/** Stone **/
			if (block instanceof BlockStone) {
				if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.STONE) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, Garden_Blocks.NIWAISHI.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }

				if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.GRANITE) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_gra.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }

				if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.DIORITE) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_dio.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }

				if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.ANDESITE) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_and.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }
			}

			/** Slab **/
			if (block instanceof BlockStoneSlab) {
				if (state.getValue(BlockStoneSlab.VARIANT) == BlockStoneSlab.EnumType.STONE) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }
			}
			
			if (block == WallBrick_Blocks.RGRA_slabhalf) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_gra.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				stack.damageItem(1, playerIn);
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return EnumActionResult.SUCCESS; }
			
			if (block == WallBrick_Blocks.RDIO_slabhalf) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_dio.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				stack.damageItem(1, playerIn);
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return EnumActionResult.SUCCESS; }
			
			if (block == WallBrick_Blocks.RAND_slabhalf) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_and.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				stack.damageItem(1, playerIn);
				playerIn.getCooldownTracker().setCooldown(this, 10);
				return EnumActionResult.SUCCESS; }
			
			
			/** Base_Niwaishi **/
			if (block instanceof Base_Niwaishi) {
				int i = state.getValue(Base_Niwaishi.STAGE_0_15).intValue();
				boolean mode = playerIn.capabilities.isCreativeMode;
				
				if (i <= 13) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlockState(pos, state.withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(i + 2)), 3);
					
					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }

				if (i == 14 || i == 15) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					if (!mode) { iworld.destroyBlock(pos, true); }
					if (mode) { iworld.destroyBlock(pos, false); }
				
					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }
			}
			
			
			/** oak **/
			if (block instanceof BlockOldLog) {
				BlockPlanks.EnumType type = state.getValue(BlockOldLog.VARIANT);
				BlockLog.EnumAxis axis = state.getValue(BlockLog.LOG_AXIS);
				
				if (type == BlockPlanks.EnumType.OAK && axis == BlockLog.EnumAxis.Y) {
					CMEvents.soundChiselWood(iworld, playerIn, pos);
					iworld.setBlockState(pos, Kitchen_Blocks.USU_TSUKI.getDefaultState().withProperty(UsuTsuki.STAGE_0_15, Integer.valueOf(0)), 3);

					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }
			}

			/** USU **/
			if (block instanceof UsuTsuki) {
				int i = state.getValue(UsuTsuki.STAGE_0_15).intValue();
		
				if (i <= 2) {
					CMEvents.soundChiselWood(iworld, playerIn, pos);
					iworld.setBlockState(pos, state.withProperty(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
					
					stack.damageItem(1, playerIn);
					playerIn.getCooldownTracker().setCooldown(this, 10);
					return EnumActionResult.SUCCESS; }
			}
		}

		return EnumActionResult.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_INGOT);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_chisel.name", meta));
	}
}
