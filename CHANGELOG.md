# 1.1.0 — Minecraft 1.21.1 / NeoForge

First release for Minecraft 1.21.1 on NeoForge, ported from the 1.20.1 Forge version.

## Highlights
- **Every integration is now a soft dependency.** The mod loads with any subset of its
  companion mods — nothing is required anymore (previously GeckoLib and Twilight Forest
  were mandatory). Items, recipes, and creative-tab entries appear only when the mods
  they belong to are installed.
- All tools, armor, materials, the Arachnarch venom fluid, boss-drop loot injections,
  and cross-mod recipes carried over from 1.20.1.
- Ice Shard armor uses its animated GeckoLib model when GeckoLib is installed, and
  falls back to standard armor rendering when it isn't.

## Integration notes for 1.21.1
- Create 6, Twilight Forest, L_Ender's Cataclysm, Serene Seasons, JEI, and JER all work
  as before.
- Ad Astra and Alex's Mobs never officially updated past 1.20.1 — the community
  1.21.1 ports (which keep the same mod ids) are supported instead.
- Blue Skies and Consecration have no 1.21.1 versions; their content stays dormant
  until such versions exist.
