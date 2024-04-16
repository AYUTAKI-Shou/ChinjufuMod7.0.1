package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ItemModelsProperty_CM {

	///* Register *///
	public static void register() {
		ItemProperties.register(Items_Teatime.CURRY.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Teatime.CURRY_C.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } ); //1.18 not fix
		
		ItemProperties.register(Items_Teatime.CURRY_T.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } ); //1.18 not fix
		

		ItemProperties.register(Items_Teatime.TEACUP.get(), new ResourceLocation("drink"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		
		/* Small */
		ItemProperties.register(Items_Weapon.RENSOUHOU_127.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.SHIGUREHOU.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.KOUKAKUHOU_100.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Middle */
		ItemProperties.register(Items_Weapon.RENSOUHOU_155.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.RENSOUHOU_203.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.RENSOUHOU_SKC.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Large */
		ItemProperties.register(Items_Weapon.RENSOUHOU_356.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.RENSOUHOU_356S3.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.RENSOUHOU_380.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.RENSOUHOU_410.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Kijyuu */
		ItemProperties.register(Items_Weapon.KIJYUU.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.SOUGANKYOU.get(), new ResourceLocation("spyglass"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		
		/* Shield */
		ItemProperties.register(Items_Weapon.SHIELD_kuchiku.get(), new ResourceLocation("blocking"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.SHIELD_yura.get(), new ResourceLocation("blocking"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.SHIELD_mogami.get(), new ResourceLocation("blocking"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.SHIELD_kongou.get(), new ResourceLocation("blocking"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		
		/* kansaiki */
		ItemProperties.register(Items_Weapon.TYPE97KK.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.TENZAN.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.RYUSEI.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.SWORDFISH.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.BARRACUDA.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.MOSQUITO.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.TBF.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemProperties.register(Items_Weapon.TYPE99.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.SUISEI.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.TYPEZERO.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.RE2001.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.JU87.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.SBD.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Weapon.F4U.get(), new ResourceLocation("pull"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		
		/* BENTOU */
		ItemProperties.register(Items_Teatime.BENTOU.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Teatime.SHAKEBEN.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Teatime.BENTOU_TAKE.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Teatime.SHAKEBEN_TAKE.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Teatime.BENTOU_KURI.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		ItemProperties.register(Items_Teatime.SHAKEBEN_KURI.get(), new ResourceLocation("eat"), (stack, worldIn, entity, flag) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
	}
}
