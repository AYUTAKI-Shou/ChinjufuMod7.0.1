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

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
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
	public Zundou_ColdMilk(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_4);

		if (i == 1) {
			if (item == Items_Teatime.NYUSAN) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.add(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.drop(new ItemStack(Items.GLASS_BOTTLE), false); }
	
				worldIn.setBlock(pos, state.setValue(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (item != Items_Teatime.NYUSAN) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 2) {
			if (item == Items_Teatime.RENNET) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, state.setValue(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(3)), 3); }
			
			if (item != Items_Teatime.RENNET) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		if (i == 4) {
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE_CURD));
	
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Conditions for TickRandom. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (true) {
			worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 300 + (50 * worldIn.getRandom().nextInt(5))); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 300 + (50 * worldIn.random.nextInt(5)));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!inWater(state, worldIn, pos)) {
			if (i == 3) {
				worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 300 + (50 * rand.nextInt(5)));
				worldIn.setBlock(pos, state.setValue(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(4)), 3); }
			
			if (i != 3) { } }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.COLD_MILK, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2)), 3); }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU);
	}
}
