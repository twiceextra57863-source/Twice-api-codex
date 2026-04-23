package com.twice.optimizer;

import net.minecraft.client.MinecraftClient;

@FunctionalInterface
public interface OptimizationAction {
    void apply(MinecraftClient client);
}
