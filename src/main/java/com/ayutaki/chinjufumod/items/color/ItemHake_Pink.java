package com.ayutaki.chinjufumod.items.color;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.blocks.chair.BaseSofa;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.furniture.Andon;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Full_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Plaster;
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
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Futon;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami_Y;
import com.ayutaki.chinjufumod.blocks.kamoislab.Base_KamoiPlaster;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Spruce;
import com.ayutaki.chinjufumod.blocks.ranma.Noren;
import com.ayutaki.chinjufumod.blocks.slidedoor.BaseSlidedoor;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Plaster;
import com.ayutaki.chinjufumod.blocks.window.Curtain;
import com.ayutaki.chinjufumod.blocks.window.CurtainTall;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Chair_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPChair_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.JP_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ItemHake_Pink extends Base_ItemHake {

	public ItemHake_Pink(Properties properties) {
		super(properties);
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();

		ItemStack stack = context.getItemInHand();
		boolean mode = playerIn.abilities.instabuild;

		/** other Blocks **/
		if (block == Blocks.WHITE_WOOL || block == Blocks.ORANGE_WOOL || block == Blocks.MAGENTA_WOOL ||
				block == Blocks.LIGHT_BLUE_WOOL || block == Blocks.YELLOW_WOOL || block == Blocks.LIME_WOOL ||
				block == Blocks.GRAY_WOOL || block == Blocks.LIGHT_GRAY_WOOL || block == Blocks.CYAN_WOOL ||
				block == Blocks.PURPLE_WOOL || block == Blocks.BLUE_WOOL || block == Blocks.BROWN_WOOL ||
				block == Blocks.GREEN_WOOL || block == Blocks.RED_WOOL || block == Blocks.BLACK_WOOL) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_WOOL.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } ); //BreakAnimation 無しで筆を返すことも可能

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_CONCRETE || block == Blocks.ORANGE_CONCRETE || block == Blocks.MAGENTA_CONCRETE ||
				block == Blocks.LIGHT_BLUE_CONCRETE || block == Blocks.YELLOW_CONCRETE || block == Blocks.LIME_CONCRETE ||
				block == Blocks.GRAY_CONCRETE || block == Blocks.LIGHT_GRAY_CONCRETE || block == Blocks.CYAN_CONCRETE ||
				block == Blocks.PURPLE_CONCRETE || block == Blocks.BLUE_CONCRETE || block == Blocks.BROWN_CONCRETE ||
				block == Blocks.GREEN_CONCRETE || block == Blocks.RED_CONCRETE || block == Blocks.BLACK_CONCRETE) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_CONCRETE.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA ||
				block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA ||
				block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA ||
				block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA ||
				block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA ||
				block == Blocks.TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_TERRACOTTA.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof ConcretePowderBlock && block != Blocks.PINK_CONCRETE_POWDER) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_CONCRETE_POWDER.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if ((block instanceof StainedGlassBlock && block != Blocks.PINK_STAINED_GLASS) || block == Blocks.GLASS) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_STAINED_GLASS.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** テラコッタ **/
		if (block instanceof GlazedTerracottaBlock && block != Blocks.PINK_GLAZED_TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_GLAZED_TERRACOTTA.defaultBlockState()
					.setValue(GlazedTerracottaBlock.FACING, state.getValue(GlazedTerracottaBlock.FACING)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 板ガラス **/
		if ((block instanceof StainedGlassPaneBlock && block != Blocks.PINK_STAINED_GLASS_PANE) || block == Blocks.GLASS_PANE) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_STAINED_GLASS_PANE.defaultBlockState()
					.setValue(PaneBlock.NORTH, state.getValue(PaneBlock.NORTH))
					.setValue(PaneBlock.EAST, state.getValue(PaneBlock.EAST))
					.setValue(PaneBlock.SOUTH, state.getValue(PaneBlock.SOUTH))
					.setValue(PaneBlock.WEST, state.getValue(PaneBlock.WEST))
					.setValue(PaneBlock.WATERLOGGED, state.getValue(PaneBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/**カーペット **/
		if (block instanceof CarpetBlock && block != Blocks.PINK_CARPET) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Blocks.PINK_CARPET.defaultBlockState(), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (block instanceof Full_Kawara && block != JP_Blocks.KAWARA_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.KAWARA_pink.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Plaster && block != JP_Blocks.SHIKKUI_pink && block != JP_Blocks.DIRTWALL) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.SHIKKUI_pink.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako && block != JP_Blocks.NAMAKO_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKO_pink.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako_B && block != JP_Blocks.NAMAKOB_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKOB_pink.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 階段 **/
		if (block instanceof Stairs_Kawara && block != JP_Blocks.KAWARA_ST_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.KAWARA_ST_pink.defaultBlockState()
					.setValue(StairsBlock.FACING, state.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, state.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, state.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, state.getValue(StairsBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Plaster && block != JP_Blocks.SHIKKUI_ST_pink && block != JP_Blocks.DIRTWALL_stairs) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.SHIKKUI_ST_pink.defaultBlockState()
					.setValue(StairsBlock.FACING, state.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, state.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, state.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, state.getValue(StairsBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako && block != JP_Blocks.NAMAKO_ST_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKO_ST_pink.defaultBlockState()
					.setValue(StairsBlock.FACING, state.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, state.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, state.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, state.getValue(StairsBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako_B && block != JP_Blocks.NAMAKOB_ST_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKOB_ST_pink.defaultBlockState()
					.setValue(StairsBlock.FACING, state.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, state.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, state.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, state.getValue(StairsBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ハーフブロック **/
		if (block instanceof Slab_Kawara && block != JP_Blocks.KAWARA_SH_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.KAWARA_SH_pink.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Plaster && block != JP_Blocks.SHIKKUI_SH_pink && block != JP_Blocks.DIRTWALL_SH) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.SHIKKUI_SH_pink.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako && block != JP_Blocks.NAMAKO_SH_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKO_SH_pink.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako_B && block != JP_Blocks.NAMAKOB_SH_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKOB_SH_pink.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** トラス **/
		if (block instanceof CTruss && block != Harbor_Blocks.TRUSS_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Harbor_Blocks.TRUSS_pink.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 椅子・座布団・キャンドル **/
		if (block instanceof CafeChair && block != Chair_Blocks.CAFECHAIR_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Chair_Blocks.CAFECHAIR_pink.defaultBlockState(), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Zabuton && block != JPChair_Blocks.ZABUTON_pink && block != JPChair_Blocks.WARAZABUTON) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JPChair_Blocks.ZABUTON_pink.defaultBlockState()
					.setValue(Zabuton.DOWN, state.getValue(Zabuton.DOWN))
					.setValue(Zabuton.WATERLOGGED, state.getValue(Zabuton.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Candle && block != Furniture_Blocks.CANDLE_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Furniture_Blocks.CANDLE_pink.defaultBlockState()
					.setValue(Candle.LIT, state.getValue(Candle.LIT))
					.setValue(Candle.DOWN, state.getValue(Candle.DOWN))
					.setValue(Candle.WATERLOGGED, state.getValue(Candle.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 行灯 **/
		if (block instanceof Andon && block != JPDeco_Blocks.ANDON_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JPDeco_Blocks.ANDON_pink.defaultBlockState()
					.setValue(Andon.LIT, state.getValue(Andon.LIT))
					.setValue(Andon.H_FACING, state.getValue(Andon.H_FACING))
					.setValue(Andon.WATERLOGGED, state.getValue(Andon.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ソファ **/
		if (block instanceof Sofa && block != Chair_Blocks.SOFA_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Chair_Blocks.SOFA_pink.defaultBlockState()
					.setValue(BaseSofa.TYPE, state.getValue(BaseSofa.TYPE))
					.setValue(BaseSofa.H_FACING, state.getValue(BaseSofa.H_FACING))
					.setValue(BaseSofa.WATERLOGGED, state.getValue(BaseSofa.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 座椅子 **/
		if (block instanceof Zaisu && block != JPChair_Blocks.ZAISU_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JPChair_Blocks.ZAISU_pink.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** のれん **/
		if (block instanceof Noren && block != Ranma_Blocks.NOREN_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Ranma_Blocks.NOREN_pink.defaultBlockState()
					.setValue(Noren.TYPE, state.getValue(Noren.TYPE))
					.setValue(Noren.H_FACING, state.getValue(Noren.H_FACING))
					.setValue(Noren.WATERLOGGED, state.getValue(Noren.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 布団 **/
		if (block instanceof Futon && block != JPDeco_Blocks.FUTON_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JPDeco_Blocks.FUTON_pink.defaultBlockState()
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 畳 **/
		if (block instanceof Tatami && block != JPDeco_Blocks.TATAMI_H_pink && block != JPDeco_Blocks.TATAMI_H) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JPDeco_Blocks.TATAMI_H_pink.defaultBlockState()
					.setValue(BaseTatami.TYPE, state.getValue(BaseTatami.TYPE))
					.setValue(BaseTatami.H_FACING, state.getValue(BaseTatami.H_FACING))
					.setValue(BaseTatami.WATERLOGGED, state.getValue(BaseTatami.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Tatami_Y && block != JPDeco_Blocks.TATAMI_HY_pink && block != JPDeco_Blocks.TATAMI_HY) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JPDeco_Blocks.TATAMI_HY_pink.defaultBlockState()
					.setValue(BaseTatami.TYPE, state.getValue(BaseTatami.TYPE))
					.setValue(BaseTatami.H_FACING, state.getValue(BaseTatami.H_FACING))
					.setValue(BaseTatami.WATERLOGGED, state.getValue(BaseTatami.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 傘 **/
		if (block instanceof Wagasa && block != Unit_Blocks.KASA_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Unit_Blocks.KASA_pink.defaultBlockState()
					.setValue(Wagasa.NORTH, state.getValue(Wagasa.NORTH))
					.setValue(Wagasa.EAST, state.getValue(Wagasa.EAST))
					.setValue(Wagasa.SOUTH, state.getValue(Wagasa.SOUTH))
					.setValue(Wagasa.WEST, state.getValue(Wagasa.WEST))
					.setValue(Wagasa.WHICH, Boolean.valueOf(false))
					.setValue(Wagasa.WATERLOGGED, state.getValue(Wagasa.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** ふすま **/
		if (block instanceof Fusuma && block != Slidedoor_Blocks.FUSUMA_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlock(pos, Slidedoor_Blocks.FUSUMA_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(pos.above(), Slidedoor_Blocks.FUSUMA_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlock(pos, Slidedoor_Blocks.FUSUMA_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(pos.below(), Slidedoor_Blocks.FUSUMA_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Fusuma_B && block != Slidedoor_Blocks.FUSUMAB_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlock(pos, Slidedoor_Blocks.FUSUMAB_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(pos.above(), Slidedoor_Blocks.FUSUMAB_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlock(pos, Slidedoor_Blocks.FUSUMAB_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(pos.below(), Slidedoor_Blocks.FUSUMAB_pink.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** 鴨居 **/
		if (block instanceof KamoiPlaster_Oak && block != KamoiPlaster_Blocks.KAMOI_pink_oak) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_oak.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Spruce && block != KamoiPlaster_Blocks.KAMOI_pink_spru) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_spru.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Birch && block != KamoiPlaster_Blocks.KAMOI_pink_bir) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_bir.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Jungle && block != KamoiPlaster_Blocks.KAMOI_pink_jun) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_jun.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Acacia && block != KamoiPlaster_Blocks.KAMOI_pink_aca) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_aca.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_DarkOak && block != KamoiPlaster_Blocks.KAMOI_pink_doak) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_doak.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Sakura && block != KamoiPlaster_Blocks.KAMOI_pink_sakura) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_sakura.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Kaede && block != KamoiPlaster_Blocks.KAMOI_pink_kaede) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_kaede.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Ichoh && block != KamoiPlaster_Blocks.KAMOI_pink_ichoh) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, KamoiPlaster_Blocks.KAMOI_pink_ichoh.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** 粘土 **/
		if (block instanceof WallPane_Clay && block != WallPanel_Blocks.WP_CLAY_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, WallPanel_Blocks.WP_CLAY_pink.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ガラス **/
		if (block instanceof WallPane_Glass && block != WallPanel_Blocks.WP_GLASS_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, WallPanel_Blocks.WP_GLASS_pink.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** しっくい **/
		if (block instanceof WallPane_Plaster && block != WallPanel_Blocks.WP_PLASTER_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, WallPanel_Blocks.WP_PLASTER_pink.defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** なまこ **/
		if (block instanceof WallPane_Namako && block != WallPanel_Blocks.WP_NAMAKO_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, WallPanel_Blocks.WP_NAMAKO_pink.defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof WallPane_Namako_B && block != WallPanel_Blocks.WP_NAMAKOB_pink) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, WallPanel_Blocks.WP_NAMAKOB_pink.defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///6.1.2////////////////////
		if (block instanceof Wall_Plaster && block != JP_Blocks.SHIKKUI_WALL_pink && block != JP_Blocks.DIRTWALL_WALL) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.SHIKKUI_WALL_pink.defaultBlockState()
					.setValue(Wall_Plaster.NORTH, state.getValue(Wall_Plaster.NORTH))
					.setValue(Wall_Plaster.SOUTH, state.getValue(Wall_Plaster.SOUTH))
					.setValue(Wall_Plaster.EAST, state.getValue(Wall_Plaster.EAST))
					.setValue(Wall_Plaster.WEST, state.getValue(Wall_Plaster.WEST))
					.setValue(Wall_Plaster.CRACK, state.getValue(Wall_Plaster.CRACK))
					.setValue(Wall_Plaster.WATERLOGGED, state.getValue(Wall_Plaster.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Sama && block != JP_Blocks.SHIKKUI_SAMA_pink && block != JP_Blocks.DIRTWALL_SAMA) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.SHIKKUI_SAMA_pink.defaultBlockState()
					.setValue(Wall_Sama.H_FACING, state.getValue(Wall_Sama.H_FACING))
					.setValue(Wall_Sama.STAGE_1_4, state.getValue(Wall_Sama.STAGE_1_4))
					.setValue(Wall_Sama.WATERLOGGED, state.getValue(Wall_Sama.WATERLOGGED)), 3);
			
			if (state.getValue(Wall_Sama.STAGE_1_4) <= 2) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			
			if (state.getValue(Wall_Sama.STAGE_1_4) >= 3) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Wall_Kawara && block != JP_Blocks.KAWARA_WALL_pink) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.KAWARA_WALL_pink.defaultBlockState()
					.setValue(Wall_Kawara.NORTH, state.getValue(Wall_Kawara.NORTH))
					.setValue(Wall_Kawara.SOUTH, state.getValue(Wall_Kawara.SOUTH))
					.setValue(Wall_Kawara.EAST, state.getValue(Wall_Kawara.EAST))
					.setValue(Wall_Kawara.WEST, state.getValue(Wall_Kawara.WEST))
					.setValue(Wall_Kawara.WATERLOGGED, state.getValue(Wall_Kawara.WATERLOGGED)), 3);
			
			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Namako && block != JP_Blocks.NAMAKO_WALL_pink) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKO_WALL_pink.defaultBlockState()
					.setValue(Wall_Namako.NORTH, state.getValue(Wall_Namako.NORTH))
					.setValue(Wall_Namako.SOUTH, state.getValue(Wall_Namako.SOUTH))
					.setValue(Wall_Namako.EAST, state.getValue(Wall_Namako.EAST))
					.setValue(Wall_Namako.WEST, state.getValue(Wall_Namako.WEST))
					.setValue(Wall_Namako.CRACK, state.getValue(Wall_Namako.CRACK))
					.setValue(Wall_Namako.WATERLOGGED, state.getValue(Wall_Namako.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_NamakoB && block != JP_Blocks.NAMAKOB_WALL_pink) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, JP_Blocks.NAMAKOB_WALL_pink.defaultBlockState()
					.setValue(Wall_NamakoB.NORTH, state.getValue(Wall_NamakoB.NORTH))
					.setValue(Wall_NamakoB.SOUTH, state.getValue(Wall_NamakoB.SOUTH))
					.setValue(Wall_NamakoB.EAST, state.getValue(Wall_NamakoB.EAST))
					.setValue(Wall_NamakoB.WEST, state.getValue(Wall_NamakoB.WEST))
					.setValue(Wall_NamakoB.CRACK, state.getValue(Wall_NamakoB.CRACK))
					.setValue(Wall_NamakoB.WATERLOGGED, state.getValue(Wall_NamakoB.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		///6.2.4////////////////////
		if (block instanceof Curtain && block != Window_Blocks.CURTAIN_pink) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlock(pos, Window_Blocks.CURTAIN_pink.defaultBlockState()
					.setValue(Curtain.H_FACING, state.getValue(Wall_Sama.H_FACING))
					.setValue(Curtain.STAGE_1_4, state.getValue(Wall_Sama.STAGE_1_4))
					.setValue(Curtain.WATERLOGGED, state.getValue(Wall_Sama.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof CurtainTall && block != Window_Blocks.CURTAINTALL_pink) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			
			if (state.getValue(CurtainTall.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlock(pos, Window_Blocks.CURTAINTALL_pink.defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.LOWER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3);
				iworld.setBlock(pos.above(), Window_Blocks.CURTAINTALL_pink.defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.UPPER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3); }
			
			if (state.getValue(CurtainTall.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlock(pos, Window_Blocks.CURTAINTALL_pink.defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.UPPER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3);
				iworld.setBlock(pos.below(), Window_Blocks.CURTAINTALL_pink.defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.LOWER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3); }
			
			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		/* Wash the brush. MIZUOKE work is in the block. */
		if (block == Blocks.CAULDRON) {
			int level = state.getValue(CauldronBlock.LEVEL);
			if (level != 0) {
				CMEvents.soundWash(iworld, playerIn, pos);
				iworld.setBlock(pos, state.setValue(CauldronBlock.LEVEL, Integer.valueOf(level - 1)), 3);

				/** Return the Item. **/
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }

				if (!mode) { stack.shrink(1); }
				return ActionResultType.SUCCESS;
			}
		}

		return ActionResultType.FAIL;
	}

}
