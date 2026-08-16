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

## Integration matrix (1.21.1 branch)

Every optional mod below is declared `type="optional"` in `neoforge.mods.toml`. This table is the source of truth for "what should a fresh instance show with mod X installed" — use it to sanity-check the creative tab and recipes rather than re-deriving gating logic from scratch.

| Mod (modid) | Unlocks | 1.21.1 NeoForge availability (as of Aug 2026) |
|---|---|---|
| `create` | copper/steel tool base, brass/zinc tools, is a co-requirement for nearly everything else | Official, current (6.0.10). Jar-in-jars Flywheel + Ponder — don't add those separately. |
| `alexsmobs` | Void Wormed tools/armor/gu, void worm loot injection | Official mod dead at 1.20.1. Use the "Alex's Mobs (Unofficial Port)" — same modid, requires **Citadel**. |
| `cataclysm` | Ender Guardian/Monstrosity gu, ignitium sheet, boss loot injections | Official, current (3.32). Requires **Curios API** + **Lionfish API**. |
| `ad_astra` | Desh/Ostrum/Calorite gear, Ice Shard armor+tools, rockets, sturdy sheets, unstable ice shard, glacian engine chain, steel ingot (Ad Astra variant) | **No live 1.21.1 NeoForge build exists.** An unofficial port existed briefly and was taken down (410 Gone) as of Aug 2026. Check again before each release — if one reappears keeping modid `ad_astra`, it slots in with no code changes needed. |
| `twilightforest` | Weird Satellite (needs ad_astra too), Giant Ice Shard tools | Official, current (4.8.x). |
| `sereneseasons` | Seasonal items (autumn/winter/spring/summer/dry/wet) | Official, current (10.x on NeoForge). Requires **GlitchCore**. |
| `geckolib` | Animated Ice Shard armor render; without it, Ice Shard armor still works as plain `ArmorItem` | Official, current (4.9.x). |
| `jei` | Ingredient tooltips (void worm gu, monstrosity gu, ender guardian gu, unstable ice shard) via `compat/JEIPlugin` | Official, current. |
| `jeresources` | declared as optional dependency; no direct code hook currently | Official, current (JER). |
| `blue_skies` | Arachnarch venom fluid/bottle/bucket, Starlit Tree Bark, boss-interaction handlers in `interact/` | **Dead since 1.20.4.** No 1.21+ build anywhere. |
| `consecration` | `data/consecration/tags/item/holy.json` tag entries only, no Java hook | **Dead since 1.20.1.** No 1.21+ build anywhere. |

Test instance setup reference (what's been verified working together): Create 6.0.10, JEI 19.44.0.401, GeckoLib 4.9.2, Alex's Mobs (unofficial port) 1.22.17 + Citadel 2.7.1, Twilight Forest 4.8.3345, Cataclysm 3.32 + Curios 9.5.1 + Lionfish API 3.1, Serene Seasons 10.1.0.3 + GlitchCore 2.1.0.2, JER 1.6.0.17. All fetched from CurseForge CDN (`mediafilez.forgecdn.net`) via `api.cfwidget.com` project lookups — no Ad Astra/Blue Skies/Consecration equivalents exist to add.

**When something appears in the creative tab with no way to craft it**, that's a gating bug: the tab's `ModList.isLoaded(...)` check and the item's actual recipe `neoforge:conditions` have drifted apart. Cross-check both — see `sturdy_desh_sheet`'s fix history for the exact failure mode (tab checked `cataclysm && create` but the recipe also needed `ad_astra:desh_plate`).

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

## Create recipe schema on 1.21.1 (hard-won from the 1.20.1 port)

`RecipeManager` parse failures are **logged as an ERROR but don't crash the game** — a malformed recipe just silently vanishes with no craftable output. Always grep `logs/latest.log` for `Parsing error loading recipe` after touching any `create:*` recipe JSON; the game loading fine is not proof the recipes are valid. Fields that changed shape from 1.20.1 Forge to 1.21.1 NeoForge (verified against the real recipes shipped inside `create-1.21.1-*.jar`, not guessed):

| Old (1.20.1) | New (1.21.1) | Applies to |
|---|---|---|
| `"item": "..."` in a result | `"id": "..."` | any recipe result, vanilla or Create |
| `{"fluid": "...", "amount": N, "nbt": {}}` ingredient | `{"type": "neoforge:single", "amount": N, "fluid": "..."}` | `create:mixing`/`create:compacting` fluid ingredients |
| `{"fluidTag": "...", "amount": N}` ingredient | `{"type": "neoforge:tag", "amount": N, "tag": "..."}` | `create:filling` etc. |
| `{"amount": N, "fluid": "..."}` in a **result** | `{"amount": N, "id": "..."}` | `create:emptying` fluid results — note this is `id` too, not the ingredient-side `type` wrapper |
| `heatRequirement` | `heat_requirement` | `create:mixing` |
| `processingTime` | `processing_time` | `create:crushing`, `create:milling`, etc. |
| `acceptMirrored` | `accept_mirrored` | `create:mechanical_crafting` |
| (none) | `"category"` required (e.g. `"misc"`) | `create:mechanical_crafting` |
| `forge:conditional` wrapper with `"recipes": [...]` | flat recipe with top-level `"neoforge:conditions": [...]` | any conditional recipe |
| `forge:` condition/tag namespace | `neoforge:`/`c:` | conditions and tags respectively |

When adding a new Create-type recipe, don't hand-write it from memory of the old format — extract a same-type example from the installed Create jar (`unzip -p create-*.jar data/create/recipe/<type>/<file>.json`) and match its shape.
