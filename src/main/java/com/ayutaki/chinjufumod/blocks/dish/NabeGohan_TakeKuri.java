package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NabeGohan_TakeKuri extends BaseNabe {

	public NabeGohan_TakeKuri(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		if (item == Items_Teatime.Item_DISH && k == 3) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(this.takeChawan()); }
			else if (!playerIn.inventory.addItemStackToInventory(this.takeChawan())) {
				playerIn.dropItem(this.takeChawan(), false); }

			if (i == 1) {
				/** 経験値取得 **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F); }

			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 4) { worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage4_FaceDown2.STAGE_1_4, Integer.valueOf(3))); }
		}

		if (item == Items.BOWL) {
			if (i == 1) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(this.takeBowl()); }
				else if (!playerIn.inventory.addItemStackToInventory(this.takeBowl())) {
					playerIn.dropItem(this.takeBowl(), false); }
	
				/** 経験値取得 **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);
	
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown2.STAGE_1_4, Integer.valueOf(3))); }
			
			if (i != 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if ((item != Items_Teatime.Item_DISH && k != 3) && item != Items.BOWL) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private ItemStack takeChawan() {
		if (this == Dish_Blocks.NABEGOHAN_TAKE) { return new ItemStack(Items_Teatime.GOHAN_TAKE, 1, 0); }
		if (this == Dish_Blocks.NABEGOHAN_KURI) { return new ItemStack(Items_Teatime.GOHAN_KURI, 1, 0); }
		return null;
	}
	
	private ItemStack takeBowl() {
		if (this == Dish_Blocks.NABEGOHAN_TAKE) { return new ItemStack(Items_Teatime.MUSHIGOME, 1, 1); }
		if (this == Dish_Blocks.NABEGOHAN_KURI) { return new ItemStack(Items_Teatime.MUSHIGOME, 1, 2); }
		return null;
	}
	
	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { stack.add(this.takeStack()); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.NABE_kara, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Dish_Blocks.NABEGOHAN_TAKE) { return new ItemStack(Items_Teatime.NABEGOHAN_TAKE, 1, 0); }
		if (this == Dish_Blocks.NABEGOHAN_KURI) { return new ItemStack(Items_Teatime.NABEGOHAN_KURI, 1, 0); }
		return null;
	}
}
