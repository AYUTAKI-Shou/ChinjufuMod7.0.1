package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
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
import net.minecraftforge.common.ToolType;

public class TrayLetter extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty LOST = BooleanProperty.create("lost");
	
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, 0.1D, 16.0D);

	public TrayLetter(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false))
				.with(LOST, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		Direction direction = state.get(H_FACING);
		
		if (state.get(LOST) != true) {
			
			/* Battle report */
			if (item == Items_Chinjufu.SHOUHOU_empty) {
				
				if (playerIn.experienceTotal >= 100) {
					CMEvents.Consume1Item_Write(worldIn, pos, playerIn, hand);
					playerIn.giveExperiencePoints(-100);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU))) {
						playerIn.dropItem(new ItemStack(Items_Chinjufu.SHOUHOU), false); }
				}

				/** Not enough EXP **/
				if (playerIn.experienceTotal < 100) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items_Chinjufu.SHOUHOU_empty
			
			
			/* Enchantbook 5 times */
			if (item == Items.BOOK) {
				
				if (playerIn.experienceTotal >= 50) {
					
					BlockState northState = worldIn.getBlockState(pos.north());
					BlockState southState = worldIn.getBlockState(pos.south());
					BlockState eastState = worldIn.getBlockState(pos.east());
					BlockState westState = worldIn.getBlockState(pos.west());
					Block northBlock = northState.getBlock();
					Block southBlock = southState.getBlock();
					Block eastBlock = eastState.getBlock();
					Block westBlock = westState.getBlock();
					
					switch (direction) {
					case NORTH:
					default:
						/** left **/
						if (eastState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.NORTH)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(eastState.getMaterial().isReplaceable())) {
							if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), eastState.with(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (eastBlock != Unit_Blocks.WRITTEN_BOOK ||
									(eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.get(WrittenBook.STAGE_1_4) == 4)) {
								if (southState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.NORTH)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(southState.getMaterial().isReplaceable())) {
									if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), southState.with(WrittenBook.STAGE_1_4, Integer.valueOf(southState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (southBlock != Unit_Blocks.WRITTEN_BOOK ||
											(southBlock == Unit_Blocks.WRITTEN_BOOK && southState.get(WrittenBook.STAGE_1_4) == 4)) {
										if (westState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.NORTH)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(westState.getMaterial().isReplaceable())) {
											if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), westState.with(WrittenBook.STAGE_1_4, Integer.valueOf(westState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;

					case SOUTH:
						/** left **/
						if (westState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.SOUTH)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(westState.getMaterial().isReplaceable())) {
							if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), westState.with(WrittenBook.STAGE_1_4, Integer.valueOf(westState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (westBlock != Unit_Blocks.WRITTEN_BOOK ||
									(westBlock == Unit_Blocks.WRITTEN_BOOK && westState.get(WrittenBook.STAGE_1_4) == 4)) {
								if (northState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.SOUTH)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(northState.getMaterial().isReplaceable())) {
									if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), northState.with(WrittenBook.STAGE_1_4, Integer.valueOf(northState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (northBlock != Unit_Blocks.WRITTEN_BOOK ||
											(northBlock == Unit_Blocks.WRITTEN_BOOK && northState.get(WrittenBook.STAGE_1_4) == 4)) {
										if (eastState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.SOUTH)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(eastState.getMaterial().isReplaceable())) {
											if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), eastState.with(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;

					case EAST:
						/** left **/
						if (southState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.EAST)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(southState.getMaterial().isReplaceable())) {
							if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), southState.with(WrittenBook.STAGE_1_4, Integer.valueOf(southState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (southBlock != Unit_Blocks.WRITTEN_BOOK ||
									(southBlock == Unit_Blocks.WRITTEN_BOOK && southState.get(WrittenBook.STAGE_1_4) == 4)) {
								if (westState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.EAST)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(westState.getMaterial().isReplaceable())) {
									if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), westState.with(WrittenBook.STAGE_1_4, Integer.valueOf(westState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (westBlock != Unit_Blocks.WRITTEN_BOOK ||
											(westBlock == Unit_Blocks.WRITTEN_BOOK && westState.get(WrittenBook.STAGE_1_4) == 4)) {
										if (northState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.EAST)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(northState.getMaterial().isReplaceable())) {
											if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), northState.with(WrittenBook.STAGE_1_4, Integer.valueOf(northState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;
						
					case WEST:
						/** left **/
						if (northState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.WEST)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(northState.getMaterial().isReplaceable())) {
							if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), northState.with(WrittenBook.STAGE_1_4, Integer.valueOf(northState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (northBlock != Unit_Blocks.WRITTEN_BOOK ||
									(northBlock == Unit_Blocks.WRITTEN_BOOK && northState.get(WrittenBook.STAGE_1_4) == 4)) {
								if (eastState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.WEST)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(eastState.getMaterial().isReplaceable())) {
									if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), eastState.with(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (eastBlock != Unit_Blocks.WRITTEN_BOOK ||
											(eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.get(WrittenBook.STAGE_1_4) == 4)) {
										if (southState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.WEST)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(southState.getMaterial().isReplaceable())) {
											if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), southState.with(WrittenBook.STAGE_1_4, Integer.valueOf(southState.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;
					} // switch direction
				} // totalExperience >= 50
				
				/** Not enough EXP **/
				if (playerIn.experienceTotal < 50) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items.BOOK
			
			if (item != Items_Chinjufu.SHOUHOU_empty && item != Items.BOOK) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
		} //get(LOST) != true
		
		/** Waterlogged **/
		if (state.get(LOST) == true) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Write Book */
	private void writebook(World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand) {
		CMEvents.Consume1Item_Write(worldIn, pos, playerIn, hand);
		playerIn.giveExperiencePoints(-10); //戦闘詳報1冊=10連
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
				.with(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN));
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
	
	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlab_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof Base_Slab_JP && state.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseTatami && state.get(BaseTatami.TYPE) == TatamiType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlab_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof Base_Slab_JP && state.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseTatami && state.get(BaseTatami.TYPE) == TatamiType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.get(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.get(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.get(Kotatsu.WATERLOGGED)));
	}
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.LETTERTRAY, Fluids.WATER.getTickRate(worldIn)); }
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.LETTERTRAY, 300); }
		
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.LETTERTRAY, 300);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.LETTERTRAY, 300);
			worldIn.setBlockState(pos, state.with(LOST, Boolean.valueOf(true)), 3); }
		
		else { }
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DOWN, H_FACING, WATERLOGGED, LOST);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB_BOX : AABB_DOWN;
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
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_lettertray").applyTextStyle(TextFormatting.GRAY));
	}
}
