package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Kit_Cooktop_on extends Base_Cooktop {

	public Kit_Cooktop_on(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);

		/* Glow Stone=1.0F, Torch=0.9375F */
		setLightLevel(0.875F);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		
		if (stack.isEmpty()) {
			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_STOVE.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(TEPPAN, state.getValue(TEPPAN))); }
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* 火の音 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (rand.nextDouble() < 0.1D) {
				worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D,
						SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	/* You will take damage if you walk on it. */
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

		if (!(entityIn.isImmuneToFire()) && entityIn instanceof EntityLivingBase &&
				!(EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))) {
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F); }
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}
}
