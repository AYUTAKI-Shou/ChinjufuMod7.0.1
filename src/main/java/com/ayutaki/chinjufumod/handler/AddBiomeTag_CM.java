package com.ayutaki.chinjufumod.handler;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.world.biome.BiomeKey_CM;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddBiomeTag_CM extends BiomeTagsProvider {

	public AddBiomeTag_CM(PackOutput outPut, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
		super(outPut, provider, ChinjufuMod.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(BiomeTags.IS_OVERWORLD).add(BiomeKey_CM.SAKURA_FOREST_KEY, BiomeKey_CM.SAKURA_HILLS_KEY,
				BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.KAEDE_HILLS_KEY, BiomeKey_CM.KAEDE_FORESTB_KEY, BiomeKey_CM.KAEDE_HILLSB_KEY, 
				BiomeKey_CM.ICHOH_FOREST_KEY, BiomeKey_CM.ICHOH_HILLS_KEY, BiomeKey_CM.ICHOH_FORESTB_KEY, BiomeKey_CM.ICHOH_HILLSB_KEY);
		
		tag(BiomeTags.IS_FOREST).add(BiomeKey_CM.SAKURA_FOREST_KEY, BiomeKey_CM.SAKURA_HILLS_KEY,
				BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.KAEDE_HILLS_KEY, BiomeKey_CM.KAEDE_FORESTB_KEY, BiomeKey_CM.KAEDE_HILLSB_KEY, 
				BiomeKey_CM.ICHOH_FOREST_KEY, BiomeKey_CM.ICHOH_HILLS_KEY, BiomeKey_CM.ICHOH_FORESTB_KEY, BiomeKey_CM.ICHOH_HILLSB_KEY);
		
		tag(BiomeTags.IS_HILL).add(BiomeKey_CM.SAKURA_HILLS_KEY,
				BiomeKey_CM.KAEDE_HILLS_KEY, BiomeKey_CM.KAEDE_HILLSB_KEY, 
				BiomeKey_CM.ICHOH_HILLS_KEY, BiomeKey_CM.ICHOH_HILLSB_KEY);
		
		tag(BiomeTags.HAS_VILLAGE_PLAINS).add(BiomeKey_CM.SAKURA_FOREST_KEY,
				BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.KAEDE_FORESTB_KEY,
				BiomeKey_CM.ICHOH_FOREST_KEY, BiomeKey_CM.ICHOH_FORESTB_KEY);

	}
}
