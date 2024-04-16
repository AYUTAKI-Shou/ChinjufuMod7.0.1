package com.ayutaki.chinjufumod.entity.helper;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Vector3 {
	
	public static final Vec3 ONE = new Vec3(1, 1, 1);

	private Vector3() {}

	public static Vec3 fromEntityCenter(Entity entityIn) {
		return new Vec3(entityIn.getX(), entityIn.getY() + entityIn.getBbHeight() / 2, entityIn.getZ());
	}

	/** Rotates {@code v} by {@code theta} radians around {@code axis} */
	public static Vec3 rotate(Vec3 v3, double theta, Vec3 axis) {
		if (Mth.equal(theta, 0)) {
			return v3;
		}

		// Rodrigues rotation formula
		Vec3 k = axis.normalize();

		float cosTheta = Mth.cos((float) theta);
		Vec3 firstTerm = v3.scale(cosTheta);
		Vec3 secondTerm = k.cross(v3).scale(Mth.sin((float) theta));
		Vec3 thirdTerm = k.scale(k.dot(v3) * (1 - cosTheta));
		return new Vec3(firstTerm.x + secondTerm.x + thirdTerm.x,
				firstTerm.y + secondTerm.y + thirdTerm.y,
				firstTerm.z + secondTerm.z + thirdTerm.z);
	}

	public static AABB boxForRange(Vec3 v3, double range) {
		return boxForRange(v3, range, range, range);
	}

	public static AABB boxForRange(Vec3 v3, double rangeX, double rangeY, double rangeZ) {
		return new AABB(v3.x - rangeX, v3.y - rangeY, v3.z - rangeZ, v3.x + rangeX, v3.y + rangeY, v3.z + rangeZ);
	}
}
