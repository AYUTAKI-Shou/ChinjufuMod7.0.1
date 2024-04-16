package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionary_CM {

	/*鉱石辞書にある素材名と自分のMODの素材を紐付けする
	* Link the material name in the ore dictionary with the material of your MOD.*/
	public static void registerOreDictionary() {

		/** Ore **/
		OreDictionary.registerOre("oreBauxite", Items_Chinjufu.BAUXITE_ORE);
		OreDictionary.registerOre("ingotAluminium", Items_Chinjufu.ALUMINUM);
		OreDictionary.registerOre("ingotAluminum", Items_Chinjufu.ALUMINUM);


		/** Seeds refer to HarvestCraft **/
		OreDictionary.registerOre("seedCabbage", Items_Teatime.SEEDS_CABBAGE);
		OreDictionary.registerOre("seedChinesecabbage", Items_Teatime.SEEDS_HAKUSAI);
		OreDictionary.registerOre("seedCorn", Items_Teatime.SEEDS_CORN);
		/** 6.4.1 **/ OreDictionary.registerOre("seedGreenonion", Items_Teatime.SEEDS_GREENONION);
		OreDictionary.registerOre("seedOnion", Items_Teatime.SEEDS_ONION);
		OreDictionary.registerOre("seedRice", Items_Teatime.SEEDS_RICE);
		OreDictionary.registerOre("seedSoybean", Items_Teatime.SEEDS_SOY);
		OreDictionary.registerOre("seedSpinach", Items_Teatime.SEEDS_SPINACH);
		OreDictionary.registerOre("seedTomato", Items_Teatime.SEEDS_TOMATO);
		OreDictionary.registerOre("seedCherry", Items_Teatime.SEEDS_CHERRY);


		/** Crops refer to HarvestCraft **/
		OreDictionary.registerOre("cropCabbage", Items_Teatime.FOOD_CABBAGE);
		OreDictionary.registerOre("cropChinesecabbage", Items_Teatime.FOOD_HAKUSAI);
		OreDictionary.registerOre("cropCorn", Items_Teatime.FOOD_CORN);
		/** 6.4.1 **/ OreDictionary.registerOre("cropGreenonion", Items_Teatime.FOOD_GREENONION);
		OreDictionary.registerOre("cropOnion", Items_Teatime.FOOD_ONION);
		OreDictionary.registerOre("cropRice", new ItemStack(Items_Teatime.INE, 1, 0));
		OreDictionary.registerOre("cropRice", new ItemStack(Items_Teatime.INE, 1, 1));
		OreDictionary.registerOre("cropSoybean", Items_Teatime.SAYA);
		OreDictionary.registerOre("cropSpinach", Items_Teatime.FOOD_SPINACH);
		OreDictionary.registerOre("cropTomato", Items_Teatime.FOOD_TOMATO);
		OreDictionary.registerOre("cropGrape", Items_Teatime.FOOD_GRAPE);
		OreDictionary.registerOre("cropCherry", Items_Teatime.FOOD_CHERRY);
		OreDictionary.registerOre("cropOrange", Items_Teatime.FOOD_MIKAN);
		OreDictionary.registerOre("listAllcitrus", Items_Teatime.FOOD_MIKAN);

		OreDictionary.registerOre("cropTea", new ItemStack(Items_Teatime.CHABA, 1, 0));

		/** Bucket **/
		OreDictionary.registerOre("bucketWater", Items_Teatime.MIZUOKE_full);
		OreDictionary.registerOre("bucketWater", Items.WATER_BUCKET);
		OreDictionary.registerOre("bucketMilk", Items_Teatime.MIZUOKE_Milk);
		OreDictionary.registerOre("bucketMilk", Items.MILK_BUCKET);


		/** Condiment refer to HarvestCraft **/
		OreDictionary.registerOre("dustSalt", new ItemStack(Items_Teatime.SHIO, 1, 0));
		OreDictionary.registerOre("foodSalt", new ItemStack(Items_Teatime.SHIO, 1, 0));
		OreDictionary.registerOre("itemSalt", new ItemStack(Items_Teatime.SHIO, 1, 0));

		OreDictionary.registerOre("foodFlour", new ItemStack(Items_Teatime.KOMUGI, 1, 1));
		OreDictionary.registerOre("foodButter", new ItemStack(Items_Teatime.KOMUGI, 1, 2));
		OreDictionary.registerOre("foodMisopaste", Items_Teatime.MISO);
		OreDictionary.registerOre("foodCheese", Items_Teatime.PIECE_CHEESE);
		OreDictionary.registerOre("foodFreshcheese", Items_Teatime.FRESH_CHEESE);
		OreDictionary.registerOre("foodSilkentofu", Items_Teatime.TOUFU);
		OreDictionary.registerOre("foodSilkentoufu", Items_Teatime.TOUFU);

		OreDictionary.registerOre("itemYeast", Items_Teatime.KOUBO);

		OreDictionary.registerOre("foodSoysauce", Items_Teatime.SHOUYU_bot_1);
		OreDictionary.registerOre("foodSoysauce", Items_Teatime.SHOUYU_bot_2);
		OreDictionary.registerOre("foodSoysauce", Items_Teatime.SHOUYU_bot_3);
		OreDictionary.registerOre("foodSoysauce", Items_Teatime.SHOUYU_bot_4);
		OreDictionary.registerOre("foodVinegar", Items_Teatime.KOMEZU_bot_1);
		OreDictionary.registerOre("foodVinegar", Items_Teatime.KOMEZU_bot_2);


		/** Tree **/
		OreDictionary.registerOre("treeSaplingCherry", Items_Seasonal.SAKURA_nae);
		OreDictionary.registerOre("treeSaplingAcer", Items_Seasonal.KAEDE_nae);
		OreDictionary.registerOre("treeSaplingGinkgo", Items_Seasonal.ICHOH_nae);
		OreDictionary.registerOre("treeSaplingAutumnoak", Items_Seasonal.OAKKARE_nae);
		OreDictionary.registerOre("treeLeavesCherry", Items_Seasonal.SAKURA_flow);
		OreDictionary.registerOre("treeLeavesAcer", Items_Seasonal.KAEDE_leaf);
		OreDictionary.registerOre("treeLeavesGinkgo", Items_Seasonal.ICHOH_leaf);
		OreDictionary.registerOre("treeLeavesAutumnoak", Items_Seasonal.OAKKARE_leaf);

		OreDictionary.registerOre("logWood", Items_Seasonal.SAKURA_log);
		OreDictionary.registerOre("logWood", Items_Seasonal.KAEDE_log);
		OreDictionary.registerOre("logWood", Items_Seasonal.ICHOH_log);
		OreDictionary.registerOre("logWoodCherry", Items_Seasonal.SAKURA_log);
		OreDictionary.registerOre("logWoodAcer", Items_Seasonal.KAEDE_log);
		OreDictionary.registerOre("logWoodGinkgo", Items_Seasonal.ICHOH_log);

		OreDictionary.registerOre("plankWoodCherry", Items_Seasonal.PLANKS_sakura);
		OreDictionary.registerOre("plankWoodAcer", Items_Seasonal.PLANKS_kaede);
		OreDictionary.registerOre("plankWoodGinkgo", Items_Seasonal.PLANKS_ichoh);
		/*OreDictionary.registerOre("plankWood", Items_Seasonal.PLANKS_sakura);
		OreDictionary.registerOre("plankWood", Items_Seasonal.PLANKS_kaede);
		OreDictionary.registerOre("plankWood", Items_Seasonal.PLANKS_ichoh); Do not use these. These confuse recipes. */
		
		OreDictionary.registerOre("slabWood", Items_Seasonal.SAKURA_slabhalf);
		OreDictionary.registerOre("slabWood", Items_Seasonal.KAEDE_slabhalf);
		OreDictionary.registerOre("slabWood", Items_Seasonal.ICHOH_slabhalf);
		OreDictionary.registerOre("slabWoodCherry", Items_Seasonal.SAKURA_slabhalf);
		OreDictionary.registerOre("slabWoodAcer", Items_Seasonal.KAEDE_slabhalf);
		OreDictionary.registerOre("slabWoodGinkgo", Items_Seasonal.ICHOH_slabhalf);

		OreDictionary.registerOre("stairWood", Items_Seasonal.SAKURA_stairs);
		OreDictionary.registerOre("stairWood", Items_Seasonal.KAEDE_stairs);
		OreDictionary.registerOre("stairWood", Items_Seasonal.ICHOH_stairs);
		OreDictionary.registerOre("stairWoodCherry", Items_Seasonal.SAKURA_stairs);
		OreDictionary.registerOre("stairWoodAcer", Items_Seasonal.KAEDE_stairs);
		OreDictionary.registerOre("stairWoodGinkgo", Items_Seasonal.ICHOH_stairs);


		/** Vanilla items **/
		OreDictionary.registerOre("cropApple", Items.APPLE);
		OreDictionary.registerOre("cropBeetroot", Items.BEETROOT);
		OreDictionary.registerOre("cropCarrot", Items.CARROT);
		OreDictionary.registerOre("cropPotato", Items.POTATO);
		OreDictionary.registerOre("cropWheat", Items.WHEAT);

		OreDictionary.registerOre("listAllbread", Items.BREAD);
		OreDictionary.registerOre("listAllegg", Items.EGG);
		OreDictionary.registerOre("listAllsugar", Items.SUGAR);
		OreDictionary.registerOre("listAllchickenraw", Items.CHICKEN);
		OreDictionary.registerOre("listAllbeefraw", Items.BEEF);
		OreDictionary.registerOre("listAllporkraw", Items.PORKCHOP);
		OreDictionary.registerOre("listAllchickencooked", Items.COOKED_CHICKEN);
		OreDictionary.registerOre("listAllbeefcooked", Items.COOKED_BEEF);
		OreDictionary.registerOre("listAllporkcooked", Items.COOKED_PORKCHOP);
		OreDictionary.registerOre("cookedPork", Items.COOKED_PORKCHOP);
		OreDictionary.registerOre("cookedBeef", Items.COOKED_BEEF);
		OreDictionary.registerOre("cookedMutton", Items.COOKED_MUTTON);
		OreDictionary.registerOre("cookedRabbit", Items.COOKED_RABBIT);
		OreDictionary.registerOre("cookedChicken", Items.COOKED_CHICKEN);
		OreDictionary.registerOre("egg", Items.EGG);
		OreDictionary.registerOre("pork", Items.PORKCHOP);
		OreDictionary.registerOre("beef", Items.BEEF);
		OreDictionary.registerOre("mutton", Items.MUTTON);
		OreDictionary.registerOre("rabbit", Items.RABBIT);
		OreDictionary.registerOre("chicken", Items.CHICKEN);

		OreDictionary.registerOre("rawFish", new ItemStack(Items.FISH, 1, 0));
		OreDictionary.registerOre("fishRaw", new ItemStack(Items.FISH, 1, 0));
		OreDictionary.registerOre("cookedFish", new ItemStack(Items.COOKED_FISH, 1, 0));
		OreDictionary.registerOre("fishCooked", new ItemStack(Items.COOKED_FISH, 1, 0));

		OreDictionary.registerOre("rawSalmon", new ItemStack(Items.FISH, 1, 1));
		OreDictionary.registerOre("salmonRaw", new ItemStack(Items.FISH, 1, 1));
		OreDictionary.registerOre("cookedSalmon", new ItemStack(Items.COOKED_FISH, 1, 1));
		OreDictionary.registerOre("salmonCooked", new ItemStack(Items.COOKED_FISH, 1, 1));

		OreDictionary.registerOre("dustRedstone", Items.REDSTONE);

		OreDictionary.registerOre("dustCocoa", new ItemStack(Items.DYE, 1, 3));

		OreDictionary.registerOre("dyeBlack", new ItemStack(Items.DYE, 1, 0));
		OreDictionary.registerOre("dyeRed", new ItemStack(Items.DYE, 1, 1));
		OreDictionary.registerOre("dyeGreen", new ItemStack(Items.DYE, 1, 2));
		OreDictionary.registerOre("dyeBrown", new ItemStack(Items.DYE, 1, 3));
		OreDictionary.registerOre("dyeBlue", new ItemStack(Items.DYE, 1, 4));
		OreDictionary.registerOre("dyePurple", new ItemStack(Items.DYE, 1, 5));
		OreDictionary.registerOre("dyeCyan", new ItemStack(Items.DYE, 1, 6));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(Items.DYE, 1, 7));
		OreDictionary.registerOre("dyeGray", new ItemStack(Items.DYE, 1, 8));
		OreDictionary.registerOre("dyePink", new ItemStack(Items.DYE, 1, 9));
		OreDictionary.registerOre("dyeLime", new ItemStack(Items.DYE, 1, 10));
		OreDictionary.registerOre("dyeYellow", new ItemStack(Items.DYE, 1, 11));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(Items.DYE, 1, 12));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(Items.DYE, 1, 13));
		OreDictionary.registerOre("dyeOrange", new ItemStack(Items.DYE, 1, 14));
		OreDictionary.registerOre("dyeWhite", new ItemStack(Items.DYE, 1, 15));

		OreDictionary.registerOre("plankWood", new ItemStack(Blocks.PLANKS, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(Blocks.PLANKS, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(Blocks.PLANKS, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(Blocks.PLANKS, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(Blocks.PLANKS, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(Blocks.PLANKS, 1, 5));
		OreDictionary.registerOre("plankWoodOak", new ItemStack(Blocks.PLANKS, 1, 0));
		OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Blocks.PLANKS, 1, 1));
		OreDictionary.registerOre("plankWoodBirch", new ItemStack(Blocks.PLANKS, 1, 2));
		OreDictionary.registerOre("plankWoodJungle", new ItemStack(Blocks.PLANKS, 1, 3));
		OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Blocks.PLANKS, 1, 4));
		OreDictionary.registerOre("plankWoodDarkoak", new ItemStack(Blocks.PLANKS, 1, 5));

		OreDictionary.registerOre("slabWood", new ItemStack(Blocks.WOODEN_SLAB, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(Blocks.WOODEN_SLAB, 1, 1));
		OreDictionary.registerOre("slabWood", new ItemStack(Blocks.WOODEN_SLAB, 1, 2));
		OreDictionary.registerOre("slabWood", new ItemStack(Blocks.WOODEN_SLAB, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(Blocks.WOODEN_SLAB, 1, 4));
		OreDictionary.registerOre("slabWood", new ItemStack(Blocks.WOODEN_SLAB, 1, 5));
		OreDictionary.registerOre("slabWoodOak", new ItemStack(Blocks.WOODEN_SLAB, 1, 0));
		OreDictionary.registerOre("slabWoodSpruce", new ItemStack(Blocks.WOODEN_SLAB, 1, 1));
		OreDictionary.registerOre("slabWoodBirch", new ItemStack(Blocks.WOODEN_SLAB, 1, 2));
		OreDictionary.registerOre("slabWoodJungle", new ItemStack(Blocks.WOODEN_SLAB, 1, 3));
		OreDictionary.registerOre("slabWoodAcacia", new ItemStack(Blocks.WOODEN_SLAB, 1, 4));
		OreDictionary.registerOre("slabWoodDarkoak", new ItemStack(Blocks.WOODEN_SLAB, 1, 5));

		OreDictionary.registerOre("buttonWood", Blocks.WOODEN_BUTTON);

		OreDictionary.registerOre("logWood", new ItemStack(Blocks.LOG, 1, 0));
		OreDictionary.registerOre("logWood", new ItemStack(Blocks.LOG, 1, 1));
		OreDictionary.registerOre("logWood", new ItemStack(Blocks.LOG, 1, 2));
		OreDictionary.registerOre("logWood", new ItemStack(Blocks.LOG, 1, 3));
		OreDictionary.registerOre("logWood", new ItemStack(Blocks.LOG2, 1, 0));
		OreDictionary.registerOre("logWood", new ItemStack(Blocks.LOG2, 1, 1));
		OreDictionary.registerOre("logWoodOak", new ItemStack(Blocks.LOG, 1, 0));
		OreDictionary.registerOre("logWoodSpruce", new ItemStack(Blocks.LOG, 1, 1));
		OreDictionary.registerOre("logWoodBirch", new ItemStack(Blocks.LOG, 1, 2));
		OreDictionary.registerOre("logWoodJungle", new ItemStack(Blocks.LOG, 1, 3));
		OreDictionary.registerOre("logWoodAcacia", new ItemStack(Blocks.LOG2, 1, 0));
		OreDictionary.registerOre("logWoodDarkoak", new ItemStack(Blocks.LOG2, 1, 1));

		OreDictionary.registerOre("treeSaplingOak", new ItemStack(Blocks.SAPLING, 1, 0));
		OreDictionary.registerOre("treeSaplingSpruce", new ItemStack(Blocks.SAPLING, 1, 1));
		OreDictionary.registerOre("treeSaplingBirch", new ItemStack(Blocks.SAPLING, 1, 2));
		OreDictionary.registerOre("treeSaplingJungle", new ItemStack(Blocks.SAPLING, 1, 3));
		OreDictionary.registerOre("treeSaplingAcacia", new ItemStack(Blocks.SAPLING, 1, 4));
		OreDictionary.registerOre("treeSaplingDarkoak", new ItemStack(Blocks.SAPLING, 1, 5));

		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 0));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 1));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 2));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 3));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 4));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 5));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 6));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 7));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 8));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 9));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 10));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 11));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 12));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 13));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 14));
		OreDictionary.registerOre("carpet", new ItemStack(Blocks.CARPET, 1, 15));
		OreDictionary.registerOre("carpetWhite", new ItemStack(Blocks.CARPET, 1, 0));
		OreDictionary.registerOre("carpetOrange", new ItemStack(Blocks.CARPET, 1, 1));
		OreDictionary.registerOre("carpetMagenta", new ItemStack(Blocks.CARPET, 1, 2));
		OreDictionary.registerOre("carpetLightBlue", new ItemStack(Blocks.CARPET, 1, 3));
		OreDictionary.registerOre("carpetYellow", new ItemStack(Blocks.CARPET, 1, 4));
		OreDictionary.registerOre("carpetLime", new ItemStack(Blocks.CARPET, 1, 5));
		OreDictionary.registerOre("carpetPink", new ItemStack(Blocks.CARPET, 1, 6));
		OreDictionary.registerOre("carpetGray", new ItemStack(Blocks.CARPET, 1, 7));
		OreDictionary.registerOre("carpetLightGray", new ItemStack(Blocks.CARPET, 1, 8));
		OreDictionary.registerOre("carpetSilver", new ItemStack(Blocks.CARPET, 1, 8));
		OreDictionary.registerOre("carpetCyan", new ItemStack(Blocks.CARPET, 1, 9));
		OreDictionary.registerOre("carpetPurple", new ItemStack(Blocks.CARPET, 1, 10));
		OreDictionary.registerOre("carpetBlue", new ItemStack(Blocks.CARPET, 1, 11));
		OreDictionary.registerOre("carpetBrown", new ItemStack(Blocks.CARPET, 1, 12));
		OreDictionary.registerOre("carpetGreen", new ItemStack(Blocks.CARPET, 1, 13));
		OreDictionary.registerOre("carpetRed", new ItemStack(Blocks.CARPET, 1, 14));
		OreDictionary.registerOre("carpetBlack", new ItemStack(Blocks.CARPET, 1, 15));

		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 0));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 1));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 2));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 3));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 4));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 5));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 6));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 7));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 8));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 9));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 10));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 11));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 12));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 13));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 14));
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, 15));
		OreDictionary.registerOre("woolWhite", new ItemStack(Blocks.WOOL, 1, 0));
		OreDictionary.registerOre("woolOrange", new ItemStack(Blocks.WOOL, 1, 1));
		OreDictionary.registerOre("woolMagenta", new ItemStack(Blocks.WOOL, 1, 2));
		OreDictionary.registerOre("woolLightBlue", new ItemStack(Blocks.WOOL, 1, 3));
		OreDictionary.registerOre("woolYellow", new ItemStack(Blocks.WOOL, 1, 4));
		OreDictionary.registerOre("woolLime", new ItemStack(Blocks.WOOL, 1, 5));
		OreDictionary.registerOre("woolPink", new ItemStack(Blocks.WOOL, 1, 6));
		OreDictionary.registerOre("woolGray", new ItemStack(Blocks.WOOL, 1, 7));
		OreDictionary.registerOre("woolLightGray", new ItemStack(Blocks.WOOL, 1, 8));
		OreDictionary.registerOre("woolSilver", new ItemStack(Blocks.WOOL, 1, 8));
		OreDictionary.registerOre("woolCyan", new ItemStack(Blocks.WOOL, 1, 9));
		OreDictionary.registerOre("woolPurple", new ItemStack(Blocks.WOOL, 1, 10));
		OreDictionary.registerOre("woolBlue", new ItemStack(Blocks.WOOL, 1, 11));
		OreDictionary.registerOre("woolBrown", new ItemStack(Blocks.WOOL, 1, 12));
		OreDictionary.registerOre("woolGreen", new ItemStack(Blocks.WOOL, 1, 13));
		OreDictionary.registerOre("woolRed", new ItemStack(Blocks.WOOL, 1, 14));
		OreDictionary.registerOre("woolBlack", new ItemStack(Blocks.WOOL, 1, 15));
		//{ "type": "forge:ore_dict", "ore": "cropWheat" }
		OreDictionary.registerOre("blockGlassColorless", Blocks.GLASS);
		OreDictionary.registerOre("blockGlassWhite", new ItemStack(Blocks.STAINED_GLASS, 1, 0));
		OreDictionary.registerOre("blockGlassOrange", new ItemStack(Blocks.STAINED_GLASS, 1, 1));
		OreDictionary.registerOre("blockGlassMagenta", new ItemStack(Blocks.STAINED_GLASS, 1, 2));
		OreDictionary.registerOre("blockGlassLightBlue", new ItemStack(Blocks.STAINED_GLASS, 1, 3));
		OreDictionary.registerOre("blockGlassYellow", new ItemStack(Blocks.STAINED_GLASS, 1, 4));
		OreDictionary.registerOre("blockGlassLime", new ItemStack(Blocks.STAINED_GLASS, 1, 5));
		OreDictionary.registerOre("blockGlassPink", new ItemStack(Blocks.STAINED_GLASS, 1, 6));
		OreDictionary.registerOre("blockGlassGray", new ItemStack(Blocks.STAINED_GLASS, 1, 7));
		OreDictionary.registerOre("blockGlassLightGray", new ItemStack(Blocks.STAINED_GLASS, 1, 8));
		OreDictionary.registerOre("blockGlassSilver", new ItemStack(Blocks.STAINED_GLASS, 1, 8));
		OreDictionary.registerOre("blockGlassCyan", new ItemStack(Blocks.STAINED_GLASS, 1, 9));
		OreDictionary.registerOre("blockGlassPurple", new ItemStack(Blocks.STAINED_GLASS, 1, 10));
		OreDictionary.registerOre("blockGlassBlue", new ItemStack(Blocks.STAINED_GLASS, 1, 11));
		OreDictionary.registerOre("blockGlassBrown", new ItemStack(Blocks.STAINED_GLASS, 1, 12));
		OreDictionary.registerOre("blockGlassGreen", new ItemStack(Blocks.STAINED_GLASS, 1, 13));
		OreDictionary.registerOre("blockGlassRed", new ItemStack(Blocks.STAINED_GLASS, 1, 14));
		OreDictionary.registerOre("blockGlassBlack", new ItemStack(Blocks.STAINED_GLASS, 1, 15));

		OreDictionary.registerOre("paneGlassColorless", Blocks.GLASS_PANE);
		
		/** Seafood **/
		OreDictionary.registerOre("rawSquid", Items_Teatime.IKA);
		OreDictionary.registerOre("rawClam", Items_Teatime.HAMAGURI);
		
		/** Bamboo **/
		OreDictionary.registerOre("bamboo", Items_Seasonal.TAKE);
		OreDictionary.registerOre("cropBamboo", Items_Seasonal.TAKE);
		OreDictionary.registerOre("cropBambooshoot", Items_Seasonal.TAKENOKO);
		OreDictionary.registerOre("cropChestnut", Items_Seasonal.KURI);

		/** item_seeds_spice
		case 0:
		default:
			return "item." + "item_seeds_pepper";
		case 1:
			return "item." + "item_seeds_cumin";
		case 2:
			return "item." + "item_seeds_turmeric";
		case 3:
			return "item." + "item_seeds_chilipepper"; **/
		OreDictionary.registerOre("cropCumin", new ItemStack(Items_Teatime.SPICE_NAE, 1, 1));
		OreDictionary.registerOre("seedCumin", new ItemStack(Items_Teatime.SPICE_NAE, 1, 1));
		OreDictionary.registerOre("cropTurmeric", new ItemStack(Items_Teatime.SPICE_NAE, 1, 2));
		
		/** item_spice
		case 0:
		default:
			return "item." + "item_crop_pepper";
		case 1:
			return "item." + "item_crop_pepperdry";
		case 2:
			return "item." + "item_crop_chilipepper";
		case 3:
			return "item." + "item_dust_blackpepper";
		case 4:
			return "item." + "item_dust_cumin";
		case 5:
			return "item." + "item_dust_turmeric";
		case 6:
			return "item." + "item_dust_chili";
		case 7:
			return "item." + "item_curry_roux"; **/
		OreDictionary.registerOre("cropPepper", new ItemStack(Items_Teatime.SPICE, 1, 0));
		OreDictionary.registerOre("cropPeppercorn", new ItemStack(Items_Teatime.SPICE, 1, 0));
		OreDictionary.registerOre("cropBlackpepper", new ItemStack(Items_Teatime.SPICE, 1, 1));
		OreDictionary.registerOre("cropChilipepper", new ItemStack(Items_Teatime.SPICE, 1, 2));
		OreDictionary.registerOre("foodChilipepper", new ItemStack(Items_Teatime.SPICE, 1, 2));
		
		OreDictionary.registerOre("foodBlackpepper", new ItemStack(Items_Teatime.SPICE, 1, 3));
		OreDictionary.registerOre("dustPepper", new ItemStack(Items_Teatime.SPICE, 1, 3));
		OreDictionary.registerOre("dustBlackpepper", new ItemStack(Items_Teatime.SPICE, 1, 3));
		OreDictionary.registerOre("dustCumin", new ItemStack(Items_Teatime.SPICE, 1, 4));
		OreDictionary.registerOre("dustTurmeric", new ItemStack(Items_Teatime.SPICE, 1, 5));
		OreDictionary.registerOre("dustChili", new ItemStack(Items_Teatime.SPICE, 1, 6));
		OreDictionary.registerOre("foodChili", new ItemStack(Items_Teatime.SPICE, 1, 6));
		
		OreDictionary.registerOre("dustDashi", new ItemStack(Items_Teatime.DASHI_bot_1, 1, 0));
		OreDictionary.registerOre("dustDashi", new ItemStack(Items_Teatime.DASHI_bot_2, 1, 0));
		OreDictionary.registerOre("dustDashi", new ItemStack(Items_Teatime.DASHI_bot_3, 1, 0));
		OreDictionary.registerOre("dustDashi", new ItemStack(Items_Teatime.DASHI_bot_4, 1, 0));
		
		OreDictionary.registerOre("foodMayonaise", new ItemStack(Items_Teatime.MAYO_bot_1, 1, 0));
		OreDictionary.registerOre("foodMayonaise", new ItemStack(Items_Teatime.MAYO_bot_2, 1, 0));
		OreDictionary.registerOre("foodMayonaise", new ItemStack(Items_Teatime.MAYO_bot_3, 1, 0));
		OreDictionary.registerOre("foodMayonaise", new ItemStack(Items_Teatime.MAYO_bot_4, 1, 0));
		
		OreDictionary.registerOre("foodWorcestershiresauce", new ItemStack(Items_Teatime.OSAUCE_bot_1, 1, 0));
		OreDictionary.registerOre("foodWorcestershiresauce", new ItemStack(Items_Teatime.OSAUCE_bot_2, 1, 0));
		OreDictionary.registerOre("foodWorcestershiresauce", new ItemStack(Items_Teatime.OSAUCE_bot_3, 1, 0));
		OreDictionary.registerOre("foodWorcestershiresauce", new ItemStack(Items_Teatime.OSAUCE_bot_4, 1, 0));
	}
}
