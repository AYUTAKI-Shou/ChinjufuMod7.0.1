package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JPChair_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block ZABUTON_white = register("block_mzabuton_white", zabuton());
	public static Block ZABUTON_orange = register("block_mzabuton_orange", zabuton());
	public static Block ZABUTON_magenta = register("block_mzabuton_magenta", zabuton());
	public static Block ZABUTON_lightb = register("block_mzabuton_lightb", zabuton());
	public static Block ZABUTON_yellow = register("block_mzabuton_yellow", zabuton());
	public static Block ZABUTON_lime = register("block_mzabuton_lime", zabuton());
	public static Block ZABUTON_pink = register("block_mzabuton_pink", zabuton());
	public static Block ZABUTON_gray = register("block_mzabuton_gray", zabuton());
	public static Block ZABUTON_lightg = register("block_mzabuton_lightg", zabuton());
	public static Block ZABUTON_cyan = register("block_mzabuton_cyan", zabuton());
	public static Block ZABUTON_purple = register("block_mzabuton_purple", zabuton());
	public static Block ZABUTON_blue = register("block_mzabuton_blue", zabuton());
	public static Block ZABUTON_brown = register("block_mzabuton_brown", zabuton());
	public static Block ZABUTON_green = register("block_mzabuton_green", zabuton());
	public static Block ZABUTON_red = register("block_mzabuton_red", zabuton());
	public static Block ZABUTON_black = register("block_mzabuton_black", zabuton());

	public static Block WARAZABUTON = register("block_wara_zabuton", new Zabuton(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.CROP).notSolid()));

	public static Block ZAISU_white = register("block_zaisu_white", zaisu());
	public static Block ZAISU_orange = register("block_zaisu_orange", zaisu());
	public static Block ZAISU_magenta = register("block_zaisu_magenta", zaisu());
	public static Block ZAISU_lightb = register("block_zaisu_lightb", zaisu());
	public static Block ZAISU_yellow = register("block_zaisu_yellow", zaisu());
	public static Block ZAISU_lime = register("block_zaisu_lime", zaisu());
	public static Block ZAISU_pink = register("block_zaisu_pink", zaisu());
	public static Block ZAISU_gray = register("block_zaisu_gray", zaisu());
	public static Block ZAISU_lightg = register("block_zaisu_lightg", zaisu());
	public static Block ZAISU_cyan = register("block_zaisu_cyan", zaisu());
	public static Block ZAISU_purple = register("block_zaisu_purple", zaisu());
	public static Block ZAISU_blue = register("block_zaisu_blue", zaisu());
	public static Block ZAISU_brown = register("block_zaisu_brown", zaisu());
	public static Block ZAISU_green = register("block_zaisu_green", zaisu());
	public static Block ZAISU_red = register("block_zaisu_red", zaisu());
	public static Block ZAISU_black = register("block_zaisu_black", zaisu());

	/* Share variables */
	private static Zabuton zabuton() {
		return new Zabuton(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.CLOTH).notSolid());
	}

	private static Zaisu zaisu() {
		return new Zaisu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
