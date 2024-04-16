package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.Multimap;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Gyorai61cm extends Item {

	private final float attackDamage = 11.0F - 1.0F;
	private final float attackSpeed = -2.4F;

	public Gyorai61cm(Properties properties) {
		super(properties.group(ItemGroups_CM.CMARMOR));
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	/* Hold it in your hand. */
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.shrink(1);
		return true;
	}

	@Override
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn) {
		return !playerIn.isCreative();
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity attacker) {
		stack.shrink(1);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}

	/* RightClick Action*/
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.abilities.isCreativeMode;

		if (!playerIn.getCooldownTracker().hasCooldown(this)) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM.GYORAI, SoundCategory.MASTER, 1.0F, 1.0F);
			
			if (!worldIn.isRemote) {
				Gyorai61cmEntity kansaiki = new Gyorai61cmEntity(playerIn, worldIn, stack);
				int power = 8; // Add the speed and distance of the Entity.
				
				boolean suirai = (ShipTypes_CM.typeDestroyer(playerIn) || ShipTypes_CM.typeCruiser(playerIn) || ShipTypes_CM.typeSubmarine(playerIn));
				double LEVEL = (playerIn.experienceLevel >= 25)? 3.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 2.0D : 
					((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 1.0D : 0.0D));
				
				double criticalA = (worldIn.rand.nextInt(3) == 0)? 3.0D : 0.0D;
				double criticalB = (worldIn.rand.nextInt(9) == 0)? 1.0D : 0.0D;
				
				if (suirai) {
					kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * power, 1.0F);
					kansaiki.setBaseDamage(kansaiki.getBaseDamage() + 1.0D + LEVEL + criticalA); }
				
				if (!suirai) {
					kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.2F * power, 1.0F);
					kansaiki.setBaseDamage(kansaiki.getBaseDamage() + LEVEL + criticalB); }
				
				worldIn.addEntity(kansaiki);
			}
	
			playerIn.addStat(Stats.ITEM_USED.get(this));
			if (!mode) { stack.shrink(1); }
			playerIn.getCooldownTracker().setCooldown(this, 15);
		}
		return ActionResult.resultSuccess(stack);
	}

	/* Return the enchantability factor of the item, most of the time is based on material. */
	@Override
	public int getItemEnchantability() {
		return 1;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_gyorai").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_gyorai2").applyTextStyle(TextFormatting.DARK_GREEN));
	}
}
