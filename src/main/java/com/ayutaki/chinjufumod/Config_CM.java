package com.ayutaki.chinjufumod;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

/* net.minecraftforge.common.ForgeConfig.class*/
public class Config_CM {

	/* Config */
	public static final ForgeConfigSpec SPEC;
	public static final Config_CM INSTANCE;

	public final BooleanValue blastBlockBreak;
	// public final BooleanValue antiShadow;

	// public final BooleanValue bauxiteGene;
	// public final IntValue bauxiteChance;

	public final BooleanValue sakuraBiomeGene;
	public final IntValue sakuraBiomeChance;
	// public final IntValue sakuraTreeChance;
	public final BooleanValue kaedeBiomeGene;
	public final IntValue kaedeBiomeChance;
	// public final IntValue kaedeTreeChance;
	public final BooleanValue ichohBiomeGene;
	public final IntValue ichohBiomeChance;
	// public final IntValue ichohTreeChance;
	public final BooleanValue chestnutsFall;
	public final BooleanValue lowSound;
	public final BooleanValue useMAKIMONO;

	
	private Config_CM(ForgeConfigSpec.Builder builder) {
		/** Blast **/
		builder.comment("Ammo blast breaks the block.").push("explosion");
		this.blastBlockBreak = builder
				.comment("Ammo blast breaks the block, when this setting is true.")
				.define("Break_Blocks", true);
		builder.pop();

		/* 要検討 Anti shadow
		builder.comment("Erase the shadow of the sliding door.").push("anti_shadow");
		this.antiShadow = builder
				.comment("Erase the shadow of the sliding door by light value 1.")
				.define("Anti_Shadow", true);
		builder.pop();*/

		/** Bauxite
		builder.comment("Generation and chance of BauxiteOre.").push("ore_gene");
		this.bauxiteGene = builder
				.comment("BauxiteOre will be generated, when this setting is true.")
				.define("Ore_Generate", true);
		this.bauxiteChance = builder
				.comment("RedStone Ore=8, Gold Ore=2, Diamond Ore=1")
				.defineInRange("Generate_Chance", 8, 1, 50); string, default, min, max
		builder.pop(); **/

		/** SAKURA **/
		builder.comment("Generation and chance of CherryBiome.").push("biome_cherry");
		this.sakuraBiomeGene = builder
				.comment("CherryBiome will be generated, when this setting is true.")
				.define("CherryBiome_Generate", true);
		this.sakuraBiomeChance = builder
				.comment("Common=9, Rare=1, Default=2")
				.defineInRange("CherryBiome_Chance", 2, 1, 9);
		/*this.sakuraTreeChance = builder
				.comment("Common=9, Rare=1, Default=2")
				.defineInRange("CherryTree_Chance", 2, 1, 9);*/
		builder.pop();

		/** KAEDE **/
		builder.comment("Generation and chance of AcerBiome.").push("biome_acer");
		this.kaedeBiomeGene = builder
				.comment("AcerBiome will be generated, when this setting is true.")
				.define("AcerBiome_Generate", true);
		this.kaedeBiomeChance = builder
				.comment("Common=9, Rare=1, Default=2")
				.defineInRange("AcerBiome_Chance", 2, 1, 9);
		/*this.kaedeTreeChance = builder
				.comment("Common=9, Rare=1, Default=2")
				.defineInRange("AcerTree_Chance", 2, 1, 9);*/
		builder.pop();

		/** ICHOH **/
		builder.comment("Generation and chance of GinkgoBiome.").push("biome_ginkgo");
		this.ichohBiomeGene = builder
				.comment("GinkgoBiome will be generated, when this setting is true.")
				.define("GinkgoBiome_Generate", true);
		this.ichohBiomeChance = builder
				.comment("Common=9, Rare=1, Default=2")
				.defineInRange("GinkgoBiome_Chance", 2, 1, 9);
		/*this.ichohTreeChance = builder
				.comment("Common=9, Rare=1, Default=2")
				.defineInRange("GinkgoTree_Chance", 2, 1, 9);*/
		builder.pop();
		
		/** KURI **/
		builder.comment("Chestnuts fall from Autumn leaves.").push("chestnuts_fall");
		this.chestnutsFall = builder
				.comment("Chestnuts fall from Autumn leaves, when this setting is true.")
				.define("Chestnuts_Fall", true);
		builder.pop();
		
		/** Low Sound **/
		builder.comment("Low-processing sound on carrier-borne aircraft.").push("low_sound");
		this.lowSound = builder
				.comment("Use a more low-processing sound on carrier-borne aircraft, when this setting is true.")
				.define("Low_Sound", false);
		builder.pop();
		
		/** MAKIMONO **/
		builder.comment("Use a MAKIMONO block.").push("use_makimono");
		this.useMAKIMONO = builder
				.comment("You can use MAKIMONO block, when this setting is true.")
				.define("Use_MAKIMONO", true);
		builder.pop();
	}
	
	static {
		final Pair<Config_CM, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Config_CM::new);
		SPEC= specPair.getRight();
		INSTANCE = specPair.getLeft();
	}
}
