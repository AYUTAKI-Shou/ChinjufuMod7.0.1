package com.ayutaki.chinjufumod.registry;

import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furnace.CStove_Bot;
import com.ayutaki.chinjufumod.blocks.furnace.CStove_Top;
import com.ayutaki.chinjufumod.blocks.school.BlackBoard;
import com.ayutaki.chinjufumod.blocks.school.SchoolChair;
import com.ayutaki.chinjufumod.blocks.school.SchoolDesk;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_joint;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_top;
import com.ayutaki.chinjufumod.blocks.school.TeacherDesk;

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
public class School_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block BLACKBOARD = register( "block_blackboard", new BlackBoard(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(School_Blocks::neverEntity).isSuffocating(School_Blocks::never)));

	public static Block SCHOOLCHAIR = register("block_schoolchair", schoolChair());
	public static Block SCHOOLCHAIR_spruce = register("block_schoolchair_s", schoolChair());
	public static Block SCHOOLCHAIR_birch = register("block_schoolchair_b", schoolChair());
	public static Block SCHOOLCHAIR_jungle = register("block_schoolchair_j", schoolChair());
	public static Block SCHOOLCHAIR_acacia = register("block_schoolchair_a", schoolChair());
	public static Block SCHOOLCHAIR_darkoak = register("block_schoolchair_d", schoolChair());
	public static Block SCHOOLCHAIR_sakura = register("block_schoolchair_saku", schoolChair());
	public static Block SCHOOLCHAIR_kaede = register("block_schoolchair_kae", schoolChair());
	public static Block SCHOOLCHAIR_ichoh = register("block_schoolchair_ich", schoolChair());

	public static Block SCHOOLDESK = register("block_schooldesk", schoolDesk());
	public static Block SCHOOLDESK_spruce = register("block_schooldesk_s", schoolDesk());
	public static Block SCHOOLDESK_birch = register("block_schooldesk_b", schoolDesk());
	public static Block SCHOOLDESK_jungle = register("block_schooldesk_j", schoolDesk());
	public static Block SCHOOLDESK_acacia = register("block_schooldesk_a", schoolDesk());
	public static Block SCHOOLDESK_darkoak = register("block_schooldesk_d", schoolDesk());
	public static Block SCHOOLDESK_sakura = register("block_schooldesk_saku", schoolDesk());
	public static Block SCHOOLDESK_kaede = register("block_schooldesk_kae", schoolDesk());
	public static Block SCHOOLDESK_ichoh = register("block_schooldesk_ich", schoolDesk());

	public static Block TEACHERDESK = register("block_teacherdesk", teacherDesk());
	public static Block TEACHERDESK_spruce = register("block_teacherdesk_s", teacherDesk());
	public static Block TEACHERDESK_birch = register("block_teacherdesk_b", teacherDesk());
	public static Block TEACHERDESK_jungle = register("block_teacherdesk_j", teacherDesk());
	public static Block TEACHERDESK_acacia = register("block_teacherdesk_a", teacherDesk());
	public static Block TEACHERDESK_darkoak = register("block_teacherdesk_d", teacherDesk());
	public static Block TEACHERDESK_sakura = register("block_teacherdesk_saku", teacherDesk());
	public static Block TEACHERDESK_kaede = register("block_teacherdesk_kae", teacherDesk());
	public static Block TEACHERDESK_ichoh = register("block_teacherdesk_ich", teacherDesk());

	public static Block STOVECHIMNEY = register("block_stovechimney", new StoveChimney(metalState()));
	public static Block STOVECHIMNEY_joint = register("block_stovechimney_joint", new StoveChimney_joint(metalState()));
	public static Block STOVECHIMNEY_topk = register("block_stovechimney_topk", new StoveChimney_top(metalState()));

	public static Block CSTOVE_top = register("block_cstove_top", new CStove_Top(metalState().lightLevel(litBlockEmission(14))));
	public static Block CSTOVE_bot = register("block_cstove_bot", new CStove_Bot(metalState()));

	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}

	private static Properties woodState() {
		return AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(School_Blocks::neverEntity).isSuffocating(School_Blocks::never);
	}
	
	private static Properties metalState() {
		return AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
				.isValidSpawn(School_Blocks::neverEntity).isSuffocating(School_Blocks::never);
	}
	
	private static SchoolChair schoolChair() {
		return new SchoolChair(woodState());
	}

	private static SchoolDesk schoolDesk() {
		return new SchoolDesk(woodState());
	}

	private static TeacherDesk teacherDesk() {
		return new TeacherDesk(woodState());
	}

	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
