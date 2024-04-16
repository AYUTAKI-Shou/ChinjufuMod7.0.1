package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Frypan_Nama_3 extends BaseStage4_Face {

	protected static final int COOK_TIME = 1000;
	/**1=シーフードソース生, 2=シーフードソース, 3=カレールー生, 4=カレールー**/
	public Frypan_Nama_3(String name) {
		super(name);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		/**1=シーフードソース生, 2=シーフードソース, 3=カレールー生, 4=カレールー**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k = stack.getMetadata();
		
		if (i == 1 ||i == 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		if (i == 2) {
			if (item == Items_Teatime.PASTA && k == 2) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);

				/** Get EXP directly. **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);
	
				if (stack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.PASTASEAFOOD)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.PASTASEAFOOD))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.PASTASEAFOOD), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.FRYPAN_kara.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }
			
			if (item != Items_Teatime.PASTA || k != 2) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (i == 4) {
			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SPICE, 2, 7));
				worldIn.setBlockState(pos, Dish_Blocks.FRYPAN_kara.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}
	
	/* Cooking */
	private boolean isCooking(World worldIn, BlockPos pos) {
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		return (downBlock == Blocks.LIT_FURNACE || downBlock == Kitchen_Blocks.LIT_KITSTOVE || 
				downBlock == Kitchen_Blocks.LIT_KITOVEN || downBlock == Kitchen_Blocks.LIT_KITOVEN_B);
	}

	@Override
	public void observedNeighborChange(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (this.isCooking(worldIn, pos)) { worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn)); }
	}
	
	@Override
	public int tickRate(World worldIn) {
		return COOK_TIME;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		/**1=シーフードソース生, 2=シーフードソース, 3=カレールー生, 4=カレールー **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (this.isCooking(worldIn, pos)) {
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			
			if (i == 1) {
				worldIn.setBlockState(pos, state.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, state.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }
			
			else { }
		}
		
		if (!this.isCooking(worldIn, pos)) { }
	}
	
	/* add Effect */
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = worldIn;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = rand;

		if (i <= 2) {
			
			if (i == 2) {
				if (this.isCooking(worldIn, pos)) {
					for (int la = 0; la < 1; ++la) {
						double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
						double d1 = ((double) ((float) par3 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D) + 0.5D;
						double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
						double d3 = 0.12D;
						double d4 = 0.17D;
						par1World.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0 - d4 + 0.25, d1 + d3 -0.5, d2, 0.0D, 0.0D, 0.0D);
					}
				}
			}
			
			if (rand.nextDouble() < 0.1D) {
				if (this.isCooking(worldIn, pos)) {
					worldIn.playSound(x, y, z, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.2F, 1.0F, false);
				}
			}
		}
		
		if (i >= 3) {
			
			if (i == 4) {
				if (this.isCooking(worldIn, pos)) {	
					for (int la = 0; la < 1; ++la) {
						double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
						double d1 = ((double) ((float) par3 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D) + 0.5D;
						double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
						double d3 = 0.12D;
						double d4 = 0.17D;
						par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d4 + 0.25, d1 + d3 -0.5, d2, 0.0D, 0.0D, 0.0D);
					}
				}
			}
			
			if (rand.nextDouble() < 0.1D) {
				if (this.isCooking(worldIn, pos)) {
					worldIn.playSound(x, y, z, SoundEvents_CM.JUU, SoundCategory.BLOCKS, 0.2F, 1.0F, false);
				}
			}
		}
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.125D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
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

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/**1=シーフードソース生, 2=シーフードソース, 3=カレールー生, 4=カレールー**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i != 4) { stack.add(this.takeStack(state)); }
		if (i == 4) { 
			stack.add(new ItemStack(Items_Teatime.FRYPAN_kara, 1, 0));
			stack.add(new ItemStack(Items_Teatime.SPICE, 2, 7)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}

	private ItemStack takeStack(IBlockState state) {
		/**1=シーフードソース生, 2=シーフードソース, 3=カレールー生, 4=カレールー**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 1) { return new ItemStack(Items_Teatime.FRYPAN_NAMA_3, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Teatime.FRYPAN_NAMA_3, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Teatime.FRYPAN_NAMA_3, 1, 3); }
		return new ItemStack(Items_Teatime.FRYPAN_kara, 1, 0);
	}
	
	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
