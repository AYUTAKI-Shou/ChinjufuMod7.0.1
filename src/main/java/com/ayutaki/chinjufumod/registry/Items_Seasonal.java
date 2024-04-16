package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.armor.CMArmorMaterial;
import com.ayutaki.chinjufumod.items.armor.Costume_Santa;
import com.ayutaki.chinjufumod.items.armor.Costume_YUKATA;
import com.ayutaki.chinjufumod.items.food.Choco_Item;
import com.ayutaki.chinjufumod.items.food.ModFoodS_Item;
import com.ayutaki.chinjufumod.items.food.Wataame_Item;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.hakkou.ChocoRaw_Item;
import com.ayutaki.chinjufumod.items.hakkou.CocoaFerm_Item;
import com.ayutaki.chinjufumod.items.hakkou.CocoaMass_Item;
import com.ayutaki.chinjufumod.items.hakkou.CocoaRoast_Item;
import com.ayutaki.chinjufumod.items.seasonal.Carpet_Item;
import com.ayutaki.chinjufumod.items.seasonal.Chabudai_Item;
import com.ayutaki.chinjufumod.items.seasonal.DoorWood_Item;
import com.ayutaki.chinjufumod.items.seasonal.Iga_Item;
import com.ayutaki.chinjufumod.items.seasonal.Kakigouri_Item;
import com.ayutaki.chinjufumod.items.seasonal.Kotatsu_Item;
import com.ayutaki.chinjufumod.items.seasonal.KuriBoil_Item;
import com.ayutaki.chinjufumod.items.seasonal.KuriIga_Item;
import com.ayutaki.chinjufumod.items.seasonal.KuriSweet_Item;
import com.ayutaki.chinjufumod.items.seasonal.NabeNamaKuri_Item;
import com.ayutaki.chinjufumod.items.seasonal.NewYearXmas_Item;
import com.ayutaki.chinjufumod.items.seasonal.PillarSlabS_Item;
import com.ayutaki.chinjufumod.items.seasonal.PresentB_Item;
import com.ayutaki.chinjufumod.items.seasonal.Present_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Button_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_FenceGate_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Fence_Item;
import com.ayutaki.chinjufumod.items.seasonal.SPlate_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_IkegakiLong_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_IkegakiSmall_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Itabei_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Kanyou_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_ShoujiWin_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Bonsai_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_GarasudoHalf_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Garasudo_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Kanki_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Kido_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Planks_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Ranma_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_ShoujiHalf_Item;
import com.ayutaki.chinjufumod.items.seasonal.S_Shouji_Item;
import com.ayutaki.chinjufumod.items.seasonal.SeasonalTab_Item;
import com.ayutaki.chinjufumod.items.seasonal.SnowCore_Item;
import com.ayutaki.chinjufumod.items.seasonal.SnowMan_Item;
import com.ayutaki.chinjufumod.items.seasonal.Suiden_Item;
import com.ayutaki.chinjufumod.items.seasonal.Takenoko_Food;
import com.ayutaki.chinjufumod.items.seasonal.Uchiwa_Item;
import com.ayutaki.chinjufumod.items.seasonal.Warahai_Item;
import com.ayutaki.chinjufumod.items.seasonal.ZundouAku_Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Seasonal {

	public static Item ORIITO, TANMONO, WARAHAI;
	public static Item AKUNABE;
	public static Item FALL_LEAF, SUIDEN;

	public static Item SAKURA_flow, KAEDE_leaf, ICHOH_leaf, OAKKARE_leaf;
	public static Item SAKURA_log, KAEDE_log, ICHOH_log;
	public static Item SAKURA_nae, KAEDE_nae, ICHOH_nae, OAKKARE_nae;

	public static Item IGA, KURI_IGA, KURI, KURI_ROAST, KURI_SWEET, KURI_BOIL, KURI_NABE;
	public static Item TAKENOKO, TAKENOKO_ROAST, TAKE;
	
	public static Item PLANKS_sakura, PLANKS_kaede, PLANKS_ichoh;
	public static Item SAKURA_slabhalf, KAEDE_slabhalf, ICHOH_slabhalf;
	public static Item SAKURA_stairs, KAEDE_stairs, ICHOH_stairs;
	public static Item PILLAR_saku, PILLAR_kae, PILLAR_ich;
	public static Item PILLARSLAB_s;

	public static Item S_FENCE, S_FGATE, S_DOOR;
	public static Item SAKURA_TRAPDOOR, KAEDE_TRAPDOOR, ICHOH_TRAPDOOR;
	public static Item S_PLATE, S_BUTTON, S_CARPET;

	public static Item WP_LOG_sakura, WP_LOG_kaede, WP_LOG_ichoh;
	public static Item WP_PLANK_sakura, WP_PLANK_kaede, WP_PLANK_ichoh;

	public static Item SGARASUDO_item, SGARASUDOH_item, SSHOUJI_item, SSHOUJIH_item, SSHOUJIWIN_item;
	public static Item SRANMA_item, SKANKI_item;

	public static Item SBONSAI_item, SKANYOU_BOT, SIKEGAKI, SIKEGAKILONG_BOT, SITABEI_item, SKIDO_item;

	public static Item CHABUDAI, KOTATSU;

	public static Item KUSATABA, KUSATABA_STAIRS, WARATABA;
	public static Item KUSATABA_RF, WARATABA_RF, KAYATABA_RF;
	public static Item WARATABA_STAIRS, KAYATABA, KAYATABA_STAIRS;

	public static Item SHIMENAWA, NEWYEAR_XMAS;
	public static Item PRESENT, PRESENT_B;
	
	public static Item SNOWCORE, SNOWMAN;
	
	public static Item HINAKAZARI, HINADAN;

	public static Item COCOA_F, COCOA_R, COCOA_M, CHOCO_raw;
	public static Item COCOA_TARU;
	public static Item FOOD_CHOCO;

	public static Item UCHIWA_item;
	public static Item FOOD_WATAGASHI;
	public static Item WATAGASHI_block, WATAGASHI_pink, WATAGASHI_red, WATAGASHI_yellow, WATAGASHI_green;
	public static Item KAKIGOURI_hata;
	public static Item KAKIGOURI_block, KAKIGOURI_pink, KAKIGOURI_red, KAKIGOURI_yellow, KAKIGOURI_green;

	public static Item YKTD_GETA, YKTO_GETA;
	public static Item IKADUCHIYKT_HELMET, IKADUCHIYKT_CHESTPLATE, IKADUCHIYKT_LEGGINGS;
	public static Item INADUMAYKT_HELMET, INADUMAYKT_CHESTPLATE, INADUMAYKT_LEGGINGS;
	public static Item HAMAKAZEYKT_HELMET, HAMAKAZEYKT_CHESTPLATE, HAMAKAZEYKT_LEGGINGS;
	public static Item URAKAZEYKT_HELMET, URAKAZEYKT_CHESTPLATE, URAKAZEYKT_LEGGINGS;
	public static Item KAWAKAZEYKT_HELMET, KAWAKAZEYKT_CHESTPLATE, KAWAKAZEYKT_LEGGINGS;
	public static Item OBOROYKT_HELMET, OBOROYKT_CHESTPLATE, OBOROYKT_LEGGINGS;
	public static Item TTOKUYKT_CHESTPLATE, TTOKUYKT_LEGGINGS, TTOKUYKTB_CHESTPLATE, TTOKUYKTB_LEGGINGS;

	public static Item AKASHISANTA_HELMET, AKASHISANTA_CHESTPLATE, AKASHISANTA_LEGGINGS, AKASHISANTA_BOOTS;
	public static Item KUMANOSANTA_HELMET, KUMANOSANTA_CHESTPLATE, KUMANOSANTA_LEGGINGS, KUMANOSANTA_BOOTS;
	public static Item SUZUYASANTA_HELMET, SUZUYASANTA_CHESTPLATE, SUZUYASANTA_LEGGINGS, SUZUYASANTA_BOOTS;
	public static Item RYUJOUSANTA_HELMET, RYUJOUSANTA_CHESTPLATE, RYUJOUSANTA_LEGGINGS, RYUJOUSANTA_BOOTS;
	public static Item TEITOKUSANTA_HELMET, TEITOKUSANTA_CHESTPLATE, TEITOKUSANTA_LEGGINGS, TEITOKUSANTA_BOOTS;


	public static void init() {

		WARAHAI = new Warahai_Item("item_warahai");
		ORIITO = new SeasonalTab_Item("item_oriito");
		TANMONO = new SeasonalTab_Item("item_tanmono");
		AKUNABE = new ZundouAku_Item("block_zundou_aku");
		FALL_LEAF = new ItemBlock_noFuel("block_fall_leaf", Seasonal_Blocks.FALL_LEAF);
		SUIDEN = new Suiden_Item("block_suiden"); //default の meta が 0 ではない為, ItemBlockのクラスを書いて対応

		SAKURA_flow = new ItemBlock_noFuel("block_tree_sakura_flow", Seasonal_Blocks.SAKURA_flow);
		KAEDE_leaf = new ItemBlock_noFuel("block_tree_kaede_leaf", Seasonal_Blocks.KAEDE_leaf);
		ICHOH_leaf = new ItemBlock_noFuel("block_tree_ichoh_leaf", Seasonal_Blocks.ICHOH_leaf);
		OAKKARE_leaf = new ItemBlock_noFuel("block_tree_oakkare_leaf", Seasonal_Blocks.OAKKARE_leaf);
		SAKURA_log = new ItemBlock_Fuel300("block_tree_sakura_log", Seasonal_Blocks.SAKURA_log);
		KAEDE_log = new ItemBlock_Fuel300("block_tree_kaede_log", Seasonal_Blocks.KAEDE_log);
		ICHOH_log = new ItemBlock_Fuel300("block_tree_ichoh_log", Seasonal_Blocks.ICHOH_log);
		SAKURA_nae = new ItemBlock_Fuel100("block_tree_sakura_nae", Seasonal_Blocks.SAKURA_nae);
		KAEDE_nae = new ItemBlock_Fuel100("block_tree_kaede_nae", Seasonal_Blocks.KAEDE_nae);
		ICHOH_nae = new ItemBlock_Fuel100("block_tree_ichoh_nae", Seasonal_Blocks.ICHOH_nae);
		OAKKARE_nae = new ItemBlock_Fuel100("block_tree_oakkare_nae", Seasonal_Blocks.OAKKARE_nae);

		IGA = new Iga_Item("item_chestnuts_burr");
		KURI_IGA = new KuriIga_Item("block_chestnuts", Seasonal_Blocks.KURIIGA_FALL);
		KURI = new SeasonalTab_Item("item_chestnut");
		KURI_ROAST= new ModFoodS_Item("item_food_chestnut", 2, 0.4F, false);
		KURI_SWEET= new KuriSweet_Item("item_food_chestnutsweet", 4, 0.6F, false);
		KURI_BOIL = new KuriBoil_Item("item_chestnut_boil");
		KURI_NABE = new NabeNamaKuri_Item("block_food_nabekuri_n");
		TAKENOKO= new ItemBlock_noFuel("block_takenoko", Seasonal_Blocks.TAKENOKO);
		TAKENOKO_ROAST= new Takenoko_Food("item_food_takenoko", 4, 0.6F, false);
		TAKE = new SeasonalTab_Item("block_take");
		
		PLANKS_sakura = new S_Planks_Item("block_planks_sakura");
		PLANKS_kaede = new S_Planks_Item("block_planks_kaede");
		PLANKS_ichoh = new S_Planks_Item("block_planks_ichoh");
		SAKURA_slabhalf = new ItemBlock_Fuel150("block_slabhalf_sakura", Seasonal_Blocks.SAKURA_slabhalf);
		KAEDE_slabhalf = new ItemBlock_Fuel150("block_slabhalf_kaede", Seasonal_Blocks.KAEDE_slabhalf);
		ICHOH_slabhalf = new ItemBlock_Fuel150("block_slabhalf_ichoh", Seasonal_Blocks.ICHOH_slabhalf);
		SAKURA_stairs = new ItemBlock_Fuel300("block_stairs_sakura", Seasonal_Blocks.SAKURA_stairs);
		KAEDE_stairs = new ItemBlock_Fuel300("block_stairs_kaede", Seasonal_Blocks.KAEDE_stairs);
		ICHOH_stairs = new ItemBlock_Fuel300("block_stairs_ichoh", Seasonal_Blocks.ICHOH_stairs);
		PILLAR_saku = new ItemBlock_Fuel300("block_pillar_sakura", Seasonal_Blocks.PILLAR_saku);
		PILLAR_kae = new ItemBlock_Fuel300("block_pillar_kaede", Seasonal_Blocks.PILLAR_kae);
		PILLAR_ich = new ItemBlock_Fuel300("block_pillar_ichoh", Seasonal_Blocks.PILLAR_ich);
		PILLARSLAB_s = new PillarSlabS_Item("block_kamoi_s");

		S_FENCE = new S_Fence_Item("block_fence_s");
		S_FGATE = new S_FenceGate_Item("block_fencegate_s");
		S_DOOR = new DoorWood_Item("block_door_s");
		SAKURA_TRAPDOOR = new ItemBlock_Fuel300("block_trapdoor_sakura", Seasonal_Blocks.SAKURA_TRAPDOOR);
		KAEDE_TRAPDOOR = new ItemBlock_Fuel300("block_trapdoor_kaede", Seasonal_Blocks.KAEDE_TRAPDOOR);
		ICHOH_TRAPDOOR = new ItemBlock_Fuel300("block_trapdoor_ichoh", Seasonal_Blocks.ICHOH_TRAPDOOR);
		S_PLATE = new SPlate_Item("block_plate_s");
		S_BUTTON = new S_Button_Item("block_button_s");
		S_CARPET = new Carpet_Item("block_carpet_s");

		WP_LOG_sakura = new ItemBlock_noFuel("block_wp_log_sakura", Seasonal_Blocks.WP_LOG_sakura);
		WP_LOG_kaede = new ItemBlock_noFuel("block_wp_log_kaede", Seasonal_Blocks.WP_LOG_kaede);
		WP_LOG_ichoh = new ItemBlock_noFuel("block_wp_log_ichoh", Seasonal_Blocks.WP_LOG_ichoh);
		WP_PLANK_sakura = new ItemBlock_noFuel("block_wp_plank_sakura", Seasonal_Blocks.WP_PLANK_sakura);
		WP_PLANK_kaede = new ItemBlock_noFuel("block_wp_plank_kaede", Seasonal_Blocks.WP_PLANK_kaede);
		WP_PLANK_ichoh = new ItemBlock_noFuel("block_wp_plank_ichoh", Seasonal_Blocks.WP_PLANK_ichoh);

		SGARASUDO_item = new S_Garasudo_Item("block_garasudo_s");
		SGARASUDOH_item = new S_GarasudoHalf_Item("block_garasudohalf_s");
		SSHOUJI_item = new S_Shouji_Item("block_shouji_s");
		SSHOUJIH_item = new S_ShoujiHalf_Item("block_shoujihalf_s");
		SSHOUJIWIN_item = new S_ShoujiWin_Item("block_shoujih_s");

		SRANMA_item = new S_Ranma_Item("block_ranma_s");
		SKANKI_item = new S_Kanki_Item("block_kanki_s");

		SBONSAI_item = new S_Bonsai_Item("block_bonsai_s");
		SKANYOU_BOT = new S_Kanyou_Item("block_kanyousakura_bot");
		SIKEGAKI = new S_IkegakiSmall_Item("block_low_sakura");
		SIKEGAKILONG_BOT = new S_IkegakiLong_Item("block_longsakura_bot");

		SITABEI_item = new S_Itabei_Item("block_itabei_sakura");
		SKIDO_item = new S_Kido_Item("block_kido_sakura");
				
		CHABUDAI = new Chabudai_Item("block_chabudai");
		KOTATSU = new Kotatsu_Item("block_kotatsu");

		KUSATABA = new ItemBlock_Fuel200("block_tabakusa", Seasonal_Blocks.KUSATABA);
		WARATABA = new ItemBlock_Fuel200("block_tabawara", Seasonal_Blocks.WARATABA);
		KAYATABA = new ItemBlock_Fuel200("block_tabakaya", Seasonal_Blocks.KAYATABA);
		KUSATABA_RF = new ItemBlock_Fuel100("block_tabakusa_roof", Seasonal_Blocks.KUSATABA_RF);
		WARATABA_RF = new ItemBlock_Fuel100("block_tabawara_roof", Seasonal_Blocks.WARATABA_RF);
		KAYATABA_RF = new ItemBlock_Fuel100("block_tabakaya_roof", Seasonal_Blocks.KAYATABA_RF);
		KUSATABA_STAIRS = new ItemBlock_Fuel200("block_tabakusa_stairs", Seasonal_Blocks.KUSATABA_STAIRS);
		WARATABA_STAIRS = new ItemBlock_Fuel200("block_tabawara_stairs", Seasonal_Blocks.WARATABA_STAIRS);
		KAYATABA_STAIRS = new ItemBlock_Fuel200("block_tabakaya_stairs", Seasonal_Blocks.KAYATABA_STAIRS);

		SHIMENAWA = new ItemBlock_Fuel100("block_shimenawa", Seasonal_Blocks.SHIMENAWA);
		NEWYEAR_XMAS = new NewYearXmas_Item("block_kadomatsu");
		PRESENT = new Present_Item("block_present");
		PRESENT_B = new PresentB_Item("block_present_b");
		SNOWCORE = new SnowCore_Item("block_snowcore");
		SNOWMAN = new SnowMan_Item("block_snowman_bot1");
		
		HINAKAZARI = new ItemBlock(Seasonal_Blocks.HINAKAZARI).setRegistryName("block_hinakazari").setUnlocalizedName("block_hinakazari");
		HINADAN = new ItemBlock(Seasonal_Blocks.HINADAN).setRegistryName("block_hinadan").setUnlocalizedName("block_hinadan");

		COCOA_F = new CocoaFerm_Item("item_cocoa_ferm").setCreativeTab(ChinjufuModTabs.SEASONAL);
		COCOA_R= new CocoaRoast_Item("item_cocoa_roast").setCreativeTab(ChinjufuModTabs.SEASONAL);
		COCOA_M= new CocoaMass_Item("item_cocoa_mass").setCreativeTab(ChinjufuModTabs.SEASONAL);
		CHOCO_raw = new ChocoRaw_Item("item_choco_raw").setCreativeTab(ChinjufuModTabs.SEASONAL);
		COCOA_TARU = new ItemBlock(Hakkou_Blocks.COCOA_TARU).setRegistryName("block_taru_cocoa_f").setUnlocalizedName("block_taru_cocoa_f");
		FOOD_CHOCO = new Choco_Item("item_food_choco", 1, 0.3F, false).setCreativeTab(ChinjufuModTabs.SEASONAL);

		UCHIWA_item = new Uchiwa_Item("block_uchiwa");
		FOOD_WATAGASHI = new Wataame_Item("item_food_watagashi", 1, 0.3F, false).setCreativeTab(ChinjufuModTabs.SEASONAL);
		WATAGASHI_block = new ItemBlock_noFuel("block_watagashi", Seasonal_Blocks.WATAGASHI_block);
		WATAGASHI_pink = new ItemBlock_noFuel("block_watagashi_pink", Seasonal_Blocks.WATAGASHI_pink);
		WATAGASHI_red = new ItemBlock_noFuel("block_watagashi_red", Seasonal_Blocks.WATAGASHI_red);
		WATAGASHI_yellow = new ItemBlock_noFuel("block_watagashi_yellow", Seasonal_Blocks.WATAGASHI_yellow);
		WATAGASHI_green = new ItemBlock_noFuel("block_watagashi_green", Seasonal_Blocks.WATAGASHI_green);

		KAKIGOURI_hata = new ItemBlock_noFuel("block_kakigouri_hata", Seasonal_Blocks.KAKIGOURI_hata);
		KAKIGOURI_block = new Kakigouri_Item("block_kakigouri_block1", 0, 0.0F, false);
		KAKIGOURI_pink = new Kakigouri_Item("block_kakigouri_pink1", 0, 0.0F, false);
		KAKIGOURI_red = new Kakigouri_Item("block_kakigouri_red1", 0, 0.0F, false);
		KAKIGOURI_yellow = new Kakigouri_Item("block_kakigouri_yellow1", 0, 0.0F, false);
		KAKIGOURI_green = new Kakigouri_Item("block_kakigouri_green1", 0, 0.0F, false);

		/* YUKARA */
		YKTD_GETA = new Costume_YUKATA("item_ykt_getadoak", CMArmorMaterial.IKADUCHIYKT, 1, EntityEquipmentSlot.FEET);
		YKTO_GETA = new Costume_YUKATA("item_ykt_getaoak", CMArmorMaterial.TTOKUYKT, 1, EntityEquipmentSlot.FEET);

		IKADUCHIYKT_HELMET = new Costume_YUKATA("item_ykt_ikaduchi_kazari", CMArmorMaterial.IKADUCHIYKT, 1, EntityEquipmentSlot.HEAD);
		IKADUCHIYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_ikaduchi_mini", CMArmorMaterial.IKADUCHIYKT, 1,EntityEquipmentSlot.CHEST);
		IKADUCHIYKT_LEGGINGS = new Costume_YUKATA("item_ykt_ikaduchi_long", CMArmorMaterial.IKADUCHIYKT, 2, EntityEquipmentSlot.LEGS);

		INADUMAYKT_HELMET = new Costume_YUKATA("item_ykt_inaduma_kazari", CMArmorMaterial.INADUMAYKT, 1, EntityEquipmentSlot.HEAD);
		INADUMAYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_inaduma_mini", CMArmorMaterial.INADUMAYKT, 1, EntityEquipmentSlot.CHEST);
		INADUMAYKT_LEGGINGS = new Costume_YUKATA("item_ykt_inaduma_long", CMArmorMaterial.INADUMAYKT, 2, EntityEquipmentSlot.LEGS);

		HAMAKAZEYKT_HELMET = new Costume_YUKATA("item_ykt_hamakaze_kazari", CMArmorMaterial.HAMAKAZEYKT, 1, EntityEquipmentSlot.HEAD);
		HAMAKAZEYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_hamakaze_mini", CMArmorMaterial.HAMAKAZEYKT, 1, EntityEquipmentSlot.CHEST);
		HAMAKAZEYKT_LEGGINGS = new Costume_YUKATA("item_ykt_hamakaze_long", CMArmorMaterial.HAMAKAZEYKT, 2, EntityEquipmentSlot.LEGS);

		URAKAZEYKT_HELMET = new Costume_YUKATA("item_ykt_urakaze_kazari", CMArmorMaterial.URAKAZEYKT, 1, EntityEquipmentSlot.HEAD);
		URAKAZEYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_urakaze_mini", CMArmorMaterial.URAKAZEYKT, 1, EntityEquipmentSlot.CHEST);
		URAKAZEYKT_LEGGINGS = new Costume_YUKATA("item_ykt_urakaze_long", CMArmorMaterial.URAKAZEYKT, 2, EntityEquipmentSlot.LEGS);

		KAWAKAZEYKT_HELMET = new Costume_YUKATA("item_ykt_kawakaze_kazari", CMArmorMaterial.KAWAKAZEYKT, 1, EntityEquipmentSlot.HEAD);
		KAWAKAZEYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_kawakaze_mini", CMArmorMaterial.KAWAKAZEYKT, 1, EntityEquipmentSlot.CHEST);
		KAWAKAZEYKT_LEGGINGS = new Costume_YUKATA("item_ykt_kawakaze_long", CMArmorMaterial.KAWAKAZEYKT, 2, EntityEquipmentSlot.LEGS);

		OBOROYKT_HELMET = new Costume_YUKATA("item_ykt_oboro_kazari", CMArmorMaterial.OBOROYKT, 1, EntityEquipmentSlot.HEAD);
		OBOROYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_oboro_mini", CMArmorMaterial.OBOROYKT, 1, EntityEquipmentSlot.CHEST);
		OBOROYKT_LEGGINGS = new Costume_YUKATA("item_ykt_oboro_long", CMArmorMaterial.OBOROYKT, 2, EntityEquipmentSlot.LEGS);

		TTOKUYKT_CHESTPLATE = new Costume_YUKATA("item_ykt_ttoku_mini", CMArmorMaterial.TTOKUYKT, 1,EntityEquipmentSlot.CHEST);
		TTOKUYKT_LEGGINGS = new Costume_YUKATA("item_ykt_ttoku_long", CMArmorMaterial.TTOKUYKT, 2, EntityEquipmentSlot.LEGS);
		TTOKUYKTB_CHESTPLATE = new Costume_YUKATA("item_ykt_ttokub_mini", CMArmorMaterial.TTOKUYKTB, 1, EntityEquipmentSlot.CHEST);
		TTOKUYKTB_LEGGINGS = new Costume_YUKATA("item_ykt_ttokub_long", CMArmorMaterial.TTOKUYKTB, 2, EntityEquipmentSlot.LEGS);

		/* SANTA COS */
		AKASHISANTA_HELMET = new Costume_Santa("item_santaakashi_helmet", CMArmorMaterial.AKASHISANTA, 1, EntityEquipmentSlot.HEAD);
		AKASHISANTA_CHESTPLATE = new Costume_Santa("item_santaakashi_chestplate", CMArmorMaterial.AKASHISANTA, 1, EntityEquipmentSlot.CHEST);
		AKASHISANTA_LEGGINGS = new Costume_Santa("item_santaakashi_leggings", CMArmorMaterial.AKASHISANTA, 2, EntityEquipmentSlot.LEGS);
		AKASHISANTA_BOOTS = new Costume_Santa("item_santaakashi_boots", CMArmorMaterial.AKASHISANTA, 1, EntityEquipmentSlot.FEET);

		KUMANOSANTA_HELMET = new Costume_Santa("item_santakumano_helmet", CMArmorMaterial.KUMANOSANTA, 1, EntityEquipmentSlot.HEAD);
		KUMANOSANTA_CHESTPLATE = new Costume_Santa("item_santakumano_chestplate", CMArmorMaterial.KUMANOSANTA, 1,EntityEquipmentSlot.CHEST);
		KUMANOSANTA_LEGGINGS = new Costume_Santa("item_santakumano_leggings", CMArmorMaterial.KUMANOSANTA, 2, EntityEquipmentSlot.LEGS);
		KUMANOSANTA_BOOTS = new Costume_Santa("item_santakumano_boots", CMArmorMaterial.KUMANOSANTA, 1, EntityEquipmentSlot.FEET);

		SUZUYASANTA_HELMET = new Costume_Santa("item_santasuzuya_helmet", CMArmorMaterial.SUZUYASANTA, 1, EntityEquipmentSlot.HEAD);
		SUZUYASANTA_CHESTPLATE = new Costume_Santa("item_santasuzuya_chestplate", CMArmorMaterial.SUZUYASANTA, 1, EntityEquipmentSlot.CHEST);
		SUZUYASANTA_LEGGINGS = new Costume_Santa("item_santasuzuya_leggings", CMArmorMaterial.SUZUYASANTA, 2, EntityEquipmentSlot.LEGS);
		SUZUYASANTA_BOOTS = new Costume_Santa("item_santasuzuya_boots", CMArmorMaterial.SUZUYASANTA, 1, EntityEquipmentSlot.FEET);

		RYUJOUSANTA_HELMET = new Costume_Santa("item_santaryujou_helmet", CMArmorMaterial.RYUJOUSANTA, 1, EntityEquipmentSlot.HEAD);
		RYUJOUSANTA_CHESTPLATE = new Costume_Santa("item_santaryujou_chestplate", CMArmorMaterial.RYUJOUSANTA, 1, EntityEquipmentSlot.CHEST);
		RYUJOUSANTA_LEGGINGS = new Costume_Santa("item_santaryujou_leggings", CMArmorMaterial.RYUJOUSANTA, 2, EntityEquipmentSlot.LEGS);
		RYUJOUSANTA_BOOTS = new Costume_Santa("item_santaryujou_boots", CMArmorMaterial.RYUJOUSANTA, 1, EntityEquipmentSlot.FEET);

		TEITOKUSANTA_HELMET = new Costume_Santa("item_santattk_helmet", CMArmorMaterial.TEITOKUSANTA, 1, EntityEquipmentSlot.HEAD);
		TEITOKUSANTA_CHESTPLATE = new Costume_Santa("item_santattk_chestplate", CMArmorMaterial.TEITOKUSANTA, 1, EntityEquipmentSlot.CHEST);
		TEITOKUSANTA_LEGGINGS = new Costume_Santa("item_santattk_leggings", CMArmorMaterial.TEITOKUSANTA, 2, EntityEquipmentSlot.LEGS);
		TEITOKUSANTA_BOOTS = new Costume_Santa("item_santattk_boots", CMArmorMaterial.TEITOKUSANTA, 1, EntityEquipmentSlot.FEET);
	}


	public static void register() {

		registerItem(WARAHAI);
		registerItem(ORIITO);
		registerItem(TANMONO);
		registerItem(AKUNABE);
		registerItem(FALL_LEAF);
		registerItem(SUIDEN);

		registerItem(SAKURA_flow);
		registerItem(KAEDE_leaf);
		registerItem(ICHOH_leaf);
		registerItem(OAKKARE_leaf);
		registerItem(SAKURA_log);
		registerItem(KAEDE_log);
		registerItem(ICHOH_log);
		registerItem(SAKURA_nae);
		registerItem(KAEDE_nae);
		registerItem(ICHOH_nae);
		registerItem(OAKKARE_nae);

		registerItem(IGA);
		registerItem(KURI_IGA);
		registerItem(KURI);
		registerItem(KURI_ROAST);
		registerItem(KURI_SWEET);
		registerItem(KURI_BOIL);
		registerItem(KURI_NABE);
		registerItem(TAKENOKO);
		registerItem(TAKENOKO_ROAST);
		registerItem(TAKE);
		
		registerItem(PLANKS_sakura);
		registerItem(PLANKS_kaede);
		registerItem(PLANKS_ichoh);
		registerItem(SAKURA_slabhalf);
		registerItem(KAEDE_slabhalf);
		registerItem(ICHOH_slabhalf);
		registerItem(SAKURA_stairs);
		registerItem(KAEDE_stairs);
		registerItem(ICHOH_stairs);
		registerItem(PILLAR_saku);
		registerItem(PILLAR_kae);
		registerItem(PILLAR_ich);
		registerItem(PILLARSLAB_s);

		registerItem(S_FENCE);
		registerItem(S_FGATE);
		registerItem(S_DOOR);
		registerItem(SAKURA_TRAPDOOR);
		registerItem(KAEDE_TRAPDOOR);
		registerItem(ICHOH_TRAPDOOR);
		registerItem(S_PLATE);
		registerItem(S_BUTTON);
		registerItem(S_CARPET);

		registerItem(WP_LOG_sakura);
		registerItem(WP_LOG_kaede);
		registerItem(WP_LOG_ichoh);
		registerItem(WP_PLANK_sakura);
		registerItem(WP_PLANK_kaede);
		registerItem(WP_PLANK_ichoh);

		registerItem(SGARASUDO_item);
		registerItem(SGARASUDOH_item);
		registerItem(SSHOUJI_item);
		registerItem(SSHOUJIH_item);
		registerItem(SSHOUJIWIN_item);

		registerItem(SRANMA_item);
		registerItem(SKANKI_item);

		registerItem(SBONSAI_item);
		registerItem(SKANYOU_BOT);
		registerItem(SIKEGAKI);
		registerItem(SIKEGAKILONG_BOT);

		registerItem(SITABEI_item);
		registerItem(SKIDO_item);
		
		registerItem(CHABUDAI);
		registerItem(KOTATSU);

		registerItem(KUSATABA);
		registerItem(WARATABA);
		registerItem(KAYATABA);
		registerItem(KUSATABA_RF);
		registerItem(WARATABA_RF);
		registerItem(KAYATABA_RF);
		registerItem(KUSATABA_STAIRS);
		registerItem(WARATABA_STAIRS);
		registerItem(KAYATABA_STAIRS);

		registerItem(SHIMENAWA);
		registerItem(NEWYEAR_XMAS);
		registerItem(PRESENT);
		registerItem(PRESENT_B);
		registerItem(SNOWCORE);
		registerItem(SNOWMAN);
		
		registerItem(HINAKAZARI);
		registerItem(HINADAN);

		registerItem(COCOA_F);
		registerItem(COCOA_R);
		registerItem(COCOA_M);
		registerItem(CHOCO_raw);
		registerItem(COCOA_TARU);
		registerItem(FOOD_CHOCO);

		registerItem(UCHIWA_item);
		registerItem(FOOD_WATAGASHI);
		registerItem(WATAGASHI_block);
		registerItem(WATAGASHI_pink);
		registerItem(WATAGASHI_red);
		registerItem(WATAGASHI_yellow);
		registerItem(WATAGASHI_green);

		registerItem(KAKIGOURI_hata);
		registerItem(KAKIGOURI_block);
		registerItem(KAKIGOURI_pink);
		registerItem(KAKIGOURI_red);
		registerItem(KAKIGOURI_yellow);
		registerItem(KAKIGOURI_green);

		registerItem(YKTD_GETA);
		registerItem(YKTO_GETA);
		registerItem(IKADUCHIYKT_HELMET);
		registerItem(IKADUCHIYKT_CHESTPLATE);
		registerItem(IKADUCHIYKT_LEGGINGS);
		registerItem(INADUMAYKT_HELMET);
		registerItem(INADUMAYKT_CHESTPLATE);
		registerItem(INADUMAYKT_LEGGINGS);

		registerItem(HAMAKAZEYKT_HELMET);
		registerItem(HAMAKAZEYKT_CHESTPLATE);
		registerItem(HAMAKAZEYKT_LEGGINGS);
		registerItem(URAKAZEYKT_HELMET);
		registerItem(URAKAZEYKT_CHESTPLATE);
		registerItem(URAKAZEYKT_LEGGINGS);
		registerItem(KAWAKAZEYKT_HELMET);
		registerItem(KAWAKAZEYKT_CHESTPLATE);
		registerItem(KAWAKAZEYKT_LEGGINGS);
		registerItem(OBOROYKT_HELMET);
		registerItem(OBOROYKT_CHESTPLATE);
		registerItem(OBOROYKT_LEGGINGS);

		registerItem(TTOKUYKT_CHESTPLATE);
		registerItem(TTOKUYKT_LEGGINGS);
		registerItem(TTOKUYKTB_CHESTPLATE);
		registerItem(TTOKUYKTB_LEGGINGS);

		registerItem(AKASHISANTA_HELMET);
		registerItem(AKASHISANTA_CHESTPLATE);
		registerItem(AKASHISANTA_LEGGINGS);
		registerItem(AKASHISANTA_BOOTS);
		registerItem(KUMANOSANTA_HELMET);
		registerItem(KUMANOSANTA_CHESTPLATE);
		registerItem(KUMANOSANTA_LEGGINGS);
		registerItem(KUMANOSANTA_BOOTS);
		registerItem(SUZUYASANTA_HELMET);
		registerItem(SUZUYASANTA_CHESTPLATE);
		registerItem(SUZUYASANTA_LEGGINGS);
		registerItem(SUZUYASANTA_BOOTS);
		registerItem(RYUJOUSANTA_HELMET);
		registerItem(RYUJOUSANTA_CHESTPLATE);
		registerItem(RYUJOUSANTA_LEGGINGS);
		registerItem(RYUJOUSANTA_BOOTS);
		registerItem(TEITOKUSANTA_HELMET);
		registerItem(TEITOKUSANTA_CHESTPLATE);
		registerItem(TEITOKUSANTA_LEGGINGS);
		registerItem(TEITOKUSANTA_BOOTS);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(WARAHAI);
		registerRender(ORIITO);
		registerRender(TANMONO);
		registerRender(AKUNABE);
		registerRender(FALL_LEAF);
		registerRender(SUIDEN);

		registerRender(SAKURA_flow);
		registerRender(KAEDE_leaf);
		registerRender(ICHOH_leaf);
		registerRender(OAKKARE_leaf);
		registerRender(SAKURA_log);
		registerRender(KAEDE_log);
		registerRender(ICHOH_log);
		registerRender(SAKURA_nae);
		registerRender(KAEDE_nae);
		registerRender(ICHOH_nae);
		registerRender(OAKKARE_nae);

		registerRender(IGA);
		registerRender(KURI_IGA);
		registerRender(KURI);
		registerRender(KURI_ROAST);
		registerRenderMeta(KURI_SWEET, 0, "item_food_chestnutsweet");
		registerRenderMeta(KURI_SWEET, 1, "item_food_chestnutchoco");
		registerRenderMeta(KURI_BOIL, 0, "item_chestnut_boil");
		registerRenderMeta(KURI_BOIL, 1, "item_chestnut_mash");
		registerRenderMeta(KURI_NABE, 1, "block_food_nabekuri_n");
		registerRenderMeta(KURI_NABE, 2, "block_food_nabekuri_b");
		registerRender(TAKENOKO);
		registerRender(TAKENOKO_ROAST);
		registerRender(TAKE);
		
		registerRender(PLANKS_sakura);
		registerRender(PLANKS_kaede);
		registerRender(PLANKS_ichoh);
		registerRender(SAKURA_slabhalf);
		registerRender(KAEDE_slabhalf);
		registerRender(ICHOH_slabhalf);
		registerRender(SAKURA_stairs);
		registerRender(KAEDE_stairs);
		registerRender(ICHOH_stairs);
		registerRender(PILLAR_saku);
		registerRender(PILLAR_kae);
		registerRender(PILLAR_ich);
		registerRenderMeta(PILLARSLAB_s, 0, "block_kamoi_sakura");
		registerRenderMeta(PILLARSLAB_s, 1, "block_kamoi_kaede");
		registerRenderMeta(PILLARSLAB_s, 2, "block_kamoi_ichoh");

		registerRenderMeta(S_FENCE, 0, "block_fence_sakura");
		registerRenderMeta(S_FENCE, 1, "block_fence_kaede");
		registerRenderMeta(S_FENCE, 2, "block_fence_ichoh");
		registerRenderMeta(S_FGATE, 0, "block_fencegate_sakura");
		registerRenderMeta(S_FGATE, 1, "block_fencegate_kaede");
		registerRenderMeta(S_FGATE, 2, "block_fencegate_ichoh");
		registerRenderMeta(S_DOOR, 0, "block_door_sakura");
		registerRenderMeta(S_DOOR, 1, "block_door_kaede");
		registerRenderMeta(S_DOOR, 2, "block_door_ichoh");
		registerRender(SAKURA_TRAPDOOR);
		registerRender(KAEDE_TRAPDOOR);
		registerRender(ICHOH_TRAPDOOR);
		registerRenderMeta(S_PLATE, 0, "block_plate_sakura");
		registerRenderMeta(S_PLATE, 1, "block_plate_kaede");
		registerRenderMeta(S_PLATE, 2, "block_plate_ichoh");
		registerRenderMeta(S_BUTTON, 0, "block_button_sakura");
		registerRenderMeta(S_BUTTON, 1, "block_button_kaede");
		registerRenderMeta(S_BUTTON, 2, "block_button_ichoh");
		registerRenderMeta(S_CARPET, 0, "block_carpet_sakura");
		registerRenderMeta(S_CARPET, 1, "block_carpet_kaede");
		registerRenderMeta(S_CARPET, 2, "block_carpet_ichoh");
		registerRenderMeta(S_CARPET, 3, "block_carpet_ochiba");

		registerRender(WP_LOG_sakura);
		registerRender(WP_LOG_kaede);
		registerRender(WP_LOG_ichoh);
		registerRender(WP_PLANK_sakura);
		registerRender(WP_PLANK_kaede);
		registerRender(WP_PLANK_ichoh);

		registerRenderMeta(SGARASUDO_item, 0, "block_garasudo_sakura");
		registerRenderMeta(SGARASUDO_item, 1, "block_garasudo_kaede");
		registerRenderMeta(SGARASUDO_item, 2, "block_garasudo_ichoh");
		registerRenderMeta(SGARASUDO_item, 3, "block_garasudob_sakura");
		registerRenderMeta(SGARASUDO_item, 4, "block_garasudob_kaede");
		registerRenderMeta(SGARASUDO_item, 5, "block_garasudob_ichoh");
		registerRenderMeta(SGARASUDOH_item, 0, "block_garasudohalf_sakura");
		registerRenderMeta(SGARASUDOH_item, 1, "block_garasudohalf_kaede");
		registerRenderMeta(SGARASUDOH_item, 2, "block_garasudohalf_ichoh");

		registerRenderMeta(SSHOUJI_item, 0, "block_shouji_sakura");
		registerRenderMeta(SSHOUJI_item, 1, "block_shouji_kaede");
		registerRenderMeta(SSHOUJI_item, 2, "block_shouji_ichoh");
		registerRenderMeta(SSHOUJI_item, 3, "block_shoujib_sakura");
		registerRenderMeta(SSHOUJI_item, 4, "block_shoujib_kaede");
		registerRenderMeta(SSHOUJI_item, 5, "block_shoujib_ichoh");
		registerRenderMeta(SSHOUJIH_item, 0, "block_shoujihalf_sakura");
		registerRenderMeta(SSHOUJIH_item, 1, "block_shoujihalf_kaede");
		registerRenderMeta(SSHOUJIH_item, 2, "block_shoujihalf_ichoh");
		registerRenderMeta(SSHOUJIWIN_item, 0, "block_shoujih_sakura");
		registerRenderMeta(SSHOUJIWIN_item, 1, "block_shoujih_kaede");
		registerRenderMeta(SSHOUJIWIN_item, 2, "block_shoujih_ichoh");

		registerRenderMeta(SRANMA_item, 0, "block_ranma_saku");
		registerRenderMeta(SRANMA_item, 1, "block_ranma_kae");
		registerRenderMeta(SRANMA_item, 2, "block_ranma_ich");
		registerRenderMeta(SRANMA_item, 3, "block_ranmab_saku");
		registerRenderMeta(SRANMA_item, 4, "block_ranmab_kae");
		registerRenderMeta(SRANMA_item, 5, "block_ranmab_ich");
		registerRenderMeta(SRANMA_item, 6, "block_ranmac_saku");
		registerRenderMeta(SRANMA_item, 7, "block_ranmac_kae");
		registerRenderMeta(SRANMA_item, 8, "block_ranmac_ich");
		
		registerRenderMeta(SKANKI_item, 0, "block_kanki_saku");
		registerRenderMeta(SKANKI_item, 1, "block_kanki_kae");
		registerRenderMeta(SKANKI_item, 2, "block_kanki_ich");
		registerRenderMeta(SKANKI_item, 3, "block_koushi_saku");
		registerRenderMeta(SKANKI_item, 4, "block_koushi_kae");
		registerRenderMeta(SKANKI_item, 5, "block_koushi_ich");
		registerRenderMeta(SKANKI_item, 6, "block_koushib_saku");
		registerRenderMeta(SKANKI_item, 7, "block_koushib_kae");
		registerRenderMeta(SKANKI_item, 8, "block_koushib_ich");

		registerRenderMeta(SBONSAI_item, 0, "block_bonsai_sakura");
		registerRenderMeta(SBONSAI_item, 1, "block_bonsai_kaede");
		registerRenderMeta(SBONSAI_item, 2, "block_bonsai_ichoh");
		registerRenderMeta(SBONSAI_item, 3, "block_bonsai_oakkare");
		registerRenderMeta(SKANYOU_BOT, 0, "block_kanyousakura_bot");
		registerRenderMeta(SKANYOU_BOT, 1, "block_kanyoukaede_bot");
		registerRenderMeta(SKANYOU_BOT, 2, "block_kanyouichoh_bot");
		registerRenderMeta(SKANYOU_BOT, 3, "block_kanyouoakkare_bot");
		registerRenderMeta(SIKEGAKI, 0, "block_low_sakura");
		registerRenderMeta(SIKEGAKI, 1, "block_low_kaede");
		registerRenderMeta(SIKEGAKI, 2, "block_low_ichoh");
		registerRenderMeta(SIKEGAKI, 3, "block_low_oakkare");
		registerRenderMeta(SIKEGAKILONG_BOT, 0, "block_longsakura_bot");
		registerRenderMeta(SIKEGAKILONG_BOT, 1, "block_longkaede_bot");
		registerRenderMeta(SIKEGAKILONG_BOT, 2, "block_longichoh_bot");
		registerRenderMeta(SIKEGAKILONG_BOT, 3, "block_longoakkare_bot");

		registerRenderMeta(SITABEI_item, 0, "block_itabei_sakura");
		registerRenderMeta(SITABEI_item, 1, "block_itabei_kaede");
		registerRenderMeta(SITABEI_item, 2, "block_itabei_ichoh");
		registerRenderMeta(SKIDO_item, 0, "block_kido_sakura");
		registerRenderMeta(SKIDO_item, 1, "block_kido_kaede");
		registerRenderMeta(SKIDO_item, 2, "block_kido_ichoh");
		
		registerRenderMeta(CHABUDAI, 0, "block_chabudai");
		registerRenderMeta(CHABUDAI, 1, "block_chabudai_spruce");
		registerRenderMeta(CHABUDAI, 2, "block_chabudai_birch");
		registerRenderMeta(CHABUDAI, 3, "block_chabudai_jungle");
		registerRenderMeta(CHABUDAI, 4, "block_chabudai_acacia");
		registerRenderMeta(CHABUDAI, 5, "block_chabudai_darkoak");
		registerRenderMeta(CHABUDAI, 6, "block_chabudai_sakura");
		registerRenderMeta(CHABUDAI, 7, "block_chabudai_kaede");
		registerRenderMeta(CHABUDAI, 8, "block_chabudai_ichoh");

		registerRenderMeta(KOTATSU, 0, "block_kotatsu");
		registerRenderMeta(KOTATSU, 1, "block_kotatsu_spruce");
		registerRenderMeta(KOTATSU, 2, "block_kotatsu_birch");
		registerRenderMeta(KOTATSU, 3, "block_kotatsu_jungle");
		registerRenderMeta(KOTATSU, 4, "block_kotatsu_acacia");
		registerRenderMeta(KOTATSU, 5, "block_kotatsu_darkoak");
		registerRenderMeta(KOTATSU, 6, "block_kotatsu_sakura");
		registerRenderMeta(KOTATSU, 7, "block_kotatsu_kaede");
		registerRenderMeta(KOTATSU, 8, "block_kotatsu_ichoh");

		registerRender(KUSATABA);
		registerRender(WARATABA);
		registerRender(KAYATABA);
		registerRender(KUSATABA_RF);
		registerRender(WARATABA_RF);
		registerRender(KAYATABA_RF);
		registerRender(KUSATABA_STAIRS);
		registerRender(WARATABA_STAIRS);
		registerRender(KAYATABA_STAIRS);

		registerRender(SHIMENAWA);
		registerRenderMeta(NEWYEAR_XMAS, 1, "block_kadomatsu");
		registerRenderMeta(NEWYEAR_XMAS, 2, "block_kagamimochi");
		registerRenderMeta(NEWYEAR_XMAS, 3, "block_xmastree");
		registerRenderMeta(NEWYEAR_XMAS, 4, "block_xmastree_w");
		registerRenderMeta(PRESENT, 1, "block_present_app");
		registerRenderMeta(PRESENT, 2, "block_present_bok");
		registerRenderMeta(PRESENT, 3, "block_present_dia");
		registerRenderMeta(PRESENT, 4, "block_present_lap");
		registerRenderMeta(PRESENT_B, 1, "block_present_bla");
		registerRenderMeta(PRESENT_B, 2, "block_present_chc");
		registerRenderMeta(PRESENT_B, 3, "block_present_chh");
		registerRender(SNOWCORE);
		registerRender(SNOWMAN);
		
		registerRender(HINAKAZARI);
		registerRender(HINADAN);

		registerRender(COCOA_F);
		registerRender(COCOA_R);
		registerRender(COCOA_M);
		registerRender(CHOCO_raw);
		registerRender(COCOA_TARU);
		registerRenderMeta(FOOD_CHOCO, 1, "item_food_choco");
		registerRenderMeta(FOOD_CHOCO, 2, "item_food_choco_apple");
		registerRenderMeta(FOOD_CHOCO, 3, "item_food_choco_cherry");
		registerRenderMeta(FOOD_CHOCO, 4, "item_food_choco_grape");
		registerRenderMeta(FOOD_CHOCO, 5, "item_food_choco_greentea");
		registerRenderMeta(FOOD_CHOCO, 6, "item_food_choco_heart");

		registerRenderMeta(UCHIWA_item, 0, "block_uchiwa_white");
		registerRenderMeta(UCHIWA_item, 1, "block_uchiwa_orange");
		registerRenderMeta(UCHIWA_item, 2, "block_uchiwa_magenta");
		registerRenderMeta(UCHIWA_item, 3, "block_uchiwa_lightb");
		registerRenderMeta(UCHIWA_item, 4, "block_uchiwa_yellow");
		registerRenderMeta(UCHIWA_item, 5, "block_uchiwa_lime");
		registerRenderMeta(UCHIWA_item, 6, "block_uchiwa_pink");
		registerRenderMeta(UCHIWA_item, 7, "block_uchiwa_gray");
		registerRenderMeta(UCHIWA_item, 8, "block_uchiwa_lightg");
		registerRenderMeta(UCHIWA_item, 9, "block_uchiwa_cyan");
		registerRenderMeta(UCHIWA_item, 10, "block_uchiwa_purple");
		registerRenderMeta(UCHIWA_item, 11, "block_uchiwa_blue");
		registerRenderMeta(UCHIWA_item, 12, "block_uchiwa_brown");
		registerRenderMeta(UCHIWA_item, 13, "block_uchiwa_green");
		registerRenderMeta(UCHIWA_item, 14, "block_uchiwa_red");
		registerRenderMeta(UCHIWA_item, 15, "block_uchiwa_black");

		registerRenderMeta(FOOD_WATAGASHI, 1, "item_food_watagashi");
		registerRenderMeta(FOOD_WATAGASHI, 2, "item_food_watagashi_y");
		registerRenderMeta(FOOD_WATAGASHI, 3, "item_food_watagashi_p");
		registerRenderMeta(FOOD_WATAGASHI, 4, "item_food_watagashi_r");
		registerRenderMeta(FOOD_WATAGASHI, 5, "item_food_watagashi_g");
		registerRender(WATAGASHI_block);
		registerRender(WATAGASHI_pink);
		registerRender(WATAGASHI_red);
		registerRender(WATAGASHI_yellow);
		registerRender(WATAGASHI_green);

		registerRender(KAKIGOURI_hata);
		registerRender(KAKIGOURI_block);
		registerRender(KAKIGOURI_pink);
		registerRender(KAKIGOURI_red);
		registerRender(KAKIGOURI_yellow);
		registerRender(KAKIGOURI_green);

		registerRender(YKTD_GETA);
		registerRender(YKTO_GETA);

		registerRender(IKADUCHIYKT_HELMET);
		registerRender(IKADUCHIYKT_CHESTPLATE);
		registerRender(IKADUCHIYKT_LEGGINGS);
		registerRender(INADUMAYKT_HELMET);
		registerRender(INADUMAYKT_CHESTPLATE);
		registerRender(INADUMAYKT_LEGGINGS);

		registerRender(HAMAKAZEYKT_HELMET);
		registerRender(HAMAKAZEYKT_CHESTPLATE);
		registerRender(HAMAKAZEYKT_LEGGINGS);
		registerRender(URAKAZEYKT_HELMET);
		registerRender(URAKAZEYKT_CHESTPLATE);
		registerRender(URAKAZEYKT_LEGGINGS);
		registerRender(KAWAKAZEYKT_HELMET);
		registerRender(KAWAKAZEYKT_CHESTPLATE);
		registerRender(KAWAKAZEYKT_LEGGINGS);
		registerRender(OBOROYKT_HELMET);
		registerRender(OBOROYKT_CHESTPLATE);
		registerRender(OBOROYKT_LEGGINGS);
		registerRender(TTOKUYKT_CHESTPLATE);
		registerRender(TTOKUYKT_LEGGINGS);
		registerRender(TTOKUYKTB_CHESTPLATE);
		registerRender(TTOKUYKTB_LEGGINGS);

		registerRender(AKASHISANTA_HELMET);
		registerRender(AKASHISANTA_CHESTPLATE);
		registerRender(AKASHISANTA_LEGGINGS);
		registerRender(AKASHISANTA_BOOTS);
		registerRender(KUMANOSANTA_HELMET);
		registerRender(KUMANOSANTA_CHESTPLATE);
		registerRender(KUMANOSANTA_LEGGINGS);
		registerRender(KUMANOSANTA_BOOTS);
		registerRender(SUZUYASANTA_HELMET);
		registerRender(SUZUYASANTA_CHESTPLATE);
		registerRender(SUZUYASANTA_LEGGINGS);
		registerRender(SUZUYASANTA_BOOTS);
		registerRender(RYUJOUSANTA_HELMET);
		registerRender(RYUJOUSANTA_CHESTPLATE);
		registerRender(RYUJOUSANTA_LEGGINGS);
		registerRender(RYUJOUSANTA_BOOTS);
		registerRender(TEITOKUSANTA_HELMET);
		registerRender(TEITOKUSANTA_CHESTPLATE);
		registerRender(TEITOKUSANTA_LEGGINGS);
		registerRender(TEITOKUSANTA_BOOTS);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}
}
