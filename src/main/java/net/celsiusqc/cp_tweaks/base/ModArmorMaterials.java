package net.celsiusqc.cp_tweaks.base;

import net.celsiusqc.cp_tweaks.CreatePlanetaryTweaks;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, CreatePlanetaryTweaks.MOD_ID);

    // Durability multipliers, applied per-slot via ArmorItem.Type#getDurability at item creation.
    public static final int VOID_WORMED_DURABILITY = 45;
    public static final int DESH_DURABILITY = 51;
    public static final int CALORITE_DURABILITY = 56;
    public static final int OSTRUM_DURABILITY = 61;
    public static final int ICE_SHARD_DURABILITY = 70;

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VOID_WORMED = register("void_wormed",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 5);
            }), 17, 3.2F, 0.12F, "gu/void_worm");

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> DESH = register("desh",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 6);
                map.put(ArmorItem.Type.LEGGINGS, 9);
                map.put(ArmorItem.Type.CHESTPLATE, 11);
                map.put(ArmorItem.Type.HELMET, 6);
            }), 17, 3.2F, 0.12F, "ingots/desh");

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CALORITE = register("calorite",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 7);
                map.put(ArmorItem.Type.LEGGINGS, 11);
                map.put(ArmorItem.Type.CHESTPLATE, 13);
                map.put(ArmorItem.Type.HELMET, 8);
            }), 17, 3.2F, 0.12F, "ingots/calorite");

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> OSTRUM = register("ostrum",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 8);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
            }), 17, 3.4F, 0.14F, "ingots/ostrum");

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ICE_SHARD = register("ice_shard",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 10);
                map.put(ArmorItem.Type.LEGGINGS, 14);
                map.put(ArmorItem.Type.CHESTPLATE, 16);
                map.put(ArmorItem.Type.HELMET, 11);
            }), 17, 3.2F, 0.12F, "shards/unstable_ice");

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(String name, Map<ArmorItem.Type, Integer> defense,
                                                                         int enchantability, float toughness, float knockbackResistance,
                                                                         String repairTagPath) {
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(
                defense,
                enchantability,
                SoundEvents.ARMOR_EQUIP_NETHERITE,
                () -> Ingredient.of(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", repairTagPath))),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CreatePlanetaryTweaks.MOD_ID, name))),
                toughness,
                knockbackResistance));
    }

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
