package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_irongrill;
import com.ayutaki.chinjufumod.blocks.gate.Gate_thick;

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

public class Gate_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> GATE_SPRUCE = register("block_gate_spruce", () -> gateSpruce());
	public static final RegistryObject<Block> GATE_SPRUCE_B = register("block_gate_spruce_b", () -> gateSpruce());
	public static final RegistryObject<Block> GATE_IRON = register("block_gate_iron", () -> new Gate_thick(ironState()));
	public static final RegistryObject<Block> GATE_IRONGRILL = register("block_gate_irongrill", () -> new Gate_irongrill(ironState()));
	
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties ironState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F, 20.0F).sound(SoundType.METAL).noOcclusion()
				.isValidSpawn(Gate_Blocks::neverEntity).isSuffocating(Gate_Blocks::never);
	}

	private static Gate_thick gateSpruce() {
		return new Gate_thick(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 10.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Gate_Blocks::neverEntity).isSuffocating(Gate_Blocks::never));
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
