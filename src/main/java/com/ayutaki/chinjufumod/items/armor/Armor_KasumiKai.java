package com.ayutaki.chinjufumod.items.armor;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ArmorLayer_CM;
import com.ayutaki.chinjufumod.items.armor.model.BaseArmor;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class Armor_KasumiKai extends Base_DestroyerItem {

	public Armor_KasumiKai(ArmorMaterial material, ArmorItem.Type slot, Item.Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entity, int slot, boolean selected) {
		if (entity instanceof Player) {
			Player playerIn = (Player)entity;

			if (playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof Armor_KasumiKai) {

				int x = (int) playerIn.getX();
				int y = (int) playerIn.getY();
				int z = (int) playerIn.getZ();
				for(int i = -1; i <= 1; i++)
				for(int j = -1; j <= 1; j++)

				if (worldIn.getBlockState(new BlockPos(x - i, y - 1, z -j)).getBlock() == Blocks.WATER || 
					worldIn.getBlockState(new BlockPos(x - i, y - 1, z -j)).getBlock() == Blocks.KELP || 
					worldIn.getBlockState(new BlockPos(x - i, y - 1, z -j)).getBlock() == Blocks.SEAGRASS) {

					if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() != Blocks.AIR) { }

					else if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() == Blocks.AIR) {
					worldIn.setBlockAndUpdate(new BlockPos(x - i, y, z -j), ChinjufuMod_Blocks.WAKE_WATER1.get().defaultBlockState()); }
				} //water
			} // BOOTS_KAI
		} //Player
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityIn, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defModel) {
				EntityModelSet entityModel = Minecraft.getInstance().getEntityModels();
				ModelPart part = entityModel.bakeLayer(slot == EquipmentSlot.LEGS ? ArmorLayer_CM.GISOU_INNER : ArmorLayer_CM.KASUMI_OUTER);
				return new BaseArmor(part); }
		});
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add(Component.translatable("tips.item_suijou_boots").withStyle(ChatFormatting.GRAY));
	}
}
