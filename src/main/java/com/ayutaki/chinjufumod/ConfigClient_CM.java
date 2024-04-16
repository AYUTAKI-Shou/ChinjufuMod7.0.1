package com.ayutaki.chinjufumod;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

/* net.minecraftforge.common.ForgeConfig.class*/
public class ConfigClient_CM {

	/* Config */
	public static final ForgeConfigSpec SPEC;
	public static final ConfigClient_CM INSTANCE;

	private static final Path CONFIG_PATH = Paths.get("config", ChinjufuMod.MOD_ID + "_16.5_client.toml");

	public final IntValue helmetTexture;
	public final IntValue chestplateTexture;
	public final IntValue leggingsTexture;
	public final IntValue bootsTexture;

	private ConfigClient_CM(ForgeConfigSpec.Builder builder) {

		builder.comment("Texture of ChinjufuMod's Helmet.").push("helmet_texture");
		this.helmetTexture = builder
				.comment("All=0, Without Clothes=1, Only Clothes=2")
				.defineInRange("Helmet_Texture", 0, 0, 2);
		builder.pop();
		
		builder.comment("Texture of ChinjufuMod's Chestplate.").push("chestplate_texture");
		this.chestplateTexture = builder
				.comment("All=0, Without Clothes=1, Only Clothes=2")
				.defineInRange("Chestplate_Texture", 0, 0, 2);
		builder.pop();
		
		builder.comment("Texture of ChinjufuMod's Leggings.").push("leggings_texture");
		this.leggingsTexture = builder
				.comment("All=0, Without Clothes=1, Only Clothes=2")
				.defineInRange("Leggings_Texture", 0, 0, 2);
		builder.pop();
		
		builder.comment("Texture of ChinjufuMod's Boots.").push("boots_texture");
		this.bootsTexture = builder
				.comment("All=0, Without Clothes=1, Only Clothes=2")
				.defineInRange("Boots_Texture", 0, 0, 2);
		builder.pop();
	}

	static {
		Pair<ConfigClient_CM, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ConfigClient_CM::new);
		SPEC = specPair.getRight();
		INSTANCE = specPair.getLeft();
		CommentedFileConfig config = CommentedFileConfig.builder(CONFIG_PATH).sync().autoreload().writingMode(WritingMode.REPLACE).build();
		config.load();
		config.save();
		SPEC.setConfig(config);
	}

	/* Gui Config */
	public static ConfigClient_CM getInstance() {
		return INSTANCE;
	}

	/** getValue **/
	public int helmetTexture() { return helmetTexture.get(); }
	public int chestplateTexture() { return chestplateTexture.get(); }
	public int leggingsTexture() { return leggingsTexture.get(); }
	public int bootsTexture() { return bootsTexture.get(); }
	
	/** changeValue **/
	public void changeTypeHelmet(int newValue) { helmetTexture.set(newValue); }
	public void changeTypeChestplate(int newValue) { chestplateTexture.set(newValue); }
	public void changeTypeLeggings(int newValue) { leggingsTexture.set(newValue); }
	public void changeTypeBoots(int newValue) { bootsTexture.set(newValue); }
	
	public void save() {
		SPEC.save();
	}
}
