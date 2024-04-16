package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class DonabeKara_Item extends ItemNameBlockItem {

	private final Fluid content;
	
	public DonabeKara_Item(Fluid containedFluidIn, Block block, Item.Properties properties) {
		super(block, properties);

		this.content = containedFluidIn;
	}
	
	/* BucketItem ...Changed the method of collecting LAVA and WATER. */
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand) {
		ItemStack stackIn = playerIn.getItemInHand(hand);
		BlockHitResult blockResult = getPlayerPOVHitResult(worldIn, playerIn, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stackIn, blockResult);

		boolean mode = playerIn.getAbilities().instabuild;

		BlockPos pos = blockResult.getBlockPos();
		Direction direction = blockResult.getDirection();
		BlockPos posDirect = pos.relative(direction);
		BlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (ret != null) return ret;

		if (blockResult.getType() == HitResult.Type.MISS) { return InteractionResultHolder.pass(stackIn); }

		if (blockResult.getType() != HitResult.Type.BLOCK) { return InteractionResultHolder.pass(stackIn); }

		else {
			if (!playerIn.isCrouching()) {
				if (worldIn.mayInteract(playerIn, pos) && playerIn.mayUseItemAt(posDirect, direction, stackIn)) {

					if (this.content == Fluids.EMPTY) {
						/** LAVA and WATER **/
						if (block instanceof BucketPickup) {

							int liquid = state.getValue(LiquidBlock.LEVEL);
							if (block == Blocks.LAVA && liquid == 0) {
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL_LAVA, SoundSource.BLOCKS, 1.0F, 1.0F);
								worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.8F, 1.0F);
								playerIn.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));

								int i = pos.getX();
								int j = pos.getY();
								int k = pos.getZ();

								for(int l = 0; l < 8; ++l) {
									worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D); }

								if (!playerIn.getInventory().add(new ItemStack(Items.AIR))) {
									playerIn.drop(new ItemStack(Items.AIR), false); }

								if (!mode) { stackIn.shrink(1); }
								if (mode) { }
							}
	
							if (block == Blocks.WATER && liquid == 0) {
								playerIn.awardStat(Stats.ITEM_USED.get(this));
								worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
								
								if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.NABESHIO_nama.get()))) {
									playerIn.drop(new ItemStack(Items_Teatime.NABESHIO_nama.get()), false); }

								if (!mode) { stackIn.shrink(1); }
								if (mode) { }
							}
							return InteractionResultHolder.success(stackIn);
						}
		
					}//empty
				}
			}//!sneaking

			return InteractionResultHolder.pass(stackIn);
		}
	}

	/* Branch the process. */
	@Override
	 public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();

		if (context.getClickedFace() == Direction.UP && (playerIn.isCrouching() || playerIn.isPassenger())) {
			return this.place(new BlockPlaceContext(context)); }

		else {
			return this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult(); }
	 }

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_simpledish").withStyle(ChatFormatting.GRAY));
	}
}
