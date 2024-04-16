package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ModFoodS_Item extends ItemFood {

	private PotionEffect[] effects;

	public ModFoodS_Item(String name, int amount, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		this.effects = potionEffects;
	}
	
	public ModFoodS_Item(String name, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		this.effects = potionEffects;
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		for (PotionEffect effect : effects) {
			playerIn.addPotionEffect(new PotionEffect(effect));
		}
	}

}
