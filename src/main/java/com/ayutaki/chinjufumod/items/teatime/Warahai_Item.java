package com.ayutaki.chinjufumod.items.teatime;

import java.util.Optional;

import com.ayutaki.chinjufumod.ItemGroups_CM;
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
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class Warahai_Item extends Item {

	public Warahai_Item(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.SEASONAL));
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
		
		boolean mode = playerIn.abilities.instabuild;

		if (biomeKey.get().location().getPath().contains("biome_sakura") || biomeKey.get().location().getPath().contains("biome_sakurahills")) {
			Block block = state.getBlock();
			
			if (block instanceof SpreadableSnowyDirtBlock) {
				worldIn.playSound(null, pos, SoundEvents.SNOW_PLACE, SoundCategory.BLOCKS, 0.8F, 1.2F);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat() + 0.5D, pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }

				if (worldIn.random.nextInt(3) == 0) {
					worldIn.setBlock(pos.above(), Wood_Blocks.TAKENOKO.defaultBlockState(), 3); }
				
				if (playerIn instanceof ServerPlayerEntity) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos.above(), stack); }
					
				if (!mode) { stack.shrink(1); }
				if (mode) { }
				
				return ActionResultType.sidedSuccess(worldIn.isClientSide());
			}
		}
		
		return ActionResultType.FAIL;
	}

}
