package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoor;

import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class Garasudo_BlockModels {

	/* -> clientproxy registerModels() */
	@SubscribeEvent
	public static void registerRender() {

		StateMap ignorePowered = new StateMap.Builder().ignore(GlassDoor.POWERED).build();
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_ACA, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_BIR, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_DOAK, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_JUN, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_SPRU, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_SAKU, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_ICH, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDO_KAE, ignorePowered);

		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_ACA, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_BIR, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_DOAK, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_JUN, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_SPRU, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_SAKU, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_ICH, ignorePowered);
		ModelLoader.setCustomStateMapper(Garasudo_Blocks.GARASUDOB_KAE, ignorePowered);
	}
}
