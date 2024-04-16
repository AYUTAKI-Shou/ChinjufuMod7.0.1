package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

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

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items_Seasonal {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Item> WARAHAI = register("item_warahai", () -> new Warahai_Item(new Item.Properties()));
	public static final RegistryObject<Item> ORIITO = register("item_oriito", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> TANMONO = register("item_tanmono", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));

	/** 6.4.1 **/ public static final RegistryObject<Item> ZUNDOU_AKU = register("block_zundou_aku", () -> new Seasonal_noFuel(Dish_Blocks.ZUNDOU_AKU.get(), new Item.Properties().craftRemainder(Items_Teatime.ZUNDOU.get())));

	public static final RegistryObject<Item> SUIDEN = register("block_suiden", () -> new Seasonal_noFuel(Wood_Blocks.SUIDEN.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALL_LEAF = register("block_fall_leaf", () -> new Seasonal_noFuel(Wood_Blocks.FALL_LEAF.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_flow = register("block_tree_sakura_flow", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_flow.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_leaf = register("block_tree_kaede_leaf", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_leaf.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_leaf = register("block_tree_ichoh_leaf", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_leaf.get(), new Item.Properties()));
	public static final RegistryObject<Item> OAKKARE_leaf = register("block_tree_oakkare_leaf", () -> new Seasonal_noFuel(Wood_Blocks.OAKKARE_leaf.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_log = register("block_tree_sakura_log", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_log.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_log = register("block_tree_kaede_log", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_log.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_log = register("block_tree_ichoh_log", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_log.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_nae = register("block_tree_sakura_nae", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_nae.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_nae = register("block_tree_kaede_nae", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_nae.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_nae = register("block_tree_ichoh_nae", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_nae.get(), new Item.Properties()));
	public static final RegistryObject<Item> OAKKARE_nae = register("block_tree_oakkare_nae", () -> new Seasonal_noFuel(Wood_Blocks.OAKKARE_nae.get(), new Item.Properties()));

	public static final RegistryObject<Item> KURI_IGA = register("block_chestnuts", () -> new Seasonal_noFuel(Wood_Blocks.KURIIGA_FALL.get(), new Item.Properties().craftRemainder(Items_NoTab.IGA.get())));
	public static final RegistryObject<Item> KURI = register("item_chestnut", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> KURI_ROAST = register("item_food_chestnut", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.KURI_ROAST)));
	public static final RegistryObject<Item> KURI_BOIL = register("item_chestnut_boil", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> KURI_MASH = register("item_chestnut_mash", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> KURI_NABE = register("block_food_nabekuri_n", () -> new Seasonal_noFuel(Dish_Blocks.KURI_NABE_nama.get(), new Item.Properties()));
	public static final RegistryObject<Item> KURI_SWEET = register("item_food_chestnutsweet", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.KURI_SWEET)));
	public static final RegistryObject<Item> KURI_CHOCO = register("item_food_chestnutchoco", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.KURI_CHOCO)));
	public static final RegistryObject<Item> TAKENOKO = register("block_takenoko", () -> new Seasonal_noFuel(Wood_Blocks.TAKENOKO.get(), new Item.Properties()));
	public static final RegistryObject<Item> TAKENOKO_ROAST = register("item_food_takenoko", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.TAKENOKO_ROAST)));
	
	public static final RegistryObject<Item> SAKURA_planks = register("block_planks_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_planks.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_planks = register("block_planks_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_planks.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_planks = register("block_planks_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_planks.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_stairs = register("block_stairs_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_stairs.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_stairs = register("block_stairs_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_stairs.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_stairs = register("block_stairs_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_stairs.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_slabhalf = register("block_slabhalf_sakura", () -> new Seasonal_noSlab(Wood_Blocks.SAKURA_slabhalf.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_slabhalf = register("block_slabhalf_kaede", () -> new Seasonal_noSlab(Wood_Blocks.KAEDE_slabhalf.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_slabhalf = register("block_slabhalf_ichoh", () -> new Seasonal_noSlab(Wood_Blocks.ICHOH_slabhalf.get(), new Item.Properties()));

	public static final RegistryObject<Item> PILLAR_saku = register("block_pillar_sakura", () -> new Seasonal_noFuel(Wood_Blocks.PILLAR_saku.get(), new Item.Properties()));
	public static final RegistryObject<Item> PILLAR_kae = register("block_pillar_kaede", () -> new Seasonal_noFuel(Wood_Blocks.PILLAR_kae.get(), new Item.Properties()));
	public static final RegistryObject<Item> PILLAR_ich = register("block_pillar_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.PILLAR_ich.get(), new Item.Properties()));
	public static final RegistryObject<Item> PILLARSLAB_saku = register("block_kamoi_sakura", () -> new Seasonal_Fuel150(Wood_Blocks.PILLARSLAB_saku.get(), new Item.Properties()));
	public static final RegistryObject<Item> PILLARSLAB_kae = register("block_kamoi_kaede", () -> new Seasonal_Fuel150(Wood_Blocks.PILLARSLAB_kae.get(), new Item.Properties()));
	public static final RegistryObject<Item> PILLARSLAB_ich = register("block_kamoi_ichoh", () -> new Seasonal_Fuel150(Wood_Blocks.PILLARSLAB_ich.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_FENCE = register("block_fence_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_FENCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_FENCE = register("block_fence_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_FENCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_FENCE = register("block_fence_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_FENCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SAKURA_FGATE = register("block_fencegate_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_FGATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_FGATE = register("block_fencegate_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_FGATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_FGATE = register("block_fencegate_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_FGATE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DOOR_SAKURA = register("block_door_sakura", () -> new Seasonal_noFuel(Wood_Blocks.DOOR_SAKURA.get(), new Item.Properties()));
	public static final RegistryObject<Item> DOOR_KAEDE = register("block_door_kaede", () -> new Seasonal_noFuel(Wood_Blocks.DOOR_KAEDE.get(), new Item.Properties()));
	public static final RegistryObject<Item> DOOR_ICHOH = register("block_door_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.DOOR_ICHOH.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_TRAPDOOR = register("block_trapdoor_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_TRAPDOOR = register("block_trapdoor_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_TRAPDOOR = register("block_trapdoor_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SAKURA_PLATE = register("block_plate_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_PLATE = register("block_plate_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_PLATE = register("block_plate_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SAKURA_BUTTON = register("block_button_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_BUTTON = register("block_button_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_BUTTON = register("block_button_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_BUTTON.get(), new Item.Properties()));

	public static final RegistryObject<Item> SAKURA_carpet = register("block_carpet_sakura", () -> new Seasonal_noFuel(Wood_Blocks.SAKURA_carpet.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAEDE_carpet = register("block_carpet_kaede", () -> new Seasonal_noFuel(Wood_Blocks.KAEDE_carpet.get(), new Item.Properties()));
	public static final RegistryObject<Item> ICHOH_carpet = register("block_carpet_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.ICHOH_carpet.get(), new Item.Properties()));
	public static final RegistryObject<Item> OCHIBA_carpet = register("block_carpet_ochiba", () -> new Seasonal_noFuel(Wood_Blocks.OCHIBA_carpet.get(), new Item.Properties()));

	public static final RegistryObject<Item> WP_LOG_sakura = register("block_wp_log_sakura", () -> new Seasonal_noFuel(Wood_Blocks.WP_LOG_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> WP_LOG_kaede = register("block_wp_log_kaede", () -> new Seasonal_noFuel(Wood_Blocks.WP_LOG_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> WP_LOG_ichoh = register("block_wp_log_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.WP_LOG_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> WP_PLANK_sakura = register("block_wp_plank_sakura", () -> new Seasonal_noFuel(Wood_Blocks.WP_PLANK_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> WP_PLANK_kaede = register("block_wp_plank_kaede", () -> new Seasonal_noFuel(Wood_Blocks.WP_PLANK_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> WP_PLANK_ichoh = register("block_wp_plank_ichoh", () -> new Seasonal_noFuel(Wood_Blocks.WP_PLANK_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> GARASUDO_SAKU = register("block_garasudo_sakura", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDO_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_KAE = register("block_garasudo_kaede", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDO_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDO_ICH = register("block_garasudo_ichoh", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDO_ICH.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_SAKU = register("block_garasudob_sakura", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOB_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_KAE = register("block_garasudob_kaede", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOB_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOB_ICH = register("block_garasudob_ichoh", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOB_ICH.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_SAKU = register("block_garasudohalf_sakura", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOH_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_KAE = register("block_garasudohalf_kaede", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOH_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARASUDOH_ICH = register("block_garasudohalf_ichoh", () -> new Seasonal_noFuel(Slidedoor_Blocks.GARASUDOH_ICH.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUJI_SAKU = register("block_shouji_sakura", () -> new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJI_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_KAE = register("block_shouji_kaede", () -> new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJI_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_ICH = register("block_shouji_ichoh", () -> new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJI_ICH.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_SAKU = register("block_shoujib_sakura", () -> new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJIB_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_KAE = register("block_shoujib_kaede", () -> new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJIB_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIB_ICH = register("block_shoujib_ichoh", () -> new Seasonal_Fuel200(Slidedoor_Blocks.SHOUJIB_ICH.get(), new Item.Properties()));

	public static final RegistryObject<Item> SHOUJIH_SAKU = register("block_shoujihalf_sakura", () -> new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJIH_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_KAE = register("block_shoujihalf_kaede", () -> new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJIH_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJIH_ICH = register("block_shoujihalf_ichoh", () -> new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJIH_ICH.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_SAKU = register("block_shoujih_sakura", () -> new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_SAKU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_KAE = register("block_shoujih_kaede", () -> new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_KAE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHOUJI_WIN_ICH = register("block_shoujih_ichoh", () -> new Seasonal_Fuel100(Slidedoor_Blocks.SHOUJI_WIN_ICH.get(), new Item.Properties()));

	public static final RegistryObject<Item> RANMA_sakura = register("block_ranma_saku", () -> new Seasonal_Fuel150(Ranma_Blocks.RANMA_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_kaede = register("block_ranma_kae", () -> new Seasonal_Fuel150(Ranma_Blocks.RANMA_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMA_ichoh = register("block_ranma_ich", () -> new Seasonal_Fuel150(Ranma_Blocks.RANMA_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_sakura = register("block_ranmab_saku", () -> new Seasonal_Fuel150(Ranma_Blocks.RANMAB_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_kaede = register("block_ranmab_kae", () -> new Seasonal_Fuel150(Ranma_Blocks.RANMAB_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAB_ichoh = register("block_ranmab_ich", () -> new Seasonal_Fuel150(Ranma_Blocks.RANMAB_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_sakura = register("block_ranmac_saku", () -> new Seasonal_noFuel(Ranma_Blocks.RANMAC_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_kaede = register("block_ranmac_kae", () -> new Seasonal_noFuel(Ranma_Blocks.RANMAC_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> RANMAC_ichoh = register("block_ranmac_ich", () -> new Seasonal_noFuel(Ranma_Blocks.RANMAC_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> KANKI_sakura = register("block_kanki_saku", () -> new Seasonal_Fuel150(Ranma_Blocks.KANKI_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_kaede = register("block_kanki_kae", () -> new Seasonal_Fuel150(Ranma_Blocks.KANKI_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANKI_ichoh = register("block_kanki_ich", () -> new Seasonal_Fuel150(Ranma_Blocks.KANKI_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> KOUSHI_sakura = register("block_koushi_saku", () -> new Seasonal_Fuel150(Ranma_Blocks.KOUSHI_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_kaede = register("block_koushi_kae", () -> new Seasonal_Fuel150(Ranma_Blocks.KOUSHI_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHI_ichoh = register("block_koushi_ich", () -> new Seasonal_Fuel150(Ranma_Blocks.KOUSHI_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_sakura = register("block_koushib_saku", () -> new Seasonal_Fuel150(Ranma_Blocks.KOUSHIB_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_kaede = register("block_koushib_kae", () -> new Seasonal_Fuel150(Ranma_Blocks.KOUSHIB_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOUSHIB_ichoh = register("block_koushib_ich", () -> new Seasonal_Fuel150(Ranma_Blocks.KOUSHIB_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> BONSAI_sakura = register("block_bonsai_sakura", () -> new Seasonal_noFuel(Garden_Blocks.BONSAI_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_kaede = register("block_bonsai_kaede", () -> new Seasonal_noFuel(Garden_Blocks.BONSAI_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_ichoh = register("block_bonsai_ichoh", () -> new Seasonal_noFuel(Garden_Blocks.BONSAI_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONSAI_kare = register("block_bonsai_oakkare", () -> new Seasonal_noFuel(Garden_Blocks.BONSAI_kare.get(), new Item.Properties()));

	public static final RegistryObject<Item> KANYOU_sakura = register("block_kanyousakura_bot", () -> new Seasonal_noFuel(Garden_Blocks.KANYOU_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_kaede = register("block_kanyoukaede_bot", () -> new Seasonal_noFuel(Garden_Blocks.KANYOU_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_ichoh = register("block_kanyouichoh_bot", () -> new Seasonal_noFuel(Garden_Blocks.KANYOU_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> KANYOU_kare = register("block_kanyouoakkare_bot", () -> new Seasonal_noFuel(Garden_Blocks.KANYOU_kare.get(), new Item.Properties()));

	public static final RegistryObject<Item> IKEGAKI_sakura = register("block_low_sakura", () -> new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_kaede = register("block_low_kaede", () -> new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_ichoh = register("block_low_ichoh", () -> new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKI_kare = register("block_low_oakkare", () -> new Seasonal_Fuel150(Garden_Blocks.IKEGAKI_kare.get(), new Item.Properties()));

	public static final RegistryObject<Item> IKEGAKILONG_sakura = register("block_longsakura_bot", () -> new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_kaede = register("block_longkaede_bot", () -> new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_ichoh = register("block_longichoh_bot", () -> new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_ichoh.get(), new Item.Properties()));
	public static final RegistryObject<Item> IKEGAKILONG_kare = register("block_longoakkare_bot", () -> new Seasonal_Fuel300(Garden_Blocks.IKEGAKILONG_kare.get(), new Item.Properties()));

	public static final RegistryObject<Item> ITABEI_sakura = register("block_itabei_sakura", () -> new Seasonal_Fuel200(Garden_Blocks.ITABEI_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_kaede = register("block_itabei_kaede", () -> new Seasonal_Fuel200(Garden_Blocks.ITABEI_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> ITABEI_ichoh = register("block_itabei_ichoh", () -> new Seasonal_Fuel200(Garden_Blocks.ITABEI_ichoh.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> KIDO_sakura = register("block_kido_sakura", () -> new Seasonal_Fuel200(Garden_Blocks.KIDO_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_kaede = register("block_kido_kaede", () -> new Seasonal_Fuel200(Garden_Blocks.KIDO_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> KIDO_ichoh = register("block_kido_ichoh", () -> new Seasonal_Fuel200(Garden_Blocks.KIDO_ichoh.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> CHABUDAI = register("block_chabudai", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_spruce = register("block_chabudai_spruce", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_birch = register("block_chabudai_birch", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_jungle = register("block_chabudai_jungle", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_acacia = register("block_chabudai_acacia", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_darkoak = register("block_chabudai_darkoak", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_sakura = register("block_chabudai_sakura", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_kaede = register("block_chabudai_kaede", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHABUDAI_ichoh = register("block_chabudai_ichoh", () -> new Seasonal_Fuel150(Unit_Blocks.CHABUDAI_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> KOTATSU = register("block_kotatsu", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_spruce = register("block_kotatsu_spruce", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_spruce.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_birch = register("block_kotatsu_birch", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_birch.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_jungle = register("block_kotatsu_jungle", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_jungle.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_acacia = register("block_kotatsu_acacia", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_acacia.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_darkoak = register("block_kotatsu_darkoak", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_darkoak.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_sakura = register("block_kotatsu_sakura", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_sakura.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_kaede = register("block_kotatsu_kaede", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_kaede.get(), new Item.Properties()));
	public static final RegistryObject<Item> KOTATSU_ichoh = register("block_kotatsu_ichoh", () -> new Seasonal_Fuel200(Unit_Blocks.KOTATSU_ichoh.get(), new Item.Properties()));

	public static final RegistryObject<Item> KUSATABA = register("block_tabakusa", () -> new Seasonal_Fuel200(Seasonal_Blocks.KUSATABA.get(), new Item.Properties()));
	public static final RegistryObject<Item> WARATABA = register("block_tabawara", () -> new Seasonal_Fuel200(Seasonal_Blocks.WARATABA.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAYATABA = register("block_tabakaya", () -> new Seasonal_Fuel200(Seasonal_Blocks.KAYATABA.get(), new Item.Properties()));

	public static final RegistryObject<Item> KUSATABA_RF = register("block_tabakusa_roof", () -> new Seasonal_Fuel100(Seasonal_Blocks.KUSATABA_RF.get(), new Item.Properties()));
	public static final RegistryObject<Item> WARATABA_RF = register("block_tabawara_roof", () -> new Seasonal_Fuel100(Seasonal_Blocks.WARATABA_RF.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAYATABA_RF = register("block_tabakaya_roof", () -> new Seasonal_Fuel100(Seasonal_Blocks.KAYATABA_RF.get(), new Item.Properties()));

	public static final RegistryObject<Item> KUSATABA_STAIRS = register("block_tabakusa_stairs", () -> new Seasonal_Fuel200(Seasonal_Blocks.KUSATABA_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> WARATABA_STAIRS = register("block_tabawara_stairs", () -> new Seasonal_Fuel200(Seasonal_Blocks.WARATABA_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAYATABA_STAIRS = register("block_tabakaya_stairs", () -> new Seasonal_Fuel200(Seasonal_Blocks.KAYATABA_STAIRS.get(), new Item.Properties()));

	public static final RegistryObject<Item> KADOMATSU = register("block_kadomatsu", () -> new Seasonal_noFuel(Seasonal_Blocks.KADOMATSU.get(), new Item.Properties()));
	public static final RegistryObject<Item> SHIMENAWA = register("block_shimenawa", () -> new Seasonal_Fuel100(Seasonal_Blocks.SHIMENAWA.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAGAMIMOCHI = register("block_kagamimochi", () -> new Seasonal_Fuel200(Seasonal_Blocks.KAGAMIMOCHI.get(), new Item.Properties()));

	public static final RegistryObject<Item> HINAKAZARI = register("block_hinakazari", () -> new Seasonal_noFuel(Seasonal_Blocks.HINAKAZARI.get(), new Item.Properties()));
	public static final RegistryObject<Item> HINADAN = register("block_hinadan", () -> new Seasonal_noFuel(Seasonal_Blocks.HINADAN.get(), new Item.Properties()));

	public static final RegistryObject<Item> XMASTREE = register("block_xmastree", () -> new Seasonal_Fuel100(Seasonal_Blocks.XMASTREE.get(), new Item.Properties()));
	public static final RegistryObject<Item> XMASTREE_W = register("block_xmastree_w", () -> new Seasonal_Fuel100(Seasonal_Blocks.XMASTREE_W.get(), new Item.Properties()));

	public static final RegistryObject<Item> PRESENT_app = register("block_present_app", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_app.get(), new Item.Properties()));
	public static final RegistryObject<Item> PRESENT_bok = register("block_present_bok", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_bok.get(), new Item.Properties()));
	public static final RegistryObject<Item> PRESENT_dia = register("block_present_dia", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_dia.get(), new Item.Properties()));
	public static final RegistryObject<Item> PRESENT_lap = register("block_present_lap", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_lap.get(), new Item.Properties()));
	public static final RegistryObject<Item> PRESENT_bla = register("block_present_bla", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_bla.get(), new Item.Properties()));
	public static final RegistryObject<Item> PRESENT_chc = register("block_present_chc", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_chc.get(), new Item.Properties()));
	public static final RegistryObject<Item> PRESENT_chh = register("block_present_chh", () -> new Seasonal_noFuel(Seasonal_Blocks.PRESENT_chh.get(), new Item.Properties()));

	public static final RegistryObject<Item> SNOWCORE = register("block_snowcore", () -> new SnowCore_Item(Seasonal_Blocks.SNOWCORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SNOWMAN = register("block_snowman", () -> new SnowMan_Item(Seasonal_Blocks.SNOWMAN.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> COCOA_F = register("item_cocoa_ferm", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> COCOA_R = register("item_cocoa_roast", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> COCOA_M = register("item_cocoa_mass", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> CHOCO_raw = register("item_choco_raw", () -> new AddInfo_Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> COCOA_TARU = register("block_taru_cocoa_f", () -> new Seasonal_noFuel(Hakkou_Blocks.COCOA_TARU.get(), new Item.Properties()));

	public static final RegistryObject<Item> FOOD_CHOCO = register("item_food_choco", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO)));
	public static final RegistryObject<Item> FOOD_CHOCO_A = register("item_food_choco_apple", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_A)));
	public static final RegistryObject<Item> FOOD_CHOCO_C = register("item_food_choco_cherry", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_C)));
	public static final RegistryObject<Item> FOOD_CHOCO_G = register("item_food_choco_grape", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_G)));
	public static final RegistryObject<Item> FOOD_CHOCO_T = register("item_food_choco_greentea", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_T)));
	public static final RegistryObject<Item> FOOD_CHOCO_H = register("item_food_choco_heart", () -> new Item(new Item.Properties().tab(ItemGroups_CM.SEASONAL).food(FoodBuilders.CHOCO_H)));

	public static final RegistryObject<Item> UCHIWA_white = register("block_uchiwa_white", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_white.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_orange = register("block_uchiwa_orange", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_orange.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_magenta = register("block_uchiwa_magenta", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_magenta.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_lightb = register("block_uchiwa_lightb", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_lightb.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_yellow = register("block_uchiwa_yellow", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_lime = register("block_uchiwa_lime", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_lime.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_pink = register("block_uchiwa_pink", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_gray = register("block_uchiwa_gray", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_gray.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_lightg = register("block_uchiwa_lightg", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_lightg.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_cyan = register("block_uchiwa_cyan", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_cyan.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_purple = register("block_uchiwa_purple", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_purple.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_blue = register("block_uchiwa_blue", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_blue.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_brown = register("block_uchiwa_brown", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_brown.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_green = register("block_uchiwa_green", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_green.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_red = register("block_uchiwa_red", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> UCHIWA_black = register("block_uchiwa_black", () -> new Seasonal_noFuel(Seasonal_Blocks.UCHIWA_black.get(), new Item.Properties()));

	public static final RegistryObject<Item> FOOD_WATAGASHI = register("item_food_watagashi", () -> new FoodAnytime_addItem(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> FOOD_WATAGASHI_A = register("item_food_watagashi_y", () -> new FoodAnytime_addItem(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> FOOD_WATAGASHI_C = register("item_food_watagashi_p", () -> new FoodAnytime_addItem(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> FOOD_WATAGASHI_G = register("item_food_watagashi_r", () -> new FoodAnytime_addItem(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> FOOD_WATAGASHI_T = register("item_food_watagashi_g", () -> new FoodAnytime_addItem(new Item.Properties().tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> WATAGASHI_block = register("block_watagashi", () -> new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_block.get(), new Item.Properties()));
	public static final RegistryObject<Item> WATAGASHI_pink = register("block_watagashi_pink", () -> new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_pink.get(), new Item.Properties()));
	public static final RegistryObject<Item> WATAGASHI_red = register("block_watagashi_red", () -> new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_red.get(), new Item.Properties()));
	public static final RegistryObject<Item> WATAGASHI_yellow = register("block_watagashi_yellow", () -> new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_yellow.get(), new Item.Properties()));
	public static final RegistryObject<Item> WATAGASHI_green = register("block_watagashi_green", () -> new Seasonal_noFuel(Seasonal_Blocks.WATAGASHI_green.get(), new Item.Properties()));

	public static final RegistryObject<Item> KAKIGOURI_hata = register("block_kakigouri_hata", () -> new Seasonal_noFuel(Seasonal_Blocks.KAKIGOURI_hata.get(), new Item.Properties()));
	public static final RegistryObject<Item> KAKIGOURI_block = register("block_kakigouri_block1", () -> new Dish_always(Seasonal_Blocks.KAKIGOURI_block.get(), (new Item.Properties()).tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> KAKIGOURI_pink = register("block_kakigouri_pink1", () -> new Dish_always(Seasonal_Blocks.KAKIGOURI_pink.get(), (new Item.Properties()).tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> KAKIGOURI_red = register("block_kakigouri_red1", () -> new Dish_always(Seasonal_Blocks.KAKIGOURI_red.get(), (new Item.Properties()).tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> KAKIGOURI_yellow = register("block_kakigouri_yellow1", () -> new Dish_always(Seasonal_Blocks.KAKIGOURI_yellow.get(), (new Item.Properties()).tab(ItemGroups_CM.SEASONAL)));
	public static final RegistryObject<Item> KAKIGOURI_green = register("block_kakigouri_green1", () -> new Dish_always(Seasonal_Blocks.KAKIGOURI_green.get(), (new Item.Properties()).tab(ItemGroups_CM.SEASONAL)));

	/* YUKATA */
	public static final RegistryObject<Item> YKTD_GETA = register("item_ykt_getadoak", () -> new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlot.FEET, new Item.Properties()));
	public static final RegistryObject<Item> YKTO_GETA = register("item_ykt_getaoak", () -> new Costume_YUKATA(CMArmorMaterial.TTOKUYKT, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<Item> IKADUCHIYKT_HELMET = register("item_ykt_ikaduchi_kazari", () -> new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> IKADUCHIYKT_CHESTPLATE = register("item_ykt_ikaduchi_mini", () -> new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> IKADUCHIYKT_LEGGINGS = register("item_ykt_ikaduchi_long", () -> new Costume_YUKATA(CMArmorMaterial.IKADUCHIYKT, EquipmentSlot.LEGS, new Item.Properties()));

	public static final RegistryObject<Item> INADUMAYKT_HELMET = register("item_ykt_inaduma_kazari", () -> new Costume_YUKATA(CMArmorMaterial.INADUMAYKT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> INADUMAYKT_CHESTPLATE = register("item_ykt_inaduma_mini", () -> new Costume_YUKATA(CMArmorMaterial.INADUMAYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> INADUMAYKT_LEGGINGS = register("item_ykt_inaduma_long", () -> new Costume_YUKATA(CMArmorMaterial.INADUMAYKT, EquipmentSlot.LEGS, new Item.Properties()));

	public static final RegistryObject<Item> HAMAKAZEYKT_HELMET = register("item_ykt_hamakaze_kazari", () -> new Costume_YUKATA(CMArmorMaterial.HAMAKAZEYKT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> HAMAKAZEYKT_CHESTPLATE = register("item_ykt_hamakaze_mini", () -> new Costume_YUKATA(CMArmorMaterial.HAMAKAZEYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> HAMAKAZEYKT_LEGGINGS = register("item_ykt_hamakaze_long", () -> new Costume_YUKATA(CMArmorMaterial.HAMAKAZEYKT, EquipmentSlot.LEGS, new Item.Properties()));

	public static final RegistryObject<Item> URAKAZEYKT_HELMET = register("item_ykt_urakaze_kazari", () -> new Costume_YUKATA(CMArmorMaterial.URAKAZEYKT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> URAKAZEYKT_CHESTPLATE = register("item_ykt_urakaze_mini", () -> new Costume_YUKATA(CMArmorMaterial.URAKAZEYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> URAKAZEYKT_LEGGINGS = register("item_ykt_urakaze_long", () -> new Costume_YUKATA(CMArmorMaterial.URAKAZEYKT, EquipmentSlot.LEGS, new Item.Properties()));

	public static final RegistryObject<Item> KAWAKAZEYKT_HELMET = register("item_ykt_kawakaze_kazari", () -> new Costume_YUKATA(CMArmorMaterial.KAWAKAZEYKT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> KAWAKAZEYKT_CHESTPLATE = register("item_ykt_kawakaze_mini", () -> new Costume_YUKATA(CMArmorMaterial.KAWAKAZEYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> KAWAKAZEYKT_LEGGINGS = register("item_ykt_kawakaze_long", () -> new Costume_YUKATA(CMArmorMaterial.KAWAKAZEYKT, EquipmentSlot.LEGS, new Item.Properties()));

	public static final RegistryObject<Item> OBOROYKT_HELMET = register("item_ykt_oboro_kazari", () -> new Costume_YUKATA(CMArmorMaterial.OBOROYKT, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> OBOROYKT_CHESTPLATE = register("item_ykt_oboro_mini", () -> new Costume_YUKATA(CMArmorMaterial.OBOROYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> OBOROYKT_LEGGINGS = register("item_ykt_oboro_long", () -> new Costume_YUKATA(CMArmorMaterial.OBOROYKT, EquipmentSlot.LEGS, new Item.Properties()));

	public static final RegistryObject<Item> TTOKUYKT_CHESTPLATE = register("item_ykt_ttoku_mini", () -> new Costume_YUKATA(CMArmorMaterial.TTOKUYKT, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> TTOKUYKT_LEGGINGS = register("item_ykt_ttoku_long", () -> new Costume_YUKATA(CMArmorMaterial.TTOKUYKT, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> TTOKUYKTB_CHESTPLATE = register("item_ykt_ttokub_mini", () -> new Costume_YUKATA(CMArmorMaterial.TTOKUYKTB, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> TTOKUYKTB_LEGGINGS = register("item_ykt_ttokub_long", () -> new Costume_YUKATA(CMArmorMaterial.TTOKUYKTB, EquipmentSlot.LEGS, new Item.Properties()));

	/* SantaCos */
	public static final RegistryObject<Item> AKASHISANTA_HELMET = register("item_santaakashi_helmet", () -> new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> AKASHISANTA_CHESTPLATE = register("item_santaakashi_chestplate", () -> new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> AKASHISANTA_LEGGINGS = register("item_santaakashi_leggings", () -> new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> AKASHISANTA_BOOTS = register("item_santaakashi_boots", () -> new Costume_Santa(CMArmorMaterial.AKASHISANTA, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<Item> SUZUYASANTA_HELMET = register("item_santasuzuya_helmet", () -> new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> SUZUYASANTA_CHESTPLATE = register("item_santasuzuya_chestplate", () -> new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> SUZUYASANTA_LEGGINGS = register("item_santasuzuya_leggings", () -> new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> SUZUYASANTA_BOOTS = register("item_santasuzuya_boots", () -> new Costume_Santa(CMArmorMaterial.SUZUYASANTA, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<Item> KUMANOSANTA_HELMET = register("item_santakumano_helmet", () -> new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> KUMANOSANTA_CHESTPLATE = register("item_santakumano_chestplate", () -> new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> KUMANOSANTA_LEGGINGS = register("item_santakumano_leggings", () -> new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> KUMANOSANTA_BOOTS = register("item_santakumano_boots", () -> new Costume_Santa(CMArmorMaterial.KUMANOSANTA, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<Item> RYUJOUSANTA_HELMET = register("item_santaryujou_helmet", () -> new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> RYUJOUSANTA_CHESTPLATE = register("item_santaryujou_chestplate", () -> new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> RYUJOUSANTA_LEGGINGS = register("item_santaryujou_leggings", () -> new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> RYUJOUSANTA_BOOTS = register("item_santaryujou_boots", () -> new Costume_Santa(CMArmorMaterial.RYUJOUSANTA, EquipmentSlot.FEET, new Item.Properties()));

	public static final RegistryObject<Item> TEITOKUSANTA_HELMET = register("item_santattk_helmet", () -> new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlot.HEAD, new Item.Properties()));
	public static final RegistryObject<Item> TEITOKUSANTA_CHESTPLATE = register("item_santattk_chestplate", () -> new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlot.CHEST, new Item.Properties()));
	public static final RegistryObject<Item> TEITOKUSANTA_LEGGINGS = register("item_santattk_leggings", () -> new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlot.LEGS, new Item.Properties()));
	public static final RegistryObject<Item> TEITOKUSANTA_BOOTS = register("item_santattk_boots", () -> new Costume_Santa(CMArmorMaterial.TEITOKUSANTA, EquipmentSlot.FEET, new Item.Properties()));


	///* Register *///
	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}
}
