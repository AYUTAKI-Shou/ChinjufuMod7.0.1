package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* BucketItem を参照。extends は BlockNamedItem とする */
public class DonabeKara_Item extends BlockNamedItem {
	private final Fluid containedBlock;

	public DonabeKara_Item(Fluid containedFluidIn, Block block, Item.Properties properties) {
		super(block, properties.tab(ItemGroups_CM.TEATIME));

		this.containedBlock = containedFluidIn;
	}

	/* 水を入れる BucketItem */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stack, raytraceresult);

		boolean mode = playerIn.abilities.instabuild;

		if (ret != null) return ret;

		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.pass(stack);
		}

		else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
			return ActionResult.pass(stack);
		}

		else {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
			BlockPos pos = blockraytraceresult.getBlockPos();
			Direction direction = blockraytraceresult.getDirection();
			BlockPos pos1 = pos.relative(direction);

			if (worldIn.mayInteract(playerIn, pos) && playerIn.mayUseItemAt(pos1, direction, stack)) {

				if (this.containedBlock == Fluids.EMPTY) {
					BlockState state1 = worldIn.getBlockState(pos);

					if (state1.getBlock() instanceof IBucketPickupHandler) {
						Fluid fluid = ((IBucketPickupHandler)state1.getBlock()).takeLiquid(worldIn, pos, state1);

						if (fluid != Fluids.EMPTY) {
							playerIn.awardStat(Stats.ITEM_USED.get(this));

							SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
							if (soundevent == null) soundevent = fluid.is(FluidTags.LAVA) ? SoundEvents.BUCKET_FILL_LAVA : SoundEvents.BUCKET_FILL;
								playerIn.playSound(soundevent, 1.0F, 1.0F);

								if (fluid == Fluids.LAVA) {

									worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundCategory.PLAYERS, 0.8F, 1.0F);
									if (!playerIn.inventory.add(new ItemStack(Items.AIR))) {
										playerIn.drop(new ItemStack(Items.AIR), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { }
								}

								else {
									if (!playerIn.inventory.add(new ItemStack(Items_Teatime.NABESHIO_nama))) {
										playerIn.drop(new ItemStack(Items_Teatime.NABESHIO_nama), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { }
								}

								return ActionResult.success(stack);
							}
						}

					return ActionResult.fail(stack);
				}
			}
		}
		return ActionResult.fail(stack);
	}

	/* 設置処理の分岐 スニーク時 playerIn.isCrouching() 座っている時 playerIn.isPassenger() */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getClickedFace() == Direction.UP && (playerIn.isCrouching())) {
			return this.place(new BlockItemUseContext(context)); }

		else {
			return this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult(); }
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").withStyle(TextFormatting.GRAY));
	}
}
