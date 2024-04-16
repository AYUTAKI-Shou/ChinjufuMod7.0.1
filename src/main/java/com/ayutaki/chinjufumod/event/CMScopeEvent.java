package com.ayutaki.chinjufumod.event;

import org.lwjgl.opengl.GL11;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, value = Side.CLIENT)
public class CMScopeEvent {

	@SubscribeEvent
	public static void updateFOV(FOVUpdateEvent event) {
		EntityPlayer player = event.getEntity();
		Item main = player.getHeldItemMainhand().getItem();
		Item off = player.getHeldItemOffhand().getItem();
		boolean useItem = ((Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) && player.isHandActive());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) { event.setNewfov(event.getFov() / 10); }
	}
	
	
	private static final ResourceLocation SOUGAN = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/binoculars_128t.png");

	@SuppressWarnings({ "incomplete-switch" })
	@SubscribeEvent
	public static void textureOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.player;
		Item main = player.getHeldItemMainhand().getItem();
		Item off = player.getHeldItemOffhand().getItem();
		boolean useItem = ((Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) && player.isHandActive());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) {
			RenderGameOverlayEvent.ElementType type = event.getType();
			int posX = event.getResolution().getScaledWidth();
			int posY = event.getResolution().getScaledHeight();
			
			switch (type) { case ALL : event.setCanceled(true); }
			
			/* from Ingame_Gui */
			//CUTOUT GlStateManager.enableBlend();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GlStateManager.depthMask(false); // TRANSLUCENT
			Minecraft.getMinecraft().getTextureManager().bindTexture(SOUGAN);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuffer();
			bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
			bufferbuilder.pos(0.0D, posY, -90.0D).tex(0.0F, 1.0F).endVertex();
			bufferbuilder.pos(posX, posY, -90.0D).tex(1.0F, 1.0F).endVertex();
			bufferbuilder.pos(posX, 0.0D, -90.0D).tex(1.0F, 0.0F).endVertex();
			bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0F, 0.0F).endVertex();
			tessellator.draw();
		}
	}
	
	
	@SubscribeEvent
	public static void firstPersonHand(RenderHandEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.player;
		Item main = player.getHeldItemMainhand().getItem();
		Item off = player.getHeldItemOffhand().getItem();
		if ((main instanceof SouganKyou || off instanceof SouganKyou) && player.isHandActive()) { event.setCanceled(true); }
	}
}
