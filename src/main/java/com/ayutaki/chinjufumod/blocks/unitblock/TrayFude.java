package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrayFude extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty LOST = BooleanProperty.create("lost");
	
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(0.0D, -8.0D, 0.0D, 16.0D, 0.1D, 16.0D);
	
	public TrayFude(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(LOST, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		Direction direction = state.getValue(H_FACING);
		
		if (state.getValue(LOST) != true) {
			
			/* Battle report */
			if (item == Items_Chinjufu.SHOUHOU_empty.get()) {
				
				if (playerIn.totalExperience >= 100) {
					CMEvents.Consume1Item_Write(worldIn, pos, playerIn, hand);
					playerIn.giveExperiencePoints(-100);
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Chinjufu.SHOUHOU.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Chinjufu.SHOUHOU.get()))) {
						playerIn.drop(new ItemStack(Items_Chinjufu.SHOUHOU.get()), false); } }
				
				/** Not enough EXP **/
				if (playerIn.totalExperience < 100) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items_Chinjufu.SHOUHOU_empty
			
			
			/* Enchantbook 5 times */
			if (item == Items.BOOK) {
				
				if (playerIn.totalExperience >= 50) {
					BlockState northState = worldIn.getBlockState(pos.north());
					BlockState southState = worldIn.getBlockState(pos.south());
					BlockState eastState = worldIn.getBlockState(pos.east());
					BlockState westState = worldIn.getBlockState(pos.west());
					Block northBlock = northState.getBlock();
					Block southBlock = southState.getBlock();
					Block eastBlock = eastState.getBlock();
					Block westBlock = westState.getBlock();
					
					if (Config_CM.INSTANCE.useMAKIMONO.get() == true) {
						switch (direction) {
						case NORTH:
						default:
							/** left **/
							if (eastState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
										.setValue(WrittenMakimono.H_FACING, Direction.NORTH)
										.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
										.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
							
							if (!(eastState.canBeReplaced())) {
								if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && eastState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.east(), eastState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(eastState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
								
								/** front **/
								if (eastBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
										(eastBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && eastState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
									if (southState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
												.setValue(WrittenMakimono.H_FACING, Direction.NORTH)
												.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
												.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
									
									if (!(southState.canBeReplaced())) {
										if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && southState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.south(), southState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(southState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
										
										/** right **/
										if (southBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
												(southBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && southState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
											if (westState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
														.setValue(WrittenMakimono.H_FACING, Direction.NORTH)
														.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
														.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
											
											if (!(westState.canBeReplaced())) {
												if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && westState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.west(), westState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(westState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;

						case SOUTH:
							/** left **/
							if (westState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
										.setValue(WrittenMakimono.H_FACING, Direction.SOUTH)
										.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
										.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
							
							if (!(westState.canBeReplaced())) {
								if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && westState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.west(), westState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(westState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
								
								/** front **/
								if (westBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
										(westBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && westState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
									if (northState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
												.setValue(WrittenMakimono.H_FACING, Direction.SOUTH)
												.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
												.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
									
									if (!(northState.canBeReplaced())) {
										if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && northState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.north(), northState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(northState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
										
										/** right **/
										if (northBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
												(northBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && northState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
											if (eastState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
														.setValue(WrittenMakimono.H_FACING, Direction.SOUTH)
														.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
														.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
											
											if (!(eastState.canBeReplaced())) {
												if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && eastState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.east(), eastState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(eastState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;

						case EAST:
							/** left **/
							if (southState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
										.setValue(WrittenMakimono.H_FACING, Direction.EAST)
										.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
										.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
							
							if (!(southState.canBeReplaced())) {
								if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && southState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.south(), southState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(southState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
								
								/** front **/
								if (southBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
										(southBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && southState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
									if (westState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
												.setValue(WrittenMakimono.H_FACING, Direction.EAST)
												.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
												.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
									
									if (!(westState.canBeReplaced())) {
										if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && westState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.west(), westState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(westState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
										
										/** right **/
										if (westBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
												(westBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && westState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
											if (northState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
														.setValue(WrittenMakimono.H_FACING, Direction.EAST)
														.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
														.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
											
											if (!(northState.canBeReplaced())) {
												if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && northState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.north(), northState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(northState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;
							
						case WEST:
							/** left **/
							if (northState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
										.setValue(WrittenMakimono.H_FACING, Direction.WEST)
										.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
										.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
							
							if (!(northState.canBeReplaced())) {
								if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && northState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.north(), northState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(northState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
								
								/** front **/
								if (northBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
										(northBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && northState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
									if (eastState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
												.setValue(WrittenMakimono.H_FACING, Direction.WEST)
												.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
												.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
									
									if (!(eastState.canBeReplaced())) {
										if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && eastState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.east(), eastState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(eastState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
										
										/** right **/
										if (eastBlock != Unit_Blocks.WRITTEN_MAKIMONO.get() ||
												(eastBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && eastState.getValue(WrittenMakimono.STAGE_1_5) == 5)) {
											if (southState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.get().defaultBlockState()
														.setValue(WrittenMakimono.H_FACING, Direction.WEST)
														.setValue(WrittenMakimono.DOWN, state.getValue(WrittenMakimono.DOWN))
														.setValue(WrittenMakimono.WATERLOGGED, state.getValue(WrittenMakimono.WATERLOGGED)), 3); }
											
											if (!(southState.canBeReplaced())) {
												if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO.get() && southState.getValue(WrittenMakimono.STAGE_1_5) != 5) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.south(), southState.setValue(WrittenMakimono.STAGE_1_5, Integer.valueOf(southState.getValue(WrittenMakimono.STAGE_1_5) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;
						} // switch
					} // useMAKIMONO() == true
					
					
					if (Config_CM.INSTANCE.useMAKIMONO.get() != true) {
						switch (direction) {
						case NORTH:
						default:
							/** left **/
							if (eastState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
										.setValue(WrittenBook.H_FACING, Direction.NORTH)
										.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
										.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
							
							if (!(eastState.canBeReplaced())) {
								if (eastBlock == Unit_Blocks.WRITTEN_BOOK.get() && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.east(), eastState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (eastBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
										(eastBlock == Unit_Blocks.WRITTEN_BOOK.get() && eastState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (southState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
												.setValue(WrittenBook.H_FACING, Direction.NORTH)
												.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
												.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
									
									if (!(southState.canBeReplaced())) {
										if (southBlock == Unit_Blocks.WRITTEN_BOOK.get() && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.south(), southState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (southBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
												(southBlock == Unit_Blocks.WRITTEN_BOOK.get() && southState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (westState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
														.setValue(WrittenBook.H_FACING, Direction.NORTH)
														.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
														.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
											
											if (!(westState.canBeReplaced())) {
												if (westBlock == Unit_Blocks.WRITTEN_BOOK.get() && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.west(), westState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;

						case SOUTH:
							/** left **/
							if (westState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
										.setValue(WrittenBook.H_FACING, Direction.SOUTH)
										.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
										.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
							
							if (!(westState.canBeReplaced())) {
								if (westBlock == Unit_Blocks.WRITTEN_BOOK.get() && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.west(), westState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (westBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
										(westBlock == Unit_Blocks.WRITTEN_BOOK.get() && westState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (northState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
												.setValue(WrittenBook.H_FACING, Direction.SOUTH)
												.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
												.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
									
									if (!(northState.canBeReplaced())) {
										if (northBlock == Unit_Blocks.WRITTEN_BOOK.get() && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.north(), northState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (northBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
												(northBlock == Unit_Blocks.WRITTEN_BOOK.get() && northState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (eastState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
														.setValue(WrittenBook.H_FACING, Direction.SOUTH)
														.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
														.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
											
											if (!(eastState.canBeReplaced())) {
												if (eastBlock == Unit_Blocks.WRITTEN_BOOK.get() && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.east(), eastState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;

						case EAST:
							/** left **/
							if (southState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
										.setValue(WrittenBook.H_FACING, Direction.EAST)
										.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
										.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
							
							if (!(southState.canBeReplaced())) {
								if (southBlock == Unit_Blocks.WRITTEN_BOOK.get() && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.south(), southState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (southBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
										(southBlock == Unit_Blocks.WRITTEN_BOOK.get() && southState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (westState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
												.setValue(WrittenBook.H_FACING, Direction.EAST)
												.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
												.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
									
									if (!(westState.canBeReplaced())) {
										if (westBlock == Unit_Blocks.WRITTEN_BOOK.get() && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.west(), westState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (westBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
												(westBlock == Unit_Blocks.WRITTEN_BOOK.get() && westState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (northState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
														.setValue(WrittenBook.H_FACING, Direction.EAST)
														.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
														.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
											
											if (!(northState.canBeReplaced())) {
												if (northBlock == Unit_Blocks.WRITTEN_BOOK.get() && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.north(), northState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;
							
						case WEST:
							/** left **/
							if (northState.canBeReplaced()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
										.setValue(WrittenBook.H_FACING, Direction.WEST)
										.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
										.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
							
							if (!(northState.canBeReplaced())) {
								if (northBlock == Unit_Blocks.WRITTEN_BOOK.get() && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.north(), northState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (northBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
										(northBlock == Unit_Blocks.WRITTEN_BOOK.get() && northState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (eastState.canBeReplaced()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
												.setValue(WrittenBook.H_FACING, Direction.WEST)
												.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
												.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
									
									if (!(eastState.canBeReplaced())) {
										if (eastBlock == Unit_Blocks.WRITTEN_BOOK.get() && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.east(), eastState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (eastBlock != Unit_Blocks.WRITTEN_BOOK.get() ||
												(eastBlock == Unit_Blocks.WRITTEN_BOOK.get() && eastState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (southState.canBeReplaced()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_BOOK.get().defaultBlockState()
														.setValue(WrittenBook.H_FACING, Direction.WEST)
														.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
														.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
											
											if (!(southState.canBeReplaced())) {
												if (southBlock == Unit_Blocks.WRITTEN_BOOK.get() && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlock(pos.south(), southState.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
											}
										}
									}
								}
							}
							break;
						} // switch direction
					} // useMAKIMONO() != true
				} // totalExperience >= 50
				
				
				/** Not enough EXP **/
				if (playerIn.totalExperience < 50) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items.BOOK
			
			
			if (item != Items_Chinjufu.SHOUHOU_empty.get() && item != Items.BOOK) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		} //getValue(LOST) != true

		
		/** Waterlogged **/
		if (state.getValue(LOST) == true) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* Write Book */
	private void writebook(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		CMEvents.Consume1Item_Write(worldIn, pos, playerIn, hand);
		playerIn.giveExperiencePoints(-10); //戦闘詳報1冊=10連
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
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
	
	/* Connect the blocks. */
	protected boolean connectHalf(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockPos newPos = pos.relative(direct);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlab_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof Base_Slab_JP && state.getValue(Base_Slab_JP.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseTatami && state.getValue(BaseTatami.TYPE) == TatamiType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockPos newPos = pos.relative(direct);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlab_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof Base_Slab_JP && state.getValue(Base_Slab_JP.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseTatami && state.getValue(BaseTatami.TYPE) == TatamiType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.getValue(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.getValue(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.getValue(Kotatsu.WATERLOGGED)));
	}
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.scheduleTick(pos, Unit_Blocks.FUDETRAY.get(), Fluids.WATER.getTickDelay(worldIn)); }
		
		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Unit_Blocks.FUDETRAY.get(), 300); }
		
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.scheduleTick(pos, Unit_Blocks.FUDETRAY.get(), 300);
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, Unit_Blocks.FUDETRAY.get(), 300);
			worldIn.setBlock(pos, state.setValue(LOST, Boolean.valueOf(true)), 3); }
		
		else { }
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, WATERLOGGED, LOST);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB_BOX : AABB_DOWN;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_lettertray").withStyle(ChatFormatting.GRAY));
	}
}
