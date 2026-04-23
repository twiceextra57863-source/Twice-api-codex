package com.twice.optimizer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

/**
 * First milestone bootstrap for your optimization mod.
 *
 * NOTE: 2x FPS cannot be guaranteed on every system/map/shader stack.
 * This class gives you a stable base and in-game toggling so we can iterate.
 */
public class TwicePvpOptimizerClient implements ClientModInitializer {
    private static final OptimizationProfile BALANCED = new OptimizationProfile();
    private static final OptimizationProfile PVP_TURBO = OptimizationProfile.turboPreset();

    private static KeyBinding toggleKey;
    private static boolean turboEnabled = true;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.twice_pvp_optimizer.toggle_turbo",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.twice_pvp_optimizer.controls"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                turboEnabled = !turboEnabled;
                applyCurrentProfile(client);
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("[Twice Optimizer] Turbo mode: " + (turboEnabled ? "ON" : "OFF")), true);
                }
            }
        });

        ClientTickEvents.CLIENT_STARTED.register(this::applyCurrentProfile);
    }

    private void applyCurrentProfile(MinecraftClient client) {
        OptimizationProfile target = turboEnabled ? PVP_TURBO : BALANCED;
        target.apply(client);
    }
}
