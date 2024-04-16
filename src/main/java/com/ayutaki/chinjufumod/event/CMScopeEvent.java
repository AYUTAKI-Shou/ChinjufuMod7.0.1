package com.ayutaki.chinjufumod.event;

import org.lwjgl.opengl.GL11;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CMScopeEvent {
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void updateFOV(FOVUpdateEvent event) {
		PlayerEntity player = event.getEntity();
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		boolean useItem = (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isUsingItem());

		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) { event.setNewfov(event.getFov() / 10); }
	}

	
	private static final ResourceLocation SOUGAN = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/binoculars_128t.png");

	@SuppressWarnings({ "resource", "incomplete-switch", "deprecation" })
	@SubscribeEvent
	public static void textureOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		boolean useItem = (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isUsingItem());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) {
			RenderGameOverlayEvent.ElementType type = event.getType();
			int posX = event.getWindow().getGuiScaledWidth();
			int posY = event.getWindow().getGuiScaledHeight();
			
			switch (type) { case ALL : event.setCanceled(true); }
			
			/* from Ingame_Gui */
			//CUTOUT RenderSystem.enableBlend();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.enableBlend();
			RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			RenderSystem.depthMask(false); // TRANSLUCENT
			Minecraft.getInstance().getTextureManager().bind(SOUGAN);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuilder();
			bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
			bufferbuilder.vertex(0.0D, posY, -90.0D).uv(0.0F, 1.0F).endVertex();
			bufferbuilder.vertex(posX, posY, -90.0D).uv(1.0F, 1.0F).endVertex();
			bufferbuilder.vertex(posX, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
			bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
			tessellator.end(); }
	}
	
	
	@SubscribeEvent
	public static void firstPersonHand(RenderHandEvent event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		if ((main instanceof SouganKyou || off instanceof SouganKyou) && player.isUsingItem()) { event.setCanceled(true); }
	}
}
