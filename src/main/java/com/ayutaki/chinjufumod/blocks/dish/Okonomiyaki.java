package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Okonomiyaki extends BaseStage4_FaceDown {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(3.5D * cw, 0.0D * cw, 2.5D * cw, 12.5D * cw, 3.0D * cw, 11.5D * cw);
	private static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(4.5D * cw, 0.0D * cw, 3.5D * cw, 13.5D * cw, 3.0D * cw, 12.5D * cw);
	private static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(3.5D * cw, 0.0D * cw, 4.5D * cw, 12.5D * cw, 3.0D * cw, 13.5D * cw);
	private static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(2.5D * cw, 0.0D * cw, 3.5D * cw, 11.5D * cw, 3.0D * cw, 12.5D * cw);

	private static final AxisAlignedBB DOWN_SOUTH = new AxisAlignedBB(3.5D * cw, -8.0D * cw, 2.5D * cw, 12.5D * cw, 0.1D * cw, 11.5D * cw);
	private static final AxisAlignedBB DOWN_WEST = new AxisAlignedBB(4.5D * cw, -8.0D * cw, 3.5D * cw, 13.5D * cw, 0.1D * cw, 12.5D * cw);
	private static final AxisAlignedBB DOWN_NORTH = new AxisAlignedBB(3.5D * cw, -8.0D * cw, 4.5D * cw, 12.5D * cw, 0.1D * cw, 13.5D * cw);
	private static final AxisAlignedBB DOWN_EAST = new AxisAlignedBB(2.5D * cw, -8.0D * cw, 3.5D * cw, 11.5D * cw, 0.1D * cw, 12.5D * cw);
	
	public Okonomiyaki(String name) {
		super(name);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}

	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/** Hand is Empty. **/
		if (stack.isEmpty()) {
			CMEvents.soundEat(worldIn, pos);

			if (this == Dish_Blocks.OKONOMIC) {
				if (i == 1) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.HASTE, 2600, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 2) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 3) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 4) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2600, 0));
					worldIn.setBlockState(pos, Dish_Blocks.CORNSOUP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(4))); }
			}
			
			if (this == Dish_Blocks.OKONOMIYAKI || this == Dish_Blocks.OKONOMIS) {
				if (i == 1) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.HASTE, 3200, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 2) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 3) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 4) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3200, 0));
					worldIn.setBlockState(pos, Dish_Blocks.CORNSOUP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(4))); }
			}
			
			if (this == Dish_Blocks.OKONOMISOBAC) {
				if (i == 1) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.HASTE, 2600, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 2) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 3) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 4) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2600, 0));
					worldIn.setBlockState(pos, Dish_Blocks.CORNSOUP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(4))); }
			}
			
			if (this == Dish_Blocks.OKONOMISOBA || this == Dish_Blocks.OKONOMISOBAS) {
				if (i == 1) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.HASTE, 3200, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 2) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 4, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 3) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 4, 0));
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

				if (i == 4) {
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 0, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3, 0));
					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3200, 0));
					worldIn.setBlockState(pos, Dish_Blocks.CORNSOUP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(4))); }
			}
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case EAST:
		default:
			/** !down= true : false **/
			return flag? AABB_EAST : DOWN_EAST;

		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;

		case WEST:
			return flag? AABB_WEST : DOWN_WEST;

		case NORTH:
			return flag? AABB_NORTH : DOWN_NORTH;
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(this.takeStack()); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.Item_SARA, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Dish_Blocks.OKONOMIYAKI) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1, 0); }
		if (this == Dish_Blocks.OKONOMIS) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1, 1); }
		if (this == Dish_Blocks.OKONOMIC) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1, 2); }
		if (this == Dish_Blocks.OKONOMISOBA) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1, 3); }
		if (this == Dish_Blocks.OKONOMISOBAS) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1, 4); }
		if (this == Dish_Blocks.OKONOMISOBAC) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1, 5); }
		return null;
	}
}
