package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

public class Zundou_MizuMilk extends BaseStage4_Face {

	protected static final int COOK_TIME = 600;
	/** 1=水, 2=湯, 3=牛乳, 4=ホットミルク **/
	public Zundou_MizuMilk(String name) {
		super(name);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
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

		/** 1=水, 2=湯, 3=牛乳, 4=ホットミルク **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		/* ON */
		if (this.isCooking(worldIn, pos)) {
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			
			if (i == 1) {
				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }
		}
		
		/** OFF **/
		if (!this.isCooking(worldIn, pos)) {
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			
			if (i == 2) {
				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
			
			if (i == 4) {
				worldIn.setBlockState(pos, Hakkou_Blocks.COLD_MILK.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
		}
	}

	/* Steam effect. */
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = worldIn;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = rand;

		/** 1=水, 2=湯, 3=牛乳, 4=ホットミルク **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2 || i == 4) {
			if (this.isCooking(worldIn, pos)) {
				for (int la = 0; la < 1; ++la) {
					double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d1 = ((double) ((float) par3 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D) + 0.5D;
					double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d3 = 0.12D;
					double d4 = 0.17D;
					par1World.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0 - d4 + 0.25, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/** add Effect **/
		if (rand.nextDouble() < 0.1D) {
			if (this.isCooking(worldIn, pos)) {
				worldIn.playSound(x, y, z, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.5F, 0.7F, false); }
		}
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=水, 2=湯, 3=牛乳, 4=ホットミルク **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		if (i < 3) {
			/* 塩水へ */
			if (item == Items_Teatime.SHIO) {
				if (i == 1) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SHIOAKUNABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
							/** 1=塩水, 2=塩湯, 3＝灰汁水, 4=灰汁湯 **/ }
		
				if (i == 2) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SHIOAKUNABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
			}
			
			/* 灰汁水へ */
			if (item == Items_Seasonal.WARAHAI) {
				if (i == 1) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SHIOAKUNABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)));
							/** 1=塩水, 2=塩湯, 3＝灰汁水, 4=灰汁湯 **/ }
		
				if (i == 2) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SHIOAKUNABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }
			}
			
			/* 出汁へ */
			if (item == Items_Teatime.DASHI_bot_1) {
				if (i == 2) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
						playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false); }
					
					worldIn.setBlockState(pos, Dish_Blocks.DASHINABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
				
				/** Too early to use **/
				if (i == 1) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
			}
			
			/* うどんへ */
			if (item == Items_Teatime.PASTA && k == 3) {
				if (i == 2) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.UDONNABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); } //Large items cool it down.
				
				/** Too early to use **/
				if (i == 1) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
			}
			
			/** ラーメン**/
			if (item == Items_Teatime.RAMEN_nama && k == 0) {
				if (i == 2) {
					CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_RAMEN.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); } //Large items cool it down.
				
				/** Too early to use **/
				if (i == 1) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
			}
		}
		
		if (i == 3) { CMEvents.textRequestHeat(worldIn, pos, playerIn); }
		
		if (i == 4) {
			if (item != Items_Teatime.NYUSAN) { CMEvents.textRequestCool(worldIn, pos, playerIn); }
			if (item == Items_Teatime.NYUSAN) { CMEvents.textEarlyUse(worldIn, pos, playerIn); } }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

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
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		/** drop は寸胴に戻して回収 **/
		stack.add(new ItemStack(Items_Teatime.ZUNDOU, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		/** 1=水, 2=湯, 3=牛乳, 4=ホットミルク **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/** pick はそれぞれを回収 **/
		if (i == 3 || i == 4) { return new ItemStack(Items_Teatime.ZUNDOUMILK, 1, 0); }
		return new ItemStack(Items_Teatime.ZUNDOUMIZU, 1, 0);
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
// 動きのあるブロックに BlockRenderLayer.TRANSLUCENT は使えない
}
