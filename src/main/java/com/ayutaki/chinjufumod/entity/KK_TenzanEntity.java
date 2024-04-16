package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class KK_TenzanEntity extends AbstractKK_Entity {
	
	private ItemStack projectile = new ItemStack(Items_Weapon.TENZAN.get());
	private double baseDamage = 7.0D; /** 天山 雷装 +7 **/
	
	public KK_TenzanEntity(EntityType<KK_TenzanEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	public KK_TenzanEntity(LivingEntity entityIn, Level world, ItemStack stack) {
		super(EntityTypes_CM.TENZAN.get(), entityIn, world);
		this.projectile = stack.copy();
	}

	protected Item getDefaultItem() {
		return this.projectile.getItem();
	}
	
	/** Collision to Entity. **/
	@SuppressWarnings("resource")
	@Override
	protected void onHitEntity(@Nonnull EntityHitResult result) {
		super.onHitEntity(result);
		Entity thrower = getOwner();
		
		if (!level().isClientSide && result.getEntity() instanceof LivingEntity && result.getEntity() != thrower) {
			/** Do not attack Friendly Mobs. **/
			boolean friendly = (result.getEntity() instanceof Villager || result.getEntity() instanceof Horse || 
					result.getEntity() instanceof Donkey || result.getEntity() instanceof TamableAnimal ||
					result.getEntity() instanceof IronGolem);
			
			if (friendly) {
				playSound(SoundEvents_CM.KK_STOP.get(), 2.0F, 1.0F);
				dropAndKill(); }

			if (!friendly) {
				double atackDamage = this.baseDamage;
				float criticalA = (this.random.nextInt(2) == 0)? 1.5F : 0.9F;
				float criticalB = (this.random.nextInt(8) == 0)? 1.2F : 0.8F;
				float addKANKOU = this.isCarrier()? criticalA : criticalB;

				result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), (float)atackDamage * addKANKOU);
				
				this.playSound((addKANKOU > 1.0F)? SoundEvents_CM.KK_ATACK2.get() : SoundEvents_CM.KK_ATACK.get(), 2.0F, 1.0F);
			}
		}
	}

	/* Reflects durability value with "stack.copy()". */
	protected ItemStack getItemStack() {
		return projectile.copy();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putDouble("damage", this.baseDamage);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
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
