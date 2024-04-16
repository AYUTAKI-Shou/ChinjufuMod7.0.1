package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NabeKara_Item extends ItemBlockBace {

	private final Block containedBlock;

	public NabeKara_Item(String name, Block containedBlockIn) {
		super(name, Dish_Blocks.NABE_kara);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		this.containedBlock = containedBlockIn;
	}

	/* 水を入れる ItemBucket */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		boolean flag = this.containedBlock == Blocks.AIR;
		ItemStack stack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, flag);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stack, raytraceresult);
		if (ret != null) return ret;

		if (raytraceresult == null) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); }

		else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); }

		else {
			BlockPos pos = raytraceresult.getBlockPos();

			if (!worldIn.isBlockModifiable(playerIn, pos)) {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
			}

			else if (flag) {

				if (!playerIn.canPlayerEdit(pos.offset(raytraceresult.sideHit), raytraceresult.sideHit, stack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
				}

				else {
					IBlockState state = worldIn.getBlockState(pos);
					Material material = state.getMaterial();

					if (material == Material.WATER && ((Integer)state.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

						worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
						playerIn.addStat(StatList.getObjectUseStats(this));
						playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);

						/** add Item **/
						if (stack.isEmpty()) { playerIn.setHeldItem(handIn, new ItemStack(Items_Teatime.NABE_KAISUI, 1, 0)); }
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_KAISUI, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.NABE_KAISUI, 1, 0), false); }

						/* 消費を最後に回す */
						if (playerIn == null || !playerIn.capabilities.isCreativeMode) { stack.shrink(1); }
						if (playerIn.capabilities.isCreativeMode) { }

						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }

					else if (material == Material.LAVA && ((Integer)state.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

						playerIn.playSound(SoundEvents.ENTITY_GENERIC_BURN, 1.0F, 1.0F);
						playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 0));
						playerIn.addStat(StatList.getObjectUseStats(this));

						/** add Item **/
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.AIR, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items.AIR, 1, 0), false); }

						/* 消費を最後に回す */
						if (playerIn == null || !playerIn.capabilities.isCreativeMode) { stack.shrink(1); }
						if (playerIn.capabilities.isCreativeMode) { }

						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }

					else {
						return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
					}
				}
			}

			else {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
			}
		}
	}


	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Dish_Blocks.NABE_kara, pos, false, facing, (Entity)null)) {

			/** Put the Block. **/
			IBlockState state1 = Dish_Blocks.NABE_kara.getDefaultState()
					.withProperty(BaseNabe.H_FACING, direction)
					.withProperty(BaseNabe.STAGE_1_4, Integer.valueOf(1));
			worldIn.setBlockState(pos, state1, 10);

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
		tooltip.add(I18n.format("tips.block_food_karanabe.name", meta));
	}

}
