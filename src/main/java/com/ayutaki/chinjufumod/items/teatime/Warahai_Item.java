package com.ayutaki.chinjufumod.items.teatime;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;
import com.ayutaki.chinjufumod.world.biome.BiomeKey_CM;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;

public class Warahai_Item extends Item {

	public Warahai_Item(Item.Properties builder) {
		super(builder);
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

		boolean mode = playerIn.getAbilities().instabuild;
		
		if (biome.is(BiomeKey_CM.SAKURA_FOREST_KEY) || biome.is(BiomeKey_CM.SAKURA_HILLS_KEY) || biome.is(Biomes.CHERRY_GROVE)) {
			Block block = state.getBlock();
			
			if (block instanceof SpreadingSnowyDirtBlock) {
				worldIn.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat() + 0.5D, pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
	

				if (worldIn.random.nextInt(3) == 0) {
					worldIn.setBlock(pos.above(), Wood_Blocks.TAKENOKO.get().defaultBlockState(), 3); }
				
				if (playerIn instanceof ServerPlayer) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerIn, pos.above(), stack); }
					
				if (!mode) { stack.shrink(1); }
				if (mode) { }
				
				return InteractionResult.sidedSuccess(worldIn.isClientSide());
			}
		}
		
		return InteractionResult.FAIL;
	}
}
