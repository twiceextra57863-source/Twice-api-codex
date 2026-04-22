# Twice OptiPvP (Fabric 1.21.4)

Ye project Minecraft **1.21.4 Fabric** ke liye ek optimization-focused client mod ka starter hai.
Target: PvP gameplay ko smooth banana, frame spikes reduce karna, aur phased workflow me heavy lag sources ko clean karna.

## Abhi kya bana hai (Phase 1 bootstrap)

- Fabric + Loom based build setup.
- Client-side initializer jo har tick frame-time sample karta hai.
- **20 PvP-related lag sources** ka structured registry (`LagSource`).
- Adaptive engine jo lag spikes detect karke emergency tuning apply karta hai (currently particle load reduce).
- Base architecture jo aage mixins/modules add karne ke liye ready hai.

## Important reality check

`2x FPS guarantee` har machine/server/resource-pack scenario me possible nahi hoti.
Lekin is repo ka workflow measurable optimization ke liye banaya gaya hai jisse practical gains track kiye ja sakein.

## Planned optimization workflow

1. **Measure baseline**
   - Spark / built-in debug profiler / frame-time logs.
2. **Apply one module at a time**
   - Camera smoothing
   - Entity render culling
   - Chunk/build render prioritization
   - Particle & translucency limits
3. **A/B test**
   - Same map, same settings, same replay path.
4. **Keep only positive modules**
   - Jiska effect stable ho wahi default profile me rahega.
5. **Publish profiles**
   - Low-end, mid-range, PvP-tournament profile.

## Phase 2 (next)

- Camera movement stutter mitigation strategy.
- Entity render budget controller.
- Build/chunk rebuild queue balancing.
- In-game config UI + presets.

## Run locally

```bash
./gradlew runClient
```

## Build

```bash
./gradlew build
```
