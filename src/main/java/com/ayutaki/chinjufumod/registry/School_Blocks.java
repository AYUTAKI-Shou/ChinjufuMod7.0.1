package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;
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

public class School_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> BLACKBOARD = register( "block_blackboard", () -> new BlackBoard(woodState()));

	public static final RegistryObject<Block> SCHOOLCHAIR = register("block_schoolchair", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_spruce = register("block_schoolchair_s", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_birch = register("block_schoolchair_b", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_jungle = register("block_schoolchair_j", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_acacia = register("block_schoolchair_a", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_darkoak = register("block_schoolchair_d", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_sakura = register("block_schoolchair_saku", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_kaede = register("block_schoolchair_kae", () -> schoolChair());
	public static final RegistryObject<Block> SCHOOLCHAIR_ichoh = register("block_schoolchair_ich", () -> schoolChair());

	public static final RegistryObject<Block> SCHOOLDESK = register("block_schooldesk", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_spruce = register("block_schooldesk_s", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_birch = register("block_schooldesk_b", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_jungle = register("block_schooldesk_j", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_acacia = register("block_schooldesk_a", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_darkoak = register("block_schooldesk_d", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_sakura = register("block_schooldesk_saku", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_kaede = register("block_schooldesk_kae", () -> schoolDesk());
	public static final RegistryObject<Block> SCHOOLDESK_ichoh = register("block_schooldesk_ich", () -> schoolDesk());

	public static final RegistryObject<Block> TEACHERDESK = register("block_teacherdesk", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_spruce = register("block_teacherdesk_s", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_birch = register("block_teacherdesk_b", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_jungle = register("block_teacherdesk_j", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_acacia = register("block_teacherdesk_a", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_darkoak = register("block_teacherdesk_d", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_sakura = register("block_teacherdesk_saku", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_kaede = register("block_teacherdesk_kae", () -> teacherDesk());
	public static final RegistryObject<Block> TEACHERDESK_ichoh = register("block_teacherdesk_ich", () -> teacherDesk());
	
	public static final RegistryObject<Block> STOVECHIMNEY = register("block_stovechimney", () -> new StoveChimney(metalState()));
	public static final RegistryObject<Block> STOVECHIMNEY_joint = register("block_stovechimney_joint", () -> new StoveChimney_joint(metalState()));
	public static final RegistryObject<Block> STOVECHIMNEY_topk = register("block_stovechimney_topk", () -> new StoveChimney_top(metalState()));
	
	public static final RegistryObject<Block> CSTOVE_top = register("block_cstove_top", () -> new CStove_Top(metalState().lightLevel(litBlockEmission(14))));
	public static final RegistryObject<Block> CSTOVE_bot = register("block_cstove_bot", () -> new CStove_Bot(metalState()));

	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}
	
	private static Properties woodState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()
				.isValidSpawn(School_Blocks::neverEntity).isSuffocating(School_Blocks::never);
	}
	
	private static Properties metalState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
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
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
