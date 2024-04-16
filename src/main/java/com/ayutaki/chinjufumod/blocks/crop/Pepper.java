package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
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

public class Pepper extends Block {

	/* Property 0 1 2 3 4. 5 6 (7), top 8 9 10 11 12. 13 14 (15) */
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);

	public Pepper(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);

		setTickRandomly(true);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_15, Integer.valueOf(0)));
	}

	/* RandomTick */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		
		if (!worldIn.isAreaLoaded(pos, 1)) return;
		
		if (i <= 7) {
			IBlockState upState = worldIn.getBlockState(pos.up());
			int h = ((Integer)upState.getValue(STAGE_0_15)).intValue();
			
			float temp = worldIn.getBiome(pos).getTemperature(pos);
			
			if (temp >= 0.5F) {
				if (worldIn.getBlockState(pos.down()).getBlock() instanceof BlockDirt && 
						worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(8) == 0) {
					
					if (i != (h - 8)) { 
						worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 8))); }
					
					if (i <= 6) {
						worldIn.setBlockState(pos, this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(h + 1))); }
				}
			}
			
			if (temp < 0.5F && rand.nextInt(1) == 0) {
				worldIn.destroyBlock(pos, true);
				worldIn.destroyBlock(pos.up(), false); }
		}
		
		if (i > 7) { }
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		/* Property 0 1 2 3 4. 5 6 (7), top 8 9 10 11 12. 13 14 (15) */
		
		/** Too early to collect **/
		if (i < 6) {
			if (item == Items.DYE && k == 15) {
				CMEvents.Consume_1Item(playerIn, hand);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
				
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i + 2)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(i + 10)));
			}
			
			if ((item == Items.DYE && k != 15) || item != Items.DYE) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
			}
		}
		
		if (i == 6 || i == 7) {
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SPICE, 4, 0));
			
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(4)));
				worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(12))); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Change DownBlock. */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		/* Property 0 1 2 3 4. 5 6 (7), top 8 9 10 11 12. 13 14 (15) */
		
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		Block upBlock = worldIn.getBlockState(pos.up()).getBlock();
		
		if (i <= 7) {
			if (downBlock != Blocks.DIRT || upBlock != this) {
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos); }
			
			else { }
		}

		else {
			if (downBlock != this) {
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos); }
			else { }
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		switch (i) {
		case 0 :
		default : return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		case 1 : return new AxisAlignedBB(0.34375D, 0.0D, 0.34375D, 0.65625D, 1.0D, 0.65625D);
		case 2 :
		case 3 : return new AxisAlignedBB(0.21875D, 0.0D, 0.21875D, 0.78125D, 1.0D, 0.78125D);
		case 4 :
		case 5 :
		case 6 :
		case 7 : return new AxisAlignedBB(0.15625D, 0.0D, 0.15625D, 0.84375D, 1.0D, 0.84375D);
		case 8 :
		case 9 :
		case 10 :
		case 11 : return new AxisAlignedBB(0.46875D, 0.0D, 0.46875D, 0.53125D, 0.5D, 0.53125D);
		case 12 :
		case 13 :
		case 14 :
		case 15 : return new AxisAlignedBB(0.21875D, 0.0D, 0.21875D, 0.78125D, 0.5D, 0.78125D);
		} // // STAGE0_15
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}
	
	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_15 });
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "axe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

	/* Render */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		if (playerIn.capabilities.isCreativeMode && i >= 8 && worldIn.getBlockState(pos.down()).getBlock() == this) {
			worldIn.setBlockToAir(pos.down()); }

		if (i <= 7 && worldIn.getBlockState(pos.up()).getBlock() == this) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.setBlockToAir(pos); }
			worldIn.setBlockToAir(pos.up()); }
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		/* Property 0 1 2 3 4. 5 6 (7), top 8 9 10 11 12. 13 14 (15) */
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i <= 7) { stack.add(new ItemStack(Items_Teatime.SPICE_NAE, (i == 7)? 3 : 1, 0)); }
		if (i > 7) { stack.add(new ItemStack(Items.AIR, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.SPICE_NAE, 1, 0);
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
