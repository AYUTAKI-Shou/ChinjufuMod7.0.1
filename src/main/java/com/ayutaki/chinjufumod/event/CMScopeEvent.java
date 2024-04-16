package com.ayutaki.chinjufumod.event;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.kansaiki.Base_BowKansaiki;
import com.ayutaki.chinjufumod.items.weapon.Base_RensouHou;
import com.ayutaki.chinjufumod.items.weapon.SouganKyou;
import com.ayutaki.chinjufumod.items.weapon.Triple_Kijyuu;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CMScopeEvent {

	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void updateFOV(ComputeFovModifierEvent event) {
		Player player = event.getPlayer();
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		boolean useItem = (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isUsingItem());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) { event.setNewFovModifier(event.getFovModifier() / 10); }
		
		if (useItem && (main instanceof Base_RensouHou || main instanceof Triple_Kijyuu || main instanceof Base_BowKansaiki
				|| off instanceof Base_RensouHou || off instanceof Triple_Kijyuu || off instanceof Base_BowKansaiki)) {
			int tick = event.getPlayer().getTicksUsingItem();
			float f1 = (float) tick / 20.0F;
			f1 = (f1 + 2.0F) / 3.0F;
			if (f1 > 1.0F) { f1 = 1.0F; } 
			else { f1 = f1 * f1; }
			event.setNewFovModifier(event.getFovModifier() * (1.0F - f1 * 0.15F)); }
	}
	
	
	private static final ResourceLocation LENS = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/binoculars_68l.png");
	private static final ResourceLocation FRAME = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/binoculars_68f.png");
	
	@SuppressWarnings({ "resource" })
	@SubscribeEvent
	public static void textureOverlay(RenderGuiOverlayEvent event) {
		Minecraft mc = Minecraft.getInstance();
		LocalPlayer player = mc.player;
		Item main = player.getMainHandItem().getItem();
		Item off = player.getOffhandItem().getItem();
		boolean useItem = (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isUsingItem());
		
		if (useItem && (main instanceof SouganKyou || off instanceof SouganKyou)) {
			RenderSystem.disableDepthTest(); //renderHotbar
			RenderSystem.defaultBlendFunc(); // TRANSLUCENT
			RenderSystem.enableBlend(); // TRANSLUCENT
			RenderSystem.depthMask(false); // TRANSLUCENT
			
			GuiGraphics gui = event.getGuiGraphics();
			float size = 0.975F;
			lensOverlay(gui, size);
			renderBack(gui, size);
			
			if(event.getOverlay() == VanillaGuiOverlay.HOTBAR.type() || event.getOverlay() == VanillaGuiOverlay.PLAYER_HEALTH.type() || 
				event.getOverlay() == VanillaGuiOverlay.ARMOR_LEVEL.type() || event.getOverlay() == VanillaGuiOverlay.FOOD_LEVEL.type() || 
				event.getOverlay() == VanillaGuiOverlay.AIR_LEVEL.type() || event.getOverlay() == VanillaGuiOverlay.MOUNT_HEALTH.type() || 
				event.getOverlay() == VanillaGuiOverlay.EXPERIENCE_BAR.type() || event.getOverlay() == VanillaGuiOverlay.JUMP_BAR.type() || 
				event.getOverlay() == VanillaGuiOverlay.ITEM_NAME.type()) {
				event.setCanceled(true);
			}
		}
	}
	
	private static void lensOverlay(GuiGraphics gui, float size) {
		int posX = gui.guiWidth();
		int posY = gui.guiHeight();
		float f = (float)Math.min(posX, posY);
		float f1 = Math.min((float)posX / f, (float)posY / f) * size;
		int i = Mth.floor(f * f1);
		int j = Mth.floor(f * f1);
		int k = (posX - i) / 2;
		int l = (posY - j) / 2;
		gui.setColor(1.0F, 1.0F, 1.0F, 0.02F);
		gui.blit(LENS, k, l, -90, 0.0F, 0.0F, i, j, i, j);
	}
		
	private static void renderBack(GuiGraphics gui, float size) {
		int posX = gui.guiWidth();
		int posY = gui.guiHeight();
		float f = (float)Math.min(posX, posY);
		float f1 = Math.min((float)posX / f, (float)posY / f) * size;
		int i = Mth.floor(f * f1);
		int j = Mth.floor(f * f1);
		int k = (posX - i) / 2;
		int l = (posY - j) / 2;
		int i1 = k + i;
		int j1 = l + j;
		gui.setColor(1.0F, 1.0F, 1.0F, 1.0F);
		gui.blit(FRAME, k, l, -90, 0.0F, 0.0F, i, j, i, j);
		gui.fill(RenderType.guiOverlay(), 0, j1, posX, posY, -90, -16777216);
		gui.fill(RenderType.guiOverlay(), 0, 0, posX, l, -90, -16777216);
		gui.fill(RenderType.guiOverlay(), 0, l, k, j1, -90, -16777216);
		gui.fill(RenderType.guiOverlay(), i1, l, posX, j1, -90, -16777216);
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
