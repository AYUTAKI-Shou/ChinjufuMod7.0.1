package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Triple_Kijyuu extends BowItem {
	
	public int SHOOTCOUNT = 0;
	
	public Triple_Kijyuu(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.CMARMOR));
	}

	/* Power to be charged. */
	public static float getArrowVelocity(int charge) {
		float f = (float)charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) { f = 1.0F; }
		return f;
	}

	/* Time to continue the action. 3 burst × 3 */
	@Override
	public int getUseDuration(ItemStack stack) {
		return 64;
	}

	/* Action when using. */
	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		boolean flag = !playerIn.getProjectile(stack).isEmpty();
		
		this.SHOOTCOUNT = 0; // Count reset.
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;
		
		if (!playerIn.abilities.instabuild && !flag) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.EMPTY_AMMO, SoundCategory.PLAYERS, 0.8F, 0.6F);
			playerIn.displayClientMessage(new TranslationTextComponent("text.chinjufumod.rightclick.empty_ammo"), true);
			return ActionResult.fail(stack); }
		
		else {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.SET_GUN, SoundCategory.PLAYERS, 0.8F, 0.8F);
			playerIn.startUsingItem(handIn);
			return ActionResult.consume(stack);
		}
	}
	
	public void onUseTick(World worldIn, LivingEntity entityLiving, ItemStack stack, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			ItemStack projectile = playerIn.getProjectile(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);

			if (i < 0) return;
			
			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_K); }
				
				float charge = getPowerForTime(i);
				if (charge >= 1.0F) {
					
					if(!playerIn.getCooldowns().isOnCooldown(this)) {
						playerIn.getCooldowns().addCooldown(this, 5);

						boolean mode1 = playerIn.abilities.instabuild || (projectile.getItem() instanceof Ammo_Kijyuu && ((Ammo_Kijyuu)projectile.getItem()).isInfinite(projectile, stack, playerIn));

						if (!worldIn.isClientSide) {
							int localCount = SHOOTCOUNT;
							
							Ammo_Kijyuu arrowitem = (Ammo_Kijyuu)(projectile.getItem() instanceof Ammo_Kijyuu ? projectile.getItem() : Items_Weapon.AMMUNITION_K);
							AbstractAmmo_Kijyuu abstractarrowentity = arrowitem.createAmmo(worldIn, projectile, playerIn);
							abstractarrowentity = customAmmo(abstractarrowentity);

							/* Damage */
							int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
							double CRITICAL = (worldIn.random.nextInt(3) == 0)? 0.5D : 0.0D;
							double LEVEL = (playerIn.experienceLevel >= 25)? 1.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 0.5D : 0.0D);
							
							abstractarrowentity.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 6.0F, 0.0F);
							if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + LEVEL + CRITICAL); }
							if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + (double)j * 0.5D + LEVEL + CRITICAL); }
							
							/* Enchant */
							int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
							if (k > 0) { abstractarrowentity.setKnockback(k); }

							if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) { abstractarrowentity.setSecondsOnFire(100); }

							if (mode1 || playerIn.abilities.instabuild) {
								 abstractarrowentity.pickup = AbstractAmmo_Kijyuu.PickupStatus.CREATIVE_ONLY; }
							
							/* Spawn Entity. */
							worldIn.addFreshEntity(abstractarrowentity);
							localCount = localCount + 1;
							SHOOTCOUNT = localCount;
							
							/* 1ms=0.001, 10ms=0.01, 50ms=0.05=1tick */
							try {
								TimeUnit.MILLISECONDS.sleep(10);
								worldIn.playSound((PlayerEntity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_FIRE, 
										SoundCategory.PLAYERS, 0.2F, 1.8F); } //"stream": false 
							catch (Exception e) { }
						} //!worldIn.isClientSide
						
						try {
							TimeUnit.MILLISECONDS.sleep(10);
							Vector3d pos = playerIn.getEyePosition(1.0F).add(0.0D, -0.15D, 0.0D).subtract(playerIn.getLookAngle().multiply(-0.75D, -0.75D, -0.75D));
							worldIn.addParticle(ParticleTypes_CM.SHOOT_PT, pos.x, pos.y, pos.z, 0.0D, 0.0D, 0.0D);
						
							try { 
								TimeUnit.MILLISECONDS.sleep(10); 
								if (!mode1 && !playerIn.abilities.instabuild) {
									projectile.shrink(1);
									if (!worldIn.isClientSide) { playerIn.drop(new ItemStack(Items_NoTab.CARTRIDGE_K), false); }
									
									if (projectile.isEmpty()) { 
										playerIn.inventory.removeItem(projectile);
										playerIn.stopUsingItem();
										
										stack.hurtAndBreak(this.SHOOTCOUNT, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
										worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.takeSound(), 
												SoundCategory.BLOCKS, 1.2F, 0.8F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F); }
								} // !mode1
							}
							catch (Exception e) { }
						}
						catch (Exception e) { }
						
					} //Cooldown
				} //charge
			}// !isEmpty
		} // entityLiving
	}
	
	private net.minecraft.util.SoundEvent takeSound() {
		return (this.SHOOTCOUNT > 5)? SoundEvents_CM.AM_CARTRIDGE3 : SoundEvents_CM.AM_CARTRIDGE2;
	}
	
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			
			stack.hurtAndBreak(this.SHOOTCOUNT, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );

			if (this.SHOOTCOUNT !=0 && !mode && !playerIn.abilities.instabuild) {
				worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.takeSound(), 
						SoundCategory.BLOCKS, 1.2F, 0.8F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F); }
		}
		return stack;
	}
	
	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@Override
	public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			
			stack.hurtAndBreak(this.SHOOTCOUNT, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );

			if (this.SHOOTCOUNT !=0 && !mode && !playerIn.abilities.instabuild) {
				worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.takeSound(), 
						SoundCategory.BLOCKS, 1.2F, 0.8F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F); }
		}
	}

	/* Ammo to be used. */
	public static final Predicate<ItemStack> AMMOK = (projectile) -> {
		return projectile.getItem() == Items_Weapon.AMMUNITION_K;
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return AMMOK;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}

	public AbstractAmmo_Kijyuu customAmmo(AbstractAmmo_Kijyuu abstractarrowentity) {
		return abstractarrowentity;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_3rensou_kijyuu").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_3rensou_kijyuu2").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_3rensou_kijyuu3").withStyle(TextFormatting.DARK_GREEN));
	}
}
/*
String str = String.valueOf(this.SHOOTCOUNT);
playerIn.displayClientMessage(new TranslationTextComponent(str), true);
*/