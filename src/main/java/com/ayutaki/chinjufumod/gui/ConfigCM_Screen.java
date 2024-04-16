package com.ayutaki.chinjufumod.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.Config_CM;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigCM_Screen implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) { }

	@Override
	public boolean hasConfigGui() {
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) {
		return new ChinjufuModConfigGui(parentScreen);
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	public static class ChinjufuModConfigGui extends GuiConfig {

		public boolean needsRefresh = true;

		public ChinjufuModConfigGui(GuiScreen parent) {

			super(parent, getConfigElements(), ChinjufuMod.MOD_ID, false, false, ChinjufuMod.MOD_NAME);
		}
		
		private static List<IConfigElement> getConfigElements() {
			final List<IConfigElement> list = new ArrayList<>();

			list.addAll(new ConfigElement(Config_CM.config.getCategory(Config_CM.GENERAL)).getChildElements());
			list.addAll(new ConfigElement(Config_CM.config.getCategory(Config_CM.CLIENT)).getChildElements());

			return list;
		}
	}
}
