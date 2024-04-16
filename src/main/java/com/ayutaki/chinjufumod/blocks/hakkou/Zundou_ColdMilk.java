package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.blocks.dish.BaseZundou_4Stage;
import com.ayutaki.chinjufumod.blocks.dish.Zundou;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Zundou_ColdMilk extends BaseZundou_4Stage {

	/** 1=冷めた牛乳、2=乳酸菌、3=レンネット、4=カード **/
	public Zundou_ColdMilk(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_4);

		if (i == 1) {
			if (item == Items_Teatime.NYUSAN) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false); }
	
				worldIn.setBlockState(pos, state.with(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(2))); }
			
			if (item != Items_Teatime.NYUSAN) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 2) {
			if (item == Items_Teatime.RENNET) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, state.with(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(3))); }
			
			if (item != Items_Teatime.RENNET) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		if (i == 4) {
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE_CURD));
	
				/** Get EXP. **/
				worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Conditions for TickRandom. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (true) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 300 + (50 * worldIn.getRandom().nextInt(5))); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 300 + (50 * worldIn.rand.nextInt(5)));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_4);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!inWater(state, worldIn, pos)) {
			if (i == 3) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 300 + (50 * rand.nextInt(5)));
				worldIn.setBlockState(pos, state.with(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(4))); }
			
			if (i != 3) { } }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState().with(H_FACING, state.get(H_FACING))
					.with(Zundou.STAGE_1_2, Integer.valueOf(2))); }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU);
	}
	
	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
}
