package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.blocks.dish.BaseZundou_4Stage;
import com.ayutaki.chinjufumod.blocks.dish.Zundou;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Zundou_ColdMilk extends BaseZundou_4Stage {

	/** 1=冷めた牛乳、2=乳酸菌、3=レンネット、4=カード **/
	public Zundou_ColdMilk(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_4);

		if (i == 1) {
			if (item == Items_Teatime.NYUSAN.get()) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.drop(new ItemStack(Items.GLASS_BOTTLE), false); }
	
				worldIn.setBlock(pos, state.setValue(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (item != Items_Teatime.NYUSAN.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 2) {
			if (item == Items_Teatime.RENNET.get()) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, state.setValue(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(3)), 3); }
			
			if (item != Items_Teatime.RENNET.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		if (i == 4) {
			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.getInventory().add(new ItemStack(Items_Teatime.CHEESE_CURD.get()));
	
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrb(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (true) { worldIn.scheduleTick(pos, Hakkou_Blocks.COLD_MILK.get(), 300 + (50 * worldIn.getRandom().nextInt(5))); }
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, Hakkou_Blocks.COLD_MILK.get(), 300 + (50 * worldIn.random.nextInt(5)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!inWater(state, worldIn, pos)) {
			if (i == 3) {
				worldIn.scheduleTick(pos, Hakkou_Blocks.COLD_MILK.get(), 300 + (50 * rand.nextInt(5)));
				worldIn.setBlock(pos, state.setValue(BaseStage4_FaceWater.STAGE_1_4, Integer.valueOf(4)), 3); }
			
			if (i != 3) { } }

		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, Hakkou_Blocks.COLD_MILK.get(), 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.get().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2)), 3); }
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU.get());
	}
}
