package com.ayutaki.chinjufumod;

import org.apache.logging.log4j.Logger;

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
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.ChestLoot_CM;
import com.ayutaki.chinjufumod.handler.FlammableBlocks_CM;
import com.ayutaki.chinjufumod.handler.GuiHandler_CM;
import com.ayutaki.chinjufumod.handler.OreDictionary_CM;
import com.ayutaki.chinjufumod.handler.SmeltingRecipe_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.proxy.CommonProxy;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;
import com.ayutaki.chinjufumod.tileentity.CStove_TileEntity;
import com.ayutaki.chinjufumod.tileentity.KitOvenB_TileEntity;
import com.ayutaki.chinjufumod.tileentity.KitOven_TileEntity;
import com.ayutaki.chinjufumod.tileentity.ReizouTop_TileEntity;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;
import com.ayutaki.chinjufumod.world.generate.CM_OreGen;
import com.ayutaki.chinjufumod.world.generate.KuriBush_Gen;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ChinjufuMod.MOD_ID, name = ChinjufuMod.MOD_NAME,
		version = ChinjufuMod.MOD_VERSION, guiFactory = ChinjufuMod.GUI_FACTORY)
public class ChinjufuMod {

	/* 参照する値をここで管理 Manage referenced values here. */
	public static final String MOD_ID = "chinjufumod";
	public static final String MOD_NAME = "ChinjufuMod";
	public static final String MOD_VERSION = "[1.12.2]7.0.1";
	public static final String GUI_FACTORY = "com.ayutaki.chinjufumod.gui.ConfigCM_Screen";

	public static final String CLIENT_PROXY_CLASS = "com.ayutaki.chinjufumod.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.ayutaki.chinjufumod.proxy.CommonProxy";


	/* クラス(設計書)をインスタンス(製品)にする Change Class to Instance. */
	@Instance
	public static ChinjufuMod instance;

	/* プロキシの登録 Register Proxy. */
	@SidedProxy(clientSide = ChinjufuMod.CLIENT_PROXY_CLASS, serverSide = ChinjufuMod.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	/* エラーログの出力 Output Error log. */
	private static Logger logger;


	/* エンティティの登録, コンフィグ読込など Register Entity and Config. */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();

		MinecraftForge.EVENT_BUS.register(new Config_CM());
		Config_CM.init(event.getSuggestedConfigurationFile());

		proxy.preInit();
		proxy.registerEntityRender();

		int entityID = 0;
		/* EntityRegistry.registerModEntity(registryName,
		 * 		entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates); */
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:mountable_block"),
				SitableEntity.class, "MountableBlock", ++entityID, this, 80, 1, false);

		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_kc"),
				AmmoEntity_Large.class, "ammunition_kc", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_medium"),
				AmmoEntity_Medium.class, "ammunition_medium", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_small"),
				AmmoEntity_Small.class, "ammunition_small", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_kijyuu"),
				AmmoEntity_Kijyuu.class, "ammunition_kijyuu", ++entityID, this, 64, 1, true);

		/* 艦載機 */
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_type97kk"),
				KK_Type97Entity.class, "type97kk", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tenzan"),
				KK_TenzanEntity.class, "tenzan", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ryusei"),
				KK_RyuseiEntity.class, "ryusei", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tbf"),
				KK_TBFEntity.class, "tbf", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_swordfish"),
				KK_SwordfishEntity.class, "swordfish", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_barracuda"),
				KK_BarracudaEntity.class, "barracuda", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_mosquito"),
				KK_MosquitoEntity.class, "mosquito", ++entityID, this, 64, 1, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_type99"),
				KB_Type99Entity.class, "type99", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_suisei"),
				KB_SuiseiEntity.class, "suisei", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_typezero"),
				KB_TypeZeroEntity.class, "typezero", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_ju87"),
				KB_Ju87Entity.class, "ju87", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_re2001"),
				KB_Re2001Entity.class, "re2001", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_sbd"),
				KB_SBDEntity.class, "sbd", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kb_f4u"),
				KB_F4UEntity.class, "f4u", ++entityID, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_gyorai"),
				Gyorai61cmEntity.class, "gyorai", ++entityID, this, 64, 1, true);

		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_toami"),
				ToamiEntity.class, "toami", ++entityID, this, 64, 1, true);

		/* registerTileEntity(Class<? extends TileEntity> tileEntityClass, ResourceLocation key) */
		GameRegistry.registerTileEntity(CStove_TileEntity.class, new ResourceLocation("chinjufumod:cstove"));
		GameRegistry.registerTileEntity(KitOven_TileEntity.class, new ResourceLocation("chinjufumod:kitoven"));
		GameRegistry.registerTileEntity(KitOvenB_TileEntity.class, new ResourceLocation("chinjufumod:kitoven_b"));
		GameRegistry.registerTileEntity(Tansu_TileEntity.class, new ResourceLocation("chinjufumod:tansu"));
		GameRegistry.registerTileEntity(Reizou_TileEntity.class, new ResourceLocation("chinjufumod:reizou"));
		GameRegistry.registerTileEntity(ReizouTop_TileEntity.class, new ResourceLocation("chinjufumod:reizou_top"));
		
		/* 赤石が影響するブロック */
		Door_Blocks.load(event);
		Garasudo_Blocks.load(event);
		Shouji_Blocks.load(event);
		Fusuma_Blocks.load(event);
		Gate_Blocks.load(event);

		proxy.registerModels();
	}

	/* レシピ・鉱石などの追加 Register Recipe and Ore. */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
		proxy.init();

		GameRegistry.registerWorldGenerator(new CM_OreGen(), 0);
		GameRegistry.registerWorldGenerator(new KuriBush_Gen(), 1);
		OreDictionary_CM.registerOreDictionary();
		SmeltingRecipe_CM.registerSmeltingRecipes();
		SoundEvents_CM.registerSounds();
		FlammableBlocks_CM.init();
		MinecraftForge.EVENT_BUS.register(new ChestLoot_CM());
		
		/* Screen */
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler_CM());

		for (Biomes_CM.ModBiomeEntry biomeEntry : Biomes_CM.biomeEntryList) {
			if (biomeEntry.getWeight() > 0) {
				BiomeManager.addBiome(biomeEntry.getType(), biomeEntry.getEntry());
				BiomeManager.addStrongholdBiome(biomeEntry.getBiome());
			}
		}
	}

	/* 他Modとの連携 Cooperation with other Mod. */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
}
