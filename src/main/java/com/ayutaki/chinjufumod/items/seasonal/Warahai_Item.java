package com.ayutaki.chinjufumod.items.seasonal;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.wood.FallLeaf;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class Warahai_Item extends Item {

	public Warahai_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

	/* FlintAndSteel */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Biome biome = worldIn.getBiome(pos);
		
		if (biome == Biomes_CM.BIOME_SAKURA || biome == Biomes_CM.BIOME_SAKURA_HILL) {
			
			Block block = worldIn.getBlockState(pos).getBlock();
			
			if (block instanceof BlockDirt || block instanceof BlockGrass || block instanceof FallLeaf) {
				
				if (worldIn.isAirBlock(pos.up())) {
					worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 0.8F, 1.2F);
					
					for(int n = 0; n < 15; ++n) {
						double d0 = worldIn.rand.nextGaussian() * 0.02D;
						double d1 = worldIn.rand.nextGaussian() * 0.02D;
						double d2 = worldIn.rand.nextGaussian() * 0.02D;
						worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat() + 0.5D, pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
					
					if (worldIn.rand.nextInt(3) == 0) {
						worldIn.setBlockState(pos.up(), Seasonal_Blocks.TAKENOKO.getDefaultState(), 3); }
					
					if (playerIn instanceof EntityPlayerMP) {
						CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }
					
					CMEvents.Consume_1Item(playerIn, hand);
					return EnumActionResult.SUCCESS;
				}
			}
		}
		return EnumActionResult.FAIL;
	}
	
}
