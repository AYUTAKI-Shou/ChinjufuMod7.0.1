package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
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
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Taru_Hakkou extends Block {

	protected static final int COOK_TIME = 6000;
	/* Property */
	/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
	/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);

	public Taru_Hakkou(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* TickRandom */
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

		/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
		/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		if (i ==0 || i == 2 || i == 4 || i == 6 || i == 8 || i == 10 || i == 11 || i == 13 || i == 14 || i == 15) { }

		if (i == 1) { worldIn.setBlockState(pos, state.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(2))); }
		if (i == 3) { worldIn.setBlockState(pos, state.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(4))); }
		if (i == 5) { worldIn.setBlockState(pos, state.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(6))); }
		if (i == 7) { worldIn.setBlockState(pos, state.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(8))); }
		if (i == 9) { worldIn.setBlockState(pos, state.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(10))); }
		if (i == 12) { worldIn.setBlockState(pos, state.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(13))); }

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
		/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (stack.isEmpty()) {
			if (i == 2) {
				CMEvents.soundItemPick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KOMEKOUJI, 4));
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(15))); 
			} /* 2=麹 */
			
			if (i == 8) {
				CMEvents.soundItemPick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.JUKUSAKEBOT));
				/** Get EXP directly. **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);

				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(0))); 
			} /* 8=熟成酒 */
			
			if (i == 10) {
				CMEvents.soundItemPick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MISO, 4));
				
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(11))); 
			} /* 10=味噌 */
			
			if (i == 13) {
				CMEvents.soundItemPick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHABA, 8, 2));

				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(14))); 
			} /* 13=紅茶 */
			
			if (i == 15) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Seasonal.TANMONO, 4, 0));

				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(14))); 
			} /* 15=麹の空棚 */
			
			if (i == 0 || i == 4 || i == 6 || i == 14) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			if (i == 11) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
			
			/** Too early to collect **/
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 12) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		} /** Hand is empty. **/
		
		/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
		/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/

		
		if (!stack.isEmpty()) {
			if (i == 0) {
				if (item == Items_Teatime.SAKEBOT) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
					CMEvents.soundSakeBottleFill(worldIn, pos);

					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(7))); }
				
				if (item != Items_Teatime.SAKEBOT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			} /* 0=空 */
			
			if (i == 4) {
				if (item == Items.BOWL) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

					if (stack.isEmpty()) {
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHUBO)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHUBO))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.SHUBO), false); }
					
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(0))); }

				if (item != Items.BOWL) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			} /* 4=酒母 */
			
			if (i == 6) {
				if (item == Items.BOWL) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					/** Get EXP directly. **/
					playerIn.addExperience(1);
					worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);

					if (stack.isEmpty()) {
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MORO)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MORO))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.MORO), false); }
					
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(0))); }
				
				if (item != Items.BOWL) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			} /* 6=もろみ */
			
			if (i == 14) {
				int k = stack.getMetadata();
				int gc = stack.getCount();

				if (item == Items_Teatime.CHADUTSU) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(12))); }
				
				if (item == Items_Teatime.CHABA && k == 1 && gc >= 8) {
					CMEvents.Consume_8Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlockState(pos, Hakkou_Blocks.HAKKOUTARU.getDefaultState()
							.withProperty(Taru_Hakkou.STAGE_0_15, Integer.valueOf(12))); }
				
				if (item == Item.getItemFromBlock(Blocks.BROWN_MUSHROOM) && gc >= 8) {
					CMEvents.Consume_8Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlockState(pos, Hakkou_Blocks.SHOUYUTARU.getDefaultState()
							.withProperty(Taru_Shouyu.STAGE_0_15, Integer.valueOf(11))); }
				
				if (item == Items_Teatime.NORI_N && gc >= 8) {
					CMEvents.Consume_8Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlockState(pos, Hakkou_Blocks.SHOUYUTARU.getDefaultState()
							.withProperty(Taru_Shouyu.STAGE_0_15, Integer.valueOf(13))); }
				
				if ((item == Items_Teatime.CHABA && k == 1 && gc < 8) || (item == Items_Teatime.NORI_N && gc < 8) ||
						(item == Item.getItemFromBlock(Blocks.BROWN_MUSHROOM) && gc < 8)) {
					CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
				
				if (item != Items_Teatime.CHADUTSU && (item != Items_Teatime.CHABA || k != 1) && item != Items_Teatime.NORI_N &&
						item != Item.getItemFromBlock(Blocks.BROWN_MUSHROOM)) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			} /* 14=紅茶の空棚 */
			
			if (i == 11) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
			
			if (i == 2 || i == 8 || i == 10 || i == 13 || i == 15) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			
			/** Too early to collect **/
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 12) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		} /** Hand is not empty. **/

		/** 'true' to not put anything on top. **/
		return true;
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

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (14 - ((Integer)state.getValue(STAGE_0_15)).intValue()) * 2;
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
		/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 9 || i == 10) { return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.125D, 1.0D); }
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
		/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/
		if (i == 0 || i == 4 || i == 6 || i == 14) {
			stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }
		if (i == 1) { stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 1)); }
		if (i == 3) { stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 2)); }
		if (i == 5) { stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 3)); }
		if (i == 7) { stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 4)); }
		if (i == 8) { stack.add(new ItemStack(Items_Teatime.JUKUSAKEBOT, 1, 0));
							stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }
		if (i == 9) { stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 5)); }
		if (i == 10 || i == 11) { stack.add(new ItemStack(Blocks.STONE_SLAB, 1, 0));
							stack.add(new ItemStack(Items_Seasonal.TANMONO, 1, 0));
							stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }
		if (i == 12) { stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 6)); }
		if (i == 13) { stack.add(new ItemStack(Items_Teatime.CHABA, 8, 2));
							stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }
		if (i == 2 || i == 15) { stack.add(new ItemStack(Items_Seasonal.TANMONO, 4, 0));
							stack.add(new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		/** 0=空, 1=未発酵の麹, 2=麹, 3=未発酵の酒母, 4=酒母, 5=未発酵のもろみ, 6=もろみ, 7=未発酵の熟成酒, 8=熟成酒 **/
		/** 9=未発酵の味噌, 10=味噌, 11=味噌の空樽, 12=未酸化の紅茶, 13=紅茶, 14=紅茶の空棚, 15=麹の空棚 **/
		if (i == 1 || i == 2) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 1); }
		if (i == 3 || i == 4) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 2); }
		if (i == 5 || i == 6) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 3); }
		if (i == 7 || i == 8) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 4); }
		if (i == 9 || i == 10) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 5); }
		if (i == 12 || i == 13) { return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 6); }
		return new ItemStack(Items_Teatime.HAKKOUTARU, 1, 0);
	}

}
