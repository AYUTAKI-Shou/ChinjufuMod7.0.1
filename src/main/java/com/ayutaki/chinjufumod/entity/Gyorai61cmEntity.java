package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Gyorai61cmEntity extends EntityThrowable {

	protected static final DataParameter<Byte> ID_FLAGS = EntityDataManager.<Byte>createKey(Gyorai61cmEntity.class, DataSerializers.BYTE);
	private ItemStack stack = ItemStack.EMPTY;
	protected double baseDamage = 10.0D;
	
	public Gyorai61cmEntity(World worldIn) {
		super(worldIn);
		setSize(1.0F, 1.0F);
	}

	public Gyorai61cmEntity(World worldIn, EntityLivingBase entity, ItemStack stack) {
		super(worldIn, entity);
		this.stack = stack.copy();
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ID_FLAGS, Byte.valueOf((byte)0));
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		/**パーティクル **/
		this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!world.isRemote && ticksExisted >= 60) { dropAndKill(); }
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
		EntityItem item = new EntityItem(world, posX, posY, posZ, stack);
		world.spawnEntity(item);
		setDead();
	}

	private ItemStack getItemStack() {
		return this.stack.copy();
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {

		switch (result.typeOfHit) {
		case BLOCK: {
			Block block = world.getBlockState(result.getBlockPos()).getBlock();
			/** Go through the blocks. **/
			if (block == Blocks.AIR || block == Blocks.WATER || block instanceof BlockBush || block instanceof BlockLeaves) {
				return;
			}

			else {
				this.hitProcess();
				this.setDead();
			}
			break;
		}

		case ENTITY: {
			if (!world.isRemote && result.entityHit != null && result.entityHit instanceof EntityLivingBase && result.entityHit != getThrower()) {

				/** Attack Mobs. **/
				double atackDamage = this.baseDamage;
				float criticalA = (this.rand.nextInt(3) == 0)? 1.2F : 1.0F;
				float criticalB = (this.rand.nextInt(9) == 0)? 1.1F : 0.9F;
				float addGYORAI = this.isSuirai()? criticalA : criticalB;
				
				result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)atackDamage * addGYORAI);

				this.hitProcess();
				this.setDead();
			}
			break;
		}

		default: break;
		}
	}

	@Override
	protected float getGravityVelocity() {
		if (this.inWater) { return 0F; }
		return 0.01F;
	}

	/* 水による速度への影響 */
	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	public boolean isPushedByWater() {
		return false;
	}

	/* Suirai */
	public void setSuirai(boolean flag) {
		byte b0 = ((Byte)this.dataManager.get(ID_FLAGS)).byteValue();

		if (flag) { this.dataManager.set(ID_FLAGS, Byte.valueOf((byte)(b0 | 1))); }
		else { this.dataManager.set(ID_FLAGS, Byte.valueOf((byte)(b0 & -2))); }
	}

	public boolean isSuirai() {
		byte b0 = ((Byte)this.dataManager.get(ID_FLAGS)).byteValue();
		return (b0 & 1) != 0;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setTag("fly_stack", stack.writeToNBT(new NBTTagCompound()));
		compound.setDouble("damage", this.baseDamage);
		compound.setBoolean("suirai", this.isSuirai());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		stack = new ItemStack(compound.getCompoundTag("fly_stack"));
		if (compound.hasKey("damage", 99)) {
			this.baseDamage = compound.getDouble("damage");
		}
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
			Explosion_CM explosion = new Explosion_CM(this.world, this, this.posX, this.posY, this.posZ, addGYORAI, false, false);
			explosion.doExplosionA();
			explosion.doExplosionB(true); }
		
		this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
		this.world.setEntityState(this, (byte)3);
	}
	
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for(int i = 0; i < 4; ++i) {
			this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
		}
	}
}
