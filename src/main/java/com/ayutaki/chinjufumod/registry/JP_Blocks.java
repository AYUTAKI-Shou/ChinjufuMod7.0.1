package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Stairs_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.JpBlockDummy;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Sama;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JP_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> JPBLOCKDUMMY = register("block_dummy", () -> new JpBlockDummy(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F, 6.0F).sound(SoundType.STONE).noOcclusion()));

	public static final RegistryObject<Block> KAWARA_white = register("block_kawara_white", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_orange = register("block_kawara_orange", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_magenta = register("block_kawara_magenta", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_lightb = register("block_kawara_lightb", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_yellow = register("block_kawara_yellow", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_lime = register("block_kawara_lime", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_pink = register("block_kawara_pink", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_gray = register("block_kawara_gray", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_lightg = register("block_kawara_lightg", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_cyan = register("block_kawara_cyan", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_purple = register("block_kawara_purple", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_blue = register("block_kawara_blue", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_brown = register("block_kawara_brown", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_green = register("block_kawara_green", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_red = register("block_kawara_red", () -> fullKawara());
	public static final RegistryObject<Block> KAWARA_black = register("block_kawara_black", () -> fullKawara());

	public static final RegistryObject<Block> KAWARA_ST_white = register("block_kst_white", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_orange = register("block_kst_orange", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_magenta = register("block_kst_magenta", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_lightb = register("block_kst_lightb", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_yellow = register("block_kst_yellow", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_lime = register("block_kst_lime", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_pink = register("block_kst_pink", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_gray = register("block_kst_gray", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_lightg = register("block_kst_lightg", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_cyan = register("block_kst_cyan", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_purple = register("block_kst_purple", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_blue = register("block_kst_blue", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_brown = register("block_kst_brown", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_green = register("block_kst_green", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_red = register("block_kst_red", () -> stairsKawara());
	public static final RegistryObject<Block> KAWARA_ST_black = register("block_kst_black", () -> stairsKawara());

	public static final RegistryObject<Block> KAWARA_SH_white = register("block_ksh_white", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_orange = register("block_ksh_orange", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_magenta = register("block_ksh_magenta", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_lightb = register("block_ksh_lightb", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_yellow = register("block_ksh_yellow", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_lime = register("block_ksh_lime", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_pink = register("block_ksh_pink", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_gray = register("block_ksh_gray", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_lightg = register("block_ksh_lightg", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_cyan = register("block_ksh_cyan", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_purple = register("block_ksh_purple", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_blue = register("block_ksh_blue", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_brown = register("block_ksh_brown", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_green = register("block_ksh_green", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_red = register("block_ksh_red", () -> slabKawara());
	public static final RegistryObject<Block> KAWARA_SH_black = register("block_ksh_black", () -> slabKawara());

	public static final RegistryObject<Block> DIRTWALL = register("block_dirtwall", () -> fullPlaster());
	public static final RegistryObject<Block> DIRTWALL_stairs = register("block_dirtwall_st", () -> stairsPlaster());
	public static final RegistryObject<Block> DIRTWALL_SH = register("block_dirtwall_sh", () -> slabPlaster());

	public static final RegistryObject<Block> SHIKKUI_white = register("block_plaster_white", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_orange = register("block_plaster_orange", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_magenta = register("block_plaster_magenta", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_lightb = register("block_plaster_lightb", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_yellow = register("block_plaster_yellow", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_lime = register("block_plaster_lime", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_pink = register("block_plaster_pink", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_gray = register("block_plaster_gray", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_lightg = register("block_plaster_lightg", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_cyan = register("block_plaster_cyan", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_purple = register("block_plaster_purple", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_blue = register("block_plaster_blue", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_brown = register("block_plaster_brown", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_green = register("block_plaster_green", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_red = register("block_plaster_red", () -> fullPlaster());
	public static final RegistryObject<Block> SHIKKUI_black = register("block_plaster_black", () -> fullPlaster());

	public static final RegistryObject<Block> SHIKKUI_ST_white = register("block_pst_white", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_orange = register("block_pst_orange", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_magenta = register("block_pst_magenta", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_lightb = register("block_pst_lightb", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_yellow = register("block_pst_yellow", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_lime = register("block_pst_lime", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_pink = register("block_pst_pink", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_gray = register("block_pst_gray", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_lightg = register("block_pst_lightg", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_cyan = register("block_pst_cyan", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_purple = register("block_pst_purple", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_blue = register("block_pst_blue", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_brown = register("block_pst_brown", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_green = register("block_pst_green", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_red = register("block_pst_red", () -> stairsPlaster());
	public static final RegistryObject<Block> SHIKKUI_ST_black = register("block_pst_black", () -> stairsPlaster());

	public static final RegistryObject<Block> SHIKKUI_SH_white = register("block_psh_white", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_orange = register("block_psh_orange", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_magenta = register("block_psh_magenta", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_lightb = register("block_psh_lightb", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_yellow = register("block_psh_yellow", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_lime = register("block_psh_lime", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_pink = register("block_psh_pink", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_gray = register("block_psh_gray", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_lightg = register("block_psh_lightg", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_cyan = register("block_psh_cyan", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_purple = register("block_psh_purple", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_blue = register("block_psh_blue", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_brown = register("block_psh_brown", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_green = register("block_psh_green", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_red = register("block_psh_red", () -> slabPlaster());
	public static final RegistryObject<Block> SHIKKUI_SH_black = register("block_psh_black", () -> slabPlaster());


	public static final RegistryObject<Block> NAMAKO_white = register("block_namako_white", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_orange = register("block_namako_orange", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_magenta = register("block_namako_magenta", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_lightb = register("block_namako_lightb", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_yellow = register("block_namako_yellow", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_lime = register("block_namako_lime", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_pink = register("block_namako_pink", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_gray = register("block_namako_gray", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_lightg = register("block_namako_lightg", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_cyan = register("block_namako_cyan", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_purple = register("block_namako_purple", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_blue = register("block_namako_blue", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_brown = register("block_namako_brown", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_green = register("block_namako_green", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_red = register("block_namako_red", () -> fullNamako());
	public static final RegistryObject<Block> NAMAKO_black = register("block_namako_black", () -> fullNamako());

	public static final RegistryObject<Block> NAMAKO_ST_white = register("block_nst_white", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_orange = register("block_nst_orange", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_magenta = register("block_nst_magenta", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_lightb = register("block_nst_lightb", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_yellow = register("block_nst_yellow", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_lime = register("block_nst_lime", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_pink = register("block_nst_pink", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_gray = register("block_nst_gray", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_lightg = register("block_nst_lightg", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_cyan = register("block_nst_cyan", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_purple = register("block_nst_purple", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_blue = register("block_nst_blue", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_brown = register("block_nst_brown", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_green = register("block_nst_green", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_red = register("block_nst_red", () -> stairsNamako());
	public static final RegistryObject<Block> NAMAKO_ST_black = register("block_nst_black", () -> stairsNamako());

	public static final RegistryObject<Block> NAMAKO_SH_white = register("block_nsh_white", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_orange = register("block_nsh_orange", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_magenta = register("block_nsh_magenta", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_lightb = register("block_nsh_lightb", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_yellow = register("block_nsh_yellow", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_lime = register("block_nsh_lime", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_pink = register("block_nsh_pink", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_gray = register("block_nsh_gray", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_lightg = register("block_nsh_lightg", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_cyan = register("block_nsh_cyan", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_purple = register("block_nsh_purple", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_blue = register("block_nsh_blue", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_brown = register("block_nsh_brown", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_green = register("block_nsh_green", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_red = register("block_nsh_red", () -> slabNamako());
	public static final RegistryObject<Block> NAMAKO_SH_black = register("block_nsh_black", () -> slabNamako());

	public static final RegistryObject<Block> NAMAKOB_white = register("block_namako_b_white", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_orange = register("block_namako_b_orange", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_magenta = register("block_namako_b_magenta", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_lightb = register("block_namako_b_lightb", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_yellow = register("block_namako_b_yellow", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_lime = register("block_namako_b_lime", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_pink = register("block_namako_b_pink", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_gray = register("block_namako_b_gray", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_lightg = register("block_namako_b_lightg", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_cyan = register("block_namako_b_cyan", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_purple = register("block_namako_b_purple", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_blue = register("block_namako_b_blue", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_brown = register("block_namako_b_brown", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_green = register("block_namako_b_green", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_red = register("block_namako_b_red", () -> fullNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_black = register("block_namako_b_black", () -> fullNamakoBtype());

	public static final RegistryObject<Block> NAMAKOB_ST_white = register("block_nst_b_white", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_orange = register("block_nst_b_orange", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_magenta = register("block_nst_b_magenta", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_lightb = register("block_nst_b_lightb", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_yellow = register("block_nst_b_yellow", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_lime = register("block_nst_b_lime", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_pink = register("block_nst_b_pink", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_gray = register("block_nst_b_gray", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_lightg = register("block_nst_b_lightg", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_cyan = register("block_nst_b_cyan", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_purple = register("block_nst_b_purple", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_blue = register("block_nst_b_blue", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_brown = register("block_nst_b_brown", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_green = register("block_nst_b_green", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_red = register("block_nst_b_red", () -> stairsNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_ST_black = register("block_nst_b_black", () -> stairsNamakoBtype());

	public static final RegistryObject<Block> NAMAKOB_SH_white = register("block_nsh_b_white", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_orange = register("block_nsh_b_orange", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_magenta = register("block_nsh_b_magenta", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_lightb = register("block_nsh_b_lightb", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_yellow = register("block_nsh_b_yellow", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_lime = register("block_nsh_b_lime", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_pink = register("block_nsh_b_pink", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_gray = register("block_nsh_b_gray", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_lightg = register("block_nsh_b_lightg", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_cyan = register("block_nsh_b_cyan", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_purple = register("block_nsh_b_purple", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_blue = register("block_nsh_b_blue", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_brown = register("block_nsh_b_brown", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_green = register("block_nsh_b_green", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_red = register("block_nsh_b_red", () -> slabNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_SH_black = register("block_nsh_b_black", () -> slabNamakoBtype());
	
	
	public static final RegistryObject<Block> DIRTWALL_WALL = register("block_dirtwall_wall", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_white = register("block_pwall_white", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_orange = register("block_pwall_orange", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_magenta = register("block_pwall_magenta", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_lightb = register("block_pwall_lightb", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_yellow = register("block_pwall_yellow", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_lime = register("block_pwall_lime", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_pink = register("block_pwall_pink", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_gray = register("block_pwall_gray", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_lightg = register("block_pwall_lightg", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_cyan = register("block_pwall_cyan", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_purple = register("block_pwall_purple", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_blue = register("block_pwall_blue", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_brown = register("block_pwall_brown", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_green = register("block_pwall_green", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_red = register("block_pwall_red", () -> wallPlaster());
	public static final RegistryObject<Block> SHIKKUI_WALL_black = register("block_pwall_black", () -> wallPlaster());
	
	public static final RegistryObject<Block> NAMAKO_WALL_white = register("block_nwall_white", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_orange = register("block_nwall_orange", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_magenta = register("block_nwall_magenta", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_lightb = register("block_nwall_lightb", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_yellow = register("block_nwall_yellow", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_lime = register("block_nwall_lime", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_pink = register("block_nwall_pink", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_gray = register("block_nwall_gray", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_lightg = register("block_nwall_lightg", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_cyan = register("block_nwall_cyan", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_purple = register("block_nwall_purple", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_blue = register("block_nwall_blue", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_brown = register("block_nwall_brown", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_green = register("block_nwall_green", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_red = register("block_nwall_red", () -> wallNamako());
	public static final RegistryObject<Block> NAMAKO_WALL_black = register("block_nwall_black", () -> wallNamako());

	public static final RegistryObject<Block> NAMAKOB_WALL_white = register("block_nwall_b_white", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_orange = register("block_nwall_b_orange", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_magenta = register("block_nwall_b_magenta", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_lightb = register("block_nwall_b_lightb", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_yellow = register("block_nwall_b_yellow", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_lime = register("block_nwall_b_lime", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_pink = register("block_nwall_b_pink", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_gray = register("block_nwall_b_gray", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_lightg = register("block_nwall_b_lightg", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_cyan = register("block_nwall_b_cyan", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_purple = register("block_nwall_b_purple", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_blue = register("block_nwall_b_blue", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_brown = register("block_nwall_b_brown", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_green = register("block_nwall_b_green", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_red = register("block_nwall_b_red", () -> wallNamakoBtype());
	public static final RegistryObject<Block> NAMAKOB_WALL_black = register("block_nwall_b_black", () -> wallNamakoBtype());
	
	public static final RegistryObject<Block> DIRTWALL_SAMA = register("block_dirtwall_sama", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_white = register("block_sama_white", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_orange = register("block_sama_orange", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_magenta = register("block_sama_magenta", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_lightb = register("block_sama_lightb", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_yellow = register("block_sama_yellow", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_lime = register("block_sama_lime", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_pink = register("block_sama_pink", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_gray = register("block_sama_gray", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_lightg = register("block_sama_lightg", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_cyan = register("block_sama_cyan", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_purple = register("block_sama_purple", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_blue = register("block_sama_blue", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_brown = register("block_sama_brown", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_green = register("block_sama_green", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_red = register("block_sama_red", () -> wallSama());
	public static final RegistryObject<Block> SHIKKUI_SAMA_black = register("block_sama_black", () -> wallSama());
	
	public static final RegistryObject<Block> KAWARA_WALL_white = register("block_kwall_white", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_orange = register("block_kwall_orange", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_magenta = register("block_kwall_magenta", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_lightb = register("block_kwall_lightb", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_yellow = register("block_kwall_yellow", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_lime = register("block_kwall_lime", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_pink = register("block_kwall_pink", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_gray = register("block_kwall_gray", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_lightg = register("block_kwall_lightg", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_cyan = register("block_kwall_cyan", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_purple = register("block_kwall_purple", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_blue = register("block_kwall_blue", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_brown = register("block_kwall_brown", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_green = register("block_kwall_green", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_red = register("block_kwall_red", () -> wallKawara());
	public static final RegistryObject<Block> KAWARA_WALL_black = register("block_kwall_black", () -> wallKawara());

	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static boolean neverSlab(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE)? true : false;
	}

	private static Boolean neverEntitySlab(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(Base_Slab_JP.TYPE) == SlabType.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Boolean neverEntityStairs(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(Base_Stairs_JP.HALF) == Half.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Properties stoneState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F, 6.0F).sound(SoundType.STONE);
	}
	
	private static Full_Kawara fullKawara() {
		return new Full_Kawara(stoneState());
	}

	private static Stairs_Kawara stairsKawara() {
		return new Stairs_Kawara(JPBLOCKDUMMY.get().defaultBlockState(), stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntityStairs).isSuffocating(JP_Blocks::never));
	}

	private static Slab_Kawara slabKawara() {
		return new Slab_Kawara(stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntitySlab).isSuffocating(JP_Blocks::neverSlab));
	}

	private static Full_Plaster fullPlaster() {
		return new Full_Plaster(stoneState());
	}

	private static Stairs_Plaster stairsPlaster() {
		return new Stairs_Plaster(JPBLOCKDUMMY.get().defaultBlockState(), stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntityStairs).isSuffocating(JP_Blocks::never));
	}

	private static Slab_Plaster slabPlaster() {
		return new Slab_Plaster(stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntitySlab).isSuffocating(JP_Blocks::neverSlab));
	}

	private static Full_Namako fullNamako() {
		return new Full_Namako(stoneState());
	}

	private static Stairs_Namako stairsNamako() {
		return new Stairs_Namako(JPBLOCKDUMMY.get().defaultBlockState(), stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntityStairs).isSuffocating(JP_Blocks::never));
	}

	private static Slab_Namako slabNamako() {
		return new Slab_Namako(stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntitySlab).isSuffocating(JP_Blocks::neverSlab));
	}

	private static Full_Namako_B fullNamakoBtype() {
		return new Full_Namako_B(stoneState());
	}

	private static Stairs_Namako_B stairsNamakoBtype() {
		return new Stairs_Namako_B(JPBLOCKDUMMY.get().defaultBlockState(), stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntityStairs).isSuffocating(JP_Blocks::never));
	}

	private static Slab_Namako_B slabNamakoBtype() {
		return new Slab_Namako_B(stoneState().noOcclusion().isValidSpawn(JP_Blocks::neverEntitySlab).isSuffocating(JP_Blocks::neverSlab));
	}

	private static Wall_Plaster wallPlaster() {
		return new Wall_Plaster(stoneState());
	}
	
	private static Wall_Namako wallNamako() {
		return new Wall_Namako(stoneState());
	}
	
	private static Wall_NamakoB wallNamakoBtype() {
		return new Wall_NamakoB(stoneState());
	}
	
	private static Wall_Sama wallSama() {
		return new Wall_Sama(stoneState());
	}
	
	private static Wall_Kawara wallKawara() {
		return new Wall_Kawara(stoneState());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
