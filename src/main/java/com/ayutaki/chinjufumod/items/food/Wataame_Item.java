package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Wataame_Item extends ItemFood {

	public Wataame_Item(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		/** Have sub items. **/
		setHasSubtypes(true);
		setAlwaysEdible();
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "item_food_watagashi";
		case 2:
			return "item." + "item_food_watagashi_y";
		case 3:
			return "item." + "item_food_watagashi_p";
		case 4:
			return "item." + "item_food_watagashi_r";
		case 5:
			return "item." + "item_food_watagashi_g";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
		}
	}

	/* Finish RightClick Action */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

		EntityPlayer playerIn = (EntityPlayer)entityLiving;
		playerIn.getFoodStats().addStats(this, stack);

		if (entityLiving instanceof EntityPlayer) {
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
			this.onFoodEaten(stack, worldIn, playerIn);
			playerIn.addStat(StatList.getObjectUseStats(this));

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)playerIn, stack);
			}
		}

		/** add Item **/
		if (playerIn == null || !playerIn.capabilities.isCreativeMode) {
			if (stack.isEmpty()) { return new ItemStack(Items.STICK); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.STICK))) {
				playerIn.dropItem(new ItemStack(Items.STICK), false); }

			stack.shrink(1);
		}
		return stack;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		int i;
		i = stack.getMetadata();

		/** ポーションエフェクトの追加 **/
		/* 1秒＝20 綿菓子は ×50=1000 素材分マイナス */
		if (i == 1) { playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 600, 0)); }
		if (i == 2) { playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1000, 0)); }
		if (i == 3) { playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1000, 0)); }
		if (i == 4) { playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1000, 0)); }
		if (i == 5) { playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1000, 0)); }
	}
}
