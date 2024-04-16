package com.ayutaki.chinjufumod.items.kansaiki;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Base_BowKansaiki extends ItemBow {

	public Base_BowKansaiki(String name, int max) {
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
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		boolean flag = !this.findAmmo(playerIn).isEmpty();
		
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;
		
		if (stack.getItemDamage() >= (stack.getMaxDamage())) {
			worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.MASTER, 1.0F, 1.0F);
			stack.shrink(1); }
		
		if (!playerIn.capabilities.isCreativeMode && !flag) {
			worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.ERROR, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.empty_fuel.name", new Object[0]), true);
			return new ActionResult(EnumActionResult.FAIL, stack); }
		
		if (playerIn.isInsideOfMaterial(Material.WATER)) { 
			worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.ERROR, SoundCategory.PLAYERS, 1.0F, 1.0F);
			playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.waterlogged.name", new Object[0]), true);
			return new ActionResult(EnumActionResult.FAIL, stack); }
		
		else {
			playerIn.setActiveHand(handIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}
	}

	public void onUsingTick(ItemStack stack, EntityLivingBase playerIn, int count) {
		super.onUsingTick(stack, playerIn, count);
		int tickCount = playerIn.getItemInUseCount();
		
		if (tickCount != 0 && tickCount % 3 == 0) { playerIn.playSound(SoundEvents_CM.KK_START, 0.5F, 1.2F); }
	}
	
	public AbstractAmmo_Entity customizeArrow(AbstractAmmo_Entity arrow) {
		return arrow;
	}
	
	/* Ammo to be used. */
	protected boolean isArrow(ItemStack stack) {
		return stack.getItem() instanceof Fuel_KK;
	}
	
	public int getItemEnchantability() {
		return 1;
	}
	
	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items_Chinjufu.ALUMINUM);
	}
}
