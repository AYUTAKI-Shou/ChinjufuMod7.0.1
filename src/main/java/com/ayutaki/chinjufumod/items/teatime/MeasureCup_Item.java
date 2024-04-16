package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MeasureCup_Item extends ItemBlockBace {

	private final Block containedBlock;
	
	public MeasureCup_Item(String name, Block containedBlockIn) {
		super(name, Dish_Blocks.KEIRYO_CUP);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		
		this.containedBlock = containedBlockIn;
	}

	/* 水を入れる ItemBucket */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		boolean contained = this.containedBlock == Blocks.AIR;
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, contained);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stack, raytraceresult);

		if (ret != null) return ret;

		if (raytraceresult == null) { return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); }

		if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) { return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); }

		else {
			BlockPos pos = raytraceresult.getBlockPos();
			IBlockState state = worldIn.getBlockState(pos);
			Block block1 = state.getBlock();
			Material material = state.getMaterial();
			
			if (!worldIn.isBlockModifiable(playerIn, pos)) { return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack); }
			
			else if (contained) {

				if (!playerIn.canPlayerEdit(pos.offset(raytraceresult.sideHit), raytraceresult.sideHit, stack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack); }

				else {

					if (!playerIn.isSneaking()) {
						/** 大釜からの給水 **/
						if (state.getBlock() == Blocks.CAULDRON) {
							int level = state.getValue(BlockCauldron.LEVEL);

							if (level == 0) { return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); }
							
							else {
								((BlockCauldron)block1).setWaterLevel(worldIn, pos, state, level - 1);
								worldIn.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

								/** add Item **/
								if (stack.isEmpty()) { playerIn.setHeldItem(handIn, new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
								if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full, 1, 0))) {
									playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full, 1, 0), false); }

								/* 消費を最後に回す */
								if (playerIn == null || !mode) { stack.shrink(1); }
								if (mode) { }

								return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }
						 }

						/** 水と溶岩 **/
						if (material == Material.WATER) {
							playerIn.addStat(StatList.getObjectUseStats(this));
							worldIn.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

							/** add Item **/
							if (stack.isEmpty()) { playerIn.setHeldItem(handIn, new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
							if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full, 1, 0))) {
								playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full, 1, 0), false); }

							/* 消費を最後に回す */
							if (playerIn == null || !mode) { stack.shrink(1); }
							if (mode) { }

							return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }

						else { return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); }
					}
				}
			}
			return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
		}	
	}
	
	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		ItemStack stack = playerIn.getHeldItem(hand);

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
		int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		EnumFacing direction = EnumFacing.getHorizontal(i);

		/** 水桶の設置 **/
		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn
				.mayPlace(Dish_Blocks.KEIRYO_CUP, pos, false, facing, (Entity)null) && playerIn.isSneaking()) {

			/** Put the Block. **/
			IBlockState state1 = Dish_Blocks.KEIRYO_CUP.getDefaultState().withProperty(Mizuoke.H_FACING, direction);
			worldIn.setBlockState(pos, state1, 10);

			SoundType soundtype = state1.getBlock().getSoundType(state1, worldIn, pos, playerIn);
			worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_measurecup.name", meta));
		tooltip.add(I18n.format("tips.block_simpledish.name", meta));
	}
}
