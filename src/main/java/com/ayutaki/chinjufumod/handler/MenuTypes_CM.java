package com.ayutaki.chinjufumod.handler;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.gui.TansuMenu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypes_CM {

	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChinjufuMod.MOD_ID);

	public static final RegistryObject<MenuType<TansuMenu>> TANSU_MENU = register("tansu_45",
			() -> IForgeMenuType.create((windowID, inv, data) -> { return new TansuMenu(windowID, inv, data); }));
    
	private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(@Nonnull String name, @Nonnull Supplier<MenuType<T>> supplier) {
		return MENU_TYPES.register(name, supplier);
	}
}
