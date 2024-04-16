package com.ayutaki.chinjufumod.blocks.season;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.dish.BaseFood_Stage4Water;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Kakigouri extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(6.4D, 0.0D, 6.4D, 9.6D, 5.0D, 9.6D);
	protected static final VoxelShape AABB_DOWN = Block.box(6.4D, -8.0D, 6.4D, 9.6D, 0.1D, 9.6D);

	public Kakigouri(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		if (i != 4) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (i == 1) {
					if (this == Seasonal_Blocks.KAKIGOURI_block.get()) { playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0)); }
					if (this != Seasonal_Blocks.KAKIGOURI_block.get()) { playerIn.addEffect(new MobEffectInstance(this.takeEffect(), 600, 0));} }
	
				if (i == 2) {
					if (this == Seasonal_Blocks.KAKIGOURI_block.get()) { playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0)); }
					if (this != Seasonal_Blocks.KAKIGOURI_block.get()) { playerIn.addEffect(new MobEffectInstance(this.takeEffect(), 780, 0)); } }
	
				if (i == 3) {
					if (this == Seasonal_Blocks.KAKIGOURI_block.get()) { playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0)); }
					if (this != Seasonal_Blocks.KAKIGOURI_block.get()) { playerIn.addEffect(new MobEffectInstance(this.takeEffect(), 900, 0)); } }
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	private MobEffect takeEffect() {
		if (this == Seasonal_Blocks.KAKIGOURI_pink.get()) { return MobEffects.DAMAGE_BOOST; }
		if (this == Seasonal_Blocks.KAKIGOURI_red.get()) { return MobEffects.NIGHT_VISION; }
		if (this == Seasonal_Blocks.KAKIGOURI_yellow.get()) { return MobEffects.DAMAGE_RESISTANCE; }
		if (this == Seasonal_Blocks.KAKIGOURI_green.get()) { return MobEffects.DIG_SPEED; }
		return null;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);
		
		if (i != 4) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }

			else { } }
		
		if (i == 4) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Seasonal_Blocks.KAKIGOURI_block.get()) { return new ItemStack(Items_Seasonal.KAKIGOURI_block.get(), 1); }
		if (this == Seasonal_Blocks.KAKIGOURI_pink.get()) { return new ItemStack(Items_Seasonal.KAKIGOURI_pink.get(), 1); }
		if (this == Seasonal_Blocks.KAKIGOURI_red.get()) { return new ItemStack(Items_Seasonal.KAKIGOURI_red.get(), 1); }
		if (this == Seasonal_Blocks.KAKIGOURI_yellow.get()) { return new ItemStack(Items_Seasonal.KAKIGOURI_yellow.get(), 1); }
		if (this == Seasonal_Blocks.KAKIGOURI_green.get()) { return new ItemStack(Items_Seasonal.KAKIGOURI_green.get(), 1); }
		return null;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kakigouri").withStyle(ChatFormatting.GRAY));
	}
}
