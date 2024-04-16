package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.addinfo.AddInfo_Item;
import com.ayutaki.chinjufumod.items.addinfo.Iga_Item;
import com.ayutaki.chinjufumod.items.foods.FoodBuilders;
import com.ayutaki.chinjufumod.items.hakkou.HakkouItem_Tips;
import com.ayutaki.chinjufumod.items.weapon.AdmiralStamp;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_NoTab {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* Chinjufu */
	public static Item EMBLEM_C = register("item_emblem_c", new Item(new Item.Properties()));
	public static Item ADMIRAL_STAMP = register("item_admiralstamp", new AdmiralStamp(ChinjufuMod_Blocks.I_ADMIRAL_STAMP, new Item.Properties().durability(16)));

	/* Teatime */
	public static Item ROTTEN_FOOD = register("item_rotten_food", new AddInfo_Item(new Item.Properties().food(FoodBuilders.ROTTEN_FOOD)));

	public static Item SHOUYU_bot_4 = register("block_shouyu_bot_4", new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_4, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static Item SHOUYU_bot_3 = register("block_shouyu_bot_3", new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_3, new Item.Properties().craftRemainder(Items_NoTab.SHOUYU_bot_4)));
	public static Item SHOUYU_bot_2 = register("block_shouyu_bot_2", new HakkouItem_Tips(Hakkou_Blocks.SHOUYU_bot_2, new Item.Properties().craftRemainder(Items_NoTab.SHOUYU_bot_3)));
	public static Item KOMEZU_bot_2 = register("block_komezu_bot_2", new HakkouItem_Tips(Hakkou_Blocks.KOMEZU_bot_2, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static Item DASHI_bot_4 = register("block_dashi_bot_4", new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_4, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static Item DASHI_bot_3 = register("block_dashi_bot_3", new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_3, new Item.Properties().craftRemainder(Items_NoTab.DASHI_bot_4)));
	public static Item DASHI_bot_2 = register("block_dashi_bot_2", new HakkouItem_Tips(Hakkou_Blocks.DASHI_bot_2, new Item.Properties().craftRemainder(Items_NoTab.DASHI_bot_3)));

	public static Item OSAUCE_bot_4 = register("block_osauce_bot_4", new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_4, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static Item OSAUCE_bot_3 = register("block_osauce_bot_3", new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_3, new Item.Properties().craftRemainder(Items_NoTab.OSAUCE_bot_4)));
	public static Item OSAUCE_bot_2 = register("block_osauce_bot_2", new HakkouItem_Tips(Dish_Blocks.OSAUCE_bot_2, new Item.Properties().craftRemainder(Items_NoTab.OSAUCE_bot_3)));
	public static Item MAYO_bot_4 = register("block_mayo_bot_4", new HakkouItem_Tips(Dish_Blocks.MAYO_bot_4, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static Item MAYO_bot_3 = register("block_mayo_bot_3", new HakkouItem_Tips(Dish_Blocks.MAYO_bot_3, new Item.Properties().craftRemainder(Items_NoTab.MAYO_bot_4)));
	public static Item MAYO_bot_2 = register("block_mayo_bot_2", new HakkouItem_Tips(Dish_Blocks.MAYO_bot_2, new Item.Properties().craftRemainder(Items_NoTab.MAYO_bot_3)));

	public static Item HAMAGURI_KARA = register("item_hamaguri_shell", new Item(new Item.Properties()));

	/* Seasonal */
	public static Item IGA = register("item_chestnuts_burr", new Iga_Item(new Item.Properties()));
	
	/* Weapon */
	public static Item CARTRIDGE_L = register("item_cartridge_kc", new Item(new Item.Properties()));
	public static Item CARTRIDGE_M = register("item_cartridge_medium", new Item(new Item.Properties()));
	public static Item CARTRIDGE_S = register("item_cartridge_small", new Item(new Item.Properties()));
	public static Item CARTRIDGE_K = register("item_cartridge_kijyuu", new Item(new Item.Properties()));
	
	
	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}
}
