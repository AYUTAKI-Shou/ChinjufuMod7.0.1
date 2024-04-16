package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.RJ_Inner;
import com.ayutaki.chinjufumod.items.armor.model.RJ_Outer;
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

public class Armor_RJKai extends Base_CarrierItem {

	public Armor_RJKai(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int slot, boolean selected) {

		if (entity instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entity;

			if(playerIn.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Armor_RJKai) {

				double x = (double) playerIn.getX();
				double y = (double) playerIn.getY();
				double z = (double) playerIn.getZ();
				for(double i = -1.3D; i <= 1.3D; i++)
				for(double j = -1.3D; j <= 1.3D; j++)

				if (worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.WATER || 
					worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.KELP || 
					worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.SEAGRASS) {

						if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() != Blocks.AIR) { }

						else if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() == Blocks.AIR) {
							worldIn.setBlockAndUpdate(new BlockPos(x - i, y, z -j), ChinjufuMod_Blocks.WAKE_WATER1.defaultBlockState()); } }
				
				else { }
			}
		}
		else { }
	}

	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slot, Armor defModel) {
		return (Armor) (slot == EquipmentSlotType.LEGS ? new RJ_Inner(0.4F) : new RJ_Outer(0.55F));
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add(new TranslationTextComponent("tips.item_suijou_boots").withStyle(TextFormatting.GRAY));
	}
}
