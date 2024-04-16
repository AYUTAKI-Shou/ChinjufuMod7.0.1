package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.addinfo.AddInfo_Item;
import com.ayutaki.chinjufumod.items.addinfo.Iga_Item;
import com.ayutaki.chinjufumod.items.foods.FoodBuilders;
import com.ayutaki.chinjufumod.items.hakkou.HakkouItem_Tips;
import com.ayutaki.chinjufumod.items.weapon.AdmiralStamp;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items_NoTab {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* Chinjufu */
	public static final RegistryObject<Item> EMBLEM_C = register("item_emblem_c", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ADMIRAL_STAMP = register("item_admiralstamp", () -> new AdmiralStamp(ChinjufuMod_Blocks.I_ADMIRAL_STAMP.get(), new Item.Properties().durability(16)));
	
	/* Teatime */
	public static final RegistryObject<Item> ROTTEN_FOOD = register("item_rotten_food", () -> new AddInfo_Item(new Item.Properties().food(FoodBuilders.ROTTEN_FOOD)));

	public static final RegistryObject<Item> SHOUYU_bot_4 = register("block_shouyu_bot_4", () -> new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_4.get(), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> SHOUYU_bot_3 = register("block_shouyu_bot_3", () -> new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_3.get(), new Item.Properties().craftRemainder(Items_NoTab.SHOUYU_bot_4.get())));
	public static final RegistryObject<Item> SHOUYU_bot_2 = register("block_shouyu_bot_2", () -> new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_2.get(), new Item.Properties().craftRemainder(Items_NoTab.SHOUYU_bot_3.get())));
	public static final RegistryObject<Item> KOMEZU_bot_2 = register("block_komezu_bot_2", () -> new HakkouItem_Tips(Hakkou_Blocks.KOMEZU_bot_2.get(), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> DASHI_bot_4 = register("block_dashi_bot_4", () -> new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_4.get(), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> DASHI_bot_3 = register("block_dashi_bot_3", () -> new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_3.get(), new Item.Properties().craftRemainder(Items_NoTab.DASHI_bot_4.get())));
	public static final RegistryObject<Item> DASHI_bot_2 = register("block_dashi_bot_2", () -> new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_2.get(), new Item.Properties().craftRemainder(Items_NoTab.DASHI_bot_3.get())));

	public static final RegistryObject<Item> OSAUCE_bot_4 = register("block_osauce_bot_4", () -> new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_4.get(), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> OSAUCE_bot_3 = register("block_osauce_bot_3", () -> new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_3.get(), new Item.Properties().craftRemainder(Items_NoTab.OSAUCE_bot_4.get())));
	public static final RegistryObject<Item> OSAUCE_bot_2 = register("block_osauce_bot_2", () -> new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_2.get(), new Item.Properties().craftRemainder(Items_NoTab.OSAUCE_bot_3.get())));
	public static final RegistryObject<Item> MAYO_bot_4 = register("block_mayo_bot_4", () -> new HakkouItem_Tips(Dish_Blocks.MAYO_bot_4.get(), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> MAYO_bot_3 = register("block_mayo_bot_3", () -> new HakkouItem_Tips(Dish_Blocks.MAYO_bot_3.get(), new Item.Properties().craftRemainder(Items_NoTab.MAYO_bot_4.get())));
	public static final RegistryObject<Item> MAYO_bot_2 = register("block_mayo_bot_2", () -> new HakkouItem_Tips(Dish_Blocks.MAYO_bot_2.get(), new Item.Properties().craftRemainder(Items_NoTab.MAYO_bot_3.get())));

	public static final RegistryObject<Item> HAMAGURI_KARA = register("item_hamaguri_shell", () -> new Item(new Item.Properties()));

	/* Seasonal */
	public static final RegistryObject<Item> IGA = register("item_chestnuts_burr", () -> new Iga_Item(new Item.Properties()));
	
	/* Weapon */
	public static final RegistryObject<Item> CARTRIDGE_L = register("item_cartridge_kc", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CARTRIDGE_M = register("item_cartridge_medium", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CARTRIDGE_S = register("item_cartridge_small", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CARTRIDGE_K = register("item_cartridge_kijyuu", () -> new Item(new Item.Properties()));
	
	
	///* Register *///
	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}
}
