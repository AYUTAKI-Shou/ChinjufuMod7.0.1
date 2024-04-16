package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Ami_Youshoku extends Base_YoushokuAmi {

	public Ami_Youshoku(Block.Properties properties) {
		super(properties);
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
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(1))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
								.with(AGE_1_12, Integer.valueOf(age - 3))
								.with(DOWN, state.get(DOWN))
								.with(UP, state.get(UP))
								.with(WAKE, state.get(WAKE))
								.with(WATERLOGGED, state.get(WATERLOGGED)), 3); }
					
					if (age < 4) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				}
				
				/** Not enough EXP **/
				if (playerIn.experienceTotal < 15) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} //COBWEB

			if (item == Items.COD_BUCKET) {
				if (state.get(WATERLOGGED)) {
					spawnCod(worldIn, pos);
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand); }
				
				if (!state.get(WATERLOGGED)) { CMEvents.textNoPlace(worldIn, pos, playerIn); }
			}
			
			if (item == Items.SALMON_BUCKET) {
				if (state.get(WATERLOGGED)) {
					spawnSalmon(worldIn, pos);
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand); }
				
				if (!state.get(WATERLOGGED)) { CMEvents.textNoPlace(worldIn, pos, playerIn); }
			}
			
			if (item == Items.TROPICAL_FISH_BUCKET) {
				if (state.get(WATERLOGGED)) {
					spawnTropicalFish(worldIn, pos);
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand); }
				
				if (!state.get(WATERLOGGED)) { CMEvents.textNoPlace(worldIn, pos, playerIn); }
			}
			
			if (item == Items_Teatime.YOUSHOKU_AMI) { return ActionResultType.FAIL; }
			
			if (item != Items_Teatime.YOUSHOKU_AMI && item != Items.STRING && item != Items_Seasonal.ORIITO && 
					item != Items.COD_BUCKET && item != Items.SALMON_BUCKET && item != Items.TROPICAL_FISH_BUCKET) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (stage != 5) { }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
	
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
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(2))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 11) &&
					(stack.getDamage() <= stack.getMaxDamage() - 10)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(3))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 10) &&
					(stack.getDamage() <= stack.getMaxDamage() - 9)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(4))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 9) &&
					(stack.getDamage() <= stack.getMaxDamage() - 8)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(5))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 8) &&
					(stack.getDamage() < stack.getMaxDamage() - 6)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(6))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if (stack.getDamage() == stack.getMaxDamage() - 6) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(7))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 6) &&
					(stack.getDamage() <= stack.getMaxDamage() - 5)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(8))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 5) &&
					(stack.getDamage() <= stack.getMaxDamage() - 4)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(9))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 4) &&
					(stack.getDamage() <= stack.getMaxDamage() - 3)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(10))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if ((stack.getDamage() > stack.getMaxDamage() - 3) &&
					(stack.getDamage() <= stack.getMaxDamage() - 2)) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(11))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			if (stack.getDamage() > stack.getMaxDamage() - 2) {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(12))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
			
			else {
				return this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
						.with(AGE_1_12, Integer.valueOf(1))
						.with(DOWN, connectThis(worldIn, pos, Direction.DOWN))
						.with(UP, connectAir(worldIn, pos, Direction.UP))
						.with(WAKE, Boolean.valueOf(false))
						.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)); }
		}
		
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
				.with(DOWN, connectThis(worldIn, pos1, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos1, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos2, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos2, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos2, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos3, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos3, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos3, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos4, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos4, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos4, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos6, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos6, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos6, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos7, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos7, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos7, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos8, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos8, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos8, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
		worldIn.setBlockState(pos9, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
				.with(AGE_1_12, Integer.valueOf(state.get(AGE_1_12)))
				.with(DOWN, connectThis(worldIn, pos9, Direction.DOWN))
				.with(UP, connectAir(worldIn, pos9, Direction.UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER)), 3);
	}
	
	/* Increase fish. */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int stage = state.get(STAGE_1_9);
		int age = state.get(AGE_1_12);
		boolean wake = state.get(WAKE);
		
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
						AxisAlignedBB AABB_SPAWN = new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1, pos.getZ() + 2);
						AxisAlignedBB AABB_CHECK = new AxisAlignedBB(pos.getX() - 1, pos.getY() - 0.5, pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1.5, pos.getZ() + 2);
						
						List<CodEntity> listCod = worldIn.getEntitiesWithinAABB(CodEntity.class, AABB_SPAWN);
						List<SalmonEntity> listSalmon = worldIn.getEntitiesWithinAABB(SalmonEntity.class, AABB_SPAWN);
						List<TropicalFishEntity> listTropicalFish = worldIn.getEntitiesWithinAABB(TropicalFishEntity.class, AABB_SPAWN);
						List<AbstractFishEntity> listFish = worldIn.getEntitiesWithinAABB(AbstractFishEntity.class, AABB_CHECK);
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
	ITextComponent codName = new TranslationTextComponent("name.farmedcod" );
	ITextComponent salmonName = new TranslationTextComponent("name.farmedsalmon");
	ITextComponent tropicalName = new TranslationTextComponent("name.farmedtropicalfish");
	
	/* Spawn fish */
	private void spawnCod(World worldIn, BlockPos pos) {
		CodEntity cod = new CodEntity(EntityType.COD, worldIn);
		cod.setPosition(pos.getX(), pos.getY(), pos.getZ());
		cod.setCustomName(codName);
		worldIn.addEntity(cod);
		CMEvents.soundFish(worldIn, pos);
	}
	
	private void spawnSalmon(World worldIn, BlockPos pos) {
		SalmonEntity salmon = new SalmonEntity(EntityType.SALMON, worldIn);
		salmon.setPosition(pos.getX(), pos.getY(), pos.getZ());
		salmon.setCustomName(salmonName);
		worldIn.addEntity(salmon);
		CMEvents.soundFish(worldIn, pos);
	}
	
	private void spawnTropicalFish(World worldIn, BlockPos pos) {
		TropicalFishEntity tropical = new TropicalFishEntity(EntityType.TROPICAL_FISH, worldIn);
		tropical.setPosition(pos.getX(), pos.getY(), pos.getZ());
		tropical.setCustomName(tropicalName);
		worldIn.addEntity(tropical);
		CMEvents.soundFish(worldIn, pos);
	}
	
	
	/* Net state changes. */
	private void agingNet(BlockState state, World worldIn, BlockPos pos) {
		int age = state.get(AGE_1_12);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		worldIn.setBlockState(pos, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(1))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
				.with(AGE_1_12, Integer.valueOf(age + 1))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(false))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
	}
	
	private void wakeUp(BlockState state, World worldIn, BlockPos pos) {
		int age = state.get(AGE_1_12);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		worldIn.setBlockState(pos, this.getDefaultState().with(STAGE_1_9, Integer.valueOf(5))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(1))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(2))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z - 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(3))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(4))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(6))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x - 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(7))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(8))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
		worldIn.setBlockState(new BlockPos(x + 1, y, z + 1), this.getDefaultState().with(STAGE_1_9, Integer.valueOf(9))
				.with(AGE_1_12, Integer.valueOf(age))
				.with(DOWN, state.get(DOWN))
				.with(UP, state.get(UP))
				.with(WAKE, Boolean.valueOf(true))
				.with(WATERLOGGED, state.get(WATERLOGGED)), 3);
	}
}
