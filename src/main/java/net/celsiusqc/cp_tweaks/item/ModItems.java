package net.celsiusqc.cp_tweaks.item;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.fluid.ModFluids;
import net.celsiusqc.cp_tweaks.item.tooltip.TooltipItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, CreatePlanetaryTweaks.MOD_ID);

    // Logo and Branding
    public static final DeferredHolder<Item, Item> CREATE_PLANETARY_TWEAKS_LOGO = ITEMS.register("create_planetary_tweaks_logo",
            () -> new Item(new Item.Properties()));

    // Seasonal Items (Serene Seasons)
    public static final DeferredHolder<Item, Item> AUTUMN = ITEMS.register("autumn",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> WINTER = ITEMS.register("winter",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SPRING = ITEMS.register("spring",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SUMMER = ITEMS.register("summer",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> DRY = ITEMS.register("dry",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> WET = ITEMS.register("wet",
            () -> new Item(new Item.Properties()));

    // Special Items with Tooltips
    public static final DeferredHolder<Item, Item> VOID_WORM_GU = ITEMS.register("void_worm_gu",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredHolder<Item, Item> UNSTABLE_ICE_SHARD = ITEMS.register("unstable_ice_shard",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredHolder<Item, Item> MONSTROSITY_GU = ITEMS.register("monstrosity_gu",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ENDER_GUARDIAN_GU = ITEMS.register("ender_guardian_gu",
            () -> new TooltipItem(new Item.Properties()));

    // Engineering and Rocketry Items
    public static final DeferredHolder<Item, Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> REINFORCED_ROCKET_FIN = ITEMS.register("reinforced_rocket_fin",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> REINFORCED_ROCKET_NOSE_CONE = ITEMS.register("reinforced_rocket_nose_cone",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> IGNITIUM_SHEET = ITEMS.register("ignitium_sheet",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> IGNITIUM_ENGINE = ITEMS.register("ignitium_engine",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> STURDY_OSTRUM_SHEET = ITEMS.register("sturdy_ostrum_sheet",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> STURDY_DESH_SHEET = ITEMS.register("sturdy_desh_sheet",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> STABILIZED_ICE_SHEET = ITEMS.register("stabilized_ice_sheet",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> FTL_GLACIAN_ENGINE = ITEMS.register("ftl_glacian_engine",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> STABILIZED_FROZEN_GU = ITEMS.register("stabilized_frozen_gu",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> GLACIAN_ENGINE_FRAME = ITEMS.register("glacian_engine_frame",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> GLACIAN_ENGINE_FAN = ITEMS.register("glacian_engine_fan",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> WEIRD_SATELLITE = ITEMS.register("weird_satellite",
            () -> new TooltipItem(new Item.Properties().stacksTo(1).fireResistant()));

    public static final DeferredHolder<Item, Item> ARACHNARCH_VENOM_BOTTLE = ITEMS.register("arachnarch_venom_bottle",
            () -> new TooltipItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(3)));

    public static final DeferredHolder<Item, Item> ARACHNARCH_VENOM_BUCKET = ITEMS.register("arachnarch_venom_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ARACHNARCH_VENOM.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> STARLIT_TREE_BARK = ITEMS.register("starlit_tree_bark",
            () -> new TooltipItem(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
