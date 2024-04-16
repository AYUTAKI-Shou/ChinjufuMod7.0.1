package com.ayutaki.chinjufumod.items.chinjufu;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdmiralStamp_Item extends ItemBlockBace {

	public AdmiralStamp_Item(String name, Block putBlock) {
		super(name, putBlock);
		setUnlocalizedName(name);
		/** アイテムのスタック数 **/
		setMaxStackSize(1);

		/** アイテムの耐久値 **/
		setMaxDamage(15);
	}

	/* 耐久値を持たせるために ContainerItemStack を呼び出す
	 * Call ContainerItemStack to have damage value. */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	/* クラフト後の処理 Processing after craft */
	@Override
	public ItemStack getContainerItem(ItemStack stack) {

		/** 残り耐久値とダメージが一致したときは, アイテムが消える
		 * Remaining durable value and damage are equal, the item disappears. **/
		if (stack.getMaxDamage() == stack.getItemDamage()) {
			return ItemStack.EMPTY;
		}

		/** それ以外は, ダメージを与えたアイテムを返す
		 * Otherwise, return items that damaged **/
		else {
			ItemStack newItemStack = stack.copy();
			newItemStack.setItemDamage(stack.getItemDamage() + 1);
			return newItemStack;
		}
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		/* 4.0F / 360.0F) + 0.5D -> add 180... 4.0F / 360.0F) + 2.5D */
		int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		EnumFacing direction = EnumFacing.getHorizontal(i);
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Chinjufu_Blocks.ADMIRAL_STAMP1, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP1.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10); }

			if (k == 1) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP1.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 10); }

			if (k == 2) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP1.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 10); }

			if (k == 3) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP1.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)), 10); }

			if (k == 4) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP2.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10); }

			if (k == 5) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP2.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 10); }

			if (k == 6) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP2.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 10); }

			if (k == 7) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP2.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)), 10); }

			if (k == 8) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP3.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10); }

			if (k == 9) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP3.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 10); }

			if (k == 10) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP3.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 10); }

			if (k == 11) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP3.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)), 10); }

			if (k == 12) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP4.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10); }

			if (k == 13) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP4.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 10); }

			if (k == 14) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP4.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 10); }

			if (k == 15) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRAL_STAMP4.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)), 10); }

			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
	
	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_admiral_stamp.name", meta));
	}
}
