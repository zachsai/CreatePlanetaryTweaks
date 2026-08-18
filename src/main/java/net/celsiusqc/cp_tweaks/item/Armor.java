package net.celsiusqc.cp_tweaks.item;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.base.*;
import net.celsiusqc.cp_tweaks.base.armors.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Armor {

    //Void Worm
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreatePlanetaryTweaks.MOD_ID);
    public static final RegistryObject<ArmorItem> VOID_WORMED_HELMET = ITEMS.register("void_wormed_helmet",
            () -> new VoidWormedArmorItem(ArmorTiers.VOID_WORMED, ArmorItem.Type.HELMET, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> VOID_WORMED_CHESTPLATE = ITEMS.register("void_wormed_chestplate",
            () -> new VoidWormedArmorItem(ArmorTiers.VOID_WORMED, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> VOID_WORMED_LEGGINGS = ITEMS.register("void_wormed_leggings",
            () -> new VoidWormedArmorItem(ArmorTiers.VOID_WORMED, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> VOID_WORMED_BOOTS = ITEMS.register("void_wormed_boots",
            () -> new VoidWormedArmorItem(ArmorTiers.VOID_WORMED, ArmorItem.Type.BOOTS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));

    //Desh
    public static final RegistryObject<ArmorItem> DESH_HELMET = ITEMS.register("desh_helmet",
            () -> new DeshArmorItem(ArmorTiers.DESH, ArmorItem.Type.HELMET, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> DESH_CHESTPLATE = ITEMS.register("desh_chestplate",
            () -> new DeshArmorItem(ArmorTiers.DESH, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> DESH_LEGGINGS = ITEMS.register("desh_leggings",
            () -> new DeshArmorItem(ArmorTiers.DESH, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> DESH_BOOTS = ITEMS.register("desh_boots",
            () -> new DeshArmorItem(ArmorTiers.DESH, ArmorItem.Type.BOOTS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));

    //Ostrum
    public static final RegistryObject<ArmorItem> OSTRUM_HELMET = ITEMS.register("ostrum_helmet",
            () -> new OstrumArmorItem(ArmorTiers.OSTRUM, ArmorItem.Type.HELMET, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> OSTRUM_CHESTPLATE = ITEMS.register("ostrum_chestplate",
            () -> new OstrumArmorItem(ArmorTiers.OSTRUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> OSTRUM_LEGGINGS = ITEMS.register("ostrum_leggings",
            () -> new OstrumArmorItem(ArmorTiers.OSTRUM, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> OSTRUM_BOOTS = ITEMS.register("ostrum_boots",
            () -> new OstrumArmorItem(ArmorTiers.OSTRUM, ArmorItem.Type.BOOTS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));

    //Calorite
    public static final RegistryObject<ArmorItem> CALORITE_HELMET = ITEMS.register("calorite_helmet",
            () -> new CaloriteArmorItem(ArmorTiers.CALORITE, ArmorItem.Type.HELMET, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> CALORITE_CHESTPLATE = ITEMS.register("calorite_chestplate",
            () -> new CaloriteArmorItem(ArmorTiers.CALORITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> CALORITE_LEGGINGS = ITEMS.register("calorite_leggings",
            () -> new CaloriteArmorItem(ArmorTiers.CALORITE, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<ArmorItem> CALORITE_BOOTS = ITEMS.register("calorite_boots",
            () -> new CaloriteArmorItem(ArmorTiers.CALORITE, ArmorItem.Type.BOOTS, new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON)));


    // Ice Shard armor uses the animated GeckoLib model when GeckoLib is
    // installed, otherwise falls back to a plain armor item. Soft dependency.
    public static final RegistryObject<ArmorItem> ICE_SHARD_HELMET = registerIceShard("ice_shard_helmet", ArmorItem.Type.HELMET);
    public static final RegistryObject<ArmorItem> ICE_SHARD_CHESTPLATE = registerIceShard("ice_shard_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final RegistryObject<ArmorItem> ICE_SHARD_LEGGINGS = registerIceShard("ice_shard_leggings", ArmorItem.Type.LEGGINGS);
    public static final RegistryObject<ArmorItem> ICE_SHARD_BOOTS = registerIceShard("ice_shard_boots", ArmorItem.Type.BOOTS);

    private static RegistryObject<ArmorItem> registerIceShard(String name, ArmorItem.Type type) {
        return ITEMS.register(name, () -> {
            Item.Properties properties = new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.UNCOMMON);
            if (net.minecraftforge.fml.ModList.get().isLoaded("geckolib")) {
                return net.celsiusqc.cp_tweaks.compat.geckolib.GeckoLibCompat.createIceShardArmor(ArmorTiers.ICE_SHARD, type, properties);
            }
            return new ArmorItem(ArmorTiers.ICE_SHARD, type, properties);
        });
    }




    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
