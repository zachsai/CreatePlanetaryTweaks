# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Create Planetary Tweaks (`cp_tweaks`) is a Minecraft integration mod: cross-mod tools, armor, materials, and recipes bridging Create, space mods (Ad Astra), and adventure mods (Twilight Forest, Cataclysm, Alex's Mobs, Blue Skies, Serene Seasons). Published on CurseForge (project id 594527, slug `create-planetary-tweaks`).

**Every integration is a soft dependency.** This is the mod's core design rule: nothing outside NeoForge/Minecraft may be required. Java-side gating uses `ModList.get().isLoaded(...)` (see `ModCreativeModTab`), registry lookups by id (see `interact/`), or isolated compat classes whose mod-specific imports only load behind an `isLoaded` check (see `compat/geckolib/GeckoLibCompat`). Data-side gating uses `neoforge:conditions` with `neoforge:mod_loaded` on recipes. Keep new content behind the same patterns.

## Branches

- `1.21-neoforge` — default; MC 1.21.1 / NeoForge 21.1.x. Active development.
- `1.20.1-forge` — legacy 1.20.1 Forge version (last CurseForge releases 1.0.x); the only branch where Blue Skies/Consecration/original Ad Astra integrations are live.
- `1.19.2`, `1.20.1-starviewer-forge` — historical. Don't reintroduce StarViewer code unless asked.

On 1.21.1, Ad Astra and Alex's Mobs are covered by community ports that keep the same mod ids (`ad_astra`, `alexsmobs`). Blue Skies and Consecration don't exist on 1.21+; their content stays registered but dormant. As of mid-2026, versions newer than 1.21.1 (26.x calendar versions) are blocked on Create shipping a port.

## Commands

Requires Java 21.

```bash
./gradlew build              # mod jar in build/libs/
./gradlew runClient          # dev client
./gradlew runServer          # dev dedicated server (--nogui; eula must be accepted in run dir)
./gradlew runGameTestServer  # crashes with "No test functions" if no gametests exist — expected
./gradlew runData            # datagen into src/generated/resources/
./gradlew publishCurseForge  # upload to CurseForge (needs curseforge_token property or CURSEFORGE_TOKEN env)
```

There are no unit tests; verification is `./gradlew build` plus booting `runServer` and checking the log for `cp_tweaks` errors.

CI: `.github/workflows/build.yml` builds on push/PR. `.github/workflows/publish-curseforge.yml` is a manual (workflow_dispatch) CurseForge upload using the `CURSEFORGE_TOKEN` repo secret; publishing is intentionally never automatic.

## Architecture

Registration flows through per-category `DeferredRegister`s, all registered on the mod bus in `CreatePlanetaryTweaks`'s constructor: `ModItems`, `Tools`, `ZincTools`, `Armor` (items), `ModBlocks`, `ModFluids`/`ModFluidTypes`, `ModArmorMaterials`, `ModLootModifiers`, `ModCreativeModTab`.

- `base/ToolTiers` (NeoForge `SimpleTier`) and `base/ModArmorMaterials` (registered `ArmorMaterial`s) define all material stats; repair ingredients are `c:` tags so other mods' items satisfy them.
- `item/tooltip/` holds generic tooltip-item classes that append `<descriptionId>.tooltip` translations.
- `interact/` contains event handlers for Blue Skies boss interactions — entity types are looked up by id, so they're inert without Blue Skies.
- `loot/AddItemModifier` is a global loot modifier (`data/cp_tweaks/loot_modifiers/*` + `data/neoforge/loot_modifiers/global_loot_modifiers.json`) that injects boss drops into other mods' loot tables.
- `compat/JEIPlugin` only loads when JEI is present; `compat/geckolib/` only when GeckoLib is (never import GeckoLib classes outside that package).
- `src/main/resources/data/` uses 1.21 conventions: singular folders (`recipe`, `tags/item`), `c:` tag namespace, ItemStack results as `{"id": ...}`, conditions as top-level `"neoforge:conditions"`.

Metadata placeholders in `META-INF/neoforge.mods.toml` are expanded from `gradle.properties` at build time — change versions there (`mod_version`, `minecraft_version`, `neo_version`), not in the toml. `mod_id=cp_tweaks` must match `CreatePlanetaryTweaks.MOD_ID`. Jar/display version format: `neoforge-<minecraft_version>-<mod_version>`.

Gotcha: NeoForge 21.1.248 needs the ASM `resolutionStrategy.force` block in `build.gradle` — without it, dev runs crash at bootstrap with duplicate `org.objectweb.asm` modules.
