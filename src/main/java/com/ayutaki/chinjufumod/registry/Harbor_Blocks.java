package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.harbor.Keikai;
import com.ayutaki.chinjufumod.blocks.harbor.Keiryu;

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

public class Harbor_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> KEIKAIBLOCK = register("block_keikai", 
			() -> new Keikai(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F, 6.0F).sound(SoundType.STONE).noOcclusion().isValidSpawn(Harbor_Blocks::neverEntity).isSuffocating(Harbor_Blocks::never)));

	public static final RegistryObject<Block> KEIRYUKUI = register("block_keiryukui", () -> keiryu());
	public static final RegistryObject<Block> KEIRYUKUI_b = register("block_keiryukui_b", () -> keiryu());

	public static final RegistryObject<Block> TRUSS = register("block_ctruss", () -> truss());
	public static final RegistryObject<Block> TRUSS_white = register("block_ctruss_white", () -> truss());
	public static final RegistryObject<Block> TRUSS_orange = register("block_ctruss_orange", () -> truss());
	public static final RegistryObject<Block> TRUSS_magenta = register("block_ctruss_magenta", () -> truss());
	public static final RegistryObject<Block> TRUSS_lightb = register("block_ctruss_lightb", () -> truss());
	public static final RegistryObject<Block> TRUSS_yellow = register("block_ctruss_yellow", () -> truss());
	public static final RegistryObject<Block> TRUSS_lime = register("block_ctruss_lime", () -> truss());
	public static final RegistryObject<Block> TRUSS_pink = register("block_ctruss_pink", () -> truss());
	public static final RegistryObject<Block> TRUSS_gray = register("block_ctruss_gray", () -> truss());
	public static final RegistryObject<Block> TRUSS_cyan = register("block_ctruss_cyan", () -> truss());
	public static final RegistryObject<Block> TRUSS_purple = register("block_ctruss_purple", () -> truss());
	public static final RegistryObject<Block> TRUSS_blue = register("block_ctruss_blue", () -> truss());
	public static final RegistryObject<Block> TRUSS_brown = register("block_ctruss_brown", () -> truss());
	public static final RegistryObject<Block> TRUSS_green = register("block_ctruss_green", () -> truss());
	public static final RegistryObject<Block> TRUSS_red = register("block_ctruss_red", () -> truss());
	public static final RegistryObject<Block> TRUSS_black = register("block_ctruss_black", () -> truss());
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static CTruss truss() {
		return new CTruss(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL)
				.noOcclusion().isValidSpawn(Harbor_Blocks::neverEntity).isSuffocating(Harbor_Blocks::never));
	}
	
	private static Keiryu keiryu() {
		return new Keiryu(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL)
				.noOcclusion().isValidSpawn(Harbor_Blocks::neverEntity).isSuffocating(Harbor_Blocks::never));
	}
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
