package net.celsiusqc.cp_tweaks.compat.geckolib;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

/**
 * Isolates all GeckoLib class references. Only call these methods after
 * checking {@code ModList.get().isLoaded("geckolib")} — the classes referenced
 * here are not loaded until a method on this class is invoked.
 */
public final class GeckoLibCompat {

    private GeckoLibCompat() {
    }

    public static ArmorItem createIceShardArmor(Holder<ArmorMaterial> material, ArmorItem.Type type, Item.Properties properties) {
        return new IceShardArmorItem(material, type, properties);
    }
}
