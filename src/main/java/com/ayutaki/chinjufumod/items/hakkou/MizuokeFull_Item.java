package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke_full;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MizuokeFull_Item extends ItemBlockBace {

	public MizuokeFull_Item(String name) {
		super(name, Hakkou_Blocks.MIZUOKE_full);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setContainerItem(Items_Teatime.MIZUOKE);
	}

	/* 素材として使った時に特定のアイテムを返す */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return new ItemStack(Items_Teatime.MIZUOKE);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos posIn, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(posIn);
		Block block = state.getBlock();
		ItemStack stack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;

		if (!playerIn.isSneaking() && playerIn.canPlayerEdit(posIn, facing, stack)) {

			/** 砂を塩田に変える **/
			if (state.getBlock() == Blocks.SAND && state.getValue(BlockSand.VARIANT) != EnumType.RED_SAND &&
					facing == EnumFacing.UP) {

				/** 生成するブロック **/
				IBlockState state1 = Crop_Blocks.ENDEN.getDefaultState().withProperty(Enden.STAGE_1_9, Integer.valueOf(1));
				worldIn.setBlockState(posIn, state1, 10);
				worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

				if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, posIn, stack); }

				/** add Item **/
				if (playerIn == null || !mode) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
					/* 消費を最後に回す */
					stack.shrink(1);
				}

				return EnumActionResult.SUCCESS;
			}

			/** 大釜への注水 **/
			if (state.getBlock() == Blocks.CAULDRON) {

				int level = state.getValue(BlockCauldron.LEVEL);

				if (level < 3) {
					worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

					if (level == 2) { ((BlockCauldron)block).setWaterLevel(worldIn, posIn, state, 3); }
					if (level < 2) { ((BlockCauldron)block).setWaterLevel(worldIn, posIn, state, level + 2); }

					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, posIn, stack); }

					/** add Item **/
					if (playerIn == null || !mode) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
						/* 消費を最後に回す */
						stack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}
				return EnumActionResult.PASS;
			}

			else {
				if (worldIn.provider.doesWaterVaporize()) {

					int l = posIn.getX();
					int i = posIn.getY();
					int j = posIn.getZ();
					worldIn.playSound(playerIn, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

					for (int k = 0; k < 8; ++k) {
						worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0D, 0.0D, 0.0D); }

					/** add Item **/
					if (playerIn == null || !mode) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
						/* 消費を最後に回す */
						stack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}

				if (!worldIn.provider.doesWaterVaporize()) {
					/** 生成するブロック 流れない Blocks.WATER とは別 **/
					IBlockState state1 = Blocks.FLOWING_WATER.getDefaultState();
					worldIn.setBlockState(posIn.offset(facing), state1, 11);
					worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, posIn, stack); }

					/** add Item **/
					if (playerIn == null || !mode) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
						/* 消費を最後に回す */
						stack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}
			}
		}

		/** 水桶の設置 **/
		if (playerIn.isSneaking()) {

			if (!block.isReplaceable(worldIn, posIn)) { posIn = posIn.offset(facing); }
			/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);

			if (!stack.isEmpty() && playerIn.canPlayerEdit(posIn, facing, stack) && worldIn.mayPlace(Hakkou_Blocks.MIZUOKE_full, posIn, false, facing, (Entity)null)) {
				/** Put the Block. **/
				IBlockState state1 = Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(Mizuoke_full.H_FACING, direction)
						.withProperty(Mizuoke_full.STAGE_1_2, Integer.valueOf(1));
				worldIn.setBlockState(posIn, state1, 10);
				worldIn.playSound(null, posIn, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F); }

			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_mizuoke_full.name", meta));
		tooltip.add(I18n.format("tips.block_simpledish.name", meta));
	}
}
