package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BaseStage4_FaceDown;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Okonomiyaki_Item extends ItemFood {

	public Okonomiyaki_Item(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.TEATIME);
		
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_food_okonomiyaki_1";
		case 1:
			return "item." + "block_food_okonomis_1";
		case 2:
			return "item." + "block_food_okonomic_1";
		case 3:
			return "item." + "block_food_okonomisoba_1";
		case 4:
			return "item." + "block_food_okonomisobas_1";
		case 5:
			return "item." + "block_food_okonomisobac_1";
		case 6:
			return "item." + "block_food_yakisoba_1";
		case 7:
			return "item." + "block_food_yakisobashio_1";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
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
			if (stack.isEmpty()) { return new ItemStack(Items_Teatime.Item_SARA, 1, 0); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.Item_SARA, 1, 0))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.Item_SARA, 1, 0), false); }

			stack.shrink(1);
		}
		return stack;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		int k;
		k = stack.getMetadata();
		
		if (k == 0 || k == 1 || k == 6 || k == 7) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 3000, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3000, 0)); }

		if (k == 2) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 2600, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2600, 0)); }

		if (k == 3 || k == 4) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 4, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 3000, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3000, 0)); }
		
		if (k == 5) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 2600, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2600, 0)); }
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack stack = playerIn.getHeldItem(hand);

			if (!stack.isEmpty() && facing == EnumFacing.UP && playerIn.canPlayerEdit(pos, facing, stack) && worldIn
					.mayPlace(this.takeBlock(playerIn, hand), pos, false, facing, (Entity)null) && (playerIn.isSneaking() || playerIn.isRiding())) {

				/** Put the Block. **/
				IBlockState state1 = this.takeBlock(playerIn, hand).getDefaultState()
						.withProperty(BaseStage4_FaceDown.H_FACING, direction)
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, state1, 10);
				CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS;
			}

			else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (k == 0) { return Dish_Blocks.OKONOMIYAKI; }
		if (k == 1) { return Dish_Blocks.OKONOMIS; }
		if (k == 2) { return Dish_Blocks.OKONOMIC; }
		if (k == 3) { return Dish_Blocks.OKONOMISOBA; }
		if (k == 4) { return Dish_Blocks.OKONOMISOBAS; }
		if (k == 5) { return Dish_Blocks.OKONOMISOBAC; }
		if (k == 6) { return Dish_Blocks.YAKISOBA; }
		if (k == 7) { return Dish_Blocks.YAKISOBASHIO; }
		return null;
	}
	
	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_simpledish.name", meta));
	}
}
