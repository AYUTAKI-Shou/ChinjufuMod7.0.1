package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kakigouri extends BaseStage4_FaceDown {

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.4D, 0.0D, 0.4D, 0.6D, 0.3125D, 0.6D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.4D, -0.5D, 0.4D, 0.6D, 0.01D, 0.6D);

	public Kakigouri(String name) {
		super(name);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i != 4) {
			/** Hand is Empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);

				if (i == 1) {
					/* 1秒＝20 かき氷は ×30=600 */
					if (this == Dish_Blocks.KAKIGOURI_block) {
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SPEED, 400, 0)); }
					if (this != Dish_Blocks.KAKIGOURI_block) { 
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(this.takeEffect(), 600, 0)); }
				}
				
				if (i == 2) {
					if (this == Dish_Blocks.KAKIGOURI_block) {
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SPEED, 500, 0)); }
					if (this != Dish_Blocks.KAKIGOURI_block) { 
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(this.takeEffect(), 780, 0)); }
				}
				
				if (i == 3) {
					if (this == Dish_Blocks.KAKIGOURI_block) { 
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SPEED, 600, 0)); }
					if (this != Dish_Blocks.KAKIGOURI_block) { 
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(this.takeEffect(), 900, 0)); }
				}
				
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private Potion takeEffect() {
		if (this == Dish_Blocks.KAKIGOURI_pink) { return MobEffects.STRENGTH; }
		if (this == Dish_Blocks.KAKIGOURI_red) { return MobEffects.NIGHT_VISION; }
		if (this == Dish_Blocks.KAKIGOURI_yellow) { return MobEffects.RESISTANCE; }
		if (this == Dish_Blocks.KAKIGOURI_green) { return MobEffects.HASTE; }
		return null;
	}
	
	/*Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB : AABB_DOWN;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { stack.add(this.takeStack()); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 7)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Dish_Blocks.KAKIGOURI_block) { return new ItemStack(Items_Seasonal.KAKIGOURI_block, 1, 0); }
		if (this == Dish_Blocks.KAKIGOURI_pink) { return new ItemStack(Items_Seasonal.KAKIGOURI_pink, 1, 0); }
		if (this == Dish_Blocks.KAKIGOURI_red) { return new ItemStack(Items_Seasonal.KAKIGOURI_red, 1, 0); }
		if (this == Dish_Blocks.KAKIGOURI_yellow) { return new ItemStack(Items_Seasonal.KAKIGOURI_yellow, 1, 0); }
		if (this == Dish_Blocks.KAKIGOURI_green) { return new ItemStack(Items_Seasonal.KAKIGOURI_green, 1, 0); }
		return null;
	}
}
