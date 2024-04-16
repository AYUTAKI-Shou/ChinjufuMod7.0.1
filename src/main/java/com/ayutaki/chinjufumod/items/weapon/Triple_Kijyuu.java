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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Triple_Kijyuu extends BowItem {

	public int SHOOTCOUNT = 0;
	
	public Triple_Kijyuu(Item.Properties properties) {
		super(properties.group(ItemGroups_CM.CMARMOR));
		
		this.addPropertyOverride(new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F;
		});
	}

	/* Power to be charged. */
	public static float getArrowVelocity(int charge) {
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
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(stack).isEmpty();

		this.SHOOTCOUNT = 0; // Count reset.
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (!playerIn.abilities.isCreativeMode && !flag) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.EMPTY_AMMO, SoundCategory.PLAYERS, 0.8F, 0.6F);
			return ActionResult.resultFail(stack); }
		
		else {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.SET_GUN, SoundCategory.PLAYERS, 0.8F, 0.8F);
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(stack);
		}
	}

	/* Called as the item is being used by an entity. */
	@Override
	public void onUse(World worldIn, LivingEntity entityLiving, ItemStack stack, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack projectile = playerIn.findAmmo(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);

			if (i < 0) return;
			
			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_K); }
				
				float charge = getArrowVelocity(i);
				if (charge >= 1.0F) {
					
					if(!playerIn.getCooldownTracker().hasCooldown(this)) {
						playerIn.getCooldownTracker().setCooldown(this, 5);

						boolean mode1 = playerIn.abilities.isCreativeMode || (projectile.getItem() instanceof Ammo_Kijyuu && ((Ammo_Kijyuu)projectile.getItem()).isInfinite(projectile, stack, playerIn));

						if (!worldIn.isRemote) {
							int localCount = SHOOTCOUNT;
							
							Ammo_Kijyuu arrowitem = (Ammo_Kijyuu)(projectile.getItem() instanceof Ammo_Kijyuu ? projectile.getItem() : Items_Weapon.AMMUNITION_K);
							AbstractAmmo_Kijyuu abstractarrowentity = arrowitem.createAmmo(worldIn, projectile, playerIn);
							abstractarrowentity = customAmmo(abstractarrowentity);

							/* Damage */
							int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
							double CRITICAL = (worldIn.rand.nextInt(3) == 0)? 0.5D : 0.0D;
							double LEVEL = (playerIn.experienceLevel >= 25)? 1.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 0.5D : 0.0D);

							abstractarrowentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 6.0F, 1.0F);
							if (j == 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + LEVEL + CRITICAL); }
							if (j > 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + LEVEL + CRITICAL); }
							
							/* Enchant */
							int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
							if (k > 0) { abstractarrowentity.setKnockbackStrength(k); }

							if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) { abstractarrowentity.setFire(100); }

							if (mode1 || playerIn.abilities.isCreativeMode) {
								abstractarrowentity.pickupStatus = AbstractAmmo_Kijyuu.PickupStatus.CREATIVE_ONLY; }
							
							worldIn.addEntity(abstractarrowentity);
							localCount = localCount + 1;
							SHOOTCOUNT = localCount;
							
							/* 1ms=0.001, 10ms=0.01, 50ms=0.05=1tick */
							try {
								TimeUnit.MILLISECONDS.sleep(10);
								worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.AM_FIRE, 
										SoundCategory.PLAYERS, 0.2F, 1.8F); } //"stream": false 
							catch (Exception e) { }
						} //!worldIn.isClientSide
						
						try {
							TimeUnit.MILLISECONDS.sleep(10);
							Vec3d pos = playerIn.getEyePosition(1.0F).add(0.0D, -0.15D, 0.0D).subtract(playerIn.getLookVec().mul(-0.75D, -0.75D, -0.75D));
							worldIn.addParticle(ParticleTypes_CM.SHOOT_PT, pos.x, pos.y, pos.z, 0.0D, 0.0D, 0.0D);
						
							try { 
								TimeUnit.MILLISECONDS.sleep(10); 
								if (!mode1 && !playerIn.abilities.isCreativeMode) {
									projectile.shrink(1);
									if (!worldIn.isRemote) { playerIn.dropItem(new ItemStack(Items_NoTab.CARTRIDGE_K), false); }
								
									if (projectile.isEmpty()) { 
										playerIn.inventory.deleteStack(projectile); 
										playerIn.stopActiveHand();
										
										stack.damageItem(this.SHOOTCOUNT, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
										worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), this.takeSound(), 
												SoundCategory.PLAYERS, 1.2F, 0.8F / (random.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F); }
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
	
	/* Added after using the item. */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			
			stack.damageItem(this.SHOOTCOUNT, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
			
			if (this.SHOOTCOUNT !=0 && !mode && !playerIn.abilities.isCreativeMode) {
				worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), this.takeSound(), 
						SoundCategory.PLAYERS, 1.2F, 0.8F / (random.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F); }
		}
		return stack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) { 
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			
			stack.damageItem(this.SHOOTCOUNT, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
			
			if (this.SHOOTCOUNT !=0 && !mode && !playerIn.abilities.isCreativeMode) {
				worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), this.takeSound(), 
						SoundCategory.PLAYERS, 1.2F, 0.8F / (random.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F); }
		}
	}
	
	public AbstractAmmo_Kijyuu customAmmo(AbstractAmmo_Kijyuu arrow) {
		return arrow;
	}
	
	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}
	
	/* Ammo to be used. */
	public static final Predicate<ItemStack> AMMOK = (projectile) -> {
		return projectile.getItem() == Items_Weapon.AMMUNITION_K;
	};

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return AMMOK;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_3rensou_kijyuu").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_3rensou_kijyuu2").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_3rensou_kijyuu3").applyTextStyle(TextFormatting.DARK_GREEN));
	}
}
