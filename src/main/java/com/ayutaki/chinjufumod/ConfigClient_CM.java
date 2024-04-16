package com.ayutaki.chinjufumod;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

/* net.minecraftforge.common.ForgeConfig.class*/
public class ConfigClient_CM {

	/* Config */
	public static final ForgeConfigSpec SPEC;
	public static final ConfigClient_CM INSTANCE;

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
		final Pair<ConfigClient_CM, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ConfigClient_CM::new);
		SPEC= specPair.getRight();
		INSTANCE = specPair.getLeft();
	}
}
