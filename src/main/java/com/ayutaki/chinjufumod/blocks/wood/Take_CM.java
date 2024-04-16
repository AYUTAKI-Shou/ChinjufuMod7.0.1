package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class Take_CM extends Block {

	/* Property */
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);
	/* Collision */
	protected static final AxisAlignedBB AABB_BOX = new AxisAlignedBB(0.40625D, 0.0D, 0.40625D, 0.59375D, 1.0D, 0.59375D);
			
	public Take_CM(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_15, Integer.valueOf(0)));
		setTickRandomly(true);
	}

	/* Check */
	private boolean checkDirt(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1)).getBlock();
		Block downBlock2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getBlock();
		Block downBlock3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1)).getBlock();
		Block downBlock4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getBlock();
		Block downBlock6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getBlock();
		Block downBlock7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1)).getBlock();
		Block downBlock8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getBlock();
		Block downBlock9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1)).getBlock();
		
		return (downBlock1 instanceof BlockDirt || downBlock1 instanceof BlockGrass || downBlock1 instanceof FallLeaf) ||
				(downBlock2 instanceof BlockDirt || downBlock2 instanceof BlockGrass || downBlock2 instanceof FallLeaf) ||
				(downBlock3 instanceof BlockDirt || downBlock3 instanceof BlockGrass || downBlock3 instanceof FallLeaf) ||
				(downBlock4 instanceof BlockDirt || downBlock4 instanceof BlockGrass || downBlock4 instanceof FallLeaf) ||
				(downBlock6 instanceof BlockDirt || downBlock6 instanceof BlockGrass || downBlock6 instanceof FallLeaf) ||
				(downBlock7 instanceof BlockDirt || downBlock7 instanceof BlockGrass || downBlock7 instanceof FallLeaf) ||
				(downBlock8 instanceof BlockDirt || downBlock8 instanceof BlockGrass || downBlock8 instanceof FallLeaf) ||
				(downBlock9 instanceof BlockDirt || downBlock9 instanceof BlockGrass || downBlock9 instanceof FallLeaf);
	}
	
	private boolean checkDirt1(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1)).getBlock();
		return (downBlock1 instanceof BlockDirt || downBlock1 instanceof BlockGrass || downBlock1 instanceof FallLeaf); }
	
	private boolean checkDirt2(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getBlock();
		return (downBlock2 instanceof BlockDirt || downBlock2 instanceof BlockGrass || downBlock2 instanceof FallLeaf); }
	
	private boolean checkDirt3(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1)).getBlock();
		return (downBlock3 instanceof BlockDirt || downBlock3 instanceof BlockGrass || downBlock3 instanceof FallLeaf); }
	
	private boolean checkDirt4(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getBlock();
		return (downBlock4 instanceof BlockDirt || downBlock4 instanceof BlockGrass || downBlock4 instanceof FallLeaf); }
	
	private boolean checkDirt6(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getBlock();
		return (downBlock6 instanceof BlockDirt || downBlock6 instanceof BlockGrass || downBlock6 instanceof FallLeaf); }
	
	private boolean checkDirt7(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1)).getBlock();
		return (downBlock7 instanceof BlockDirt || downBlock7 instanceof BlockGrass || downBlock7 instanceof FallLeaf); }
	
	private boolean checkDirt8(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getBlock();
		return (downBlock8 instanceof BlockDirt || downBlock8 instanceof BlockGrass || downBlock8 instanceof FallLeaf); }
	
	private boolean checkDirt9(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		Block downBlock9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1)).getBlock();
		return (downBlock9 instanceof BlockDirt || downBlock9 instanceof BlockGrass || downBlock9 instanceof FallLeaf); }
	
	private boolean checkSpace(IBlockState state, World worldIn, BlockPos pos) {
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
		IBlockState state1 = worldIn.getBlockState(pos1);
		IBlockState state2 = worldIn.getBlockState(pos2);
		IBlockState state3 = worldIn.getBlockState(pos3);
		IBlockState state4 = worldIn.getBlockState(pos4);
		IBlockState state6 = worldIn.getBlockState(pos6);
		IBlockState state7 = worldIn.getBlockState(pos7);
		IBlockState state8 = worldIn.getBlockState(pos8);
		IBlockState state9 = worldIn.getBlockState(pos9);
		
		return (state1.getMaterial().isReplaceable()) ||
				(state2.getMaterial().isReplaceable()) ||
				(state3.getMaterial().isReplaceable()) ||
				(state4.getMaterial().isReplaceable()) ||
				(state6.getMaterial().isReplaceable()) ||
				(state7.getMaterial().isReplaceable()) ||
				(state8.getMaterial().isReplaceable()) ||
				(state9.getMaterial().isReplaceable());
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		int i = state.getValue(STAGE_0_15);
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		
		if (i == 13 && (downBlock instanceof BlockDirt || downBlock instanceof BlockGrass || downBlock instanceof FallLeaf)) {
			if (this.checkDirt(state, worldIn, pos) && this.checkSpace(state, worldIn, pos)) {
				
				if ((item == Items.DYE && k == 15) || item == Items_Seasonal.WARAHAI) {
					CMEvents.Consume_1Item(playerIn, hand);
					
					for(int n = 0; n < 15; ++n) {
						double d0 = worldIn.rand.nextGaussian() * 0.02D;
						double d1 = worldIn.rand.nextGaussian() * 0.02D;
						double d2 = worldIn.rand.nextGaussian() * 0.02D;
						worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }

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
					
					IBlockState state1 = worldIn.getBlockState(pos1);
					IBlockState state2 = worldIn.getBlockState(pos2);
					IBlockState state3 = worldIn.getBlockState(pos3);
					IBlockState state4 = worldIn.getBlockState(pos4);
					IBlockState state6 = worldIn.getBlockState(pos6);
					IBlockState state7 = worldIn.getBlockState(pos7);
					IBlockState state8 = worldIn.getBlockState(pos8);
					IBlockState state9 = worldIn.getBlockState(pos9);
					
					IBlockState TAKENOKO = Seasonal_Blocks.TAKENOKO.getDefaultState();
					
					if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos1, TAKENOKO, 3); } }
					
					if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos2, TAKENOKO, 3); } }
					
					if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos3, TAKENOKO, 3); } }
					
					if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos4, TAKENOKO, 3); } }
					
					if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos6, TAKENOKO, 3); } }
					
					if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos7, TAKENOKO, 3); } }
					
					if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos8, TAKENOKO, 3); } }
					
					if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos9, TAKENOKO, 3); } }
				} //BONE_MEAL
			} // check
	
			if (!this.checkDirt(state, worldIn, pos) || !this.checkSpace(state, worldIn, pos)) {
				CMEvents.textNoPlace(worldIn, pos, playerIn);
			} // !check
		}//downBlock
		
		return true;
	}
	
	/* Update BlockState. */
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		int i = state.getValue(STAGE_0_15);
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		Block upBlock = worldIn.getBlockState(pos.up()).getBlock();
		return (i > 10)? ((downBlock instanceof BlockDirt || downBlock instanceof BlockGrass || downBlock instanceof FallLeaf || downBlock instanceof Take_CM) && upBlock instanceof Take_CM) : downBlock instanceof Take_CM;
	}
	
	protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!this.canBlockStay(worldIn, pos, state)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
		this.checkAndDropBlock(worldIn, pos, state);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		int i = state.getValue(STAGE_0_15);
		int jump6 = (rand.nextInt(2) == 0)? 6 : i + 1;
		int jump10 = (rand.nextInt(2) == 0)? 10 : i + 1;
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		
		if (!worldIn.isAreaLoaded(pos, 1)) return; 
		
		this.checkAndDropBlock(worldIn, pos, state);
		
		if (this.canBlockStay(worldIn, pos, state)) {
			switch (i) {
			case 0 :
			default :
				if (downBlock == Seasonal_Blocks.TAKENOKO) {
					worldIn.setBlockState(pos.down(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(11)), 3); }
				
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(12)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;

			case 1 :
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(11)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(12)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;

			case 2 :
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos.down(2), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos.down(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 3 :
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(2), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 4 :
				if (this.putJungle(worldIn, pos)) {
					if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
						worldIn.setBlockState(pos.down(2), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
						worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
						worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				} //putJungle
				
				if (!this.putJungle(worldIn, pos)) {
					if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
						worldIn.setBlockState(pos.down(2), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
						worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
						worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(jump6)), 3); }
				} //!putJungle
				break;

			case 5 :
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(2), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos.down(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 6 :
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 7 :
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos.down(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(jump10)), 3); }
				break;

			case 8 :
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(jump10)), 3); }
				break;
				
			case 9 :
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos.down(2), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlockState(pos.up(1), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 10 : break;				
			case 11 : break;
			case 12 : break;
				
			case 13 :
				if (downBlock instanceof BlockDirt || downBlock instanceof BlockGrass || downBlock instanceof FallLeaf) {
					
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
					
					IBlockState state1 = worldIn.getBlockState(pos1);
					IBlockState state2 = worldIn.getBlockState(pos2);
					IBlockState state3 = worldIn.getBlockState(pos3);
					IBlockState state4 = worldIn.getBlockState(pos4);
					IBlockState state6 = worldIn.getBlockState(pos6);
					IBlockState state7 = worldIn.getBlockState(pos7);
					IBlockState state8 = worldIn.getBlockState(pos8);
					IBlockState state9 = worldIn.getBlockState(pos9);
					
					IBlockState TAKENOKO = Seasonal_Blocks.TAKENOKO.getDefaultState();
					
					if (this.countBamboo(state, worldIn, pos) < 7) {
						
						if (!worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos1, TAKENOKO, 3); } }
							
							if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos9, TAKENOKO, 3); } }
						} //!isRaining()
						
						if (worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos1, TAKENOKO, 3); } }
							
							if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos9, TAKENOKO, 3); } }
						} //isRaining()
					} //< 7
					
					if (this.countBamboo(state, worldIn, pos) >= 7) { } //>= 7
				} //SpreadableSnowyDirtBlock
				break;

			case 14 : break;
			case 15 : break;
			} // switch
		}
	}
	
	private boolean putJungle(World worldIn, BlockPos pos) {
		Biome biome = worldIn.getBiome(pos);
		return (biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_HILLS || biome == Biomes.JUNGLE_EDGE);
	}
	
	private boolean airLight(World worldIn, BlockPos pos) {
		return worldIn.isAirBlock(pos.up()) && worldIn.getLightFromNeighbors(pos.up()) >= 9;
	}
	
	private int countBamboo(IBlockState state, World worldIn, BlockPos pos) {
		int count = 0;
		for (int rangeX = -3; rangeX <= 3; rangeX++) {
			for (int rangeZ = -3; rangeZ <= 3; rangeZ++) {
				if (worldIn.getBlockState(pos.add(rangeX, 0, rangeZ)).getBlock() instanceof Take_CM) {
					count++; }
				
				if (worldIn.getBlockState(pos.add(rangeX, 0, rangeZ)).getBlock() instanceof Takenoko) {
					count++; }
			}
		}
		return count;
	}
	
	/* Collision */
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB_BOX.offset(state.getOffset(source, pos));
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}
	
	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_15 });
	}

	/* Rendering */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
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
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Seasonal.TAKE, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Seasonal.TAKENOKO);
	}

}

