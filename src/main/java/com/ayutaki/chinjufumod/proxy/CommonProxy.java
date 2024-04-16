package com.ayutaki.chinjufumod.proxy;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonProxy implements IProxy {

	public void setup(final FMLCommonSetupEvent event) {
		/** some preinit code **/
		ChinjufuMod.LOGGER.info("HELLO FROM ChinjufuMod");
	}

}
