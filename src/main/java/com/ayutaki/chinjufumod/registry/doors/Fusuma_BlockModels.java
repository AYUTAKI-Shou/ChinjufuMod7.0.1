package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;

import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class Fusuma_BlockModels {

	/* -> clientproxy registerModels() */
	@SubscribeEvent
	public static void registerRender() {

		StateMap ignorePowered = new StateMap.Builder().ignore(Fusuma.POWERED).build();
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_black, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_blue, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_brown, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_cyan, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_gray, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_green, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_lightblue, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_lightgray, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_lime, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_magenta, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_orange, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_pink, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_purple, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_red, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_white, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMA_yellow, ignorePowered);

		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_black, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_blue, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_brown, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_cyan, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_gray, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_green, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_lightblue, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_lightgray, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_lime, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_magenta, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_orange, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_pink, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_purple, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_red, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_white, ignorePowered);
		ModelLoader.setCustomStateMapper(Fusuma_Blocks.FUSUMAB_yellow, ignorePowered);
	}
}
