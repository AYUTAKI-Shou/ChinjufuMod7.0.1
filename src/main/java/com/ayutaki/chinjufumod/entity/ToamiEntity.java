package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn( value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class ToamiEntity extends ThrowableEntity implements IRendersAsItem {

	private static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.createKey(ToamiEntity.class, DataSerializers.ITEMSTACK);
	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(ToamiEntity.class, DataSerializers.VARINT);
	private ItemStack projectile = new ItemStack(Items_Teatime.TOAMI);

	public ToamiEntity(EntityType<ToamiEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public ToamiEntity(LivingEntity entity, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.TOAMI, entity, worldIn);
		this.projectile = stack.copy();
	}

	@Override
	protected void registerData() {
		this.getDataManager().register(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.dataManager.register(RETURN_TO, -1);
	}
	
	/* Flying render */
	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void tick() {
		super.tick();

		if (!world.isRemote) {
			Entity thrower = getThrower();
			
			if (isReturning()) { 
				if (thrower == null && ticksExisted > 60) { dropAndKill(); }
				
				if (thrower != null) { returnAndKill(); } }
		
			if (!isReturning()) {
				if (thrower == null && ticksExisted > 60) { dropAndKill(); }
				
				if (thrower != null && ticksExisted >= 15) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	/* Drop item and Kill entity. */
	private void returnAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getThrower();
		PlayerEntity playerIn = (PlayerEntity)thrower;
		if (thrower != null && !playerIn.abilities.isCreativeMode) { stack.attemptDamageItem(1, rand, null); }
		
		ItemEntity item = new ItemEntity(world, thrower.getPosX(), thrower.getPosY(), thrower.getPosZ(), stack);
		world.addEntity(item);
		remove();
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getThrower();
		PlayerEntity playerIn = (PlayerEntity)thrower;
		if (thrower != null && !playerIn.abilities.isCreativeMode) { stack.attemptDamageItem(1, rand, null); }
		
		ItemEntity item = new ItemEntity(world, getPosX(), getPosY(), getPosZ(), stack);
		world.addEntity(item);
		remove();
	}
	
	/* stack.copy() で耐久値を反映 */
	private ItemStack getItemStack() {
		return this.projectile.copy();
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {

		switch (result.getType()) {
		case BLOCK: {
			BlockRayTraceResult blockResult = (BlockRayTraceResult) result;
			BlockState state = world.getBlockState(blockResult.getPos());
			Block block = state.getBlock();

			if (state.getMaterial().isReplaceable() || block == Blocks.KELP ||
					block == Crop_Blocks.SHIKAKE_AMI || block == Crop_Blocks.YOUSHOKU_AMI) { return; }
			
			if (!state.getMaterial().isReplaceable() && block != Blocks.KELP &&
					block != Crop_Blocks.SHIKAKE_AMI && block != Crop_Blocks.YOUSHOKU_AMI) { 
				setEntityToReturnTo(getEntityToReturnTo() + 1); }
			break;
		}

		case ENTITY: {
			EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
			LivingEntity thrower = getThrower();

			if (isReturning()) { return; }
			
			if (!isReturning()) { 
				if (!world.isRemote && entityResult.getEntity() instanceof LivingEntity) {
					
					if (entityResult.getEntity() instanceof CodEntity) {
						entityResult.getEntity().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 2.0F, 1.0F);
						entityResult.getEntity().remove();
						thrower.entityDropItem(new ItemStack(Items.COD)); }
					
					if (entityResult.getEntity() instanceof SalmonEntity) {
						entityResult.getEntity().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 2.0F, 1.0F);
						entityResult.getEntity().remove();
						thrower.entityDropItem(new ItemStack(Items.SALMON)); }
					
					if (entityResult.getEntity() instanceof TropicalFishEntity) {
						entityResult.getEntity().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 2.0F, 1.0F);
						entityResult.getEntity().remove();
						thrower.entityDropItem(new ItemStack(Items.TROPICAL_FISH)); }
					
					if (entityResult.getEntity() instanceof PufferfishEntity) {
						entityResult.getEntity().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 2.0F, 1.0F);
						entityResult.getEntity().remove();
						thrower.entityDropItem(new ItemStack(Items.PUFFERFISH));
						((LivingEntity) thrower).addPotionEffect(new EffectInstance(Effects.POISON, 60, 0)); }
					
					if (entityResult.getEntity() instanceof SquidEntity) {
						entityResult.getEntity().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 2.0F, 1.0F);
						entityResult.getEntity().remove();
						thrower.entityDropItem(new ItemStack(Items_Teatime.IKA)); }
					
					if (!(entityResult.getEntity() instanceof CodEntity) && !(entityResult.getEntity() instanceof SalmonEntity) &&
							!(entityResult.getEntity() instanceof TropicalFishEntity) && !(entityResult.getEntity() instanceof PufferfishEntity) &&
							!(entityResult.getEntity() instanceof SquidEntity)) {
						
						entityResult.getEntity().playSound(SoundEvents.ENTITY_GENERIC_HURT, 2.0F, 1.0F);
						((LivingEntity) entityResult.getEntity()).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300, 1));
						setEntityToReturnTo(getEntityToReturnTo() + 1); }
				}
			}
			break;
		}
		
		default: break;
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}
	
	/* Effect of water on Entity Speed. */
	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	public boolean isPushedByWater() {
		return false;
	}

	/* RETURN_TO */
	public boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	private int getEntityToReturnTo() {
		return dataManager.get(RETURN_TO);
	}

	private void setEntityToReturnTo(int entityID) {
		dataManager.set(RETURN_TO, entityID);
	}

	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		if (stack.getItem() != this.getDefaultItem() || stack.hasTag()) {
			this.getDataManager().set(DATA_ITEM_STACK, Util.make(stack.copy(), (consumer) -> {
				consumer.setCount(1);
			}));
		}
	}

	protected Item getDefaultItem() {
		return this.projectile.getItem();
	}

	protected ItemStack getItemRaw() {
		return this.getDataManager().get(DATA_ITEM_STACK);
	}

	/* implements IRendersAsItem で必須 */
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		ItemStack stack = this.getItemRaw();
		return stack.isEmpty() ? new ItemStack(this.getDefaultItem()) : stack;
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		ItemStack stack = this.getItemRaw();
		if (!stack.isEmpty()) {
			compound.put("Item", stack.write(new CompoundNBT())); }
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		ItemStack stack = ItemStack.read(compound.getCompound("Item"));
		this.setItem(stack);
	}
}
