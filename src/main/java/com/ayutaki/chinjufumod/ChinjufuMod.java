package com.ayutaki.chinjufumod;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;

import com.ayutaki.chinjufumod.handler.AddBiomeTag_CM;
import com.ayutaki.chinjufumod.handler.BlockEntity_CM;
import com.ayutaki.chinjufumod.handler.CompostableItems_CM;
import com.ayutaki.chinjufumod.handler.DatapackBuilt_CM;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.MenuTypes_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
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
import com.mojang.logging.LogUtils;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

/* The value here should match an entry in the META-INF/mods.toml file */
@Mod(ChinjufuMod.MOD_ID)
public class ChinjufuMod {

	/* Define mod id in a common place for everything to reference */
	public static final String MOD_ID = "chinjufumod";
	/* Directly reference a slf4j logger */
	public static final Logger LOGGER = LogUtils.getLogger();

	public ChinjufuMod() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config_CM.SPEC, MOD_ID + "_20.2.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigClient_CM.SPEC, MOD_ID + "_20.2_client.toml");

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
		ItemGroups_CM.TABS.register(eventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		eventBus.addListener(this::commonSetup);
		eventBus.addListener(this::gatherData);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		/** Some common setup code **/
		LOGGER.info("HELLO FROM COMMON SETUP");
		
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
	
	private void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		PackOutput outPut = gen.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookUp = event.getLookupProvider();
		CompletableFuture<HolderLookup.Provider> lookUpOwn = lookUp.thenApply(provider -> DatapackBuilt_CM.BUILDER
				.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), provider));
		
		gen.addProvider(event.includeServer(), new DatapackBuilt_CM(outPut, lookUp));
		gen.addProvider(event.includeServer(), new AddBiomeTag_CM(outPut, lookUpOwn, event.getExistingFileHelper()));
	}
	
	/* You can use SubscribeEvent and let the Event Bus discover methods to call */
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		/** Do something when the server starts **/
		LOGGER.info("HELLO from server starting");
	}
}
