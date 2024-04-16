package com.ayutaki.chinjufumod.gui;

import java.util.Objects;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ConfigClient_CM;
import com.ayutaki.chinjufumod.Config_CM;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen extends Screen {

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

	public ConfigScreen(Screen parentScreen) {
		super(new TranslationTextComponent("gui.config.chinjufumod.title", ChinjufuMod.MOD_ID + "_15.2"));
		this.parentScreen = parentScreen;
	}

	//private static final ITextComponent BAUXITECHANCE_TOOLTIP = new TranslationTextComponent("gui.config.bauxiteore.chance.tooltip");
	//private static final ITextComponent BIOMECHANCE_TOOLTIP = new TranslationTextComponent("gui.config.biomechance.tooltip");
	//private static final ITextComponent TREECHANCE_TOOLTIP = new TranslationTextComponent("gui.config.treechance.tooltip");

	@Override
	protected void init() {
		this.optionsRowList = new OptionsRowList(Objects.requireNonNull(this.minecraft), this.width, this.height,
				OPTIONS_LIST_TOP_HEIGHT, this.height - OPTIONS_LIST_BOTTOM_OFFSET, OPTIONS_LIST_ITEM_HEIGHT);

		/* Blast net.minecraft.client.AbstractOption*/
		this.optionsRowList.addOption(new BooleanOption("gui.config.blastblockbreak",
				//new TranslationTextComponent("gui.config.blastblockbreak.tooltip"),
				unused -> CI.blastBlockBreak(), (unused, newValue) -> CI.changeBlastBlockBreak(newValue)));

		/* Anti Shadow */
		this.optionsRowList.addOption(new BooleanOption("gui.config.antishadow",
				//new TranslationTextComponent("gui.config.antishadow.tooltip"),
				unused -> CI.antiShadow(), (unused, newValue) -> CI.changeAntiShadow(newValue)));

		/* Bauxite */
		this.optionsRowList.addOption(new BooleanOption("gui.config.bauxiteore.gene",
				//new TranslationTextComponent("gui.config.bauxiteore.gene.tooltip"),
				unused -> CI.bauxiteGene(), (unused, newValue) -> CI.changeBauxiteGene(newValue)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.bauxiteore.chance", 1.0D, 100.0D, 1.0F,
						(unused) -> (double) CI.bauxiteChance(),
						(unused, newValue) -> CI.changeBauxiteChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));

		/* SAKURA */
		this.optionsRowList.addOption(new BooleanOption("gui.config.cherrybiome.gene",
				//new TranslationTextComponent("gui.config.cherrybiome.gene.tooltip"),
				unused -> CI.sakuraBiomeGene(), (unused, newValue) -> CI.changeSakuraBiomeGene(newValue)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.cherrybiome.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.sakuraBiomeChance(),
						(unused, newValue) -> CI.changeSakuraBiomeChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)),

				new SliderPercentageOption("gui.config.cherrytree.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.sakuraTreeChance(),
						(unused, newValue) -> CI.changeSakuraTreeChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));

		/* KAEDE */
		this.optionsRowList.addOption(new BooleanOption("gui.config.acerbiome.gene",
				//new TranslationTextComponent("gui.config.acerbiome.gene.tooltip"),
				unused -> CI.kaedeBiomeGene(), (unused, newValue) -> CI.changeKaedeBiomeGene(newValue)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.acerbiome.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.kaedeBiomeChance(),
						(unused, newValue) -> CI.changeKaedeBiomeChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)),

				new SliderPercentageOption("gui.config.acertree.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.kaedeTreeChance(),
						(unused, newValue) -> CI.changeKaedeTreeChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));

		/* ICHOH */
		this.optionsRowList.addOption(new BooleanOption("gui.config.ginkgobiome.gene",
				//new TranslationTextComponent("gui.config.ginkgobiome.gene.tooltip"),
				unused -> CI.ichohBiomeGene(), (unused, newValue) -> CI.changeIchohBiomeGene(newValue)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.ginkgobiome.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.ichohBiomeChance(),
						(unused, newValue) -> CI.changeIchohBiomeChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)),

				new SliderPercentageOption("gui.config.ginkgotree.chance", 1.0D, 9.0D, 1.0F,
						(unused) -> (double) CI.ichohTreeChance(),
						(unused, newValue) -> CI.changeIchohTreeChance(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));

		/** KURI **/
		this.optionsRowList.addOption(new BooleanOption("gui.config.chestnutsfall",
				//new TranslationTextComponent("gui.config.chestnutsfall.tooltip"),
				unused -> CI.chestnutsFall(), (unused, newValue) -> CI.changeChestnutsFall(newValue)));
		
		/** Low Sound **/
		this.optionsRowList.addOption(new BooleanOption("gui.config.lowsound",
				//new TranslationTextComponent("gui.config.lowsound.tooltip"),
				unused -> CI.lowSound(), (unused, newValue) -> CI.changeLowSound(newValue)));
		
		/* MAKIMONO */
		this.optionsRowList.addOption(new BooleanOption("gui.config.usemakimono",
				//new TranslationTextComponent("gui.config.usemakimono.tooltip"),
				unused -> CI.useMAKIMONO(), (unused, newValue) -> CI.changeUseMAKIMONO(newValue)));
		
		/** Costume **/
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.helmet_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.helmetTexture(),
						(unused, newValue) -> Client_I.changeTypeHelmet(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.chestplate_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.chestplateTexture(),
						(unused, newValue) -> Client_I.changeTypeChestplate(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.leggings_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.leggingsTexture(),
						(unused, newValue) -> Client_I.changeTypeLeggings(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));
		
		this.optionsRowList.addOption(
				new SliderPercentageOption("gui.config.boots_texture", 0.0D, 2.0D, 1.0F,
						(unused) -> (double) Client_I.bootsTexture(),
						(unused, newValue) -> Client_I.changeTypeBoots(newValue.intValue()),
						(gs, option) -> option.getDisplayString() + (int) option.get(gs)));

		
		this.children.add(this.optionsRowList);
		
		this.addButton(new Button((this.width + BUTTONS_INTERVAL) / 2, this.height - BOTTOM_BUTTON_HEIGHT_OFFSET,
				BOTTOM_BUTTON_WIDTH, BUTTON_HEIGHT,
				I18n.format("gui.config.chinjufumod.save"),
				button -> this.onClose()));
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		this.optionsRowList.render(mouseX, mouseY, partialTicks);
		this.drawCenteredString(this.font, this.title.getFormattedText(), this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
		super.render(mouseX, mouseY, partialTicks);
	}

	@Override
	public void onClose() {
		CI.save();//セーブ
		Objects.requireNonNull(this.minecraft).displayGuiScreen(parentScreen);//戻る
	}

}
