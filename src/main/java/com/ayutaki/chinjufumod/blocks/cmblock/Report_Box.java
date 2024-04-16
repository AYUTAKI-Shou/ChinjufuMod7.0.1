package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Report_Box extends Block {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_15 = IntegerProperty.create("stage", 1, 15);
	/* 1=E, 2=B, 3=R, 4=P, 5=N, 6=-1, 7=N, 8=-2, 9=N, 10=-3, 11=N, 12=-4, 13=N, 14=-5, 15=N */
	public Report_Box(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_15, Integer.valueOf(1)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(STAGE_1_15, Integer.valueOf(1));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_15);
		int gc = stack.getCount();
		boolean mode = playerIn.abilities.isCreativeMode;
		
		Direction direction = state.get(H_FACING);

		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());
		
		boolean wait = (i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		
		switch (direction) {
		case NORTH:
		default:
			if (!northState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (northState.getMaterial().isReplaceable()) {
				if (northState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(northState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					

					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;

		case SOUTH:
			if (!southState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (southState.getMaterial().isReplaceable()) {
				if (southState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(southState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;

		case EAST:
			if (!eastState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (eastState.getMaterial().isReplaceable()) {
				if (eastState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(eastState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;
			
		case WEST:
			if (!westState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (westState.getMaterial().isReplaceable()) {
				if (westState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(westState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;
		} // switch
		
		return ActionResultType.SUCCESS;
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.REPORT_BOX, 120);
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		int i = state.get(STAGE_1_15);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		if (repo) { worldIn.getPendingBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.REPORT_BOX, 120); }
	}

	protected void dropOrder(BlockState state, ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_Chinjufu.WORK_ORDER, 5);
		
		Direction direction = state.get(H_FACING);
		double sn = (direction == Direction.SOUTH)? 1.2D : ((direction == Direction.NORTH)? - 0.7D : 0.0D); 
		double ew = (direction == Direction.EAST)? 1.2D : ((direction == Direction.WEST)? - 0.7D : 0.0D);
		
		InventoryHelper.spawnItemStack(worldIn, pos.getX() + ew, pos.getY() + 0.5D, pos.getZ() + sn, stack);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_15);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		
		if (repo) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.REPORT_BOX, 120);
			worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			this.dropOrder(state, worldIn, pos); 
			
			if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
			if (i == 15) { worldIn.setBlockState(pos, state.with(STAGE_1_15, Integer.valueOf(1)), 3); }
		}

		else { }
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_15);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		
		if (repo) {
			for(int k = 0; k < 5; ++k) {
				double x = pos.getX();
				double y = pos.getY();
				double z = pos.getZ();
				worldIn.playSound(x, y, z, SoundEvents_CM.NOISE, SoundCategory.BLOCKS, 0.5F, 1.0F, false); } }
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, STAGE_1_15);
	}
	
	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_report_box").applyTextStyle(TextFormatting.GRAY));
	}
}
