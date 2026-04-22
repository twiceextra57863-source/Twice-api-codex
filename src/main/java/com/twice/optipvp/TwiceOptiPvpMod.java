package com.twice.optipvp;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwiceOptiPvpMod implements ModInitializer {
    public static final String MOD_ID = "twice-optipvp";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("TwiceOptiPvp initialized. Use client entrypoint for FPS tuning.");
    }
}
