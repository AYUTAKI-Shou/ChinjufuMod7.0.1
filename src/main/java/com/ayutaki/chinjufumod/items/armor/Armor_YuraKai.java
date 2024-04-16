package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.YuraInner;
import com.ayutaki.chinjufumod.items.armor.model.YuraOuter;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Armor_YuraKai extends Base_CruiserItem {

	public Armor_YuraKai(String name, ArmorMaterial a_material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, a_material, renderIndexIn, equipmentSlotIn);
	}

	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack armor) {

		if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof Armor_YuraKai) {

			int x = (int) playerIn.posX;
			int y = (int) playerIn.posY;
			int z = (int) playerIn.posZ;

			for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++)
			for(int k = -2; k <= 0; k++)

			if (worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.WATER){

				if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() != Blocks.AIR) { }

				else if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() == Blocks.AIR) {
					worldIn.setBlockState(new BlockPos(x - i, y, z -j), Chinjufu_Blocks.WAKE_WATER1.getDefaultState()); } }
			
			else { }
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, 
			EntityEquipmentSlot slotType, ModelBiped _default) {
		return (slotType == EntityEquipmentSlot.LEGS)? new YuraInner(0.4F) : new YuraOuter(0.55F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, worldIn, tooltip, advanced);
		tooltip.add(I18n.format("tips.item_suijou_boots.name"));
	}
}
