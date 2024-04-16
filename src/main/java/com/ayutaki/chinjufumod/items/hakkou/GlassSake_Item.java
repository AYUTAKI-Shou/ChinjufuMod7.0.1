package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Wine;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
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
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GlassSake_Item extends ItemBlockBace {

	public GlassSake_Item(String name) {
		super(name, Hakkou_Blocks.SAKEGLASS);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		/** 1=生酒, 2=日本酒, 3=熟成酒, 4=甘酒 **/
		switch (stack.getMetadata()) {
		case 1:
			return "item." + "block_glass_sakenama";
		case 2:
		default:
			return "item." + "block_glass_sake";
		case 3:
			return "item." + "block_glass_sakejuku";
		case 4:
			return "item." + "block_glass_amazake";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
		}
	}

	/* 飲み終わった時の処理 */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

		int k;
		k = stack.getMetadata();

		if (!worldIn.isRemote) {
			if (k == 1) {
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2250, 0));
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 2600, 0)); }

			if (k == 2) {
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2250, 1));
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 2600, 0)); }

			if (k == 3) {
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2250, 2));
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 2250, 0)); }

			if (k == 4) {
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.HASTE, 2000, 0)); }
		}

		if (entityLiving instanceof EntityPlayerMP) {
			EntityPlayerMP playerInmp = (EntityPlayerMP)entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(playerInmp, stack);
			playerInmp.addStat(StatList.getObjectUseStats(this));
		}

		EntityPlayer playerIn = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;
		if (playerIn == null || !playerIn.capabilities.isCreativeMode) {
			if (k == 1 || k == 2 || k == 3) {
				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.Item_DISH, 1, 7); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.Item_DISH, 1, 7))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.Item_DISH, 1, 7), false); } }

			if (k == 4) {
				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.Item_DISH, 1, 1); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.Item_DISH, 1, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.Item_DISH, 1, 1), false); } }

			stack.shrink(1);
		}
		return stack;
	}

	/* 飲むのにかかる時間 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 32;
	}

	/* 飲むアクションをさせる */
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	/* 右クリックで飲むアクション */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (!stack.isEmpty() && facing == EnumFacing.UP && playerIn.canPlayerEdit(pos, facing, stack) && worldIn
				.mayPlace(Hakkou_Blocks.SAKEGLASS, pos, false, facing, (Entity)null) && (playerIn.isSneaking() || playerIn.isRiding())) {

			if (k == 1) {
				/** Put the Block. **/
				IBlockState state1 = Hakkou_Blocks.SAKEGLASS.getDefaultState().withProperty(Glass_Sake.STAGE_1_15, Integer.valueOf(1));
				worldIn.setBlockState(pos, state1, 10); }
			if (k == 2) {
				IBlockState state1 = Hakkou_Blocks.SAKEGLASS.getDefaultState().withProperty(Glass_Sake.STAGE_1_15, Integer.valueOf(4));
				worldIn.setBlockState(pos, state1, 10); }
			if (k == 3) {
				IBlockState state1 = Hakkou_Blocks.SAKEGLASS.getDefaultState().withProperty(Glass_Sake.STAGE_1_15, Integer.valueOf(7));
				worldIn.setBlockState(pos, state1, 10); }
			if (k == 4) {
				IBlockState state1 = Hakkou_Blocks.WINEGLASS.getDefaultState().withProperty(Glass_Wine.STAGE_1_15, Integer.valueOf(13));
				worldIn.setBlockState(pos, state1, 10); }

			CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_simpledish.name", meta));
	}

}
