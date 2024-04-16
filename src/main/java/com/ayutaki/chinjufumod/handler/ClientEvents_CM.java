package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Kijyuu;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Large;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Medium;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Small;
import com.ayutaki.chinjufumod.entity.render.RenderGyorai61cm;
import com.ayutaki.chinjufumod.entity.render.RenderKB_F4U;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Ju87;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Re2001;
import com.ayutaki.chinjufumod.entity.render.RenderKB_SBD;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Suisei;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Type99;
import com.ayutaki.chinjufumod.entity.render.RenderKB_TypeZero;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Barracuda;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Mosquito;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ryusei;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Swordfish;
import com.ayutaki.chinjufumod.entity.render.RenderKK_TBF;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Tenzan;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Type97;
import com.ayutaki.chinjufumod.entity.render.SitableRenderer;
import com.ayutaki.chinjufumod.entity.render.ToamiRenderer;
import com.ayutaki.chinjufumod.items.armor.model.AkatsukiModel;
import com.ayutaki.chinjufumod.items.armor.model.BattleshipModel;
import com.ayutaki.chinjufumod.items.armor.model.GisouModel;
import com.ayutaki.chinjufumod.items.armor.model.IkkousenModel;
import com.ayutaki.chinjufumod.items.armor.model.KasumiOuter;
import com.ayutaki.chinjufumod.items.armor.model.NagatoModel;
import com.ayutaki.chinjufumod.items.armor.model.RJModel;
import com.ayutaki.chinjufumod.items.armor.model.Ro500_Outer;
import com.ayutaki.chinjufumod.items.armor.model.SendaiModel;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineModel;
import com.ayutaki.chinjufumod.items.armor.model.ToneModel;
import com.ayutaki.chinjufumod.items.armor.model.UKIWA_Model;
import com.ayutaki.chinjufumod.items.armor.model.YUKATA_Model;
import com.ayutaki.chinjufumod.items.armor.model.YuraModel;
import com.ayutaki.chinjufumod.items.armor.model.ZuihouModel;
import com.ayutaki.chinjufumod.particle.AutumnParticle;
import com.ayutaki.chinjufumod.particle.IchohParticle;
import com.ayutaki.chinjufumod.particle.KaedeParticle;
import com.ayutaki.chinjufumod.particle.Particle_Ammo;
import com.ayutaki.chinjufumod.particle.Particle_Mark;
import com.ayutaki.chinjufumod.particle.Particle_ShootK;
import com.ayutaki.chinjufumod.particle.Particle_ShootL;
import com.ayutaki.chinjufumod.particle.Particle_ShootM;
import com.ayutaki.chinjufumod.particle.SakuraParticle;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents_CM {

	/* RenderTypes -> .json "render_type": "cutout", "render_type": "cutout_mipped", "render_type": "translucent", */
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		/** Some client setup code **/
		ChinjufuMod.LOGGER.info("Hello from ChinjufuMod Client Events!");
		/* ItemModels ...eating drinking */
		ItemModelsProperty_CM.register();

		/* Stopped using it in 1.20.2. Screen
		event.enqueueWork(
			() -> MenuScreens.register(MenuTypes_CM.TANSU_MENU.get(), TansuScreen::new)
		); */
	}

	
	/* EntityRender_CM */
	@SubscribeEvent
	public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityTypes_CM.SITABLE.get(), SitableRenderer::new); 
		event.registerEntityRenderer(EntityTypes_CM.TOAMI.get(), renderManager -> new ToamiRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

		event.registerEntityRenderer(EntityTypes_CM.AMMO_L.get(), RenderAmmo_Large::new);
		event.registerEntityRenderer(EntityTypes_CM.AMMO_M.get(), RenderAmmo_Medium::new);
		event.registerEntityRenderer(EntityTypes_CM.AMMO_S.get(), RenderAmmo_Small::new);
		event.registerEntityRenderer(EntityTypes_CM.AMMO_K.get(), RenderAmmo_Kijyuu::new);
		
		event.registerEntityRenderer(EntityTypes_CM.TYPE97.get(), renderManager -> new RenderKK_Type97(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.TENZAN.get(), renderManager -> new RenderKK_Tenzan(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.RYUSEI.get(), renderManager -> new RenderKK_Ryusei(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.TBF.get(), renderManager -> new RenderKK_TBF(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.SWORDFISH.get(), renderManager -> new RenderKK_Swordfish(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.BARRACUDA.get(), renderManager -> new RenderKK_Barracuda(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.MOSQUITO.get(), renderManager -> new RenderKK_Mosquito(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		event.registerEntityRenderer(EntityTypes_CM.TYPE99.get(), renderManager -> new RenderKB_Type99(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.SUISEI.get(), renderManager -> new RenderKB_Suisei(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.TYPEZERO.get(), renderManager -> new RenderKB_TypeZero(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.JU87.get(), renderManager -> new RenderKB_Ju87(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.RE2001.get(), renderManager -> new RenderKB_Re2001(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.SBD.get(), renderManager -> new RenderKB_SBD(renderManager, Minecraft.getInstance().getItemRenderer()));
		event.registerEntityRenderer(EntityTypes_CM.F4U.get(), renderManager -> new RenderKB_F4U(renderManager, Minecraft.getInstance().getItemRenderer()));

		event.registerEntityRenderer(EntityTypes_CM.GYORAI61.get(), renderManager -> new RenderGyorai61cm(renderManager, Minecraft.getInstance().getItemRenderer()));
	}
	
	
	/* ParticleManager_CM */
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerFactories(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ParticleTypes_CM.FALLSAKURA.get(), SakuraParticle.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.FALLKAEDE.get(), KaedeParticle.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.FALLICHOH.get(), IchohParticle.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.FALLKARE.get(), AutumnParticle.Provider::new);
		
		event.registerSpriteSet(ParticleTypes_CM.AMMO_PT.get(), Particle_Ammo.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.SHOOT_PT.get(), Particle_ShootK.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.SHOOTL_PT.get(), Particle_ShootL.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.SHOOTM_PT.get(), Particle_ShootM.Provider::new);
		event.registerSpriteSet(ParticleTypes_CM.MARK_PT.get(), Particle_Mark.Provider::new);
	}
	
	
	/* TintIndex of Block. Small values version. , "tintindex": 1 */
	@SubscribeEvent
	public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event) {
		/** 20 Water=1, 35 CornSoup=2 **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? BiomeColors.getAverageWaterColor(worldIn, pos) : ((tint == 2)? 16441700 : -1); },
				Garden_Blocks.CHOUZUBACHI.get(),
				Garden_Blocks.CHOUZUBACHI_gra.get(),
				Garden_Blocks.CHOUZUBACHI_dio.get(),
				Garden_Blocks.CHOUZUBACHI_and.get(),
				Garden_Blocks.SHISHIODOSHI.get(),
				Garden_Blocks.SHISHIODOSHI2.get(),
				Kitchen_Blocks.KIT_SINK.get(),
				Wood_Blocks.SUIDEN.get(),

				Hakkou_Blocks.MIZUOKE.get(),
				Hakkou_Blocks.MIZUOKE_full.get(),
				Hakkou_Blocks.HAKUSAI_TARU1.get(),
				Hakkou_Blocks.HAKUSAI_TARU2.get(),
				
				Dish_Blocks.KEIRYO_CUP.get(),
				Dish_Blocks.CURRY.get(),
				Dish_Blocks.CURRY_C.get(),
				Dish_Blocks.CURRY_T.get(),
				Dish_Blocks.CURRYSET.get(),
				Dish_Blocks.CURRYSET_C.get(),
				Dish_Blocks.CURRYSET_T.get(),
				Dish_Blocks.ZUNDOU_NCURRY.get(),
				Dish_Blocks.ZUNDOU_NCURRY_C.get(),
				Dish_Blocks.ZUNDOU_NCURRY_T.get(),
				Dish_Blocks.ZUNDOU_RAMEN.get(), /* 6.4.1 */
				Dish_Blocks.ZUNDOU_RSOUP_nama.get(), /* 6.4.1 */
				
				Dish_Blocks.KETTLE_full.get(),
				Dish_Blocks.ZUNDOU_MIZU.get(),
				Dish_Blocks.ZUNDOU_SHIO.get(),
				Dish_Blocks.ZUNDOU_FISH.get(),
				Dish_Blocks.ZUNDOU_UDON.get(),
				Dish_Blocks.ZUNDOU_PASTA.get(),
				
				Dish_Blocks.NABETORI_nama.get(),
				Dish_Blocks.NABEMISO_nama.get(),
				Dish_Blocks.NABEGOHAN_nama.get(),
				Dish_Blocks.NABEGOHANKURI_nama.get(),
				Dish_Blocks.NABEGOHANTAKE_nama.get(),
				Dish_Blocks.NABESHIO_nama.get(),
				Dish_Blocks.NABENIMAME_nama.get(),
				Dish_Blocks.KURI_NABE_nama.get(),
				
				Dish_Blocks.NABECORN_nama.get(),
				Dish_Blocks.NABECORN.get(),
				Dish_Blocks.CORNSOUP.get(),
				Dish_Blocks.EGGBURGSET.get() );
		
		/** 21 Raw_Sake **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 12509680 : -1; },
				Hakkou_Blocks.NAMASAKEGLASS.get() );
		
		/** 22 Sake **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 9223890 : -1; },
				Hakkou_Blocks.SAKEGLASS.get() );
		
		/** 23 Aged_Sake **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 11164250 : -1; },
				Hakkou_Blocks.JUKUSAKEGLASS.get() );
		
		/** 24 Cider **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 15127945 : -1; },
				Hakkou_Blocks.CIDERGLASS.get() );
		
		/** 25 Aged_Cider **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 14588001 : -1; },
				Hakkou_Blocks.JUKUCIDERGLASS.get() );
		
		/** 26 Wine **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 8398655 : -1; },
				Hakkou_Blocks.WINEGLASS.get() );
		
		/** 27 Aged_Wine **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 5715258 : -1; },
				Hakkou_Blocks.JUKUWINEGLASS.get() );
		
		/** 28 Mead **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 13821640 : -1; },
				Hakkou_Blocks.MEADGLASS.get() );
		
		/** 29 Aged_Mead **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 13808770 : -1; },
				Hakkou_Blocks.JUKUMEADGLASS.get() );
		
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		event.register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); },
				Dish_Blocks.KYUSU.get(), 
				Dish_Blocks.JPTEACUP.get(),
				Dish_Blocks.JPTEASET.get(),
				Dish_Blocks.SUSHISET_salmon.get(),
				Dish_Blocks.SUSHISET_fish.get(),
				Dish_Blocks.SUSHISET_beef.get(),
				Dish_Blocks.SUSHISET_tamago.get(),
				Dish_Blocks.SUSHISET_4shoku.get(),
				
				Dish_Blocks.NABETORI.get(),
				Dish_Blocks.NABEMISO.get(),
				Dish_Blocks.TONSUITORI.get(),
				Dish_Blocks.MISOSOUP.get(),
				
				Dish_Blocks.TAMAGOYAKITEI.get(),
				Dish_Blocks.YAKIZAKANATEI.get(),
				Dish_Blocks.YAKIJYAKETEI.get(),
				Dish_Blocks.TAMAGOYAKITEI_TAKE.get(),
				Dish_Blocks.YAKIZAKANATEI_TAKE.get(),
				Dish_Blocks.YAKIJYAKETEI_TAKE.get(),
				Dish_Blocks.TAMAGOYAKITEI_KURI.get(),
				Dish_Blocks.YAKIZAKANATEI_KURI.get(),
				Dish_Blocks.YAKIJYAKETEI_KURI.get() );
		
		/** 31 Black_Tea **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 14493736 : -1; },
				Dish_Blocks.TEAPOT.get(), 
				Dish_Blocks.TEACUP.get(),
				Dish_Blocks.TEASET.get() );

		/** 33 Aku **/
		event.register((state, worldIn, pos, tint) -> { return (tint == 1)? 3297410 : -1; },
				Dish_Blocks.ZUNDOU_AKU.get(),
				Dish_Blocks.ZUNDOU_ORIITO.get() );

		/** 20 Water=1, 34 AMAZAKE=2 **/
		event.register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? BiomeColors.getAverageWaterColor(worldIn, pos) : ((tint == 2)? 16443100 : -1); },
				Hakkou_Blocks.NABEAMAZAKE_nama.get(),
				Hakkou_Blocks.NABEAMAZAKE.get(),
				Hakkou_Blocks.AMAZAKEGLASS.get() );
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		event.register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); },
				Crop_Blocks.ENDEN.get() );
		
		/** 42 KAINASHI=1 **/
		event.register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 15790315 : -1; },
				Crop_Blocks.KAINASHI.get() );
		
		/* BiomeColors.class 設置場所の色を拾う BiomeColors.getFoliageColor(worldIn, pos) */
		/* Biome.class 気温と降雨量から色指定 FoliageColor.get(Temperature, Downfall) 1.0F以上はクラッシュする */
		/** 1 Oak **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.6F) : -1; },
				Garden_Blocks.BONSAI_oak.get(),
				Garden_Blocks.KANYOU.get(),
				Garden_Blocks.IKEGAKILONG.get(),
				Garden_Blocks.IKEGAKI.get() );
		
		/** 2 Spruce **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.getEvergreenColor() : -1; },
				Garden_Blocks.BONSAI_spru.get(),
				Garden_Blocks.KANYOU_spruce.get(),
				Garden_Blocks.IKEGAKILONG_spruce.get(),
				Garden_Blocks.IKEGAKI_spruce.get() );

		/** 3 Birch **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.getBirchColor() : -1; },
				Garden_Blocks.BONSAI_bir.get(),
				Garden_Blocks.KANYOU_birch.get(),
				Garden_Blocks.IKEGAKILONG_birch.get(),
				Garden_Blocks.IKEGAKI_birch.get() );
		
		/** 4 Jungle **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.9F) : -1; }, //緑
				Garden_Blocks.BONSAI_jun.get(),
				Garden_Blocks.KANYOU_jungle.get(),
				Garden_Blocks.IKEGAKILONG_jungle.get(),
				Garden_Blocks.IKEGAKI_jungle.get() );
		
		/** 5 Acacia **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.0F) : -1; },
				Garden_Blocks.BONSAI_aca.get(),
				Garden_Blocks.KANYOU_acacia.get(),
				Garden_Blocks.IKEGAKILONG_acacia.get(),
				Garden_Blocks.IKEGAKI_acacia.get() );
		
		/** 6 DarkOak **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.8F) : -1; }, //黒
				Garden_Blocks.BONSAI_doak.get(),
				Garden_Blocks.KANYOU_darkoak.get(),
				Garden_Blocks.IKEGAKILONG_darkoak.get(),
				Garden_Blocks.IKEGAKI_darkoak.get() );
		
		/** 7 Acer **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 14828063 : -1; },
				Garden_Blocks.BONSAI_kaede.get(),
				Garden_Blocks.KANYOU_kaede.get(),
				Garden_Blocks.IKEGAKILONG_kaede.get(),
				Garden_Blocks.IKEGAKI_kaede.get(),
				Wood_Blocks.KAEDE_leaf.get(),
				Wood_Blocks.KAEDE_carpet.get() );
		
		/** 8 Autumn_Oak **/
		event.register((state, worldIn, pos, tint) -> {
			return (tint == 1)? 11495695 : -1; },
				Garden_Blocks.BONSAI_kare.get(),
				Garden_Blocks.KANYOU_kare.get(),
				Garden_Blocks.IKEGAKILONG_kare.get(),
				Garden_Blocks.IKEGAKI_kare.get(),
				Wood_Blocks.OAKKARE_leaf.get(),
				Wood_Blocks.OCHIBA_carpet.get() );
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		event.register((state, worldIn, pos, tint) -> { 
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); },
				Kitchen_Blocks.KIT_REIZOU.get(),
				Kitchen_Blocks.KIT_REIZOU_TOP.get() );
	}
	
	/* TintIndex of ItemBlock */
	@SubscribeEvent
	public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
		/** 20 Water waterColor(4159204) from Biome=1, 35 CornSoup=2 **/
		event.register((stack, tint) -> {
			return (tint == 1)? 4159204 : ((tint == 2)? 16441700 : -1); },
				Items_Seasonal.SUIDEN.get(),
				Items_Seasonal.KURI_NABE.get(),
				
				Items_Teatime.MIZUOKE_full.get(),
				Items_Teatime.HAKUSAI_TARU1.get(),
				Items_Teatime.HAKUSAI_TARU2.get(),

				Items_Teatime.KEIRYO_CUP_full.get(),
				Items_Teatime.CURRY.get(),
				Items_Teatime.CURRY_C.get(),
				Items_Teatime.CURRY_T.get(),
				Items_Teatime.CURRYSET.get(),
				Items_Teatime.CURRYSET_C.get(),
				Items_Teatime.CURRYSET_T.get(),
				Items_Teatime.ZUNDOU_NCURRY.get(),
				Items_Teatime.ZUNDOU_NCURRY_C.get(),
				Items_Teatime.ZUNDOU_NCURRY_T.get(),
				Items_Teatime.ZUNDOU_RSOUP_nama.get(), /* 6.4.1 */
				
				Items_Teatime.KETTLE_full.get(),
				Items_Teatime.KETTLE_boil.get(),
				Items_Teatime.ZUNDOU_MIZU.get(),
				Items_Teatime.ZUNDOU_SHIO.get(),
				
				Items_Teatime.NABETORI_nama.get(),
				Items_Teatime.NABEMISO_nama.get(),
				Items_Teatime.NABEGOHAN_nama.get(),
				Items_Teatime.NABEGOHANKURI_nama.get(),
				Items_Teatime.NABEGOHANTAKE_nama.get(),
				Items_Teatime.NABESHIO_nama.get(),
				Items_Teatime.NABENIMAME_nama.get(),
				
				Items_Teatime.NABECORN_nama.get(),
				Items_Teatime.NABECORN.get(),
				Items_Teatime.CORNSOUP.get(),
				Items_Teatime.EGGBURGSET.get() );
		
		/** 42 KANSUI 63,98,168 _6.4.1 **/
		event.register((stack, tint) -> { return (tint == 1)? 4154024 : -1; },
				Items_Teatime.KANSUI.get() );
		
		/** 21 Raw_Sake **/
		event.register((stack, tint) -> { return (tint == 1)? 12509680 : -1; },
				Items_Teatime.NAMASAKEGLASS.get() );
		
		/** 22 Sake **/
		event.register((stack, tint) -> { return (tint == 1)? 9223890 : -1; },
				Items_Teatime.SAKEGLASS.get() );
		
		/** 23 Aged_Sake **/
		event.register((stack, tint) -> { return (tint == 1)? 11164250 : -1; },
				Items_Teatime.JUKUSAKEGLASS.get() );
		
		/** 24 Cider **/
		event.register((stack, tint) -> { return (tint == 1)? 15127945 : -1; },
				Items_Teatime.CIDERGLASS.get() );
		
		/** 25 Aged_Cider **/
		event.register((stack, tint) -> { return (tint == 1)? 14588001 : -1; },
				Items_Teatime.JUKUCIDERGLASS.get() );
		
		/** 26 Wine **/
		event.register((stack, tint) -> { return (tint == 1)? 8398655 : -1; },
				Items_Teatime.WINEGLASS.get() );
		
		/** 27 Aged_Wine **/
		event.register((stack, tint) -> { return (tint == 1)? 5715258 : -1; },
				Items_Teatime.JUKUWINEGLASS.get() );
		
		/** 28 Mead **/
		event.register((stack, tint) -> { return (tint == 1)? 13821640 : -1; },
				Items_Teatime.MEADGLASS.get() );
		
		/** 29 Aged_Mead **/
		event.register((stack, tint) -> { return (tint == 1)? 13808770 : -1; },
				Items_Teatime.JUKUMEADGLASS.get() );
		
		/** 30 Green_Tea=1, 32 MisoSoup=2 **/
		event.register((stack, tint) -> { 
			return (tint == 1)? 16775010 : ((tint == 2)? 15772230 : -1); },
				Items_Teatime.KYUSU.get(),
				Items_Teatime.JPTEACUP.get(),
				Items_Teatime.JPTEASET.get(),
				Items_Teatime.SUSHISET_salmon.get(),
				Items_Teatime.SUSHISET_fish.get(),
				Items_Teatime.SUSHISET_beef.get(),
				Items_Teatime.SUSHISET_tamago.get(),
				Items_Teatime.SUSHISET_4shoku.get(),
				
				Items_Teatime.NABETORI.get(),
				Items_Teatime.NABEMISO.get(),
				Items_Teatime.TONSUITORI.get(),
				Items_Teatime.MISOSOUP.get(),
				
				Items_Teatime.TAMAGOYAKITEI.get(),
				Items_Teatime.YAKIZAKANATEI.get(),
				Items_Teatime.YAKIJYAKETEI.get(),
				Items_Teatime.TAMAGOYAKITEI_TAKE.get(),
				Items_Teatime.YAKIZAKANATEI_TAKE.get(),
				Items_Teatime.YAKIJYAKETEI_TAKE.get(),
				Items_Teatime.TAMAGOYAKITEI_KURI.get(),
				Items_Teatime.YAKIZAKANATEI_KURI.get(),
				Items_Teatime.YAKIJYAKETEI_KURI.get() );
		
		/** 31 Black_Tea **/
		event.register((state, tint) -> { return (tint == 1)? 14493736 : -1; },
				Items_Teatime.TEAPOT.get(),
				Items_Teatime.TEACUP.get(),
				Items_Teatime.TEASET.get() );

		/** 33 Aku **/
		event.register((state, tint) -> { return (tint == 1)? 3297410 : -1; },
				Items_Seasonal.ZUNDOU_AKU.get() );

		/** 20 Water=1, 34 AMAZAKE=2 **/
		event.register((state, tint) -> { 
			return (tint == 1)? 4159204 : ((tint == 2)? 16443100 : -1); },
				Items_Teatime.NABEAMAZAKE_nama.get(),
				Items_Teatime.NABEAMAZAKE.get(),
				Items_Teatime.AMAZAKEGLASS.get() );
		
		/** 40 ENDEN=1, 41 ENDEN=2 **/
		event.register((state, tint) -> { 
			return (tint == 1)? 6587090 : ((tint == 2)? 8560880 : -1); },
				Items_Teatime.ENDEN.get() );
		
		
		/** 1 Oak **/
		event.register((state, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.6F) : -1; },
				Items_Wadeco.BONSAI_oak.get(),
				Items_Wadeco.KANYOU.get(),
				Items_Wadeco.IKEGAKILONG.get(),
				Items_Wadeco.IKEGAKI.get() );
		
		/** 2 Spruce **/
		event.register((state, tint) -> {
			return (tint == 1)? FoliageColor.getEvergreenColor() : -1; },
				Items_Wadeco.BONSAI_spru.get(),
				Items_Wadeco.KANYOU_spruce.get(),
				Items_Wadeco.IKEGAKILONG_spruce.get(),
				Items_Wadeco.IKEGAKI_spruce.get() );

		/** 3 Birch **/
		event.register((state, tint) -> {
			return (tint == 1)? FoliageColor.getBirchColor() : -1; },
				Items_Wadeco.BONSAI_bir.get(),
				Items_Wadeco.KANYOU_birch.get(),
				Items_Wadeco.IKEGAKILONG_birch.get(),
				Items_Wadeco.IKEGAKI_birch.get() );
		
		/** 4 Jungle **/
		event.register((state, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.9F) : -1; }, //緑
				Items_Wadeco.BONSAI_jun.get(),
				Items_Wadeco.KANYOU_jungle.get(),
				Items_Wadeco.IKEGAKILONG_jungle.get(),
				Items_Wadeco.IKEGAKI_jungle.get() );
		
		/** 5 Acacia **/
		event.register((state, tint) -> {
			return (tint == 1)? FoliageColor.get(0.9F, 0.0F) : -1; },
				Items_Wadeco.BONSAI_aca.get(),
				Items_Wadeco.KANYOU_acacia.get(),
				Items_Wadeco.IKEGAKILONG_acacia.get(),
				Items_Wadeco.IKEGAKI_acacia.get() );
		
		/** 6 DarkOak **/
		event.register((state, tint) -> {
			return (tint == 1)? FoliageColor.get(0.7F, 0.8F) : -1; }, //黒
				Items_Wadeco.BONSAI_doak.get(),
				Items_Wadeco.KANYOU_darkoak.get(),
				Items_Wadeco.IKEGAKILONG_darkoak.get(),
				Items_Wadeco.IKEGAKI_darkoak.get() );
		
		/** 7 Acer **/
		event.register((state, tint) -> {
			return (tint == 1)? 14828063 : -1; },
				Items_Seasonal.BONSAI_kaede.get(),
				Items_Seasonal.KANYOU_kaede.get(),
				Items_Seasonal.IKEGAKILONG_kaede.get(),
				Items_Seasonal.IKEGAKI_kaede.get(),
				Items_Seasonal.KAEDE_leaf.get(),
				Items_Seasonal.KAEDE_carpet.get() );
		
		/** 8 Autumn_Oak **/
		event.register((state, tint) -> {
			return (tint == 1)? 11495695 : -1; },
				Items_Seasonal.BONSAI_kare.get(),
				Items_Seasonal.KANYOU_kare.get(),
				Items_Seasonal.IKEGAKILONG_kare.get(),
				Items_Seasonal.IKEGAKI_kare.get(),
				Items_Seasonal.OAKKARE_leaf.get(),
				Items_Seasonal.OCHIBA_carpet.get() );
		
		/** Reizou 1=200,200,200 2=225,240,255**/
		event.register((state, tint) -> {
			return (tint == 1)? 13158600 : ((tint == 2)? 14807295 : -1); },
				Items_Teatime.KIT_REIZOU.get() );
	}
	
	
	/* ArmorRender_CM */
	@SubscribeEvent
	public static void registerEntityRenderingHandler(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ArmorLayer_CM.GISOU_INNER, () -> LayerDefinition.create(GisouModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.GISOU_OUTER, () -> LayerDefinition.create(GisouModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.AKATSUKI_INNER, () -> LayerDefinition.create(AkatsukiModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.AKATSUKI_OUTER, () -> LayerDefinition.create(AkatsukiModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.KASUMI_OUTER, () -> LayerDefinition.create(KasumiOuter.createOuter(), 64, 120));
		
		event.registerLayerDefinition(ArmorLayer_CM.SENDAI_INNER, () -> LayerDefinition.create(SendaiModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.SENDAI_OUTER, () -> LayerDefinition.create(SendaiModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.YURA_INNER, () -> LayerDefinition.create(YuraModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.YURA_OUTER, () -> LayerDefinition.create(YuraModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.TONE_INNER, () -> LayerDefinition.create(ToneModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.TONE_OUTER, () -> LayerDefinition.create(ToneModel.createOuter(), 64, 120));

		event.registerLayerDefinition(ArmorLayer_CM.RJ_INNER, () -> LayerDefinition.create(RJModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RJ_OUTER, () -> LayerDefinition.create(RJModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.ZUIHOU_INNER, () -> LayerDefinition.create(ZuihouModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.ZUIHOU_OUTER, () -> LayerDefinition.create(ZuihouModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.IKKOU_INNER, () -> LayerDefinition.create(IkkousenModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.IKKOU_OUTER, () -> LayerDefinition.create(IkkousenModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RJ_INNER, () -> LayerDefinition.create(RJModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RJ_OUTER, () -> LayerDefinition.create(RJModel.createOuter(), 64, 120));
		
		event.registerLayerDefinition(ArmorLayer_CM.SENKAN_INNER, () -> LayerDefinition.create(BattleshipModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.SENKAN_OUTER, () -> LayerDefinition.create(BattleshipModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.NAGATO_INNER, () -> LayerDefinition.create(NagatoModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.NAGATO_OUTER, () -> LayerDefinition.create(NagatoModel.createOuter(), 64, 120));
		
		event.registerLayerDefinition(ArmorLayer_CM.SUBMARINE_INNER, () -> LayerDefinition.create(SubmarineModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.SUBMARINE_OUTER, () -> LayerDefinition.create(SubmarineModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.UKIWA_INNER, () -> LayerDefinition.create(UKIWA_Model.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RO500_OUTER, () -> LayerDefinition.create(Ro500_Outer.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RO500_OUTER_C, () -> LayerDefinition.create(UKIWA_Model.ro500_OuterC(), 64, 120));

		
		event.registerLayerDefinition(ArmorLayer_CM.YUKATA_INNER, () -> LayerDefinition.create(YUKATA_Model.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.YUKATA_OUTER, () -> LayerDefinition.create(YUKATA_Model.createOuter(), 64, 120));
	}
}
