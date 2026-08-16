package net.celsiusqc.cp_tweaks.base;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ToolTiers {

    private static Ingredient repairTag(String path) {
        return Ingredient.of(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path)));
    }

    public static final Tier DESH_TIPPED_STONE = new SimpleTier(
            BlockTags.INCORRECT_FOR_STONE_TOOL, 115, 7, 1.5f, 15,
            () -> repairTag("nuggets/desh"));

    public static final Tier COPPER = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 131, 5, 2, 13,
            () -> repairTag("ingots/copper"));

    public static final Tier ZINC = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 7, 2, 14,
            () -> repairTag("ingots/zinc"));

    public static final Tier BRASS = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 450, 7, 3, 12,
            () -> repairTag("ingots/brass"));

    public static final Tier STEEL = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 6, 3, 14,
            () -> repairTag("ingots/steel"));

    public static final Tier VOID_WORMED = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2067, 10, 6, 15,
            () -> repairTag("gu/void_worm"));

    public static final Tier DESH = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2189, 10, 7, 15,
            () -> repairTag("ingots/desh"));

    public static final Tier OSTRUM = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2354, 10, 8, 15,
            () -> repairTag("ingots/ostrum"));

    public static final Tier CALORITE = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2414, 10, 9, 15,
            () -> repairTag("ingots/calorite"));

    public static final Tier ICE_SHARD = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3000, 12, 10, 20,
            () -> repairTag("shards/unstable_ice"));
}
