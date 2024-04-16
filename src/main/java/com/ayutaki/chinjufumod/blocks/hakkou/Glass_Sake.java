package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Glass_Sake extends Base_Glass {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(6.8D, 0.0D, 6.8D, 9.2D, 3.2D, 9.2D);
	protected static final VoxelShape AABB_DOWN = Block.box(6.8D, -8.0D, 6.8D, 9.2D, 0.1D, 9.2D);

	public Glass_Sake(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_0_2);

		if (i != 2) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundDrink(worldIn, pos);
				
				if (i == 0) { this.take1(playerIn); }
				if (i == 1) { this.take2(playerIn); }
				worldIn.setBlock(pos, state.setValue(Base_Glass.STAGE_0_2, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 2) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	private void take1(PlayerEntity playerIn) {
		if (this == Hakkou_Blocks.NAMASAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1200, 0));
			playerIn.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 1400, 0)); }
		
		if (this == Hakkou_Blocks.SAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1200, 1));
			playerIn.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 1400, 0)); }
		
		if (this == Hakkou_Blocks.JUKUSAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1200, 2));
			playerIn.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 1200, 0)); }

		if (this == Hakkou_Blocks.AMAZAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 1200, 0)); }
	}
	
	private void take2(PlayerEntity playerIn) {
		if (this == Hakkou_Blocks.NAMASAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1500, 0));
			playerIn.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 1720, 0)); }
		
		if (this == Hakkou_Blocks.SAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1500, 1));
			playerIn.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 1720, 0)); }
		
		if (this == Hakkou_Blocks.JUKUSAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1500, 2));
			playerIn.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 1500, 0)); }

		if (this == Hakkou_Blocks.AMAZAKEGLASS) { 
			playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 1200, 0)); }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		/** !down= true : false **/
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Hakkou_Blocks.NAMASAKEGLASS) { return new ItemStack(Items_Teatime.NAMASAKEGLASS, 1); }
		if (this == Hakkou_Blocks.SAKEGLASS) { return new ItemStack(Items_Teatime.SAKEGLASS, 1); }
		if (this == Hakkou_Blocks.JUKUSAKEGLASS) { return new ItemStack(Items_Teatime.JUKUSAKEGLASS, 1); }
		if (this == Hakkou_Blocks.AMAZAKEGLASS) { return new ItemStack(Items_Teatime.AMAZAKEGLASS, 1); }
		return null;
	}
}
