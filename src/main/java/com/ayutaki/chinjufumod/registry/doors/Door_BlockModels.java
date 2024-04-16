package com.ayutaki.chinjufumod.registry.doors;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class Door_BlockModels {

	/* -> clientproxy registerModels() */
	@SubscribeEvent
	public static void registerRender() {

		StateMap ignorePowered = new StateMap.Builder().ignore(BlockDoor.POWERED).build();
		ModelLoader.setCustomStateMapper(Door_Blocks.DOOR_SAKURA, ignorePowered);
		ModelLoader.setCustomStateMapper(Door_Blocks.DOOR_KAEDE, ignorePowered);
		ModelLoader.setCustomStateMapper(Door_Blocks.DOOR_ICHOH, ignorePowered);
		ModelLoader.setCustomStateMapper(Door_Blocks.TAKEDOOR, ignorePowered);
		ModelLoader.setCustomStateMapper(Door_Blocks.TAKEDOOR_Y, ignorePowered);
		ModelLoader.setCustomStateMapper(Door_Blocks.TAKEDOOR_K, ignorePowered);


		StateMap ignorePowered1 = new StateMap.Builder().ignore(BlockFenceGate.POWERED).build();
		ModelLoader.setCustomStateMapper(Door_Blocks.SAKURA_FGATE, ignorePowered1);
		ModelLoader.setCustomStateMapper(Door_Blocks.KAEDE_FGATE, ignorePowered1);
		ModelLoader.setCustomStateMapper(Door_Blocks.ICHOH_FGATE, ignorePowered1);
		ModelLoader.setCustomStateMapper(Door_Blocks.TAKEFENCEGATE, ignorePowered1);
		ModelLoader.setCustomStateMapper(Door_Blocks.TAKEFENCEGATE_Y, ignorePowered1);
		ModelLoader.setCustomStateMapper(Door_Blocks.TAKEFENCEGATE_K, ignorePowered1);
		
		StateMap ignorePowered2 = new StateMap.Builder().ignore(BlockFenceGate.POWERED).build();
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_spruce, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_birch, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_jungle, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_acacia, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_darkoak, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_sakura, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_kaede, ignorePowered2);
		ModelLoader.setCustomStateMapper(Door_Blocks.KIDO_ichoh, ignorePowered2);
	}
}
