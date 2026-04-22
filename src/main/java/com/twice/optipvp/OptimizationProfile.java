package com.twice.optipvp;

import java.util.EnumMap;
import java.util.Map;

public final class OptimizationProfile {
    private final Map<LagSource, Boolean> switches = new EnumMap<>(LagSource.class);

    public OptimizationProfile() {
        for (LagSource lagSource : LagSource.values()) {
            switches.put(lagSource, true);
        }
    }

    public boolean isEnabled(LagSource source) {
        return switches.getOrDefault(source, false);
    }

    public void setEnabled(LagSource source, boolean enabled) {
        switches.put(source, enabled);
    }
}
