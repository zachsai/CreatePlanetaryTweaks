package net.celsiusqc.cp_tweaks.item;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.base.ToolTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Tools {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, CreatePlanetaryTweaks.MOD_ID);

    private static Item.Properties sword(Tier tier, int damage, float speed) {
        return new Item.Properties().attributes(SwordItem.createAttributes(tier, damage, speed));
    }

    private static Item.Properties axe(Tier tier, float damage, float speed) {
        return new Item.Properties().attributes(AxeItem.createAttributes(tier, damage, speed));
    }

    private static Item.Properties pickaxe(Tier tier, float damage, float speed) {
        return new Item.Properties().attributes(PickaxeItem.createAttributes(tier, damage, speed));
    }

    private static Item.Properties shovel(Tier tier, float damage, float speed) {
        return new Item.Properties().attributes(ShovelItem.createAttributes(tier, damage, speed));
    }

    private static Item.Properties hoe(Tier tier, float damage, float speed) {
        return new Item.Properties().attributes(HoeItem.createAttributes(tier, damage, speed));
    }

    // Desh Tipped Stone
    public static final DeferredHolder<Item, SwordItem> DESH_TIPPED_STONE_SWORD = ITEMS.register("desh_tipped_stone_sword",
            () -> new SwordItem(ToolTiers.DESH_TIPPED_STONE, sword(ToolTiers.DESH_TIPPED_STONE, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> DESH_TIPPED_STONE_AXE = ITEMS.register("desh_tipped_stone_axe",
            () -> new AxeItem(ToolTiers.DESH_TIPPED_STONE, axe(ToolTiers.DESH_TIPPED_STONE, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> DESH_TIPPED_STONE_PICKAXE = ITEMS.register("desh_tipped_stone_pickaxe",
            () -> new PickaxeItem(ToolTiers.DESH_TIPPED_STONE, pickaxe(ToolTiers.DESH_TIPPED_STONE, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> DESH_TIPPED_STONE_SHOVEL = ITEMS.register("desh_tipped_stone_shovel",
            () -> new ShovelItem(ToolTiers.DESH_TIPPED_STONE, shovel(ToolTiers.DESH_TIPPED_STONE, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> DESH_TIPPED_STONE_HOE = ITEMS.register("desh_tipped_stone_hoe",
            () -> new HoeItem(ToolTiers.DESH_TIPPED_STONE, hoe(ToolTiers.DESH_TIPPED_STONE, -2, 0.0f)));

    // Copper
    public static final DeferredHolder<Item, SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ToolTiers.COPPER, sword(ToolTiers.COPPER, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ToolTiers.COPPER, axe(ToolTiers.COPPER, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ToolTiers.COPPER, pickaxe(ToolTiers.COPPER, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ToolTiers.COPPER, shovel(ToolTiers.COPPER, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ToolTiers.COPPER, hoe(ToolTiers.COPPER, -2, 0.0f)));

    // Brass (Create)
    public static final DeferredHolder<Item, SwordItem> BRASS_SWORD = ITEMS.register("brass_sword",
            () -> new SwordItem(ToolTiers.BRASS, sword(ToolTiers.BRASS, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> BRASS_AXE = ITEMS.register("brass_axe",
            () -> new AxeItem(ToolTiers.BRASS, axe(ToolTiers.BRASS, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> BRASS_PICKAXE = ITEMS.register("brass_pickaxe",
            () -> new PickaxeItem(ToolTiers.BRASS, pickaxe(ToolTiers.BRASS, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> BRASS_SHOVEL = ITEMS.register("brass_shovel",
            () -> new ShovelItem(ToolTiers.BRASS, shovel(ToolTiers.BRASS, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> BRASS_HOE = ITEMS.register("brass_hoe",
            () -> new HoeItem(ToolTiers.BRASS, hoe(ToolTiers.BRASS, -3, 0.0f)));

    // Steel
    public static final DeferredHolder<Item, SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ToolTiers.STEEL, sword(ToolTiers.STEEL, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ToolTiers.STEEL, axe(ToolTiers.STEEL, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ToolTiers.STEEL, pickaxe(ToolTiers.STEEL, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ToolTiers.STEEL, shovel(ToolTiers.STEEL, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ToolTiers.STEEL, hoe(ToolTiers.STEEL, -3, 0.0f)));

    // Void Wormed (Alex's Mobs)
    public static final DeferredHolder<Item, SwordItem> VOID_WORM_SWORD = ITEMS.register("void_wormed_sword",
            () -> new SwordItem(ToolTiers.VOID_WORMED, sword(ToolTiers.VOID_WORMED, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> VOID_WORM_AXE = ITEMS.register("void_wormed_axe",
            () -> new AxeItem(ToolTiers.VOID_WORMED, axe(ToolTiers.VOID_WORMED, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> VOID_WORM_PICKAXE = ITEMS.register("void_wormed_pickaxe",
            () -> new PickaxeItem(ToolTiers.VOID_WORMED, pickaxe(ToolTiers.VOID_WORMED, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> VOID_WORM_SHOVEL = ITEMS.register("void_wormed_shovel",
            () -> new ShovelItem(ToolTiers.VOID_WORMED, shovel(ToolTiers.VOID_WORMED, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> VOID_WORM_HOE = ITEMS.register("void_wormed_hoe",
            () -> new HoeItem(ToolTiers.VOID_WORMED, hoe(ToolTiers.VOID_WORMED, -6, 0.0f)));

    // Desh (Ad Astra)
    public static final DeferredHolder<Item, SwordItem> DESH_SWORD = ITEMS.register("desh_sword",
            () -> new SwordItem(ToolTiers.DESH, sword(ToolTiers.DESH, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> DESH_AXE = ITEMS.register("desh_axe",
            () -> new AxeItem(ToolTiers.DESH, axe(ToolTiers.DESH, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> DESH_PICKAXE = ITEMS.register("desh_pickaxe",
            () -> new PickaxeItem(ToolTiers.DESH, pickaxe(ToolTiers.DESH, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> DESH_SHOVEL = ITEMS.register("desh_shovel",
            () -> new ShovelItem(ToolTiers.DESH, shovel(ToolTiers.DESH, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> DESH_HOE = ITEMS.register("desh_hoe",
            () -> new HoeItem(ToolTiers.DESH, hoe(ToolTiers.DESH, -7, 0.0f)));

    // Ostrum (Ad Astra)
    public static final DeferredHolder<Item, SwordItem> OSTRUM_SWORD = ITEMS.register("ostrum_sword",
            () -> new SwordItem(ToolTiers.OSTRUM, sword(ToolTiers.OSTRUM, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> OSTRUM_AXE = ITEMS.register("ostrum_axe",
            () -> new AxeItem(ToolTiers.OSTRUM, axe(ToolTiers.OSTRUM, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> OSTRUM_PICKAXE = ITEMS.register("ostrum_pickaxe",
            () -> new PickaxeItem(ToolTiers.OSTRUM, pickaxe(ToolTiers.OSTRUM, 0, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> OSTRUM_SHOVEL = ITEMS.register("ostrum_shovel",
            () -> new ShovelItem(ToolTiers.OSTRUM, shovel(ToolTiers.OSTRUM, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> OSTRUM_HOE = ITEMS.register("ostrum_hoe",
            () -> new HoeItem(ToolTiers.OSTRUM, hoe(ToolTiers.OSTRUM, -9, 0.0f)));

    // Calorite (Ad Astra)
    public static final DeferredHolder<Item, SwordItem> CALORITE_SWORD = ITEMS.register("calorite_sword",
            () -> new SwordItem(ToolTiers.CALORITE, sword(ToolTiers.CALORITE, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> CALORITE_AXE = ITEMS.register("calorite_axe",
            () -> new AxeItem(ToolTiers.CALORITE, axe(ToolTiers.CALORITE, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> CALORITE_PICKAXE = ITEMS.register("calorite_pickaxe",
            () -> new PickaxeItem(ToolTiers.CALORITE, pickaxe(ToolTiers.CALORITE, 1, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> CALORITE_SHOVEL = ITEMS.register("calorite_shovel",
            () -> new ShovelItem(ToolTiers.CALORITE, shovel(ToolTiers.CALORITE, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> CALORITE_HOE = ITEMS.register("calorite_hoe",
            () -> new HoeItem(ToolTiers.CALORITE, hoe(ToolTiers.CALORITE, -8, 0.0f)));

    // Ice Shard
    public static final DeferredHolder<Item, SwordItem> ICE_SHARD_SWORD = ITEMS.register("ice_shard_sword",
            () -> new SwordItem(ToolTiers.ICE_SHARD, sword(ToolTiers.ICE_SHARD, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> ICE_SHARD_AXE = ITEMS.register("ice_shard_axe",
            () -> new AxeItem(ToolTiers.ICE_SHARD, axe(ToolTiers.ICE_SHARD, 5, -3.0f)));
    public static final DeferredHolder<Item, PickaxeItem> ICE_SHARD_PICKAXE = ITEMS.register("ice_shard_pickaxe",
            () -> new PickaxeItem(ToolTiers.ICE_SHARD, pickaxe(ToolTiers.ICE_SHARD, 0, -2.8f)));
    public static final DeferredHolder<Item, ShovelItem> ICE_SHARD_SHOVEL = ITEMS.register("ice_shard_shovel",
            () -> new ShovelItem(ToolTiers.ICE_SHARD, shovel(ToolTiers.ICE_SHARD, 1.5f, -3.0f)));
    public static final DeferredHolder<Item, HoeItem> ICE_SHARD_HOE = ITEMS.register("ice_shard_hoe",
            () -> new HoeItem(ToolTiers.ICE_SHARD, hoe(ToolTiers.ICE_SHARD, -10, 0.0f)));

    public static final DeferredHolder<Item, SwordItem> GIANT_ICE_SHARD_SWORD = ITEMS.register("giant_ice_shard_sword",
            () -> new SwordItem(ToolTiers.ICE_SHARD, sword(ToolTiers.ICE_SHARD, 3, -2.4f)));
    public static final DeferredHolder<Item, AxeItem> GIANT_ICE_SHARD_AXE = ITEMS.register("giant_ice_shard_axe",
            () -> new AxeItem(ToolTiers.ICE_SHARD, axe(ToolTiers.ICE_SHARD, 3, -2.4f)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
