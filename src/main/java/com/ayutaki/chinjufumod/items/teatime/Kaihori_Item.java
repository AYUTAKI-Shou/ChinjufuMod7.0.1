package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.blocks.crop.Hamaguri;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class Kaihori_Item extends Item {

	public Kaihori_Item(Item.Properties builder) {
		super(builder.tab(ItemGroups_CM.TEATIME));
	}

	/* FlintAndSteel */
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		ItemStack stack = context.getItemInHand();
		Holder<Biome> biome = worldIn.getBiome(pos);

		BlockState upState = worldIn.getBlockState(pos.above());
		boolean water = (upState.getMaterial() == Material.WATER)? true : false;
		
		if (state.getBlock() == Blocks.SAND || state.getBlock() == Crop_Blocks.KAINASHI.get()) {
			worldIn.playSound(null, pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 0.8F, 1.2F);
			
			if (state.getBlock() == Blocks.SAND && upState.getMaterial().isReplaceable()) {
				
				if (biome.is(Biomes.BEACH) && hasWater(worldIn, pos)) {
					if (worldIn.random.nextInt(4) == 0) {
						worldIn.setBlock(pos.above(), Crop_Blocks.HAMAGURI.get().defaultBlockState().setValue(Hamaguri.WATERLOGGED, water), 3); } 
				} //Biomes.BEACH && hasWater
				
				if (!biome.is(Biomes.BEACH) || !hasWater(worldIn, pos)) { CMEvents.textNotDig(playerIn); }
			} //isReplaceable()
			
			if (state.getBlock() != Blocks.SAND || !upState.getMaterial().isReplaceable()) { CMEvents.textNotDig(playerIn); }
			
			/* Break animation. */
			stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
			return InteractionResult.sidedSuccess(worldIn.isClientSide());
		}
		
		else { return InteractionResult.FAIL; }
	}

	private boolean hasWater(Level worldIn, BlockPos pos) {
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
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(new TranslatableComponent("tips.item_kaihori").withStyle(ChatFormatting.GRAY));
	}
}
