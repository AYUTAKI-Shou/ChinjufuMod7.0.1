package com.ayutaki.chinjufumod.proxy;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.gui.ConfigScreen_CM;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientProxy implements IProxy {

	public void setup(final FMLCommonSetupEvent event) {
		ModList.get().getModContainerById(ChinjufuMod.MOD_ID).ifPresent((consumer) -> consumer
				.registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> (mc, screen) -> new ConfigScreen_CM(screen)));
	}

}
