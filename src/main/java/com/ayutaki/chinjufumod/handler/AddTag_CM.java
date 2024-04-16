package com.ayutaki.chinjufumod.handler;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddTag_CM {

	public static void register(DataGenerator generator, ExistingFileHelper helper) {
		generator.addProvider(new ModBiomeTagsProvider(generator, helper));
	}
 
	public static class ModBiomeTagsProvider extends BiomeTagsProvider {

		public ModBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
			super(generator, ChinjufuMod.MOD_ID, existingFileHelper);
		}

		@Override
		protected void addTags() {
			tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.SAKURA_FOREST_KEY);
			tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.SAKURA_HILLS_KEY);
			tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.KAEDE_FOREST_KEY);
			tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.KAEDE_HILLS_KEY);
			tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.ICHOH_FOREST_KEY);
			tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.ICHOH_HILLS_KEY);
		}
	}
}
