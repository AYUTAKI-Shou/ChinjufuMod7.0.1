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
		Item main = player.getHeldItemMainhand().getItem();
		Item off = player.getHeldItemOffhand().getItem();
		boolean useItem = ((Minecraft.getInstance().gameSettings.thirdPersonView == 0) && player.isHandActive());
		/* first person */
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) { event.setNewfov(event.getFov() / 10); }
	}

	
	private static final ResourceLocation SOUGAN = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/binoculars_128t.png");

	@SuppressWarnings({ "resource", "incomplete-switch" })
	@SubscribeEvent
	public static void textureOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		Item main = player.getHeldItemMainhand().getItem();
		Item off = player.getHeldItemOffhand().getItem();
		boolean useItem = ((Minecraft.getInstance().gameSettings.thirdPersonView == 0) && player.isHandActive());

		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) {
			RenderGameOverlayEvent.ElementType type = event.getType();
			int posX = event.getWindow().getScaledWidth();
			int posY = event.getWindow().getScaledHeight();

			switch (type) { case ALL : event.setCanceled(true); }
			
			/* from Ingame_Gui */
			//CUTOUT RenderSystem.enableBlend(); 
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.enableBlend();
			RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			RenderSystem.depthMask(false); // TRANSLUCENT
			Minecraft.getInstance().getTextureManager().bindTexture(SOUGAN);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuffer();
			bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
			bufferbuilder.pos(0.0D, posY, -90.0D).tex(0.0F, 1.0F).endVertex();
			bufferbuilder.pos(posX, posY, -90.0D).tex(1.0F, 1.0F).endVertex();
			bufferbuilder.pos(posX, 0.0D, -90.0D).tex(1.0F, 0.0F).endVertex();
			bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0F, 0.0F).endVertex();
			tessellator.draw(); }
	}
	
	
	@SubscribeEvent
	public static void firstPersonHand(RenderHandEvent event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		Item main = player.getHeldItemMainhand().getItem();
		Item off = player.getHeldItemOffhand().getItem();
		if ((main instanceof SouganKyou || off instanceof SouganKyou) && player.isHandActive()) { event.setCanceled(true); }
	}
}
