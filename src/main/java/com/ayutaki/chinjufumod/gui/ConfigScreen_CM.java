package com.ayutaki.chinjufumod.gui;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ConfigClient_CM;
import com.ayutaki.chinjufumod.Config_CM;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen_CM extends Screen {

	private static final int TITLE_HEIGHT = 8;
	private static final int OPTIONS_LIST_TOP_HEIGHT = 24;
	private static final int OPTIONS_LIST_BOTTOM_OFFSET = 32;
	private static final int BOTTOM_BUTTON_HEIGHT_OFFSET = 26;
	private static final int OPTIONS_LIST_ITEM_HEIGHT = 25;
	private static final int BOTTOM_BUTTON_WIDTH = 150;
	private static final int BUTTONS_INTERVAL = 4;
	private static final int BUTTON_HEIGHT = 20;

	private static final Config_CM CI = Config_CM.getInstance();
	private static final ConfigClient_CM Client_I = ConfigClient_CM.getInstance();
	
	private final Screen parentScreen;
	private OptionsRowList optionsRowList;

	public ConfigScreen_CM(Screen parentScreen) {
		super(new TranslationTextComponent("gui.config.chinjufumod.title", ChinjufuMod.MOD_ID + "_16.5"));
		this.parentScreen = parentScreen;
	}

	private static final ITextComponent BAUXITECHANCE_TOOLTIP = new TranslationTextComponent("gui.config.bauxiteore.chance.tooltip");
	private static final ITextComponent BIOMECHANCE_TOOLTIP = new TranslationTextComponent("gui.config.biomechance.tooltip");
	private static final ITextComponent TREECHANCE_TOOLTIP = new TranslationTextComponent("gui.config.treechance.tooltip");

	private static final ITextComponent HELMET_TOOLTIP = new TranslationTextComponent("gui.config.helmet_texture.tooltip");
	private static final ITextComponent CHESTPLATE_TOOLTIP = new TranslationTextComponent("gui.config.chestplate_texture.tooltip");
	private static final ITextComponent LEGGINGS_TOOLTIP = new TranslationTextComponent("gui.config.leggings_texture.tooltip");
	private static final ITextComponent BOOTS_TOOLTIP = new TranslationTextComponent("gui.config.boots_texture.tooltip");
	
	@SuppressWarnings("resource")
	@Override
	protected void init() {
		this.optionsRowList = new OptionsRowList(Objects.requireNonNull(this.minecraft), this.width, this.height,
				OPTIONS_LIST_TOP_HEIGHT, this.height - OPTIONS_LIST_BOTTOM_OFFSET, OPTIONS_LIST_ITEM_HEIGHT);

		/* Blast net.minecraft.client.AbstractOption*/
		this.optionsRowList.addBig(new BooleanOption("gui.config.blastblockbreak",
				new TranslationTextComponent("gui.config.blastblockbreak.tooltip"),
				unused -> CI.blastBlockBreak(), (unused, newValue) -> CI.changeBlastBlockBreak(newValue)));

		/* Anti Shadow */
		this.optionsRowList.addBig(new BooleanOption("gui.config.antishadow",
				new TranslationTextComponent("gui.config.antishadow.tooltip"),
				unused -> CI.antiShadow(), (unused, newValue) -> CI.changeAntiShadow(newValue)));

		/* Bauxite */
		this.optionsRowList.addBig(new BooleanOption("gui.config.bauxiteore.gene",
				new TranslationTextComponent("gui.config.bauxiteore.gene.tooltip"),
				unused -> CI.bauxiteGene(), (unused, newValue) -> CI.changeBauxiteGene(newValue)));
		
		this.optionsRowList.addBig(
				new SliderPercentageOption("gui.config.bauxiteore.chance", 1.0D, 100.0D, 1.0F,
						(unused) -> (double) CI.bauxiteChance(),
						(unused, newValue) -> CI.changeBauxiteChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(BAUXITECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.bauxiteore.chance" ) + ": " + (int) option.get(gs)); }));

		/* SAKURA */
		this.optionsRowList.addBig(new BooleanOption("gui.config.cherrybiome.gene",
				new TranslationTextComponent("gui.config.cherrybiome.gene.tooltip"),
				unused -> CI.sakuraBiomeGene(), (unused, newValue) -> CI.changeSakuraBiomeGene(newValue)));
		
		this.optionsRowList.addSmall(
				new SliderPercentageOption("gui.config.cherrybiome.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.sakuraBiomeChance(),
						(unused, newValue) -> CI.changeSakuraBiomeChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(BIOMECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.cherrybiome.chance" ) + ": " + (int) option.get(gs)); }),

				new SliderPercentageOption("gui.config.cherrytree.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.sakuraTreeChance(),
						(unused, newValue) -> CI.changeSakuraTreeChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(TREECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.cherrytree.chance" ) + ": " + (int) option.get(gs)); }));

		/* KAEDE */
		this.optionsRowList.addBig(new BooleanOption("gui.config.acerbiome.gene",
				new TranslationTextComponent("gui.config.acerbiome.gene.tooltip"),
				unused -> CI.kaedeBiomeGene(), (unused, newValue) -> CI.changeKaedeBiomeGene(newValue)));
		
		this.optionsRowList.addSmall(
				new SliderPercentageOption("gui.config.acerbiome.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.kaedeBiomeChance(),
						(unused, newValue) -> CI.changeKaedeBiomeChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(BIOMECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.acerbiome.chance" ) + ": " + (int) option.get(gs)); }),

				new SliderPercentageOption("gui.config.acertree.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.kaedeTreeChance(),
						(unused, newValue) -> CI.changeKaedeTreeChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(TREECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.acertree.chance" ) + ": " + (int) option.get(gs)); }));

		/* ICHOH */
		this.optionsRowList.addBig(new BooleanOption("gui.config.ginkgobiome.gene",
				new TranslationTextComponent("gui.config.ginkgobiome.gene.tooltip"),
				unused -> CI.ichohBiomeGene(), (unused, newValue) -> CI.changeIchohBiomeGene(newValue)));
		
		this.optionsRowList.addSmall(
				new SliderPercentageOption("gui.config.ginkgobiome.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.ichohBiomeChance(),
						(unused, newValue) -> CI.changeIchohBiomeChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(BIOMECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.ginkgobiome.chance" ) + ": " + (int) option.get(gs)); }),

				new SliderPercentageOption("gui.config.ginkgotree.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.ichohTreeChance(),
						(unused, newValue) -> CI.changeIchohTreeChance(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(TREECHANCE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.ginkgotree.chance" ) + ": " + (int) option.get(gs)); }));
		
		/** KURI **/
		this.optionsRowList.addBig(new BooleanOption("gui.config.chestnutsfall",
				new TranslationTextComponent("gui.config.chestnutsfall.tooltip"),
				unused -> CI.chestnutsFall(), (unused, newValue) -> CI.changeChestnutsFall(newValue)));
		
		/** Low Sound **/
		this.optionsRowList.addBig(new BooleanOption("gui.config.lowsound",
				new TranslationTextComponent("gui.config.lowsound.tooltip"),
				unused -> CI.lowSound(), (unused, newValue) -> CI.changeLowSound(newValue)));
		
		/** MAKIMONO **/
		this.optionsRowList.addBig(new BooleanOption("gui.config.usemakimono",
				new TranslationTextComponent("gui.config.usemakimono.tooltip"),
				unused -> CI.useMAKIMONO(), (unused, newValue) -> CI.changeUseMAKIMONO(newValue)));
		
		/** Costume **/
		this.optionsRowList.addBig(
				new SliderPercentageOption("gui.config.helmet_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.helmetTexture(),
						(unused, newValue) -> Client_I.changeTypeHelmet(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(HELMET_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.helmet_texture" ) + ": " + (int) option.get(gs)); }));
		
		this.optionsRowList.addBig(
				new SliderPercentageOption("gui.config.chestplate_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.chestplateTexture(),
						(unused, newValue) -> Client_I.changeTypeChestplate(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(CHESTPLATE_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.chestplate_texture" ) + ": " + (int) option.get(gs)); }));
		
		this.optionsRowList.addBig(
				new SliderPercentageOption("gui.config.leggings_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.leggingsTexture(),
						(unused, newValue) -> Client_I.changeTypeLeggings(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(LEGGINGS_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.leggings_texture" ) + ": " + (int) option.get(gs)); }));
		
		this.optionsRowList.addBig(
				new SliderPercentageOption("gui.config.boots_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.bootsTexture(),
						(unused, newValue) -> Client_I.changeTypeBoots(newValue.intValue()),
						(gs, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(BOOTS_TOOLTIP, 200));
							return new StringTextComponent(I18n.get("gui.config.boots_texture" ) + ": " + (int) option.get(gs)); }));
			
		this.children.add(this.optionsRowList);

		this.addButton(new Button((this.width + BUTTONS_INTERVAL) / 2, this.height - BOTTOM_BUTTON_HEIGHT_OFFSET,
				BOTTOM_BUTTON_WIDTH, BUTTON_HEIGHT,
				new TranslationTextComponent("gui.config.chinjufumod.save"),
				button -> this.onClose()));
	}


	@Override
	public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		this.optionsRowList.render(matrixStack, mouseX, mouseY, partialTicks);
		drawCenteredString(matrixStack, this.font, this.title.getString(), this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
		super.render(matrixStack, mouseX, mouseY, partialTicks);

		List<IReorderingProcessor> list = SettingsScreen.tooltipAt(this.optionsRowList, mouseX, mouseY);
		if (list != null) {
			this.renderTooltip(matrixStack, list, mouseX, mouseY);
		}
	}

	@Override
	public void onClose() {
		CI.save();//セーブ
		Objects.requireNonNull(this.minecraft).setScreen(parentScreen);//戻る
	}

}
/*
public static final BooleanOption HIDE_MATCHED_NAMES = new BooleanOption("options.hideMatchedNames",
 new TranslationTextComponent("options.hideMatchedNames.tooltip"),
(p_244790_0_) -> { return p_244790_0_.hideMatchedNames; },
(p_244791_0_, p_244791_1_) -> { p_244791_0_.hideMatchedNames = p_244791_1_; }
);
*/
