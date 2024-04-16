package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FallLeaf extends Block {

	public FallLeaf(String name) {
		super(Material.GROUND);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.PLANT);
		setHardness(0.75F);
		setResistance(5.0F);

		setTickRandomly(true);
	}

	/* RandomTick */
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (!worldIn.isRemote) {
			/** pos.upが暗いと土ブロックになる **/
			if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2) {
				worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState()); }

			else {
				if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {

					for (int i = 0; i < 4; ++i) {
						BlockPos nearPos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

						if (nearPos.getY() >= 0 && nearPos.getY() < 256 && !worldIn.isBlockLoaded(nearPos)) { return; }

						IBlockState upState = worldIn.getBlockState(nearPos.up());
						IBlockState state1 = worldIn.getBlockState(nearPos);

						/** 付近の土ブロックを落ち葉ブロックに変える **/
						if (state1.getBlock() == Blocks.DIRT && state1.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && worldIn.getLightFromNeighbors(nearPos.up()) >= 4 && upState.getLightOpacity(worldIn, pos.up()) <= 2) {
							worldIn.setBlockState(nearPos, Seasonal_Blocks.FALL_LEAF.getDefaultState()); }
					}
				}
			}
		}
	}

	/* バイオーム生成時に, 木や草が生えるようにする */
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess worldIn, BlockPos pos,
			EnumFacing direction, net.minecraftforge.common.IPlantable plantable) {
		return true;
	}

	@Override
	public void onPlantGrow(IBlockState state, World worldIn, BlockPos pos, BlockPos source) { }

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		boolean mode = playerIn.capabilities.isCreativeMode;

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		/** && かつ || または **/
		if (item == Items.DIAMOND_SHOVEL || item == Items.GOLDEN_SHOVEL || item == Items.IRON_SHOVEL || item == Items
				.STONE_SHOVEL || item == Items.WOODEN_SHOVEL) {

			((EntityLivingBase) playerIn).playSound(SoundEvents.ITEM_SHOVEL_FLATTEN, 1.0F, 1.0F);
			worldIn.setBlockState(pos, Blocks.GRASS_PATH.getDefaultState());

			if (!mode) { stack.damageItem(1, playerIn); }
			if (mode) { }
			return true;
	 	}

		if (item == Items.DIAMOND_HOE || item == Items.GOLDEN_HOE || item == Items.IRON_HOE || item == Items
				.STONE_HOE || item == Items.WOODEN_HOE) {

			((EntityLivingBase) playerIn).playSound(SoundEvents.ITEM_HOE_TILL, 1.0F, 1.0F);
			worldIn.setBlockState(pos, Seasonal_Blocks.SUIDEN.getDefaultState());

			if (!mode) { stack.damageItem(1, playerIn); }
			if (mode) { }
			return true;
	 	}

		/** モンスターわきのためにfalse **/
		return false;
	}


	/* モンスターをSpawnするようにする */
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess worldIn, BlockPos pos,
		net.minecraft.entity.EntityLiving.SpawnPlacementType type) {
		return true;
	}

	/* Render */
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return true;
	}

	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Items_Seasonal.FALL_LEAF, 1, 0);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Blocks.DIRT));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Seasonal.FALL_LEAF, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_fall_leaf.name", meta));
	}
}
