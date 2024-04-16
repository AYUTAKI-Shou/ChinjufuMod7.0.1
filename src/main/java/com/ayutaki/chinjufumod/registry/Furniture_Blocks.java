package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable;
import com.ayutaki.chinjufumod.blocks.furniture.LampHang;
import com.ayutaki.chinjufumod.blocks.furniture.LampMarine;
import com.ayutaki.chinjufumod.blocks.furniture.LightEmbed;
import com.ayutaki.chinjufumod.blocks.furniture.StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.StandBedroom;
import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.handler.BlockEntity_CM;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Furniture_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> DRESSINGTABLE = register("block_dressingtable", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_spruce = register("block_dressingtable_s", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_birch = register("block_dressingtable_b", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_jungle = register("block_dressingtable_j", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_acacia = register("block_dressingtable_a", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_darkoak = register("block_dressingtable_d", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_sakura = register("block_dressingtable_saku", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_kaede = register("block_dressingtable_kae", () -> dressingTable());
	public static final RegistryObject<Block> DRESSINGTABLE_ichoh = register("block_dressingtable_ich", () -> dressingTable());

	public static final RegistryObject<Block> CANDLE_white = register("block_candle_white", () -> candle());
	public static final RegistryObject<Block> CANDLE_orange = register("block_candle_orange", () -> candle());
	public static final RegistryObject<Block> CANDLE_magenta = register("block_candle_magenta", () -> candle());
	public static final RegistryObject<Block> CANDLE_lightb = register("block_candle_lightb", () -> candle());
	public static final RegistryObject<Block> CANDLE_yellow = register("block_candle_yellow", () -> candle());
	public static final RegistryObject<Block> CANDLE_lime = register("block_candle_lime", () -> candle());
	public static final RegistryObject<Block> CANDLE_pink = register("block_candle_pink", () -> candle());
	public static final RegistryObject<Block> CANDLE_gray = register("block_candle_gray", () -> candle());
	public static final RegistryObject<Block> CANDLE_lightg = register("block_candle_lightg", () -> candle());
	public static final RegistryObject<Block> CANDLE_cyan = register("block_candle_cyan", () -> candle());
	public static final RegistryObject<Block> CANDLE_purple = register("block_candle_purple", () -> candle());
	public static final RegistryObject<Block> CANDLE_blue = register("block_candle_blue", () -> candle());
	public static final RegistryObject<Block> CANDLE_brown = register("block_candle_brown", () -> candle());
	public static final RegistryObject<Block> CANDLE_green = register("block_candle_green", () -> candle());
	public static final RegistryObject<Block> CANDLE_red = register("block_candle_red", () -> candle());
	public static final RegistryObject<Block> CANDLE_black = register("block_candle_black", () -> candle());
	
	public static final RegistryObject<Block> LAMP = register("block_lamp", () -> new LampHang(lampState().lightLevel(litBlockEmission(15))));
	public static final RegistryObject<Block> STANDARM = register("block_standarm", () -> new StandArm(lampState().lightLevel(litBlockEmission(15))));
	public static final RegistryObject<Block> STAND = register("block_standbedroom", () -> new StandBedroom(lampState().lightLevel(litBlockEmission(15))));
	public static final RegistryObject<Block> M_LAMP = register("block_marinelamp", () -> new LampMarine(lampState().lightLevel(litBlockEmission(15))));
	public static final RegistryObject<Block> E_LIGHT = register("block_lightembed", () -> new LightEmbed(lampState().lightLevel(lightBlock(15))));

	public static final RegistryObject<Block> TANSU_OAK = register("block_tansu_oak", () -> tansu());
	public static final RegistryObject<Block> TANSU_SPRUCE = register("block_tansu_spruce", () -> tansu());
	public static final RegistryObject<Block> TANSU_BIRCH = register("block_tansu_birch", () -> tansu());
	public static final RegistryObject<Block> TANSU_JUNGLE = register("block_tansu_jungle", () -> tansu());
	public static final RegistryObject<Block> TANSU_ACACIA = register("block_tansu_acacia", () -> tansu());
	public static final RegistryObject<Block> TANSU_DOAK = register("block_tansu_doak", () -> tansu());
	public static final RegistryObject<Block> TANSU_SAKURA = register("block_tansu_sakura", () -> tansu());
	public static final RegistryObject<Block> TANSU_KAEDE = register("block_tansu_kaede", () -> tansu());
	public static final RegistryObject<Block> TANSU_ICHOH = register("block_tansu_ichoh", () -> tansu());

	
	/* Share variables */
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}
	
	private static ToIntFunction<BlockState> lightBlock(int value) {
		return (state) -> { return value; };
	}
	
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static DressingTable dressingTable() {
		return new DressingTable(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never));
	}
	
	private static Properties lampState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F, 2.0F).sound(SoundType.METAL).noOcclusion()
				.isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never);
	}
	
	private static Candle candle() {
		return new Candle(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never).lightLevel(litBlockEmission(13)));
	}
	
	private static Tansu tansu() {
		return new Tansu(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD), () -> { return BlockEntity_CM.TANSU.get(); });
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
