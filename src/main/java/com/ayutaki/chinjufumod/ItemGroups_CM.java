package com.ayutaki.chinjufumod;

import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemGroups_CM {

	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<CreativeModeTab> CHINJUFU = TABS.register("chinjufumod_1", () -> CreativeModeTab.builder()
		.icon(() -> new ItemStack(Items_NoTab.EMBLEM_C.get()))
		.title(Component.translatable("itemGroup.chinjufumod.tab_chinjufumod"))
		.displayItems((parameters, output) -> {
			Items_Chinjufu.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
			
			//output.accept(Items_Chinjufu.BAUXITE.get());
			//output.accept(Items_Chinjufu.BAUXITE_ORE.get());
			//output.accept(Items_Chinjufu.BAUXITE_ORE_DEEP.get());
		}).build());
	
	public static final RegistryObject<CreativeModeTab> TEATIME = TABS.register("chinjufumod_2", () -> CreativeModeTab.builder()
			.withTabsBefore(ItemGroups_CM.CHINJUFU.getKey())
			.icon(() -> new ItemStack(Items_Teatime.TEACUP.get()))
			.title(Component.translatable("itemGroup.chinjufumod.tab_teatime"))
			.displayItems((parameters, output) -> {
				Items_Teatime.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
		}).build());
	
	public static final RegistryObject<CreativeModeTab> SEASONAL = TABS.register("chinjufumod_3", () -> CreativeModeTab.builder()
			.withTabsBefore(ItemGroups_CM.TEATIME.getKey())
			.icon(() -> new ItemStack(Items_Seasonal.HAMAKAZEYKT_CHESTPLATE.get()))
			.title(Component.translatable("itemGroup.chinjufumod.tab_seasonal"))
			.displayItems((parameters, output) -> {
				Items_Seasonal.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
		}).build());

	public static final RegistryObject<CreativeModeTab> CMARMOR = TABS.register("chinjufumod_4", () -> CreativeModeTab.builder()
			.withTabsBefore(ItemGroups_CM.SEASONAL.getKey())
			.icon(() -> new ItemStack(Items_Armor.FUBUKI_CHESTPLATE.get()))
			.title(Component.translatable("itemGroup.chinjufumod.tab_cmarmor"))
			.displayItems((parameters, output) -> {
				Items_Armor.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
				Items_Weapon.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
		}).build());
	
	public static final RegistryObject<CreativeModeTab> WADECO = TABS.register("chinjufumod_5", () -> CreativeModeTab.builder()
			.withTabsBefore(ItemGroups_CM.CMARMOR.getKey())
			.icon(() -> new ItemStack(Items_Wadeco.FUSUMAB_cyan.get()))
			.title(Component.translatable("itemGroup.chinjufumod.tab_cmodwadeco"))
			.displayItems((parameters, output) -> {
				Items_Wadeco.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
		}).build());
	
	public static final RegistryObject<CreativeModeTab> WABLOCK = TABS.register("chinjufumod_6", () -> CreativeModeTab.builder()
			.withTabsBefore(ItemGroups_CM.WADECO.getKey())
			.icon(() -> new ItemStack(Items_Wablock.KAWARA_gray.get()))
			.title(Component.translatable("itemGroup.chinjufumod.tab_cmodwablock"))
			.displayItems((parameters, output) -> {
				Items_Wablock.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
		}).build());

	public static final RegistryObject<CreativeModeTab> WALLPANEL = TABS.register("chinjufumod_7", () -> CreativeModeTab.builder()
			.withTabsBefore(ItemGroups_CM.WABLOCK.getKey())
			.icon(() -> new ItemStack(Items_WallPanel.WP_STONE_graB.get()))
			.title(Component.translatable("itemGroup.chinjufumod.tab_wallpanel"))
			.displayItems((parameters, output) -> {
				Items_WallPanel.ITEMS.getEntries().forEach(registryObject -> { output.accept(registryObject.get()); });
		}).build());
}
