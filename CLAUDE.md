# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Create Planetary Tweaks (`cp_tweaks`) is a Minecraft mod. The active branch (`1.21-neoforge`) targets Minecraft 1.21 on NeoForge 21.0.x and is currently a fresh NeoForge MDK template being rebuilt from earlier versions. Older ports live on other branches (`1.20.1-forge`, `1.19.2`); a discarded StarViewer integration exists on `1.20.1-starviewer-forge`. Don't reintroduce StarViewer code unless asked.

## Commands

Requires Java 21 (the CI workflow's JDK 17 is stale relative to the build's Java 21 toolchain).

```bash
./gradlew build            # build the mod jar (output in build/libs/)
./gradlew runClient        # launch a dev Minecraft client with the mod
./gradlew runServer        # launch a dev dedicated server (--nogui)
./gradlew runGameTestServer  # run registered gametests headlessly, then exit
./gradlew runData          # run data generators; output goes to src/generated/resources/
./gradlew --refresh-dependencies  # fix missing/broken dependency caches
```

There are no unit tests; testing is done via gametests (`runGameTestServer`, namespaced to `cp_tweaks`) or manually via `runClient`.

## Architecture

Standard NeoForge single-source-set mod:

- `src/main/java/net/celsiusqc/cp_tweaks/CreatePlanetaryTweaks.java` — main `@Mod` class. All registration goes through the static `DeferredRegister` fields (`BLOCKS`, `ITEMS`, `CREATIVE_MODE_TABS`), which are registered to the mod event bus in the constructor. Client-only code goes in the nested `ClientModEvents` (`@EventBusSubscriber` with `Dist.CLIENT`).
- `src/main/java/net/celsiusqc/cp_tweaks/Config.java` — `ModConfigSpec`-based common config, registered in the mod constructor.
- `src/main/resources/META-INF/neoforge.mods.toml` — mod metadata; version/dependency placeholders are expanded at build time from `gradle.properties` via the `processResources` task, so change versions in `gradle.properties`, not the toml.
- `src/generated/resources/` — datagen output, included as a resource source set.

Key identifiers that must stay in sync: `mod_id=cp_tweaks` in `gradle.properties` and `CreatePlanetaryTweaks.MODID`.

Mod version comes from `mod_version` in `gradle.properties`; the jar version string is `neoforge-1.21-<mod_version>`.
