package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Mizuoke_full extends BaseStage2_Face {

	/* Property 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
	public Mizuoke_full(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
		
		setTickRandomly(true);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		boolean mode = playerIn.capabilities.isCreativeMode;

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		/* 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		/** バケツ **/
		if (item == Items.BUCKET) {

			if (!mode) {
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
					playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
			return true;
		}

		if (item == Items_Teatime.MIZUOKE) {

			if (!mode) {
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
			return true;
		}


		/** ガラス瓶 **/
		if (item == Items.GLASS_BOTTLE) {

			if (!mode) {
				stack.shrink(1);
				ItemStack stack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
				if (!playerIn.inventory.addItemStackToInventory(stack3)) { playerIn.dropItem(stack3, false); }
				else if (playerIn instanceof EntityPlayerMP) {
					((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }
			return true;
		}

		/** 計量カップ **/
		if (item == Items_Teatime.KEIRYO_CUP) {
			if (!mode) {
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }
			return true;
		}

		/** 洗う **/
		else {
			if (item instanceof ItemArmor) {

				ItemArmor itemarmor = (ItemArmor)item;
				if (itemarmor.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && itemarmor.hasColor(stack) && !worldIn.isRemote) {
					itemarmor.removeColor(stack);

					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
					if (i != 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }

					playerIn.addStat(StatList.ARMOR_CLEANED);
					return true;
				}
			} //鎧

			if (item instanceof ItemBanner) {

				if (TileEntityBanner.getPatterns(stack) > 0 && !worldIn.isRemote) {
					ItemStack stack1 = stack.copy();
					stack1.setCount(1);
					TileEntityBanner.removeBannerData(stack1);
					playerIn.addStat(StatList.BANNER_CLEANED);

					if (!mode) { stack.shrink(1); }

					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
					if (i != 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }

					if (stack.isEmpty()) { playerIn.setHeldItem(hand, stack1); }
					else if (!playerIn.inventory.addItemStackToInventory(stack1)) { playerIn.dropItem(stack1, false); }
					else if (playerIn instanceof EntityPlayerMP) {
						((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); }
				}
				return true;
			} //旗

			if (item instanceof Base_ItemHake) {

				if (!mode) { stack.shrink(1); }

				CMEvents.soundWaterUse(worldIn, pos);

				if (i == 1) {
					worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }

				if (i != 1) {
					worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }

				/** add Item **/
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }

				return true;
			}//色筆
		}

		/** 'true' to not put anything on top. **/
		return true;
	}

	/* RandomTick */
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 1)) return;
		/* 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		if (worldIn.isRainingAt(pos.up())) {
			if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(i + 1))); }

			if (i != 1) { }
		}
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5625D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Teatime.MIZUOKE_full, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.MIZUOKE_full, 1, 0);
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
