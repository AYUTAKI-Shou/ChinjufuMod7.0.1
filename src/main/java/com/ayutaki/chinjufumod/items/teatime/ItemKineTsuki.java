package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKineTsuki extends Item {

	public ItemKineTsuki(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		this.maxStackSize = 1;
		setMaxDamage(128);
	}

	/* FlintAndSteel */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World iworld, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		IBlockState state = iworld.getBlockState(pos);
		ItemStack stack = playerIn.getHeldItem(hand);
		Block block = state.getBlock();
		
		if(!playerIn.getCooldownTracker().hasCooldown(this)) {

			if (block instanceof UsuTsuki) {
				int i = state.getValue(UsuTsuki.STAGE_0_15).intValue();
				if (facing == EnumFacing.UP) {
					
					if (i >= 4 && i <= 14) {
						if (i >= 4 && i <= 6) { //volume, pitch
							iworld.playSound(playerIn, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F); }
			
						if (i >= 7 && i <= 14) {
							iworld.playSound(playerIn, pos, SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, SoundCategory.BLOCKS, 0.8F, 1.1F);
							iworld.playSound(playerIn, pos, SoundEvents.BLOCK_SLIME_STEP, SoundCategory.BLOCKS, 0.1F, 0.8F); }

						iworld.setBlockState(pos, Kitchen_Blocks.USU_TSUKI.getDefaultState().withProperty(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
						stack.damageItem(1, playerIn);
						playerIn.getCooldownTracker().setCooldown(this, 10); }
					
					else { }
				}
				
				if (facing != EnumFacing.UP) { iworld.playSound(playerIn, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.8F); }

				return EnumActionResult.SUCCESS;
			}
		}

		return EnumActionResult.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Item.getItemFromBlock(Blocks.LOG));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_usutsuki.name", meta));
	}
}
