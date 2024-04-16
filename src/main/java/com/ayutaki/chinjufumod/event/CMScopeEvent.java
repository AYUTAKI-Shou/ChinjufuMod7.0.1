package com.ayutaki.chinjufumod.event;

import org.lwjgl.opengl.GL11;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.kansaiki.Base_BowKansaiki;
import com.ayutaki.chinjufumod.items.weapon.Base_RensouHou;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;
import com.ayutaki.chinjufumod.items.weapon.Triple_Kijyuu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CMScopeEvent {

	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void updateFOV(FOVModifierEvent event) {
		Player player = event.getEntity();
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		boolean useItem = (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isUsingItem());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) { event.setNewfov(event.getFov() / 10); }
		
		if (useItem && (main instanceof Base_RensouHou || main instanceof Triple_Kijyuu || main instanceof Base_BowKansaiki)) {
			int tick = event.getEntity().getTicksUsingItem();
			float f1 = (float) tick / 20.0F;
			f1 = (f1 + 2.0F) / 3.0F;
			if (f1 > 1.0F) { f1 = 1.0F; } 
			else { f1 = f1 * f1; }
			event.setNewfov(event.getFov() * (1.0F - f1 * 0.15F)); }
	}

	
	private static final ResourceLocation SOUGAN = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/binoculars_128t.png");

	@SuppressWarnings({ "resource", "incomplete-switch" })
	@SubscribeEvent
	public static void textureOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getInstance();
		LocalPlayer player = mc.player;
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		boolean useItem = (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isUsingItem());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) {
			RenderGameOverlayEvent.ElementType type = event.getType();
			int posX = event.getWindow().getGuiScaledWidth();
			int posY = event.getWindow().getGuiScaledHeight();
			
			switch (type) { case ALL : event.setCanceled(true); }
			
			/* from Ingame_Gui */
			/*RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.defaultBlendFunc();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.enableBlend(); //CUTOUT */
			
			RenderSystem.disableDepthTest();
			RenderSystem.defaultBlendFunc();
			RenderSystem.setShader(GameRenderer::getPositionTexShader); //SpyglassOverlay
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.enableBlend();
			RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			RenderSystem.depthMask(false); // TRANSLUCENT

			RenderSystem.setShaderTexture(0, SOUGAN);
			Tesselator tessellator = Tesselator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuilder();
			bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
			bufferbuilder.vertex(0.0D, posY, -90.0D).uv(0.0F, 1.0F).endVertex();
			bufferbuilder.vertex(posX, posY, -90.0D).uv(1.0F, 1.0F).endVertex();
			bufferbuilder.vertex(posX, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
			bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
			tessellator.end(); }
	}
	

	@SubscribeEvent
	public static void firstPersonHand(RenderHandEvent event) {
		Minecraft mc = Minecraft.getInstance();
		LocalPlayer player = mc.player;
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		if ((main instanceof SouganKyou || off instanceof SouganKyou) && player.isUsingItem()) { event.setCanceled(true); }
	}
}
