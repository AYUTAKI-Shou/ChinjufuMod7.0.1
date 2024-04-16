package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.phys.BlockHitResult;

public class FallLeaf extends GrassBlock {

	public FallLeaf(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ShovelItem) {
			stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
			worldIn.playSound(null, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlock(pos, Blocks.DIRT_PATH.defaultBlockState(), 3);
			return InteractionResult.SUCCESS;
		}

		if (item instanceof HoeItem) {
			stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
			worldIn.playSound(null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlock(pos, Wood_Blocks.SUIDEN.get().defaultBlockState(), 3);
			return InteractionResult.SUCCESS;
		}

		/* PASS for Mob Spawn. */
		return InteractionResult.PASS;
	}
	
	/* Conditions to grow. */
	private static boolean canBeGrass(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos upPos = pos.above();
		BlockState upState = worldIn.getBlockState(upPos);
		if (upState.is(Blocks.SNOW) && upState.getValue(SnowLayerBlock.LAYERS) == 1) {
			return true;
		} else if (upState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			int i = LightEngine.getLightBlockInto(worldIn, state, pos, upState, upPos, Direction.UP, upState.getLightBlock(worldIn, upPos));
			return i < worldIn.getMaxLightLevel();
		}
	}

	private static boolean canPropagate(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos upPos = pos.above();
		return canBeGrass(state, worldIn, pos) && !worldIn.getFluidState(upPos).is(FluidTags.WATER);
	}

	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (!canBeGrass(state, worldIn, pos)) {
			if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
			worldIn.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState()); }
		
		else {
			if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
			if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9) {
				BlockState defaultState = this.defaultBlockState();

				for(int i = 0; i < 4; ++i) {
					BlockPos nearPos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
					if (worldIn.getBlockState(nearPos).is(Blocks.DIRT) && canPropagate(defaultState, worldIn, nearPos)) {
						worldIn.setBlockAndUpdate(nearPos, defaultState.setValue(SNOWY, Boolean.valueOf(worldIn.getBlockState(nearPos.above()).is(Blocks.SNOW))));
					}
				}
			}
		}
	}

	/* バイオーム生成時に、木や草が生えるようにする -> forge:dirt タグに追加する必要がある */
	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
		return true;
	}

	/* モブ湧き -> ReplaceSpawn でスポーンルールを改変 IForgeBlock */
	@Override
	public boolean isValidSpawn(BlockState state, BlockGetter world, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
		return true;
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_fall_leaf").withStyle(ChatFormatting.GRAY));
	}
}
