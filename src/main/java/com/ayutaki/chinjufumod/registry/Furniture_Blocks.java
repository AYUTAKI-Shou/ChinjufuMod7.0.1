package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable;
import com.ayutaki.chinjufumod.blocks.furniture.LampHang;
import com.ayutaki.chinjufumod.blocks.furniture.LampMarine;
import com.ayutaki.chinjufumod.blocks.furniture.LightEmbed;
import com.ayutaki.chinjufumod.blocks.furniture.StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.StandBedroom;
import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.handler.TileEntity_CM;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Furniture_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block DRESSINGTABLE = register("block_dressingtable", dressingTable());
	public static Block DRESSINGTABLE_spruce = register("block_dressingtable_s", dressingTable());
	public static Block DRESSINGTABLE_birch = register("block_dressingtable_b", dressingTable());
	public static Block DRESSINGTABLE_jungle = register("block_dressingtable_j", dressingTable());
	public static Block DRESSINGTABLE_acacia = register("block_dressingtable_a", dressingTable());
	public static Block DRESSINGTABLE_darkoak = register("block_dressingtable_d", dressingTable());
	public static Block DRESSINGTABLE_sakura = register("block_dressingtable_saku", dressingTable());
	public static Block DRESSINGTABLE_kaede = register("block_dressingtable_kae", dressingTable());
	public static Block DRESSINGTABLE_ichoh = register("block_dressingtable_ich", dressingTable());

	public static Block LAMP = register("block_lamp", new LampHang(lampState()));
	public static Block STANDARM = register("block_standarm", new StandArm(lampState()));
	public static Block STAND = register("block_standbedroom", new StandBedroom(lampState()));
	public static Block M_LAMP = register("block_marinelamp", new LampMarine(lampState()));
	public static Block E_LIGHT = register("block_lightembed", new LightEmbed(lampState()));
	
	public static Block CANDLE_white = register("block_candle_white", candle());
	public static Block CANDLE_orange = register("block_candle_orange", candle());
	public static Block CANDLE_magenta = register("block_candle_magenta", candle());
	public static Block CANDLE_lightb = register("block_candle_lightb", candle());
	public static Block CANDLE_yellow = register("block_candle_yellow", candle());
	public static Block CANDLE_lime = register("block_candle_lime", candle());
	public static Block CANDLE_pink = register("block_candle_pink", candle());
	public static Block CANDLE_gray = register("block_candle_gray", candle());
	public static Block CANDLE_lightg = register("block_candle_lightg", candle());
	public static Block CANDLE_cyan = register("block_candle_cyan", candle());
	public static Block CANDLE_purple = register("block_candle_purple", candle());
	public static Block CANDLE_blue = register("block_candle_blue", candle());
	public static Block CANDLE_brown = register("block_candle_brown", candle());
	public static Block CANDLE_green = register("block_candle_green", candle());
	public static Block CANDLE_red = register("block_candle_red", candle());
	public static Block CANDLE_black = register("block_candle_black", candle());

	public static Block TANSU_OAK = register("block_tansu_oak", tansu());
	public static Block TANSU_SPRUCE = register("block_tansu_spruce", tansu());
	public static Block TANSU_BIRCH = register("block_tansu_birch", tansu());
	public static Block TANSU_JUNGLE = register("block_tansu_jungle", tansu());
	public static Block TANSU_ACACIA = register("block_tansu_acacia", tansu());
	public static Block TANSU_DOAK = register("block_tansu_doak", tansu());
	public static Block TANSU_SAKURA = register("block_tansu_sakura", tansu());
	public static Block TANSU_KAEDE = register("block_tansu_kaede", tansu());
	public static Block TANSU_ICHOH = register("block_tansu_ichoh", tansu());

	/* Share variables */
	private static Candle candle() {
		return new Candle(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).notSolid());
	}

	private static DressingTable dressingTable() {
		return new DressingTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Tansu tansu() {
		return new Tansu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD), () -> { return TileEntity_CM.TANSU; });
	}
	
	private static Properties lampState() {
		return Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F, 2.0F).sound(SoundType.METAL).notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
