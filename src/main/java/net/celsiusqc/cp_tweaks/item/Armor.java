package net.celsiusqc.cp_tweaks.item;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.celsiusqc.cp_tweaks.base.ModArmorMaterials;
import net.celsiusqc.cp_tweaks.compat.geckolib.GeckoLibCompat;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Armor {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, CreatePlanetaryTweaks.MOD_ID);

    private static Item.Properties props(int durabilityMultiplier, ArmorItem.Type type) {
        return new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(Rarity.UNCOMMON)
                .durability(type.getDurability(durabilityMultiplier));
    }

    private static DeferredHolder<Item, ArmorItem> registerSet(String name, Holder<ArmorMaterial> material,
                                                               int durabilityMultiplier, ArmorItem.Type type) {
        return ITEMS.register(name, () -> new ArmorItem(material, type, props(durabilityMultiplier, type)));
    }

    // Void Wormed (Alex's Mobs)
    public static final DeferredHolder<Item, ArmorItem> VOID_WORMED_HELMET =
            registerSet("void_wormed_helmet", ModArmorMaterials.VOID_WORMED, ModArmorMaterials.VOID_WORMED_DURABILITY, ArmorItem.Type.HELMET);
    public static final DeferredHolder<Item, ArmorItem> VOID_WORMED_CHESTPLATE =
            registerSet("void_wormed_chestplate", ModArmorMaterials.VOID_WORMED, ModArmorMaterials.VOID_WORMED_DURABILITY, ArmorItem.Type.CHESTPLATE);
    public static final DeferredHolder<Item, ArmorItem> VOID_WORMED_LEGGINGS =
            registerSet("void_wormed_leggings", ModArmorMaterials.VOID_WORMED, ModArmorMaterials.VOID_WORMED_DURABILITY, ArmorItem.Type.LEGGINGS);
    public static final DeferredHolder<Item, ArmorItem> VOID_WORMED_BOOTS =
            registerSet("void_wormed_boots", ModArmorMaterials.VOID_WORMED, ModArmorMaterials.VOID_WORMED_DURABILITY, ArmorItem.Type.BOOTS);

    // Desh (Ad Astra)
    public static final DeferredHolder<Item, ArmorItem> DESH_HELMET =
            registerSet("desh_helmet", ModArmorMaterials.DESH, ModArmorMaterials.DESH_DURABILITY, ArmorItem.Type.HELMET);
    public static final DeferredHolder<Item, ArmorItem> DESH_CHESTPLATE =
            registerSet("desh_chestplate", ModArmorMaterials.DESH, ModArmorMaterials.DESH_DURABILITY, ArmorItem.Type.CHESTPLATE);
    public static final DeferredHolder<Item, ArmorItem> DESH_LEGGINGS =
            registerSet("desh_leggings", ModArmorMaterials.DESH, ModArmorMaterials.DESH_DURABILITY, ArmorItem.Type.LEGGINGS);
    public static final DeferredHolder<Item, ArmorItem> DESH_BOOTS =
            registerSet("desh_boots", ModArmorMaterials.DESH, ModArmorMaterials.DESH_DURABILITY, ArmorItem.Type.BOOTS);

    // Ostrum (Ad Astra)
    public static final DeferredHolder<Item, ArmorItem> OSTRUM_HELMET =
            registerSet("ostrum_helmet", ModArmorMaterials.OSTRUM, ModArmorMaterials.OSTRUM_DURABILITY, ArmorItem.Type.HELMET);
    public static final DeferredHolder<Item, ArmorItem> OSTRUM_CHESTPLATE =
            registerSet("ostrum_chestplate", ModArmorMaterials.OSTRUM, ModArmorMaterials.OSTRUM_DURABILITY, ArmorItem.Type.CHESTPLATE);
    public static final DeferredHolder<Item, ArmorItem> OSTRUM_LEGGINGS =
            registerSet("ostrum_leggings", ModArmorMaterials.OSTRUM, ModArmorMaterials.OSTRUM_DURABILITY, ArmorItem.Type.LEGGINGS);
    public static final DeferredHolder<Item, ArmorItem> OSTRUM_BOOTS =
            registerSet("ostrum_boots", ModArmorMaterials.OSTRUM, ModArmorMaterials.OSTRUM_DURABILITY, ArmorItem.Type.BOOTS);

    // Calorite (Ad Astra)
    public static final DeferredHolder<Item, ArmorItem> CALORITE_HELMET =
            registerSet("calorite_helmet", ModArmorMaterials.CALORITE, ModArmorMaterials.CALORITE_DURABILITY, ArmorItem.Type.HELMET);
    public static final DeferredHolder<Item, ArmorItem> CALORITE_CHESTPLATE =
            registerSet("calorite_chestplate", ModArmorMaterials.CALORITE, ModArmorMaterials.CALORITE_DURABILITY, ArmorItem.Type.CHESTPLATE);
    public static final DeferredHolder<Item, ArmorItem> CALORITE_LEGGINGS =
            registerSet("calorite_leggings", ModArmorMaterials.CALORITE, ModArmorMaterials.CALORITE_DURABILITY, ArmorItem.Type.LEGGINGS);
    public static final DeferredHolder<Item, ArmorItem> CALORITE_BOOTS =
            registerSet("calorite_boots", ModArmorMaterials.CALORITE, ModArmorMaterials.CALORITE_DURABILITY, ArmorItem.Type.BOOTS);

    // Ice Shard — uses the animated GeckoLib model when GeckoLib is installed,
    // otherwise falls back to a plain armor item. Soft dependency by design.
    public static final DeferredHolder<Item, ArmorItem> ICE_SHARD_HELMET = registerIceShard("ice_shard_helmet", ArmorItem.Type.HELMET);
    public static final DeferredHolder<Item, ArmorItem> ICE_SHARD_CHESTPLATE = registerIceShard("ice_shard_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final DeferredHolder<Item, ArmorItem> ICE_SHARD_LEGGINGS = registerIceShard("ice_shard_leggings", ArmorItem.Type.LEGGINGS);
    public static final DeferredHolder<Item, ArmorItem> ICE_SHARD_BOOTS = registerIceShard("ice_shard_boots", ArmorItem.Type.BOOTS);

    private static DeferredHolder<Item, ArmorItem> registerIceShard(String name, ArmorItem.Type type) {
        return ITEMS.register(name, () -> {
            Item.Properties properties = props(ModArmorMaterials.ICE_SHARD_DURABILITY, type);
            if (ModList.get().isLoaded("geckolib")) {
                return GeckoLibCompat.createIceShardArmor(ModArmorMaterials.ICE_SHARD, type, properties);
            }
            return new ArmorItem(ModArmorMaterials.ICE_SHARD, type, properties);
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
