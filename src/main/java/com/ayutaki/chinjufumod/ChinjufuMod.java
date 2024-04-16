package com.ayutaki.chinjufumod;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ayutaki.chinjufumod.gui.ReizouScreen;
import com.ayutaki.chinjufumod.gui.TansuScreen;
import com.ayutaki.chinjufumod.handler.AddBiomes_CM;
import com.ayutaki.chinjufumod.handler.AnimalSpawnRules_CM;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.CompostableItems_CM;
import com.ayutaki.chinjufumod.handler.EntityRender_CM;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.Features_CM;
import com.ayutaki.chinjufumod.handler.ItemModelsProperty_CM;
import com.ayutaki.chinjufumod.handler.MenuTypes_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.RenderTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.handler.TileEntity_CM;
import com.ayutaki.chinjufumod.handler.TintColors_CM;
import com.ayutaki.chinjufumod.proxy.ClientProxy;
import com.ayutaki.chinjufumod.proxy.IProxy;
import com.ayutaki.chinjufumod.proxy.ServerProxy;
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
import com.ayutaki.chinjufumod.world.biome.SurfaceBuilder_CM;
import com.ayutaki.chinjufumod.world.generate.KuriBush_Gen;
import com.ayutaki.chinjufumod.world.generate.OreGen_CM;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/* The value here should match an entry in the META-INF/mods.toml file */
@Mod(ChinjufuMod.MOD_ID)
public class ChinjufuMod {

	public static final String MOD_ID = "chinjufumod";
	/* Directly reference a log4j logger. */
	public static final Logger LOGGER = LogManager.getLogger();
	public static final IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

	public ChinjufuMod() {
 
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config_CM.SPEC, MOD_ID + "_16.5.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigClient_CM.SPEC, MOD_ID + "_16.5_client.toml");

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		EntityTypes_CM.ENTITY_TYPES.register(eventBus);
		TileEntity_CM.TILE_ENTITIES.register(eventBus);
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

		/** register Biome **/
		Features_CM.FEATURES.register(eventBus);
		SurfaceBuilder_CM.SURFACE_BUILDERS.register(eventBus);
		Biomes_CM.BIOMES.register(eventBus);

		eventBus.addListener(this::setup);
		eventBus.addListener(this::enqueueIMC);
		eventBus.addListener(this::processIMC);
		eventBus.addListener(this::clientSetup);

		/** Register ourselves for server and other game events we are interested in **/
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {

		/** add Biome **/
		AnimalSpawnRules_CM.registers();
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen_CM::generate);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, KuriBush_Gen::generate);
		event.enqueueWork(AddBiomes_CM::addBiomes);

		/** etc **/
		CompostableItems_CM.register();

		/** ConfigScreen**/
		proxy.setup(event);
	}

	private void clientSetup(final FMLClientSetupEvent event) {

		/** EntityRender **/
		EntityRender_CM.register();
		/** ItemModels ...eating drinking **/
		ItemModelsProperty_CM.register();

		/** BlockRenderType, Tint **/
		RenderTypes_CM.register();
		TintColors_CM.registerBlockColors();
		TintColors_CM.registerItemColors();

		/* Screen */
		ScreenManager.register(MenuTypes_CM.TANSU_MENU.get(), TansuScreen::new);
		ScreenManager.register(MenuTypes_CM.REIZOU_MENU.get(), ReizouScreen::new);
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		/** some example code to dispatch IMC to another mod **/
		InterModComms.sendTo("chinjufumod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
	}

	private void processIMC(final InterModProcessEvent event) {
		/** some example code to receive and process InterModComms from other mods **/
		LOGGER.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	/* You can use SubscribeEvent and let the Event Bus discover methods to call */
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		/** do something when the server starts **/
		LOGGER.info("HELLO from server starting");
	}
}
