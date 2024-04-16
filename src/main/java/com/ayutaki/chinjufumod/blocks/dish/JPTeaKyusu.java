package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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

public class JPTeaKyusu extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(4.0D, 0.0D, 6.0D, 10.0D, 3.5D, 10.0D);
	protected static final VoxelShape AABB_WEST = Block.box(6.0D, 0.0D, 4.0D, 10.0D, 3.5D, 10.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(6.0D, 0.0D, 6.0D, 12.0D, 3.5D, 10.0D);
	protected static final VoxelShape AABB_EAST = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 3.5D, 12.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(4.0D, -8.0D, 2.0D, 10.0D, 0.1D, 6.0D);
	protected static final VoxelShape DOWN_WEST = Block.box(10.0D, -8.0D, 4.0D, 14.0D, 0.1D, 10.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(6.0D, -8.0D, 10.0D, 12.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_EAST = Block.box(2.0D, -8.0D, 6.0D, 6.0D, 0.1D, 12.0D);

	public JPTeaKyusu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_5);

		if (i != 5) {
			if (item == Items_Teatime.YUNOMI.get()) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_Tea(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.JPTEACUP.get())); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.JPTEACUP.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.JPTEACUP.get()), false); }
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3); }
			
			if (item != Items_Teatime.YUNOMI.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_5);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(5)), 3); }

			else { } }
		
		if (i == 5) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case NORTH:
		default:
			return flag? AABB_NORTH : DOWN_NORTH;
		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;
		case WEST:
			return flag? AABB_WEST : DOWN_WEST;
		case EAST:
			return flag? AABB_EAST : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.KYUSU.get());
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(new TranslatableComponent("tips.block_food_kyusu_1").withStyle(ChatFormatting.GRAY));
	}
}
