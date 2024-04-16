package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MizuokeKara_Item extends ItemBlockBace {

	private final Block containedBlock;

	public MizuokeKara_Item(String name, Block containedBlockIn) {
		super(name, Hakkou_Blocks.MIZUOKE);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		
		this.containedBlock = containedBlockIn;
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 100;
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

			BlockPos posIn = raytraceresult.getBlockPos();
			IBlockState state = worldIn.getBlockState(posIn);
			Block block1 = state.getBlock();
			Material material = state.getMaterial();

			if (!worldIn.isBlockModifiable(playerIn, posIn)) { return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack); }

			else if (contained) {

				if (!playerIn.canPlayerEdit(posIn.offset(raytraceresult.sideHit), raytraceresult.sideHit, stack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack); }

				else {

					if (!playerIn.isSneaking()) {
						/** 大釜からの給水 **/
						if (state.getBlock() == Blocks.CAULDRON) {
							int level = state.getValue(BlockCauldron.LEVEL);

							if (level >= 2) {
								((BlockCauldron)block1).setWaterLevel(worldIn, posIn, state, level - 2);
								worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

								/** add Item **/
								if (stack.isEmpty()) { playerIn.setHeldItem(handIn, new ItemStack(Items_Teatime.MIZUOKE_full)); }
								if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full, 1, 0))) {
									playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full, 1, 0), false); }

								/* 消費を最後に回す */
								if (playerIn == null || !mode) { stack.shrink(1); }
								if (mode) { }

								return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }

							if (level == 1) {
								((BlockCauldron)block1).setWaterLevel(worldIn, posIn, state, 0);
								worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }

							else { return new ActionResult<ItemStack>(EnumActionResult.PASS, stack); } }

						/** 水と溶岩 **/
						if (material == Material.WATER && ((Integer)state.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

							worldIn.setBlockState(posIn, Blocks.AIR.getDefaultState(), 11);
							playerIn.addStat(StatList.getObjectUseStats(this));
							playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);

							/** add Item **/
							if (stack.isEmpty()) { playerIn.setHeldItem(handIn, new ItemStack(Items_Teatime.MIZUOKE_full)); }
							if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full, 1, 0))) {
								playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full, 1, 0), false); }

							/* 消費を最後に回す */
							if (playerIn == null || !mode) { stack.shrink(1); }
							if (mode) { }

							return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack); }

						if (material == Material.LAVA && ((Integer)state.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

							playerIn.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1.0F, 1.0F);
							playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 0));
							playerIn.addStat(StatList.getObjectUseStats(this));

							worldIn.setBlockState(posIn, Blocks.AIR.getDefaultState(), 11);

							int l = posIn.getX();
							int i = posIn.getY();
							int j = posIn.getZ();

							for (int k = 0; k < 8; ++k) {
								worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0D, 0.0D, 0.0D); }

							/** add Item **/
							if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.AIR, 1, 0))) {
								playerIn.dropItem(new ItemStack(Items.AIR, 1, 0), false); }

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

	/* 牛乳を汲む ItemShears */
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, net.minecraft.entity.player.EntityPlayer playerIn, EntityLivingBase entity, EnumHand hand) {

		if (entity.world.isRemote) { return false; }

		/* EntityCow */
		if (stack.getItem() == Items_Teatime.MIZUOKE) {

			if (entity instanceof EntityCow && !playerIn.capabilities.isCreativeMode && !entity.isChild()) {

				entity.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);

				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_Milk)))
				{ playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_Milk), false); }

				/* 消費を最後に回す */
				stack.shrink(1);
			}
			return true;
		}
		return false;
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
				.mayPlace(Hakkou_Blocks.MIZUOKE, pos, false, facing, (Entity)null) && playerIn.isSneaking()) {

			/** Put the Block. **/
			IBlockState state1 = Hakkou_Blocks.MIZUOKE.getDefaultState().withProperty(Mizuoke.H_FACING, direction)
					.withProperty(Mizuoke.STAGE_1_4, Integer.valueOf(1));
			worldIn.setBlockState(pos, state1, 10);
			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_mizuoke.name", meta));
		tooltip.add(I18n.format("tips.block_simpledish.name", meta));
	}
}
