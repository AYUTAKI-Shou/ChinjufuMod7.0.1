package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.ToneInner;
import com.ayutaki.chinjufumod.items.armor.model.ToneOuter;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Armor_ToneKai extends Base_CruiserItem {

	public Armor_ToneKai(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int slot, boolean selected) {

		if (entity instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entity;

			if (playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof Armor_ToneKai) {

				double x = (double) playerIn.prevPosX;
				double y = (double) playerIn.prevPosY;
				double z = (double) playerIn.prevPosZ;
				for(double i = -1.3D; i <= 1.3D; i++)
				for(double j = -1.3D; j <= 1.3D; j++)

				if (worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.WATER || worldIn
					.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.KELP || worldIn
					.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.SEAGRASS) {

						if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() != Blocks.AIR) { }

						else if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() == Blocks.AIR) {
						worldIn.setBlockState(new BlockPos(x - i, y, z -j), ChinjufuMod_Blocks.WAKE_WATER1.getDefaultState()); } }
				
				else { }
			}
		}
		else { }
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slotType, Armor defModel) {
		return (Armor) (slotType == EquipmentSlotType.LEGS ? new ToneInner(0.3F) : new ToneOuter(0.55F));
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add(new TranslationTextComponent("tips.item_suijou_boots").applyTextStyle(TextFormatting.GRAY));
	}
}
