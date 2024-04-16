package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
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
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public Gyorai61cm(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.CMARMOR));

		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
		return slot == EquipmentSlotType.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
	}

	/* Hold it in your hand. */
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.shrink(1);
		return true;
	}

	@Override
	public boolean canAttackBlock(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn) {
		return !playerIn.isCreative();
	}

	@Override
	public boolean mineBlock(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity attacker) {
		stack.shrink(1);
		return true;
	}

	/* RightClick Action*/
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.abilities.instabuild;

		if (!playerIn.getCooldowns().isOnCooldown(this)) {
			worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.GYORAI, SoundCategory.MASTER, 1.0F, 1.0F);
			
			if (!worldIn.isClientSide) {
				Gyorai61cmEntity kansaiki = new Gyorai61cmEntity(playerIn, worldIn, stack);
				int POWER = 8; // Add the speed and distance of the Entity.
				
				boolean suirai = (ShipTypes_CM.typeDestroyer(playerIn) || ShipTypes_CM.typeCruiser(playerIn) || ShipTypes_CM.typeSubmarine(playerIn));
				float basePower = suirai? 0.25F : 0.2F;
				double LEVEL = (playerIn.experienceLevel >= 25)? 3.0D : ((playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25)? 2.0D : 
					((playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19)? 1.0D : 0.0D));
				
				if (suirai) { kansaiki.setSuirai(true); }
				int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, stack);
				
				kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, basePower * POWER, 1.0F);
				if (j == 0) { kansaiki.setBaseDamage(kansaiki.getBaseDamage() + LEVEL); }
				if (j > 0) { kansaiki.setBaseDamage(kansaiki.getBaseDamage() + LEVEL + (double)j * 0.5D); }
				worldIn.addFreshEntity(kansaiki);
			}
	
			playerIn.awardStat(Stats.ITEM_USED.get(this));
			if (!mode) { stack.shrink(1); }
			playerIn.getCooldowns().addCooldown(this, 15);
		}
		
		return ActionResult.sidedSuccess(stack, worldIn.isClientSide());
	}

	/* Return the enchantability factor of the item, most of the time is based on material. */
	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_gyorai").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_gyorai2").withStyle(TextFormatting.DARK_GREEN));
	}
}
