package com.ayutaki.chinjufumod.items.teatime;

import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;

public class Warahai_Item extends Item {

	public Warahai_Item(Item.Properties properties) {
		super(properties);
	}

	/* FlintAndSteel */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = worldIn.getBlockState(pos);
		ItemStack stack = context.getItem();
		Biome biome = worldIn.getBiome(pos);

		boolean mode = playerIn.abilities.isCreativeMode;
		
		if (biome == Biomes_CM.SAKURA_FOREST.get() || biome == Biomes_CM.SAKURA_HILLS.get()) {
			Block block = state.getBlock();
			
			if (block instanceof SpreadableSnowyDirtBlock) {
				
				if (worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {
					worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 0.8F, 1.2F);

					for(int n = 0; n < 15; ++n) {
						double d0 = random.nextGaussian() * 0.02D;
						double d1 = random.nextGaussian() * 0.02D;
						double d2 = random.nextGaussian() * 0.02D;
						worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + random.nextFloat(), pos.getY() + random.nextFloat() + 0.5D, pos.getZ() + random.nextFloat(), d0, d1, d2); }

					if (random.nextInt(3) == 0) {
						worldIn.setBlockState(pos.up(), Wood_Blocks.TAKENOKO.getDefaultState(), 3); }
					
					if (playerIn instanceof ServerPlayerEntity) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos.up(), stack); }
					
					if (!mode) { stack.shrink(1); }
					if (mode) { }
					
					return ActionResultType.SUCCESS;
				}
			}
		}
		return ActionResultType.FAIL;
	}
}
