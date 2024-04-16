package com.ayutaki.chinjufumod.items.chinjufu;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class OilDrum_Item extends ItemBlockBace {

	public OilDrum_Item(String name) {
		super(name, Chinjufu_Blocks.ALUMI_W);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}

	/* return the fuel burn time for this itemstack in a furnace.
 * Return 0 to make it not act as a fuel.
 * Return -1 to let the default vanilla logic decide. */
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 7200;
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

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Chinjufu_Blocks.ALUMI_W, pos, false, facing, (Entity)null)) {

			/** Put the Block. **/
			IBlockState state1 = Chinjufu_Blocks.ALUMI_W.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4));
			worldIn.setBlockState(pos, state1, 10);
			CMEvents.Consume_1Metal(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
