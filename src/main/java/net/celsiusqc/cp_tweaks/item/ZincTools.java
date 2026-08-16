package net.celsiusqc.cp_tweaks.item;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.base.ToolTiers;
import net.celsiusqc.cp_tweaks.item.tooltip.TooltipTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ZincTools {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, CreatePlanetaryTweaks.MOD_ID);

    public static final DeferredHolder<Item, SwordItem> ZINC_SWORD = ITEMS.register("zinc_sword",
            () -> new TooltipTools.Sword(ToolTiers.ZINC,
                    new Item.Properties().attributes(SwordItem.createAttributes(ToolTiers.ZINC, 3, -2.4f))));
    public static final DeferredHolder<Item, AxeItem> ZINC_AXE = ITEMS.register("zinc_axe",
            () -> new TooltipTools.Axe(ToolTiers.ZINC,
                    new Item.Properties().attributes(AxeItem.createAttributes(ToolTiers.ZINC, 5, -3.0f))));
    public static final DeferredHolder<Item, PickaxeItem> ZINC_PICKAXE = ITEMS.register("zinc_pickaxe",
            () -> new TooltipTools.Pickaxe(ToolTiers.ZINC,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ToolTiers.ZINC, 1, -2.8f))));
    public static final DeferredHolder<Item, ShovelItem> ZINC_SHOVEL = ITEMS.register("zinc_shovel",
            () -> new TooltipTools.Shovel(ToolTiers.ZINC,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ToolTiers.ZINC, 1.5f, -3.0f))));
    public static final DeferredHolder<Item, HoeItem> ZINC_HOE = ITEMS.register("zinc_hoe",
            () -> new TooltipTools.Hoe(ToolTiers.ZINC,
                    new Item.Properties().attributes(HoeItem.createAttributes(ToolTiers.ZINC, -2, 0.0f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
