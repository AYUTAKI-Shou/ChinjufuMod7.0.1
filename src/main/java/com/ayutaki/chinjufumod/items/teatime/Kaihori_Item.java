package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.blocks.crop.Hamaguri;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* FlintAndSteelItem 参照*/
public class Kaihori_Item extends Item {

	public Kaihori_Item(Item.Properties properties) {
		super(properties.group(ItemGroups_CM.TEATIME));
	}

	/* FlintAndSteel */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = worldIn.getBlockState(pos);
		ItemStack stack = context.getItem();
		Biome biome = worldIn.getBiome(pos);
		
		BlockState upState = worldIn.getBlockState(pos.up());
		boolean water = (upState.getMaterial() == Material.WATER)? true : false;
		
		if (state.getBlock() == Blocks.SAND || state.getBlock() == Crop_Blocks.KAINASHI) {
			worldIn.playSound(null, pos, SoundEvents.BLOCK_SAND_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F);
			
			if (state.getBlock() == Blocks.SAND && upState.getMaterial().isReplaceable()) {
				
				if (biome == Biomes.BEACH && hasWater(worldIn, pos)) {
					if (worldIn.rand.nextInt(4) == 0) {
						worldIn.setBlockState(pos.up(), Crop_Blocks.HAMAGURI.getDefaultState().with(Hamaguri.WATERLOGGED, water), 3); }
				} //Biomes.BEACH && hasWater
				
				if (biome != Biomes.BEACH || !hasWater(worldIn, pos)) { CMEvents.textNotDig(playerIn); }				
			} //isReplaceable()

			if (state.getBlock() != Blocks.SAND || !upState.getMaterial().isReplaceable()) { CMEvents.textNotDig(playerIn); }
			
			/* Break animation. */
			stack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
			return ActionResultType.SUCCESS;
		}
		
		else { return ActionResultType.FAIL; }
	}

	private boolean hasWater(World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		return (worldIn.getBlockState(new BlockPos(x - 1, y, z - 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x + 1, y, z - 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x - 1, y, z + 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x + 1, y, z + 1)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x, y + 1, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x, y, z - 2)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x - 2, y, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x + 2, y, z)).getMaterial() == Material.WATER) ||
				(worldIn.getBlockState(new BlockPos(x, y, z + 2)).getMaterial() == Material.WATER);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_NUGGET;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_kaihori").applyTextStyle(TextFormatting.GRAY));
	}
}
