package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.items.addinfo.AddInfo_Item;
import com.ayutaki.chinjufumod.items.addinfo.SnowCore_Item;
import com.ayutaki.chinjufumod.items.addinfo.SnowMan_Item;
import com.ayutaki.chinjufumod.items.armor.CMArmorMaterial;
import com.ayutaki.chinjufumod.items.armor.Costume_Santa;
import com.ayutaki.chinjufumod.items.armor.Costume_YUKATA;
import com.ayutaki.chinjufumod.items.dish.Dish_always;
import com.ayutaki.chinjufumod.items.foods.FoodAnytime_addItem;
import com.ayutaki.chinjufumod.items.foods.FoodBuilders;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_noFuel;
import com.ayutaki.chinjufumod.items.fuel.Seasonal_noSlab;
import com.ayutaki.chinjufumod.items.teatime.Warahai_Item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Seasonal {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static Item WARAHAI = register("item_warahai", new Warahai_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item ORIITO = register("item_oriito", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item TANMONO = register("item_tanmono", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));

	/** 6.4.1 **/ public static Item ZUNDOU_AKU = register("block_zundou_aku", new Seasonal_noFuel(Dish_Blocks.ZUNDOU_AKU, new Item.Properties().containerItem(Items_Teatime.ZUNDOU)));

	public static Item SUIDEN = register("block_suiden", new Seasonal_noFuel(Wood_Blocks.SUIDEN, new Item.Properties()));
	public static Item FALL_LEAF = register("block_fall_leaf", new Seasonal_noFuel(Wood_Blocks.FALL_LEAF, new Item.Properties()));

	public static Item SAKURA_flow = register("block_tree_sakura_flow", new Seasonal_noFuel(Wood_Blocks.SAKURA_flow, new Item.Properties()));
	public static Item KAEDE_leaf = register("block_tree_kaede_leaf", new Seasonal_noFuel(Wood_Blocks.KAEDE_leaf, new Item.Properties()));
	public static Item ICHOH_leaf = register("block_tree_ichoh_leaf", new Seasonal_noFuel(Wood_Blocks.ICHOH_leaf, new Item.Properties()));
	public static Item OAKKARE_leaf = register("block_tree_oakkare_leaf", new Seasonal_noFuel(Wood_Blocks.OAKKARE_leaf, new Item.Properties()));

	public static Item SAKURA_log = register("block_tree_sakura_log", new Seasonal_noFuel(Wood_Blocks.SAKURA_log, new Item.Properties()));
	public static Item KAEDE_log = register("block_tree_kaede_log", new Seasonal_noFuel(Wood_Blocks.KAEDE_log, new Item.Properties()));
	public static Item ICHOH_log = register("block_tree_ichoh_log", new Seasonal_noFuel(Wood_Blocks.ICHOH_log, new Item.Properties()));

	public static Item SAKURA_nae = register("block_tree_sakura_nae", new Seasonal_noFuel(Wood_Blocks.SAKURA_nae, new Item.Properties()));
	public static Item KAEDE_nae = register("block_tree_kaede_nae", new Seasonal_noFuel(Wood_Blocks.KAEDE_nae, new Item.Properties()));
	public static Item ICHOH_nae = register("block_tree_ichoh_nae", new Seasonal_noFuel(Wood_Blocks.ICHOH_nae, new Item.Properties()));
	public static Item OAKKARE_nae = register("block_tree_oakkare_nae", new Seasonal_noFuel(Wood_Blocks.OAKKARE_nae, new Item.Properties()));
	
	public static Item KURI_IGA = register("block_chestnuts", new Seasonal_noFuel(Wood_Blocks.KURIIGA_FALL, new Item.Properties().containerItem(Items_NoTab.IGA)));
	public static Item KURI = register("item_chestnut", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item KURI_ROAST = register("item_food_chestnut", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.KURI_ROAST)));
	public static Item KURI_BOIL = register("item_chestnut_boil", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).containerItem(Items.BOWL)));
	public static Item KURI_MASH = register("item_chestnut_mash", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).containerItem(Items.BOWL)));
	public static Item KURI_NABE = register("block_food_nabekuri_n", new Seasonal_noFuel(Dish_Blocks.KURI_NABE_nama, new Item.Properties()));
	public static Item KURI_SWEET = register("item_food_chestnutsweet", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.KURI_SWEET)));
	public static Item KURI_CHOCO = register("item_food_chestnutchoco", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.KURI_CHOCO)));
	public static Item TAKENOKO = register("block_takenoko", new Seasonal_noFuel(Wood_Blocks.TAKENOKO, new Item.Properties()));
	public static Item TAKENOKO_ROAST = register("item_food_takenoko", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.TAKENOKO_ROAST)));
	
	public static Item SAKURA_planks = register("block_planks_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_planks, new Item.Properties()));
	public static Item KAEDE_planks = register("block_planks_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_planks, new Item.Properties()));
	public static Item ICHOH_planks = register("block_planks_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_planks, new Item.Properties()));

	public static Item SAKURA_stairs = register("block_stairs_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_stairs, new Item.Properties()));
	public static Item KAEDE_stairs = register("block_stairs_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_stairs, new Item.Properties()));
	public static Item ICHOH_stairs = register("block_stairs_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_stairs, new Item.Properties()));

	public static Item SAKURA_slabhalf = register("block_slabhalf_sakura", new Seasonal_noSlab(Wood_Blocks.SAKURA_slabhalf, new Item.Properties()));
	public static Item KAEDE_slabhalf = register("block_slabhalf_kaede", new Seasonal_noSlab(Wood_Blocks.KAEDE_slabhalf, new Item.Properties()));
	public static Item ICHOH_slabhalf = register("block_slabhalf_ichoh", new Seasonal_noSlab(Wood_Blocks.ICHOH_slabhalf, new Item.Properties()));

	public static Item PILLAR_saku = register("block_pillar_sakura", new Seasonal_noFuel(Wood_Blocks.PILLAR_saku, new Item.Properties()));
	public static Item PILLAR_kae = register("block_pillar_kaede", new Seasonal_noFuel(Wood_Blocks.PILLAR_kae, new Item.Properties()));
	public static Item PILLAR_ich = register("block_pillar_ichoh", new Seasonal_noFuel(Wood_Blocks.PILLAR_ich, new Item.Properties()));
	public static Item PILLARSLAB_saku = register("block_kamoi_sakura", new Seasonal_Fuel150(Wood_Blocks.PILLARSLAB_saku, new Item.Properties()));
	public static Item PILLARSLAB_kae = register("block_kamoi_kaede", new Seasonal_Fuel150(Wood_Blocks.PILLARSLAB_kae, new Item.Properties()));
	public static Item PILLARSLAB_ich = register("block_kamoi_ichoh", new Seasonal_Fuel150(Wood_Blocks.PILLARSLAB_ich, new Item.Properties()));

	public static Item SAKURA_FENCE = register("block_fence_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_FENCE, new Item.Properties()));
	public static Item KAEDE_FENCE = register("block_fence_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_FENCE, new Item.Properties()));
	public static Item ICHOH_FENCE = register("block_fence_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_FENCE, new Item.Properties()));
	public static Item SAKURA_FGATE = register("block_fencegate_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_FGATE, new Item.Properties()));
	public static Item KAEDE_FGATE = register("block_fencegate_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_FGATE, new Item.Properties()));
	public static Item ICHOH_FGATE = register("block_fencegate_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_FGATE, new Item.Properties()));

	public static Item DOOR_SAKURA = register("block_door_sakura", new Seasonal_noFuel(Gate_Blocks.DOOR_SAKURA, new Item.Properties()));
	public static Item DOOR_KAEDE = register("block_door_kaede", new Seasonal_noFuel(Gate_Blocks.DOOR_KAEDE, new Item.Properties()));
	public static Item DOOR_ICHOH = register("block_door_ichoh", new Seasonal_noFuel(Gate_Blocks.DOOR_ICHOH, new Item.Properties()));

	public static Item SAKURA_TRAPDOOR = register("block_trapdoor_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_TRAPDOOR, new Item.Properties()));
	public static Item KAEDE_TRAPDOOR = register("block_trapdoor_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_TRAPDOOR, new Item.Properties()));
	public static Item ICHOH_TRAPDOOR = register("block_trapdoor_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_TRAPDOOR, new Item.Properties()));
	public static Item SAKURA_PLATE = register("block_plate_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_PLATE, new Item.Properties()));
	public static Item KAEDE_PLATE = register("block_plate_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_PLATE, new Item.Properties()));
	public static Item ICHOH_PLATE = register("block_plate_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_PLATE, new Item.Properties()));
	public static Item SAKURA_BUTTON = register("block_button_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_BUTTON, new Item.Properties()));
	public static Item KAEDE_BUTTON = register("block_button_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_BUTTON, new Item.Properties()));
	public static Item ICHOH_BUTTON = register("block_button_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_BUTTON, new Item.Properties()));

	public static Item SAKURA_carpet = register("block_carpet_sakura", new Seasonal_noFuel(Wood_Blocks.SAKURA_carpet, new Item.Properties()));
	public static Item KAEDE_carpet = register("block_carpet_kaede", new Seasonal_noFuel(Wood_Blocks.KAEDE_carpet, new Item.Properties()));
	public static Item ICHOH_carpet = register("block_carpet_ichoh", new Seasonal_noFuel(Wood_Blocks.ICHOH_carpet, new Item.Properties()));
	public static Item OCHIBA_carpet = register("block_carpet_ochiba", new Seasonal_noFuel(Wood_Blocks.OCHIBA_carpet, new Item.Properties()));

	public static Item WP_LOG_sakura = register("block_wp_log_sakura", new Seasonal_noFuel(Wood_Blocks.WP_LOG_sakura, new Item.Properties()));
	public static Item WP_LOG_kaede = register("block_wp_log_kaede", new Seasonal_noFuel(Wood_Blocks.WP_LOG_kaede, new Item.Properties()));
	public static Item WP_LOG_ichoh = register("block_wp_log_ichoh", new Seasonal_noFuel(Wood_Blocks.WP_LOG_ichoh, new Item.Properties()));

	public static Item WP_PLANK_sakura = register("block_wp_plank_sakura", new Seasonal_noFuel(Wood_Blocks.WP_PLANK_sakura, new Item.Properties()));
	public static Item WP_PLANK_kaede = register("block_wp_plank_kaede", new Seasonal_noFuel(Wood_Blocks.WP_PLANK_kaede, new Item.Properties()));
	public static Item WP_PLANK_ichoh = register("block_wp_plank_ichoh", new Seasonal_noFuel(Wood_Blocks.WP_PLANK_ichoh, new Item.Properties()));

	public static Item GARASUDO_SAKU = register("block_garasudo_sakura", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDO_SAKU, new Item.Properties()));
	public static Item GARASUDO_KAE = register("block_garasudo_kaede", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDO_KAE, new Item.Properties()));
	public static Item GARASUDO_ICH = register("block_garasudo_ichoh", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDO_ICH, new Item.Properties()));
	public static Item GARASUDOB_SAKU = register("block_garasudob_sakura", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOB_SAKU, new Item.Properties()));
	public static Item GARASUDOB_KAE = register("block_garasudob_kaede", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOB_KAE, new Item.Properties()));
	public static Item GARASUDOB_ICH = register("block_garasudob_ichoh", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOB_ICH, new Item.Properties()));
	public static Item GARASUDOH_SAKU = register("block_garasudohalf_sakura", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOH_SAKU, new Item.Properties()));
	public static Item GARASUDOH_KAE = register("block_garasudohalf_kaede", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOH_KAE, new Item.Properties()));
	public static Item GARASUDOH_ICH = register("block_garasudohalf_ichoh", new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOH_ICH, new Item.Properties()));

	public static Item SHOUJI_SAKU = register("block_shouji_sakura", new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJI_SAKU, new Item.Properties()));
	public static Item SHOUJI_KAE = register("block_shouji_kaede", new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJI_KAE, new Item.Properties()));
	public static Item SHOUJI_ICH = register("block_shouji_ichoh", new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJI_ICH, new Item.Properties()));
	public static Item SHOUJIB_SAKU = register("block_shoujib_sakura", new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJIB_SAKU, new Item.Properties()));
	public static Item SHOUJIB_KAE = register("block_shoujib_kaede", new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJIB_KAE, new Item.Properties()));
	public static Item SHOUJIB_ICH = register("block_shoujib_ichoh", new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJIB_ICH, new Item.Properties()));

	public static Item SHOUJIH_SAKU = register("block_shoujihalf_sakura", new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJIH_SAKU, new Item.Properties()));
	public static Item SHOUJIH_KAE = register("block_shoujihalf_kaede", new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJIH_KAE, new Item.Properties()));
	public static Item SHOUJIH_ICH = register("block_shoujihalf_ichoh", new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJIH_ICH, new Item.Properties()));
	public static Item SHOUJI_WIN_SAKU = register("block_shoujih_sakura", new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_SAKU, new Item.Properties()));
	public static Item SHOUJI_WIN_KAE = register("block_shoujih_kaede", new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_KAE, new Item.Properties()));
	public static Item SHOUJI_WIN_ICH = register("block_shoujih_ichoh", new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_ICH, new Item.Properties()));

	public static Item RANMA_sakura = register("block_ranma_saku", new Seasonal_Fuel150(Ranma_Blocks.RANMA_sakura, new Item.Properties()));
	public static Item RANMA_kaede = register("block_ranma_kae", new Seasonal_Fuel150(Ranma_Blocks.RANMA_kaede, new Item.Properties()));
	public static Item RANMA_ichoh = register("block_ranma_ich", new Seasonal_Fuel150(Ranma_Blocks.RANMA_ichoh, new Item.Properties()));
	public static Item RANMAB_sakura = register("block_ranmab_saku", new Seasonal_Fuel150(Ranma_Blocks.RANMAB_sakura, new Item.Properties()));
	public static Item RANMAB_kaede = register("block_ranmab_kae", new Seasonal_Fuel150(Ranma_Blocks.RANMAB_kaede, new Item.Properties()));
	public static Item RANMAB_ichoh = register("block_ranmab_ich", new Seasonal_Fuel150(Ranma_Blocks.RANMAB_ichoh, new Item.Properties()));
	public static Item RANMAC_sakura = register("block_ranmac_saku", new Seasonal_noFuel(Ranma_Blocks.RANMAC_sakura, new Item.Properties()));
	public static Item RANMAC_kaede = register("block_ranmac_kae", new Seasonal_noFuel(Ranma_Blocks.RANMAC_kaede, new Item.Properties()));
	public static Item RANMAC_ichoh = register("block_ranmac_ich", new Seasonal_noFuel(Ranma_Blocks.RANMAC_ichoh, new Item.Properties()));

	public static Item KANKI_sakura = register("block_kanki_saku", new Seasonal_Fuel150(Ranma_Blocks.KANKI_sakura, new Item.Properties()));
	public static Item KANKI_kaede = register("block_kanki_kae", new Seasonal_Fuel150(Ranma_Blocks.KANKI_kaede, new Item.Properties()));
	public static Item KANKI_ichoh = register("block_kanki_ich", new Seasonal_Fuel150(Ranma_Blocks.KANKI_ichoh, new Item.Properties()));

	public static Item KOUSHI_sakura = register("block_koushi_saku", new Seasonal_Fuel150(Ranma_Blocks.KOUSHI_sakura, new Item.Properties()));
	public static Item KOUSHI_kaede = register("block_koushi_kae", new Seasonal_Fuel150(Ranma_Blocks.KOUSHI_kaede, new Item.Properties()));
	public static Item KOUSHI_ichoh = register("block_koushi_ich", new Seasonal_Fuel150(Ranma_Blocks.KOUSHI_ichoh, new Item.Properties()));
	public static Item KOUSHIB_sakura = register("block_koushib_saku", new Seasonal_Fuel150(Ranma_Blocks.KOUSHIB_sakura, new Item.Properties()));
	public static Item KOUSHIB_kaede = register("block_koushib_kae", new Seasonal_Fuel150(Ranma_Blocks.KOUSHIB_kaede, new Item.Properties()));
	public static Item KOUSHIB_ichoh = register("block_koushib_ich", new Seasonal_Fuel150(Ranma_Blocks.KOUSHIB_ichoh, new Item.Properties()));

	public static Item BONSAI_sakura = register("block_bonsai_sakura", new Seasonal_noFuel(Garden_Blocks.BONSAI_sakura, new Item.Properties()));
	public static Item BONSAI_kaede = register("block_bonsai_kaede", new Seasonal_noFuel(Garden_Blocks.BONSAI_kaede, new Item.Properties()));
	public static Item BONSAI_ichoh = register("block_bonsai_ichoh", new Seasonal_noFuel(Garden_Blocks.BONSAI_ichoh, new Item.Properties()));
	public static Item BONSAI_kare = register("block_bonsai_oakkare", new Seasonal_noFuel(Garden_Blocks.BONSAI_kare, new Item.Properties()));

	public static Item KANYOU_sakura = register("block_kanyousakura_bot", new Seasonal_noFuel(Garden_Blocks.KANYOU_sakura, new Item.Properties()));
	public static Item KANYOU_kaede = register("block_kanyoukaede_bot", new Seasonal_noFuel(Garden_Blocks.KANYOU_kaede, new Item.Properties()));
	public static Item KANYOU_ichoh = register("block_kanyouichoh_bot", new Seasonal_noFuel(Garden_Blocks.KANYOU_ichoh, new Item.Properties()));
	public static Item KANYOU_kare = register("block_kanyouoakkare_bot", new Seasonal_noFuel(Garden_Blocks.KANYOU_kare, new Item.Properties()));

	public static Item IKEGAKI_sakura = register("block_low_sakura", new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_sakura, new Item.Properties()));
	public static Item IKEGAKI_kaede = register("block_low_kaede", new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_kaede, new Item.Properties()));
	public static Item IKEGAKI_ichoh = register("block_low_ichoh", new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_ichoh, new Item.Properties()));
	public static Item IKEGAKI_kare = register("block_low_oakkare", new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_kare, new Item.Properties()));

	public static Item IKEGAKILONG_sakura = register("block_longsakura_bot", new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_sakura, new Item.Properties()));
	public static Item IKEGAKILONG_kaede = register("block_longkaede_bot", new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_kaede, new Item.Properties()));
	public static Item IKEGAKILONG_ichoh = register("block_longichoh_bot", new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_ichoh, new Item.Properties()));
	public static Item IKEGAKILONG_kare = register("block_longoakkare_bot", new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_kare, new Item.Properties()));

	public static Item ITABEI_sakura = register("block_itabei_sakura", new Seasonal_Fuel200(Garden_Blocks.ITABEI_sakura, new Item.Properties()));
	public static Item ITABEI_kaede = register("block_itabei_kaede", new Seasonal_Fuel200(Garden_Blocks.ITABEI_kaede, new Item.Properties()));
	public static Item ITABEI_ichoh = register("block_itabei_ichoh", new Seasonal_Fuel200(Garden_Blocks.ITABEI_ichoh, new Item.Properties()));
	
	public static Item KIDO_sakura = register("block_kido_sakura", new Seasonal_Fuel200(Garden_Blocks.KIDO_sakura, new Item.Properties()));
	public static Item KIDO_kaede = register("block_kido_kaede", new Seasonal_Fuel200(Garden_Blocks.KIDO_kaede, new Item.Properties()));
	public static Item KIDO_ichoh = register("block_kido_ichoh", new Seasonal_Fuel200(Garden_Blocks.KIDO_ichoh, new Item.Properties()));

	public static Item CHABUDAI = register("block_chabudai", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI, new Item.Properties()));
	public static Item CHABUDAI_spruce = register("block_chabudai_spruce", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_spruce, new Item.Properties()));
	public static Item CHABUDAI_birch = register("block_chabudai_birch", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_birch, new Item.Properties()));
	public static Item CHABUDAI_jungle = register("block_chabudai_jungle", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_jungle, new Item.Properties()));
	public static Item CHABUDAI_acacia = register("block_chabudai_acacia", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_acacia, new Item.Properties()));
	public static Item CHABUDAI_darkoak = register("block_chabudai_darkoak", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_darkoak, new Item.Properties()));
	public static Item CHABUDAI_sakura = register("block_chabudai_sakura", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_sakura, new Item.Properties()));
	public static Item CHABUDAI_kaede = register("block_chabudai_kaede", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_kaede, new Item.Properties()));
	public static Item CHABUDAI_ichoh = register("block_chabudai_ichoh", new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_ichoh, new Item.Properties()));

	public static Item KOTATSU = register("block_kotatsu", new Seasonal_Fuel200(Unit_Blocks.KOTATSU, new Item.Properties()));
	public static Item KOTATSU_spruce = register("block_kotatsu_spruce", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_spruce, new Item.Properties()));
	public static Item KOTATSU_birch = register("block_kotatsu_birch", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_birch, new Item.Properties()));
	public static Item KOTATSU_jungle = register("block_kotatsu_jungle", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_jungle, new Item.Properties()));
	public static Item KOTATSU_acacia = register("block_kotatsu_acacia", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_acacia, new Item.Properties()));
	public static Item KOTATSU_darkoak = register("block_kotatsu_darkoak", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_darkoak, new Item.Properties()));
	public static Item KOTATSU_sakura = register("block_kotatsu_sakura", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_sakura, new Item.Properties()));
	public static Item KOTATSU_kaede = register("block_kotatsu_kaede", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_kaede, new Item.Properties()));
	public static Item KOTATSU_ichoh = register("block_kotatsu_ichoh", new Seasonal_Fuel200(Unit_Blocks.KOTATSU_ichoh, new Item.Properties()));

	public static Item KUSATABA = register("block_tabakusa", new Seasonal_Fuel200(Seasonal_Blocks.KUSATABA, new Item.Properties()));
	public static Item WARATABA = register("block_tabawara", new Seasonal_Fuel200(Seasonal_Blocks.WARATABA, new Item.Properties()));
	public static Item KAYATABA = register("block_tabakaya", new Seasonal_Fuel200(Seasonal_Blocks.KAYATABA, new Item.Properties()));

	public static Item KUSATABA_RF = register("block_tabakusa_roof", new Seasonal_Fuel100(Seasonal_Blocks.KUSATABA_RF, new Item.Properties()));
	public static Item WARATABA_RF = register("block_tabawara_roof", new Seasonal_Fuel100(Seasonal_Blocks.WARATABA_RF, new Item.Properties()));
	public static Item KAYATABA_RF = register("block_tabakaya_roof", new Seasonal_Fuel100(Seasonal_Blocks.KAYATABA_RF, new Item.Properties()));

	public static Item KUSATABA_STAIRS = register("block_tabakusa_stairs", new Seasonal_Fuel200(Seasonal_Blocks.KUSATABA_STAIRS, new Item.Properties()));
	public static Item WARATABA_STAIRS = register("block_tabawara_stairs", new Seasonal_Fuel200(Seasonal_Blocks.WARATABA_STAIRS, new Item.Properties()));
	public static Item KAYATABA_STAIRS = register("block_tabakaya_stairs", new Seasonal_Fuel200(Seasonal_Blocks.KAYATABA_STAIRS, new Item.Properties()));

	public static Item KADOMATSU = register("block_kadomatsu", new Seasonal_noFuel(Seasonal_Blocks.KADOMATSU, new Item.Properties()));
	public static Item SHIMENAWA = register("block_shimenawa", new Seasonal_Fuel100(Seasonal_Blocks.SHIMENAWA, new Item.Properties()));
	public static Item KAGAMIMOCHI = register("block_kagamimochi", new Seasonal_Fuel200(Seasonal_Blocks.KAGAMIMOCHI, new Item.Properties()));

	public static Item HINAKAZARI = register("block_hinakazari", new Seasonal_noFuel(Seasonal_Blocks.HINAKAZARI, new Item.Properties()));
	public static Item HINADAN = register("block_hinadan", new Seasonal_noFuel(Seasonal_Blocks.HINADAN, new Item.Properties()));

	public static Item XMASTREE = register("block_xmastree", new Seasonal_Fuel100(Seasonal_Blocks.XMASTREE, new Item.Properties()));
	public static Item XMASTREE_W = register("block_xmastree_w", new Seasonal_Fuel100(Seasonal_Blocks.XMASTREE_W, new Item.Properties()));

	public static Item PRESENT_app = register("block_present_app", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_app, new Item.Properties()));
	public static Item PRESENT_bok = register("block_present_bok", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_bok, new Item.Properties()));
	public static Item PRESENT_dia = register("block_present_dia", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_dia, new Item.Properties()));
	public static Item PRESENT_lap = register("block_present_lap", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_lap, new Item.Properties()));
	public static Item PRESENT_bla = register("block_present_bla", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_bla, new Item.Properties()));
	public static Item PRESENT_chc = register("block_present_chc", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_chc, new Item.Properties()));
	public static Item PRESENT_chh = register("block_present_chh", new Seasonal_noFuel(Seasonal_Blocks.PRESENT_chh, new Item.Properties()));

	public static Item COCOA_F = register("item_cocoa_ferm", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item COCOA_R = register("item_cocoa_roast", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item COCOA_M = register("item_cocoa_mass", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item CHOCO_raw = register("item_choco_raw", new AddInfo_Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).containerItem(Items.BOWL)));
	public static Item COCOA_TARU = register("block_taru_cocoa_f", new Seasonal_noFuel(Hakkou_Blocks.COCOA_TARU, new Item.Properties()));

	public static Item SNOWCORE = register("block_snowcore", new SnowCore_Item(Seasonal_Blocks.SNOWCORE, new Item.Properties()));
	public static Item SNOWMAN = register("block_snowman", new SnowMan_Item(Seasonal_Blocks.SNOWMAN, new Item.Properties()));
	
	public static Item FOOD_CHOCO = register("item_food_choco", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO)));
	public static Item FOOD_CHOCO_A = register("item_food_choco_apple", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_A)));
	public static Item FOOD_CHOCO_C = register("item_food_choco_cherry", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_C)));
	public static Item FOOD_CHOCO_G = register("item_food_choco_grape", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_G)));
	public static Item FOOD_CHOCO_T = register("item_food_choco_greentea", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_T)));
	public static Item FOOD_CHOCO_H = register("item_food_choco_heart", new Item(new Item.Properties().group(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_H)));

	public static Item UCHIWA_white = register("block_uchiwa_white", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_white, new Item.Properties()));
	public static Item UCHIWA_orange = register("block_uchiwa_orange", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_orange, new Item.Properties()));
	public static Item UCHIWA_magenta = register("block_uchiwa_magenta", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_magenta, new Item.Properties()));
	public static Item UCHIWA_lightb = register("block_uchiwa_lightb", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_lightb, new Item.Properties()));
	public static Item UCHIWA_yellow = register("block_uchiwa_yellow", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_yellow, new Item.Properties()));
	public static Item UCHIWA_lime = register("block_uchiwa_lime", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_lime, new Item.Properties()));
	public static Item UCHIWA_pink = register("block_uchiwa_pink", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_pink, new Item.Properties()));
	public static Item UCHIWA_gray = register("block_uchiwa_gray", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_gray, new Item.Properties()));
	public static Item UCHIWA_lightg = register("block_uchiwa_lightg", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_lightg, new Item.Properties()));
	public static Item UCHIWA_cyan = register("block_uchiwa_cyan", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_cyan, new Item.Properties()));
	public static Item UCHIWA_purple = register("block_uchiwa_purple", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_purple, new Item.Properties()));
	public static Item UCHIWA_blue = register("block_uchiwa_blue", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_blue, new Item.Properties()));
	public static Item UCHIWA_brown = register("block_uchiwa_brown", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_brown, new Item.Properties()));
	public static Item UCHIWA_green = register("block_uchiwa_green", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_green, new Item.Properties()));
	public static Item UCHIWA_red = register("block_uchiwa_red", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_red, new Item.Properties()));
	public static Item UCHIWA_black = register("block_uchiwa_black", new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_black, new Item.Properties()));

	public static Item FOOD_WATAGASHI = register("item_food_watagashi", new FoodAnytime_addItem(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item FOOD_WATAGASHI_A = register("item_food_watagashi_y", new FoodAnytime_addItem(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item FOOD_WATAGASHI_C = register("item_food_watagashi_p", new FoodAnytime_addItem(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item FOOD_WATAGASHI_G = register("item_food_watagashi_r", new FoodAnytime_addItem(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item FOOD_WATAGASHI_T = register("item_food_watagashi_g", new FoodAnytime_addItem(new Item.Properties().group(ItemGroups_CM.SEASONAL)));
	public static Item WATAGASHI_block = register("block_watagashi", new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_block, new Item.Properties()));
	public static Item WATAGASHI_pink = register("block_watagashi_pink", new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_pink, new Item.Properties()));
	public static Item WATAGASHI_red = register("block_watagashi_red", new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_red, new Item.Properties()));
	public static Item WATAGASHI_yellow = register("block_watagashi_yellow", new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_yellow, new Item.Properties()));
	public static Item WATAGASHI_green = register("block_watagashi_green", new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_green, new Item.Properties()));

	public static Item KAKIGOURI_hata = register("block_kakigouri_hata", new Seasonal_noFuel(Seasonal_Blocks.KAKIGOURI_hata, new Item.Properties()));
	public static Item KAKIGOURI_block = register("block_kakigouri_block1", new Dish_always(Seasonal_Blocks.KAKIGOURI_block, (new Item.Properties()).group(ItemGroups_CM.SEASONAL)));
	public static Item KAKIGOURI_pink = register("block_kakigouri_pink1", new Dish_always(Seasonal_Blocks.KAKIGOURI_pink, (new Item.Properties()).group(ItemGroups_CM.SEASONAL)));
	public static Item KAKIGOURI_red = register("block_kakigouri_red1", new Dish_always(Seasonal_Blocks.KAKIGOURI_red, (new Item.Properties()).group(ItemGroups_CM.SEASONAL)));
	public static Item KAKIGOURI_yellow = register("block_kakigouri_yellow1", new Dish_always(Seasonal_Blocks.KAKIGOURI_yellow, (new Item.Properties()).group(ItemGroups_CM.SEASONAL)));
	public static Item KAKIGOURI_green = register("block_kakigouri_green1", new Dish_always(Seasonal_Blocks.KAKIGOURI_green, (new Item.Properties()).group(ItemGroups_CM.SEASONAL)));

	/* YUKATA*/
	public static Item YKTD_GETA = register("item_ykt_getadoak", new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlotType.FEET, new Item.Properties()));
	public static Item YKTO_GETA = register("item_ykt_getaoak", new Costume_YUKATA(CMArmorMaterial.TTOKUYKT, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item IKADUCHIYKT_HELMET = register("item_ykt_ikaduchi_kazari", new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item IKADUCHIYKT_CHESTPLATE = register("item_ykt_ikaduchi_mini", new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item IKADUCHIYKT_LEGGINGS = register("item_ykt_ikaduchi_long", new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlotType.LEGS, new Item.Properties()));

	public static Item INADUMAYKT_HELMET = register("item_ykt_inaduma_kazari", new Costume_YUKATA(CMArmorMaterial.INADUMAYKT, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item INADUMAYKT_CHESTPLATE = register("item_ykt_inaduma_mini", new Costume_YUKATA(CMArmorMaterial.INADUMAYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item INADUMAYKT_LEGGINGS = register("item_ykt_inaduma_long", new Costume_YUKATA(CMArmorMaterial.INADUMAYKT, EquipmentSlotType.LEGS, new Item.Properties()));

	public static Item HAMAKAZEYKT_HELMET = register("item_ykt_hamakaze_kazari", new Costume_YUKATA(CMArmorMaterial.HAMAKAZEYKT, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item HAMAKAZEYKT_CHESTPLATE = register("item_ykt_hamakaze_mini", new Costume_YUKATA(CMArmorMaterial.HAMAKAZEYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item HAMAKAZEYKT_LEGGINGS = register("item_ykt_hamakaze_long", new Costume_YUKATA(CMArmorMaterial.HAMAKAZEYKT, EquipmentSlotType.LEGS, new Item.Properties()));

	public static Item URAKAZEYKT_HELMET = register("item_ykt_urakaze_kazari", new Costume_YUKATA(CMArmorMaterial.URAKAZEYKT, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item URAKAZEYKT_CHESTPLATE = register("item_ykt_urakaze_mini", new Costume_YUKATA(CMArmorMaterial.URAKAZEYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item URAKAZEYKT_LEGGINGS = register("item_ykt_urakaze_long", new Costume_YUKATA(CMArmorMaterial.URAKAZEYKT, EquipmentSlotType.LEGS, new Item.Properties()));

	public static Item KAWAKAZEYKT_HELMET = register("item_ykt_kawakaze_kazari", new Costume_YUKATA(CMArmorMaterial.KAWAKAZEYKT, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item KAWAKAZEYKT_CHESTPLATE = register("item_ykt_kawakaze_mini", new Costume_YUKATA(CMArmorMaterial.KAWAKAZEYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item KAWAKAZEYKT_LEGGINGS = register("item_ykt_kawakaze_long", new Costume_YUKATA(CMArmorMaterial.KAWAKAZEYKT, EquipmentSlotType.LEGS, new Item.Properties()));

	public static Item OBOROYKT_HELMET = register("item_ykt_oboro_kazari", new Costume_YUKATA(CMArmorMaterial.OBOROYKT, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item OBOROYKT_CHESTPLATE = register("item_ykt_oboro_mini", new Costume_YUKATA(CMArmorMaterial.OBOROYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item OBOROYKT_LEGGINGS = register("item_ykt_oboro_long", new Costume_YUKATA(CMArmorMaterial.OBOROYKT, EquipmentSlotType.LEGS, new Item.Properties()));

	public static Item TTOKUYKT_CHESTPLATE = register("item_ykt_ttoku_mini", new Costume_YUKATA(CMArmorMaterial.TTOKUYKT, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item TTOKUYKT_LEGGINGS = register("item_ykt_ttoku_long", new Costume_YUKATA(CMArmorMaterial.TTOKUYKT, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item TTOKUYKTB_CHESTPLATE = register("item_ykt_ttokub_mini", new Costume_YUKATA(CMArmorMaterial.TTOKUYKTB, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item TTOKUYKTB_LEGGINGS = register("item_ykt_ttokub_long", new Costume_YUKATA(CMArmorMaterial.TTOKUYKTB, EquipmentSlotType.LEGS, new Item.Properties()));

	/* SantaCos*/
	public static Item AKASHISANTA_HELMET = register("item_santaakashi_helmet", new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item AKASHISANTA_CHESTPLATE = register("item_santaakashi_chestplate", new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item AKASHISANTA_LEGGINGS = register("item_santaakashi_leggings", new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item AKASHISANTA_BOOTS = register("item_santaakashi_boots", new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item SUZUYASANTA_HELMET = register("item_santasuzuya_helmet", new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item SUZUYASANTA_CHESTPLATE = register("item_santasuzuya_chestplate", new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item SUZUYASANTA_LEGGINGS = register("item_santasuzuya_leggings", new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item SUZUYASANTA_BOOTS = register("item_santasuzuya_boots", new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item KUMANOSANTA_HELMET = register("item_santakumano_helmet", new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item KUMANOSANTA_CHESTPLATE = register("item_santakumano_chestplate", new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item KUMANOSANTA_LEGGINGS = register("item_santakumano_leggings", new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item KUMANOSANTA_BOOTS = register("item_santakumano_boots", new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item RYUJOUSANTA_HELMET = register("item_santaryujou_helmet", new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item RYUJOUSANTA_CHESTPLATE = register("item_santaryujou_chestplate", new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item RYUJOUSANTA_LEGGINGS = register("item_santaryujou_leggings", new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item RYUJOUSANTA_BOOTS = register("item_santaryujou_boots", new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlotType.FEET, new Item.Properties()));

	public static Item TEITOKUSANTA_HELMET = register("item_santattk_helmet", new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlotType.HEAD, new Item.Properties()));
	public static Item TEITOKUSANTA_CHESTPLATE = register("item_santattk_chestplate", new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlotType.CHEST, new Item.Properties()));
	public static Item TEITOKUSANTA_LEGGINGS = register("item_santattk_leggings", new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlotType.LEGS, new Item.Properties()));
	public static Item TEITOKUSANTA_BOOTS = register("item_santattk_boots", new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlotType.FEET, new Item.Properties()));

	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
