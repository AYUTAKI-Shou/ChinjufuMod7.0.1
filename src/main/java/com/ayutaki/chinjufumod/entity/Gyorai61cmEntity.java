package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn( value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class Gyorai61cmEntity extends ThrowableEntity implements IRendersAsItem {

	protected static final DataParameter<ItemStack> DATA_ITEM_STACK = EntityDataManager.createKey(Gyorai61cmEntity.class, DataSerializers.ITEMSTACK);
	protected static final DataParameter<Byte> ID_FLAGS = EntityDataManager.createKey(Gyorai61cmEntity.class, DataSerializers.BYTE);
	private ItemStack projectile = new ItemStack(Items_Weapon.GYORAI_61cm);
	private double baseDamage = 10.0D;
	
	public Gyorai61cmEntity(EntityType<Gyorai61cmEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public Gyorai61cmEntity(LivingEntity entity, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.GYORAI61, entity, worldIn);
		this.projectile = stack.copy();
	}

	@Override
	protected void registerData() {
		this.getDataManager().register(DATA_ITEM_STACK, ItemStack.EMPTY);
		this.dataManager.register(ID_FLAGS, (byte)0);
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

		/** Particle **/
		double d0 = this.getPosX();
		double d1 = this.getPosY();
		double d2 = this.getPosZ();
		this.world.addParticle(ParticleTypes.CLOUD, d0, d1, d2, 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!world.isRemote && ticksExisted >= 60) { dropAndKill(); }
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
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
			Block block = world.getBlockState(blockResult.getPos()).getBlock();

			if (block == Blocks.AIR || block == Blocks.WATER || block instanceof BushBlock || block instanceof LeavesBlock) {
				return; }

			else {
				this.hitProcess();
				this.remove(); }
			break;
		}

		case ENTITY: {
			EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
			/** Attack Mobs. **/
			double atackDamage = this.baseDamage;
			float criticalA = (this.rand.nextInt(3) == 0)? 1.2F : 1.0F;
			float criticalB = (this.rand.nextInt(9) == 0)? 1.1F : 0.9F;
			float addGYORAI = this.isSuirai()? criticalA : criticalB;

			entityResult.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)atackDamage * addGYORAI);

			this.hitProcess();
			this.remove();
			break;
		}
		default: break; }
	}

	@Override
	protected float getGravityVelocity() {
		if (this.inWater) { return 0F; }
		return 0.01F;
	}

	/* Effect of water on Entity Speed. */
	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	public boolean isPushedByWater() {
		return false;
	}
	
	public void setSuirai(boolean flag) {
		this.setFlag(1, flag);
	}
	
	protected void setFlag(int value, boolean flag) {
		byte b0 = this.dataManager.get(ID_FLAGS);
		
		if (flag) { this.dataManager.set(ID_FLAGS, (byte)(b0 | value)); } 
		else { this.dataManager.set(ID_FLAGS, (byte)(b0 & ~value)); }
	}
	
	public boolean isSuirai() {
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
		
		compound.putDouble("damage", this.baseDamage);
		compound.putBoolean("suirai", this.isSuirai());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		ItemStack stack = ItemStack.read(compound.getCompound("Item"));
		this.setItem(stack);
		
		if (compound.contains("damage", 99)) {
			this.baseDamage = compound.getDouble("damage"); }
		
		this.setSuirai(compound.getBoolean("suirai"));
	}

	public void setBaseDamage(double damage) {
		this.baseDamage = damage;
	}
	
	public double getBaseDamage() {
		return this.baseDamage;
	}
	
	/* Hit */
	public void hitProcess() {
		if (!this.world.isRemote) {
			float addGYORAI = this.isSuirai()? 1.5F : 1.0F;
			this.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), addGYORAI, false, Explosion.Mode.NONE); }
		
		this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F / (this.rand.nextFloat() * 0.2F + 0.9F));
		this.world.setEntityState(this, (byte)3);
	}
	
	public Explosion_CM createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		return this.explode(entityIn, (DamageSource)null, xIn, yIn, zIn, value, flag, modeIn);
	}

	public Explosion_CM explode(@Nullable Entity entityIn, @Nullable DamageSource damage, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		Explosion_CM explosion = new Explosion_CM(world, this, xIn, yIn, zIn, value, flag, modeIn);
		explosion.doExplosionA();
		explosion.doExplosionB(true);
		return explosion;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for(int i = 0; i < 4; ++i) {
				this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D); }
		}
	}
}
