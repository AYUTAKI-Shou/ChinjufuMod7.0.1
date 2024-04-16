package com.ayutaki.chinjufumod.registry;

import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Board;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Duct;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Ductend;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Kanki;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Sink;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaChawan_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDonburi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSara_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaShikki_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSushiGeta_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTcup_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTonsui_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaYunomi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen;
import com.ayutaki.chinjufumod.blocks.kitchen.Reizou;
import com.ayutaki.chinjufumod.blocks.kitchen.ReizouTop;
import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.TileEntity_CM;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Kitchen_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block KITCHEN = register("block_kitchen", new Kitchen(woodState()));
	public static Block KIT_BOARD = register("block_kit_board", new Kit_Board(woodState()));
	public static Block KIT_SINK = register("block_kit_sink", new Kit_Sink(woodState().randomTicks()));
	public static Block KIT_COOKTOP = register("block_kit_stove", new Kit_Cooktop(woodState().lightLevel(litCooktop(14))));
	
	public static Block KIT_OVEN = register("block_kit_oven", new Kitchen_Oven(ovenState().lightLevel(litBlockEmission(14))));
	public static Block KIT_OVEN_B = register("block_kit_oven_black", new Kitchen_Oven_B(ovenState().lightLevel(litBlockEmission(14))));
	public static Block IRORI = register("block_irori", new Irori(ovenState().randomTicks().lightLevel(litIrori(14, 12))));
	public static Block KIT_REIZOU = register("block_kit_reizou", reizou());
	public static Block KIT_REIZOU_TOP = register("block_kit_reizou_top", reizouTop());

	public static Block KIT_KANKI_1 = register("block_kit_kanki", new Kit_Kanki(metalState()));
	public static Block KIT_HAIKIDUCT = register("block_kit_duct", new Kit_Duct(metalState()));
	public static Block KIT_DUCTEND_1 = register("block_kit_ductend", new Kit_Ductend(metalState()));

	public static Block KIT_TANA = register("block_kit_tana", new Kit_Tana(woodState()));
	public static Block KIT_CHAWAN1 = register("block_kit_chawan1", new Kit_TanaChawan_1(woodState()));
	public static Block KIT_SHIKKI1 = register("block_kit_shikki1", new Kit_TanaShikki_1(woodState()));
	public static Block KIT_SARA1 = register("block_kit_sara1", new Kit_TanaSara_1(woodState()));
	public static Block KIT_TONSUI1 = register("block_kit_tonsui1", new Kit_TanaTonsui_1(woodState()));
	public static Block KIT_YUNOMI1 = register("block_kit_yunomi1", new Kit_TanaYunomi_1(woodState()));
	public static Block KIT_TCUP1 = register("block_kit_tcup1", new Kit_TanaTcup_1(woodState()));
	public static Block KIT_DRINKGLASS1 = register("block_kit_driglass1", new Kit_TanaDrinkglass_1(woodState()));
	public static Block KIT_DONBURI1 = register("block_kit_donburi1", new Kit_TanaDonburi_1(woodState()));
	public static Block KIT_SUSHIGETA1 = register("block_kit_sushigeta1", new Kit_TanaSushiGeta_1(woodState()));
	public static Block USU_TSUKI = register("block_usutsuki", new UsuTsuki(woodState()));

	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static ToIntFunction<BlockState> litIrori(int value1, int value2) {
		return (state) -> { return state.getValue(Irori.LIT)? value1 : (((state.getValue(Irori.STAGE_0_10) >= 7) && (state.getValue(Irori.STAGE_0_10) <= 9))? value2 : 0); };
	}

	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}
	
	private static ToIntFunction<BlockState> litCooktop(int value) {
		return (state) -> { return (state.getValue(Kit_Cooktop.STAGE_1_3) ==2) ? value : 0; };
	}

	private static Properties woodState() {
		return AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()
				.isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never);
	}
	
	private static Properties ovenState() {
		return AbstractBlock.Properties.of(Material.METAL).strength(2.0F, 6.0F).sound(SoundType.METAL).noOcclusion();
	}
	
	private static Properties metalState() {
		return AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
				.isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never);
	}
	
	private static Reizou reizou() {
		return new Reizou(metalState(), () -> { return TileEntity_CM.REIZOU; });
	}
	
	private static ReizouTop reizouTop() {
		return new ReizouTop(metalState(), () -> { return TileEntity_CM.REIZOU_TOP; });
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
