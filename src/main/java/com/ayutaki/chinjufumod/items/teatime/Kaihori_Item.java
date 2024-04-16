package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Kaihori_Item extends Item {

	public Kaihori_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		
		setMaxDamage(256);
	}

	/* FlintAndSteel */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Biome biome = worldIn.getBiome(pos);
		IBlockState state = worldIn.getBlockState(pos);
		IBlockState upState = worldIn.getBlockState(pos.up());
		
		if (state.getBlock() == Blocks.SAND || state.getBlock() == Crop_Blocks.KAINASHI) {
			worldIn.playSound(null, pos, SoundEvents.BLOCK_SAND_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F);
			
			if (state.getBlock() == Blocks.SAND && state.getValue(BlockSand.VARIANT) != BlockSand.EnumType.RED_SAND && upState.getMaterial().isReplaceable()) {
				
				if (biome == Biomes.BEACH && hasWater(worldIn, pos)) {
					if (worldIn.rand.nextInt(4) == 0) { worldIn.setBlockState(pos.up(), Crop_Blocks.HAMAGURI.getDefaultState(), 3); }
				} //Biomes.BEACH && hasWater	
				
				if (biome != Biomes.BEACH || !hasWater(worldIn, pos)) { CMEvents.textNotDig(playerIn); }
			} //isReplaceable()
			
			if (state.getBlock() != Blocks.SAND || state.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND || !upState.getMaterial().isReplaceable()) { 
				CMEvents.textNotDig(playerIn); }
			
			/* Break animation. */
			stack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS;
		} //Blocks.SAND
		
		return EnumActionResult.FAIL;
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
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_NUGGET);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_kaihori.name", meta));
	}
}
