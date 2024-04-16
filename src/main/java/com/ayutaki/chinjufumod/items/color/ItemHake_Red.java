package com.ayutaki.chinjufumod.items.color;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.chair.BaseZabuton;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_1;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_2;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_3;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_4;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_1;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_2;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_3;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_4;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Candle;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_JpFull;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Wall;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_WallKawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoBCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_PlasterCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Sama;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatamiWood;
import com.ayutaki.chinjufumod.blocks.jpdeco.Futon;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami_Y;
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
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;
import com.ayutaki.chinjufumod.blocks.wallpane.BaseStage2_WP;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_clay_color;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_glass_stained;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_plaster;
import com.ayutaki.chinjufumod.blocks.window.Curtain;
import com.ayutaki.chinjufumod.blocks.window.CurtainTall;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiShikkui_Blocks;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;
import com.ayutaki.chinjufumod.registry.WallPaneJP_Blocks;
import com.ayutaki.chinjufumod.registry.WallPane_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockConcretePowder;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.block.BlockHardenedClay;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStainedHardenedClay;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHake_Red extends Base_ItemHake {

	public ItemHake_Red(String name) {
		super(name);
	}

	/* FlintAndSteel */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState stateIn = worldIn.getBlockState(pos);
		ItemStack stack = playerIn.getHeldItem(hand);
		Block blockIn = stateIn.getBlock();
		
		/** 羊毛・コンクリート **/
		if (blockIn instanceof BlockColored || blockIn instanceof BlockConcretePowder ||
				blockIn instanceof BlockStainedGlass || blockIn instanceof BlockStainedHardenedClay) {
			int color = ((EnumDyeColor)stateIn.getValue(BlockColored.COLOR)).getMetadata();

			if (color != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(BlockColored.COLOR, EnumDyeColor.RED), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** ガラスブロック **/
		if (blockIn == Blocks.GLASS) {
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState()
					.withProperty(BlockStainedGlass.COLOR, EnumDyeColor.RED), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

			if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
			if (stack.getMaxDamage() <= 2) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				stack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}


		/** 板ガラス, カーペット **/
		if (blockIn instanceof BlockStainedGlassPane || blockIn instanceof BlockCarpet) {
			int color = ((EnumDyeColor)stateIn.getValue(BlockColored.COLOR)).getMetadata();

			if (color != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(BlockColored.COLOR, EnumDyeColor.RED), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn == Blocks.GLASS_PANE) {
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Blocks.STAINED_GLASS_PANE.getDefaultState()
					.withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.RED), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

			if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
			if (stack.getMaxDamage() <= 1) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				stack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}


		/** 堅焼き粘土 **/
		if (blockIn instanceof BlockHardenedClay) {
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState()
					.withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.RED), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

			if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
			if (stack.getMaxDamage() <= 2) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				stack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}


		/** テラコッタ **/
		if (blockIn instanceof BlockGlazedTerracotta) {
			if (blockIn != Blocks.RED_GLAZED_TERRACOTTA) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Blocks.RED_GLAZED_TERRACOTTA.getDefaultState()
						.withProperty(BlockGlazedTerracotta.FACING, stateIn.getValue(BlockGlazedTerracotta.FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (blockIn instanceof Plaster || blockIn instanceof Plaster_Crash ||
				blockIn instanceof Kawara || blockIn instanceof Kawara_Crash ||
				blockIn instanceof Namako || blockIn instanceof Namako_Crash ||
				blockIn instanceof NamakoB || blockIn instanceof NamakoB_Crash) {
			int color = ((Integer)stateIn.getValue(Base_JpFull.STAGE_0_15)).intValue();

			if (color != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(14)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}


		/** ハーフブロック **/
		if (blockIn instanceof Kawara_Slab) {
			if (blockIn != JPBlock_Blocks.KAWARA_SH_red) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.KAWARA_SH_red.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
					if (stack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
					if (stack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Plaster_Slab) {
			if (blockIn != JPBlock_Blocks.SHIKKUI_SH_red) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.SHIKKUI_SH_red.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
					if (stack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
					if (stack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Namako_Slab) {
			if (blockIn != JPBlock_Blocks.NAMAKO_SH_red) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKO_SH_red.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
					if (stack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
					if (stack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof NamakoB_Slab) {
			if (blockIn != JPBlock_Blocks.NAMAKOB_SH_red) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_SH_red.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
					if (stack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
					if (stack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}


		/** 階段 **/
		if (blockIn instanceof Kawara_Stairs) {
			if (blockIn != JPBlock_Blocks.KAWARA_ST_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.KAWARA_ST_red.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Plaster_Stairs) {
			if (blockIn != JPBlock_Blocks.SHIKKUI_ST_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.SHIKKUI_ST_red.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Namako_Stairs) {
			if (blockIn != JPBlock_Blocks.NAMAKO_ST_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKO_ST_red.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof NamakoB_Stairs) {
			if (blockIn != JPBlock_Blocks.NAMAKOB_ST_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_ST_red.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** トラス **/
		if (blockIn instanceof CTruss) {
			if (blockIn != Harbor_Blocks.TRUSS_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Harbor_Blocks.TRUSS_red.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 椅子・座布団・キャンドル **/
		if (blockIn instanceof CafeChair || blockIn instanceof BaseZabuton ||
				blockIn instanceof Candle || blockIn instanceof Lit_Candle) {
			int stage = ((Integer)stateIn.getValue(CafeChair.STAGE_0_15)).intValue();

			if (stage != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, stateIn.withProperty(CafeChair.STAGE_0_15, Integer.valueOf(14)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 行灯 **/
		if (blockIn instanceof Andon_1 || blockIn instanceof Andon_2 ||
				blockIn instanceof Andon_3 || blockIn instanceof Andon_4) {
			int stage = ((Integer)stateIn.getValue(BaseStage4_Face.STAGE_1_4)).intValue();

			if (!(blockIn == Lamp_Blocks.ANDON_4 && stage == 3)) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Lamp_Blocks.ANDON_4.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Lit_Andon_1 || blockIn instanceof Lit_Andon_2 ||
				blockIn instanceof Lit_Andon_3 || blockIn instanceof Lit_Andon_4) {
			int stage = ((Integer)stateIn.getValue(BaseStage4_Face.STAGE_1_4)).intValue();

			if (!(blockIn == Lamp_Blocks.LIT_ANDON_4 && stage == 3)) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_4.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** ソファ **/
		if (blockIn instanceof Sofa) {
			if (blockIn != Furniture_Blocks.SOFA_red && blockIn != Furniture_Blocks.SOFA_leather) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Furniture_Blocks.SOFA_red.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 座椅子 **/
		if (blockIn instanceof Zaisu) {
			if (blockIn != JPDeco_Blocks.ZAISU_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.ZAISU_red.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** のれん **/
		if (blockIn instanceof Noren) {
			if (blockIn != JPDeco_Blocks.NOREN_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.NOREN_red.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 布団 **/
		if (blockIn instanceof Futon) {
			if (blockIn != JPDeco_Blocks.FUTON_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.FUTON_red.getDefaultState()
						.withProperty(BaseStage2_Face.H_FACING, stateIn.getValue(BaseStage2_Face.H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, stateIn.getValue(BaseStage2_Face.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 畳 **/
		if (blockIn instanceof Tatami) {
			if (blockIn != JPDeco_Blocks.TATAMI_red && blockIn != JPDeco_Blocks.TATAMI) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_red.getDefaultState()
						.withProperty(BaseFacingSlabW.H_FACING, stateIn.getValue(BaseFacingSlabW.H_FACING))
						.withProperty(BaseFacingSlabW.DOUBLE, stateIn.getValue(BaseFacingSlabW.DOUBLE))
						.withProperty(BaseFacingSlabW.HALF, stateIn.getValue(BaseFacingSlabW.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Tatami_Y) {
			if (blockIn != JPDeco_Blocks.TATAMIY_red && blockIn != JPDeco_Blocks.TATAMIY) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.TATAMIY_red.getDefaultState()
						.withProperty(BaseFacingSlabW.H_FACING, stateIn.getValue(BaseFacingSlabW.H_FACING))
						.withProperty(BaseFacingSlabW.DOUBLE, stateIn.getValue(BaseFacingSlabW.DOUBLE))
						.withProperty(BaseFacingSlabW.HALF, stateIn.getValue(BaseFacingSlabW.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof BaseTatamiWood) {
			int color = ((Integer)stateIn.getValue(BaseTatamiWood.STAGE_0_15)).intValue();

			if (color != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(BaseTatamiWood.STAGE_0_15, Integer.valueOf(14)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(2, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		/** 傘 **/
		if (blockIn instanceof Wagasa) {
			if (blockIn != Garden_Blocks.KASA_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Garden_Blocks.KASA_red.getDefaultState(), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** ふすま HINGEはUPPERから H_FACINGはLOWERから **/
		IBlockState upState = worldIn.getBlockState(pos.up());
		IBlockState downState = worldIn.getBlockState(pos.down());

		if (blockIn instanceof Fusuma) {
			if (blockIn != Fusuma_Blocks.FUSUMA_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				if (stateIn.getValue(Fusuma.HALF) == HalfState.LOWER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMA_red.getDefaultState()
							.withProperty(Fusuma.H_FACING, stateIn.getValue(Fusuma.H_FACING))
							.withProperty(Fusuma.OPEN, stateIn.getValue(Fusuma.OPEN))
							.withProperty(Fusuma.HINGE, upState.getValue(Fusuma.HINGE))
							.withProperty(Fusuma.POWERED, upState.getValue(Fusuma.POWERED))
							.withProperty(Fusuma.HALF, HalfState.LOWER), 11);
					worldIn.setBlockState(pos.up(), Fusuma_Blocks.FUSUMA_red.getDefaultState()
							.withProperty(Fusuma.H_FACING, stateIn.getValue(Fusuma.H_FACING))
							.withProperty(Fusuma.OPEN, stateIn.getValue(Fusuma.OPEN))
							.withProperty(Fusuma.HINGE, upState.getValue(Fusuma.HINGE))
							.withProperty(Fusuma.POWERED, upState.getValue(Fusuma.POWERED))
							.withProperty(Fusuma.HALF, HalfState.UPPER), 11); }

				if (stateIn.getValue(Fusuma.HALF) == HalfState.UPPER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMA_red.getDefaultState()
							.withProperty(Fusuma.H_FACING, downState.getValue(Fusuma.H_FACING))
							.withProperty(Fusuma.OPEN, downState.getValue(Fusuma.OPEN))
							.withProperty(Fusuma.HINGE, stateIn.getValue(Fusuma.HINGE))
							.withProperty(Fusuma.POWERED, stateIn.getValue(Fusuma.POWERED))
							.withProperty(Fusuma.HALF, HalfState.UPPER), 11);
					worldIn.setBlockState(pos.down(), Fusuma_Blocks.FUSUMA_red.getDefaultState()
							.withProperty(Fusuma.H_FACING, downState.getValue(Fusuma.H_FACING))
							.withProperty(Fusuma.OPEN, downState.getValue(Fusuma.OPEN))
							.withProperty(Fusuma.HINGE, stateIn.getValue(Fusuma.HINGE))
							.withProperty(Fusuma.POWERED, stateIn.getValue(Fusuma.POWERED))
							.withProperty(Fusuma.HALF, HalfState.LOWER), 11); }

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Fusuma_B) {
			if (blockIn != Fusuma_Blocks.FUSUMAB_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				if (stateIn.getValue(Fusuma_B.HALF) == HalfState.LOWER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMAB_red.getDefaultState()
							.withProperty(Fusuma_B.H_FACING, stateIn.getValue(Fusuma_B.H_FACING))
							.withProperty(Fusuma_B.OPEN, stateIn.getValue(Fusuma_B.OPEN))
							.withProperty(Fusuma_B.HINGE, upState.getValue(Fusuma_B.HINGE))
							.withProperty(Fusuma_B.POWERED, upState.getValue(Fusuma_B.POWERED))
							.withProperty(Fusuma_B.HALF, HalfState.LOWER), 11);
					worldIn.setBlockState(pos.up(), Fusuma_Blocks.FUSUMAB_red.getDefaultState()
							.withProperty(Fusuma_B.H_FACING, stateIn.getValue(Fusuma_B.H_FACING))
							.withProperty(Fusuma_B.OPEN, stateIn.getValue(Fusuma_B.OPEN))
							.withProperty(Fusuma_B.HINGE, upState.getValue(Fusuma_B.HINGE))
							.withProperty(Fusuma_B.POWERED, upState.getValue(Fusuma_B.POWERED))
							.withProperty(Fusuma_B.HALF, HalfState.UPPER), 11); }

				if (stateIn.getValue(Fusuma_B.HALF) == HalfState.UPPER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMAB_red.getDefaultState()
							.withProperty(Fusuma_B.H_FACING, downState.getValue(Fusuma_B.H_FACING))
							.withProperty(Fusuma_B.OPEN, downState.getValue(Fusuma_B.OPEN))
							.withProperty(Fusuma_B.HINGE, stateIn.getValue(Fusuma_B.HINGE))
							.withProperty(Fusuma_B.POWERED, stateIn.getValue(Fusuma_B.POWERED))
							.withProperty(Fusuma_B.HALF, HalfState.UPPER), 11);
					worldIn.setBlockState(pos.down(), Fusuma_Blocks.FUSUMAB_red.getDefaultState()
							.withProperty(Fusuma_B.H_FACING, downState.getValue(Fusuma_B.H_FACING))
							.withProperty(Fusuma_B.OPEN, downState.getValue(Fusuma_B.OPEN))
							.withProperty(Fusuma_B.HINGE, stateIn.getValue(Fusuma_B.HINGE))
							.withProperty(Fusuma_B.POWERED, stateIn.getValue(Fusuma_B.POWERED))
							.withProperty(Fusuma_B.HALF, HalfState.LOWER), 11); }

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** 鴨居 **/
		if (blockIn instanceof KamoiPlaster_Oak) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_o) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_o.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Spruce) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_s) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_s.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Birch) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_b) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_b.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Jungle) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_j) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_j.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Acacia) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_a) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_a.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_DarkOak) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_d) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_d.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Sakura) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_saku) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_saku.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Kaede) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_kae) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_kae.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Ichoh) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_red_ich) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_red_ich.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** 粘土 **/
		if (blockIn instanceof WP_clay_color) {
			if (blockIn != WallPane_Blocks.WP_CLAY_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPane_Blocks.WP_CLAY_red.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof WP_clay) {
			CMEvents.soundPaint(worldIn, playerIn, pos);

			worldIn.setBlockState(pos, WallPane_Blocks.WP_CLAY_red.getDefaultState()
					.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

			if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
			if (stack.getMaxDamage() <= 1) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				stack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}

		/** ガラス **/
		if (blockIn instanceof WP_glass_stained) {
			if (blockIn != WallPane_Blocks.WP_GLASS_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPane_Blocks.WP_GLASS_red.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof WP_glass) {
			CMEvents.soundPaint(worldIn, playerIn, pos);

			worldIn.setBlockState(pos, WallPane_Blocks.WP_GLASS_red.getDefaultState()
					.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

			if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
			if (stack.getMaxDamage() <= 1) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				stack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}

		/** しっくい **/
		if (blockIn instanceof WP_plaster) {
			if (blockIn != WallPaneJP_Blocks.WP_PLASTER_red && blockIn != WallPaneJP_Blocks.WP_DIRTWALL) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPaneJP_Blocks.WP_PLASTER_red.getDefaultState()
						.withProperty(BaseStage2_WP.H_FACING, stateIn.getValue(BaseStage2_WP.H_FACING))
						.withProperty(BaseStage2_WP.STAGE_1_2, stateIn.getValue(BaseStage2_WP.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** なまこ **/
		if (blockIn instanceof WP_namako) {
			if (blockIn != WallPaneJP_Blocks.WP_NAMAKO_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPaneJP_Blocks.WP_NAMAKO_red.getDefaultState()
						.withProperty(BaseStage2_WP.H_FACING, stateIn.getValue(BaseStage2_WP.H_FACING))
						.withProperty(BaseStage2_WP.STAGE_1_2, stateIn.getValue(BaseStage2_WP.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof WP_namako_B) {
			if (blockIn != WallPaneJP_Blocks.WP_NAMAKOB_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPaneJP_Blocks.WP_NAMAKOB_red.getDefaultState()
						.withProperty(BaseStage2_WP.H_FACING, stateIn.getValue(BaseStage2_WP.H_FACING))
						.withProperty(BaseStage2_WP.STAGE_1_2, stateIn.getValue(BaseStage2_WP.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///6.1.2////////////////////
		if (blockIn instanceof Wall_Plaster || blockIn instanceof Wall_PlasterCrash ||
				blockIn instanceof Wall_Namako || blockIn instanceof Wall_NamakoCrash ||
				blockIn instanceof Wall_NamakoB || blockIn instanceof Wall_NamakoBCrash) {
			int color = ((Integer)stateIn.getValue(Base_Wall.STAGE_0_15)).intValue();

			if (color != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(Base_Wall.STAGE_0_15, Integer.valueOf(14))
						.withProperty(Base_Wall.NORTH, stateIn.getValue(Base_Wall.NORTH))
						.withProperty(Base_Wall.EAST, stateIn.getValue(Base_Wall.EAST))
						.withProperty(Base_Wall.SOUTH, stateIn.getValue(Base_Wall.SOUTH))
						.withProperty(Base_Wall.WEST, stateIn.getValue(Base_Wall.WEST)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		if (blockIn instanceof Wall_Kawara) {
			int color = ((Integer)stateIn.getValue(Base_WallKawara.STAGE_0_15)).intValue();

			if (color != 14) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(14))
						.withProperty(Base_WallKawara.NORTH, stateIn.getValue(Base_WallKawara.NORTH))
						.withProperty(Base_WallKawara.EAST, stateIn.getValue(Base_WallKawara.EAST))
						.withProperty(Base_WallKawara.SOUTH, stateIn.getValue(Base_WallKawara.SOUTH))
						.withProperty(Base_WallKawara.WEST, stateIn.getValue(Base_WallKawara.WEST)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		if (blockIn instanceof Wall_Sama) {
			if (blockIn != JPBlock_Blocks.SHIKKUI_SAMA_red && blockIn != JPBlock_Blocks.DIRTWALL_SAMA) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.SHIKKUI_SAMA_red.getDefaultState()
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4))
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stateIn.getValue(BaseStage4_Face.STAGE_1_4) == 1 || stateIn.getValue(BaseStage4_Face.STAGE_1_4) == 2) {
					if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
					if (stack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				if (stateIn.getValue(BaseStage4_Face.STAGE_1_4) != 1 && stateIn.getValue(BaseStage4_Face.STAGE_1_4) != 2) {
					if (stack.getMaxDamage() > 2) { stack.damageItem(2, playerIn); }
					if (stack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						stack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}
		
		///6.2.4////////////////////
		if (blockIn instanceof Curtain) {
			if (blockIn != Window_Blocks.CURTAIN_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Window_Blocks.CURTAIN_red.getDefaultState()
						.withProperty(Curtain.H_FACING, stateIn.getValue(Curtain.H_FACING))
						.withProperty(Curtain.STAGE_1_4, stateIn.getValue(Curtain.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		if (blockIn instanceof CurtainTall) {
			if (blockIn != Window_Blocks.CURTAINTALL_red) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				if (stateIn.getValue(CurtainTall.HALF) == HalfState.LOWER) {
					worldIn.setBlockState(pos, Window_Blocks.CURTAINTALL_red.getDefaultState()
							.withProperty(CurtainTall.H_FACING, stateIn.getValue(CurtainTall.H_FACING))
							.withProperty(CurtainTall.OPEN, stateIn.getValue(CurtainTall.OPEN))
							.withProperty(CurtainTall.HINGE, upState.getValue(CurtainTall.HINGE))
							.withProperty(CurtainTall.HALF, HalfState.LOWER), 11);
					worldIn.setBlockState(pos.up(), Window_Blocks.CURTAINTALL_red.getDefaultState()
							.withProperty(CurtainTall.H_FACING, stateIn.getValue(CurtainTall.H_FACING))
							.withProperty(CurtainTall.OPEN, stateIn.getValue(CurtainTall.OPEN))
							.withProperty(CurtainTall.HINGE, upState.getValue(CurtainTall.HINGE))
							.withProperty(CurtainTall.HALF, HalfState.UPPER), 11); }

				if (stateIn.getValue(CurtainTall.HALF) == HalfState.UPPER) {
					worldIn.setBlockState(pos, Window_Blocks.CURTAINTALL_red.getDefaultState()
							.withProperty(CurtainTall.H_FACING, downState.getValue(CurtainTall.H_FACING))
							.withProperty(CurtainTall.OPEN, downState.getValue(CurtainTall.OPEN))
							.withProperty(CurtainTall.HINGE, stateIn.getValue(CurtainTall.HINGE))
							.withProperty(CurtainTall.HALF, HalfState.UPPER), 11);
					worldIn.setBlockState(pos.down(), Window_Blocks.CURTAINTALL_red.getDefaultState()
							.withProperty(CurtainTall.H_FACING, downState.getValue(CurtainTall.H_FACING))
							.withProperty(CurtainTall.OPEN, downState.getValue(CurtainTall.OPEN))
							.withProperty(CurtainTall.HINGE, stateIn.getValue(CurtainTall.HINGE))
							.withProperty(CurtainTall.HALF, HalfState.LOWER), 11); }

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, stack); }

				if (stack.getMaxDamage() > 1) { stack.damageItem(1, playerIn); }
				if (stack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		/* 洗浄 -> 水桶はブロックで処理 */
		boolean mode = playerIn.capabilities.isCreativeMode;

		if (blockIn == Blocks.CAULDRON) {
			int level = stateIn.getValue(BlockCauldron.LEVEL);
			if (level != 0) {
				((BlockCauldron)blockIn).setWaterLevel(worldIn, pos, stateIn, level - 1);
				CMEvents.soundWash(worldIn, playerIn, pos);

				/** add Item **/
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }

				if (!mode) { stack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		return EnumActionResult.PASS;
	}

}
