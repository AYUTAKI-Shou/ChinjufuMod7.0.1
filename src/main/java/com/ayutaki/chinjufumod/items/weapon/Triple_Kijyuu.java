package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Kijyuu;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Triple_Kijyuu extends ItemBow {

	public int SHOOTCOUNT = 0;
	
	public Triple_Kijyuu(String name, int max) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.CMARMOR);
		setMaxDamage(max);
		this.maxStackSize = 1;

		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F; } } );
	}

	/* private -> protected */
	protected ItemStack findAmmo(EntityPlayer playerIn) {

		if (this.isArrow(playerIn.getHeldItem(EnumHand.OFF_HAND))) {
			return playerIn.getHeldItem(EnumHand.OFF_HAND); }

		else if (this.isArrow(playerIn.getHeldItem(EnumHand.MAIN_HAND))) {
			return playerIn.getHeldItem(EnumHand.MAIN_HAND); }

		else {
			for (int i = 0; i < playerIn.inventory.getSizeInventory(); ++i) {
				ItemStack stack = playerIn.inventory.getStackInSlot(i);

				if (this.isArrow(stack)) { return stack; }
			}
			return ItemStack.EMPTY; }
	}

	/* 引き絞りに寄って矢に与える速度 */
	public static float getArrowVelocity(int charge) {
		float f = (float)charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) { f = 1.0F; }
		return f;
	}
	
	public int getMaxItemUseDuration(ItemStack stack) {
		return 64;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		boolean flag = !this.findAmmo(playerIn).isEmpty();

		this.SHOOTCOUNT = 0;
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;
		
		if (!playerIn.capabilities.isCreativeMode && !flag) {
			worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.EMPTY_AMMO, SoundCategory.PLAYERS, 0.8F, 0.6F);
			playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.empty_ammo", new Object[0]), true);
			return new ActionResult(EnumActionResult.FAIL, stack); }
		
		else {
			worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.SET_GUN, SoundCategory.PLAYERS, 0.8F, 0.8F);
			playerIn.setActiveHand(handIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}
	}
	
	
	public void onUsingTick(ItemStack stack, EntityLivingBase entityIn, int timeLeft) {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer)entityIn;
			World worldIn = entityIn.world;
			
			boolean mode = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack projectile = this.findAmmo(playerIn);
			
			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !projectile.isEmpty() || mode);
			if (i < 0) return;
			
			if (!projectile.isEmpty() || mode) {
				/** Ammo item instance. Entity to be fired. **/
				if (projectile.isEmpty()) { projectile = new ItemStack(Items_Weapon.AMMUNITION_K); }
				
				float charge = getArrowVelocity(i);
				if (charge >= 1.0F) {
					
					if(!playerIn.getCooldownTracker().hasCooldown(this)) {
						playerIn.getCooldownTracker().setCooldown(this, 5);
						boolean mode1 = playerIn.capabilities.isCreativeMode || (projectile.getItem() instanceof Ammo_Kijyuu && ((Ammo_Kijyuu) projectile.getItem()).isInfinite(projectile, stack, playerIn));

						if (!worldIn.isRemote) {
							int localCount = SHOOTCOUNT;
							/* Ammo item instance. Entity to be fired. */
							Ammo_Kijyuu itemarrow = (Ammo_Kijyuu)(projectile.getItem() instanceof Ammo_Kijyuu ? projectile.getItem() : Items_Weapon.AMMUNITION_S);
							AmmoEntity_Kijyuu entityarrow = (AmmoEntity_Kijyuu) itemarrow.createAmmo(worldIn, projectile, playerIn);

							/* Damage */
							int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
							double CRITICAL = (worldIn.rand.nextInt(3) == 0)? 0.5D : 0.0D;
							double LEVEL = (playerIn.experienceLevel >= 25)? 1.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 0.5D : 0.0D);

							entityarrow.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 6.0F, 1.0F);
							if (j == 0) { entityarrow.setDamage(entityarrow.getDamage() + LEVEL + CRITICAL); }
							if (j > 0) { entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + LEVEL + CRITICAL); }
				
							/* add PUNCH I. */							
							int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
							if (k > 0) { entityarrow.setKnockbackStrength(k); }

							if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) { entityarrow.setFire(100); }

							if (mode1 || playerIn.capabilities.isCreativeMode) {
								entityarrow.pickupStatus = AmmoEntity_Kijyuu.PickupStatus.CREATIVE_ONLY; }

							worldIn.spawnEntity(entityarrow);
							localCount = localCount + 1;
							SHOOTCOUNT = localCount;
						} // !isClientSide
						
						worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.AM_FIRE, 
								SoundCategory.PLAYERS, 0.2F, 1.8F);
						
						if (!mode1 && !playerIn.capabilities.isCreativeMode) {
							projectile.shrink(1);
							if (!worldIn.isRemote) { playerIn.dropItem(new ItemStack(Items_Weapon.CARTRIDGE_K), false); }

							if (projectile.isEmpty()) { 
								playerIn.inventory.deleteStack(projectile);
								playerIn.stopActiveHand();
								
								stack.damageItem(this.SHOOTCOUNT, playerIn);
								worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, this.takeSound(), 
										SoundCategory.BLOCKS, 1.2F, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F); }
						}

					} //Cooldown
				} //charge
			}// !isEmpty
		} // entityIn
		super.onUsingTick(stack, entityIn, timeLeft);
	}
	
	private net.minecraft.util.SoundEvent takeSound() {
		return (this.SHOOTCOUNT > 5)? SoundEvents_CM.AM_CARTRIDGE3 : SoundEvents_CM.AM_CARTRIDGE2;
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
		if (entityIn instanceof EntityPlayer) {
			if (!worldIn.isRemote) {
				EntityPlayer playerIn = (EntityPlayer)entityIn;
				boolean mode = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

				stack.damageItem(this.SHOOTCOUNT, playerIn);
				
				if (this.SHOOTCOUNT !=0 && !mode && !playerIn.capabilities.isCreativeMode) {
					worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, this.takeSound(), 
							SoundCategory.BLOCKS, 1.2F, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F); }
			}
		}
		return stack;
	}
	
	/* Called when the playerIn stops using an Item (stops holding the right mouse button). */
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityIn, int timeLeft) { 
		if (entityIn instanceof EntityPlayer) {
			if (!worldIn.isRemote) {
				EntityPlayer playerIn = (EntityPlayer)entityIn;
				boolean mode = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

				stack.damageItem(this.SHOOTCOUNT, playerIn);

				if (this.SHOOTCOUNT !=0 && !mode && !playerIn.capabilities.isCreativeMode) {
					worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, this.takeSound(), 
							SoundCategory.BLOCKS, 1.2F, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F); }
			}
		}
	}
	
	/* If not set to true, it will come off when damage is added to it. */
	@Override
	public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
		return true;
	}
	
	/* Ammo to be used. */
	protected boolean isArrow(ItemStack stack) {
		return stack.getItem() instanceof Ammo_Kijyuu;
	}
	
	public AbstractAmmo_Entity customizeArrow(AbstractAmmo_Entity arrow) {
		return arrow;
	}
	
	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_INGOT);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_3rensou_kijyuu.name", meta));
		tooltip.add(I18n.format("tips.item_3rensou_kijyuu2.name", meta));
		tooltip.add(TextFormatting.DARK_GREEN + I18n.format("tips.item_3rensou_kijyuu3.name", meta));
	}
}
