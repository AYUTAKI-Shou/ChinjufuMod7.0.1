package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

public class Ami_Youshoku extends Base_YoushokuAmi {
	
	public Ami_Youshoku(BlockBehaviour.Properties properties) {
		super(properties);
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
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(1))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
								.setValue(AGE_1_12, Integer.valueOf(age - 3))
								.setValue(DOWN, state.getValue(DOWN))
								.setValue(UP, state.getValue(UP))
								.setValue(WAKE, state.getValue(WAKE))
								.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
					
					if (age < 4) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				}
				
				/** Not enough EXP **/
				if (playerIn.totalExperience < 15) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} //COBWEB

			if (item == Items.COD_BUCKET) {
				if (state.getValue(WATERLOGGED)) {
					spawnCod(worldIn, pos);
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand); }
				
				if (!state.getValue(WATERLOGGED)) { CMEvents.textNoPlace(worldIn, pos, playerIn); }
			}
			
			if (item == Items.SALMON_BUCKET) {
				if (state.getValue(WATERLOGGED)) {
					spawnSalmon(worldIn, pos);
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand); }
				
				if (!state.getValue(WATERLOGGED)) { CMEvents.textNoPlace(worldIn, pos, playerIn); }
			}
			
			if (item == Items.TROPICAL_FISH_BUCKET) {
				if (state.getValue(WATERLOGGED)) {
					spawnTropicalFish(worldIn, pos);
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand); }
				
				if (!state.getValue(WATERLOGGED)) { CMEvents.textNoPlace(worldIn, pos, playerIn); }
			}
			
			if (item == Items_Teatime.YOUSHOKU_AMI.get()) { return InteractionResult.FAIL; }
			
			if (item != Items_Teatime.YOUSHOKU_AMI.get() && item != Items_Seasonal.ORIITO.get() && item != Items.STRING && 
					item != Items.COD_BUCKET && item != Items.SALMON_BUCKET && item != Items.TROPICAL_FISH_BUCKET) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (stage != 5) { }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
	
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
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(2))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 11) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 10)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(3))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 10) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 9)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(4))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 9) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 8)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(5))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 8) &&
					(stack.getDamageValue() < stack.getMaxDamage() - 6)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(6))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if (stack.getDamageValue() == stack.getMaxDamage() - 6) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(7))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 6) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 5)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(8))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 5) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 4)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(9))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 4) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 3)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(10))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if ((stack.getDamageValue() > stack.getMaxDamage() - 3) &&
					(stack.getDamageValue() <= stack.getMaxDamage() - 2)) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(11))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			if (stack.getDamageValue() > stack.getMaxDamage() - 2) {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(12))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			else {
				return this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
						.setValue(AGE_1_12, Integer.valueOf(1))
						.setValue(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.setValue(UP, connectAir(worldIn, pos, Direction.UP))
						.setValue(WAKE, Boolean.valueOf(false))
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
		}
		
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
				.setValue(DOWN, connectThis(worldIn, pos1, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos1, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos2, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos2, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos2, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos3, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos3, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos3, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos4, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos4, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos4, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos6, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos6, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos6, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos7, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos7, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos7, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos8, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos8, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos8, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
		worldIn.setBlock(pos9, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
				.setValue(AGE_1_12, Integer.valueOf(state.getValue(AGE_1_12)))
				.setValue(DOWN, connectThis(worldIn, pos9, Direction.DOWN))
				.setValue(UP, connectAir(worldIn, pos9, Direction.UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)), 3);
	}
	
	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int stage = state.getValue(STAGE_1_9);
		int age = state.getValue(AGE_1_12);
		boolean wake = state.getValue(WAKE);
		
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
				if (!wake) {
					if (rand.nextInt(4) == 0) { wakeUp(state, worldIn, pos); } }
				
				if (wake) {
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
						AABB AABB_SPAWN = new AABB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1, pos.getZ() + 2);
						AABB AABB_CHECK = new AABB(pos.getX() - 1, pos.getY() - 0.5, pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1.5, pos.getZ() + 2);
						
						List<Cod> listCod = worldIn.getEntitiesOfClass(Cod.class, AABB_SPAWN);
						List<Salmon> listSalmon = worldIn.getEntitiesOfClass(Salmon.class, AABB_SPAWN);
						List<TropicalFish> listTropicalFish = worldIn.getEntitiesOfClass(TropicalFish.class, AABB_SPAWN);
						List<AbstractFish> listFish = worldIn.getEntitiesOfClass(AbstractFish.class, AABB_CHECK);
						/** age1=2, age2=3, age3=4, age4=5, age5=6, age6=7 **/
						
						if (listFish.size() >= 5) { }
						
						if (listFish.size() < 5) {
							if (listCod.size() >= 2 && rand.nextInt(4) == 0) {
								spawnCod(worldIn, pos);
								agingNet(state, worldIn, pos); }
							
							if (listSalmon.size() >= 2 && rand.nextInt(4) == 0) {
								spawnSalmon(worldIn, pos);
								agingNet(state, worldIn, pos); }

							if (listTropicalFish.size() >= 2 && rand.nextInt(4) == 0) {
								spawnTropicalFish(worldIn, pos);
								agingNet(state, worldIn, pos); } }
						break;
					case 12: break;
					} // switch AGE_1_12
				} //wake
			} // WATERLOGGED
			break;
		case 6: break;
		case 7: break;
		case 8: break;
		case 9: break;
		} // switch STAGE_1_9
	}
	
	/* Fish name */
	Component codName = Component.translatable("name.farmedcod" );
	Component salmonName = Component.translatable("name.farmedsalmon");
	Component tropicalName = Component.translatable("name.farmedtropicalfish");

	/* Spawn fish */
	private void spawnCod(Level worldIn, BlockPos pos) {
		Cod cod = new Cod(EntityType.COD, worldIn);
		cod.setPos(pos.getX(), pos.getY(), pos.getZ());
		cod.setCustomName(codName);
		worldIn.addFreshEntity(cod);
		CMEvents.soundFish(worldIn, pos);
	}
	
	private void spawnSalmon(Level worldIn, BlockPos pos) {
		Salmon salmon = new Salmon(EntityType.SALMON, worldIn);
		salmon.setPos(pos.getX(), pos.getY(), pos.getZ());
		salmon.setCustomName(salmonName);
		worldIn.addFreshEntity(salmon);
		CMEvents.soundFish(worldIn, pos);
	}
	
	private void spawnTropicalFish(Level worldIn, BlockPos pos) {
		TropicalFish tropical = new TropicalFish(EntityType.TROPICAL_FISH, worldIn);
		tropical.setPos(pos.getX(), pos.getY(), pos.getZ());
		tropical.setCustomName(tropicalName);
		worldIn.addFreshEntity(tropical);
		CMEvents.soundFish(worldIn, pos);
	}
	
	/* Net state changes. */
	private void agingNet(BlockState state, Level worldIn, BlockPos pos) {
		int age = state.getValue(AGE_1_12);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		worldIn.setBlock(pos, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(1))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
				.setValue(AGE_1_12, Integer.valueOf(age + 1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
	}
	
	private void wakeUp(BlockState state, Level worldIn, BlockPos pos) {
		int age = state.getValue(AGE_1_12);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		worldIn.setBlock(pos, this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(1))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(2))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z - 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(3))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(4))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(6))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x - 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(7))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(8))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		worldIn.setBlock(new BlockPos(x + 1, y, z + 1), this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(9))
				.setValue(AGE_1_12, Integer.valueOf(age))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(UP, state.getValue(UP))
				.setValue(WAKE, Boolean.valueOf(true))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
	}
}
