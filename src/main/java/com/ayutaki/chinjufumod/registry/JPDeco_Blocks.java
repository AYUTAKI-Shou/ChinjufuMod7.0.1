package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furniture.Andon;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Large;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Small;
import com.ayutaki.chinjufumod.blocks.jpdeco.BambooCube;
import com.ayutaki.chinjufumod.blocks.jpdeco.BambooFence;
import com.ayutaki.chinjufumod.blocks.jpdeco.BambooFenceGate;
import com.ayutaki.chinjufumod.blocks.jpdeco.BambooPressurePlate;
import com.ayutaki.chinjufumod.blocks.jpdeco.BambooSlab;
import com.ayutaki.chinjufumod.blocks.jpdeco.BambooStairs;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Futon;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami_Y;
import com.ayutaki.chinjufumod.blocks.season.Door_CM;
import com.ayutaki.chinjufumod.blocks.season.TrapDoor_CM;
import com.ayutaki.chinjufumod.blocks.season.WoodButton_CM;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JPDeco_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> TATAMI_H = register("block_tatamih", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_white = register("block_tatamih_white", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_orange = register("block_tatamih_orange", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_magenta = register("block_tatamih_magenta", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_lightb = register("block_tatamih_lightb", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_yellow = register("block_tatamih_yellow", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_lime = register("block_tatamih_lime", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_pink = register("block_tatamih_pink", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_gray = register("block_tatamih_gray", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_lightg = register("block_tatamih_lightg", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_cyan = register("block_tatamih_cyan", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_purple = register("block_tatamih_purple", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_blue = register("block_tatamih_blue", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_brown = register("block_tatamih_brown", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_green = register("block_tatamih_green", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_red = register("block_tatamih_red", () -> tatami());
	public static final RegistryObject<Block> TATAMI_H_black = register("block_tatamih_black", () -> tatami());

	public static final RegistryObject<Block> TATAMI_HY = register("block_tatamih_y", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_white = register("block_tatamih_y_white", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_orange = register("block_tatamih_y_orange", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_magenta = register("block_tatamih_y_magenta", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_lightb = register("block_tatamih_y_lightb", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_yellow = register("block_tatamih_y_yellow", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_lime = register("block_tatamih_y_lime", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_pink = register("block_tatamih_y_pink", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_gray = register("block_tatamih_y_gray", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_lightg = register("block_tatamih_y_lightg", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_cyan = register("block_tatamih_y_cyan", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_purple = register("block_tatamih_y_purple", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_blue = register("block_tatamih_y_blue", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_brown = register("block_tatamih_y_brown", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_green = register("block_tatamih_y_green", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_red = register("block_tatamih_y_red", () -> tatamiY());
	public static final RegistryObject<Block> TATAMI_HY_black = register("block_tatamih_y_black", () -> tatamiY());

	public static final RegistryObject<Block> TAKECUBE = register("block_bamboo_cube", () -> bambooCube());
	public static final RegistryObject<Block> TAKECUBE_Y = register("block_bamboo_y_cube", () -> bambooCube());
	public static final RegistryObject<Block> TAKECUBE_K = register("block_bamboo_k_cube", () -> bambooCube());
	public static final RegistryObject<Block> TAKE_ST = register("block_bamboo_stairs", () -> bambooStairs());
	public static final RegistryObject<Block> TAKE_STY = register("block_bamboo_y_stairs", () -> bambooStairs());
	public static final RegistryObject<Block> TAKE_STK = register("block_bamboo_k_stairs", () -> bambooStairs());
	public static final RegistryObject<Block> TAKE_SH = register("block_bamboo_slab", () -> bambooSlab());
	public static final RegistryObject<Block> TAKE_SHY = register("block_bamboo_y_slab", () -> bambooSlab());
	public static final RegistryObject<Block> TAKE_SHK = register("block_bamboo_k_slab", () -> bambooSlab());

	public static final RegistryObject<Block> TAKEFENCE = register("block_bamboo_fence", () -> bambooFence());
	public static final RegistryObject<Block> TAKEFENCE_Y = register("block_bamboo_y_fence", () -> bambooFence());
	public static final RegistryObject<Block> TAKEFENCE_K = register("block_bamboo_k_fence", () -> bambooFence());
	public static final RegistryObject<Block> TAKEFENCEGATE = register("block_bamboo_fencegate", () -> bambooFenceGate(WoodType.BAMBOO));
	public static final RegistryObject<Block> TAKEFENCEGATE_Y = register("block_bamboo_y_fencegate", () -> bambooFenceGate(WoodType.BAMBOO));
	public static final RegistryObject<Block> TAKEFENCEGATE_K = register("block_bamboo_k_fencegate", () -> bambooFenceGate(WoodType.BAMBOO));
	public static final RegistryObject<Block> TAKEDOOR = register("block_bamboo_door", () -> bambooDoor(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKEDOOR_Y = register("block_bamboo_y_door", () -> bambooDoor(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKEDOOR_K = register("block_bamboo_k_door", () -> bambooDoor(BlockSetType.BAMBOO));

	public static final RegistryObject<Block> TAKE_TRAPDOOR = register("block_bamboo_trapdoor", () -> bambooTrapDoor(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_TRAPDOOR_Y = register("block_bamboo_y_trapdoor", () -> bambooTrapDoor(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_TRAPDOOR_K = register("block_bamboo_k_trapdoor", () -> bambooTrapDoor(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_PLATE = register("block_bamboo_plate", () -> bambooPressurePlate(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_PLATE_Y = register("block_bamboo_y_plate", () -> bambooPressurePlate(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_PLATE_K = register("block_bamboo_k_plate", () -> bambooPressurePlate(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_BUTTON = register("block_bamboo_button", () -> bambooButton(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_BUTTON_Y = register("block_bamboo_y_button", () -> bambooButton(BlockSetType.BAMBOO));
	public static final RegistryObject<Block> TAKE_BUTTON_K = register("block_bamboo_k_button", () -> bambooButton(BlockSetType.BAMBOO));
	
	public static final RegistryObject<Block> ANDON_white = register("block_andon_white", () -> andon());
	public static final RegistryObject<Block> ANDON_orange = register("block_andon_orange", () -> andon());
	public static final RegistryObject<Block> ANDON_magenta = register("block_andon_magenta", () -> andon());
	public static final RegistryObject<Block> ANDON_lightb = register("block_andon_lightb", () -> andon());
	public static final RegistryObject<Block> ANDON_yellow = register("block_andon_yellow", () -> andon());
	public static final RegistryObject<Block> ANDON_lime = register("block_andon_lime", () -> andon());
	public static final RegistryObject<Block> ANDON_pink = register("block_andon_pink", () -> andon());
	public static final RegistryObject<Block> ANDON_gray = register("block_andon_gray", () -> andon());
	public static final RegistryObject<Block> ANDON_lightg = register("block_andon_lightg", () -> andon());
	public static final RegistryObject<Block> ANDON_cyan = register("block_andon_cyan", () -> andon());
	public static final RegistryObject<Block> ANDON_purple = register("block_andon_purple", () -> andon());
	public static final RegistryObject<Block> ANDON_blue = register("block_andon_blue", () -> andon());
	public static final RegistryObject<Block> ANDON_brown = register("block_andon_brown", () -> andon());
	public static final RegistryObject<Block> ANDON_green = register("block_andon_green", () -> andon());
	public static final RegistryObject<Block> ANDON_red = register("block_andon_red", () -> andon());
	public static final RegistryObject<Block> ANDON_black = register("block_andon_black", () -> andon());

	public static final RegistryObject<Block> FUTON_white = register("block_futon_c_white", () -> futon());
	public static final RegistryObject<Block> FUTON_orange = register("block_futon_c_orange", () -> futon());
	public static final RegistryObject<Block> FUTON_magenta = register("block_futon_c_magenta", () -> futon());
	public static final RegistryObject<Block> FUTON_lightb = register("block_futon_c_lightb", () -> futon());
	public static final RegistryObject<Block> FUTON_yellow = register("block_futon_c_yellow", () -> futon());
	public static final RegistryObject<Block> FUTON_lime = register("block_futon_c_lime", () -> futon());
	public static final RegistryObject<Block> FUTON_pink = register("block_futon_c_pink", () -> futon());
	public static final RegistryObject<Block> FUTON_gray = register("block_futon_c_gray", () -> futon());
	public static final RegistryObject<Block> FUTON_lightg = register("block_futon_c_lightg", () -> futon());
	public static final RegistryObject<Block> FUTON_cyan = register("block_futon_c_cyan", () -> futon());
	public static final RegistryObject<Block> FUTON_purple = register("block_futon_c_purple", () -> futon());
	public static final RegistryObject<Block> FUTON_blue = register("block_futon_c_blue", () -> futon());
	public static final RegistryObject<Block> FUTON_brown = register("block_futon_c_brown", () -> futon());
	public static final RegistryObject<Block> FUTON_green = register("block_futon_c_green", () -> futon());
	public static final RegistryObject<Block> FUTON_red = register("block_futon_c_red", () -> futon());
	public static final RegistryObject<Block> FUTON_black = register("block_futon_c_black", () -> futon());

	public static final RegistryObject<Block> WADAIKO = register("block_wadaiko", 
			() -> new Wadaiko_Large(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never)));
	public static final RegistryObject<Block> WADAIKO_small = register("block_wadaiko_small", 
			() -> new Wadaiko_Small(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never)));

	
	/* Share variables */
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}
	
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static boolean neverTatami(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.getValue(BaseTatami.TYPE) != TatamiType.BOTTOM && state.getValue(BaseTatami.TYPE) != TatamiType.TOP)? true : false;
	}

	private static Boolean neverEntityTatami(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(BaseTatami.TYPE) == TatamiType.BOTTOM)? (boolean)false : (boolean)true;
	}
	
	private static boolean neverSlab(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.getValue(BambooSlab.TYPE) == SlabType.DOUBLE)? true : false;
	}

	private static Boolean neverEntitySlab(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(BambooSlab.TYPE) == SlabType.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Boolean neverEntityStairs(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(BambooStairs.TYPE) == Half.BOTTOM)? (boolean)false : (boolean)true;
	}
	
	private static Properties tatamiState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.GRASS)
				.isValidSpawn(JPDeco_Blocks::neverEntityTatami).isSuffocating(JPDeco_Blocks::neverTatami);
	}
	
	private static Tatami tatami() {
		return new Tatami(tatamiState());
	}

	private static Tatami_Y tatamiY() {
		return new Tatami_Y(tatamiState());
	}

	private static Properties woodState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD);
	}

	private static BambooCube bambooCube() {
		return new BambooCube(woodState().noOcclusion());
	}

	private static BambooStairs bambooStairs() {
		return new BambooStairs(TAKECUBE.get().defaultBlockState(), woodState().noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntityStairs).isSuffocating(JPDeco_Blocks::never));
	}

	private static BambooSlab bambooSlab() {
		return new BambooSlab(woodState().noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntitySlab).isSuffocating(JPDeco_Blocks::neverSlab));
	}

	private static BambooFence bambooFence() {
		return new BambooFence(woodState().noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never));
	}

	private static BambooFenceGate bambooFenceGate(WoodType type) {
		return new BambooFenceGate(woodState().noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never), type);
	}

	private static Door_CM bambooDoor(BlockSetType type) {
		return new Door_CM(woodState().noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never), type);
	}

	private static TrapDoor_CM bambooTrapDoor(BlockSetType type) {
		return new TrapDoor_CM(woodState().noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never), type);
	}

	private static BambooPressurePlate bambooPressurePlate(BlockSetType type) {
		return new BambooPressurePlate(BambooPressurePlate.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never), type);
	}

	private static WoodButton_CM bambooButton(BlockSetType type) {
		return new WoodButton_CM(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never), type, 30, true);
	}

	private static Andon andon() {
		return new Andon(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never).lightLevel(litBlockEmission(14)));
	}

	private static Futon futon() {
		return new Futon(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(1.0F, 1.0F).sound(SoundType.WOOL)
				.noOcclusion().isValidSpawn(JPDeco_Blocks::neverEntity).isSuffocating(JPDeco_Blocks::never));
	}


	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
