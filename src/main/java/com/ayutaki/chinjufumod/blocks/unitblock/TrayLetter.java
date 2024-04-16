package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TrayLetter extends Block {

	/* Property */
	public static final PropertyInteger STAGE_1_2 = PropertyInteger.create("stage", 1, 2);
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	/* Collision */
	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.03125D, 1.0D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.0D, -0.5D, 0.0D, 1.0D, 0.01D, 1.0D);

	public TrayLetter(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(STAGE_1_2, Integer.valueOf(1))
				.withProperty(DOWN, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		EnumFacing direction = state.getValue(H_FACING);
		
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		
		if (playerIn.experienceTotal >= 100) {
			/* Battle report */
			if (item == Items_Chinjufu.SHOUHOU_empty) {
				CMEvents.Consume1Item_Write(worldIn, pos, playerIn, hand);
				playerIn.addExperience(-100);
				
				if (stack.isEmpty()) { 
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU))) {
					playerIn.dropItem(new ItemStack(Items_Chinjufu.SHOUHOU), false); }
			} // item == Items_Chinjufu.SHOUHOU_empty
			
			
			/* Enchantbook */
			if (item == Items.BOOK) {
				
				IBlockState northState = worldIn.getBlockState(pos.north());
				IBlockState southState = worldIn.getBlockState(pos.south());
				IBlockState eastState = worldIn.getBlockState(pos.east());
				IBlockState westState = worldIn.getBlockState(pos.west());
				Block northBlock = northState.getBlock();
				Block southBlock = southState.getBlock();
				Block eastBlock = eastState.getBlock();
				Block westBlock = westState.getBlock();
				
				switch (i) {
				case 1 :
				default :
					
					switch (direction) {
					case NORTH :
					default:
						/** left **/
						if (eastState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(eastState.getMaterial().isReplaceable())) {
							if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (eastBlock != Unit_Blocks.WRITTEN_BOOK ||
									(eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (southState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(southState.getMaterial().isReplaceable())) {
									if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (southBlock != Unit_Blocks.WRITTEN_BOOK ||
											(southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (westState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(westState.getMaterial().isReplaceable())) {
											if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
									}
								}
							}
						}
						break;
					
					case SOUTH :
						/** left **/
						if (westState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(westState.getMaterial().isReplaceable())) {
							if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (westBlock != Unit_Blocks.WRITTEN_BOOK ||
									(westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (northState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(northState.getMaterial().isReplaceable())) {
									if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (northBlock != Unit_Blocks.WRITTEN_BOOK ||
											(northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (eastState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(eastState.getMaterial().isReplaceable())) {
											if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
									} /** right **/
								}
							} /** front **/
						} /** left **/
						break;
					
					case EAST :
						/** left **/
						if (southState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(southState.getMaterial().isReplaceable())) {
							if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (southBlock != Unit_Blocks.WRITTEN_BOOK ||
									(southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (westState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(westState.getMaterial().isReplaceable())) {
									if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (westBlock != Unit_Blocks.WRITTEN_BOOK ||
											(westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (northState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(northState.getMaterial().isReplaceable())) {
											if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
									}
								}
							}
						}
						break;
						
					case WEST :
						/** left **/
						if (northState.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(northState.getMaterial().isReplaceable())) {
							if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (northBlock != Unit_Blocks.WRITTEN_BOOK ||
									(northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (eastState.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(eastState.getMaterial().isReplaceable())) {
									if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (eastBlock != Unit_Blocks.WRITTEN_BOOK ||
											(eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (southState.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(southState.getMaterial().isReplaceable())) {
											if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
									}
								}
							}
						}
						break;
					} // direction
					
					break;

				///// Fude Tray ////////////////////////////////////////////////////////////////////////////////////////////////////
				case 2 :
					if (!Config_CM.useMAKIMONO) {
						switch (direction) {
						case NORTH :
						default:
							/** left **/
							if (eastState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(eastState.getMaterial().isReplaceable())) {
								if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (eastBlock != Unit_Blocks.WRITTEN_BOOK ||
										(eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (southState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(southState.getMaterial().isReplaceable())) {
										if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (southBlock != Unit_Blocks.WRITTEN_BOOK ||
												(southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (westState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(westState.getMaterial().isReplaceable())) {
												if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						
						case SOUTH :
							/** left **/
							if (westState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(westState.getMaterial().isReplaceable())) {
								if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (westBlock != Unit_Blocks.WRITTEN_BOOK ||
										(westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (northState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(northState.getMaterial().isReplaceable())) {
										if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (northBlock != Unit_Blocks.WRITTEN_BOOK ||
												(northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (eastState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(eastState.getMaterial().isReplaceable())) {
												if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										} /** right **/
									}
								} /** front **/
							} /** left **/
							break;
						
						case EAST :
							/** left **/
							if (southState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(southState.getMaterial().isReplaceable())) {
								if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (southBlock != Unit_Blocks.WRITTEN_BOOK ||
										(southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (westState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(westState.getMaterial().isReplaceable())) {
										if (westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (westBlock != Unit_Blocks.WRITTEN_BOOK ||
												(westBlock == Unit_Blocks.WRITTEN_BOOK && westState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (northState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(northState.getMaterial().isReplaceable())) {
												if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
							
						case WEST :
							/** left **/
							if (northState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(northState.getMaterial().isReplaceable())) {
								if (northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (northBlock != Unit_Blocks.WRITTEN_BOOK ||
										(northBlock == Unit_Blocks.WRITTEN_BOOK && northState.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (eastState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(eastState.getMaterial().isReplaceable())) {
										if (eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (eastBlock != Unit_Blocks.WRITTEN_BOOK ||
												(eastBlock == Unit_Blocks.WRITTEN_BOOK && eastState.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (southState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(southState.getMaterial().isReplaceable())) {
												if (southBlock == Unit_Blocks.WRITTEN_BOOK && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						} // direction
					} // useMAKIMONO == false
					
					///// use MAKIMONO ////////////////////////////////////////////////////////////////////////////////////////////////////
					if (Config_CM.useMAKIMONO) {
						switch (direction) {
						case NORTH :
						default:
							/** left **/
							if (eastState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(eastState.getMaterial().isReplaceable())) {
								if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO && eastState.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (eastBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (southState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(southState.getMaterial().isReplaceable())) {
										if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO && southState.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (southBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (westState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(westState.getMaterial().isReplaceable())) {
												if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO && westState.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (westBlock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						
						case SOUTH :
							/** left **/
							if (westState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(westState.getMaterial().isReplaceable())) {
								if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO && westState.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (westBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (northState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(northState.getMaterial().isReplaceable())) {
										if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO && northState.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (northBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (eastState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(eastState.getMaterial().isReplaceable())) {
												if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO && eastState.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (eastBlock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										} /** right **/
									}
								} /** front **/
							} /** left **/
							break;
						
						case EAST :
							/** left **/
							if (southState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(southState.getMaterial().isReplaceable())) {
								if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO && southState.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (southBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (westState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(westState.getMaterial().isReplaceable())) {
										if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO && westState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), westState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(westState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (westBlock == Unit_Blocks.WRITTEN_MAKIMONO && westState.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (westBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (northState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(northState.getMaterial().isReplaceable())) {
												if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO && northState.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (northBlock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
							
						case WEST :
							/** left **/
							if (northState.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(northState.getMaterial().isReplaceable())) {
								if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO && northState.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), northState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (northBlock == Unit_Blocks.WRITTEN_MAKIMONO && northState.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (northBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (eastState.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(eastState.getMaterial().isReplaceable())) {
										if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO && eastState.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), eastState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eastState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (eastBlock == Unit_Blocks.WRITTEN_MAKIMONO && eastState.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (eastBlock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (southState.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(southState.getMaterial().isReplaceable())) {
												if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO && southState.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.south(), southState.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southState.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (southBlock == Unit_Blocks.WRITTEN_MAKIMONO && southState.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (southBlock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						} // direction
					} // useMAKIMONO == true
					
					break;
				} // STAGE_1_2
				

			} // item == Items.BOOK
			
			if (item != Items_Chinjufu.SHOUHOU_empty && item != Items.BOOK) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** Not enough EXP **/
		if (playerIn.experienceTotal < 100) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
		
		return true;
	}
	
	/* Write Book */
	private void writebook(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		CMEvents.Consume1Item_Write(worldIn, pos, playerIn, hand);
		playerIn.addExperience(-10); //戦闘詳報1冊=10連
	}
	
	/* BlockState when it was placed. */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(STAGE_1_2)).intValue() - 1 << 2;
		return i;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(STAGE_1_2, Integer.valueOf(1 + (meta >> 2)));
	}

	/*Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down = true : false **/
		return flag? AABB : AABB_DOWN;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** ぶつからないブロックになる **/
		return NULL_AABB;
	}

	/* Reaction to Neighboring blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		return block instanceof Chabudai || block instanceof LowDesk || block instanceof Kotatsu ||
					block instanceof Chabudai_sub || block instanceof LowDesk_sub || block instanceof Kotatsu_sub ||
					(block instanceof BaseFacingSlabW && state.getValue(BaseFacingSlabW.HALF) == SlabHalf.BOTTOM && state.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabW && state.getValue(BaseSlabW.HALF) == SlabHalf.BOTTOM && state.getValue(BaseSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabWType2 && state.getValue(BaseSlabWType2.HALF) == SlabHalf.BOTTOM && state.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(block instanceof BlockHalfWoodSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlabNew && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()));
	}

	/*Create BlockStates in this block. */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, DOWN, STAGE_1_2 });
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Render */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		if (i == 1) { return new ItemStack(Items_Chinjufu.LETTERTRAY, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Chinjufu.LETTERTRAY, 1, 2); }
		return null;
	}
}
