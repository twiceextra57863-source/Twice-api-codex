package com.twice.optimizer;

import net.minecraft.client.MinecraftClient;

/**
 * Temporary placeholder for each optimization module.
 * Replacing these with real implementations is the next milestone.
 */
public record StubAction(String id) implements OptimizationAction {
    @Override
    public void apply(MinecraftClient client) {
        // Intentional no-op while scaffolding the full optimization pipeline.
        // This keeps startup stable and creates extension points for each lag fix.
    }
}
