package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JPChair_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> ZABUTON_white = register("block_mzabuton_white", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_orange = register("block_mzabuton_orange", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_magenta = register("block_mzabuton_magenta", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_lightb = register("block_mzabuton_lightb", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_yellow = register("block_mzabuton_yellow", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_lime = register("block_mzabuton_lime", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_pink = register("block_mzabuton_pink", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_gray = register("block_mzabuton_gray", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_lightg = register("block_mzabuton_lightg", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_cyan = register("block_mzabuton_cyan", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_purple = register("block_mzabuton_purple", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_blue = register("block_mzabuton_blue", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_brown = register("block_mzabuton_brown", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_green = register("block_mzabuton_green", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_red = register("block_mzabuton_red", () -> zabuton());
	public static final RegistryObject<Block> ZABUTON_black = register("block_mzabuton_black", () -> zabuton());

	public static final RegistryObject<Block> WARAZABUTON = register("block_wara_zabuton", 
			() -> new Zabuton(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.GRASS).noOcclusion().isValidSpawn(JPChair_Blocks::neverEntity).isSuffocating(JPChair_Blocks::never)));

	public static final RegistryObject<Block> ZAISU_white = register("block_zaisu_white", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_orange = register("block_zaisu_orange", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_magenta = register("block_zaisu_magenta", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_lightb = register("block_zaisu_lightb", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_yellow = register("block_zaisu_yellow", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_lime = register("block_zaisu_lime", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_pink = register("block_zaisu_pink", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_gray = register("block_zaisu_gray", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_lightg = register("block_zaisu_lightg", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_cyan = register("block_zaisu_cyan", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_purple = register("block_zaisu_purple", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_blue = register("block_zaisu_blue", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_brown = register("block_zaisu_brown", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_green = register("block_zaisu_green", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_red = register("block_zaisu_red", () -> zaisu());
	public static final RegistryObject<Block> ZAISU_black = register("block_zaisu_black", () -> zaisu());
	
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static Zabuton zabuton() {
		return new Zabuton(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(1.0F, 1.0F).sound(SoundType.WOOL)
				.noOcclusion().isValidSpawn(JPChair_Blocks::neverEntity).isSuffocating(JPChair_Blocks::never));
	}

	private static Zaisu zaisu() {
		return new Zaisu(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(JPChair_Blocks::neverEntity).isSuffocating(JPChair_Blocks::never));
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
