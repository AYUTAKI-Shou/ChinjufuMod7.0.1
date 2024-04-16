package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_iron;
import com.ayutaki.chinjufumod.blocks.gate.Gate_irongrill;
import com.ayutaki.chinjufumod.blocks.gate.Gate_spruce;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Gate_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block GATE_SPRUCE = register("block_gate_spruce", gateSpruce());
	public static Block GATE_SPRUCE_B = register("block_gate_spruce_b", gateSpruce());
	public static Block GATE_IRON = register("block_gate_iron", new Gate_iron(ironState()));
	public static Block GATE_IRONGRILL = register("block_gate_irongrill", new Gate_irongrill(ironState()));

	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static Gate_spruce gateSpruce() {
		return new Gate_spruce(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 10.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Gate_Blocks::neverEntity).isSuffocating(Gate_Blocks::never));
	}
	
	private static Properties ironState() {
		return AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 20.0F).sound(SoundType.METAL).noOcclusion()
				.isValidSpawn(Gate_Blocks::neverEntity).isSuffocating(Gate_Blocks::never);
	}

	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
