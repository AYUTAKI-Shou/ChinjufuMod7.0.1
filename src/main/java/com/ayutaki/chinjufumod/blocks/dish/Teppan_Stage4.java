package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.furnace.AbstractOvenBlock;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Teppan_Stage4 extends BaseTeppan {

	protected static final int COOK_TIME = 700;
	/* Property */
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	/* Collision */
	private static final VoxelShape AABB_BOX = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 1.0D, 13.5D);
	
	public Teppan_Stage4(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_4);
		/** 1=raw, 2=re, 3=soba, 4=sauce **/
		boolean yakiSoba = (this == Dish_Blocks.YAKISOBA_nama) || (this == Dish_Blocks.YAKISOBASHIO_nama);
		
		if (yakiSoba && i == 4) {
			if (item == Items_Teatime.SARA) {
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
				
				if (stack.isEmpty()) { playerIn.inventory.add(this.takeOkonomi()); }
				else if (!playerIn.inventory.add(this.takeOkonomi())) { playerIn.drop(this.takeOkonomi(), false); }

				worldIn.setBlock(pos, Dish_Blocks.OKONOMIC_nama.defaultBlockState()
						.setValue(H_FACING,state.getValue(H_FACING))
						.setValue(DOWN,state.getValue(DOWN))
						.setValue(WATERLOGGED,state.getValue(WATERLOGGED))
						.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				if (item != Items_Teatime.SARA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		else { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	private ItemStack takeOkonomi() {
		if (this == Dish_Blocks.YAKISOBA_nama) { return new ItemStack(Items_Teatime.YAKISOBA, 1); }
		if (this == Dish_Blocks.YAKISOBASHIO_nama) { return new ItemStack(Items_Teatime.YAKISOBASHIO, 1); }
		return null;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		BlockState downState = worldIn.getBlockState(pos.below());
		Block downBlock = downState.getBlock();
		boolean teppan = (downBlock instanceof AbstractOvenBlock || downBlock instanceof Kit_Cooktop);
		
		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(teppan))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Update BlockState. */
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if(!inWater(state, worldIn, pos) && isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * worldIn.getRandom().nextInt(3))); }
	
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60); }

		boolean down = connectTeppan(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {

		if(!inWater(state, worldIn, pos) && isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * worldIn.random.nextInt(3))); }
	
		if (inWater(state, worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, this, 60); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);
		boolean yakiSoba = (this == Dish_Blocks.YAKISOBA_nama) || (this == Dish_Blocks.YAKISOBASHIO_nama);
		
		if (!inWater(state, worldIn, pos)) {
			if (yakiSoba && i == 4) { }
			
			else { 
				if (isCooking(worldIn, pos)) {
					worldIn.setBlock(pos, this.toClick().defaultBlockState()
							.setValue(H_FACING,state.getValue(H_FACING))
							.setValue(DOWN,state.getValue(DOWN))
							.setValue(WATERLOGGED,state.getValue(WATERLOGGED))
							.setValue(STAGE_1_4, Integer.valueOf(i)), 3);
					CMEvents.soundKotePlace(worldIn, pos);
					worldIn.getBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(3))); }
				
				if (!this.isCooking(worldIn, pos)) { }
			}
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.OKONOMIC_nama.defaultBlockState()
					.setValue(H_FACING,state.getValue(H_FACING))
					.setValue(DOWN,state.getValue(DOWN))
					.setValue(WATERLOGGED,state.getValue(WATERLOGGED))
					.setValue(STAGE_1_4, Integer.valueOf(4)), 3);
			this.dropRottenfood(worldIn, pos); }
	}

	private Block toClick() {
		if (this == Dish_Blocks.OKONOMISOBA_nama) { return Dish_Blocks.OKONOMISOBA_click; }
		if (this == Dish_Blocks.OKONOMISOBAS_nama) { return Dish_Blocks.OKONOMISOBAS_click; }
		if (this == Dish_Blocks.OKONOMISOBAC_nama) { return Dish_Blocks.OKONOMISOBAC_click; }
		if (this == Dish_Blocks.YAKISOBA_nama) { return Dish_Blocks.YAKISOBA_click; }
		if (this == Dish_Blocks.YAKISOBASHIO_nama) { return Dish_Blocks.YAKISOBASHIO_click; }
		return null;
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, STAGE_1_4, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}
	
	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (this.isCooking(worldIn, pos)) {
			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, SoundEvents_CM.JUU, SoundCategory.BLOCKS, 0.2F, 1.0F, false); }
			
			if (i != 1 && rand.nextDouble() < 0.25D) {
				worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6 - 0.3D, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
		
		if (!this.isCooking(worldIn, pos)) { }
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.OKONOMISOBA_nama) { return new ItemStack(Items_Teatime.OKONOMISOBA_nama, 1); }
		if (this == Dish_Blocks.OKONOMISOBAS_nama) { return new ItemStack(Items_Teatime.OKONOMISOBAS_nama, 1); }
		if (this == Dish_Blocks.OKONOMISOBAC_nama) { return new ItemStack(Items_Teatime.OKONOMISOBAC_nama, 1); }
		if (this == Dish_Blocks.YAKISOBA_nama) { return new ItemStack(Items_Teatime.YAKISOBA_nama, 1); }
		if (this == Dish_Blocks.YAKISOBASHIO_nama) { return new ItemStack(Items_Teatime.YAKISOBASHIO_nama, 1); }
		return null;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_frypan").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_food_frypan_sara").withStyle(TextFormatting.GRAY));
	}
}
