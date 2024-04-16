package com.ayutaki.chinjufumod.proxy;

import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;

/* CommonProxyで扱うメソッドを約束
 * Promises methods to handle in CommonProxy. */
public interface ProxyInterface {

	default void preInit() {};

	default void init() {};

	default void postInit() {};

	boolean isSinglePlayer();

	boolean isDedicatedServer();

	default void initTileEntitySpecialRenderer() { }

	default void spawnParticle(ParticleTypes_CM particleType, double x, double y, double z, double velX, double velY, double velZ) { }
}
