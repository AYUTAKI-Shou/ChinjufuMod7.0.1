package com.ayutaki.chinjufumod.handler;

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

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypes_CM {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ChinjufuMod.MOD_ID);

	public static EntityType<SitableEntity> SITABLE = register("sitable", EntityType.Builder.create(SitableEntity::new, EntityClassification.MISC).size(0.0F, 0.0F));

	/* Ammo. ARROW.size(0.5F, 0.5F) FIREBALL.size(1.0F, 1.0F) SMALL_FIREBALL.size(0.3125F, 0.3125F) */
	public static EntityType<AmmoEntity_Small> AMMO_S = register("ammunition_small", EntityType.Builder.<AmmoEntity_Small>create(AmmoEntity_Small::new, EntityClassification.MISC).size(0.5F, 0.5F));
	public static EntityType<AmmoEntity_Medium> AMMO_M = register("ammunition_medium", EntityType.Builder.<AmmoEntity_Medium>create(AmmoEntity_Medium::new, EntityClassification.MISC).size(0.75F, 0.75F));
	public static EntityType<AmmoEntity_Large> AMMO_L = register("ammunition_large", EntityType.Builder.<AmmoEntity_Large>create(AmmoEntity_Large::new, EntityClassification.MISC).size(1.0F, 1.0F));
	public static EntityType<AmmoEntity_Kijyuu> AMMO_K = register("ammunition_kijyuu", EntityType.Builder.<AmmoEntity_Kijyuu>create(AmmoEntity_Kijyuu::new, EntityClassification.MISC).size(0.25F, 0.25F));

	/* Aircraft. If the size of this is larger, it will pass through the mob. */
	public static EntityType<KK_Type97Entity> TYPE97 = register("type97", EntityType.Builder.<KK_Type97Entity>create(KK_Type97Entity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TenzanEntity> TENZAN = register("tenzan", EntityType.Builder.<KK_TenzanEntity>create(KK_TenzanEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_RyuseiEntity> RYUSEI = register("ryusei", EntityType.Builder.<KK_RyuseiEntity>create(KK_RyuseiEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TBFEntity> TBF = register("tbf", EntityType.Builder.<KK_TBFEntity>create(KK_TBFEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_SwordfishEntity> SWORDFISH = register("swordfish", EntityType.Builder.<KK_SwordfishEntity>create(KK_SwordfishEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_BarracudaEntity> BARRACUDA = register("barracuda", EntityType.Builder.<KK_BarracudaEntity>create(KK_BarracudaEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_MosquitoEntity> MOSQUITO = register("mosquito", EntityType.Builder.<KK_MosquitoEntity>create(KK_MosquitoEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static EntityType<KB_Type99Entity> TYPE99 = register("type99", EntityType.Builder.<KB_Type99Entity>create(KB_Type99Entity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KB_SuiseiEntity> SUISEI = register("suisei", EntityType.Builder.<KB_SuiseiEntity>create(KB_SuiseiEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KB_TypeZeroEntity> TYPEZERO = register("typezero", EntityType.Builder.<KB_TypeZeroEntity>create(KB_TypeZeroEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KB_Ju87Entity> JU87 = register("ju87", EntityType.Builder.<KB_Ju87Entity>create(KB_Ju87Entity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KB_Re2001Entity> RE2001 = register("re2001", EntityType.Builder.<KB_Re2001Entity>create(KB_Re2001Entity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KB_SBDEntity> SBD = register("sbd", EntityType.Builder.<KB_SBDEntity>create(KB_SBDEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KB_F4UEntity> F4U = register("f4u", EntityType.Builder.<KB_F4UEntity>create(KB_F4UEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static EntityType<Gyorai61cmEntity> GYORAI61 = register("gyorai", EntityType.Builder.<Gyorai61cmEntity>create(Gyorai61cmEntity::new, EntityClassification.MISC)
			.size(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));

	public static EntityType<ToamiEntity> TOAMI = register("toami", EntityType.Builder.<ToamiEntity>create(ToamiEntity::new, EntityClassification.MISC)
			.size(3.0F, 3.0F).setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	
	///* Register *///
	private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		EntityType<T> type = builder.build(ChinjufuMod.MOD_ID + ":" + name);
		ENTITY_TYPES.register(name, () -> type);
		return type;
	}
}
