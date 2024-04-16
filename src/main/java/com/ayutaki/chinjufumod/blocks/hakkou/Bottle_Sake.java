package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Bottle_Sake extends BaseBlock_SakeBottle {

	public Bottle_Sake(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
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

		if (item == Items_Teatime.Item_DISH && k == 7) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			worldIn.playSound(null, pos, SoundEvents_CM.SAKE, SoundCategory.PLAYERS, 1.0F, 1.0F);

			/** インベントリが満杯でドロップさせるには if (stack.isEmpty()) を使う **/
			if (stack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(this.tekeGlass()); }
			else if (!playerIn.inventory.addItemStackToInventory(this.tekeGlass())) {
				playerIn.dropItem(this.tekeGlass(), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 4) {
				worldIn.setBlockState(pos, this.tekeState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseBlock_SakeBottle.DOWN, state.getValue(DOWN))); } }
		
		if (item != Items_Teatime.Item_DISH || k != 7) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private ItemStack tekeGlass() {
		if (this == Hakkou_Blocks.NAMASAKEBOT) { return new ItemStack(Items_Teatime.SAKEGLASS, 1, 1); }
		if (this == Hakkou_Blocks.SAKEBOT) { return new ItemStack(Items_Teatime.SAKEGLASS, 1, 2); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT) { return new ItemStack(Items_Teatime.SAKEGLASS, 1, 3); }
		
		if (this == Hakkou_Blocks.WINEBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 1); }
		if (this == Hakkou_Blocks.JUKUWINEBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 2); }
		if (this == Hakkou_Blocks.CIDERBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 3); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 4); }
		if (this == Hakkou_Blocks.MEADBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 5); }
		if (this == Hakkou_Blocks.JUKUMEADBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1, 6); }
		return null;
	}

	private IBlockState tekeState() {
		if (this == Hakkou_Blocks.NAMASAKEBOT) { 
			return Hakkou_Blocks.KARABOTJP.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(1)); }
		if (this == Hakkou_Blocks.SAKEBOT) { 
			return Hakkou_Blocks.KARABOTJP.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(2)); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT) { 
			return Hakkou_Blocks.KARABOTJP.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(3)); }
		
		if (this == Hakkou_Blocks.WINEBOT) { 
			return Hakkou_Blocks.KARABOT.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(1)); }
		if (this == Hakkou_Blocks.JUKUWINEBOT) { 
			return Hakkou_Blocks.KARABOT.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(2)); }
		if (this == Hakkou_Blocks.CIDERBOT) { 
			return Hakkou_Blocks.KARABOT.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(3)); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT) { 
			return Hakkou_Blocks.KARABOT.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(4)); }
		
		if (this == Hakkou_Blocks.MEADBOT) { 
			return Hakkou_Blocks.KARABOTMEAD.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(1)); }
		if (this == Hakkou_Blocks.JUKUMEADBOT) { 
			return Hakkou_Blocks.KARABOTMEAD.getDefaultState().withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(2)); }
		return null;
	}
	
	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { stack.add(this.tekeStack()); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 8)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.tekeStack();
	}
	
	private ItemStack tekeStack() {
		if (this == Hakkou_Blocks.NAMASAKEBOT) { return new ItemStack(Items_Teatime.NAMASAKEBOT, 1, 0); }
		if (this == Hakkou_Blocks.SAKEBOT) { return new ItemStack(Items_Teatime.SAKEBOT, 1, 0); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT) { return new ItemStack(Items_Teatime.JUKUSAKEBOT, 1, 0); }
		
		if (this == Hakkou_Blocks.WINEBOT) { return new ItemStack(Items_Teatime.WINEBOT, 1, 0); }
		if (this == Hakkou_Blocks.JUKUWINEBOT) { return new ItemStack(Items_Teatime.JUKUWINEBOT, 1, 0); }
		if (this == Hakkou_Blocks.CIDERBOT) { return new ItemStack(Items_Teatime.CIDERBOT, 1, 0); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT) { return new ItemStack(Items_Teatime.JUKUCIDERBOT, 1, 0); }
		if (this == Hakkou_Blocks.MEADBOT) { return new ItemStack(Items_Teatime.MEADBOT, 1, 0); }
		if (this == Hakkou_Blocks.JUKUMEADBOT) { return new ItemStack(Items_Teatime.JUKUMEADBOT, 1, 0); }
		return null;
	}
}
