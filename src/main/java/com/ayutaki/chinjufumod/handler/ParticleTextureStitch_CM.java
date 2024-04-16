package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, value = Side.CLIENT)
public class ParticleTextureStitch_CM {

	@SubscribeEvent
	public static void texStitch(TextureStitchEvent.Pre evt) {
		TextureMap map = evt.getMap();

		map.registerSprite(new ResourceLocation(ChinjufuMod.MOD_ID, "particles/fallsakura"));
		map.registerSprite(new ResourceLocation(ChinjufuMod.MOD_ID, "particles/fallkaede"));
		map.registerSprite(new ResourceLocation(ChinjufuMod.MOD_ID, "particles/fallichoh"));
		map.registerSprite(new ResourceLocation(ChinjufuMod.MOD_ID, "particles/fallkare"));
		
		map.registerSprite(new ResourceLocation("particle/particles"));
	}

}
