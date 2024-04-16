package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ItemModelsProperty_CM {

	///* Register *///
	public static void register() {

		ItemModelsProperties.register(Items_Teatime.CURRY, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Teatime.CURRY_C, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.CURRY_T, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.TEACUP, new ResourceLocation("drink"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		
		/* Small */
		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_127, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIGUREHOU, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.KOUKAKUHOU_100, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Middle */
		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_155, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_203, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_SKC, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Large */
		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_356, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_356S3, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_380, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_410, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		/* Kijyuu */
		ItemModelsProperties.register(Items_Weapon.KIJYUU, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.SOUGANKYOU, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		
		/* Shield */
		ItemModelsProperties.register(Items_Weapon.SHIELD_kuchiku, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIELD_yura, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIELD_mogami, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIELD_kongou, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		
		/* kansaiki */
		ItemModelsProperties.register(Items_Weapon.TYPE97KK, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.TENZAN, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.RYUSEI, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.SWORDFISH, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.BARRACUDA, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.MOSQUITO, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.TBF, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.TYPE99, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.SUISEI, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.TYPEZERO, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.RE2001, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.JU87, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.SBD, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Weapon.F4U, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		
		/* BENTOU */
		ItemModelsProperties.register(Items_Teatime.BENTOU, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.SHAKEBEN, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.BENTOU_TAKE, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.SHAKEBEN_TAKE, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.BENTOU_KURI, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemModelsProperties.register(Items_Teatime.SHAKEBEN_KURI, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
	}
}
