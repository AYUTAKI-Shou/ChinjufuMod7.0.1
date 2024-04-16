package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Glass_Sake extends Base_Glass {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(6.8D, 0.0D, 6.8D, 9.2D, 3.2D, 9.2D);
	protected static final VoxelShape AABB_DOWN = Block.box(6.8D, -8.0D, 6.8D, 9.2D, 0.1D, 9.2D);
	
	public Glass_Sake(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
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
		return InteractionResult.SUCCESS;
	}
	
	private void take1(Player playerIn) {
		if (this == Hakkou_Blocks.NAMASAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0));
			playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1400, 0)); }
		
		if (this == Hakkou_Blocks.SAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1));
			playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1400, 0)); }
		
		if (this == Hakkou_Blocks.JUKUSAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2));
			playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 0)); }

		if (this == Hakkou_Blocks.AMAZAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0)); }
	}
	
	private void take2(Player playerIn) {
		if (this == Hakkou_Blocks.NAMASAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1500, 0));
			playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1720, 0)); }
		
		if (this == Hakkou_Blocks.SAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1500, 1));
			playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1720, 0)); }
		
		if (this == Hakkou_Blocks.JUKUSAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1500, 2));
			playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1500, 0)); }

		if (this == Hakkou_Blocks.AMAZAKEGLASS.get()) { 
			playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0)); }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB_BOX : AABB_DOWN;
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Hakkou_Blocks.NAMASAKEGLASS.get()) { return new ItemStack(Items_Teatime.NAMASAKEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.SAKEGLASS.get()) { return new ItemStack(Items_Teatime.SAKEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.JUKUSAKEGLASS.get()) { return new ItemStack(Items_Teatime.JUKUSAKEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.AMAZAKEGLASS.get()) { return new ItemStack(Items_Teatime.AMAZAKEGLASS.get(), 1); }
		return null;
	}
}
