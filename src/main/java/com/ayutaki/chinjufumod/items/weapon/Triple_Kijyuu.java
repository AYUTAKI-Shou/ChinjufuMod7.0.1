package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Triple_Kijyuu extends BowItem {

	public int SHOOTCOUNT = 0;
	
	public Triple_Kijyuu(Item.Properties properties) {
		super(properties);
	}
	
	/* Power to be charged. */
	public static float getPowerForTime(int charge) {
		float f = (float)charge / 20.0F;
		f = (f + 2.0F) / 3.0F;
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
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		boolean flag = !playerIn.getProjectile(stack).isEmpty();
		
		this.SHOOTCOUNT = 0; // Count reset.
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (!playerIn.getAbilities().instabuild && !flag) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.EMPTY_AMMO.get(), SoundSource.PLAYERS, 0.8F, 0.6F);
			playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.empty_ammo"), true);
			return InteractionResultHolder.fail(stack); }
		
		else {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.SET_GUN.get(), SoundSource.PLAYERS, 0.8F, 0.8F);
			playerIn.startUsingItem(handIn);
			return InteractionResultHolder.consume(stack);
		}
	}

	@SuppressWarnings("deprecation")
	public void onUseTick(Level worldIn, LivingEntity entityLiving, ItemStack stack, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerIn = (Player)entityLiving;
			boolean mode = playerIn.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			ItemStack projectile = playerIn.getProjectile(stack);
			
			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);

			if (i < 0) return;
			
			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_K.get()); }
				
				float charge = getPowerForTime(i);
				if (charge >= 1.0F) {
					
					if(!playerIn.getCooldowns().isOnCooldown(this)) {
						playerIn.getCooldowns().addCooldown(this, 5);

						boolean mode1 = playerIn.getAbilities().instabuild || (projectile.getItem() instanceof Ammo_Kijyuu && ((Ammo_Kijyuu)projectile.getItem()).isInfinite(projectile, stack, playerIn));

						if (!worldIn.isClientSide) {
							int localCount = SHOOTCOUNT;
							
							Ammo_Kijyuu arrowitem = (Ammo_Kijyuu)(projectile.getItem() instanceof Ammo_Kijyuu ? projectile.getItem() : Items_Weapon.AMMUNITION_K.get());
							AbstractAmmo_Kijyuu abstractarrowentity = arrowitem.createAmmo(worldIn, projectile, playerIn);
							abstractarrowentity = customAmmo(abstractarrowentity);

							/* Damage */
							int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
							double CRITICAL = (worldIn.random.nextInt(3) == 0)? 0.5D : 0.0D;
							double LEVEL = (playerIn.experienceLevel >= 25)? 1.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 0.5D : 0.0D);
							
							abstractarrowentity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 6.0F, 1.0F);
							if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + LEVEL + CRITICAL); }
							if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + (double)j * 0.5D + LEVEL + CRITICAL); }
							
							/* Enchant */
							int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
							if (k > 0) { abstractarrowentity.setKnockback(k); }

							if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) { abstractarrowentity.setSecondsOnFire(100); }

							if (mode1 || playerIn.getAbilities().instabuild) {
								 abstractarrowentity.pickup = AbstractAmmo_Kijyuu.Pickup.CREATIVE_ONLY; }

							/* Spawn Entity. */
							worldIn.addFreshEntity(abstractarrowentity);
							localCount = localCount + 1;
							SHOOTCOUNT = localCount;
							
							/* 1ms=0.001, 10ms=0.01, 50ms=0.05=1tick */
							try {
								TimeUnit.MILLISECONDS.sleep(10);
								worldIn.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_FIRE.get(), 
										SoundSource.PLAYERS, 0.2F, 1.8F); } //"stream": false 
							catch (Exception e) { }
						} //!worldIn.isClientSide
						
						try {
							TimeUnit.MILLISECONDS.sleep(10);
							Vec3 pos = playerIn.getEyePosition(1.0F).add(0.0D, -0.15D, 0.0D).subtract(playerIn.getLookAngle().multiply(-0.75D, -0.75D, -0.75D));
							worldIn.addParticle((ParticleOptions) ParticleTypes_CM.SHOOT_PT.get(), pos.x, pos.y, pos.z, 0.0D, 0.0D, 0.0D);
						
							try { 
								TimeUnit.MILLISECONDS.sleep(10); 
								if (!mode1 && !playerIn.getAbilities().instabuild) {
									projectile.shrink(1);
									if (!worldIn.isClientSide) { playerIn.drop(new ItemStack(Items_NoTab.CARTRIDGE_K.get()), false); }
								
									if (projectile.isEmpty()) { 
										playerIn.getInventory().removeItem(projectile); 
										playerIn.stopUsingItem();
										
										stack.hurtAndBreak(this.SHOOTCOUNT, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
										worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.takeSound(), 
												SoundSource.BLOCKS, 1.2F, 0.8F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F); }
									} 
								}
							catch (Exception e) { }
						}
						catch (Exception e) { }
						
					} //Cooldown
				} //charge
			}// !isEmpty
		} // entityLiving
	}
	
	private net.minecraft.sounds.SoundEvent takeSound() {
		return (this.SHOOTCOUNT > 5)? SoundEvents_CM.AM_CARTRIDGE3.get() : SoundEvents_CM.AM_CARTRIDGE2.get();
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		if (entityLiving instanceof Player) {
			Player playerIn = (Player)entityLiving;
			boolean mode = playerIn.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			
			stack.hurtAndBreak(this.SHOOTCOUNT, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
			
			if (this.SHOOTCOUNT != 0 && !mode && !playerIn.getAbilities().instabuild) {
				worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.takeSound(), 
						SoundSource.BLOCKS, 1.2F, 0.8F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F); }
		}
		return stack;
	}
	
	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@SuppressWarnings("deprecation")
	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerIn = (Player)entityLiving;
			boolean mode = playerIn.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			
			stack.hurtAndBreak(this.SHOOTCOUNT, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
			
			if (this.SHOOTCOUNT != 0 && !mode && !playerIn.getAbilities().instabuild) {
				worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.takeSound(), 
						SoundSource.BLOCKS, 1.2F, 0.8F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F); }
		}
	}
	
	/* Ammo to be used. */
	public static final Predicate<ItemStack> AMMOK = (projectile) -> {
		return projectile.getItem() == Items_Weapon.AMMUNITION_K.get();
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return AMMOK;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}
	
	public AbstractAmmo_Kijyuu customAmmo(AbstractAmmo_Kijyuu arrow) {
		return arrow;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_3rensou_kijyuu").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.item_3rensou_kijyuu2").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.item_3rensou_kijyuu3").withStyle(ChatFormatting.DARK_GREEN));
	}
}
