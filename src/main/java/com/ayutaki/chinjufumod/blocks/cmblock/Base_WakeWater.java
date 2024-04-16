package com.ayutaki.chinjufumod.blocks.cmblock;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Base_WakeWater extends Block implements IBucketPickupHandler {

	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.1D, 16.0D);

	public Base_WakeWater(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		/** 水を汲む **/
		if (item == Items.GLASS_BOTTLE) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);

			ItemStack stack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
			if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack4); }
			else if (!playerIn.inventory.add(stack4)) {
				playerIn.drop(stack4, false); }
		}

		/** TTimeItems **/
		if (item == Items_Teatime.MIZUOKE) {
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full))) {
				playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
		}

		if (item == Items_Teatime.NABE_kara) {
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.NABESHIO_nama)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.NABESHIO_nama))) {
				playerIn.drop(new ItemStack(Items_Teatime.NABESHIO_nama), false); }
		}
		
		if (item == Items_Teatime.KEIRYO_CUP) {
			CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
				playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* Items.BUCKET など Fluids.WATER の有るアイテムで水を汲む */
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		return Fluids.WATER;
	}
}
