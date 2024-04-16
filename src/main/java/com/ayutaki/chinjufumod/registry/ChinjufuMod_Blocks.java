package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampItem;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AmmoBauxiteBox;
import com.ayutaki.chinjufumod.blocks.cmblock.EmptyBox;
import com.ayutaki.chinjufumod.blocks.cmblock.Oil_Drum;
import com.ayutaki.chinjufumod.blocks.cmblock.Report_Box;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater1;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater2;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater3;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChinjufuMod_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> BAUXITE_ORE = register("block_bauxite_ore", () -> new DropExperienceBlock(oreState().strength(3.0F, 3.0F).sound(SoundType.STONE), UniformInt.of(1, 3)));
	public static final RegistryObject<Block> BAUXITE_ORE_DEEP = register("block_bauxite_ore_deep", () -> new DropExperienceBlock(oreState().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(1, 3)));

	public static final RegistryObject<Block> OIL_DRUM = register("block_fuel_can", () -> new Oil_Drum(metalState()));

	public static final RegistryObject<Block> EMPTY_BOX = register("block_empty_box", () -> new EmptyBox(boxState().isSuffocating(ChinjufuMod_Blocks::never)));
	public static final RegistryObject<Block> AMMOBOX = register("block_ammunition_box", () -> new AmmoBauxiteBox(boxState()));
	public static final RegistryObject<Block> BAUXITE_BOX = register("block_bauxite_box", () -> new AmmoBauxiteBox(boxState()));

	public static final RegistryObject<Block> ALUMI_BLOCK = register("block_alumi_block", () -> new AlumiBlock(metalState()));
	public static final RegistryObject<Block> STEEL_BLOCK = register("block_steel_block", () -> new AlumiBlock(metalState()));
	public static final RegistryObject<Block> COPPER_BLOCK = register("block_copper_block", () -> new AlumiBlock(metalState()));
	public static final RegistryObject<Block> GOLD_BLOCK = register("block_gold_block", () -> new AlumiBlock(metalState()));
	public static final RegistryObject<Block> NETHERITE_BLOCK = register("block_netherite_block", () -> new AlumiBlock(metalState()));

	public static final RegistryObject<Block> I_ADMIRAL_STAMP = register("item_admiralstamp_b", () -> new AdmiralStampItem(stampState()));
	public static final RegistryObject<Block> REPORT_BOX = register("block_report_box", () -> new Report_Box(metalState()));

	public static final RegistryObject<Block> WAKE_WATER1 = register("block_wake_water1", () -> new WakeWater1(wakeState()));
	public static final RegistryObject<Block> WAKE_WATER2 = register("block_wake_water2", () -> new WakeWater2(wakeState()));
	public static final RegistryObject<Block> WAKE_WATER3 = register("block_wake_water3", () -> new WakeWater3(wakeState()));

	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties oreState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops();
	}
	
	private static Properties metalState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(1.0F, 3.0F).noOcclusion()
				.isValidSpawn(ChinjufuMod_Blocks::neverEntity);
	}
	
	private static Properties boxState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 3.0F)
				.isValidSpawn(ChinjufuMod_Blocks::neverEntity);
	}
	
	private static Properties stampState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().sound(SoundType.WOOD).strength(0.5F).noOcclusion()
				.isValidSpawn(ChinjufuMod_Blocks::neverEntity).isSuffocating(ChinjufuMod_Blocks::never);
	}
	
	private static Properties wakeState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WATER).sound(SoundType.SNOW).strength(0.1F, 3.0F).noOcclusion()
				.isValidSpawn(ChinjufuMod_Blocks::neverEntity).isSuffocating(ChinjufuMod_Blocks::never);
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
