package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.KK_MosquitoEntity;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KK_Mosquito extends Base_BowKansaiki {

	public KK_Mosquito(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.instabuild;
			ItemStack fuel = playerIn.getProjectile(stack);
			
			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !fuel.isEmpty() || mode);

			if (i < 0) return;
			
			if (!fuel.isEmpty() || mode) {
				if (fuel.isEmpty()) { fuel = new ItemStack(Items_Weapon.KK_FUEL); }
				
				float charge = getArrowVelocity(i);
				if (!((double)charge < 0.1D)) {
					
					if (!worldIn.isClientSide) {
						KK_MosquitoEntity kansaiki = new KK_MosquitoEntity(playerIn, worldIn, stack);
						int POWER = 8; // Add the speed and distance of the Entity.
						
						boolean carrier = ShipTypes_CM.typeCarrier(playerIn);
						float basePower = carrier? 0.25F : 0.2F;
						double LEVEL = (playerIn.experienceLevel >= 25)? 3.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 2.0D : 
							((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 1.0D : 0.0D));
						
						if (carrier) { kansaiki.setCarrier(true); }
						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
						
						kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, basePower * POWER, 1.0F);
						if (j == 0) { kansaiki.setBaseDamage(kansaiki.getBaseDamage() + LEVEL); }
						if (j > 0) { kansaiki.setBaseDamage(kansaiki.getBaseDamage() + LEVEL + (double)j * 0.5D); }
						worldIn.addFreshEntity(kansaiki);
						
						if (mode) { playerIn.inventory.removeItem(stack); } // mode
						
						if (!mode) {
							fuel.shrink(1);
							stack.shrink(1); } // !mode
						
						playerIn.awardStat(Stats.ITEM_USED.get(this));
					} // !worldIn.isClientSide
				} // charge
			} // !fuel.isEmpty() 
			
		} // PlayerEntity
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_kk").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_kk_8f").withStyle(TextFormatting.DARK_GREEN));
	}
}
