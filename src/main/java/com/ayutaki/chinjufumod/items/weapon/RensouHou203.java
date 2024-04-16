package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.AmmoEntity_Medium;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Small;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RensouHou203 extends Base_RensouHou {

	public RensouHou203(String name, int max) {
		super(name, max);
	}

	/* Called when the playerIn stops using an Item (stops holding the right mouse button). */
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {

		if (entityLiving instanceof EntityPlayer) {

			EntityPlayer playerIn = (EntityPlayer)entityLiving;
			boolean mode = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack projectile = this.findAmmo(playerIn);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);
			if (i < 0) return;

			if (!projectile.isEmpty() || mode) {

				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_M); }

				float charge = getArrowVelocity(i);
				if (!((double)charge < 0.1D)) {
					boolean mode1 = playerIn.capabilities.isCreativeMode || (projectile.getItem() instanceof Ammo_Medium && ((Ammo_Medium) projectile.getItem()).isInfinite(projectile, stack, playerIn));

					if (!worldIn.isRemote) {
						/* Ammo item instance. Entity to be fired. */
						Ammo_Medium itemarrow = (Ammo_Medium)(projectile.getItem() instanceof Ammo_Medium ? projectile.getItem() : Items_Weapon.AMMUNITION_M);
						AmmoEntity_Medium entityarrow = (AmmoEntity_Medium) itemarrow.createAmmo(worldIn, projectile, playerIn);
						
						/* Damage */
						entityarrow.setIsCritical(true);
						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						boolean cruiser = ShipTypes_CM.typeCruiser(playerIn);
						double FIT = (cruiser)? 1.0D : 0.0D;
						double LEVEL = (playerIn.experienceLevel >= 25)? 1.5D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 1.0D : 
							((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 0.5D : 0.0D));
						
						entityarrow.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.5F, 1.0F);
						if (j == 0) { entityarrow.setDamage(entityarrow.getDamage() + 2.0D + FIT + LEVEL); }
						if (j > 0) { entityarrow.setDamage(entityarrow.getDamage() + 2.0D + (double)j * 0.5D + FIT + LEVEL); }
						
						/* Enchant */
						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						if (k == 0) { entityarrow.setKnockbackStrength(1); }
						if (k > 0) { entityarrow.setKnockbackStrength(k + 1); }

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) { entityarrow.setFire(100); }

						/* Break animation. */
						stack.damageItem(1, playerIn);

						if (mode1 || playerIn.capabilities.isCreativeMode) {
							entityarrow.pickupStatus = AmmoEntity_Small.PickupStatus.CREATIVE_ONLY; }

						worldIn.spawnEntity(entityarrow);
						playerIn.getCooldownTracker().setCooldown(this, 12);
					}

					/* Firing sound effect. Small 0.5F, 1.4F, Medium 1.0F, 1.2F Large 1.2F, 1.0F */
					worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ,
							SoundEvents_CM.AM_FIRE, SoundCategory.PLAYERS, 1.0F, 1.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);

					if (!mode1 && !playerIn.capabilities.isCreativeMode) {
						projectile.shrink(1);
						if (projectile.isEmpty()) { playerIn.inventory.deleteStack(projectile); }

						if (!worldIn.isRemote) {
							playerIn.dropItem(new ItemStack(Items_Weapon.CARTRIDGE_M), false);
							worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.AM_CARTRIDGE, 
									SoundCategory.BLOCKS, 1.0F, 1.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F); }
					}

					playerIn.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	}

	/* Ammo to be used. */
	protected boolean isArrow(ItemStack stack) {
		return stack.getItem() instanceof Ammo_Medium;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_rensouhou_medium.name", meta));
		tooltip.add(TextFormatting.DARK_GREEN + I18n.format("tips.item_rensouhou203.name", meta));
	}
}
