package com.ayutaki.chinjufumod.gui;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TansuScreen extends AbstractContainerScreen<TansuMenu> {
	
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/tansu_45.png");
	
	public TansuScreen(TansuMenu menu, Inventory inv, Component titleIn) {
		super(menu, inv, titleIn);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 175;
		this.imageHeight = 203;
	}
	
	@Override
	public void render(GuiGraphics stack, final int mouseX, final int mouseY, final float partialTicks) {
		this.renderBackground(stack, mouseY, mouseY, partialTicks); // fix 20.2
		super.render(stack, mouseX, mouseY, partialTicks);
		this.renderTooltip(stack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics stack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) / 2;
		stack.blit(BACKGROUND_TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);
	}

	/* Inventory title height. */
	@Override
	protected void renderLabels(GuiGraphics stack, int mouseX, int mouseY) {
		stack.drawString(this.font, this.title, 8, 6, 4210752, false);
		stack.drawString(this.font, this.playerInventoryTitle, 8, 110, 4210752, false);
	}
}
