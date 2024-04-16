package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.gui.ReizouMenu;
import com.ayutaki.chinjufumod.gui.TansuMenu;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuTypes_CM {

	public static final DeferredRegister<ContainerType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<ContainerType<TansuMenu>> TANSU_MENU = MENU_TYPES.register("tansu_45", () -> IForgeContainerType.create(TansuMenu::new));
	public static final RegistryObject<ContainerType<ReizouMenu>> REIZOU_MENU = MENU_TYPES.register("reizou_45", () -> IForgeContainerType.create(ReizouMenu::new));

}
