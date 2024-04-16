package com.ayutaki.chinjufumod.handler;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Kijyuu;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Large;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Medium;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Small;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity;
import com.ayutaki.chinjufumod.entity.KB_F4UEntity;
import com.ayutaki.chinjufumod.entity.KB_Ju87Entity;
import com.ayutaki.chinjufumod.entity.KB_Re2001Entity;
import com.ayutaki.chinjufumod.entity.KB_SBDEntity;
import com.ayutaki.chinjufumod.entity.KB_SuiseiEntity;
import com.ayutaki.chinjufumod.entity.KB_Type99Entity;
import com.ayutaki.chinjufumod.entity.KB_TypeZeroEntity;
import com.ayutaki.chinjufumod.entity.KK_BarracudaEntity;
import com.ayutaki.chinjufumod.entity.KK_MosquitoEntity;
import com.ayutaki.chinjufumod.entity.KK_RyuseiEntity;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity;
import com.ayutaki.chinjufumod.entity.KK_TenzanEntity;
import com.ayutaki.chinjufumod.entity.KK_Type97Entity;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.entity.ToamiEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypes_CM {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<EntityType<SitableEntity>> SITABLE = register("entity_sit", 
			() -> EntityType.Builder.<SitableEntity>of(SitableEntity::new, MobCategory.MISC).sized(0.0F, 0.0F));
	
	public static final RegistryObject<EntityType<ToamiEntity>> TOAMI = register("toami", 
			() -> EntityType.Builder.<ToamiEntity>of(ToamiEntity::new, MobCategory.MISC)
			.sized(3.0F, 3.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	/* Ammo ARROW.sized(0.5F, 0.5F) FIREBALL.sized(1.0F, 1.0F) SMALL_FIREBALL.sized(0.3125F, 0.3125F)*/
	public static final RegistryObject<EntityType<AmmoEntity_Small>> AMMO_S = register("ammunition_small", 
			() -> EntityType.Builder.<AmmoEntity_Small>of(AmmoEntity_Small::new, MobCategory.MISC).sized(0.5F, 0.5F));
	public static final RegistryObject<EntityType<AmmoEntity_Medium>> AMMO_M = register("ammunition_medium", 
			() -> EntityType.Builder.<AmmoEntity_Medium>of(AmmoEntity_Medium::new, MobCategory.MISC).sized(0.75F, 0.75F));
	public static final RegistryObject<EntityType<AmmoEntity_Large>> AMMO_L = register("ammunition_large", 
			() -> EntityType.Builder.<AmmoEntity_Large>of(AmmoEntity_Large::new, MobCategory.MISC).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<AmmoEntity_Kijyuu>> AMMO_K = register("ammunition_kijyuu", 
			() -> EntityType.Builder.<AmmoEntity_Kijyuu>of(AmmoEntity_Kijyuu::new, MobCategory.MISC).sized(0.25F, 0.25F));
	
	/* Aircraft */
	public static final RegistryObject<EntityType<KK_Type97Entity>> TYPE97 = register("type97", 
			() -> EntityType.Builder.<KK_Type97Entity>of(KK_Type97Entity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KK_TenzanEntity>> TENZAN = register("tenzan", 
			() -> EntityType.Builder.<KK_TenzanEntity>of(KK_TenzanEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KK_RyuseiEntity>> RYUSEI = register("ryusei", 
			() -> EntityType.Builder.<KK_RyuseiEntity>of(KK_RyuseiEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KK_TBFEntity>> TBF = register("tbf", 
			() -> EntityType.Builder.<KK_TBFEntity>of(KK_TBFEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KK_SwordfishEntity>> SWORDFISH = register("swordfish", 
			() -> EntityType.Builder.<KK_SwordfishEntity>of(KK_SwordfishEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KK_BarracudaEntity>> BARRACUDA = register("barracuda", 
			() -> EntityType.Builder.<KK_BarracudaEntity>of(KK_BarracudaEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KK_MosquitoEntity>> MOSQUITO = register("mosquito", 
			() -> EntityType.Builder.<KK_MosquitoEntity>of(KK_MosquitoEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<KB_Type99Entity>> TYPE99 = register("type99", 
			() -> EntityType.Builder.<KB_Type99Entity>of(KB_Type99Entity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KB_SuiseiEntity>> SUISEI = register("suisei", 
			() -> EntityType.Builder.<KB_SuiseiEntity>of(KB_SuiseiEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KB_TypeZeroEntity>> TYPEZERO = register("typezero", 
			() -> EntityType.Builder.<KB_TypeZeroEntity>of(KB_TypeZeroEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KB_Ju87Entity>> JU87 = register("ju87", 
			() -> EntityType.Builder.<KB_Ju87Entity>of(KB_Ju87Entity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KB_Re2001Entity>> RE2001 = register("re2001", 
			() -> EntityType.Builder.<KB_Re2001Entity>of(KB_Re2001Entity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KB_SBDEntity>> SBD = register("sbd", 
			() -> EntityType.Builder.<KB_SBDEntity>of(KB_SBDEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<KB_F4UEntity>> F4U = register("f4u", 
			() -> EntityType.Builder.<KB_F4UEntity>of(KB_F4UEntity::new, MobCategory.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<Gyorai61cmEntity>> GYORAI61 = register("gyorai", 
			() -> EntityType.Builder.<Gyorai61cmEntity>of(Gyorai61cmEntity::new, MobCategory.MISC)
			.sized(1.0F, 1.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> builder) {
		ResourceLocation location = new ResourceLocation(ChinjufuMod.MOD_ID, name);
		return ENTITY_TYPES.register(name, () -> builder.get().build(location.toString()));
	}
	/* EntityRender_CM -> ClientEvents */
}
