package com.ayutaki.chinjufumod.blocks.season;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/* FallingBlock. When this falls, the only drop is this ItemBlock. */
public class SnowCore extends BlockFalling {

	public static final PropertyInteger STAGE_0_9 = PropertyInteger.create("stage", 0, 9);
	
	/* Collision */
	protected static final AxisAlignedBB AABB_01 = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.3125D, 0.625D);
	protected static final AxisAlignedBB AABB_23 = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.4375D, 0.6875D);
	protected static final AxisAlignedBB AABB_45 = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.5625D, 0.6875D);
	protected static final AxisAlignedBB AABB_67 = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.6875D, 0.75D);
	protected static final AxisAlignedBB AABB_89 = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.8125D, 0.8125D);
	protected static final AxisAlignedBB COLL_89 = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 1.0D, 0.8125D);
	
	public SnowCore(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		
		setSoundType(SoundType.SNOW);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_9, Integer.valueOf(0)));
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.SNOW;
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();
		EnumFacing playerfacing = playerIn.getHorizontalFacing();
		
		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();
		
		IBlockState airState = Blocks.AIR.getDefaultState();
		Block SNOW = Blocks.SNOW_LAYER;
		IBlockState placeSNOW = SNOW.getDefaultState().withProperty(BlockSnow.LAYERS, Integer.valueOf(1));
		Block SNOWCORE = Seasonal_Blocks.SNOWCORE;
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {
			
			if (i <= 7) {
				switch (playerfacing) {
				case NORTH :
				default :
					if (northBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.north(), state.withProperty(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (northBlock != SNOW) {
						if (northState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.north(), state.withProperty(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!northState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;

				case SOUTH :
					if (southBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.south(), state.withProperty(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (southBlock != SNOW) {
						if (southState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.south(), state.withProperty(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!southState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;

				case EAST :
					if (eastBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.east(), state.withProperty(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (eastBlock != SNOW) {
						if (eastState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.east(), state.withProperty(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!eastState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
					
				case WEST :
					if (westBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.west(), state.withProperty(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (westBlock != SNOW) {
						if (westState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.west(), state.withProperty(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!westState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
				} // switch playerfacing
			} //i <= 7
			
			
			if (i == 8) {
				switch (playerfacing) {
				case NORTH :
				default :
					if (northBlock == SNOWCORE) {
						if (northState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (northState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (northBlock != SNOWCORE) {
						if (northBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.north(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northBlock != SNOW) {
							if (northState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.north(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case SOUTH :
					if (southBlock == SNOWCORE) {
						if (southState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (southState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (southBlock != SNOWCORE) {
						if (southBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.south(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southBlock != SNOW) {
							if (southState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.south(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case EAST :
					if (eastBlock == SNOWCORE) {
						if (eastState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (eastState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (eastBlock != SNOWCORE) {
						if (eastBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.east(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastBlock != SNOW) {
							if (eastState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.east(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eastState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST :
					if (westBlock == SNOWCORE) {
						if (westState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (westState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (westBlock != SNOWCORE) {
						if (westBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.west(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westBlock != SNOW) {
							if (westState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.west(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!westState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch playerfacing
			} //i == 8
	
			
			if (i == 9) {
				switch (playerfacing) {
				case NORTH :
				default :
					if (northBlock == SNOWCORE) {
						if (northState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (northState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.SOUTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (northBlock != SNOWCORE) {
						if (northBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.north(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northBlock != SNOW) {
							if (northState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.north(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case SOUTH :
					if (southBlock == SNOWCORE) {
						if (southState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (southState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.NORTH)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (southBlock != SNOWCORE) {
						if (southBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.south(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southBlock != SNOW) {
							if (southState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.south(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case EAST :
					if (eastBlock == SNOWCORE) {
						if (eastState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (eastState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.WEST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (eastBlock != SNOWCORE) {
						if (eastBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.east(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastBlock != SNOW) {
							if (eastState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.east(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eastState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST :
					if (westBlock == SNOWCORE) {
						if (westState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (westState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
									.withProperty(Base_SnowManBot.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
									.withProperty(Base_SnowManTop.H_FACING, EnumFacing.EAST)
									.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
					} // make SNOUMAN
					
					if (westBlock != SNOWCORE) {
						if (westBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.west(), state.withProperty(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westBlock != SNOW) {
							if (westState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.west(), state.withProperty(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!westState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch playerfacing
			} //i == 9
		}/** Hand is empty. **/
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();

		switch (i) {
		case 0 :
		default :
		case 1 : return AABB_01;
		case 2 :
		case 3 : return AABB_23;
		case 4 :
		case 5 : return AABB_45;
		case 6 :
		case 7 : return AABB_67; 
		case 8 :
		case 9 : return AABB_89;
		} // STAGE_0_9
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();
		
		switch (i) {
		case 0 :
		default :
		case 1 : 
		case 2 :
		case 3 : 
		case 4 :
		case 5 : 
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, NULL_AABB);
			break;
		case 6 :
		case 7 : 
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_67);
			break;
		case 8 :
		case 9 : 
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, COLL_89);
			break;
		} // STAGE_0_9
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

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_9, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_9)).intValue();
	}
	
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_9 });
	}

	/* TickRandom */
	private boolean hasHeat(World worldIn, BlockPos pos) {
		for(BlockPos nearpos : BlockPos.getAllInBoxMutable(pos.add(-2, -1, -2), pos.add(2, 1, 2))) {
			IBlockState nearstate = worldIn.getBlockState(nearpos);
			Block nearblock = nearstate.getBlock();

			if (nearblock == Blocks.LAVA || nearblock == Blocks.MAGMA ||
					nearblock instanceof BlockFire || nearblock == Blocks.LIT_FURNACE ||
					nearblock == Furniture_Blocks.LIT_CSTOVE_top || 
					nearblock == Kitchen_Blocks.LIT_KITOVEN || nearblock == Kitchen_Blocks.LIT_KITOVEN_B || 
					nearblock == Kitchen_Blocks.LIT_IRORI || nearblock == Kitchen_Blocks.LIT_KITSTOVE) {
				return true; }
		}
		return false;
	}
	
	@Override
	public void observedNeighborChange(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (this.hasHeat(worldIn, pos)) { worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn)); }
	}
	
	private boolean hasAtama(World worldIn, BlockPos pos) {
		IBlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		return (upBlock instanceof SnowCore && upState.getValue(STAGE_0_9) >= 8);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		
		if (((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0) || 
				hasAtama(worldIn, pos) || downBlock instanceof BlockLiquid) {
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn)); }
		
		else { worldIn.scheduleUpdate(pos, this, 200); }
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
			
		int i = state.getValue(STAGE_0_9);
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();

		if (downBlock == Blocks.ICE || downBlock == Blocks.PACKED_ICE || downBlock == Blocks.SNOW) { }
	
		if (downBlock != Blocks.ICE && downBlock != Blocks.PACKED_ICE && downBlock != Blocks.SNOW) {
			
			if (this.hasHeat(worldIn, pos)) {
				worldIn.scheduleUpdate(pos, this, 200);
				breakBlock(state, worldIn, pos); }
			
			if (!this.hasHeat(worldIn, pos)) {
				/** Plain 0.8F, Jungle 0.9F, Desert 2.0F **/
				if (worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
					worldIn.scheduleUpdate(pos, this, 200);
					breakBlock(state, worldIn, pos); }
				
				if (worldIn.getBiome(pos).getTemperature(pos) <= 0.85F) { }
			} //!hasHeat
		}
		
		if (!worldIn.isRemote) { this.checkFallable(worldIn, pos); }
		
		if (hasAtama(worldIn, pos)) {
			if (i <= 7) { }
			
			if (i == 8) {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, EnumFacing.SOUTH)
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
				worldIn.setBlockState(pos.up(), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
						.withProperty(Base_SnowManTop.H_FACING, EnumFacing.SOUTH)
						.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
		
			if (i == 9) {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, EnumFacing.SOUTH)
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
				worldIn.setBlockState(pos.up(), Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
						.withProperty(Base_SnowManTop.H_FACING, EnumFacing.SOUTH)
						.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3); }
		}
		
		if (downBlock instanceof BlockLiquid) {
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			worldIn.destroyBlock(pos, true); }
	}
	
	private void breakBlock(IBlockState state, World worldIn, BlockPos pos) {
		int i = state.getValue(STAGE_0_9);
		if (i != 0) { 
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_0_9, Integer.valueOf(i - 1)), 3); }
		if (i == 0) { worldIn.destroyBlock(pos, true); }
	}
	
	private void checkFallable(World worldIn, BlockPos pos) {
		if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0) {

			if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32))) {
				if (!worldIn.isRemote) {
					EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
					this.onStartFalling(entityfallingblock);
					worldIn.spawnEntity(entityfallingblock); }
			}
			
			else {
				IBlockState state = worldIn.getBlockState(pos);
				worldIn.setBlockToAir(pos);
				BlockPos pos1;

				for (pos1 = pos.down(); (worldIn.isAirBlock(pos1) || canFallThrough(worldIn.getBlockState(pos1))) && pos1.getY() > 0; pos1 = pos1.down()) { ; }

				if (pos1.getY() > 0) {
					worldIn.setBlockState(pos1.up(), state); //Forge: Fix loss of state information during world gen.
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState state) {
		return 15792895;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Seasonal.SNOWCORE));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Seasonal.SNOWCORE);
	}
}
