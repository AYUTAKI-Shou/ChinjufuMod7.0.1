package com.ayutaki.chinjufumod;

import java.util.stream.Collectors;

import org.slf4j.Logger;

import com.ayutaki.chinjufumod.gui.TansuScreen;
import com.ayutaki.chinjufumod.handler.AddTag_CM;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.BlockEntity_CM;
import com.ayutaki.chinjufumod.handler.CompostableItems_CM;
import com.ayutaki.chinjufumod.handler.EntityRender_CM;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.ItemModelsProperty_CM;
import com.ayutaki.chinjufumod.handler.MenuTypes_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.RenderTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.handler.TintColors_CM;
import com.ayutaki.chinjufumod.registry.Chair_Blocks;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Gate_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.ayutaki.chinjufumod.registry.JPChair_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.JP_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Pantry_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;
import com.ayutaki.chinjufumod.world.biome.SurfaceRule_CM;
import com.ayutaki.chinjufumod.world.biome.TBProviderIchoh_CM;
import com.ayutaki.chinjufumod.world.biome.TBProviderKaede_CM;
import com.ayutaki.chinjufumod.world.biome.TBProviderSakura_CM;
import com.ayutaki.chinjufumod.world.features.FeatureConfigured_CM;
import com.ayutaki.chinjufumod.world.features.FeaturePlaced_CM;
import com.ayutaki.chinjufumod.world.generate.KuriBush_Gen;
import com.ayutaki.chinjufumod.world.generate.OreGen_CM;
import com.mojang.logging.LogUtils;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

/* The value here should match an entry in the META-INF/mods.toml file */
@Mod(ChinjufuMod.MOD_ID)
public class ChinjufuMod {

	public static final String MOD_ID = "chinjufumod";
	/* Directly reference a log4j logger. */
	private static final Logger LOGGER = LogUtils.getLogger();

	public ChinjufuMod() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config_CM.SPEC, MOD_ID + "_18.2.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigClient_CM.SPEC, MOD_ID + "_18.2_client.toml");
		eventBus.register(Config_CM.class);
		eventBus.register(ConfigClient_CM.class);
		
		EntityTypes_CM.ENTITY_TYPES.register(eventBus);
		BlockEntity_CM.BLOCK_ENTITIES.register(eventBus);
		MenuTypes_CM.MENU_TYPES.register(eventBus);
		ParticleTypes_CM.PARTICLE_TYPES.register(eventBus);
		SoundEvents_CM.SOUNDS.register(eventBus);

		/** register Blocks **/
		Chair_Blocks.BLOCKS.register(eventBus);
		ChinjufuMod_Blocks.BLOCKS.register(eventBus);
		Crop_Blocks.BLOCKS.register(eventBus);
		Dish_Blocks.BLOCKS.register(eventBus);
		Furniture_Blocks.BLOCKS.register(eventBus);
		Garden_Blocks.BLOCKS.register(eventBus);
		Gate_Blocks.BLOCKS.register(eventBus);
		Hakkou_Blocks.BLOCKS.register(eventBus);
		Harbor_Blocks.BLOCKS.register(eventBus);
		JPChair_Blocks.BLOCKS.register(eventBus);
		JPDeco_Blocks.BLOCKS.register(eventBus);
		JP_Blocks.BLOCKS.register(eventBus);
		KamoiPlanks_Blocks.BLOCKS.register(eventBus);
		KamoiPlaster_Blocks.BLOCKS.register(eventBus);
		Kitchen_Blocks.BLOCKS.register(eventBus);
		Pantry_Blocks.BLOCKS.register(eventBus);
		Ranma_Blocks.BLOCKS.register(eventBus);
		School_Blocks.BLOCKS.register(eventBus);
		Seasonal_Blocks.BLOCKS.register(eventBus);
		Slidedoor_Blocks.BLOCKS.register(eventBus);
		Unit_Blocks.BLOCKS.register(eventBus);
		WallPanel_Blocks.BLOCKS.register(eventBus);
		Window_Blocks.BLOCKS.register(eventBus);
		Wood_Blocks.BLOCKS.register(eventBus);

		FeatureConfigured_CM.CONFIG_FEATURES.register(eventBus);
		FeaturePlaced_CM.PLACED_FEATURES.register(eventBus);

		/** register Items **/
		Items_NoTab.ITEMS.register(eventBus);
		Items_Chinjufu.ITEMS.register(eventBus);
		Items_Teatime.ITEMS.register(eventBus);
		Items_Seasonal.ITEMS.register(eventBus);
		Items_Armor.ITEMS.register(eventBus);
		Items_Weapon.ITEMS.register(eventBus);
		Items_Wadeco.ITEMS.register(eventBus);
		Items_Wablock.ITEMS.register(eventBus);
		Items_WallPanel.ITEMS.register(eventBus);
		
		/** add Ore **/
		/** Additions to any list/map contained in a biome : {@link EventPriority#HIGH} **/
		/** Removals to any list/map contained in a biome : {@link EventPriority#NORMAL} **/
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen_CM::generate);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, KuriBush_Gen::generate);
		Biomes_CM.BIOMES.register(eventBus);
		
		eventBus.addListener(this::setup);
		eventBus.addListener(this::enqueueIMC);
		eventBus.addListener(this::processIMC);
		eventBus.addListener(this::gatherData);
		eventBus.addListener(this::clientSetup);

		MinecraftForge.EVENT_BUS.register(this);
	}

	/* preinit code world.biome META-INF */
	private void setup(final FMLCommonSetupEvent event) { 
		event.enqueueWork(() -> {
			/** Add Biome by terrablender.api **/
			if (Config_CM.INSTANCE.sakuraBiomeGene.get()) {
				Regions.register(new TBProviderSakura_CM(new ResourceLocation(MOD_ID, "overworld_sakura"), Config_CM.INSTANCE.sakuraBiomeChance.get())); }
			
			if (Config_CM.INSTANCE.kaedeBiomeGene.get()) {
				Regions.register(new TBProviderKaede_CM(new ResourceLocation(MOD_ID, "overworld_kaede"), Config_CM.INSTANCE.kaedeBiomeChance.get())); }
			
			if (Config_CM.INSTANCE.ichohBiomeGene.get()) {
				Regions.register(new TBProviderIchoh_CM(new ResourceLocation(MOD_ID, "overworld_ichoh"), Config_CM.INSTANCE.ichohBiomeChance.get())); }

			/** Change Surface by terrablender.api **/
			SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, SurfaceRule_CM.makeRules());
		});
		
		/** etc **/
		CompostableItems_CM.register();
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		/* EntityRender */
		EntityRender_CM.register();
		/* ItemModels ...eating drinking */
		ItemModelsProperty_CM.register();

		/* BlockRenderType, Tint */
		RenderTypes_CM.register();
		TintColors_CM.registerBlockColors();
		TintColors_CM.registerItemColors();
		
		/* Screen */
		MenuScreens.register(MenuTypes_CM.TANSU_MENU.get(), TansuScreen::new);
	}
	
	private void enqueueIMC(final InterModEnqueueEvent event) {
		InterModComms.sendTo(ChinjufuMod.MOD_ID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
	}

	private void processIMC(final InterModProcessEvent event) {
		LOGGER.info("Got IMC {}", event.getIMCStream().map(m->m.messageSupplier().get()).collect(Collectors.toList()));
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		LOGGER.info("HELLO from server starting");
	}
	
	private void gatherData(final GatherDataEvent event) {
		if (event.includeServer()) {
			AddTag_CM.register(event.getGenerator(), event.getExistingFileHelper());
		}
	}
}
