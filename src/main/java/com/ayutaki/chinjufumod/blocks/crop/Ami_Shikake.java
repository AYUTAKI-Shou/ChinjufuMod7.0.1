package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Ami_Shikake extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_9 = IntegerProperty.create("stage", 1, 9);
	public static final IntegerProperty AGE_1_12 = IntegerProperty.create("age", 1, 12);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	protected static final VoxelShape AABB_1 = Shapes.or(Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D),
			Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 4.0D),
			Block.box(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 13.0D),
			Block.box(12.0D, 0.0D, 0.0D, 13.0D, 16.0D, 4.0D),
			Block.box(3.0D, 0.0D, 4.0D, 4.0D, 16.0D, 12.0D),
			Block.box(0.0D, 0.0D, 12.0D, 1.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape AABB_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	protected static final VoxelShape AABB_2N = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_3 = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 1.0D),
			Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 4.0D),
			Block.box(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 13.0D),
			Block.box(3.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D),
			Block.box(12.0D, 0.0D, 4.0D, 13.0D, 16.0D, 12.0D),
			Block.box(15.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape AABB_4 = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_4W = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	
	protected static final VoxelShape AABB_5N = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D),
			Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_5S = Shapes.or(Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D),
			Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_5E = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D),
			Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_5W = Shapes.or(Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D));
	
	protected static final VoxelShape AABB_6 = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_6E = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape AABB_7 = Shapes.or(Block.box(13.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D),
			Block.box(3.0D, 0.0D, 12.0D, 13.0D, 16.0D, 13.0D),
			Block.box(0.0D, 0.0D, 3.0D, 4.0D, 16.0D, 4.0D),
			Block.box(12.0D, 0.0D, 12.0D, 13.0D, 16.0D, 16.0D),
			Block.box(3.0D, 0.0D, 4.0D, 4.0D, 16.0D, 12.0D),
			Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 4.0D));
	
	protected static final VoxelShape AABB_8 = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_8S = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_9 = Shapes.or(Block.box(0.0D, 0.0D, 15.0D, 3.0D, 16.0D, 16.0D),
			Block.box(3.0D, 0.0D, 12.0D, 13.0D, 16.0D, 13.0D),
			Block.box(12.0D, 0.0D, 3.0D, 16.0D, 16.0D, 4.0D),
			Block.box(3.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D),
			Block.box(12.0D, 0.0D, 4.0D, 13.0D, 16.0D, 12.0D),
			Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D));
	
	protected static final VoxelShape BOT_BASE = Block.box(0.0D, -1.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	
	protected static final VoxelShape BOTTOM_1 = Shapes.or(AABB_1, BOT_BASE);
	protected static final VoxelShape BOTTOM_2 = Shapes.or(AABB_2, BOT_BASE);
	protected static final VoxelShape BOTTOM_2N = Shapes.or(AABB_2N, BOT_BASE);
	protected static final VoxelShape BOTTOM_3 = Shapes.or(AABB_3, BOT_BASE);
	protected static final VoxelShape BOTTOM_4 = Shapes.or(AABB_4, BOT_BASE);
	protected static final VoxelShape BOTTOM_4W = Shapes.or(AABB_4W, BOT_BASE);
	protected static final VoxelShape BOTTOM_5N = Shapes.or(AABB_5N, BOT_BASE);
	protected static final VoxelShape BOTTOM_5S = Shapes.or(AABB_5S, BOT_BASE);
	protected static final VoxelShape BOTTOM_5E = Shapes.or(AABB_5E, BOT_BASE);
	protected static final VoxelShape BOTTOM_5W = Shapes.or(AABB_5W, BOT_BASE);
	protected static final VoxelShape BOTTOM_6 = Shapes.or(AABB_6, BOT_BASE);
	protected static final VoxelShape BOTTOM_6E = Shapes.or(AABB_6E, BOT_BASE);
	protected static final VoxelShape BOTTOM_7 = Shapes.or(AABB_7, BOT_BASE);
	protected static final VoxelShape BOTTOM_8 = Shapes.or(AABB_8, BOT_BASE);
	protected static final VoxelShape BOTTOM_8S = Shapes.or(AABB_8S, BOT_BASE);
	protected static final VoxelShape BOTTOM_9 = Shapes.or(AABB_9, BOT_BASE);
	
	public Ami_Shikake(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_9, Integer.valueOf(5))
				.setValue(AGE_1_12, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int stage = state.getValue(STAGE_1_9);
		int age = state.getValue(AGE_1_12);
		
		if (stage == 5) {
			
			if (item == Items.STRING || item == Items_Seasonal.ORIITO.get()) {
				
				/* 5 times */
				if (playerIn.totalExperience >= 15) {
					
					if (age >= 4) {
						CMEvents.Consume_1Item(playerIn, hand);
						CMEvents.soundWoolPlace(worldIn, pos);
						playerIn.giveExperiencePoints(-3);
						
						int x = (int) pos.getX();
						int y = (int) pos.getY();
						int z = (int) pos.getZ();
						
						worldIn.setBlock(pos, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(1))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
					
					if (age < 4) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				}
				
				/** Not enough EXP **/
				if (playerIn.totalExperience < 15) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			}
			
			if (item == Items_Teatime.SHIKAKE_AMI.get()) { return InteractionResult.FAIL; }
			
			if (item != Items_Teatime.SHIKAKE_AMI.get() && item != Items.STRING && item != Items_Seasonal.ORIITO.get()) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (stage != 5) { }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int stage = state.getValue(STAGE_1_9);
		
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
		case 9: return Shapes.empty();
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int stage = state.getValue(STAGE_1_9);
		boolean down = state.getValue(DOWN);
		
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
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		/** BoneMealItem 105, net.minecraft.data.worldgen.biome.Biomes Holder<Biome> **/
		Holder<Biome> biome = worldIn.getBiome(pos);
		/** || biome.is(Biomes.PLAIN) */
		if (biome.is(Biomes.WARM_OCEAN) || biome.is(Biomes.RIVER) ||
				biome.is(Biomes.COLD_OCEAN) || biome.is(Biomes.DEEP_COLD_OCEAN) ||
				biome.is(Biomes.FROZEN_OCEAN) || biome.is(Biomes.DEEP_FROZEN_OCEAN) || 
				biome.is(Biomes.OCEAN) || biome.is(Biomes.DEEP_OCEAN) || 
				biome.is(Biomes.LUKEWARM_OCEAN) || biome.is(Biomes.DEEP_LUKEWARM_OCEAN)) {
			
			ItemStack stack = context.getItemInHand();
			
			int x = (int) pos.getX();
			int y = (int) pos.getY();
			int z = (int) pos.getZ();
			
			if (worldIn.getBlockState(new BlockPos(x - 1, y, z - 1)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x + 1, y, z - 1)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x + 1, y, z + 1)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced(context) &&
					worldIn.getBlockState(new BlockPos(x - 1, y, z + 1)).canBeReplaced(context)) {

				if ((stack.getDamageValue() > stack.getMaxDamage() - 12) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 11)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(2))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 11) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 10)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(3))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 10) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 9)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(4))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 9) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 8)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(5))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 8) &&
						(stack.getDamageValue() < stack.getMaxDamage() - 6)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(6))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if (stack.getDamageValue() == stack.getMaxDamage() - 6) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(7))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 6) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 5)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(8))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 5) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 4)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(9))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 4) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 3)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(10))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if ((stack.getDamageValue() > stack.getMaxDamage() - 3) &&
						(stack.getDamageValue() <= stack.getMaxDamage() - 2)) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(11))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				if (stack.getDamageValue() > stack.getMaxDamage() - 2) {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
							.setValue(STAGE_1_9, Integer.valueOf(5))
							.setValue(AGE_1_12, Integer.valueOf(12))
							.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
							.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
				
				else {
					return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
						.setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(1))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			} // can Place
			
			else { 
				CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
				return null; }
			
		} // biome
		
		else { 
			CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
			return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	@Override
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		FluidState fluid = worldIn.getFluidState(pos);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
		BlockPos pos2 = new BlockPos(x, y, z - 1);
		BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
		BlockPos pos4 = new BlockPos(x - 1, y, z);
		BlockPos pos6 = new BlockPos(x + 1, y, z);
		BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
		BlockPos pos8 = new BlockPos(x, y, z + 1);
		BlockPos pos9 = new BlockPos(x + 1, y, z + 1);
		
		worldIn.setBlock(pos1, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(1))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos1, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos2, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos2, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos3, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos3, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos4, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos4, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos6, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos6, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos7, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos7, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos8, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos8, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos9, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, connectThis(worldIn, pos9, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
	}
	
	/* Connect the blocks. */
	protected boolean connectThis(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockPos newPos = pos.relative(direct);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return block instanceof Ami_Shikake;
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!state.canSurvive(worldIn, pos)) { return Blocks.AIR.defaultBlockState(); }

		boolean down = connectThis(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}
	
	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		Direction direction = state.getValue(H_FACING);
		int stage = state.getValue(STAGE_1_9);
		int age = state.getValue(AGE_1_12);
		
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }
		
		switch (stage) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5:
		default: 
			if (!state.getValue(WATERLOGGED)) {
				if (rand.nextInt(1) == 0) { worldIn.destroyBlock(pos, true); } }
			
			if (state.getValue(WATERLOGGED)) {
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
					AABB AABB_CHECK = new AABB(pos.getX() - 1, pos.getY() - 0.5, pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1.5, pos.getZ() + 2);
					List<AbstractFish> listFish = worldIn.getEntitiesOfClass(AbstractFish.class, AABB_CHECK);
					
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
	Component codName = Component.translatable("name.capturedcod");
	Component salmonName = Component.translatable("name.capturedsalmon");
	Component tropicalName = Component.translatable("name.capturedtropicalfish");
	
	/* Spawn fish */
	private void spawnFish(ServerLevel worldIn, BlockPos pos) {
		Holder<Biome> biome = worldIn.getBiome(pos);
		
		Cod cod = new Cod(EntityType.COD, worldIn);
		cod.setPos(pos.getX(), pos.getY(), pos.getZ());
		cod.setCustomName(codName);
		
		Salmon salmon = new Salmon(EntityType.SALMON, worldIn);
		salmon.setPos(pos.getX(), pos.getY(), pos.getZ());
		salmon.setCustomName(salmonName);
		
		TropicalFish tropical = new TropicalFish(EntityType.TROPICAL_FISH, worldIn);
		tropical.setPos(pos.getX(), pos.getY(), pos.getZ());
		tropical.setCustomName(tropicalName);
		
		CMEvents.soundFish(worldIn, pos);
		
		if (biome.is(Biomes.WARM_OCEAN)) { worldIn.addFreshEntity(tropical); }
			
		else if (biome.is(Biomes.RIVER) ||
					biome.is(Biomes.COLD_OCEAN) || biome.is(Biomes.DEEP_COLD_OCEAN) ||
					biome.is(Biomes.FROZEN_OCEAN) || biome.is(Biomes.DEEP_FROZEN_OCEAN)) {
					worldIn.addFreshEntity(salmon); }
		
		else if (biome.is(Biomes.OCEAN) || biome.is(Biomes.DEEP_OCEAN) || 
					biome.is(Biomes.LUKEWARM_OCEAN) || biome.is(Biomes.DEEP_LUKEWARM_OCEAN)) {
			worldIn.addFreshEntity(cod); }
	}
	
	/* Net state changes. */
	private void agingNet(BlockState state, Level worldIn, BlockPos pos) {
		int age = state.getValue(AGE_1_12);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		worldIn.setBlock(pos, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(1))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		int stage = state.getValue(STAGE_1_9);
		
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		if (stage == 1) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 2) { return worldIn.getBlockState(new BlockPos(x, y, z + 1)).getBlock() instanceof Ami_Shikake; }
		if (stage == 3) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 4) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 6) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 7) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Ami_Shikake; }
		if (stage == 8) { return worldIn.getBlockState(new BlockPos(x, y, z - 1)).getBlock() instanceof Ami_Shikake; }
		if (stage == 9) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Ami_Shikake; }
		return super.canSurvive(state, worldIn, pos);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE_1_12, DOWN, H_FACING, STAGE_1_9, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SHIKAKE_AMI.get());
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
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
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
}
