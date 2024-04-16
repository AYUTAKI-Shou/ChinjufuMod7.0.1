package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.pantry.CanTea;
import com.ayutaki.chinjufumod.blocks.pantry.Chadutsu;
import com.ayutaki.chinjufumod.blocks.pantry.Pantry_Box;
import com.ayutaki.chinjufumod.blocks.pantry.Pantry_Empty;
import com.ayutaki.chinjufumod.blocks.pantry.Pantry_Sack;
import com.ayutaki.chinjufumod.blocks.pantry.Tawara;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Pantry_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> BOX_H_EMPTY = register("block_boxh_empty", () -> new Pantry_Empty(baseState().sound(SoundType.WOOD).isSuffocating(Pantry_Blocks::never)));
	public static final RegistryObject<Block> BOX_H_EMPTY2 = register("block_boxh_empty2", () -> new Pantry_Empty(baseState().sound(SoundType.WOOD).isSuffocating(Pantry_Blocks::never)));
	public static final RegistryObject<Block> BOX_H_EMPTY3 = register("block_boxh_empty3", () -> new Pantry_Empty(baseState().sound(SoundType.GRASS).isSuffocating(Pantry_Blocks::never)));

	public static final RegistryObject<Block> BOX_H_APPLE = register("block_boxh_apple", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_BEEF = register("block_boxh_beef", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_BEETROOT = register("block_boxh_beetroot", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_BREAD = register("block_boxh_bread", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_CARROT = register("block_boxh_carrot", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_CHICKEN = register("block_boxh_chicken", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_CHORUS = register("block_boxh_chorus", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_COCO = register("block_boxh_coco", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_COD = register("block_boxh_cod", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_EGG = register("block_boxh_egg", () -> pantryBox());

	public static final RegistryObject<Block> BOX_H_FISH = register("block_boxh_fish", () -> pantryBox());

	public static final RegistryObject<Block> BOX_H_FLOUR = register("block_boxh_flour", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_MUTTON = register("block_boxh_mutton", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_PORK = register("block_boxh_pork", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_POTATO = register("block_boxh_potato", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_RABBIT = register("block_boxh_rabbit", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_SALMON = register("block_boxh_salmon", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_SWBERRY = register("block_boxh_swberry", () -> pantryBox());

	public static final RegistryObject<Block> BOX_H_CABBAGE = register("block_boxh_cabbage", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_HAKUSAI = register("block_boxh_hakusai", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_CHERRY = register("block_boxh_cherry", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_CITRUS = register("block_boxh_citrus", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_CORN = register("block_boxh_corn", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_GRAPE = register("block_boxh_grape", () -> pantryBox());
	/** 6.4.1 **/ public static final RegistryObject<Block> BOX_H_GREENONION = register("block_boxh_greenonion", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_ONION = register("block_boxh_onion", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_RICE = register("block_boxh_rice", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_SOY = register("block_boxh_soy", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_SPINACH = register("block_boxh_spinach", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_TOMATO = register("block_boxh_tomato", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_TAKENOKO = register("block_boxh_takenoko", () -> pantryBox());
	public static final RegistryObject<Block> BOX_H_KURI = register("block_boxh_chestnut", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_TGREEN = register("block_boxh_tgreen", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_TRED = register("block_boxh_tred", () -> pantrySack());

	public static final RegistryObject<Block> BOX_H_BPEPPER = register("block_boxh_bpepper", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_CUMIN = register("block_boxh_cumin", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_TURMERIC = register("block_boxh_turmeric", () -> pantrySack());
	public static final RegistryObject<Block> BOX_H_CHILI = register("block_boxh_chili", () -> pantrySack());
	
	public static final RegistryObject<Block> CHADUTSU = register("block_tea_chadutsu", () -> new Chadutsu(baseState().sound(SoundType.STONE).isSuffocating(Pantry_Blocks::never)));
	public static final RegistryObject<Block> CANTEA = register("block_tea_can", () -> new CanTea(baseState().sound(SoundType.STONE).isSuffocating(Pantry_Blocks::never)));
	public static final RegistryObject<Block> TAWARA = register("block_tawara_cm", () -> new Tawara(baseState().sound(SoundType.GRASS)));
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties baseState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).noOcclusion().isValidSpawn(Pantry_Blocks::neverEntity);
	}
	
	private static Pantry_Box pantryBox() {
		return new Pantry_Box(baseState().sound(SoundType.WOOD));
	}

	private static Pantry_Sack pantrySack() {
		return new Pantry_Sack(baseState().sound(SoundType.GRASS));
	}
	

	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
