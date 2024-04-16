package com.ayutaki.chinjufumod.proxy;

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
import com.ayutaki.chinjufumod.entity.ToamiEntity;
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
import com.ayutaki.chinjufumod.entity.render.ToamiRender;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.TintColors_CM;
import com.ayutaki.chinjufumod.particle.AutumnParticle;
import com.ayutaki.chinjufumod.particle.IchohParticle;
import com.ayutaki.chinjufumod.particle.KaedeParticle;
import com.ayutaki.chinjufumod.particle.Particle_Ammo;
import com.ayutaki.chinjufumod.particle.Particle_Mark;
import com.ayutaki.chinjufumod.particle.SakuraParticle;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.ayutaki.chinjufumod.registry.doors.Door_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Gate_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Shouji_BlockModels;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/* クライアントプロキシはコモンプロキシを拡張するクラス
* Client proxy is a class that extends common proxy. */
public class ClientProxy extends CommonProxy {

	public static boolean rendering = false;
	public static Entity renderEntity = null;
	public static Entity backupEntity = null;

	/* エンティティの登録, コンフィグ読込など
	* Register Entity and Config. */
	@Override
	public void preInit() {
		//TileEntityItemStackRenderer.instance = new RenderShield(TileEntityItemStackRenderer.instance);
	}

	/* レシピ・鉱石などの追加 Register Recipe and Ore. */
	@Override
	public void init() {
		TintColors_CM.registerColorHandlers();
	}

	/* 他Modとの連携 Cooperation with other Mod. */
	@Override
	public void postInit() { }

	/* シングルプレイかどうか Single play or not? */
	@Override
	public boolean isSinglePlayer() {
		return Minecraft.getMinecraft().isSingleplayer();
	}

	/* サーバープレイかどうか Sever play or not? */
	@Override
	public boolean isDedicatedServer() {
		return false;
	}

	/* 赤石が影響するブロック */
	public void registerModels() {
		Garasudo_BlockModels.registerRender();
		Door_BlockModels.registerRender();
		Shouji_BlockModels.registerRender();
		Fusuma_BlockModels.registerRender();
		Gate_BlockModels.registerRender();
	}

	@Override
	public ModelBiped getArmorModel(int id) {
		return null;
	}

	/* エンティティのレンダリング */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerEntityRender() {

		RenderingRegistry.registerEntityRenderingHandler(AmmoEntity_Large.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				 return new RenderAmmo_Large(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(AmmoEntity_Medium.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				 return new RenderAmmo_Medium(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(AmmoEntity_Small.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				 return new RenderAmmo_Small(manager);
			}
		});

		
		/* 艦載機 -> 雪玉の応用でアイテムモデルを投げる */
		RenderingRegistry.registerEntityRenderingHandler(KK_Type97Entity.class, renderManager ->
		new RenderKK_Type97(renderManager, Items_Weapon.TYPE97KK, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(KK_TenzanEntity.class, renderManager ->
		new RenderKK_Tenzan(renderManager, Items_Weapon.TENZAN, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(KK_RyuseiEntity.class, renderManager ->
		new RenderKK_Ryusei(renderManager, Items_Weapon.RYUSEI, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(KK_TBFEntity.class, renderManager ->
		new RenderKK_TBF(renderManager, Items_Weapon.TBF, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(KK_SwordfishEntity.class, renderManager ->
		new RenderKK_Swordfish(renderManager, Items_Weapon.SWORDFISH, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(KK_BarracudaEntity.class, renderManager ->
		new RenderKK_Barracuda(renderManager, Items_Weapon.BARRACUDA, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KK_MosquitoEntity.class, renderManager ->
		new RenderKK_Mosquito(renderManager, Items_Weapon.MOSQUITO, Minecraft.getMinecraft().getRenderItem()));
		
		
		RenderingRegistry.registerEntityRenderingHandler(KB_Type99Entity.class, renderManager ->
		new RenderKB_Type99(renderManager, Items_Weapon.TYPE99, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KB_SuiseiEntity.class, renderManager ->
		new RenderKB_Suisei(renderManager, Items_Weapon.SUISEI, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KB_TypeZeroEntity.class, renderManager ->
		new RenderKB_TypeZero(renderManager, Items_Weapon.TYPEZERO, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KB_Ju87Entity.class, renderManager ->
		new RenderKB_Ju87(renderManager, Items_Weapon.JU87, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KB_Re2001Entity.class, renderManager ->
		new RenderKB_Re2001(renderManager, Items_Weapon.RE2001, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KB_SBDEntity.class, renderManager ->
		new RenderKB_SBD(renderManager, Items_Weapon.SBD, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(KB_F4UEntity.class, renderManager ->
		new RenderKB_F4U(renderManager, Items_Weapon.F4U, Minecraft.getMinecraft().getRenderItem()));
		
		/* 魚雷*/
		RenderingRegistry.registerEntityRenderingHandler(Gyorai61cmEntity.class, renderManager ->
		new RenderGyorai61cm(renderManager, Items_Weapon.GYORAI_61cm, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(ToamiEntity.class, renderManager ->
		new ToamiRender(renderManager, Items_Teatime.TOAMI_W, Minecraft.getMinecraft().getRenderItem()));
	}
	
	/* 落葉 -> パーティクルに変更 */
	@Override
	public void spawnParticle(ParticleTypes_CM particleType, double x, double y, double z, double vx, double vy, double vz) {

		Minecraft mc = FMLClientHandler.instance().getClient();
		Entity entity = mc.getRenderViewEntity();
		World world = mc.world;

		if (entity != null && mc.effectRenderer != null) {

			int i = mc.gameSettings.particleSetting;
			double dx = entity.posX - x;
			double dy = entity.posY - y;
			double dz = entity.posZ - z;
			
			if (i == 1 && world.rand.nextInt(3) == 0) { i = 2; }

			if (dx * dx + dy * dy + dz * dz <= 1024D && i <= 1) {
				Particle particle = null;
				
				switch (particleType) {
				
				case FALLSAKURA:
					particle = new SakuraParticle(world, x, y, z, vx, vy, vz);
					break;
				case FALLKAEDE:
					particle = new KaedeParticle(world, x, y, z, vx, vy, vz);
					break;
				case FALLICHOH:
					particle = new IchohParticle(world, x, y, z, vx, vy, vz);
					break;
				case FALLKARE:
					particle = new AutumnParticle(world, x, y, z, vx, vy, vz);
					break;

				case AMMO_PT:
					particle = new Particle_Ammo(world, x, y, z, vx, vy, vz);
					break;
				case MARK_PT:
					particle = new Particle_Mark(world, x, y, z, vx, vy, vz);
					break;
					
				default: break;
				} //Particle particle = ParticleFactory_CM.createParticle(particleType, world, x, y, z, vx, vy, vz);
				
				if (particle != null) {
					mc.effectRenderer.addEffect(particle);
				}
			}
		}
	}
}
