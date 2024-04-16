package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class KB_SuiseiEntity extends AbstractKK_Entity {

	private ItemStack projectile = new ItemStack(Items_Weapon.SUISEI);
	private double baseDamage = 8.0D; /** 彗星 爆装+8 **/
	
	public KB_SuiseiEntity(EntityType<KB_SuiseiEntity> type, World world) {
		super(type, world);
	}

	public KB_SuiseiEntity(LivingEntity entityIn, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.SUISEI, entityIn, worldIn);
		projectile = stack.copy();
	}

	protected Item getDefaultItem() {
		return this.projectile.getItem();
	}
	
	/** Collision to Entity. **/
	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		Entity thrower = getOwner();

		if (!level.isClientSide && result.getEntity() instanceof LivingEntity && result.getEntity() != thrower) {
			/** Do not attack Friendly Mobs. **/
			boolean friendly = (result.getEntity() instanceof VillagerEntity || result.getEntity() instanceof HorseEntity || 
					result.getEntity() instanceof DonkeyEntity || result.getEntity() instanceof TameableEntity ||
					result.getEntity() instanceof IronGolemEntity);
			
			if (friendly) {
				playSound(SoundEvents_CM.KK_STOP, 2.0F, 1.0F);
				dropAndKill(); }

			if (!friendly) {
				double atackDamage = this.baseDamage;
				float criticalA = (this.random.nextInt(4) == 0)? 1.2F : 1.0F;
				float criticalB = (this.random.nextInt(8) == 0)? 1.1F : 0.9F;
				float addKANBAKU = this.isCarrier()? criticalA : criticalB;
				
				result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), (float)atackDamage * addKANBAKU);
				
				this.playSound((addKANBAKU > 1.0F)? SoundEvents_CM.KK_ATACK2 : SoundEvents_CM.KK_ATACK, 2.0F, 1.0F);
			}
		}
	}

	/* Reflects durability value with "stack.copy()". */
	protected ItemStack getItemStack() {
		return projectile.copy();
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putDouble("damage", this.baseDamage);
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("damage", 99)) {
			this.baseDamage = compound.getDouble("damage"); }
	}
	
	public void setBaseDamage(double damage) {
		this.baseDamage = damage;
	}
	
	public double getBaseDamage() {
		return this.baseDamage;
	}
}
