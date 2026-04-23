package com.twice.optimizer;

import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the 20 lag-cleanup switches requested for PvP-focused gameplay.
 * For now we keep actions safe + reversible (no packet hacks, no unfair cheats).
 */
public class OptimizationProfile {
    private final List<OptimizationAction> actions;

    public OptimizationProfile() {
        this.actions = new ArrayList<>();
    }

    public static OptimizationProfile turboPreset() {
        OptimizationProfile profile = new OptimizationProfile();

        profile.actions.add(new StubAction("01_camera_input_pipeline"));
        profile.actions.add(new StubAction("02_camera_smoothing_disable"));
        profile.actions.add(new StubAction("03_mouse_poll_priority"));
        profile.actions.add(new StubAction("04_entity_shadow_cull"));
        profile.actions.add(new StubAction("05_non_combat_entity_cull"));
        profile.actions.add(new StubAction("06_particle_budget_pvp"));
        profile.actions.add(new StubAction("07_chunk_rebuild_budget"));
        profile.actions.add(new StubAction("08_transparent_block_batching"));
        profile.actions.add(new StubAction("09_animation_frame_skip_for_far_entities"));
        profile.actions.add(new StubAction("10_dynamic_lod_entities"));
        profile.actions.add(new StubAction("11_dynamic_lod_blocks"));
        profile.actions.add(new StubAction("12_weather_render_disable_in_fight"));
        profile.actions.add(new StubAction("13_fog_cost_reduce"));
        profile.actions.add(new StubAction("14_light_update_throttle"));
        profile.actions.add(new StubAction("15_block_entity_ticker_budget"));
        profile.actions.add(new StubAction("16_chunk_upload_queue_tune"));
        profile.actions.add(new StubAction("17_gpu_state_change_reduce"));
        profile.actions.add(new StubAction("18_overlay_render_cleanup"));
        profile.actions.add(new StubAction("19_server_particle_filter"));
        profile.actions.add(new StubAction("20_auto_profile_by_fps"));

        return profile;
    }

    public void apply(MinecraftClient client) {
        for (OptimizationAction action : actions) {
            action.apply(client);
        }
    }
}
