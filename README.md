# Twice PvP Optimizer (Fabric 1.21.4)

Ye project tumhare PvP-focused optimization mod ka **starter base** hai.

## Kya ready hai (Phase-1 bootstrap)

- Fabric 1.21.4 mod scaffold.
- Client entrypoint + in-game turbo toggle key (`O`).
- 20 lag-cleanup modules ki clear list (camera lag, entity render lag, build/chunk render lag etc.) as extensible actions.
- CI workflow (`.github/workflows/build.yml`) to keep repo stable.

## Important reality check

Har PC, shader pack, resource pack, server, aur scene alag hota hai — isi liye **exact 2x FPS guarantee** technically possible nahi hoti.
Is starter ka goal hai reproducible optimization pipeline dena jisse measurable improvement nikal sake.

## Next implementation milestones

1. Stub actions ko real mixin-based/render-budget logic se replace karna.
2. FPS benchmark command + CSV profiling output add karna.
3. Auto profile switching (combat vs build mode).
4. Optional compatibility hooks (Sodium/Iris) for extra gains.

## Run

```bash
gradle runClient
```
