package com.twice.optipvp;

import net.minecraft.client.MinecraftClient;

/**
 * First milestone engine:
 * - tracks frame-times in-session
 * - applies safe, reversible option tweaks when spikes are detected
 * - keeps logic centralized so future mixins can target specific lag sources
 */
public final class AdaptivePerformanceEngine {
    private static final int SAMPLE_WINDOW = 120;
    private static final long SPIKE_NS = 25_000_000L; // ~40 FPS frame

    private final OptimizationProfile profile = new OptimizationProfile();
    private final long[] frameSamples = new long[SAMPLE_WINDOW];

    private int cursor = 0;
    private long lastFrameNs = System.nanoTime();
    private int cooldownTicks = 0;

    public void tick(MinecraftClient client) {
        long now = System.nanoTime();
        long frameTime = now - lastFrameNs;
        lastFrameNs = now;

        frameSamples[cursor] = frameTime;
        cursor = (cursor + 1) % SAMPLE_WINDOW;

        if (cooldownTicks > 0) {
            cooldownTicks--;
            return;
        }

        if (shouldApplyEmergencyTuning() && profile.isEnabled(LagSource.ENTITY_RENDER_SPIKES)) {
            applyEmergencyTuning(client);
            cooldownTicks = 100;
        }
    }

    private boolean shouldApplyEmergencyTuning() {
        int spikes = 0;

        for (long sample : frameSamples) {
            if (sample > SPIKE_NS) {
                spikes++;
            }
        }

        return spikes > 18;
    }

    private void applyEmergencyTuning(MinecraftClient client) {
        // Safe default action: reduce particle load quickly if frame spikes persist.
        // This is low-risk and can be expanded with additional strategy modules.
        if (profile.isEnabled(LagSource.PARTICLE_OVERDRAW)) {
            client.options.getParticles().setValue(net.minecraft.client.option.ParticlesMode.DECREASED);
            TwiceOptiPvpMod.LOGGER.info("TwiceOptiPvp: emergency tuning applied (particles -> DECREASED)");
        }
    }
}
