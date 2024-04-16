package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;
import java.util.Optional;

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
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kaihori_Item extends Item {

	public Kaihori_Item(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.TEATIME));
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		ItemStack stack = context.getItemInHand();
		Optional<RegistryKey<Biome>> biomeKey = worldIn.getBiomeName(pos);

		BlockState upState = worldIn.getBlockState(pos.above());
		boolean water = (upState.getMaterial() == Material.WATER)? true : false;
		
		if (state.getBlock() == Blocks.SAND || state.getBlock() == Crop_Blocks.KAINASHI) {
			worldIn.playSound(null, pos, SoundEvents.SAND_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F);
			
			if (state.getBlock() == Blocks.SAND && upState.getMaterial().isReplaceable()) {
				
				if (biomeKey.get().location().getPath().contains("beach") && hasWater(worldIn, pos)) {
					if (worldIn.random.nextInt(4) == 0) {
						worldIn.setBlock(pos.above(), Crop_Blocks.HAMAGURI.defaultBlockState().setValue(Hamaguri.WATERLOGGED, water), 3); } 
				} //Biomes.BEACH && hasWater
				
				if (!biomeKey.get().location().getPath().contains("beach") || !hasWater(worldIn, pos)) { CMEvents.textNotDig(playerIn); }
			} //isReplaceable()
			
			if (state.getBlock() != Blocks.SAND || !upState.getMaterial().isReplaceable()) { CMEvents.textNotDig(playerIn); }
			
			/* Break animation. */
			stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
			return ActionResultType.sidedSuccess(worldIn.isClientSide());
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
	
	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_NUGGET;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_kaihori").withStyle(TextFormatting.GRAY));
	}
}
