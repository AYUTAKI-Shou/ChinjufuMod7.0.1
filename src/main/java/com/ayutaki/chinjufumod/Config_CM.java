package com.ayutaki.chinjufumod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config_CM {

	public static Configuration config;

	public static final String GENERAL = "general";
	public static final String CLIENT = "client";
	
	public static boolean isGeneratorEnabled = true;
	public static int isGeneratorChance = 25;

	public static boolean sakuraBiomeRegister = true;
	public static int sakuraBiomeChance = 4;
	public static int sakuraTreeChance = 3;

	public static boolean kaedeBiomeRegister = true;
	public static int kaedeBiomeChance = 4;
	public static int kaedeTreeChance = 3;

	public static boolean ichohBiomeRegister = true;
	public static int ichohBiomeChance = 4;
	public static int ichohTreeChance = 3;

	public static boolean chestnutsFall = true;
	public static boolean lowSound = true;
	public static boolean blastBlockBreak = true;
	public static boolean useMAKIMONO = true;

	/** Client **/
	public static int helmetTexture = 0;
	public static int chestplateTexture = 0;
	public static int leggingsTexture = 0;
	public static int bootsTexture = 0;

	public static void init(File file) {
		if (config == null) {
			config = new Configuration(file);
			loadConfig(false);
		}
	}

	public static void loadConfig(boolean shouldChange) {

		/* General*/
		isGeneratorEnabled = config.getBoolean("enabledGenerator", GENERAL,
				isGeneratorEnabled, "BauxiteOre will be generated, when this setting is true.", "config.bauxiteore.enabledGenerator");

		/** config.getInt(name, category, defaultValue, minValue, maxValue, comment, langKey) **/
		isGeneratorChance = config.getInt("generatorChance", GENERAL,
				25, 1, 100, "RedStone Ore=25, Gold Ore=8", "config.bauxiteore.chance");

		/* SAKURA */
		sakuraBiomeRegister = config.getBoolean("sakuraBiomeRegister", GENERAL,
				sakuraBiomeRegister, "CherryBiome will be generated, when this setting is true.", "config.cherrybiome.register");

		sakuraBiomeChance = config.getInt("sakuraChanceBiome", GENERAL,
				4, 1, 19, "Common=19, Rare=1", "config.cherrybiome.chance");

		sakuraTreeChance = config.getInt("sakuraChanceTree", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.cherrytree.chance");

		/* KAEDE */
		kaedeBiomeRegister = config.getBoolean("kaedeBiomeRegister", GENERAL,
				kaedeBiomeRegister, "AcerBiome will be generated, when this setting is true.", "config.acerbiome.register");

		kaedeBiomeChance = config.getInt("kaedeChanceBiome", GENERAL,
				4, 1, 19, "Common=19, Rare=1", "config.acerbiome.chance");

		kaedeTreeChance = config.getInt("kaedeTreeBiome", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.acertree.chance");

		/* ICHOH */
		ichohBiomeRegister = config.getBoolean("ichohBiomeRegister", GENERAL,
				ichohBiomeRegister, "GinkgoBiome will be generated, when this setting is true.", "config.ginkgobiome.register");

		ichohBiomeChance = config.getInt("ichohChanceBiome", GENERAL,
				4, 1, 19, "Common=19, Rare=1", "config.ginkgobiome.chance");

		ichohTreeChance = config.getInt("ichohChanceTree", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.ginkgotree.chance");

		/* KURI */
		chestnutsFall = config.getBoolean("chestnutsFall", GENERAL,
				chestnutsFall, "Chestnuts fall from Autumn leaves, when this setting is true.", "config.chestnutsfall");
	
		lowSound = config.getBoolean("lowSound", GENERAL,
				lowSound, "Use a more low-processing sound on carrier-borne aircraft, when this setting is true.", "config.lowsound");

		/* BLAST */
		blastBlockBreak = config.getBoolean("blastBlockBreak", GENERAL,
				blastBlockBreak, "Ammo blast breaks the block, when this setting is true.", "config.blastblockbreak.enabled");
		
		/* MAKIMONO */
		useMAKIMONO = config.getBoolean("useMAKIMONO", GENERAL,
				useMAKIMONO, "You can use MAKIMONO block, when this setting is true.", "config.usemakimono");

		kaedeTreeChance = config.getInt("kaedeTreeBiome", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.acertree.chance");
		
		
		/** Client **/
		helmetTexture = config.getInt("helmetTexture", CLIENT,
				0, 0, 2, "All=0, Without Clothes=1, Only Clothes=2", "config.helmet_texture");
				
		chestplateTexture = config.getInt("chestplateTexture", CLIENT,
				0, 0, 2, "All=0, Without Clothes=1, Only Clothes=2", "config.chestplate_texture");
				
		leggingsTexture = config.getInt("leggingsTexture", CLIENT,
				0, 0, 2, "All=0, Without Clothes=1, Only Clothes=2", "config.leggings_texture");
		
		bootsTexture = config.getInt("bootsTexture", CLIENT,
				0, 0, 2, "All=0, Without Clothes=1, Only Clothes=2", "config.boots_texture");
		
		
		/* save config*/
		if (config.hasChanged() && shouldChange) { }
		config.save();

	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.getModID().equals(ChinjufuMod.MOD_ID)) {
			loadConfig(true);
		}
	}
}
