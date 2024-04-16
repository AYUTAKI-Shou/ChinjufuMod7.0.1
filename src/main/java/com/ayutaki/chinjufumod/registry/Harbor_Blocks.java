package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.harbor.Keikai;
import com.ayutaki.chinjufumod.blocks.harbor.Keiryu;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Harbor_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block KEIKAIBLOCK = register("block_keikai", new Keikai(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 6.0F).sound(SoundType.STONE).notSolid()));

	public static Block KEIRYUKUI = register("block_keiryukui", keiryu());
	public static Block KEIRYUKUI_b = register("block_keiryukui_b", keiryu());

	public static Block TRUSS = register("block_ctruss", truss());
	public static Block TRUSS_white = register("block_ctruss_white", truss());
	public static Block TRUSS_orange = register("block_ctruss_orange", truss());
	public static Block TRUSS_magenta = register("block_ctruss_magenta", truss());
	public static Block TRUSS_lightb = register("block_ctruss_lightb", truss());
	public static Block TRUSS_yellow = register("block_ctruss_yellow", truss());
	public static Block TRUSS_lime = register("block_ctruss_lime", truss());
	public static Block TRUSS_pink = register("block_ctruss_pink", truss());
	public static Block TRUSS_gray = register("block_ctruss_gray", truss());
	public static Block TRUSS_cyan = register("block_ctruss_cyan", truss());
	public static Block TRUSS_purple = register("block_ctruss_purple", truss());
	public static Block TRUSS_blue = register("block_ctruss_blue", truss());
	public static Block TRUSS_brown = register("block_ctruss_brown", truss());
	public static Block TRUSS_green = register("block_ctruss_green", truss());
	public static Block TRUSS_red = register("block_ctruss_red", truss());
	public static Block TRUSS_black = register("block_ctruss_black", truss());

	/* Share variables */
	private static CTruss truss() {
		return new CTruss(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.METAL).notSolid());
	}

	private static Keiryu keiryu() {
		return new Keiryu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 6.0F).sound(SoundType.METAL).notSolid());
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
