package com.ayutaki.chinjufumod.gui;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ReizouScreen extends ContainerScreen<ReizouMenu> {
	
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ChinjufuMod.MOD_ID, "textures/gui/tansu_45.png");
	
	public ReizouScreen(ReizouMenu menu, PlayerInventory inv, ITextComponent titleIn) {
		super(menu, inv, titleIn);
		this.passEvents = false;
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 175;
		this.imageHeight = 203;
	}
	
	@Override
	public void render(MatrixStack stack, final int mouseX, final int mouseY, final float partialTicks) {
		this.renderBackground(stack);
		super.render(stack, mouseX, mouseY, partialTicks);
		this.renderTooltip(stack, mouseX, mouseY);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void renderBg(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) / 2;
		this.blit(stack, x, y, 0, 0, this.imageWidth, this.imageHeight);
	}

	/* Inventory title height. */
	@Override
	protected void renderLabels(MatrixStack stack, int mouseX, int mouseY) {
		this.font.draw(stack, this.title, 8.0f, 6.0f, 4210752);
		this.font.draw(stack, this.inventory.getDisplayName(), 8.0f, 110.f, 4210752);
	}
}
