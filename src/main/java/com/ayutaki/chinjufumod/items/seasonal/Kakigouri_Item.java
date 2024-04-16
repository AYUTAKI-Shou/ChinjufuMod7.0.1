package com.ayutaki.chinjufumod.items.seasonal;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BaseStage4_FaceDown;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Kakigouri_Item extends ItemFood {

	public Kakigouri_Item(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setAlwaysEdible();
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
			if (stack.isEmpty()) { return new ItemStack(Items_Teatime.Item_DISH, 1, 7); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.Item_DISH, 1, 7))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.Item_DISH, 1, 7), false); }

			stack.shrink(1);
		}
		return stack;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		/** ポーションエフェクトの追加 一口100 通常 120 **/
		if (this == Items_Seasonal.KAKIGOURI_block) { playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1250, 0)); }
		if (this == Items_Seasonal.KAKIGOURI_pink) { playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1900, 0)); }
		if (this == Items_Seasonal.KAKIGOURI_red) { playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1900, 0)); }
		if (this == Items_Seasonal.KAKIGOURI_yellow) { playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1900, 0)); }
		if (this == Items_Seasonal.KAKIGOURI_green) { playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1900, 0)); }
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
					.mayPlace(takeBlock(), pos, false, facing, (Entity)null) && (playerIn.isSneaking() || playerIn.isRiding())) {

				/** Put the Block. **/
				IBlockState state1 = takeBlock().getDefaultState()
						.withProperty(BaseStage4_FaceDown.H_FACING, direction)
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, state1, 10);
				CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS;
			}

		else {
			return EnumActionResult.FAIL;
		}
	}

	private Block takeBlock() {
		if (this == Items_Seasonal.KAKIGOURI_block) { return Dish_Blocks.KAKIGOURI_block; }
		if (this == Items_Seasonal.KAKIGOURI_pink) { return Dish_Blocks.KAKIGOURI_pink; }
		if (this == Items_Seasonal.KAKIGOURI_red) { return Dish_Blocks.KAKIGOURI_red; }
		if (this == Items_Seasonal.KAKIGOURI_yellow) { return Dish_Blocks.KAKIGOURI_yellow; }
		if (this == Items_Seasonal.KAKIGOURI_green) { return Dish_Blocks.KAKIGOURI_green; }
		return null;
	}
	
	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kakigouri.name", meta));
		tooltip.add(I18n.format("tips.block_simpledish.name", meta));
	}
}
