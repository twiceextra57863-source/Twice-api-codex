package com.twice.optipvp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class TwiceOptiPvpClient implements ClientModInitializer {
    private final AdaptivePerformanceEngine engine = new AdaptivePerformanceEngine();

    @Override
    public void onInitializeClient() {
        TwiceOptiPvpMod.LOGGER.info("TwiceOptiPvp client optimizer starting...");
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
    }

    private void onTick(MinecraftClient client) {
        if (client.world == null || client.player == null) {
            return;
        }

        engine.tick(client);
    }
}
