package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.entity.helper.Vector3;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn( value = Dist.CLIENT, _interface = IRendersAsItem.class)
public abstract class AbstractKK_Entity extends ThrowableEntity implements IRendersAsItem {

	protected static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.createKey(AbstractKK_Entity.class, DataSerializers.ITEMSTACK);
	protected static final DataParameter<Byte> ID_FLAGS = EntityDataManager.createKey(AbstractKK_Entity.class, DataSerializers.BYTE);
	protected static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(AbstractKK_Entity.class, DataSerializers.VARINT);
	
	protected AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, World worldIn) {
		super(type, worldIn);
	}

	protected AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, double x, double y, double z, World worldIn) {
		this(type, worldIn);
		this.setPosition(x, y, z);
	}
	public AbstractKK_Entity(EntityType<? extends AbstractKK_Entity> type, LivingEntity livingEntityIn, World worldIn) {
		this(type, livingEntityIn.getPosX(), livingEntityIn.getPosYEye() - (double)0.1F, livingEntityIn.getPosZ(), worldIn);
		this.owner = livingEntityIn;
		//this.ownerId = livingEntityIn.getUniqueID();
		if (Config_CM.getInstance().lowSound()) { this.playSound(SoundEvents_CM.KK_PROPELLER12, 1.5F, 1.0F); }
	}
	
	@Override
	protected void registerData() {
		this.getDataManager().register(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.dataManager.register(ID_FLAGS, (byte)0);
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

	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance) {
		double d0 = this.getBoundingBox().getAverageEdgeLength() * 4.0D;
		if (Double.isNaN(d0)) { d0 = 4.0D; }

		d0 = d0 * 64.0D;
		return distance < d0 * d0;
	}
		
	@Override
	public void tick() {
		super.tick();

		/** PROPELLER Sound **/
		if (!Config_CM.getInstance().lowSound()) {
			if (this.ticksExisted % 3 == 0 ) { this.playSound(SoundEvents_CM.KK_PROPELLER, 1.5F, 1.0F); } }

		/** Server state control **/
		if (!world.isRemote) {
			Entity thrower = getThrower();
			
			/** 水による未帰還も多いため削除
			if (isInWater()) {
				entityDropItem(getItemStack(), 0.5f);
				this.playSound(SoundEvents_CM.WATER_SPLASH, 2.0F, 1.0F);
				this.remove();
			} **/
			
			if (isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					setMotion(motion.toVec3D());

					if (getDistanceSq(thrower) < 2) { dropAndKill(); } }
			}

			if (!isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null && ticksExisted >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
		
		Vec3d vec3d = this.getMotion();
		double d0 = this.getPosX() + vec3d.x;
		double d1 = this.getPosY() + vec3d.y;
		double d2 = this.getPosZ() + vec3d.z;
		float f = MathHelper.sqrt(horizontalMag(vec3d));
		this.rotationYaw = (float)(MathHelper.atan2(vec3d.x, vec3d.z) * (double)(180F / (float)Math.PI));

		for(this.rotationPitch = (float)(MathHelper.atan2(vec3d.y, (double)f) * (double)(180F / (float)Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
			; }

		while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
			this.prevRotationPitch += 360.0F; }

		while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
			this.prevRotationYaw -= 360.0F; }

		while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
			this.prevRotationYaw += 360.0F; }

		this.rotationPitch = MathHelper.lerp(0.2F, this.prevRotationPitch, this.rotationPitch);
		this.rotationYaw = MathHelper.lerp(0.2F, this.prevRotationYaw, this.rotationYaw);
		float f1;
		if (this.isInWater()) {
			for(int i = 0; i < 4; ++i) {
				this.world.addParticle(ParticleTypes.BUBBLE, d0 - vec3d.x * 0.25D, d1 - vec3d.y * 0.25D, d2 - vec3d.z * 0.25D, vec3d.x, vec3d.y, vec3d.z); }
			f1 = 0.8F;
		} 
		 
		else { f1 = 0.99F; }

		this.setMotion(vec3d.scale((double)f1));
		if (!this.hasNoGravity()) {
			Vec3d vec3d1 = this.getMotion();
			this.setMotion(vec3d1.x, vec3d1.y - (double)this.getGravityVelocity(), vec3d1.z); }

		this.setPosition(d0, d1, d2);
	}
	
	protected float getGravityVelocity() {
		return 0.0F;
	}
	
	/* Drop item and Kill entity. */
	protected void dropAndKill() {
		ItemStack stack = getItemStack();
		
		Entity thrower = getThrower();
		PlayerEntity playerIn = (PlayerEntity)thrower;
		if (thrower != null && !playerIn.abilities.isCreativeMode) { stack.attemptDamageItem(1, rand, null); }
		
		ItemEntity item = new ItemEntity(world, getPosX(), getPosY(), getPosZ(), stack);
		world.addEntity(item);
		remove();
	}

	protected abstract ItemStack getItemStack();

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {
		RayTraceResult.Type resultType = result.getType();
		
		if (resultType == RayTraceResult.Type.ENTITY) {
			this.onHitEntity((EntityRayTraceResult)result); }
		
		else if (resultType == RayTraceResult.Type.BLOCK) {
			BlockRayTraceResult blockResult = (BlockRayTraceResult) result;
			Block block = world.getBlockState(blockResult.getPos()).getBlock();
			/** Go through the blocks. **/
			if (block instanceof Block) { return; }
		}
	}
	
	/** Collision to Entity. **/
	protected void onHitEntity(EntityRayTraceResult result) { }
	
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

	protected int getEntityToReturnTo() {
		return dataManager.get(RETURN_TO);
	}

	protected void setEntityToReturnTo(int entityID) {
		dataManager.set(RETURN_TO, entityID);
	}

	/* Carrier */
	public void setCarrier(boolean flag) {
		this.setFlag(1, flag);
	}
	
	protected void setFlag(int value, boolean flag) {
		byte b0 = this.dataManager.get(ID_FLAGS);
		
		if (flag) { this.dataManager.set(ID_FLAGS, (byte)(b0 | value)); } 
		else { this.dataManager.set(ID_FLAGS, (byte)(b0 & ~value)); }
	}
	
	public boolean isCarrier() {
		byte b0 = this.dataManager.get(ID_FLAGS);
		return (b0 & 1) != 0;
	}
	
	/* DATA_ITEM_STACK */
	public void setItem(ItemStack stack) {
		if (stack.getItem() != this.getDefaultItem() || stack.hasTag()) {
			this.getDataManager().set(DATA_ITEM_STACK, Util.make(stack.copy(), (consumer) -> {
				consumer.setCount(1);
			}));
		}
	}

	protected abstract Item getDefaultItem();

	protected ItemStack getItemRaw() {
		return this.getDataManager().get(DATA_ITEM_STACK);
	}

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

		compound.putBoolean("carrier", this.isCarrier());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		ItemStack stack = ItemStack.read(compound.getCompound("Item"));
		this.setItem(stack);

		this.setCarrier(compound.getBoolean("carrier"));
	}
}
