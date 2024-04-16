package com.ayutaki.chinjufumod.entity;

import java.util.List;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SitableEntity extends Entity {

	private BlockPos source;

	public SitableEntity(EntityType<SitableEntity> type, World worldIn) {
		super(type, worldIn);
		this.noPhysics = true;
	}

	private SitableEntity(EntityType<SitableEntity> type, World worldIn, BlockPos source, double yOffset) {
		this(type, worldIn);
		this.source = source;
		this.setPos(source.getX() + 0.5, source.getY() + yOffset, source.getZ() + 0.5);
	}

	@Override
	protected void defineSynchedData() { }

	@Override
	public void tick() {

		super.tick();
		if(source == null) {
			source = this.blockPosition();
		}

		if(!level.isClientSide) {

			if(this.getPassengers().isEmpty() || this.level.isEmptyBlock(source)) {
				this.remove();
				this.level.updateNeighbourForOutputSignal(blockPosition(), this.level.getBlockState(blockPosition()).getBlock());
			}
		}
	}

	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) { }

	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) { }

	@Override
	public double getPassengersRidingOffset() {
		return 0.0;
	}

	public BlockPos getSource() {
		return source;
	}

	@Override
	protected boolean canAddPassenger(Entity entity) {
		return true;
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static ActionResultType create(World worldIn, BlockPos pos, double yOffset, PlayerEntity playerIn) {

		if(!worldIn.isClientSide) {

			List<SitableEntity> seats = worldIn.getEntitiesOfClass(SitableEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));

			if(seats.isEmpty()) {
				SitableEntity seat = new SitableEntity(EntityTypes_CM.SITABLE, worldIn, pos, yOffset);
				worldIn.addFreshEntity(seat);
				playerIn.startRiding(seat, false);
			}
		}
		return ActionResultType.SUCCESS;
	}

}
