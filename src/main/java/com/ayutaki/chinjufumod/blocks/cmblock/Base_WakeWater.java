package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Optional;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Base_WakeWater extends Block implements BucketPickup {

	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.1D, 16.0D);

	public Base_WakeWater(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		/** 水を汲む **/
		if (item == Items.GLASS_BOTTLE) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);

			ItemStack stack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
			if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack4); }
			else if (!playerIn.getInventory().add(stack4)) {
				playerIn.drop(stack4, false); }
		}

		/** TTimeItems **/
		if (item == Items_Teatime.MIZUOKE.get()) {
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
				playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); }
		}

		if (item == Items_Teatime.NABE_kara.get()) {
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.NABESHIO_nama.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.NABESHIO_nama.get()))) {
				playerIn.drop(new ItemStack(Items_Teatime.NABESHIO_nama.get()), false); }
		}

		if (item == Items_Teatime.KEIRYO_CUP.get()) {
			CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()))) {
				playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()), false); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* BucketPickup Items.BUCKET -> Items.WATER_BUCKET */
	@Override
	public ItemStack pickupBlock(@Nullable Player playerIn, LevelAccessor worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			
			if (!state.canSurvive(worldIn, pos)) { worldIn.destroyBlock(pos, true); }
			return new ItemStack(Items.WATER_BUCKET);
		}
		
		else { return ItemStack.EMPTY; }
	} // fix 20.2
	
	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}
}
