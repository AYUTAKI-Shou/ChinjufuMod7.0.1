package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Base_WakeWater extends Block {

	public Base_WakeWater(String name) {
		super(Material.GLASS);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.SNOW);
		setHardness(0.1F);
		setResistance(500.0F);
		setLightOpacity(0);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.00625D, 1.0D);
	}

	/* tick処理で消せなかった時の保険。再ログイン時に消去する */
	public void onChunkLoad(World worldIn, BlockPos pos) {
		worldIn.setBlockToAir(pos);
	}

	/*水を汲む邪魔をしないための措置*/
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		/* 水を汲む WATERブロックは, クリエティブで汲めなくしているが保留 */
		if (item == Items.BUCKET) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
				playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false); }
		}

		/* 大釜(Cauldron)から引用 */
		if (item == Items.GLASS_BOTTLE) {
			CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
			ItemStack stack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);

			if (!playerIn.inventory.addItemStackToInventory(stack3)) {
				playerIn.dropItem(stack3, false); }
			else if (playerIn instanceof EntityPlayerMP) {
				((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); }
		}

		/* TTimeItems 海水OKの水桶と土鍋のみ */
		if (item == Items_Teatime.MIZUOKE) {
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
		}

		if (item == Items_Teatime.NABE_kara) {
			CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_KAISUI)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_KAISUI))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.NABE_KAISUI), false); }
		}
		
		if (item == Items_Teatime.KEIRYO_CUP) {
			CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
			
			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}

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

	public SoundType getSoundType(IBlockState state, World worldIn, BlockPos pos, @Nullable Entity entity) {
		return super.getSoundType(state, worldIn, pos, entity);
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
