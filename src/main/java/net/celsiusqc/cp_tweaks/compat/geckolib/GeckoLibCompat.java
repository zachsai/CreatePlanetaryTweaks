package net.celsiusqc.cp_tweaks.compat.geckolib;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.GeckoLib;

/**
 * Isolates all GeckoLib class references. Only call these methods after
 * checking {@code ModList.get().isLoaded("geckolib")} — the classes
 * referenced here are not loaded until a method on this class is invoked.
 */
public final class GeckoLibCompat {

    private GeckoLibCompat() {
    }

    public static void initialize() {
        GeckoLib.initialize();
    }

    public static ArmorItem createIceShardArmor(ArmorMaterial material, ArmorItem.Type type, Item.Properties properties) {
        return new IceShardArmorItem(material, type, properties);
    }
}
