package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Ami_Shikake extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_9 = IntegerProperty.create("stage", 1, 9);
	public static final IntegerProperty AGE_1_12 = IntegerProperty.create("age", 1, 12);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	protected static final VoxelShape AABB_1 = VoxelShapes.or(Block.makeCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 4.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 13.0D, 16.0D, 4.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 4.0D, 4.0D, 16.0D, 12.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 1.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape AABB_2 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	protected static final VoxelShape AABB_2N = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_3 = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 1.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 4.0D),
			Block.makeCuboidShape(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D),
			Block.makeCuboidShape(12.0D, 0.0D, 4.0D, 13.0D, 16.0D, 12.0D),
			Block.makeCuboidShape(15.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape AABB_4 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_4W = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	
	protected static final VoxelShape AABB_5N = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_5S = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_5E = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D),
			Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_5W = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape AABB_6 = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_6E = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape AABB_7 = VoxelShapes.or(Block.makeCuboidShape(13.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 12.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 4.0D, 16.0D, 4.0D),
			Block.makeCuboidShape(12.0D, 0.0D, 12.0D, 13.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 4.0D, 4.0D, 16.0D, 12.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 4.0D));
	
	protected static final VoxelShape AABB_8 = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_8S = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_9 = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 3.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 12.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(12.0D, 0.0D, 3.0D, 16.0D, 16.0D, 4.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(12.0D, 0.0D, 4.0D, 13.0D, 16.0D, 12.0D),
			Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D));
	
	protected static final VoxelShape BOT_BASE = Block.makeCuboidShape(0.0D, -1.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	
	protected static final VoxelShape BOTTOM_1 = VoxelShapes.or(AABB_1, BOT_BASE);
	protected static final VoxelShape BOTTOM_2 = VoxelShapes.or(AABB_2, BOT_BASE);
	protected static final VoxelShape BOTTOM_2N = VoxelShapes.or(AABB_2N, BOT_BASE);
	protected static final VoxelShape BOTTOM_3 = VoxelShapes.or(AABB_3, BOT_BASE);
	protected static final VoxelShape BOTTOM_4 = VoxelShapes.or(AABB_4, BOT_BASE);
	protected static final VoxelShape BOTTOM_4W = VoxelShapes.or(AABB_4W, BOT_BASE);
	protected static final VoxelShape BOTTOM_5N = VoxelShapes.or(AABB_5N, BOT_BASE);
	protected static final VoxelShape BOTTOM_5S = VoxelShapes.or(AABB_5S, BOT_BASE);
	protected static final VoxelShape BOTTOM_5E = VoxelShapes.or(AABB_5E, BOT_BASE);
	protected static final VoxelShape BOTTOM_5W = VoxelShapes.or(AABB_5W, BOT_BASE);
	protected static final VoxelShape BOTTOM_6 = VoxelShapes.or(AABB_6, BOT_BASE);
	protected static final VoxelShape BOTTOM_6E = VoxelShapes.or(AABB_6E, BOT_BASE);
	protected static final VoxelShape BOTTOM_7 = VoxelShapes.or(AABB_7, BOT_BASE);
	protected static final VoxelShape BOTTOM_8 = VoxelShapes.or(AABB_8, BOT_BASE);
	protected static final VoxelShape BOTTOM_8S = VoxelShapes.or(AABB_8S, BOT_BASE);
	protected static final VoxelShape BOTTOM_9 = VoxelShapes.or(AABB_9, BOT_BASE);
	
	public Ami_Shikake(Block.Properties properties) {
		super(properties);
		
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_9, Integer.valueOf(5))
				.with(AGE_1_12, Integer.valueOf(1))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int stage = state.get(STAGE_1_9);
		int age = state.get(AGE_1_12);
		
		if (stage == 5) {
			
			if (item == Items.STRING || item == Items_Seasonal.ORIITO) {
				
				/* 5 times */
				if (playerIn.experienceTotal >= 15) {
					
					if (age >= 4) {
						CMEvents.Consume_1Item(playerIn, hand);
						CMEvents.soundWoolPlace(worldIn, pos);
						playerIn.giveExperiencePoints(-3);
						
						double x = (double) pos.getX();
						double y = (double) pos.getY();
						double z = (double) pos.getZ();
						
						worldIn.setBlockState(pos, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(1))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(H_FACING, state.get(H_FACING))
								.with(DOWN, state.get(DOWN))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3); }
					
					if (age < 4) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				}
				
				/** Not enough EXP **/
				if (playerIn.experienceTotal < 15) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			}
			
			if (item == Items_Teatime.SHIKAKE_AMI) { return ActionResultType.FAIL; }
			
			if (item != Items_Teatime.SHIKAKE_AMI && item != Items.STRING && item != Items_Seasonal.ORIITO) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (stage != 5) { }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int stage = state.get(STAGE_1_9);
		
		switch (stage) {
		case 5:
		default: return AABB_BOX;
		case 1:
		case 2:
		case 3:
		case 4:
		case 6:
		case 7:
		case 8:
		case 9: return VoxelShapes.empty();
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int stage = state.get(STAGE_1_9);
		boolean down = state.get(DOWN);
		
		if (down == false) {
			switch (stage) {
			case 1:
			default: return BOTTOM_1;
			case 2: 
				switch (direction) {
				case NORTH:
				default: return BOTTOM_2N;
				case SOUTH: return BOTTOM_2;
				case EAST: return BOTTOM_2;
				case WEST: return BOTTOM_2;
				}
			case 3: return BOTTOM_3;
			case 4: 
				switch (direction) {
				case NORTH:
				default: return BOTTOM_4;
				case SOUTH: return BOTTOM_4;
				case EAST: return BOTTOM_4;
				case WEST: return BOTTOM_4W;
				}
			case 5: 
				switch (direction) {
				case NORTH:
				default: return BOTTOM_5N;
				case SOUTH: return BOTTOM_5S;
				case EAST: return BOTTOM_5E;
				case WEST: return BOTTOM_5W;
				}
			case 6: 
				switch (direction) {
				case NORTH:
				default: return BOTTOM_6;
				case SOUTH: return BOTTOM_6;
				case EAST: return BOTTOM_6E;
				case WEST: return BOTTOM_6;
				}
			case 7: return BOTTOM_7;
			case 8: 
				switch (direction) {
				case NORTH:
				default: return BOTTOM_8;
				case SOUTH: return BOTTOM_8S;
				case EAST: return BOTTOM_8;
				case WEST: return BOTTOM_8;
				}
			case 9: return BOTTOM_9;
			}
		} // down == false
		
		else {
			switch (stage) {
			case 1:
			default: return AABB_1;
			case 2: 
				switch (direction) {
				case NORTH:
				default: return AABB_2N;
				case SOUTH: return AABB_2;
				case EAST: return AABB_2;
				case WEST: return AABB_2;
				}
			case 3: return AABB_3;
			case 4: 
				switch (direction) {
				case NORTH:
				default: return AABB_4;
				case SOUTH: return AABB_4;
				case EAST: return AABB_4;
				case WEST: return AABB_4W;
				}
			case 5: 
				switch (direction) {
				case NORTH:
				default: return AABB_5N;
				case SOUTH: return AABB_5S;
				case EAST: return AABB_5E;
				case WEST: return AABB_5W;
				}
			case 6: 
				switch (direction) {
				case NORTH:
				default: return AABB_6;
				case SOUTH: return AABB_6;
				case EAST: return AABB_6E;
				case WEST: return AABB_6;
				}
			case 7: return AABB_7;
			case 8: 
				switch (direction) {
				case NORTH:
				default: return AABB_8;
				case SOUTH: return AABB_8S;
				case EAST: return AABB_8;
				case WEST: return AABB_8;
				}
			case 9: return AABB_9;
			}
		}
	}
	
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		Biome biome = worldIn.getBiome(pos);
		
		if (biome == Biomes.WARM_OCEAN || biome == Biomes.DEEP_WARM_OCEAN ||
				biome == Biomes.RIVER || biome == Biomes.COLD_OCEAN || biome == Biomes.DEEP_COLD_OCEAN ||
				biome == Biomes.FROZEN_OCEAN || biome == Biomes.DEEP_FROZEN_OCEAN ||
				biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN ||
				biome == Biomes.LUKEWARM_OCEAN || biome == Biomes.DEEP_LUKEWARM_OCEAN) {
			
			ItemStack stack = context.getItem();
			
			double x = (double) pos.getX();
			double y = (double) pos.getY();
			double z = (double) pos.getZ();
			
			if (worldIn.getBlockState(new BlockPos(x - 1, y, z - 1)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x, y, z - 1)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x + 1, y, z - 1)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x + 1, y, z)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x - 1, y, z)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x + 1, y, z + 1)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x, y, z + 1)).isReplaceable(context) &&
					worldIn.getBlockState(new BlockPos(x - 1, y, z + 1)).isReplaceable(context)) {

				if ((stack.getDamage() > stack.getMaxDamage() - 12) &&
						(stack.getDamage() <= stack.getMaxDamage() - 11)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(2))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 11) &&
						(stack.getDamage() <= stack.getMaxDamage() - 10)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(3))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 10) &&
						(stack.getDamage() <= stack.getMaxDamage() - 9)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(4))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 9) &&
						(stack.getDamage() <= stack.getMaxDamage() - 8)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(5))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 8) &&
						(stack.getDamage() < stack.getMaxDamage() - 6)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(6))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if (stack.getDamage() == stack.getMaxDamage() - 6) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(7))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 6) &&
						(stack.getDamage() <= stack.getMaxDamage() - 5)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(8))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 5) &&
						(stack.getDamage() <= stack.getMaxDamage() - 4)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(9))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 4) &&
						(stack.getDamage() <= stack.getMaxDamage() - 3)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(10))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if ((stack.getDamage() > stack.getMaxDamage() - 3) &&
						(stack.getDamage() <= stack.getMaxDamage() - 2)) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(11))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				if (stack.getDamage() > stack.getMaxDamage() - 2) {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
							.with(STAGE_1_9, Integer.valueOf(5))
							.with(AGE_1_12, Integer.valueOf(12))
							.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
				
				else {
					return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
						.with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(1))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			} // NoPlace
			
			else { 
				CMEvents.textNoPlace(context.getWorld(), context.getPos(), context.getPlayer());
				return null; }
		} //biome

		else { 
			CMEvents.textNoPlace(context.getWorld(), context.getPos(), context.getPlayer());
			return null; }
	}

	/* Add other Blocks. */
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluid = worldIn.getFluidState(pos);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
		BlockPos pos2 = new BlockPos(x, y, z - 1);
		BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
		BlockPos pos4 = new BlockPos(x - 1, y, z);
		BlockPos pos6 = new BlockPos(x + 1, y, z);
		BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
		BlockPos pos8 = new BlockPos(x, y, z + 1);
		BlockPos pos9 = new BlockPos(x + 1, y, z + 1);
		
		worldIn.setBlockState(pos1, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(1))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos1, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos2, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos2, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos3, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos3, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos4, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos4, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos6, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos6, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos7, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos7, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos8, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos8, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos9, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, connectThis(worldIn, pos9, Direction.DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
	}
	
	/* Connect the blocks. */
	protected boolean connectThis(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return block instanceof Ami_Shikake;
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
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		if (!state.isValidPosition(worldIn, pos)) { return Blocks.AIR.getDefaultState(); }
		
		boolean down = connectThis(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		Direction direction = state.get(H_FACING);
		int stage = state.get(STAGE_1_9);
		int age = state.get(AGE_1_12);
		
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }
	
		switch (stage) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5:
		default: 
			if (!state.get(WATERLOGGED)) {
				if (rand.nextInt(1) == 0) { worldIn.destroyBlock(pos, true); } }
			
			if (state.get(WATERLOGGED)) {
				switch (age) {
				case 1:
				default:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
					AxisAlignedBB AABB_CHECK = new AxisAlignedBB(pos.getX() - 1, pos.getY() - 0.5, pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1.5, pos.getZ() + 2);
					List<AbstractFishEntity> listFish = worldIn.getEntitiesWithinAABB(AbstractFishEntity.class, AABB_CHECK);
					
					if (listFish.size() >= 5) { }
					
					if (listFish.size() < 5) {
						switch (direction) {
						case NORTH:
						default:
							if (worldIn.getBlockState(pos.north(2)).getBlock() == Blocks.WATER) {
								if (rand.nextInt(4) == 0) {
									spawnFish(worldIn, pos);
									agingNet(state, worldIn, pos); } }
							
							if (worldIn.getBlockState(pos.north(2)).getBlock() != Blocks.WATER) { }
							break;

						case SOUTH:
							if (worldIn.getBlockState(pos.south(2)).getBlock() == Blocks.WATER) {
								if (rand.nextInt(4) == 0) {
									spawnFish(worldIn, pos);
									agingNet(state, worldIn, pos); } }
							
							if (worldIn.getBlockState(pos.south(2)).getBlock() != Blocks.WATER) { }
							break;

						case EAST:
							if (worldIn.getBlockState(pos.east(2)).getBlock() == Blocks.WATER) {
								if (rand.nextInt(4) == 0) {
									spawnFish(worldIn, pos);
									agingNet(state, worldIn, pos); } }
							
							if (worldIn.getBlockState(pos.east(2)).getBlock() != Blocks.WATER) { }
							break;
							
						case WEST:
							if (worldIn.getBlockState(pos.west(2)).getBlock() == Blocks.WATER) {
								if (rand.nextInt(4) == 0) {
									spawnFish(worldIn, pos);
									agingNet(state, worldIn, pos); } }
							
							if (worldIn.getBlockState(pos.west(2)).getBlock() != Blocks.WATER) { }
							break;
						} // switch direction
					}//size() < 5
					break;
				case 12: break;
				} // switch AGE_1_12
			} // WATERLOGGED
			break;
		case 6: break;
		case 7: break;
		case 8: break;
		case 9: break;
		} // switch STAGE_1_9
	}
	
	/* Fish name */
	ITextComponent codName = new TranslationTextComponent("name.capturedcod");
	ITextComponent salmonName = new TranslationTextComponent("name.capturedsalmon");
	ITextComponent tropicalName = new TranslationTextComponent("name.capturedtropicalfish");
	
	/* Spawn fish */
	private void spawnFish(ServerWorld worldIn, BlockPos pos) {
		Biome biome = worldIn.getBiome(pos);
		
		CodEntity cod = new CodEntity(EntityType.COD, worldIn);
		cod.setPosition(pos.getX(), pos.getY(), pos.getZ());
		cod.setCustomName(codName);
		
		SalmonEntity salmon = new SalmonEntity(EntityType.SALMON, worldIn);
		salmon.setPosition(pos.getX(), pos.getY(), pos.getZ());
		salmon.setCustomName(salmonName);
		
		TropicalFishEntity tropical = new TropicalFishEntity(EntityType.TROPICAL_FISH, worldIn);
		tropical.setPosition(pos.getX(), pos.getY(), pos.getZ());
		tropical.setCustomName(tropicalName);
		
		CMEvents.soundFish(worldIn, pos);
		
		if (biome == Biomes.WARM_OCEAN || biome == Biomes.DEEP_WARM_OCEAN) {
				worldIn.addEntity(tropical); }

		else if (biome == Biomes.RIVER || biome == Biomes.COLD_OCEAN || biome == Biomes.DEEP_COLD_OCEAN ||
				biome == Biomes.FROZEN_OCEAN || biome == Biomes.DEEP_FROZEN_OCEAN) {
			worldIn.addEntity(salmon); }
		
		else if (biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN ||
				biome == Biomes.LUKEWARM_OCEAN || biome == Biomes.DEEP_LUKEWARM_OCEAN) {
			worldIn.addEntity(cod); }
	}
	
	private void agingNet(BlockState state, ServerWorld worldIn, BlockPos pos) {
		int age = state.get(AGE_1_12);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		worldIn.setBlockState(pos, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(1))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(H_FACING, state.get(H_FACING))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		int stage = state.get(STAGE_1_9);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		if (stage == 1) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 2) { return worldIn.getBlockState(new BlockPos(x, y, z + 1)).getBlock() instanceof Ami_Shikake; }
		if (stage == 3) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 4) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 6) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 7) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 8) { return worldIn.getBlockState(new BlockPos(x, y, z - 1)).getBlock() instanceof Ami_Shikake; }
		if (stage == 9) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Ami_Shikake; }
		return super.isValidPosition(state, worldIn, pos);
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(AGE_1_12, DOWN, H_FACING, STAGE_1_9, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SHIKAKE_AMI);
	}
	
	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		BlockState state1 = worldIn.getBlockState(new BlockPos(x - 1, y, z - 1));
		BlockState state2 = worldIn.getBlockState(new BlockPos(x, y, z - 1));
		BlockState state3 = worldIn.getBlockState(new BlockPos(x + 1, y, z - 1));
		BlockState state4 = worldIn.getBlockState(new BlockPos(x - 1, y, z));
		BlockState state6 = worldIn.getBlockState(new BlockPos(x + 1, y, z));
		BlockState state7 = worldIn.getBlockState(new BlockPos(x - 1, y, z + 1));
		BlockState state8 = worldIn.getBlockState(new BlockPos(x, y, z + 1));
		BlockState state9 = worldIn.getBlockState(new BlockPos(x + 1, y, z + 1));

		/** False is not Drop. **/
		if (state1.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x - 1, y, z - 1), false); }
		if (state2.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x, y, z - 1), false); }
		if (state3.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x + 1, y, z - 1), false); }
		if (state4.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x - 1, y, z), false); }
		if (state6.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x + 1, y, z), false); }
		if (state7.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x - 1, y, z + 1), false); }
		if (state8.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x, y, z + 1), false); }
		if (state9.getBlock() instanceof Ami_Shikake) { worldIn.destroyBlock(new BlockPos(x + 1, y, z + 1), false); }
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
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
